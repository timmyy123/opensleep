package com.google.android.gms.internal.measurement;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class zzpr extends zzadu implements zzafd {
    private static final zzpr zzl;
    private static volatile zzafj zzm;
    private int zzb;
    private boolean zzf;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private String zze = "";
    private zzaef zzg = zzadu.zzcy();

    static {
        zzpr zzprVar = new zzpr();
        zzl = zzprVar;
        zzadu.zzcs(zzpr.class, zzprVar);
    }

    private zzpr() {
    }

    public static zzpr zzh(InputStream inputStream, zzadf zzadfVar) {
        return (zzpr) zzadu.zzcB(zzl, inputStream, zzadfVar);
    }

    public final String zza() {
        return this.zze;
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final zzabz zzc() {
        zzabz zzabzVarZzb = zzabz.zzb(this.zzh);
        return zzabzVarZzb == null ? zzabz.UNKNOWN : zzabzVarZzb;
    }

    public final boolean zzd() {
        return this.zzi;
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final boolean zzf() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadu.zzct(zzl, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003\u001a\u0004᠌\u0002\u0005ဇ\u0003\u0006ဇ\u0005\u0007ဇ\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", zzabz.zzc(), "zzi", "zzk", "zzj"});
        }
        if (i2 == 3) {
            return new zzpr();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzpq(bArr);
        }
        if (i2 == 5) {
            return zzl;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzm;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzpr.class) {
            try {
                zzadqVar = zzm;
                if (zzadqVar == null) {
                    zzadqVar = new zzadq(zzl);
                    zzm = zzadqVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzadqVar;
    }
}
