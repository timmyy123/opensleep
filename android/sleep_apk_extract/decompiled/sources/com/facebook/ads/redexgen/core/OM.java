package com.facebook.ads.redexgen.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import com.facebook.ads.internal.util.common.FbValidationUtils;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class OM {
    public static byte[] A00;
    public static String[] A01 = {"NpBoDzCQyjOF8OFx9MsnsgXANanqzzj6", "RSaml0mwJ5MGBXbUX4Y7eJ496TcnwqpH", "O6M6", "HC1y", "xJAb", "6P21Vz3Cvscq5f42i51asuNZrA3r2siu", "D2rYJRkohSsxhH", "5Vn2BbDuwzZpkNg8pcGLkugAGTBH17kk"};
    public static final String A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{61, 32, 32, 32, 48, 48, 48, 48, 48, 48, 48, 48, 48, 33, 33, 33, 33, 33, 33, 33, 33, 49, 49, 49, 44, 78, 101, 98, 104, 101, 98, 107, 44, 120, 99, 44, 127, 105, 126, 122, 101, 111, 105, 44, 127, 121, 111, 111, 105, 127, 127, 44, 49, 44, 44, 85, 66, 89, 83, 91, 82, 72, 82, 79, 67, 69, 86, 68, 72, 92, 82, 78, 73, 78, 72, 69, 73, 95, 72, 76, 83, 89, 95, 69, 95, 66, 78, 72, 91, 73, 18, 21, 19, 30, 18, 4, 19, 23, 8, 2, 4, 30, 18, 5, 10, 30, 23, 4, 19, 18, 8, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 77, 65, 67, 0, 72, 79, 77, 75, 76, 65, 65, 69, 0, 79, 74, 93, 0, 71, 64, 90, 75, 92, 64, 79, 66, 0, 71, 94, 77, 0, 111, 91, 74, 71, 75, 64, 77, 75, 96, 75, 90, 89, 65, 92, 69, 124, 75, 67, 65, 90, 75, 125, 75, 92, 88, 71, 77, 75, 31, 19, 17, 82, 26, 29, 31, 25, 30, 19, 19, 23, 82, 23, 29, 8, 29, 18, 29};
    }

    static {
        A01();
        A02 = OM.class.getSimpleName();
    }

    public static void A02(C1417ge c1417ge, Message message) {
        Bundle bundle = message.getData().getBundle(A00(55, 17, 118));
        if (bundle != null) {
            U5.A06(c1417ge, bundle.getString(A00(90, 23, 32)), bundle.getString(A00(72, 18, 123)));
        }
    }

    public static boolean A03(Context context, String str) {
        PackageManager packageManager;
        if (!A00(171, 19, 29).equals(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            boolean validationPassed = FbValidationUtils.isFbSigningCertificateValid(FbValidationUtils.getSigningCertificate(packageManager.getPackageInfo(str, 64)));
            return validationPassed;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A04(C1417ge c1417ge, boolean z, ServiceConnection serviceConnection) {
        boolean forceBypassValidation;
        boolean forceBypassValidation2;
        boolean z2 = false;
        if (c1417ge.A05().AAO()) {
            if (!z) {
                boolean zA1d = C0871Up.A1d(c1417ge);
                if (A01[1].charAt(26) == '5') {
                    throw new RuntimeException();
                }
                A01[7] = "wVoKdL5DefY3vFtz3wgH19EGFsYG1twM";
                if (zA1d) {
                }
            }
            forceBypassValidation = true;
        } else {
            forceBypassValidation = false;
        }
        if (!forceBypassValidation) {
            boolean forceBypassValidation3 = A03(c1417ge, AbstractC0874Us.A05(z));
            forceBypassValidation2 = forceBypassValidation3;
        }
        if (!forceBypassValidation2) {
            return false;
        }
        Intent intent = new Intent();
        if (!z) {
            boolean forceBypassValidation4 = c1417ge.A05().AAO();
            if (forceBypassValidation4) {
                boolean forceBypassValidation5 = C0871Up.A1d(c1417ge);
                if (forceBypassValidation5) {
                    z2 = true;
                }
            }
        }
        boolean zBindService = c1417ge.bindService(intent.setComponent(new ComponentName(AbstractC0874Us.A05(z2), A00(113, 58, 79))), serviceConnection, 1);
        boolean forceBypassValidation6 = c1417ge.A05().AAO();
        if (forceBypassValidation6) {
            String str = A00(13, 42, 109) + zBindService + A00(0, 13, 124);
        }
        return zBindService;
    }
}
