package com.facebook.ads.redexgen.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ok, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0715Ok implements Serializable {
    public static final long serialVersionUID = -3209129042070173126L;
    public C0715Ok A00;
    public final int A01;
    public final String A02;
    public final String A03;
    public final List<C0715Ok> A04;

    public C0715Ok(int i, String str, String str2) {
        this.A04 = new ArrayList();
        this.A01 = i;
        this.A03 = str;
        this.A02 = str2;
    }

    public C0715Ok(String str) {
        this(0, null, str);
    }

    private void A00(C0715Ok c0715Ok) {
        this.A00 = c0715Ok;
    }

    public final int A01() {
        return this.A01;
    }

    public final C0715Ok A02() {
        return this.A00;
    }

    public final String A03() {
        return this.A02;
    }

    public final String A04() {
        return this.A03;
    }

    public final List<C0715Ok> A05() {
        return this.A04;
    }

    public final void A06(C0715Ok c0715Ok) {
        c0715Ok.A00(this);
        this.A04.add(c0715Ok);
    }
}
