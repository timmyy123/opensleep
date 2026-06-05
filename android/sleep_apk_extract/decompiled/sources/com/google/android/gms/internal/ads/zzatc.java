package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzatc implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzate zzc;

    public zzatc(zzate zzateVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        Objects.requireNonNull(zzateVar);
        this.zzc = zzateVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzate zzateVar = this.zzc;
        zzateVar.zzx().zza(this.zza, this.zzb);
        zzateVar.zzx().zzb(zzateVar.toString());
    }
}
