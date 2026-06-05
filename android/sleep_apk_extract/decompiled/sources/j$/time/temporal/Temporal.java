package j$.time.temporal;

import j$.time.LocalDate;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public interface Temporal extends TemporalAccessor {
    Temporal a(long j, o oVar);

    Temporal b(long j, q qVar);

    default Temporal c(long j, q qVar) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = b(Long.MAX_VALUE, qVar);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.b(j2, qVar);
    }

    /* JADX INFO: renamed from: e */
    default Temporal k(LocalDate localDate) {
        return localDate.f(this);
    }

    long l(Temporal temporal, q qVar);
}
