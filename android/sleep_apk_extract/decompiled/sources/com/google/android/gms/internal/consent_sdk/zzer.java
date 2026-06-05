package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzer extends zzqm implements zzrr {
    private static final zzer zzb;
    private int zzd;
    private zzeq zze;
    private zzhl zzf;

    static {
        zzer zzerVar = new zzer();
        zzb = zzerVar;
        zzqm.zzz(zzer.class, zzerVar);
    }

    private zzer() {
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
            return new zzer();
        }
        zzez zzezVar = null;
        if (i2 == 4) {
            return new zzeo(zzezVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
