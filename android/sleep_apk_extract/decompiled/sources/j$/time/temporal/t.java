package j$.time.temporal;

import j$.time.format.c0;
import j$.time.format.d0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements o {
    public static final s f = s.f(1, 7);
    public static final s g = s.g(0, 4, 6);
    public static final s h = s.g(0, 52, 54);
    public static final s i = s.g(1, 52, 53);
    public final String a;
    public final u b;
    public final q c;
    public final q d;
    public final s e;

    public t(String str, u uVar, q qVar, q qVar2, s sVar) {
        this.a = str;
        this.b = uVar;
        this.c = qVar;
        this.d = qVar2;
        this.e = sVar;
    }

    public static int a(int i2, int i3) {
        return ((i3 - 1) + (i2 + 7)) / 7;
    }

    @Override // j$.time.temporal.o
    public final long C(TemporalAccessor temporalAccessor) {
        int iC;
        b bVar = b.WEEKS;
        q qVar = this.d;
        if (qVar == bVar) {
            iC = b(temporalAccessor);
        } else if (qVar == b.MONTHS) {
            int iB = b(temporalAccessor);
            int iG = temporalAccessor.g(a.DAY_OF_MONTH);
            iC = a(h(iG, iB), iG);
        } else if (qVar == b.YEARS) {
            int iB2 = b(temporalAccessor);
            int iG2 = temporalAccessor.g(a.DAY_OF_YEAR);
            iC = a(h(iG2, iB2), iG2);
        } else if (qVar == u.h) {
            iC = d(temporalAccessor);
        } else {
            if (qVar != b.FOREVER) {
                throw new IllegalStateException("unreachable, rangeUnit: " + qVar + ", this: " + this);
            }
            iC = c(temporalAccessor);
        }
        return iC;
    }

    @Override // j$.time.temporal.o
    public final Temporal H(Temporal temporal, long j) {
        if (this.e.a(j, this) == temporal.g(this)) {
            return temporal;
        }
        if (this.d != b.FOREVER) {
            return temporal.b(r0 - r1, this.c);
        }
        u uVar = this.b;
        return e(j$.time.chrono.k.n(temporal), (int) j, temporal.g(uVar.e), temporal.g(uVar.c));
    }

    public final int b(TemporalAccessor temporalAccessor) {
        return Math.floorMod(temporalAccessor.g(a.DAY_OF_WEEK) - this.b.a.getValue(), 7) + 1;
    }

    public final int c(TemporalAccessor temporalAccessor) {
        int iB = b(temporalAccessor);
        int iG = temporalAccessor.g(a.YEAR);
        a aVar = a.DAY_OF_YEAR;
        int iG2 = temporalAccessor.g(aVar);
        int iH = h(iG2, iB);
        int iA = a(iH, iG2);
        return iA == 0 ? iG - 1 : iA >= a(iH, ((int) temporalAccessor.j(aVar).d) + this.b.b) ? iG + 1 : iG;
    }

    public final int d(TemporalAccessor temporalAccessor) {
        int iA;
        int iB = b(temporalAccessor);
        a aVar = a.DAY_OF_YEAR;
        int iG = temporalAccessor.g(aVar);
        int iH = h(iG, iB);
        int iA2 = a(iH, iG);
        return iA2 == 0 ? d(j$.time.chrono.k.n(temporalAccessor).y(temporalAccessor).c(iG, (q) b.DAYS)) : (iA2 <= 50 || iA2 < (iA = a(iH, ((int) temporalAccessor.j(aVar).d) + this.b.b))) ? iA2 : (iA2 - iA) + 1;
    }

    public final j$.time.chrono.b e(j$.time.chrono.k kVar, int i2, int i3, int i4) {
        j$.time.chrono.b bVarDate = kVar.date(i2, 1, 1);
        int iH = h(1, b(bVarDate));
        int i5 = i4 - 1;
        return bVarDate.b(((Math.min(i3, a(iH, bVarDate.lengthOfYear() + this.b.b) - 1) - 1) * 7) + i5 + (-iH), (q) b.DAYS);
    }

    public final s f(TemporalAccessor temporalAccessor, a aVar) {
        int iH = h(temporalAccessor.g(aVar), b(temporalAccessor));
        s sVarJ = temporalAccessor.j(aVar);
        return s.f(a(iH, (int) sVarJ.a), a(iH, (int) sVarJ.d));
    }

    public final s g(TemporalAccessor temporalAccessor) {
        a aVar = a.DAY_OF_YEAR;
        if (!temporalAccessor.h(aVar)) {
            return h;
        }
        int iB = b(temporalAccessor);
        int iG = temporalAccessor.g(aVar);
        int iH = h(iG, iB);
        int iA = a(iH, iG);
        if (iA == 0) {
            return g(j$.time.chrono.k.n(temporalAccessor).y(temporalAccessor).c(iG + 7, (q) b.DAYS));
        }
        return iA >= a(iH, this.b.b + ((int) temporalAccessor.j(aVar).d)) ? g(j$.time.chrono.k.n(temporalAccessor).y(temporalAccessor).b((r0 - iG) + 8, (q) b.DAYS)) : s.f(1L, r1 - 1);
    }

    public final int h(int i2, int i3) {
        int iFloorMod = Math.floorMod(i2 - i3, 7);
        return iFloorMod + 1 > this.b.b ? 7 - iFloorMod : -iFloorMod;
    }

    @Override // j$.time.temporal.o
    public final boolean isDateBased() {
        return true;
    }

    @Override // j$.time.temporal.o
    public final boolean o(TemporalAccessor temporalAccessor) {
        if (!temporalAccessor.h(a.DAY_OF_WEEK)) {
            return false;
        }
        b bVar = b.WEEKS;
        q qVar = this.d;
        if (qVar == bVar) {
            return true;
        }
        if (qVar == b.MONTHS) {
            return temporalAccessor.h(a.DAY_OF_MONTH);
        }
        if (qVar == b.YEARS) {
            return temporalAccessor.h(a.DAY_OF_YEAR);
        }
        if (qVar == u.h) {
            return temporalAccessor.h(a.DAY_OF_YEAR);
        }
        if (qVar == b.FOREVER) {
            return temporalAccessor.h(a.YEAR);
        }
        return false;
    }

    @Override // j$.time.temporal.o
    public final s range() {
        return this.e;
    }

    @Override // j$.time.temporal.o
    public final s t(TemporalAccessor temporalAccessor) {
        b bVar = b.WEEKS;
        q qVar = this.d;
        if (qVar == bVar) {
            return this.e;
        }
        if (qVar == b.MONTHS) {
            return f(temporalAccessor, a.DAY_OF_MONTH);
        }
        if (qVar == b.YEARS) {
            return f(temporalAccessor, a.DAY_OF_YEAR);
        }
        if (qVar == u.h) {
            return g(temporalAccessor);
        }
        if (qVar == b.FOREVER) {
            return a.YEAR.b;
        }
        throw new IllegalStateException("unreachable, rangeUnit: " + qVar + ", this: " + this);
    }

    public final String toString() {
        return this.a + "[" + this.b.toString() + "]";
    }

    @Override // j$.time.temporal.o
    public final TemporalAccessor x(Map map, c0 c0Var, d0 d0Var) {
        j$.time.chrono.b bVarB;
        j$.time.chrono.b bVarB2;
        j$.time.chrono.b bVarB3;
        long jLongValue = ((Long) map.get(this)).longValue();
        int intExact = Math.toIntExact(jLongValue);
        b bVar = b.WEEKS;
        s sVar = this.e;
        u uVar = this.b;
        q qVar = this.d;
        if (qVar == bVar) {
            long jFloorMod = Math.floorMod((sVar.a(jLongValue, this) - 1) + (uVar.a.getValue() - 1), 7) + 1;
            map.remove(this);
            map.put(a.DAY_OF_WEEK, Long.valueOf(jFloorMod));
            return null;
        }
        a aVar = a.DAY_OF_WEEK;
        if (!map.containsKey(aVar)) {
            return null;
        }
        int iFloorMod = Math.floorMod(aVar.b.a(((Long) map.get(aVar)).longValue(), aVar) - uVar.a.getValue(), 7) + 1;
        j$.time.chrono.k kVarN = j$.time.chrono.k.n(c0Var);
        a aVar2 = a.YEAR;
        if (!map.containsKey(aVar2)) {
            if ((qVar != u.h && qVar != b.FOREVER) || !map.containsKey(uVar.f) || !map.containsKey(uVar.e)) {
                return null;
            }
            t tVar = uVar.f;
            int iA = tVar.e.a(((Long) map.get(tVar)).longValue(), uVar.f);
            if (d0Var == d0.LENIENT) {
                bVarB = e(kVarN, iA, 1, iFloorMod).b(Math.subtractExact(((Long) map.get(uVar.e)).longValue(), 1L), (q) bVar);
            } else {
                t tVar2 = uVar.e;
                j$.time.chrono.b bVarE = e(kVarN, iA, tVar2.e.a(((Long) map.get(tVar2)).longValue(), uVar.e), iFloorMod);
                if (d0Var == d0.STRICT && c(bVarE) != iA) {
                    j$.time.g.a("Strict mode rejected resolved date as it is in a different week-based-year");
                    return null;
                }
                bVarB = bVarE;
            }
            map.remove(this);
            map.remove(uVar.f);
            map.remove(uVar.e);
            map.remove(aVar);
            return bVarB;
        }
        int iA2 = aVar2.b.a(((Long) map.get(aVar2)).longValue(), aVar2);
        b bVar2 = b.MONTHS;
        if (qVar == bVar2) {
            a aVar3 = a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                long jLongValue2 = ((Long) map.get(aVar3)).longValue();
                long j = intExact;
                if (d0Var == d0.LENIENT) {
                    j$.time.chrono.b bVarB4 = kVarN.date(iA2, 1, 1).b(Math.subtractExact(jLongValue2, 1L), (q) bVar2);
                    int iB = b(bVarB4);
                    int iG = bVarB4.g(a.DAY_OF_MONTH);
                    bVarB3 = bVarB4.b(Math.addExact(Math.multiplyExact(Math.subtractExact(j, a(h(iG, iB), iG)), 7L), iFloorMod - b(bVarB4)), (q) b.DAYS);
                } else {
                    j$.time.chrono.b bVarDate = kVarN.date(iA2, aVar3.b.a(jLongValue2, aVar3), 1);
                    long jA = sVar.a(j, this);
                    int iB2 = b(bVarDate);
                    int iG2 = bVarDate.g(a.DAY_OF_MONTH);
                    j$.time.chrono.b bVarB5 = bVarDate.b((((int) (jA - ((long) a(h(iG2, iB2), iG2)))) * 7) + (iFloorMod - b(bVarDate)), (q) b.DAYS);
                    if (d0Var == d0.STRICT && bVarB5.i(aVar3) != jLongValue2) {
                        j$.time.g.a("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                    bVarB3 = bVarB5;
                }
                map.remove(this);
                map.remove(aVar2);
                map.remove(aVar3);
                map.remove(aVar);
                return bVarB3;
            }
        }
        if (qVar != b.YEARS) {
            return null;
        }
        long j2 = intExact;
        j$.time.chrono.b bVarDate2 = kVarN.date(iA2, 1, 1);
        if (d0Var == d0.LENIENT) {
            int iB3 = b(bVarDate2);
            int iG3 = bVarDate2.g(a.DAY_OF_YEAR);
            bVarB2 = bVarDate2.b(Math.addExact(Math.multiplyExact(Math.subtractExact(j2, a(h(iG3, iB3), iG3)), 7L), iFloorMod - b(bVarDate2)), (q) b.DAYS);
        } else {
            long jA2 = sVar.a(j2, this);
            int iB4 = b(bVarDate2);
            int iG4 = bVarDate2.g(a.DAY_OF_YEAR);
            j$.time.chrono.b bVarB6 = bVarDate2.b((((int) (jA2 - ((long) a(h(iG4, iB4), iG4)))) * 7) + (iFloorMod - b(bVarDate2)), (q) b.DAYS);
            if (d0Var == d0.STRICT && bVarB6.i(aVar2) != iA2) {
                j$.time.g.a("Strict mode rejected resolved date as it is in a different year");
                return null;
            }
            bVarB2 = bVarB6;
        }
        map.remove(this);
        map.remove(aVar2);
        map.remove(aVar);
        return bVarB2;
    }
}
