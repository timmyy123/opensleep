package com.google.android.gms.internal.consent_sdk;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzru implements zzsa {
    private final zzrq zza;
    private final zzsp zzb;
    private final boolean zzc = false;
    private final zzqb zzd;

    private zzru(zzsp zzspVar, zzqb zzqbVar, zzrq zzrqVar) {
        this.zzb = zzspVar;
        this.zzd = zzqbVar;
        this.zza = zzrqVar;
    }

    public static zzru zzi(zzsp zzspVar, zzqb zzqbVar, zzrq zzrqVar) {
        return new zzru(zzspVar, zzqbVar, zzrqVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final int zza(Object obj) {
        int iZzb = ((zzqm) obj).zzc.zzb();
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return iZzb;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final int zzb(Object obj) {
        int iHashCode = ((zzqm) obj).zzc.hashCode();
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final Object zzc() {
        zzrq zzrqVar = this.zza;
        return zzrqVar instanceof zzqm ? ((zzqm) zzrqVar).zzr() : zzrqVar.zzu().zzk();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final void zzd(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final void zze(Object obj, Object obj2) {
        zzsc.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            zzsc.zzo(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final void zzf(Object obj, zztb zztbVar) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final boolean zzg(Object obj, Object obj2) {
        if (!((zzqm) obj).zzc.equals(((zzqm) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final boolean zzh(Object obj) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }
}
