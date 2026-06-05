package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
final class zzarm implements zzarn {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzagb zzc;
    private final zzahk zzd;
    private final zzarr zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzet zzh;
    private final int zzi;
    private final zzv zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzarm(zzagb zzagbVar, zzahk zzahkVar, zzarr zzarrVar) throws zzat {
        this.zzc = zzagbVar;
        this.zzd = zzahkVar;
        this.zze = zzarrVar;
        int iMax = Math.max(1, zzarrVar.zzc / 10);
        this.zzi = iMax;
        zzet zzetVar = new zzet(zzarrVar.zzf);
        zzetVar.zzu();
        int iZzu = zzetVar.zzu();
        this.zzf = iZzu;
        int i = zzarrVar.zzb;
        int i2 = zzarrVar.zzd;
        int iM$1 = Fragment$$ExternalSyntheticOutline1.m$1(i2 - (i * 4), 8, zzarrVar.zze * i, 1);
        if (iZzu != iM$1) {
            throw zzat.zzb(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iM$1).length() + 34 + String.valueOf(iZzu).length()), iM$1, "Expected frames per block: ", iZzu, "; got: "), null);
        }
        String str = zzfl.zza;
        int i3 = ((iMax + iZzu) - 1) / iZzu;
        this.zzg = new byte[i2 * i3];
        this.zzh = new zzet((iZzu + iZzu) * i * i3);
        int i4 = ((zzarrVar.zzc * zzarrVar.zzd) * 8) / iZzu;
        zzt zztVar = new zzt();
        zztVar.zzo("audio/raw");
        zztVar.zzi(i4);
        zztVar.zzj(i4);
        zztVar.zzp((iMax + iMax) * i);
        zztVar.zzG(zzarrVar.zzb);
        zztVar.zzH(zzarrVar.zzc);
        zztVar.zzI(2);
        this.zzj = zztVar.zzO();
    }

    private final void zzd(int i) {
        long jZzv = this.zzl + zzfl.zzv(this.zzn, 1000000L, this.zze.zzc, RoundingMode.DOWN);
        int iZzf = zzf(i);
        this.zzd.zze(jZzv, 1, iZzf, this.zzm - iZzf, null);
        this.zzn += (long) i;
        this.zzm -= iZzf;
    }

    private final int zze(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zzf(int i) {
        return (i + i) * this.zze.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final void zza(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final void zzb(int i, long j) {
        zzaru zzaruVar = new zzaru(this.zze, this.zzf, i, j);
        this.zzc.zzw(zzaruVar);
        zzahk zzahkVar = this.zzd;
        zzahkVar.zzA(this.zzj);
        zzahkVar.zzO(zzaruVar.zza());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003c -> B:4:0x0021). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzarn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzc(zzafz zzafzVar, long j) {
        int iZze;
        int iZze2 = zze(this.zzm);
        int i = this.zzi;
        String str = zzfl.zza;
        int i2 = this.zzf;
        zzarr zzarrVar = this.zze;
        int i3 = zzarrVar.zzd;
        int i4 = ((((i - iZze2) + i2) - 1) / i2) * i3;
        boolean z = j == 0;
        while (!z) {
            if (this.zzk >= i4) {
                break;
            }
            int iZza = zzafzVar.zza(this.zzg, this.zzk, (int) Math.min(i4 - r12, j));
            if (iZza == -1) {
                while (!z) {
                }
            } else {
                this.zzk += iZza;
            }
        }
        int i5 = this.zzk / i3;
        if (i5 > 0) {
            byte[] bArr = this.zzg;
            zzet zzetVar = this.zzh;
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = 0;
                while (true) {
                    int i8 = zzarrVar.zzb;
                    if (i7 < i8) {
                        byte[] bArrZzi = zzetVar.zzi();
                        int i9 = (i3 / i8) - 4;
                        int i10 = (i7 * 4) + (i6 * i3);
                        int i11 = bArr[i10 + 1] & 255;
                        int i12 = bArr[i10] & 255;
                        int i13 = i5;
                        int iMin = Math.min(bArr[i10 + 2] & 255, 88);
                        int[] iArr = zzb;
                        int i14 = iArr[iMin];
                        int i15 = (i6 * i2 * i8) + i7;
                        int iMax = (short) (i12 | (i11 << 8));
                        int i16 = i15 + i15;
                        bArrZzi[i16] = (byte) (iMax & PHIpAddressSearchManager.END_IP_SCAN);
                        bArrZzi[i16 + 1] = (byte) (iMax >> 8);
                        int i17 = 0;
                        while (i17 < i9 + i9) {
                            byte b = bArr[((i17 / 8) * i8 * 4) + (i8 * 4) + i10 + ((i17 / 2) % 4)];
                            int i18 = i17;
                            int i19 = i18 % 2 == 0 ? b & 15 : (b & 255) >> 4;
                            int i20 = i19 & 7;
                            int i21 = (((i20 + i20) + 1) * i14) >> 3;
                            if ((i19 & 8) != 0) {
                                i21 = -i21;
                            }
                            iMax = Math.max(-32768, Math.min(iMax + i21, 32767));
                            i16 = i8 + i8 + i16;
                            bArrZzi[i16] = (byte) (iMax & PHIpAddressSearchManager.END_IP_SCAN);
                            bArrZzi[i16 + 1] = (byte) (iMax >> 8);
                            iMin = Math.max(0, Math.min(iMin + zza[i19], 88));
                            i14 = iArr[iMin];
                            i17 = i18 + 1;
                        }
                        i7++;
                        i5 = i13;
                    }
                }
            }
            int i22 = i5;
            int iZzf = zzf(i2 * i22);
            zzetVar.zzh(0);
            zzetVar.zzf(iZzf);
            this.zzk -= i22 * i3;
            int iZze3 = zzetVar.zze();
            this.zzd.zzc(zzetVar, iZze3);
            int i23 = this.zzm + iZze3;
            this.zzm = i23;
            if (zze(i23) >= i) {
                zzd(i);
            }
        }
        if (z && (iZze = zze(this.zzm)) > 0) {
            zzd(iZze);
        }
        return z;
    }
}
