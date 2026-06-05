package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzift implements zzigh {
    private final zzifp zza;
    private final zzigt zzb;
    private final boolean zzc = false;
    private final zzidp zzd;

    private zzift(zzigt zzigtVar, zzidp zzidpVar, zzifp zzifpVar) {
        this.zzb = zzigtVar;
        this.zzd = zzidpVar;
        this.zza = zzifpVar;
    }

    public static zzift zzh(zzigt zzigtVar, zzidp zzidpVar, zzifp zzifpVar) {
        return new zzift(zzigtVar, zzidpVar, zzifpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final Object zza() {
        zzifp zzifpVar = this.zza;
        return zzifpVar instanceof zziee ? ((zziee) zzifpVar).zzbg() : zzifpVar.zzcY().zzbt();
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final boolean zzb(Object obj, Object obj2) {
        if (!((zziee) obj).zzt.equals(((zziee) obj2).zzt)) {
            return false;
        }
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final int zzc(Object obj) {
        int iHashCode = ((zziee) obj).zzt.hashCode();
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final void zzd(Object obj, Object obj2) {
        zzigi.zzI(this.zzb, obj, obj2);
        if (this.zzc) {
            zzigi.zzH(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final int zze(Object obj) {
        int iZzh = ((zziee) obj).zzt.zzh();
        if (this.zzc) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return iZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final void zzf(Object obj, zzihi zzihiVar) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final void zzg(Object obj, zzigc zzigcVar, zzido zzidoVar) {
        this.zzb.zzh(obj);
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzico zzicoVar) {
        zziee zzieeVar = (zziee) obj;
        if (zzieeVar.zzt == zzigu.zza()) {
            zzieeVar.zzt = zzigu.zzb();
        }
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final void zzk(Object obj) {
        this.zzb.zzj(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final boolean zzl(Object obj) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }
}
