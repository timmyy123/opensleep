package com.facebook.ads.redexgen.core;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Te, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0834Te extends Exception {
    public int A00;
    public int A01;
    public int A02;
    public JSONObject A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;

    public C0834Te(String str) {
        super(str);
        this.A01 = 0;
        this.A06 = true;
        this.A05 = true;
        this.A04 = false;
        this.A00 = 0;
        this.A02 = -1;
    }

    public C0834Te(String str, String str2) {
        super(str + '\n' + str2);
        this.A01 = 0;
        this.A06 = true;
        this.A05 = true;
        this.A04 = false;
        this.A00 = 0;
        this.A02 = -1;
    }

    public C0834Te(Throwable th) {
        super(th);
        this.A01 = 0;
        this.A06 = true;
        this.A05 = true;
        this.A04 = false;
        this.A00 = 0;
        this.A02 = -1;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final int A02() {
        return this.A02;
    }

    public final JSONObject A03() {
        return this.A03;
    }

    public final void A04(int i) {
        this.A00 = i;
    }

    public final void A05(int i) {
        this.A01 = i;
    }

    public final void A06(int i) {
        this.A02 = i;
    }

    public final void A07(JSONObject jSONObject) {
        this.A03 = jSONObject;
    }

    public final void A08(boolean z) {
        this.A05 = z;
    }

    public final void A09(boolean z) {
        this.A04 = z;
    }

    public final void A0A(boolean z) {
        this.A06 = z;
    }

    public final boolean A0B() {
        return this.A05;
    }

    public final boolean A0C() {
        return this.A04;
    }

    public final boolean A0D() {
        return this.A06;
    }
}
