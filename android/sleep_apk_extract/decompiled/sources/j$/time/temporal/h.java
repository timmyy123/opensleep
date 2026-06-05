package j$.time.temporal;

import j$.time.DayOfWeek;
import j$.time.LocalDate;
import j$.time.format.c0;
import j$.time.format.d0;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements o {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;
    public static final int[] a;
    public static final /* synthetic */ h[] b;

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.o
            public final long C(TemporalAccessor temporalAccessor) {
                if (!o(temporalAccessor)) {
                    throw new r("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.g(a.DAY_OF_YEAR) - h.a[((temporalAccessor.g(a.MONTH_OF_YEAR) - 1) / 3) + (j$.time.chrono.r.c.isLeapYear(temporalAccessor.i(a.YEAR)) ? 4 : 0)];
            }

            @Override // j$.time.temporal.o
            public final Temporal H(Temporal temporal, long j) {
                long jC = C(temporal);
                range().b(j, this);
                a aVar = a.DAY_OF_YEAR;
                return temporal.a((j - jC) + temporal.i(aVar), aVar);
            }

            @Override // j$.time.temporal.o
            public final boolean o(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.DAY_OF_YEAR) || !temporalAccessor.h(a.MONTH_OF_YEAR) || !temporalAccessor.h(a.YEAR)) {
                    return false;
                }
                h hVar2 = j.a;
                return j$.time.chrono.k.n(temporalAccessor).equals(j$.time.chrono.r.c);
            }

            @Override // j$.time.temporal.o
            public final s range() {
                return s.g(1L, 90L, 92L);
            }

            @Override // j$.time.temporal.o
            public final s t(TemporalAccessor temporalAccessor) {
                if (!o(temporalAccessor)) {
                    throw new r("Unsupported field: DayOfQuarter");
                }
                long jI = temporalAccessor.i(h.QUARTER_OF_YEAR);
                if (jI == 1) {
                    return j$.time.chrono.r.c.isLeapYear(temporalAccessor.i(a.YEAR)) ? s.f(1L, 91L) : s.f(1L, 90L);
                }
                return jI == 2 ? s.f(1L, 91L) : (jI == 3 || jI == 4) ? s.f(1L, 92L) : range();
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }

            @Override // j$.time.temporal.o
            public final TemporalAccessor x(Map map, c0 c0Var, d0 d0Var) {
                LocalDate localDateOf;
                long jSubtractExact;
                a aVar = a.YEAR;
                Long l = (Long) map.get(aVar);
                o oVar = h.QUARTER_OF_YEAR;
                Long l2 = (Long) map.get(oVar);
                if (l != null && l2 != null) {
                    int iA = aVar.b.a(l.longValue(), aVar);
                    long jLongValue = ((Long) map.get(h.DAY_OF_QUARTER)).longValue();
                    h hVar2 = j.a;
                    if (j$.time.chrono.k.n(c0Var).equals(j$.time.chrono.r.c)) {
                        if (d0Var == d0.LENIENT) {
                            localDateOf = LocalDate.of(iA, 1, 1).S(Math.multiplyExact(Math.subtractExact(l2.longValue(), 1L), 3L));
                            jSubtractExact = Math.subtractExact(jLongValue, 1L);
                        } else {
                            localDateOf = LocalDate.of(iA, ((oVar.range().a(l2.longValue(), oVar) - 1) * 3) + 1, 1);
                            if (jLongValue < 1 || jLongValue > 90) {
                                if (d0Var == d0.STRICT) {
                                    t(localDateOf).b(jLongValue, this);
                                } else {
                                    range().b(jLongValue, this);
                                }
                            }
                            jSubtractExact = jLongValue - 1;
                        }
                        map.remove(this);
                        map.remove(aVar);
                        map.remove(oVar);
                        return localDateOf.R(jSubtractExact);
                    }
                    j$.time.g.a("Resolve requires IsoChronology");
                }
                return null;
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.o
            public final long C(TemporalAccessor temporalAccessor) {
                if (o(temporalAccessor)) {
                    return (temporalAccessor.i(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new r("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.o
            public final Temporal H(Temporal temporal, long j) {
                long jC = C(temporal);
                range().b(j, this);
                a aVar = a.MONTH_OF_YEAR;
                return temporal.a(((j - jC) * 3) + temporal.i(aVar), aVar);
            }

            @Override // j$.time.temporal.o
            public final boolean o(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.MONTH_OF_YEAR)) {
                    return false;
                }
                h hVar3 = j.a;
                return j$.time.chrono.k.n(temporalAccessor).equals(j$.time.chrono.r.c);
            }

            @Override // j$.time.temporal.o
            public final s range() {
                return s.f(1L, 4L);
            }

            @Override // j$.time.temporal.o
            public final s t(TemporalAccessor temporalAccessor) {
                if (o(temporalAccessor)) {
                    return range();
                }
                throw new r("Unsupported field: QuarterOfYear");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.o
            public final long C(TemporalAccessor temporalAccessor) {
                if (o(temporalAccessor)) {
                    return h.I(LocalDate.x(temporalAccessor));
                }
                throw new r("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.o
            public final Temporal H(Temporal temporal, long j) {
                range().b(j, this);
                return temporal.b(Math.subtractExact(j, C(temporal)), b.WEEKS);
            }

            @Override // j$.time.temporal.o
            public final boolean o(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar4 = j.a;
                return j$.time.chrono.k.n(temporalAccessor).equals(j$.time.chrono.r.c);
            }

            @Override // j$.time.temporal.o
            public final s range() {
                return s.g(1L, 52L, 53L);
            }

            @Override // j$.time.temporal.o
            public final s t(TemporalAccessor temporalAccessor) {
                if (o(temporalAccessor)) {
                    return h.L(LocalDate.x(temporalAccessor));
                }
                throw new r("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }

            @Override // j$.time.temporal.o
            public final TemporalAccessor x(Map map, c0 c0Var, d0 d0Var) {
                LocalDate localDateA;
                long j;
                o oVar = h.WEEK_BASED_YEAR;
                Long l = (Long) map.get(oVar);
                a aVar = a.DAY_OF_WEEK;
                Long l2 = (Long) map.get(aVar);
                if (l != null && l2 != null) {
                    int iA = oVar.range().a(l.longValue(), oVar);
                    long jLongValue = ((Long) map.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                    h hVar4 = j.a;
                    if (j$.time.chrono.k.n(c0Var).equals(j$.time.chrono.r.c)) {
                        LocalDate localDateOf = LocalDate.of(iA, 1, 4);
                        if (d0Var == d0.LENIENT) {
                            long jLongValue2 = l2.longValue();
                            if (jLongValue2 > 7) {
                                long j2 = jLongValue2 - 1;
                                localDateOf = localDateOf.T(j2 / 7);
                                j = j2 % 7;
                            } else {
                                if (jLongValue2 < 1) {
                                    localDateOf = localDateOf.T(Math.subtractExact(jLongValue2, 7L) / 7);
                                    j = (jLongValue2 + 6) % 7;
                                }
                                localDateA = localDateOf.T(Math.subtractExact(jLongValue, 1L)).a(jLongValue2, aVar);
                            }
                            jLongValue2 = j + 1;
                            localDateA = localDateOf.T(Math.subtractExact(jLongValue, 1L)).a(jLongValue2, aVar);
                        } else {
                            int iA2 = aVar.b.a(l2.longValue(), aVar);
                            if (jLongValue < 1 || jLongValue > 52) {
                                if (d0Var == d0.STRICT) {
                                    h.L(localDateOf).b(jLongValue, this);
                                } else {
                                    range().b(jLongValue, this);
                                }
                            }
                            localDateA = localDateOf.T(jLongValue - 1).a(iA2, aVar);
                        }
                        map.remove(this);
                        map.remove(oVar);
                        map.remove(aVar);
                        return localDateA;
                    }
                    j$.time.g.a("Resolve requires IsoChronology");
                }
                return null;
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.o
            public final long C(TemporalAccessor temporalAccessor) {
                if (o(temporalAccessor)) {
                    return h.J(LocalDate.x(temporalAccessor));
                }
                throw new r("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.o
            public final Temporal H(Temporal temporal, long j) {
                if (!o(temporal)) {
                    throw new r("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.b.a(j, h.WEEK_BASED_YEAR);
                LocalDate localDateX = LocalDate.x(temporal);
                int iG = localDateX.g(a.DAY_OF_WEEK);
                int I = h.I(localDateX);
                if (I == 53 && h.K(iA) == 52) {
                    I = 52;
                }
                return temporal.k(LocalDate.of(iA, 1, 4).R(((I - 1) * 7) + (iG - r3.g(r6))));
            }

            @Override // j$.time.temporal.o
            public final boolean o(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar5 = j.a;
                return j$.time.chrono.k.n(temporalAccessor).equals(j$.time.chrono.r.c);
            }

            @Override // j$.time.temporal.o
            public final s range() {
                return a.YEAR.b;
            }

            @Override // j$.time.temporal.o
            public final s t(TemporalAccessor temporalAccessor) {
                if (o(temporalAccessor)) {
                    return a.YEAR.b;
                }
                throw new r("Unsupported field: WeekBasedYear");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        b = new h[]{hVar, hVar2, hVar3, hVar4};
        a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public static int I(LocalDate localDate) {
        int iOrdinal = localDate.H().ordinal();
        int I = localDate.I() - 1;
        int i = (3 - iOrdinal) + I;
        int i2 = i - ((i / 7) * 7);
        int i3 = i2 - 3;
        if (i3 < -3) {
            i3 = i2 + 4;
        }
        if (I < i3) {
            if (localDate.I() != 180) {
                localDate = LocalDate.P(localDate.a, 180);
            }
            return (int) L(localDate.U(-1L)).d;
        }
        int i4 = ((I - i3) / 7) + 1;
        if (i4 != 53 || i3 == -3 || (i3 == -2 && localDate.isLeapYear())) {
            return i4;
        }
        return 1;
    }

    public static int J(LocalDate localDate) {
        int year = localDate.getYear();
        int I = localDate.I();
        if (I <= 3) {
            return I - localDate.H().ordinal() < -2 ? year - 1 : year;
        }
        if (I >= 363) {
            return ((I - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.H().ordinal() >= 0 ? year + 1 : year;
        }
        return year;
    }

    public static int K(int i) {
        LocalDate localDateOf = LocalDate.of(i, 1, 1);
        if (localDateOf.H() != DayOfWeek.THURSDAY) {
            return (localDateOf.H() == DayOfWeek.WEDNESDAY && localDateOf.isLeapYear()) ? 53 : 52;
        }
        return 53;
    }

    public static s L(LocalDate localDate) {
        return s.f(1L, K(J(localDate)));
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) b.clone();
    }

    @Override // j$.time.temporal.o
    public final boolean isDateBased() {
        return true;
    }
}
