package com.facebook.ads.redexgen.core;

import android.media.AudioTrack;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.92, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass92 {
    public static String[] A06 = {"", "nhk", "6wGu", "R2WrInr05AqD6", "BdEvLx16NkmWuQrDJldKvob3T9iK8w4Y", "M6vHIG3eEec4aewABnTFZg6yiBplWKQQ", "QcLcQkrsijLVHbF72gur0", "onHOAzLdE60eB9RAzeJwCwAMM5cMFU2V"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public final AnonymousClass90 A05;

    public AnonymousClass92(AudioTrack audioTrack) {
        if (C5C.A02 >= 19) {
            this.A05 = new AnonymousClass90(audioTrack);
            A05();
        } else {
            this.A05 = null;
            A00(3);
        }
    }

    private void A00(int i) {
        this.A00 = i;
        switch (i) {
            case 0:
                this.A03 = 0L;
                this.A01 = -1L;
                this.A02 = System.nanoTime() / 1000;
                this.A04 = 5000L;
                return;
            case 1:
                this.A04 = 5000L;
                return;
            case 2:
            case 3:
                this.A04 = 10000000L;
                return;
            case 4:
                this.A04 = 500000L;
                return;
            default:
                throw new IllegalStateException();
        }
    }

    public final long A01() {
        if (this.A05 == null) {
            return -1L;
        }
        AnonymousClass90 anonymousClass90 = this.A05;
        String[] strArr = A06;
        if (strArr[3].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[5] = "Fw4LpErMEjjeSvAcoNX9TuPtkznMdbTC";
        strArr2[7] = "f0n5p1oCE9LYQx7aTjfY3rJEatpCWuo0";
        return anonymousClass90.A00();
    }

    public final long A02() {
        if (this.A05 != null) {
            return this.A05.A01();
        }
        return -9223372036854775807L;
    }

    public final void A03() {
        if (this.A00 == 4) {
            A05();
        }
    }

    public final void A04() {
        A00(4);
    }

    public final void A05() {
        if (this.A05 != null) {
            A00(0);
        }
    }

    public final boolean A06() {
        return this.A00 == 2;
    }

    public final boolean A07(long j) {
        if (this.A05 == null) {
            return false;
        }
        long j2 = this.A03;
        String[] strArr = A06;
        if (strArr[5].charAt(8) == strArr[7].charAt(8)) {
            A06[0] = "";
            if (j - j2 < this.A04) {
                return false;
            }
            this.A03 = j;
            boolean zA02 = this.A05.A02();
            int i = this.A00;
            String[] strArr2 = A06;
            if (strArr2[3].length() != strArr2[2].length()) {
                A06[0] = "";
                switch (i) {
                    case 0:
                        if (!zA02) {
                            if (j - this.A02 <= 500000) {
                                return zA02;
                            }
                            A00(3);
                            return zA02;
                        }
                        long jA01 = this.A05.A01();
                        long timestampPositionFrames = this.A02;
                        if (jA01 >= timestampPositionFrames) {
                            long jA00 = this.A05.A00();
                            String[] strArr3 = A06;
                            if (strArr3[6].length() != strArr3[1].length()) {
                                A06[4] = "9pDihLuu39ZUNEKcmAfhT2ejMoup6027";
                                this.A01 = jA00;
                                A00(1);
                                return zA02;
                            }
                        } else {
                            return false;
                        }
                        break;
                    case 1:
                        if (zA02) {
                            long jA002 = this.A05.A00();
                            long timestampPositionFrames2 = this.A01;
                            if (jA002 > timestampPositionFrames2) {
                                A00(2);
                                return zA02;
                            }
                            return zA02;
                        }
                        A05();
                        return zA02;
                    case 2:
                        if (!zA02) {
                            A05();
                            return zA02;
                        }
                        return zA02;
                    case 3:
                        if (zA02) {
                            A05();
                            return zA02;
                        }
                        return zA02;
                    case 4:
                        return zA02;
                    default:
                        throw new IllegalStateException();
                }
            } else {
                throw new RuntimeException();
            }
        }
        throw new RuntimeException();
    }
}
