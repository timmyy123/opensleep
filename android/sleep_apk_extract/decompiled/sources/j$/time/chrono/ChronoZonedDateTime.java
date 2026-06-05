package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.b;
import j$.time.temporal.Temporal;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public interface ChronoZonedDateTime<D extends b> extends Temporal, Comparable<ChronoZonedDateTime<?>> {
    @Override // j$.time.temporal.Temporal
    ChronoZonedDateTime a(long j, j$.time.temporal.o oVar);

    @Override // j$.time.temporal.Temporal
    ChronoZonedDateTime b(long j, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.Temporal
    default ChronoZonedDateTime c(long j, j$.time.temporal.q qVar) {
        return j.o(getChronology(), super.c(j, qVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object d(j$.time.s sVar) {
        return (sVar == j$.time.temporal.p.e || sVar == j$.time.temporal.p.a) ? getZone() : sVar == j$.time.temporal.p.d ? getOffset() : sVar == j$.time.temporal.p.g ? toLocalTime() : sVar == j$.time.temporal.p.b ? getChronology() : sVar == j$.time.temporal.p.c ? j$.time.temporal.b.NANOS : sVar.j(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int g(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return super.g(oVar);
        }
        int i = h.a[((j$.time.temporal.a) oVar).ordinal()];
        if (i != 1) {
            return i != 2 ? toLocalDateTime().g(oVar) : getOffset().getTotalSeconds();
        }
        throw new j$.time.temporal.r("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    default k getChronology() {
        return toLocalDate().getChronology();
    }

    ZoneOffset getOffset();

    ZoneId getZone();

    @Override // j$.time.temporal.TemporalAccessor
    default long i(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar.C(this);
        }
        int i = h.a[((j$.time.temporal.a) oVar).ordinal()];
        return i != 1 ? i != 2 ? toLocalDateTime().i(oVar) : getOffset().getTotalSeconds() : toEpochSecond();
    }

    @Override // j$.time.temporal.TemporalAccessor
    default j$.time.temporal.s j(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? (oVar == j$.time.temporal.a.INSTANT_SECONDS || oVar == j$.time.temporal.a.OFFSET_SECONDS) ? ((j$.time.temporal.a) oVar).b : toLocalDateTime().j(oVar) : oVar.t(this);
    }

    @Override // j$.time.temporal.Temporal
    default ChronoZonedDateTime k(j$.time.temporal.m mVar) {
        return j.o(getChronology(), mVar.f(this));
    }

    ChronoZonedDateTime m(ZoneId zoneId);

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    default int compareTo(ChronoZonedDateTime chronoZonedDateTime) {
        int iCompare = Long.compare(toEpochSecond(), chronoZonedDateTime.toEpochSecond());
        return (iCompare == 0 && (iCompare = toLocalTime().getNano() - chronoZonedDateTime.toLocalTime().getNano()) == 0 && (iCompare = toLocalDateTime().compareTo(chronoZonedDateTime.toLocalDateTime())) == 0 && (iCompare = getZone().getId().compareTo(chronoZonedDateTime.getZone().getId())) == 0) ? ((a) getChronology()).getId().compareTo(chronoZonedDateTime.getChronology().getId()) : iCompare;
    }

    default long toEpochSecond() {
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().P())) - ((long) getOffset().getTotalSeconds());
    }

    default Instant toInstant() {
        return Instant.ofEpochSecond(toEpochSecond(), toLocalTime().getNano());
    }

    default b toLocalDate() {
        return toLocalDateTime().toLocalDate();
    }

    ChronoLocalDateTime toLocalDateTime();

    default LocalTime toLocalTime() {
        return toLocalDateTime().toLocalTime();
    }

    ChronoZonedDateTime v(ZoneId zoneId);
}
