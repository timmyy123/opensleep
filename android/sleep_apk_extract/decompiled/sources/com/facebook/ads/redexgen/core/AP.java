package com.facebook.ads.redexgen.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.ads.AdError;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization("OculusDefaultDataSource extends this class and hence cannot be final")
public final class AP implements InterfaceC1917pF {
    public static byte[] A0B;
    public static String[] A0C = {"tGdrGbTKqUAyZjAtECCaXso437TIFtay", "xasvTmVCH4LeG7al8p8ObQF4UIpko", "linuVDi59rGKxPba8cSgrQfx0g5xcZS0", "EsZJycHVVsXuEv", "at8NLtJKkPgo1aJyGFOZsbSRJOLI96cu", "TOIRSmJtL8rNzzbss9LVqHyYWtEEJZpF", "R6ga9urJMlxgk01j3rMsq3yEpAD", "8pNo6y0"};
    public InterfaceC1917pF A00;
    public InterfaceC1917pF A01;
    public InterfaceC1917pF A02;
    public InterfaceC1917pF A03;
    public InterfaceC1917pF A04;
    public InterfaceC1917pF A05;
    public InterfaceC1917pF A06;

    @MetaExoPlayerCustomization("OculusDefaultDataSource accesses this field directly")
    public InterfaceC1917pF A07;
    public final InterfaceC1917pF A08;

    @MetaExoPlayerCustomization("OculusDefaultDataSource accesses this field directly")
    public final Context A09;

