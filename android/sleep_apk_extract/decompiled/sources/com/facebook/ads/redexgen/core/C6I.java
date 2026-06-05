package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C6I {
    public static byte[] A0G;
    public static String[] A0H = {"PO8jPPjsWkSohvoClx2DXSl8S5WX59Vo", "WTC2lbEoOF", "JF48xkVfbyUi8xBtmw", "8DzCN5fkinelgfDbo7bZLAsZpLiI5tji", "0XqHByXaOSOjXRziBAqROkukCru0GxwN", "eULZ8KrR2sSax75EYp3yLx1S0uA0IndI", "SEYTT", "AcNYjN6U0IjRu5cSurFZ1FZkr4vsIKRe"};

    @MetaExoPlayerCustomization("The average time that it takes to decode frames expressed in milliseconds")
    public int A00;

    @MetaExoPlayerCustomization("The average time that it takes to render frames expressed in milliseconds")
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;

    @MetaExoPlayerCustomization("Total number of samples used to calculate average decode and render times")
    public int A0C;
    public int A0D;

    @MetaExoPlayerCustomization("The number of frames that were in a gap and skipped as a result of it")
    public int A0E;
    public long A0F;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0G = new byte[]{19, 50, 52, 56, 51, 50, 37, 20, 56, 34, 57, 35, 50, 37, 36, 119, 44, 93, 119, 51, 50, 52, 56, 51, 50, 37, 30, 57, 62, 35, 36, 106, 114, 36, 123, 93, 119, 51, 50, 52, 56, 51, 50, 37, 5, 50, 59, 50, 54, 36, 50, 36, 106, 114, 36, 93, 119, 38, 34, 50, 34, 50, 51, 30, 57, 39, 34, 35, 21, 34, 49, 49, 50, 37, 36, 106, 114, 36, 93, 119, 36, 60, 62, 39, 39, 50, 51, 30, 57, 39, 34, 35, 21, 34, 49, 49, 50, 37, 36, 106, 114, 36, 93, 119, 37, 50, 57, 51, 50, 37, 50, 51, 24, 34, 35, 39, 34, 35, 21, 34, 49, 49, 50, 37, 36, 106, 114, 36, 93, 119, 36, 60, 62, 39, 39, 50, 51, 24, 34, 35, 39, 34, 35, 21, 34, 49, 49, 50, 37, 36, 106, 114, 36, 93, 119, 51, 37, 56, 39, 39, 50, 51, 21, 34, 49, 49, 50, 37, 36, 106, 114, 36, 93, 119, 51, 37, 56, 39, 39, 50, 51, 30, 57, 39, 34, 35, 21, 34, 49, 49, 50, 37, 36, 106, 114, 36, 93, 119, 58, 54, 47, 20, 56, 57, 36, 50, 52, 34, 35, 62, 33, 50, 19, 37, 56, 39, 39, 50, 51, 21, 34, 49, 49, 50, 37, 36, 106, 114, 36, 93, 119, 51, 37, 56, 39, 39, 50, 51, 3, 56, 28, 50, 46, 49, 37, 54, 58, 50, 18, 33, 50, 57, 35, 36, 106, 114, 36, 93, 119, 35, 56, 35, 54, 59, 1, 62, 51, 50, 56, 17, 37, 54, 58, 50, 7, 37, 56, 52, 50, 36, 36, 62, 57, 48, 24, 49, 49, 36, 50, 35, 2, 36, 106, 114, 36, 93, 119, 33, 62, 51, 50, 56, 17, 37, 54, 58, 50, 7, 37, 56, 52, 50, 36, 36, 62, 57, 48, 24, 49, 49, 36, 50, 35, 20, 56, 34, 57, 35, 106, 114, 36, 93, 42};
    }

    static {
        A01();
    }

    public final synchronized void A02() {
    }

    @MetaExoPlayerCustomization
    public final void A03(long j) {
        this.A01 = this.A09 == 0 ? -1 : (int) (j / ((long) this.A09));
        String[] strArr = A0H;
        if (strArr[5].charAt(27) != strArr[4].charAt(27)) {
            throw new RuntimeException();
        }
        A0H[1] = "yfB4vc6THQ";
    }

    @MetaExoPlayerCustomization
    public final void A04(Pair<Long, Integer> newSamplePerFrameDecodeTimeAndCount) {
        int i;
        long j = ((long) this.A0C) * ((long) this.A00);
        this.A0C += ((Integer) newSamplePerFrameDecodeTimeAndCount.second).intValue();
        long updatedTotalDecodeTime = ((Long) newSamplePerFrameDecodeTimeAndCount.first).longValue() + j;
        if (this.A0C == 0) {
            i = -1;
        } else {
            long currentTotalDecodeTime = this.A0C;
            i = (int) (updatedTotalDecodeTime / currentTotalDecodeTime);
        }
        this.A00 = i;
    }

    public final String toString() {
        return C5C.A0n(A00(0, 333, 101), Integer.valueOf(this.A02), Integer.valueOf(this.A03), Integer.valueOf(this.A08), Integer.valueOf(this.A0A), Integer.valueOf(this.A09), Integer.valueOf(this.A0B), Integer.valueOf(this.A04), Integer.valueOf(this.A05), Integer.valueOf(this.A07), Integer.valueOf(this.A06), Long.valueOf(this.A0F), Integer.valueOf(this.A0D));
    }
}
