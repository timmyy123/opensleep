package com.google.android.gms.internal.aicore;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdk extends zzex implements zzgb {
    private static final zzdk zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        zzdk zzdkVar = new zzdk();
        zzf = zzdkVar;
        zzex.zzp(zzdk.class, zzdkVar);
    }

    private zzdk() {
    }

    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.aicore.zzex
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzex.zzq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzdk();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzdj(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
