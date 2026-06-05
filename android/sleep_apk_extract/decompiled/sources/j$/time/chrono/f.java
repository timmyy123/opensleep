package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.temporal.Temporal;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import org.achartengine.chart.TimeChart;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements ChronoLocalDateTime, Temporal, j$.time.temporal.m, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;
    public final transient b a;
    public final transient LocalTime b;

    public f(b bVar, LocalTime localTime) {
        Objects.requireNonNull(localTime, "time");
        this.a = bVar;
        this.b = localTime;
    }

    public static f o(k kVar, Temporal temporal) {
        f fVar = (f) temporal;
        if (kVar.equals(fVar.getChronology())) {
            return fVar;
        }
        j$.time.g.e("Chronology mismatch, required: ", kVar.getId(), fVar.getChronology().getId());
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new d0((byte) 2, this);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, j$.time.temporal.Temporal
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final f a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return o(this.a.getChronology(), oVar.H(this, j));
        }
        boolean zJ = ((j$.time.temporal.a) oVar).J();
        b bVar = this.a;
        return zJ ? H(bVar, this.b.a(j, oVar)) : H(bVar.a(j, oVar), this.b);
    }

    public final f H(Temporal temporal, LocalTime localTime) {
        b bVar = this.a;
        return (bVar == temporal && this.b == localTime) ? this : new f(d.o(bVar.getChronology(), temporal), localTime);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final ChronoLocalDateTime k(LocalDate localDate) {
        return H(localDate, this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDateTime) && compareTo((ChronoLocalDateTime) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).J() ? this.b.g(oVar) : this.a.g(oVar) : j(oVar).a(i(oVar), oVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar != null && oVar.o(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        return aVar.isDateBased() || aVar.J();
    }

    public final int hashCode() {
        return this.b.hashCode() ^ this.a.hashCode();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).J() ? this.b.i(oVar) : this.a.i(oVar) : oVar.C(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s j(j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            return (((j$.time.temporal.a) oVar).J() ? this.b : this.a).j(oVar);
        }
        return oVar.t(this);
    }

    @Override // j$.time.temporal.Temporal
    public final long l(Temporal temporal, j$.time.temporal.q qVar) {
        Objects.requireNonNull(temporal, "endExclusive");
        ChronoLocalDateTime chronoLocalDateTimeA = getChronology().A(temporal);
        if (!(qVar instanceof j$.time.temporal.b)) {
            Objects.requireNonNull(qVar, "unit");
            return qVar.o(this, chronoLocalDateTimeA);
        }
        j$.time.temporal.b bVar = (j$.time.temporal.b) qVar;
        j$.time.temporal.b bVar2 = j$.time.temporal.b.DAYS;
        if (bVar.compareTo(bVar2) >= 0) {
            b localDate = chronoLocalDateTimeA.toLocalDate();
            if (chronoLocalDateTimeA.toLocalTime().compareTo(this.b) < 0) {
                localDate = localDate.c(1L, (j$.time.temporal.q) bVar2);
            }
            return this.a.l(localDate, qVar);
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        long jI = chronoLocalDateTimeA.i(aVar) - this.a.i(aVar);
        switch (e.a[bVar.ordinal()]) {
            case 1:
                jI = Math.multiplyExact(jI, 86400000000000L);
                break;
            case 2:
                jI = Math.multiplyExact(jI, 86400000000L);
                break;
            case 3:
                jI = Math.multiplyExact(jI, TimeChart.DAY);
                break;
            case 4:
                jI = Math.multiplyExact(jI, 86400L);
                break;
            case 5:
                jI = Math.multiplyExact(jI, 1440L);
                break;
            case 6:
                jI = Math.multiplyExact(jI, 24L);
                break;
            case 7:
                jI = Math.multiplyExact(jI, 2L);
                break;
        }
        return Math.addExact(jI, this.b.l(chronoLocalDateTimeA.toLocalTime(), qVar));
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, j$.time.temporal.Temporal
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final f b(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.b)) {
            return o(this.a.getChronology(), qVar.t(this, j));
        }
        switch (e.a[((j$.time.temporal.b) qVar).ordinal()]) {
            case 1:
                return x(this.a, 0L, 0L, 0L, j);
            case 2:
                f fVarH = H(this.a.b(j / 86400000000L, (j$.time.temporal.q) j$.time.temporal.b.DAYS), this.b);
                return fVarH.x(fVarH.a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                f fVarH2 = H(this.a.b(j / TimeChart.DAY, (j$.time.temporal.q) j$.time.temporal.b.DAYS), this.b);
                return fVarH2.x(fVarH2.a, 0L, 0L, 0L, (j % TimeChart.DAY) * 1000000);
            case 4:
                return x(this.a, 0L, 0L, j, 0L);
            case 5:
                return x(this.a, 0L, j, 0L, 0L);
            case 6:
                return x(this.a, j, 0L, 0L, 0L);
            case 7:
                f fVarH3 = H(this.a.b(j / 256, (j$.time.temporal.q) j$.time.temporal.b.DAYS), this.b);
                return fVarH3.x(fVarH3.a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return H(this.a.b(j, qVar), this.b);
        }
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final b toLocalDate() {
        return this.a;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final LocalTime toLocalTime() {
        return this.b;
    }

    public final String toString() {
        return this.a.toString() + "T" + this.b.toString();
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final ChronoZonedDateTime w(ZoneId zoneId) {
        return j.t(zoneId, null, this);
    }

    public final f x(b bVar, long j, long j2, long j3, long j4) {
        long j5 = j | j2 | j3 | j4;
        LocalTime localTime = this.b;
        if (j5 == 0) {
            return H(bVar, localTime);
        }
        long j6 = j / 24;
        long jO = localTime.O();
        long j7 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L) + jO;
        long jFloorDiv = Math.floorDiv(j7, 86400000000000L) + j6 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long jFloorMod = Math.floorMod(j7, 86400000000000L);
        return H(bVar.b(jFloorDiv, (j$.time.temporal.q) j$.time.temporal.b.DAYS), jFloorMod == jO ? this.b : LocalTime.H(jFloorMod));
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final Temporal k(LocalDate localDate) {
        return H(localDate, this.b);
    }
}
