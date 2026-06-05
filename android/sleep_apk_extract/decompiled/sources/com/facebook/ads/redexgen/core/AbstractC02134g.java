package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4g, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC02134g {
    public static int A00;
    public static InterfaceC02124f A01;
    public static boolean A02;
    public static byte[] A03;
    public static String[] A04 = {"pjC", "Ar4G3OSxcgl2D", "AarUE2nt7cnp4GdKoelKCQn2Jt4OXyEc", "B5uTmPcht7q4WCzfelpVRln9dVKzTr9W", "36fORse15dXsGKgrcWq47HxFqRHPKtSm", "Eh56lsHHP32qxPGDjQKhG4rai7NSZl8p", "QN71kq8063jCyPpsf", "zuMcuSAj79dOj6A3T"};
    public static final Object A05;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] - i3;
            if (A04[1].length() == 28) {
                throw new RuntimeException();
            }
            A04[0] = "EwS";
            bArrCopyOfRange[i4] = (byte) (i5 - 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{-58, -65, 127, -107, -107, 4, 4, 4, 4, -8, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 17, 18, 26, 17, -21, 18, 22, 23, -24, 27, 6, 8, 19, 23, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 18, 17, -61, -53, 17, 18, -61, 17, 8, 23, 26, 18, 21, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -52};
    }

    static {
        A03();
        A05 = new Object();
        A00 = 0;
        A02 = true;
        A01 = InterfaceC02124f.A00;
    }

    @Pure
    public static String A01(String str, Throwable th) {
        String strA02 = A02(th);
        if (!TextUtils.isEmpty(strA02)) {
            StringBuilder sbAppend = new StringBuilder().append(str);
            String strA00 = A00(2, 3, 2);
            StringBuilder sbAppend2 = sbAppend.append(strA00);
            String throwableString = A00(1, 1, 66);
            return sbAppend2.append(strA02.replace(throwableString, strA00)).append('\n').toString();
        }
        return str;
    }

    @Pure
    public static String A02(Throwable th) {
        synchronized (A05) {
            if (th == null) {
                return null;
            }
            if (A0B(th)) {
                return A00(9, 33, 48);
            }
            if (!A02) {
                return th.getMessage();
            }
            return Log.getStackTraceString(th).trim().replace(A00(0, 1, 74), A00(5, 4, 113));
        }
    }

    @Pure
    public static void A04(String str, String str2) {
        synchronized (A05) {
            int i = A00;
        }
    }

    @Pure
    public static void A05(String str, String str2) {
        synchronized (A05) {
            if (A00 <= 3) {
                A01.A6H(str, str2);
            }
        }
    }

    @Pure
    public static void A06(String str, String str2) {
        synchronized (A05) {
            if (A00 <= 1) {
                A01.A9t(str, str2);
            }
        }
    }

    @Pure
    public static void A07(String str, String str2) {
        synchronized (A05) {
            if (A00 <= 2) {
                A01.AKm(str, str2);
            }
        }
    }

    @Pure
    public static void A08(String str, String str2, Throwable th) {
        A05(str, A01(str2, th));
    }

    @Pure
    public static void A09(String str, String str2, Throwable th) {
        A06(str, A01(str2, th));
    }

    @Pure
    public static void A0A(String str, String str2, Throwable th) {
        A07(str, A01(str2, th));
    }

    @Pure
    public static boolean A0B(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                String[] strArr = A04;
                if (strArr[3].charAt(22) != strArr[2].charAt(22)) {
                    throw new RuntimeException();
                }
                A04[1] = "Bi";
                return true;
            }
            th = th.getCause();
        }
        return false;
    }
}
