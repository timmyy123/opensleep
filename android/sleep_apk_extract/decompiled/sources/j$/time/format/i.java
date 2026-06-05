package j$.time.format;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public class i implements e {
    public static final long[] f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};
    public final j$.time.temporal.o a;
    public final int b;
    public final int c;
    public final e0 d;
    public final int e;

    public i(j$.time.temporal.o oVar, int i, int i2, e0 e0Var) {
        this.a = oVar;
        this.b = i;
        this.c = i2;
        this.d = e0Var;
        this.e = 0;
    }

    public boolean b(v vVar) {
        int i = this.e;
        if (i != -1) {
            return i > 0 && this.b == this.c && this.d == e0.NOT_NEGATIVE;
        }
        return true;
    }

    public int c(v vVar, long j, int i, int i2) {
        return vVar.f(this.a, j, i, i2);
    }

    public i d() {
        if (this.e == -1) {
            return this;
        }
        return new i(this.a, this.b, this.c, this.d, -1);
    }

    public i e(int i) {
        return new i(this.a, this.b, this.c, this.d, this.e + i);
    }

    @Override // j$.time.format.e
    public boolean o(x xVar, StringBuilder sb) {
        j$.time.temporal.o oVar = this.a;
        Long lA = xVar.a(oVar);
        if (lA == null) {
            return false;
        }
        long jA = a(xVar, lA.longValue());
        b0 b0Var = xVar.b.c;
        String string = jA == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jA));
        int length = string.length();
        int i = this.c;
        if (length > i) {
            throw new j$.time.c("Field " + oVar + " cannot be printed as the value " + jA + " exceeds the maximum print width of " + i);
        }
        b0Var.getClass();
        int i2 = this.b;
        e0 e0Var = this.d;
        if (jA >= 0) {
            int i3 = b.a[e0Var.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    sb.append('+');
                }
            } else if (i2 < 19 && jA >= f[i2]) {
                sb.append('+');
            }
        } else {
            int i4 = b.a[e0Var.ordinal()];
            if (i4 == 1 || i4 == 2 || i4 == 3) {
                sb.append('-');
            } else if (i4 == 4) {
                throw new j$.time.c("Field " + oVar + " cannot be printed as the value " + jA + " cannot be negative according to the SignStyle");
            }
        }
        for (int i5 = 0; i5 < i2 - string.length(); i5++) {
            sb.append('0');
        }
        sb.append(string);
        return true;
    }

    @Override // j$.time.format.e
    public int t(v vVar, CharSequence charSequence, int i) {
        int i2;
        boolean z;
        boolean z2;
        BigInteger bigIntegerAdd;
        boolean z3;
        boolean z4;
        int i3;
        long j;
        long j2;
        int i4;
        DateTimeFormatter dateTimeFormatter;
        boolean z5;
        int length = charSequence.length();
        if (i == length) {
            return ~i;
        }
        char cCharAt = charSequence.charAt(i);
        DateTimeFormatter dateTimeFormatter2 = vVar.a;
        dateTimeFormatter2.c.getClass();
        int i5 = this.c;
        e0 e0Var = this.d;
        int i6 = this.b;
        int i7 = 0;
        boolean z6 = true;
        if (cCharAt == '+') {
            boolean z7 = vVar.c;
            boolean z8 = i6 == i5;
            int iOrdinal = e0Var.ordinal();
            if (iOrdinal == 0 ? z7 : !(iOrdinal == 1 || iOrdinal == 4 || (!z7 && !z8))) {
                return ~i;
            }
            i2 = i + 1;
            z = false;
            z2 = true;
        } else {
            dateTimeFormatter2.c.getClass();
            if (cCharAt == '-') {
                boolean z9 = vVar.c;
                boolean z10 = i6 == i5;
                int iOrdinal2 = e0Var.ordinal();
                if (iOrdinal2 != 0 && iOrdinal2 != 1 && iOrdinal2 != 4 && (z9 || z10)) {
                    return ~i;
                }
                i2 = i + 1;
                z2 = false;
                z = true;
            } else {
                if (e0Var == e0.ALWAYS && vVar.c) {
                    return ~i;
                }
                i2 = i;
                z = false;
                z2 = false;
            }
        }
        int i8 = (vVar.c || b(vVar)) ? i6 : 1;
        int i9 = i2 + i8;
        if (i9 > length) {
            return ~i2;
        }
        if (!vVar.c && !b(vVar)) {
            i5 = 9;
        }
        int i10 = this.e;
        int iMax = Math.max(i10, 0) + i5;
        while (true) {
            bigIntegerAdd = null;
            if (i7 >= 2) {
                z3 = z;
                z4 = z2;
                i3 = i2;
                j = 0;
                break;
            }
            int iMin = Math.min(i2 + iMax, length);
            boolean z11 = z6;
            j2 = 0;
            i4 = i2;
            while (true) {
                if (i4 >= iMin) {
                    z3 = z;
                    break;
                }
                int i11 = i4 + 1;
                char cCharAt2 = charSequence.charAt(i4);
                dateTimeFormatter2.c.getClass();
                int i12 = cCharAt2 - '0';
                z3 = z;
                if (i12 < 0 || i12 > 9) {
                    i12 = -1;
                }
                if (i12 >= 0) {
                    if (i11 - i2 > 18) {
                        if (bigIntegerAdd == null) {
                            bigIntegerAdd = BigInteger.valueOf(j2);
                        }
                        dateTimeFormatter = dateTimeFormatter2;
                        z5 = z2;
                        bigIntegerAdd = bigIntegerAdd.multiply(BigInteger.TEN).add(BigInteger.valueOf(i12));
                    } else {
                        dateTimeFormatter = dateTimeFormatter2;
                        z5 = z2;
                        j2 = (j2 * 10) + ((long) i12);
                    }
                    i4 = i11;
                    z = z3;
                    dateTimeFormatter2 = dateTimeFormatter;
                    z2 = z5;
                } else if (i4 < i9) {
                    return ~i2;
                }
            }
            DateTimeFormatter dateTimeFormatter3 = dateTimeFormatter2;
            z4 = z2;
            if (i10 <= 0 || i7 != 0) {
                break;
            }
            int iMax2 = Math.max(i8, (i4 - i2) - i10);
            i7++;
            z6 = z11;
            z = z3;
            dateTimeFormatter2 = dateTimeFormatter3;
            z2 = z4;
            iMax = iMax2;
        }
        i3 = i4;
        j = j2;
        BigInteger bigIntegerDivide = bigIntegerAdd;
        if (z3) {
            if (bigIntegerDivide != null) {
                if (bigIntegerDivide.equals(BigInteger.ZERO) && vVar.c) {
                    return ~(i2 - 1);
                }
                bigIntegerDivide = bigIntegerDivide.negate();
            } else {
                if (j == 0 && vVar.c) {
                    return ~(i2 - 1);
                }
                j = -j;
            }
        } else if (e0Var == e0.EXCEEDS_PAD && vVar.c) {
            int i13 = i3 - i2;
            if (z4) {
                if (i13 <= i6) {
                    return ~(i2 - 1);
                }
            } else if (i13 > i6) {
                return ~i2;
            }
        }
        if (bigIntegerDivide == null) {
            return c(vVar, j, i2, i3);
        }
        if (bigIntegerDivide.bitLength() > 63) {
            bigIntegerDivide = bigIntegerDivide.divide(BigInteger.TEN);
            i3--;
        }
        return c(vVar, bigIntegerDivide.longValue(), i2, i3);
    }

    public String toString() {
        int i = this.c;
        j$.time.temporal.o oVar = this.a;
        e0 e0Var = this.d;
        int i2 = this.b;
        if (i2 == 1 && i == 19 && e0Var == e0.NORMAL) {
            return "Value(" + oVar + ")";
        }
        if (i2 == i && e0Var == e0.NOT_NEGATIVE) {
            return "Value(" + oVar + "," + i2 + ")";
        }
        return "Value(" + oVar + "," + i2 + "," + i + "," + e0Var + ")";
    }

    public i(j$.time.temporal.o oVar, int i, int i2, e0 e0Var, int i3) {
        this.a = oVar;
        this.b = i;
        this.c = i2;
        this.d = e0Var;
        this.e = i3;
    }

    public long a(x xVar, long j) {
        return j;
    }
}
