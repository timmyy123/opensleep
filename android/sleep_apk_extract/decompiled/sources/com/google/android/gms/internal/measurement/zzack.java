package com.google.android.gms.internal.measurement;

import java.util.Objects;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzack extends zzacl {
    final /* synthetic */ zzacr zza;
    private int zzb;
    private final int zzc;

    public zzack(zzacr zzacrVar) {
        Objects.requireNonNull(zzacrVar);
        this.zza = zzacrVar;
        this.zzb = 0;
        this.zzc = zzacrVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzacn
    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zza(i);
        }
        Types$$ExternalSyntheticBUOutline0.m();
        return (byte) 0;
    }
}
