package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
public final class zznk extends zzadu implements zzafd {
    private static final zznk zzo;
    private static volatile zzafj zzp;
    private int zzb;
    private boolean zzf;
    private zznm zzk;
    private boolean zzl;
    private boolean zzm;
    private zznf zzn;
    private zzacr zze = zzacr.zza;
    private String zzg = "";
    private zzaef zzh = zzadu.zzcy();
    private zzaef zzi = zzadu.zzcy();
    private zzaeb zzj = zzadu.zzcv();

    static {
        zznk zznkVar = new zznk();
        zzo = zznkVar;
        zzadu.zzcs(zznk.class, zznkVar);
    }

    private zznk() {
    }

    public static zznk zza() {
        return zzo;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadu.zzct(zzo, "\u0004\n\u0000\u0001\u0001\f\n\u0000\u0003\u0000\u0001ည\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004\u001a\u0005\u001a\u0007ࠬ\bဉ\u0003\nဇ\u0004\u000bဇ\u0005\fဉ\u0006", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzabz.zzc(), "zzk", "zzl", "zzm", "zzn"});
        }
        if (i2 == 3) {
            return new zznk();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zznj(bArr);
        }
        if (i2 == 5) {
            return zzo;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzp;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zznk.class) {
            try {
                zzadqVar = zzp;
                if (zzadqVar == null) {
                    zzadqVar = new zzadq(zzo);
                    zzp = zzadqVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzadqVar;
    }
}
