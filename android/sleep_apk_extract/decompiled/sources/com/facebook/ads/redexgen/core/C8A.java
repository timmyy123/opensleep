package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8A {
    public static String[] A06 = {"jkVScMAnmSDw5NjtFKaMDw93YHVTZfVV", "X8vR6FaiUrrVUV4OyPqbjTz4nTbdT", "DJqg7VUdCo9q2ysxPrWS1RTdTLsj", "4FrbkvGGO58oIWN02YSUZA4iQkwc41Il", "lEgbsVLzgPUjgc1", "ISDPu1y88m9uUW9z", "L6djBwtYOA2bka2PQ69EdZLSIG4ne", "x8MPEelqUvAzBLNZGFUUNdgpeh0HUacA"};
    public C1829no A00;
    public C1829no A01;
    public C1829no A02;
    public BP<C1829no> A03 = BP.A03();
    public AbstractC1873oX<C1829no, Timeline> A04 = AbstractC1873oX.A04();
    public final C1948pl A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1829no A00(InterfaceC01843b interfaceC01843b, BP<C1829no> bp, C1829no c1829no, C1948pl c1948pl) {
        int iA07;
        Timeline timelineA7g = interfaceC01843b.A7g();
        int iA7c = interfaceC01843b.A7c();
        Object objA0M = timelineA7g.A0N() ? null : timelineA7g.A0M(iA7c);
        if (!interfaceC01843b.AAd()) {
            boolean zA0N = timelineA7g.A0N();
            String[] strArr = A06;
            if (strArr[7].charAt(14) != strArr[3].charAt(14)) {
                throw new RuntimeException();
            }
            A06[6] = "fPIpfte6042F2VeKOBsTFTkNJVxhR";
            iA07 = zA0N ? -1 : timelineA7g.A0H(iA7c, c1948pl).A07(C5C.A0O(interfaceC01843b.A7e()) - c1948pl.A0C());
        }
        for (int i = 0; i < bp.size(); i++) {
            C1829no c1829no2 = bp.get(i);
            if (A04(c1829no2, objA0M, interfaceC01843b.AAd(), interfaceC01843b.A7Y(), interfaceC01843b.A7Z(), iA07)) {
                return c1829no2;
            }
        }
        if (bp.isEmpty() && c1829no != null) {
            if (A04(c1829no, objA0M, interfaceC01843b.AAd(), interfaceC01843b.A7Y(), interfaceC01843b.A7Z(), iA07)) {
                return c1829no;
            }
        }
        return null;
    }

    public C8A(C1948pl c1948pl) {
        this.A05 = c1948pl;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<com.facebook.ads.androidx.media3.exoplayer.source.MediaSource$MediaPeriodId, com.facebook.ads.androidx.media3.common.Timeline> */
    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "builder of ImmutableMap should be a buildOrThrow")
    private void A02(Timeline timeline) {
        C1871oV<C1829no, Timeline> c1871oVA03 = AbstractC1873oX.A03();
        if (this.A03.isEmpty()) {
            A03(c1871oVA03, this.A01, timeline);
            C1829no c1829no = this.A02;
            C1829no c1829no2 = this.A01;
            if (A06[4].length() == 25) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[2] = "UxUdIKnoAyUMpq9t4QIr4fpxRPT3";
            strArr[1] = "6BCX8szW2uTmGViuSf00Yq1AObOIr";
            if (!CB.A01(c1829no, c1829no2)) {
                A03(c1871oVA03, this.A02, timeline);
            }
            if (!CB.A01(this.A00, this.A01) && !CB.A01(this.A00, this.A02)) {
                A03(c1871oVA03, this.A00, timeline);
            }
        } else {
            for (int i = 0; i < this.A03.size(); i++) {
                A03(c1871oVA03, this.A03.get(i), timeline);
            }
            if (!this.A03.contains(this.A00)) {
                A03(c1871oVA03, this.A00, timeline);
            }
        }
        this.A04 = c1871oVA03.A07();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<com.facebook.ads.androidx.media3.exoplayer.source.MediaSource$MediaPeriodId, com.facebook.ads.androidx.media3.common.Timeline> */
    private void A03(C1871oV<C1829no, Timeline> c1871oV, C1829no c1829no, Timeline timeline) {
        if (c1829no == null) {
            return;
        }
        if (timeline.A0A(c1829no.A04) != -1) {
            c1871oV.A05(c1829no, timeline);
            return;
        }
        Timeline existingTimeline = this.A04.get(c1829no);
        if (existingTimeline == null) {
            return;
        }
        c1871oV.A05(c1829no, existingTimeline);
    }

    public static boolean A04(C1829no c1829no, Object obj, boolean z, int i, int i2, int i3) {
        if (c1829no.A04.equals(obj)) {
            return (z && c1829no.A00 == i && c1829no.A01 == i2) || (!z && c1829no.A00 == -1 && c1829no.A02 == i3);
        }
        return false;
    }

    public final Timeline A05(C1829no c1829no) {
        return this.A04.get(c1829no);
    }

    public final C1829no A06() {
        return this.A00;
    }

    public final void A07(InterfaceC01843b interfaceC01843b) {
        this.A00 = A00(interfaceC01843b, this.A03, this.A01, this.A05);
        A02(interfaceC01843b.A7g());
    }
}
