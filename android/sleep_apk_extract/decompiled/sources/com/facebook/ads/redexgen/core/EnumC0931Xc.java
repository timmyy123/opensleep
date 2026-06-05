package com.facebook.ads.redexgen.core;

import android.view.View;
import com.facebook.ads.NativeAdBase;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC0931Xc {
    A0I(0),
    A0H(1),
    A0G(2),
    A0K(3),
    A0J(4),
    A0A(5, NativeAdBase.NativeComponentTag.AD_ICON),
    A0F(6, NativeAdBase.NativeComponentTag.AD_TITLE),
    A09(7, NativeAdBase.NativeComponentTag.AD_COVER_IMAGE),
    A0E(8, NativeAdBase.NativeComponentTag.AD_SUBTITLE),
    A06(9, NativeAdBase.NativeComponentTag.AD_BODY),
    A07(10, NativeAdBase.NativeComponentTag.AD_CALL_TO_ACTION),
    A0D(11, NativeAdBase.NativeComponentTag.AD_SOCIAL_CONTEXT),
    A08(12, NativeAdBase.NativeComponentTag.AD_CHOICES_ICON),
    A0B(13, NativeAdBase.NativeComponentTag.AD_MEDIA),
    A0C(12, NativeAdBase.NativeComponentTag.AD_OPTIONS_VIEW);

    public static int A02;
    public static byte[] A03;
    public static String[] A04 = {"mm8FkjmxkAn0ntAt6yMmjJOmEmwUFxWQ", "VQVAUr8hHMqZVaEwe8OtAk0HCVwVuT9q", "oClOzaysC8x4DOGoit7i4h3Gpfb0OXMF", "fuZWqRC62r9MuSCVvwKu5U60eWbDLskj", "2DvdeCnwUfm17kN5FHRDQx8hBER6C2qU", "K4oeerNs7A1VEBeDem7X4xZbHtBFCQWn", "JTXeDaIbilWka07jjSO5NeC2nexU0fdc", "Pjq84j8K1toDwE9n24Yhtzr00ksRVLD1"};
    public final int A00;

    @Nullable
    public final NativeAdBase.NativeComponentTag A01;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {-22, -17, -11, -26, -13, -17, -30, -19, 0, -30, -27, 0, -29, -16, -27, -6, 20, 25, 31, 16, 29, 25, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 23, 42, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 15, 42, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 23, 23, 42, 31, 26, 42, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 31, 20, 26, 25, -52, -47, -41, -56, -43, -47, -60, -49, -30, -60, -57, -30, -58, -53, -46, -52, -58, -56, -42, -30, -52, -58, -46, -47, -103, -98, -92, -107, -94, -98, -111, -100, -81, -111, -108, -81, -109, -97, -90, -107, -94, -81, -103, -99, -111, -105, -107, -1, 4, 10, -5, 8, 4, -9, 2, 21, -9, -6, 21, -1, -7, 5, 4, -99, -94, -88, -103, -90, -94, -107, -96, -77, -107, -104, -77, -95, -103, -104, -99, -107, 0, 5, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -4, 9, 5, -8, 3, 22, -8, -5, 22, 6, 7, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, 6, 5, 10, 22, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, -4, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -55, -50, -44, -59, -46, -50, -63, -52, -33, -63, -60, -33, -45, -49, -61, -55, -63, -52, -33, -61, -49, -50, -44, -59, -40, -44, -50, -45, -39, -54, -41, -45, -58, -47, -28, -58, -55, -28, -40, -38, -57, -39, -50, -39, -47, -54, -12, -7, -1, -16, -3, -7, -20, -9, 10, -20, -17, 10, -1, -12, -1, -9, -16, -89, -84, -78, -93, -80, -84, -97, -86, -67, -97, -82, -89, -67, -78, -83, -83, -67, -86, -83, -75, -20, -15, -9, -24, -11, -15, -28, -17, 2, -15, -14, 2, -26, -17, -20, -26, -18, 17, 22, 28, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 26, 22, 9, 20, 39, 22, 23, 39, 28, 9, 15, 17, 22, 28, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 26, 22, 9, 20, 39, 22, 29, 20, 20, 39, 30, 17, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 31, -4, 1, 7, -8, 5, 1, -12, -1, 18, 10, 5, 2, 1, -6, 18, 7, -12, -6, 18, -10, -1, -12, 6, 6};
        String[] strArr = A04;
        if (strArr[0].charAt(5) != strArr[7].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[4] = "5kHbeeIehC4HjRV2XKp0gKWNT0mjCFu0";
        strArr2[5] = "V77oNHMbviq5SbxHHLaqMPGHTmS2Clc8";
        A03 = bArr;
    }

    static {
        A02();
        A02 = -1593835521;
    }

    EnumC0931Xc(int i) {
        this.A00 = i;
        this.A01 = null;
    }

    EnumC0931Xc(int i, NativeAdBase.NativeComponentTag nativeComponentTag) {
        this.A00 = i;
        this.A01 = nativeComponentTag;
    }

    @Nullable
    public static EnumC0931Xc A00(NativeAdBase.NativeComponentTag nativeComponentTag) {
        for (EnumC0931Xc enumC0931Xc : values()) {
            if (enumC0931Xc.A01 == nativeComponentTag) {
                return enumC0931Xc;
            }
        }
        return null;
    }

    public static void A03(@Nullable View view, NativeAdBase.NativeComponentTag nativeComponentTag) {
        EnumC0931Xc internalTag = A00(nativeComponentTag);
        if (view != null && internalTag != null) {
            view.setTag(A02, nativeComponentTag);
        }
    }

    public static void A04(@Nullable View view, @Nullable EnumC0931Xc enumC0931Xc) {
        if (view != null && enumC0931Xc != null) {
            view.setTag(A02, enumC0931Xc);
        }
    }

    public final int A06() {
        return this.A00;
    }
}
