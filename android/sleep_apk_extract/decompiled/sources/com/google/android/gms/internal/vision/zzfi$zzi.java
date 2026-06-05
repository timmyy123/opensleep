package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfi$zzi extends zzjb<zzfi$zzi, zza> implements zzkm {
    private static final zzfi$zzi zzg;
    private static volatile zzkx<zzfi$zzi> zzh;
    private int zzc;
    private zzfi$zzj zzd;
    private zzfi$zzl zze;
    private zzjl<zzfi$zzf> zzf = zzjb.zzo();

    static {
        zzfi$zzi zzfi_zzi = new zzfi$zzi();
        zzg = zzfi_zzi;
        zzjb.zza((Class<zzfi$zzi>) zzfi$zzi.class, zzfi_zzi);
    }

    private zzfi$zzi() {
    }

    private final void zzc() {
        zzjl<zzfi$zzf> zzjlVar = this.zzf;
        if (zzjlVar.zza()) {
            return;
        }
        this.zzf = zzjb.zza(zzjlVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzi>] */
    @Override // com.google.android.gms.internal.vision.zzjb
    public final Object zza(int i, Object obj, Object obj2) {
        Object obj3;
        int i2 = zzfk.zza[i - 1];
        zzfk zzfkVar = null;
        switch (i2) {
            case 1:
                return new zzfi$zzi();
            case 2:
                return new zza(zzfkVar);
            case 3:
                return zzjb.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", zzfi$zzf.class});
            case 4:
                return zzg;
            case 5:
                zzkx<zzfi$zzi> zzkxVar = zzh;
                if (zzkxVar != null) {
                    return zzkxVar;
                }
                synchronized (zzfi$zzi.class) {
                    try {
                        zzkx<zzfi$zzi> zzkxVar2 = zzh;
                        obj3 = zzkxVar2;
                        if (zzkxVar2 == null) {
                            ?? zzaVar = new zzjb.zza(zzg);
                            zzh = zzaVar;
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

    public static final class zza extends zzjb.zzb<zzfi$zzi, zza> implements zzkm {
        private zza() {
            super(zzfi$zzi.zzg);
        }

        public final zza zza(zzfi$zzj zzfi_zzj) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzfi$zzi) this.zza).zza(zzfi_zzj);
            return this;
        }

        public /* synthetic */ zza(zzfk zzfkVar) {
            this();
        }

        public final zza zza(Iterable<? extends zzfi$zzf> iterable) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzfi$zzi) this.zza).zza(iterable);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Iterable<? extends zzfi$zzf> iterable) {
        zzc();
        zzhf.zza(iterable, this.zzf);
    }

    public static zza zza() {
        return zzg.zzj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzfi$zzj zzfi_zzj) {
        zzfi_zzj.getClass();
        this.zzd = zzfi_zzj;
        this.zzc |= 1;
    }
}
