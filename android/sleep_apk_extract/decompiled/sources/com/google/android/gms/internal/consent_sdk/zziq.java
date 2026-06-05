package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zziq extends zzqm implements zzrr {
    private static final zziq zzb;
    private int zzd;
    private int zze;
    private zzik zzf;
    private zzip zzg;

    static {
        zziq zziqVar = new zziq();
        zzb = zziqVar;
        zzqm.zzz(zziq.class, zziqVar);
    }

    private zziq() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzil.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zziq();
        }
        zziv zzivVar = null;
        if (i2 == 4) {
            return new zzii(zzivVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
