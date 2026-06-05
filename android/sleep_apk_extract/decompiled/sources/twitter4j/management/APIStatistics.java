package twitter4j.management;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class APIStatistics implements APIStatisticsMBean {
    private final InvocationStatisticsCalculator API_STATS_CALCULATOR;
    private final int HISTORY_SIZE;
    private final Map<String, InvocationStatisticsCalculator> METHOD_STATS_MAP = new HashMap(100);

    public APIStatistics(int i) {
        this.API_STATS_CALCULATOR = new InvocationStatisticsCalculator("API", i);
        this.HISTORY_SIZE = i;
    }

    private synchronized InvocationStatisticsCalculator getMethodStatistics(String str) {
        InvocationStatisticsCalculator invocationStatisticsCalculator;
        invocationStatisticsCalculator = this.METHOD_STATS_MAP.get(str);
        if (invocationStatisticsCalculator == null) {
            invocationStatisticsCalculator = new InvocationStatisticsCalculator(str, this.HISTORY_SIZE);
            this.METHOD_STATS_MAP.put(str, invocationStatisticsCalculator);
        }
        return invocationStatisticsCalculator;
    }

    public synchronized void methodCalled(String str, long j, boolean z) {
        getMethodStatistics(str).increment(j, z);
        this.API_STATS_CALCULATOR.increment(j, z);
    }
}
