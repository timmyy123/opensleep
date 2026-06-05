package j$.time.chrono;

import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public interface l extends TemporalAccessor, j$.time.temporal.m {
    @Override // j$.time.temporal.TemporalAccessor
    default Object d(j$.time.s sVar) {
        return sVar == j$.time.temporal.p.c ? j$.time.temporal.b.ERAS : super.d(sVar);
    }

    @Override // j$.time.temporal.m
    default Temporal f(Temporal temporal) {
        return temporal.a(getValue(), j$.time.temporal.a.ERA);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int g(j$.time.temporal.o oVar) {
        return oVar == j$.time.temporal.a.ERA ? getValue() : super.g(oVar);
    }

    int getValue();

    @Override // j$.time.temporal.TemporalAccessor
    default boolean h(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.ERA : oVar != null && oVar.o(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long i(j$.time.temporal.o oVar) {
        if (oVar == j$.time.temporal.a.ERA) {
            return getValue();
        }
        if (oVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.r(j$.time.d.a("Unsupported field: ", oVar));
        }
        return oVar.C(this);
    }
}
