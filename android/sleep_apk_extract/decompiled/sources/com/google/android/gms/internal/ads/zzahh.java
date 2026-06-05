package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzahh extends zzagn {
    final /* synthetic */ zzahb zza;
    final /* synthetic */ zzahi zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzahh(zzahi zzahiVar, zzahb zzahbVar, zzahb zzahbVar2) {
        super(zzahbVar);
        this.zza = zzahbVar2;
        Objects.requireNonNull(zzahiVar);
        this.zzb = zzahiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagn, com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        zzagz zzagzVarZzc = this.zza.zzc(j);
        zzahc zzahcVar = zzagzVarZzc.zza;
        long j2 = zzahcVar.zzb;
        zzahi zzahiVar = this.zzb;
        zzahc zzahcVar2 = new zzahc(j2, zzahiVar.zza() + zzahcVar.zzc);
        zzahc zzahcVar3 = zzagzVarZzc.zzb;
        return new zzagz(zzahcVar2, new zzahc(zzahcVar3.zzb, zzahiVar.zza() + zzahcVar3.zzc));
    }
}
