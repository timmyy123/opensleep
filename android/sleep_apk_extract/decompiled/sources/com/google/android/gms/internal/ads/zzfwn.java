package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfwn implements Runnable {
    final /* synthetic */ zzfws zza;

    public zzfwn(zzfws zzfwsVar) {
        Objects.requireNonNull(zzfwsVar);
        this.zza = zzfwsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzh().zzc();
    }
}
