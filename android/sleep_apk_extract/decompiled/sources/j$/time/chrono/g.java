package j$.time.chrono;

import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements TemporalAmount, Serializable {
    public static final /* synthetic */ int e = 0;
    private static final long serialVersionUID = 57387258289L;
    public final k a;
    public final int b;
    public final int c;
    public final int d;

    static {
        j$.time.b.c(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public g(k kVar, int i, int i2, int i3) {
        this.a = kVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final long a() {
        j$.time.temporal.s sVarS = this.a.s(j$.time.temporal.a.MONTH_OF_YEAR);
        if (sVarS.a == sVarS.b && sVarS.c == sVarS.d && sVarS.d()) {
            return (sVarS.d - sVarS.a) + 1;
        }
        return -1L;
    }

    public final void b(TemporalAccessor temporalAccessor) {
        k kVar = (k) temporalAccessor.d(j$.time.temporal.p.b);
        if (kVar == null || this.a.equals(kVar)) {
            return;
        }
        j$.time.g.f("Chronology mismatch, expected: ", this.a.getId(), ", actual: ", kVar.getId());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.b == gVar.b && this.c == gVar.c && this.d == gVar.d && this.a.equals(gVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ (Integer.rotateLeft(this.d, 16) + (Integer.rotateLeft(this.c, 8) + this.b));
    }

    @Override // j$.time.temporal.TemporalAmount
    public final Temporal o(Temporal temporal) {
        b(temporal);
        if (this.c == 0) {
            int i = this.b;
            if (i != 0) {
                temporal = temporal.b(i, j$.time.temporal.b.YEARS);
            }
        } else {
            long jA = a();
            int i2 = this.b;
            if (jA > 0) {
                temporal = temporal.b((((long) i2) * jA) + ((long) this.c), j$.time.temporal.b.MONTHS);
            } else {
                if (i2 != 0) {
                    temporal = temporal.b(i2, j$.time.temporal.b.YEARS);
                }
                temporal = temporal.b(this.c, j$.time.temporal.b.MONTHS);
            }
        }
        int i3 = this.d;
        return i3 != 0 ? temporal.b(i3, j$.time.temporal.b.DAYS) : temporal;
    }

    @Override // j$.time.temporal.TemporalAmount
    public final Temporal t(Temporal temporal) {
        b(temporal);
        if (this.c == 0) {
            int i = this.b;
            if (i != 0) {
                temporal = temporal.c(i, j$.time.temporal.b.YEARS);
            }
        } else {
            long jA = a();
            int i2 = this.b;
            if (jA > 0) {
                temporal = temporal.c((((long) i2) * jA) + ((long) this.c), j$.time.temporal.b.MONTHS);
            } else {
                if (i2 != 0) {
                    temporal = temporal.c(i2, j$.time.temporal.b.YEARS);
                }
                temporal = temporal.c(this.c, j$.time.temporal.b.MONTHS);
            }
        }
        int i3 = this.d;
        return i3 != 0 ? temporal.c(i3, j$.time.temporal.b.DAYS) : temporal;
    }

    public final String toString() {
        if (this.b == 0 && this.c == 0 && this.d == 0) {
            return this.a.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.toString());
        sb.append(" P");
        int i = this.b;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.c;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.d;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    public Object writeReplace() {
        return new d0((byte) 9, this);
    }
}
