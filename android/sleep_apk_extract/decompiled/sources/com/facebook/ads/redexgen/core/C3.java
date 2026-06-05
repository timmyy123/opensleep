package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C3 implements InterfaceC1657ko {
    public final /* synthetic */ CC A00;

    public C3(final CC val$separatorMatcher) {
        this.A00 = val$separatorMatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.2R] */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1657ko
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C2R AAl(final C1658kp splitter, final CharSequence toSplit) {
        return new AbstractC0395Bw(splitter, toSplit) { // from class: com.facebook.ads.redexgen.X.2R
            @Override // com.facebook.ads.redexgen.core.AbstractC0395Bw
            public final int A04(int separatorPosition) {
                return separatorPosition + 1;
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC0395Bw
            public final int A05(int start) {
                return this.A00.A00.A08(this.A03, start);
            }
        };
    }
}
