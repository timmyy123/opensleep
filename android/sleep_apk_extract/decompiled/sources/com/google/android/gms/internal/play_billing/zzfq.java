package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfq extends zzhk implements zzin {
    private static final zzfq zzb;
    private int zzd;
    private String zze = "";

    static {
        zzfq zzfqVar = new zzfq();
        zzb = zzfqVar;
        zzhk.zzx(zzfq.class, zzfqVar);
    }

    private zzfq() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzfq();
        }
        zzfr zzfrVar = null;
        if (i2 == 4) {
            return new zzfp(zzfrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
