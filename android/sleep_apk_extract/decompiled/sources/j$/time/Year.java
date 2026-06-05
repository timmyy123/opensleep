package j$.time;

import j$.time.format.d0;
import j$.time.format.e0;
import j$.time.format.u;
import j$.time.temporal.Temporal;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class Year implements Temporal, j$.time.temporal.m, Comparable<Year>, Serializable {
    public static final /* synthetic */ int b = 0;
    private static final long serialVersionUID = -23038383694477807L;
    public final int a;

    static {
        u uVar = new u();
        uVar.n(j$.time.temporal.a.YEAR, 4, 10, e0.EXCEEDS_PAD);
        uVar.r(Locale.getDefault(), d0.SMART, null);
    }

    public Year(int i) {
        this.a = i;
    }

    public static Year of(int i) {
        j$.time.temporal.a.YEAR.I(i);
        return new Year(i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new o(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this);
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
    public final int compareTo(Year year) {
        return this.a - year.a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object d(s sVar) {
        return sVar == j$.time.temporal.p.b ? j$.time.chrono.r.c : sVar == j$.time.temporal.p.c ? j$.time.temporal.b.YEARS : super.d(sVar);
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final Temporal k(LocalDate localDate) {
        return (Year) localDate.f(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Year) && this.a == ((Year) obj).a;
    }

    @Override // j$.time.temporal.m
    public final Temporal f(Temporal temporal) {
        if (j$.time.chrono.k.n(temporal).equals(j$.time.chrono.r.c)) {
            return temporal.a(this.a, j$.time.temporal.a.YEAR);
        }
        g.a("Adjustment only supported on ISO date-time");
        return null;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.o oVar) {
        return j(oVar).a(i(oVar), oVar);
    }

    public int getValue() {
        return this.a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.YEAR || oVar == j$.time.temporal.a.YEAR_OF_ERA || oVar == j$.time.temporal.a.ERA : oVar != null && oVar.o(this);
    }

    public final int hashCode() {
        return this.a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar.C(this);
        }
        int i = p.a[((j$.time.temporal.a) oVar).ordinal()];
        if (i == 1) {
            int i2 = this.a;
            if (i2 < 1) {
                i2 = 1 - i2;
            }
            return i2;
        }
        if (i == 2) {
            return this.a;
        }
        if (i == 3) {
            return this.a < 1 ? 0 : 1;
        }
        throw new j$.time.temporal.r(d.a("Unsupported field: ", oVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s j(j$.time.temporal.o oVar) {
        if (oVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.s.f(1L, this.a <= 0 ? 1000000000L : 999999999L);
        }
        return super.j(oVar);
    }

    @Override // j$.time.temporal.Temporal
    public final long l(Temporal temporal, j$.time.temporal.q qVar) {
        Year yearOf;
        if (temporal instanceof Year) {
            yearOf = (Year) temporal;
        } else {
            Objects.requireNonNull(temporal, "temporal");
            try {
                if (!j$.time.chrono.r.c.equals(j$.time.chrono.k.n(temporal))) {
                    temporal = LocalDate.x(temporal);
                }
                yearOf = of(temporal.g(j$.time.temporal.a.YEAR));
            } catch (c e) {
                g.g("Unable to obtain Year from TemporalAccessor: ", temporal, temporal.getClass().getName(), e);
                return 0L;
            }
        }
        if (!(qVar instanceof j$.time.temporal.b)) {
            return qVar.o(this, yearOf);
        }
        long j = ((long) yearOf.a) - ((long) this.a);
        int i = p.b[((j$.time.temporal.b) qVar).ordinal()];
        if (i == 1) {
            return j;
        }
        if (i == 2) {
            return j / 10;
        }
        if (i == 3) {
            return j / 100;
        }
        if (i == 4) {
            return j / 1000;
        }
        if (i == 5) {
            j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
            return yearOf.i(aVar) - i(aVar);
        }
        g.d("Unsupported unit: ", qVar);
        return 0L;
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final Year b(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.b)) {
            return (Year) qVar.t(this, j);
        }
        int i = p.b[((j$.time.temporal.b) qVar).ordinal()];
        if (i == 1) {
            return t(j);
        }
        if (i == 2) {
            return t(Math.multiplyExact(j, 10L));
        }
        if (i == 3) {
            return t(Math.multiplyExact(j, 100L));
        }
        if (i == 4) {
            return t(Math.multiplyExact(j, 1000L));
        }
        if (i == 5) {
            j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
            return a(Math.addExact(i(aVar), j), aVar);
        }
        g.d("Unsupported unit: ", qVar);
        return null;
    }

    public final Year t(long j) {
        if (j == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return of(aVar.b.a(((long) this.a) + j, aVar));
    }

    public final String toString() {
        return Integer.toString(this.a);
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public final Year a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return (Year) oVar.H(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        aVar.I(j);
        int i = p.a[aVar.ordinal()];
        if (i == 1) {
            if (this.a < 1) {
                j = 1 - j;
            }
            return of((int) j);
        }
        if (i == 2) {
            return of((int) j);
        }
        if (i == 3) {
            return i(j$.time.temporal.a.ERA) == j ? this : of(1 - this.a);
        }
        throw new j$.time.temporal.r(d.a("Unsupported field: ", oVar));
    }
}
