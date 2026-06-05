package com.facebook.ads.redexgen.core;

import android.text.Layout;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class KT {
    public static byte[] A0J;
    public static String[] A0K = {"Usxox1Jpg4zI1D26A46628IJoKVIfDOb", "DJj4Y7Lf5wmbgFbmipnyENDrbENW0zBu", "xAirbBVx6sN", "JUHzrsF6PskbrsOcxUQeRZ6EJgAR84BH", "g21uR390", "sct5cBRRGNi", "fSzYgZjiZ3zjw2rk03FKz0970uetzuqd", "YzsQQs1"};
    public float A00;
    public int A02;
    public int A04;
    public Layout.Alignment A0C;
    public Layout.Alignment A0D;
    public KI A0E;
    public String A0F;
    public String A0G;
    public boolean A0H;
    public boolean A0I;
    public int A07 = -1;
    public int A0B = -1;
    public int A03 = -1;
    public int A06 = -1;
    public int A05 = -1;
    public int A09 = -1;
    public int A08 = -1;
    public int A0A = -1;
    public float A01 = Float.MAX_VALUE;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 111);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0J = new byte[]{-24, 7, 9, 17, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 24, 21, 27, 20, 10, -58, 9, 21, 18, 21, 24, -58, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 7, 25, -58, 20, 21, 26, -58, 8, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 20, -58, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 15, 20, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, -44, -27, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 19, -65, 2, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 17, -65, 7, 0, 18, -65, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 19, -65, 1, 4, 4, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -65, 3, 4, 5, 8, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 4, 3, -51};
    }

    static {
        A02();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private KT A00(KT kt, boolean z) {
        if (kt != null) {
            if (!this.A0I && kt.A0I) {
                A0H(kt.A04);
            }
            if (this.A03 == -1) {
                this.A03 = kt.A03;
            }
            if (this.A06 == -1) {
                this.A06 = kt.A06;
            }
            if (this.A0F == null) {
                String str = kt.A0F;
                String[] strArr = A0K;
                if (strArr[3].charAt(11) != strArr[1].charAt(11)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0K;
                strArr2[2] = "cxifAUO6W4n";
                strArr2[5] = "Va8L5s638mc";
                if (str != null) {
                    this.A0F = kt.A0F;
                }
            }
            if (this.A07 == -1) {
                this.A07 = kt.A07;
            }
            if (this.A0B == -1) {
                this.A0B = kt.A0B;
            }
            int i = this.A08;
            String[] strArr3 = A0K;
            if (strArr3[2].length() != strArr3[5].length()) {
                throw new RuntimeException();
            }
            A0K[6] = "rpCcf5jyKzMEHl3XckJI6ROuZzizfKVN";
            if (i == -1) {
                this.A08 = kt.A08;
            }
            Layout.Alignment alignment = this.A0D;
            if (A0K[6].charAt(6) != 'j') {
                A0K[0] = "iHkaK3PGLb6DAQNakyilLZ3b8fweVD8f";
                if (alignment == null) {
                    if (kt.A0D != null) {
                        this.A0D = kt.A0D;
                    }
                }
                if (this.A0C == null && kt.A0C != null) {
                    this.A0C = kt.A0C;
                }
                if (this.A0A == -1) {
                    this.A0A = kt.A0A;
                }
                if (this.A05 == -1) {
                    this.A05 = kt.A05;
                    this.A00 = kt.A00;
                }
                if (this.A0E == null) {
                    this.A0E = kt.A0E;
                }
                if (this.A01 == Float.MAX_VALUE) {
                    this.A01 = kt.A01;
                }
                if (z && !this.A0H && kt.A0H) {
                    A0G(kt.A02);
                }
                if (z && this.A09 == -1 && kt.A09 != -1) {
                    this.A09 = kt.A09;
                }
            } else {
                A0K[0] = "IvRWfCdmbtpyZ5Utg7SC4PH3AC5nND0h";
                if (alignment == null) {
                }
                if (this.A0C == null) {
                    this.A0C = kt.A0C;
                }
                if (this.A0A == -1) {
                }
                if (this.A05 == -1) {
                }
                if (this.A0E == null) {
                }
                if (this.A01 == Float.MAX_VALUE) {
                }
                if (z) {
                    A0G(kt.A02);
                }
                if (z) {
                    this.A09 = kt.A09;
                }
            }
        }
        return this;
    }

    public final float A03() {
        return this.A00;
    }

    public final float A04() {
        return this.A01;
    }

    public final int A05() {
        if (this.A0H) {
            return this.A02;
        }
        throw new IllegalStateException(A01(0, 38, 55));
    }

    public final int A06() {
        if (this.A0I) {
            return this.A04;
        }
        throw new IllegalStateException(A01(38, 32, 48));
    }

    public final int A07() {
        return this.A05;
    }

    public final int A08() {
        return this.A08;
    }

    public final int A09() {
        return this.A09;
    }

    public final int A0A() {
        if (this.A03 == -1 && this.A06 == -1) {
            return -1;
        }
        int i = (this.A03 == 1 ? 1 : 0) | (this.A06 == 1 ? 2 : 0);
        String[] strArr = A0K;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0K;
        strArr2[2] = "pc7acbLDMjB";
        strArr2[5] = "xuQHQFUerHu";
        return i;
    }

    public final Layout.Alignment A0B() {
        return this.A0C;
    }

    public final Layout.Alignment A0C() {
        return this.A0D;
    }

    public final KI A0D() {
        return this.A0E;
    }

    public final KT A0E(float f) {
        this.A00 = f;
        return this;
    }

    public final KT A0F(float f) {
        this.A01 = f;
        return this;
    }

    public final KT A0G(int i) {
        this.A02 = i;
        this.A0H = true;
        return this;
    }

    public final KT A0H(int i) {
        this.A04 = i;
        this.A0I = true;
        return this;
    }

    public final KT A0I(int i) {
        this.A05 = i;
        return this;
    }

    public final KT A0J(int i) {
        this.A08 = i;
        return this;
    }

    public final KT A0K(int i) {
        this.A09 = i;
        return this;
    }

    public final KT A0L(Layout.Alignment alignment) {
        this.A0C = alignment;
        return this;
    }

    public final KT A0M(Layout.Alignment alignment) {
        this.A0D = alignment;
        return this;
    }

    public final KT A0N(KI ki) {
        this.A0E = ki;
        return this;
    }

    public final KT A0O(KT kt) {
        return A00(kt, true);
    }

    public final KT A0P(String str) {
        this.A0F = str;
        return this;
    }

    public final KT A0Q(String str) {
        this.A0G = str;
        return this;
    }

    public final KT A0R(boolean z) {
        this.A03 = z ? 1 : 0;
        return this;
    }

    public final KT A0S(boolean z) {
        this.A06 = z ? 1 : 0;
        return this;
    }

    public final KT A0T(boolean z) {
        this.A07 = z ? 1 : 0;
        return this;
    }

    public final KT A0U(boolean z) {
        this.A0A = z ? 1 : 0;
        return this;
    }

    public final KT A0V(boolean z) {
        this.A0B = z ? 1 : 0;
        return this;
    }

    public final String A0W() {
        return this.A0F;
    }

    public final String A0X() {
        return this.A0G;
    }

    public final boolean A0Y() {
        return this.A0A == 1;
    }

    public final boolean A0Z() {
        return this.A0H;
    }

    public final boolean A0a() {
        return this.A0I;
    }

    public final boolean A0b() {
        return this.A07 == 1;
    }

    public final boolean A0c() {
        return this.A0B == 1;
    }
}
