package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhp extends zzqm implements zzrr {
    private static final zzhp zzb;

    static {
        zzhp zzhpVar = new zzhp();
        zzb = zzhpVar;
        zzqm.zzz(zzhp.class, zzhpVar);
    }

    private zzhp() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzib zzibVar = null;
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0000", null);
        }
        if (i2 == 3) {
            return new zzhp();
        }
        if (i2 == 4) {
            return new zzho(zzibVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
