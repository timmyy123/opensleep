package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class VH {
    public static byte[] A01;
    public static String[] A02 = {"am7j6uScRjgCcPqqGN06IL2NdGqCY6Pl", "w2ZRrlRUUsiRMX9SKs", "YXk4XDe5B5k7k4iyVx", "HQJJvXTTm7JfU3rwkPa2kdaJgQaSJ1wQ", "CAcSGcaxdMqfnhSDV62pp9c6tORR9BLO", "RFt9Cff9se89ZLPQ3aPSv6xdx8CuSNuI", "50wRnqLOESyReC73zJKGvVAEIeXW1ukc", "sHFX2DnzluM9Fq3mqMt8R8eeRnZzCLqn"};
    public static final /* synthetic */ VH[] A03;
    public static final VH A04;
    public static final VH A05;
    public static final VH A06;
    public static final VH A07;
    public static final VH A08;
    public static final VH A09;
    public static final VH A0A;
    public static final VH A0B;
    public static final VH A0C;
    public static final VH A0D;
    public static final VH A0E;
    public static final VH A0F;
    public static final VH A0G;
    public static final VH A0H;
    public static final VH A0I;
    public static final VH A0J;
    public static final VH A0K;
    public static final VH A0L;
    public static final VH A0M;
    public static final VH A0N;
    public static final VH A0O;
    public static final VH A0P;
    public static final VH A0Q;
    public static final VH A0R;
    public static final VH A0S;
    public static final VH A0T;
    public static final VH A0U;
    public static final VH A0V;
    public static final VH A0W;
    public static final VH A0X;
    public static final VH A0Y;
    public static final VH A0Z;
    public static final VH A0a;
    public static final VH A0b;
    public static final VH A0c;
    public static final VH A0d;
    public static final VH A0e;
    public static final VH A0f;
    public static final VH A0g;
    public static final VH A0h;
    public static final VH A0i;
    public static final VH A0j;
    public static final VH A0k;
    public static final VH A0l;
    public static final VH A0m;
    public static final VH A0n;
    public static final VH A0o;
    public static final VH A0p;
    public static final VH A0q;
    public static final VH A0r;
    public static final VH A0s;
    public static final VH A0t;
    public static final VH A0u;
    public static final VH A0v;
    public static final VH A0w;
    public static final VH A0x;
    public static final VH A0y;
    public static final VH A0z;
    public final String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 76);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-17, -14, -17, -2, 2, -13, 0, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 2, -9, -5, -13, -3, 3, 2, -111, -108, -81, -109, -104, -97, -103, -109, -107, -93, -81, -109, -100, -103, -109, -101, -107, -108, -90, -87, -60, -88, -79, -76, -72, -86, -87, -82, -79, -52, -80, -71, -68, -64, -78, -52, -80, -71, -74, -80, -72, -78, -79, -101, -98, -71, -90, -87, -101, -98, -97, -98, -71, -99, -101, -90, -90, -100, -101, -99, -91, -75, -72, -45, -58, -71, -60, -61, -58, -56, -71, -72, -62, -59, -32, -45, -58, -47, -48, -45, -43, -32, -60, -51, -54, -60, -52, -58, -59, -27, -24, 3, -10, -23, -12, -13, -10, -8, 3, -15, -27, -14, -27, -21, -23, 3, -12, -10, -23, -22, -9, 3, -25, -16, -19, -25, -17, -23, -24, -97, -94, -67, -80, -93, -82, -83, -80, -78, -67, -75, -90, -73, -67, -79, -93, -93, -89, -84, -91, -67, -78, -90, -89, -79, -67, -95, -86, -89, -95, -87, -93, -94, -52, -49, -22, -35, -48, -34, -37, -38, -39, -34, -48, -22, -35, -48, -50, -48, -44, -31, -48, -49, -61, -46, -46, -31, -49, -47, -40, -57, -58, -31, -42, -47, -31, -60, -61, -59, -51, -55, -44, -47, -41, -48, -58, -104, -89, -89, -74, -87, -100, -85, -84, -87, -91, -100, -101, -74, -85, -90, -74, -99, -90, -87, -100, -98, -87, -90, -84, -91, -101, -40, -42, -40, -35, -38, -12, -37, -42, -34, -31, -22, -25, -38, -78, -80, -78, -73, -76, -50, -62, -60, -78, -78, -76, -62, -62, -10, -1, -4, -10, -2, -6, 8, -12, 5, -9, 18, -10, -1, -4, -10, -2, -64, -47, -66, -36, -64, -55, -58, -64, -56, -62, -63, -92, -91, -74, -87, -93, -91, -65, -78, -81, -76, -95, -76, -91, -92, -45, -30, -37, -18, -44, -27, -48, -37, -28, -48, -29, -44, -18, -39, -30, -25, -10, -17, 2, -20, -15, -9, -11, -14, 2, -28, -15, -20, -16, -28, -9, -20, -14, -15, 2, -24, -15, -25, -24, -25, -91, -76, -83, -64, -85, -76, -64, -90, -77, -77, -80, -77, -102, -87, -94, -75, -87, -101, -86, -75, -85, -88, -94, -6, 9, 2, 21, 10, 8, -9, 4, 9, -4, 5, 8, 3, 21, -9, 9, 9, -5, 10, 9, -93, -78, -85, -66, -74, -92, -95, -66, -75, -88, -92, -74, -66, -92, -79, -79, -82, -79, 10, 25, 18, 37, 29, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8, 37, 28, 15, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 29, 37, 18, 21, 7, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, -109, -100, -110, -83, -111, -113, -96, -110, -83, -95, -106, -99, -91, -100, -8, -4, -1, 1, -12, 2, 2, -8, -2, -3, -80, -75, -69, -71, -74, -58, -86, -88, -71, -85, -58, -70, -81, -74, -66, -75, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 6, 20, 20, 32, 20, 21, 19, 10, 4, 21, 32, 20, 6, 4, 16, 15, 5, 32, 4, 9, 2, 15, 15, 6, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 32, 10, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 17, 19, 6, 20, 20, 10, 16, 15, 7, 4, 9, 6, 26, -2, 7, 4, -2, 6, -75, -88, -67, -80, -82, -88, -69, -80, -74, -75, -8, -17, 2, -2, 9, -19, -2, -21, 9, -19, -10, -13, -19, -11, -17, -18, -8, -17, 2, -2, 9, -19, -2, -21, 9, -16, -21, -13, -10, -17, -18, -47, -56, -56, -31, -42, -61, -44, -55, -57, -42, -31, -59, -50, -53, -59, -51, 8, -7, -5, 3, -7, -1, -3, 23, -7, 4, 10, -3, -7, -4, 17, 23, 1, 6, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -7, 4, 4, -3, -4, 23, 10, -3, 15, -7, 10, -4, 23, -1, 10, -7, 6, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -3, -4, -9, -24, -22, -14, -24, -18, -20, 6, -16, -11, -6, -5, -24, -13, -13, -20, -21, 6, -7, -20, -2, -24, -7, -21, 6, -18, -7, -24, -11, -5, -20, -21, -78, -82, -93, -69, -93, -92, -82, -89, -63, -91, -74, -93, -63, -91, -82, -85, -91, -83, -89, -90, -3, -1, -14, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -1, -14, 4, -18, -1, -15, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -16, 1, -18, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -16, -7, -10, -16, -8, -14, -15, -27, -25, -38, -12, -25, -38, -20, -42, -25, -39, -12, -24, -35, -28, -20, -29, -72, -70, -83, -57, -70, -83, -65, -87, -70, -84, -57, -65, -87, -68, -85, -80, -57, -75, -87, -79, -74, -57, -87, -84, -57, -85, -76, -79, -85, -77, -83, -84, -78, -91, -73, -95, -78, -92, -65, -93, -81, -82, -74, -91, -78, -77, -87, -81, -82, -65, -89, -78, -95, -82, -76, -91, -92, 21, 7, 5, 17, 16, 6, 33, 5, 10, 3, 16, 16, 7, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 33, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 15, 18, 20, 7, 21, 21, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 17, 16, 1, -13, -15, -3, -4, -14, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -15, -10, -17, -4, -4, -13, -6, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 4, -9, -14, -13, -3, -64, -75, -68, -60, -52, -82, -79, -52, -80, -82, -71, -71, -78, -79, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 9, 15, 8, -2, 25, -4, 15, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 9, 8, 25, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -1, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -1, -2, -93, -97, -91, -98, -108, -81, -97, -106, -106, -64, -68, -62, -69, -79, -52, -68, -69, -34, -33, -38, -35, -48, -22, -50, -41, -44, -50, -42, -20, -16, -30, -23, -34, -8, -19, -24, -8, -36, -27, -30, -36, -28, 8, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3, 19, 7, 8, -7, 4, 19, -9, -11, 2, -9, -7, 0, 19, -9, 0, -3, -9, -1, -27, -24, -32, -16, -28, -27, -42, -31, -16, -44, -35, -38, -44, -36, -19, -32, -37, -36, -26, -10, -38, -26, -28, -25, -29, -36, -21, -36, -37, -25, -38, -43, -42, -32, -16, -42, -29, -29, -32, -29, 16, 3, -2, -1, 9, 25, 3, -2, 6, -1, -23, -36, -41, -40, -30, -14, -29, -44, -24, -26, -40, -41, -48, -61, -66, -65, -55, -39, -54, -58, -69, -45, -90, -103, -108, -107, -97, -81, -96, -100, -111, -87, -81, -96, -111, -91, -93, -107, -81, -109, -100, -103, -109, -101, -107, -108, -50, -63, -68, -67, -57, -41, -56, -54, 
        -67, -56, -71, -54, -67, -68, -34, -47, -52, -51, -41, -25, -37, -45, -47, -40, -25, -53, -44, -47, -53, -45, -51, -52, -52, -49, -54, -50, -45, -38, -44, -50, -48, -34, -54, -50, -41, -44, -50, -42, -48, -49, 40, 43, 38, 42, 51, 54, 58, 44, 38, 42, 51, 48, 42, 50, 44, 43, -29, -26, -31, -27, -18, -15, -11, -25, -26, -2, 1, -4, 9, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -2, 1, 2, 1, -4, 0, -2, 9, 9, -1, -2, 0, 8, -4, -1, -6, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 15, -6, -2, 7, 4, -2, 6, 0, -1, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 17, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 31, 18, 29, 28, 31, 33, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 26, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 27, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 20, 18, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 29, 31, 18, 19, 32, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 16, 25, 22, 16, 24, 18, 17, -17, -14, -19, 0, -13, -2, -3, 0, 2, -19, 5, -10, 7, -19, 1, -13, -13, -9, -4, -11, -19, 2, -10, -9, 1, -19, -15, -6, -9, -15, -7, -13, -14, -6, -3, -8, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -2, 9, 8, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -2, -3, 30, 33, 28, 47, 34, 48, 45, 44, 43, 48, 34, 28, 47, 34, 32, 34, 38, 51, 34, 33, 42, 45, 42, 57, 61, 46, 59, 40, 61, 50, 54, 46, 56, 62, 61, 28, 43, 43, 26, 40, 42, 49, 32, 31, 26, 47, 42, 26, 29, 28, 30, 38, 34, 45, 42, 48, 41, 31, 37, 52, 52, 35, 54, 41, 56, 57, 54, 50, 41, 40, 35, 56, 51, 35, 42, 51, 54, 41, 43, 54, 51, 57, 50, 40, -59, -61, -59, -54, -57, -63, -56, -61, -53, -50, -41, -44, -57, -16, -18, -16, -11, -14, -20, 0, 2, -16, -16, -14, 0, 0, -66, -57, -60, -66, -58, -62, -48, -68, -51, -65, -70, -66, -57, -60, -66, -58, 35, 52, 33, 31, 35, 44, 41, 35, 43, 37, 36, -77, -76, -59, -72, -78, -76, -82, -63, -66, -61, -80, -61, -76, -77, -32, -17, -24, -37, -31, -14, -35, -24, -15, -35, -16, -31, -37, -26, -35, -14, -35, -17, -33, -18, -27, -20, -16, -28, -13, -20, -33, -23, -18, -12, -14, -17, -33, -31, -18, -23, -19, -31, -12, -23, -17, -18, -33, -27, -18, -28, -27, -28, 46, 61, 54, 41, 52, 61, 41, 47, 60, 60, 57, 60, 6, 21, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 1, 21, 7, 22, 1, 23, 20, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -25, -10, -17, -30, -9, -11, -28, -15, -10, -23, -14, -11, -16, -30, -28, -10, -10, -24, -9, -10, -8, 7, 0, -13, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -7, -10, -13, 10, -3, -7, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -13, -7, 6, 6, 3, 6, -53, -38, -45, -58, -34, -52, -55, -58, -35, -48, -52, -34, -58, -45, -42, -56, -53, -52, -53, -71, -62, -72, -77, -73, -75, -58, -72, -77, -57, -68, -61, -53, -62, -35, -31, -28, -26, -39, -25, -25, -35, -29, -30, 29, 34, 40, 38, 35, 19, 23, 21, 38, 24, 19, 39, 28, 35, 43, 34, 19, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 26, 26, 6, 26, 27, 25, 16, 10, 27, 6, 26, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 10, 22, 21, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6, 10, 15, 8, 21, 21, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 19, 6, 16, 20, 23, 25, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 26, 26, 16, 22, 21, -23, -26, -21, -24, -36, -32, -23, -26, -32, -24, -35, -48, -27, -40, -42, -48, -29, -40, -34, -35, 55, 46, 65, 61, 40, 44, 61, 42, 40, 44, 53, 50, 44, 52, 46, 45, 6, -3, 16, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -9, -5, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -7, -9, -2, -7, 1, 4, -3, -4, 16, 7, 7, 0, 21, 2, 19, 8, 6, 21, 0, 4, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, 4, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 48, 33, 35, 43, 33, 39, 37, 31, 33, 44, 50, 37, 33, 36, 57, 31, 41, 46, 51, 52, 33, 44, 44, 37, 36, 31, 50, 37, 55, 33, 50, 36, 31, 39, 50, 33, 46, 52, 37, 36, 45, 30, 32, 40, 30, 36, 34, 28, 38, 43, 48, 49, 30, 41, 41, 34, 33, 28, 47, 34, 52, 30, 47, 33, 28, 36, 47, 30, 43, 49, 34, 33, -41, -45, -56, -32, -56, -55, -45, -52, -58, -54, -37, -56, -58, -54, -45, -48, -54, -46, -52, -53, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, -6, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, 18, -4, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -1, -6, -2, 15, -4, -6, -2, 7, 4, -2, 6, 0, -1, -13, -11, -24, -30, -11, -24, -6, -28, -11, -25, -30, -10, -21, -14, -6, -15, -59, -57, -70, -76, -57, -70, -52, -74, -57, -71, -76, -52, -74, -55, -72, -67, -76, -62, -74, -66, -61, -76, -74, -71, -76, -72, -63, -66, -72, -64, -70, -71, 10, -3, 15, -7, 10, -4, -9, -5, 7, 6, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -3, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1, 7, 6, -9, -1, 10, -7, 6, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -3, -4, 40, 26, 24, 36, 35, 25, 20, 24, 29, 22, 35, 35, 26, 33, 20, 30, 34, 37, 39, 26, 40, 40, 30, 36, 35, -24, -38, -40, -28, -29, -39, -44, -40, -35, -42, -29, -29, -38, -31, -44, -21, -34, -39, -38, -28, 8, -3, 4, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -12, -10, -7, -12, -8, -10, 1, 1, -6, -7, 53, 49, 55, 48, 38, 33, 36, 54, 48, 33, 50, 52, 39, 53, 53, 39, 38, 39, 35, 41, 34, 24, 19, 35, 26, 26, 61, 57, 63, 56, 46, 41, 57, 56, -57, -56, -61, -58, -71, -77, -73, -64, -67, -73, -65, -4, 0, -14, -7, -18, -24, -3, -8, -24, -20, -11, -14, -20, -12, 62, 65, 57, 41, 61, 62, 47, 58, 41, 45, 43, 56, 45, 47, 54, 41, 45, 54, 51, 45, 53, 35, 38, 30, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 34, 35, 20, 31, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 18, 27, 24, 18, 26, -41, -54, -59, -58, -48, -64, -60, -48, -50, -47, -51, -58, -43, -58, -59, -37, -50, -55, -54, -44, -60, -54, -41, -41, -44, -41, -36, -49, -54, -53, -43, -59, -49, -54, -46, -53, 5, -8, -13, -12, -2, -18, -1, -16, 4, 2, -12, -13, 38, 25, 20, 21, 31, 15, 32, 28, 17, 41, 27, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 9, 
        10, 20, 4, 21, 17, 6, 30, 4, 21, 6, 26, 24, 10, 4, 8, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 8, 16, 10, 9, 30, 17, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 23, 7, 24, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 24, 9, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -5, -18, -23, -22, -12, -28, -8, -16, -18, -11, -28, -24, -15, -18, -24, -16, -22, -23};
    }

    static {
        A01();
        A0D = new VH(A00(167, 20, 63), 0, A00(1176, 20, 113));
        A08 = new VH(A00(58, 18, 14), 1, A00(1067, 18, 81));
        A04 = new VH(A00(0, 15, 98), 2, A00(1196, 15, 125));
        A0H = new VH(A00(249, 13, 35), 3, A00(1273, 13, 65));
        A0G = new VH(A00(236, 13, 73), 4, A00(1260, 13, 22));
        A0k = new VH(A00(799, 14, 33), 5, A00(1831, 14, 73));
        A0T = new VH(A00(437, 10, 99), 6, A00(1469, 10, 40));
        A0i = new VH(A00(754, 25, 118), 7, A00(1786, 25, 105));
        A0j = new VH(A00(779, 20, 98), 8, A00(1811, 20, 41));
        A0V = new VH(A00(463, 37, 117), 9, A00(1495, 37, 91));
        A06 = new VH(A00(33, 9, 25), 10, A00(1058, 9, 54));
        A07 = new VH(A00(42, 16, 33), 11, A00(1042, 16, 123));
        A0X = new VH(A00(510, 10, 27), 12, A00(1542, 10, 35));
        A0p = new VH(A00(861, 14, 77), 13, A00(1890, 14, 61));
        A0o = new VH(A00(850, 11, 63), 14, A00(1879, 11, 8));
        A0W = new VH(A00(500, 10, 111), 15, A00(1532, 10, 49));
        A0I = new VH(A00(262, 16, 103), 16, A00(1286, 16, 15));
        A0r = new VH(A00(896, 14, 69), 17, A00(1925, 14, 99));
        A0q = new VH(A00(875, 21, 104), 18, A00(1904, 21, 126));
        A0a = new VH(A00(551, 16, 54), 19, A00(1583, 16, 85));
        A0J = new VH(A00(278, 11, 49), 20, A00(1302, 11, 116));
        A0d = new VH(A00(639, 20, 22), 21, A00(1671, 20, 27));
        A0Y = new VH(A00(520, 16, 94), 22, A00(1552, 16, 125));
        A0Z = new VH(A00(536, 15, 94), 23, A00(1568, 15, 76));
        A0U = new VH(A00(447, 16, 27), 24, A00(1479, 16, 104));
        A0S = new VH(A00(423, 14, 2), 25, A00(1455, 14, 8));
        A0y = new VH(A00(992, 14, 44), 26, A00(2021, 14, 92));
        A0t = new VH(A00(925, 11, 69), 27, A00(1954, 11, 25));
        A0s = new VH(A00(910, 15, 75), 28, A00(1939, 15, 21));
        A0u = new VH(A00(936, 10, 110), 29, A00(1965, 10, 26));
        A0w = new VH(A00(958, 10, 46), 30, A00(1987, 10, 100));
        A0v = new VH(A00(946, 12, 71), 31, A00(1975, 12, 67));
        A0x = new VH(A00(968, 24, 4), 32, A00(1997, 24, 89));
        A0n = new VH(A00(842, 8, 33), 33, A00(1871, 8, 126));
        A0m = new VH(A00(833, 9, 4), 34, A00(1862, 9, 104));
        A0l = new VH(A00(813, 20, 110), 35, A00(1845, 17, 118));
        A0z = new VH(A00(1006, 18, 60), 36, A00(2035, 18, 57));
        A05 = new VH(A00(15, 18, 4), 37, A00(1024, 18, 31));
        A0A = new VH(A00(87, 17, 53), 38, A00(1085, 17, 79));
        A0C = new VH(A00(134, 33, 18), 39, A00(1132, 33, 66));
        A0B = new VH(A00(104, 30, 88), 40, A00(1102, 30, 97));
        A09 = new VH(A00(76, 11, 40), 41, A00(1165, 11, 77));
        A0E = new VH(A00(187, 23, 54), 42, A00(1211, 23, 111));
        A0F = new VH(A00(210, 26, 11), 43, A00(1234, 26, 120));
        A0K = new VH(A00(289, 14, 20), 44, A00(1313, 14, 3));
        A0P = new VH(A00(366, 20, 106), 45, A00(1398, 20, 55));
        A0O = new VH(A00(355, 11, 10), 46, A00(1387, 11, 86));
        A0R = new VH(A00(404, 19, 122), 47, A00(1436, 19, 27));
        A0M = new VH(A00(318, 25, 87), 48, A00(1350, 25, 52));
        A0L = new VH(A00(303, 15, 67), 49, A00(1327, 23, 48));
        A0Q = new VH(A00(386, 18, 19), 50, A00(1418, 18, 72));
        A0N = new VH(A00(343, 12, 21), 51, A00(1375, 12, 126));
        A0e = new VH(A00(659, 22, 97), 52, A00(1691, 22, 79));
        A0g = new VH(A00(697, 32, 28), 53, A00(1729, 32, 9));
        A0c = new VH(A00(607, 32, 91), 54, A00(1639, 32, 113));
        A0b = new VH(A00(567, 40, 108), 55, A00(1599, 40, 116));
        A0f = new VH(A00(681, 16, 73), 56, A00(1713, 16, 55));
        A0h = new VH(A00(729, 25, 20), 57, A00(1761, 25, 76));
        A03 = A02();
    }

    public VH(String str, int i, String str2) {
        this.A00 = str2;
    }

    public static /* synthetic */ VH[] A02() {
        VH[] vhArr = new VH[58];
        vhArr[0] = A0D;
        vhArr[1] = A08;
        vhArr[2] = A04;
        vhArr[3] = A0H;
        vhArr[4] = A0G;
        vhArr[5] = A0k;
        vhArr[6] = A0T;
        vhArr[7] = A0i;
        vhArr[8] = A0j;
        vhArr[9] = A0V;
        vhArr[10] = A06;
        vhArr[11] = A07;
        vhArr[12] = A0X;
        vhArr[13] = A0p;
        vhArr[14] = A0o;
        vhArr[15] = A0W;
        vhArr[16] = A0I;
        vhArr[17] = A0r;
        vhArr[18] = A0q;
        vhArr[19] = A0a;
        vhArr[20] = A0J;
        vhArr[21] = A0d;
        vhArr[22] = A0Y;
        vhArr[23] = A0Z;
        vhArr[24] = A0U;
        vhArr[25] = A0S;
        vhArr[26] = A0y;
        vhArr[27] = A0t;
        vhArr[28] = A0s;
        vhArr[29] = A0u;
        vhArr[30] = A0w;
        vhArr[31] = A0v;
        vhArr[32] = A0x;
        vhArr[33] = A0n;
        vhArr[34] = A0m;
        vhArr[35] = A0l;
        vhArr[36] = A0z;
        vhArr[37] = A05;
        vhArr[38] = A0A;
        vhArr[39] = A0C;
        vhArr[40] = A0B;
        vhArr[41] = A09;
        vhArr[42] = A0E;
        vhArr[43] = A0F;
        vhArr[44] = A0K;
        vhArr[45] = A0P;
        vhArr[46] = A0O;
        vhArr[47] = A0R;
        if (A02[0].charAt(23) == 'L') {
            throw new RuntimeException();
        }
        A02[3] = "wMas9DWZ40J0dvpslMT24maZaRvhGZfF";
        vhArr[48] = A0M;
        vhArr[49] = A0L;
        vhArr[50] = A0Q;
        vhArr[51] = A0N;
        vhArr[52] = A0e;
        vhArr[53] = A0g;
        vhArr[54] = A0c;
        vhArr[55] = A0b;
        vhArr[56] = A0f;
        vhArr[57] = A0h;
        return vhArr;
    }

    public final String A03() {
        return this.A00;
    }

    public static VH valueOf(String str) {
        return (VH) Enum.valueOf(VH.class, str);
    }

    public static VH[] values() {
        return (VH[]) A03.clone();
    }
}
