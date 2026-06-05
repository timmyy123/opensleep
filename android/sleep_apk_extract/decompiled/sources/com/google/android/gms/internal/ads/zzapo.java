package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzapo implements zzafy {
    private final zzet zzc;
    private final zzes zzd;
    private zzagb zze;
    private long zzf;
    private boolean zzh;
    private boolean zzi;
    private final zzapp zza = new zzapp(true, null, 0, "audio/mp4a-latm");
    private final zzet zzb = new zzet(2048);
    private long zzg = -1;

    public zzapo(int i) {
        zzet zzetVar = new zzet(10);
        this.zzc = zzetVar;
        byte[] bArrZzi = zzetVar.zzi();
        this.zzd = new zzes(bArrZzi, bArrZzi.length);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws EOFException, InterruptedIOException {
        zzet zzetVar;
        int i = 0;
        while (true) {
            zzetVar = this.zzc;
            zzafp zzafpVar = (zzafp) zzafzVar;
            zzafpVar.zzh(zzetVar.zzi(), 0, 10, false);
            zzetVar.zzh(0);
            if (zzetVar.zzx() != 4801587) {
                break;
            }
            zzetVar.zzk(3);
            int iZzG = zzetVar.zzG();
            i += iZzG + 10;
            zzafpVar.zzj(iZzG, false);
        }
        zzafzVar.zzl();
        zzafp zzafpVar2 = (zzafp) zzafzVar;
        zzafpVar2.zzj(i, false);
        if (this.zzg == -1) {
            this.zzg = i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        do {
            zzafpVar2.zzh(zzetVar.zzi(), 0, 2, false);
            zzetVar.zzh(0);
            if (zzapp.zzf(zzetVar.zzt())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                zzafpVar2.zzh(zzetVar.zzi(), 0, 4, false);
                zzes zzesVar = this.zzd;
                zzesVar.zzf(14);
                int iZzj = zzesVar.zzj(13);
                if (iZzj <= 6) {
                    i4++;
                    zzafzVar.zzl();
                    zzafpVar2.zzj(i4, false);
                } else {
                    zzafpVar2.zzj(iZzj - 6, false);
                    i3 += iZzj;
                }
            } else {
                i4++;
                zzafzVar.zzl();
                zzafpVar2.zzj(i4, false);
            }
            i2 = 0;
            i3 = 0;
        } while (i4 - i < 8192);
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zze = zzagbVar;
        this.zza.zzb(zzagbVar, new zzarh(Integer.MIN_VALUE, 0, 1));
        zzagbVar.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) {
        this.zze.getClass();
        zzet zzetVar = this.zzb;
        int iZza = zzafzVar.zza(zzetVar.zzi(), 0, 2048);
        if (!this.zzi) {
            this.zze.zzw(new zzaha(-9223372036854775807L, 0L));
            this.zzi = true;
        }
        if (iZza == -1) {
            return -1;
        }
        zzetVar.zzh(0);
        zzetVar.zzf(iZza);
        if (!this.zzh) {
            this.zza.zzc(this.zzf, 4);
            this.zzh = true;
        }
        this.zza.zzd(zzetVar);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        this.zzh = false;
        this.zza.zza();
        this.zzf = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
