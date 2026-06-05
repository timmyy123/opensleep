package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import kotlin.Metadata;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/annotation/AnnotationTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CLASS", "ANNOTATION_CLASS", "TYPE_PARAMETER", "PROPERTY", "FIELD", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPE", "EXPRESSION", "FILE", "TYPEALIAS", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum EnumC2006qo {
    A05,
    A04,
    A0H,
    A0C,
    A08,
    A0B,
    A0I,
    A06,
    A0A,
    A0D,
    A0E,
    A0F,
    A07,
    A09,
    A0G;

    public static byte[] A00;
    public static String[] A01 = {"Rv8gvV16xF14rXJa8ys12UvRM3fqPLyI", "UcSDNoyAd7hAuBmsZZHLguWnytii130l", "ED7ecOC6EdeJIgNMIPoHmXrwamnQGstx", "BUEKOmcJKNgB4JeoBrUcYjJkope3pnc", "09HtIC6J3ndQ006hR2DfsxfysqzwGQ1s", "uKMTkvRb9VJmiylnlY8d6WVdU9", "Y6AdbyooKlLQqvqU7YO0Osoc2idrR8tf", "d6Zg2ebC4FLOENwv3uxY"};
    public static final /* synthetic */ InterfaceC0351Ac A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 63);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        if (A01[6].charAt(0) == 's') {
            throw new RuntimeException();
        }
        A01[6] = "fY3Nz46mZ4ok68tyHpIJjbxIlrtCCt3n";
        A00 = new byte[]{126, 113, 113, 112, 107, 126, 107, 118, 112, 113, 96, 124, 115, 126, 108, 108, 36, 43, 38, 52, 52, 39, 43, 42, 55, 48, 54, 49, 39, 48, 43, 54, 20, 9, 1, 3, 20, 2, 2, 24, 30, 31, 96, 111, 99, 106, 98, 89, 86, 83, 90, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 31, 4, 9, 30, 3, 5, 4, 30, 29, 17, 19, 30, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 4, 19, 0, 27, 19, 16, 30, 23, 59, 57, 36, 59, 46, 57, 63, 50, 117, 119, 106, 117, 96, 119, 113, 124, 122, 98, 96, 113, 113, 96, 119, 70, 68, 89, 70, 83, 68, 66, 79, 73, 69, 83, 66, 66, 83, 68, 126, 115, 122, 111, 71, 74, 67, 86, 82, 95, 90, 82, 64, 79, 66, 75, 94, 68, 75, 90, 73, 90, 86, 94, 79, 94, 73, 68, 83, 94, 71, 87, 77, 66, 83, 64, 83, 95, 87, 70, 87, 64};
    }

    static {
        A01();
        A02 = AbstractC1998qd.A01(A03);
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC2006qo[] valuesCustom() throws CloneNotSupportedException {
        Object objClone = values().clone();
        String[] strArr = A01;
        if (strArr[7].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[7] = "fNr6S9qwrpJNcVOY2uQv";
        strArr2[5] = "MQ40BB82iiEDH6m8yNyJR95Ya0";
        return (EnumC2006qo[]) objClone;
    }
}
