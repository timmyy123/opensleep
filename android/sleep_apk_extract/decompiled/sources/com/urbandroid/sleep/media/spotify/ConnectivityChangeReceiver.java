package com.urbandroid.sleep.media.spotify;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.urbandroid.common.LoggingReceiver;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConnectivityChangeReceiver extends LoggingReceiver {
    public static boolean isConnected(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
