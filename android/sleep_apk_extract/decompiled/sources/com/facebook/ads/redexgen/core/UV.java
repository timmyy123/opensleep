package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum UV {
    A03,
    A05,
    A04;

    public static byte[] A00;
    public static String[] A01 = {"seqAlwXEOvzJRT", "2kwhh1C9lzELPF4tFLY2", "Jj", "sVBc1MgsVLAc0bDFJylP1xNQuOv", "HeA0CnCob9O6sWYI", "hyCzZMBJpVm0WSm5X0p8b9", "uKys1875npMZUjGe7nShhq", "p4I3Upmes50ZeKIDqz8mdw8ttLtPhh"};

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            A01[3] = "YOiRDsLdwk415VnA";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 80);
            i4++;
        }
    }

    public static void A01() {
        A00 = new byte[]{93, 94, 79, 88, 83, 94, 95, 68, 73, 94, 88, 84, 73, 95, 72, 72, 75, 90, 77, 70, 81, 76, 91, 72, 72, 75, 92, 81, 90, 65, 65, 81, 93, 67, 79, 66, 66, 88, 89, 73, 68, 83, 85, 89, 68, 82, 69, 73, 66, 89, 73, 80, 83, 66, 85, 94};
    }

    static {
        A01();
    }
}
