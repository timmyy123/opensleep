package com.facebook.ads.redexgen.core;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class AN extends BS<String, List<String>> {
    public final Map<String, List<String>> A00;

    public AN(Map<String, List<String>> headers) {
        this.A00 = headers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.BS, java.util.Map
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final List<String> get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) super.get(obj);
    }

    public static /* synthetic */ boolean A01(String str) {
        return str != null;
    }

    public static /* synthetic */ boolean A02(Map.Entry entry) {
        return entry.getKey() != null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1853oD
    /* JADX INFO: renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final Map<String, List<String>> A03() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.BS, java.util.Map
    public final boolean containsKey(Object obj) {
        return obj != null && super.containsKey(obj);
    }

    @Override // com.facebook.ads.redexgen.core.BS, java.util.Map
    public final boolean containsValue(Object obj) {
        return A06(obj);
    }

    @Override // com.facebook.ads.redexgen.core.BS, java.util.Map
    public final Set<Map.Entry<String, List<String>>> entrySet() {
        return AbstractC2004qj.A07(super.entrySet(), new InterfaceC1652kj() { // from class: com.facebook.ads.redexgen.X.pC
            @Override // com.facebook.ads.redexgen.core.InterfaceC1652kj
            public final boolean A4C(Object obj) {
                return AN.A02((Map.Entry) obj);
            }
        });
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj != null && A07(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return A04();
    }

    @Override // com.facebook.ads.redexgen.core.BS, java.util.Map
    public final boolean isEmpty() {
        if (super.isEmpty()) {
            return true;
        }
        return super.size() == 1 && super.containsKey(null);
    }

    @Override // com.facebook.ads.redexgen.core.BS, java.util.Map
    public final Set<String> keySet() {
        return AbstractC2004qj.A07(super.keySet(), new InterfaceC1652kj() { // from class: com.facebook.ads.redexgen.X.pD
            @Override // com.facebook.ads.redexgen.core.InterfaceC1652kj
            public final boolean A4C(Object obj) {
                return AN.A01((String) obj);
            }
        });
    }

    @Override // com.facebook.ads.redexgen.core.BS, java.util.Map
    public final int size() {
        return super.size() - (super.containsKey(null) ? 1 : 0);
    }
}
