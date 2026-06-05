package com.facebook.ads.redexgen.core;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class KO {
    public static byte[] A00;
    public static String[] A01 = {"KgPme38LEDVaM0D12Uwlfvq6nYMDVVkT", "a5g98XiYqimDBheiX8ybcf7PetcT8W7U", "dRcctykKkiCtpnpKZqpaePhb1Qg1PkeN", "6JMbAfNKE0NkFS9oLsx1Zln6Fen7GSJu", "0ohFdoD3UqF2FgjtvUgt7lzB", "HqtC3No697vYpZ7G6OCOOOlSljo", "Ih90XUpH", "6OUjWPhHhDm3iVNi78UT7lOYQX351vXz"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static KM A00(KM km, Map<String, KT> map) {
        while (km != null) {
            KT ktA02 = A02(km.A04, km.A0H(), map);
            if (ktA02 != null && ktA02.A09() == 1) {
                return km;
            }
            km = km.A03;
        }
        return null;
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[3].charAt(23) != strArr[0].charAt(23)) {
                throw new RuntimeException();
            }
            A01[6] = "lLmUOaES";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 115);
            i4++;
        }
    }

    public static void A05() {
        if (A01[2].charAt(10) == 'x') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "BbbzftLMD2m3WHwPv0bAANWrbX2mWIyE";
        strArr[7] = "7lYjBODxVBmaGubq4OQdXtxLEf46a0ab";
        A00 = new byte[]{-117, -75, -78, -103, -40, -30, -62, -40, -30, 64, 88, 86, 93, 93, 86, 91, 84, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 95, 98, 79, 102, 65, 82, 101, 97, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 91, 92, 81, 82, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 100, 86, 97, 85, 92, 98, 97, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 82, 101, 78, 80, 97, 89, 102, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 92, 91, 82, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 97, 82, 101, 97, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 80, 85, 86, 89, 81, 27, -10, 22, 15, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -12, 7, 16, 6, 7, 20, -9, 22, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 73, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -9, 74, 102, 30, 48, -6, -5, 75, 25};
    }

    static {
        A05();
    }

    public static KM A01(KM km, Map<String, KT> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(km);
        while (!arrayDeque.isEmpty()) {
            KM km2 = (KM) arrayDeque.pop();
            KT kt = km2.A04;
            String[] strArrA0H = km2.A0H();
            if (A01[6].length() != 8) {
                throw new RuntimeException();
            }
            A01[6] = "prCmMBcG";
            KT ktA02 = A02(kt, strArrA0H, map);
            if (ktA02 != null && ktA02.A09() == 3) {
                return km2;
            }
            for (int iA0C = km2.A0C() - 1; iA0C >= 0; iA0C--) {
                arrayDeque.push(km2.A0D(iA0C));
            }
        }
        return null;
    }

    public static KT A02(KT kt, String[] strArr, Map<String, KT> map) {
        int i = 0;
        if (kt == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                KT kt2 = new KT();
                int length = strArr.length;
                while (i < length) {
                    kt2.A0O(map.get(strArr[i]));
                    i++;
                }
                return kt2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                String str = strArr[0];
                String[] strArr2 = A01;
                if (strArr2[1].charAt(10) != strArr2[7].charAt(10)) {
                    throw new RuntimeException();
                }
                A01[5] = "FXnyxRIFGSjHG1Q4pZ8iBycDDGv";
                return kt.A0O(map.get(str));
            }
            if (strArr != null) {
                int length2 = strArr.length;
                if (A01[2].charAt(10) == 'x') {
                    throw new RuntimeException();
                }
                A01[5] = "6UN5UNrVzg6BSs5KXnnHYvLLh5S";
                if (length2 > 1) {
                    int length3 = strArr.length;
                    while (i < length3) {
                        KT kt3 = map.get(strArr[i]);
                        if (A01[5].length() != 27) {
                            throw new RuntimeException();
                        }
                        A01[2] = "LBM9N0gh5w8sQTAl6eCIViVepwnbqV6U";
                        kt.A0O(kt3);
                        i++;
                    }
                    return kt;
                }
            }
        }
        return kt;
    }

    public static String A04(String str) {
        String strA03 = A03(1, 2, 53);
        String strA032 = A03(0, 1, 14);
        String strReplaceAll = str.replaceAll(strA03, strA032);
        String out = A03(4, 5, 69);
        String strReplaceAll2 = strReplaceAll.replaceAll(out, strA032);
        String strA033 = A03(3, 1, 6);
        String strReplaceAll3 = strReplaceAll2.replaceAll(strA032, strA033);
        String out2 = A03(77, 11, 123);
        return strReplaceAll3.replaceAll(out2, strA033);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A06(Spannable spannable, int i, int i2, KT kt, KM km, Map<String, KT> map, int i3) {
        KM kmA01;
        KT ktA02;
        int i4;
        int i5;
        int i6;
        if (kt.A0A() != -1) {
            spannable.setSpan(new StyleSpan(kt.A0A()), i, i2, 33);
        }
        if (kt.A0b()) {
            spannable.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (kt.A0c()) {
            spannable.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (kt.A0a()) {
            AbstractC02003t.A00(spannable, new ForegroundColorSpan(kt.A06()), i, i2, 33);
        }
        boolean zA0Z = kt.A0Z();
        if (A01[5].length() == 27) {
            A01[2] = "DOLHbyxdL1TIGmJ49PhqpcsDL7xIVQFO";
            if (zA0Z) {
                AbstractC02003t.A00(spannable, new BackgroundColorSpan(kt.A05()), i, i2, 33);
            }
            if (kt.A0W() != null) {
                AbstractC02003t.A00(spannable, new TypefaceSpan(kt.A0W()), i, i2, 33);
            }
            if (kt.A0D() != null) {
                KI ki = (KI) AbstractC02053y.A01(kt.A0D());
                if (ki.A01 == -1) {
                    String[] strArr = A01;
                    if (strArr[1].charAt(10) == strArr[7].charAt(10)) {
                        A01[5] = "2MSbzH5cEcM3iPzp1Bk7CXgbIPr";
                        if (i3 == 2 || i3 == 1) {
                            i4 = 3;
                        } else {
                            i4 = 1;
                        }
                        i5 = 1;
                    }
                } else {
                    i4 = ki.A01;
                    i5 = ki.A00;
                }
                if (ki.A02 == -2) {
                    i6 = 1;
                } else {
                    i6 = ki.A02;
                }
                AbstractC02003t.A00(spannable, new C1926pO(i4, i5, i6), i, i2, 33);
            }
            switch (kt.A09()) {
                case 2:
                    KM kmA00 = A00(km, map);
                    if (kmA00 != null && (kmA01 = A01(kmA00, map)) != null) {
                        if (kmA01.A0C() == 1) {
                            KM containerNode = kmA01.A0D(0);
                            if (containerNode.A08 != null) {
                                KM containerNode2 = kmA01.A0D(0);
                                String str = (String) C5C.A0f(containerNode2.A08);
                                KT ktA022 = A02(kmA01.A04, kmA01.A0H(), map);
                                int iA08 = ktA022 != null ? ktA022.A08() : -1;
                                if (iA08 == -1 && (ktA02 = A02(kmA00.A04, kmA00.A0H(), map)) != null) {
                                    iA08 = ktA02.A08();
                                }
                                spannable.setSpan(new C1927pP(str, iA08), i, i2, 33);
                            } else {
                                AbstractC02134g.A06(A03(63, 14, 47), A03(9, 54, 122));
                            }
                            break;
                        }
                    }
                    break;
                case 3:
                case 4:
                    spannable.setSpan(new KF(), i, i2, 33);
                    break;
            }
            if (kt.A0Y()) {
                AbstractC02003t.A00(spannable, new C1928pQ(), i, i2, 33);
            }
            switch (kt.A07()) {
                case 1:
                    AbstractC02003t.A00(spannable, new AbsoluteSizeSpan((int) kt.A03(), true), i, i2, 33);
                    return;
                case 2:
                    AbstractC02003t.A00(spannable, new RelativeSizeSpan(kt.A03()), i, i2, 33);
                    return;
                case 3:
                    AbstractC02003t.A00(spannable, new RelativeSizeSpan(kt.A03() / 100.0f), i, i2, 33);
                    return;
                default:
                    return;
            }
        }
        throw new RuntimeException();
    }

    public static void A07(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }
}
