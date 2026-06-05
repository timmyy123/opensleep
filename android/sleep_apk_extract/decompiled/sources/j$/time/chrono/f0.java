package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends a implements Serializable {
    public static final f0 c = new f0();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map.put("en", new String[]{"BB", "BE"});
        map.put("th", new String[]{"BB", "BE"});
        map2.put("en", new String[]{"B.B.", "B.E."});
        map2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        map3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        map3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private f0() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.a, j$.time.chrono.k
    public final b E(Map map, j$.time.format.d0 d0Var) {
        return (h0) super.E(map, d0Var);
    }

    @Override // j$.time.chrono.k
    public final ChronoZonedDateTime F(Instant instant, ZoneId zoneId) {
        return j.x(this, instant, zoneId);
    }

    @Override // j$.time.chrono.k
    public final b date(int i, int i2, int i3) {
        return new h0(LocalDate.of(i - 543, i2, i3));
    }

    @Override // j$.time.chrono.k
    public final b dateEpochDay(long j) {
        return new h0(LocalDate.O(j));
    }

    @Override // j$.time.chrono.k
    public final b dateNow() {
        return new h0(LocalDate.x(LocalDate.N(new j$.time.a(ZoneId.systemDefault()))));
    }

    @Override // j$.time.chrono.k
    public final b dateYearDay(int i, int i2) {
        return new h0(LocalDate.P(i - 543, i2));
    }

    @Override // j$.time.chrono.k
    public final l eraOf(int i) {
        if (i == 0) {
            return i0.BEFORE_BE;
        }
        if (i == 1) {
            return i0.BE;
        }
        j$.time.g.b("Invalid era: ", i);
        return null;
    }

    @Override // j$.time.chrono.k
    public final List eras() {
        return j$.time.b.c(i0.values());
    }

    @Override // j$.time.chrono.k
    public final String getCalendarType() {
        return "buddhist";
    }

    @Override // j$.time.chrono.k
    public final String getId() {
        return "ThaiBuddhist";
    }

    @Override // j$.time.chrono.k
    public final boolean isLeapYear(long j) {
        return r.c.isLeapYear(j - 543);
    }

    @Override // j$.time.chrono.k
    public final j$.time.temporal.s s(j$.time.temporal.a aVar) {
        int i = e0.a[aVar.ordinal()];
        if (i == 1) {
            j$.time.temporal.s sVar = j$.time.temporal.a.PROLEPTIC_MONTH.b;
            return j$.time.temporal.s.f(sVar.a + 6516, sVar.d + 6516);
        }
        if (i == 2) {
            j$.time.temporal.s sVar2 = j$.time.temporal.a.YEAR.b;
            return j$.time.temporal.s.g(1L, (-(sVar2.a + 543)) + 1, sVar2.d + 543);
        }
        if (i != 3) {
            return aVar.b;
        }
        j$.time.temporal.s sVar3 = j$.time.temporal.a.YEAR.b;
        return j$.time.temporal.s.f(sVar3.a + 543, sVar3.d + 543);
    }

    @Override // j$.time.chrono.k
    public final int u(l lVar, int i) {
        if (lVar instanceof i0) {
            return lVar == i0.BE ? i : 1 - i;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    public Object writeReplace() {
        return new d0((byte) 1, this);
    }

    @Override // j$.time.chrono.k
    public final b y(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof h0 ? (h0) temporalAccessor : new h0(LocalDate.x(temporalAccessor));
    }
}
