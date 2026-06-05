package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends d {
    private static final long serialVersionUID = 1300372329181994526L;
    public final transient LocalDate a;

    public b0(LocalDate localDate) {
        Objects.requireNonNull(localDate, "isoDate");
        this.a = localDate;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new d0((byte) 7, this);
    }

    @Override // j$.time.chrono.d
    public final b C(long j) {
        return K(this.a.S(j));
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b D(TemporalAmount temporalAmount) {
        return (b0) super.D(temporalAmount);
    }

    @Override // j$.time.chrono.d
    public final b H(long j) {
        return K(this.a.U(j));
    }

    public final int I() {
        return this.a.getYear() - 1911;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    @Override // j$.time.chrono.d, j$.time.temporal.Temporal
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b0 a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return (b0) super.a(j, oVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        if (i(aVar) == j) {
            return this;
        }
        int[] iArr = a0.a;
        int i = iArr[aVar.ordinal()];
        if (i == 4) {
            int iA = z.c.s(aVar).a(j, aVar);
            int i2 = iArr[aVar.ordinal()];
            if (i2 == 4) {
                return K(this.a.Y(I() >= 1 ? iA + 1911 : 1912 - iA));
            }
            if (i2 == 6) {
                return K(this.a.Y(iA + 1911));
            }
            if (i2 == 7) {
                return K(this.a.Y(1912 - I()));
            }
        } else {
            if (i == 5) {
                z.c.s(aVar).b(j, aVar);
                return K(this.a.S(j - (((((long) I()) * 12) + ((long) this.a.getMonthValue())) - 1)));
            }
            if (i == 6 || i == 7) {
            }
        }
        return K(this.a.a(j, oVar));
    }

    public final b0 K(LocalDate localDate) {
        return localDate.equals(this.a) ? this : new b0(localDate);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.Temporal
    public final b b(long j, j$.time.temporal.q qVar) {
        return (b0) super.b(j, qVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.Temporal
    public final b c(long j, j$.time.temporal.q qVar) {
        return (b0) super.c(j, qVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final Temporal k(LocalDate localDate) {
        return (b0) super.k(localDate);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b0) {
            return this.a.equals(((b0) obj).a);
        }
        return false;
    }

    @Override // j$.time.chrono.b
    public final k getChronology() {
        return z.c;
    }

    @Override // j$.time.chrono.b
    public final l getEra() {
        return I() >= 1 ? c0.ROC : c0.BEFORE_ROC;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        z.c.getClass();
        return this.a.hashCode() ^ (-1990173233);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar.C(this);
        }
        int i = a0.a[((j$.time.temporal.a) oVar).ordinal()];
        if (i == 4) {
            int I = I();
            if (I < 1) {
                I = 1 - I;
            }
            return I;
        }
        if (i == 5) {
            return ((((long) I()) * 12) + ((long) this.a.getMonthValue())) - 1;
        }
        if (i == 6) {
            return I();
        }
        if (i != 7) {
            return this.a.i(oVar);
        }
        return I() < 1 ? 0 : 1;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s j(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar.t(this);
        }
        if (!h(oVar)) {
            throw new j$.time.temporal.r(j$.time.d.a("Unsupported field: ", oVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        int i = a0.a[aVar.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return this.a.j(oVar);
        }
        if (i != 4) {
            return z.c.s(aVar);
        }
        j$.time.temporal.s sVar = j$.time.temporal.a.YEAR.b;
        return j$.time.temporal.s.f(1L, I() <= 0 ? (-sVar.a) + 1912 : sVar.d - 1911);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b k(j$.time.temporal.m mVar) {
        return (b0) super.k(mVar);
    }

    @Override // j$.time.chrono.b
    public final long toEpochDay() {
        return this.a.toEpochDay();
    }

    @Override // j$.time.chrono.d
    public final b x(long j) {
        return K(this.a.R(j));
    }

    @Override // j$.time.chrono.b
    public final ChronoLocalDateTime z(LocalTime localTime) {
        return new f(this, localTime);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.Temporal
    public final Temporal b(long j, j$.time.temporal.q qVar) {
        return (b0) super.b(j, qVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.Temporal
    public final Temporal c(long j, j$.time.temporal.q qVar) {
        return (b0) super.c(j, qVar);
    }
}
