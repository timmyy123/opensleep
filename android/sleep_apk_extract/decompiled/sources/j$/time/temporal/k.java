package j$.time.temporal;

import j$.time.format.c0;
import j$.time.format.d0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public enum k implements o {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;
    public final transient String a;
    public final transient s b;
    public final transient long c;

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j) {
        this.a = str;
        this.b = s.f((-365243219162L) + j, 365241780471L + j);
        this.c = j;
    }

    @Override // j$.time.temporal.o
    public final long C(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(a.EPOCH_DAY) + this.c;
    }

    @Override // j$.time.temporal.o
    public final Temporal H(Temporal temporal, long j) {
        if (this.b.e(j)) {
            return temporal.a(Math.subtractExact(j, this.c), a.EPOCH_DAY);
        }
        throw new j$.time.c("Invalid value: " + this.a + " " + j);
    }

    @Override // j$.time.temporal.o
    public final boolean isDateBased() {
        return true;
    }

    @Override // j$.time.temporal.o
    public final boolean o(TemporalAccessor temporalAccessor) {
        return temporalAccessor.h(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.o
    public final s range() {
        return this.b;
    }

    @Override // j$.time.temporal.o
    public final s t(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.h(a.EPOCH_DAY)) {
            return this.b;
        }
        j$.time.g.i("Unsupported field: ", this);
        return null;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }

    @Override // j$.time.temporal.o
    public final TemporalAccessor x(Map map, c0 c0Var, d0 d0Var) {
        long jLongValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.k kVarN = j$.time.chrono.k.n(c0Var);
        d0 d0Var2 = d0.LENIENT;
        long j = this.c;
        if (d0Var == d0Var2) {
            return kVarN.dateEpochDay(Math.subtractExact(jLongValue, j));
        }
        this.b.b(jLongValue, this);
        return kVarN.dateEpochDay(jLongValue - j);
    }
}
