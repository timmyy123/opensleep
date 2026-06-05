package biz.source_code.dsp.math;

import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class PolynomialRootFinderJenkinsTraub {

    public static class GlobalEnvironment {
        private static final double cosr = Math.cos(1.6406094968746698d);
        private static final double sinr = Math.sin(1.6406094968746698d);
        private double a;
        private double a1;
        private double a3;
        private double a7;
        private double b;
        private double c;
        private double d;
        private double e;
        private double f;
        private double g;
        private double h;
        private double[] k;
        private Complex lz;
        private int n;
        private int nn;
        private double[] p;
        private double[] qk;
        private double[] qp;
        private Complex sz;
        private double u;
        private double v;

        public static class RealitOut {
            boolean iflag;
            int nz;
            double sss;

            public RealitOut(double d, int i, boolean z) {
                this.sss = d;
                this.nz = i;
                this.iflag = z;
            }
        }

        public /* synthetic */ GlobalEnvironment(int i) {
            this();
        }

        private int calcsc() {
            double[] dArr = new double[2];
            PolynomialRootFinderJenkinsTraub.quadsd(this.n, this.u, this.v, this.k, this.qk, dArr);
            double d = dArr[0];
            this.c = d;
            this.d = dArr[1];
            if (Math.abs(d) <= Math.abs(this.k[this.n]) * 100.0d * 2.22E-16d || Math.abs(this.d) <= Math.abs(this.k[this.n - 1]) * 100.0d * 2.22E-16d) {
                return 3;
            }
            double dAbs = Math.abs(this.d);
            double dAbs2 = Math.abs(this.c);
            double d2 = this.a;
            if (dAbs >= dAbs2) {
                double d3 = this.d;
                double d4 = d2 / d3;
                this.e = d4;
                double d5 = this.c / d3;
                this.f = d5;
                double d6 = this.u;
                double d7 = this.b;
                double d8 = d6 * d7;
                this.g = d8;
                double d9 = this.v * d7;
                this.h = d9;
                this.a3 = ((d7 / d3) * d9) + ((d8 + d2) * d4);
                this.a1 = (d7 * d5) - d2;
                this.a7 = ((d5 + d6) * d2) + d9;
                return 2;
            }
            double d10 = this.c;
            double d11 = d2 / d10;
            this.e = d11;
            double d12 = this.d;
            double d13 = d12 / d10;
            this.f = d13;
            double d14 = this.u * d11;
            this.g = d14;
            double d15 = this.v;
            double d16 = this.b;
            double d17 = d15 * d16;
            this.h = d17;
            this.a3 = (((d17 / d10) + d14) * d16) + (d2 * d11);
            this.a1 = d16 - (d13 * d2);
            this.a7 = (d17 * d13) + (d14 * d12) + d2;
            return 1;
        }

        private int fxshfr(int i, double d) {
            double d2;
            double d3;
            int i2;
            char c;
            double d4;
            double dAbs;
            double d5 = this.v;
            char c2 = 2;
            double[] dArr = new double[2];
            PolynomialRootFinderJenkinsTraub.quadsd(this.nn, this.u, d5, this.p, this.qp, dArr);
            int i3 = 0;
            this.a = dArr[0];
            int i4 = 1;
            this.b = dArr[1];
            int i5 = 1;
            double d6 = d5;
            double d7 = 0.0d;
            double d8 = 0.0d;
            double d9 = 0.25d;
            double d10 = 0.25d;
            int iCalcsc = calcsc();
            double d11 = d;
            while (i5 <= i) {
                nextk(iCalcsc);
                iCalcsc = calcsc();
                double[] dArrNewest = newest(iCalcsc);
                double d12 = dArrNewest[i3];
                double d13 = dArrNewest[i4];
                int i6 = i3;
                double d14 = this.k[this.n];
                if (d14 != 0.0d) {
                    d2 = 0.25d;
                    d3 = (-this.p[this.nn]) / d14;
                } else {
                    d2 = 0.25d;
                    d3 = 0.0d;
                }
                if (i5 == i4 || iCalcsc == 3) {
                    i2 = i4;
                    c = c2;
                    d4 = d3;
                    dAbs = 1.0d;
                    d7 = 1.0d;
                } else {
                    double dAbs2 = d13 != 0.0d ? Math.abs((d13 - d6) / d13) : 1.0d;
                    dAbs = d3 != 0.0d ? Math.abs((d3 - d11) / d3) : 1.0d;
                    double d15 = dAbs2 < d7 ? d7 * dAbs2 : 1.0d;
                    double d16 = dAbs < d8 ? dAbs * d8 : 1.0d;
                    int i7 = d15 < d9 ? i4 : i6;
                    int i8 = d16 < d10 ? i4 : i6;
                    if (i8 == 0 && i7 == 0) {
                        i2 = i4;
                        c = c2;
                        d4 = d3;
                    } else {
                        i2 = i4;
                        double d17 = dAbs;
                        double d18 = this.u;
                        d4 = d3;
                        double d19 = this.v;
                        double[] dArr2 = new double[this.n + 1];
                        int i9 = i7;
                        for (int i10 = i2; i10 <= this.n; i10++) {
                            dArr2[i10] = this.k[i10];
                        }
                        char c3 = 20;
                        char c4 = (i8 == 0 || (i9 != 0 && d16 >= d15)) ? (char) 20 : '(';
                        int i11 = i6;
                        int i12 = i11;
                        double d20 = d12;
                        double d21 = d13;
                        double d22 = d4;
                        while (c4 != 'F') {
                            if (c4 == c3) {
                                double d23 = d20;
                                double d24 = d18;
                                int i13 = iCalcsc;
                                int i14 = i11;
                                double d25 = d21;
                                double d26 = d22;
                                int iQuadit = quadit(d23, d25);
                                if (iQuadit > 0) {
                                    return iQuadit;
                                }
                                d9 *= d2;
                                if (i14 != 0 || i8 == 0) {
                                    d22 = d26;
                                    i11 = i14;
                                    d18 = d24;
                                    d20 = d23;
                                    c4 = '2';
                                } else {
                                    for (int i15 = i2; i15 <= this.n; i15++) {
                                        this.k[i15] = dArr2[i15];
                                    }
                                    d22 = d26;
                                    i11 = i14;
                                    d18 = d24;
                                    d20 = d23;
                                    c4 = '(';
                                }
                                d21 = d25;
                                iCalcsc = i13;
                                i12 = i2;
                                c3 = 20;
                            } else if (c4 == '(') {
                                RealitOut realitOutRealit = realit(d22);
                                int i16 = realitOutRealit.nz;
                                if (i16 > 0) {
                                    return i16;
                                }
                                double d27 = realitOutRealit.sss;
                                d10 *= d2;
                                if (realitOutRealit.iflag) {
                                    d22 = d27;
                                    i11 = i2;
                                    c3 = 20;
                                    c4 = '2';
                                } else {
                                    d21 = d27 * d27;
                                    d20 = -(d27 + d27);
                                    d18 = d18;
                                    d22 = d27;
                                    i11 = i2;
                                    c3 = 20;
                                    c4 = 20;
                                }
                            } else {
                                if (c4 != '2') {
                                    Utf8$$ExternalSyntheticBUOutline0.m$1();
                                    return i6;
                                }
                                this.u = d18;
                                this.v = d19;
                                for (int i17 = i2; i17 <= this.n; i17++) {
                                    this.k[i17] = dArr2[i17];
                                }
                                if (i9 == 0 || i12 != 0) {
                                    double[] dArr3 = new double[2];
                                    PolynomialRootFinderJenkinsTraub.quadsd(this.nn, this.u, this.v, this.p, this.qp, dArr3);
                                    this.a = dArr3[i6];
                                    this.b = dArr3[i2];
                                    iCalcsc = calcsc();
                                    i11 = i11;
                                    c3 = 20;
                                    c4 = 'F';
                                } else {
                                    c3 = 20;
                                    c4 = 20;
                                }
                            }
                        }
                        dAbs = d17;
                        c = 2;
                    }
                    d7 = dAbs2;
                }
                i5++;
                i4 = i2;
                i3 = i6;
                d6 = d13;
                c2 = c;
                d8 = dAbs;
                d11 = d4;
            }
            return i3;
        }

        private double[] newest(int i) {
            double d;
            double d2;
            if (i == 3) {
                return new double[]{0.0d, 0.0d};
            }
            double d3 = this.a;
            if (i == 2) {
                double d4 = d3 + this.g;
                double d5 = this.f;
                d = (d4 * d5) + this.h;
                d2 = (this.v * this.d) + ((d5 + this.u) * this.c);
            } else {
                double d6 = this.u;
                double d7 = (this.b * d6) + d3;
                double d8 = this.h;
                double d9 = this.f;
                d = (d8 * d9) + d7;
                d2 = this.c + (((this.v * d9) + d6) * this.d);
            }
            double[] dArr = this.k;
            int i2 = this.n;
            double d10 = -dArr[i2];
            double[] dArr2 = this.p;
            double d11 = dArr2[this.nn];
            double d12 = d10 / d11;
            double d13 = (-((dArr2[i2] * d12) + dArr[i2 - 1])) / d11;
            double d14 = this.v;
            double d15 = this.a1;
            double d16 = this.a7;
            double d17 = d12 * d16;
            double d18 = d12 * d12 * this.a3;
            double d19 = (((d14 * d13) * d15) - d17) - d18;
            double d20 = ((d12 * d) + d2) - d19;
            if (d20 == 0.0d) {
                return new double[]{0.0d, 0.0d};
            }
            double d21 = this.u;
            return new double[]{d21 - (((((d16 * d13) + (d12 * d15)) * d14) + ((d18 + d17) * d21)) / d20), ((d19 / d20) + 1.0d) * d14};
        }

        private void nextk(int i) {
            int i2 = 3;
            if (i == 3) {
                double[] dArr = this.k;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
                while (i2 <= this.n) {
                    this.k[i2] = this.qk[i2 - 2];
                    i2++;
                }
                return;
            }
            if (Math.abs(this.a1) <= Math.abs(i == 1 ? this.b : this.a) * 2.22E-16d * 10.0d) {
                double[] dArr2 = this.k;
                dArr2[1] = 0.0d;
                dArr2[2] = (-this.a7) * this.qp[1];
                while (i2 <= this.n) {
                    this.k[i2] = (this.a3 * this.qk[i2 - 2]) - (this.a7 * this.qp[i2 - 1]);
                    i2++;
                }
                return;
            }
            double d = this.a7;
            double d2 = this.a1;
            double d3 = d / d2;
            this.a7 = d3;
            this.a3 /= d2;
            double[] dArr3 = this.k;
            double[] dArr4 = this.qp;
            dArr3[1] = dArr4[1];
            dArr3[2] = dArr4[2] - (d3 * dArr4[1]);
            while (i2 <= this.n) {
                double[] dArr5 = this.k;
                double d4 = this.a3 * this.qk[i2 - 2];
                double d5 = this.a7;
                double[] dArr6 = this.qp;
                dArr5[i2] = (d4 - (d5 * dArr6[i2 - 1])) + dArr6[i2];
                i2++;
            }
        }

        private int quadit(double d, double d2) {
            this.u = d;
            this.v = d2;
            int i = 0;
            int i2 = 0;
            boolean z = false;
            double d3 = 0.0d;
            double d4 = 0.0d;
            while (true) {
                Complex[] complexArrQuad = PolynomialRootFinderJenkinsTraub.quad(1.0d, this.u, this.v);
                Complex complex = complexArrQuad[i];
                this.sz = complex;
                this.lz = complexArrQuad[1];
                if (Math.abs(Math.abs(complex.re()) - Math.abs(this.lz.re())) > Math.abs(this.lz.re()) * 0.01d) {
                    return i;
                }
                double[] dArr = new double[2];
                int i3 = i;
                PolynomialRootFinderJenkinsTraub.quadsd(this.nn, this.u, this.v, this.p, this.qp, dArr);
                double d5 = dArr[i3];
                this.a = d5;
                this.b = dArr[1];
                double dAbs = Math.abs(this.sz.im() * this.b) + Math.abs(d5 - (this.sz.re() * this.b));
                double dSqrt = Math.sqrt(Math.abs(this.v));
                double dAbs2 = Math.abs(this.qp[1]) * 2.0d;
                double d6 = (-this.sz.re()) * this.b;
                for (int i4 = 2; i4 <= this.n; i4++) {
                    dAbs2 = (dAbs2 * dSqrt) + Math.abs(this.qp[i4]);
                }
                if (dAbs <= ((Math.abs(d6) * 4.44E-16d) + (((Math.abs(this.a + d6) + (dAbs2 * dSqrt)) * 1.998E-15d) - (((Math.abs(this.b) * dSqrt) + Math.abs(this.a + d6)) * 1.554E-15d))) * 20.0d) {
                    return 2;
                }
                i2++;
                if (i2 > 20) {
                    return i3;
                }
                if (i2 >= 2 && d3 <= 0.01d && dAbs >= d4 && !z) {
                    if (d3 < 2.22E-16d) {
                        d3 = 2.22E-16d;
                    }
                    double dSqrt2 = Math.sqrt(d3);
                    double d7 = this.u;
                    double d8 = d7 - (d7 * dSqrt2);
                    this.u = d8;
                    double d9 = this.v;
                    double d10 = (dSqrt2 * d9) + d9;
                    this.v = d10;
                    double[] dArr2 = new double[2];
                    PolynomialRootFinderJenkinsTraub.quadsd(this.nn, d8, d10, this.p, this.qp, dArr2);
                    this.a = dArr2[i3];
                    this.b = dArr2[1];
                    for (int i5 = 1; i5 <= 5; i5++) {
                        nextk(calcsc());
                    }
                    i2 = i3;
                    z = true;
                }
                nextk(calcsc());
                double[] dArrNewest = newest(calcsc());
                double d11 = dArrNewest[i3];
                double d12 = dArrNewest[1];
                if (d12 == 0.0d) {
                    return i3;
                }
                double dAbs3 = Math.abs((d12 - this.v) / d12);
                this.u = d11;
                this.v = d12;
                i = i3;
                d3 = dAbs3;
                d4 = dAbs;
            }
        }

        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r5v8 */
        private RealitOut realit(double d) {
            double d2;
            ?? r5 = 0;
            double d3 = d;
            int i = 0;
            double d4 = 0.0d;
            double d5 = 0.0d;
            while (true) {
                double d6 = this.p[1];
                this.qp[1] = d6;
                double d7 = d6;
                for (int i2 = 2; i2 <= this.nn; i2++) {
                    d7 = (d7 * d3) + this.p[i2];
                    this.qp[i2] = d7;
                }
                double dAbs = Math.abs(d7);
                double dAbs2 = Math.abs(d3);
                double dAbs3 = Math.abs(this.qp[1]) * 0.5d;
                for (int i3 = 2; i3 <= this.nn; i3++) {
                    dAbs3 = Math.abs(this.qp[i3]) + (dAbs3 * dAbs2);
                }
                if (dAbs <= ((dAbs3 * 4.44E-16d) - (dAbs * 2.22E-16d)) * 20.0d) {
                    this.sz = new Complex(d3);
                    return new RealitOut(d, 1, r5);
                }
                i++;
                if (i > 10) {
                    return new RealitOut(d, r5, r5);
                }
                if (i >= 2 && Math.abs(d4) <= Math.abs(d3 - d4) * 0.001d && dAbs > d5) {
                    return new RealitOut(d3, r5, true);
                }
                double d8 = this.k[1];
                this.qk[1] = d8;
                for (int i4 = 2; i4 <= this.n; i4++) {
                    d8 = (d8 * d3) + this.k[i4];
                    this.qk[i4] = d8;
                }
                double dAbs4 = Math.abs(d8);
                double dAbs5 = Math.abs(this.k[this.n]) * 10.0d * 2.22E-16d;
                double[] dArr = this.k;
                if (dAbs4 <= dAbs5) {
                    dArr[1] = 0.0d;
                    for (int i5 = 2; i5 <= this.n; i5++) {
                        this.k[i5] = this.qk[i5 - 1];
                    }
                    d2 = d3;
                } else {
                    d2 = d3;
                    double d9 = (-d7) / d8;
                    dArr[1] = this.qp[1];
                    for (int i6 = 2; i6 <= this.n; i6++) {
                        this.k[i6] = (this.qk[i6 - 1] * d9) + this.qp[i6];
                    }
                }
                double d10 = this.k[1];
                for (int i7 = 2; i7 <= this.n; i7++) {
                    d10 = (d10 * d2) + this.k[i7];
                }
                double d11 = Math.abs(d10) > (Math.abs(this.k[this.n]) * 10.0d) * 2.22E-16d ? (-d7) / d10 : 0.0d;
                d3 = d2 + d11;
                d4 = d11;
                d5 = dAbs;
                r5 = 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0293, code lost:
        
            r1 = r34.n;
            r4[r3 - r1] = r34.sz;
            r8 = r35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x029d, code lost:
        
            if (r6 <= r8) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x029f, code lost:
        
            r4[(r3 - r1) + r8] = r34.lz;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x02a6, code lost:
        
            r1 = r34.nn - r6;
            r34.nn = r1;
            r34.n = r1 - r8;
            r1 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x02b1, code lost:
        
            if (r1 > r34.nn) goto L157;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x02b3, code lost:
        
            r34.p[r1] = r34.qp[r1];
            r1 = r1 + 1;
         */
        /* JADX WARN: Removed duplicated region for block: B:93:0x01fc  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01ff  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Complex[] rpoly(double[] dArr) {
            int i;
            double d;
            int i2;
            int i3;
            double[] dArr2;
            double d2;
            int i4;
            int length = dArr.length;
            int i5 = length - 1;
            Complex[] complexArr = new Complex[i5];
            double dSqrt = Math.sqrt(0.5d);
            double d3 = -dSqrt;
            this.n = i5;
            double d4 = 0.0d;
            if (dArr[0] == 0.0d) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("The leading coefficient must not be zero.");
                return null;
            }
            while (true) {
                i = this.n;
                if (i <= 0 || dArr[i] != 0.0d) {
                    break;
                }
                complexArr[i5 - i] = Complex.ZERO;
                this.n = i - 1;
            }
            this.nn = i + 1;
            int i6 = 2;
            this.p = new double[i + 2];
            int i7 = 1;
            for (int i8 = 1; i8 <= this.nn; i8++) {
                this.p[i8] = dArr[i8 - 1];
            }
            while (true) {
                int i9 = this.n;
                if (i9 < i7) {
                    return complexArr;
                }
                if (i9 == i7) {
                    double[] dArr3 = this.p;
                    complexArr[length - i6] = new Complex((-dArr3[i6]) / dArr3[i7]);
                    return complexArr;
                }
                if (i9 == i6) {
                    double[] dArr4 = this.p;
                    Complex[] complexArrQuad = PolynomialRootFinderJenkinsTraub.quad(dArr4[i7], dArr4[i6], dArr4[3]);
                    complexArr[length - 3] = complexArrQuad[0];
                    complexArr[length - i6] = complexArrQuad[i7];
                    return complexArr;
                }
                double d5 = 3.4028234663852886E38d;
                double d6 = d4;
                for (int i10 = i7; i10 <= this.nn; i10++) {
                    double dAbs = Math.abs(this.p[i10]);
                    if (dAbs > d6) {
                        d6 = dAbs;
                    }
                    if (dAbs != d4 && dAbs < d5) {
                        d5 = dAbs;
                    }
                }
                double d7 = 5.295019598298592E-23d / d5;
                if (d7 == d4) {
                    d7 = 1.1754943508222875E-38d;
                }
                if ((d7 <= 1.0d || 3.4028234663852886E38d / d7 < d6) && (d7 > 1.0d || d6 <= 10.0d)) {
                    d = d4;
                } else {
                    d = d4;
                    double dPow = Math.pow(2.0d, (Math.log(d7) / Math.log(2.0d)) + 0.5d);
                    if (dPow != 1.0d) {
                        for (int i11 = i7; i11 <= this.nn; i11++) {
                            double[] dArr5 = this.p;
                            dArr5[i11] = dArr5[i11] * dPow;
                        }
                    }
                }
                double[] dArr6 = new double[this.nn + i7];
                int i12 = i7;
                while (true) {
                    i2 = this.nn;
                    if (i12 > i2) {
                        break;
                    }
                    dArr6[i12] = Math.abs(this.p[i12]);
                    i12++;
                }
                double d8 = -dArr6[i2];
                dArr6[i2] = d8;
                double dExp = Math.exp((Math.log(-d8) - Math.log(dArr6[i7])) / ((double) this.n));
                double d9 = dArr6[this.n];
                if (d9 != d) {
                    double d10 = (-dArr6[this.nn]) / d9;
                    if (d10 < dExp) {
                        dExp = d10;
                    }
                }
                while (true) {
                    double d11 = 0.1d * dExp;
                    double d12 = dArr6[i7];
                    for (int i13 = 2; i13 <= this.nn; i13++) {
                        d12 = (d12 * d11) + dArr6[i13];
                    }
                    if (d12 <= d) {
                        break;
                    }
                    dExp = d11;
                }
                double d13 = dExp;
                while (Math.abs(dExp / d13) > 0.005d) {
                    double d14 = dArr6[i7];
                    double d15 = d14;
                    for (int i14 = 2; i14 <= this.n; i14++) {
                        d14 = (d14 * d13) + dArr6[i14];
                        d15 = (d15 * d13) + d14;
                    }
                    dExp = ((d14 * d13) + dArr6[this.nn]) / d15;
                    d13 -= dExp;
                }
                int i15 = this.n;
                int i16 = i15 - 1;
                this.k = new double[i15 + i7];
                int i17 = 2;
                while (true) {
                    i3 = this.n;
                    dArr2 = this.k;
                    if (i17 > i3) {
                        break;
                    }
                    dArr2[i17] = (((double) (this.nn - i17)) * this.p[i17]) / ((double) i3);
                    i17++;
                    i7 = i7;
                    dSqrt = dSqrt;
                    d3 = d3;
                }
                int i18 = i7;
                d2 = dSqrt;
                double d16 = d3;
                double[] dArr7 = this.p;
                dArr2[i18] = dArr7[i18];
                double d17 = dArr7[this.nn];
                double d18 = dArr7[i3];
                int i19 = dArr2[i3] == d ? i18 : 0;
                for (int i20 = i18; i20 <= 5; i20++) {
                    double d19 = this.k[this.n];
                    if (i19 != 0) {
                        for (int i21 = i18; i21 <= i16; i21++) {
                            int i22 = this.nn - i21;
                            double[] dArr8 = this.k;
                            dArr8[i22] = dArr8[i22 - 1];
                        }
                        double[] dArr9 = this.k;
                        dArr9[i18] = d;
                        i19 = dArr9[this.n] == d ? i18 : 0;
                    } else {
                        double d20 = (-d17) / d19;
                        int i23 = i18;
                        while (i23 <= i16) {
                            int i24 = this.nn - i23;
                            int i25 = i23;
                            double[] dArr10 = this.k;
                            dArr10[i24] = (dArr10[i24 - 1] * d20) + this.p[i24];
                            i23 = i25 + 1;
                        }
                        double[] dArr11 = this.k;
                        dArr11[i18] = this.p[i18];
                        if (Math.abs(dArr11[this.n]) <= Math.abs(d18) * 2.22E-16d * 10.0d) {
                        }
                    }
                }
                double[] dArr12 = new double[this.n + 1];
                for (int i26 = i18; i26 <= this.n; i26++) {
                    dArr12[i26] = this.k[i26];
                }
                int i27 = i18;
                d3 = d16;
                while (true) {
                    double d21 = d2;
                    double d22 = cosr;
                    double d23 = sinr;
                    d2 = (d22 * d21) - (d23 * d3);
                    d3 = (d22 * d3) + (d23 * d21);
                    double d24 = d13 * d2;
                    this.u = (-2.0d) * d24;
                    this.v = d13;
                    this.qp = new double[this.nn + 1];
                    this.qk = new double[this.n + 1];
                    int iFxshfr = fxshfr(i27 * 20, d24);
                    if (iFxshfr > 0) {
                        break;
                    }
                    int i28 = i18;
                    for (int i29 = i28; i29 <= this.n; i29++) {
                        this.k[i29] = dArr12[i29];
                    }
                    int i30 = i27 + 1;
                    if (i27 > 20) {
                        Types$$ExternalSyntheticBUOutline0.m$2("No convergence.");
                        return null;
                    }
                    i27 = i30;
                    i18 = i28;
                }
                this.qp = null;
                this.qk = null;
                i7 = i4;
                d4 = d;
                dSqrt = d2;
                i6 = 2;
            }
        }

        private GlobalEnvironment() {
        }
    }

    public static Complex[] findRoots(double[] dArr) {
        return new GlobalEnvironment(0).rpoly(dArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Complex[] quad(double d, double d2, double d3) {
        double dAbs;
        double dSqrt;
        double dAbs2;
        if (d == 0.0d && d2 == 0.0d) {
            return new Complex[]{new Complex(0.0d), new Complex(0.0d)};
        }
        if (d == 0.0d) {
            return new Complex[]{new Complex((-d3) / d2), new Complex(0.0d)};
        }
        if (d3 == 0.0d) {
            return new Complex[]{new Complex(0.0d), new Complex((-d2) / d)};
        }
        double d4 = d2 / 2.0d;
        if (Math.abs(d4) < Math.abs(d3)) {
            dAbs = ((d4 / Math.abs(d3)) * d4) - (d3 >= 0.0d ? d : -d);
            dSqrt = Math.sqrt(Math.abs(dAbs));
            dAbs2 = Math.sqrt(Math.abs(d3));
        } else {
            dAbs = 1.0d - ((d3 / d4) * (d / d4));
            dSqrt = Math.sqrt(Math.abs(dAbs));
            dAbs2 = Math.abs(d4);
        }
        double d5 = dAbs2 * dSqrt;
        if (dAbs < 0.0d) {
            Complex complex = new Complex((-d4) / d, Math.abs(d5 / d));
            return new Complex[]{complex, complex.conj()};
        }
        if (d4 >= 0.0d) {
            d5 = -d5;
        }
        double d6 = ((-d4) + d5) / d;
        return new Complex[]{new Complex(d6 != 0.0d ? (d3 / d6) / d : 0.0d), new Complex(d6)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void quadsd(int i, double d, double d2, double[] dArr, double[] dArr2, double[] dArr3) {
        double d3 = dArr[1];
        dArr2[1] = d3;
        double d4 = dArr[2] - (d * d3);
        dArr2[2] = d4;
        int i2 = 3;
        double d5 = d3;
        double d6 = d4;
        while (i2 <= i) {
            double d7 = (dArr[i2] - (d * d6)) - (d5 * d2);
            dArr2[i2] = d7;
            i2++;
            d5 = d6;
            d6 = d7;
        }
        dArr3[0] = d6;
        dArr3[1] = d5;
    }
}
