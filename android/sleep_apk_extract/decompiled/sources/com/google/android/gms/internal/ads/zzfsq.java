package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfsq extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzfss zza;

    public zzfsq(zzfss zzfssVar) {
        Objects.requireNonNull(zzfssVar);
        this.zza = zzfssVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.zza.zzk(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.zza.zzk(false);
    }
}
