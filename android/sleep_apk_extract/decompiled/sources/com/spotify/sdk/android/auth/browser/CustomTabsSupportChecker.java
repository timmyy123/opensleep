package com.spotify.sdk.android.auth.browser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CustomTabsSupportChecker {
    private static final String TAG = "CustomTabsSupportChecker";

    private static String getPackageNameSupportingCustomTabs(PackageManager packageManager, Uri uri) {
        Intent intentAddCategory = new Intent("android.intent.action.VIEW", uri).addCategory("android.intent.category.BROWSABLE");
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intentAddCategory, 0);
        String str = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
        Log.d(TAG, "Found default package name for handling VIEW intents: " + str);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intentAddCategory, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent = new Intent();
            intent.setAction("android.support.customtabs.action.CustomTabsService");
            intent.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent, 0) != null) {
                Log.d(TAG, "Adding " + resolveInfo.activityInfo.packageName + " to supported packages");
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.size() == 1) {
            return (String) arrayList.get(0);
        }
        if (arrayList.size() > 1) {
            return (TextUtils.isEmpty(str) || !arrayList.contains(str)) ? (String) arrayList.get(0) : str;
        }
        return null;
    }

    public static String getPackageSupportingCustomTabs(Context context, AuthorizationRequest authorizationRequest) {
        String redirectUri = authorizationRequest.getRedirectUri();
        String packageNameSupportingCustomTabs = getPackageNameSupportingCustomTabs(context.getPackageManager(), authorizationRequest.toUri());
        return (redirectUri.startsWith("http") || redirectUri.startsWith(TournamentShareDialogURIBuilder.scheme) || !hasBrowserSupportForCustomTabs(packageNameSupportingCustomTabs) || !hasRedirectUriActivity(context.getPackageManager(), redirectUri)) ? "" : packageNameSupportingCustomTabs;
    }

    private static boolean hasBrowserSupportForCustomTabs(String str) {
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        Log.d(TAG, "No package supporting CustomTabs found.");
        return false;
    }

    private static boolean hasRedirectUriActivity(PackageManager packageManager, String str) {
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 64).iterator();
        while (it.hasNext()) {
            if (RedirectUriReceiverActivity.class.getName().equals(it.next().activityInfo.name)) {
                return true;
            }
        }
        return false;
    }
}
