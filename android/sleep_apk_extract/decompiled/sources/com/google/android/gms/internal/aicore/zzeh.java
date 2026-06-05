package com.google.android.gms.internal.aicore;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeh extends zzex implements zzgb {
    private static final zzeh zze;
    private long zzb;
    private int zzd;

    static {
        zzeh zzehVar = new zzeh();
        zze = zzehVar;
        zzex.zzp(zzeh.class, zzehVar);
    }

    private zzeh() {
    }

    public static zzeh zzb() {
        return zze;
    }

    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.aicore.zzex
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzgj(zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzb", "zzd"});
        }
        if (i2 == 3) {
            return new zzeh();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzeg(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
