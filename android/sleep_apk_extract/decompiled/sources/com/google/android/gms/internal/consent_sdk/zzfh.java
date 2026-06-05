package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfh extends zzqm implements zzrr {
    private static final zzfh zzb;
    private int zzd;
    private zzff zze;
    private zzlj zzf;
    private int zzg;

    static {
        zzfh zzfhVar = new zzfh();
        zzb = zzfhVar;
        zzqm.zzz(zzfh.class, zzfhVar);
    }

    private zzfh() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0003᠌\u0002\u0004ဉ\u0001", new Object[]{"zzd", "zze", "zzg", zzig.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzfh();
        }
        zzfg zzfgVar = null;
        if (i2 == 4) {
            return new zzfb(zzfgVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
