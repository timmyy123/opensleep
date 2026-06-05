package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgpp extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzgpr zza;

    public zzgpp(zzgpr zzgprVar) {
        Objects.requireNonNull(zzgprVar);
        this.zza = zzgprVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        zzgpr zzgprVar = this.zza;
        synchronized (zzgprVar) {
            zzgprVar.zzf(networkCapabilities);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        zzgpr zzgprVar = this.zza;
        synchronized (zzgprVar) {
            zzgprVar.zzf(null);
        }
    }
}
