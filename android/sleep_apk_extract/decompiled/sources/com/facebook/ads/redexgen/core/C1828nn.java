package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1828nn implements FL, InterfaceC0412Cp {
    public static String[] A0E = {"SSDELygzudefytBtRYlDWoyFfpg", "4SEnazR2Nu4dPKZqq", "4H9jqKlT7lQdtxWBQl9xa6akogWkCWsp", "Wknx73gM1GoPE2GN1snRYal1oMjUwY3P", "7txELYcTJwThSLRxJ5dUM1K4qPQ", "gA7GGJKubAjwOro28", "9KdodW4K4GXGszeM7wnefptXiT4TjY3", ""};
    public long A00;
    public C02415i A01;
    public InterfaceC0528Hd A02;
    public boolean A04;
    public final Uri A06;
    public final AnonymousClass48 A07;
    public final AG A08;
    public final DD A09;
    public final HA A0A;
    public volatile boolean A0C;
    public final /* synthetic */ C03449p A0D;
    public final HV A0B = new HV();
    public boolean A03 = true;
    public final long A05 = Cq.A00();

    public C1828nn(C03449p c03449p, Uri uri, InterfaceC1917pF interfaceC1917pF, DD dd, HA ha, AnonymousClass48 anonymousClass48) {
        this.A0D = c03449p;
        this.A06 = uri;
        this.A08 = new AG(interfaceC1917pF);
        this.A09 = dd;
        this.A0A = ha;
        this.A07 = anonymousClass48;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(long j, long j2) {
        this.A0B.A00 = j;
        this.A00 = j2;
        this.A03 = true;
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.core.FL
    public final void A4r() {
        this.A0C = true;
    }

    @Override // com.facebook.ads.redexgen.core.FL
    public final void AAr() throws IOException {
        int iAHM = 0;
        while (iAHM == 0 && !this.A0C) {
            try {
                long j = this.A0B.A00;
                this.A01 = new C02415i(this.A06, j, -1L, this.A0D.A0b);
                long jAGi = this.A08.AGi(this.A01);
                if (jAGi != -1) {
                    jAGi += j;
                    this.A0D.A0G();
                }
                this.A0D.A09 = null;
                InterfaceC1917pF interfaceC1917pF = this.A08;
                if (this.A0D.A09 != null && this.A0D.A09.A01 != -1) {
                    final AG ag = this.A08;
                    final int i = this.A0D.A09.A01;
                    interfaceC1917pF = new InterfaceC1917pF(ag, i, this) { // from class: com.facebook.ads.redexgen.X.9r
                        public int A00;
                        public final int A01;
                        public final InterfaceC1917pF A02;
                        public final InterfaceC0412Cp A03;
                        public final byte[] A04;

                        {
                            AbstractC02053y.A07(i > 0);
                            this.A02 = ag;
                            this.A01 = i;
                            this.A03 = this;
                            this.A04 = new byte[1];
                            this.A00 = i;
                        }

                        private boolean A00() throws IOException {
                            int bytesRead = this.A02.read(this.A04, 0, 1);
                            if (bytesRead == -1) {
                                return false;
                            }
                            int bytesRead2 = this.A04[0];
                            int metadataLength = (bytesRead2 & PHIpAddressSearchManager.END_IP_SCAN) << 4;
                            if (metadataLength == 0) {
                                return true;
                            }
                            int i2 = 0;
                            int i3 = metadataLength;
                            byte[] bArr = new byte[metadataLength];
                            while (i3 > 0) {
                                int bytesRead3 = this.A02.read(bArr, i2, i3);
                                if (bytesRead3 == -1) {
                                    return false;
                                }
                                i2 += bytesRead3;
                                i3 -= bytesRead3;
                            }
                            while (metadataLength > 0) {
                                int bytesRead4 = metadataLength - 1;
                                if (bArr[bytesRead4] != 0) {
                                    break;
                                }
                                metadataLength--;
                            }
                            if (metadataLength > 0) {
                                this.A03.AE5(new C02284v(bArr, metadataLength));
                            }
                            return true;
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                        public final void A43(InterfaceC02525t interfaceC02525t) {
                            AbstractC02053y.A01(interfaceC02525t);
                            this.A02.A43(interfaceC02525t);
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                        public final Map<String, List<String>> A8t() {
                            return this.A02.A8t();
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                        public final Uri A9P() {
                            return this.A02.A9P();
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                        public final long AGi(C02415i c02415i) {
                            throw new UnsupportedOperationException();
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
                        public final void close() {
                            throw new UnsupportedOperationException();
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC01612c
                        public final int read(byte[] bArr, int i2, int i3) throws IOException {
                            if (this.A00 == 0) {
                                if (!A00()) {
                                    return -1;
                                }
                                this.A00 = this.A01;
                            }
                            int i4 = this.A02.read(bArr, i2, Math.min(this.A00, i3));
                            if (i4 != -1) {
                                int bytesRead = this.A00;
                                this.A00 = bytesRead - i4;
                            }
                            return i4;
                        }
                    };
                    this.A02 = this.A0D.A0Z();
                    this.A02.A6e(C03449p.A0g);
                }
                this.A09.AAB(interfaceC1917pF, this.A06, this.A08.A8t(), j, jAGi, this.A0A);
                if (this.A0D.A09 != null) {
                    this.A09.A5y();
                }
                if (this.A03) {
                    this.A09.AJ6(j, this.A00);
                    this.A03 = false;
                }
                while (iAHM == 0 && !this.A0C) {
                    try {
                        this.A07.A00();
                        iAHM = this.A09.AHM(this.A0B);
                        long position = this.A09.A7a();
                        if (position > this.A0D.A0M + j) {
                            j = position;
                            this.A07.A02();
                            this.A0D.A0O.post(this.A0D.A0a);
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                if (iAHM == 1) {
                    iAHM = 0;
                } else {
                    long jA7a = this.A09.A7a();
                    String[] strArr = A0E;
                    if (strArr[2].charAt(24) != strArr[3].charAt(24)) {
                        throw new RuntimeException();
                    }
                    A0E[6] = "OKjnlHtv3KbBLefZQYMpPe9SdH47QI1";
                    if (jA7a != -1) {
                        this.A0B.A00 = this.A09.A7a();
                    }
                }
                AbstractC02365d.A00(this.A08);
            } catch (Throwable th) {
                if (iAHM != 1 && this.A09.A7a() != -1) {
                    this.A0B.A00 = this.A09.A7a();
                }
                AbstractC02365d.A00(this.A08);
                throw th;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0412Cp
    public final void AE5(C02284v c02284v) {
        long jMax;
        if (this.A04) {
            jMax = Math.max(this.A0D.A03(true), this.A00);
        } else {
            jMax = this.A00;
        }
        int iA07 = c02284v.A07();
        InterfaceC0528Hd interfaceC0528Hd = (InterfaceC0528Hd) AbstractC02053y.A01(this.A02);
        interfaceC0528Hd.AIr(c02284v, iA07);
        interfaceC0528Hd.AIu(jMax, 1, iA07, 0, null);
        this.A04 = true;
    }
}
