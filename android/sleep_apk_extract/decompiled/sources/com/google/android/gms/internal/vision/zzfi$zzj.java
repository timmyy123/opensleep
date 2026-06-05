package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfi$zzj extends zzjb<zzfi$zzj, zzb> implements zzkm {
    private static final zzfi$zzj zzi;
    private static volatile zzkx<zzfi$zzj> zzj;
    private int zzc;
    private int zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzfi$zzj zzfi_zzj = new zzfi$zzj();
        zzi = zzfi_zzj;
        zzjb.zza((Class<zzfi$zzj>) zzfi$zzj.class, zzfi_zzj);
    }

    private zzfi$zzj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(long j) {
        this.zzc |= 4;
        this.zzf = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(long j) {
        this.zzc |= 8;
        this.zzg = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(long j) {
        this.zzc |= 16;
        this.zzh = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzj>] */
    @Override // com.google.android.gms.internal.vision.zzjb
    public final Object zza(int i, Object obj, Object obj2) {
        Object obj3;
        int i2 = zzfk.zza[i - 1];
        zzfk zzfkVar = null;
        switch (i2) {
            case 1:
                return new zzfi$zzj();
            case 2:
                return new zzb(zzfkVar);
            case 3:
                return zzjb.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0004\u0005ဂ\u0003", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzh", "zzg"});
            case 4:
                return zzi;
            case 5:
                zzkx<zzfi$zzj> zzkxVar = zzj;
                if (zzkxVar != null) {
                    return zzkxVar;
                }
                synchronized (zzfi$zzj.class) {
                    try {
                        zzkx<zzfi$zzj> zzkxVar2 = zzj;
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

    public static final class zzb extends zzjb.zzb<zzfi$zzj, zzb> implements zzkm {
        private zzb() {
            super(zzfi$zzj.zzi);
        }

        public final zzb zza(long j) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzfi$zzj) this.zza).zza(j);
            return this;
        }

        public final zzb zzb(long j) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzfi$zzj) this.zza).zzb(j);
            return this;
        }

        public final zzb zzc(long j) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzfi$zzj) this.zza).zzc(j);
            return this;
        }

        public final zzb zzd(long j) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzfi$zzj) this.zza).zzd(j);
            return this;
        }

        public /* synthetic */ zzb(zzfk zzfkVar) {
            this();
        }
    }

    public enum zza implements zzje {
        FORMAT_UNKNOWN(0),
        FORMAT_LUMINANCE(1),
        FORMAT_RGB8(2),
        FORMAT_MONOCHROME(3);

        private static final zzjh<zza> zze = new zzfx();
        private final int zzf;

        zza(int i) {
            this.zzf = i;
        }

        public static zza zza(int i) {
            if (i == 0) {
                return FORMAT_UNKNOWN;
            }
            if (i == 1) {
                return FORMAT_LUMINANCE;
            }
            if (i == 2) {
                return FORMAT_RGB8;
            }
            if (i != 3) {
                return null;
            }
            return FORMAT_MONOCHROME;
        }

        public static zzjg zzb() {
            return zzfw.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.vision.zzje
        public final int zza() {
            return this.zzf;
        }
    }

    public static zzb zza() {
        return zzi.zzj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(long j) {
        this.zzc |= 2;
        this.zze = j;
    }
}
