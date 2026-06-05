package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.p5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1907p5 extends C02345b {
    public static byte[] A02;
    public final int A00;
    public final C02415i A01;

    static {
        A06();
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A02 = new byte[]{-39, -30, -37, -41, -24, -22, -37, -18, -22, -92, -96, -28, -27, -22, -106, -26, -37, -24, -29, -33, -22, -22, -37, -38, -92, -96};
    }

    public C1907p5(C02415i c02415i, int i, int i2) {
        super(A03(i, i2));
        this.A01 = c02415i;
        this.A00 = i2;
    }

    public C1907p5(IOException iOException, C02415i c02415i, int i, int i2) {
        super(iOException, A03(i, i2));
        this.A01 = c02415i;
        this.A00 = i2;
    }

    public C1907p5(String str, C02415i c02415i, int i, int i2) {
        super(str, A03(i, i2));
        this.A01 = c02415i;
        this.A00 = i2;
    }

    public C1907p5(String str, IOException iOException, C02415i c02415i, int i, int i2) {
        super(str, iOException, A03(i, i2));
        this.A01 = c02415i;
        this.A00 = i2;
    }

    public static int A03(int i, int i2) {
        if (i == 2000 && i2 == 1) {
            return 2001;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1907p5 A04(IOException iOException, C02415i c02415i, int i) {
        int errorCode;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            errorCode = AdError.CACHE_ERROR_CODE;
        } else if (iOException instanceof InterruptedIOException) {
            errorCode = 1004;
        } else if (message != null) {
            String strA01 = AbstractC1616k7.A01(message);
            String message2 = A05(0, 26, 62);
            if (strA01.matches(message2)) {
                errorCode = 2007;
            } else {
                errorCode = 2001;
            }
        }
        if (errorCode == 2007) {
            return new AM(iOException, c02415i);
        }
        return new C1907p5(iOException, c02415i, errorCode, i);
    }
}
