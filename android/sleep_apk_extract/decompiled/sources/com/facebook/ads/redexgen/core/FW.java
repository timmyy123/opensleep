package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class FW {
    public static String[] A07 = {"yeCTR", "vbYpGeRKHwsNyxajpSfuheCIvaYNa3MM", "oEndzsHg4", "8UJlx4orYPxMpFHWptRgD2Ht", "cT5Bq67DmISXhs3jX", "HBUYvmEJLfhzIFqS0furUTPx", "Yflab", "bdcCFsYTxOJVXsfU13RZ00QELBiL0cIH"};
    public static final Comparator<FV> A08 = new Comparator() { // from class: com.facebook.ads.redexgen.X.FS
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return FW.A00((FV) obj, (FV) obj2);
        }
    };
    public static final Comparator<FV> A09 = new Comparator() { // from class: com.facebook.ads.redexgen.X.FT
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Float.compare(((FV) obj).A00, ((FV) obj2).A00);
        }
    };
    public int A01;
    public int A02;
    public int A03;
    public final int A04;
    public final FV[] A06 = new FV[5];
    public final ArrayList<FV> A05 = new ArrayList<>();
    public int A00 = -1;

    public FW(int i) {
        this.A04 = i;
    }

    public static /* synthetic */ int A00(FV fv, FV fv2) {
        return fv.A01 - fv2.A01;
    }

    private void A02() {
        if (this.A00 != 1) {
            Collections.sort(this.A05, A08);
            this.A00 = 1;
        }
    }

    private void A03() {
        if (this.A00 != 0) {
            Collections.sort(this.A05, A09);
            this.A00 = 0;
        }
    }

    private final void A04(int i, float f) {
        FV oldestSample;
        A02();
        if (this.A02 > 0) {
            FV[] fvArr = this.A06;
            int i2 = this.A02 - 1;
            this.A02 = i2;
            oldestSample = fvArr[i2];
        } else {
            oldestSample = new FV();
        }
        int i3 = this.A01;
        this.A01 = i3 + 1;
        oldestSample.A01 = i3;
        oldestSample.A02 = i;
        oldestSample.A00 = f;
        this.A05.add(oldestSample);
        this.A03 += i;
        while (this.A03 > this.A04) {
            int excessWeight = this.A03 - this.A04;
            FV fv = this.A05.get(0);
            if (fv.A02 <= excessWeight) {
                this.A03 -= fv.A02;
                this.A05.remove(0);
                if (this.A02 < 5) {
                    FV[] fvArr2 = this.A06;
                    int excessWeight2 = this.A02;
                    this.A02 = excessWeight2 + 1;
                    fvArr2[excessWeight2] = fv;
                }
            } else {
                fv.A02 -= excessWeight;
                this.A03 -= excessWeight;
            }
        }
    }

    public final float A05(float f) {
        A03();
        float f2 = this.A03 * f;
        int i = 0;
        int i2 = 0;
        while (true) {
            int size = this.A05.size();
            int accumulatedWeight = A07[7].charAt(16);
            if (accumulatedWeight != 49) {
                throw new RuntimeException();
            }
            A07[7] = "tMnKu67VMHjg0RGb1V9fdd44wq1tOS9W";
            if (i2 < size) {
                FV fv = this.A05.get(i2);
                i += fv.A02;
                float desiredWeight = i;
                if (desiredWeight >= f2) {
                    float desiredWeight2 = fv.A00;
                    return desiredWeight2;
                }
                i2++;
            } else {
                if (this.A05.isEmpty()) {
                    return Float.NaN;
                }
                float desiredWeight3 = this.A05.get(this.A05.size() - 1).A00;
                return desiredWeight3;
            }
        }
    }

    public final void A06() {
        this.A05.clear();
        this.A00 = -1;
        this.A01 = 0;
        this.A03 = 0;
    }

    @MetaExoPlayerCustomization("D20155618 Samples OutOfBounds Error Check Fix")
    public final void A07(int i, float f) {
        FV oldestSample;
        if (MetaExoPlayerUpgradeConfig.A03(EnumC1581jX.A1F)) {
            A04(i, f);
            return;
        }
        A02();
        if (this.A02 > 0) {
            FV[] fvArr = this.A06;
            int i2 = this.A02 - 1;
            this.A02 = i2;
            oldestSample = fvArr[i2];
        } else {
            oldestSample = new FV();
        }
        int i3 = this.A01;
        this.A01 = i3 + 1;
        oldestSample.A01 = i3;
        oldestSample.A02 = i;
        oldestSample.A00 = f;
        this.A05.add(oldestSample);
        this.A03 += i;
        while (this.A03 > this.A04 && !this.A05.isEmpty()) {
            int excessWeight = this.A03 - this.A04;
            FV fv = this.A05.get(0);
            if (fv.A02 <= excessWeight) {
                this.A03 -= fv.A02;
                String[] strArr = A07;
                if (strArr[3].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A07;
                strArr2[3] = "3KNEloHV0yOGYGtjjhul0kjR";
                strArr2[5] = "CQhg8nP9eAQ7nTj9eI4Xv7HE";
                this.A05.remove(0);
                if (this.A02 < 5) {
                    FV[] fvArr2 = this.A06;
                    String[] strArr3 = A07;
                    if (strArr3[6].length() != strArr3[0].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A07;
                    strArr4[2] = "1EJuh5GaS";
                    strArr4[4] = "pMRpDkTII4u81yBOo";
                    int excessWeight2 = this.A02;
                    this.A02 = excessWeight2 + 1;
                    fvArr2[excessWeight2] = fv;
                } else {
                    continue;
                }
            } else {
                fv.A02 -= excessWeight;
                this.A03 -= excessWeight;
            }
        }
    }
}
