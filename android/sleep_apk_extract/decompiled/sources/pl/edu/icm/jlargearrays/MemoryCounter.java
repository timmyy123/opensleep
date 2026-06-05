package pl.edu.icm.jlargearrays;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MemoryCounter {
    private static long counter;

    public static void decreaseCounter(long j) {
        long j2 = counter - j;
        counter = j2;
        if (j2 < 0) {
            counter = 0L;
        }
    }

    public static void increaseCounter(long j) {
        counter += j;
    }
}
