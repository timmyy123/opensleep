package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0484Fl {
    public static String[] A06 = {"dMFZX87GqTT9Fs0Ar6j3E2RThJ3xoo5C", "EZFFHtKPOVGLUG8dVwtPTz8nzxupRUs1", "DY3mC9", "dvwRzkCZI4VqlMgEqzZkoiwb96J7xIXP", "wd3MOH", "qlWDoilZ8SCd72klWsfV9j8AsjQ0qExG", "jWVrW2Cr0ltYhYujxpjcdhq8TPZz7fCz", "Hjt9g6OfaYlBY6sAvmXw7jkFi98u1lZw"};
    public int A00;
    public boolean A04;
    public boolean A05;
    public C0483Fk A03 = new C0483Fk();
    public C0483Fk A02 = new C0483Fk();
    public long A01 = -9223372036854775807L;

    public final float A00() {
        if (A06()) {
            return (float) (1.0E9d / this.A03.A01());
        }
        return -1.0f;
    }

    public final int A01() {
        return this.A00;
    }

    public final long A02() {
        if (A06()) {
            return this.A03.A01();
        }
        return -9223372036854775807L;
    }

    public final long A03() {
        if (A06()) {
            return this.A03.A02();
        }
        return -9223372036854775807L;
    }

    public final void A04() {
        this.A03.A03();
        this.A02.A03();
        this.A04 = false;
        this.A01 = -9223372036854775807L;
        this.A00 = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A05(long j) {
        this.A03.A04(j);
        if (this.A03.A06()) {
            boolean z = this.A05;
            String[] strArr = A06;
            if (strArr[2].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[2] = "Bgvzqe";
            strArr2[4] = "uyRQxe";
            if (!z) {
                this.A04 = false;
            } else if (this.A01 != -9223372036854775807L) {
                if (!this.A04 || this.A02.A05()) {
                    this.A02.A03();
                    this.A02.A04(this.A01);
                }
                this.A04 = true;
                this.A02.A04(j);
            }
        }
        if (this.A04 && this.A02.A06()) {
            C0483Fk c0483Fk = this.A03;
            C0483Fk previousMatcher = this.A02;
            this.A03 = previousMatcher;
            this.A02 = c0483Fk;
            this.A04 = false;
            this.A05 = false;
        }
        this.A01 = j;
        this.A00 = this.A03.A06() ? 0 : this.A00 + 1;
    }

    public final boolean A06() {
        return this.A03.A06();
    }
}
