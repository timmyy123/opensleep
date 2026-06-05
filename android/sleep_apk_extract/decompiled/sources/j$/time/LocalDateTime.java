package j$.time;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import kaaes.spotify.webapi.android.SpotifyService;
import org.achartengine.chart.TimeChart;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class LocalDateTime implements Temporal, j$.time.temporal.m, ChronoLocalDateTime<LocalDate>, Serializable {
    public static final LocalDateTime c = of(LocalDate.d, LocalTime.e);
    public static final LocalDateTime d = of(LocalDate.e, LocalTime.f);
    private static final long serialVersionUID = 6207766400415563566L;
    public final LocalDate a;
    public final LocalTime b;

    public LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.a = localDate;
        this.b = localTime;
    }

    public static LocalDateTime C(long j, int i, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, SpotifyService.OFFSET);
        long j2 = i;
        j$.time.temporal.a.NANO_OF_SECOND.I(j2);
        long totalSeconds = j + ((long) zoneOffset.getTotalSeconds());
        return new LocalDateTime(LocalDate.O(Math.floorDiv(totalSeconds, 86400L)), LocalTime.H((((long) ((int) Math.floorMod(totalSeconds, 86400L))) * 1000000000) + j2));
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        Objects.requireNonNull(localDate, "date");
        Objects.requireNonNull(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return C(instant.getEpochSecond(), instant.getNano(), zoneId.getRules().getOffset(instant));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static LocalDateTime t(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).toLocalDateTime();
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(LocalDate.x(temporalAccessor), LocalTime.x(temporalAccessor));
        } catch (c e) {
            g.g("Unable to obtain LocalDateTime from TemporalAccessor: ", temporalAccessor, temporalAccessor.getClass().getName(), e);
            return null;
        }
    }

    private Object writeReplace() {
        return new o((byte) 5, this);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, java.lang.Comparable
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public final int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? o((LocalDateTime) chronoLocalDateTime) : super.compareTo(chronoLocalDateTime);
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime b(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) qVar.t(this, j);
        }
        switch (h.a[((j$.time.temporal.b) qVar).ordinal()]) {
            case 1:
                return J(this.a, 0L, 0L, 0L, j);
            case 2:
                LocalDateTime localDateTimeL = L(this.a.R(j / 86400000000L), this.b);
                return localDateTimeL.J(localDateTimeL.a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                LocalDateTime localDateTimeL2 = L(this.a.R(j / TimeChart.DAY), this.b);
                return localDateTimeL2.J(localDateTimeL2.a, 0L, 0L, 0L, (j % TimeChart.DAY) * 1000000);
            case 4:
                return I(j);
            case 5:
                return J(this.a, 0L, j, 0L, 0L);
            case 6:
                return J(this.a, j, 0L, 0L, 0L);
            case 7:
                LocalDateTime localDateTimeL3 = L(this.a.R(j / 256), this.b);
                return localDateTimeL3.J(localDateTimeL3.a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return L(this.a.b(j, qVar), this.b);
        }
    }

    public final LocalDateTime I(long j) {
        return J(this.a, 0L, 0L, j, 0L);
    }

    public final LocalDateTime J(LocalDate localDate, long j, long j2, long j3, long j4) {
        long j5 = j | j2 | j3 | j4;
        LocalTime localTime = this.b;
        if (j5 == 0) {
            return L(localDate, localTime);
        }
        long j6 = j / 24;
        long jO = localTime.O();
        long j7 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L) + jO;
        long jFloorDiv = Math.floorDiv(j7, 86400000000000L) + j6 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long jFloorMod = Math.floorMod(j7, 86400000000000L);
        return L(localDate.R(jFloorDiv), jFloorMod == jO ? this.b : LocalTime.H(jFloorMod));
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return (LocalDateTime) oVar.H(this, j);
        }
        boolean zJ = ((j$.time.temporal.a) oVar).J();
        LocalDate localDate = this.a;
        return zJ ? L(localDate, this.b.a(j, oVar)) : L(localDate.a(j, oVar), this.b);
    }

    public final LocalDateTime L(LocalDate localDate, LocalTime localTime) {
        return (this.a == localDate && this.b == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    /* JADX INFO: renamed from: atZone, reason: merged with bridge method [inline-methods] */
    public ZonedDateTime w(ZoneId zoneId) {
        return ZonedDateTime.x(this, null, zoneId);
    }

    @Override // j$.time.temporal.Temporal
    public final ChronoLocalDateTime c(long j, j$.time.temporal.q qVar) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = b(Long.MAX_VALUE, qVar);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.b(j2, qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object d(s sVar) {
        return sVar == j$.time.temporal.p.f ? this.a : super.d(sVar);
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final ChronoLocalDateTime k(LocalDate localDate) {
        return L(localDate, this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.a.equals(localDateTime.a) && this.b.equals(localDateTime.b)) {
                return true;
            }
        }
        return false;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).J() ? this.b.g(oVar) : this.a.g(oVar) : super.g(oVar);
    }

    public int getDayOfMonth() {
        return this.a.getDayOfMonth();
    }

    public int getHour() {
        return this.b.getHour();
    }

    public int getMinute() {
        return this.b.getMinute();
    }

    public int getMonthValue() {
        return this.a.getMonthValue();
    }

    public int getNano() {
        return this.b.getNano();
    }

    public int getSecond() {
        return this.b.getSecond();
    }

    public int getYear() {
        return this.a.getYear();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar != null && oVar.o(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        return aVar.isDateBased() || aVar.J();
    }

    public int hashCode() {
        return this.b.hashCode() ^ this.a.hashCode();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).J() ? this.b.i(oVar) : this.a.i(oVar) : oVar.C(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s j(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).J() ? this.b.j(oVar) : this.a.j(oVar) : oVar.t(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    @Override // j$.time.temporal.Temporal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long l(Temporal temporal, j$.time.temporal.q qVar) {
        long jMultiplyExact;
        long j;
        LocalDateTime localDateTimeT = t(temporal);
        if (!(qVar instanceof j$.time.temporal.b)) {
            return qVar.o(this, localDateTimeT);
        }
        j$.time.temporal.b bVar = (j$.time.temporal.b) qVar;
        if (bVar.compareTo(j$.time.temporal.b.DAYS) >= 0) {
            LocalDate localDateR = localDateTimeT.a;
            LocalDate localDate = this.a;
            boolean z = false;
            if (localDate != null) {
                localDateR.getClass();
                if (localDateR.o(localDate) > 0) {
                    z = true;
                }
            } else if (localDateR.toEpochDay() > localDate.toEpochDay()) {
            }
            if (z && localDateTimeT.b.compareTo(this.b) < 0) {
                localDateR = localDateR.R(-1L);
            } else if (localDateR.K(this.a) && localDateTimeT.b.compareTo(this.b) > 0) {
                localDateR = localDateR.R(1L);
            }
            return this.a.l(localDateR, qVar);
        }
        LocalDate localDate2 = this.a;
        LocalDate localDate3 = localDateTimeT.a;
        localDate2.getClass();
        long epochDay = localDate3.toEpochDay() - localDate2.toEpochDay();
        if (epochDay == 0) {
            return this.b.l(localDateTimeT.b, qVar);
        }
        long jO = localDateTimeT.b.O() - this.b.O();
        if (epochDay > 0) {
            jMultiplyExact = epochDay - 1;
            j = jO + 86400000000000L;
        } else {
            jMultiplyExact = epochDay + 1;
            j = jO - 86400000000000L;
        }
        switch (h.a[bVar.ordinal()]) {
            case 1:
                jMultiplyExact = Math.multiplyExact(jMultiplyExact, 86400000000000L);
                break;
            case 2:
                jMultiplyExact = Math.multiplyExact(jMultiplyExact, 86400000000L);
                j /= 1000;
                break;
            case 3:
                jMultiplyExact = Math.multiplyExact(jMultiplyExact, TimeChart.DAY);
                j /= 1000000;
                break;
            case 4:
                jMultiplyExact = Math.multiplyExact(jMultiplyExact, 86400L);
                j /= 1000000000;
                break;
            case 5:
                jMultiplyExact = Math.multiplyExact(jMultiplyExact, 1440L);
                j /= 60000000000L;
                break;
            case 6:
                jMultiplyExact = Math.multiplyExact(jMultiplyExact, 24L);
                j /= 3600000000000L;
                break;
            case 7:
                jMultiplyExact = Math.multiplyExact(jMultiplyExact, 2L);
                j /= 43200000000000L;
                break;
        }
        return Math.addExact(jMultiplyExact, j);
    }

    public LocalDateTime minus(TemporalAmount temporalAmount) {
        if (!(temporalAmount instanceof Period)) {
            Objects.requireNonNull(temporalAmount, "amountToSubtract");
            return (LocalDateTime) temporalAmount.t(this);
        }
        Period period = (Period) temporalAmount;
        LocalDate localDate = this.a;
        localDate.getClass();
        long jB = period.b();
        LocalDate localDateS = jB == Long.MIN_VALUE ? localDate.S(Long.MAX_VALUE).S(1L) : localDate.S(-jB);
        long days = period.getDays();
        return L(days == Long.MIN_VALUE ? localDateS.R(Long.MAX_VALUE).R(1L) : localDateS.R(-days), this.b);
    }

    public final int o(LocalDateTime localDateTime) {
        int iO = this.a.o(localDateTime.toLocalDate());
        return iO == 0 ? this.b.compareTo(localDateTime.toLocalTime()) : iO;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.b;
    }

    public String toString() {
        return this.a.toString() + "T" + this.b.toString();
    }

    public final boolean x(ChronoLocalDateTime chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return o((LocalDateTime) chronoLocalDateTime) < 0;
        }
        long epochDay = ((LocalDate) toLocalDate()).toEpochDay();
        long epochDay2 = chronoLocalDateTime.toLocalDate().toEpochDay();
        return epochDay < epochDay2 || (epochDay == epochDay2 && toLocalTime().O() < chronoLocalDateTime.toLocalTime().O());
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public LocalDate toLocalDate() {
        return this.a;
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final Temporal k(LocalDate localDate) {
        return L(localDate, this.b);
    }

    public static LocalDateTime of(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new LocalDateTime(LocalDate.of(i, i2, i3), LocalTime.of(i4, i5, i6, i7));
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
}
