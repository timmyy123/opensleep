package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfi$zzg extends zzjb<zzfi$zzg, zza> implements zzkm {
    private static final zzfi$zzg zzj;
    private static volatile zzkx<zzfi$zzg> zzk;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private float zzi;

    static {
        zzfi$zzg zzfi_zzg = new zzfi$zzg();
        zzj = zzfi_zzg;
        zzjb.zza((Class<zzfi$zzg>) zzfi$zzg.class, zzfi_zzg);
    }

    private zzfi$zzg() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzg>] */
    @Override // com.google.android.gms.internal.vision.zzjb
    public final Object zza(int i, Object obj, Object obj2) {
        Object obj3;
        int i2 = zzfk.zza[i - 1];
        zzfk zzfkVar = null;
        switch (i2) {
            case 1:
                return new zzfi$zzg();
            case 2:
                return new zza(zzfkVar);
            case 3:
                return zzjb.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzc.zzb(), "zzf", zzb.zzb(), "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                zzkx<zzfi$zzg> zzkxVar = zzk;
                if (zzkxVar != null) {
                    return zzkxVar;
                }
                synchronized (zzfi$zzg.class) {
                    try {
                        zzkx<zzfi$zzg> zzkxVar2 = zzk;
                        obj3 = zzkxVar2;
                        if (zzkxVar2 == null) {
                            ?? zzaVar = new zzjb.zza(zzj);
                            zzk = zzaVar;
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

    public static final class zza extends zzjb.zzb<zzfi$zzg, zza> implements zzkm {
        private zza() {
            super(zzfi$zzg.zzj);
        }

        public /* synthetic */ zza(zzfk zzfkVar) {
            this();
        }
    }

    public enum zzb implements zzje {
        CLASSIFICATION_UNKNOWN(0),
        CLASSIFICATION_NONE(1),
        CLASSIFICATION_ALL(2);

        private static final zzjh<zzb> zzd = new zzfq();
        private final int zze;

        zzb(int i) {
            this.zze = i;
        }

        public static zzb zza(int i) {
            if (i == 0) {
                return CLASSIFICATION_UNKNOWN;
            }
            if (i == 1) {
                return CLASSIFICATION_NONE;
            }
            if (i != 2) {
                return null;
            }
            return CLASSIFICATION_ALL;
        }

        public static zzjg zzb() {
            return zzfr.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.vision.zzje
        public final int zza() {
            return this.zze;
        }
    }

    public enum zzc implements zzje {
        LANDMARK_UNKNOWN(0),
        LANDMARK_NONE(1),
        LANDMARK_ALL(2),
        LANDMARK_CONTOUR(3);

        private static final zzjh<zzc> zze = new zzft();
        private final int zzf;

        zzc(int i) {
            this.zzf = i;
        }

        public static zzc zza(int i) {
            if (i == 0) {
                return LANDMARK_UNKNOWN;
            }
            if (i == 1) {
                return LANDMARK_NONE;
            }
            if (i == 2) {
                return LANDMARK_ALL;
            }
            if (i != 3) {
                return null;
            }
            return LANDMARK_CONTOUR;
        }

        public static zzjg zzb() {
            return zzfs.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.vision.zzje
        public final int zza() {
            return this.zzf;
        }
    }

    public enum zzd implements zzje {
        MODE_UNKNOWN(0),
        MODE_ACCURATE(1),
        MODE_FAST(2),
        MODE_SELFIE(3);

        private static final zzjh<zzd> zze = new zzfu();
        private final int zzf;

        zzd(int i) {
            this.zzf = i;
        }

        public static zzd zza(int i) {
            if (i == 0) {
                return MODE_UNKNOWN;
            }
            if (i == 1) {
                return MODE_ACCURATE;
            }
            if (i == 2) {
                return MODE_FAST;
            }
            if (i != 3) {
                return null;
            }
            return MODE_SELFIE;
        }

        public static zzjg zzb() {
            return zzfv.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.vision.zzje
        public final int zza() {
            return this.zzf;
        }
    }
}
