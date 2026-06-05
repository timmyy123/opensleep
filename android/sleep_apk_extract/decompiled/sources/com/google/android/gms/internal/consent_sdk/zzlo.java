package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzlo extends zzqm implements zzrr {
    private static final zzlo zzb;
    private int zzd;
    private zzlm zze;

    static {
        zzlo zzloVar = new zzlo();
        zzb = zzloVar;
        zzqm.zzz(zzlo.class, zzloVar);
    }

    private zzlo() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzlo();
        }
        zzln zzlnVar = null;
        if (i2 == 4) {
            return new zzlk(zzlnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
