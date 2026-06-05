package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfi$zzd extends zzjb<zzfi$zzd, zza> implements zzkm {
    private static final zzfi$zzd zzd;
    private static volatile zzkx<zzfi$zzd> zze;
    private zzjl<zzfi$zzm> zzc = zzjb.zzo();

    static {
        zzfi$zzd zzfi_zzd = new zzfi$zzd();
        zzd = zzfi_zzd;
        zzjb.zza((Class<zzfi$zzd>) zzfi$zzd.class, zzfi_zzd);
    }

    private zzfi$zzd() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzd>] */
    @Override // com.google.android.gms.internal.vision.zzjb
    public final Object zza(int i, Object obj, Object obj2) {
        Object obj3;
        int i2 = zzfk.zza[i - 1];
        zzfk zzfkVar = null;
        switch (i2) {
            case 1:
                return new zzfi$zzd();
            case 2:
                return new zza(zzfkVar);
            case 3:
                return zzjb.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfi$zzm.class});
            case 4:
                return zzd;
            case 5:
                zzkx<zzfi$zzd> zzkxVar = zze;
                if (zzkxVar != null) {
                    return zzkxVar;
                }
                synchronized (zzfi$zzd.class) {
                    try {
                        zzkx<zzfi$zzd> zzkxVar2 = zze;
                        obj3 = zzkxVar2;
                        if (zzkxVar2 == null) {
                            ?? zzaVar = new zzjb.zza(zzd);
                            zze = zzaVar;
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

    public static final class zza extends zzjb.zzb<zzfi$zzd, zza> implements zzkm {
        private zza() {
            super(zzfi$zzd.zzd);
        }

        public /* synthetic */ zza(zzfk zzfkVar) {
            this();
        }
    }
}
