package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3K, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C3K extends IOException {
    public int A00;
    public boolean A01;

    @Deprecated
    public C3K() {
    }

    @Deprecated
    public C3K(String str) {
        super(str);
    }

    public C3K(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.A01 = z;
        this.A00 = i;
    }

    public static C3K A00(String str) {
        return new C3K(str, null, false, 1);
    }

    public static C3K A01(String str, Throwable th) {
        return new C3K(str, th, true, 1);
    }

    public static C3K A02(String str, Throwable th) {
        return new C3K(str, th, true, 0);
    }
}
