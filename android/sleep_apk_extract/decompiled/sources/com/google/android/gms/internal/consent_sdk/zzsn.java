package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzsn extends zzqm implements zzrr {
    private static final zzsn zzb;
    private long zzd;
    private int zze;

    static {
        zzsn zzsnVar = new zzsn();
        zzb = zzsnVar;
        zzqm.zzz(zzsn.class, zzsnVar);
    }

    private zzsn() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzrz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzsn();
        }
        zzsm zzsmVar = null;
        if (i2 == 4) {
            return new zzsl(zzsmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
