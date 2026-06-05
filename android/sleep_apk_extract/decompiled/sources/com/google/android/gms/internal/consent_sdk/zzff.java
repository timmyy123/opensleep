package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzff extends zzqm implements zzrr {
    private static final zzff zzb;
    private int zzd;
    private zzfe zze;

    static {
        zzff zzffVar = new zzff();
        zzb = zzffVar;
        zzqm.zzz(zzff.class, zzffVar);
    }

    private zzff() {
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
            return new zzff();
        }
        zzfg zzfgVar = null;
        if (i2 == 4) {
            return new zzfc(zzfgVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
