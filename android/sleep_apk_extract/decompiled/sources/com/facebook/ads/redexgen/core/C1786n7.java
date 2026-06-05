package com.facebook.ads.redexgen.core;

import android.os.Looper;
import android.os.SystemClock;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.n7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1786n7 {
    public static byte[] A03;
    public static String[] A04 = {"unLJAGqnT9K2C6pR52hzklfZHwTRg6Yr", "LeSEUls9Myr0akOYyr4ALINYOEymKOkL", "W8GYPv6JCblyMHrg4mb8qhrlE9HlP5p8", "LeDDfwbzgRXTDhaT1cwFWvWAB6ITTWPz", "taf7WKL89SeyG6P6BerDozU5lBYArJ2v", "", "BSTJObkWS6NqTAYjIRk7bCGrxc9Lgut2", "ohz3nwuOVveogY5495fLWWA936p3Bkwf"};
    public static final FJ A05;
    public static final FJ A06;
    public static final FJ A07;
    public static final FJ A08;
    public FK<? extends FL> A00;
    public IOException A01;
    public final InterfaceExecutorC0475Fb A02;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A03 = new byte[]{62, 3, 20, 43, 23, 26, 2, 30, 9, 65, 55, 20, 26, 31, 30, 9, 65};
    }

    static {
        A07();
        A07 = A01(false, -9223372036854775807L);
        A08 = A01(true, -9223372036854775807L);
        A05 = new FJ(2, -9223372036854775807L);
        A06 = new FJ(3, -9223372036854775807L);
    }

    @MetaExoPlayerCustomization(type = {"MERGED"})
    public C1786n7(InterfaceExecutorC0475Fb interfaceExecutorC0475Fb) {
        this.A02 = interfaceExecutorC0475Fb;
    }

    @MetaExoPlayerCustomization(type = {"MERGED"})
    public C1786n7(String str) {
        this(AbstractC0474Fa.A00(C5C.A0u(A06(0, 17, 64) + str), new AnonymousClass49() { // from class: com.facebook.ads.redexgen.X.n8
            @Override // com.facebook.ads.redexgen.core.AnonymousClass49
            public final void A39(Object obj) {
                ((ExecutorService) obj).shutdown();
            }
        }));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FI != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.FL> */
    @MetaExoPlayerCustomization("D14742363 Needed to accept supplied looper for Exo2DashLiveManifestFetcher manifest loading")
    private final <T extends FL> long A00(Looper looper, T t, FI<T> fi2, int i) {
        AbstractC02053y.A08(looper != null);
        this.A01 = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new FK(this, looper, t, fi2, i, jElapsedRealtime).A06(0L);
        return jElapsedRealtime;
    }

    public static FJ A01(boolean z, long j) {
        return new FJ(z ? 1 : 0, j);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FI != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.FL> */
    public final <T extends FL> long A08(T t, FI<T> fi2, int i) {
        Looper looper = (Looper) AbstractC02053y.A02(Looper.myLooper());
        return A00(looper, t, fi2, i);
    }

    public final void A09() {
        ((FK) AbstractC02053y.A02(this.A00)).A07(false);
    }

    public final void A0A() {
        this.A01 = null;
    }

    public final void A0B(int i) throws IOException {
        if (this.A01 == null) {
            if (this.A00 != null) {
                FK<? extends FL> fk = this.A00;
                if (i == Integer.MIN_VALUE) {
                    FK<? extends FL> fk2 = this.A00;
                    String[] strArr = A04;
                    if (strArr[6].charAt(7) == strArr[1].charAt(7)) {
                        throw new RuntimeException();
                    }
                    A04[2] = "wo2YdO45DQEJfRTdGKzxAcazBLTDj4mX";
                    i = fk2.A06;
                }
                fk.A05(i);
                return;
            }
            return;
        }
        throw this.A01;
    }

    public final void A0C(FM fm) {
        if (this.A00 != null) {
            FK<? extends FL> fk = this.A00;
            String[] strArr = A04;
            if (strArr[5].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "XVuhTdSnDMDRP6HltjyP328n9S8al0u6";
            strArr2[0] = "1piWh3nqPhJ4K6qVEs9qRP5dHkNT6n7u";
            fk.A07(true);
        }
        if (fm != null) {
            this.A02.execute(new FN(fm));
        }
        this.A02.AHb();
    }

    public final boolean A0D() {
        return this.A01 != null;
    }

    public final boolean A0E() {
        return this.A00 != null;
    }
}
