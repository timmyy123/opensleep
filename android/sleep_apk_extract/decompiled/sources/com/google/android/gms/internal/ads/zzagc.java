package com.google.android.gms.internal.ads;

import java.io.EOFException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzagc {
    public static void zza(boolean z, String str) throws zzat {
        if (!z) {
            throw zzat.zzb(str, null);
        }
    }

    public static int zzb(zzafz zzafzVar, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int iZzg = zzafzVar.zzg(bArr, i + i3, i2 - i3);
            if (iZzg == -1) {
                break;
            }
            i3 += iZzg;
        }
        return i3;
    }

    public static boolean zzc(zzafz zzafzVar, byte[] bArr, int i, int i2) {
        try {
            zzafzVar.zzc(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zzd(zzafz zzafzVar, int i) {
        try {
            zzafzVar.zzf(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzafz zzafzVar, byte[] bArr, int i, int i2, boolean z) throws EOFException {
        try {
            return zzafzVar.zzh(bArr, 0, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static int zzf(int i) {
        if (i == 20) {
            return 63750;
        }
        if (i == 30) {
            return 2250000;
        }
        switch (i) {
            case 5:
                return 80000;
            case 6:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            default:
                switch (i) {
                    case 14:
                        return 3062500;
                    case 15:
                        return 8000;
                    case 16:
                        return 256000;
                    case 17:
                        return 336000;
                    case 18:
                        return 768000;
                    default:
                        return -2147483647;
                }
        }
    }
}
