package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class x {
    public final TemporalAccessor a;
    public final DateTimeFormatter b;
    public int c;

    public x(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        j$.time.chrono.k kVar = dateTimeFormatter.e;
        if (kVar != null) {
            j$.time.chrono.k kVar2 = (j$.time.chrono.k) temporalAccessor.d(j$.time.temporal.p.b);
            ZoneId zoneId = (ZoneId) temporalAccessor.d(j$.time.temporal.p.a);
            j$.time.chrono.b bVarY = null;
            kVar = Objects.equals(kVar, kVar2) ? null : kVar;
            if (kVar != null) {
                j$.time.chrono.k kVar3 = kVar != null ? kVar : kVar2;
                if (kVar != null) {
                    if (temporalAccessor.h(j$.time.temporal.a.EPOCH_DAY)) {
                        bVarY = kVar3.y(temporalAccessor);
                    } else if (kVar != j$.time.chrono.r.c || kVar2 != null) {
                        for (j$.time.temporal.a aVar : j$.time.temporal.a.values()) {
                            if (aVar.isDateBased() && temporalAccessor.h(aVar)) {
                                throw new j$.time.c("Unable to apply override chronology '" + kVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new w(bVarY, temporalAccessor, kVar3, zoneId);
            }
        }
        this.a = temporalAccessor;
        this.b = dateTimeFormatter;
    }

    public final Long a(j$.time.temporal.o oVar) {
        int i = this.c;
        TemporalAccessor temporalAccessor = this.a;
        if (i <= 0 || temporalAccessor.h(oVar)) {
            return Long.valueOf(temporalAccessor.i(oVar));
        }
        return null;
    }

    public final Object b(j$.time.s sVar) {
        TemporalAccessor temporalAccessor = this.a;
        Object objD = temporalAccessor.d(sVar);
        if (objD != null || this.c != 0) {
            return objD;
        }
        throw new j$.time.c("Unable to extract " + sVar + " from temporal " + temporalAccessor);
    }

    public final String toString() {
        return this.a.toString();
    }
}
