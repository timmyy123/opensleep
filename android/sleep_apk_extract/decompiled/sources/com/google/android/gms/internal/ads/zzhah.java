package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhah extends zzhai {
    public static int zza(long j) {
        int i = (int) j;
        zzgtj.zze(((long) i) == j, "Out of range: %s", j);
        return i;
    }

    public static int zzb(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static int zzc(int i, int i2, int i3) {
        zzgtj.zzg(true, "min (%s) must be less than or equal to max (%s)", i2, 1073741823);
        return Math.min(Math.max(i, i2), 1073741823);
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        zzgtj.zzg(length >= 4, "array too small: %s < %s", length, 4);
        return zze(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int zze(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    public static int[] zzf(Collection collection) {
        if (collection instanceof zzhag) {
            zzhag zzhagVar = (zzhag) collection;
            return Arrays.copyOfRange(zzhagVar.zza, zzhagVar.zzb, zzhagVar.zzc);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            obj.getClass();
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static List zzg(int... iArr) {
        int length = iArr.length;
        return length == 0 ? Collections.EMPTY_LIST : new zzhag(iArr, 0, length);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Integer zzh(String str, int i) {
        Long lValueOf;
        str.getClass();
        if (str.isEmpty()) {
            lValueOf = null;
        } else {
            char cCharAt = str.charAt(0);
            int i2 = cCharAt == '-' ? 1 : 0;
            if (i2 != str.length()) {
                int i3 = i2 + 1;
                int iZza = zzhaj.zza(str.charAt(i2));
                if (iZza >= 0 && iZza < 10) {
                    long j = -iZza;
                    while (true) {
                        if (i3 < str.length()) {
                            int i4 = i3 + 1;
                            int iZza2 = zzhaj.zza(str.charAt(i3));
                            if (iZza2 < 0 || iZza2 >= 10 || j < -922337203685477580L) {
                                break;
                            }
                            long j2 = j * 10;
                            long j3 = iZza2;
                            if (j2 < Long.MIN_VALUE + j3) {
                                break;
                            }
                            j = j2 - j3;
                            i3 = i4;
                        } else if (cCharAt == '-') {
                            lValueOf = Long.valueOf(j);
                        } else {
                            if (j == Long.MIN_VALUE) {
                                break;
                            }
                            lValueOf = Long.valueOf(-j);
                        }
                    }
                    lValueOf = null;
                }
            }
        }
        if (lValueOf == null || lValueOf.longValue() != lValueOf.intValue()) {
            return null;
        }
        return Integer.valueOf(lValueOf.intValue());
    }

    public static /* synthetic */ int zzi(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }
}
