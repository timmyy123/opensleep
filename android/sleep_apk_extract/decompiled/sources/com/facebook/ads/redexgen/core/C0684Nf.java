package com.facebook.ads.redexgen.core;

import com.facebook.appevents.AppEventsConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0684Nf {
    public static int A06;
    public static byte[] A07;
    public static String[] A08 = {"Vkhbk7q", "bbLm7avGUtHkF3jUZkJgwv05OQOBaWiK", "tolCyKl3IftnRlKEmRnT2sO5c0DyKStU", "eQuD8llomM2wZCZ6oqqCRxFaVaKQS5vz", "G8C7OMdE9YEe4", "q", AppEventsConstants.EVENT_PARAM_VALUE_NO, "mGkZm9P"};
    public int A00;
    public int A01;
    public long A03;
    public String A04;
    public int A02 = 0;
    public LinkedList<Integer> A05 = new LinkedList<>();

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{-50, 31, -7, 26, -44, 0, -13, -1, 3, -13, -4, -15, 7, -82, -47, -17, -2, -2, -9, -4, -11, -82, -46, -17, 2, -17, -56, -82, -4, -3, -4, -13, -82, -41, -4, 2, -13, -11, -13, 0, -82, -3, -15, -15, 3, 0, 0, -13, -4, -15, -13, 44, 16, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 29, 1, 10, -1, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 21, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 16, 1, 0, -5, 5, 0, -16, -28, -5, -30, -26, -28, -13, -13, -24, -25, -30, -28, -11, -11, -28, -4, -30, -17, -24, -15, -22, -9, -21, 37, 25, 25, 43, 40, 40, 27, 36, 25, 27, 41, 44, 33, 46, 37, 43, 32, 57, 48, 54, 53, 32, 48, 36, 36, 54, 51, 51, 38, 47, 36, 38, 32, 52, 38, 36, 52, -19, -28, -22, -23, -44, -27, -38, -25, -34, -28, -39, 3, 101};
    }

    static {
        A03();
        A06 = 50;
    }

    public C0684Nf(String str) {
        this.A04 = str;
    }

    public static int A00() {
        int i = A06;
        if (A08[3].charAt(20) == '5') {
            throw new RuntimeException();
        }
        A08[1] = "fgVvaJPNAH92mxaTJIosOWA9xsF7cqZV";
        return i;
    }

    private void A02() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        while (true) {
            LinkedList<Integer> linkedList = this.A05;
            if (A08[6].length() != 1) {
                throw new RuntimeException();
            }
            A08[2] = "YiLzIz5T1838NHRcssOQsoNOVVrgTctO";
            if (!linkedList.isEmpty() && this.A05.peekFirst() != null) {
                long currentTime = this.A05.peekFirst().intValue();
                if (jCurrentTimeMillis - currentTime >= this.A00) {
                    this.A05.removeFirst();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void A04(int i) {
        this.A02 = i;
    }

    public final void A05(int i, int i2, long j, int i3) {
        this.A00 = i;
        this.A01 = i2;
        this.A03 = j;
        A06 = i3;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A06(JSONArray jSONArray) throws JSONException {
        for (int i = 0; i < idx; i++) {
            if (jSONArray.get(i) instanceof Integer) {
                this.A05.addLast((Integer) jSONArray.get(i));
            } else {
                throw new JSONException(A01(4, 47, 35));
            }
        }
    }

    public final void A07(boolean z) {
        if (z) {
            this.A05.addLast(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        }
        A02();
    }

    public final boolean A08() {
        return ((long) this.A05.size()) >= this.A03;
    }

    public final boolean A09() {
        return (System.currentTimeMillis() / 1000) - ((long) this.A02) <= ((long) this.A01);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(A01(138, 1, 29));
        sb.append(A01(55, 12, 49));
        String strA01 = A01(1, 1, 122);
        sb.append(strA01);
        sb.append(this.A04);
        String strA012 = A01(0, 1, 55);
        sb.append(strA012);
        sb.append(A01(101, 6, 81));
        sb.append(strA01);
        sb.append(this.A00);
        sb.append(strA012);
        sb.append(A01(127, 11, 10));
        sb.append(strA01);
        sb.append(this.A01);
        sb.append(strA012);
        sb.append(A01(52, 3, 66));
        sb.append(strA01);
        sb.append(this.A03);
        sb.append(strA012);
        sb.append(A01(107, 20, 86));
        sb.append(strA01);
        sb.append(this.A02);
        sb.append(strA012);
        sb.append(A01(67, 23, 24));
        sb.append(strA01);
        sb.append(A06);
        sb.append(strA012);
        sb.append(A01(90, 11, 75));
        sb.append(A01(2, 2, 84));
        Iterator<Integer> itr = this.A05.iterator();
        while (itr.hasNext()) {
            sb.append(itr.next());
            if (itr.hasNext()) {
                sb.append(strA012);
            }
        }
        sb.append(A01(51, 1, 100));
        if (A08[1].charAt(17) == 'M') {
            throw new RuntimeException();
        }
        A08[6] = "G";
        sb.append(A01(139, 1, 125));
        return sb.toString();
    }
}
