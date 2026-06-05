package j$.time;

import j$.time.temporal.Temporal;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import kaaes.spotify.webapi.android.SpotifyService;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class OffsetTime implements Temporal, j$.time.temporal.m, Comparable<OffsetTime>, Serializable {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 7264499704384272492L;
    public final LocalTime a;
    public final ZoneOffset b;

    static {
        LocalTime localTime = LocalTime.e;
        ZoneOffset zoneOffset = ZoneOffset.MAX;
        localTime.getClass();
        of(localTime, zoneOffset);
        LocalTime localTime2 = LocalTime.f;
        ZoneOffset zoneOffset2 = ZoneOffset.MIN;
        localTime2.getClass();
        of(localTime2, zoneOffset2);
    }

    public OffsetTime(LocalTime localTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localTime, "time");
        this.a = localTime;
        Objects.requireNonNull(zoneOffset, SpotifyService.OFFSET);
        this.b = zoneOffset;
    }

    public static OffsetTime of(LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetTime(localTime, zoneOffset);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new o((byte) 9, this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return (OffsetTime) oVar.H(this, j);
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
        LocalTime localTime = this.a;
        if (oVar != aVar) {
            return x(localTime.a(j, oVar), this.b);
        }
        j$.time.temporal.a aVar2 = (j$.time.temporal.a) oVar;
        return x(localTime, ZoneOffset.ofTotalSeconds(aVar2.b.a(j, aVar2)));
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
    public final int compareTo(OffsetTime offsetTime) {
        OffsetTime offsetTime2 = offsetTime;
        if (this.b.equals(offsetTime2.b)) {
            return this.a.compareTo(offsetTime2.a);
        }
        int iCompare = Long.compare(t(), offsetTime2.t());
        return iCompare == 0 ? this.a.compareTo(offsetTime2.a) : iCompare;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object d(s sVar) {
        if (sVar == j$.time.temporal.p.d || sVar == j$.time.temporal.p.e) {
            return this.b;
        }
        if (((sVar == j$.time.temporal.p.a) || (sVar == j$.time.temporal.p.b)) || sVar == j$.time.temporal.p.f) {
            return null;
        }
        return sVar == j$.time.temporal.p.g ? this.a : sVar == j$.time.temporal.p.c ? j$.time.temporal.b.NANOS : sVar.j(this);
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final Temporal k(LocalDate localDate) {
        return (OffsetTime) localDate.f(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetTime) {
            OffsetTime offsetTime = (OffsetTime) obj;
            if (this.a.equals(offsetTime.a) && this.b.equals(offsetTime.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.temporal.m
    public final Temporal f(Temporal temporal) {
        return temporal.a(this.a.O(), j$.time.temporal.a.NANO_OF_DAY).a(this.b.getTotalSeconds(), j$.time.temporal.a.OFFSET_SECONDS);
    }

    public ZoneOffset getOffset() {
        return this.b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).J() || oVar == j$.time.temporal.a.OFFSET_SECONDS : oVar != null && oVar.o(this);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ this.a.hashCode();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.OFFSET_SECONDS ? this.b.getTotalSeconds() : this.a.i(oVar) : oVar.C(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s j(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.OFFSET_SECONDS ? ((j$.time.temporal.a) oVar).b : this.a.j(oVar) : oVar.t(this);
    }

    @Override // j$.time.temporal.Temporal
    public final long l(Temporal temporal, j$.time.temporal.q qVar) {
        OffsetTime offsetTime;
        if (temporal instanceof OffsetTime) {
            offsetTime = (OffsetTime) temporal;
        } else {
            try {
                offsetTime = new OffsetTime(LocalTime.x(temporal), ZoneOffset.I(temporal));
            } catch (c e) {
                g.g("Unable to obtain OffsetTime from TemporalAccessor: ", temporal, temporal.getClass().getName(), e);
                return 0L;
            }
        }
        if (!(qVar instanceof j$.time.temporal.b)) {
            return qVar.o(this, offsetTime);
        }
        long jT = offsetTime.t() - t();
        switch (n.a[((j$.time.temporal.b) qVar).ordinal()]) {
            case 1:
                return jT;
            case 2:
                return jT / 1000;
            case 3:
                return jT / 1000000;
            case 4:
                return jT / 1000000000;
            case 5:
                return jT / 60000000000L;
            case 6:
                return jT / 3600000000000L;
            case 7:
                return jT / 43200000000000L;
            default:
                g.d("Unsupported unit: ", qVar);
                return 0L;
        }
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final OffsetTime b(long j, j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.b ? x(this.a.b(j, qVar), this.b) : (OffsetTime) qVar.t(this, j);
    }

    public final long t() {
        return this.a.O() - (((long) this.b.getTotalSeconds()) * 1000000000);
    }

    public LocalTime toLocalTime() {
        return this.a;
    }

    public final String toString() {
        return this.a.toString() + this.b.c;
    }

    public final OffsetTime x(LocalTime localTime, ZoneOffset zoneOffset) {
        return (this.a == localTime && this.b.equals(zoneOffset)) ? this : new OffsetTime(localTime, zoneOffset);
    }
}
