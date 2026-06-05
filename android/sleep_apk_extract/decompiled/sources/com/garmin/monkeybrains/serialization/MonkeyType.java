package com.garmin.monkeybrains.serialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MonkeyType<T> {
    public byte mType;

    public MonkeyType(byte b) {
        this.mType = b;
    }

    public static MonkeyType<?> deserialize(byte[] bArr) {
        byte b = bArr[0];
        if (b == 0) {
            return new MonkeyNull();
        }
        if (b == 1) {
            return new MonkeyInt(bArr);
        }
        if (b == 2) {
            return new MonkeyFloat(bArr);
        }
        if (b == 3) {
            return new MonkeyString(bArr);
        }
        if (b == 5) {
            return new MonkeyArray(bArr);
        }
        if (b == 9) {
            return new MonkeyBool(bArr);
        }
        if (b == 11) {
            return new MonkeyHash(bArr);
        }
        if (b == 14) {
            return new MonkeyLong(bArr);
        }
        if (b == 15) {
            return new MonkeyDouble(bArr);
        }
        if (b == 19) {
            return new MonkeyChar(bArr);
        }
        if (b != 20) {
            return null;
        }
        return new MonkeyByteArray(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> MonkeyType<?> fromJava(T t, boolean z) {
        if (t == 0) {
            return new MonkeyNull(null);
        }
        if (t instanceof MonkeyType) {
            return (MonkeyType) t;
        }
        if (t instanceof Integer) {
            return new MonkeyInt(((Integer) t).intValue());
        }
        if (t instanceof Long) {
            Number number = (Number) t;
            long jLongValue = number.longValue();
            return (!z || jLongValue > 2147483647L || jLongValue < -2147483648L) ? new MonkeyLong(((Long) t).longValue()) : new MonkeyInt(number.intValue());
        }
        if (t instanceof Float) {
            return new MonkeyFloat(((Float) t).floatValue());
        }
        if (t instanceof Double) {
            Number number2 = (Number) t;
            float fFloatValue = number2.floatValue();
            return (!z || Math.abs(((double) fFloatValue) - number2.doubleValue()) >= 1.0E-5d) ? new MonkeyDouble(((Double) t).doubleValue()) : new MonkeyFloat(fFloatValue);
        }
        if (t instanceof String) {
            return new MonkeyString((String) t);
        }
        if (t instanceof Character) {
            return new MonkeyChar(Integer.valueOf(((Character) t).charValue()));
        }
        if (t instanceof List) {
            List list = (List) t;
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof Byte) {
                    }
                }
                return new MonkeyByteArray((List<Byte>) list);
            }
            return new MonkeyArray(list, z);
        }
        if (t instanceof Boolean) {
            return new MonkeyBool(((Boolean) t).booleanValue());
        }
        if (t instanceof Map) {
            return new MonkeyHash((Map) t, z);
        }
        if (!(t instanceof byte[])) {
            return new MonkeyNull(null);
        }
        ArrayList arrayList = new ArrayList();
        for (byte b : (byte[]) t) {
            arrayList.add(Byte.valueOf(b));
        }
        return new MonkeyByteArray(arrayList);
    }

    public boolean equals(Object obj) {
        if (obj instanceof MonkeyType) {
            return obj instanceof MonkeyNull ? this instanceof MonkeyNull : toJava().equals(((MonkeyType) obj).toJava());
        }
        return false;
    }

    public abstract int getNumBytes();

    public int hashCode() {
        return toJava().hashCode();
    }

    public abstract byte[] serialize();

    public abstract T toJava();

    public static <T> MonkeyType<?> fromJava(T t) {
        return fromJava(t, true);
    }
}
