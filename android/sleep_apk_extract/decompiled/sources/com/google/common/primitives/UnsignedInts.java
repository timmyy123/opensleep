package com.google.common.primitives;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UnsignedInts {
    public static int compare(int i, int i2) {
        return Ints.compare(flip(i), flip(i2));
    }

    public static int divide(int i, int i2) {
        return (int) (toLong(i) / toLong(i2));
    }

    public static int flip(int i) {
        return i ^ Integer.MIN_VALUE;
    }

    public static int parseUnsignedInt(String str, int i) {
        Preconditions.checkNotNull(str);
        long j = Long.parseLong(str, i);
        if ((4294967295L & j) == j) {
            return (int) j;
        }
        throw new NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
    }

    public static int remainder(int i, int i2) {
        return (int) (toLong(i) % toLong(i2));
    }

    public static long toLong(int i) {
        return ((long) i) & 4294967295L;
    }

    public static String toString(int i, int i2) {
        return Long.toString(((long) i) & 4294967295L, i2);
    }
}
