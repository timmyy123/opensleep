package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.emsg.EventMessage;
import com.facebook.ads.androidx.media3.extractor.metadata.icy.IcyInfo;
import com.facebook.ads.androidx.media3.extractor.metadata.scte35.PrivateCommand;
import com.facebook.ads.androidx.media3.extractor.metadata.scte35.SpliceInsertCommand;
import com.facebook.ads.androidx.media3.extractor.metadata.scte35.SpliceNullCommand;
import com.facebook.ads.androidx.media3.extractor.metadata.scte35.SpliceScheduleCommand;
import com.facebook.ads.androidx.media3.extractor.metadata.scte35.TimeSignalCommand;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.o5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1845o5 implements InterfaceC0376Bd {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 45);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{40, 29, 29, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 4, 25, 29, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 73, 29, 6, 73, 10, 27, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 8, 29, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 73, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 10, 6, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 27, 73, 15, 6, 27, 73, 28, 7, 26, 28, 25, 25, 6, 27, 29, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 73, 36, 32, 36, 44, 73, 29, 16, 25, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 83, 73, 25, 8, 8, 20, 17, 27, 25, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, 23, 22, 87, 17, 28, 75, 19, 2, 2, 30, 27, 17, 19, 6, 27, 29, 28, 93, 10, 95, 23, 31, 1, 21, 5, 20, 20, 8, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 7, 5, 16, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, 75, 28, 73, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 7, 29, 58, 43, 43, 55, 50, 56, 58, 47, 50, 52, 53, 116, 35, 118, 40, 56, 47, 62, 104, 110};
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000b  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC0376Bd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InterfaceC0547Hw A5J(C1981qI c1981qI) {
        byte b;
        String str = c1981qI.A0W;
        if (str != null) {
            switch (str.hashCode()) {
                case -1348231605:
                    String mimeType = A00(88, 17, 73);
                    b = !str.equals(mimeType) ? (byte) -1 : (byte) 3;
                    break;
                case -1248341703:
                    String mimeType2 = A00(55, 15, 85);
                    if (str.equals(mimeType2)) {
                        b = 0;
                        break;
                    }
                    break;
                case 1154383568:
                    String mimeType3 = A00(70, 18, 95);
                    if (str.equals(mimeType3)) {
                        b = 1;
                        break;
                    }
                    break;
                case 1652648887:
                    String mimeType4 = A00(105, 20, 118);
                    if (str.equals(mimeType4)) {
                        b = 2;
                        break;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    return new C9U();
                case 1:
                    return new AbstractC1753mZ() { // from class: com.facebook.ads.redexgen.X.9d
                        /* JADX WARN: Failed to parse debug info
                        java.lang.ArrayIndexOutOfBoundsException: Index 12 out of bounds for length 12
                        	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
                        	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
                        	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
                        	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
                        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
                         */
                        private final EventMessage A00(C02284v c02284v) {
                            return new EventMessage((String) AbstractC02053y.A01(c02284v.A0U()), (String) AbstractC02053y.A01(c02284v.A0U()), c02284v.A0P(), c02284v.A0P(), Arrays.copyOfRange(c02284v.A0l(), c02284v.A09(), c02284v.A0A()));
                        }

                        @Override // com.facebook.ads.redexgen.core.AbstractC1753mZ
                        public final Metadata A0R(C03359e c03359e, ByteBuffer byteBuffer) {
                            return new Metadata(A00(new C02284v(byteBuffer.array(), byteBuffer.limit())));
                        }
                    };
                case 2:
                    return new AbstractC1753mZ() { // from class: com.facebook.ads.redexgen.X.94
                        public static String[] A03 = {"LinnqKc1r0Ls5OIb", "1aWHF9GftncklZYsR1NJvylUpCZwYQhA", "WIGwItTSIaUh0S", "86hqVYxCYoyBTLzVv0XRyx6tGel5Hfof", "L8UaESXrw6FNBEuX", "ZSKLe1wjy7TzDmQANFt3bVwH52LTNoGA", "sWuUgP3CrL0lX60YF5iqvlGlBvq7Icsz", "4dV7lZySL5Inrb"};
                        public AnonymousClass53 A00;
                        public final C02284v A02 = new C02284v();
                        public final C02274u A01 = new C02274u();

                        @Override // com.facebook.ads.redexgen.core.AbstractC1753mZ
                        public final Metadata A0R(C03359e c03359e, ByteBuffer byteBuffer) {
                            if (this.A00 == null || c03359e.A00 != this.A00.A04()) {
                                this.A00 = new AnonymousClass53(c03359e.A01);
                                this.A00.A05(c03359e.A01 - c03359e.A00);
                            }
                            byte[] bArrArray = byteBuffer.array();
                            int size = byteBuffer.limit();
                            this.A02.A0j(bArrArray, size);
                            this.A01.A0E(bArrArray, size);
                            this.A01.A09(39);
                            long jA04 = (((long) this.A01.A04(1)) << 32) | ((long) this.A01.A04(32));
                            this.A01.A09(20);
                            int iA04 = this.A01.A04(12);
                            int spliceCommandType = this.A01.A04(8);
                            Metadata.Entry spliceNullCommand = null;
                            this.A02.A0g(14);
                            switch (spliceCommandType) {
                                case 0:
                                    spliceNullCommand = new SpliceNullCommand();
                                    break;
                                case 4:
                                    spliceNullCommand = SpliceScheduleCommand.A00(this.A02);
                                    break;
                                case 5:
                                    C02284v c02284v = this.A02;
                                    String[] strArr = A03;
                                    if (strArr[0].length() != strArr[4].length()) {
                                        throw new RuntimeException();
                                    }
                                    String[] strArr2 = A03;
                                    strArr2[0] = "3zG9Y3L3pcSl9hsO";
                                    strArr2[4] = "rzd7tnlstbcgZZIh";
                                    spliceNullCommand = SpliceInsertCommand.A00(c02284v, jA04, this.A00);
                                    break;
                                case 6:
                                    spliceNullCommand = TimeSignalCommand.A01(this.A02, jA04, this.A00);
                                    break;
                                case PHIpAddressSearchManager.END_IP_SCAN /* 255 */:
                                    spliceNullCommand = PrivateCommand.A00(this.A02, iA04, jA04);
                                    break;
                            }
                            return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
                        }
                    };
                case 3:
                    return new AbstractC1753mZ() { // from class: com.facebook.ads.redexgen.X.9c
                        public static byte[] A02;
                        public static String[] A03 = {"Lh0eiN4oYILfPl4jy3dJZhwMArdhxg", "ZZdJzt9nksvE8tVcjKh5yb5LHp4DKBwy", "Dbw1S4FpTZ", "Q8KOrM0jMS", "", "1W", "E5bBazuIHkpw9TIkFnjV805WNgqTNchu", "VvZ"};
                        public static final Pattern A04;
                        public final CharsetDecoder A01 = AbstractC1618k9.A05.newDecoder();
                        public final CharsetDecoder A00 = AbstractC1618k9.A00.newDecoder();

                        public static String A00(int i, int i2, int i3) {
                            byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                            for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                                bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 53);
                            }
                            return new String(bArrCopyOfRange);
                        }

                        public static void A02() {
                            byte[] bArr = {72, 78, 75, 95, 73, 93, 71, 72, 78, 74, 95, 73, 71, 91, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 10, 29, 25, 21, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 20, 29, 17, 22, 16, 7, 3, 15, 23, 16, MqttWireMessage.MESSAGE_TYPE_DISCONNECT};
                            String[] strArr = A03;
                            if (strArr[3].length() != strArr[2].length()) {
                                throw new RuntimeException();
                            }
                            A03[7] = "K4Z";
                            A02 = bArr;
                        }

                        static {
                            A02();
                            A04 = Pattern.compile(A00(0, 14, 85), 32);
                        }

                        private String A01(ByteBuffer byteBuffer) {
                            try {
                                return this.A01.decode(byteBuffer).toString();
                            } catch (CharacterCodingException unused) {
                                try {
                                    String string = this.A00.decode(byteBuffer).toString();
                                    this.A00.reset();
                                    byteBuffer.rewind();
                                    return string;
                                } catch (CharacterCodingException unused2) {
                                    this.A00.reset();
                                    byteBuffer.rewind();
                                    return null;
                                } catch (Throwable th) {
                                    this.A00.reset();
                                    byteBuffer.rewind();
                                    throw th;
                                }
                            } finally {
                                this.A01.reset();
                                byteBuffer.rewind();
                            }
                        }

                        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                        /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
                        @Override // com.facebook.ads.redexgen.core.AbstractC1753mZ
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Metadata A0R(C03359e c03359e, ByteBuffer byteBuffer) {
                            byte b2;
                            String strA01 = A01(byteBuffer);
                            byte[] bArr = new byte[byteBuffer.limit()];
                            byteBuffer.get(bArr);
                            if (strA01 == null) {
                                return new Metadata(new IcyInfo(bArr, null, null));
                            }
                            String str2 = null;
                            String name = null;
                            Pattern pattern = A04;
                            String icyString = A03[7];
                            if (icyString.length() != 3) {
                                throw new RuntimeException();
                            }
                            A03[4] = "";
                            Matcher matcher = pattern.matcher(strA01);
                            for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
                                String strGroup = matcher.group(1);
                                String strGroup2 = matcher.group(2);
                                if (strGroup != null) {
                                    String key = AbstractC1616k7.A01(strGroup);
                                    switch (key.hashCode()) {
                                        case -315603473:
                                            b2 = key.equals(A00(25, 9, 87)) ? (byte) 1 : (byte) -1;
                                            break;
                                        case 1646559960:
                                            if (key.equals(A00(14, 11, 77))) {
                                                b2 = 0;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (b2) {
                                        case 0:
                                            str2 = strGroup2;
                                            break;
                                        case 1:
                                            name = strGroup2;
                                            break;
                                    }
                                }
                            }
                            return new Metadata(new IcyInfo(bArr, str2, name));
                        }
                    };
            }
        }
        StringBuilder sb = new StringBuilder();
        String mimeType5 = A00(0, 55, 68);
        throw new IllegalArgumentException(sb.append(mimeType5).append(str).toString());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0376Bd
    public final boolean AKN(C1981qI c1981qI) {
        String str = c1981qI.A0W;
        String mimeType = A00(55, 15, 85);
        if (!mimeType.equals(str)) {
            String mimeType2 = A00(70, 18, 95);
            if (!mimeType2.equals(str)) {
                String mimeType3 = A00(105, 20, 118);
                if (!mimeType3.equals(str)) {
                    String mimeType4 = A00(88, 17, 73);
                    if (!mimeType4.equals(str)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
