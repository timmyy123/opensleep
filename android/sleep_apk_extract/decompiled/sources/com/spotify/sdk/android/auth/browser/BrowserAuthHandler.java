package com.spotify.sdk.android.auth.browser;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.spotify.sdk.android.auth.AuthorizationHandler;
import com.spotify.sdk.android.auth.AuthorizationRequest;

/* JADX INFO: loaded from: classes4.dex */
public class BrowserAuthHandler implements AuthorizationHandler {
    private static final String TAG = "BrowserAuthHandler";
    private Context mContext;
    private boolean mIsAuthInProgress = false;
    private CustomTabsServiceConnection mTabConnection;
    private CustomTabsSession mTabsSession;
    private Uri mUri;

    private boolean internetPermissionNotGranted(Context context) {
        return context.getPackageManager().checkPermission("android.permission.INTERNET", context.getPackageName()) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchAuthInBrowserFallback() {
        if (internetPermissionNotGranted(this.mContext)) {
            Log.e(TAG, "Missing INTERNET permission");
        }
        this.mContext.startActivity(new Intent("android.intent.action.VIEW", this.mUri));
        this.mIsAuthInProgress = true;
    }

    @Override // com.spotify.sdk.android.auth.AuthorizationHandler
    public boolean isAuthInProgress() {
        return this.mIsAuthInProgress;
    }

    @Override // com.spotify.sdk.android.auth.AuthorizationHandler
    public void setOnCompleteListener(AuthorizationHandler.OnCompleteListener onCompleteListener) {
    }

    @Override // com.spotify.sdk.android.auth.AuthorizationHandler
    public boolean start(Activity activity, final AuthorizationRequest authorizationRequest) {
        String str = TAG;
        Log.d(str, "start");
        this.mContext = activity;
        this.mUri = authorizationRequest.toUri();
        String packageSupportingCustomTabs = CustomTabsSupportChecker.getPackageSupportingCustomTabs(this.mContext, authorizationRequest);
        boolean zIsEmpty = TextUtils.isEmpty(packageSupportingCustomTabs);
        if (internetPermissionNotGranted(this.mContext)) {
            Log.e(str, "Missing INTERNET permission");
        }
        if (zIsEmpty) {
            Log.d(str, "Launching auth inside a web browser");
            launchAuthInBrowserFallback();
            return true;
        }
        Log.d(str, "Launching auth in a Custom Tab using package:" + packageSupportingCustomTabs);
        CustomTabsServiceConnection customTabsServiceConnection = new CustomTabsServiceConnection() { // from class: com.spotify.sdk.android.auth.browser.BrowserAuthHandler.1
            @Override // androidx.browser.customtabs.CustomTabsServiceConnection
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                customTabsClient.warmup(0L);
                BrowserAuthHandler.this.mTabsSession = customTabsClient.newSession(new CustomTabsCallback());
                if (BrowserAuthHandler.this.mTabsSession != null) {
                    new CustomTabsIntent.Builder().setSession(BrowserAuthHandler.this.mTabsSession).build().launchUrl(BrowserAuthHandler.this.mContext, authorizationRequest.toUri());
                    BrowserAuthHandler.this.mIsAuthInProgress = true;
                } else {
                    BrowserAuthHandler.this.unbindCustomTabsService();
                    Log.i(BrowserAuthHandler.TAG, "Auth using CustomTabs aborted, reason: CustomTabsSession is null.");
                    BrowserAuthHandler.this.launchAuthInBrowserFallback();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(BrowserAuthHandler.TAG, "Auth using CustomTabs aborted, reason: CustomTabsService disconnected.");
                BrowserAuthHandler.this.mTabsSession = null;
                BrowserAuthHandler.this.mTabConnection = null;
            }
        };
        this.mTabConnection = customTabsServiceConnection;
        CustomTabsClient.bindCustomTabsService(this.mContext, packageSupportingCustomTabs, customTabsServiceConnection);
        return true;
    }

    @Override // com.spotify.sdk.android.auth.AuthorizationHandler
    public void stop() {
        Log.d(TAG, "stop");
        unbindCustomTabsService();
        this.mContext = null;
        this.mIsAuthInProgress = false;
    }

    public void unbindCustomTabsService() {
        CustomTabsServiceConnection customTabsServiceConnection = this.mTabConnection;
        if (customTabsServiceConnection == null) {
            return;
        }
        this.mContext.unbindService(customTabsServiceConnection);
        this.mTabsSession = null;
        this.mTabConnection = null;
    }
}
