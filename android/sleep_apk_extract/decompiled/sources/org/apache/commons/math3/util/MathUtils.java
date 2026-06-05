package org.apache.commons.math3.util;

import java.util.Arrays;
import org.apache.commons.math3.exception.NullArgumentException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MathUtils {
    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throw new NullArgumentException();
        }
    }

    public static boolean equals(double d, double d2) {
        return new Double(d).equals(new Double(d2));
    }

    public static int hash(double d) {
        return new Double(d).hashCode();
    }

    public static int hash(double[] dArr) {
        return Arrays.hashCode(dArr);
    }
}
