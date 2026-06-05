package com.google.android.gms.internal.aicore;

import com.google.android.gms.internal.ads.zzbuy$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzds {
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i, zzdr zzdrVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzdrVar);
        }
        zzdrVar.zza = b;
        return i2;
    }

    public static int zzb(int i, byte[] bArr, int i2, zzdr zzdrVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzdrVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzdrVar.zza = i5 | (b2 << MqttWireMessage.MESSAGE_TYPE_DISCONNECT);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdrVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdrVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdrVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzc(byte[] bArr, int i, zzdr zzdrVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzdrVar.zzb = j;
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
        zzdrVar.zzb = j2;
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

    public static int zzf(byte[] bArr, int i, zzdr zzdrVar) throws zzfi {
        int iZza = zza(bArr, i, zzdrVar);
        int i2 = zzdrVar.zza;
        if (i2 < 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m$2("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i2 > bArr.length - iZza) {
            zzbuy$$ExternalSyntheticBUOutline0.m$2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        if (i2 == 0) {
            zzdrVar.zzc = zzeb.zzb;
            return iZza;
        }
        zzdrVar.zzc = zzeb.zzg(bArr, iZza, i2);
        return iZza + i2;
    }

    public static int zzg(zzgk zzgkVar, byte[] bArr, int i, int i2, zzdr zzdrVar) throws zzfi {
        Object objZza = zzgkVar.zza();
        int iZzi = zzi(objZza, zzgkVar, bArr, i, i2, zzdrVar);
        zzgkVar.zzh(objZza);
        zzdrVar.zzc = objZza;
        return iZzi;
    }

    public static int zzh(zzgk zzgkVar, byte[] bArr, int i, int i2, int i3, zzdr zzdrVar) throws zzfi {
        Object objZza = zzgkVar.zza();
        int iZzj = zzj(objZza, zzgkVar, bArr, i, i2, i3, zzdrVar);
        zzgkVar.zzh(objZza);
        zzdrVar.zzc = objZza;
        return iZzj;
    }

    public static int zzi(Object obj, zzgk zzgkVar, byte[] bArr, int i, int i2, zzdr zzdrVar) throws zzfi {
        int iZzb = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzb = zzb(i3, bArr, iZzb, zzdrVar);
            i3 = zzdrVar.zza;
        }
        int i4 = iZzb;
        if (i3 < 0 || i3 > i2 - i4) {
            zzbuy$$ExternalSyntheticBUOutline0.m$2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        int i5 = zzdrVar.zze + 1;
        zzdrVar.zze = i5;
        zzo(i5);
        int i6 = i4 + i3;
        zzgkVar.zzg(obj, bArr, i4, i6, zzdrVar);
        zzdrVar.zze--;
        zzdrVar.zzc = obj;
        return i6;
    }

    public static int zzj(Object obj, zzgk zzgkVar, byte[] bArr, int i, int i2, int i3, zzdr zzdrVar) throws zzfi {
        int i4 = zzdrVar.zze + 1;
        zzdrVar.zze = i4;
        zzo(i4);
        int iZzf = ((zzgd) zzgkVar).zzf(obj, bArr, i, i2, i3, zzdrVar);
        zzdrVar.zze--;
        zzdrVar.zzc = obj;
        return iZzf;
    }

    public static int zzk(int i, byte[] bArr, int i2, int i3, zzfg zzfgVar, zzdr zzdrVar) {
        if (zzfgVar != null) {
            throw new ClassCastException();
        }
        zza(bArr, i2, zzdrVar);
        int i4 = zzdrVar.zza;
        throw null;
    }

    public static int zzl(byte[] bArr, int i, zzfg zzfgVar, zzdr zzdrVar) throws zzfi {
        if (zzfgVar != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return 0;
        }
        int iZza = zza(bArr, i, zzdrVar);
        int i2 = zzdrVar.zza + iZza;
        if (iZza < i2) {
            zza(bArr, iZza, zzdrVar);
            throw null;
        }
        if (iZza == i2) {
            return iZza;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzm(zzgk zzgkVar, int i, byte[] bArr, int i2, int i3, zzfg zzfgVar, zzdr zzdrVar) throws zzfi {
        int iZzg = zzg(zzgkVar, bArr, i2, i3, zzdrVar);
        zzfgVar.add(zzdrVar.zzc);
        while (iZzg < i3) {
            int iZza = zza(bArr, iZzg, zzdrVar);
            if (i != zzdrVar.zza) {
                break;
            }
            iZzg = zzg(zzgkVar, bArr, iZza, i3, zzdrVar);
            zzfgVar.add(zzdrVar.zzc);
        }
        return iZzg;
    }

    public static int zzn(int i, byte[] bArr, int i2, int i3, zzgw zzgwVar, zzdr zzdrVar) throws zzfi {
        if ((i >>> 3) == 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m$2("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzc = zzc(bArr, i2, zzdrVar);
            zzgwVar.zzg(i, Long.valueOf(zzdrVar.zzb));
            return iZzc;
        }
        if (i4 == 1) {
            zzgwVar.zzg(i, Long.valueOf(zze(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzdrVar);
            int i5 = zzdrVar.zza;
            if (i5 < 0) {
                zzbuy$$ExternalSyntheticBUOutline0.m$2("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                return 0;
            }
            if (i5 > bArr.length - iZza) {
                zzbuy$$ExternalSyntheticBUOutline0.m$2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return 0;
            }
            if (i5 == 0) {
                zzgwVar.zzg(i, zzeb.zzb);
            } else {
                zzgwVar.zzg(i, zzeb.zzg(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzgwVar.zzg(i, Integer.valueOf(zzd(bArr, i2)));
                return i2 + 4;
            }
            zzbuy$$ExternalSyntheticBUOutline0.m$2("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i6 = (i & (-8)) | 4;
        zzgw zzgwVarZzb = zzgw.zzb();
        int i7 = zzdrVar.zze + 1;
        zzdrVar.zze = i7;
        zzo(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzdrVar);
            int i9 = zzdrVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZza2;
                break;
            }
            i2 = zzn(i9, bArr, iZza2, i3, zzgwVarZzb, zzdrVar);
            i8 = i9;
        }
        zzdrVar.zze--;
        if (i2 > i3 || i8 != i6) {
            zzbuy$$ExternalSyntheticBUOutline0.m$2("Failed to parse the message.");
            return 0;
        }
        zzgwVar.zzg(i, zzgwVarZzb);
        return i2;
    }

    private static void zzo(int i) throws zzfi {
        if (i < zzb) {
            return;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$2("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }
}
