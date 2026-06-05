package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2v, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C01782v {
    public static String[] A05 = {"qHTDH9In90rcdwOuJSMsckDCyhXLEqXh", "sjoVkyKa6A2BCKkZrfwj87PX67VguoUI", "qImvz97oy2HsABXMHKvVYevPQzDne9wP", "UzpUk3fTqoJh79PyI9vqz", "KgRAjTCckMjKxprnKjT8aDWLldg5JvO5", "4Alk19u7jrL2h9l2ISqApHve2GAaOLRy", "kGAXwVnqzw6LSG9eyiJgo4nQQXri73zT", "O"};
    public long A00 = Long.MIN_VALUE;
    public long A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;

    public final C01782v A05(long j) {
        AbstractC02053y.A07(j == Long.MIN_VALUE || j >= 0);
        this.A00 = j;
        return this;
    }

    public final C01782v A06(long j) {
        AbstractC02053y.A07(j >= 0);
        this.A01 = j;
        if (A05[2].charAt(19) == 'l') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[1] = "GlFOp7JpNqKfXRYg7N9RmxJvUWBJ1iGt";
        strArr[5] = "Rn5Ay0m12IVZQeo3EqueLf0qwBG2bayA";
        return this;
    }

    public final C01782v A07(boolean z) {
        this.A02 = z;
        return this;
    }

    public final C01782v A08(boolean z) {
        this.A03 = z;
        return this;
    }

    public final C01782v A09(boolean z) {
        this.A04 = z;
        return this;
    }

    public final AW A0A() {
        return A0B();
    }

    @Deprecated
    public final AW A0B() {
        return new AW(this);
    }
}
