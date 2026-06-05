package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.b;
import j$.time.temporal.Temporal;
import java.util.Objects;
import kaaes.spotify.webapi.android.SpotifyService;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public interface ChronoLocalDateTime<D extends b> extends Temporal, j$.time.temporal.m, Comparable<ChronoLocalDateTime<?>> {
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: B */
    default int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        int iCompareTo = toLocalDate().compareTo(chronoLocalDateTime.toLocalDate());
        return (iCompareTo == 0 && (iCompareTo = toLocalTime().compareTo(chronoLocalDateTime.toLocalTime())) == 0) ? ((a) getChronology()).getId().compareTo(chronoLocalDateTime.getChronology().getId()) : iCompareTo;
    }

    @Override // j$.time.temporal.Temporal
    ChronoLocalDateTime a(long j, j$.time.temporal.o oVar);

    @Override // j$.time.temporal.Temporal
    ChronoLocalDateTime b(long j, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.Temporal
    default ChronoLocalDateTime c(long j, j$.time.temporal.q qVar) {
        return f.o(getChronology(), super.c(j, qVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object d(j$.time.s sVar) {
        if (sVar == j$.time.temporal.p.a || sVar == j$.time.temporal.p.e || sVar == j$.time.temporal.p.d) {
            return null;
        }
        return sVar == j$.time.temporal.p.g ? toLocalTime() : sVar == j$.time.temporal.p.b ? getChronology() : sVar == j$.time.temporal.p.c ? j$.time.temporal.b.NANOS : sVar.j(this);
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    default ChronoLocalDateTime k(LocalDate localDate) {
        return f.o(getChronology(), localDate.f(this));
    }

    @Override // j$.time.temporal.m
    default Temporal f(Temporal temporal) {
        return temporal.a(toLocalDate().toEpochDay(), j$.time.temporal.a.EPOCH_DAY).a(toLocalTime().O(), j$.time.temporal.a.NANO_OF_DAY);
    }

    default k getChronology() {
        return toLocalDate().getChronology();
    }

    default long r(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, SpotifyService.OFFSET);
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().P())) - ((long) zoneOffset.getTotalSeconds());
    }

    default Instant toInstant(ZoneOffset zoneOffset) {
        return Instant.ofEpochSecond(r(zoneOffset), toLocalTime().getNano());
    }

    b toLocalDate();

    LocalTime toLocalTime();

    ChronoZonedDateTime w(ZoneId zoneId);
}
