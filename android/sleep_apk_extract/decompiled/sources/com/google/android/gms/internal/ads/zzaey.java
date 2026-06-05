package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaey {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzv zza(zzet zzetVar, String str, String str2, zzq zzqVar) {
        zzes zzesVar = new zzes();
        zzesVar.zza(zzetVar);
        int i = zzc[zzesVar.zzj(2)];
        zzesVar.zzh(8);
        int i2 = zze[zzesVar.zzj(3)];
        if (zzesVar.zzj(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzesVar.zzj(5)] * 1000;
        zzesVar.zzm();
        zzetVar.zzh(zzesVar.zze());
        zzt zztVar = new zzt();
        zztVar.zza(str);
        zztVar.zzo("audio/ac3");
        zztVar.zzG(i2);
        zztVar.zzH(i);
        zztVar.zzs(zzqVar);
        zztVar.zze(str2);
        zztVar.zzi(i3);
        zztVar.zzj(i3);
        return zztVar.zzO();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzv zzb(zzet zzetVar, String str, String str2, zzq zzqVar) {
        String str3;
        zzes zzesVar = new zzes();
        zzesVar.zza(zzetVar);
        int iZzj = zzesVar.zzj(13) * 1000;
        zzesVar.zzh(3);
        int i = zzc[zzesVar.zzj(2)];
        zzesVar.zzh(10);
        int i2 = zze[zzesVar.zzj(3)];
        if (zzesVar.zzj(1) != 0) {
            i2++;
        }
        zzesVar.zzh(3);
        int iZzj2 = zzesVar.zzj(4);
        zzesVar.zzh(1);
        if (iZzj2 > 0) {
            zzesVar.zzh(6);
            if (zzesVar.zzj(1) != 0) {
                i2 += 2;
            }
            zzesVar.zzh(1);
        }
        if (zzesVar.zzc() > 7) {
            zzesVar.zzh(7);
            str3 = zzesVar.zzj(1) != 0 ? "audio/eac3-joc" : "audio/eac3";
        }
        zzesVar.zzm();
        zzetVar.zzh(zzesVar.zze());
        zzt zztVar = new zzt();
        zztVar.zza(str);
        zztVar.zzo(str3);
        zztVar.zzG(i2);
        zztVar.zzH(i);
        zztVar.zzs(zzqVar);
        zztVar.zze(str2);
        zztVar.zzj(iZzj);
        return zztVar.zzO();
    }

    public static zzaex zzc(zzes zzesVar) {
        int iZzf;
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iZzd = zzesVar.zzd();
        zzesVar.zzh(40);
        int iZzj = zzesVar.zzj(5);
        zzesVar.zzf(iZzd);
        int i9 = -1;
        if (iZzj > 10) {
            zzesVar.zzh(16);
            int iZzj2 = zzesVar.zzj(2);
            if (iZzj2 == 0) {
                i9 = 0;
            } else if (iZzj2 == 1) {
                i9 = 1;
            } else if (iZzj2 == 2) {
                i9 = 2;
            }
            zzesVar.zzh(3);
            int iZzj3 = zzesVar.zzj(11) + 1;
            int iZzj4 = zzesVar.zzj(2);
            if (iZzj4 == 3) {
                i = zzd[zzesVar.zzj(2)];
                i6 = 6;
                i5 = 3;
            } else {
                int iZzj5 = zzesVar.zzj(2);
                int i10 = zzb[iZzj5];
                i5 = iZzj5;
                i = zzc[iZzj4];
                i6 = i10;
            }
            iZzf = iZzj3 + iZzj3;
            int i11 = (iZzf * i) / (i6 * 32);
            int iZzj6 = zzesVar.zzj(3);
            boolean zZzi = zzesVar.zzi();
            i2 = zze[iZzj6] + (zZzi ? 1 : 0);
            zzesVar.zzh(10);
            if (zzesVar.zzi()) {
                zzesVar.zzh(8);
            }
            if (iZzj6 == 0) {
                zzesVar.zzh(5);
                if (zzesVar.zzi()) {
                    zzesVar.zzh(8);
                }
                i7 = 0;
                iZzj6 = 0;
            } else {
                i7 = iZzj6;
            }
            if (i9 == 1) {
                if (zzesVar.zzi()) {
                    zzesVar.zzh(16);
                }
                i8 = 1;
            } else {
                i8 = i9;
            }
            if (zzesVar.zzi()) {
                if (i7 > 2) {
                    zzesVar.zzh(2);
                }
                if ((i7 & 1) != 0 && i7 > 2) {
                    zzesVar.zzh(6);
                }
                if ((i7 & 4) != 0) {
                    zzesVar.zzh(6);
                }
                if (zZzi && zzesVar.zzi()) {
                    zzesVar.zzh(5);
                }
                if (i8 == 0) {
                    if (zzesVar.zzi()) {
                        zzesVar.zzh(6);
                    }
                    if (i7 == 0 && zzesVar.zzi()) {
                        zzesVar.zzh(6);
                    }
                    if (zzesVar.zzi()) {
                        zzesVar.zzh(6);
                    }
                    int iZzj7 = zzesVar.zzj(2);
                    if (iZzj7 == 1) {
                        zzesVar.zzh(5);
                    } else if (iZzj7 == 2) {
                        zzesVar.zzh(12);
                    } else if (iZzj7 == 3) {
                        int iZzj8 = zzesVar.zzj(5);
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(5);
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                if (zzesVar.zzi()) {
                                    zzesVar.zzh(4);
                                }
                                if (zzesVar.zzi()) {
                                    zzesVar.zzh(4);
                                }
                            }
                        }
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(5);
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(7);
                                if (zzesVar.zzi()) {
                                    zzesVar.zzh(8);
                                }
                            }
                        }
                        zzesVar.zzh((iZzj8 + 2) * 8);
                        zzesVar.zzm();
                    }
                    if (i7 < 2) {
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(14);
                        }
                        if (iZzj6 == 0 && zzesVar.zzi()) {
                            zzesVar.zzh(14);
                        }
                    }
                    if (!zzesVar.zzi()) {
                        i8 = 0;
                    } else if (i5 == 0) {
                        zzesVar.zzh(5);
                        i8 = 0;
                        i5 = 0;
                    } else {
                        for (int i12 = 0; i12 < i6; i12++) {
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(5);
                            }
                        }
                        i8 = 0;
                    }
                }
            }
            if (zzesVar.zzi()) {
                zzesVar.zzh(5);
                if (i7 == 2) {
                    zzesVar.zzh(4);
                    i7 = 2;
                }
                if (i7 >= 6) {
                    zzesVar.zzh(2);
                }
                if (zzesVar.zzi()) {
                    zzesVar.zzh(8);
                }
                if (i7 == 0 && zzesVar.zzi()) {
                    zzesVar.zzh(8);
                }
                if (iZzj4 < 3) {
                    zzesVar.zzg();
                }
            }
            if (i8 == 0 && i5 != 3) {
                zzesVar.zzg();
            }
            if (i8 == 2 && (i5 == 3 || zzesVar.zzi())) {
                zzesVar.zzh(6);
            }
            i3 = i6 * 256;
            str = (zzesVar.zzi() && zzesVar.zzj(6) == 1 && zzesVar.zzj(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i4 = i11;
        } else {
            zzesVar.zzh(32);
            int iZzj9 = zzesVar.zzj(2);
            String str2 = iZzj9 == 3 ? null : "audio/ac3";
            int iZzj10 = zzesVar.zzj(6);
            int i13 = zzf[iZzj10 / 2] * 1000;
            iZzf = zzf(iZzj9, iZzj10);
            zzesVar.zzh(8);
            int iZzj11 = zzesVar.zzj(3);
            if ((iZzj11 & 1) != 0 && iZzj11 != 1) {
                zzesVar.zzh(2);
            }
            if ((iZzj11 & 4) != 0) {
                zzesVar.zzh(2);
            }
            if (iZzj11 == 2) {
                zzesVar.zzh(2);
            }
            i = iZzj9 < 3 ? zzc[iZzj9] : -1;
            i2 = zze[iZzj11] + (zzesVar.zzi() ? 1 : 0);
            i3 = 1536;
            str = str2;
            i4 = i13;
        }
        return new zzaex(str, i9, i2, i, iZzf, i3, i4, null);
    }

    public static int zzd(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b = bArr[4];
            return zzf((b & 192) >> 6, b & 63);
        }
        int i = bArr[2] & 7;
        int i2 = ((bArr[3] & 255) | (i << 8)) + 1;
        return i2 + i2;
    }

    public static int zze(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
