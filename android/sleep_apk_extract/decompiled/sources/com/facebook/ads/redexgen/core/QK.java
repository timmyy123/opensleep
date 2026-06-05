package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QK implements InterfaceC0946Xr {
    public final Collection<String> A00;

    public QK() {
        this.A00 = new ArrayList();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0946Xr
    public final void AH8(String str) {
        this.A00.add(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0946Xr
    public final void flush() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.A00.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append('\n');
        }
        return sb.toString();
    }
}
