package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzaed;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzni extends zzadu implements zzafd {
    private static final zzaec zzl = new zzng();
    private static final zzni zzq;
    private static volatile zzafj zzr;
    private int zzb;
    private boolean zzf;
    private long zzh;
    private zznm zzm;
    private boolean zzn;
    private boolean zzo;
    private zznf zzp;
    private zzacr zze = zzacr.zza;
    private String zzg = "";
    private zzaef zzi = zzadu.zzcy();
    private zzaef zzj = zzadu.zzcy();
    private zzaeb zzk = zzadu.zzcv();

    static {
        zzni zzniVar = new zzni();
        zzq = zzniVar;
        zzadu.zzcs(zzni.class, zzniVar);
    }

    private zzni() {
    }

    public static zznh zzo() {
        return (zznh) zzq.zzcn();
    }

    public static zzni zzp() {
        return zzq;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final zzacr zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final long zze() {
        return this.zzh;
    }

    public final List zzf() {
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
            return zzadu.zzct(zzq, "\u0004\u000b\u0000\u0001\u0001\f\u000b\u0000\u0003\u0000\u0001ည\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005\u001a\u0006\u001a\u0007ࠬ\bဉ\u0004\nဇ\u0005\u000bဇ\u0006\fဉ\u0007", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzabz.zzc(), "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new zzni();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zznh(bArr);
        }
        if (i2 == 5) {
            return zzq;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzr;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzni.class) {
            try {
                zzadqVar = zzr;
                if (zzadqVar == null) {
                    zzadqVar = new zzadq(zzq);
                    zzr = zzadqVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzadqVar;
    }

    public final List zzh() {
        return this.zzj;
    }

    public final List zzi() {
        return new zzaed.zza(this.zzk, zzl);
    }

    public final boolean zzj() {
        return (this.zzb & 16) != 0;
    }

    public final zznm zzk() {
        zznm zznmVar = this.zzm;
        return zznmVar == null ? zznm.zzc() : zznmVar;
    }

    public final boolean zzl() {
        return this.zzn;
    }

    public final boolean zzm() {
        return this.zzo;
    }

    public final zznf zzn() {
        zznf zznfVar = this.zzp;
        return zznfVar == null ? zznf.zzb() : zznfVar;
    }

    public final /* synthetic */ void zzq(long j) {
        this.zzb |= 8;
        this.zzh = j;
    }
}
