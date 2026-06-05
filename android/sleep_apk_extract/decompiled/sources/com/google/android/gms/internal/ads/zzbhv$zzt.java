package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhv$zza;
import com.google.android.gms.internal.ads.zzbhv$zzm;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzt extends zziee<zzbhv$zzt, zza> implements zzifq {
    private static final zzbhv$zzt zzF;
    private static volatile zzifx<zzbhv$zzt> zzG = null;
    public static final int zza = 9;
    public static final int zzb = 10;
    public static final int zzc = 11;
    public static final int zzd = 12;
    public static final int zze = 13;
    public static final int zzf = 14;
    public static final int zzg = 15;
    public static final int zzh = 16;
    public static final int zzi = 17;
    public static final int zzj = 18;
    public static final int zzk = 19;
    public static final int zzl = 20;
    public static final int zzm = 21;
    private zzbhv$zzab zzA;
    private zzbhv$zza zzB;
    private zzbhv$zzaf zzC;
    private zzbhv$zzbl zzD;
    private zzbhv$zzb zzE;
    private int zzn;
    private int zzo;
    private int zzu;
    private zzbhv$zzar zzw;
    private zzbhv$zzm zzy;
    private zzbhv$zzo zzz;
    private String zzp = "";
    private int zzv = 1000;
    private zziep zzx = zziee.zzbE();

    static {
        zzbhv$zzt zzbhv_zzt = new zzbhv$zzt();
        zzF = zzbhv_zzt;
        zziee.zzbu(zzbhv$zzt.class, zzbhv_zzt);
    }

    private zzbhv$zzt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public void zzI(String str) {
        str.getClass();
        this.zzn |= 2;
        this.zzp = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzcC, reason: merged with bridge method [inline-methods] */
    public void zzax(zzbhv$zzbl zzbhv_zzbl) {
        zzbhv_zzbl.getClass();
        this.zzD = zzbhv_zzbl;
        this.zzn |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzcF, reason: merged with bridge method [inline-methods] */
    public void zzaA(zzbhv$zzb zzbhv_zzb) {
        zzbhv_zzb.getClass();
        this.zzE = zzbhv_zzb;
        this.zzn |= 2048;
    }

    private void zzci() {
        zziep zziepVar = this.zzx;
        if (zziepVar.zza()) {
            return;
        }
        this.zzx = zziee.zzbF(zziepVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzcl, reason: merged with bridge method [inline-methods] */
    public void zzaa(Iterable<? extends Long> iterable) {
        zzci();
        zzicj.zzaW(iterable, this.zzx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzcm, reason: merged with bridge method [inline-methods] */
    public void zzab() {
        this.zzx = zziee.zzbE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzcn, reason: merged with bridge method [inline-methods] */
    public void zzac(zzbhv$zzm zzbhv_zzm) {
        zzbhv_zzm.getClass();
        this.zzy = zzbhv_zzm;
        this.zzn |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzcw, reason: merged with bridge method [inline-methods] */
    public void zzar(zzbhv$zza zzbhv_zza) {
        zzbhv_zza.getClass();
        this.zzB = zzbhv_zza;
        this.zzn |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzcz, reason: merged with bridge method [inline-methods] */
    public void zzau(zzbhv$zzaf zzbhv_zzaf) {
        zzbhv_zzaf.getClass();
        this.zzC = zzbhv_zzaf;
        this.zzn |= 512;
    }

    public static zza zzx() {
        return (zza) zzF.zzbn();
    }

    public zzbhv$zzm zzG() {
        zzbhv$zzm zzbhv_zzm = this.zzy;
        return zzbhv_zzm == null ? zzbhv$zzm.zzC() : zzbhv_zzm;
    }

    public zzbhv$zza zzY() {
        zzbhv$zza zzbhv_zza = this.zzB;
        return zzbhv_zza == null ? zzbhv$zza.zzD() : zzbhv_zza;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzF, "\u0004\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\f᠌\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zzn", "zzo", "zzp", "zzu", "zzv", zzbhv$zzq.zze(), "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzt();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzF;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzt> zzifxVar = zzG;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzt.class) {
            try {
                zzidzVar = zzG;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzF);
                    zzG = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public String zzf() {
        return this.zzp;
    }

    public final class zza extends zzidy<zzbhv$zzt, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzt.zzF);
        }

        public zza zzD(Iterable<? extends Long> iterable) {
            zzbg();
            ((zzbhv$zzt) this.zza).zzaa(iterable);
            return this;
        }

        public zza zzE() {
            zzbg();
            ((zzbhv$zzt) this.zza).zzab();
            return this;
        }

        public zzbhv$zzm zzG() {
            return ((zzbhv$zzt) this.zza).zzG();
        }

        public zza zzI(zzbhv$zzm.zza zzaVar) {
            zzbg();
            ((zzbhv$zzt) this.zza).zzac(zzaVar.zzbm());
            return this;
        }

        public zzbhv$zza zzY() {
            return ((zzbhv$zzt) this.zza).zzY();
        }

        public zza zzaa(zzbhv$zza.zzb zzbVar) {
            zzbg();
            ((zzbhv$zzt) this.zza).zzar(zzbVar.zzbm());
            return this;
        }

        public zza zzaf(zzbhv$zzaf zzbhv_zzaf) {
            zzbg();
            ((zzbhv$zzt) this.zza).zzau(zzbhv_zzaf);
            return this;
        }

        public zza zzal(zzbhv$zzbl zzbhv_zzbl) {
            zzbg();
            ((zzbhv$zzt) this.zza).zzax(zzbhv_zzbl);
            return this;
        }

        public zza zzar(zzbhv$zzb zzbhv_zzb) {
            zzbg();
            ((zzbhv$zzt) this.zza).zzaA(zzbhv_zzb);
            return this;
        }

        public String zzf() {
            return ((zzbhv$zzt) this.zza).zzf();
        }

        public zza zzh(String str) {
            zzbg();
            ((zzbhv$zzt) this.zza).zzI(str);
            return this;
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
