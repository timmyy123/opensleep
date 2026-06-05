package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafc {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzafc(List list, int i, int i2, int i3, int i4) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a4 A[Catch: ArrayIndexOutOfBoundsException -> 0x01e6, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x01e6, blocks: (B:3:0x0004, B:14:0x003f, B:16:0x004a, B:18:0x005a, B:21:0x0066, B:23:0x0092, B:25:0x0098, B:27:0x00ad, B:29:0x00b6, B:31:0x00be, B:33:0x00d3, B:35:0x00e0, B:37:0x00f5, B:39:0x00fb, B:41:0x0110, B:43:0x0116, B:45:0x012b, B:48:0x0134, B:50:0x013d, B:51:0x0140, B:52:0x0145, B:54:0x015b, B:55:0x015e, B:57:0x0167, B:58:0x016a, B:63:0x0177, B:65:0x017d, B:67:0x0182, B:68:0x0185, B:71:0x0190, B:74:0x0197, B:77:0x019e, B:79:0x01a4, B:89:0x01c3, B:93:0x01cb, B:95:0x01dc, B:88:0x01bf, B:61:0x0171), top: B:100:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzafc zza(byte[] bArr) throws zzat {
        int i;
        int i2;
        int i3;
        int iZzc;
        int iZzj;
        try {
            zzes zzesVar = new zzes(bArr, bArr.length);
            int i4 = 1;
            zzesVar.zzo(1);
            int iZzj2 = zzesVar.zzj(3);
            zzesVar.zzh(6);
            boolean zZzi = zzesVar.zzi();
            boolean zZzi2 = zzesVar.zzi();
            int i5 = 12;
            boolean z = false;
            if (iZzj2 != 2) {
                i = iZzj2 > 2 ? true != zZzi ? 8 : 10 : -1;
            } else if (!zZzi) {
                zZzi = false;
                iZzj2 = 2;
                if (iZzj2 > 2) {
                }
            } else if (true == zZzi2) {
                i = 12;
            }
            int i6 = 13;
            zzesVar.zzh(13);
            if (zzesVar.zzc() <= 0) {
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            zzesVar.zzg();
            int iZzj3 = zzesVar.zzj(4);
            if (iZzj3 != 1) {
                StringBuilder sb = new StringBuilder(String.valueOf(iZzj3).length() + 22);
                sb.append("Unsupported obu_type: ");
                sb.append(iZzj3);
                zzeg.zzb("Av1Config", sb.toString());
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            if (zzesVar.zzi()) {
                zzeg.zzb("Av1Config", "Unsupported obu_extension_flag");
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            boolean zZzi3 = zzesVar.zzi();
            zzesVar.zzg();
            if (zZzi3 && zzesVar.zzj(8) > 127) {
                zzeg.zzb("Av1Config", "Excessive obu_size");
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            int iZzj4 = zzesVar.zzj(3);
            zzesVar.zzg();
            if (zzesVar.zzi()) {
                zzeg.zzb("Av1Config", "Unsupported reduced_still_picture_header");
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            if (zzesVar.zzi()) {
                zzeg.zzb("Av1Config", "Unsupported timing_info_present_flag");
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            if (zzesVar.zzi()) {
                zzeg.zzb("Av1Config", "Unsupported initial_display_delay_present_flag");
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            int iZzj5 = zzesVar.zzj(5);
            int i7 = 0;
            while (i7 <= iZzj5) {
                zzesVar.zzh(i5);
                if (zzesVar.zzj(5) > 7) {
                    zzesVar.zzg();
                }
                i7++;
                i5 = 12;
            }
            int iZzj6 = zzesVar.zzj(4);
            int iZzj7 = zzesVar.zzj(4);
            zzesVar.zzh(iZzj6 + 1);
            zzesVar.zzh(iZzj7 + 1);
            if (zzesVar.zzi()) {
                zzesVar.zzh(7);
            }
            zzesVar.zzh(7);
            boolean zZzi4 = zzesVar.zzi();
            if (zZzi4) {
                zzesVar.zzh(2);
            }
            if (zzesVar.zzi() || zzesVar.zzj(1) > 0) {
                if (!zzesVar.zzi()) {
                    zzesVar.zzh(1);
                }
            }
            if (zZzi4) {
                zzesVar.zzh(3);
            }
            zzesVar.zzh(3);
            boolean zZzi5 = zzesVar.zzi();
            if (iZzj4 != 2) {
                if (iZzj4 == 1) {
                }
                if (zzesVar.zzi()) {
                    i2 = -1;
                    i3 = -1;
                    iZzc = -1;
                } else {
                    int iZzj8 = zzesVar.zzj(8);
                    int iZzj9 = zzesVar.zzj(8);
                    int iZzj10 = zzesVar.zzj(8);
                    if (z || iZzj8 != 1) {
                        i6 = iZzj9;
                        iZzj = zzesVar.zzj(1);
                        int iZzb = zzi.zzb(iZzj8);
                        if (iZzj == 1) {
                            i4 = 2;
                        }
                        iZzc = zzi.zzc(i6);
                        i3 = i4;
                        i2 = iZzb;
                    } else if (iZzj9 != 13) {
                        iZzj8 = 1;
                        i6 = iZzj9;
                        iZzj = zzesVar.zzj(1);
                        int iZzb2 = zzi.zzb(iZzj8);
                        if (iZzj == 1) {
                        }
                        iZzc = zzi.zzc(i6);
                        i3 = i4;
                        i2 = iZzb2;
                    } else if (iZzj10 == 0) {
                        iZzj8 = 1;
                        iZzj = 1;
                        int iZzb22 = zzi.zzb(iZzj8);
                        if (iZzj == 1) {
                        }
                        iZzc = zzi.zzc(i6);
                        i3 = i4;
                        i2 = iZzb22;
                    } else {
                        iZzj8 = 1;
                        iZzj = zzesVar.zzj(1);
                        int iZzb222 = zzi.zzb(iZzj8);
                        if (iZzj == 1) {
                        }
                        iZzc = zzi.zzc(i6);
                        i3 = i4;
                        i2 = iZzb222;
                    }
                }
                return new zzafc(zzgwm.zzj(bArr), i, i2, i3, iZzc);
            }
            if (zZzi5) {
                zzesVar.zzg();
            }
            if (zzesVar.zzi()) {
                z = true;
            }
            if (zzesVar.zzi()) {
            }
            return new zzafc(zzgwm.zzj(bArr), i, i2, i3, iZzc);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzat.zzb("Error parsing AV1 config", e);
        }
    }
}
