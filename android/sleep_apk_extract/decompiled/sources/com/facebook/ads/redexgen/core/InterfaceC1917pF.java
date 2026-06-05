package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC1917pF extends InterfaceC01612c {
    void A43(InterfaceC02525t interfaceC02525t);

    Map<String, List<String>> A8t();

    Uri A9P();

    long AGi(C02415i c02415i) throws IOException;

    void close() throws IOException;
}
