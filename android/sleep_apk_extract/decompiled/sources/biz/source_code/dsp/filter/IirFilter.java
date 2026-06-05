package biz.source_code.dsp.filter;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class IirFilter {
    private double[] a;
    private double[] b;
    private double[] buf1;
    private double[] buf2;
    private int n1;
    private int n2;
    private int pos1;
    private int pos2;

    public IirFilter(IirFilterCoefficients iirFilterCoefficients) {
        double[] dArr = iirFilterCoefficients.a;
        this.a = dArr;
        double[] dArr2 = iirFilterCoefficients.b;
        this.b = dArr2;
        if (dArr.length < 1 || dArr2.length < 1 || dArr[0] != 1.0d) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid coefficients.");
            throw null;
        }
        int length = dArr2.length - 1;
        this.n1 = length;
        int length2 = dArr.length - 1;
        this.n2 = length2;
        this.buf1 = new double[length];
        this.buf2 = new double[length2];
    }

    public double step(double d) {
        int i;
        double d2 = this.b[0] * d;
        int i2 = 1;
        while (true) {
            int i3 = this.n1;
            if (i2 > i3) {
                break;
            }
            d2 += this.b[i2] * this.buf1[((this.pos1 + i3) - i2) % i3];
            i2++;
        }
        int i4 = 1;
        while (true) {
            i = this.n2;
            if (i4 > i) {
                break;
            }
            d2 -= this.a[i4] * this.buf2[((this.pos2 + i) - i4) % i];
            i4++;
        }
        int i5 = this.n1;
        if (i5 > 0) {
            double[] dArr = this.buf1;
            int i6 = this.pos1;
            dArr[i6] = d;
            this.pos1 = (i6 + 1) % i5;
        }
        if (i > 0) {
            double[] dArr2 = this.buf2;
            int i7 = this.pos2;
            dArr2[i7] = d2;
            this.pos2 = (i7 + 1) % i;
        }
        return d2;
    }
}
