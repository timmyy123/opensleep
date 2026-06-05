package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzahr implements zzahb {
    final /* synthetic */ zzaht zza;
    private final long zzb;

    public zzahr(zzaht zzahtVar, long j) {
        Objects.requireNonNull(zzahtVar);
        this.zza = zzahtVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        zzaht zzahtVar = this.zza;
        zzagz zzagzVarZzg = zzahtVar.zzh()[0].zzg(j);
        for (int i = 1; i < zzahtVar.zzh().length; i++) {
            zzagz zzagzVarZzg2 = zzahtVar.zzh()[i].zzg(j);
            if (zzagzVarZzg2.zza.zzc < zzagzVarZzg.zza.zzc) {
                zzagzVarZzg = zzagzVarZzg2;
            }
        }
        return zzagzVarZzg;
    }
}
