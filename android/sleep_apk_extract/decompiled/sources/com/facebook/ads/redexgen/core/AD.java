package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appfunctions.AppFunctionException;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AD extends C1962pz {
    public static byte[] A07;
    public static final AnonymousClass23<AD> A08;
    public static final String A09;
    public static final String A0A;
    public static final String A0B;
    public static final String A0C;
    public static final String A0D;
    public static final String A0E;
    public final boolean A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final C1981qI A04;
    public final C3C A05;
    public final String A06;

    public static /* synthetic */ AD A00(Bundle bundle) {
        return new AD(bundle);
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{120, -67, -54, -54, -57, -54, -124, 120, -63, -58, -68, -67, -48, -107, -83, -95, -25, -16, -13, -18, -30, -11, -66, -37, -49, 21, 30, 33, 28, 16, 35, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 34, 36, 31, 31, 30, 33, 35, 20, 19, -20, -21, -47, -45, -26, -18, -16, -11, -26, -95, -26, -13, -13, -16, -13, -53, -25, -19, -22, -37, -35, -104, -35, -22, -22, -25, -22, -50, -25, -34, -15, -23, -34, -36, -19, -34, -35, -103, -21, -18, -25, -19, -30, -26, -34, -103, -34, -21, -21, -24, -21};
    }

    static {
        A07();
        A08 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.ot
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return AD.A00(bundle);
            }
        };
        A0E = C5C.A0h(1001);
        A0D = C5C.A0h(1002);
        A0C = C5C.A0h(AppFunctionException.ERROR_FUNCTION_NOT_FOUND);
        A0A = C5C.A0h(1004);
        A0B = C5C.A0h(1005);
        A09 = C5C.A0h(1006);
    }

    public AD(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, false);
    }

    public AD(int i, Throwable th, String str, int i2, String str2, int i3, C1981qI c1981qI, int i4, boolean z) {
        this(A06(i, th, str, str2, i3, c1981qI, i4), th, i2, i, str2, i3, c1981qI, i4, null, SystemClock.elapsedRealtime(), z);
    }

    public AD(Bundle bundle) {
        C1981qI c1981qI;
        super(bundle);
        this.A03 = bundle.getInt(A0E, 2);
        this.A06 = bundle.getString(A0D);
        this.A02 = bundle.getInt(A0C, -1);
        Bundle bundle2 = bundle.getBundle(A0A);
        if (bundle2 == null) {
            c1981qI = null;
        } else {
            c1981qI = (C1981qI) C1981qI.A0b.A6f(bundle2);
        }
        this.A04 = c1981qI;
        this.A01 = bundle.getInt(A0B, 4);
        this.A00 = bundle.getBoolean(A09, false);
        this.A05 = null;
    }

    public AD(String str, Throwable th, int i, int i2, String str2, int i3, C1981qI c1981qI, int i4, C3C c3c, long j, boolean z) {
        super(str, th, i, j);
        AbstractC02053y.A07(!z || i2 == 1);
        AbstractC02053y.A07(th != null || i2 == 3);
        this.A03 = i2;
        this.A06 = str2;
        this.A02 = i3;
        this.A04 = c1981qI;
        this.A01 = i4;
        this.A05 = c3c;
        this.A00 = z;
    }

    public static AD A01(IOException iOException, int i) {
        return new AD(0, iOException, i);
    }

    @Deprecated
    public static AD A02(RuntimeException runtimeException) {
        return A03(runtimeException, 1000);
    }

    public static AD A03(RuntimeException runtimeException, int i) {
        return new AD(2, runtimeException, i);
    }

    public static AD A04(Throwable th, String str, int i, C1981qI c1981qI, int i2, boolean z, int i3) {
        int i4 = i2;
        if (c1981qI == null) {
            i4 = 4;
        }
        return new AD(1, th, null, i3, str, i, c1981qI, i4, z);
    }

    public static String A06(@MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}, value = "Throwable cause - linked with Error reporting") int i, Throwable th, String str, String str2, int i2, C1981qI c1981qI, int i3) {
        String message;
        String strA05;
        if (str == null) {
            message = th == null ? null : th.getMessage();
        } else {
            message = str;
        }
        if (message != null) {
            return message;
        }
        switch (i) {
            case 0:
                strA05 = A05(56, 12, 59);
                break;
            case 1:
                StringBuilder sbAppend = new StringBuilder().append(str2);
                String message2 = A05(0, 14, 27);
                StringBuilder sbAppend2 = sbAppend.append(message2).append(i2);
                String message3 = A05(14, 9, 68);
                StringBuilder sbAppend3 = sbAppend2.append(message3).append(c1981qI);
                String message4 = A05(23, 19, 114);
                StringBuilder sbAppend4 = sbAppend3.append(message4);
                String message5 = C5C.A0g(i3);
                strA05 = sbAppend4.append(message5).toString();
                break;
            case 2:
            default:
                strA05 = A05(68, 24, 60);
                break;
            case 3:
                strA05 = A05(44, 12, 68);
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbAppend5 = new StringBuilder().append(strA05);
            String message6 = A05(42, 2, 116);
            return sbAppend5.append(message6).append(str).toString();
        }
        return strA05;
    }
}
