package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class z extends a implements Serializable {
    public static final z c = new z();
    private static final long serialVersionUID = 1039765215346859963L;

    private z() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.a, j$.time.chrono.k
    public final b E(Map map, j$.time.format.d0 d0Var) {
        return (b0) super.E(map, d0Var);
    }

    @Override // j$.time.chrono.k
    public final ChronoZonedDateTime F(Instant instant, ZoneId zoneId) {
        return j.x(this, instant, zoneId);
    }

    @Override // j$.time.chrono.k
    public final b date(int i, int i2, int i3) {
        return new b0(LocalDate.of(i + 1911, i2, i3));
    }

    @Override // j$.time.chrono.k
    public final b dateEpochDay(long j) {
        return new b0(LocalDate.O(j));
    }

    @Override // j$.time.chrono.k
    public final b dateNow() {
        return new b0(LocalDate.x(LocalDate.N(new j$.time.a(ZoneId.systemDefault()))));
    }

    @Override // j$.time.chrono.k
    public final b dateYearDay(int i, int i2) {
        return new b0(LocalDate.P(i + 1911, i2));
    }

    @Override // j$.time.chrono.k
    public final l eraOf(int i) {
        if (i == 0) {
            return c0.BEFORE_ROC;
        }
        if (i == 1) {
            return c0.ROC;
        }
        j$.time.g.b("Invalid era: ", i);
        return null;
    }

    @Override // j$.time.chrono.k
    public final List eras() {
        return j$.time.b.c(c0.values());
    }

    @Override // j$.time.chrono.k
    public final String getCalendarType() {
        return "roc";
    }

    @Override // j$.time.chrono.k
    public final String getId() {
        return "Minguo";
    }

    @Override // j$.time.chrono.k
    public final boolean isLeapYear(long j) {
        return r.c.isLeapYear(j + 1911);
    }

    @Override // j$.time.chrono.k
    public final j$.time.temporal.s s(j$.time.temporal.a aVar) {
        int i = y.a[aVar.ordinal()];
        if (i == 1) {
            j$.time.temporal.s sVar = j$.time.temporal.a.PROLEPTIC_MONTH.b;
            return j$.time.temporal.s.f(sVar.a - 22932, sVar.d - 22932);
        }
        if (i == 2) {
            j$.time.temporal.s sVar2 = j$.time.temporal.a.YEAR.b;
            return j$.time.temporal.s.g(1L, sVar2.d - 1911, (-sVar2.a) + 1912);
        }
        if (i != 3) {
            return aVar.b;
        }
        j$.time.temporal.s sVar3 = j$.time.temporal.a.YEAR.b;
        return j$.time.temporal.s.f(sVar3.a - 1911, sVar3.d - 1911);
    }

    @Override // j$.time.chrono.k
    public final int u(l lVar, int i) {
        if (lVar instanceof c0) {
            return lVar == c0.ROC ? i : 1 - i;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    public Object writeReplace() {
        return new d0((byte) 1, this);
    }

    @Override // j$.time.chrono.k
    public final b y(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof b0 ? (b0) temporalAccessor : new b0(LocalDate.x(temporalAccessor));
    }
}
