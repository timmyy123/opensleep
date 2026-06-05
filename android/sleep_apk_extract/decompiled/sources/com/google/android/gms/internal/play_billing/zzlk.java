package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes3.dex */
public final class zzlk extends zzhk implements zzin {
    private static final zzlk zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private zzku zzg;
    private zzkx zzh;

    static {
        zzlk zzlkVar = new zzlk();
        zzb = zzlkVar;
        zzhk.zzx(zzlk.class, zzlkVar);
    }

    private zzlk() {
    }

    public static /* synthetic */ void zzC(zzlk zzlkVar, zzjz zzjzVar) {
        zzlkVar.zzf = zzjzVar;
        zzlkVar.zze = 2;
    }

    public static /* synthetic */ void zzD(zzlk zzlkVar, zzkd zzkdVar) {
        zzlkVar.zzf = zzkdVar;
        zzlkVar.zze = 3;
    }

    public static /* synthetic */ void zzE(zzlk zzlkVar, zzkl zzklVar) {
        zzklVar.getClass();
        zzlkVar.zzf = zzklVar;
        zzlkVar.zze = 7;
    }

    public static /* synthetic */ void zzF(zzlk zzlkVar, zzku zzkuVar) {
        zzkuVar.getClass();
        zzlkVar.zzg = zzkuVar;
        zzlkVar.zzd |= 1;
    }

    public static /* synthetic */ void zzG(zzlk zzlkVar, zzlq zzlqVar) {
        zzlqVar.getClass();
        zzlkVar.zzf = zzlqVar;
        zzlkVar.zze = 8;
    }

    public static /* synthetic */ void zzH(zzlk zzlkVar, zzlu zzluVar) {
        zzlkVar.zzf = zzluVar;
        zzlkVar.zze = 4;
    }

    public static zzli zzc() {
        return (zzli) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhk.zzu(zzb, "\u0004\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001\u0007<\u0000\b<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzjz.class, zzkd.class, zzlu.class, zzkr.class, "zzh", zzkl.class, zzlq.class});
        }
        if (i2 == 3) {
            return new zzlk();
        }
        zzlj zzljVar = null;
        if (i2 == 4) {
            return new zzli(zzljVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
