package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaqs implements zzafy {
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private long zzh;
    private zzaqo zzi;
    private zzagb zzj;
    private boolean zzk;
    private final zzfi zza = new zzfi(0);
    private final zzet zzc = new zzet(4096);
    private final SparseArray zzb = new SparseArray();
    private final zzaqp zzd = new zzaqp();

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws EOFException, InterruptedIOException {
        byte[] bArr = new byte[14];
        zzafp zzafpVar = (zzafp) zzafzVar;
        zzafpVar.zzh(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzafpVar.zzj(bArr[13] & 7, false);
        zzafpVar.zzh(bArr, 0, 3, false);
        return ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255)) == 1;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzj = zzagbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x012e  */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) {
        zzapt zzapvVar;
        zzagb zzagbVar = this.zzj;
        zzagbVar.getClass();
        long jZzo = zzafzVar.zzo();
        if (jZzo != -1) {
            zzaqp zzaqpVar = this.zzd;
            if (!zzaqpVar.zza()) {
                return zzaqpVar.zzc(zzafzVar, zzagyVar);
            }
        }
        if (!this.zzk) {
            this.zzk = true;
            zzaqp zzaqpVar2 = this.zzd;
            if (zzaqpVar2.zzd() != -9223372036854775807L) {
                zzaqo zzaqoVar = new zzaqo(zzaqpVar2.zzb(), zzaqpVar2.zzd(), jZzo);
                this.zzi = zzaqoVar;
                this.zzj.zzw(zzaqoVar.zza());
            } else {
                zzagbVar.zzw(new zzaha(zzaqpVar2.zzd(), 0L));
            }
        }
        zzaqo zzaqoVar2 = this.zzi;
        if (zzaqoVar2 != null && zzaqoVar2.zzc()) {
            return zzaqoVar2.zzd(zzafzVar, zzagyVar);
        }
        zzafzVar.zzl();
        long jZzm = jZzo != -1 ? jZzo - zzafzVar.zzm() : -1L;
        if (jZzm != -1 && jZzm < 4) {
            return -1;
        }
        zzet zzetVar = this.zzc;
        if (!zzafzVar.zzh(zzetVar.zzi(), 0, 4, true)) {
            return -1;
        }
        zzetVar.zzh(0);
        int iZzB = zzetVar.zzB();
        if (iZzB == 441) {
            return -1;
        }
        if (iZzB == 442) {
            zzafzVar.zzi(zzetVar.zzi(), 0, 10);
            zzetVar.zzh(9);
            zzafzVar.zzf((zzetVar.zzs() & 7) + 14);
            return 0;
        }
        if (iZzB == 443) {
            zzafzVar.zzi(zzetVar.zzi(), 0, 2);
            zzetVar.zzh(0);
            zzafzVar.zzf(zzetVar.zzt() + 6);
            return 0;
        }
        if ((iZzB >> 8) != 1) {
            zzafzVar.zzf(1);
            return 0;
        }
        int i = iZzB & PHIpAddressSearchManager.END_IP_SCAN;
        SparseArray sparseArray = this.zzb;
        zzaqq zzaqqVar = (zzaqq) sparseArray.get(i);
        if (!this.zze) {
            if (zzaqqVar == null) {
                zzapt zzaptVar = null;
                if (i == 189) {
                    zzapvVar = new zzapj(null, 0, "video/mp2p");
                    this.zzf = true;
                    this.zzh = zzafzVar.zzn();
                } else if ((iZzB & 224) == 192) {
                    zzapvVar = new zzaqf(null, 0, "video/mp2p");
                    this.zzf = true;
                    this.zzh = zzafzVar.zzn();
                } else {
                    if ((iZzB & 240) == 224) {
                        zzapvVar = new zzapv(null, "video/mp2p");
                        this.zzg = true;
                        this.zzh = zzafzVar.zzn();
                    }
                    if (zzaptVar != null) {
                        zzaptVar.zzb(this.zzj, new zzarh(Integer.MIN_VALUE, i, 256));
                        zzaqqVar = new zzaqq(zzaptVar, this.zza);
                        sparseArray.put(i, zzaqqVar);
                    }
                }
                zzaptVar = zzapvVar;
                if (zzaptVar != null) {
                }
            }
            long j = 1048576;
            if (this.zzf && this.zzg) {
                j = 8192 + this.zzh;
            }
            if (zzafzVar.zzn() > j) {
                this.zze = true;
                this.zzj.zzv();
            }
        }
        zzafzVar.zzi(zzetVar.zzi(), 0, 2);
        zzetVar.zzh(0);
        int iZzt = zzetVar.zzt() + 6;
        if (zzaqqVar == null) {
            zzafzVar.zzf(iZzt);
        } else {
            zzetVar.zza(iZzt);
            zzafzVar.zzc(zzetVar.zzi(), 0, iZzt);
            zzetVar.zzh(6);
            zzaqqVar.zzb(zzetVar);
            zzetVar.zzf(zzetVar.zzj());
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zze(long j, long j2) {
        zzfi zzfiVar = this.zza;
        if (zzfiVar.zzc() != -9223372036854775807L) {
            long jZza = zzfiVar.zza();
            if (jZza != -9223372036854775807L && jZza != 0 && jZza != j2) {
                zzfiVar.zzd(j2);
            }
        }
        zzaqo zzaqoVar = this.zzi;
        int i = 0;
        if (zzaqoVar != null) {
            zzaqoVar.zzb(j2);
        }
        while (true) {
            SparseArray sparseArray = this.zzb;
            if (i >= sparseArray.size()) {
                return;
            }
            ((zzaqq) sparseArray.valueAt(i)).zza();
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
