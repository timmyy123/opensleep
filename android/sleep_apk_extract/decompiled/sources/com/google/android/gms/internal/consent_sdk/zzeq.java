package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeq extends zzqm implements zzrr {
    private static final zzeq zzb;

    static {
        zzeq zzeqVar = new zzeq();
        zzb = zzeqVar;
        zzqm.zzz(zzeq.class, zzeqVar);
    }

    private zzeq() {
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
            return new zzeq();
        }
        if (i2 == 4) {
            return new zzep(zzezVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
