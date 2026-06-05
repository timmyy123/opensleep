package com.facebook.ads.redexgen.core;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1367fq {
    public float A00;
    public EnumC0645Lr A01;
    public Map<String, String> A02;

    public C1367fq(EnumC0645Lr enumC0645Lr) {
        this(enumC0645Lr, 0.0f);
    }

    public C1367fq(EnumC0645Lr enumC0645Lr, float f) {
        this(enumC0645Lr, f, null);
    }

    public C1367fq(@Nullable EnumC0645Lr enumC0645Lr, float f, Map<String, String> windowParams) {
        this.A01 = enumC0645Lr;
        this.A00 = f;
        if (windowParams != null) {
            this.A02 = windowParams;
        } else {
            this.A02 = new HashMap();
        }
    }

    public final float A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01.A03();
    }

    public final EnumC0645Lr A02() {
        return this.A01;
    }

    public final Map<String, String> A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A01 == EnumC0645Lr.A0I;
    }
}
