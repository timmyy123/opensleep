package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zznh extends zzqm implements zzrr {
    private static final zznh zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private int zzh;
    private zzte zzi;
    private zzte zzj;
    private int zzk;

    static {
        zznh zznhVar = new zznh();
        zzb = zznhVar;
        zzqm.zzz(zznh.class, zznhVar);
    }

    private zznh() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005᠌\u0004\u00067\u0000\u0007<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zznd.zza, "zzh", zzne.zza, "zzi", "zzj", "zzk", zzng.zza, zzqa.class});
        }
        if (i2 == 3) {
            return new zznh();
        }
        zzno zznoVar = null;
        if (i2 == 4) {
            return new zznf(zznoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
