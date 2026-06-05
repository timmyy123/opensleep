package pl.edu.icm.jlargearrays;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.apache.commons.math3.util.FastMath;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes5.dex */
public abstract class LargeArrayUtils {
    public static final Unsafe UNSAFE;

    static {
        Object obj = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(cls);
            e = null;
            obj = obj2;
        } catch (ClassNotFoundException e) {
            e = e;
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (IllegalArgumentException e3) {
            e = e3;
        } catch (NoSuchFieldException e4) {
            e = e4;
        } catch (SecurityException e5) {
            e = e5;
        }
        Unsafe unsafe = (Unsafe) obj;
        UNSAFE = unsafe;
        if (unsafe == null) {
            throw new Error("Could not obtain access to sun.misc.Unsafe", e);
        }
    }

    public static void arraycopy(final LongLargeArray longLargeArray, final long j, final LongLargeArray longLargeArray2, final long j2, long j3) {
        if (j < 0 || j >= longLargeArray.length()) {
            Utf8$$ExternalSyntheticBUOutline0.m$1("srcPos < 0 || srcPos >= src.length()");
            return;
        }
        if (j2 < 0 || j2 >= longLargeArray2.length()) {
            Utf8$$ExternalSyntheticBUOutline0.m$1("destPos < 0 || destPos >= dest.length()");
            return;
        }
        if (j3 < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("length < 0");
            return;
        }
        if (longLargeArray2.isConstant()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Constant arrays cannot be modified.");
            return;
        }
        int iMin = (int) FastMath.min(j3, ConcurrencyUtils.getNumberOfThreads());
        if (iMin < 2 || j3 < ConcurrencyUtils.getConcurrentThreshold()) {
            long j4 = j;
            long j5 = j2;
            while (j4 < j + j3) {
                longLargeArray2.setLong(j5, longLargeArray.getLong(j4));
                j4++;
                j5++;
            }
            return;
        }
        long j6 = j3 / ((long) iMin);
        Future[] futureArr = new Future[iMin];
        int i = 0;
        while (i < iMin) {
            final long j7 = ((long) i) * j6;
            Future[] futureArr2 = futureArr;
            int i2 = i;
            final long j8 = i == iMin + (-1) ? j3 : j7 + j6;
            futureArr2[i2] = ConcurrencyUtils.submit(new Runnable() { // from class: pl.edu.icm.jlargearrays.LargeArrayUtils.12
                @Override // java.lang.Runnable
                public void run() {
                    for (long j9 = j7; j9 < j8; j9++) {
                        longLargeArray2.setLong(j2 + j9, longLargeArray.getLong(j + j9));
                    }
                }
            });
            i = i2 + 1;
            futureArr = futureArr2;
        }
        try {
            ConcurrencyUtils.waitForCompletion(futureArr);
        } catch (InterruptedException unused) {
            long j9 = j;
            long j10 = j2;
            while (j9 < j + j3) {
                longLargeArray2.setLong(j10, longLargeArray.getLong(j9));
                j9++;
                j10++;
            }
        } catch (ExecutionException unused2) {
            long j11 = j;
            long j12 = j2;
            while (j11 < j + j3) {
                longLargeArray2.setLong(j12, longLargeArray.getLong(j11));
                j11++;
                j12++;
            }
        }
    }

    public static void arraycopy(final FloatLargeArray floatLargeArray, final long j, final FloatLargeArray floatLargeArray2, final long j2, long j3) {
        if (j < 0 || j >= floatLargeArray.length()) {
            Utf8$$ExternalSyntheticBUOutline0.m$1("srcPos < 0 || srcPos >= src.length()");
            return;
        }
        if (j2 < 0 || j2 >= floatLargeArray2.length()) {
            Utf8$$ExternalSyntheticBUOutline0.m$1("destPos < 0 || destPos >= dest.length()");
            return;
        }
        if (j3 >= 0) {
            if (!floatLargeArray2.isConstant()) {
                int iMin = (int) FastMath.min(j3, ConcurrencyUtils.getNumberOfThreads());
                if (iMin < 2 || j3 < ConcurrencyUtils.getConcurrentThreshold()) {
                    long j4 = j;
                    long j5 = j2;
                    while (j4 < j + j3) {
                        floatLargeArray2.setFloat(j5, floatLargeArray.getFloat(j4));
                        j4++;
                        j5++;
                    }
                    return;
                }
                long j6 = j3 / ((long) iMin);
                Future[] futureArr = new Future[iMin];
                int i = 0;
                while (i < iMin) {
                    final long j7 = ((long) i) * j6;
                    Future[] futureArr2 = futureArr;
                    int i2 = i;
                    final long j8 = i == iMin + (-1) ? j3 : j7 + j6;
                    futureArr2[i2] = ConcurrencyUtils.submit(new Runnable() { // from class: pl.edu.icm.jlargearrays.LargeArrayUtils.14
                        @Override // java.lang.Runnable
                        public void run() {
                            for (long j9 = j7; j9 < j8; j9++) {
                                floatLargeArray2.setFloat(j2 + j9, floatLargeArray.getFloat(j + j9));
                            }
                        }
                    });
                    i = i2 + 1;
                    futureArr = futureArr2;
                }
                try {
                    ConcurrencyUtils.waitForCompletion(futureArr);
                    return;
                } catch (InterruptedException unused) {
                    long j9 = j;
                    long j10 = j2;
                    while (j9 < j + j3) {
                        floatLargeArray2.setFloat(j10, floatLargeArray.getFloat(j9));
                        j9++;
                        j10++;
                    }
                    return;
                } catch (ExecutionException unused2) {
                    long j11 = j;
                    long j12 = j2;
                    while (j11 < j + j3) {
                        floatLargeArray2.setFloat(j12, floatLargeArray.getFloat(j11));
                        j11++;
                        j12++;
                    }
                    return;
                }
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Constant arrays cannot be modified.");
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("length < 0");
    }
}
