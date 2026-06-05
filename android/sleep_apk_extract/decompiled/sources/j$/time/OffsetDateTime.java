package j$.time;

import j$.time.temporal.Temporal;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import kaaes.spotify.webapi.android.SpotifyService;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class OffsetDateTime implements Temporal, j$.time.temporal.m, Comparable<OffsetDateTime>, Serializable {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 2287754244819255394L;
    public final LocalDateTime a;
    public final ZoneOffset b;

    static {
        LocalDateTime localDateTime = LocalDateTime.c;
        ZoneOffset zoneOffset = ZoneOffset.MAX;
        localDateTime.getClass();
        of(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.d;
        ZoneOffset zoneOffset2 = ZoneOffset.MIN;
        localDateTime2.getClass();
        of(localDateTime2, zoneOffset2);
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "dateTime");
        this.a = localDateTime;
        Objects.requireNonNull(zoneOffset, SpotifyService.OFFSET);
        this.b = zoneOffset;
    }

    public static OffsetDateTime o(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset offset = zoneId.getRules().getOffset(instant);
        return new OffsetDateTime(LocalDateTime.C(instant.getEpochSecond(), instant.getNano(), offset), offset);
    }

    public static OffsetDateTime of(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new o((byte) 10, this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return (OffsetDateTime) oVar.H(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        int i = m.a[aVar.ordinal()];
        LocalDateTime localDateTime = this.a;
        return i != 1 ? i != 2 ? x(localDateTime.a(j, oVar), this.b) : x(localDateTime, ZoneOffset.ofTotalSeconds(aVar.b.a(j, aVar))) : o(Instant.ofEpochSecond(j, localDateTime.getNano()), this.b);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal c(long j, j$.time.temporal.q qVar) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = b(Long.MAX_VALUE, qVar);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.b(j2, qVar);
    }

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int iCompare;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (getOffset().equals(offsetDateTime2.getOffset())) {
            iCompare = toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime());
        } else {
            iCompare = Long.compare(this.a.r(this.b), offsetDateTime2.a.r(offsetDateTime2.b));
            if (iCompare == 0) {
                iCompare = this.a.toLocalTime().getNano() - offsetDateTime2.a.toLocalTime().getNano();
            }
        }
        return iCompare == 0 ? toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime()) : iCompare;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object d(s sVar) {
        if (sVar == j$.time.temporal.p.d || sVar == j$.time.temporal.p.e) {
            return getOffset();
        }
        if (sVar == j$.time.temporal.p.a) {
            return null;
        }
        return sVar == j$.time.temporal.p.f ? this.a.toLocalDate() : sVar == j$.time.temporal.p.g ? this.a.toLocalTime() : sVar == j$.time.temporal.p.b ? j$.time.chrono.r.c : sVar == j$.time.temporal.p.c ? j$.time.temporal.b.NANOS : sVar.j(this);
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final Temporal k(LocalDate localDate) {
        LocalDateTime localDateTime = this.a;
        return x(localDateTime.L(localDate, localDateTime.b), this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            if (this.a.equals(offsetDateTime.a) && this.b.equals(offsetDateTime.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.temporal.m
    public final Temporal f(Temporal temporal) {
        return temporal.a(this.a.toLocalDate().toEpochDay(), j$.time.temporal.a.EPOCH_DAY).a(this.a.toLocalTime().O(), j$.time.temporal.a.NANO_OF_DAY).a(getOffset().getTotalSeconds(), j$.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return super.g(oVar);
        }
        int i = m.a[((j$.time.temporal.a) oVar).ordinal()];
        if (i != 1) {
            return i != 2 ? this.a.g(oVar) : getOffset().getTotalSeconds();
        }
        throw new j$.time.temporal.r("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public ZoneOffset getOffset() {
        return this.b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            return true;
        }
        return oVar != null && oVar.o(this);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ this.a.hashCode();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar.C(this);
        }
        int i = m.a[((j$.time.temporal.a) oVar).ordinal()];
        return i != 1 ? i != 2 ? this.a.i(oVar) : getOffset().getTotalSeconds() : this.a.r(this.b);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s j(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? (oVar == j$.time.temporal.a.INSTANT_SECONDS || oVar == j$.time.temporal.a.OFFSET_SECONDS) ? ((j$.time.temporal.a) oVar).b : this.a.j(oVar) : oVar.t(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [j$.time.OffsetDateTime] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    @Override // j$.time.temporal.Temporal
    public final long l(Temporal temporal, j$.time.temporal.q qVar) {
        if (temporal instanceof OffsetDateTime) {
            temporal = (OffsetDateTime) temporal;
        } else {
            try {
                ZoneOffset zoneOffsetI = ZoneOffset.I(temporal);
                LocalDate localDate = (LocalDate) temporal.d(j$.time.temporal.p.f);
                LocalTime localTime = (LocalTime) temporal.d(j$.time.temporal.p.g);
                temporal = (localDate == null || localTime == null) ? o(Instant.from(temporal), zoneOffsetI) : new OffsetDateTime(LocalDateTime.of(localDate, localTime), zoneOffsetI);
            } catch (c e) {
                g.g("Unable to obtain OffsetDateTime from TemporalAccessor: ", temporal, temporal.getClass().getName(), e);
                return 0L;
            }
        }
        if (!(qVar instanceof j$.time.temporal.b)) {
            return qVar.o(this, temporal);
        }
        ZoneOffset zoneOffset = this.b;
        boolean zEquals = zoneOffset.equals(temporal.b);
        OffsetDateTime offsetDateTime = temporal;
        if (!zEquals) {
            offsetDateTime = new OffsetDateTime(temporal.a.I(zoneOffset.getTotalSeconds() - temporal.b.getTotalSeconds()), zoneOffset);
        }
        return this.a.l(offsetDateTime.a, qVar);
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final OffsetDateTime b(long j, j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.b ? x(this.a.b(j, qVar), this.b) : (OffsetDateTime) qVar.t(this, j);
    }

    public LocalDateTime toLocalDateTime() {
        return this.a;
    }

    public final String toString() {
        return this.a.toString() + this.b.c;
    }

    public final OffsetDateTime x(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.a == localDateTime && this.b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }
}
