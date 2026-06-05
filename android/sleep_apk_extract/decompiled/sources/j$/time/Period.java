package j$.time;

import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class Period implements TemporalAmount, Serializable {
    public static final Period d = new Period(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;
    public final int a;
    public final int b;
    public final int c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        b.c(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public Period(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static Period a(int i, int i2, int i3) {
        return ((i | i2) | i3) == 0 ? d : new Period(i, i2, i3);
    }

    public static void c(TemporalAccessor temporalAccessor) {
        j$.time.chrono.k kVar = (j$.time.chrono.k) temporalAccessor.d(j$.time.temporal.p.b);
        if (kVar == null || j$.time.chrono.r.c.equals(kVar)) {
            return;
        }
        throw new c("Chronology mismatch, expected: ISO, actual: " + kVar.getId());
    }

    public static Period of(int i, int i2, int i3) {
        return a(i, i2, i3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new o(MqttWireMessage.MESSAGE_TYPE_DISCONNECT, this);
    }

    public final long b() {
        return (((long) this.a) * 12) + ((long) this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Period) {
            Period period = (Period) obj;
            if (this.a == period.a && this.b == period.b && this.c == period.c) {
                return true;
            }
        }
        return false;
    }

    public int getDays() {
        return this.c;
    }

    public int getMonths() {
        return this.b;
    }

    public int getYears() {
        return this.a;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.c, 16) + Integer.rotateLeft(this.b, 8) + this.a;
    }

    @Override // j$.time.temporal.TemporalAmount
    public final Temporal o(Temporal temporal) {
        c(temporal);
        if (this.b == 0) {
            int i = this.a;
            if (i != 0) {
                temporal = temporal.b(i, j$.time.temporal.b.YEARS);
            }
        } else {
            long jB = b();
            if (jB != 0) {
                temporal = temporal.b(jB, j$.time.temporal.b.MONTHS);
            }
        }
        int i2 = this.c;
        return i2 != 0 ? temporal.b(i2, j$.time.temporal.b.DAYS) : temporal;
    }

    @Override // j$.time.temporal.TemporalAmount
    public final Temporal t(Temporal temporal) {
        c(temporal);
        if (this.b == 0) {
            int i = this.a;
            if (i != 0) {
                temporal = temporal.c(i, j$.time.temporal.b.YEARS);
            }
        } else {
            long jB = b();
            if (jB != 0) {
                temporal = temporal.c(jB, j$.time.temporal.b.MONTHS);
            }
        }
        int i2 = this.c;
        return i2 != 0 ? temporal.c(i2, j$.time.temporal.b.DAYS) : temporal;
    }

    public final String toString() {
        if (this == d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i = this.a;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.b;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.c;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }
}
