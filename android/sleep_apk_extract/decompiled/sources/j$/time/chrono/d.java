package j$.time.chrono;

import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements b, Temporal, j$.time.temporal.m, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public static b o(k kVar, Temporal temporal) {
        b bVar = (b) temporal;
        if (kVar.equals(bVar.getChronology())) {
            return bVar;
        }
        j$.time.g.e("Chronology mismatch, expected: ", kVar.getId(), bVar.getChronology().getId());
        return null;
    }

    public abstract b C(long j);

    @Override // j$.time.chrono.b
    public b D(TemporalAmount temporalAmount) {
        return o(getChronology(), temporalAmount.o(this));
    }

    public abstract b H(long j);

    @Override // j$.time.temporal.Temporal
    public b a(long j, j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.r(j$.time.d.a("Unsupported field: ", oVar));
        }
        return o(getChronology(), oVar.H(this, j));
    }

    @Override // j$.time.temporal.Temporal
    public b b(long j, j$.time.temporal.q qVar) {
        boolean z = qVar instanceof j$.time.temporal.b;
        if (!z) {
            if (!z) {
                return o(getChronology(), qVar.t(this, j));
            }
            j$.time.g.d("Unsupported unit: ", qVar);
            return null;
        }
        switch (c.a[((j$.time.temporal.b) qVar).ordinal()]) {
            case 1:
                return x(j);
            case 2:
                return x(Math.multiplyExact(j, 7L));
            case 3:
                return C(j);
            case 4:
                return H(j);
            case 5:
                return H(Math.multiplyExact(j, 10L));
            case 6:
                return H(Math.multiplyExact(j, 100L));
            case 7:
                return H(Math.multiplyExact(j, 1000L));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return a(Math.addExact(i(aVar), j), (j$.time.temporal.o) aVar);
            default:
                j$.time.g.d("Unsupported unit: ", qVar);
                return null;
        }
    }

    @Override // j$.time.chrono.b, j$.time.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal c(long j, j$.time.temporal.q qVar) {
        return c(j, qVar);
    }

    @Override // j$.time.chrono.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }

    @Override // j$.time.chrono.b
    public int hashCode() {
        long epochDay = toEpochDay();
        return getChronology().hashCode() ^ ((int) (epochDay ^ (epochDay >>> 32)));
    }

    @Override // j$.time.temporal.Temporal
    public b k(j$.time.temporal.m mVar) {
        return o(getChronology(), mVar.f(this));
    }

    @Override // j$.time.chrono.b, j$.time.temporal.Temporal
    public final long l(Temporal temporal, j$.time.temporal.q qVar) {
        Objects.requireNonNull(temporal, "endExclusive");
        b bVarY = getChronology().y(temporal);
        if (!(qVar instanceof j$.time.temporal.b)) {
            Objects.requireNonNull(qVar, "unit");
            return qVar.o(this, bVarY);
        }
        switch (c.a[((j$.time.temporal.b) qVar).ordinal()]) {
            case 1:
                return bVarY.toEpochDay() - toEpochDay();
            case 2:
                return (bVarY.toEpochDay() - toEpochDay()) / 7;
            case 3:
                return t(bVarY);
            case 4:
                return t(bVarY) / 12;
            case 5:
                return t(bVarY) / 120;
            case 6:
                return t(bVarY) / 1200;
            case 7:
                return t(bVarY) / 12000;
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return bVarY.i(aVar) - i(aVar);
            default:
                j$.time.g.d("Unsupported unit: ", qVar);
                return 0L;
        }
    }

    public final long t(b bVar) {
        if (getChronology().s(j$.time.temporal.a.MONTH_OF_YEAR).d != 12) {
            throw new IllegalStateException("ChronoLocalDateImpl only supports Chronologies with 12 months per year");
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        long jI = i(aVar) * 32;
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_MONTH;
        return (((bVar.i(aVar) * 32) + ((long) bVar.g(aVar2))) - (jI + ((long) g(aVar2)))) / 32;
    }

    @Override // j$.time.chrono.b
    public final String toString() {
        long jI = i(j$.time.temporal.a.YEAR_OF_ERA);
        long jI2 = i(j$.time.temporal.a.MONTH_OF_YEAR);
        long jI3 = i(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(getChronology().toString());
        sb.append(" ");
        sb.append(getEra());
        sb.append(" ");
        sb.append(jI);
        sb.append(jI2 < 10 ? "-0" : "-");
        sb.append(jI2);
        sb.append(jI3 < 10 ? "-0" : "-");
        sb.append(jI3);
        return sb.toString();
    }

    public abstract b x(long j);
}
