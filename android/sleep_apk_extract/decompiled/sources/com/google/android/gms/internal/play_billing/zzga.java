package com.google.android.gms.internal.play_billing;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzga {
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i, zzfz zzfzVar) throws zzhr {
        int iZzh = zzh(bArr, i, zzfzVar);
        int i2 = zzfzVar.zza;
        if (i2 < 0) {
            Gson$$ExternalSyntheticBUOutline0.m$2("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i2 > bArr.length - iZzh) {
            Gson$$ExternalSyntheticBUOutline0.m$2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        if (i2 == 0) {
            zzfzVar.zzc = zzgk.zzb;
            return iZzh;
        }
        zzfzVar.zzc = zzgk.zzj(bArr, iZzh, i2);
        return iZzh + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int zzc(zzix zzixVar, byte[] bArr, int i, int i2, int i3, zzfz zzfzVar) throws zzhr {
        Object objZze = zzixVar.zze();
        int iZzl = zzl(objZze, zzixVar, bArr, i, i2, i3, zzfzVar);
        zzixVar.zzf(objZze);
        zzfzVar.zzc = objZze;
        return iZzl;
    }

    public static int zzd(zzix zzixVar, byte[] bArr, int i, int i2, zzfz zzfzVar) throws zzhr {
        Object objZze = zzixVar.zze();
        int iZzm = zzm(objZze, zzixVar, bArr, i, i2, zzfzVar);
        zzixVar.zzf(objZze);
        zzfzVar.zzc = objZze;
        return iZzm;
    }

    public static int zze(zzix zzixVar, int i, byte[] bArr, int i2, int i3, zzho zzhoVar, zzfz zzfzVar) throws zzhr {
        int iZzd = zzd(zzixVar, bArr, i2, i3, zzfzVar);
        zzhoVar.add(zzfzVar.zzc);
        while (iZzd < i3) {
            int iZzh = zzh(bArr, iZzd, zzfzVar);
            if (i != zzfzVar.zza) {
                break;
            }
            iZzd = zzd(zzixVar, bArr, iZzh, i3, zzfzVar);
            zzhoVar.add(zzfzVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zzho zzhoVar, zzfz zzfzVar) throws zzhr {
        zzhl zzhlVar = (zzhl) zzhoVar;
        int iZzh = zzh(bArr, i, zzfzVar);
        int i2 = zzfzVar.zza + iZzh;
        while (iZzh < i2) {
            iZzh = zzh(bArr, iZzh, zzfzVar);
            zzhlVar.zzg(zzfzVar.zza);
        }
        if (iZzh == i2) {
            return iZzh;
        }
        Gson$$ExternalSyntheticBUOutline0.m$2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzg(int i, byte[] bArr, int i2, int i3, zzjk zzjkVar, zzfz zzfzVar) throws zzhr {
        if ((i >>> 3) == 0) {
            Gson$$ExternalSyntheticBUOutline0.m$2("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzk = zzk(bArr, i2, zzfzVar);
            zzjkVar.zzj(i, Long.valueOf(zzfzVar.zzb));
            return iZzk;
        }
        if (i4 == 1) {
            zzjkVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzh = zzh(bArr, i2, zzfzVar);
            int i5 = zzfzVar.zza;
            if (i5 < 0) {
                Gson$$ExternalSyntheticBUOutline0.m$2("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                return 0;
            }
            if (i5 > bArr.length - iZzh) {
                Gson$$ExternalSyntheticBUOutline0.m$2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return 0;
            }
            if (i5 == 0) {
                zzjkVar.zzj(i, zzgk.zzb);
            } else {
                zzjkVar.zzj(i, zzgk.zzj(bArr, iZzh, i5));
            }
            return iZzh + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzjkVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            }
            Gson$$ExternalSyntheticBUOutline0.m$2("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i6 = (i & (-8)) | 4;
        zzjk zzjkVarZzf = zzjk.zzf();
        int i7 = zzfzVar.zze + 1;
        zzfzVar.zze = i7;
        zzo(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzh2 = zzh(bArr, i2, zzfzVar);
            int i9 = zzfzVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZzh2;
                break;
            }
            i2 = zzg(i9, bArr, iZzh2, i3, zzjkVarZzf, zzfzVar);
            i8 = i9;
        }
        zzfzVar.zze--;
        if (i2 > i3 || i8 != i6) {
            Gson$$ExternalSyntheticBUOutline0.m$2("Failed to parse the message.");
            return 0;
        }
        zzjkVar.zzj(i, zzjkVarZzf);
        return i2;
    }

    public static int zzh(byte[] bArr, int i, zzfz zzfzVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzfzVar);
        }
        zzfzVar.zza = b;
        return i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, zzfz zzfzVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzfzVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzfzVar.zza = i5 | (b2 << MqttWireMessage.MESSAGE_TYPE_DISCONNECT);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzfzVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzfzVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzfzVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzj(int i, byte[] bArr, int i2, int i3, zzho zzhoVar, zzfz zzfzVar) {
        zzhl zzhlVar = (zzhl) zzhoVar;
        int iZzh = zzh(bArr, i2, zzfzVar);
        zzhlVar.zzg(zzfzVar.zza);
        while (iZzh < i3) {
            int iZzh2 = zzh(bArr, iZzh, zzfzVar);
            if (i != zzfzVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzfzVar);
            zzhlVar.zzg(zzfzVar.zza);
        }
        return iZzh;
    }

    public static int zzk(byte[] bArr, int i, zzfz zzfzVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzfzVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzfzVar.zzb = j2;
        return i3;
    }

    public static int zzl(Object obj, zzix zzixVar, byte[] bArr, int i, int i2, int i3, zzfz zzfzVar) throws zzhr {
        int i4 = zzfzVar.zze + 1;
        zzfzVar.zze = i4;
        zzo(i4);
        int iZzc = ((zzip) zzixVar).zzc(obj, bArr, i, i2, i3, zzfzVar);
        zzfzVar.zze--;
        zzfzVar.zzc = obj;
        return iZzc;
    }

    public static int zzm(Object obj, zzix zzixVar, byte[] bArr, int i, int i2, zzfz zzfzVar) throws zzhr {
        int iZzi = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzi = zzi(i3, bArr, iZzi, zzfzVar);
            i3 = zzfzVar.zza;
        }
        int i4 = iZzi;
        if (i3 < 0 || i3 > i2 - i4) {
            Gson$$ExternalSyntheticBUOutline0.m$2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        int i5 = zzfzVar.zze + 1;
        zzfzVar.zze = i5;
        zzo(i5);
        int i6 = i4 + i3;
        zzixVar.zzh(obj, bArr, i4, i6, zzfzVar);
        zzfzVar.zze--;
        zzfzVar.zzc = obj;
        return i6;
    }

    public static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zzo(int i) throws zzhr {
        if (i < zzb) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m$2("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }
}
