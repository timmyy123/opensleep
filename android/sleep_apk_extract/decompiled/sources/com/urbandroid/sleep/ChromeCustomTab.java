package com.urbandroid.sleep;

import android.app.Activity;
import android.content.ComponentName;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.util.ColorUtil;

/* JADX INFO: loaded from: classes4.dex */
public class ChromeCustomTab {
    private Activity activity;
    private CustomTabsClient client;
    private CustomTabsServiceConnection connection;
    private CustomTabsSession customTabsSession;
    private String url;
    private boolean warmupWhenReady = false;
    private boolean mayLaunchWhenReady = false;

    public ChromeCustomTab(Activity activity) {
        this.activity = activity;
        bindCustomTabsService();
    }

    private void bindCustomTabsService() {
        if (this.client != null) {
            return;
        }
        CustomTabsServiceConnection customTabsServiceConnection = new CustomTabsServiceConnection() { // from class: com.urbandroid.sleep.ChromeCustomTab.1
            @Override // androidx.browser.customtabs.CustomTabsServiceConnection
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                ChromeCustomTab.this.client = customTabsClient;
                if (ChromeCustomTab.this.warmupWhenReady) {
                    ChromeCustomTab.this.warmup();
                }
                if (ChromeCustomTab.this.mayLaunchWhenReady) {
                    ChromeCustomTab.this.mayLaunch();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                ChromeCustomTab.this.client = null;
            }
        };
        this.connection = customTabsServiceConnection;
        if (CustomTabsClient.bindCustomTabsService(this.activity, "com.android.chrome", customTabsServiceConnection)) {
            return;
        }
        this.connection = null;
    }

    private CustomTabsSession getSession() {
        CustomTabsClient customTabsClient = this.client;
        if (customTabsClient == null) {
            this.customTabsSession = null;
        } else if (this.customTabsSession == null) {
            this.customTabsSession = customTabsClient.newSession(new CustomTabsCallback() { // from class: com.urbandroid.sleep.ChromeCustomTab.2
                @Override // androidx.browser.customtabs.CustomTabsCallback
                public void onNavigationEvent(int i, Bundle bundle) {
                    Logger.logWarning("CustomTabs: onNavigationEvent: Code = " + i);
                }
            });
        }
        return this.customTabsSession;
    }

    public void mayLaunch() {
        CustomTabsSession session = getSession();
        if (this.client == null || session == null) {
            this.mayLaunchWhenReady = true;
        } else {
            this.mayLaunchWhenReady = false;
            session.mayLaunchUrl(Uri.parse(this.url), null, null);
        }
    }

    public void show(Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = 24;
        options.outHeight = 24;
        int i = this.activity.getResources().getConfiguration().uiMode & 48;
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(getSession());
        builder.setToolbarColor(ColorUtil.i(this.activity, R.color.bar)).setShowTitle(true);
        builder.setSecondaryToolbarColor(ColorUtil.i(this.activity, R.color.bar_dark));
        builder.setStartAnimations(this.activity, R.anim.slide_in_right, R.anim.slide_in_left);
        builder.setExitAnimations(this.activity, R.anim.slide_out_left, R.anim.slide_out_right);
        builder.setColorScheme(i == 32 ? 2 : 1);
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("Chrome: color "), i == 32 ? 2 : 1);
        builder.setCloseButtonIcon(BitmapFactory.decodeResource(this.activity.getResources(), R.drawable.ic_arrow_back, options));
        builder.build().launchUrl(this.activity, uri);
    }

    public void unbindCustomTabsService() {
        CustomTabsServiceConnection customTabsServiceConnection = this.connection;
        if (customTabsServiceConnection == null) {
            return;
        }
        this.activity.unbindService(customTabsServiceConnection);
        this.client = null;
        this.customTabsSession = null;
    }

    public void warmup() {
        CustomTabsClient customTabsClient = this.client;
        if (customTabsClient == null) {
            this.warmupWhenReady = true;
        } else {
            this.warmupWhenReady = false;
            customTabsClient.warmup(0L);
        }
    }

    public void show(String str) {
        show(Uri.parse(str));
    }
}
