package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzmo extends zzqm implements zzrr {
    private static final zzmo zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private zzte zzg;
    private zzte zzh;
    private int zzi;

    static {
        zzmo zzmoVar = new zzmo();
        zzb = zzmoVar;
        zzqm.zzz(zzmo.class, zzmoVar);
    }

    private zzmo() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003᠌\u0002\u00047\u0000\u0005<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", "zzh", "zzi", zzmn.zza, zzqa.class});
        }
        if (i2 == 3) {
            return new zzmo();
        }
        zzmw zzmwVar = null;
        if (i2 == 4) {
            return new zzmm(zzmwVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
