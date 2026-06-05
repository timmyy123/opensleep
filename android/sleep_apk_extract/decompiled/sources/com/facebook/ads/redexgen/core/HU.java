package com.facebook.ads.redexgen.core;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class HU {
    public static String[] A04 = {"xqK2Lo9z9A1fq6AmzHgSANRckQSbvLg7", "r87Jk1TDX4QDRIaoZWvBkBULXd6iRGy1", "O8Rd55zCWOMZlt38o2yZqibVFCpM9qBW", "4N74z6RiBgc3GZHRgJ9RjrwcKA2Sbu4k", "rTO2Tuhk28L6aGO7sMrwgJqOHaARqGQ4", "wV6nIrgfSj92E7JYn8Dcxr40UnK38ksI", "xhpcFCDiO5Y2wtHgWJ12k6gPj7fKn5Nf", "gVHczwThIZ3ivnhVZg4GXcBO3FodCEeQ"};
    public int A00;
    public int A01;
    public int A02;
    public byte[] A03;

    public HU(byte[] bArr, int i, int i2) {
        A08(bArr, i, i2);
    }

    private int A00() {
        int i = 0;
        while (!A0A()) {
            i++;
        }
        int i2 = (1 << i) - 1;
        int leadingZeros = i > 0 ? A05(i) : 0;
        return i2 + leadingZeros;
    }

    private void A01() {
        AbstractC02053y.A08(this.A02 >= 0 && (this.A02 < this.A01 || (this.A02 == this.A01 && this.A00 == 0)));
        String[] strArr = A04;
        if (strArr[5].charAt(17) == strArr[0].charAt(17)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[4] = "rbUb6Xt6pPTA8n7h1lny7mpNeejrLbnq";
        strArr2[1] = "r9GQrTTZLq4j6OnUyTd1FCUw4PnbqYK4";
    }

    private boolean A02(int i) {
        if (2 <= i && i < this.A01 && this.A03[i] == 3 && this.A03[i - 2] == 0) {
            byte[] bArr = this.A03;
            String[] strArr = A04;
            if (strArr[3].charAt(14) != strArr[6].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[3] = "mTSOM4VXL5Qz6aHfzfUvwcrlrHOw2Zy6";
            strArr2[6] = "LbZWpLfoz4TupHHNd8RSjDzMBM5OqJ05";
            if (bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final int A03() {
        int iA00 = A00();
        int codeNum = iA00 % 2;
        int i = codeNum == 0 ? -1 : 1;
        int codeNum2 = iA00 + 1;
        return i * (codeNum2 / 2);
    }

    public final int A04() {
        return A00();
    }

    public final int A05(int i) {
        int i2 = 0;
        int returnValue = this.A00;
        this.A00 = returnValue + i;
        while (true) {
            int returnValue2 = this.A00;
            if (returnValue2 <= 8) {
                break;
            }
            int returnValue3 = this.A00;
            this.A00 = returnValue3 - 8;
            byte[] bArr = this.A03;
            int returnValue4 = this.A02;
            int i3 = bArr[returnValue4] & PHIpAddressSearchManager.END_IP_SCAN;
            int returnValue5 = this.A00;
            i2 |= i3 << returnValue5;
            int i4 = this.A02;
            int returnValue6 = this.A02;
            if (!A02(returnValue6 + 1)) {
                i = 1;
            }
            this.A02 = i4 + i;
        }
        byte[] bArr2 = this.A03;
        int returnValue7 = this.A02;
        int i5 = bArr2[returnValue7] & PHIpAddressSearchManager.END_IP_SCAN;
        int returnValue8 = this.A00;
        int i6 = i2 | (i5 >> (8 - returnValue8));
        int i7 = 32 - i;
        String[] strArr = A04;
        String str = strArr[5];
        String str2 = strArr[0];
        int iCharAt = str.charAt(17);
        int returnValue9 = str2.charAt(17);
        if (iCharAt == returnValue9) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[2] = "RXY6xLJuKIcEz3kUylWDYr6tsmitvphK";
        strArr2[7] = "WXiq34WZkyW8ugzR2g0a8ipZBHhkiRcU";
        int returnValue10 = (-1) >>> i7;
        int i8 = i6 & returnValue10;
        int returnValue11 = this.A00;
        if (returnValue11 == 8) {
            this.A00 = 0;
            int i9 = this.A02;
            int returnValue12 = this.A02;
            int i10 = i9 + (A02(returnValue12 + 1) ? 2 : 1);
            String[] strArr3 = A04;
            String str3 = strArr3[4];
            String str4 = strArr3[1];
            int iCharAt2 = str3.charAt(0);
            int returnValue13 = str4.charAt(0);
            if (iCharAt2 != returnValue13) {
                String[] strArr4 = A04;
                strArr4[4] = "rds4vupX8r7j5bNz4Ka4tPduGPmVtsGV";
                strArr4[1] = "rRPYe8lZfiAZtF0hvmlKmZn0YXaVPkJ6";
                this.A02 = i10;
            } else {
                String[] strArr5 = A04;
                strArr5[3] = "oP8krBIP0DDB0MHyD3CqohM2a51fTyLT";
                strArr5[6] = "8dOgzrP5xxQxSwHCAu2NrFg9fwsPMfLi";
                this.A02 = i10;
            }
        }
        A01();
        return i8;
    }

    public final void A06() {
        int i = this.A00 + 1;
        this.A00 = i;
        if (i == 8) {
            this.A00 = 0;
            this.A02 += A02(this.A02 + 1) ? 2 : 1;
        }
        A01();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A07(int i) {
        int oldByteOffset;
        int i2 = this.A02;
        int i3 = i / 8;
        int oldByteOffset2 = this.A02;
        this.A02 = oldByteOffset2 + i3;
        int numBytes = this.A00;
        int oldByteOffset3 = i3 * 8;
        this.A00 = numBytes + (i - oldByteOffset3);
        int numBytes2 = this.A00;
        if (numBytes2 > 7) {
            int oldByteOffset4 = this.A02;
            this.A02 = oldByteOffset4 + 1;
            String[] strArr = A04;
            String str = strArr[3];
            String str2 = strArr[6];
            int numBytes3 = str.charAt(14);
            int oldByteOffset5 = str2.charAt(14);
            if (numBytes3 == oldByteOffset5) {
                String[] strArr2 = A04;
                strArr2[5] = "JMOXq6hG4yZwGcrVKWuSo4mZKx3jwnv0";
                strArr2[0] = "8hcVzozxp8VhJG7sJROCpbfriQIXRjxB";
                int oldByteOffset6 = this.A00;
                this.A00 = oldByteOffset6 - 8;
                while (true) {
                    i2++;
                    oldByteOffset = this.A02;
                    if (i2 > oldByteOffset) {
                        boolean zA02 = A02(i2);
                        String[] strArr3 = A04;
                        String str3 = strArr3[4];
                        String str4 = strArr3[1];
                        int numBytes4 = str3.charAt(0);
                        int oldByteOffset7 = str4.charAt(0);
                        if (numBytes4 != oldByteOffset7) {
                            break;
                        }
                        String[] strArr4 = A04;
                        strArr4[3] = "ItBao4LZOiviF1HOEk7WTyNzP7shwqmG";
                        strArr4[6] = "at4dJT6xDps7byHlzjkGtuWM4RrUB1u7";
                        if (zA02) {
                            int oldByteOffset8 = this.A02;
                            this.A02 = oldByteOffset8 + 1;
                            i2 += 2;
                        }
                    } else {
                        A01();
                        return;
                    }
                }
            }
        } else {
            while (true) {
                i2++;
                oldByteOffset = this.A02;
                if (i2 > oldByteOffset) {
                }
            }
        }
        throw new RuntimeException();
    }

    public final void A08(byte[] bArr, int i, int i2) {
        this.A03 = bArr;
        this.A02 = i;
        this.A01 = i2;
        this.A00 = 0;
        A01();
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0009 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A09() {
        int i = this.A02;
        int i2 = this.A00;
        int i3 = 0;
        while (initialBitOffset < initialByteOffset && !A0A()) {
            i3++;
        }
        int i4 = this.A02;
        int initialByteOffset = this.A01;
        int initialByteOffset2 = i4 == initialByteOffset ? 1 : 0;
        this.A02 = i;
        this.A00 = i2;
        if (initialByteOffset2 != 0) {
            return false;
        }
        int initialByteOffset3 = i3 * 2;
        return A0B(initialByteOffset3 + 1);
    }

    public final boolean A0A() {
        boolean returnValue = (this.A03[this.A02] & (128 >> this.A00)) != 0;
        A06();
        return returnValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A0B(int i) {
        int i2;
        int i3 = this.A02;
        int oldByteOffset = i / 8;
        int i4 = this.A02 + oldByteOffset;
        int newBitOffset = (this.A00 + i) - (oldByteOffset * 8);
        if (newBitOffset > 7) {
            i4++;
            String[] strArr = A04;
            String str = strArr[4];
            String str2 = strArr[1];
            int numBytes = str.charAt(0);
            if (numBytes == str2.charAt(0)) {
                String[] strArr2 = A04;
                strArr2[2] = "4R3sKytGl1afrKMjnsBwna0p74CJayfl";
                strArr2[7] = "DtV04uWRet80XDEpYPrFh03isGofLap7";
                newBitOffset -= 8;
                i2 = i3 + 1;
                while (i2 <= i4) {
                    int i5 = this.A01;
                    String[] strArr3 = A04;
                    String str3 = strArr3[5];
                    String str4 = strArr3[0];
                    int numBytes2 = str3.charAt(17);
                    if (numBytes2 != str4.charAt(17)) {
                        String[] strArr4 = A04;
                        strArr4[4] = "ru8g1XQo0WAy59nUdKAzfoQ85z62h8So";
                        strArr4[1] = "rlk5s9hHQFi3gmvg8c7PRJF1MfkgSAIS";
                        if (i4 >= i5) {
                            break;
                        }
                        if (A02(i2)) {
                            i4++;
                            i2 += 2;
                        }
                        i2++;
                    }
                }
                if (i4 < this.A01) {
                    return i4 == this.A01 && newBitOffset == 0;
                }
                return true;
            }
        } else {
            i2 = i3 + 1;
            while (i2 <= i4) {
            }
            if (i4 < this.A01) {
            }
        }
        throw new RuntimeException();
    }
}
