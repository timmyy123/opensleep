package com.facebook.ads.redexgen.core;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class C8M implements InterfaceC1720lq {
    public static String[] A06 = {"A1ZwXb6JdBVxSPYV1ZzpyUVQy2gRfJA9", "vkvPFBYHwcZnb4NzphHjmgFJFbjiYwSo", "W7sj7Up3ABI8RZFTAAZOEHe7srfTkl57", "fls3PiASqtk6GqNgTZFqwBZFoYeyHn2V", "1yDmXHBn42mad7W8CPx8A7RWKYn1BqT7", "CjPJSc8sfbO2R56Y3Yx9Z137FYjSqvlb", "2KSypf5DjPiLYF3nQ7brfSsHONTUzR5A", "k5ePLg8NJJ"};
    public long A00;
    public long A01;
    public C1V A02;
    public final ArrayDeque<C1V> A03 = new ArrayDeque<>();
    public final ArrayDeque<C8P> A04;
    public final PriorityQueue<C1V> A05;

    public abstract C1711lh A0Z();

    public abstract void A0b(C8S c8s);

    public abstract boolean A0d();

    public C8M() {
        for (int i = 0; i < 10; i++) {
            this.A03.add(new C1V());
        }
        this.A04 = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            ArrayDeque<C8P> arrayDeque = this.A04;
            final AnonymousClass64 anonymousClass64 = new AnonymousClass64() { // from class: com.facebook.ads.redexgen.X.li
                @Override // com.facebook.ads.redexgen.core.AnonymousClass64
                public final void AHj(AbstractC1901oz abstractC1901oz) {
                    this.A00.A0c((C1U) abstractC1901oz);
                }
            };
            arrayDeque.add(new C8P(anonymousClass64) { // from class: com.facebook.ads.redexgen.X.1U
                public AnonymousClass64<C1U> A00;

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.64 != com.facebook.ads.androidx.media3.decoder.DecoderOutputBuffer$Owner<com.facebook.ads.androidx.media3.extractor.text.cea.CeaDecoder$CeaOutputBuffer> */
                {
                    this.A00 = anonymousClass64;
                }

                @Override // com.facebook.ads.redexgen.core.C8P, com.facebook.ads.redexgen.core.AbstractC1901oz
                public final void A0B() {
                    this.A00.AHj(this);
                }
            });
        }
        this.A05 = new PriorityQueue<>();
    }

    private void A0U(C1V c1v) {
        c1v.A0A();
        this.A03.add(c1v);
    }

    public final long A0V() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass60
    /* JADX INFO: renamed from: A0W, reason: merged with bridge method [inline-methods] */
    public C8S A5r() throws C1713lj {
        AbstractC02053y.A08(this.A02 == null);
        if (this.A03.isEmpty()) {
            return null;
        }
        this.A02 = this.A03.pollFirst();
        return this.A02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f7, code lost:
    
        return null;
     */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass60
    /* JADX INFO: renamed from: A0X */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C8P A5t() throws C1713lj {
        if (!this.A04.isEmpty()) {
            while (true) {
                boolean zIsEmpty = this.A05.isEmpty();
                if (A06[5].charAt(7) == 's') {
                    A06[6] = "DOprmnWJZ9SCRw8WSrP7EOY5DTOSvJmV";
                    if (!zIsEmpty) {
                        C1V c1vPeek = this.A05.peek();
                        if (A06[7].length() == 10) {
                            A06[2] = "urX0HrInINzEpwrp6LaPdmgGjQDQJQna";
                            if (((C1V) C5C.A0f(c1vPeek)).A01 > this.A00) {
                                break;
                            }
                            C1V c1v = (C1V) C5C.A0f(this.A05.poll());
                            if (c1v.A05()) {
                                C8P c8p = (C8P) C5C.A0f(this.A04.pollFirst());
                                c8p.A00(4);
                                A0U(c1v);
                                String[] strArr = A06;
                                if (strArr[4].charAt(25) != strArr[3].charAt(25)) {
                                    return c8p;
                                }
                                String[] strArr2 = A06;
                                strArr2[4] = "oxl05cpa7UEpdlHPP7s3uyaLsYMYJfaH";
                                strArr2[3] = "7KvbtL7fQFgbKwZtHueu0Zl9fYEN12Vy";
                                return c8p;
                            }
                            A0b(c1v);
                            if (A0d()) {
                                C1711lh c1711lhA0Z = A0Z();
                                C8P c8p2 = (C8P) C5C.A0f(this.A04.pollFirst());
                                long j = c1v.A01;
                                String[] strArr3 = A06;
                                if (strArr3[4].charAt(25) != strArr3[3].charAt(25)) {
                                    throw new RuntimeException();
                                }
                                A06[5] = "oIgvRTusAdocLQHm4RFtRlwv19XF7U3W";
                                c8p2.A0C(j, c1711lhA0Z, Long.MAX_VALUE);
                                A0U(c1v);
                                return c8p2;
                            }
                            A0U(c1v);
                        } else {
                            throw new RuntimeException();
                        }
                    } else {
                        break;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        } else {
            return null;
        }
    }

    public final C8P A0Y() {
        return this.A04.pollFirst();
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass60
    /* JADX INFO: renamed from: A0a, reason: merged with bridge method [inline-methods] */
    public void AHJ(C8S c8s) throws C1713lj {
        AbstractC02053y.A07(c8s == this.A02);
        C1V c1v = (C1V) c8s;
        if (c1v.A04()) {
            A0U(c1v);
        } else {
            long j = this.A01;
            this.A01 = 1 + j;
            c1v.A00 = j;
            this.A05.add(c1v);
        }
        if (A06[7].length() != 10) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[0] = "rj1eyhsOe6SuoM1rYy40tvsoNCkJE80J";
        strArr[1] = "ibYLffFAaVDMN4cD1vowu1tbJEM8Lkom";
        this.A02 = null;
    }

    public final void A0c(C8P c8p) {
        c8p.A0A();
        this.A04.add(c8p);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass60
    public void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1720lq
    public void AJh(long j) {
        this.A00 = j;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass60
    public void flush() {
        this.A01 = 0L;
        this.A00 = 0L;
        while (!this.A05.isEmpty()) {
            A0U((C1V) C5C.A0f(this.A05.poll()));
        }
        if (this.A02 != null) {
            A0U(this.A02);
            this.A02 = null;
        }
    }
}
