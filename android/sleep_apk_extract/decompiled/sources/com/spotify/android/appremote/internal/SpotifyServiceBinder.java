package com.spotify.android.appremote.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
abstract class SpotifyServiceBinder {
    private static Boolean bindLegacyService(Context context, String str, ServiceConnection serviceConnection) {
        Intent intent = new Intent("com.spotify.mobile.appprotocol.action.START_APP_PROTOCOL_SERVICE").setPackage(str);
        startServiceForBuildVersion(context, intent);
        return bindToService(intent, context, serviceConnection);
    }

    public static Boolean bindService(Context context, ServiceConnection serviceConnection, String str) {
        try {
            if (bindToService(new Intent("com.spotify.mobile.appprotocol.action.BIND_PROTOCOL_SERVICE").setPackage(str), context, serviceConnection).booleanValue()) {
                return Boolean.TRUE;
            }
        } catch (Exception unused) {
        }
        return bindLegacyService(context, str, serviceConnection);
    }

    private static Boolean bindToService(Intent intent, Context context, ServiceConnection serviceConnection) {
        return Boolean.valueOf(context.getApplicationContext().bindService(intent, serviceConnection, 65));
    }

    private static void startServiceForBuildVersion(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.getApplicationContext().startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
