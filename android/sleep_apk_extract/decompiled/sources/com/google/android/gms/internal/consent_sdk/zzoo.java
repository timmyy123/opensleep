package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzoo extends zzqm implements zzrr {
    private static final zzoo zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzqq zzg = zzqm.zzs();

    static {
        zzoo zzooVar = new zzoo();
        zzb = zzooVar;
        zzqm.zzz(zzoo.class, zzooVar);
    }

    private zzoo() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzqp zzqpVar = zzom.zza;
            return zzqm.zzw(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002ࠬ\u0003᠌\u0001", new Object[]{"zzd", "zze", "zzg", zzqpVar, "zzf", zzqpVar});
        }
        if (i2 == 3) {
            return new zzoo();
        }
        zzon zzonVar = null;
        if (i2 == 4) {
            return new zzol(zzonVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
