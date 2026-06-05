package j$.time.chrono;

import j$.time.LocalTime;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public interface b extends Temporal, j$.time.temporal.m, Comparable {
    b D(TemporalAmount temporalAmount);

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: G */
    default int compareTo(b bVar) {
        int iCompare = Long.compare(toEpochDay(), bVar.toEpochDay());
        if (iCompare != 0) {
            return iCompare;
        }
        return ((a) getChronology()).getId().compareTo(bVar.getChronology().getId());
    }

    @Override // j$.time.temporal.Temporal
    b a(long j, j$.time.temporal.o oVar);

    @Override // j$.time.temporal.Temporal
    b b(long j, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.Temporal
    default b c(long j, j$.time.temporal.q qVar) {
        return d.o(getChronology(), super.c(j, qVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object d(j$.time.s sVar) {
        if (sVar == j$.time.temporal.p.a || sVar == j$.time.temporal.p.e || sVar == j$.time.temporal.p.d || sVar == j$.time.temporal.p.g) {
            return null;
        }
        return sVar == j$.time.temporal.p.b ? getChronology() : sVar == j$.time.temporal.p.c ? j$.time.temporal.b.DAYS : sVar.j(this);
    }

    boolean equals(Object obj);

    @Override // j$.time.temporal.m
    default Temporal f(Temporal temporal) {
        return temporal.a(toEpochDay(), j$.time.temporal.a.EPOCH_DAY);
    }

    k getChronology();

    default l getEra() {
        return getChronology().eraOf(g(j$.time.temporal.a.ERA));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default boolean h(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).isDateBased() : oVar != null && oVar.o(this);
    }

    int hashCode();

    default boolean isLeapYear() {
        return getChronology().isLeapYear(i(j$.time.temporal.a.YEAR));
    }

    b k(j$.time.temporal.m mVar);

    @Override // j$.time.temporal.Temporal
    long l(Temporal temporal, j$.time.temporal.q qVar);

    default int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    default long toEpochDay() {
        return i(j$.time.temporal.a.EPOCH_DAY);
    }

    String toString();

    default ChronoLocalDateTime z(LocalTime localTime) {
        return new f(this, localTime);
    }
}
