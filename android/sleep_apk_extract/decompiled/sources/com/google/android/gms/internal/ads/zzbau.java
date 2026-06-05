package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbau extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzbav zza;

    public zzbau(zzbav zzbavVar) {
        Objects.requireNonNull(zzbavVar);
        this.zza = zzbavVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzbav.class) {
            this.zza.zzd(networkCapabilities);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        synchronized (zzbav.class) {
            this.zza.zzd(null);
        }
    }
}
