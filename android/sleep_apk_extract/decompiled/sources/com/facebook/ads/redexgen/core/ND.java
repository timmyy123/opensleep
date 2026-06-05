package com.facebook.ads.redexgen.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;
import com.google.home.platform.traits.ValidationIssue;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ND extends BroadcastReceiver {
    public static byte[] A04;
    public static String[] A05 = {"63pwlQLoKCwW5p0QbdIUXInLNpJNKeDN", "nHjoojzh8ordTnJYOplsZEbhm3W", "EK1vnrz7nKD3WlqrabskcsTCjgB0Ol", "mrmSGnRe67YPxuitutY03vnr8HmLlvTO", "WBHqWyIJ9gRz16UTB", "T08A1gJjhONZbMQfbDH2kUMGt2wak3q8", "FhlipUgI3MYzEfQ5vdiUeGYh1Tc", "VMf9mWXeYEwI4WFFD1RYJOJBmcxdGyXB"};
    public C1608jz A00;
    public NC A01;
    public C1421gi A02;
    public String A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] - i3) - 35;
            String[] strArr = A05;
            if (strArr[0].charAt(15) == strArr[5].charAt(15)) {
                throw new RuntimeException();
            }
            A05[2] = "Rbn9Cx2mmrqT6crDebcgtgLlRg709d";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-99, 2, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -51, 5, 0, 2, 4, 1, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 10, -51, 0, 3, 18, -51, 8, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 19, 4, 17, 18, 19, 8, 19, 8, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -51, 0, 2, 19, 8, 21, 8, 19, 24, -2, 3, 4, 18, 19, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 24, 4, 3, -121, -109, -111, 82, -118, -123, -121, -119, -122, -109, -109, -113, 82, -123, -120, -105, 82, -115, -110, -104, -119, -106, -105, -104, -115, -104, -115, -123, -112, 82, -123, -121, -104, -115, -102, -115, -104, -99, -125, -120, -119, -105, -104, -106, -109, -99, -119, -120, 94, -9, 3, 1, -62, -6, -11, -9, -7, -10, 3, 3, -1, -62, -11, -8, 7, -62, -3, 2, 8, -7, 6, 7, 8, -3, 8, -3, -11, 0, -62, -9, 0, -3, -9, -1, -7, -8, -93, -81, -83, 110, -90, -95, -93, -91, -94, -81, -81, -85, 110, -95, -92, -77, 110, -87, -82, -76, -91, -78, -77, -76, -87, -76, -87, -95, -84, 110, -93, -84, -87, -93, -85, -91, -92, 122, -112, -100, -102, 91, -109, -114, -112, -110, -113, -100, -100, -104, 91, -114, -111, -96, 91, -106, -101, -95, -110, -97, -96, -95, -106, -95, -106, -114, -103, 91, -111, -106, -96, -102, -106, -96, -96, -110, -111, -27, -15, -17, -80, -24, -29, -27, -25, -28, -15, -15, -19, -80, -29, -26, -11, -80, -21, -16, -10, -25, -12, -11, -10, -21, -10, -21, -29, -18, -80, -26, -21, -11, -17, -21, -11, -11, -25, -26, -68, -68, -56, -58, -121, -65, -70, -68, -66, -69, -56, -56, -60, -121, -70, -67, -52, -121, -62, -57, -51, -66, -53, -52, -51, -62, -51, -62, -70, -59, -121, -67, -62, -52, -55, -59, -70, -46, -66, -67, -115, -103, -105, 88, -112, -117, -115, -113, -116, -103, -103, -107, 88, -117, -114, -99, 88, -109, -104, -98, -113, -100, -99, -98, -109, -98, -109, -117, -106, 88, -114, -109, -99, -102, -106, -117, -93, -113, -114, 100, -18, -6, -8, -71, -15, -20, -18, -16, -19, -6, -6, -10, -71, -20, -17, -2, -71, -12, -7, -1, -16, -3, -2, -1, -12, -1, -12, -20, -9, -71, -16, -3, -3, -6, -3, -11, 1, -1, -64, -8, -13, -11, -9, -12, 1, 1, -3, -64, -13, -10, 5, -64, -5, 0, 6, -9, 4, 5, 6, -5, 6, -5, -13, -2, -64, -9, 4, 4, 1, 4, -52, -95, -83, -85, 108, -92, -97, -95, -93, -96, -83, -83, -87, 108, -97, -94, -79, 108, -89, -84, -78, -93, -80, -79, -78, -89, -78, -89, -97, -86, 108, -92, -89, -84, -89, -79, -90, -99, -97, -95, -78, -89, -76, -89, -78, -73, 120, -75, -63, -65, -128, -72, -77, -75, -73, -76, -63, -63, -67, -128, -77, -74, -59, -128, -69, -64, -58, -73, -60, -59, -58, -69, -58, -69, -77, -66, -128, -69, -65, -62, -60, -73, -59, -59, -69, -63, -64, -128, -66, -63, -71, -71, -73, -74, -2, 10, 8, -55, 1, -4, -2, 0, -3, 10, 10, 6, -55, -4, -1, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -55, 4, 9, 15, 0, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 4, 15, 4, -4, 7, -55, 4, 8, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 4, 10, 9, -55, 7, 10, 2, 2, 0, -1, -43, -62, -50, -52, -115, -59, -64, -62, -60, -63, -50, -50, -54, -115, -64, -61, -46, -115, -56, -51, -45, -60, -47, -46, -45, -56, -45, -56, -64, -53, -115, -47, -60, -42, -64, -47, -61, -105, -93, -95, 98, -102, -107, -105, -103, -106, -93, -93, -97, 98, -107, -104, -89, 98, -99, -94, -88, -103, -90, -89, -88, -99, -88, -99, -107, -96, 98, -90, -103, -85, -107, -90, -104, 110, -107, -95, -97, 96, -104, -109, -107, -105, -108, -95, -95, -99, 96, -109, -106, -91, 96, -101, -96, -90, -105, -92, -91, -90, -101, -90, -101, -109, -98, 96, -92, -105, -87, -109, -92, -106, -111, -91, -105, -92, -88, -105, -92, -111, -104, -109, -101, -98, -89, -92, -105, -42, -30, -32, -95, -39, -44, -42, -40, -43, -30, -30, -34, -95, -44, -41, -26, -95, -36, -31, -25, -40, -27, -26, -25, -36, -25, -36, -44, -33, -95, -27, -40, -22, -44, -27, -41, -46, -26, -40, -27, -23, -40, -27, -46, -39, -44, -36, -33, -24, -27, -40, -83, -70, -58, -60, -123, -67, -72, -70, -68, -71, -58, -58, -62, -123, -72, -69, -54, -123, -64, -59, -53, -68, -55, -54, -53, -64, -53, -64, -72, -61, -123, -55, -68, -50, -72, -55, -69, -74, -54, -68, -55, -51, -68, -55, -74, -54, -52, -70, -70, -68, -54, -54, -95, -83, -85, 108, -92, -97, -95, -93, -96, -83, -83, -87, 108, -97, -94, -79, 108, -89, -84, -78, -93, -80, -79, -78, -89, -78, -89, -97, -86, 108, -80, -93, -75, -97, -80, -94, -99, -79, -93, -80, -76, -93, -80, -99, -79, -77, -95, -95, -93, -79, -79, 120};
    }

    static {
        A01();
    }

    public ND(C1421gi c1421gi, String str, C1608jz c1608jz, NC nc) {
        this.A02 = c1421gi;
        this.A03 = str;
        this.A01 = nc;
        this.A00 = c1608jz;
    }

    public final void A02() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(495, 48, 120) + this.A03);
        intentFilter.addAction(A00(291, 40, 7) + this.A03);
        intentFilter.addAction(A00(212, 40, 95) + this.A03);
        intentFilter.addAction(A00(135, 38, 29) + this.A03);
        intentFilter.addAction(A00(366, 36, 111) + this.A03);
        intentFilter.addAction(A00(49, 49, 1) + this.A03);
        intentFilter.addAction(A00(579, 37, 17) + this.A03);
        intentFilter.addAction(A00(770, 52, 27) + this.A03);
        intentFilter.addAction(A00(667, 52, 80) + this.A03);
        intentFilter.addAction(A00(ValidationIssue.AUTOMATION_TOO_LARGE_FIELD_NUMBER, 46, 27) + this.A03);
        P2.A00(this.A02).A06(this, intentFilter);
    }

    public final void A03() {
        try {
            P2.A00(this.A02).A05(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String intentAction = A00(0, 1, 64);
        String[] parts = action.split(intentAction);
        String str = parts[0];
        if (this.A01 == null || str == null) {
            return;
        }
        String intentAction2 = A00(98, 37, 113);
        if (intentAction2.equals(str)) {
            this.A01.AEC(this.A00, null, true);
            return;
        }
        String intentAction3 = A00(173, 39, 10);
        if (intentAction3.equals(str)) {
            NC nc = this.A01;
            C1608jz c1608jz = this.A00;
            String[] parts2 = A05;
            String intentAction4 = parts2[4];
            if (intentAction4.length() != 17) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[0] = "idxCQmInCgmI6Z6QfnOOGUSKG4RxfEy9";
            strArr[5] = "XFDoNEsmHzckDsBjNEh42nqO1hdjTO2H";
            nc.AED(c1608jz);
            return;
        }
        String intentAction5 = A00(252, 39, 54);
        if (intentAction5.equals(str)) {
            this.A01.AEE(this.A00);
            return;
        }
        String intentAction6 = A00(448, 47, 47);
        if (intentAction6.equals(str)) {
            this.A01.AEH(this.A00);
            return;
        }
        String intentAction7 = A00(331, 35, 104);
        if (intentAction7.equals(str)) {
            if (C0871Up.A1y(context)) {
                this.A01.AEG(this.A00, AdError.AD_PRESENTATION_ERROR);
                return;
            } else {
                this.A01.AEG(this.A00, AdError.INTERNAL_ERROR);
                return;
            }
        }
        String intentAction8 = A00(1, 48, 124);
        if (intentAction8.equals(str)) {
            this.A01.onInterstitialActivityDestroyed();
            return;
        }
        String intentAction9 = A00(543, 36, 60);
        if (intentAction9.equals(str)) {
            this.A01.AEI();
            return;
        }
        String intentAction10 = A00(719, 51, 52);
        if (intentAction10.equals(str)) {
            this.A01.AEK();
            return;
        }
        String intentAction11 = A00(616, 51, 15);
        if (!intentAction11.equals(str)) {
            return;
        }
        this.A01.AEJ();
    }
}
