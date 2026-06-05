package j$.time;

import com.facebook.appevents.AppEventsConstants;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import org.achartengine.chart.TimeChart;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class LocalTime implements Temporal, j$.time.temporal.m, Comparable<LocalTime>, Serializable {
    public static final LocalTime e;
    public static final LocalTime f;
    public static final LocalTime g;
    public static final LocalTime[] h = new LocalTime[24];
    private static final long serialVersionUID = 6414437269572265201L;
    public final byte a;
    public final byte b;
    public final byte c;
    public final int d;

    static {
        int i = 0;
        while (true) {
            LocalTime[] localTimeArr = h;
            if (i >= localTimeArr.length) {
                LocalTime localTime = localTimeArr[0];
                g = localTime;
                LocalTime localTime2 = localTimeArr[12];
                e = localTime;
                f = new LocalTime(23, 59, 59, 999999999);
                return;
            }
            localTimeArr[i] = new LocalTime(i, 0, 0, 0);
            i++;
        }
    }

    public LocalTime(int i, int i2, int i3, int i4) {
        this.a = (byte) i;
        this.b = (byte) i2;
        this.c = (byte) i3;
        this.d = i4;
    }

    public static LocalTime H(long j) {
        j$.time.temporal.a.NANO_OF_DAY.I(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (((long) i) * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (((long) i2) * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        return t(i, i2, i3, (int) (j3 - (((long) i3) * 1000000000)));
    }

    public static LocalTime N(DataInput dataInput) throws IOException {
        int i;
        int i2;
        int i3 = dataInput.readByte();
        int i4 = 0;
        if (i3 < 0) {
            i3 = ~i3;
            i2 = 0;
            i = 0;
        } else {
            byte b = dataInput.readByte();
            if (b < 0) {
                int i5 = ~b;
                i = 0;
                i4 = i5;
                i2 = 0;
            } else {
                byte b2 = dataInput.readByte();
                if (b2 < 0) {
                    i2 = ~b2;
                    i = 0;
                    i4 = b;
                } else {
                    i = dataInput.readInt();
                    i4 = b;
                    i2 = b2;
                }
            }
        }
        return of(i3, i4, i2, i);
    }

    public static LocalTime of(int i, int i2, int i3, int i4) {
        j$.time.temporal.a.HOUR_OF_DAY.I(i);
        j$.time.temporal.a.MINUTE_OF_HOUR.I(i2);
        j$.time.temporal.a.SECOND_OF_MINUTE.I(i3);
        j$.time.temporal.a.NANO_OF_SECOND.I(i4);
        return t(i, i2, i3, i4);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static LocalTime t(int i, int i2, int i3, int i4) {
        return ((i2 | i3) | i4) == 0 ? h[i] : new LocalTime(i, i2, i3, i4);
    }

    private Object writeReplace() {
        return new o((byte) 4, this);
    }

    public static LocalTime x(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalTime localTime = (LocalTime) temporalAccessor.d(j$.time.temporal.p.g);
        if (localTime != null) {
            return localTime;
        }
        g.f("Unable to obtain LocalTime from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    public final int C(j$.time.temporal.o oVar) {
        switch (i.a[((j$.time.temporal.a) oVar).ordinal()]) {
            case 1:
                return this.d;
            case 2:
                throw new j$.time.temporal.r("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.d / 1000;
            case 4:
                throw new j$.time.temporal.r("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.d / 1000000;
            case 6:
                return (int) (O() / 1000000);
            case 7:
                return this.c;
            case 8:
                return P();
            case 9:
                return this.b;
            case 10:
                return (this.a * 60) + this.b;
            case 11:
                return this.a % MqttWireMessage.MESSAGE_TYPE_PINGREQ;
            case 12:
                int i = this.a % MqttWireMessage.MESSAGE_TYPE_PINGREQ;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 13:
                return this.a;
            case 14:
                byte b = this.a;
                if (b == 0) {
                    return 24;
                }
                return b;
            case 15:
                return this.a / MqttWireMessage.MESSAGE_TYPE_PINGREQ;
            default:
                throw new j$.time.temporal.r(d.a("Unsupported field: ", oVar));
        }
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final LocalTime b(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.b)) {
            return (LocalTime) qVar.t(this, j);
        }
        switch (i.b[((j$.time.temporal.b) qVar).ordinal()]) {
            case 1:
                return L(j);
            case 2:
                return L((j % 86400000000L) * 1000);
            case 3:
                return L((j % TimeChart.DAY) * 1000000);
            case 4:
                return M(j);
            case 5:
                return K(j);
            case 6:
                return J(j);
            case 7:
                return J((j % 2) * 12);
            default:
                g.d("Unsupported unit: ", qVar);
                return null;
        }
    }

    public final LocalTime J(long j) {
        return j == 0 ? this : t(((((int) (j % 24)) + this.a) + 24) % 24, this.b, this.c, this.d);
    }

    public final LocalTime K(long j) {
        if (j != 0) {
            int i = (this.a * 60) + this.b;
            int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
            if (i != i2) {
                return t(i2 / 60, i2 % 60, this.c, this.d);
            }
        }
        return this;
    }

    public final LocalTime L(long j) {
        if (j != 0) {
            long jO = O();
            long j2 = (((j % 86400000000000L) + jO) + 86400000000000L) % 86400000000000L;
            if (jO != j2) {
                return t((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
            }
        }
        return this;
    }

    public final LocalTime M(long j) {
        if (j != 0) {
            int i = (this.b * 60) + (this.a * 3600) + this.c;
            int i2 = ((((int) (j % 86400)) + i) + 86400) % 86400;
            if (i != i2) {
                return t(i2 / 3600, (i2 / 60) % 60, i2 % 60, this.d);
            }
        }
        return this;
    }

    public final long O() {
        return (((long) this.c) * 1000000000) + (((long) this.b) * 60000000000L) + (((long) this.a) * 3600000000000L) + ((long) this.d);
    }

    public final int P() {
        return (this.b * 60) + (this.a * 3600) + this.c;
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final LocalTime a(long j, j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return (LocalTime) oVar.H(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        aVar.I(j);
        switch (i.a[aVar.ordinal()]) {
            case 1:
                return R((int) j);
            case 2:
                return H(j);
            case 3:
                return R(((int) j) * 1000);
            case 4:
                return H(j * 1000);
            case 5:
                return R(((int) j) * 1000000);
            case 6:
                return H(j * 1000000);
            case 7:
                int i = (int) j;
                if (this.c != i) {
                    j$.time.temporal.a.SECOND_OF_MINUTE.I(i);
                    return t(this.a, this.b, i, this.d);
                }
                return this;
            case 8:
                return M(j - ((long) P()));
            case 9:
                int i2 = (int) j;
                if (this.b != i2) {
                    j$.time.temporal.a.MINUTE_OF_HOUR.I(i2);
                    return t(this.a, i2, this.c, this.d);
                }
                return this;
            case 10:
                return K(j - ((long) ((this.a * 60) + this.b)));
            case 11:
                return J(j - ((long) (this.a % MqttWireMessage.MESSAGE_TYPE_PINGREQ)));
            case 12:
                if (j == 12) {
                    j = 0;
                }
                return J(j - ((long) (this.a % MqttWireMessage.MESSAGE_TYPE_PINGREQ)));
            case 13:
                int i3 = (int) j;
                if (this.a != i3) {
                    j$.time.temporal.a.HOUR_OF_DAY.I(i3);
                    return t(i3, this.b, this.c, this.d);
                }
                return this;
            case 14:
                if (j == 24) {
                    j = 0;
                }
                int i4 = (int) j;
                if (this.a != i4) {
                    j$.time.temporal.a.HOUR_OF_DAY.I(i4);
                    return t(i4, this.b, this.c, this.d);
                }
                return this;
            case 15:
                return J((j - ((long) (this.a / MqttWireMessage.MESSAGE_TYPE_PINGREQ))) * 12);
            default:
                throw new j$.time.temporal.r(d.a("Unsupported field: ", oVar));
        }
    }

    public final LocalTime R(int i) {
        if (this.d == i) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.I(i);
        return t(this.a, this.b, this.c, i);
    }

    public final void S(DataOutput dataOutput) throws IOException {
        if (this.d != 0) {
            dataOutput.writeByte(this.a);
            dataOutput.writeByte(this.b);
            dataOutput.writeByte(this.c);
            dataOutput.writeInt(this.d);
            return;
        }
        if (this.c != 0) {
            dataOutput.writeByte(this.a);
            dataOutput.writeByte(this.b);
            dataOutput.writeByte(~this.c);
            return;
        }
        byte b = this.b;
        byte b2 = this.a;
        if (b == 0) {
            dataOutput.writeByte(~b2);
        } else {
            dataOutput.writeByte(b2);
            dataOutput.writeByte(~this.b);
        }
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal c(long j, j$.time.temporal.q qVar) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = b(Long.MAX_VALUE, qVar);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.b(j2, qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object d(s sVar) {
        if (sVar == j$.time.temporal.p.b || sVar == j$.time.temporal.p.a || sVar == j$.time.temporal.p.e || sVar == j$.time.temporal.p.d) {
            return null;
        }
        if (sVar == j$.time.temporal.p.g) {
            return this;
        }
        if (sVar == j$.time.temporal.p.f) {
            return null;
        }
        return sVar == j$.time.temporal.p.c ? j$.time.temporal.b.NANOS : sVar.j(this);
    }

    @Override // j$.time.temporal.Temporal
    /* JADX INFO: renamed from: e */
    public final Temporal k(LocalDate localDate) {
        return (LocalTime) localDate.f(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.a == localTime.a && this.b == localTime.b && this.c == localTime.c && this.d == localTime.d) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.temporal.m
    public final Temporal f(Temporal temporal) {
        return temporal.a(O(), j$.time.temporal.a.NANO_OF_DAY);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? C(oVar) : super.g(oVar);
    }

    public int getHour() {
        return this.a;
    }

    public int getMinute() {
        return this.b;
    }

    public int getNano() {
        return this.d;
    }

    public int getSecond() {
        return this.c;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).J() : oVar != null && oVar.o(this);
    }

    public final int hashCode() {
        long jO = O();
        return (int) (jO ^ (jO >>> 32));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.NANO_OF_DAY ? O() : oVar == j$.time.temporal.a.MICRO_OF_DAY ? O() / 1000 : C(oVar) : oVar.C(this);
    }

    @Override // j$.time.temporal.Temporal
    public final long l(Temporal temporal, j$.time.temporal.q qVar) {
        LocalTime localTimeX = x(temporal);
        if (!(qVar instanceof j$.time.temporal.b)) {
            return qVar.o(this, localTimeX);
        }
        long jO = localTimeX.O() - O();
        switch (i.b[((j$.time.temporal.b) qVar).ordinal()]) {
            case 1:
                return jO;
            case 2:
                return jO / 1000;
            case 3:
                return jO / 1000000;
            case 4:
                return jO / 1000000000;
            case 5:
                return jO / 60000000000L;
            case 6:
                return jO / 3600000000000L;
            case 7:
                return jO / 43200000000000L;
            default:
                g.d("Unsupported unit: ", qVar);
                return 0L;
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final int compareTo(LocalTime localTime) {
        int iCompare = Integer.compare(this.a, localTime.a);
        return (iCompare == 0 && (iCompare = Integer.compare(this.b, localTime.b)) == 0 && (iCompare = Integer.compare(this.c, localTime.c)) == 0) ? Integer.compare(this.d, localTime.d) : iCompare;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b = this.a;
        byte b2 = this.b;
        byte b3 = this.c;
        int i = this.d;
        sb.append(b < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "");
        sb.append((int) b);
        sb.append(b2 < 10 ? ":0" : ":");
        sb.append((int) b2);
        if (b3 > 0 || i > 0) {
            sb.append(b3 < 10 ? ":0" : ":");
            sb.append((int) b3);
            if (i > 0) {
                sb.append('.');
                if (i % 1000000 == 0) {
                    sb.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    sb.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }
}
