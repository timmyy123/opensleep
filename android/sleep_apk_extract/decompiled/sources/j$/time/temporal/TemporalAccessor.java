package j$.time.temporal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public interface TemporalAccessor {
    default Object d(j$.time.s sVar) {
        if (sVar == p.a || sVar == p.b || sVar == p.c) {
            return null;
        }
        return sVar.j(this);
    }

    default int g(o oVar) {
        s sVarJ = j(oVar);
        if (!sVarJ.d()) {
            throw new r("Invalid field " + oVar + " for get() method, use getLong() instead");
        }
        long jI = i(oVar);
        if (sVarJ.e(jI)) {
            return (int) jI;
        }
        throw new j$.time.c("Invalid value for " + oVar + " (valid values " + sVarJ + "): " + jI);
    }

    boolean h(o oVar);

    long i(o oVar);

    default s j(o oVar) {
        if (!(oVar instanceof a)) {
            Objects.requireNonNull(oVar, "field");
            return oVar.t(this);
        }
        if (h(oVar)) {
            return ((a) oVar).b;
        }
        throw new r(j$.time.d.a("Unsupported field: ", oVar));
    }
}
