package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzamn implements zzahb {
    final /* synthetic */ zzamo zza;

    public /* synthetic */ zzamn(zzamo zzamoVar, byte[] bArr) {
        Objects.requireNonNull(zzamoVar);
        this.zza = zzamoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        zzamo zzamoVar = this.zza;
        return zzamoVar.zzf().zzh(zzamoVar.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        zzamo zzamoVar = this.zza;
        long jZzd = zzamoVar.zzd() + BigInteger.valueOf(zzamoVar.zzf().zzi(j)).multiply(BigInteger.valueOf(zzamoVar.zze() - zzamoVar.zzd())).divide(BigInteger.valueOf(zzamoVar.zzg())).longValue();
        String str = zzfl.zza;
        zzahc zzahcVar = new zzahc(j, Math.max(zzamoVar.zzd(), Math.min(jZzd - 30000, zzamoVar.zze() - 1)));
        return new zzagz(zzahcVar, zzahcVar);
    }
}
