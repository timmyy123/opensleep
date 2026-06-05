package j$.time.chrono;

import j$.time.DayOfWeek;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements k {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    static {
        new Locale("ja", "JP", "JP");
    }

    public static void o(Map map, j$.time.temporal.a aVar, long j) {
        Long l = (Long) map.get(aVar);
        if (l == null || l.longValue() == j) {
            map.put(aVar, Long.valueOf(j));
            return;
        }
        throw new j$.time.c("Conflict found: " + aVar + " " + l + " differs from " + aVar + " " + j);
    }

    public static k t(k kVar, String str) {
        String calendarType;
        k kVar2 = (k) a.putIfAbsent(str, kVar);
        if (kVar2 == null && (calendarType = kVar.getCalendarType()) != null) {
            b.putIfAbsent(calendarType, kVar);
        }
        return kVar2;
    }

    public static b x(b bVar, long j, long j2, long j3) {
        long j4;
        b bVarB = bVar.b(j, (j$.time.temporal.q) j$.time.temporal.b.MONTHS);
        j$.time.temporal.b bVar2 = j$.time.temporal.b.WEEKS;
        b bVarB2 = bVarB.b(j2, (j$.time.temporal.q) bVar2);
        if (j3 <= 7) {
            if (j3 < 1) {
                bVarB2 = bVarB2.b(Math.subtractExact(j3, 7L) / 7, (j$.time.temporal.q) bVar2);
                j4 = (j3 + 6) % 7;
            }
            return bVarB2.k(new j$.time.temporal.n(DayOfWeek.of((int) j3).getValue(), 0));
        }
        long j5 = j3 - 1;
        bVarB2 = bVarB2.b(j5 / 7, (j$.time.temporal.q) bVar2);
        j4 = j5 % 7;
        j3 = j4 + 1;
        return bVarB2.k(new j$.time.temporal.n(DayOfWeek.of((int) j3).getValue(), 0));
    }

    public void C(Map map, j$.time.format.d0 d0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (d0Var != j$.time.format.d0.LENIENT) {
                aVar.I(l.longValue());
            }
            b bVarA = dateNow().a(1L, (j$.time.temporal.o) j$.time.temporal.a.DAY_OF_MONTH).a(l.longValue(), (j$.time.temporal.o) aVar);
            o(map, j$.time.temporal.a.MONTH_OF_YEAR, bVarA.g(r6));
            o(map, j$.time.temporal.a.YEAR, bVarA.g(r6));
        }
    }

    @Override // j$.time.chrono.k
    public b E(Map map, j$.time.format.d0 d0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        if (map.containsKey(aVar)) {
            return dateEpochDay(((Long) map.remove(aVar)).longValue());
        }
        C(map, d0Var);
        b bVarI = I(map, d0Var);
        if (bVarI != null) {
            return bVarI;
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
        if (map.containsKey(aVar2)) {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                if (map.containsKey(j$.time.temporal.a.DAY_OF_MONTH)) {
                    return H(map, d0Var);
                }
                j$.time.temporal.a aVar4 = j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    j$.time.temporal.a aVar5 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (map.containsKey(aVar5)) {
                        int iA = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                        if (d0Var == j$.time.format.d0.LENIENT) {
                            long jSubtractExact = Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L);
                            return date(iA, 1, 1).b(jSubtractExact, (j$.time.temporal.q) j$.time.temporal.b.MONTHS).b(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), (j$.time.temporal.q) j$.time.temporal.b.WEEKS).b(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), (j$.time.temporal.q) j$.time.temporal.b.DAYS);
                        }
                        int iA2 = s(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                        int iA3 = s(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                        b bVarB = date(iA, iA2, 1).b((s(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5) - 1) + ((iA3 - 1) * 7), (j$.time.temporal.q) j$.time.temporal.b.DAYS);
                        if (d0Var != j$.time.format.d0.STRICT || bVarB.g(aVar3) == iA2) {
                            return bVarB;
                        }
                        j$.time.g.a("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                    j$.time.temporal.a aVar6 = j$.time.temporal.a.DAY_OF_WEEK;
                    if (map.containsKey(aVar6)) {
                        int iA4 = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                        if (d0Var == j$.time.format.d0.LENIENT) {
                            return x(date(iA4, 1, 1), Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar6)).longValue(), 1L));
                        }
                        int iA5 = s(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                        b bVarK = date(iA4, iA5, 1).b((s(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4) - 1) * 7, (j$.time.temporal.q) j$.time.temporal.b.DAYS).k(new j$.time.temporal.n(DayOfWeek.of(s(aVar6).a(((Long) map.remove(aVar6)).longValue(), aVar6)).getValue(), 0));
                        if (d0Var != j$.time.format.d0.STRICT || bVarK.g(aVar3) == iA5) {
                            return bVarK;
                        }
                        j$.time.g.a("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                }
            }
            j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar7)) {
                int iA6 = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                if (d0Var != j$.time.format.d0.LENIENT) {
                    return dateYearDay(iA6, s(aVar7).a(((Long) map.remove(aVar7)).longValue(), aVar7));
                }
                return dateYearDay(iA6, 1).b(Math.subtractExact(((Long) map.remove(aVar7)).longValue(), 1L), (j$.time.temporal.q) j$.time.temporal.b.DAYS);
            }
            j$.time.temporal.a aVar8 = j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR;
            if (map.containsKey(aVar8)) {
                j$.time.temporal.a aVar9 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                if (map.containsKey(aVar9)) {
                    int iA7 = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (d0Var == j$.time.format.d0.LENIENT) {
                        return dateYearDay(iA7, 1).b(Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), (j$.time.temporal.q) j$.time.temporal.b.WEEKS).b(Math.subtractExact(((Long) map.remove(aVar9)).longValue(), 1L), (j$.time.temporal.q) j$.time.temporal.b.DAYS);
                    }
                    int iA8 = s(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8);
                    b bVarB2 = dateYearDay(iA7, 1).b((s(aVar9).a(((Long) map.remove(aVar9)).longValue(), aVar9) - 1) + ((iA8 - 1) * 7), (j$.time.temporal.q) j$.time.temporal.b.DAYS);
                    if (d0Var != j$.time.format.d0.STRICT || bVarB2.g(aVar2) == iA7) {
                        return bVarB2;
                    }
                    j$.time.g.a("Strict mode rejected resolved date as it is in a different year");
                    return null;
                }
                j$.time.temporal.a aVar10 = j$.time.temporal.a.DAY_OF_WEEK;
                if (map.containsKey(aVar10)) {
                    int iA9 = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (d0Var == j$.time.format.d0.LENIENT) {
                        return x(dateYearDay(iA9, 1), 0L, Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar10)).longValue(), 1L));
                    }
                    b bVarK2 = dateYearDay(iA9, 1).b((s(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8) - 1) * 7, (j$.time.temporal.q) j$.time.temporal.b.DAYS).k(new j$.time.temporal.n(DayOfWeek.of(s(aVar10).a(((Long) map.remove(aVar10)).longValue(), aVar10)).getValue(), 0));
                    if (d0Var != j$.time.format.d0.STRICT || bVarK2.g(aVar2) == iA9) {
                        return bVarK2;
                    }
                    j$.time.g.a("Strict mode rejected resolved date as it is in a different year");
                    return null;
                }
            }
        }
        return null;
    }

    public b H(Map map, j$.time.format.d0 d0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iA = s(aVar).a(((Long) map.remove(aVar)).longValue(), aVar);
        if (d0Var == j$.time.format.d0.LENIENT) {
            long jSubtractExact = Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L);
            return date(iA, 1, 1).b(jSubtractExact, (j$.time.temporal.q) j$.time.temporal.b.MONTHS).b(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L), (j$.time.temporal.q) j$.time.temporal.b.DAYS);
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iA3 = s(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (d0Var != j$.time.format.d0.SMART) {
            return date(iA, iA2, iA3);
        }
        try {
            return date(iA, iA2, iA3);
        } catch (j$.time.c unused) {
            return this.date(iA, iA2, 1).k(new j$.time.s(2));
        }
    }

    public b I(Map map, j$.time.format.d0 d0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l = (Long) map.remove(aVar);
        if (l == null) {
            j$.time.temporal.a aVar2 = j$.time.temporal.a.ERA;
            if (!map.containsKey(aVar2)) {
                return null;
            }
            s(aVar2).b(((Long) map.get(aVar2)).longValue(), aVar2);
            return null;
        }
        Long l2 = (Long) map.remove(j$.time.temporal.a.ERA);
        int iA = d0Var != j$.time.format.d0.LENIENT ? s(aVar).a(l.longValue(), aVar) : Math.toIntExact(l.longValue());
        if (l2 != null) {
            o(map, j$.time.temporal.a.YEAR, u(eraOf(s(r2).a(l2.longValue(), r2)), iA));
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.YEAR;
        if (map.containsKey(aVar3)) {
            o(map, aVar3, u(dateYearDay(s(aVar3).a(((Long) map.get(aVar3)).longValue(), aVar3), 1).getEra(), iA));
            return null;
        }
        if (d0Var == j$.time.format.d0.STRICT) {
            map.put(aVar, l);
            return null;
        }
        if (eras().isEmpty()) {
            o(map, aVar3, iA);
            return null;
        }
        o(map, aVar3, u((l) r9.get(r9.size() - 1), iA));
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return getId().compareTo(((k) obj).getId());
    }

    @Override // j$.time.chrono.k
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && getId().compareTo(((a) obj).getId()) == 0;
    }

    @Override // j$.time.chrono.k
    public final int hashCode() {
        return getId().hashCode() ^ getClass().hashCode();
    }

    @Override // j$.time.chrono.k
    public final String toString() {
        return getId();
    }
}
