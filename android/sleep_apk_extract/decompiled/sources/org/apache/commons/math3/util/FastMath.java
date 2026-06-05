package org.apache.commons.math3.util;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FastMath {
    private static final double LOG_MAX_VALUE = StrictMath.log(Double.MAX_VALUE);
    private static final double[][] LN_QUICK_COEF = {new double[]{1.0d, 5.669184079525E-24d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.986821492305628E-8d}, new double[]{-0.25d, -6.663542893624021E-14d}, new double[]{0.19999998807907104d, 1.1921056801463227E-8d}, new double[]{-0.1666666567325592d, -7.800414592973399E-9d}, new double[]{0.1428571343421936d, 5.650007086920087E-9d}, new double[]{-0.12502530217170715d, -7.44321345601866E-11d}, new double[]{0.11113807559013367d, 9.219544613762692E-9d}};
    private static final double[][] LN_HI_PREC_COEF = {new double[]{1.0d, -6.032174644509064E-23d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.9868161777724352E-8d}, new double[]{-0.2499999701976776d, -2.957007209750105E-8d}, new double[]{0.19999954104423523d, 1.5830993332061267E-10d}, new double[]{-0.16624879837036133d, -2.6033824355191673E-8d}};
    private static final double[] SINE_TABLE_A = {0.0d, 0.1246747374534607d, 0.24740394949913025d, 0.366272509098053d, 0.4794255495071411d, 0.5850973129272461d, 0.6816387176513672d, 0.7675435543060303d, 0.8414709568023682d, 0.902267575263977d, 0.9489846229553223d, 0.9808930158615112d, 0.9974949359893799d, 0.9985313415527344d};
    private static final double[] SINE_TABLE_B = {0.0d, -4.068233003401932E-9d, 9.755392680573412E-9d, 1.9987994582857286E-8d, -1.0902938113007961E-8d, -3.9986783938944604E-8d, 4.23719669792332E-8d, -5.207000323380292E-8d, 2.800552834259E-8d, 1.883511811213715E-8d, -3.5997360512765566E-9d, 4.116164446561962E-8d, 5.0614674548127384E-8d, -1.0129027912496858E-9d};
    private static final double[] COSINE_TABLE_A = {1.0d, 0.9921976327896118d, 0.9689123630523682d, 0.9305076599121094d, 0.8775825500488281d, 0.8109631538391113d, 0.7316888570785522d, 0.6409968137741089d, 0.5403022766113281d, 0.4311765432357788d, 0.3153223395347595d, 0.19454771280288696d, 0.07073719799518585d, -0.05417713522911072d};
    private static final double[] COSINE_TABLE_B = {0.0d, 3.4439717236742845E-8d, 5.865827662008209E-8d, -3.7999795083850525E-8d, 1.184154459111628E-8d, -3.43338934259355E-8d, 1.1795268640216787E-8d, 4.438921624363781E-8d, 2.925681159240093E-8d, -2.6437112632041807E-8d, 2.2860509143963117E-8d, -4.813899778443457E-9d, 3.6725170580355583E-9d, 2.0217439756338078E-10d};
    private static final double[] TANGENT_TABLE_A = {0.0d, 0.1256551444530487d, 0.25534194707870483d, 0.3936265707015991d, 0.5463024377822876d, 0.7214844226837158d, 0.9315965175628662d, 1.1974215507507324d, 1.5574076175689697d, 2.092571258544922d, 3.0095696449279785d, 5.041914939880371d, 14.101419448852539d, -18.430862426757812d};
    private static final double[] TANGENT_TABLE_B = {0.0d, -7.877917738262007E-9d, -2.5857668567479893E-8d, 5.2240336371356666E-9d, 5.206150291559893E-8d, 1.8307188599677033E-8d, -5.7618793749770706E-8d, 7.848361555046424E-8d, 1.0708593250394448E-7d, 1.7827257129423813E-8d, 2.893485277253286E-8d, 3.1660099222737955E-7d, 4.983191803254889E-7d, -3.356118100840571E-7d};
    private static final long[] RECIP_2PI = {2935890503282001226L, 9154082963658192752L, 3952090531849364496L, 9193070505571053912L, 7910884519577875640L, 113236205062349959L, 4577762542105553359L, -5034868814120038111L, 4208363204685324176L, 5648769086999809661L, 2819561105158720014L, -4035746434778044925L, -302932621132653753L, -2644281811660520851L, -3183605296591799669L, 6722166367014452318L, -3512299194304650054L, -7278142539171889152L};
    private static final long[] PI_O_4_BITS = {-3958705157555305932L, -4267615245585081135L};
    private static final double[] EIGHTHS = {0.0d, 0.125d, 0.25d, 0.375d, 0.5d, 0.625d, 0.75d, 0.875d, 1.0d, 1.125d, 1.25d, 1.375d, 1.5d, 1.625d};
    private static final double[] CBRTTWO = {0.6299605249474366d, 0.7937005259840998d, 1.0d, 1.2599210498948732d, 1.5874010519681994d};

    public static class CodyWaite {
        private final int finalK;
        private final double finalRemA;
        private final double finalRemB;

        public CodyWaite(double d) {
            int i = (int) (0.6366197723675814d * d);
            while (true) {
                double d2 = -i;
                double d3 = 1.570796251296997d * d2;
                double d4 = d + d3;
                double d5 = 7.549789948768648E-8d * d2;
                double d6 = d5 + d4;
                double d7 = (-((d4 - d) - d3)) + (-((d6 - d4) - d5));
                double d8 = d2 * 6.123233995736766E-17d;
                double d9 = d8 + d6;
                double d10 = d7 + (-((d9 - d6) - d8));
                if (d9 > 0.0d) {
                    this.finalK = i;
                    this.finalRemA = d9;
                    this.finalRemB = d10;
                    return;
                }
                i--;
            }
        }

        public int getK() {
            return this.finalK;
        }

        public double getRemA() {
            return this.finalRemA;
        }

        public double getRemB() {
            return this.finalRemB;
        }
    }

    public static class ExpFracTable {
        private static final double[] EXP_FRAC_TABLE_A = FastMathLiteralArrays.loadExpFracA();
        private static final double[] EXP_FRAC_TABLE_B = FastMathLiteralArrays.loadExpFracB();
    }

    public static class ExpIntTable {
        private static final double[] EXP_INT_TABLE_A = FastMathLiteralArrays.loadExpIntA();
        private static final double[] EXP_INT_TABLE_B = FastMathLiteralArrays.loadExpIntB();
    }

    public static class lnMant {
        private static final double[][] LN_MANT = FastMathLiteralArrays.loadLnMant();
    }

    public static double abs(double d) {
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d) & Long.MAX_VALUE);
    }

    public static double ceil(double d) {
        if (d != d) {
            return d;
        }
        double dFloor = floor(d);
        if (dFloor == d) {
            return dFloor;
        }
        double d2 = dFloor + 1.0d;
        return d2 == 0.0d ? d * d2 : d2;
    }

    public static double cos(double d) {
        double dSinQ;
        double remB = 0.0d;
        if (d < 0.0d) {
            d = -d;
        }
        if (d != d || d == Double.POSITIVE_INFINITY) {
            return Double.NaN;
        }
        int k = 0;
        if (d > 3294198.0d) {
            double[] dArr = new double[3];
            reducePayneHanek(d, dArr);
            k = ((int) dArr[0]) & 3;
            d = dArr[1];
            remB = dArr[2];
        } else if (d > 1.5707963267948966d) {
            CodyWaite codyWaite = new CodyWaite(d);
            k = codyWaite.getK() & 3;
            d = codyWaite.getRemA();
            remB = codyWaite.getRemB();
        }
        if (k == 0) {
            return cosQ(d, remB);
        }
        if (k == 1) {
            dSinQ = sinQ(d, remB);
        } else {
            if (k != 2) {
                if (k != 3) {
                    return Double.NaN;
                }
                return sinQ(d, remB);
            }
            dSinQ = cosQ(d, remB);
        }
        return -dSinQ;
    }

    private static double cosQ(double d, double d2) {
        double d3 = 1.5707963267948966d - d;
        return sinQ(d3, (6.123233995736766E-17d - d2) + (-((d3 - 1.5707963267948966d) + d)));
    }

    private static double exp(double d, double d2, double[] dArr) {
        double d3;
        int i = (int) d;
        if (d < 0.0d) {
            if (d < -746.0d) {
                if (dArr != null) {
                    dArr[0] = 0.0d;
                    dArr[1] = 0.0d;
                }
                return 0.0d;
            }
            if (i < -709) {
                double dExp = exp(d + 40.19140625d, d2, dArr) / 2.8504009514401178E17d;
                if (dArr != null) {
                    dArr[0] = dArr[0] / 2.8504009514401178E17d;
                    dArr[1] = dArr[1] / 2.8504009514401178E17d;
                }
                return dExp;
            }
            if (i == -709) {
                double dExp2 = exp(d + 1.494140625d, d2, dArr) / 4.455505956692757d;
                if (dArr != null) {
                    dArr[0] = dArr[0] / 4.455505956692757d;
                    dArr[1] = dArr[1] / 4.455505956692757d;
                }
                return dExp2;
            }
            i--;
        } else if (i > 709) {
            if (dArr != null) {
                dArr[0] = Double.POSITIVE_INFINITY;
                dArr[1] = 0.0d;
            }
            return Double.POSITIVE_INFINITY;
        }
        int i2 = i + 750;
        double d4 = ExpIntTable.EXP_INT_TABLE_A[i2];
        double d5 = ExpIntTable.EXP_INT_TABLE_B[i2];
        double d6 = i;
        int i3 = (int) ((d - d6) * 1024.0d);
        double d7 = ExpFracTable.EXP_FRAC_TABLE_A[i3];
        double d8 = ExpFracTable.EXP_FRAC_TABLE_B[i3];
        double d9 = d - ((((double) i3) / 1024.0d) + d6);
        double d10 = (((((((0.04168701738764507d * d9) + 0.1666666505023083d) * d9) + 0.5000000000042687d) * d9) + 1.0d) * d9) - 3.940510424527919E-20d;
        double d11 = d4 * d7;
        double d12 = (d5 * d8) + (d7 * d5) + (d4 * d8);
        double d13 = d12 + d11;
        if (d2 != 0.0d) {
            double d14 = d13 * d2;
            d3 = (d13 * d10) + (d14 * d10) + d14;
        } else {
            d3 = d13 * d10;
        }
        double d15 = d3 + d12 + d11;
        if (dArr != null) {
            dArr[0] = d11;
            double d16 = d13 * d2;
            dArr[1] = (d13 * d10) + (d16 * d10) + d16 + d12;
        }
        return d15;
    }

    public static double floor(double d) {
        if (d != d || d >= 4.503599627370496E15d || d <= -4.503599627370496E15d) {
            return d;
        }
        long j = (long) d;
        if (d < 0.0d && j != d) {
            j--;
        }
        return j == 0 ? d * j : j;
    }

    private static double log(double d, double[] dArr) {
        double d2;
        double d3;
        if (d != 0.0d) {
            long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
            if (((Long.MIN_VALUE & jDoubleToRawLongBits) != 0 || d != d) && d != 0.0d) {
                if (dArr != null) {
                    dArr[0] = Double.NaN;
                }
                return Double.NaN;
            }
            if (d == Double.POSITIVE_INFINITY) {
                if (dArr != null) {
                    dArr[0] = Double.POSITIVE_INFINITY;
                }
                return Double.POSITIVE_INFINITY;
            }
            int i = ((int) (jDoubleToRawLongBits >> 52)) - 1023;
            if ((9218868437227405312L & jDoubleToRawLongBits) == 0) {
                if (d != 0.0d) {
                    jDoubleToRawLongBits <<= 1;
                    while ((4503599627370496L & jDoubleToRawLongBits) == 0) {
                        i--;
                        jDoubleToRawLongBits <<= 1;
                    }
                } else if (dArr != null) {
                    dArr[0] = Double.NEGATIVE_INFINITY;
                }
            }
            if ((i == -1 || i == 0) && d < 1.01d && d > 0.99d && dArr == null) {
                double d4 = d - 1.0d;
                double d5 = d4 * 1.073741824E9d;
                double d6 = (d4 + d5) - d5;
                double d7 = d4 - d6;
                double[][] dArr2 = LN_QUICK_COEF;
                double[] dArr3 = dArr2[dArr2.length - 1];
                double d8 = dArr3[0];
                double d9 = dArr3[1];
                for (int length = dArr2.length - 2; length >= 0; length--) {
                    double d10 = d8 * d6;
                    double d11 = (d9 * d7) + (d9 * d6) + (d8 * d7);
                    double d12 = d10 * 1.073741824E9d;
                    double d13 = (d10 + d12) - d12;
                    double d14 = (d10 - d13) + d11;
                    double[] dArr4 = LN_QUICK_COEF[length];
                    double d15 = d13 + dArr4[0];
                    double d16 = d15 * 1.073741824E9d;
                    d8 = (d15 + d16) - d16;
                    d9 = (d15 - d8) + d14 + dArr4[1];
                }
                double d17 = d8 * d6;
                double d18 = (d9 * d7) + (d6 * d9) + (d8 * d7);
                double d19 = 1.073741824E9d * d17;
                double d20 = (d17 + d19) - d19;
                return (d17 - d20) + d18 + d20;
            }
            long j = 4499201580859392L & jDoubleToRawLongBits;
            double[] dArr5 = lnMant.LN_MANT[(int) (j >> 42)];
            double d21 = jDoubleToRawLongBits & 4398046511103L;
            double d22 = j + 4.503599627370496E15d;
            double d23 = d21 / d22;
            if (dArr != null) {
                double d24 = d23 * 1.073741824E9d;
                double d25 = (d23 + d24) - d24;
                double d26 = d23 - d25;
                double d27 = (((d21 - (d25 * d22)) - (d26 * d22)) / d22) + d26;
                double[][] dArr6 = LN_HI_PREC_COEF;
                double[] dArr7 = dArr6[dArr6.length - 1];
                double d28 = dArr7[0];
                double d29 = dArr7[1];
                for (int length2 = dArr6.length - 2; length2 >= 0; length2--) {
                    double d30 = d28 * d25;
                    double d31 = (d29 * d27) + (d29 * d25) + (d28 * d27);
                    double d32 = d30 * 1.073741824E9d;
                    double d33 = (d30 + d32) - d32;
                    double d34 = (d30 - d33) + d31;
                    double[] dArr8 = LN_HI_PREC_COEF[length2];
                    double d35 = d33 + dArr8[0];
                    double d36 = d35 * 1.073741824E9d;
                    d28 = (d35 + d36) - d36;
                    d29 = (d35 - d28) + d34 + dArr8[1];
                }
                double d37 = d28 * d25;
                double d38 = (d29 * d27) + (d25 * d29) + (d28 * d27);
                d2 = d37 + d38;
                d3 = -((d2 - d37) - d38);
            } else {
                d2 = (((((((((((-0.16624882440418567d) * d23) + 0.19999954120254515d) * d23) - 0.2499999997677497d) * d23) + 0.3333333333332802d) * d23) - 0.5d) * d23) + 1.0d) * d23;
                d3 = 0.0d;
            }
            double d39 = i;
            double d40 = 0.6931470632553101d * d39;
            double d41 = dArr5[0];
            double d42 = d40 + d41;
            double d43 = (-((d42 - d40) - d41)) + 0.0d;
            double d44 = d42 + d2;
            double d45 = d43 + (-((d44 - d42) - d2));
            double d46 = d39 * 1.1730463525082348E-7d;
            double d47 = d44 + d46;
            double d48 = d45 + (-((d47 - d44) - d46));
            double d49 = dArr5[1];
            double d50 = d47 + d49;
            double d51 = d48 + (-((d50 - d47) - d49));
            double d52 = d50 + d3;
            double d53 = d51 + (-((d52 - d50) - d3));
            if (dArr != null) {
                dArr[0] = d52;
                dArr[1] = d53;
            }
            return d52 + d53;
        }
        return Double.NEGATIVE_INFINITY;
    }

    public static double max(double d, double d2) {
        if (d <= d2) {
            if (d >= d2) {
                if (d != d2) {
                    return Double.NaN;
                }
                if (Double.doubleToRawLongBits(d) == Long.MIN_VALUE) {
                }
            }
            return d2;
        }
        return d;
    }

    public static double min(double d, double d2) {
        if (d <= d2) {
            if (d >= d2) {
                if (d != d2) {
                    return Double.NaN;
                }
                if (Double.doubleToRawLongBits(d) == Long.MIN_VALUE) {
                }
            }
            return d;
        }
        return d2;
    }

    private static double polyCosine(double d) {
        return ((((((2.479773539153719E-5d * r4) - 0.0013888888689039883d) * r4) + 0.041666666666621166d) * r4) - 0.49999999999999994d) * d * d;
    }

    private static double polySine(double d) {
        return ((((((2.7553817452272217E-6d * r0) - 1.9841269659586505E-4d) * r0) + 0.008333333333329196d) * r0) - 0.16666666666666666d) * d * d * d;
    }

    private static void reducePayneHanek(double d, double[] dArr) {
        long j;
        long j2;
        long j3;
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        int i = ((int) ((jDoubleToRawLongBits >> 52) & 2047)) - 1022;
        long j4 = ((jDoubleToRawLongBits & 4503599627370495L) | 4503599627370496L) << 11;
        int i2 = i >> 6;
        int i3 = i - (i2 << 6);
        if (i3 != 0) {
            long j5 = i2 == 0 ? 0L : RECIP_2PI[i2 - 1] << i3;
            long[] jArr = RECIP_2PI;
            long j6 = jArr[i2];
            int i4 = 64 - i3;
            j = j5 | (j6 >>> i4);
            long j7 = jArr[i2 + 1];
            j2 = (j6 << i3) | (j7 >>> i4);
            j3 = (jArr[i2 + 2] >>> i4) | (j7 << i3);
        } else {
            j = i2 == 0 ? 0L : RECIP_2PI[i2 - 1];
            long[] jArr2 = RECIP_2PI;
            j2 = jArr2[i2];
            j3 = jArr2[i2 + 1];
        }
        long j8 = j4 >>> 32;
        long j9 = j4 & 4294967295L;
        long j10 = j2 >>> 32;
        long j11 = j2 & 4294967295L;
        long j12 = j8 * j10;
        long j13 = j9 * j11;
        long j14 = j10 * j9;
        long j15 = j11 * j8;
        long j16 = j13 + (j15 << 32);
        long j17 = j12 + (j15 >>> 32);
        boolean z = (j13 & Long.MIN_VALUE) != 0;
        boolean z2 = (j15 & 2147483648L) != 0;
        long j18 = j16 & Long.MIN_VALUE;
        boolean z3 = j18 != 0;
        if ((z && z2) || ((z || z2) && !z3)) {
            j17++;
        }
        boolean z4 = j18 != 0;
        boolean z5 = (j14 & 2147483648L) != 0;
        long j19 = j16 + (j14 << 32);
        long j20 = j17 + (j14 >>> 32);
        long j21 = j19 & Long.MIN_VALUE;
        boolean z6 = j21 != 0;
        if ((z4 && z5) || ((z4 || z5) && !z6)) {
            j20++;
        }
        long j22 = j3 >>> 32;
        long j23 = (j8 * j22) + ((((j3 & 4294967295L) * j8) + (j22 * j9)) >>> 32);
        boolean z7 = j21 != 0;
        boolean z8 = (j23 & Long.MIN_VALUE) != 0;
        long j24 = j19 + j23;
        boolean z9 = (j24 & Long.MIN_VALUE) != 0;
        if ((z7 && z8) || ((z7 || z8) && !z9)) {
            j20++;
        }
        long j25 = j >>> 32;
        long j26 = j & 4294967295L;
        long j27 = (j9 * j26) + (((j8 * j26) + (j9 * j25)) << 32) + j20;
        int i5 = (int) (j27 >>> 62);
        long j28 = (j27 << 2) | (j24 >>> 62);
        long j29 = j24 << 2;
        long j30 = j28 >>> 32;
        long j31 = j28 & 4294967295L;
        long[] jArr3 = PI_O_4_BITS;
        long j32 = jArr3[0];
        long j33 = j32 >>> 32;
        long j34 = j32 & 4294967295L;
        long j35 = j30 * j33;
        long j36 = j31 * j34;
        long j37 = j33 * j31;
        long j38 = j34 * j30;
        long j39 = j36 + (j38 << 32);
        long j40 = j35 + (j38 >>> 32);
        boolean z10 = (j36 & Long.MIN_VALUE) != 0;
        boolean z11 = (j38 & 2147483648L) != 0;
        long j41 = j39 & Long.MIN_VALUE;
        boolean z12 = j41 != 0;
        if ((z10 && z11) || ((z10 || z11) && !z12)) {
            j40++;
        }
        boolean z13 = j41 != 0;
        boolean z14 = (j37 & 2147483648L) != 0;
        long j42 = j39 + (j37 << 32);
        long j43 = j40 + (j37 >>> 32);
        long j44 = j42 & Long.MIN_VALUE;
        boolean z15 = j44 != 0;
        if ((z13 && z14) || ((z13 || z14) && !z15)) {
            j43++;
        }
        long j45 = jArr3[1];
        long j46 = j45 >>> 32;
        long j47 = (j30 * j46) + (((j30 * (j45 & 4294967295L)) + (j31 * j46)) >>> 32);
        boolean z16 = j44 != 0;
        boolean z17 = (j47 & Long.MIN_VALUE) != 0;
        long j48 = j42 + j47;
        long j49 = j48 & Long.MIN_VALUE;
        boolean z18 = j49 != 0;
        if ((z16 && z17) || ((z16 || z17) && !z18)) {
            j43++;
        }
        long j50 = j29 >>> 32;
        long j51 = j32 >>> 32;
        long j52 = (j50 * j51) + (((j50 * (j32 & 4294967295L)) + ((j29 & 4294967295L) * j51)) >>> 32);
        boolean z19 = j49 != 0;
        boolean z20 = (j52 & Long.MIN_VALUE) != 0;
        boolean z21 = ((j48 + j52) & Long.MIN_VALUE) != 0;
        if ((z19 && z20) || ((z19 || z20) && !z21)) {
            j43++;
        }
        double d2 = (j43 >>> 12) / 4.503599627370496E15d;
        double d3 = ((((j43 & 4095) << 40) + (r34 >>> 24)) / 4.503599627370496E15d) / 4.503599627370496E15d;
        double d4 = d2 + d3;
        dArr[0] = i5;
        dArr[1] = d4 * 2.0d;
        dArr[2] = (-((d4 - d2) - d3)) * 2.0d;
    }

    public static double rint(double d) {
        double dFloor = floor(d);
        double d2 = d - dFloor;
        if (d2 <= 0.5d) {
            return (d2 >= 0.5d && (((long) dFloor) & 1) != 0) ? dFloor + 1.0d : dFloor;
        }
        if (dFloor == -1.0d) {
            return -0.0d;
        }
        return dFloor + 1.0d;
    }

    public static double sin(double d) {
        double remA;
        boolean z;
        double dSinQ;
        double remB = 0.0d;
        int k = 0;
        if (d < 0.0d) {
            remA = -d;
            z = true;
        } else {
            remA = d;
            z = false;
        }
        if (remA == 0.0d) {
            return Double.doubleToRawLongBits(d) < 0 ? -0.0d : 0.0d;
        }
        if (remA != remA || remA == Double.POSITIVE_INFINITY) {
            return Double.NaN;
        }
        if (remA > 3294198.0d) {
            double[] dArr = new double[3];
            reducePayneHanek(remA, dArr);
            k = ((int) dArr[0]) & 3;
            remA = dArr[1];
            remB = dArr[2];
        } else if (remA > 1.5707963267948966d) {
            CodyWaite codyWaite = new CodyWaite(remA);
            k = codyWaite.getK() & 3;
            remA = codyWaite.getRemA();
            remB = codyWaite.getRemB();
        }
        if (z) {
            k ^= 2;
        }
        if (k == 0) {
            return sinQ(remA, remB);
        }
        if (k == 1) {
            return cosQ(remA, remB);
        }
        if (k == 2) {
            dSinQ = sinQ(remA, remB);
        } else {
            if (k != 3) {
                return Double.NaN;
            }
            dSinQ = cosQ(remA, remB);
        }
        return -dSinQ;
    }

    private static double sinQ(double d, double d2) {
        int i = (int) ((8.0d * d) + 0.5d);
        double d3 = d - EIGHTHS[i];
        double d4 = SINE_TABLE_A[i];
        double d5 = SINE_TABLE_B[i];
        double d6 = COSINE_TABLE_A[i];
        double d7 = COSINE_TABLE_B[i];
        double dPolySine = polySine(d3);
        double dPolyCosine = polyCosine(d3);
        double d8 = 1.073741824E9d * d3;
        double d9 = (d3 + d8) - d8;
        double d10 = (d3 - d9) + dPolySine;
        double d11 = d4 + 0.0d;
        double d12 = d6 * d9;
        double d13 = d11 + d12;
        double d14 = d6 * d10;
        double d15 = (d7 * d10) + (d5 * dPolyCosine) + (d7 * d9) + d14 + (d4 * dPolyCosine) + (-((d11 - 0.0d) - d4)) + 0.0d + (-((d13 - d11) - d12)) + d5;
        if (d2 != 0.0d) {
            double d16 = (((dPolyCosine + 1.0d) * (d6 + d7)) - ((d9 + d10) * (d4 + d5))) * d2;
            double d17 = d13 + d16;
            d15 += -((d17 - d13) - d16);
            d13 = d17;
        }
        return d13 + d15;
    }

    public static double sqrt(double d) {
        return Math.sqrt(d);
    }

    public static long abs(long j) {
        long j2 = j >>> 63;
        return (j ^ ((~j2) + 1)) + j2;
    }

    public static int abs(int i) {
        int i2 = i >>> 31;
        return (i ^ ((~i2) + 1)) + i2;
    }

    public static int max(int i, int i2) {
        return i <= i2 ? i2 : i;
    }

    public static long min(long j, long j2) {
        return j <= j2 ? j : j2;
    }

    public static int min(int i, int i2) {
        return i <= i2 ? i : i2;
    }

    public static double exp(double d) {
        return exp(d, 0.0d, null);
    }

    public static double log(double d) {
        return log(d, null);
    }
}
