package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends a implements Serializable {
    public static final u c = new u();
    private static final long serialVersionUID = 459996390165777884L;

    private u() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.a, j$.time.chrono.k
    public final b E(Map map, j$.time.format.d0 d0Var) {
        return (w) super.E(map, d0Var);
    }

    @Override // j$.time.chrono.k
    public final ChronoZonedDateTime F(Instant instant, ZoneId zoneId) {
        return j.x(this, instant, zoneId);
    }

    @Override // j$.time.chrono.a
    public final b I(Map map, j$.time.format.d0 d0Var) {
        w wVarL;
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        Long l = (Long) map.get(aVar);
        x xVarQ = l != null ? x.q(s(aVar).a(l.longValue(), aVar)) : null;
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR_OF_ERA;
        Long l2 = (Long) map.get(aVar2);
        int iA = l2 != null ? s(aVar2).a(l2.longValue(), aVar2) : 0;
        if (xVarQ == null && l2 != null && !map.containsKey(j$.time.temporal.a.YEAR) && d0Var != j$.time.format.d0.STRICT) {
            x[] xVarArr = x.e;
            xVarQ = ((x[]) Arrays.copyOf(xVarArr, xVarArr.length))[((x[]) Arrays.copyOf(xVarArr, xVarArr.length)).length - 1];
        }
        if (l2 != null && xVarQ != null) {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                j$.time.temporal.a aVar4 = j$.time.temporal.a.DAY_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    map.remove(aVar);
                    map.remove(aVar2);
                    if (d0Var == j$.time.format.d0.LENIENT) {
                        return new w(LocalDate.of((xVarQ.b.getYear() + iA) - 1, 1, 1)).I(Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), j$.time.temporal.b.MONTHS).I(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), j$.time.temporal.b.DAYS);
                    }
                    int iA2 = s(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int iA3 = s(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    if (d0Var != j$.time.format.d0.SMART) {
                        LocalDate localDate = w.d;
                        LocalDate localDateOf = LocalDate.of((xVarQ.b.getYear() + iA) - 1, iA2, iA3);
                        if (!localDateOf.K(xVarQ.b) && xVarQ == x.n(localDateOf)) {
                            return new w(xVarQ, iA, localDateOf);
                        }
                        j$.time.g.a("year, month, and day not valid for Era");
                        return null;
                    }
                    if (iA < 1) {
                        j$.time.g.b("Invalid YearOfEra: ", iA);
                        return null;
                    }
                    int year = (xVarQ.b.getYear() + iA) - 1;
                    try {
                        wVarL = new w(LocalDate.of(year, iA2, iA3));
                    } catch (j$.time.c unused) {
                        wVarL = new w(LocalDate.of(year, iA2, 1)).L(new j$.time.s(2));
                    }
                    if (wVarL.b == xVarQ || wVarL.g(j$.time.temporal.a.YEAR_OF_ERA) <= 1 || iA <= 1) {
                        return wVarL;
                    }
                    throw new j$.time.c("Invalid YearOfEra for Era: " + xVarQ + " " + iA);
                }
            }
            j$.time.temporal.a aVar5 = j$.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar5)) {
                map.remove(aVar);
                map.remove(aVar2);
                if (d0Var == j$.time.format.d0.LENIENT) {
                    return new w(LocalDate.P((xVarQ.b.getYear() + iA) - 1, 1)).I(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), j$.time.temporal.b.DAYS);
                }
                int iA4 = s(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5);
                LocalDate localDate2 = w.d;
                LocalDate localDate3 = xVarQ.b;
                LocalDate localDateP = iA == 1 ? LocalDate.P(localDate3.getYear(), (xVarQ.b.I() + iA4) - 1) : LocalDate.P((localDate3.getYear() + iA) - 1, iA4);
                if (!localDateP.K(xVarQ.b) && xVarQ == x.n(localDateP)) {
                    return new w(xVarQ, iA, localDateP);
                }
                j$.time.g.a("Invalid parameters");
            }
        }
        return null;
    }

    @Override // j$.time.chrono.k
    public final b date(int i, int i2, int i3) {
        return new w(LocalDate.of(i, i2, i3));
    }

    @Override // j$.time.chrono.k
    public final b dateEpochDay(long j) {
        return new w(LocalDate.O(j));
    }

    @Override // j$.time.chrono.k
    public final b dateNow() {
        return new w(LocalDate.x(LocalDate.N(new j$.time.a(ZoneId.systemDefault()))));
    }

    @Override // j$.time.chrono.k
    public final b dateYearDay(int i, int i2) {
        return new w(LocalDate.P(i, i2));
    }

    @Override // j$.time.chrono.k
    public final l eraOf(int i) {
        return x.q(i);
    }

    @Override // j$.time.chrono.k
    public final List eras() {
        x[] xVarArr = x.e;
        return j$.time.b.c((x[]) Arrays.copyOf(xVarArr, xVarArr.length));
    }

    @Override // j$.time.chrono.k
    public final String getCalendarType() {
        return "japanese";
    }

    @Override // j$.time.chrono.k
    public final String getId() {
        return "Japanese";
    }

    @Override // j$.time.chrono.k
    public final boolean isLeapYear(long j) {
        return r.c.isLeapYear(j);
    }

    @Override // j$.time.chrono.k
    public final j$.time.temporal.s s(j$.time.temporal.a aVar) {
        switch (t.a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                j$.time.g.d("Unsupported field: ", aVar);
                return null;
            case 5:
                x[] xVarArr = x.e;
                int year = xVarArr[xVarArr.length - 1].b.getYear();
                int year2 = 1000000000 - xVarArr[xVarArr.length - 1].b.getYear();
                int year3 = xVarArr[0].b.getYear();
                int i = 1;
                while (true) {
                    x[] xVarArr2 = x.e;
                    if (i >= xVarArr2.length) {
                        return j$.time.temporal.s.g(1L, year2, 999999999 - year);
                    }
                    x xVar = xVarArr2[i];
                    year2 = Math.min(year2, (xVar.b.getYear() - year3) + 1);
                    year3 = xVar.b.getYear();
                    i++;
                }
                break;
            case 6:
                x xVar2 = x.d;
                long j = j$.time.temporal.a.DAY_OF_YEAR.b.c;
                long jMin = j;
                for (x xVar3 : x.e) {
                    long jMin2 = Math.min(jMin, (xVar3.b.lengthOfYear() - xVar3.b.I()) + 1);
                    jMin = xVar3.o() != null ? Math.min(jMin2, xVar3.o().b.I() - 1) : jMin2;
                }
                return j$.time.temporal.s.g(1L, jMin, j$.time.temporal.a.DAY_OF_YEAR.b.d);
            case 7:
                return j$.time.temporal.s.f(w.d.getYear(), 999999999L);
            case 8:
                long j2 = x.d.a;
                x[] xVarArr3 = x.e;
                return j$.time.temporal.s.f(j2, xVarArr3[xVarArr3.length - 1].a);
            default:
                return aVar.b;
        }
    }

    @Override // j$.time.chrono.k
    public final int u(l lVar, int i) {
        if (!(lVar instanceof x)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        x xVar = (x) lVar;
        int year = (xVar.b.getYear() + i) - 1;
        if (i == 1 || (year >= -999999999 && year <= 999999999 && year >= xVar.b.getYear() && lVar == x.n(LocalDate.of(year, 1, 1)))) {
            return year;
        }
        j$.time.g.a("Invalid yearOfEra value");
        return 0;
    }

    public Object writeReplace() {
        return new d0((byte) 1, this);
    }

    @Override // j$.time.chrono.k
    public final b y(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof w ? (w) temporalAccessor : new w(LocalDate.x(temporalAccessor));
    }
}
