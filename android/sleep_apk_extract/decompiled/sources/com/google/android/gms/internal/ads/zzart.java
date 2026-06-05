package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzart {
    private static final byte[] zzb = {0, 0, 0, 0, 16, 0, -128, 0, 0, -86, 0, 56, -101, 113};
    private static final byte[] zzc = {0, 0, 33, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    public static boolean zza(zzafz zzafzVar) {
        zzet zzetVar = new zzet(8);
        int i = zzars.zza(zzafzVar, zzetVar).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        zzafzVar.zzi(zzetVar.zzi(), 0, 4);
        zzetVar.zzh(0);
        int iZzB = zzetVar.zzB();
        if (iZzB == 1463899717) {
            return true;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iZzB).length() + 23);
        sb.append("Unsupported form type: ");
        sb.append(iZzB);
        zzeg.zze("WavHeaderReader", sb.toString());
        return false;
    }

    public static zzarr zzb(zzafz zzafzVar) {
        byte[] bArr;
        int i;
        byte[] bArr2;
        zzet zzetVar = new zzet(16);
        long j = zzd(1718449184, zzafzVar, zzetVar).zzb;
        zzgtj.zzi(j >= 16);
        zzafzVar.zzi(zzetVar.zzi(), 0, 16);
        zzetVar.zzh(0);
        int iZzu = zzetVar.zzu();
        int iZzu2 = zzetVar.zzu();
        int iZzI = zzetVar.zzI();
        int iZzI2 = zzetVar.zzI();
        int iZzu3 = zzetVar.zzu();
        int iZzu4 = zzetVar.zzu();
        int i2 = ((int) j) - 16;
        if (i2 > 0) {
            bArr = new byte[i2];
            zzafzVar.zzi(bArr, 0, i2);
            if (iZzu == 65534) {
                if (i2 == 24) {
                    zzet zzetVar2 = new zzet(bArr);
                    zzetVar2.zzu();
                    int iZzu5 = zzetVar2.zzu();
                    if (iZzu5 != 0 && iZzu5 != iZzu4) {
                        StringBuilder sb = new StringBuilder(String.valueOf(iZzu4).length() + String.valueOf(iZzu5).length() + 33 + 19);
                        Fragment$$ExternalSyntheticOutline1.m(sb, "validBits ( ", iZzu5, ")  != bitsPerSample( ", iZzu4);
                        sb.append(") are not supported");
                        throw zzat.zzc(sb.toString());
                    }
                    int iZzI3 = zzetVar2.zzI();
                    if ((iZzI3 >> 18) != 0) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzI3).length() + 21);
                        sb2.append("invalid channel mask ");
                        sb2.append(iZzI3);
                        throw zzat.zzc(sb2.toString());
                    }
                    if (iZzI3 != 0 && Integer.bitCount(iZzI3) != iZzu2) {
                        int iBitCount = Integer.bitCount(iZzI3);
                        StringBuilder sb3 = new StringBuilder(String.valueOf(iBitCount).length() + 46 + String.valueOf(iZzI3).length());
                        sb3.append("invalid number of channels (");
                        sb3.append(iBitCount);
                        sb3.append(") in channel mask ");
                        sb3.append(iZzI3);
                        throw zzat.zzc(sb3.toString());
                    }
                    iZzu = zzetVar2.zzu();
                    byte[] bArr3 = new byte[14];
                    zzetVar2.zzm(bArr3, 0, 14);
                    if (!Arrays.equals(bArr3, zzb) && !Arrays.equals(bArr3, zzc)) {
                        throw zzat.zzc("invalid wav format extension guid");
                    }
                } else {
                    bArr2 = bArr;
                    i = 65534;
                }
            }
            zzafzVar.zzf((int) (zzafzVar.zzm() - zzafzVar.zzn()));
            return new zzarr(i, iZzu2, iZzI, iZzI2, iZzu3, iZzu4, bArr2);
        }
        bArr = zzfl.zzb;
        i = iZzu;
        bArr2 = bArr;
        zzafzVar.zzf((int) (zzafzVar.zzm() - zzafzVar.zzn()));
        return new zzarr(i, iZzu2, iZzI, iZzI2, iZzu3, iZzu4, bArr2);
    }

    public static Pair zzc(zzafz zzafzVar) {
        zzafzVar.zzl();
        zzars zzarsVarZzd = zzd(1684108385, zzafzVar, new zzet(8));
        zzafzVar.zzf(8);
        return Pair.create(Long.valueOf(zzafzVar.zzn()), Long.valueOf(zzarsVarZzd.zzb));
    }

    private static zzars zzd(int i, zzafz zzafzVar, zzet zzetVar) throws zzat {
        zzars zzarsVarZza = zzars.zza(zzafzVar, zzetVar);
        while (true) {
            int i2 = zzarsVarZza.zza;
            if (i2 == i) {
                return zzarsVarZza;
            }
            zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i2).length() + 28), "Ignoring unknown WAV chunk: ", i2, "WavHeaderReader");
            long j = zzarsVarZza.zzb;
            long j2 = 8 + j;
            if ((1 & j) != 0) {
                j2 = 9 + j;
            }
            if (j2 > 2147483647L) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 40);
                sb.append("Chunk is too large (~2GB+) to skip; id: ");
                sb.append(i2);
                throw zzat.zzc(sb.toString());
            }
            zzafzVar.zzf((int) j2);
            zzarsVarZza = zzars.zza(zzafzVar, zzetVar);
        }
    }
}
