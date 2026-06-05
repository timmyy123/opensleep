package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzafb {
    private static final int[] zzb = {AdError.CACHE_ERROR_CODE, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARN: Removed duplicated region for block: B:145:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0292 A[PHI: r1 r5 r8
      0x0292: PHI (r1v4 int) = (r1v3 int), (r1v56 int) binds: [B:176:0x0294, B:169:0x026a] A[DONT_GENERATE, DONT_INLINE]
      0x0292: PHI (r5v3 int) = (r5v2 int), (r5v17 int) binds: [B:176:0x0294, B:169:0x026a] A[DONT_GENERATE, DONT_INLINE]
      0x0292: PHI (r8v3 int) = (r8v2 int), (r8v37 int) binds: [B:176:0x0294, B:169:0x026a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x037f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzv zza(zzet zzetVar, String str, String str2, zzq zzqVar) throws zzat {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean zZzi;
        int i7;
        int iZzj;
        int iZzj2;
        int iZzj3;
        int i8;
        boolean z;
        int i9;
        int i10;
        int i11;
        int i12;
        zzes zzesVar = new zzes();
        zzesVar.zza(zzetVar);
        int iZzc = zzesVar.zzc();
        int iZzj4 = zzesVar.zzj(3);
        if (iZzj4 > 1) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzj4).length() + 30);
            sb.append("Unsupported AC-4 DSI version: ");
            sb.append(iZzj4);
            throw zzat.zzc(sb.toString());
        }
        int iZzj5 = zzesVar.zzj(7);
        int i13 = true != zzesVar.zzi() ? 44100 : 48000;
        zzesVar.zzh(4);
        int iZzj6 = zzesVar.zzj(9);
        if (iZzj5 > 1) {
            if (iZzj4 == 0) {
                throw zzat.zzc("Invalid AC-4 DSI version: 0");
            }
            if (zzesVar.zzi()) {
                zzesVar.zzh(16);
                if (zzesVar.zzi()) {
                    zzesVar.zzh(128);
                }
            }
        }
        if (iZzj4 == 1) {
            if (!zzg(zzesVar)) {
                throw zzat.zzc("Invalid AC-4 DSI bitrate.");
            }
            zzesVar.zzm();
        }
        zzaez zzaezVar = new zzaez(null);
        for (int i14 = 0; i14 < iZzj6; i14++) {
            if (iZzj4 == 0) {
                zZzi = zzesVar.zzi();
                i7 = 8;
                iZzj = zzesVar.zzj(5);
                iZzj2 = zzesVar.zzj(5);
                iZzj3 = 0;
                i8 = 0;
                z = false;
            } else {
                int iZzj7 = zzesVar.zzj(8);
                iZzj3 = zzesVar.zzj(8);
                i7 = 8;
                if (iZzj3 == 255) {
                    iZzj3 = zzesVar.zzj(16) + PHIpAddressSearchManager.END_IP_SCAN;
                }
                if (iZzj7 > 2) {
                    zzesVar.zzh(iZzj3 * 8);
                } else {
                    int iZzc2 = (iZzc - zzesVar.zzc()) / 8;
                    iZzj = zzesVar.zzj(5);
                    iZzj2 = iZzj7;
                    z = iZzj == 31;
                    i8 = iZzc2;
                    zZzi = false;
                }
            }
            zzaezVar.zzf = iZzj2;
            if (zZzi || z || iZzj != 6) {
                zzaezVar.zzg = zzesVar.zzj(3);
                if (zzesVar.zzi()) {
                    zzesVar.zzh(5);
                }
                zzesVar.zzh(2);
                if (iZzj4 == 1) {
                    if (iZzj2 == 1) {
                        zzesVar.zzh(2);
                    } else if (iZzj2 == 2) {
                        iZzj2 = 2;
                        zzesVar.zzh(2);
                    }
                    if (zzaezVar.zza) {
                        int i15 = zzaezVar.zzc;
                        int i16 = zzaezVar.zzg;
                        if (i15 > 0) {
                            i6 = i15 + 1;
                            if (i16 == 4 && i6 == 17) {
                                i6 = 21;
                            }
                        } else {
                            if (i16 == 0) {
                                i5 = 2;
                            } else if (i16 != 1) {
                                i5 = 2;
                                if (i16 == 2) {
                                    i6 = i;
                                } else if (i16 == 3) {
                                    i6 = 10;
                                } else if (i16 != 4) {
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(i16).length() + 33);
                                    sb2.append("AC-4 level ");
                                    sb2.append(i16);
                                    sb2.append(" has not been defined.");
                                    zzeg.zzc("Ac4Util", sb2.toString());
                                } else {
                                    i6 = 12;
                                }
                            } else {
                                i6 = 6;
                            }
                            i6 = i5;
                        }
                    } else {
                        int i17 = zzaezVar.zzb;
                        boolean z2 = zzaezVar.zzd;
                        int i18 = zzaezVar.zze;
                        switch (i17) {
                            case 0:
                                i4 = 1;
                                break;
                            case 1:
                                i4 = 2;
                                break;
                            case 2:
                                i4 = 3;
                                break;
                            case 3:
                                i4 = i2;
                                break;
                            case 4:
                                i4 = 6;
                                break;
                            case 5:
                            case 7:
                            case 9:
                                i4 = i3;
                                break;
                            case 6:
                            case 8:
                            case 10:
                                i4 = i;
                                break;
                            case 11:
                                i4 = 11;
                                break;
                            case 12:
                                i4 = 12;
                                break;
                            case 13:
                                i4 = 13;
                                break;
                            case 14:
                                i4 = 14;
                                break;
                            case 15:
                                i4 = 24;
                                break;
                        }
                        if (i17 == 11 || i17 == 12 || i17 == 13 || i17 == 14) {
                            if (!z2) {
                                i4 -= 2;
                            }
                            i6 = i4;
                            if (i18 == 0) {
                                i6 -= 4;
                            } else if (i18 == 1) {
                                i6 -= 2;
                            }
                        } else {
                            i6 = i4;
                        }
                    }
                    if (i6 > 0) {
                        throw zzat.zzc("Cannot determine channel count of presentation.");
                    }
                    Object[] objArr = {Integer.valueOf(iZzj5), Integer.valueOf(zzaezVar.zzf), Integer.valueOf(zzaezVar.zzg)};
                    String str3 = zzfl.zza;
                    String str4 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr);
                    zzt zztVar = new zzt();
                    zztVar.zza(str);
                    zztVar.zzo("audio/ac4");
                    zztVar.zzG(i6);
                    zztVar.zzH(i13);
                    zztVar.zzs(zzqVar);
                    zztVar.zze(str2);
                    zztVar.zzk(str4);
                    return zztVar.zzO();
                }
                zzesVar.zzh(5);
                zzesVar.zzh(10);
                if (iZzj4 == 1) {
                    if (iZzj2 > 0) {
                        zzaezVar.zza = zzesVar.zzi();
                    }
                    if (zzaezVar.zza) {
                        if (iZzj2 != 1) {
                            i10 = 2;
                            if (iZzj2 == 2) {
                                i12 = 2;
                            } else {
                                i9 = iZzc;
                                i12 = iZzj2;
                                zzesVar.zzh(24);
                                i11 = 1;
                            }
                        } else {
                            i12 = 1;
                        }
                        i9 = iZzc;
                        int iZzj8 = zzesVar.zzj(5);
                        if (iZzj8 >= 0 && iZzj8 <= 15) {
                            zzaezVar.zzb = iZzj8;
                        }
                        if (iZzj8 < 11 || iZzj8 > 14) {
                            i10 = 2;
                        } else {
                            zzaezVar.zzd = zzesVar.zzi();
                            i10 = 2;
                            zzaezVar.zze = zzesVar.zzj(2);
                        }
                        zzesVar.zzh(24);
                        i11 = 1;
                    } else {
                        i9 = iZzc;
                        i10 = 2;
                        i11 = 1;
                        i12 = iZzj2;
                    }
                    if (iZzj2 == i11 || iZzj2 == i10) {
                        if (zzesVar.zzi() && zzesVar.zzi()) {
                            zzesVar.zzh(i10);
                        }
                        if (zzesVar.zzi()) {
                            zzesVar.zzg();
                            int i19 = i7;
                            int iZzj9 = zzesVar.zzj(i19);
                            int i20 = 0;
                            while (i20 < iZzj9) {
                                zzesVar.zzh(i19);
                                i20++;
                                i19 = 8;
                            }
                        }
                    }
                    iZzj2 = i12;
                } else {
                    i9 = iZzc;
                }
                if (!zZzi && !z) {
                    zzesVar.zzg();
                    if (iZzj == 0 || iZzj == 1 || iZzj == 2) {
                        if (iZzj2 == 0) {
                            for (int i21 = 0; i21 < 2; i21++) {
                                zzd(zzesVar, zzaezVar);
                            }
                            iZzj2 = 0;
                            zzesVar.zzg();
                            if (!zzesVar.zzi()) {
                            }
                            if (iZzj2 <= 0) {
                            }
                        } else {
                            for (int i22 = 0; i22 < 2; i22++) {
                                zze(zzesVar, zzaezVar);
                            }
                            zzesVar.zzg();
                            if (!zzesVar.zzi()) {
                            }
                            if (iZzj2 <= 0) {
                            }
                        }
                    } else if (iZzj != 3 && iZzj != 4) {
                        if (iZzj != 5) {
                            int iZzj10 = zzesVar.zzj(7);
                            for (int i23 = 0; i23 < iZzj10; i23++) {
                                zzesVar.zzh(8);
                            }
                        } else if (iZzj2 == 0) {
                            zzd(zzesVar, zzaezVar);
                            iZzj2 = 0;
                        } else {
                            int iZzj11 = zzesVar.zzj(3);
                            for (int i24 = 0; i24 < iZzj11 + 2; i24++) {
                                zze(zzesVar, zzaezVar);
                            }
                        }
                        zzesVar.zzg();
                        if (!zzesVar.zzi()) {
                        }
                        if (iZzj2 <= 0) {
                        }
                    } else if (iZzj2 == 0) {
                        for (int i25 = 0; i25 < 3; i25++) {
                            zzd(zzesVar, zzaezVar);
                        }
                        iZzj2 = 0;
                        zzesVar.zzg();
                        if (!zzesVar.zzi()) {
                        }
                        if (iZzj2 <= 0) {
                        }
                    } else {
                        for (int i26 = 0; i26 < 3; i26++) {
                            zze(zzesVar, zzaezVar);
                        }
                        zzesVar.zzg();
                        if (!zzesVar.zzi()) {
                        }
                        if (iZzj2 <= 0) {
                        }
                    }
                } else if (iZzj2 == 0) {
                    zzd(zzesVar, zzaezVar);
                    iZzj2 = 0;
                    zzesVar.zzg();
                    if (!zzesVar.zzi()) {
                        i3 = 7;
                    }
                    if (iZzj2 <= 0) {
                        i = 8;
                        i2 = 5;
                        zzesVar.zzm();
                        if (iZzj4 == 1) {
                            int iZzc3 = ((i9 - zzesVar.zzc()) / i) - i8;
                            if (iZzj3 < iZzc3) {
                                throw zzat.zzc("pres_bytes is smaller than presentation bytes read.");
                            }
                            zzesVar.zzo(iZzj3 - iZzc3);
                        }
                        if (zzaezVar.zza) {
                            i4 = -1;
                        } else {
                            i4 = -1;
                            if (zzaezVar.zzb == -1) {
                                StringBuilder sb3 = new StringBuilder(String.valueOf(i14).length() + 45);
                                sb3.append("Can't determine channel mode of presentation ");
                                sb3.append(i14);
                                throw zzat.zzc(sb3.toString());
                            }
                        }
                    } else {
                        if (zzesVar.zzi() && !zzg(zzesVar)) {
                            throw zzat.zzc("Can't parse bitrate DSI.");
                        }
                        if (zzesVar.zzi()) {
                            zzesVar.zzm();
                            zzesVar.zzo(zzesVar.zzj(16));
                            i2 = 5;
                            int iZzj12 = zzesVar.zzj(5);
                            for (int i27 = 0; i27 < iZzj12; i27++) {
                                zzesVar.zzh(3);
                                zzesVar.zzh(8);
                            }
                            i = 8;
                        }
                        zzesVar.zzm();
                        if (iZzj4 == 1) {
                        }
                        if (zzaezVar.zza) {
                        }
                    }
                } else {
                    zze(zzesVar, zzaezVar);
                    zzesVar.zzg();
                    if (!zzesVar.zzi()) {
                    }
                    if (iZzj2 <= 0) {
                    }
                }
                if (zzaezVar.zza) {
                }
                if (i6 > 0) {
                }
            } else {
                i9 = iZzc;
            }
            i3 = 7;
            int iZzj13 = zzesVar.zzj(7);
            for (int i28 = 0; i28 < iZzj13; i28++) {
                zzesVar.zzh(15);
            }
            if (iZzj2 <= 0) {
            }
            if (zzaezVar.zza) {
            }
            if (i6 > 0) {
            }
        }
        i = 8;
        i2 = 5;
        i3 = 7;
        i4 = -1;
        if (zzaezVar.zza) {
        }
        if (i6 > 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzafa zzb(zzes zzesVar) {
        int i;
        int i2;
        int iZzj;
        int iZzj2 = zzesVar.zzj(16);
        int iZzj3 = zzesVar.zzj(16);
        if (iZzj3 == 65535) {
            iZzj3 = zzesVar.zzj(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = iZzj3 + i;
        if (iZzj2 == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int iZzj4 = zzesVar.zzj(2);
        int i5 = 0;
        if (iZzj4 == 3) {
            int i6 = 0;
            while (true) {
                iZzj = zzesVar.zzj(2) + i6;
                if (!zzesVar.zzi()) {
                    break;
                }
                i6 = (iZzj + 1) << 2;
            }
            iZzj4 = iZzj + 3;
        }
        int i7 = iZzj4;
        int iZzj5 = zzesVar.zzj(10);
        if (zzesVar.zzi() && zzesVar.zzj(3) > 0) {
            zzesVar.zzh(2);
        }
        int i8 = 48000;
        if (true != zzesVar.zzi()) {
            i2 = 48000;
            i8 = 44100;
        } else {
            i2 = 48000;
        }
        int iZzj6 = zzesVar.zzj(4);
        if (i8 == 44100 && iZzj6 == 13) {
            i5 = zzb[13];
        } else if (i8 == i2 && iZzj6 < 14) {
            i5 = zzb[iZzj6];
            int i9 = iZzj5 % 5;
            if (i9 == 1) {
                if (iZzj6 == 3 || iZzj6 == 8) {
                    i5++;
                }
            } else if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 == 4 && (iZzj6 == 3 || iZzj6 == 8 || iZzj6 == 11)) {
                    }
                }
            } else if (iZzj6 == 8 || iZzj6 == 11) {
            }
        }
        return new zzafa(i7, 2, i8, i4, i5, null);
    }

    public static void zzc(int i, zzet zzetVar) {
        zzetVar.zza(7);
        byte[] bArrZzi = zzetVar.zzi();
        bArrZzi[0] = -84;
        bArrZzi[1] = 64;
        bArrZzi[2] = -1;
        bArrZzi[3] = -1;
        bArrZzi[4] = (byte) ((i >> 16) & PHIpAddressSearchManager.END_IP_SCAN);
        bArrZzi[5] = (byte) ((i >> 8) & PHIpAddressSearchManager.END_IP_SCAN);
        bArrZzi[6] = (byte) (i & PHIpAddressSearchManager.END_IP_SCAN);
    }

    private static void zzd(zzes zzesVar, zzaez zzaezVar) throws zzat {
        int iZzj = zzesVar.zzj(5);
        zzesVar.zzh(2);
        if (zzesVar.zzi()) {
            zzesVar.zzh(5);
        }
        if (iZzj >= 7 && iZzj <= 10) {
            zzesVar.zzg();
        }
        if (zzesVar.zzi()) {
            int iZzj2 = zzesVar.zzj(3);
            if (zzaezVar.zzb == -1 && iZzj >= 0 && iZzj <= 15 && (iZzj2 == 0 || iZzj2 == 1)) {
                zzaezVar.zzb = iZzj;
            }
            if (zzesVar.zzi()) {
                zzf(zzesVar);
            }
        }
    }

    private static void zze(zzes zzesVar, zzaez zzaezVar) throws zzat {
        zzesVar.zzh(2);
        boolean zZzi = zzesVar.zzi();
        int iZzj = zzesVar.zzj(8);
        for (int i = 0; i < iZzj; i++) {
            zzesVar.zzh(2);
            if (zzesVar.zzi()) {
                zzesVar.zzh(5);
            }
            if (zZzi) {
                zzesVar.zzh(24);
            } else {
                if (zzesVar.zzi()) {
                    if (!zzesVar.zzi()) {
                        zzesVar.zzh(4);
                    }
                    zzaezVar.zzc = zzesVar.zzj(6) + 1;
                }
                zzesVar.zzh(4);
            }
        }
        if (zzesVar.zzi()) {
            zzesVar.zzh(3);
            if (zzesVar.zzi()) {
                zzf(zzesVar);
            }
        }
    }

    private static void zzf(zzes zzesVar) throws zzat {
        int iZzj = zzesVar.zzj(6);
        if (iZzj < 2 || iZzj > 42) {
            throw zzat.zzc(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iZzj)));
        }
        zzesVar.zzh(iZzj * 8);
    }

    private static boolean zzg(zzes zzesVar) {
        if (zzesVar.zzc() < 66) {
            return false;
        }
        zzesVar.zzh(66);
        return true;
    }
}
