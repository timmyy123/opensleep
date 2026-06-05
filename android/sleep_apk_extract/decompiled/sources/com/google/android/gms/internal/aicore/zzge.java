package com.google.android.gms.internal.aicore;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzge implements zzgk {
    private final zzga zza;
    private final zzgv zzb;
    private final boolean zzc = false;
    private final zzel zzd;

    private zzge(zzgv zzgvVar, zzel zzelVar, zzga zzgaVar) {
        this.zzb = zzgvVar;
        this.zzd = zzelVar;
        this.zza = zzgaVar;
    }

    public static zzge zze(zzgv zzgvVar, zzel zzelVar, zzga zzgaVar) {
        return new zzge(zzgvVar, zzelVar, zzgaVar);
    }

    @Override // com.google.android.gms.internal.aicore.zzgk
    public final Object zza() {
        zzga zzgaVar = this.zza;
        return zzgaVar instanceof zzex ? ((zzex) zzgaVar).zzk() : zzgaVar.zzu().zze();
    }

    @Override // com.google.android.gms.internal.aicore.zzgk
    public final boolean zzb(Object obj, Object obj2) {
        if (!((zzex) obj).zzc.equals(((zzex) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.aicore.zzgk
    public final int zzc(Object obj) {
        int iHashCode = ((zzex) obj).zzc.hashCode();
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.aicore.zzgk
    public final void zzd(Object obj, Object obj2) {
        zzgm.zzd(this.zzb, obj, obj2);
        if (this.zzc) {
            zzgm.zzc(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.aicore.zzgk
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzdr zzdrVar) {
        zzex zzexVar = (zzex) obj;
        if (zzexVar.zzc == zzgw.zza()) {
            zzexVar.zzc = zzgw.zzb();
        }
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.android.gms.internal.aicore.zzgk
    public final void zzh(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.aicore.zzgk
    public final boolean zzi(Object obj) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }
}
