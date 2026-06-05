package com.ftdi.j2xx;

/* JADX INFO: loaded from: classes3.dex */
abstract class FT_BaudRate {
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int FT_CalcBaudRate(int i, int i2, boolean z) {
        if (i == 0) {
            return 3000000;
        }
        int i3 = ((-49153) & i) * 100;
        if (!z) {
            int i4 = i & 49152;
            if (i4 == 16384) {
                i3 += 50;
            } else if (i4 == 32768) {
                i3 += 25;
            } else if (i4 == 49152) {
                i3 += 12;
            }
        } else if (i2 == 0) {
            int i5 = i & 49152;
            if (i5 != 16384) {
                if (i5 != 32768) {
                    if (i5 == 49152) {
                    }
                }
            }
        } else {
            int i6 = i & 49152;
            if (i6 == 0) {
                i3 += 37;
            } else if (i6 == 16384) {
                i3 += 62;
            } else if (i6 == 32768) {
                i3 += 75;
            } else if (i6 == 49152) {
                i3 += 87;
            }
        }
        return 300000000 / i3;
    }

    private static int FT_CalcBaudRateHi(int i, int i2) {
        if (i == 0) {
            return 12000000;
        }
        if (i == 1) {
            return 8000000;
        }
        int i3 = ((-49153) & i) * 100;
        if ((i2 & 65533) == 0) {
            int i4 = i & 49152;
            if (i4 == 16384) {
                i3 += 50;
            } else if (i4 == 32768) {
                i3 += 25;
            } else if (i4 == 49152) {
                i3 += 12;
            }
        } else {
            int i5 = i & 49152;
            if (i5 == 0) {
                i3 += 37;
            } else if (i5 == 16384) {
                i3 += 62;
            } else if (i5 == 32768) {
                i3 += 75;
            } else if (i5 == 49152) {
                i3 += 87;
            }
        }
        return 1200000000 / i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte FT_CalcDivisor(int i, int[] iArr, boolean z) {
        if (i == 0) {
            return (byte) -1;
        }
        int i2 = 3000000 / i;
        if ((i2 & (-16384)) > 0) {
            return (byte) -1;
        }
        iArr[0] = i2;
        byte b = 1;
        iArr[1] = 0;
        if (i2 == 1 && ((3000000 % i) * 100) / i <= 3) {
            iArr[0] = 0;
        }
        int i3 = iArr[0];
        if (i3 == 0) {
            return (byte) 1;
        }
        int i4 = ((3000000 % i) * 100) / i;
        int i5 = 16384;
        if (z) {
            if (i4 > 6) {
                if (i4 > 18) {
                    if (i4 > 31) {
                        if (i4 <= 43) {
                            iArr[1] = 1;
                            i5 = 0;
                        } else if (i4 > 56) {
                            if (i4 <= 68) {
                                iArr[1] = 1;
                            } else if (i4 <= 81) {
                                iArr[1] = 1;
                                i5 = 32768;
                            } else {
                                if (i4 <= 93) {
                                    iArr[1] = 1;
                                    i5 = 49152;
                                }
                                b = 0;
                                i5 = 0;
                            }
                        }
                    }
                }
            }
        } else if (i4 <= 6) {
            i5 = 0;
        } else if (i4 <= 18) {
            i5 = 49152;
        } else if (i4 <= 37) {
            i5 = 32768;
        } else if (i4 > 75) {
            b = 0;
            i5 = 0;
        }
        iArr[0] = i3 | i5;
        return b;
    }

    private static byte FT_CalcDivisorHi(int i, int[] iArr) {
        int i2;
        if (i == 0) {
            return (byte) -1;
        }
        int i3 = 12000000 / i;
        if ((i3 & (-16384)) > 0) {
            return (byte) -1;
        }
        byte b = 1;
        iArr[1] = 2;
        if (i >= 11640000 && i <= 12360000) {
            iArr[0] = 0;
            return (byte) 1;
        }
        if (i >= 7760000 && i <= 8240000) {
            iArr[0] = 1;
            return (byte) 1;
        }
        iArr[0] = i3;
        iArr[1] = 2;
        if (i3 == 1 && ((12000000 % i) * 100) / i <= 3) {
            iArr[0] = 0;
        }
        int i4 = iArr[0];
        if (i4 == 0) {
            return (byte) 1;
        }
        int i5 = ((12000000 % i) * 100) / i;
        if (i5 <= 6) {
            i2 = 0;
        } else {
            i2 = 49152;
            if (i5 > 18) {
                if (i5 <= 31) {
                    i2 = 32768;
                } else if (i5 <= 43) {
                    iArr[1] = 2 | 1;
                    i2 = 0;
                } else if (i5 <= 56) {
                    i2 = 16384;
                } else if (i5 <= 68) {
                    iArr[1] = 2 | 1;
                    i2 = 16384;
                } else if (i5 <= 81) {
                    iArr[1] = 2 | 1;
                    i2 = 32768;
                } else if (i5 <= 93) {
                    iArr[1] = 2 | 1;
                } else {
                    b = 0;
                    i2 = 0;
                }
            }
        }
        iArr[0] = i4 | i2;
        return b;
    }

    public static byte FT_GetDivisor(int i, int[] iArr, boolean z) {
        int i2;
        int i3;
        byte bFT_CalcDivisor = FT_CalcDivisor(i, iArr, z);
        if (bFT_CalcDivisor == -1) {
            return (byte) -1;
        }
        if (bFT_CalcDivisor == 0) {
            iArr[0] = (iArr[0] & (-49153)) + 1;
        }
        int iFT_CalcBaudRate = FT_CalcBaudRate(iArr[0], iArr[1], z);
        if (i > iFT_CalcBaudRate) {
            i2 = ((i * 100) / iFT_CalcBaudRate) - 100;
            i3 = ((i % iFT_CalcBaudRate) * 100) % iFT_CalcBaudRate;
        } else {
            i2 = ((iFT_CalcBaudRate * 100) / i) - 100;
            i3 = ((iFT_CalcBaudRate % i) * 100) % i;
        }
        if (i2 < 3) {
            return (byte) 1;
        }
        return (i2 == 3 && i3 == 0) ? (byte) 1 : (byte) 0;
    }

    public static final byte FT_GetDivisorHi(int i, int[] iArr) {
        int i2;
        int i3;
        byte bFT_CalcDivisorHi = FT_CalcDivisorHi(i, iArr);
        if (bFT_CalcDivisorHi == -1) {
            return (byte) -1;
        }
        if (bFT_CalcDivisorHi == 0) {
            iArr[0] = (iArr[0] & (-49153)) + 1;
        }
        int iFT_CalcBaudRateHi = FT_CalcBaudRateHi(iArr[0], iArr[1]);
        if (i > iFT_CalcBaudRateHi) {
            i2 = ((i * 100) / iFT_CalcBaudRateHi) - 100;
            i3 = ((i % iFT_CalcBaudRateHi) * 100) % iFT_CalcBaudRateHi;
        } else {
            i2 = ((iFT_CalcBaudRateHi * 100) / i) - 100;
            i3 = ((iFT_CalcBaudRateHi % i) * 100) % i;
        }
        if (i2 < 3) {
            return (byte) 1;
        }
        return (i2 == 3 && i3 == 0) ? (byte) 1 : (byte) 0;
    }
}
