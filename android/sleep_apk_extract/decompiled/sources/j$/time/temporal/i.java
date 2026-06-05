package j$.time.temporal;

import j$.time.Duration;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public enum i implements q {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");

    public final String a;

    static {
        Duration.x(31556952L, 0);
        Duration.x(7889238L, 0);
    }

    i(String str) {
        this.a = str;
    }

    @Override // j$.time.temporal.q
    public final long o(Temporal temporal, Temporal temporal2) {
        if (temporal.getClass() != temporal2.getClass()) {
            return temporal.l(temporal2, this);
        }
        int i = c.a[ordinal()];
        if (i == 1) {
            h hVar = j.c;
            return Math.subtractExact(temporal2.i(hVar), temporal.i(hVar));
        }
        if (i == 2) {
            return temporal.l(temporal2, b.MONTHS) / 3;
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // j$.time.temporal.q
    public final Temporal t(Temporal temporal, long j) {
        int i = c.a[ordinal()];
        if (i == 1) {
            return temporal.a(Math.addExact(temporal.g(r4), j), j.c);
        }
        if (i == 2) {
            return temporal.b(j / 4, b.YEARS).b((j % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }
}
