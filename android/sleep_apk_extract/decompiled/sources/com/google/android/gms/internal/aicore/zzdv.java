package com.google.android.gms.internal.aicore;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzdv extends zzdw {
    final /* synthetic */ zzeb zza;
    private int zzb = 0;
    private final int zzc;

    public zzdv(zzeb zzebVar) {
        this.zza = zzebVar;
        this.zzc = zzebVar.zzc();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.aicore.zzdy
    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        Types$$ExternalSyntheticBUOutline0.m();
        return (byte) 0;
    }
}
