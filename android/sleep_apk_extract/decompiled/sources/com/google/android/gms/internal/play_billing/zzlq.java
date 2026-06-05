package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes3.dex */
public final class zzlq extends zzhk implements zzin {
    private static final zzlq zzb;
    private int zzd;
    private zzki zze;

    static {
        zzlq zzlqVar = new zzlq();
        zzb = zzlqVar;
        zzhk.zzx(zzlq.class, zzlqVar);
    }

    private zzlq() {
    }

    public static /* synthetic */ void zzC(zzlq zzlqVar, zzki zzkiVar) {
        zzkiVar.getClass();
        zzlqVar.zze = zzkiVar;
        zzlqVar.zzd |= 1;
    }

    public static zzlo zzc() {
        return (zzlo) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzlq();
        }
        zzlp zzlpVar = null;
        if (i2 == 4) {
            return new zzlo(zzlpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
