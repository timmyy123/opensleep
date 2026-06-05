package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfi$zzo extends zzjb<zzfi$zzo, zza> implements zzkm {
    private static final zzfi$zzo zzi;
    private static volatile zzkx<zzfi$zzo> zzj;
    private int zzc;
    private zzfi$zze zzd;
    private zzfi$zzk zze;
    private zzfi$zzi zzf;
    private int zzg;
    private boolean zzh;

    static {
        zzfi$zzo zzfi_zzo = new zzfi$zzo();
        zzi = zzfi_zzo;
        zzjb.zza((Class<zzfi$zzo>) zzfi$zzo.class, zzfi_zzo);
    }

    private zzfi$zzo() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzo>] */
    @Override // com.google.android.gms.internal.vision.zzjb
    public final Object zza(int i, Object obj, Object obj2) {
        Object obj3;
        int i2 = zzfk.zza[i - 1];
        zzfk zzfkVar = null;
        switch (i2) {
            case 1:
                return new zzfi$zzo();
            case 2:
                return new zza(zzfkVar);
            case 3:
                return zzjb.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004င\u0003\u0005ဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                zzkx<zzfi$zzo> zzkxVar = zzj;
                if (zzkxVar != null) {
                    return zzkxVar;
                }
                synchronized (zzfi$zzo.class) {
                    try {
                        zzkx<zzfi$zzo> zzkxVar2 = zzj;
                        obj3 = zzkxVar2;
                        if (zzkxVar2 == null) {
                            ?? zzaVar = new zzjb.zza(zzi);
                            zzj = zzaVar;
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

    public static final class zza extends zzjb.zzb<zzfi$zzo, zza> implements zzkm {
        private zza() {
            super(zzfi$zzo.zzi);
        }

        public final zza zza(zzfi$zzi zzfi_zzi) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzfi$zzo) this.zza).zza(zzfi_zzi);
            return this;
        }

        public /* synthetic */ zza(zzfk zzfkVar) {
            this();
        }
    }

    public static zza zza() {
        return zzi.zzj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzfi$zzi zzfi_zzi) {
        zzfi_zzi.getClass();
        this.zzf = zzfi_zzi;
        this.zzc |= 4;
    }
}
