package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class K2 {
    public static byte[] A07;
    public static String[] A08 = {"kwH2IgvZBGVpLaminurwcFHn", "J6e0tkh1Ff6tZSOwzR7AwbvIu8fVWeGQ", "bmiWbLOqDwiyYFUNe9As1QTlUgH4xYog", "dMXPCdyZdj7A6mfCnV5k3qiAvM2EcvhL", "upBvpVjUbbd4tW9uVknw3ChYtDg3XaKB", "lx9xVZ51GyjZV5dkAVxa", "4OpeXOwoxJhsdURDQeyl4TBKgN5cofiY", "16zjJfNWedSO35u1fMpvBODfGSUbEH9B"};
    public static final byte[] A09;
    public static final byte[] A0A;
    public static final byte[] A0B;
    public Bitmap A00;
    public final Canvas A01;
    public final Paint A02 = new Paint();
    public final Paint A03;
    public final C0596Ju A04;
    public final C0597Jv A05;
    public final K1 A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0596Ju A04(C02274u c02274u, int i) {
        int iA04;
        int iA042;
        int iA043;
        int iA044;
        int i2 = 8;
        int iA045 = c02274u.A04(8);
        c02274u.A09(8);
        int i3 = i - 2;
        int[] iArrA0F = A0F();
        int[] iArrA0G = A0G();
        int[] iArrA0H = A0H();
        while (i3 > 0) {
            int iA046 = c02274u.A04(i2);
            int iA047 = c02274u.A04(i2);
            int i4 = i3 - 2;
            int[] iArr = (iA047 & 128) != 0 ? iArrA0F : (iA047 & 64) != 0 ? iArrA0G : iArrA0H;
            int i5 = iA047 & 1;
            String[] strArr = A08;
            if (strArr[2].charAt(19) == strArr[6].charAt(19)) {
                throw new RuntimeException();
            }
            A08[3] = "yhDNrhcDigDR24Kxe5BS389mQBs2ZM2v";
            if (i5 != 0) {
                iA04 = c02274u.A04(i2);
                iA042 = c02274u.A04(i2);
                iA043 = c02274u.A04(i2);
                iA044 = c02274u.A04(i2);
                i3 = i4 - 4;
            } else {
                iA04 = c02274u.A04(6) << 2;
                iA042 = c02274u.A04(4) << 4;
                iA043 = c02274u.A04(4) << 4;
                iA044 = c02274u.A04(2) << 6;
                i3 = i4 - 2;
            }
            if (iA04 == 0) {
                iA042 = 0;
                if (A08[3].charAt(20) != '3') {
                    throw new RuntimeException();
                }
                A08[7] = "NRFOfVblegIP33K9RsgAL0VferudmJOb";
                iA043 = 0;
                iA044 = PHIpAddressSearchManager.END_IP_SCAN;
            }
            iArr[iA046] = A00(255 - (iA044 & PHIpAddressSearchManager.END_IP_SCAN), C5C.A07((int) (((double) iA04) + (((double) (iA042 - 128)) * 1.402d)), 0, PHIpAddressSearchManager.END_IP_SCAN), C5C.A07((int) ((((double) iA04) - (((double) (iA043 - 128)) * 0.34414d)) - (((double) (iA042 - 128)) * 0.71414d)), 0, PHIpAddressSearchManager.END_IP_SCAN), C5C.A07((int) (((double) iA04) + (((double) (iA043 - 128)) * 1.772d)), 0, PHIpAddressSearchManager.END_IP_SCAN));
            i2 = 8;
        }
        return new C0596Ju(iA045, iArrA0F, iArrA0G, iArrA0H);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0597Jv A05(C02274u c02274u) {
        int iA04;
        int iA042;
        int iA043;
        int iA044;
        c02274u.A09(4);
        boolean zA0H = c02274u.A0H();
        c02274u.A09(3);
        int iA045 = c02274u.A04(16);
        int iA046 = c02274u.A04(16);
        if (zA0H) {
            iA04 = c02274u.A04(16);
            iA044 = c02274u.A04(16);
            iA042 = c02274u.A04(16);
            iA043 = c02274u.A04(16);
        } else {
            iA04 = 0;
            iA042 = 0;
            iA043 = iA046;
            iA044 = iA045;
        }
        return new C0597Jv(iA045, iA046, iA04, iA044, iA042, iA043);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0601Jz A08(C02274u c02274u, int i) {
        int i2 = 8;
        int iA04 = c02274u.A04(8);
        c02274u.A09(4);
        boolean zA0H = c02274u.A0H();
        c02274u.A09(3);
        int iA042 = c02274u.A04(16);
        int iA043 = c02274u.A04(16);
        int iA044 = c02274u.A04(3);
        int iA045 = c02274u.A04(3);
        c02274u.A09(2);
        int iA046 = c02274u.A04(8);
        int iA047 = c02274u.A04(8);
        int iA048 = c02274u.A04(4);
        int iA049 = c02274u.A04(2);
        c02274u.A09(2);
        int i3 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int iA0410 = c02274u.A04(16);
            int iA0411 = c02274u.A04(2);
            int iA0412 = c02274u.A04(2);
            int iA0413 = c02274u.A04(12);
            c02274u.A09(4);
            int iA0414 = c02274u.A04(12);
            i3 -= 6;
            int iA0415 = 0;
            int iA0416 = 0;
            if (iA0411 == 1 || iA0411 == 2) {
                iA0415 = c02274u.A04(i2);
                iA0416 = c02274u.A04(i2);
                i3 -= 2;
            }
            sparseArray.put(iA0410, new K0(iA0411, iA0412, iA0413, iA0414, iA0415, iA0416));
            i2 = 8;
        }
        return new C0601Jz(iA04, zA0H, iA042, iA043, iA044, iA045, iA046, iA047, iA048, iA049, sparseArray);
    }

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{63, 26, 15, 26, 91, 29, 18, 30, 23, 31, 91, 23, 30, 21, 28, 15, 19, 91, 30, 3, 24, 30, 30, 31, 8, 91, 23, 18, 22, 18, 15, 98, 80, 68, 118, 71, 84, 85, 67, 84};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final List<C1931pT> A0I(byte[] bArr, int i) {
        C02274u c02274u = new C02274u(bArr, i);
        while (c02274u.A01() >= 48 && c02274u.A04(8) == 15) {
            A0B(c02274u, this.A06);
        }
        C0599Jx c0599Jx = this.A06.A01;
        if (c0599Jx == null) {
            return Collections.emptyList();
        }
        C0597Jv c0597Jv = this.A06.A00 != null ? this.A06.A00 : this.A05;
        if (this.A00 == null || c0597Jv.A05 + 1 != this.A00.getWidth() || c0597Jv.A00 + 1 != this.A00.getHeight()) {
            this.A00 = Bitmap.createBitmap(c0597Jv.A05 + 1, c0597Jv.A00 + 1, Bitmap.Config.ARGB_8888);
            this.A01.setBitmap(this.A00);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<C0600Jy> sparseArray = c0599Jx.A03;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            this.A01.save();
            C0600Jy c0600JyValueAt = sparseArray.valueAt(i2);
            C0601Jz c0601Jz = this.A06.A08.get(sparseArray.keyAt(i2));
            int i3 = c0600JyValueAt.A00 + c0597Jv.A02;
            int i4 = c0600JyValueAt.A01 + c0597Jv.A04;
            this.A01.clipRect(i3, i4, Math.min(c0601Jz.A08 + i3, c0597Jv.A01), Math.min(c0601Jz.A02 + i4, c0597Jv.A03));
            C0596Ju c0596Ju = this.A06.A06.get(c0601Jz.A00);
            if (c0596Ju == null && (c0596Ju = this.A06.A04.get(c0601Jz.A00)) == null) {
                c0596Ju = this.A04;
            }
            SparseArray<K0> sparseArray2 = c0601Jz.A09;
            for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
                int iKeyAt = sparseArray2.keyAt(i5);
                K0 k0ValueAt = sparseArray2.valueAt(i5);
                C0598Jw c0598Jw = this.A06.A07.get(iKeyAt);
                if (c0598Jw == null) {
                    c0598Jw = this.A06.A05.get(iKeyAt);
                }
                if (c0598Jw != null) {
                    A0C(c0598Jw, c0596Ju, c0601Jz.A01, i3 + k0ValueAt.A02, i4 + k0ValueAt.A05, c0598Jw.A01 ? null : this.A02, this.A01);
                }
            }
            if (A08[4].charAt(14) != '9') {
                throw new RuntimeException();
            }
            A08[0] = "Y9Cu9eZ8R7HUBmBBCZ1DilUT";
            if (c0601Jz.A0A) {
                this.A03.setColor(c0601Jz.A01 == 3 ? c0596Ju.A03[c0601Jz.A07] : c0601Jz.A01 == 2 ? c0596Ju.A02[c0601Jz.A06] : c0596Ju.A01[c0601Jz.A05]);
                this.A01.drawRect(i3, i4, c0601Jz.A08 + i3, c0601Jz.A02 + i4, this.A03);
            }
            arrayList.add(new C01953o().A0D(Bitmap.createBitmap(this.A00, i3, i4, c0601Jz.A08, c0601Jz.A02)).A04(i3 / c0597Jv.A05).A0A(0).A07(i4 / c0597Jv.A00, 0).A09(0).A06(c0601Jz.A08 / c0597Jv.A05).A03(c0601Jz.A02 / c0597Jv.A00).A0H());
            this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
            this.A01.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    static {
        A0A();
        A09 = new byte[]{0, 7, 8, 15};
        A0A = new byte[]{0, 119, -120, -1};
        A0B = new byte[]{0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public K2(int i, int i2) {
        this.A02.setStyle(Paint.Style.FILL_AND_STROKE);
        this.A02.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.A02.setPathEffect(null);
        this.A03 = new Paint();
        this.A03.setStyle(Paint.Style.FILL);
        this.A03.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.A03.setPathEffect(null);
        this.A01 = new Canvas();
        this.A05 = new C0597Jv(719, 575, 0, 719, 0, 575);
        this.A04 = new C0596Ju(0, A0F(), A0G(), A0H());
        this.A06 = new K1(i, i2);
    }

    public static int A00(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public static int A01(C02274u c02274u, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        boolean z = false;
        do {
            int iA04 = 0;
            int iA042 = c02274u.A04(2);
            if (iA042 != 0) {
                iA04 = 1;
            } else if (c02274u.A0H()) {
                iA04 = c02274u.A04(3) + 3;
                iA042 = c02274u.A04(2);
            } else if (c02274u.A0H()) {
                iA04 = 1;
                iA042 = 0;
            } else {
                switch (c02274u.A04(2)) {
                    case 0:
                        z = true;
                        iA042 = 0;
                        break;
                    case 1:
                        iA04 = 2;
                        iA042 = 0;
                        break;
                    case 2:
                        int iA043 = c02274u.A04(4);
                        if (A08[7].charAt(9) != 'e') {
                            A08[7] = "PWQusWjmzTX1R8w37TeIuijcGSqhz46U";
                            iA04 = iA043 + 12;
                            iA042 = c02274u.A04(2);
                        } else {
                            throw new RuntimeException();
                        }
                        break;
                    case 3:
                        iA04 = c02274u.A04(8) + 29;
                        iA042 = c02274u.A04(2);
                        break;
                    default:
                        iA042 = 0;
                        break;
                }
            }
            if (iA04 != 0 && paint != null) {
                if (bArr != null) {
                    iA042 = bArr[iA042];
                }
                paint.setColor(iArr[iA042]);
                canvas.drawRect(i, i2, i + iA04, i2 + 1, paint);
            }
            i += iA04;
        } while (!z);
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0071 A[PHI: r0
      0x0071: PHI (r0v20 int) = (r0v18 int), (r0v23 int) binds: [B:25:0x0080, B:22:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A02(C02274u c02274u, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int iA04;
        int i3 = i;
        boolean z = false;
        do {
            int peek = 0;
            int iA042 = c02274u.A04(4);
            if (iA042 != 0) {
                peek = 1;
            } else if (c02274u.A0H()) {
                if (!c02274u.A0H()) {
                    peek = c02274u.A04(2) + 4;
                    iA042 = c02274u.A04(4);
                } else {
                    switch (c02274u.A04(2)) {
                        case 0:
                            peek = 1;
                            iA042 = 0;
                            break;
                        case 1:
                            peek = 2;
                            iA042 = 0;
                            break;
                        case 2:
                            peek = c02274u.A04(4) + 9;
                            iA042 = c02274u.A04(4);
                            break;
                        case 3:
                            peek = c02274u.A04(8) + 25;
                            iA042 = c02274u.A04(4);
                            break;
                        default:
                            iA042 = 0;
                            break;
                    }
                }
            } else if (A08[0].length() != 24) {
                A08[1] = "Jb849HVzYsbrcyVvorQRSzDXgxwzOwbS";
                iA04 = c02274u.A04(3);
                if (iA04 != 0) {
                    peek = iA04 + 2;
                    iA042 = 0;
                } else {
                    z = true;
                    iA042 = 0;
                }
            } else {
                A08[3] = "lCytI93sja9tcovqvw8Z3JcTVPPUQzad";
                iA04 = c02274u.A04(3);
                if (iA04 != 0) {
                }
            }
            if (peek != 0 && paint != null) {
                if (bArr != null) {
                    iA042 = bArr[iA042];
                }
                paint.setColor(iArr[iA042]);
                float f = i3;
                float f2 = i2;
                String[] strArr = A08;
                if (strArr[2].charAt(19) == strArr[6].charAt(19)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[2] = "7zyAW2neZYMKALasLQ64ygc21beBnsUa";
                strArr2[6] = "CykdyJVKnOvIvZ1RH2gJr9pO2NNGsRyJ";
                canvas.drawRect(f, f2, i3 + peek, i2 + 1, paint);
            }
            i3 += peek;
        } while (!z);
        return i3;
    }

    public static int A03(C02274u c02274u, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int runLength;
        int i3 = i;
        boolean z = false;
        do {
            int iA04 = c02274u.A04(8);
            if (iA04 != 0) {
                runLength = 1;
            } else if (!c02274u.A0H()) {
                runLength = c02274u.A04(7);
                if (runLength != 0) {
                    iA04 = 0;
                } else {
                    z = true;
                    runLength = 0;
                    iA04 = 0;
                }
            } else {
                runLength = c02274u.A04(7);
                iA04 = c02274u.A04(8);
            }
            if (runLength != 0 && paint != null) {
                if (bArr != null) {
                    iA04 = bArr[iA04];
                }
                paint.setColor(iArr[iA04]);
                if (A08[3].charAt(20) != '3') {
                    throw new RuntimeException();
                }
                A08[3] = "mqxvpcZRbZaRJOXRSA703vBu0XWYN9Vd";
                canvas.drawRect(i3, i2, i3 + runLength, i2 + 1, paint);
            }
            i3 += runLength;
        } while (!z);
        return i3;
    }

    public static C0598Jw A06(C02274u c02274u) {
        int iA04 = c02274u.A04(16);
        c02274u.A09(4);
        int objectCodingMethod = c02274u.A04(2);
        boolean zA0H = c02274u.A0H();
        c02274u.A09(1);
        byte[] bottomFieldData = C5C.A07;
        byte[] bArr = C5C.A07;
        if (objectCodingMethod == 1) {
            int numberOfCodes = c02274u.A04(8);
            c02274u.A09(numberOfCodes * 16);
        } else if (objectCodingMethod == 0) {
            int iA042 = c02274u.A04(16);
            int topFieldDataLength = c02274u.A04(16);
            int objectId = A08[4].charAt(14);
            if (objectId != 57) {
                throw new RuntimeException();
            }
            A08[7] = "H05iJqDXaQUoFjCcOPsdhLa69PYGJoEl";
            if (iA042 > 0) {
                bottomFieldData = new byte[iA042];
                c02274u.A0G(bottomFieldData, 0, iA042);
            }
            if (topFieldDataLength > 0) {
                bArr = new byte[topFieldDataLength];
                c02274u.A0G(bArr, 0, topFieldDataLength);
            } else {
                bArr = bottomFieldData;
            }
        }
        return new C0598Jw(iA04, zA0H, bottomFieldData, bArr);
    }

    public static C0599Jx A07(C02274u c02274u, int i) {
        int iA04 = c02274u.A04(8);
        int iA042 = c02274u.A04(4);
        int iA043 = c02274u.A04(2);
        c02274u.A09(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int remainingLength = c02274u.A04(8);
            c02274u.A09(8);
            int version = c02274u.A04(16);
            int timeoutSecs = c02274u.A04(16);
            i2 -= 6;
            sparseArray.put(remainingLength, new C0600Jy(version, timeoutSecs));
        }
        return new C0599Jx(iA04, iA042, iA043, sparseArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0B(C02274u c02274u, K1 k1) {
        int pageId = c02274u.A04(8);
        int iA04 = c02274u.A04(16);
        int iA042 = c02274u.A04(16);
        int dataFieldLimit = c02274u.A02() + iA042;
        int dataFieldLength = iA042 * 8;
        int segmentType = c02274u.A01();
        if (dataFieldLength > segmentType) {
            AbstractC02134g.A07(A09(31, 9, 48), A09(0, 31, 109));
            int segmentType2 = c02274u.A01();
            c02274u.A09(segmentType2);
            return;
        }
        switch (pageId) {
            case 16:
                int i = k1.A03;
                int dataFieldLength2 = A08[0].length();
                if (dataFieldLength2 != 24) {
                    A08[0] = "Hq1l6D9egrnTUyhluyir9I8C";
                    if (iA04 == i) {
                        C0599Jx c0599Jx = k1.A01;
                        C0599Jx c0599JxA07 = A07(c02274u, iA042);
                        int segmentType3 = c0599JxA07.A00;
                        if (segmentType3 != 0) {
                            k1.A01 = c0599JxA07;
                            k1.A08.clear();
                            k1.A06.clear();
                            k1.A07.clear();
                        } else if (c0599Jx != null) {
                            int dataFieldLength3 = c0599Jx.A02;
                            int segmentType4 = c0599JxA07.A02;
                            if (dataFieldLength3 != segmentType4) {
                                k1.A01 = c0599JxA07;
                            }
                        }
                    }
                    break;
                } else {
                    String[] strArr = A08;
                    strArr[2] = "8IE5rQcmaz5UZt5DB4HgynTP0JDS9G2L";
                    strArr[6] = "0jBafq8KrrfMTCoyXHA3EFrvXh6eCdvZ";
                    if (iA04 == i) {
                    }
                }
                break;
            case 17:
                C0599Jx c0599Jx2 = k1.A01;
                int segmentType5 = k1.A03;
                if (iA04 == segmentType5 && c0599Jx2 != null) {
                    C0601Jz c0601JzA08 = A08(c02274u, iA042);
                    int i2 = c0599Jx2.A00;
                    int dataFieldLength4 = A08[4].charAt(14);
                    if (dataFieldLength4 != 57) {
                        String[] strArr2 = A08;
                        strArr2[2] = "Zbq5EbbYoVc51AepmzNMcu8RWeX9tFKS";
                        strArr2[6] = "SzpXTRUgh7e1fMrIr1mTDXGfSUuiig9T";
                        if (i2 == 0) {
                            SparseArray<C0601Jz> sparseArray = k1.A08;
                            int segmentType6 = c0601JzA08.A03;
                            C0601Jz c0601Jz = sparseArray.get(segmentType6);
                            if (c0601Jz != null) {
                                c0601JzA08.A00(c0601Jz);
                            }
                        }
                        SparseArray<C0601Jz> sparseArray2 = k1.A08;
                        int segmentType7 = c0601JzA08.A03;
                        sparseArray2.put(segmentType7, c0601JzA08);
                    } else {
                        A08[0] = "ijH7h91dhg9QFNoxZPsrwXGu";
                        if (i2 == 0) {
                        }
                        SparseArray<C0601Jz> sparseArray22 = k1.A08;
                        int segmentType72 = c0601JzA08.A03;
                        sparseArray22.put(segmentType72, c0601JzA08);
                    }
                }
                break;
            case 18:
                int segmentType8 = k1.A03;
                if (iA04 == segmentType8) {
                    C0596Ju c0596JuA04 = A04(c02274u, iA042);
                    SparseArray<C0596Ju> sparseArray3 = k1.A06;
                    int segmentType9 = c0596JuA04.A00;
                    sparseArray3.put(segmentType9, c0596JuA04);
                } else {
                    int segmentType10 = k1.A02;
                    if (iA04 == segmentType10) {
                        C0596Ju c0596JuA042 = A04(c02274u, iA042);
                        SparseArray<C0596Ju> sparseArray4 = k1.A04;
                        int segmentType11 = c0596JuA042.A00;
                        sparseArray4.put(segmentType11, c0596JuA042);
                    }
                }
                break;
            case 19:
                int segmentType12 = k1.A03;
                if (iA04 == segmentType12) {
                    C0598Jw c0598JwA06 = A06(c02274u);
                    SparseArray<C0598Jw> sparseArray5 = k1.A07;
                    int segmentType13 = c0598JwA06.A00;
                    sparseArray5.put(segmentType13, c0598JwA06);
                } else {
                    int segmentType14 = k1.A02;
                    if (iA04 == segmentType14) {
                        C0598Jw c0598JwA062 = A06(c02274u);
                        SparseArray<C0598Jw> sparseArray6 = k1.A05;
                        int i3 = c0598JwA062.A00;
                        int dataFieldLength5 = A08[0].length();
                        if (dataFieldLength5 != 24) {
                            throw new RuntimeException();
                        }
                        A08[3] = "cNAVN6CCWtYeoU1m0uPi3L7jVIjjgAwx";
                        sparseArray6.put(i3, c0598JwA062);
                    }
                }
                break;
            case 20:
                int segmentType15 = k1.A03;
                if (iA04 == segmentType15) {
                    k1.A00 = A05(c02274u);
                }
                break;
        }
        int segmentType16 = c02274u.A02();
        c02274u.A0A(dataFieldLimit - segmentType16);
    }

    public static void A0C(C0598Jw c0598Jw, C0596Ju c0596Ju, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = c0596Ju.A03;
        } else if (i == 2) {
            iArr = c0596Ju.A02;
        } else {
            iArr = c0596Ju.A01;
        }
        A0D(c0598Jw.A03, iArr, i, i2, i3, paint, canvas);
        A0D(c0598Jw.A02, iArr, i, i2, i3 + 1, paint, canvas);
    }

    public static void A0D(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int i4 = i3;
        C02274u c02274u = new C02274u(bArr);
        byte[] clutMapTable2To8 = null;
        byte[] clutMapTable2To4 = null;
        byte[] bArrA0E = null;
        int line = i2;
        while (c02274u.A01() != 0) {
            switch (c02274u.A04(8)) {
                case 16:
                    if (i == 3) {
                        bArr2 = clutMapTable2To4 == null ? A0A : clutMapTable2To4;
                    } else if (i == 2) {
                        bArr2 = clutMapTable2To8 == null ? A09 : clutMapTable2To8;
                    } else {
                        bArr2 = null;
                    }
                    line = A01(c02274u, iArr, bArr2, line, i4, paint, canvas);
                    c02274u.A06();
                    break;
                case 17:
                    if (i == 3) {
                        bArr3 = bArrA0E == null ? A0B : bArrA0E;
                    } else {
                        bArr3 = null;
                    }
                    line = A02(c02274u, iArr, bArr3, line, i4, paint, canvas);
                    c02274u.A06();
                    break;
                case 18:
                    line = A03(c02274u, iArr, null, line, i4, paint, canvas);
                    break;
                case 32:
                    clutMapTable2To8 = A0E(4, 4, c02274u);
                    break;
                case 33:
                    clutMapTable2To4 = A0E(4, 8, c02274u);
                    break;
                case 34:
                    bArrA0E = A0E(16, 8, c02274u);
                    break;
                case 240:
                    i4 += 2;
                    line = i2;
                    break;
            }
        }
    }

    public static byte[] A0E(int i, int i2, C02274u c02274u) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) c02274u.A04(i2);
        }
        return bArr;
    }

    public static int[] A0F() {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = -1;
        iArr[2] = -16777216;
        String[] strArr = A08;
        if (strArr[2].charAt(19) == strArr[6].charAt(19)) {
            throw new RuntimeException();
        }
        A08[1] = "Jw8cEdbjQQjFC79Gk6sPH9AUdvvWBQg4";
        iArr[3] = -8421505;
        return iArr;
    }

    public static int[] A0G() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < iArr.length; i++) {
            if (i < 8) {
                int i2 = (i & 1) != 0 ? PHIpAddressSearchManager.END_IP_SCAN : 0;
                iArr[i] = A00(PHIpAddressSearchManager.END_IP_SCAN, i2, (i & 2) != 0 ? PHIpAddressSearchManager.END_IP_SCAN : 0, (i & 4) != 0 ? PHIpAddressSearchManager.END_IP_SCAN : 0);
            } else {
                int i3 = (i & 1) != 0 ? 127 : 0;
                int i4 = (i & 2) != 0 ? 127 : 0;
                int i5 = i & 4;
                if (A08[4].charAt(14) != '9') {
                    throw new RuntimeException();
                }
                A08[3] = "UrHD9QQTZDyJKzMppguU3aPtXoZ0irSR";
                iArr[i] = A00(PHIpAddressSearchManager.END_IP_SCAN, i3, i4, i5 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x0029, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] A0H() {
        int i;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = PHIpAddressSearchManager.END_IP_SCAN;
            if (i2 < 8) {
                int i4 = (i2 & 1) != 0 ? PHIpAddressSearchManager.END_IP_SCAN : 0;
                int i5 = (i2 & 2) != 0 ? PHIpAddressSearchManager.END_IP_SCAN : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = A00(63, i4, i5, i3);
            } else {
                switch (i2 & 136) {
                    case 0:
                        int i6 = (i2 & 1) != 0 ? 85 : 0;
                        iArr[i2] = A00(PHIpAddressSearchManager.END_IP_SCAN, i6 + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                        break;
                    case 8:
                        int i7 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                        int i8 = i2 & 2;
                        if (A08[4].charAt(14) != '9') {
                            i = i8 != 0 ? 85 : 0;
                        } else {
                            A08[0] = "s2RCWxPvpwpJ3GpvuxZigl51";
                            if (i8 != 0) {
                            }
                        }
                        iArr[i2] = A00(127, i7, i + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                        break;
                    case 128:
                        int i9 = ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0);
                        int i10 = ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0);
                        int i11 = ((i2 & 4) == 0 ? 0 : 43) + 127;
                        int i12 = i2 & 64;
                        if (A08[7].charAt(9) != 'e') {
                            A08[3] = "e63e4cS46GPtzp0vrxC333RpnvVdNaZZ";
                            iArr[i2] = A00(PHIpAddressSearchManager.END_IP_SCAN, i9, i10, i11 + (i12 == 0 ? 0 : 85));
                        } else {
                            throw new RuntimeException();
                        }
                        break;
                    case 136:
                        int i13 = (i2 & 1) != 0 ? 43 : 0;
                        iArr[i2] = A00(PHIpAddressSearchManager.END_IP_SCAN, i13 + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                        break;
                }
            }
        }
        return iArr;
    }

    public final void A0J() {
        this.A06.A00();
    }
}
