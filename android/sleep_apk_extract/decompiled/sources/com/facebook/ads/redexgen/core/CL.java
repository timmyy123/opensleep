package com.facebook.ads.redexgen.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class CL implements InterfaceC1415gc {
    public final C0399Cb A00;
    public final EnumC1420gh A01;

    public CL(C0399Cb c0399Cb, EnumC1420gh enumC1420gh) {
        this.A00 = c0399Cb;
        this.A01 = enumC1420gh;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1415gc
    public void A4D(Map<InterfaceC1397gK, EnumC1420gh> map, Map<SyncModifiableBundle, EnumC1407gU> map2) {
        map.put(this.A00, this.A01);
    }
}
