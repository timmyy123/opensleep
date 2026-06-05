package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1320f5 implements TP {
    public static byte[] A04;
    public Context A00;
    public final TO A02;
    public final AtomicBoolean A03 = new AtomicBoolean(false);
    public TM A01 = A00();

    static {
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{113, 101, 122, 106, 102, 112, 97, 97, 124, 123, 114, 102, 106, 126, 112, 108};
    }

    public C1320f5(Context context, TO to) {
        this.A00 = context;
        this.A02 = to;
    }

    private TM A00() {
        return TM.A00(WN.A00(this.A00).getString(A01(0, 16, 100), null));
    }

    private void A02() {
        this.A02.ACV(new C1325fA(this));
    }

    public final void A04(String[] strArr, Integer num, Integer num2) {
        TM tm = new TM(strArr, num, num2);
        TM newSettings = this.A01;
        if (tm.equals(newSettings)) {
            return;
        }
        this.A01 = tm;
        this.A03.set(true);
        SharedPreferences.Editor editorEdit = WN.A00(this.A00).edit();
        TM newSettings2 = this.A01;
        editorEdit.putString(A01(0, 16, 100), newSettings2.A07()).apply();
    }

    @Override // com.facebook.ads.redexgen.core.TP
    public final TM A7k() {
        A02();
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.TP
    public final boolean AAh() {
        A02();
        if (this.A01 == null) {
            return false;
        }
        Set<String> setA0a = C0871Up.A0a(this.A00);
        String identifier = this.A01.A07();
        Iterator<String> it = setA0a.iterator();
        while (it.hasNext()) {
            if (identifier.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.TP
    public final boolean AJw() {
        A02();
        return this.A03.getAndSet(false);
    }
}
