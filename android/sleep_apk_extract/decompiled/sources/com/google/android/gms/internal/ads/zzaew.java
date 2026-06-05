package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaew {
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzaev zza(byte[] bArr) {
        return zzb(new zzes(bArr, bArr.length), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c4, code lost:
    
        if (r12 != 3) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzaev zzb(zzes zzesVar, boolean z) throws zzat {
        int i;
        int iZzc = zzc(zzesVar);
        int iZzd = zzd(zzesVar);
        int iZzj = zzesVar.zzj(4);
        String strM = zzba$$ExternalSyntheticOutline0.m(iZzc, "mp4a.40.", new StringBuilder(String.valueOf(iZzc).length() + 8));
        if (iZzc == 5 || iZzc == 29) {
            iZzd = zzd(zzesVar);
            iZzc = zzc(zzesVar);
            if (iZzc == 22) {
                iZzj = zzesVar.zzj(4);
            }
        }
        if (z) {
            int i2 = 3;
            if (iZzc != 1 && iZzc != 2 && iZzc != 3 && iZzc != 4 && iZzc != 6 && iZzc != 7 && iZzc != 17) {
                switch (iZzc) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        StringBuilder sb = new StringBuilder(String.valueOf(iZzc).length() + 31);
                        sb.append("Unsupported audio object type: ");
                        sb.append(iZzc);
                        throw zzat.zzc(sb.toString());
                }
            }
            if (zzesVar.zzi()) {
                zzeg.zzc("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (zzesVar.zzi()) {
                zzesVar.zzh(14);
            }
            boolean zZzi = zzesVar.zzi();
            if (iZzj == 0) {
                Home$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            if (iZzc == 6) {
                zzesVar.zzh(3);
                if (zZzi) {
                    if (iZzc == 22) {
                        zzesVar.zzh(16);
                        i = 22;
                    } else {
                        i = iZzc;
                    }
                    if (i == 17 || i == 19 || i == 20 || i == 23) {
                        zzesVar.zzh(3);
                    }
                    zzesVar.zzh(1);
                }
                switch (iZzc) {
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        int iZzj2 = zzesVar.zzj(2);
                        if (iZzj2 == 2) {
                            i2 = iZzj2;
                        }
                        StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(i2, 22));
                        sb2.append("Unsupported epConfig: ");
                        sb2.append(i2);
                        throw zzat.zzc(sb2.toString());
                }
            }
            if (iZzc == 20) {
                iZzc = 20;
                zzesVar.zzh(3);
            }
            if (zZzi) {
            }
            switch (iZzc) {
            }
        }
        int i3 = zzc[iZzj];
        if (i3 != -1) {
            return new zzaev(iZzd, i3, strM, null);
        }
        throw zzat.zzb(null, null);
    }

    private static int zzc(zzes zzesVar) {
        int iZzj = zzesVar.zzj(5);
        return iZzj == 31 ? zzesVar.zzj(6) + 32 : iZzj;
    }

    private static int zzd(zzes zzesVar) throws zzat {
        int iZzj = zzesVar.zzj(4);
        if (iZzj == 15) {
            if (zzesVar.zzc() >= 24) {
                return zzesVar.zzj(24);
            }
            throw zzat.zzb("AAC header insufficient data", null);
        }
        if (iZzj < 13) {
            return zzb[iZzj];
        }
        throw zzat.zzb("AAC header wrong Sampling Frequency Index", null);
    }
}
