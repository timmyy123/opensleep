package com.facebook.ads.redexgen.core;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import com.google.home.platform.traits.ValidationIssue;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.net.ssl.HttpsURLConnection;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0408Cl implements InterfaceC1372fv {
    public static byte[] A07;
    public static String[] A08 = {"QhNFYJC9gEUd0JRpeTZcIYaCPwaofmcY", "H7lFuH2c6lRKE1KzrEc8woYXA3m4qwgD", "VasthUCsKtAfJQ49O69n9k2VDB8sk6Ry", "CLNAbcda3kskZ9l1P61KK9o7E81JDy0P", "FTSbac7VR6oRDuoXxASKkUBG2ay4Jl1O", "oDWQMCtwqliv6oQHoqRk4BTd2HTxQUcC", "maa7C87UpzAlS2qduOc8uqrscl2NkhxH", ""};
    public static final String A09;
    public InterfaceC0832Tc A00;
    public Executor A01;
    public boolean A02;
    public C1377g0 A03;
    public final InterfaceC1382g5 A04 = new C0416Cu();
    public final InterfaceC1387gA A05;
    public final InterfaceC1388gB A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private final InterfaceC1371fu A01(AbstractC1384g7 abstractC1384g7) throws C1385g8 {
        C1385g8 c1385g8;
        String strA07 = A07(220, 7, 86);
        HttpURLConnection httpURLConnection = null;
        C0409Cm c0409CmA05 = null;
        boolean z = false;
        try {
            try {
                this.A02 = false;
                HttpURLConnection httpURLConnectionA08 = A08(abstractC1384g7.A05(), XD.A04() ? A09() : null);
                A0H(httpURLConnectionA08, abstractC1384g7);
                A0G(httpURLConnectionA08, abstractC1384g7);
                if (this.A06.AAZ()) {
                    this.A06.ABt(httpURLConnectionA08, abstractC1384g7.A06());
                }
                httpURLConnectionA08.connect();
                this.A02 = true;
                Set<String> setA01 = this.A03.A01();
                Set<String> setA02 = this.A03.A02();
                boolean z2 = (setA01 == null || setA01.isEmpty()) ? false : true;
                if (setA02 != null && !setA02.isEmpty()) {
                    z = true;
                }
                if ((httpURLConnectionA08 instanceof HttpsURLConnection) && (z2 || z)) {
                    try {
                        AbstractC1389gC.A03((HttpsURLConnection) httpURLConnectionA08, setA01, setA02);
                    } catch (CertificateException e) {
                        this.A00.ABz(strA07, AbstractC0833Td.A1z, new C0834Te(e));
                    } catch (Exception e2) {
                        this.A00.ABz(strA07, AbstractC0833Td.A1y, new C0834Te(e2));
                    }
                }
                if (httpURLConnectionA08.getDoOutput() && abstractC1384g7.A06() != null) {
                    A00(httpURLConnectionA08, abstractC1384g7.A06());
                }
                C0409Cm c0409CmA06 = httpURLConnectionA08.getDoInput() ? A06(httpURLConnectionA08) : new C0409Cm(httpURLConnectionA08, null);
                if (this.A06.AAZ()) {
                    this.A06.ABu(c0409CmA06);
                }
                if (httpURLConnectionA08 != null) {
                    httpURLConnectionA08.disconnect();
                }
                return c0409CmA06;
            } catch (Throwable th) {
                if (this.A06.AAZ()) {
                    this.A06.ABu(c0409CmA05);
                }
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e3) {
            try {
                try {
                    c0409CmA05 = A05(null);
                } catch (Throwable unused) {
                    if (c0409CmA05 == null || c0409CmA05.A9C() <= 0) {
                        throw new C1385g8(e3, c0409CmA05);
                    }
                    if (this.A06.AAZ()) {
                        this.A06.ABu(c0409CmA05);
                    }
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    return c0409CmA05;
                }
            } catch (Exception unused2) {
                Log.e(getClass().getSimpleName(), A07(117, 13, 98), e3);
                if (0 != 0 && c0409CmA05.A9C() > 0) {
                    if (this.A06.AAZ()) {
                        this.A06.ABu(null);
                    }
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
                c1385g8 = new C1385g8(e3, null);
            }
            if (A08[7].length() == 19) {
                throw new RuntimeException();
            }
            A08[5] = "6Q02gTcavt1J3D6llCgnQfsLExV7BLlB";
            if (c0409CmA05 == null || c0409CmA05.A9C() <= 0) {
                c1385g8 = new C1385g8(e3, c0409CmA05);
                throw c1385g8;
            }
            if (this.A06.AAZ()) {
                this.A06.ABu(c0409CmA05);
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            return c0409CmA05;
        }
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{59, 57, 102, 107, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 102, 100, 77, 64, 9, 77, 79, 30, 93, 75, 76, 82, 30, 42, 99, 121, 42, 100, 101, 126, 42, 107, 42, 124, 107, 102, 99, 110, 42, 95, 88, 70, 80, 31, 22, 80, 75, 120, 116, 23, 0, 116, 105, 116, 55, 59, 73, 79, 59, 38, 59, 38, 42, 126, 120, 115, 99, 100, 109, 42, 94, 4, 34, 43, 38, 55, 52, 34, 35, 71, 51, 46, 42, 34, 71, 90, 71, 71, 101, 116, 116, 105, 110, 103, 32, 116, 104, 101, 32, 104, 116, 116, 112, 32, 114, 101, 115, 112, 111, 110, 115, 101, 32, 116, 105, 109, 101, 100, 32, 111, 117, 116, 61, 22, 7, 4, 28, 1, 24, 83, 22, 1, 1, 28, 1, 23, 22, 4, 111, 122, 22, 7, 7, 27, 30, 20, 22, 3, 30, 24, 25, 88, 15, 90, 0, 0, 0, 90, 17, 24, 5, 26, 90, 2, 5, 27, 18, 25, 20, 24, 19, 18, 19, 76, 20, 31, 22, 5, 4, 18, 3, 74, 34, 35, 49, 90, 79, 89, 79, 72, 86, 26, 23, 81, 26, 23, 83, 120, 100, 100, 96, 62, 96, 98, 127, 104, 105, 88, 127, 99, 100, 27, 7, 7, 3, 93, 3, 1, 28, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, 35, 28, 1, 7, 41, 34, 51, 48, 40, 53, 44};
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x015a, code lost:
    
        r7 = r29.A00;
        r10 = java.lang.System.currentTimeMillis() - r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0163, code lost:
    
        if (r30.A04 != null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0165, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0167, code lost:
    
        r7.ABo(r0, r10, 0, r2, 0, new java.util.concurrent.TimeoutException(A07(82, 35, 17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0182, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0183, code lost:
    
        r2 = r30.A04.length;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 44 out of bounds for length 31
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InterfaceC1371fu A0J(AbstractC1384g7 abstractC1384g7) throws C1385g8 {
        long length;
        int i = 0;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iA01 = abstractC1384g7.A02().A01();
        long jA03 = abstractC1384g7.A02().A03();
        long jCurrentTimeMillis2 = System.currentTimeMillis() + ((long) abstractC1384g7.A02().A04());
        while (true) {
            if (i >= iA01 || jCurrentTimeMillis2 <= System.currentTimeMillis()) {
                break;
            }
            try {
                if (this.A06.AAZ()) {
                    String str = (i + 1) + A07(37, 4, 97) + iA01 + A07(56, 9, 27) + abstractC1384g7.A05();
                }
                jCurrentTimeMillis = System.currentTimeMillis();
                InterfaceC1371fu interfaceC1371fuA01 = A01(abstractC1384g7);
                if (interfaceC1371fuA01 != null) {
                    this.A00.ABo(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, interfaceC1371fuA01.A72().length, abstractC1384g7.A04 == null ? 0L : abstractC1384g7.A04.length, interfaceC1371fuA01.A9C(), null);
                    return interfaceC1371fuA01;
                }
                continue;
            } catch (C1385g8 e) {
                if (A0I(e, jCurrentTimeMillis, abstractC1384g7)) {
                    int i2 = iA01 - 1;
                    if (A08[1].charAt(0) == 'l') {
                        throw new RuntimeException();
                    }
                    A08[1] = "iDEOxz3pTPjJqVLmMx3mPs9K2XOoyKBI";
                    if (i < i2) {
                        continue;
                    } else {
                        if (!this.A05.ADs(e) || i >= iA01 - 1) {
                            InterfaceC1371fu interfaceC1371fuA00 = e.A00();
                            InterfaceC0832Tc interfaceC0832Tc = this.A00;
                            long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                            if (A08[1].charAt(0) == 'l') {
                            }
                            interfaceC0832Tc.ABo(jCurrentTimeMillis, jCurrentTimeMillis3, length, abstractC1384g7.A04 != null ? 0L : abstractC1384g7.A04.length, interfaceC1371fuA00 != null ? 0 : interfaceC1371fuA00.A9C(), e);
                            throw e;
                        }
                        if (jA03 > 0) {
                            try {
                                Thread.sleep(jA03);
                            } catch (InterruptedException e2) {
                                this.A00.ABo(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, 0L, abstractC1384g7.A04 != null ? abstractC1384g7.A04.length : 0L, 0, e2);
                                throw e;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            i++;
        }
        InterfaceC1371fu interfaceC1371fuA002 = e.A00();
        InterfaceC0832Tc interfaceC0832Tc2 = this.A00;
        long jCurrentTimeMillis32 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (A08[1].charAt(0) == 'l') {
            A08[4] = "ETXEAYq6mx6OG4ZVoxEdED8XICrn9DEf";
            if (interfaceC1371fuA002 != null) {
                length = interfaceC1371fuA002.A72() == null ? 0L : interfaceC1371fuA002.A72().length;
            }
        } else {
            A08[1] = "GUaOJDLzyYCGW5Cxc7undAaXJNT5GVew";
            if (interfaceC1371fuA002 != null) {
            }
        }
        interfaceC0832Tc2.ABo(jCurrentTimeMillis, jCurrentTimeMillis32, length, abstractC1384g7.A04 != null ? 0L : abstractC1384g7.A04.length, interfaceC1371fuA002 != null ? 0 : interfaceC1371fuA002.A9C(), e);
        throw e;
    }

    static {
        A0A();
        A09 = InterfaceC1372fv.class.getSimpleName();
    }

    public C0408Cl(C1377g0 c1377g0, InterfaceC0832Tc interfaceC0832Tc, Executor executor) {
        A0B();
        this.A03 = c1377g0;
        this.A06 = new C0407Ck(c1377g0.A04());
        final InterfaceC1388gB interfaceC1388gB = this.A06;
        this.A05 = new AbstractC0415Ct(interfaceC1388gB) { // from class: com.facebook.ads.redexgen.X.2i
        };
        this.A01 = executor;
        this.A00 = interfaceC0832Tc;
    }

    private final int A00(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStreamAGn = null;
        try {
            outputStreamAGn = this.A05.AGn(httpURLConnection);
            if (outputStreamAGn != null) {
                this.A05.AL8(outputStreamAGn, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStreamAGn != null) {
                try {
                    outputStreamAGn.close();
                } catch (Exception unused) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStreamAGn != null) {
                try {
                    outputStreamAGn.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final InterfaceC1371fu A02(AbstractC1384g7 abstractC1384g7) {
        if (this.A03.A04()) {
            A0C(abstractC1384g7);
        }
        InterfaceC1371fu interfaceC1371fuA01 = null;
        try {
            interfaceC1371fuA01 = A01(abstractC1384g7);
            return interfaceC1371fuA01;
        } catch (C1385g8 hre) {
            this.A05.ADs(hre);
            return interfaceC1371fuA01;
        } catch (Exception e) {
            this.A05.ADs(new C1385g8(e, interfaceC1371fuA01));
            return interfaceC1371fuA01;
        }
    }

    private final InterfaceC1371fu A03(String str, C1386g9 c1386g9, C1380g3 c1380g3) {
        return A02(new C0411Co(str, c1386g9, c1380g3));
    }

    private final InterfaceC1371fu A04(String str, String str2, byte[] bArr, C1380g3 c1380g3) {
        return A02(new C0410Cn(str, null, str2, bArr, c1380g3));
    }

    private final C0409Cm A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream errorStream = null;
        byte[] responseBody = null;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                responseBody = this.A05.AHT(errorStream);
            }
            C0409Cm c0409Cm = new C0409Cm(httpURLConnection, responseBody);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused) {
                }
            }
            return c0409Cm;
        } catch (Throwable th) {
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final C0409Cm A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStreamAGm = null;
        byte[] responseBody = null;
        try {
            inputStreamAGm = this.A05.AGm(httpURLConnection);
            if (inputStreamAGm != null) {
                responseBody = this.A05.AHT(inputStreamAGm);
            }
            C0409Cm c0409Cm = new C0409Cm(httpURLConnection, responseBody);
            if (inputStreamAGm != null) {
                try {
                    inputStreamAGm.close();
                } catch (Exception unused) {
                }
            }
            return c0409Cm;
        } catch (Throwable th) {
            String[] strArr = A08;
            if (strArr[3].charAt(2) != strArr[0].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "UXNjV4lzV2ywD4tdDbD0LjxSkhTqZWDx";
            strArr2[0] = "ckNMQEffDKJwLTwRJSWHE7UL6GsW6bMO";
            if (inputStreamAGm != null) {
                try {
                    inputStreamAGm.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final HttpURLConnection A08(String str, Proxy proxy) throws IOException {
        try {
            new URL(str);
            TrafficStats.setThreadStatsTag(61453);
            return this.A05.AGl(str, proxy);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(str + A07(18, 19, 27), e);
        }
    }

    public static Proxy A09() {
        Proxy proxy = Proxy.NO_PROXY;
        String property = System.getProperty(A07(192, 14, 1));
        String proxyAddress = System.getProperty(A07(ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER, 14, 98));
        int port = -1;
        if (proxyAddress != null) {
            try {
                port = Integer.parseInt(proxyAddress);
            } catch (NumberFormatException unused) {
                return proxy;
            }
        }
        if (!TextUtils.isEmpty(property) && port > 0 && port <= 65535) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, port));
        }
        return proxy;
    }

    public static synchronized void A0B() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private void A0C(AbstractC1384g7 abstractC1384g7) {
        StringBuilder sb = new StringBuilder(A07(182, 10, 43));
        boolean zEquals = abstractC1384g7.A03().equals(EnumC1383g6.A06);
        String strA07 = A07(41, 1, 120);
        if (zEquals) {
            byte[] bArrA06 = abstractC1384g7.A06();
            if (A08[1].charAt(0) == 'l') {
                throw new RuntimeException();
            }
            A08[4] = "MgpsgMtpOSh21D9UNcI3ZUtvoefc4JIC";
            if (bArrA06 != null) {
                sb.append(A07(7, 5, 124));
                sb.append(new String(abstractC1384g7.A06(), Charset.forName(A07(130, 5, 83))));
                sb.append(strA07);
            }
        }
        for (Map.Entry<String, String> entry : abstractC1384g7.A02().A06().entrySet()) {
            sb.append(A07(2, 5, 87));
            sb.append(entry.getKey());
            sb.append(A07(66, 1, 47));
            sb.append(entry.getValue());
            sb.append(strA07);
        }
        sb.append(A07(0, 2, 10));
        sb.append(abstractC1384g7.A05());
        sb.append(strA07);
        String string = sb.toString();
        A0E(string, 1, (string.length() / 4000) + 1);
    }

    private void A0D(AbstractC1384g7 abstractC1384g7, InterfaceC1373fw interfaceC1373fw) {
        this.A04.A6y(this, interfaceC1373fw, this.A01).A04(abstractC1384g7);
        if (this.A03.A04()) {
            A0C(abstractC1384g7);
        }
    }

    private void A0E(String str, int i, int i2) {
        String str2 = A09 + A07(12, 6, 47) + i + A07(65, 1, 96) + i2;
        if (str.length() > 4000) {
            str.substring(0, 4000);
            A0E(str.substring(4000), i + 1, i2);
        }
    }

    private void A0F(String str, String str2, byte[] bArr, InterfaceC1373fw interfaceC1373fw, C1380g3 c1380g3) {
        C0410Cn req = new C0410Cn(str, null, str2, bArr, c1380g3);
        A0D(req, interfaceC1373fw);
    }

    private void A0G(HttpURLConnection httpURLConnection, AbstractC1384g7 abstractC1384g7) {
        Map<String, String> mapA06 = abstractC1384g7.A02().A06();
        InterfaceC1370ft interfaceC1370ftA05 = abstractC1384g7.A02().A05();
        for (String str : mapA06.keySet()) {
            httpURLConnection.setRequestProperty(str, mapA06.get(str));
        }
        if (interfaceC1370ftA05 != null) {
            Map<String, String> mapA6g = interfaceC1370ftA05.A6g(this.A03.A03());
            for (String str2 : mapA6g.keySet()) {
                httpURLConnection.setRequestProperty(str2, mapA6g.get(str2));
            }
        }
    }

    private final void A0H(HttpURLConnection httpURLConnection, AbstractC1384g7 abstractC1384g7) throws IOException {
        C1380g3 c1380g3A02 = abstractC1384g7.A02();
        httpURLConnection.setConnectTimeout(c1380g3A02.A00());
        httpURLConnection.setReadTimeout(c1380g3A02.A02());
        this.A05.AH6(httpURLConnection, abstractC1384g7.A03(), abstractC1384g7.A04());
    }

    private final boolean A0I(Throwable th, long j, AbstractC1384g7 abstractC1384g7) {
        C1380g3 c1380g3A02 = abstractC1384g7.A02();
        long jCurrentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.A06.AAZ()) {
            String str = A07(67, 15, 118) + jCurrentTimeMillis + A07(42, 7, 69) + c1380g3A02.A00() + A07(49, 7, 10) + c1380g3A02.A02();
        }
        if (this.A02) {
            long jA02 = c1380g3A02.A02();
            if (A08[4].charAt(1) == 'Y') {
                throw new RuntimeException();
            }
            A08[7] = "tgQXMymp9cIZW";
            return jCurrentTimeMillis >= jA02;
        }
        long elapsedTime = c1380g3A02.A00();
        return jCurrentTimeMillis >= elapsedTime;
    }

    public final C1377g0 A0K() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1372fv
    @Deprecated
    public final InterfaceC1371fu AGw(String str, Map<String, String> parameters) {
        return A03(str, new C1386g9(parameters), this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1372fv
    @Deprecated
    public final InterfaceC1371fu AGx(String str, byte[] bArr) {
        return A04(str, A07(135, 47, 102), bArr, this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1372fv
    public final void AGy(String str, byte[] bArr, InterfaceC1373fw interfaceC1373fw) {
        A0F(str, A07(135, 47, 102), bArr, interfaceC1373fw, this.A03.A00());
    }
}
