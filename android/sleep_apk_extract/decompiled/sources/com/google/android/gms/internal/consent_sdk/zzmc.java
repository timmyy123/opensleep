package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzmc extends zzqm implements zzrr {
    private static final zzmc zzb;
    private int zzd;
    private boolean zze;

    static {
        zzmc zzmcVar = new zzmc();
        zzb = zzmcVar;
        zzqm.zzz(zzmc.class, zzmcVar);
    }

    private zzmc() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzmc();
        }
        zzmd zzmdVar = null;
        if (i2 == 4) {
            return new zzmb(zzmdVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
