package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1510iC implements InterfaceC0716Ol {
    public final SharedPreferences.Editor A00;

    public C1510iC(SharedPreferences.Editor editor) {
        this.A00 = editor;
    }

    public final C1510iC A00(String str, long j) {
        this.A00.putLong(str, j);
        return this;
    }

    public final C1510iC A01(String str, String str2) {
        this.A00.putString(str, str2);
        return this;
    }

    public final void A02() {
        this.A00.apply();
    }
}
