package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzb extends zziee<zzbhv$zzb, zzc> implements zzifq {
    public static final int zza = 1;
    private static final zzbhv$zzb zzc;
    private static volatile zzifx<zzbhv$zzb> zzd;
    private zzieq<zza> zzb = zziee.zzbM();

    public enum zzd implements zziei {
        UNSPECIFIED(0),
        IN_MEMORY(1);

        private static final zziej<zzd> zze = new zziej<zzd>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzb.zzd.1
        };
        private final int zzf;

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
            this.zzf = i;
        }

        public static zzd zzc(int i) {
            if (i == 0) {
                return UNSPECIFIED;
            }
            if (i != 1) {
                return null;
            }
            return IN_MEMORY;
        }

        public static zziek zze() {
            return zza.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.zzf);
        }

        @Override // com.google.android.gms.internal.ads.zziei
        public final int zza() {
            return this.zzf;
        }
    }

    static {
        zzbhv$zzb zzbhv_zzb = new zzbhv$zzb();
        zzc = zzbhv_zzb;
        zziee.zzbu(zzbhv$zzb.class, zzbhv_zzb);
    }

    private zzbhv$zzb() {
    }

    private void zzD() {
        zzieq<zza> zzieqVar = this.zzb;
        if (zzieqVar.zza()) {
            return;
        }
        this.zzb = zziee.zzbN(zzieqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzF, reason: merged with bridge method [inline-methods] */
    public void zzx(zza zzaVar) {
        zzaVar.getClass();
        zzD();
        this.zzb.add(zzaVar);
    }

    public static zzc zzs() {
        return (zzc) zzc.zzbn();
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zza.class});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzb();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzc(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzb> zzifxVar = zzd;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzb.class) {
            try {
                zzidzVar = zzd;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzc);
                    zzd = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zziee<zza, C0005zza> implements zzifq {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zza zzh;
        private static volatile zzifx<zza> zzi;
        private int zzd;
        private int zze;
        private zze zzf;
        private zzg zzg;

        static {
            zza zzaVar = new zza();
            zzh = zzaVar;
            zziee.zzbu(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzF, reason: merged with bridge method [inline-methods] */
        public void zzw(zzd zzdVar) {
            this.zze = zzdVar.zza();
            this.zzd |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
        public void zzy(zze zzeVar) {
            zzeVar.getClass();
            this.zzf = zzeVar;
            this.zzd |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzK, reason: merged with bridge method [inline-methods] */
        public void zzB(zzg zzgVar) {
            zzgVar.getClass();
            this.zzg = zzgVar;
            this.zzd |= 4;
        }

        public static C0005zza zzs() {
            return (C0005zza) zzh.zzbn();
        }

        @Override // com.google.android.gms.internal.ads.zziee
        public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zziee.zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzd.zze(), "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zza();
            }
            byte[] bArr = null;
            if (iOrdinal == 4) {
                return new C0005zza(bArr);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zza> zzifxVar = zzi;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zza.class) {
                try {
                    zzidzVar = zzi;
                    if (zzidzVar == null) {
                        zzidzVar = new zzidz(zzh);
                        zzi = zzidzVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzidzVar;
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzb$zza$zza, reason: collision with other inner class name */
        public final class C0005zza extends zzidy<zza, C0005zza> implements zzifq {
            private C0005zza() {
                super(zza.zzh);
            }

            public C0005zza zzc(zzd zzdVar) {
                zzbg();
                ((zza) this.zza).zzw(zzdVar);
                return this;
            }

            public C0005zza zzg(zze zzeVar) {
                zzbg();
                ((zza) this.zza).zzy(zzeVar);
                return this;
            }

            public C0005zza zzh(zze.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzy(zzaVar.zzbm());
                return this;
            }

            public C0005zza zzn(zzg.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzB(zzaVar.zzbm());
                return this;
            }

            public /* synthetic */ C0005zza(byte[] bArr) {
                this();
            }
        }
    }

    public final class zze extends zziee<zze, zza> implements zzifq {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zze zzf;
        private static volatile zzifx<zze> zzg;
        private int zzc;
        private boolean zzd;
        private int zze;

        static {
            zze zzeVar = new zze();
            zzf = zzeVar;
            zziee.zzbu(zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzB, reason: merged with bridge method [inline-methods] */
        public void zzw(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        public static zza zzq() {
            return (zza) zzf.zzbn();
        }

        public static zze zzs() {
            return zzf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
        public void zzu(boolean z) {
            this.zzc |= 1;
            this.zzd = z;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zziee.zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zzc", "zzd", "zze"});
            }
            if (iOrdinal == 3) {
                return new zze();
            }
            byte[] bArr = null;
            if (iOrdinal == 4) {
                return new zza(bArr);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zze> zzifxVar = zzg;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zze.class) {
                try {
                    zzidzVar = zzg;
                    if (zzidzVar == null) {
                        zzidzVar = new zzidz(zzf);
                        zzg = zzidzVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzidzVar;
        }

        public final class zza extends zzidy<zze, zza> implements zzifq {
            private zza() {
                super(zze.zzf);
            }

            public zza zzc(boolean z) {
                zzbg();
                ((zze) this.zza).zzu(z);
                return this;
            }

            public zza zzg(int i) {
                zzbg();
                ((zze) this.zza).zzw(i);
                return this;
            }

            public /* synthetic */ zza(byte[] bArr) {
                this();
            }
        }
    }

    public final class zzg extends zziee<zzg, zza> implements zzifq {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzg zzh;
        private static volatile zzifx<zzg> zzi;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private int zzg;

        static {
            zzg zzgVar = new zzg();
            zzh = zzgVar;
            zziee.zzbu(zzg.class, zzgVar);
        }

        private zzg() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzD, reason: merged with bridge method [inline-methods] */
        public void zzw(boolean z) {
            this.zzd |= 1;
            this.zze = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzF, reason: merged with bridge method [inline-methods] */
        public void zzy(boolean z) {
            this.zzd |= 2;
            this.zzf = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
        public void zzA(int i) {
            this.zzd |= 4;
            this.zzg = i;
        }

        public static zza zzs() {
            return (zza) zzh.zzbn();
        }

        @Override // com.google.android.gms.internal.ads.zziee
        public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zziee.zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzg();
            }
            byte[] bArr = null;
            if (iOrdinal == 4) {
                return new zza(bArr);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzg> zzifxVar = zzi;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzg.class) {
                try {
                    zzidzVar = zzi;
                    if (zzidzVar == null) {
                        zzidzVar = new zzidz(zzh);
                        zzi = zzidzVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzidzVar;
        }

        public final class zza extends zzidy<zzg, zza> implements zzifq {
            private zza() {
                super(zzg.zzh);
            }

            public zza zzc(boolean z) {
                zzbg();
                ((zzg) this.zza).zzw(z);
                return this;
            }

            public zza zzg(boolean z) {
                zzbg();
                ((zzg) this.zza).zzy(z);
                return this;
            }

            public zza zzk(int i) {
                zzbg();
                ((zzg) this.zza).zzA(i);
                return this;
            }

            public /* synthetic */ zza(byte[] bArr) {
                this();
            }
        }
    }

    public final class zzc extends zzidy<zzbhv$zzb, zzc> implements zzifq {
        private zzc() {
            super(zzbhv$zzb.zzc);
        }

        public zzc zzh(zza.C0005zza c0005zza) {
            zzbg();
            ((zzbhv$zzb) this.zza).zzx(c0005zza.zzbm());
            return this;
        }

        public /* synthetic */ zzc(byte[] bArr) {
            this();
        }
    }
}
