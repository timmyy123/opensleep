package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzagg {
    public static boolean zza(zzet zzetVar, zzagl zzaglVar, int i, zzagf zzagfVar) {
        int iZzg = zzetVar.zzg();
        long jZzz = zzetVar.zzz();
        long j = jZzz >>> 16;
        if (j != i) {
            return false;
        }
        boolean z = (j & 1) == 1;
        long j2 = jZzz >> 12;
        long j3 = jZzz >> 8;
        long j4 = jZzz >> 4;
        long j5 = jZzz >> 1;
        long j6 = jZzz & 1;
        int i2 = (int) (j4 & 15);
        if (i2 <= 7) {
            if (i2 != zzaglVar.zzg - 1) {
                return false;
            }
        } else if (i2 > 10 || zzaglVar.zzg != 2) {
            return false;
        }
        int i3 = (int) (j5 & 7);
        if ((i3 != 0 && i3 != zzaglVar.zzi) || j6 == 1 || !zzd(zzetVar, zzaglVar, z, zzagfVar)) {
            return false;
        }
        long j7 = zzagfVar.zza;
        int iZzc = zzc(zzetVar, (int) (j2 & 15));
        long j8 = zzaglVar.zzj;
        boolean z2 = j8 == 0 || j7 + ((long) iZzc) >= j8;
        if (iZzc == -1) {
            return false;
        }
        if ((!z2 && iZzc < zzaglVar.zza) || iZzc > zzaglVar.zzb) {
            return false;
        }
        int i4 = zzaglVar.zze;
        int i5 = (int) (j3 & 15);
        if (i5 != 0) {
            if (i5 <= 11) {
                if (i5 != zzaglVar.zzf) {
                    return false;
                }
            } else if (i5 == 12) {
                if (zzetVar.zzs() * 1000 != i4) {
                    return false;
                }
            } else {
                if (i5 > 14) {
                    return false;
                }
                int iZzt = zzetVar.zzt();
                if (i5 == 14) {
                    iZzt *= 10;
                }
                if (iZzt != i4) {
                    return false;
                }
            }
        }
        if (zzetVar.zzs() != zzfl.zzL(zzetVar.zzi(), iZzg, zzetVar.zzg() - 1, 0)) {
            return false;
        }
        if (zzetVar.zzd() != 0) {
            int iZzn = zzetVar.zzn();
            if ((iZzn & 128) != 0) {
                return false;
            }
            int i6 = (iZzn & 126) >> 1;
            if ((i6 >= 2 && i6 <= 7) || (i6 >= 13 && i6 <= 31)) {
                StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + 57);
                sb.append("Ignoring frame where first subframe has a reserved type: ");
                sb.append(i6);
                zzeg.zzb("FlacFrameReader", sb.toString());
                return false;
            }
        }
        return true;
    }

    public static long zzb(zzafz zzafzVar, zzagl zzaglVar) throws zzat {
        zzafzVar.zzl();
        zzafzVar.zzk(1);
        byte[] bArr = new byte[1];
        zzafzVar.zzi(bArr, 0, 1);
        int i = bArr[0] & 1;
        boolean z = 1 == i;
        zzafzVar.zzk(2);
        int i2 = 1 != i ? 6 : 7;
        zzet zzetVar = new zzet(i2);
        zzetVar.zzf(zzagc.zzb(zzafzVar, zzetVar.zzi(), 0, i2));
        zzafzVar.zzl();
        zzagf zzagfVar = new zzagf();
        if (zzd(zzetVar, zzaglVar, z, zzagfVar)) {
            return zzagfVar.zza;
        }
        throw zzat.zzb(null, null);
    }

    public static int zzc(zzet zzetVar, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzetVar.zzs() + 1;
            case 7:
                return zzetVar.zzt() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    private static boolean zzd(zzet zzetVar, zzagl zzaglVar, boolean z, zzagf zzagfVar) {
        try {
            long jZzO = zzetVar.zzO();
            if (!z) {
                jZzO *= (long) zzaglVar.zzb;
            }
            long j = zzaglVar.zzj;
            if (j != 0 && jZzO > j) {
                return false;
            }
            zzagfVar.zza = jZzO;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
