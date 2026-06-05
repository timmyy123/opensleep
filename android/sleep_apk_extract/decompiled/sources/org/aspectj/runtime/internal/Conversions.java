package org.aspectj.runtime.internal;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Conversions {
    public static Object booleanObject(boolean z) {
        return Boolean.valueOf(z);
    }

    public static Object byteObject(byte b) {
        return Byte.valueOf(b);
    }

    public static Object doubleObject(double d) {
        return Double.valueOf(d);
    }

    public static Object floatObject(float f) {
        return Float.valueOf(f);
    }

    public static Object intObject(int i) {
        return Integer.valueOf(i);
    }

    public static Object longObject(long j) {
        return Long.valueOf(j);
    }

    public static Object shortObject(short s) {
        return Short.valueOf(s);
    }
}
