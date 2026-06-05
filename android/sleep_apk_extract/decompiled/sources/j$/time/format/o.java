package j$.time.format;

import j$.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends i {
    public static final LocalDate h = LocalDate.of(2000, 1, 1);
    public final j$.time.chrono.b g;

    public o(j$.time.temporal.o oVar, int i, int i2, j$.time.chrono.b bVar, int i3) {
        super(oVar, i, i2, e0.NOT_NEGATIVE, i3);
        this.g = bVar;
    }

    @Override // j$.time.format.i
    public final long a(x xVar, long j) {
        long jAbs = Math.abs(j);
        j$.time.chrono.b bVar = this.g;
        long jG = bVar != null ? j$.time.chrono.k.n(xVar.a).y(bVar).g(this.a) : 0;
        long[] jArr = i.f;
        if (j >= jG) {
            long j2 = jArr[this.b];
            if (j < jG + j2) {
                return jAbs % j2;
            }
        }
        return jAbs % jArr[this.c];
    }

    @Override // j$.time.format.i
    public final boolean b(v vVar) {
        if (vVar.c) {
            return super.b(vVar);
        }
        return false;
    }

    @Override // j$.time.format.i
    public final int c(final v vVar, long j, final int i, final int i2) {
        final o oVar;
        v vVar2;
        final long j2;
        int iG;
        long j3;
        j$.time.chrono.b bVar = this.g;
        if (bVar != null) {
            j$.time.chrono.k kVar = vVar.c().c;
            if (kVar == null && (kVar = vVar.a.e) == null) {
                kVar = j$.time.chrono.r.c;
            }
            iG = kVar.y(bVar).g(this.a);
            oVar = this;
            j2 = j;
            Consumer consumer = new Consumer() { // from class: j$.time.format.n
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.c(vVar, j2, i, i2);
                }
            };
            vVar2 = vVar;
            if (vVar2.e == null) {
                vVar2.e = new ArrayList();
            }
            vVar2.e.add(consumer);
        } else {
            oVar = this;
            vVar2 = vVar;
            j2 = j;
            iG = 0;
        }
        int i3 = i2 - i;
        int i4 = oVar.b;
        if (i3 != i4 || j2 < 0) {
            j3 = j2;
        } else {
            long j4 = i.f[i4];
            long j5 = iG;
            long j6 = j5 - (j5 % j4);
            long j7 = iG > 0 ? j6 + j2 : j6 - j2;
            j3 = j7 < j5 ? j4 + j7 : j7;
        }
        return vVar2.f(oVar.a, j3, i, i2);
    }

    @Override // j$.time.format.i
    public final i d() {
        if (this.e == -1) {
            return this;
        }
        return new o(this.a, this.b, this.c, this.g, -1);
    }

    @Override // j$.time.format.i
    public final i e(int i) {
        return new o(this.a, this.b, this.c, this.g, this.e + i);
    }

    @Override // j$.time.format.i
    public final String toString() {
        j$.time.chrono.b bVar = this.g;
        return "ReducedValue(" + this.a + "," + this.b + "," + this.c + "," + (bVar != null ? bVar : 0) + ")";
    }
}
