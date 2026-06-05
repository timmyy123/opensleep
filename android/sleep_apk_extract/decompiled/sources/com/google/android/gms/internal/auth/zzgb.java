package com.google.android.gms.internal.auth;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzgb implements zzgi {
    private final zzfx zza;
    private final zzgz zzb;
    private final zzem zzc;

    private zzgb(zzgz zzgzVar, zzem zzemVar, zzfx zzfxVar) {
        this.zzb = zzgzVar;
        this.zzc = zzemVar;
        this.zza = zzfxVar;
    }

    public static zzgb zzb(zzgz zzgzVar, zzem zzemVar, zzfx zzfxVar) {
        return new zzgb(zzgzVar, zzemVar, zzfxVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object obj) {
        return this.zzb.zzb(obj).hashCode();
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        zzfx zzfxVar = this.zza;
        return zzfxVar instanceof zzev ? ((zzev) zzfxVar).zzc() : ((zzet) ((zzev) zzfxVar).zzn(5, null, null)).zzd();
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zze(Object obj) {
        this.zzb.zze(obj);
        this.zzc.zzb(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object obj, Object obj2) {
        zzgk.zzd(this.zzb, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzdt zzdtVar) {
        zzev zzevVar = (zzev) obj;
        if (zzevVar.zzc == zzha.zza()) {
            zzevVar.zzc = zzha.zzd();
        }
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzh(Object obj, Object obj2) {
        return this.zzb.zzb(obj).equals(this.zzb.zzb(obj2));
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzi(Object obj) {
        this.zzc.zza(obj);
        throw null;
    }
}
