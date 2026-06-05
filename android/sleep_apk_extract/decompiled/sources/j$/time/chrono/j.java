package j$.time.chrono;

import j$.time.Duration;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.Temporal;
import j$.time.zone.ZoneRules;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import kaaes.spotify.webapi.android.SpotifyService;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements ChronoZonedDateTime, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    public final transient f a;
    public final transient ZoneOffset b;
    public final transient ZoneId c;

    public j(ZoneId zoneId, ZoneOffset zoneOffset, f fVar) {
        Objects.requireNonNull(fVar, "dateTime");
        this.a = fVar;
        Objects.requireNonNull(zoneOffset, SpotifyService.OFFSET);
        this.b = zoneOffset;
        Objects.requireNonNull(zoneId, "zone");
        this.c = zoneId;
    }

    public static j o(k kVar, Temporal temporal) {
        j jVar = (j) temporal;
        if (kVar.equals(jVar.getChronology())) {
            return jVar;
        }
        j$.time.g.e("Chronology mismatch, required: ", kVar.getId(), jVar.getChronology().getId());
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static j t(ZoneId zoneId, ZoneOffset zoneOffset, f fVar) {
        Objects.requireNonNull(fVar, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new j(zoneId, (ZoneOffset) zoneId, fVar);
        }
        ZoneRules rules = zoneId.getRules();
        LocalDateTime localDateTimeT = LocalDateTime.t(fVar);
        List listF = rules.f(localDateTimeT);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() == 0) {
            j$.time.zone.b bVarE = rules.e(localDateTimeT);
            fVar = fVar.x(fVar.a, 0L, 0L, Duration.x(bVarE.d.getTotalSeconds() - bVarE.c.getTotalSeconds(), 0).getSeconds(), 0L);
            zoneOffset = bVarE.d;
        } else {
            if (zoneOffset == null || !listF.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) listF.get(0);
            }
            fVar = fVar;
        }
        Objects.requireNonNull(zoneOffset, SpotifyService.OFFSET);
        return new j(zoneId, zoneOffset, fVar);
    }

    private Object writeReplace() {
        return new d0((byte) 3, this);
    }

    public static j x(k kVar, Instant instant, ZoneId zoneId) {
        ZoneOffset offset = zoneId.getRules().getOffset(instant);
        Objects.requireNonNull(offset, SpotifyService.OFFSET);
        return new j(zoneId, offset, (f) kVar.A(LocalDateTime.C(instant.getEpochSecond(), instant.getNano(), offset)));
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.Temporal
    public final ChronoZonedDateTime a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return o(getChronology(), oVar.H(this, j));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        int i = i.a[aVar.ordinal()];
        if (i == 1) {
            return b(j - toEpochSecond(), (j$.time.temporal.q) j$.time.temporal.b.SECONDS);
        }
        if (i != 2) {
            return t(this.c, this.b, this.a.a(j, oVar));
        }
        return x(getChronology(), this.a.toInstant(ZoneOffset.ofTotalSeconds(aVar.b.a(j, aVar))), this.c);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.Temporal
    public final ChronoZonedDateTime b(long j, j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.b ? k(this.a.b(j, qVar)) : o(getChronology(), qVar.t(this, j));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && compareTo((ChronoZonedDateTime) obj) == 0;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset getOffset() {
        return this.b;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId getZone() {
        return this.c;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            return true;
        }
        return oVar != null && oVar.o(this);
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.c.hashCode(), 3) ^ (this.a.hashCode() ^ this.b.hashCode());
    }

    @Override // j$.time.temporal.Temporal
    public final long l(Temporal temporal, j$.time.temporal.q qVar) {
        Objects.requireNonNull(temporal, "endExclusive");
        ChronoZonedDateTime chronoZonedDateTimeQ = getChronology().q(temporal);
        if (qVar instanceof j$.time.temporal.b) {
            return this.a.l(chronoZonedDateTimeQ.m(this.b).toLocalDateTime(), qVar);
        }
        Objects.requireNonNull(qVar, "unit");
        return qVar.o(this, chronoZonedDateTimeQ);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime m(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        if (this.c.equals(zoneId)) {
            return this;
        }
        return x(getChronology(), this.a.toInstant(this.b), zoneId);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoLocalDateTime toLocalDateTime() {
        return this.a;
    }

    public final String toString() {
        String str = this.a.toString() + this.b.c;
        ZoneOffset zoneOffset = this.b;
        ZoneId zoneId = this.c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime v(ZoneId zoneId) {
        return t(zoneId, this.b, this.a);
    }
}