    @MetaExoPlayerCustomization("OculusDefaultDataSource accesses this field directly")
    public final List<InterfaceC02525t> A0A = new ArrayList();

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 6);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0B = new byte[]{24, 86, 89, 83, 69, 88, 94, 83, 104, 86, 68, 68, 82, 67, 24, 76, 121, 121, 104, 96, 125, 121, 100, 99, 106, 45, 121, 98, 45, 125, 97, 108, 116, 45, 95, 89, 64, 93, 45, 126, 121, 127, 104, 108, 96, 45, 122, 100, 121, 101, 98, 120, 121, 45, 105, 104, 125, 104, 99, 105, 100, 99, 106, 45, 98, 99, 45, 121, 101, 104, 45, 95, 89, 64, 93, 45, 104, 117, 121, 104, 99, 126, 100, 98, 99, 83, 114, 113, 118, 98, 123, 99, 83, 118, 99, 118, 68, 120, 98, 101, 116, 114, 7, 48, 48, 45, 48, 98, 43, 44, 49, 54, 35, 44, 54, 43, 35, 54, 43, 44, 37, 98, 16, 22, 15, 18, 98, 39, 58, 54, 39, 44, 49, 43, 45, 44, 70, 73, 67, 85, 72, 78, 67, 9, 85, 66, 84, 72, 82, 85, 68, 66, 48, 34, 34, 52, 37, 38, 42, 40, 107, 35, 36, 38, 32, 39, 42, 42, 46, 107, 36, 33, 54, 107, 34, 42, 42, 34, 41, 32, 107, 36, 43, 33, 55, 42, 44, 33, 107, 32, 61, 42, 53, 41, 36, 60, 32, 55, 119, 107, 32, 61, 49, 107, 55, 49, 40, 53, 107, 23, 49, 40, 53, 1, 36, 49, 36, 22, 42, 48, 55, 38, 32, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, 1, 27, 10, 1, 27, 63, 58, 47, 58, 51, 32, 54, 51, 36, 50, 46, 52, 51, 34, 36, 75, 77, 84, 73, 70, 87, 67};
    }

    static {
        A08();
    }

    public AP(Context context, InterfaceC1917pF interfaceC1917pF) {
        this.A09 = context.getApplicationContext();
        this.A08 = (InterfaceC1917pF) AbstractC02053y.A01(interfaceC1917pF);
    }

    private InterfaceC1917pF A00() {
        if (this.A00 == null) {
            final Context context = this.A09;
            this.A00 = new AQ(context) { // from class: com.facebook.ads.redexgen.X.1n
                public static byte[] A05;
                public static String[] A06 = {"PTz87XAKzq7jvDXOa", "sgpUZ", "Bde9N92B9PLOW1wkk", "DRZuAIPcc", "gakZC5ePxUI2GDKV9", "pz9vQcEWFJbuREE6smExYo368tZlwkrG", "j43UPSzsV7IrH", "51Zh85ddLdY4jrUIDlK8L"};
                public long A00;
                public Uri A01;
                public InputStream A02;
                public boolean A03;
                public final AssetManager A04;

                public static String A00(int i, int i2, int i3) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
                    for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                        int i5 = (bArrCopyOfRange[i4] ^ i3) ^ 113;
                        String[] strArr = A06;
                        if (strArr[2].length() != strArr[4].length()) {
                            throw new RuntimeException();
                        }
                        A06[1] = "rCVU";
                        bArrCopyOfRange[i4] = (byte) i5;
                    }
                    return new String(bArrCopyOfRange);
                }

                public static void A01() {
                    A05 = new byte[]{124, 116, 58, 53, 63, 41, 52, 50, 63, 4, 58, 40, 40, 62, 47, 116};
                }

                /* JADX WARN: Failed to parse debug info
                java.lang.ArrayIndexOutOfBoundsException
                 */
                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                public final long AGi(C02415i c02415i) throws C1919pH {
                    try {
                        this.A01 = c02415i.A06;
                        String strSubstring = (String) AbstractC02053y.A01(this.A01.getPath());
                        boolean zStartsWith = strSubstring.startsWith(A00(1, 15, 42));
                        String[] strArr = A06;
                        if (strArr[2].length() == strArr[4].length()) {
                            String[] strArr2 = A06;
                            strArr2[2] = "3xdRIl55zUe0UeQhp";
                            strArr2[4] = "pS29hwepCfn47vExr";
                            if (zStartsWith) {
                                strSubstring = strSubstring.substring(15);
                            } else if (strSubstring.startsWith(A00(0, 1, 34))) {
                                strSubstring = strSubstring.substring(1);
                            }
                            A0G(c02415i);
                            this.A02 = this.A04.open(strSubstring, 1);
                            if (this.A02.skip(c02415i.A04) < c02415i.A04) {
                                throw new C1919pH(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                            }
                            if (c02415i.A03 != -1) {
                                this.A00 = c02415i.A03;
                            } else {
                                this.A00 = this.A02.available();
                                if (this.A00 == 2147483647L) {
                                    this.A00 = -1L;
                                }
                            }
                            this.A03 = true;
                            A0H(c02415i);
                            return this.A00;
                        }
                    } catch (C1919pH e) {
                        throw e;
                    } catch (IOException e2) {
                        boolean z = e2 instanceof FileNotFoundException;
                        if (A06[6].length() == 13) {
                            A06[6] = "P3wDYI6sXfUMf";
                            throw new C1919pH(e2, z ? 2005 : 2000);
                        }
                    }
                    throw new RuntimeException();
                }

                static {
                    A01();
                }

                {
                    super(false);
                    this.A04 = context.getAssets();
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                public final Uri A9P() {
                    return this.A01;
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                public final void close() throws C1919pH {
                    this.A01 = null;
                    try {
                        try {
                            if (this.A02 != null) {
                                this.A02.close();
                            }
                        } catch (IOException e) {
                            throw new C1919pH(e, 2000);
                        }
                    } finally {
                        this.A02 = null;
                        if (this.A03) {
                            this.A03 = false;
                            A0E();
                        }
                    }
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC01612c
                public final int read(byte[] bArr, int i, int i2) throws IOException {
                    if (i2 == 0) {
                        return 0;
                    }
                    if (this.A00 == 0) {
                        return -1;
                    }
                    try {
                        if (this.A00 != -1) {
                            i2 = (int) Math.min(this.A00, i2);
                        }
                        int i3 = ((InputStream) C5C.A0f(this.A02)).read(bArr, i, i2);
                        if (i3 == -1) {
                            return -1;
                        }
                        long j = this.A00;
                        if (A06[6].length() != 13) {
                            throw new RuntimeException();
                        }
                        A06[6] = "7Z6S4bUZVA19c";
                        if (j != -1) {
                            this.A00 -= (long) i3;
                        }
                        A0F(i3);
                        return i3;
                    } catch (IOException e) {
                        throw new C1919pH(e, 2000);
                    }
                }
            };
            A09(this.A00);
        }
        return this.A00;
    }

    private InterfaceC1917pF A01() {
        if (this.A01 == null) {
            final Context context = this.A09;
            this.A01 = new AQ(context) { // from class: com.facebook.ads.redexgen.X.1m
                public static byte[] A06;
                public static String[] A07 = {"2ftN4rqyMzReasXlS0Bd7yvXq4Z2w8Rd", "SB3v1XRSpovCjfjTdx7anKa7xqXJKcRT", "XVjCn6r7eDTGJtLvngTS2wgt8nCOhnB8", "1Z3zzaFrxDlwod4BzGavHrSG6vNvtkR5", "UgcL11Y1AQOJlkVRTNTymNMOAMwNhJW2", "NkTGPgJcqOjwrAzhjPkYXMY7OTNaeVTG", "UuxCrg9I54LtW8vlxqROWB7HyIfBI135", "4rxicH75x32fMwhdD1obBcUBdLwTm4oP"};
                public long A00;
                public AssetFileDescriptor A01;
                public Uri A02;
                public FileInputStream A03;
                public boolean A04;
                public final ContentResolver A05;

                public static String A00(int i, int i2, int i3) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
                    for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                        bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 87);
                    }
                    return new String(bArrCopyOfRange);
                }

                public static void A01() {
                    A06 = new byte[]{-76, -71, -76, 10, 54, 60, 51, 43, -25, 53, 54, 59, -25, 54, 55, 44, 53, -25, 45, 48, 51, 44, -25, 43, 44, 58, 42, 57, 48, 55, 59, 54, 57, -25, 45, 54, 57, 1, -25, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 25, 15, 29, 26, 20, 15, -39, 27, 29, 26, 33, 20, 15, 16, 29, -39, 16, 35, 31, 29, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -39, -20, -18, -18, -16, -5, -1, 10, -6, -3, -12, -14, -12, -7, -20, -9, 10, -8, -16, -17, -12, -20, 10, -15, -6, -3, -8, -20, -1, -70, -58, -59, -53, -68, -59, -53, 1};
                }

                /* JADX WARN: Code restructure failed: missing block: B:30:0x00e4, code lost:
                
                    if (r0 >= 0) goto L39;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:33:0x00ee, code lost:
                
                    if (r0 >= 0) goto L39;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:38:0x010e, code lost:
                
                    if (r0 >= 0) goto L39;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:43:0x012a, code lost:
                
                    if (r0 >= 0) goto L39;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:58:0x016d, code lost:
                
                    throw new com.facebook.ads.redexgen.core.C1918pG(null, com.facebook.ads.AdError.REMOTE_ADS_SERVICE_ERROR);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:60:0x0176, code lost:
                
                    throw new com.facebook.ads.redexgen.core.C1918pG(null, com.facebook.ads.AdError.REMOTE_ADS_SERVICE_ERROR);
                 */
                /* JADX WARN: Failed to parse debug info
                java.lang.ArrayIndexOutOfBoundsException: Index 23 out of bounds for length 15
                	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
                	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
                	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
                	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
                	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
                 */
                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final long AGi(C02415i c02415i) throws C1918pG {
                    AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
                    try {
                        try {
                            Uri uri = c02415i.A06;
                            this.A02 = uri;
                            A0G(c02415i);
                            if (A00(90, 7, 0).equals(c02415i.A06.getScheme())) {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean(A00(39, 51, 84), true);
                                assetFileDescriptorOpenAssetFileDescriptor = this.A05.openTypedAssetFileDescriptor(uri, A00(0, 3, 51), bundle);
                            } else {
                                assetFileDescriptorOpenAssetFileDescriptor = this.A05.openAssetFileDescriptor(uri, A00(97, 1, 56));
                            }
                            this.A01 = assetFileDescriptorOpenAssetFileDescriptor;
                            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                                try {
                                    throw new C1918pG(new IOException(A00(3, 36, 112) + uri), 2000);
                                } catch (IOException e) {
                                    e = e;
                                    throw new C1918pG(e, e instanceof FileNotFoundException ? 2005 : 2000);
                                }
                            }
                            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                            this.A03 = fileInputStream;
                            if (length != -1 && c02415i.A04 > length) {
                                throw new C1918pG(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                            }
                            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
                            long jSkip = fileInputStream.skip(c02415i.A04 + startOffset) - startOffset;
                            long j = c02415i.A04;
                            String[] strArr = A07;
                            if (strArr[0].charAt(30) == strArr[3].charAt(30)) {
                                String[] strArr2 = A07;
                                strArr2[7] = "V2cYJorATJJITl96mEL4teMpahqL5My0";
                                strArr2[2] = "81QpsL8o4R3JZzZywbg9Kxgu0WDTOmHd";
                                if (jSkip != j) {
                                    throw new C1918pG(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                                }
                                if (length == -1) {
                                    FileChannel channel = fileInputStream.getChannel();
                                    long size = channel.size();
                                    if (size == 0) {
                                        this.A00 = -1L;
                                    } else {
                                        this.A00 = size - channel.position();
                                        long j2 = this.A00;
                                        if (A07[5].charAt(20) != 'X') {
                                            String[] strArr3 = A07;
                                            strArr3[7] = "o4lencYzmcLYt1MiV6fFEBYqoofjVCYJ";
                                            strArr3[2] = "LnRaAWOGUoCClb3L4bo6XdN18ipe8ADC";
                                        } else {
                                            A07[1] = "bSHOsa59vSpVf4yTu8YpmIN0mXabJXNA";
                                        }
                                    }
                                } else {
                                    this.A00 = length - jSkip;
                                    long j3 = this.A00;
                                    if (A07[5].charAt(20) != 'X') {
                                        A07[5] = "bEcLXKtmUZe87exD27VZX6tOwUTS9Sez";
                                    } else {
                                        A07[1] = "HQINqvWzgwxijb9Tl3Os5Fu0qA3gaNYz";
                                    }
                                }
                                long j4 = c02415i.A03;
                                if (A07[5].charAt(20) == 'X') {
                                    String[] strArr4 = A07;
                                    strArr4[0] = "HMZNFKbBHMEnP71uJIxHqXthvd44tlRl";
                                    strArr4[3] = "eoHh6GrHY21TbtSwRzT9Dqoif9pbqNR5";
                                    if (j4 != -1) {
                                        this.A00 = this.A00 == -1 ? c02415i.A03 : Math.min(this.A00, c02415i.A03);
                                    }
                                    this.A04 = true;
                                    A0H(c02415i);
                                    return c02415i.A03 != -1 ? c02415i.A03 : this.A00;
                                }
                            }
                            throw new RuntimeException();
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (C1918pG e3) {
                        throw e3;
                    }
                }

                static {
                    A01();
                }

                {
                    super(false);
                    this.A05 = context.getContentResolver();
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                public final Uri A9P() {
                    return this.A02;
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                public final void close() throws C1918pG {
                    this.A02 = null;
                    try {
                        try {
                            if (this.A03 != null) {
                                this.A03.close();
                            }
                            this.A03 = null;
                            try {
                                try {
                                    if (this.A01 != null) {
                                        this.A01.close();
                                    }
                                } catch (IOException e) {
                                    throw new C1918pG(e, 2000);
                                }
                            } finally {
                                this.A01 = null;
                                if (this.A04) {
                                    this.A04 = false;
                                    A0E();
                                }
                            }
                        } catch (IOException e2) {
                            throw new C1918pG(e2, 2000);
                        }
                    } catch (Throwable th) {
                        this.A03 = null;
                        try {
                            try {
                                if (this.A01 != null) {
                                    this.A01.close();
                                }
                                this.A01 = null;
                                if (this.A04) {
                                    this.A04 = false;
                                    A0E();
                                }
                                throw th;
                            } catch (IOException e3) {
                                throw new C1918pG(e3, 2000);
                            }
                        } finally {
                            this.A01 = null;
                            if (this.A04) {
                                this.A04 = false;
                                A0E();
                            }
                        }
                    }
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC01612c
                public final int read(byte[] bArr, int i, int i2) throws IOException {
                    if (i2 == 0) {
                        return 0;
                    }
                    long j = this.A00;
                    if (A07[1].charAt(15) != 'T') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A07;
                    strArr[0] = "xrRDl1n0HP8M9562uVsbLDb97IGJJORF";
                    strArr[3] = "BxGqKYmJPgWUa88HGr5IfMWzChfrhfRY";
                    if (j == 0) {
                        return -1;
                    }
                    try {
                        if (this.A00 != -1) {
                            i2 = (int) Math.min(this.A00, i2);
                        }
                        int i3 = ((FileInputStream) C5C.A0f(this.A03)).read(bArr, i, i2);
                        if (i3 == -1) {
                            return -1;
                        }
                        if (this.A00 != -1) {
                            this.A00 -= (long) i3;
                        }
                        A0F(i3);
                        return i3;
                    } catch (IOException e) {
                        throw new C1918pG(e, 2000);
                    }
                }
            };
            A09(this.A01);
        }
        return this.A01;
    }

    private InterfaceC1917pF A02() {
        if (this.A02 == null) {
            this.A02 = new AQ() { // from class: com.facebook.ads.redexgen.X.1l
                public static byte[] A04;
                public int A00;
                public int A01;
                public C02415i A02;
                public byte[] A03;

                static {
                    A01();
                }

                public static String A00(int i, int i2, int i3) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
                    for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                        bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 120);
                    }
                    return new String(bArrCopyOfRange);
                }

                public static void A01() {
                    A04 = new byte[]{-17, 48, 87, 86, 104, 90, 43, 41, 58, 103, 103, 100, 103, 21, 108, 93, 94, 97, 90, 21, 101, 86, 103, 104, 94, 99, 92, 21, 55, 86, 104, 90, 43, 41, 21, 90, 99, 88, 100, 89, 90, 89, 21, 104, 105, 103, 94, 99, 92, 47, 21, -23, 2, -7, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 4, -7, -9, 8, -7, -8, -76, -23, -26, -35, -76, -6, 3, 6, 1, -11, 8, -50, -76, 60, 85, 90, 92, 87, 87, 86, 89, 91, 76, 75, 7, 90, 74, 79, 76, 84, 76, 33, 7, 25, 22, 41, 22};
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                public final Uri A9P() {
                    if (this.A02 != null) {
                        return this.A02.A06;
                    }
                    return null;
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                public final long AGi(C02415i c02415i) throws IOException {
                    A0G(c02415i);
                    this.A02 = c02415i;
                    Uri uri = c02415i.A06;
                    String scheme = uri.getScheme();
                    AbstractC02053y.A09(A00(94, 4, 61).equals(scheme), A00(74, 20, 111) + scheme);
                    String[] uriParts = C5C.A1O(uri.getSchemeSpecificPart(), A00(0, 1, 75));
                    if (uriParts.length == 2) {
                        String str = uriParts[1];
                        String dataString = uriParts[0];
                        if (dataString.contains(A00(1, 7, 125))) {
                            try {
                                this.A03 = Base64.decode(str, 0);
                            } catch (IllegalArgumentException e) {
                                throw C3K.A02(A00(8, 43, 125) + str, e);
                            }
                        } else {
                            this.A03 = C5C.A1G(URLDecoder.decode(str, AbstractC1618k9.A01.name()));
                        }
                        if (c02415i.A04 <= this.A03.length) {
                            this.A01 = (int) c02415i.A04;
                            this.A00 = this.A03.length - this.A01;
                            if (c02415i.A03 != -1) {
                                this.A00 = (int) Math.min(this.A00, c02415i.A03);
                            }
                            A0H(c02415i);
                            return c02415i.A03 != -1 ? c02415i.A03 : this.A00;
                        }
                        this.A03 = null;
                        throw new C02345b(AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                    throw C3K.A02(A00(51, 23, 28) + uri, null);
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                public final void close() {
                    if (this.A03 != null) {
                        this.A03 = null;
                        A0E();
                    }
                    this.A02 = null;
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC01612c
                public final int read(byte[] bArr, int i, int i2) {
                    if (i2 == 0) {
                        return 0;
                    }
                    if (this.A00 == 0) {
                        return -1;
                    }
                    int iMin = Math.min(i2, this.A00);
                    System.arraycopy(C5C.A0f(this.A03), this.A01, bArr, i, iMin);
                    this.A01 += iMin;
                    this.A00 -= iMin;
                    A0F(iMin);
                    return iMin;
                }
            };
            A09(this.A02);
        }
        return this.A02;
    }

    private InterfaceC1917pF A03() {
        if (this.A03 == null) {
            this.A03 = new C01421j();
            A09(this.A03);
        }
        return this.A03;
    }

    private InterfaceC1917pF A04() {
        if (this.A04 == null) {
            final Context context = this.A09;
            this.A04 = new AQ(context) { // from class: com.facebook.ads.redexgen.X.1i
                public static byte[] A07;
                public static String[] A08 = {"QLuP8Pt4KiB", "RgtlFkBshe2uzsEMObMvf6GLE9oju0kX", "TTP1lITjIL7gpSd4kE", "ZIRCIqgztw3RRTH34yg2MmGGdHBG3Sqw", "W8lxrl5W", "1BP9Supp2XIZ7aBeV", "CPoLKetsO3XScG5XHhoA5", "r"};
                public long A00;
                public AssetFileDescriptor A01;
                public Uri A02;
                public InputStream A03;
                public boolean A04;
                public final Resources A05;
                public final String A06;

                public static String A00(int i, int i2, int i3) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
                    for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                        bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 127);
                    }
                    return new String(bArrCopyOfRange);
                }

                public static void A01() {
                    A07 = new byte[]{105, 54, 72, 99, 105, 45, 98, 107, 45, 126, 121, 127, 104, 108, 96, 45, 127, 104, 108, 110, 101, 104, 105, 45, 101, 108, 123, 100, 99, 106, 45, 99, 98, 121, 45, 127, 104, 108, 105, 45, 126, 120, 107, 107, 100, 110, 100, 104, 99, 121, 45, 105, 108, 121, 108, 35, 122, 77, 91, 71, 93, 90, 75, 77, 8, 65, 76, 77, 70, 92, 65, 78, 65, 77, 90, 8, 69, 93, 91, 92, 8, 74, 77, 8, 73, 70, 8, 65, 70, 92, 77, 79, 77, 90, 6, 27, 44, 58, 38, 60, 59, 42, 44, 105, 32, 58, 105, 42, 38, 36, 57, 59, 44, 58, 58, 44, 45, 115, 105, 50, 5, 19, 15, 21, 18, 3, 5, 64, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 20, 64, 6, 15, 21, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 4, 78, 115, 116, 111, 6, 75, 83, 85, 82, 6, 67, 79, 82, 78, 67, 84, 6, 83, 85, 67, 6, 85, 69, 78, 67, 75, 67, 6, 84, 71, 81, 84, 67, 85, 73, 83, 84, 69, 67, 6, 73, 84, 6, 71, 72, 66, 84, 73, 79, 66, 8, 84, 67, 85, 73, 83, 84, 69, 67, 114, 74, 5, 98, 109, 103, 113, 108, 106, 103, 45, 113, 102, 112, 108, 118, 113, 96, 102, 69, 86, 64, 92, 79, 89, 92, 75, 93, 65, 91, 92, 77, 75};
                }

                /* JADX WARN: Code restructure failed: missing block: B:100:0x0260, code lost:
                
                    throw new com.facebook.ads.redexgen.core.C1905p3(A00(119, 19, 31), null, 2005);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:24:0x00f7, code lost:
                
                    if (r1 != 0) goto L25;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x0116, code lost:
                
                    if (r1 != 0) goto L25;
                 */
                /* JADX WARN: Failed to parse debug info
                java.lang.ArrayIndexOutOfBoundsException
                 */
                /* JADX WARN: Removed duplicated region for block: B:107:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final long AGi(C02415i c02415i) throws C1905p3 {
                    int identifier;
                    C01411i c01411i;
                    Uri uri = c02415i.A06;
                    this.A02 = uri;
                    if (!TextUtils.equals(A00(218, 11, 81), uri.getScheme())) {
                        String scheme = uri.getScheme();
                        String[] strArr = A08;
                        if (strArr[1].charAt(14) != strArr[3].charAt(14)) {
                            String[] strArr2 = A08;
                            strArr2[4] = "6WAfCQCC";
                            strArr2[5] = "2bXUndVpRAzh6SBol";
                            String strA00 = A00(199, 16, 124);
                            if (TextUtils.equals(strA00, scheme) && uri.getPathSegments().size() == 1 && ((String) AbstractC02053y.A01(uri.getLastPathSegment())).matches(A00(196, 3, 81))) {
                                try {
                                    identifier = Integer.parseInt((String) AbstractC02053y.A01(uri.getLastPathSegment()));
                                } catch (NumberFormatException unused) {
                                    throw new C1905p3(A00(56, 39, 87), null, 1004);
                                }
                            } else {
                                if (!TextUtils.equals(strA00, uri.getScheme())) {
                                    throw new C1905p3(A00(138, 58, 89), null, 1004);
                                }
                                String strSubstring = (String) AbstractC02053y.A01(uri.getPath());
                                if (strSubstring.startsWith(A00(0, 1, 57))) {
                                    strSubstring = strSubstring.substring(1);
                                }
                                String host = uri.getHost();
                                String str = (TextUtils.isEmpty(host) ? A00(0, 0, 29) : host + A00(1, 1, 115)) + strSubstring;
                                Resources resources = this.A05;
                                String str2 = this.A06;
                                if (A08[6].length() != 1) {
                                    String[] strArr3 = A08;
                                    strArr3[1] = "8DRS4lLYfMrToLqDwLXqvfchHPsueWE2";
                                    strArr3[3] = "vCWitTtlDB9EwPvV6O7ut3igyg5fSS64";
                                    identifier = resources.getIdentifier(str, A00(215, 3, 72), str2);
                                } else {
                                    String[] strArr4 = A08;
                                    strArr4[7] = "A";
                                    strArr4[2] = "wipKq4bcm9KT4pACcA";
                                    identifier = resources.getIdentifier(str, A00(10, 1, 58), str2);
                                }
                            }
                            A0G(c02415i);
                            try {
                                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.A05.openRawResourceFd(identifier);
                                this.A01 = assetFileDescriptorOpenRawResourceFd;
                                if (assetFileDescriptorOpenRawResourceFd == null) {
                                    throw new C1905p3(A00(95, 24, 54) + uri, null, 2000);
                                }
                                long length = assetFileDescriptorOpenRawResourceFd.getLength();
                                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
                                this.A03 = fileInputStream;
                                if (length != -1) {
                                    try {
                                        if (c02415i.A04 > length) {
                                            throw new C1905p3(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                                        }
                                    } catch (C1905p3 e) {
                                        throw e;
                                    } catch (IOException e2) {
                                        e = e2;
                                        throw new C1905p3(null, e, 2000);
                                    }
                                }
                                try {
                                    long startOffset = assetFileDescriptorOpenRawResourceFd.getStartOffset();
                                    long jSkip = fileInputStream.skip(c02415i.A04 + startOffset) - startOffset;
                                    try {
                                    } catch (C1905p3 e3) {
                                        throw e3;
                                    } catch (IOException e4) {
                                        e = e4;
                                    }
                                    try {
                                        if (jSkip != c02415i.A04) {
                                            throw new C1905p3(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                                        }
                                        if (length == -1) {
                                            FileChannel channel = fileInputStream.getChannel();
                                            if (channel.size() == 0) {
                                                c01411i = this;
                                                c01411i.A00 = -1L;
                                            } else {
                                                c01411i = this;
                                                c01411i.A00 = channel.size() - channel.position();
                                                if (c01411i.A00 < 0) {
                                                    throw new C1905p3(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                                                }
                                            }
                                        } else {
                                            c01411i = this;
                                            c01411i.A00 = length - jSkip;
                                            if (c01411i.A00 < 0) {
                                                throw new C02345b(AdError.REMOTE_ADS_SERVICE_ERROR);
                                            }
                                        }
                                        long j = c02415i.A03;
                                        String[] strArr5 = A08;
                                        if (strArr5[7].length() != strArr5[2].length()) {
                                            A08[0] = "f";
                                            if (j != -1) {
                                                c01411i.A00 = c01411i.A00 == -1 ? c02415i.A03 : Math.min(c01411i.A00, c02415i.A03);
                                            }
                                            c01411i.A04 = true;
                                            A0H(c02415i);
                                            return c02415i.A03 != -1 ? c02415i.A03 : c01411i.A00;
                                        }
                                    } catch (C1905p3 e5) {
                                        throw e5;
                                    } catch (IOException e6) {
                                        e = e6;
                                        throw new C1905p3(null, e, 2000);
                                    }
                                } catch (C1905p3 e7) {
                                    throw e7;
                                } catch (IOException e8) {
                                    e = e8;
                                }
                            } catch (Resources.NotFoundException e9) {
                                throw new C1905p3(null, e9, 2005);
                            }
                        }
                    }
                    throw new RuntimeException();
                }

                static {
                    A01();
                }

                {
                    super(false);
                    this.A05 = context.getResources();
                    this.A06 = context.getPackageName();
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                public final Uri A9P() {
                    return this.A02;
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                public final void close() throws C1905p3 {
                    this.A02 = null;
                    try {
                        try {
                            if (this.A03 != null) {
                                this.A03.close();
                            }
                            this.A03 = null;
                            try {
                                try {
                                    if (this.A01 != null) {
                                        this.A01.close();
                                    }
                                } catch (IOException e) {
                                    throw new C1905p3(null, e, 2000);
                                }
                            } catch (Throwable th) {
                                this.A01 = null;
                                String[] strArr = A08;
                                if (strArr[1].charAt(14) == strArr[3].charAt(14)) {
                                    throw new RuntimeException();
                                }
                                A08[6] = "iC26zNxzLLnB2GH7qyOIGlAQhGgRPuU";
                                if (this.A04) {
                                    this.A04 = false;
                                    A0E();
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            throw new C1905p3(null, e2, 2000);
                        }
                    } catch (Throwable th2) {
                        this.A03 = null;
                        try {
                            try {
                                if (this.A01 != null) {
                                    this.A01.close();
                                }
                                this.A01 = null;
                                if (this.A04) {
                                    this.A04 = false;
                                    A0E();
                                }
                                throw th2;
                            } catch (IOException e3) {
                                throw new C1905p3(null, e3, 2000);
                            }
                        } finally {
                            this.A01 = null;
                            if (this.A04) {
                                this.A04 = false;
                                A0E();
                            }
                        }
                    }
                }

                @Override // com.facebook.ads.redexgen.core.InterfaceC01612c
                public final int read(byte[] bArr, int i, int i2) throws C1905p3 {
                    if (i2 == 0) {
                        return 0;
                    }
                    if (this.A00 == 0) {
                        return -1;
                    }
                    try {
                        if (this.A00 != -1) {
                            i2 = (int) Math.min(this.A00, i2);
                        }
                        int i3 = ((InputStream) C5C.A0f(this.A03)).read(bArr, i, i2);
                        if (i3 == -1) {
                            if (this.A00 == -1) {
                                return -1;
                            }
                            throw new C1905p3(A00(2, 54, 114), new EOFException(), 2000);
                        }
                        if (this.A00 != -1) {
                            this.A00 -= (long) i3;
                        }
                        A0F(i3);
                        return i3;
                    } catch (IOException e) {
                        throw new C1905p3(null, e, 2000);
                    }
                }
            };
            A09(this.A04);
        }
        return this.A04;
    }

    private InterfaceC1917pF A05() throws Exception {
        if (this.A05 == null) {
            try {
                this.A05 = (InterfaceC1917pF) Class.forName(A07(157, 66, 67)).getConstructor(new Class[0]).newInstance(new Object[0]);
                A09(this.A05);
            } catch (ClassNotFoundException unused) {
                AbstractC02134g.A07(A07(85, 17, 17), A07(15, 70, 11));
            } catch (Exception e) {
                throw new RuntimeException(A07(102, 34, 68), e);
            }
            if (this.A05 == null) {
                this.A05 = this.A08;
            }
        }
        return this.A05;
    }

    private InterfaceC1917pF A06() {
        if (this.A06 == null) {
            this.A06 = new C01401h();
            A09(this.A06);
        }
        return this.A06;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A09(InterfaceC1917pF interfaceC1917pF) {
        for (int i = 0; i < i; i++) {
            interfaceC1917pF.A43(this.A0A.get(i));
        }
    }

    private void A0A(InterfaceC1917pF interfaceC1917pF, InterfaceC02525t interfaceC02525t) {
        if (interfaceC1917pF != null) {
            interfaceC1917pF.A43(interfaceC02525t);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
    public final void A43(InterfaceC02525t interfaceC02525t) {
        AbstractC02053y.A01(interfaceC02525t);
        this.A08.A43(interfaceC02525t);
        this.A0A.add(interfaceC02525t);
        A0A(this.A03, interfaceC02525t);
        A0A(this.A00, interfaceC02525t);
        A0A(this.A01, interfaceC02525t);
        A0A(this.A05, interfaceC02525t);
        A0A(this.A06, interfaceC02525t);
        A0A(this.A02, interfaceC02525t);
        A0A(this.A04, interfaceC02525t);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
    public final Map<String, List<String>> A8t() {
        return this.A07 == null ? Collections.emptyMap() : this.A07.A8t();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
    public final Uri A9P() {
        if (this.A07 == null) {
            return null;
        }
        return this.A07.A9P();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012e  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long AGi(C02415i c02415i) throws IOException {
        AbstractC02053y.A08(this.A07 == null);
        String scheme = c02415i.A06.getScheme();
        if (C5C.A1A(c02415i.A06)) {
            String path = c02415i.A06.getPath();
            if (path != null) {
                String[] strArr = A0C;
                String uriPath = strArr[4];
                if (uriPath.charAt(27) != strArr[0].charAt(27)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0C;
                strArr2[4] = "woaZ3GsQ3DbiayOrUPjNVqqq8n8IT0aY";
                strArr2[0] = "klzvMTRWbU3yZvxB9bRoGsioUmbI9kjx";
                String scheme2 = A07(0, 15, 49);
                if (path.startsWith(scheme2)) {
                    InterfaceC1917pF interfaceC1917pFA00 = A00();
                    String[] strArr3 = A0C;
                    String uriPath2 = strArr3[4];
                    if (uriPath2.charAt(27) != strArr3[0].charAt(27)) {
                        String[] strArr4 = A0C;
                        strArr4[1] = "PIVfyqk1Etrv0Wbxq4vDpVOoMCV7O";
                        strArr4[7] = "Bsp2dR1";
                        this.A07 = interfaceC1917pFA00;
                    } else {
                        String[] strArr5 = A0C;
                        strArr5[1] = "maZBVk5L4nnlZEqCNC7SxmxFjkMbb";
                        strArr5[7] = "XTvzFpJ";
                        this.A07 = interfaceC1917pFA00;
                    }
                } else {
                    this.A07 = A03();
                }
            }
        } else {
            String scheme3 = A07(152, 5, 87);
            if (scheme3.equals(scheme)) {
                this.A07 = A00();
            } else {
                String scheme4 = A07(223, 7, 105);
                if (scheme4.equals(scheme)) {
                    this.A07 = A01();
                } else {
                    String scheme5 = A07(245, 4, 63);
                    if (scheme5.equals(scheme)) {
                        this.A07 = A05();
                    } else {
                        String scheme6 = A07(249, 3, 53);
                        if (scheme6.equals(scheme)) {
                            this.A07 = A06();
                        } else {
                            String scheme7 = A07(230, 4, 93);
                            if (scheme7.equals(scheme)) {
                                this.A07 = A02();
                            } else {
                                String scheme8 = A07(234, 11, 71);
                                if (!scheme8.equals(scheme)) {
                                    String scheme9 = A07(136, 16, 33);
                                    if (scheme9.equals(scheme)) {
                                        this.A07 = A04();
                                    } else {
                                        this.A07 = this.A08;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return this.A07.AGi(c02415i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
    public final void close() throws IOException {
        if (this.A07 != null) {
            try {
                this.A07.close();
            } finally {
                this.A07 = null;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01612c
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return ((InterfaceC1917pF) AbstractC02053y.A01(this.A07)).read(bArr, i, i2);
    }
}
