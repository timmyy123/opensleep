package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.dynamicloading.FlashPreferences;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.home.platform.traits.ValidationIssue;
import java.lang.Thread;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class U2 {
    public static boolean A00;
    public static boolean A01;
    public static byte[] A02;
    public static String[] A03 = {"i0FOsf0o9fpBvAlaEaGgnCYFRbNnwBKJ", "ZsBa2nEfyhltTo", "ZG6g5nWnUhxh", "6zjosiDwJWE47kuMvKAUCDrCWUeR8P3q", "Gh89HIHHDqfPtiuASbXLVil627eRz", "Lsbp3nhJR34oAmuvtJAouWbaxC4Ny9OM", "s0Y", "C"};
    public static final AtomicBoolean A04;
    public static final AtomicBoolean A05;
    public static final AtomicBoolean A06;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-89, -39, -39, -89, -39, -88, -40, -84, -54, -58, -59, -7, -24, -19, -23, -14, -25, -23, -46, -23, -8, -5, -13, -10, -17, -88, -103, -96, 117, -66, -61, -66, -55, -66, -74, -63, -66, -49, -74, -55, -66, -60, -61, 117, -56, -55, -74, -57, -55, -70, -71, -84, -67, -60, 121, -48, -70, -52, 121, -70, -59, -53, -66, -70, -67, -46, 121, -62, -57, -62, -51, -62, -70, -59, -62, -45, -66, -67, 122, 121, -84, -60, -62, -55, -55, -62, -57, -64, -121, -90, -68, -62, 109, -79, -68, -69, 116, -63, 109, -80, -82, -71, -71, 109, -114, -62, -79, -74, -78, -69, -80, -78, -101, -78, -63, -60, -68, -65, -72, -114, -79, -64, 123, -74, -69, -74, -63, -74, -82, -71, -74, -57, -78, 117, 118, 123, 109, -96, -68, -70, -78, 109, -77, -62, -69, -80, -63, -74, -68, -69, -82, -71, -74, -63, -58, 109, -70, -82, -58, 109, -69, -68, -63, 109, -60, -68, -65, -72, 109, -67, -65, -68, -67, -78, -65, -71, -58, 123, -120, -105, -112, -58, -52, -63, -45, -56, 0, 6, -5, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 2, -7, -3, 9, 8, 0, 3, 1, -42, -44, -35, -44, -31, -40, -46, -3, 2, -3, 8, -3, -11, 0, -3, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -7, -51, -46, -51, -40, -51, -59, -48, -51, -34, -55, -116, -115, -124, -46, -45, -40, -124, -57, -59, -48, -48, -55, -56, -110, 1, -10, 8, 9, -12, 7, -6, 8, 10, 1, 9};
    }

    static {
        A03();
        A06 = new AtomicBoolean();
        A04 = new AtomicBoolean();
        A05 = new AtomicBoolean();
    }

    public static C1265eB A00() {
        return new C1265eB();
    }

    public static C1264eA A01(C1417ge c1417ge) {
        return new C1264eA(c1417ge);
    }

    public static void A04(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        Y4.A01.execute(new C1266eC(initListener, initResult));
    }

    public static void A06(C1417ge c1417ge) {
        if (AbstractC0873Ur.A0P(c1417ge) && !A05.getAndSet(true)) {
            try {
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = new TT(Thread.getDefaultUncaughtExceptionHandler(), c1417ge, new C1199d6());
                Thread.setDefaultUncaughtExceptionHandler(defaultUncaughtExceptionHandler);
            } catch (Exception e) {
                c1417ge.A08().ABC(A02(198, 7, 78), AbstractC0833Td.A1X, new C0834Te(e));
            }
        }
    }

    public static void A07(C1417ge c1417ge) {
        A0H(c1417ge, null, null, 3);
    }

    public static void A08(C1417ge c1417ge) {
        A0H(c1417ge, null, null, 3);
    }

    public static void A09(C1417ge c1417ge) {
        if (C0871Up.A2O(c1417ge)) {
            A0F(c1417ge, 0);
        }
        if (C0871Up.A2X(c1417ge)) {
            A0B(c1417ge);
        }
    }

    public static void A0A(C1417ge c1417ge) {
        if (C0871Up.A2P(c1417ge)) {
            String[] strArr = A03;
            if (strArr[1].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[1] = "XjvPwbQrSqkAxC";
            strArr2[6] = "skO";
            A0G(c1417ge, null, 3);
        }
    }

    public static void A0B(C1417ge c1417ge) {
        YG.A06.execute(new C1267eD(c1417ge));
    }

    public static void A0C(C1417ge c1417ge) {
        OP.A02(c1417ge);
        TX.A0C(c1417ge, new C1169cc(c1417ge), new C1317f2(), BuildConfigApi.isDebug());
        c1417ge.A0A();
        A0D(c1417ge);
    }

    public static void A0D(C1417ge c1417ge) {
        if (ProcessUtils.isRemoteRenderingProcess()) {
            return;
        }
        SharedPreferences sharedPreferences = FlashPreferences.getSharedPreferences(c1417ge);
        String string = sharedPreferences.getString(A02(186, 12, 121), null);
        String string2 = sharedPreferences.getString(A02(239, 11, 116), null);
        if (string != null && string2 != null) {
            InterfaceC0832Tc interfaceC0832TcA08 = c1417ge.A08();
            C0834Te c0834Te = new C0834Te(string2);
            String flashConfig = A02(181, 5, 63);
            interfaceC0832TcA08.ABz(flashConfig, 3701, c0834Te);
        }
    }

    public static void A0F(C1417ge c1417ge, int i) {
        T7.A01(c1417ge);
        if (A04.getAndSet(true)) {
            return;
        }
        if (AdInternalSettings.isDebugBuild() || AdInternalSettings.isDebuggerOn()) {
            AbstractC0904Vy.A02();
        }
        A06(c1417ge);
        AbstractC0911Wf.A00(C0871Up.A0q(c1417ge), BuildConfigApi.isDebug(), A00(), A01(c1417ge));
        C0812Si.A03(C0871Up.A04(c1417ge));
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            C1390gD.A09(new C1255e1(c1417ge));
        }
        if (i == 3) {
            Log.e(A02(8, 17, 99), A02(89, 89, 44));
            c1417ge.A08().ABz(A02(178, 3, 6), AbstractC0833Td.A0R, new C0834Te(A02(215, 24, 67)));
        }
        ActivityUtils.A04(c1417ge, AudienceNetworkActivity.class);
        YG.A05(c1417ge);
        VL.A05(c1417ge);
        N8.A01(c1417ge);
        if (C0871Up.A16(c1417ge)) {
            RX.A00(c1417ge);
        }
        if (C0871Up.A1z(c1417ge)) {
            ZR.A02().A90(c1417ge);
        }
    }

    public static void A0G(C1417ge c1417ge, AudienceNetworkAds.InitListener initListener, int i) {
        T7.A01(c1417ge);
        boolean z = false;
        synchronized (U2.class) {
            boolean execute = A00;
            if (!execute) {
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        boolean execute2 = A01;
                        if (!execute2) {
                            A01 = true;
                            z = true;
                        }
                    }
                } else {
                    A00 = true;
                    z = true;
                }
            }
        }
        if (z) {
            A0F(c1417ge, i);
            YG.A08.execute(new C1292ed(c1417ge, initListener));
        } else {
            if (i != 1) {
                return;
            }
            String strA02 = A02(51, 38, 56);
            if (initListener != null) {
                A04(initListener, new U1(true, strA02));
            } else {
                Log.w(A02(8, 17, 99), strA02);
            }
        }
    }

    public static void A0H(C1417ge c1417ge, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener, int i) {
        AbstractC0904Vy.A05(A02(ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_FIELD_NUMBER, 10, 115), A02(25, 26, 52), A02(0, 8, 82));
        C1390gD.A06();
        A0G(c1417ge, initListener, i);
    }

    public static synchronized boolean A0I() {
        return A00;
    }
}
