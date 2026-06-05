package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import androidx.health.platform.client.proto.DescriptorProtos;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.home.platform.traits.ValidationIssue;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.47, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AnonymousClass47 {
    public static byte[] A00;
    public static final Map<String, Integer> A01;
    public static final Pattern A02;
    public static final Pattern A03;
    public static final Pattern A04;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-29, -13, 7, -4, -9, -15, -67, -67, -15, -7, 16, -58, -63, -56, 18, -66, -63, -67, -15, -7, 16, -58, -63, -56, 18, -66, -63, -67, -15, -7, 16, -58, -63, -56, 18, -66, -15, -66, -71, 19, 39, 28, 23, 22, 17, -35, -35, 17, 25, 48, -26, -31, -24, 50, -34, -31, -35, 17, 25, 48, -26, -31, -24, 50, -34, -31, -35, 17, 25, 48, -26, -31, -24, 50, -34, -31, -35, 17, 25, -33, 17, -29, -12, 17, 25, -33, -12, -34, 17, -34, -39, -10, 10, -1, -6, -7, -12, -64, -64, -12, -4, 19, -55, -60, -53, 21, -63, -60, -64, -12, -4, 19, -55, -60, -53, 21, -63, -60, -64, -12, -4, 19, -55, -60, -53, 21, -63, -60, -64, -12, -4, 19, -55, -60, -53, 21, -63, -12, -63, -68, 15, 26, 23, 17, 19, 16, 26, 35, 19, 47, 60, 66, 55, 63, 67, 51, 69, 54, 55, 66, 51, -27, -11, -7, -27, 55, 71, 75, 55, 67, 55, 72, 63, 68, 59, -30, -5, -10, -13, -26, -7, -4, 0, -2, -4, 55, 62, 72, 70, 74, 58, -36, -26, -37, -35, -27, 22, 32, 21, 34, 23, 28, 25, 24, 21, 32, 33, 35, 34, 24, -11, -1, 8, -8, -1, 9, 18, 2, 19, 6, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 9, 2, 17, 90, 106, 103, 111, 102, -6, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, 4, 17, 15, 7, 7, -4, 80, 78, 81, 82, 97, 79, 89, 98, 82, 76, 81, 74, 91, 93, 91, 78, 94, 92, 78, 16, 21, 28, 16, 28, 25, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 33, 18, 47, 59, 62, 45, 56, -20, -8, -5, -9, -17, -11, -8, 0, -18, -5, -21, -11, -2, -18, -25, -13, -10, -14, -9, -19, -16, -17, -13, 2, -7, -3, 3, -1, -2, 39, 61, 37, 50, 60, 57, 74, 67, 58, 68, 77, 61, 54, 51, 68, 61, 53, 75, 51, 64, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 9, 26, 19, 15, 23, 20, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 22, 26, 23, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 50, 47, 64, 57, 53, 64, 47, 71, 73, 70, 87, 80, 76, 87, 74, 74, 83, -8, -11, 6, -1, -5, 6, -7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, 27, 20, 20, 17, 10, 20, 18, -32, -35, -18, -25, -23, -35, -29, -31, -22, -16, -35, -35, -38, -21, -28, -24, -27, -30, -17, -34, -32, -21, -34, -34, -25, 61, 58, 75, 68, 72, 75, 58, 71, 64, 62, -32, -35, -18, -25, -21, -18, -33, -28, -27, -32, -11, -14, 3, -4, 3, -10, -11, 92, 89, 106, 99, 107, 89, 100, 101, 103, 102, 35, 32, 49, 42, 50, 36, 32, 38, 49, 36, 36, 45, 34, 31, 48, 41, 49, 42, 31, 50, 35, 32, 42, 51, 35, -9, -12, 5, -2, 6, -1, -12, 7, -8, -6, 5, -12, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -2, -5, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 5, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 6, -5, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -1, 1, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -1, 19, 47, 44, 61, 54, 63, 64, 61, 60, 64, 58, 52, 62, 48, 61, 58, 75, 68, 79, 66, 72, 69, 62, 77, 92, 93, 93, 104, 104, 97, 102, 99, 20, 21, 21, 32, 35, 27, 41, 18, 28, 37, 21, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, 21, 15, 26, 9, 33, 65, 70, 74, 68, 79, 66, 86, -8, 3, -8, -5, -7, 6, -10, 0, 9, -7, 25, 28, 37, 24, 21, 37, 28, 22, 30, -11, -5, -2, 1, -16, -5, 6, -9, -8, 3, -12, 28, 37, 40, 27, 41, 42, 29, 40, 27, 27, 36, -28, -13, -31, -26, -15, -25, -33, -16, -22, -14, -9, -4, -21, -8, -5, -8, -9, -8, -1, 3, 4, 7, -8, -7, 4, -11, 9, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 6, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 22, 19, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 21, 25, 22, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 34, 45, 28, 52, 69, 80, 67, 67, 76, -28, -17, -30, -30, -21, -10, -30, -23, -23, -20, -12, -13, -2, -15, 5, 26, 33, 32, 23, 43, 22, 23, 41, 34, 41, 46, 42, 35, 40, 37, 10, 15, 5, 10, 2, 15, 19, 6, 5, 69, 74, 64, 69, 67, 75, 1, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 7, 10, 17, 31, 28, 21, 31, 29, -7, -18, 3, -14, -5, -15, -14, -1, 0, -11, 10, -7, 2, -8, -7, 6, -10, 0, 9, 7, -4, 47, 36, 58, 49, 42, 53, 40, 40, 49, 86, 79, 87, 89, 88, 77, 82, 83, 80, 80, 89, 88, 65, 62, 60, 61, 73, 55, 65, 74, 58, -5, -8, -10, -9, 3, -14, -2, 1, -16, -5, 94, 91, 89, 90, 102, 85, 107, 83, 96, 42, 39, 37, 38, 50, 37, 45, 42, 34, 35, 44, 48, 45, 34, 55, 35, 42, 42, 45, 53, 29, 26, 24, 25, 37, 24, 35, 18, 42, -13, -16, -18, -17, -5, -18, -7, -20, -20, -11, 51, 48, 46, 47, 59, 46, 57, 44, 64, -24, -27, -29, -28, -16, -20, -27, -22, -25, 99, 96, 94, 95, 107, 106, 88, 99, 100, 102, 101, -6, -9, -11, -10, 2, 1, -13, -17, -11, 0, -13, -13, -4, 82, 79, 77, 78, 90, 89, 81, 95, 72, 82, 91, 75, 91, 88, 86, 87, 99, 98, 91, 80, 99, 84, 86, 97, 80, 104, 29, 26, 24, 25, 37, 36, 29, 18, 37, 22, 24, 35, 22, 42, 79, 76, 74, 75, 87, 86, 87, 72, 72, 79, 69, 79, 88, 72, -24, -27, -29, -28, -16, -11, -31, -24, -24, -21, -13, 34, 31, 35, 27, 78, 75, 79, 71, 73, 84, 71, 71, 80, -12, -15, -10, -19, -10, 99, 87, 93, 91, 100, 106, 87, 78, 66, 83, 80, 80, 79, 55, 47, 46, 51, 63, 55, 43, 59, 63, 43, 55, 43, 60, 51, 56, 47, 66, 58, 57, 62, 74, 66, 55, 65, 74, 58, -12, -20, -21, -16, -4, -12, -10, -7, -22, -17, -16, -21, 57, 49, 48, 53, 65, 57, 60, 65, 62, 60, 56, 49, 19, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, 15, 27, 19, 25, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 24, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 20, -22, -30, -31, -26, -14, -22, -16, -23, -34, 
        -15, -30, -33, -23, -14, -30, 56, 48, 47, 52, 64, 56, 62, 59, 61, 52, 57, 50, 50, 61, 48, 48, 57, 59, 51, 50, 55, 67, 59, 66, 67, 64, 63, 67, 61, 55, 65, 51, 71, 63, 62, 67, 79, 71, 80, 67, 73, 70, 63, 78, 76, 63, 62, 94, 90, 85, 95, 90, 88, 89, 101, 83, 93, 102, 86, 56, 52, 57, 63, 46, 61, 48, 44, 56, 36, 32, 42, 43, 48, 41, 38, 42, 28, 36, 38, 26, 26, 24, 42, 32, 37, 80, 67, 88, 67, 76, 81, 89, 74, 75, 86, 71, 50, 37, 58, 61, -14, -17, -25, -17, -28, -26, -24, 20, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 27, 10, -14, -17, -20, -7, -24, -25, -11, -28, -27, 27, 30, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 26, 19, 17, 8, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -6, 7, 0, -2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -2, -3, 5, 8, -7, -2, -1, -6, 49, 34, 45, 38, 40, 48, 45, 37, 38, 47, 51, 48, 37, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -3, 8, 1, 3, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 1, 1, 10, -1, -16, -5, -12, 3, 4, 1, 0, 4, -2, -8, 2, -12, 24, 9, 20, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 30, 17, 23, 20, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 28, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 21, 6, 21, 6, 30, 6, 28, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 21, 6, -5, -9, -7, -2, 6, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -4, -4, -9, -20, -7, -4, 51, 44, 49, 46, 100, 96, 105, 97, 41, 40, 48, 29, 30, 43, 27, 37, 46, 30, -6, -1, -4, -6, -10, -17, 71, 58, 55, 58, 56, 56, 54, 69, 74, 71, 69, 65, 58, 17, 4, 3, 65, 54, 49, 0, -11, -16, -17, 59, 56, 60, 66, 43, 59, 56, 64, 55, 32, 29, 39, 15, 26, 16, 26, 35, 19, 27, 9, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 20, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, 26, 23, 31, 22, 30, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 23, 24, 26, 25, 20, 2, 15, 5, 26, 3, 19, 16, 24, 15, 0, -14, -18, -12, -1, -14, -14, -5, 28, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 10, 28, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 21, 21, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 3, -1, 8, 8, -5, 87, 77, 80, 90, 73, 86, 105, 97, 111, 88, 98, 107, 91, 58, 51, 40, 59, 44, 41, 51, 60, 44, -3, -10, -21, -2, -17, -15, -4, -21, 3, 65, 58, 47, 66, 51, 53, 64, 51, 71, 89, 84, 85, 93, 77, 74, 76, 67, 72, 65, 65, 76, 63, 63, 72, -6, -5, -20, -20, -13, -23, -13, -4, -20, 71, 52, 65, 92, 77, 73, 84, 72, 60, 61, 71, 72, 64, 57, 32, 27, 25, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 32, 27, 24, 22, 5, 18, 23, 20, 5, 22, 9, 18, 24, 45, 46, 43, 42, 46, 40, 34, 44, 30, 9, -4, 2, -1, -8, 7, 51, 36, 33, 29, 48, 103, 88, 89, 100, 85, 24, 9, 10, 21, 6, 20, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 16, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 6, 54, 34, 41, 41, 44, 52, 45, 25, 32, 32, 35, 43, 27, 38, 25, 25, 34};
    }

    static {
        A04();
        A04 = Pattern.compile(A03(1, 38, 28));
        A03 = Pattern.compile(A03(91, 49, 31));
        A02 = Pattern.compile(A03(39, 52, 60));
        A01 = new HashMap();
        A01.put(A03(140, 9, 53), -984833);
        A01.put(A03(149, 12, 85), -332841);
        Map<String, Integer> map = A01;
        Integer numValueOf = Integer.valueOf(Color.CYAN);
        map.put(A03(161, 4, 11), numValueOf);
        A01.put(A03(165, 10, 93), -8388652);
        A01.put(A03(175, 5, 8), -983041);
        A01.put(A03(180, 5, 30), -657956);
        A01.put(A03(ModuleDescriptor.MODULE_VERSION, 6, 92), -6972);
        A01.put(A03(191, 5, 1), Integer.valueOf(Color.BLACK));
        A01.put(A03(196, 14, 59), -5171);
        A01.put(A03(210, 4, 26), Integer.valueOf(Color.BLUE));
        A01.put(A03(214, 10, 36), -7722014);
        A01.put(A03(224, 5, 127), -5952982);
        A01.put(A03(229, 9, 31), -2180985);
        A01.put(A03(238, 9, 116), -10510688);
        A01.put(A03(247, 10, 112), -8388864);
        A01.put(A03(257, 9, 52), -2987746);
        A01.put(A03(266, 5, 83), -32944);
        A01.put(A03(271, 14, 16), -10185235);
        A01.put(A03(285, 8, 11), -1828);
        A01.put(A03(293, 7, 23), -2354116);
        A01.put(A03(300, 4, 75), numValueOf);
        A01.put(A03(304, 8, 95), -16777077);
        A01.put(A03(312, 8, 89), -16741493);
        A01.put(A03(320, 13, 47), -4684277);
        A01.put(A03(333, 8, 85), -5658199);
        A01.put(A03(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 9, 108), -16751616);
        A01.put(A03(350, 8, 27), -5658199);
        A01.put(A03(358, 9, 48), -4343957);
        A01.put(A03(367, 11, 3), -7667573);
        A01.put(A03(378, 14, 0), -11179217);
        A01.put(A03(392, 10, 96), -29696);
        A01.put(A03(ValidationIssue.AUTOMATION_TOO_LARGE_FIELD_NUMBER, 10, 3), -6737204);
        A01.put(A03(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, 7, 24), -7667712);
        A01.put(A03(419, 10, 127), -1468806);
        A01.put(A03(429, 12, 70), -7357297);
        A01.put(A03(441, 13, 69), -12042869);
        A01.put(A03(454, 13, 26), -13676721);
        A01.put(A03(467, 13, 33), -13676721);
        A01.put(A03(480, 13, 82), -16724271);
        A01.put(A03(FacebookRequestErrorClassification.ESC_APP_INACTIVE, 10, 96), -7077677);
        A01.put(A03(503, 8, 127), -60269);
        A01.put(A03(511, 11, 55), -16728065);
        A01.put(A03(522, 7, 47), -9868951);
        A01.put(A03(529, 7, 100), -9868951);
        A01.put(A03(536, 10, 27), -14774017);
        A01.put(A03(546, 9, 58), -5103070);
        A01.put(A03(555, 11, 22), -1296);
        A01.put(A03(566, 11, 61), -14513374);
        Map<String, Integer> map2 = A01;
        Integer numValueOf2 = Integer.valueOf(Color.MAGENTA);
        map2.put(A03(577, 7, 5), numValueOf2);
        A01.put(A03(584, 9, 16), -2302756);
        A01.put(A03(593, 10, 23), -460545);
        A01.put(A03(603, 4, 41), -10496);
        A01.put(A03(607, 9, 46), -2448096);
        A01.put(A03(616, 4, 66), -8355712);
        A01.put(A03(620, 5, 101), -16744448);
        A01.put(A03(625, 11, 4), -5374161);
        A01.put(A03(636, 4, 19), -8355712);
        A01.put(A03(640, 8, 57), -983056);
        A01.put(A03(648, 7, 65), -38476);
        A01.put(A03(655, 9, 40), -3318692);
        A01.put(A03(664, 6, 99), -11861886);
        A01.put(A03(670, 5, 31), -16);
        A01.put(A03(675, 5, 59), -989556);
        A01.put(A03(680, 8, 20), -1644806);
        A01.put(A03(688, 13, 27), -3851);
        A01.put(A03(701, 9, 74), -8586240);
        A01.put(A03(710, 12, 113), -1331);
        A01.put(A03(722, 9, 92), -5383962);
        A01.put(A03(731, 10, 22), -1015680);
        A01.put(A03(741, 9, 121), -2031617);
        A01.put(A03(750, 20, 69), -329006);
        A01.put(A03(770, 9, 56), -2894893);
        A01.put(A03(779, 10, 14), -7278960);
        A01.put(A03(789, 9, 78), -2894893);
        A01.put(A03(798, 9, 3), -18751);
        A01.put(A03(807, 11, 126), -24454);
        A01.put(A03(818, 13, 21), -14634326);
        A01.put(A03(831, 12, 109), -7876870);
        A01.put(A03(843, 14, 118), -8943463);
        A01.put(A03(857, 14, 56), -8943463);
        A01.put(A03(871, 14, 106), -5192482);
        A01.put(A03(885, 11, 3), -32);
        A01.put(A03(896, 4, 61), Integer.valueOf(Color.GREEN));
        A01.put(A03(DescriptorProtos.Edition.EDITION_LEGACY_VALUE, 9, 105), -13447886);
        A01.put(A03(909, 5, 15), -331546);
        A01.put(A03(914, 7, 125), numValueOf2);
        A01.put(A03(921, 6, 104), -8388608);
        A01.put(A03(927, 16, 81), -10039894);
        A01.put(A03(943, 10, 92), -16777011);
        A01.put(A03(953, 12, 14), -4565549);
        A01.put(A03(965, 12, 83), -7114533);
        A01.put(A03(977, 14, 45), -12799119);
        A01.put(A03(991, 15, 4), -8689426);
        A01.put(A03(1006, 17, 82), -16713062);
        A01.put(A03(1023, 15, 85), -12004916);
        A01.put(A03(1038, 15, 97), -3730043);
        A01.put(A03(1053, 12, 120), -15132304);
        A01.put(A03(1065, 9, 82), -655366);
        A01.put(A03(1074, 9, 62), -6943);
        A01.put(A03(1083, 8, 62), -6987);
        A01.put(A03(1091, 11, 105), -8531);
        A01.put(A03(1102, 4, 75), -16777088);
        A01.put(A03(1106, 7, 10), -133658);
        A01.put(A03(1113, 5, 44), -8355840);
        A01.put(A03(1118, 9, 10), -9728477);
        A01.put(A03(1127, 6, 51), -23296);
        A01.put(A03(1133, 9, 32), -47872);
        A01.put(A03(1142, 6, 29), -2461482);
        A01.put(A03(1148, 13, 72), -1120086);
        A01.put(A03(1161, 9, 35), -6751336);
        A01.put(A03(1170, 13, 22), -5247250);
        A01.put(A03(1183, 13, 47), -2396013);
        A01.put(A03(1196, 10, 44), -4139);
        A01.put(A03(1206, 9, 29), -9543);
        A01.put(A03(1215, 4, 14), -3308225);
        A01.put(A03(1219, 4, 74), -16181);
        A01.put(A03(1223, 4, 123), -2252579);
        A01.put(A03(1227, 10, 64), -5185306);
        A01.put(A03(1237, 6, 17), -8388480);
        A01.put(A03(1243, 13, 92), -10079335);
        A01.put(A03(1256, 3, 38), Integer.valueOf(Color.RED));
        A01.put(A03(1266, 9, 80), -4419697);
        A01.put(A03(1275, 9, 53), -12490271);
        A01.put(A03(1284, 11, 47), -7650029);
        A01.put(A03(1295, 6, 50), -360334);
        A01.put(A03(1301, 10, 40), -744352);
        A01.put(A03(1311, 8, 20), -13726889);
        A01.put(A03(1319, 8, 48), -2578);
        A01.put(A03(1327, 6, 33), -6270419);
        A01.put(A03(1333, 6, 107), -4144960);
        A01.put(A03(1339, 7, 125), -7876885);
        A01.put(A03(1346, 9, 78), -9807155);
        A01.put(A03(1355, 9, 17), -9404272);
        A01.put(A03(1364, 9, 85), -9404272);
        A01.put(A03(1373, 4, 109), -1286);
        A01.put(A03(1377, 11, 97), -16711809);
        A01.put(A03(1388, 9, 14), -12156236);
        A01.put(A03(1397, 3, 90), -2968436);
        A01.put(A03(1400, 4, 111), -16744320);
        A01.put(A03(1404, 7, 91), -2572328);
        A01.put(A03(1411, 6, 51), -40121);
        A01.put(A03(1417, 11, 43), 0);
        A01.put(A03(1428, 9, 64), -12525360);
        A01.put(A03(1437, 6, 26), -1146130);
        A01.put(A03(1443, 5, 67), -663885);
        A01.put(A03(1448, 5, 119), -1);
        A01.put(A03(1453, 10, 40), -657931);
        A01.put(A03(1463, 6, 68), Integer.valueOf(Color.YELLOW));
        A01.put(A03(1469, 11, 59), -6632142);
    }

    public static int A00(String str) {
        return A02(str, true);
    }

    public static int A01(String str) {
        return A02(str, false);
    }

    public static int A02(String str, boolean z) {
        int i;
        AbstractC02053y.A07(!TextUtils.isEmpty(str));
        String strReplace = str.replace(A03(0, 1, 74), A03(0, 0, 45));
        if (strReplace.charAt(0) == '#') {
            int i2 = (int) Long.parseLong(strReplace.substring(1), 16);
            if (strReplace.length() == 7) {
                return (-16777216) | i2;
            }
            if (strReplace.length() == 9) {
                return ((i2 & PHIpAddressSearchManager.END_IP_SCAN) << 24) | (i2 >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (strReplace.startsWith(A03(1262, 4, 21))) {
            Matcher matcher = (z ? A02 : A03).matcher(strReplace);
            if (matcher.matches()) {
                if (z) {
                    i = (int) (Float.parseFloat((String) AbstractC02053y.A01(matcher.group(4))) * 255.0f);
                } else {
                    i = Integer.parseInt((String) AbstractC02053y.A01(matcher.group(4)), 10);
                }
                return android.graphics.Color.argb(i, Integer.parseInt((String) AbstractC02053y.A01(matcher.group(1)), 10), Integer.parseInt((String) AbstractC02053y.A01(matcher.group(2)), 10), Integer.parseInt((String) AbstractC02053y.A01(matcher.group(3)), 10));
            }
        } else if (strReplace.startsWith(A03(1259, 3, 86))) {
            Matcher matcher2 = A04.matcher(strReplace);
            if (matcher2.matches()) {
                return android.graphics.Color.rgb(Integer.parseInt((String) AbstractC02053y.A01(matcher2.group(1)), 10), Integer.parseInt((String) AbstractC02053y.A01(matcher2.group(2)), 10), Integer.parseInt((String) AbstractC02053y.A01(matcher2.group(3)), 10));
            }
        } else {
            Integer color = A01.get(AbstractC1616k7.A01(strReplace));
            if (color != null) {
                return color.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
