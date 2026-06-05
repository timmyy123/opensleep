package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfn extends zzadu implements zzafd {
    private static final zzfn zzk;
    private static volatile zzafj zzl;
    private int zzb;
    private int zze;
    private String zzf = "";
    private zzfh zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzfn zzfnVar = new zzfn();
        zzk = zzfnVar;
        zzadu.zzcs(zzfn.class, zzfnVar);
    }

    private zzfn() {
    }

    public static zzfm zzj() {
        return (zzfm) zzk.zzcn();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final zzfh zzd() {
        zzfh zzfhVar = this.zzg;
        return zzfhVar == null ? zzfh.zzj() : zzfhVar;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadu.zzct(zzk, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzfn();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzfm(bArr);
        }
        if (i2 == 5) {
            return zzk;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzl;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzfn.class) {
            try {
                zzadqVar = zzl;
                if (zzadqVar == null) {
                    zzadqVar = new zzadq(zzk);
                    zzl = zzadqVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzadqVar;
    }

    public final boolean zzh() {
        return (this.zzb & 32) != 0;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final /* synthetic */ void zzk(String str) {
        this.zzb |= 2;
        this.zzf = str;
    }
}
