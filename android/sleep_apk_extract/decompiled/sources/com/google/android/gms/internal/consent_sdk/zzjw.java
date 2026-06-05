package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjw extends zzqm implements zzrr {
    private static final zzjw zzb;

    static {
        zzjw zzjwVar = new zzjw();
        zzb = zzjwVar;
        zzqm.zzz(zzjw.class, zzjwVar);
    }

    private zzjw() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzkb zzkbVar = null;
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0000", null);
        }
        if (i2 == 3) {
            return new zzjw();
        }
        if (i2 == 4) {
            return new zzjv(zzkbVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
