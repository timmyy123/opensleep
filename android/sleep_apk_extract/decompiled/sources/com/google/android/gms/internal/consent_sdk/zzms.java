package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzms extends zzqm implements zzrr {
    private static final zzms zzb;
    private int zzd;
    private int zze;

    static {
        zzms zzmsVar = new zzms();
        zzb = zzmsVar;
        zzqm.zzz(zzms.class, zzmsVar);
    }

    private zzms() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzmq.zza});
        }
        if (i2 == 3) {
            return new zzms();
        }
        zzmw zzmwVar = null;
        if (i2 == 4) {
            return new zzmr(zzmwVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
