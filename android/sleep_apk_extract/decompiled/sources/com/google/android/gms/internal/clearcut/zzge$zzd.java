package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzge$zzd extends zzcg<zzge$zzd, zza> implements zzdq {
    private static volatile zzdz<zzge$zzd> zzbg;
    private static final zzge$zzd zztx;
    private int zzbb;
    private int zztu;
    private String zztv = "";
    private String zztw = "";

    public static final class zza extends zzcg.zza<zzge$zzd, zza> implements zzdq {
        private zza() {
            super(zzge$zzd.zztx);
        }

        public /* synthetic */ zza(zzgf zzgfVar) {
            this();
        }
    }

    static {
        zzge$zzd zzge_zzd = new zzge$zzd();
        zztx = zzge_zzd;
        zzcg.zza((Class<zzge$zzd>) zzge$zzd.class, zzge_zzd);
    }

    private zzge$zzd() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzge$zzd>] */
    @Override // com.google.android.gms.internal.clearcut.zzcg
    public final Object zza(int i, Object obj, Object obj2) {
        Object obj3;
        int i2 = zzgf.zzba[i - 1];
        zzgf zzgfVar = null;
        switch (i2) {
            case 1:
                return new zzge$zzd();
            case 2:
                return new zza(zzgfVar);
            case 3:
                return zzcg.zza(zztx, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"zzbb", "zztu", "zztv", "zztw"});
            case 4:
                return zztx;
            case 5:
                zzdz<zzge$zzd> zzdzVar = zzbg;
                if (zzdzVar != null) {
                    return zzdzVar;
                }
                synchronized (zzge$zzd.class) {
                    try {
                        zzdz<zzge$zzd> zzdzVar2 = zzbg;
                        obj3 = zzdzVar2;
                        if (zzdzVar2 == null) {
                            ?? zzbVar = new zzcg.zzb(zztx);
                            zzbg = zzbVar;
                            obj3 = zzbVar;
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
}
