package twitter4j.management;

/* JADX INFO: loaded from: classes5.dex */
public class InvocationStatisticsCalculator {
    private long callCount;
    private long errorCount;
    private int index;
    private final String name;
    private long[] times;
    private long totalTime;

    public InvocationStatisticsCalculator(String str, int i) {
        this.name = str;
        this.times = new long[i];
    }

    public synchronized long getAverageTime() {
        try {
            int iMin = Math.min(Math.abs((int) this.callCount), this.times.length);
            long j = 0;
            if (iMin == 0) {
                return 0L;
            }
            for (int i = 0; i < iMin; i++) {
                j += this.times[i];
            }
            return j / ((long) iMin);
        } catch (Throwable th) {
            throw th;
        }
    }

    public long getCallCount() {
        return this.callCount;
    }

    public long getErrorCount() {
        return this.errorCount;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public void increment(long j, boolean z) {
        this.callCount++;
        this.errorCount += z ? 0L : 1L;
        this.totalTime += j;
        long[] jArr = this.times;
        int i = this.index;
        jArr[i] = j;
        int i2 = i + 1;
        this.index = i2;
        if (i2 >= jArr.length) {
            this.index = 0;
        }
    }

    public String toString() {
        return "calls=" + getCallCount() + ",errors=" + getErrorCount() + ",totalTime=" + getTotalTime() + ",avgTime=" + getAverageTime();
    }
}
