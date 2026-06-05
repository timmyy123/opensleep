package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes3.dex */
public final class zzkr extends zzhk implements zzin {
    private static final zzkr zzb;
    private int zzd;
    private int zzf;
    private zzki zzi;
    private boolean zzj;
    private boolean zzk;
    private String zze = "";
    private zzhn zzg = zzhk.zzr();
    private zzho zzh = zzhk.zzs();

    static {
        zzkr zzkrVar = new zzkr();
        zzb = zzkrVar;
        zzhk.zzx(zzkr.class, zzkrVar);
    }

    private zzkr() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zzd", "zze", "zzf", zzkp.zza, "zzg", zzkm.zza, "zzh", zzln.class, "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzkr();
        }
        zzkq zzkqVar = null;
        if (i2 == 4) {
            return new zzko(zzkqVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
