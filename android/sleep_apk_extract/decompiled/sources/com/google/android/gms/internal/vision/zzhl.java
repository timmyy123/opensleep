package com.google.android.gms.internal.vision;

import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzhl {
    public static int zza(int i, byte[] bArr, int i2, int i3, zzlx zzlxVar, zzhn zzhnVar) {
        if ((i >>> 3) == 0) {
            throw zzjk.zzd();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzb = zzb(bArr, i2, zzhnVar);
            zzlxVar.zza(i, Long.valueOf(zzhnVar.zzb));
            return iZzb;
        }
        if (i4 == 1) {
            zzlxVar.zza(i, Long.valueOf(zzb(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzhnVar);
            int i5 = zzhnVar.zza;
            if (i5 < 0) {
                throw zzjk.zzb();
            }
            if (i5 > bArr.length - iZza) {
                throw zzjk.zza();
            }
            if (i5 == 0) {
                zzlxVar.zza(i, zzht.zza);
            } else {
                zzlxVar.zza(i, zzht.zza(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzjk.zzd();
            }
            zzlxVar.zza(i, Integer.valueOf(zza(bArr, i2)));
            return i2 + 4;
        }
        zzlx zzlxVarZzb = zzlx.zzb();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzhnVar);
            i7 = zzhnVar.zza;
            if (i7 == i6) {
                i2 = iZza2;
                break;
            }
            i2 = zza(i7, bArr, iZza2, i3, zzlxVarZzb, zzhnVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzjk.zzg();
        }
        zzlxVar.zza(i, zzlxVarZzb);
        return i2;
    }

    public static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int zzc(byte[] bArr, int i, zzhn zzhnVar) {
        int iZza = zza(bArr, i, zzhnVar);
        int i2 = zzhnVar.zza;
        if (i2 < 0) {
            throw zzjk.zzb();
        }
        if (i2 == 0) {
            zzhnVar.zzc = "";
            return iZza;
        }
        zzhnVar.zzc = new String(bArr, iZza, i2, zzjf.zza);
        return iZza + i2;
    }

    public static int zzd(byte[] bArr, int i, zzhn zzhnVar) {
        int iZza = zza(bArr, i, zzhnVar);
        int i2 = zzhnVar.zza;
        if (i2 < 0) {
            throw zzjk.zzb();
        }
        if (i2 == 0) {
            zzhnVar.zzc = "";
            return iZza;
        }
        zzhnVar.zzc = zzmd.zzb(bArr, iZza, i2);
        return iZza + i2;
    }

    public static int zze(byte[] bArr, int i, zzhn zzhnVar) {
        int iZza = zza(bArr, i, zzhnVar);
        int i2 = zzhnVar.zza;
        if (i2 < 0) {
            throw zzjk.zzb();
        }
        if (i2 > bArr.length - iZza) {
            throw zzjk.zza();
        }
        if (i2 == 0) {
            zzhnVar.zzc = zzht.zza;
            return iZza;
        }
        zzhnVar.zzc = zzht.zza(bArr, iZza, i2);
        return iZza + i2;
    }

    public static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    public static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    public static int zzb(byte[] bArr, int i, zzhn zzhnVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzhnVar.zzb = j;
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
        zzhnVar.zzb = j2;
        return i3;
    }

    public static int zza(int i, byte[] bArr, int i2, zzhn zzhnVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzhnVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzhnVar.zza = i5 | (b2 << MqttWireMessage.MESSAGE_TYPE_DISCONNECT);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzhnVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzhnVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzhnVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zza(zzlc zzlcVar, byte[] bArr, int i, int i2, zzhn zzhnVar) {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzhnVar);
            i3 = zzhnVar.zza;
        }
        int i4 = iZza;
        if (i3 >= 0 && i3 <= i2 - i4) {
            Object objZza = zzlcVar.zza();
            int i5 = i4 + i3;
            zzlcVar.zza(objZza, bArr, i4, i5, zzhnVar);
            zzlcVar.zzc(objZza);
            zzhnVar.zzc = objZza;
            return i5;
        }
        throw zzjk.zza();
    }

    public static int zza(zzlc zzlcVar, byte[] bArr, int i, int i2, int i3, zzhn zzhnVar) {
        zzko zzkoVar = (zzko) zzlcVar;
        Object objZza = zzkoVar.zza();
        int iZza = zzkoVar.zza(objZza, bArr, i, i2, i3, zzhnVar);
        zzkoVar.zzc(objZza);
        zzhnVar.zzc = objZza;
        return iZza;
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzjl<?> zzjlVar, zzhn zzhnVar) {
        zzjd zzjdVar = (zzjd) zzjlVar;
        int iZza = zza(bArr, i2, zzhnVar);
        zzjdVar.zzc(zzhnVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzhnVar);
            if (i != zzhnVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzhnVar);
            zzjdVar.zzc(zzhnVar.zza);
        }
        return iZza;
    }

    public static int zza(byte[] bArr, int i, zzjl<?> zzjlVar, zzhn zzhnVar) {
        zzjd zzjdVar = (zzjd) zzjlVar;
        int iZza = zza(bArr, i, zzhnVar);
        int i2 = zzhnVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzhnVar);
            zzjdVar.zzc(zzhnVar.zza);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzjk.zza();
    }

    public static int zza(zzlc<?> zzlcVar, int i, byte[] bArr, int i2, int i3, zzjl<?> zzjlVar, zzhn zzhnVar) {
        int iZza = zza(zzlcVar, bArr, i2, i3, zzhnVar);
        zzjlVar.add(zzhnVar.zzc);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzhnVar);
            if (i != zzhnVar.zza) {
                break;
            }
            iZza = zza(zzlcVar, bArr, iZza2, i3, zzhnVar);
            zzjlVar.add(zzhnVar.zzc);
        }
        return iZza;
    }

    public static int zza(byte[] bArr, int i, zzhn zzhnVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzhnVar.zza = b;
            return i2;
        }
        return zza(b, bArr, i2, zzhnVar);
    }
}
