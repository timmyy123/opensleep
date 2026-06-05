package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzoh extends zzqm implements zzrr {
    private static final zzoh zzb;
    private int zzd;
    private zzod zze;
    private zznx zzf;
    private zzof zzg;

    static {
        zzoh zzohVar = new zzoh();
        zzb = zzohVar;
        zzqm.zzz(zzoh.class, zzohVar);
    }

    private zzoh() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzoh();
        }
        zzog zzogVar = null;
        if (i2 == 4) {
            return new zznv(zzogVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
