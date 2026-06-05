package com.urbandroid.common.connectivity;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.urbandroid.common.util.Environment;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class WaitForConnectivityService extends Service {
    public static boolean isRequiredNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected() || activeNetworkInfo.isRoaming()) {
            return false;
        }
        if (activeNetworkInfo.getType() == 1 || Environment.isIcsOrGreater()) {
            return true;
        }
        return connectivityManager.getBackgroundDataSetting();
    }
}
