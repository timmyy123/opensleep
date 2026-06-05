package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class w extends d {
    public static final LocalDate d = LocalDate.of(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    public final transient LocalDate a;
    public final transient x b;
    public final transient int c;

    public w(LocalDate localDate) {
        if (localDate.K(d)) {
            j$.time.g.a("JapaneseDate before Meiji 6 is not supported");
            throw null;
        }
        x xVarN = x.n(localDate);
        this.b = xVarN;
        this.c = (localDate.getYear() - xVarN.b.getYear()) + 1;
        this.a = localDate;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new d0((byte) 4, this);
    }

    @Override // j$.time.chrono.d
    public final b C(long j) {
        return K(this.a.S(j));
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b D(TemporalAmount temporalAmount) {
        return (w) super.D(temporalAmount);
    }

    @Override // j$.time.chrono.d
    public final b H(long j) {
        return K(this.a.U(j));
    }

    public final w I(long j, j$.time.temporal.b bVar) {
        return (w) super.b(j, (j$.time.temporal.q) bVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.Temporal
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final w a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return (w) super.a(j, oVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        if (i(aVar) == j) {
            return this;
        }
        int[] iArr = v.a;
        int i = iArr[aVar.ordinal()];
        if (i == 3 || i == 8 || i == 9) {
            u uVar = u.c;
            int iA = uVar.s(aVar).a(j, aVar);
            int i2 = iArr[aVar.ordinal()];
            if (i2 == 3) {
                return K(this.a.Y(uVar.u(this.b, iA)));
            }
            if (i2 == 8) {
                return K(this.a.Y(uVar.u(x.q(iA), this.c)));
            }
            if (i2 == 9) {
                return K(this.a.Y(iA));
            }
        }
        return K(this.a.a(j, oVar));
    }

    public final w K(LocalDate localDate) {
        return localDate.equals(this.a) ? this : new w(localDate);
    }

    public final w L(j$.time.s sVar) {
        return (w) super.k(sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.Temporal
    public final b b(long j, j$.time.temporal.q qVar) {
        return (w) super.b(j, qVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.Temporal
    public final b c(long j, j$.time.temporal.q qVar) {
        return (w) super.c(j, qVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final Temporal k(LocalDate localDate) {
        return (w) super.k(localDate);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return this.a.equals(((w) obj).a);
        }
        return false;
    }

    @Override // j$.time.chrono.b
    public final k getChronology() {
        return u.c;
    }

    @Override // j$.time.chrono.b
    public final l getEra() {
        return this.b;
    }

    @Override // j$.time.chrono.b, j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.o oVar) {
        if (oVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || oVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || oVar == j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH || oVar == j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).isDateBased() : oVar != null && oVar.o(this);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        u.c.getClass();
        return this.a.hashCode() ^ (-688086063);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar.C(this);
        }
        switch (v.a[((j$.time.temporal.a) oVar).ordinal()]) {
            case 2:
                int i = this.c;
                LocalDate localDate = this.a;
                return i == 1 ? (localDate.I() - this.b.b.I()) + 1 : localDate.I();
            case 3:
                return this.c;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new j$.time.temporal.r(j$.time.d.a("Unsupported field: ", oVar));
            case 8:
                return this.b.a;
            default:
                return this.a.i(oVar);
        }
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
        int i = v.a[aVar.ordinal()];
        if (i == 1) {
            return j$.time.temporal.s.f(1L, this.a.lengthOfMonth());
        }
        if (i == 2) {
            return j$.time.temporal.s.f(1L, lengthOfYear());
        }
        if (i != 3) {
            return u.c.s(aVar);
        }
        int year = this.b.b.getYear();
        return this.b.o() != null ? j$.time.temporal.s.f(1L, (r5.b.getYear() - year) + 1) : j$.time.temporal.s.f(1L, 999999999 - year);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b k(j$.time.temporal.m mVar) {
        return (w) super.k(mVar);
    }

    @Override // j$.time.chrono.b
    public final int lengthOfYear() {
        x xVarO = this.b.o();
        int iLengthOfYear = (xVarO == null || xVarO.b.getYear() != this.a.getYear()) ? this.a.lengthOfYear() : xVarO.b.I() - 1;
        return this.c == 1 ? iLengthOfYear - (this.b.b.I() - 1) : iLengthOfYear;
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
        return (w) super.b(j, qVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.Temporal
    public final Temporal c(long j, j$.time.temporal.q qVar) {
        return (w) super.c(j, qVar);
    }

    public w(x xVar, int i, LocalDate localDate) {
        if (!localDate.K(d)) {
            this.b = xVar;
            this.c = i;
            this.a = localDate;
            return;
        }
        j$.time.g.a("JapaneseDate before Meiji 6 is not supported");
        throw null;
    }
}
