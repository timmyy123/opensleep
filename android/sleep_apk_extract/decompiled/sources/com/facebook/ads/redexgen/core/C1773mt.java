package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1773mt implements InterfaceC0528Hd {
    public final byte[] A00 = new byte[4096];

    @Override // com.facebook.ads.redexgen.core.InterfaceC0528Hd
    public final /* synthetic */ int AIp(InterfaceC01612c interfaceC01612c, int i, boolean z) {
        return AbstractC0525Ha.A00(this, interfaceC01612c, i, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0528Hd
    public final /* synthetic */ void AIr(C02284v c02284v, int i) {
        AbstractC0525Ha.A01(this, c02284v, i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0528Hd
    public final void A6e(C1981qI c1981qI) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0528Hd
    public final int AIq(InterfaceC01612c interfaceC01612c, int i, boolean z, int i2) throws IOException {
        int bytesSkipped = interfaceC01612c.read(this.A00, 0, Math.min(this.A00.length, i));
        if (bytesSkipped == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        return bytesSkipped;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0528Hd
    public final void AIs(C02284v c02284v, int i, int i2) {
        c02284v.A0g(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0528Hd
    public final void AIu(long j, int i, int i2, int i3, C0526Hb c0526Hb) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0528Hd
    @MetaExoPlayerCustomization("New API added for Meta")
    public final void AKf(Uri uri) {
    }
}
