package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzlu extends zzqm implements zzrr {
    private static final zzlu zzb;
    private int zzd;
    private zzlt zze;
    private zzhl zzf;

    static {
        zzlu zzluVar = new zzlu();
        zzb = zzluVar;
        zzqm.zzz(zzlu.class, zzluVar);
    }

    private zzlu() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzlu();
        }
        zzly zzlyVar = null;
        if (i2 == 4) {
            return new zzlr(zzlyVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
