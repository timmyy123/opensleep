package j$.time;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class LocalDate implements Temporal, j$.time.temporal.m, j$.time.chrono.b, Serializable {
    public static final LocalDate d = of(-999999999, 1, 1);
    public static final LocalDate e = of(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;
    public final int a;
    public final short b;
    public final short c;

    static {
        of(1970, 1, 1);
    }

    public LocalDate(int i, int i2, int i3) {
        this.a = i;
        this.b = (short) i2;
        this.c = (short) i3;
    }

    public static LocalDate N(a aVar) {
        Instant instantOfEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneId zoneId = aVar.a;
        Objects.requireNonNull(instantOfEpochMilli, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return O(Math.floorDiv(instantOfEpochMilli.getEpochSecond() + ((long) zoneId.getRules().getOffset(instantOfEpochMilli).getTotalSeconds()), 86400L));
    }

    public static LocalDate O(long j) {
        long j2;
        j$.time.temporal.a.EPOCH_DAY.I(j);
        long j3 = 719468 + j;
        if (j3 < 0) {
            long j4 = ((j + 719469) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        int i3 = ((i2 + 2) % 12) + 1;
        int i4 = (i - (((i2 * 306) + 5) / 10)) + 1;
        long j7 = j5 + j2 + ((long) (i2 / 10));
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return new LocalDate(aVar.b.a(j7, aVar), i3, i4);
    }

    public static LocalDate P(int i, int i2) {
        long j = i;
        j$.time.temporal.a.YEAR.I(j);
        j$.time.temporal.a.DAY_OF_YEAR.I(i2);
        boolean zIsLeapYear = j$.time.chrono.r.c.isLeapYear(j);
        if (i2 == 366 && !zIsLeapYear) {
            g.c("Invalid date 'DayOfYear 366' as '", i, "' is not a leap year");
            return null;
        }
        k kVarC = k.C(((i2 - 1) / 31) + 1);
        if (i2 > (kVarC.t(zIsLeapYear) + kVarC.o(zIsLeapYear)) - 1) {
            kVarC = k.a[(kVarC.ordinal() + 13) % 12];
        }
        return new LocalDate(i, kVarC.getValue(), (i2 - kVarC.o(zIsLeapYear)) + 1);
    }

    public static LocalDate V(int i, int i2, int i3) {
        if (i2 == 2) {
            i3 = Math.min(i3, j$.time.chrono.r.c.isLeapYear((long) i) ? 29 : 28);
        } else if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = Math.min(i3, 30);
        }
        return new LocalDate(i, i2, i3);
    }

    public static LocalDate of(int i, int i2, int i3) {
        j$.time.temporal.a.YEAR.I(i);
        j$.time.temporal.a.MONTH_OF_YEAR.I(i2);
        j$.time.temporal.a.DAY_OF_MONTH.I(i3);
        return t(i, i2, i3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static LocalDate t(int i, int i2, int i3) {
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else if (j$.time.chrono.r.c.isLeapYear(i)) {
                i4 = 29;
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    g.c("Invalid date 'February 29' as '", i, "' is not a leap year");
                    return null;
                }
                throw new c("Invalid date '" + k.C(i2).name() + " " + i3 + "'");
            }
        }
        return new LocalDate(i, i2, i3);
    }

    private Object writeReplace() {
        return new o((byte) 3, this);
    }

    public static LocalDate x(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalDate localDate = (LocalDate) temporalAccessor.d(j$.time.temporal.p.f);
        if (localDate != null) {
            return localDate;
        }
        g.f("Unable to obtain LocalDate from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    public final int C(j$.time.temporal.o oVar) {
        switch (f.a[((j$.time.temporal.a) oVar).ordinal()]) {
            case 1:
                return this.c;
            case 2:
                return I();
            case 3:
                return ((this.c - 1) / 7) + 1;
            case 4:
                int i = this.a;
                return i >= 1 ? i : 1 - i;
            case 5:
                return H().getValue();
            case 6:
                return ((this.c - 1) % 7) + 1;
            case 7:
                return ((I() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.r("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((I() - 1) / 7) + 1;
            case 10:
                return this.b;
            case 11:
                throw new j$.time.temporal.r("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.a;
            case 13:
                return this.a >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.r(d.a("Unsupported field: ", oVar));
        }
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.b D(TemporalAmount temporalAmount) {
        if (temporalAmount != null) {
            return S(((Period) temporalAmount).b()).R(r3.getDays());
        }
        Objects.requireNonNull(temporalAmount, "amountToAdd");
        return (LocalDate) ((Period) temporalAmount).o(this);
    }

    @Override // j$.time.chrono.b, java.lang.Comparable
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.b bVar) {
        return bVar instanceof LocalDate ? o((LocalDate) bVar) : super.compareTo(bVar);
    }

    public final DayOfWeek H() {
        return DayOfWeek.of(((int) Math.floorMod(toEpochDay() + 3, 7L)) + 1);
    }

    public final int I() {
        return (k.C(this.b).o(isLeapYear()) + this.c) - 1;
    }

    public final long J() {
        return ((((long) this.a) * 12) + ((long) this.b)) - 1;
    }

    public final boolean K(j$.time.chrono.b bVar) {
        return bVar instanceof LocalDate ? o((LocalDate) bVar) < 0 : toEpochDay() < bVar.toEpochDay();
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final LocalDate c(long j, j$.time.temporal.q qVar) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = b(Long.MAX_VALUE, qVar);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.b(j2, qVar);
    }

    public final long M(LocalDate localDate) {
        return (((localDate.J() * 32) + ((long) localDate.getDayOfMonth())) - ((J() * 32) + ((long) getDayOfMonth()))) / 32;
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final LocalDate b(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.b)) {
            return (LocalDate) qVar.t(this, j);
        }
        switch (f.b[((j$.time.temporal.b) qVar).ordinal()]) {
            case 1:
                return R(j);
            case 2:
                return T(j);
            case 3:
                return S(j);
            case 4:
                return U(j);
            case 5:
                return U(Math.multiplyExact(j, 10L));
            case 6:
                return U(Math.multiplyExact(j, 100L));
            case 7:
                return U(Math.multiplyExact(j, 1000L));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return a(Math.addExact(i(aVar), j), aVar);
            default:
                g.d("Unsupported unit: ", qVar);
                return null;
        }
    }

    public final LocalDate R(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = ((long) this.c) + j;
        if (j2 > 0) {
            if (j2 <= 28) {
                return new LocalDate(this.a, this.b, (int) j2);
            }
            if (j2 <= 59) {
                long jLengthOfMonth = lengthOfMonth();
                if (j2 <= jLengthOfMonth) {
                    return new LocalDate(this.a, this.b, (int) j2);
                }
                short s = this.b;
                if (s < 12) {
                    return new LocalDate(this.a, s + 1, (int) (j2 - jLengthOfMonth));
                }
                j$.time.temporal.a.YEAR.I(this.a + 1);
                return new LocalDate(this.a + 1, 1, (int) (j2 - jLengthOfMonth));
            }
        }
        return O(Math.addExact(toEpochDay(), j));
    }

    public final LocalDate S(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.a) * 12) + ((long) (this.b - 1)) + j;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return V(aVar.b.a(Math.floorDiv(j2, 12L), aVar), ((int) Math.floorMod(j2, 12L)) + 1, this.c);
    }

    public final LocalDate T(long j) {
        return R(Math.multiplyExact(j, 7L));
    }

    public final LocalDate U(long j) {
        if (j == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return V(aVar.b.a(((long) this.a) + j, aVar), this.b, this.c);
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final LocalDate a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return (LocalDate) oVar.H(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        aVar.I(j);
        switch (f.a[aVar.ordinal()]) {
            case 1:
                int i = (int) j;
                if (this.c != i) {
                    return of(this.a, this.b, i);
                }
                return this;
            case 2:
                int i2 = (int) j;
                if (I() != i2) {
                    return P(this.a, i2);
                }
                return this;
            case 3:
                return T(j - i(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.a < 1) {
                    j = 1 - j;
                }
                return Y((int) j);
            case 5:
                return R(j - ((long) H().getValue()));
            case 6:
                return R(j - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return R(j - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return O(j);
            case 9:
                return T(j - i(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
            case 10:
                int i3 = (int) j;
                if (this.b != i3) {
                    j$.time.temporal.a.MONTH_OF_YEAR.I(i3);
                    return V(this.a, i3, this.c);
                }
                return this;
            case 11:
                return S(j - J());
            case 12:
                return Y((int) j);
            case 13:
                if (i(j$.time.temporal.a.ERA) != j) {
                    return Y(1 - this.a);
                }
                return this;
            default:
                throw new j$.time.temporal.r(d.a("Unsupported field: ", oVar));
        }
    }

    @Override // j$.time.chrono.b
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final LocalDate k(j$.time.temporal.m mVar) {
        return mVar instanceof LocalDate ? (LocalDate) mVar : (LocalDate) mVar.f(this);
    }

    public final LocalDate Y(int i) {
        if (this.a == i) {
            return this;
        }
        j$.time.temporal.a.YEAR.I(i);
        return V(i, this.b, this.c);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object d(s sVar) {
        return sVar == j$.time.temporal.p.f ? this : super.d(sVar);
    }

    @Override // j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && o((LocalDate) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? C(oVar) : super.g(oVar);
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.k getChronology() {
        return j$.time.chrono.r.c;
    }

    public int getDayOfMonth() {
        return this.c;
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.l getEra() {
        return getYear() >= 1 ? j$.time.chrono.s.CE : j$.time.chrono.s.BCE;
    }

    public int getMonthValue() {
        return this.b;
    }

    public int getYear() {
        return this.a;
    }

    @Override // j$.time.chrono.b
    public final int hashCode() {
        int i = this.a;
        return (i & (-2048)) ^ (((i << 11) + (this.b << 6)) + this.c);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.EPOCH_DAY ? toEpochDay() : oVar == j$.time.temporal.a.PROLEPTIC_MONTH ? J() : C(oVar) : oVar.C(this);
    }

    @Override // j$.time.chrono.b
    public final boolean isLeapYear() {
        return j$.time.chrono.r.c.isLeapYear(this.a);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s j(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar.t(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        if (!aVar.isDateBased()) {
            throw new j$.time.temporal.r(d.a("Unsupported field: ", oVar));
        }
        int i = f.a[aVar.ordinal()];
        if (i == 1) {
            return j$.time.temporal.s.f(1L, lengthOfMonth());
        }
        if (i == 2) {
            return j$.time.temporal.s.f(1L, lengthOfYear());
        }
        if (i != 3) {
            return i != 4 ? aVar.b : getYear() <= 0 ? j$.time.temporal.s.f(1L, 1000000000L) : j$.time.temporal.s.f(1L, 999999999L);
        }
        return j$.time.temporal.s.f(1L, (k.C(this.b) != k.FEBRUARY || isLeapYear()) ? 5L : 4L);
    }

    @Override // j$.time.temporal.Temporal
    public final long l(Temporal temporal, j$.time.temporal.q qVar) {
        LocalDate localDateX = x(temporal);
        if (!(qVar instanceof j$.time.temporal.b)) {
            return qVar.o(this, localDateX);
        }
        switch (f.b[((j$.time.temporal.b) qVar).ordinal()]) {
            case 1:
                return localDateX.toEpochDay() - toEpochDay();
            case 2:
                return (localDateX.toEpochDay() - toEpochDay()) / 7;
            case 3:
                return M(localDateX);
            case 4:
                return M(localDateX) / 12;
            case 5:
                return M(localDateX) / 120;
            case 6:
                return M(localDateX) / 1200;
            case 7:
                return M(localDateX) / 12000;
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return localDateX.i(aVar) - i(aVar);
            default:
                g.d("Unsupported unit: ", qVar);
                return 0L;
        }
    }

    public final int lengthOfMonth() {
        short s = this.b;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : isLeapYear() ? 29 : 28;
    }

    @Override // j$.time.chrono.b
    public final int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public final int o(LocalDate localDate) {
        int i = this.a - localDate.a;
        return (i == 0 && (i = this.b - localDate.b) == 0) ? this.c - localDate.c : i;
    }

    @Override // j$.time.chrono.b
    public final long toEpochDay() {
        long j = this.a;
        long j2 = this.b;
        long j3 = 365 * j;
        long j4 = (((367 * j2) - 362) / 12) + (j >= 0 ? ((j + 399) / 400) + (((3 + j) / 4) - ((99 + j) / 100)) + j3 : j3 - ((j / (-400)) + ((j / (-4)) - (j / (-100))))) + ((long) (this.c - 1));
        if (j2 > 2) {
            j4 = !isLeapYear() ? j4 - 2 : j4 - 1;
        }
        return j4 - 719528;
    }

    @Override // j$.time.chrono.b
    public final String toString() {
        int i = this.a;
        short s = this.b;
        short s2 = this.c;
        int iAbs = Math.abs(i);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i > 9999) {
                sb.append('+');
            }
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i + 10000);
            sb.deleteCharAt(0);
        }
        sb.append(s < 10 ? "-0" : "-");
        sb.append((int) s);
        sb.append(s2 < 10 ? "-0" : "-");
        sb.append((int) s2);
        return sb.toString();
    }

    @Override // j$.time.chrono.b
    public final ChronoLocalDateTime z(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }
}
