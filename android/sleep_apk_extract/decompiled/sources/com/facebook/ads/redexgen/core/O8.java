package com.facebook.ads.redexgen.core;

import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class O8 {
    public final long A00;
    public final C0853Tx A01;
    public final String A02;
    public final JSONObject A03;

    public O8(JSONObject jSONObject, C0853Tx c0853Tx, String str, long j) {
        this.A03 = jSONObject;
        this.A01 = c0853Tx;
        this.A02 = str;
        this.A00 = j;
    }

    public final long A00() {
        return this.A00;
    }

    public final C0853Tx A01() {
        return this.A01;
    }

    public final String A02() {
        return this.A02;
    }

    public final JSONObject A03() {
        return this.A03;
    }
}
