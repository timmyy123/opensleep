package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjm extends zzqm implements zzrr {
    private static final zzjm zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        zzjm zzjmVar = new zzjm();
        zzb = zzjmVar;
        zzqm.zzz(zzjm.class, zzjmVar);
    }

    private zzjm() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0007᠌\u0005", new Object[]{"zzd", "zze", zzjk.zza, "zzf", "zzg", "zzh", zzjl.zza, "zzi", zzjj.zza, "zzj", zzji.zza});
        }
        if (i2 == 3) {
            return new zzjm();
        }
        zzjn zzjnVar = null;
        if (i2 == 4) {
            return new zzjh(zzjnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
