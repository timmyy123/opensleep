package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0893Vm {
    public final AdErrorType A00;
    public final String A01;

    public C0893Vm(int i, String str) {
        this(AdErrorType.adErrorTypeFromCode(i), str);
    }

    public C0893Vm(AdErrorType adErrorType, String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public static C0893Vm A00(AdErrorType adErrorType) {
        return new C0893Vm(adErrorType, (String) null);
    }

    public static C0893Vm A01(AdErrorType adErrorType, String str) {
        return new C0893Vm(adErrorType, str);
    }

    public static C0893Vm A02(C0894Vn c0894Vn) {
        return new C0893Vm(c0894Vn.A00(), c0894Vn.A01());
    }

    public final AdErrorType A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }
}
