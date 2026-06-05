package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.SparseArray;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1678lA implements H9 {
    public static String[] A0B = {"UBvRkgXOGDkhiRviOullp8V", "VkNaXMTzU8N2w", "EmncOItxREzVuvRcJiesLUTUZ", "GKNHQwhZeE13dvoU8lLSXwuEJRZ0Rb8T", "UfDFEQBLtd8kFCM7fNQpR1e2paOBi7mP", "RVi2VPuM0SECIbGMRSZvlBLvqxfM7S", "lPCpjqdMUX8JsRnbL9v7kcIYKByBL6xe", "JprIbG5eTccKgwX6h6kDKt0luN"};
    public static final HD A0C = new HD() { // from class: com.facebook.ads.redexgen.X.lB
        @Override // com.facebook.ads.redexgen.core.HD
        public final H9[] A5N() {
            return C1678lA.A01();
        }

        @Override // com.facebook.ads.redexgen.core.HD
        public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
            return HC.A01(this, uri, map);
        }
    };
    public long A00;
    public HA A01;
    public C1680lC A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final SparseArray<L7> A07;
    public final C02284v A08;
    public final AnonymousClass53 A09;
    public final L6 A0A;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b1  */
    @Override // com.facebook.ads.redexgen.core.H9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int AHL(InterfaceC1772ms interfaceC1772ms, HV hv) throws IOException {
        AbstractC02053y.A02(this.A01);
        long jA8O = interfaceC1772ms.A8O();
        if ((jA8O != -1) && !this.A0A.A0E()) {
            return this.A0A.A0B(interfaceC1772ms, hv);
        }
        A00(jA8O);
        if (this.A02 != null && this.A02.A09()) {
            return this.A02.A06(interfaceC1772ms, hv);
        }
        interfaceC1772ms.AIl();
        long jA8i = jA8O != -1 ? jA8O - interfaceC1772ms.A8i() : -1L;
        if ((jA8i != -1 && jA8i < 4) || !interfaceC1772ms.AGu(this.A08.A0l(), 0, 4, true)) {
            return -1;
        }
        this.A08.A0f(0);
        int iA0C = this.A08.A0C();
        if (iA0C == 441) {
            return -1;
        }
        if (A0B[2].length() == 2) {
            throw new RuntimeException();
        }
        String[] strArr = A0B;
        strArr[5] = "kMhOTVhRWN36SIdb7fVpbVP8KQK8iP";
        strArr[1] = "K6CIMfQf5fCJv";
        if (iA0C == 442) {
            interfaceC1772ms.AGt(this.A08.A0l(), 0, 10);
            this.A08.A0f(9);
            interfaceC1772ms.AK3((this.A08.A0I() & 7) + 14);
            return 0;
        }
        if (iA0C == 443) {
            interfaceC1772ms.AGt(this.A08.A0l(), 0, 2);
            this.A08.A0f(0);
            interfaceC1772ms.AK3(this.A08.A0M() + 6);
            return 0;
        }
        if (((iA0C & Color.YELLOW) >> 8) != 1) {
            interfaceC1772ms.AK3(1);
            return 0;
        }
        int i = iA0C & PHIpAddressSearchManager.END_IP_SCAN;
        L7 l7 = this.A07.get(i);
        if (!this.A03) {
            if (l7 == null) {
                InterfaceC0623Kv c1690lM = null;
                if (i == 189) {
                    c1690lM = new C1700lW();
                    this.A04 = true;
                    this.A00 = interfaceC1772ms.A8n();
                } else {
                    int i2 = i & 224;
                    if (A0B[7].length() != 26) {
                        A0B[7] = "MD0211Yr4bYXM5L9ZkPBjN7rOQ";
                        if (i2 == 192) {
                            c1690lM = new C1684lG();
                            this.A04 = true;
                            this.A00 = interfaceC1772ms.A8n();
                        } else if ((i & 240) == 224) {
                            c1690lM = new C1690lM();
                            this.A05 = true;
                            this.A00 = interfaceC1772ms.A8n();
                        }
                    } else {
                        String[] strArr2 = A0B;
                        strArr2[6] = "PIHtVurnoe8IajroMJlyufhIBiisymoK";
                        strArr2[4] = "tbo4qyhyaN86Rqnk6vLIVirgmw8EdsC9";
                        if (i2 == 192) {
                        }
                    }
                }
                if (c1690lM != null) {
                    c1690lM.A5c(this.A01, new LG(i, 256));
                    l7 = new L7(c1690lM, this.A09);
                    this.A07.put(i, l7);
                }
            }
            if (interfaceC1772ms.A8n() > ((this.A04 && this.A05) ? this.A00 + 8192 : 1048576L)) {
                this.A03 = true;
                this.A01.A6O();
            }
        }
        interfaceC1772ms.AGt(this.A08.A0l(), 0, 2);
        this.A08.A0f(0);
        int iA0M = this.A08.A0M() + 6;
        if (l7 == null) {
            interfaceC1772ms.AK3(iA0M);
            return 0;
        }
        this.A08.A0d(iA0M);
        interfaceC1772ms.readFully(this.A08.A0l(), 0, iA0M);
        this.A08.A0f(6);
        l7.A03(this.A08);
        this.A08.A0e(this.A08.A08());
        return 0;
    }

    public C1678lA() {
        this(new AnonymousClass53(0L));
    }

    public C1678lA(AnonymousClass53 anonymousClass53) {
        this.A09 = anonymousClass53;
        this.A08 = new C02284v(4096);
        this.A07 = new SparseArray<>();
        this.A0A = new L6();
    }

    @RequiresNonNull({"output"})
    private void A00(long j) {
        if (!this.A06) {
            this.A06 = true;
            if (this.A0A.A0C() != -9223372036854775807L) {
                this.A02 = new C1680lC(this.A0A.A0D(), this.A0A.A0C(), j);
                this.A01.AJ7(this.A02.A07());
            } else {
                this.A01.AJ7(new C1767mn(this.A0A.A0C()));
            }
        }
    }

    public static /* synthetic */ H9[] A01() {
        return new H9[]{new C1678lA()};
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A01 = ha;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AJ6(long j, long j2) {
        boolean z = false;
        boolean resetTimestampAdjuster = this.A09.A04() == -9223372036854775807L;
        if (!resetTimestampAdjuster) {
            long jA02 = this.A09.A02();
            if (jA02 != -9223372036854775807L && jA02 != 0 && jA02 != j2) {
                z = true;
            }
            resetTimestampAdjuster = z;
        }
        if (resetTimestampAdjuster) {
            this.A09.A07(j2);
        }
        if (this.A02 != null) {
            this.A02.A08(j2);
        }
        for (int i = 0; i < this.A07.size(); i++) {
            this.A07.valueAt(i).A02();
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC1772ms interfaceC1772ms) throws IOException {
        byte[] bArr = new byte[14];
        interfaceC1772ms.AGt(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        byte b = bArr[13];
        if (A0B[3].charAt(12) == 'n') {
            throw new RuntimeException();
        }
        A0B[2] = "VV5ZPjEmtEUa5x1ycfEwWXr";
        int packStuffingLength = b & 7;
        interfaceC1772ms.A47(packStuffingLength);
        interfaceC1772ms.AGt(bArr, 0, 3);
        int packStuffingLength2 = bArr[0];
        int i = (packStuffingLength2 & PHIpAddressSearchManager.END_IP_SCAN) << 16;
        int packStuffingLength3 = bArr[1];
        int i2 = i | ((packStuffingLength3 & PHIpAddressSearchManager.END_IP_SCAN) << 8);
        int packStuffingLength4 = bArr[2];
        return 1 == ((packStuffingLength4 & PHIpAddressSearchManager.END_IP_SCAN) | i2);
    }
}
