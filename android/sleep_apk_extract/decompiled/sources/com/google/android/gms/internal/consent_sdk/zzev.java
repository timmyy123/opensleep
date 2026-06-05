package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzev extends zzqm implements zzrr {
    private static final zzev zzb;

    static {
        zzev zzevVar = new zzev();
        zzb = zzevVar;
        zzqm.zzz(zzev.class, zzevVar);
    }

    private zzev() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzez zzezVar = null;
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0000", null);
        }
        if (i2 == 3) {
            return new zzev();
        }
        if (i2 == 4) {
            return new zzeu(zzezVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
