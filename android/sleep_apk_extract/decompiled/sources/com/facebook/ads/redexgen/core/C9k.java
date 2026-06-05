package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9k, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C9k implements InterfaceC1720lq {
    public static String[] A05 = {"09FvAMDbH0ybjBvy7etGUlmvLnEax64M", "9UhXzLA65KAjnLS2nIkoWygikqgIUMi6", "7x5jjcV5dGluzAi4xLXm7mPjpISGuC5w", "OMb242EU3cjCZF5lkBhqnraDuTpVEe8I", "YkwDHYmprJhwUHAQbO7ClYxi5co4mZVB", "F0wri1MO2ggHk2Yd2fKtZmsEqFQ1SY6P", "VahsyjeijnOod8dsGLMZVGg77qfAqG3R", "hv5jyUmHRXfPhpozztfXRSgwdurH1xzL"};
    public int A00;
    public boolean A01;
    public final C0583Jh A02 = new C0583Jh();
    public final C8S A03 = new C8S();
    public final Deque<C8P> A04 = new ArrayDeque();

    public C9k() {
        for (int i = 0; i < 2; i++) {
            this.A04.addFirst(new C8P() { // from class: com.facebook.ads.redexgen.X.1c
                @Override // com.facebook.ads.redexgen.core.C8P, com.facebook.ads.redexgen.core.AbstractC1901oz
                public final void A0B() {
                    this.A00.A04(this);
                }
            });
        }
        this.A00 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass60
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C8S A5r() throws C1713lj {
        AbstractC02053y.A08(!this.A01);
        if (this.A00 != 0) {
            return null;
        }
        this.A00 = 1;
        return this.A03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass60
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C8P A5t() throws C1713lj {
        AbstractC02053y.A08(!this.A01);
        if (this.A00 != 2 || this.A04.isEmpty()) {
            return null;
        }
        C8P c8pRemoveFirst = this.A04.removeFirst();
        if (this.A03.A05()) {
            String[] strArr = A05;
            if (strArr[5].charAt(13) == strArr[0].charAt(13)) {
                throw new RuntimeException();
            }
            A05[4] = "JYyYZLdoMjCFjS6FBvPaG66m4kKjUjXi";
            c8pRemoveFirst.A00(4);
        } else {
            c8pRemoveFirst.A0C(this.A03.A01, new C1808nT(this.A03.A01, this.A02.A02(((ByteBuffer) AbstractC02053y.A01(this.A03.A02)).array())), 0L);
        }
        this.A03.A0A();
        this.A00 = 0;
        return c8pRemoveFirst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass60
    /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final void AHJ(C8S c8s) throws C1713lj {
        AbstractC02053y.A08(!this.A01);
        AbstractC02053y.A08(this.A00 == 1);
        AbstractC02053y.A07(this.A03 == c8s);
        this.A00 = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(C8P c8p) {
        AbstractC02053y.A08(this.A04.size() < 2);
        AbstractC02053y.A07(!this.A04.contains(c8p));
        c8p.A0A();
        this.A04.addFirst(c8p);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass60
    public final void AHb() {
        this.A01 = true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1720lq
    public final void AJh(long j) {
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass60
    public final void flush() {
        AbstractC02053y.A08(!this.A01);
        this.A03.A0A();
        this.A00 = 0;
    }
}
