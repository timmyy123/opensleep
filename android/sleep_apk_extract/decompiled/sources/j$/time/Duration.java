package j$.time;

import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    public static final Duration c = new Duration(0, 0);
    public static final BigInteger d = BigInteger.valueOf(1000000000);
    private static final long serialVersionUID = 3078945930695997490L;
    public final long a;
    public final int b;

    public Duration(long j, int i) {
        this.a = j;
        this.b = i;
    }

    public static Duration C(long j) {
        long j2 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i = (int) (((long) i) + 1000000000);
            j2--;
        }
        return x(j2, i);
    }

    public static Duration between(Temporal temporal, Temporal temporal2) {
        try {
            return C(temporal.l(temporal2, j$.time.temporal.b.NANOS));
        } catch (c | ArithmeticException unused) {
            long jL = temporal.l(temporal2, j$.time.temporal.b.SECONDS);
            long j = 0;
            try {
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
                long jI = temporal2.i(aVar) - temporal.i(aVar);
                if (jL > 0 && jI < 0) {
                    jL++;
                } else if (jL < 0 && jI > 0) {
                    jL--;
                }
                j = jI;
            } catch (c unused2) {
            }
            return ofSeconds(jL, j);
        }
    }

    public static Duration ofDays(long j) {
        return x(Math.multiplyExact(j, 86400L), 0);
    }

    public static Duration ofMillis(long j) {
        long j2 = j / 1000;
        int i = (int) (j % 1000);
        if (i < 0) {
            i += 1000;
            j2--;
        }
        return x(j2, i * 1000000);
    }

    public static Duration ofMinutes(long j) {
        return x(Math.multiplyExact(j, 60L), 0);
    }

    public static Duration ofSeconds(long j, long j2) {
        return x(Math.addExact(j, Math.floorDiv(j2, 1000000000L)), (int) Math.floorMod(j2, 1000000000L));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new o((byte) 1, this);
    }

    public static Duration x(long j, int i) {
        return (((long) i) | j) == 0 ? c : new Duration(j, i);
    }

    public final BigDecimal H() {
        return BigDecimal.valueOf(this.a).add(BigDecimal.valueOf(this.b, 9));
    }

    @Override // java.lang.Comparable
    public int compareTo(Duration duration) {
        int iCompare = Long.compare(this.a, duration.a);
        return iCompare != 0 ? iCompare : this.b - duration.b;
    }

    public long dividedBy(Duration duration) {
        Objects.requireNonNull(duration, "divisor");
        return H().divideToIntegralValue(duration.H()).longValueExact();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            if (this.a == duration.a && this.b == duration.b) {
                return true;
            }
        }
        return false;
    }

    public int getNano() {
        return this.b;
    }

    public long getSeconds() {
        return this.a;
    }

    public int hashCode() {
        long j = this.a;
        return (this.b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public Duration multipliedBy(long j) {
        if (j == 0) {
            return c;
        }
        if (j == 1) {
            return this;
        }
        BigInteger bigIntegerExact = H().multiply(BigDecimal.valueOf(j)).movePointRight(9).toBigIntegerExact();
        BigInteger[] bigIntegerArrDivideAndRemainder = bigIntegerExact.divideAndRemainder(d);
        if (bigIntegerArrDivideAndRemainder[0].bitLength() <= 63) {
            return ofSeconds(bigIntegerArrDivideAndRemainder[0].longValue(), bigIntegerArrDivideAndRemainder[1].intValue());
        }
        throw new ArithmeticException("Exceeds capacity of Duration: " + bigIntegerExact);
    }

    @Override // j$.time.temporal.TemporalAmount
    public final Temporal o(Temporal temporal) {
        long j = this.a;
        if (j != 0) {
            temporal = temporal.b(j, j$.time.temporal.b.SECONDS);
        }
        int i = this.b;
        return i != 0 ? temporal.b(i, j$.time.temporal.b.NANOS) : temporal;
    }

    @Override // j$.time.temporal.TemporalAmount
    public final Temporal t(Temporal temporal) {
        long j = this.a;
        if (j != 0) {
            temporal = temporal.c(j, j$.time.temporal.b.SECONDS);
        }
        int i = this.b;
        return i != 0 ? temporal.c(i, j$.time.temporal.b.NANOS) : temporal;
    }

    public long toMillis() {
        long j = this.a;
        long j2 = this.b;
        if (j < 0) {
            j++;
            j2 -= 1000000000;
        }
        return Math.addExact(Math.multiplyExact(j, 1000L), j2 / 1000000);
    }

    public long toMinutes() {
        return this.a / 60;
    }

    public final String toString() {
        if (this == c) {
            return "PT0S";
        }
        long j = this.a;
        if (j < 0 && this.b > 0) {
            j++;
        }
        long j2 = j / 3600;
        int i = (int) ((j % 3600) / 60);
        int i2 = (int) (j % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j2 != 0) {
            sb.append(j2);
            sb.append('H');
        }
        if (i != 0) {
            sb.append(i);
            sb.append('M');
        }
        if (i2 == 0 && this.b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (this.a >= 0 || this.b <= 0 || i2 != 0) {
            sb.append(i2);
        } else {
            sb.append("-0");
        }
        if (this.b > 0) {
            int length = sb.length();
            long j3 = this.a;
            int i3 = this.b;
            if (j3 < 0) {
                sb.append(2000000000 - ((long) i3));
            } else {
                sb.append(((long) i3) + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }
}
