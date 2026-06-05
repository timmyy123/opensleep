package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0491Fs extends AbstractC1365fo {
    public final /* synthetic */ VA A00;
    public final /* synthetic */ Y2 A01;
    public final /* synthetic */ C1259e5 A02;
    public final /* synthetic */ C0489Fq A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ Map A05;

    public C0491Fs(C0489Fq c0489Fq, String str, C1259e5 c1259e5, VA va, Map map, Y2 y2) {
        this.A03 = c0489Fq;
        this.A04 = str;
        this.A02 = c1259e5;
        this.A00 = va;
        this.A05 = map;
        this.A01 = y2;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1365fo
    public final void A03() {
        if (!this.A03.A02.A0Z() && !TextUtils.isEmpty(this.A04) && !this.A03.A05.get(this.A02.A02())) {
            this.A00.ABJ(this.A04, new C1078b9(this.A05).A03(this.A03.A03).A02(this.A01).A05());
            C0685Ng.A07(this.A03.A00, this.A03.A06);
            this.A03.A05.put(this.A02.A02(), true);
        }
    }
}
