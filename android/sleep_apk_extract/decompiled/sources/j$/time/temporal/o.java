package j$.time.temporal;

import j$.time.format.c0;
import j$.time.format.d0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public interface o {
    long C(TemporalAccessor temporalAccessor);

    Temporal H(Temporal temporal, long j);

    boolean isDateBased();

    boolean o(TemporalAccessor temporalAccessor);

    s range();

    s t(TemporalAccessor temporalAccessor);

    default TemporalAccessor x(Map map, c0 c0Var, d0 d0Var) {
        return null;
    }
}
