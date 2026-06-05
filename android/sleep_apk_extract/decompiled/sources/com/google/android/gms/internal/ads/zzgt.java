package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgt {
    public final boolean zza;
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final boolean zze;
    public final int zzf;
    public final int zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final byte zzl;
    public final byte zzm;

    /* JADX WARN: Removed duplicated region for block: B:68:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private zzgt(zzgs zzgsVar) {
        byte bZzj;
        boolean zZzi = false;
        zzgtj.zza(zzgsVar.zza == 1);
        int iRemaining = zzgsVar.zzb.remaining();
        byte[] bArr = new byte[iRemaining];
        zzgsVar.zzb.asReadOnlyBuffer().get(bArr);
        zzes zzesVar = new zzes(bArr, iRemaining);
        this.zzg = zzesVar.zzj(3);
        zzesVar.zzg();
        boolean zZzi2 = zzesVar.zzi();
        this.zza = zZzi2;
        if (zZzi2) {
            zzesVar.zzj(5);
            this.zzb = false;
            this.zzh = false;
        } else {
            if (zzesVar.zzi()) {
                zzesVar.zzh(64);
                if (zzesVar.zzi()) {
                    int i = 0;
                    while (!zzesVar.zzi()) {
                        i++;
                    }
                    if (i < 32) {
                        zzesVar.zzh(i);
                    }
                }
                boolean zZzi3 = zzesVar.zzi();
                this.zzb = zZzi3;
                if (zZzi3) {
                    zzesVar.zzh(47);
                }
            } else {
                this.zzb = false;
            }
            this.zzh = zzesVar.zzi();
            int iZzj = zzesVar.zzj(5);
            for (int i2 = 0; i2 <= iZzj; i2++) {
                zzesVar.zzh(12);
                if (i2 == 0) {
                    if (zzesVar.zzj(5) > 7) {
                        zzesVar.zzi();
                    }
                } else if (zzesVar.zzj(5) > 7) {
                    zzesVar.zzg();
                }
                if (this.zzb) {
                    zzesVar.zzg();
                }
                if (this.zzh && zzesVar.zzi()) {
                    if (i2 == 0) {
                        zzesVar.zzj(4);
                    } else {
                        zzesVar.zzh(4);
                    }
                }
            }
        }
        int iZzj2 = zzesVar.zzj(4);
        int iZzj3 = zzesVar.zzj(4);
        zzesVar.zzh(iZzj2 + 1);
        zzesVar.zzh(iZzj3 + 1);
        if (this.zza) {
            this.zzc = false;
        } else {
            boolean zZzi4 = zzesVar.zzi();
            this.zzc = zZzi4;
            if (zZzi4) {
                zzesVar.zzh(4);
                zzesVar.zzh(3);
            }
        }
        zzesVar.zzh(3);
        if (this.zza) {
            this.zze = true;
            this.zzd = true;
            this.zzf = 0;
        } else {
            zzesVar.zzh(4);
            boolean zZzi5 = zzesVar.zzi();
            if (zZzi5) {
                zzesVar.zzh(2);
            }
            if (zzesVar.zzi()) {
                this.zzd = true;
            } else {
                boolean zZzi6 = zzesVar.zzi();
                this.zzd = zZzi6;
                if (!zZzi6) {
                    this.zze = true;
                }
                if (zZzi5) {
                    this.zzf = 0;
                } else {
                    this.zzf = zzesVar.zzj(3) + 1;
                }
            }
            if (zzesVar.zzi()) {
                this.zze = true;
            } else {
                this.zze = zzesVar.zzi();
            }
            if (zZzi5) {
            }
        }
        zzesVar.zzh(3);
        boolean zZzi7 = zzesVar.zzi();
        if (this.zzg == 2 && zZzi7) {
            this.zzi = zzesVar.zzi();
        } else {
            this.zzi = false;
        }
        if (this.zzg != 1) {
            this.zzj = zzesVar.zzi();
        } else {
            this.zzj = false;
        }
        if (zzesVar.zzi()) {
            this.zzl = (byte) zzesVar.zzj(8);
            this.zzm = (byte) zzesVar.zzj(8);
            bZzj = (byte) zzesVar.zzj(8);
        } else {
            this.zzl = (byte) 0;
            this.zzm = (byte) 0;
            bZzj = 0;
        }
        if (this.zzj) {
            zzesVar.zzg();
            this.zzk = false;
        } else if (this.zzl == 1 && this.zzm == 13 && bZzj == 0) {
            this.zzk = false;
        } else {
            zzesVar.zzg();
            int i3 = this.zzg;
            if (i3 == 0) {
                this.zzk = true;
                zZzi = true;
            } else if (i3 == 1) {
                this.zzk = false;
            } else if (this.zzi) {
                boolean zZzi8 = zzesVar.zzi();
                this.zzk = zZzi8;
                if (zZzi8) {
                    zZzi = zzesVar.zzi();
                }
            } else {
                this.zzk = true;
            }
            if (this.zzk && zZzi) {
                zzesVar.zzj(2);
            }
        }
        zzesVar.zzg();
    }

    public static zzgt zza(zzgs zzgsVar) {
        try {
            return new zzgt(zzgsVar);
        } catch (zzgr unused) {
            return null;
        }
    }
}
