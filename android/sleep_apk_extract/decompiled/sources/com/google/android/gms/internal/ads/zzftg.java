package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzftg extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzfth zza;

    public zzftg(zzfth zzfthVar) {
        Objects.requireNonNull(zzfthVar);
        this.zza = zzfthVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.zza.zzi(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.zza.zzi(false);
    }
}
