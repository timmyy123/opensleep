package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgl extends zzadu implements zzafd {
    private static final zzgl zzw;
    private static volatile zzafj zzx;
    private int zzb;
    private long zze;
    private int zzg;
    private boolean zzl;
    private zzgf zzq;
    private zzgp zzr;
    private zzgv zzs;
    private zzgr zzt;
    private zzgn zzu;
    private String zzf = "";
    private zzaef zzh = zzadu.zzcy();
    private zzaef zzi = zzadu.zzcy();
    private zzaef zzj = zzadu.zzcy();
    private String zzk = "";
    private zzaef zzm = zzadu.zzcy();
    private zzaef zzn = zzadu.zzcy();
    private String zzo = "";
    private String zzp = "";
    private zzaeb zzv = zzadu.zzcv();

    static {
        zzgl zzglVar = new zzgl();
        zzw = zzglVar;
        zzadu.zzcs(zzgl.class, zzglVar);
    }

    private zzgl() {
    }

    public static zzgk zzs() {
        return (zzgk) zzw.zzcn();
    }

    public static zzgl zzt() {
        return zzw;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final long zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final List zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadu.zzct(zzw, "\u0004\u0012\u0000\u0001\u0001\u0014\u0012\u0000\u0006\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b\u0014+", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", zzgt.class, "zzi", zzgj.class, "zzj", zzfd.class, "zzk", "zzl", "zzm", zzja.class, "zzn", zzgh.class, "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv"});
        }
        if (i2 == 3) {
            return new zzgl();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzgk(bArr);
        }
        if (i2 == 5) {
            return zzw;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzx;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzgl.class) {
            try {
                zzadqVar = zzx;
                if (zzadqVar == null) {
                    zzadqVar = new zzadq(zzw);
                    zzx = zzadqVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzadqVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzgj zzh(int i) {
        return (zzgj) this.zzi.get(i);
    }

    public final List zzi() {
        return this.zzj;
    }

    public final List zzj() {
        return this.zzm;
    }

    public final int zzk() {
        return this.zzm.size();
    }

    public final List zzl() {
        return this.zzn;
    }

    public final String zzm() {
        return this.zzo;
    }

    public final boolean zzn() {
        return (this.zzb & 128) != 0;
    }

    public final zzgf zzo() {
        zzgf zzgfVar = this.zzq;
        return zzgfVar == null ? zzgf.zzh() : zzgfVar;
    }

    public final boolean zzp() {
        return (this.zzb & 512) != 0;
    }

    public final zzgv zzq() {
        zzgv zzgvVar = this.zzs;
        return zzgvVar == null ? zzgv.zze() : zzgvVar;
    }

    public final List zzr() {
        return this.zzv;
    }

    public final /* synthetic */ void zzu(int i, zzgj zzgjVar) {
        zzgjVar.getClass();
        zzaef zzaefVar = this.zzi;
        if (!zzaefVar.zza()) {
            this.zzi = zzadu.zzcz(zzaefVar);
        }
        this.zzi.set(i, zzgjVar);
    }

    public final /* synthetic */ void zzv() {
        this.zzj = zzadu.zzcy();
    }

    public final /* synthetic */ void zzw() {
        this.zzm = zzadu.zzcy();
    }
}
