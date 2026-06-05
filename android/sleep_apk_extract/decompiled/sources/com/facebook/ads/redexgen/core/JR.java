package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public final class JR {
    public static String[] A08 = {"AtxLAVOLIQu", "Fle8gwQlySsExFOL9KX8wb0v", "wFpk", "KqR90lH25ch62x6cAj66e37DOVxg4eZG", "XchR4DYnLnD3gtwkslZg", "tO3f9MPY4MkMP3", "", "TthioVfwXchWaR6I8DsFZ4y13Jptm90E"};
    public final int A00;
    public final int A01;
    public final long A02;
    public final JO A03;
    public final int[] A04;
    public final int[] A05;
    public final long[] A06;
    public final long[] A07;

    public JR(JO jo, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        AbstractC02053y.A07(iArr.length == jArr2.length);
        AbstractC02053y.A07(jArr.length == jArr2.length);
        AbstractC02053y.A07(iArr2.length == jArr2.length);
        this.A03 = jo;
        this.A06 = jArr;
        this.A05 = iArr;
        this.A00 = i;
        this.A07 = jArr2;
        this.A04 = iArr2;
        this.A02 = j;
        this.A01 = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public final int A00(long j) {
        for (int iA0L = C5C.A0L(this.A07, j, true, false); iA0L >= 0; iA0L--) {
            int i = this.A04[iA0L] & 1;
            int i2 = A08[1].length();
            if (i2 == 25) {
                throw new RuntimeException();
            }
            A08[1] = "GcE";
            if (i != 0) {
                return iA0L;
            }
        }
        return -1;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int A01(long j) {
        for (int i = C5C.A0K(this.A07, j, true, false); i < startIndex; i++) {
            int startIndex = this.A04[i];
            if ((startIndex & 1) != 0) {
                return i;
            }
        }
        return -1;
    }
}
