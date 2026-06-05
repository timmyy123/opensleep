package com.google.android.gms.internal.serialization;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzwh {
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i, zzwg zzwgVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzwgVar);
        }
        zzwgVar.zza = b;
        return i2;
    }

    public static int zzb(int i, byte[] bArr, int i2, zzwg zzwgVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzwgVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzwgVar.zza = i5 | (b2 << MqttWireMessage.MESSAGE_TYPE_DISCONNECT);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzwgVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzwgVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzwgVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzc(byte[] bArr, int i, zzwg zzwgVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzwgVar.zzb = j;
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
        zzwgVar.zzb = j2;
        return i3;
    }

    public static int zzd(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static long zze(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public static int zzf(byte[] bArr, int i, zzwg zzwgVar) throws zzzv {
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza;
        if (i2 < 0) {
            Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i2 == 0) {
            zzwgVar.zzc = "";
            return iZza;
        }
        zzwgVar.zzc = new String(bArr, iZza, i2, zzzt.zza);
        return iZza + i2;
    }

    public static int zzg(byte[] bArr, int i, zzwg zzwgVar) throws zzzv {
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza;
        if (i2 < 0) {
            Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i2 == 0) {
            zzwgVar.zzc = "";
            return iZza;
        }
        zzwgVar.zzc = zzacd.zze(bArr, iZza, i2);
        return iZza + i2;
    }

    public static int zzh(byte[] bArr, int i, zzwg zzwgVar) throws zzzv {
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza;
        if (i2 < 0) {
            Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i2 > bArr.length - iZza) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        if (i2 == 0) {
            zzwgVar.zzc = zzwr.zzb;
            return iZza;
        }
        zzwgVar.zzc = zzwr.zzl(bArr, iZza, i2);
        return iZza + i2;
    }

    public static int zzi(zzabe zzabeVar, byte[] bArr, int i, int i2, zzwg zzwgVar) throws zzzv {
        Object objZza = zzabeVar.zza();
        int iZzk = zzk(objZza, zzabeVar, bArr, i, i2, zzwgVar);
        zzabeVar.zzk(objZza);
        zzwgVar.zzc = objZza;
        return iZzk;
    }

    public static int zzj(zzabe zzabeVar, byte[] bArr, int i, int i2, int i3, zzwg zzwgVar) throws zzzv {
        Object objZza = zzabeVar.zza();
        int iZzl = zzl(objZza, zzabeVar, bArr, i, i2, i3, zzwgVar);
        zzabeVar.zzk(objZza);
        zzwgVar.zzc = objZza;
        return iZzl;
    }

    public static int zzk(Object obj, zzabe zzabeVar, byte[] bArr, int i, int i2, zzwg zzwgVar) throws zzzv {
        int iZzb = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzb = zzb(i3, bArr, iZzb, zzwgVar);
            i3 = zzwgVar.zza;
        }
        int i4 = iZzb;
        if (i3 < 0 || i3 > i2 - i4) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        int i5 = zzwgVar.zze + 1;
        zzwgVar.zze = i5;
        zzz(i5);
        int i6 = i4 + i3;
        zzabeVar.zzj(obj, bArr, i4, i6, zzwgVar);
        zzwgVar.zze--;
        zzwgVar.zzc = obj;
        return i6;
    }

    public static int zzl(Object obj, zzabe zzabeVar, byte[] bArr, int i, int i2, int i3, zzwg zzwgVar) throws zzzv {
        int i4 = zzwgVar.zze + 1;
        zzwgVar.zze = i4;
        zzz(i4);
        int iZzi = ((zzaat) zzabeVar).zzi(obj, bArr, i, i2, i3, zzwgVar);
        zzwgVar.zze--;
        zzwgVar.zzc = obj;
        return iZzi;
    }

    public static int zzm(int i, byte[] bArr, int i2, int i3, zzzs zzzsVar, zzwg zzwgVar) {
        zzzh zzzhVar = (zzzh) zzzsVar;
        int iZza = zza(bArr, i2, zzwgVar);
        zzzhVar.zzi(zzwgVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzwgVar);
            if (i != zzwgVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzwgVar);
            zzzhVar.zzi(zzwgVar.zza);
        }
        return iZza;
    }

    public static int zzn(byte[] bArr, int i, zzzs zzzsVar, zzwg zzwgVar) throws zzzv {
        zzzh zzzhVar = (zzzh) zzzsVar;
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzwgVar);
            zzzhVar.zzi(zzwgVar.zza);
        }
        if (iZza == i2) {
            return iZza;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzo(byte[] bArr, int i, zzzs zzzsVar, zzwg zzwgVar) throws zzzv {
        zzaae zzaaeVar = (zzaae) zzzsVar;
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza + iZza;
        while (iZza < i2) {
            iZza = zzc(bArr, iZza, zzwgVar);
            zzaaeVar.zzd(zzwgVar.zzb);
        }
        if (iZza == i2) {
            return iZza;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzp(byte[] bArr, int i, zzzs zzzsVar, zzwg zzwgVar) throws zzzv {
        zzzh zzzhVar = (zzzh) zzzsVar;
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza;
        int i3 = iZza + i2;
        if (i3 > bArr.length) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        zzzhVar.zzj((i2 / 4) + zzzhVar.size());
        while (iZza < i3) {
            zzzhVar.zzi(zzd(bArr, iZza));
            iZza += 4;
        }
        if (iZza == i3) {
            return iZza;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzq(byte[] bArr, int i, zzzs zzzsVar, zzwg zzwgVar) throws zzzv {
        zzaae zzaaeVar = (zzaae) zzzsVar;
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza;
        int i3 = iZza + i2;
        if (i3 > bArr.length) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        zzaaeVar.zzi((i2 / 8) + zzaaeVar.size());
        while (iZza < i3) {
            zzaaeVar.zzd(zze(bArr, iZza));
            iZza += 8;
        }
        if (iZza == i3) {
            return iZza;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzr(byte[] bArr, int i, zzzs zzzsVar, zzwg zzwgVar) throws zzzv {
        zzyw zzywVar = (zzyw) zzzsVar;
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza;
        int i3 = iZza + i2;
        if (i3 > bArr.length) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        zzywVar.zzi((i2 / 4) + zzywVar.size());
        while (iZza < i3) {
            zzywVar.zzg(Float.intBitsToFloat(zzd(bArr, iZza)));
            iZza += 4;
        }
        if (iZza == i3) {
            return iZza;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzs(byte[] bArr, int i, zzzs zzzsVar, zzwg zzwgVar) throws zzzv {
        zzyj zzyjVar = (zzyj) zzzsVar;
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza;
        int i3 = iZza + i2;
        if (i3 > bArr.length) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        zzyjVar.zzi((i2 / 8) + zzyjVar.size());
        while (iZza < i3) {
            zzyjVar.zzg(Double.longBitsToDouble(zze(bArr, iZza)));
            iZza += 8;
        }
        if (iZza == i3) {
            return iZza;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzt(byte[] bArr, int i, zzzs zzzsVar, zzwg zzwgVar) throws zzzv {
        zzwi zzwiVar = (zzwi) zzzsVar;
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza + iZza;
        while (true) {
            boolean z = false;
            if (iZza >= i2) {
                break;
            }
            iZza = zzc(bArr, iZza, zzwgVar);
            if (zzwgVar.zzb != 0) {
                z = true;
            }
            zzwiVar.zzg(z);
        }
        if (iZza == i2) {
            return iZza;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzu(byte[] bArr, int i, zzzs zzzsVar, zzwg zzwgVar) throws zzzv {
        zzzh zzzhVar = (zzzh) zzzsVar;
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzwgVar);
            zzzhVar.zzi(zzwv.zzP(zzwgVar.zza));
        }
        if (iZza == i2) {
            return iZza;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzv(byte[] bArr, int i, zzzs zzzsVar, zzwg zzwgVar) throws zzzv {
        zzaae zzaaeVar = (zzaae) zzzsVar;
        int iZza = zza(bArr, i, zzwgVar);
        int i2 = zzwgVar.zza + iZza;
        while (iZza < i2) {
            iZza = zzc(bArr, iZza, zzwgVar);
            zzaaeVar.zzd(zzwv.zzQ(zzwgVar.zzb));
        }
        if (iZza == i2) {
            return iZza;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzw(zzabe zzabeVar, int i, byte[] bArr, int i2, int i3, zzzs zzzsVar, zzwg zzwgVar) throws zzzv {
        int iZzi = zzi(zzabeVar, bArr, i2, i3, zzwgVar);
        zzzsVar.add(zzwgVar.zzc);
        while (iZzi < i3) {
            int iZza = zza(bArr, iZzi, zzwgVar);
            if (i != zzwgVar.zza) {
                break;
            }
            iZzi = zzi(zzabeVar, bArr, iZza, i3, zzwgVar);
            zzzsVar.add(zzwgVar.zzc);
        }
        return iZzi;
    }

    public static int zzx(int i, byte[] bArr, int i2, int i3, zzabs zzabsVar, zzwg zzwgVar) throws zzzv {
        if ((i >>> 3) == 0) {
            Gson$$ExternalSyntheticBUOutline0.m("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzc = zzc(bArr, i2, zzwgVar);
            zzabsVar.zzk(i, Long.valueOf(zzwgVar.zzb));
            return iZzc;
        }
        if (i4 == 1) {
            zzabsVar.zzk(i, Long.valueOf(zze(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzwgVar);
            int i5 = zzwgVar.zza;
            if (i5 < 0) {
                Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                return 0;
            }
            if (i5 > bArr.length - iZza) {
                Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return 0;
            }
            if (i5 == 0) {
                zzabsVar.zzk(i, zzwr.zzb);
            } else {
                zzabsVar.zzk(i, zzwr.zzl(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzabsVar.zzk(i, Integer.valueOf(zzd(bArr, i2)));
                return i2 + 4;
            }
            Gson$$ExternalSyntheticBUOutline0.m("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i6 = (i & (-8)) | 4;
        zzabs zzabsVarZzb = zzabs.zzb();
        int i7 = zzwgVar.zze + 1;
        zzwgVar.zze = i7;
        zzz(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzwgVar);
            int i9 = zzwgVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZza2;
                break;
            }
            i2 = zzx(i9, bArr, iZza2, i3, zzabsVarZzb, zzwgVar);
            i8 = i9;
        }
        zzwgVar.zze--;
        if (i2 > i3 || i8 != i6) {
            Gson$$ExternalSyntheticBUOutline0.m("Failed to parse the message.");
            return 0;
        }
        zzabsVar.zzk(i, zzabsVarZzb);
        return i2;
    }

    public static int zzy(int i, byte[] bArr, int i2, int i3, zzwg zzwgVar) throws zzzv {
        if ((i >>> 3) == 0) {
            Gson$$ExternalSyntheticBUOutline0.m("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzc(bArr, i2, zzwgVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zza(bArr, i2, zzwgVar) + zzwgVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            Gson$$ExternalSyntheticBUOutline0.m("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zza(bArr, i2, zzwgVar);
            i6 = zzwgVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzy(i6, bArr, i2, i3, zzwgVar);
        }
        if (i2 <= i3 && i6 == i5) {
            return i2;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Failed to parse the message.");
        return 0;
    }

    private static void zzz(int i) throws zzzv {
        if (i < zzb) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }
}
