package com.google.android.gms.internal.aicore;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdm extends zzex implements zzgb {
    private static final zzdm zzh;
    private int zzb;
    private long zzd;
    private zzfg zze = zzex.zzs();
    private zzeh zzf;
    private float zzg;

    static {
        zzdm zzdmVar = new zzdm();
        zzh = zzdmVar;
        zzex.zzp(zzdm.class, zzdmVar);
    }

    private zzdm() {
    }

    public static zzdm zzf(byte[] bArr, zzek zzekVar) {
        return (zzdm) zzex.zzt(zzh, bArr, zzekVar);
    }

    public static zzdm zzg() {
        return zzh;
    }

    public final long zza() {
        return this.zzd;
    }

    public final List zzb() {
        return this.zze;
    }

    public final zzeh zzc() {
        zzeh zzehVar = this.zzf;
        return zzehVar == null ? zzeh.zzb() : zzehVar;
    }

    @Override // com.google.android.gms.internal.aicore.zzex
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzex.zzq(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဃ\u0000\u0002\u001b\u0003ဉ\u0001\u0004ခ\u0002", new Object[]{"zzb", "zzd", "zze", zzdk.class, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzdm();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzdl(bArr);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }

    public final float zze() {
        return this.zzg;
    }
}
