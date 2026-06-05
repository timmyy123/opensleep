package com.google.android.gms.internal.measurement;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzach {
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i, zzacg zzacgVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzacgVar);
        }
        zzacgVar.zza = b;
        return i2;
    }

    public static int zzb(int i, byte[] bArr, int i2, zzacg zzacgVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzacgVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzacgVar.zza = i5 | (b2 << MqttWireMessage.MESSAGE_TYPE_DISCONNECT);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzacgVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzacgVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzacgVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzc(byte[] bArr, int i, zzacg zzacgVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzacgVar.zzb = j;
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
        zzacgVar.zzb = j2;
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

    public static int zzf(byte[] bArr, int i, zzacg zzacgVar) {
        int iZza = zza(bArr, i, zzacgVar);
        int i2 = zzacgVar.zza;
        if (i2 < 0) {
            Gson$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i2 == 0) {
            zzacgVar.zzc = "";
            return iZza;
        }
        zzacgVar.zzc = zzagl.zzd(bArr, iZza, i2);
        return iZza + i2;
    }

    public static int zzg(byte[] bArr, int i, zzacg zzacgVar) {
        int iZza = zza(bArr, i, zzacgVar);
        int i2 = zzacgVar.zza;
        if (i2 < 0) {
            Gson$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i2 > bArr.length - iZza) {
            Gson$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        if (i2 == 0) {
            zzacgVar.zzc = zzacr.zza;
            return iZza;
        }
        zzacgVar.zzc = zzacr.zzj(bArr, iZza, i2);
        return iZza + i2;
    }

    public static int zzh(zzafp zzafpVar, byte[] bArr, int i, int i2, zzacg zzacgVar) {
        Object objZza = zzafpVar.zza();
        int iZzj = zzj(objZza, zzafpVar, bArr, i, i2, zzacgVar);
        zzafpVar.zzk(objZza);
        zzacgVar.zzc = objZza;
        return iZzj;
    }

    public static int zzi(zzafp zzafpVar, byte[] bArr, int i, int i2, int i3, zzacg zzacgVar) {
        Object objZza = zzafpVar.zza();
        int iZzk = zzk(objZza, zzafpVar, bArr, i, i2, i3, zzacgVar);
        zzafpVar.zzk(objZza);
        zzacgVar.zzc = objZza;
        return iZzk;
    }

    public static int zzj(Object obj, zzafp zzafpVar, byte[] bArr, int i, int i2, zzacg zzacgVar) {
        int iZzb = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzb = zzb(i3, bArr, iZzb, zzacgVar);
            i3 = zzacgVar.zza;
        }
        int i4 = iZzb;
        if (i3 < 0 || i3 > i2 - i4) {
            Gson$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        int i5 = zzacgVar.zze + 1;
        zzacgVar.zze = i5;
        zzq(i5);
        int i6 = i4 + i3;
        zzafpVar.zzj(obj, bArr, i4, i6, zzacgVar);
        zzacgVar.zze--;
        zzacgVar.zzc = obj;
        return i6;
    }

    public static int zzk(Object obj, zzafp zzafpVar, byte[] bArr, int i, int i2, int i3, zzacg zzacgVar) {
        int i4 = zzacgVar.zze + 1;
        zzacgVar.zze = i4;
        zzq(i4);
        int iZzi = ((zzaff) zzafpVar).zzi(obj, bArr, i, i2, i3, zzacgVar);
        zzacgVar.zze--;
        zzacgVar.zzc = obj;
        return iZzi;
    }

    public static int zzl(int i, byte[] bArr, int i2, int i3, zzaef zzaefVar, zzacg zzacgVar) {
        zzadv zzadvVar = (zzadv) zzaefVar;
        int iZza = zza(bArr, i2, zzacgVar);
        zzadvVar.zzh(zzacgVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzacgVar);
            if (i != zzacgVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzacgVar);
            zzadvVar.zzh(zzacgVar.zza);
        }
        return iZza;
    }

    public static int zzm(byte[] bArr, int i, zzaef zzaefVar, zzacg zzacgVar) {
        zzadv zzadvVar = (zzadv) zzaefVar;
        int iZza = zza(bArr, i, zzacgVar);
        int i2 = zzacgVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzacgVar);
            zzadvVar.zzh(zzacgVar.zza);
        }
        if (iZza == i2) {
            return iZza;
        }
        Gson$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int zzn(zzafp zzafpVar, int i, byte[] bArr, int i2, int i3, zzaef zzaefVar, zzacg zzacgVar) {
        int iZzh = zzh(zzafpVar, bArr, i2, i3, zzacgVar);
        zzaefVar.add(zzacgVar.zzc);
        while (iZzh < i3) {
            int iZza = zza(bArr, iZzh, zzacgVar);
            if (i != zzacgVar.zza) {
                break;
            }
            iZzh = zzh(zzafpVar, bArr, iZza, i3, zzacgVar);
            zzaefVar.add(zzacgVar.zzc);
        }
        return iZzh;
    }

    public static int zzo(int i, byte[] bArr, int i2, int i3, zzaga zzagaVar, zzacg zzacgVar) {
        if ((i >>> 3) == 0) {
            Gson$$ExternalSyntheticBUOutline0.m$1("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzc = zzc(bArr, i2, zzacgVar);
            zzagaVar.zzk(i, Long.valueOf(zzacgVar.zzb));
            return iZzc;
        }
        if (i4 == 1) {
            zzagaVar.zzk(i, Long.valueOf(zze(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzacgVar);
            int i5 = zzacgVar.zza;
            if (i5 < 0) {
                Gson$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                return 0;
            }
            if (i5 > bArr.length - iZza) {
                Gson$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return 0;
            }
            if (i5 == 0) {
                zzagaVar.zzk(i, zzacr.zza);
            } else {
                zzagaVar.zzk(i, zzacr.zzj(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzagaVar.zzk(i, Integer.valueOf(zzd(bArr, i2)));
                return i2 + 4;
            }
            Gson$$ExternalSyntheticBUOutline0.m$1("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i6 = (i & (-8)) | 4;
        zzaga zzagaVarZzb = zzaga.zzb();
        int i7 = zzacgVar.zze + 1;
        zzacgVar.zze = i7;
        zzq(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzacgVar);
            int i9 = zzacgVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZza2;
                break;
            }
            i2 = zzo(i9, bArr, iZza2, i3, zzagaVarZzb, zzacgVar);
            i8 = i9;
        }
        zzacgVar.zze--;
        if (i2 > i3 || i8 != i6) {
            Gson$$ExternalSyntheticBUOutline0.m$1("Failed to parse the message.");
            return 0;
        }
        zzagaVar.zzk(i, zzagaVarZzb);
        return i2;
    }

    public static int zzp(int i, byte[] bArr, int i2, int i3, zzacg zzacgVar) {
        if ((i >>> 3) == 0) {
            Gson$$ExternalSyntheticBUOutline0.m$1("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzc(bArr, i2, zzacgVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zza(bArr, i2, zzacgVar) + zzacgVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            Gson$$ExternalSyntheticBUOutline0.m$1("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zza(bArr, i2, zzacgVar);
            i6 = zzacgVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzp(i6, bArr, i2, i3, zzacgVar);
        }
        if (i2 <= i3 && i6 == i5) {
            return i2;
        }
        Gson$$ExternalSyntheticBUOutline0.m$1("Failed to parse the message.");
        return 0;
    }

    private static void zzq(int i) throws zzaeh {
        if (i < zzb) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m$1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }
}
