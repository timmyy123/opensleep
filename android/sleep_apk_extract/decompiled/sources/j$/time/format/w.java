package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements TemporalAccessor {
    public final /* synthetic */ j$.time.chrono.b a;
    public final /* synthetic */ TemporalAccessor b;
    public final /* synthetic */ j$.time.chrono.k c;
    public final /* synthetic */ ZoneId d;

    public w(j$.time.chrono.b bVar, TemporalAccessor temporalAccessor, j$.time.chrono.k kVar, ZoneId zoneId) {
        this.a = bVar;
        this.b = temporalAccessor;
        this.c = kVar;
        this.d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object d(j$.time.s sVar) {
        return sVar == j$.time.temporal.p.b ? this.c : sVar == j$.time.temporal.p.a ? this.d : sVar == j$.time.temporal.p.c ? this.b.d(sVar) : sVar.j(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.o oVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !oVar.isDateBased()) ? this.b.h(oVar) : bVar.h(oVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !oVar.isDateBased()) ? this.b.i(oVar) : bVar.i(oVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s j(j$.time.temporal.o oVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !oVar.isDateBased()) ? this.b.j(oVar) : bVar.j(oVar);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.k kVar = this.c;
        if (kVar != null) {
            str = " with chronology " + kVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.b + str + str2;
    }
}
