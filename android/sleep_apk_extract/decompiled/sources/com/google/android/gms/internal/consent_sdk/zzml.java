package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzml extends zzqm implements zzrr {
    private static final zzml zzb;
    private int zzd;
    private int zze;
    private boolean zzf;

    static {
        zzml zzmlVar = new zzml();
        zzb = zzmlVar;
        zzqm.zzz(zzml.class, zzmlVar);
    }

    private zzml() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", zzmj.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzml();
        }
        zzmw zzmwVar = null;
        if (i2 == 4) {
            return new zzmk(zzmwVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
