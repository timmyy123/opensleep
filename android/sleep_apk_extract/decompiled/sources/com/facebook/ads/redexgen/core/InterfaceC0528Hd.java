package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC0528Hd {
    void A6e(C1981qI c1981qI);

    int AIp(InterfaceC01612c interfaceC01612c, int i, boolean z) throws IOException;

    int AIq(InterfaceC01612c interfaceC01612c, int i, boolean z, int i2) throws IOException;

    void AIr(C02284v c02284v, int i);

    void AIs(C02284v c02284v, int i, int i2);

    void AIu(long j, int i, int i2, int i3, C0526Hb c0526Hb);

    @MetaExoPlayerCustomization("New Meta API")
    void AKf(Uri uri);
}
