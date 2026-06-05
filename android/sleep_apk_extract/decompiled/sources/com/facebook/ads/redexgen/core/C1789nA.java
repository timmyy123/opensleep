package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1789nA implements F6, InterfaceC02525t {
    public int A00;
    public int A01;

    @MetaExoPlayerCustomization("Needed for Meta Custom getAvailableSamples")
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public long A08;
    public long A09;
    public boolean A0A;
    public final AnonymousClass45 A0B;
    public final F4 A0C;
    public final FW A0D;

    @MetaExoPlayerCustomization("Upstream uses Map. Oculus doesn't play well with these collections")
    public final Map<Integer, Long> A0E;
    public final boolean A0F;
    public static final List<Long> A0L = MetaExoPlayerCustomizedCollections.A03(4400000L, 3200000L, 2300000L, 1600000L, 810000L);
    public static final List<Long> A0G = MetaExoPlayerCustomizedCollections.A03(1400000L, 990000L, 730000L, 510000L, 230000L);
    public static final List<Long> A0H = MetaExoPlayerCustomizedCollections.A03(2100000L, 1400000L, 1000000L, 890000L, 640000L);
    public static final List<Long> A0I = MetaExoPlayerCustomizedCollections.A03(2600000L, 1700000L, 1300000L, 1000000L, 700000L);
    public static final List<Long> A0J = MetaExoPlayerCustomizedCollections.A03(5700000L, 3700000L, 2300000L, 1700000L, 990000L);
    public static final List<Long> A0K = MetaExoPlayerCustomizedCollections.A03(2800000L, 1800000L, 1400000L, 1100000L, 870000L);

    @Deprecated
    public C1789nA() {
        this(null, Collections.emptyMap(), 2000, AnonymousClass45.A00, false);
    }

    public C1789nA(Context context, Map<Integer, Long> initialBitrateEstimates, int i, AnonymousClass45 anonymousClass45, boolean z) {
        this.A0E = MetaExoPlayerCustomizedCollections.A04(initialBitrateEstimates);
        this.A0C = new F4();
        this.A0D = new FW(i);
        this.A0B = anonymousClass45;
        this.A0F = z;
        if (context != null) {
            C02224p c02224pA03 = C02224p.A03(context);
            this.A00 = c02224pA03.A09();
            this.A04 = A00(this.A00);
            c02224pA03.A0A(new InterfaceC02204n() { // from class: com.facebook.ads.redexgen.X.nB
                @Override // com.facebook.ads.redexgen.core.InterfaceC02204n
                public final void AF1(int i2) {
                    this.A00.A01(i2);
                }
            });
            return;
        }
        this.A00 = 0;
        this.A04 = A00(0);
    }

    private long A00(int i) {
        Long initialBitrateEstimate = this.A0E.get(Integer.valueOf(i));
        if (initialBitrateEstimate == null) {
            initialBitrateEstimate = this.A0E.get(0);
        }
        if (initialBitrateEstimate == null) {
            initialBitrateEstimate = 1000000L;
        }
        return initialBitrateEstimate.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A01(int i) {
        int sampleElapsedTimeMs;
        if (this.A00 == 0 || this.A0F) {
            if (this.A0A) {
                i = this.A01;
            }
            if (this.A00 == i) {
                return;
            }
            this.A00 = i;
            if (i == 1 || i == 0 || i == 8) {
                return;
            }
            this.A04 = A00(i);
            long jA6J = this.A0B.A6J();
            if (this.A03 > 0) {
                long nowMs = jA6J - this.A07;
                sampleElapsedTimeMs = (int) nowMs;
            } else {
                sampleElapsedTimeMs = 0;
            }
            A02(sampleElapsedTimeMs, this.A06, this.A04);
            this.A07 = jA6J;
            this.A06 = 0L;
            this.A08 = 0L;
            this.A09 = 0L;
            this.A0D.A06();
        }
    }

    private void A02(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.A05) {
            return;
        }
        this.A05 = j2;
        this.A0C.A00(i, j, j2);
    }

    public static boolean A04(C02415i c02415i, boolean z) {
        return z && !c02415i.A06(8);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC02525t
    public final synchronized void ADK(InterfaceC1917pF interfaceC1917pF, C02415i c02415i, boolean z, int i) {
        if (A04(c02415i, z)) {
            this.A06 += (long) i;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC02525t
    public final synchronized void AGG(InterfaceC1917pF interfaceC1917pF, C02415i c02415i, boolean z) {
        if (A04(c02415i, z)) {
            AbstractC02053y.A08(this.A03 > 0);
            long nowMs = this.A0B.A6J();
            int i = (int) (nowMs - this.A07);
            this.A09 += (long) i;
            this.A08 += this.A06;
            if (i > 0) {
                FW fw = this.A0D;
                int sampleElapsedTimeMs = (int) Math.sqrt(this.A06);
                fw.A07(sampleElapsedTimeMs, (this.A06 * 8000.0f) / i);
                if (this.A09 >= 2000 || this.A08 >= 524288) {
                    this.A04 = (long) this.A0D.A05(0.5f);
                }
                int sampleElapsedTimeMs2 = this.A02;
                this.A02 = sampleElapsedTimeMs2 + 1;
                A02(i, this.A06, this.A04);
                this.A07 = nowMs;
                this.A06 = 0L;
            }
            int sampleElapsedTimeMs3 = this.A03;
            this.A03 = sampleElapsedTimeMs3 - 1;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC02525t
    public final synchronized void AGH(@MetaExoPlayerCustomization InterfaceC1917pF interfaceC1917pF, C02415i c02415i, boolean z, boolean z2) {
        if (A04(c02415i, z)) {
            if (this.A03 == 0) {
                this.A07 = this.A0B.A6J();
            }
            this.A03++;
        }
    }
}
