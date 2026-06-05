package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public interface k extends Comparable {
    static k n(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        k kVar = (k) temporalAccessor.d(j$.time.temporal.p.b);
        r rVar = r.c;
        if (kVar != null) {
            return kVar;
        }
        Objects.requireNonNull(rVar, "defaultObj");
        return rVar;
    }

    static k of(String str) {
        ConcurrentHashMap concurrentHashMap = a.a;
        Objects.requireNonNull(str, "id");
        while (true) {
            ConcurrentHashMap concurrentHashMap2 = a.a;
            k kVar = (k) concurrentHashMap2.get(str);
            if (kVar == null) {
                kVar = (k) a.b.get(str);
            }
            if (kVar != null) {
                return kVar;
            }
            if (concurrentHashMap2.get("ISO") != null) {
                for (k kVar2 : ServiceLoader.load(k.class)) {
                    if (str.equals(kVar2.getId()) || str.equals(kVar2.getCalendarType())) {
                        return kVar2;
                    }
                }
                j$.time.g.a("Unknown chronology: ".concat(str));
                return null;
            }
            n nVar = n.l;
            nVar.getClass();
            a.t(nVar, "Hijrah-umalqura");
            u uVar = u.c;
            uVar.getClass();
            a.t(uVar, "Japanese");
            z zVar = z.c;
            zVar.getClass();
            a.t(zVar, "Minguo");
            f0 f0Var = f0.c;
            f0Var.getClass();
            a.t(f0Var, "ThaiBuddhist");
            try {
                for (a aVar : Arrays.asList(new a[0])) {
                    if (!aVar.getId().equals("ISO")) {
                        a.t(aVar, aVar.getId());
                    }
                }
                r rVar = r.c;
                rVar.getClass();
                a.t(rVar, "ISO");
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    default ChronoLocalDateTime A(TemporalAccessor temporalAccessor) {
        try {
            return y(temporalAccessor).z(LocalTime.x(temporalAccessor));
        } catch (j$.time.c e) {
            throw new j$.time.c("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + temporalAccessor.getClass(), e);
        }
    }

    b E(Map map, j$.time.format.d0 d0Var);

    ChronoZonedDateTime F(Instant instant, ZoneId zoneId);

    b date(int i, int i2, int i3);

    b dateEpochDay(long j);

    b dateNow();

    b dateYearDay(int i, int i2);

    boolean equals(Object obj);

    l eraOf(int i);

    List eras();

    String getCalendarType();

    String getId();

    int hashCode();

    boolean isLeapYear(long j);

    default ChronoZonedDateTime q(TemporalAccessor temporalAccessor) {
        try {
            ZoneId zoneIdO = ZoneId.o(temporalAccessor);
            try {
                return F(Instant.from(temporalAccessor), zoneIdO);
            } catch (j$.time.c unused) {
                return j.t(zoneIdO, null, f.o(this, this.A(temporalAccessor)));
            }
        } catch (j$.time.c e) {
            throw new j$.time.c("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + temporalAccessor.getClass(), e);
        }
    }

    j$.time.temporal.s s(j$.time.temporal.a aVar);

    String toString();

    int u(l lVar, int i);

    b y(TemporalAccessor temporalAccessor);
}
