package com.facebook.ads.redexgen.core;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8O, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8O {
    public static final C8O A03;
    public final String A00;
    public final C8N A01;
    public final Object A02;

    static {
        C8O c8o;
        if (C5C.A02 < 31) {
            c8o = new C8O("");
        } else {
            c8o = new C8O(C8N.A01, "");
        }
        A03 = c8o;
    }

    public C8O(C8N c8n, String str) {
        this.A01 = c8n;
        this.A00 = str;
        this.A02 = new Object();
    }

    public C8O(String str) {
        AbstractC02053y.A08(C5C.A02 < 31);
        this.A00 = str;
        this.A01 = null;
        this.A02 = new Object();
    }

    public final LogSessionId A00() {
        return ((C8N) AbstractC02053y.A01(this.A01)).A00;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8O)) {
            return false;
        }
        C8O c8o = (C8O) obj;
        if (Objects.equals(this.A00, c8o.A00) && Objects.equals(this.A01, c8o.A01) && Objects.equals(this.A02, c8o.A02)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.A00, this.A01, this.A02);
    }
}
