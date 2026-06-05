package androidx.core.net;

import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConnectivityManagerCompat {
    @Deprecated
    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
