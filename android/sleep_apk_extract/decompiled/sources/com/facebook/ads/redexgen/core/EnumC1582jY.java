package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import kotlin.Metadata;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/MetaExoPlayerUpgradeConfig$INTEGER_ID;", "", "<init>", "(Ljava/lang/String;I)V", "VIDEO_FRAME_PROCESSOR_RELEASE_FRAME_UPPER_THRESHOLD", "VIDEO_FRAME_PROCESSOR_RELEASE_FRAME_LOWER_THRESHOLD", "EXOPLAYER_THREAD_POLLING_INTERVAL_MS", "VIDEO_WIDTH_TO_ENABLE_SR_EFFECTS", "THREAD_SLEEP_TIME_MS_FOR_DECODER_INIT_FAILURE", "MAXIMUM_BUFFER_AHEAD_PERIODS", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum EnumC1582jY {
    A08,
    A07,
    A04,
    A09,
    A06,
    A05;

    public static byte[] A00;
    public static String[] A01 = {"c95Lzjuspptm9E7Bq7QmweGmY5R10C5h", "Zk6TzuwldulRhYKg1CBSJof2CZY9gIPJ", "XWeVwIBdTgQEhYdvDu40qdXIYhK4HrTg", "rtXo5EzrNDEqFEKR3RUK8LgsLvDIfnK9", "nSK2a8", "SqSuC4", "z9axXz6aPS", "x862N1xvn0JhssWOwgOTuSK6X"};
    public static final /* synthetic */ InterfaceC0351Ac A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 69);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{51, 46, 57, 38, 58, 55, 47, 51, 36, 41, 34, 62, 36, 51, 55, 50, 41, 38, 57, 58, 58, 63, 56, 49, 41, 63, 56, 34, 51, 36, 32, 55, 58, 41, 59, 37, 17, 29, 4, 21, 17, 9, 17, 3, 30, 9, 26, 26, 25, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 3, 29, 20, 25, 29, 24, 3, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 25, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 21, 19, 24, 15, 16, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 22, 1, 5, 0, 27, 23, 8, 1, 1, 20, 27, 16, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 9, 1, 27, 9, 23, 27, 2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 22, 27, 0, 1, 7, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, 1, 22, 27, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 16, 27, 2, 5, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 8, 17, 22, 1, 115, 108, 97, 96, 106, 122, 99, 119, 100, 104, 96, 122, 117, 119, 106, 102, 96, 118, 118, 106, 119, 122, 119, 96, 105, 96, 100, 118, 96, 122, 99, 119, 100, 104, 96, 122, 105, 106, 114, 96, 119, 122, 113, 109, 119, 96, 118, 109, 106, 105, 97, 100, 123, 118, 119, 125, 109, 116, 96, 115, 127, 119, 109, 98, 96, 125, 113, 119, 97, 97, 125, 96, 109, 96, 119, 126, 119, 115, 97, 119, 109, 116, 96, 115, 127, 119, 109, 103, 98, 98, 119, 96, 109, 102, 122, 96, 119, 97, 122, 125, 126, 118, 64, 95, 82, 83, 89, 73, 65, 95, 82, 66, 94, 73, 66, 89, 73, 83, 88, 87, 84, 90, 83, 73, 69, 68, 73, 83, 80, 80, 83, 85, 66, 69};
    }

    static {
        A01();
        A02 = AbstractC1998qd.A01(A03);
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1582jY[] valuesCustom() {
        EnumC1582jY[] enumC1582jYArrValuesCustom = values();
        if (A01[0].charAt(28) == 't') {
            throw new RuntimeException();
        }
        A01[7] = "Z";
        return (EnumC1582jY[]) enumC1582jYArrValuesCustom.clone();
    }
}
