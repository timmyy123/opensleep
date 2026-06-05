package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfi$zzn extends zzjb<zzfi$zzn, zza> implements zzkm {
    private static final zzfi$zzn zzh;
    private static volatile zzkx<zzfi$zzn> zzi;
    private int zzc;
    private zzfi$zzd zzd;
    private int zze;
    private zzfi$zzh zzf;
    private zzfi$zzc zzg;

    static {
        zzfi$zzn zzfi_zzn = new zzfi$zzn();
        zzh = zzfi_zzn;
        zzjb.zza((Class<zzfi$zzn>) zzfi$zzn.class, zzfi_zzn);
    }

    private zzfi$zzn() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzn>] */
    @Override // com.google.android.gms.internal.vision.zzjb
    public final Object zza(int i, Object obj, Object obj2) {
        Object obj3;
        int i2 = zzfk.zza[i - 1];
        zzfk zzfkVar = null;
        switch (i2) {
            case 1:
                return new zzfi$zzn();
            case 2:
                return new zza(zzfkVar);
            case 3:
                return zzjb.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0010ဉ\u0002\u0011ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                zzkx<zzfi$zzn> zzkxVar = zzi;
                if (zzkxVar != null) {
                    return zzkxVar;
                }
                synchronized (zzfi$zzn.class) {
                    try {
                        zzkx<zzfi$zzn> zzkxVar2 = zzi;
                        obj3 = zzkxVar2;
                        if (zzkxVar2 == null) {
                            ?? zzaVar = new zzjb.zza(zzh);
                            zzi = zzaVar;
                            obj3 = zzaVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return obj3;
            case 6:
                return (byte) 1;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
            case 7:
                return null;
        }
    }

    public static final class zza extends zzjb.zzb<zzfi$zzn, zza> implements zzkm {
        private zza() {
            super(zzfi$zzn.zzh);
        }

        public /* synthetic */ zza(zzfk zzfkVar) {
            this();
        }
    }
}
