package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class p extends d {
    private static final long serialVersionUID = -5207853542612002020L;
    public final transient n a;
    public final transient int b;
    public final transient int c;
    public final transient int d;

    public p(n nVar, long j) {
        int i = (int) j;
        nVar.J();
        if (i < nVar.e || i >= nVar.f) {
            j$.time.g.a("Hijrah date out of range");
            throw null;
        }
        int iBinarySearch = Arrays.binarySearch(nVar.d, i);
        iBinarySearch = iBinarySearch < 0 ? (-iBinarySearch) - 2 : iBinarySearch;
        int[] iArr = {nVar.L(iBinarySearch), ((nVar.g + iBinarySearch) % 12) + 1, (i - nVar.d[iBinarySearch]) + 1};
        this.a = nVar;
        this.b = iArr[0];
        this.c = iArr[1];
        this.d = iArr[2];
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new d0((byte) 6, this);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b D(TemporalAmount temporalAmount) {
        return (p) super.D(temporalAmount);
    }

    @Override // j$.time.chrono.d
    public final b H(long j) {
        return j == 0 ? this : L(Math.addExact(this.b, (int) j), this.c, this.d);
    }

    public final int I() {
        return this.a.P(this.b, this.c - 1) + this.d;
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final p x(long j) {
        return new p(this.a, toEpochDay() + j);
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final p C(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.b) * 12) + ((long) (this.c - 1)) + j;
        n nVar = this.a;
        long jFloorDiv = Math.floorDiv(j2, 12L);
        if (jFloorDiv >= nVar.L(0) && jFloorDiv <= nVar.L(nVar.d.length - 1) - 1) {
            return L((int) jFloorDiv, ((int) Math.floorMod(j2, 12L)) + 1, this.d);
        }
        throw new j$.time.c("Invalid Hijrah year: " + jFloorDiv);
    }

    public final p L(int i, int i2, int i3) {
        int iN = this.a.N(i, i2);
        if (i3 > iN) {
            i3 = iN;
        }
        return new p(this.a, i, i2, i3);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.Temporal
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public final p a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return (p) super.a(j, oVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        this.a.s(aVar).b(j, aVar);
        int i = (int) j;
        switch (o.a[aVar.ordinal()]) {
            case 1:
                return L(this.b, this.c, i);
            case 2:
                return x(Math.min(i, lengthOfYear()) - I());
            case 3:
                return x((j - i(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return x(j - ((long) (((int) Math.floorMod(toEpochDay() + 3, 7L)) + 1)));
            case 5:
                return x(j - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return x(j - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new p(this.a, j);
            case 8:
                return x((j - i(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return L(this.b, i, this.d);
            case 10:
                return C(j - (((((long) this.b) * 12) + ((long) this.c)) - 1));
            case 11:
                if (this.b < 1) {
                    i = 1 - i;
                }
                return L(i, this.c, this.d);
            case 12:
                return L(i, this.c, this.d);
            case 13:
                return L(1 - this.b, this.c, this.d);
            default:
                throw new j$.time.temporal.r(j$.time.d.a("Unsupported field: ", oVar));
        }
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.Temporal
    public final b b(long j, j$.time.temporal.q qVar) {
        return (p) super.b(j, qVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.Temporal
    public final b c(long j, j$.time.temporal.q qVar) {
        return (p) super.c(j, qVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final Temporal k(LocalDate localDate) {
        return (p) super.k(localDate);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.b == pVar.b && this.c == pVar.c && this.d == pVar.d && this.a.equals(pVar.a)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.b
    public final k getChronology() {
        return this.a;
    }

    @Override // j$.time.chrono.b
    public final l getEra() {
        return q.AH;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        int i = this.b;
        int i2 = this.c;
        int i3 = this.d;
        this.a.getClass();
        return ((i & (-2048)) ^ 2100100019) ^ (((i << 11) + (i2 << 6)) + i3);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        int I;
        int iFloorMod;
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar.C(this);
        }
        switch (o.a[((j$.time.temporal.a) oVar).ordinal()]) {
            case 1:
                I = this.d;
                return I;
            case 2:
                I = I();
                return I;
            case 3:
                iFloorMod = (this.d - 1) / 7;
                I = iFloorMod + 1;
                return I;
            case 4:
                iFloorMod = (int) Math.floorMod(toEpochDay() + 3, 7L);
                I = iFloorMod + 1;
                return I;
            case 5:
                iFloorMod = (this.d - 1) % 7;
                I = iFloorMod + 1;
                return I;
            case 6:
                iFloorMod = (I() - 1) % 7;
                I = iFloorMod + 1;
                return I;
            case 7:
                return toEpochDay();
            case 8:
                iFloorMod = (I() - 1) / 7;
                I = iFloorMod + 1;
                return I;
            case 9:
                I = this.c;
                return I;
            case 10:
                return ((((long) this.b) * 12) + ((long) this.c)) - 1;
            case 11:
                I = this.b;
                return I;
            case 12:
                I = this.b;
                return I;
            case 13:
                return this.b <= 1 ? 0 : 1;
            default:
                throw new j$.time.temporal.r(j$.time.d.a("Unsupported field: ", oVar));
        }
    }

    @Override // j$.time.chrono.b
    public final boolean isLeapYear() {
        return this.a.isLeapYear(this.b);
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
        int i = o.a[aVar.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? this.a.s(aVar) : j$.time.temporal.s.f(1L, 5L) : j$.time.temporal.s.f(1L, lengthOfYear()) : j$.time.temporal.s.f(1L, this.a.N(this.b, this.c));
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b k(j$.time.temporal.m mVar) {
        return (p) super.k(mVar);
    }

    @Override // j$.time.chrono.b
    public final int lengthOfYear() {
        return this.a.P(this.b, 12);
    }

    @Override // j$.time.chrono.b
    public final long toEpochDay() {
        return this.a.M(this.b, this.c, this.d);
    }

    @Override // j$.time.chrono.b
    public final ChronoLocalDateTime z(LocalTime localTime) {
        return new f(this, localTime);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.Temporal
    public final Temporal b(long j, j$.time.temporal.q qVar) {
        return (p) super.b(j, qVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.Temporal
    public final Temporal c(long j, j$.time.temporal.q qVar) {
        return (p) super.c(j, qVar);
    }

    public p(n nVar, int i, int i2, int i3) {
        nVar.M(i, i2, i3);
        this.a = nVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }
}
