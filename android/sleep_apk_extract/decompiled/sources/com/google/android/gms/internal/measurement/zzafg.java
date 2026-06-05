package com.google.android.gms.internal.measurement;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzafg implements zzafp {
    private final zzafc zza;
    private final zzafz zzb;
    private final boolean zzc = false;
    private final zzadg zzd;

    private zzafg(zzafz zzafzVar, zzadg zzadgVar, zzafc zzafcVar) {
        this.zzb = zzafzVar;
        this.zzd = zzadgVar;
        this.zza = zzafcVar;
    }

    public static zzafg zzh(zzafz zzafzVar, zzadg zzadgVar, zzafc zzafcVar) {
        return new zzafg(zzafzVar, zzadgVar, zzafcVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final Object zza() {
        zzafc zzafcVar = this.zza;
        return zzafcVar instanceof zzadu ? ((zzadu) zzafcVar).zzck() : zzafcVar.zzcI().zzbg();
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final boolean zzb(Object obj, Object obj2) {
        if (!((zzadu) obj).zzc.equals(((zzadu) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final int zzc(Object obj) {
        int iHashCode = ((zzadu) obj).zzc.hashCode();
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzd(Object obj, Object obj2) {
        zzafq.zzE(this.zzb, obj, obj2);
        if (this.zzc) {
            zzafq.zzD(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final int zze(Object obj) {
        int iZzh = ((zzadu) obj).zzc.zzh();
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return iZzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzf(Object obj, zzago zzagoVar) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzg(Object obj, zzafo zzafoVar, zzadf zzadfVar) {
        this.zzb.zzh(obj);
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzacg zzacgVar) {
        zzadu zzaduVar = (zzadu) obj;
        if (zzaduVar.zzc == zzaga.zza()) {
            zzaduVar.zzc = zzaga.zzb();
        }
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzk(Object obj) {
        this.zzb.zzj(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final boolean zzl(Object obj) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }
}
