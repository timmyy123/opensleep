package com.google.android.gms.internal.serialization;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzwk extends zzwl {
    final /* synthetic */ zzwr zza;
    private int zzb = 0;
    private final int zzc;

    public zzwk(zzwr zzwrVar) {
        this.zza = zzwrVar;
        this.zzc = zzwrVar.zzc();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.serialization.zzwn
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
