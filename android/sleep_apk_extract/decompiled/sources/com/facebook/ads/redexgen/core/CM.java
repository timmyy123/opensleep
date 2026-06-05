package com.facebook.ads.redexgen.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class CM implements InterfaceC1415gc {
    public final EnumC1407gU A00;
    public final AbstractC01622d A01;

    public CM(AbstractC01622d abstractC01622d, EnumC1407gU enumC1407gU) {
        this.A01 = abstractC01622d;
        this.A00 = enumC1407gU;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1415gc
    public void A4D(Map<InterfaceC1397gK, EnumC1420gh> map, Map<SyncModifiableBundle, EnumC1407gU> map2) {
        map2.put(null, this.A00);
    }
}
