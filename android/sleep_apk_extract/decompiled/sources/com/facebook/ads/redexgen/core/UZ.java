package com.facebook.ads.redexgen.core;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class UZ {
    public static byte[] A01;
    public static String[] A02 = {"bU9TaOq2H1BCoTTudHgTa6noiTEuLI16", "3dC6vQggwfY", "sSGIgptGmRpdYm1DWaL7pn14ju5", "", "MWUI4wrCJQVvfxcejCMbIiiXK3H", "jomkRAByJcuN5WcossiIAnU6", "EV4d58k22VMnbcsySNbmwKm2xbXDyfIQ", "0y1Y4yK8RTgYo"};
    public final File A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[7].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[7] = "66mt0TcJLXpax";
            strArr2[1] = "NTsH2gO48Ko";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 122);
            i4++;
        }
    }

    public static void A02() {
        byte[] bArr = {7, 37, 42, 42, 43, 48, 100, 33, 42, 55, 49, 54, 33, 100, 99, 97, 55, 99, 100, 45, 55, 100, 37, 100, 32, 45, 54, 33, 39, 48, 43, 54, 61, 7, 32, 40, 45, 36, 37, 97, 53, 46, 97, 34, 51, 36, 32, 53, 36, 97, 37, 40, 51, 36, 34, 53, 46, 51, 56, 97, 102, 100, 50, 102, 124, 120, 105, 126, 113, 69, 118, 117, 125};
        String[] strArr = A02;
        if (strArr[3].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "";
        strArr2[5] = "lx0xFtkenAwJEtKSHitpjLSh";
        A01 = bArr;
    }

    static {
        A02();
    }

    public UZ(File file) {
        this.A00 = file;
    }

    public static UZ A00(String str, Context context) throws IOException {
        File filesDir = new File(context.getFilesDir(), A01(64, 9, 96));
        A03(filesDir);
        File fbsdklogDir = new File(filesDir, str);
        A03(fbsdklogDir);
        return new UZ(fbsdklogDir);
    }

    public static void A03(File file) throws IOException {
        if (file.exists() || file.mkdir()) {
            if (file.isDirectory()) {
                return;
            } else {
                throw new C0856Ua(String.format(Locale.US, A01(0, 33, 62), file.getCanonicalPath()));
            }
        }
        throw new C0856Ua(String.format(Locale.US, A01(33, 31, 59), file.getCanonicalPath()));
    }

    public final UZ A04(String str) throws IOException {
        File file = new File(this.A00, str);
        A03(file);
        return new UZ(file);
    }

    public final File A05() {
        return this.A00;
    }
}
