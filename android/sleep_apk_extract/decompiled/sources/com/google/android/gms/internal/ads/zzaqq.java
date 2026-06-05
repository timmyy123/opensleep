package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzaqq {
    private final zzapt zza;
    private final zzfi zzb;
    private final zzes zzc = new zzes(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzaqq(zzapt zzaptVar, zzfi zzfiVar) {
        this.zza = zzaptVar;
        this.zzb = zzfiVar;
    }

    public final void zza() {
        this.zzf = false;
        this.zza.zza();
    }

    public final void zzb(zzet zzetVar) {
        long jZze;
        char c;
        zzes zzesVar = this.zzc;
        zzetVar.zzm(zzesVar.zza, 0, 3);
        zzesVar.zzf(0);
        zzesVar.zzh(8);
        this.zzd = zzesVar.zzi();
        this.zze = zzesVar.zzi();
        zzesVar.zzh(6);
        zzetVar.zzm(zzesVar.zza, 0, zzesVar.zzj(8));
        zzesVar.zzf(0);
        if (this.zzd) {
            zzesVar.zzh(4);
            long jZzj = zzesVar.zzj(3);
            zzesVar.zzh(1);
            int iZzj = zzesVar.zzj(15) << 15;
            zzesVar.zzh(1);
            long jZzj2 = zzesVar.zzj(15);
            zzesVar.zzh(1);
            if (this.zzf || !this.zze) {
                c = 30;
            } else {
                zzesVar.zzh(4);
                long jZzj3 = ((long) zzesVar.zzj(3)) << 30;
                zzesVar.zzh(1);
                int iZzj2 = zzesVar.zzj(15) << 15;
                zzesVar.zzh(1);
                c = 30;
                long jZzj4 = zzesVar.zzj(15);
                zzesVar.zzh(1);
                this.zzb.zze(jZzj3 | ((long) iZzj2) | jZzj4);
                this.zzf = true;
            }
            jZze = this.zzb.zze((jZzj << c) | ((long) iZzj) | jZzj2);
        } else {
            jZze = 0;
        }
        zzapt zzaptVar = this.zza;
        zzaptVar.zzc(jZze, 4);
        zzaptVar.zzd(zzetVar);
        zzaptVar.zze(false);
    }
}
