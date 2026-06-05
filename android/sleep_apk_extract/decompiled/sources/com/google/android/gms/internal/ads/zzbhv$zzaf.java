package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhv$zzd;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzaf extends zziee<zzbhv$zzaf, zzc> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 4;
    public static final int zze = 5;
    public static final int zzf = 6;
    public static final int zzg = 7;
    public static final int zzh = 8;
    private static final zzbhv$zzaf zzv;
    private static volatile zzifx<zzbhv$zzaf> zzw;
    private int zzi;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzp;
    private int zzu;
    private zzieq<zza> zzj = zziee.zzbM();
    private String zzn = "";
    private String zzo = "";

    public enum zzd implements zziei {
        UNSPECIFIED(0),
        CONNECTING(1),
        CONNECTED(2),
        DISCONNECTING(3),
        DISCONNECTED(4),
        SUSPENDED(5);

        private static final zziej<zzd> zzm = new zziej<zzd>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzaf.zzd.1
        };
        private final int zzn;

        final class zza implements zziek {
            static final zziek zza = new zza();

            private zza() {
            }

            @Override // com.google.android.gms.internal.ads.zziek
            public boolean zza(int i) {
                return zzd.zzc(i) != null;
            }
        }

        zzd(int i) {
            this.zzn = i;
        }

        public static zzd zzc(int i) {
            if (i == 0) {
                return UNSPECIFIED;
            }
            if (i == 1) {
                return CONNECTING;
            }
            if (i == 2) {
                return CONNECTED;
            }
            if (i == 3) {
                return DISCONNECTING;
            }
            if (i == 4) {
                return DISCONNECTED;
            }
            if (i != 5) {
                return null;
            }
            return SUSPENDED;
        }

        public static zziek zze() {
            return zza.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.zzn);
        }

        @Override // com.google.android.gms.internal.ads.zziei
        public final int zza() {
            return this.zzn;
        }
    }

    static {
        zzbhv$zzaf zzbhv_zzaf = new zzbhv$zzaf();
        zzv = zzbhv_zzaf;
        zziee.zzbu(zzbhv$zzaf.class, zzbhv_zzaf);
    }

    private zzbhv$zzaf() {
    }

    public static zzc zzB() {
        return (zzc) zzv.zzbn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaC, reason: merged with bridge method [inline-methods] */
    public void zzae(long j) {
        this.zzi |= 32;
        this.zzp = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaE, reason: merged with bridge method [inline-methods] */
    public void zzag(int i) {
        this.zzi |= 64;
        this.zzu = i;
    }

    private void zzaj() {
        zzieq<zza> zzieqVar = this.zzj;
        if (zzieqVar.zza()) {
            return;
        }
        this.zzj = zziee.zzbN(zzieqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzan, reason: merged with bridge method [inline-methods] */
    public void zzN(Iterable<? extends zza> iterable) {
        zzaj();
        zzicj.zzaW(iterable, this.zzj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaq, reason: merged with bridge method [inline-methods] */
    public void zzS(int i) {
        this.zzi |= 1;
        this.zzk = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzas, reason: merged with bridge method [inline-methods] */
    public void zzU(int i) {
        this.zzi |= 2;
        this.zzl = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzau, reason: merged with bridge method [inline-methods] */
    public void zzW(long j) {
        this.zzi |= 4;
        this.zzm = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaw, reason: merged with bridge method [inline-methods] */
    public void zzY(String str) {
        str.getClass();
        this.zzi |= 8;
        this.zzn = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaz, reason: merged with bridge method [inline-methods] */
    public void zzab(String str) {
        str.getClass();
        this.zzi |= 16;
        this.zzo = str;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzv, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005\bင\u0006", new Object[]{"zzi", "zzj", zza.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzaf();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzc(bArr);
        }
        if (iOrdinal == 5) {
            return zzv;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzaf> zzifxVar = zzw;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzaf.class) {
            try {
                zzidzVar = zzw;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzv);
                    zzw = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zziee<zza, C0004zza> implements zzifq {
        private static final zza zzG;
        private static volatile zzifx<zza> zzH = null;
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 8;
        public static final int zzi = 9;
        public static final int zzj = 10;
        public static final int zzk = 11;
        public static final int zzl = 12;
        public static final int zzm = 13;
        private static final zzien<zzbhv$zzd.zza> zzx = new zzien<zzbhv$zzd.zza>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzaf.zza.1
        };
        private int zzA;
        private int zzB;
        private int zzC;
        private int zzD;
        private int zzE;
        private long zzF;
        private int zzn;
        private long zzo;
        private int zzp;
        private long zzu;
        private long zzv;
        private zziem zzw = zziee.zzbC();
        private zzbhv$zzab zzy;
        private int zzz;

        static {
            zza zzaVar = new zza();
            zzG = zzaVar;
            zziee.zzbu(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzaB, reason: merged with bridge method [inline-methods] */
        public void zzR(long j) {
            this.zzn |= 8;
            this.zzv = j;
        }

        private void zzaD() {
            zziem zziemVar = this.zzw;
            if (zziemVar.zza()) {
                return;
            }
            this.zzw = zziee.zzbD(zziemVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzaG, reason: merged with bridge method [inline-methods] */
        public void zzZ(Iterable<? extends zzbhv$zzd.zza> iterable) {
            zzaD();
            Iterator<? extends zzbhv$zzd.zza> it = iterable.iterator();
            while (it.hasNext()) {
                this.zzw.zzi(it.next().zza());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzaI, reason: merged with bridge method [inline-methods] */
        public void zzad(zzbhv$zzab zzbhv_zzab) {
            zzbhv_zzab.getClass();
            this.zzy = zzbhv_zzab;
            this.zzn |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzaL, reason: merged with bridge method [inline-methods] */
        public void zzag(zzbhv$zzq zzbhv_zzq) {
            this.zzz = zzbhv_zzq.zza();
            this.zzn |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzav, reason: merged with bridge method [inline-methods] */
        public void zzF(long j) {
            this.zzn |= 1;
            this.zzo = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzax, reason: merged with bridge method [inline-methods] */
        public void zzJ(zzbhv$zzq zzbhv_zzq) {
            this.zzp = zzbhv_zzq.zza();
            this.zzn |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzaz, reason: merged with bridge method [inline-methods] */
        public void zzN(long j) {
            this.zzn |= 4;
            this.zzu = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzcf, reason: merged with bridge method [inline-methods] */
        public void zzai(zzbhv$zzq zzbhv_zzq) {
            this.zzA = zzbhv_zzq.zza();
            this.zzn |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzch, reason: merged with bridge method [inline-methods] */
        public void zzak(zzbhv$zzq zzbhv_zzq) {
            this.zzB = zzbhv_zzq.zza();
            this.zzn |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzcj, reason: merged with bridge method [inline-methods] */
        public void zzam(int i) {
            this.zzn |= 256;
            this.zzC = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzcl, reason: merged with bridge method [inline-methods] */
        public void zzao(zzbhv$zzq zzbhv_zzq) {
            this.zzD = zzbhv_zzq.zza();
            this.zzn |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzcn, reason: merged with bridge method [inline-methods] */
        public void zzaq(zzd zzdVar) {
            this.zzE = zzdVar.zza();
            this.zzn |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzcp, reason: merged with bridge method [inline-methods] */
        public void zzas(long j) {
            this.zzn |= 2048;
            this.zzF = j;
        }

        public static zza zzk(byte[] bArr) {
            return (zza) zziee.zzbU(zzG, bArr);
        }

        public static C0004zza zzz() {
            return (C0004zza) zzG.zzbn();
        }

        public long zzb() {
            return this.zzo;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zziee.zzbv(zzG, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ࠞ\u0006ဉ\u0004\u0007᠌\u0005\b᠌\u0006\t᠌\u0007\nင\b\u000b᠌\t\f᠌\n\rဂ\u000b", new Object[]{"zzn", "zzo", "zzp", zzbhv$zzq.zze(), "zzu", "zzv", "zzw", zzbhv$zzd.zza.zze(), "zzy", "zzz", zzbhv$zzq.zze(), "zzA", zzbhv$zzq.zze(), "zzB", zzbhv$zzq.zze(), "zzC", "zzD", zzbhv$zzq.zze(), "zzE", zzd.zze(), "zzF"});
            }
            if (iOrdinal == 3) {
                return new zza();
            }
            byte[] bArr = null;
            if (iOrdinal == 4) {
                return new C0004zza(bArr);
            }
            if (iOrdinal == 5) {
                return zzG;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zza> zzifxVar = zzH;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zza.class) {
                try {
                    zzidzVar = zzH;
                    if (zzidzVar == null) {
                        zzidzVar = new zzidz(zzG);
                        zzH = zzidzVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzidzVar;
        }

        public zzbhv$zzq zzf() {
            zzbhv$zzq zzbhv_zzqZzc = zzbhv$zzq.zzc(this.zzp);
            return zzbhv_zzqZzc == null ? zzbhv$zzq.ENUM_FALSE : zzbhv_zzqZzc;
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzaf$zza$zza, reason: collision with other inner class name */
        public final class C0004zza extends zzidy<zza, C0004zza> implements zzifq {
            private C0004zza() {
                super(zza.zzG);
            }

            public C0004zza zzF(zzbhv$zzq zzbhv_zzq) {
                zzbg();
                ((zza) this.zza).zzag(zzbhv_zzq);
                return this;
            }

            public C0004zza zzJ(zzbhv$zzq zzbhv_zzq) {
                zzbg();
                ((zza) this.zza).zzai(zzbhv_zzq);
                return this;
            }

            public C0004zza zzN(zzbhv$zzq zzbhv_zzq) {
                zzbg();
                ((zza) this.zza).zzak(zzbhv_zzq);
                return this;
            }

            public C0004zza zzR(int i) {
                zzbg();
                ((zza) this.zza).zzam(i);
                return this;
            }

            public C0004zza zzV(zzbhv$zzq zzbhv_zzq) {
                zzbg();
                ((zza) this.zza).zzao(zzbhv_zzq);
                return this;
            }

            public C0004zza zzZ(zzd zzdVar) {
                zzbg();
                ((zza) this.zza).zzaq(zzdVar);
                return this;
            }

            public C0004zza zzad(long j) {
                zzbg();
                ((zza) this.zza).zzas(j);
                return this;
            }

            public C0004zza zzc(long j) {
                zzbg();
                ((zza) this.zza).zzF(j);
                return this;
            }

            public C0004zza zzg(zzbhv$zzq zzbhv_zzq) {
                zzbg();
                ((zza) this.zza).zzJ(zzbhv_zzq);
                return this;
            }

            public C0004zza zzk(long j) {
                zzbg();
                ((zza) this.zza).zzN(j);
                return this;
            }

            public C0004zza zzo(long j) {
                zzbg();
                ((zza) this.zza).zzR(j);
                return this;
            }

            public C0004zza zzv(Iterable<? extends zzbhv$zzd.zza> iterable) {
                zzbg();
                ((zza) this.zza).zzZ(iterable);
                return this;
            }

            public C0004zza zzz(zzbhv$zzab zzbhv_zzab) {
                zzbg();
                ((zza) this.zza).zzad(zzbhv_zzab);
                return this;
            }

            public /* synthetic */ C0004zza(byte[] bArr) {
                this();
            }
        }
    }

    public final class zzc extends zzidy<zzbhv$zzaf, zzc> implements zzifq {
        private zzc() {
            super(zzbhv$zzaf.zzv);
        }

        public zzc zzB(String str) {
            zzbg();
            ((zzbhv$zzaf) this.zza).zzY(str);
            return this;
        }

        public zzc zzH(String str) {
            zzbg();
            ((zzbhv$zzaf) this.zza).zzab(str);
            return this;
        }

        public zzc zzM(long j) {
            zzbg();
            ((zzbhv$zzaf) this.zza).zzae(j);
            return this;
        }

        public zzc zzQ(int i) {
            zzbg();
            ((zzbhv$zzaf) this.zza).zzag(i);
            return this;
        }

        public zzc zzj(Iterable<? extends zza> iterable) {
            zzbg();
            ((zzbhv$zzaf) this.zza).zzN(iterable);
            return this;
        }

        public zzc zzo(int i) {
            zzbg();
            ((zzbhv$zzaf) this.zza).zzS(i);
            return this;
        }

        public zzc zzs(int i) {
            zzbg();
            ((zzbhv$zzaf) this.zza).zzU(i);
            return this;
        }

        public zzc zzw(long j) {
            zzbg();
            ((zzbhv$zzaf) this.zza).zzW(j);
            return this;
        }

        public /* synthetic */ zzc(byte[] bArr) {
            this();
        }
    }
}
