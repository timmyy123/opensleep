package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1631kN implements InterfaceC0664Mk {
    public static String[] A02 = {"NTKnPH7sxZWFtkQQ5kROJPoMkjUZ4Q4d", "RaExZ6aQUY7gKyEqo", "qL9TLqM", "etoa52irCH6srt3CKfgZrOFq7EubEl4q", "qkXLyShprh", "IdfSVJasrAewAIwCfeRk8lkXcSCS6gZu", "rDp9NxZtyasBjPeaw", "WSm3MQw1MgB2HgbRdvVa7F4Bk"};
    public static final C1631kN A03 = new C1631kN(Collections.emptyMap());
    public int A00;
    public final Map<String, byte[]> A01;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A02(HashMap<String, byte[]> map, Map<String, Object> map2) {
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            map.put(entry.getKey(), A04(entry.getValue()));
        }
    }

    public C1631kN() {
        this(Collections.emptyMap());
    }

    public C1631kN(Map<String, byte[]> metadata) {
        this.A01 = Collections.unmodifiableMap(metadata);
    }

    public static Map<String, byte[]> A00(Map<String, byte[]> otherMetadata, C0665Ml c0665Ml) {
        HashMap map = new HashMap(otherMetadata);
        A01(map, c0665Ml.A08());
        A02(map, c0665Ml.A09());
        return map;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A01(HashMap<String, byte[]> metadata, List<String> names) {
        for (int i = 0; i < i; i++) {
            metadata.remove(names.get(i));
        }
    }

    public static boolean A03(Map<String, byte[]> first, Map<String, byte[]> second) {
        if (first.size() != second.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : first.entrySet()) {
            String[] strArr = A02;
            if (strArr[3].charAt(15) != strArr[5].charAt(15)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "RxVH6UseI2QDAmyClyRrXYV4sPTOH4uG";
            strArr2[5] = "pwd4aQIs84j1qxbCSK6duDEgPeljesR1";
            if (!Arrays.equals(entry.getValue(), second.get(entry.getKey()))) {
                return false;
            }
        }
        String[] strArr3 = A02;
        if (strArr3[2].length() != strArr3[7].length()) {
            String[] strArr4 = A02;
            strArr4[3] = "m75a4Dv9Ey5SlHFCv1UmHUzSVmhM8DwK";
            strArr4[5] = "s7eMveGG854NsBOCE3EU05ylLzSbP54K";
            return true;
        }
        return true;
    }

    public static byte[] A04(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(AbstractC1618k9.A05);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public final C1631kN A05(C0665Ml c0665Ml) {
        Map<String, byte[]> mapA00 = A00(this.A01, c0665Ml);
        Map<String, byte[]> mutatedMetadata = this.A01;
        if (A03(mutatedMetadata, mapA00)) {
            return this;
        }
        return new C1631kN(mapA00);
    }

    public final Set<Map.Entry<String, byte[]>> A06() {
        return this.A01.entrySet();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0664Mk
    public final long A6h(String str, long j) {
        byte[] bytes = this.A01.get(str);
        if (bytes != null) {
            long j2 = ByteBuffer.wrap(bytes).getLong();
            if (A02[4].length() != 10) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[1] = "kz3tzBS2MuEJlb9Es";
            strArr[6] = "H8ViBkjAuDsfEZOZe";
            return j2;
        }
        return j;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0664Mk
    public final String A6j(String str, String str2) {
        byte[] bArr = this.A01.get(str);
        if (bArr != null) {
            return new String(bArr, AbstractC1618k9.A05);
        }
        return str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return A03(this.A01, ((C1631kN) obj).A01);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int i = 0;
            for (Map.Entry<String, byte[]> entry : this.A01.entrySet()) {
                int iHashCode = entry.getKey().hashCode();
                int result = Arrays.hashCode(entry.getValue());
                i += iHashCode ^ result;
            }
            this.A00 = i;
        }
        int result2 = this.A00;
        return result2;
    }
}
