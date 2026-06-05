package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.SlowMotionData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class JL {
    public static byte[] A03;
    public static String[] A04 = {"1LFyGIpszZgsQUUW5R18ay4ATJEAL43c", "dt6orGbglcsjMqs", "9FFDgagoC1", "foXErnBO9GEWWKnhx2CBLj59I1mQsasl", "8wc6iy8fDBcca8zNmQv", "", "jjxV28nHyp6my1wOvIi", "qfRjwVGa5Ot2KmC8yJE9Z4CCjcQdKZvd"};
    public static final C1658kp A05;
    public static final C1658kp A06;
    public int A01;
    public final List<JI> A02 = new ArrayList();
    public int A00 = 0;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 58);
            if (A04[0].charAt(18) != '1') {
                throw new RuntimeException();
            }
            A04[1] = "QzkInJPgctLD5w2";
            bArrCopyOfRange[i4] = b;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{45, 10, 18, 5, 8, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, 68, 55, 33, 34, 68, 10, 5, 9, 1, 56, 7, 4, 28, 38, 4, 31, 2, 4, 5, 52, 47, 10, 31, 10, 93, 123, 126, 107, 124, 81, 93, 98, 97, 121, 67, 97, 122, 103, 97, 96, 81, 76, 73, 67, 94, 120, 125, 104, 127, 82, 94, 97, 98, 122, 64, 98, 121, 100, 98, 99, 82, 73, 108, 121, 108, 50, 20, 17, 4, 19, 62, 50, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 22, 44, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 21, 8, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 62, 37, 4, 7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 8, 2, 10, 4, 19, 8, 15, 6, 62, 46, 15, 65, 103, 98, 119, 96, 77, 65, 126, 125, 101, 95, 125, 102, 123, 125, 124, 77, 87, 118, 123, 102, 77, 86, 115, 102, 115};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A06(InterfaceC1772ms interfaceC1772ms, List<Metadata.Entry> list) throws IOException {
        long jA8n = interfaceC1772ms.A8n();
        int iA8O = (int) ((interfaceC1772ms.A8O() - interfaceC1772ms.A8n()) - ((long) this.A01));
        C02284v c02284v = new C02284v(iA8O);
        interfaceC1772ms.readFully(c02284v.A0l(), 0, iA8O);
        for (int i = 0; i < this.A02.size(); i++) {
            JI ji = this.A02.get(i);
            c02284v.A0f((int) (ji.A02 - jA8n));
            c02284v.A0g(4);
            int iA0E = c02284v.A0E();
            String[] strArr = A04;
            if (strArr[6].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            A04[7] = "1HViS9NC9rn2qgqFvoB7LQiD1FLq6ChH";
            int iA00 = A00(c02284v.A0W(iA0E));
            int i2 = ji.A01 - (iA0E + 8);
            switch (iA00) {
                case 2192:
                    list.add(A01(c02284v, i2));
                    break;
                case 2816:
                case 2817:
                case 2819:
                case 2820:
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    static {
        A03();
        A06 = C1658kp.A02(':');
        A05 = C1658kp.A02('*');
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A00(String str) throws C3K {
        byte b;
        switch (str.hashCode()) {
            case -1711564334:
                b = !str.equals(A02(16, 15, 81)) ? (byte) -1 : (byte) 0;
                break;
            case -1332107749:
                if (str.equals(A02(104, 26, 40))) {
                    b = 3;
                    break;
                }
                break;
            case -1251387154:
                if (str.equals(A02(51, 21, 55))) {
                    b = 1;
                    break;
                }
                break;
            case -830665521:
                if (str.equals(A02(72, 32, 91))) {
                    b = 4;
                    break;
                }
                break;
            case 1760745220:
                if (str.equals(A02(31, 20, 52))) {
                    b = 2;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
                return 2192;
            case 1:
                return 2816;
            case 2:
                return 2817;
            case 3:
                return 2819;
            case 4:
                return 2820;
            default:
                throw C3K.A01(A02(0, 16, 94), null);
        }
    }

    public static SlowMotionData A01(C02284v c02284v, int i) throws C3K {
        List<SlowMotionData.Segment> segments = new ArrayList<>();
        String dataString = c02284v.A0W(i);
        List<String> listA06 = A05.A06(dataString);
        for (int i2 = 0; i2 < listA06.size(); i2++) {
            List<String> listA062 = A06.A06(listA06.get(i2));
            if (listA062.size() == 3) {
                try {
                    long j = Long.parseLong(listA062.get(0));
                    long startTimeMs = Long.parseLong(listA062.get(1));
                    segments.add(new SlowMotionData.Segment(j, startTimeMs, 1 << (Integer.parseInt(listA062.get(2)) - 1)));
                } catch (NumberFormatException e) {
                    throw C3K.A01(null, e);
                }
            } else {
                throw C3K.A01(null, null);
            }
        }
        return new SlowMotionData(segments);
    }

    private void A04(InterfaceC1772ms interfaceC1772ms, HV hv) throws IOException {
        C02284v c02284v = new C02284v(8);
        interfaceC1772ms.readFully(c02284v.A0l(), 0, 8);
        this.A01 = c02284v.A0E() + 8;
        if (c02284v.A0C() != 1397048916) {
            hv.A00 = 0L;
        } else {
            hv.A00 = interfaceC1772ms.A8n() - ((long) (this.A01 - 12));
            this.A00 = 2;
        }
    }

    private void A05(InterfaceC1772ms interfaceC1772ms, HV hv) throws IOException {
        long jA8O = interfaceC1772ms.A8O();
        int i = (this.A01 - 12) - 8;
        C02284v c02284v = new C02284v(i);
        interfaceC1772ms.readFully(c02284v.A0l(), 0, i);
        for (int i2 = 0; i2 < i / 12; i2++) {
            c02284v.A0g(2);
            int i3 = c02284v.A0a();
            switch (i3) {
                case 2192:
                case 2816:
                case 2817:
                case 2819:
                case 2820:
                    long streamLength = this.A01;
                    long j = jA8O - streamLength;
                    long streamLength2 = c02284v.A0E();
                    int size = c02284v.A0E();
                    this.A02.add(new JI(i3, j - streamLength2, size));
                    break;
                default:
                    c02284v.A0g(8);
                    break;
            }
        }
        if (this.A02.isEmpty()) {
            hv.A00 = 0L;
            return;
        }
        this.A00 = 3;
        long streamLength3 = this.A02.get(0).A02;
        hv.A00 = streamLength3;
    }

    public final int A07(InterfaceC1772ms interfaceC1772ms, HV hv, List<Metadata.Entry> slowMotionMetadataEntries) throws IOException {
        long j = 0;
        switch (this.A00) {
            case 0:
                long jA8O = interfaceC1772ms.A8O();
                if (jA8O != -1 && jA8O >= 8) {
                    j = jA8O - 8;
                }
                hv.A00 = j;
                this.A00 = 1;
                return 1;
            case 1:
                A04(interfaceC1772ms, hv);
                return 1;
            case 2:
                A05(interfaceC1772ms, hv);
                return 1;
            case 3:
                A06(interfaceC1772ms, slowMotionMetadataEntries);
                hv.A00 = 0L;
                return 1;
            default:
                throw new IllegalStateException();
        }
    }

    public final void A08() {
        this.A02.clear();
        this.A00 = 0;
    }
}
