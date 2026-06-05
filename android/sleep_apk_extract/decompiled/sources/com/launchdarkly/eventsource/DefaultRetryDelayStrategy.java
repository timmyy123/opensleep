package com.launchdarkly.eventsource;

import com.launchdarkly.eventsource.RetryDelayStrategy;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultRetryDelayStrategy extends RetryDelayStrategy {
    static DefaultRetryDelayStrategy INSTANCE = new DefaultRetryDelayStrategy(0, 30000, 2.0f, 0.5f);
    private static final SecureRandom random = new SecureRandom();
    private final float backoffMultiplier;
    private final float jitterMultiplier;
    private final long lastBaseDelayMillis;
    private final long maxDelayMillis;

    private DefaultRetryDelayStrategy(long j, long j2, float f, float f2) {
        this.lastBaseDelayMillis = j;
        this.maxDelayMillis = j2;
        this.backoffMultiplier = f;
        this.jitterMultiplier = f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    @Override // com.launchdarkly.eventsource.RetryDelayStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RetryDelayStrategy.Result apply(long j) {
        long jNextInt;
        long j2 = this.lastBaseDelayMillis;
        if (j2 != 0) {
            j = (long) (j2 * this.backoffMultiplier);
        }
        long j3 = this.maxDelayMillis;
        long j4 = (j3 <= 0 || j <= j3) ? j : j3;
        float f = this.jitterMultiplier;
        if (f <= 0.0f) {
            jNextInt = j4;
        } else {
            int iRound = Math.round((j4 > 2147483647L ? Integer.MAX_VALUE : (int) j4) * f);
            if (iRound > 0) {
                jNextInt = j4 - ((long) random.nextInt(iRound));
            }
        }
        return new RetryDelayStrategy.Result(jNextInt, new DefaultRetryDelayStrategy(j4, this.maxDelayMillis, this.backoffMultiplier, this.jitterMultiplier));
    }
}
