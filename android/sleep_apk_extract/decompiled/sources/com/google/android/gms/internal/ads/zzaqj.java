package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzaqj {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zza(zzes zzesVar, zzaqh zzaqhVar) throws zzat {
        long jZzk;
        zzesVar.zze();
        int iZzf = zzf(zzesVar, 3, 8, 8);
        zzaqhVar.zza = iZzf;
        if (iZzf == -1) {
            return false;
        }
        zzgtj.zza(Math.max(Math.max(2, 8), 32) <= 63);
        Math.addExact(Math.addExact(3L, 255L), 4294967296L);
        if (zzesVar.zzc() < 2) {
            jZzk = -1;
        } else {
            jZzk = zzesVar.zzk(2);
            if (jZzk == 3) {
                if (zzesVar.zzc() >= 8) {
                    long jZzk2 = zzesVar.zzk(8);
                    long j = jZzk2 + 3;
                    if (jZzk2 != 255) {
                        jZzk = j;
                    } else if (zzesVar.zzc() >= 32) {
                        jZzk = zzesVar.zzk(32) + j;
                    }
                }
            }
        }
        zzaqhVar.zzb = jZzk;
        if (jZzk == -1) {
            return false;
        }
        if (jZzk > 16) {
            StringBuilder sb = new StringBuilder(String.valueOf(jZzk).length() + 49);
            sb.append("Contains sub-stream with an invalid packet label ");
            sb.append(jZzk);
            throw zzat.zzc(sb.toString());
        }
        if (jZzk == 0) {
            int i = zzaqhVar.zza;
            if (i == 1) {
                throw zzat.zzb("Mpegh3daConfig packet with invalid packet label 0", null);
            }
            if (i == 2) {
                throw zzat.zzb("Mpegh3daFrame packet with invalid packet label 0", null);
            }
            if (i == 17) {
                throw zzat.zzb("AudioTruncation packet with invalid packet label 0", null);
            }
        }
        int iZzf2 = zzf(zzesVar, 11, 24, 24);
        zzaqhVar.zzc = iZzf2;
        return iZzf2 != -1;
    }

    public static zzaqi zzb(zzes zzesVar) throws zzat {
        int iZzj;
        int i;
        char c;
        int i2;
        int i3;
        int iZzj2;
        char c2;
        int iZzj3 = zzesVar.zzj(8);
        int i4 = 5;
        int iZzj4 = zzesVar.zzj(5);
        if (iZzj4 != 31) {
            switch (iZzj4) {
                case 0:
                    iZzj = 96000;
                    break;
                case 1:
                    iZzj = 88200;
                    break;
                case 2:
                    iZzj = 64000;
                    break;
                case 3:
                    iZzj = 48000;
                    break;
                case 4:
                    iZzj = 44100;
                    break;
                case 5:
                    iZzj = 32000;
                    break;
                case 6:
                    iZzj = 24000;
                    break;
                case 7:
                    iZzj = 22050;
                    break;
                case 8:
                    iZzj = 16000;
                    break;
                case 9:
                    iZzj = 12000;
                    break;
                case 10:
                    iZzj = 11025;
                    break;
                case 11:
                    iZzj = 8000;
                    break;
                case 12:
                    iZzj = 7350;
                    break;
                case 13:
                case 14:
                default:
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj4).length() + 32);
                    sb.append("Unsupported sampling rate index ");
                    sb.append(iZzj4);
                    throw zzat.zzc(sb.toString());
                case 15:
                    iZzj = 57600;
                    break;
                case 16:
                    iZzj = 51200;
                    break;
                case 17:
                    iZzj = 40000;
                    break;
                case 18:
                    iZzj = 38400;
                    break;
                case 19:
                    iZzj = 34150;
                    break;
                case 20:
                    iZzj = 28800;
                    break;
                case 21:
                    iZzj = 25600;
                    break;
                case 22:
                    iZzj = 20000;
                    break;
                case 23:
                    iZzj = 19200;
                    break;
                case 24:
                    iZzj = 17075;
                    break;
                case 25:
                    iZzj = 14400;
                    break;
                case 26:
                    iZzj = 12800;
                    break;
                case 27:
                    iZzj = 9600;
                    break;
            }
        } else {
            iZzj = zzesVar.zzj(24);
        }
        int iZzj5 = zzesVar.zzj(3);
        int i5 = 1;
        if (iZzj5 == 0) {
            i = 768;
        } else if (iZzj5 == 1) {
            i = 1024;
        } else if (iZzj5 == 2 || iZzj5 == 3) {
            i = 2048;
        } else {
            if (iZzj5 != 4) {
                StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(iZzj5, 36));
                sb2.append("Unsupported coreSbrFrameLengthIndex ");
                sb2.append(iZzj5);
                throw zzat.zzc(sb2.toString());
            }
            i = 4096;
        }
        if (iZzj5 == 0 || iZzj5 == 1) {
            c = 0;
        } else if (iZzj5 == 2) {
            c = 2;
        } else if (iZzj5 == 3) {
            c = 3;
        } else {
            if (iZzj5 != 4) {
                StringBuilder sb3 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(iZzj5, 36));
                sb3.append("Unsupported coreSbrFrameLengthIndex ");
                sb3.append(iZzj5);
                throw zzat.zzc(sb3.toString());
            }
            c = 1;
        }
        zzesVar.zzh(2);
        zzc(zzesVar);
        int iZzj6 = zzesVar.zzj(5);
        int i6 = 0;
        int iZzf = 0;
        while (true) {
            int i7 = 16;
            if (i6 < iZzj6 + 1) {
                int iZzj7 = zzesVar.zzj(3);
                iZzf += zzf(zzesVar, 5, 8, 16) + 1;
                if ((iZzj7 == 0 || iZzj7 == 2) && zzesVar.zzi()) {
                    zzc(zzesVar);
                }
                i6++;
            } else {
                int iZzf2 = zzf(zzesVar, 4, 8, 16) + 1;
                zzesVar.zzg();
                int i8 = 0;
                while (true) {
                    double d = 2.0d;
                    if (i8 >= iZzf2) {
                        int i9 = iZzj3;
                        byte[] bArr = null;
                        if (zzesVar.zzi()) {
                            int iZzf3 = zzf(zzesVar, 2, 4, 8) + 1;
                            for (int i10 = 0; i10 < iZzf3; i10++) {
                                int iZzf4 = zzf(zzesVar, 4, 8, 16);
                                int iZzf5 = zzf(zzesVar, 4, 8, 16);
                                if (iZzf4 == 7) {
                                    int iZzj8 = zzesVar.zzj(4) + 1;
                                    zzesVar.zzh(4);
                                    byte[] bArr2 = new byte[iZzj8];
                                    for (int i11 = 0; i11 < iZzj8; i11++) {
                                        bArr2[i11] = (byte) zzesVar.zzj(8);
                                    }
                                    bArr = bArr2;
                                } else {
                                    zzesVar.zzh(iZzf5 * 8);
                                }
                            }
                        }
                        byte[] bArr3 = bArr;
                        switch (iZzj) {
                            case 14700:
                            case 16000:
                                d = 3.0d;
                                break;
                            case 22050:
                            case 24000:
                                break;
                            case 29400:
                            case 32000:
                            case 58800:
                            case 64000:
                                d = 1.5d;
                                break;
                            case 44100:
                            case 48000:
                            case 88200:
                            case 96000:
                                d = 1.0d;
                                break;
                            default:
                                StringBuilder sb4 = new StringBuilder(String.valueOf(iZzj).length() + 26);
                                sb4.append("Unsupported sampling rate ");
                                sb4.append(iZzj);
                                throw zzat.zzc(sb4.toString());
                        }
                        return new zzaqi(i9, (int) (((double) iZzj) * d), (int) (((double) i) * d), bArr3, null);
                    }
                    int iZzj9 = zzesVar.zzj(2);
                    if (iZzj9 == 0) {
                        i2 = iZzj3;
                        i3 = i5;
                        zzd(zzesVar);
                        if (c > 0) {
                            zze(zzesVar);
                        }
                    } else if (iZzj9 == i5) {
                        i3 = i5;
                        if (zzd(zzesVar)) {
                            zzesVar.zzg();
                        }
                        if (c > 0) {
                            zze(zzesVar);
                            iZzj2 = zzesVar.zzj(2);
                            c2 = c;
                        } else {
                            iZzj2 = 0;
                            c2 = 0;
                        }
                        if (iZzj2 > 0) {
                            zzesVar.zzh(6);
                            int iZzj10 = zzesVar.zzj(2);
                            zzesVar.zzh(4);
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(i4);
                            }
                            if (iZzj2 == 2 || iZzj2 == 3) {
                                zzesVar.zzh(6);
                            }
                            if (iZzj10 == 2) {
                                zzesVar.zzg();
                            }
                        }
                        i2 = iZzj3;
                        int iFloor = ((int) Math.floor(Math.log(iZzf - 1) / Math.log(2.0d))) + 1;
                        int iZzj11 = zzesVar.zzj(2);
                        if (iZzj11 > 0 && zzesVar.zzi()) {
                            zzesVar.zzh(iFloor);
                        }
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(iFloor);
                        }
                        if (c2 == 0 && iZzj11 == 0) {
                            zzesVar.zzg();
                        }
                    } else if (iZzj9 != 3) {
                        i2 = iZzj3;
                        i3 = i5;
                    } else {
                        zzf(zzesVar, 4, 8, i7);
                        int iZzf6 = zzf(zzesVar, 4, 8, i7);
                        i3 = i5;
                        if (zzesVar.zzi()) {
                            zzf(zzesVar, 8, i7, 0);
                        }
                        zzesVar.zzg();
                        if (iZzf6 > 0) {
                            zzesVar.zzh(iZzf6 * 8);
                        }
                        i2 = iZzj3;
                    }
                    i8++;
                    iZzj3 = i2;
                    i5 = i3;
                    i4 = 5;
                    i7 = 16;
                }
            }
        }
    }

    private static void zzc(zzes zzesVar) {
        int iZzj;
        int iZzj2 = zzesVar.zzj(2);
        if (iZzj2 == 0) {
            zzesVar.zzh(6);
            return;
        }
        int iZzf = zzf(zzesVar, 5, 8, 16) + 1;
        if (iZzj2 == 1) {
            zzesVar.zzh(iZzf * 7);
            return;
        }
        if (iZzj2 == 2) {
            boolean zZzi = zzesVar.zzi();
            int i = true != zZzi ? 5 : 1;
            int i2 = true == zZzi ? 7 : 5;
            int i3 = true == zZzi ? 8 : 6;
            int i4 = 0;
            while (i4 < iZzf) {
                if (zzesVar.zzi()) {
                    zzesVar.zzh(7);
                    iZzj = 0;
                } else {
                    if (zzesVar.zzj(2) == 3 && zzesVar.zzj(i2) * i != 0) {
                        zzesVar.zzg();
                    }
                    iZzj = zzesVar.zzj(i3) * i;
                    if (iZzj != 0 && iZzj != 180) {
                        zzesVar.zzg();
                    }
                    zzesVar.zzg();
                }
                if (iZzj != 0 && iZzj != 180 && zzesVar.zzi()) {
                    i4++;
                }
                i4++;
            }
        }
    }

    private static boolean zzd(zzes zzesVar) {
        zzesVar.zzh(3);
        boolean zZzi = zzesVar.zzi();
        if (zZzi) {
            zzesVar.zzh(13);
        }
        return zZzi;
    }

    private static void zze(zzes zzesVar) {
        zzesVar.zzh(3);
        zzesVar.zzh(8);
        boolean zZzi = zzesVar.zzi();
        boolean zZzi2 = zzesVar.zzi();
        if (zZzi) {
            zzesVar.zzh(5);
        }
        if (zZzi2) {
            zzesVar.zzh(6);
        }
    }

    private static int zzf(zzes zzesVar, int i, int i2, int i3) {
        zzgtj.zza(Math.max(Math.max(i, i2), i3) <= 31);
        int i4 = (1 << i) - 1;
        int i5 = (1 << i2) - 1;
        Math.addExact(Math.addExact(i4, i5), 1 << i3);
        if (zzesVar.zzc() < i) {
            return -1;
        }
        int iZzj = zzesVar.zzj(i);
        if (iZzj == i4) {
            if (zzesVar.zzc() < i2) {
                return -1;
            }
            int iZzj2 = zzesVar.zzj(i2);
            iZzj += iZzj2;
            if (iZzj2 == i5) {
                if (zzesVar.zzc() < i3) {
                    return -1;
                }
                return zzesVar.zzj(i3) + iZzj;
            }
        }
        return iZzj;
    }
}
