package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzanx implements zzanl {
    private static final byte[] zza = {0, 7, 8, 15};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzanq zzg;
    private final zzanp zzh;
    private final zzanw zzi;
    private Bitmap zzj;

    public zzanx(List list) {
        zzet zzetVar = new zzet((byte[]) list.get(0));
        int iZzt = zzetVar.zzt();
        int iZzt2 = zzetVar.zzt();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzanq(719, 575, 0, 719, 0, 575);
        this.zzh = new zzanp(0, zzd(), zze(), zzf());
        this.zzi = new zzanw(iZzt, iZzt2);
    }

    private static zzanp zzb(zzes zzesVar, int i) {
        int iZzj;
        int iZzj2;
        int iZzj3;
        int iZzj4;
        int i2 = 8;
        int iZzj5 = zzesVar.zzj(8);
        zzesVar.zzh(8);
        int[] iArrZzd = zzd();
        int[] iArrZze = zze();
        int[] iArrZzf = zzf();
        int i3 = i - 2;
        while (i3 > 0) {
            int iZzj6 = zzesVar.zzj(i2);
            int iZzj7 = zzesVar.zzj(i2);
            int[] iArr = (iZzj7 & 128) != 0 ? iArrZzd : (iZzj7 & 64) != 0 ? iArrZze : iArrZzf;
            if ((iZzj7 & 1) != 0) {
                iZzj3 = zzesVar.zzj(i2);
                iZzj4 = zzesVar.zzj(i2);
                iZzj = zzesVar.zzj(i2);
                iZzj2 = zzesVar.zzj(i2);
                i3 -= 6;
            } else {
                int iZzj8 = zzesVar.zzj(6) << 2;
                int iZzj9 = zzesVar.zzj(4) << 4;
                i3 -= 4;
                iZzj = zzesVar.zzj(4) << 4;
                iZzj2 = zzesVar.zzj(2) << 6;
                iZzj3 = iZzj8;
                iZzj4 = iZzj9;
            }
            if (iZzj3 == 0) {
                iZzj2 = 255;
            }
            if (iZzj3 == 0) {
                iZzj = 0;
            }
            if (iZzj3 == 0) {
                iZzj4 = 0;
            }
            int i4 = 255 - (iZzj2 & PHIpAddressSearchManager.END_IP_SCAN);
            double d = iZzj3;
            String str = zzfl.zza;
            double d2 = iZzj4 - 128;
            double d3 = iZzj - 128;
            iArr[iZzj6] = zzg((byte) i4, Math.max(0, Math.min((int) ((1.402d * d2) + d), PHIpAddressSearchManager.END_IP_SCAN)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), PHIpAddressSearchManager.END_IP_SCAN)), Math.max(0, Math.min((int) ((d3 * 1.772d) + d), PHIpAddressSearchManager.END_IP_SCAN)));
            iZzj5 = iZzj5;
            i2 = 8;
        }
        return new zzanp(iZzj5, iArrZzd, iArrZze, iArrZzf);
    }

    private static zzanr zzc(zzes zzesVar) {
        byte[] bArr;
        int iZzj = zzesVar.zzj(16);
        zzesVar.zzh(4);
        int iZzj2 = zzesVar.zzj(2);
        boolean zZzi = zzesVar.zzi();
        zzesVar.zzh(1);
        byte[] bArr2 = zzfl.zzb;
        if (iZzj2 != 1) {
            if (iZzj2 == 0) {
                int iZzj3 = zzesVar.zzj(16);
                int iZzj4 = zzesVar.zzj(16);
                if (iZzj3 > 0) {
                    bArr2 = new byte[iZzj3];
                    zzesVar.zzn(bArr2, 0, iZzj3);
                }
                if (iZzj4 > 0) {
                    bArr = new byte[iZzj4];
                    zzesVar.zzn(bArr, 0, iZzj4);
                }
            }
            return new zzanr(iZzj, zZzi, bArr2, bArr);
        }
        zzesVar.zzh(zzesVar.zzj(8) * 16);
        bArr = bArr2;
        return new zzanr(iZzj, zZzi, bArr2, bArr);
    }

    private static int[] zzd() {
        return new int[]{0, -1, Color.BLACK, -8421505};
    }

    private static int[] zze() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            int i2 = i & 4;
            int i3 = i & 2;
            int i4 = i & 1;
            if (i < 8) {
                iArr[i] = zzg(PHIpAddressSearchManager.END_IP_SCAN, 1 != i4 ? 0 : 255, i3 != 0 ? 255 : 0, i2 != 0 ? 255 : 0);
            } else {
                iArr[i] = zzg(PHIpAddressSearchManager.END_IP_SCAN, 1 != i4 ? 0 : 127, i3 != 0 ? 127 : 0, i2 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] zzf() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            int i2 = PHIpAddressSearchManager.END_IP_SCAN;
            if (i < 8) {
                int i3 = i & 2;
                int i4 = i & 4;
                int i5 = 1 != (i & 1) ? 0 : 255;
                int i6 = i3 != 0 ? 255 : 0;
                if (i4 == 0) {
                    i2 = 0;
                }
                iArr[i] = zzg(63, i5, i6, i2);
            } else {
                int i7 = i & 136;
                if (i7 == 0) {
                    iArr[i] = zzg(PHIpAddressSearchManager.END_IP_SCAN, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i7 == 8) {
                    iArr[i] = zzg(127, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i7 == 128) {
                    iArr[i] = zzg(PHIpAddressSearchManager.END_IP_SCAN, (1 != (i & 1) ? 0 : 43) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                } else if (i7 == 136) {
                    iArr[i] = zzg(PHIpAddressSearchManager.END_IP_SCAN, (1 != (i & 1) ? 0 : 43) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static int zzg(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0201 A[LOOP:3: B:89:0x0163->B:122:0x0201, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zzh(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int i4;
        int iZzj;
        char c;
        int i5;
        int iZzj2;
        int iZzj3;
        int iZzj4;
        int i6;
        int i7;
        boolean z;
        int iZzj5;
        int iZzj6;
        int i8;
        int i9;
        int i10;
        int iZzj7;
        int i11;
        Paint paint2 = paint;
        zzes zzesVar = new zzes(bArr, bArr.length);
        int i12 = i2;
        int i13 = i3;
        byte[] bArrZzi = null;
        byte[] bArrZzi2 = null;
        byte[] bArrZzi3 = null;
        while (zzesVar.zzc() != 0) {
            int iZzj8 = zzesVar.zzj(8);
            if (iZzj8 != 240) {
                int i14 = 4;
                int i15 = 1;
                int i16 = 2;
                switch (iZzj8) {
                    case 16:
                        int i17 = 1;
                        if (i != 3) {
                            if (i != 2) {
                                bArr2 = null;
                            } else if (bArrZzi3 == null) {
                                bArr3 = zza;
                                bArr2 = bArr3;
                            } else {
                                bArr2 = bArrZzi3;
                            }
                            i4 = 0;
                            while (true) {
                                iZzj = zzesVar.zzj(2);
                                if (iZzj != 0) {
                                }
                                i5 = i4;
                                c = 4;
                                if (iZzj3 == 0) {
                                }
                                paint2 = paint;
                                i4 = i5;
                                i17 = 1;
                            }
                        } else if (bArrZzi == null) {
                            bArr3 = zzb;
                            bArr2 = bArr3;
                            i4 = 0;
                            while (true) {
                                iZzj = zzesVar.zzj(2);
                                if (iZzj != 0) {
                                    iZzj3 = i17;
                                    iZzj2 = iZzj;
                                } else {
                                    if (zzesVar.zzi()) {
                                        iZzj4 = zzesVar.zzj(3) + 3;
                                        iZzj2 = zzesVar.zzj(2);
                                    } else {
                                        if (zzesVar.zzi()) {
                                            iZzj3 = i17;
                                            i5 = i4;
                                            iZzj2 = 0;
                                        } else {
                                            int iZzj9 = zzesVar.zzj(2);
                                            if (iZzj9 == 0) {
                                                c = 4;
                                                i5 = i17;
                                                iZzj2 = 0;
                                                iZzj3 = 0;
                                            } else if (iZzj9 == i17) {
                                                c = 4;
                                                i5 = i4;
                                                iZzj3 = 2;
                                                iZzj2 = 0;
                                            } else if (iZzj9 == 2) {
                                                c = 4;
                                                i5 = i4;
                                                iZzj3 = zzesVar.zzj(4) + 12;
                                                iZzj2 = zzesVar.zzj(2);
                                            } else if (iZzj9 != 3) {
                                                i5 = i4;
                                                iZzj2 = 0;
                                                iZzj3 = 0;
                                            } else {
                                                iZzj4 = zzesVar.zzj(8) + 29;
                                                iZzj2 = zzesVar.zzj(2);
                                            }
                                            if (iZzj3 == 0 || paint2 == null) {
                                                i6 = i12;
                                            } else {
                                                int i18 = i13 + 1;
                                                float f = i13;
                                                if (bArr2 != 0) {
                                                    iZzj2 = bArr2[iZzj2];
                                                }
                                                paint2.setColor(iArr[iZzj2]);
                                                i6 = i12;
                                                canvas.drawRect(i12, f, i12 + iZzj3, i18, paint2);
                                            }
                                            i12 = i6 + iZzj3;
                                            if (i5 == 0) {
                                                zzesVar.zzm();
                                            } else {
                                                paint2 = paint;
                                                i4 = i5;
                                                i17 = 1;
                                            }
                                        }
                                        c = 4;
                                        if (iZzj3 == 0) {
                                            i6 = i12;
                                            i12 = i6 + iZzj3;
                                            if (i5 == 0) {
                                            }
                                        }
                                    }
                                    iZzj3 = iZzj4;
                                }
                                i5 = i4;
                                c = 4;
                                if (iZzj3 == 0) {
                                }
                            }
                        } else {
                            bArr2 = bArrZzi;
                            i4 = 0;
                            while (true) {
                                iZzj = zzesVar.zzj(2);
                                if (iZzj != 0) {
                                }
                                i5 = i4;
                                c = 4;
                                if (iZzj3 == 0) {
                                }
                                paint2 = paint;
                                i4 = i5;
                                i17 = 1;
                            }
                        }
                        break;
                    case 17:
                        byte[] bArr4 = i == 3 ? bArrZzi2 == null ? zzc : bArrZzi2 : null;
                        boolean z2 = false;
                        while (true) {
                            int iZzj10 = zzesVar.zzj(i14);
                            if (iZzj10 != 0) {
                                i7 = 1;
                                z = z2;
                            } else if (zzesVar.zzi()) {
                                if (zzesVar.zzi()) {
                                    int iZzj11 = zzesVar.zzj(i16);
                                    if (iZzj11 == 0) {
                                        i7 = 1;
                                        z = z2;
                                        iZzj10 = 0;
                                    } else if (iZzj11 == 1) {
                                        z = z2;
                                        i7 = i16;
                                        iZzj10 = 0;
                                    } else if (iZzj11 == i16) {
                                        iZzj5 = zzesVar.zzj(i14) + 9;
                                        iZzj6 = zzesVar.zzj(i14);
                                    } else if (iZzj11 != 3) {
                                        z = z2;
                                        iZzj10 = 0;
                                        i7 = 0;
                                    } else {
                                        iZzj5 = zzesVar.zzj(8) + 25;
                                        iZzj6 = zzesVar.zzj(i14);
                                    }
                                } else {
                                    iZzj5 = zzesVar.zzj(i16) + i14;
                                    iZzj6 = zzesVar.zzj(i14);
                                }
                                i7 = iZzj5;
                                z = z2;
                                iZzj10 = iZzj6;
                            } else {
                                int iZzj12 = zzesVar.zzj(3);
                                if (iZzj12 != 0) {
                                    i7 = iZzj12 + 2;
                                    z = z2;
                                    iZzj10 = 0;
                                } else {
                                    z = true;
                                    iZzj10 = 0;
                                    i7 = 0;
                                }
                            }
                            if (i7 == 0 || paint2 == null) {
                                i8 = i12;
                                i9 = i16;
                            } else {
                                int i19 = i13 + 1;
                                float f2 = i13;
                                if (bArr4 != 0) {
                                    iZzj10 = bArr4[iZzj10];
                                }
                                paint2.setColor(iArr[iZzj10]);
                                i8 = i12;
                                i9 = 2;
                                canvas.drawRect(i12, f2, i12 + i7, i19, paint2);
                            }
                            i12 = i8 + i7;
                            if (z) {
                                zzesVar.zzm();
                                continue;
                            } else {
                                i16 = i9;
                                z2 = z;
                                i14 = 4;
                            }
                            break;
                        }
                        break;
                    case 18:
                        int i20 = i12;
                        int i21 = 0;
                        while (true) {
                            int iZzj13 = zzesVar.zzj(8);
                            if (iZzj13 != 0) {
                                i10 = i21;
                                iZzj7 = i15;
                            } else if (zzesVar.zzi()) {
                                i10 = i21;
                                iZzj7 = zzesVar.zzj(7);
                                iZzj13 = zzesVar.zzj(8);
                            } else {
                                int iZzj14 = zzesVar.zzj(7);
                                if (iZzj14 != 0) {
                                    i10 = i21;
                                    iZzj7 = iZzj14;
                                    iZzj13 = 0;
                                } else {
                                    i10 = i15;
                                    iZzj13 = 0;
                                    iZzj7 = 0;
                                }
                            }
                            if (iZzj7 == 0 || paint2 == null) {
                                i11 = i15;
                            } else {
                                paint2.setColor(iArr[iZzj13]);
                                i11 = i15;
                                canvas.drawRect(i20, i13, i20 + iZzj7, i13 + 1, paint2);
                            }
                            i20 += iZzj7;
                            if (i10 != 0) {
                                i12 = i20;
                                continue;
                            } else {
                                i15 = i11;
                                i21 = i10;
                            }
                            break;
                        }
                        break;
                    default:
                        switch (iZzj8) {
                            case 32:
                                bArrZzi3 = zzi(4, 4, zzesVar);
                                break;
                            case 33:
                                bArrZzi = zzi(4, 8, zzesVar);
                                break;
                            case 34:
                                bArrZzi2 = zzi(16, 8, zzesVar);
                                break;
                            default:
                                continue;
                        }
                        break;
                }
            } else {
                i13 += 2;
                i12 = i2;
            }
            paint2 = paint;
        }
    }

    private static byte[] zzi(int i, int i2, zzes zzesVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzesVar.zzj(i2);
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i, int i2, zzank zzankVar, zzdt zzdtVar) {
        boolean z;
        zzand zzandVar;
        Canvas canvas;
        char c;
        char c2;
        char c3;
        int i3;
        zzanw zzanwVar;
        Canvas canvas2;
        int i4;
        int i5;
        int i6;
        zzanu zzanuVar;
        int iZzj;
        int iZzj2;
        int iZzj3;
        int iZzj4;
        int i7;
        int iZzj5;
        zzes zzesVar = new zzes(bArr, i + i2);
        zzesVar.zzf(i);
        while (true) {
            z = true;
            if (zzesVar.zzc() >= 48 && zzesVar.zzj(8) == 15) {
                zzanw zzanwVar2 = this.zzi;
                int iZzj6 = zzesVar.zzj(8);
                int iZzj7 = zzesVar.zzj(16);
                int iZzj8 = zzesVar.zzj(16);
                int iZze = zzesVar.zze() + iZzj8;
                if (iZzj8 * 8 > zzesVar.zzc()) {
                    zzeg.zzc("DvbParser", "Data field length exceeds limit");
                    zzesVar.zzh(zzesVar.zzc());
                } else {
                    switch (iZzj6) {
                        case 16:
                            if (iZzj7 == zzanwVar2.zza) {
                                zzans zzansVar = zzanwVar2.zzi;
                                int iZzj9 = zzesVar.zzj(8);
                                int iZzj10 = zzesVar.zzj(4);
                                int iZzj11 = zzesVar.zzj(2);
                                zzesVar.zzh(2);
                                SparseArray sparseArray = new SparseArray();
                                for (int i8 = iZzj8 - 2; i8 > 0; i8 -= 6) {
                                    int iZzj12 = zzesVar.zzj(8);
                                    zzesVar.zzh(8);
                                    sparseArray.put(iZzj12, new zzant(zzesVar.zzj(16), zzesVar.zzj(16)));
                                }
                                zzans zzansVar2 = new zzans(iZzj9, iZzj10, iZzj11, sparseArray);
                                if (zzansVar2.zzb != 0) {
                                    zzanwVar2.zzi = zzansVar2;
                                    zzanwVar2.zzc.clear();
                                    zzanwVar2.zzd.clear();
                                    zzanwVar2.zze.clear();
                                } else if (zzansVar != null) {
                                    if (zzansVar.zza != zzansVar2.zza) {
                                        zzanwVar2.zzi = zzansVar2;
                                    }
                                }
                            }
                            break;
                        case 17:
                            zzans zzansVar3 = zzanwVar2.zzi;
                            if (iZzj7 == zzanwVar2.zza && zzansVar3 != null) {
                                int iZzj13 = zzesVar.zzj(8);
                                zzesVar.zzh(4);
                                boolean zZzi = zzesVar.zzi();
                                zzesVar.zzh(3);
                                int iZzj14 = zzesVar.zzj(16);
                                int iZzj15 = zzesVar.zzj(16);
                                int iZzj16 = zzesVar.zzj(3);
                                int iZzj17 = zzesVar.zzj(3);
                                zzesVar.zzh(2);
                                int iZzj18 = zzesVar.zzj(8);
                                int iZzj19 = zzesVar.zzj(8);
                                int iZzj20 = zzesVar.zzj(4);
                                int iZzj21 = zzesVar.zzj(2);
                                zzesVar.zzh(2);
                                int i9 = iZzj8 - 10;
                                SparseArray sparseArray2 = new SparseArray();
                                while (i9 > 0) {
                                    int iZzj22 = zzesVar.zzj(16);
                                    int iZzj23 = zzesVar.zzj(2);
                                    int iZzj24 = zzesVar.zzj(2);
                                    int iZzj25 = zzesVar.zzj(12);
                                    zzesVar.zzh(4);
                                    int iZzj26 = zzesVar.zzj(12);
                                    int i10 = i9 - 6;
                                    if (iZzj23 == 1) {
                                        i9 -= 8;
                                        iZzj = zzesVar.zzj(8);
                                        iZzj2 = zzesVar.zzj(8);
                                    } else if (iZzj23 == 2) {
                                        iZzj23 = 2;
                                        i9 -= 8;
                                        iZzj = zzesVar.zzj(8);
                                        iZzj2 = zzesVar.zzj(8);
                                    } else {
                                        i9 = i10;
                                        iZzj = 0;
                                        iZzj2 = 0;
                                    }
                                    sparseArray2.put(iZzj22, new zzanv(iZzj23, iZzj24, iZzj25, iZzj26, iZzj, iZzj2));
                                }
                                zzanu zzanuVar2 = new zzanu(iZzj13, zZzi, iZzj14, iZzj15, iZzj16, iZzj17, iZzj18, iZzj19, iZzj20, iZzj21, sparseArray2);
                                if (zzansVar3.zzb == 0 && (zzanuVar = (zzanu) zzanwVar2.zzc.get(zzanuVar2.zza)) != null) {
                                    int i11 = 0;
                                    while (true) {
                                        SparseArray sparseArray3 = zzanuVar.zzj;
                                        if (i11 < sparseArray3.size()) {
                                            zzanuVar2.zzj.put(sparseArray3.keyAt(i11), (zzanv) sparseArray3.valueAt(i11));
                                            i11++;
                                        }
                                    }
                                }
                                zzanwVar2.zzc.put(zzanuVar2.zza, zzanuVar2);
                            }
                            break;
                        case 18:
                            if (iZzj7 == zzanwVar2.zza) {
                                zzanp zzanpVarZzb = zzb(zzesVar, iZzj8);
                                zzanwVar2.zzd.put(zzanpVarZzb.zza, zzanpVarZzb);
                            } else if (iZzj7 == zzanwVar2.zzb) {
                                zzanp zzanpVarZzb2 = zzb(zzesVar, iZzj8);
                                zzanwVar2.zzf.put(zzanpVarZzb2.zza, zzanpVarZzb2);
                            }
                            break;
                        case 19:
                            if (iZzj7 == zzanwVar2.zza) {
                                zzanr zzanrVarZzc = zzc(zzesVar);
                                zzanwVar2.zze.put(zzanrVarZzc.zza, zzanrVarZzc);
                            } else if (iZzj7 == zzanwVar2.zzb) {
                                zzanr zzanrVarZzc2 = zzc(zzesVar);
                                zzanwVar2.zzg.put(zzanrVarZzc2.zza, zzanrVarZzc2);
                            }
                            break;
                        case 20:
                            if (iZzj7 == zzanwVar2.zza) {
                                zzesVar.zzh(4);
                                boolean zZzi2 = zzesVar.zzi();
                                zzesVar.zzh(3);
                                int iZzj27 = zzesVar.zzj(16);
                                int iZzj28 = zzesVar.zzj(16);
                                if (zZzi2) {
                                    int iZzj29 = zzesVar.zzj(16);
                                    iZzj3 = zzesVar.zzj(16);
                                    iZzj5 = zzesVar.zzj(16);
                                    iZzj4 = zzesVar.zzj(16);
                                    i7 = iZzj29;
                                } else {
                                    iZzj3 = iZzj27;
                                    iZzj4 = iZzj28;
                                    i7 = 0;
                                    iZzj5 = 0;
                                }
                                zzanwVar2.zzh = new zzanq(iZzj27, iZzj28, i7, iZzj3, iZzj5, iZzj4);
                            }
                            break;
                    }
                    zzesVar.zzo(iZze - zzesVar.zze());
                }
            }
        }
        zzanw zzanwVar3 = this.zzi;
        zzans zzansVar4 = zzanwVar3.zzi;
        if (zzansVar4 == null) {
            zzandVar = new zzand(zzgwm.zzi(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzanq zzanqVar = zzanwVar3.zzh;
            if (zzanqVar == null) {
                zzanqVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzanqVar.zza + 1 != bitmap.getWidth() || zzanqVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzanqVar.zza + 1, zzanqVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = bitmapCreateBitmap;
                this.zzf.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray4 = zzansVar4.zzc;
            int i12 = 0;
            while (i12 < sparseArray4.size()) {
                Canvas canvas3 = this.zzf;
                canvas3.save();
                zzant zzantVar = (zzant) sparseArray4.valueAt(i12);
                zzanu zzanuVar3 = (zzanu) zzanwVar3.zzc.get(sparseArray4.keyAt(i12));
                int i13 = zzantVar.zza + zzanqVar.zzc;
                int i14 = zzantVar.zzb + zzanqVar.zze;
                int i15 = zzanuVar3.zzc;
                int i16 = i13 + i15;
                boolean z2 = z;
                int iMin = Math.min(i16, zzanqVar.zzd);
                int i17 = zzanuVar3.zzd;
                int i18 = i14 + i17;
                canvas3.clipRect(i13, i14, iMin, Math.min(i18, zzanqVar.zzf));
                int i19 = zzanuVar3.zzf;
                zzanp zzanpVar = (zzanp) zzanwVar3.zzd.get(i19);
                if (zzanpVar == null && (zzanpVar = (zzanp) zzanwVar3.zzf.get(i19)) == null) {
                    zzanpVar = this.zzh;
                }
                SparseArray sparseArray5 = zzanuVar3.zzj;
                SparseArray sparseArray6 = sparseArray4;
                int i20 = i12;
                int i21 = 0;
                while (i21 < sparseArray5.size()) {
                    int iKeyAt = sparseArray5.keyAt(i21);
                    int i22 = i21;
                    zzanv zzanvVar = (zzanv) sparseArray5.valueAt(i21);
                    SparseArray sparseArray7 = sparseArray5;
                    zzanr zzanrVar = (zzanr) zzanwVar3.zze.get(iKeyAt);
                    if (zzanrVar == null) {
                        zzanrVar = (zzanr) zzanwVar3.zzg.get(iKeyAt);
                    }
                    if (zzanrVar != null) {
                        Paint paint = zzanrVar.zzb ? null : this.zzd;
                        i5 = i15;
                        int i23 = zzanuVar3.zze;
                        zzanwVar = zzanwVar3;
                        int i24 = zzanvVar.zza + i13;
                        int i25 = i14 + zzanvVar.zzb;
                        canvas2 = canvas3;
                        i4 = i13;
                        int[] iArr = i23 == 3 ? zzanpVar.zzd : i23 == 2 ? zzanpVar.zzc : zzanpVar.zzb;
                        i6 = i16;
                        zzh(zzanrVar.zzc, iArr, i23, i24, i25, paint, canvas2);
                        zzh(zzanrVar.zzd, iArr, i23, i24, i25 + 1, paint, canvas2);
                    } else {
                        zzanwVar = zzanwVar3;
                        canvas2 = canvas3;
                        i4 = i13;
                        i5 = i15;
                        i6 = i16;
                    }
                    i13 = i4;
                    i16 = i6;
                    i21 = i22 + 1;
                    i15 = i5;
                    canvas3 = canvas2;
                    sparseArray5 = sparseArray7;
                    zzanwVar3 = zzanwVar;
                }
                zzanw zzanwVar4 = zzanwVar3;
                Canvas canvas4 = canvas3;
                int i26 = i13;
                int i27 = i15;
                int i28 = i16;
                float f = i14;
                float f2 = i26;
                if (zzanuVar3.zzb) {
                    int i29 = zzanuVar3.zze;
                    if (i29 == 3) {
                        i3 = zzanpVar.zzd[zzanuVar3.zzg];
                        c3 = 2;
                    } else {
                        c3 = 2;
                        i3 = i29 == 2 ? zzanpVar.zzc[zzanuVar3.zzh] : zzanpVar.zzb[zzanuVar3.zzi];
                    }
                    Paint paint2 = this.zze;
                    paint2.setColor(i3);
                    float f3 = i28;
                    c2 = c3;
                    c = 3;
                    canvas = canvas4;
                    canvas.drawRect(f2, f, f3, i18, paint2);
                } else {
                    canvas = canvas4;
                    c = 3;
                    c2 = 2;
                }
                zzcw zzcwVar = new zzcw();
                zzcwVar.zzc(Bitmap.createBitmap(this.zzj, i26, i14, i27, i17));
                float f4 = zzanqVar.zza;
                zzcwVar.zzi(f2 / f4);
                zzcwVar.zzj(0);
                float f5 = zzanqVar.zzb;
                zzcwVar.zzf(f / f5, 0);
                zzcwVar.zzg(0);
                zzcwVar.zzm(i27 / f4);
                zzcwVar.zzn(i17 / f5);
                arrayList.add(zzcwVar.zzr());
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                i12 = i20 + 1;
                z = z2;
                zzanwVar3 = zzanwVar4;
                sparseArray4 = sparseArray6;
            }
            zzandVar = new zzand(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzdtVar.zza(zzandVar);
    }
}
