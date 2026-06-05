package com.urbandroid.sleep.service.awake;

import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/service/awake/AverageActivityOverThreshold;", "Lcom/urbandroid/common/FeatureLogger;", "", "threshold", "<init>", "(F)V", "activity", "", "update", "(F)Z", "F", "getThreshold", "()F", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/snoring/feature/FloatFunction;", "kotlin.jvm.PlatformType", "averageActivity", "Lcom/urbandroid/sleep/snoring/feature/FloatFunction;", "looksLikeMilliG", "Z", "", "callCount", "I", "lastResult", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class AverageActivityOverThreshold implements FeatureLogger {
    private int callCount;
    private boolean lastResult;
    private boolean looksLikeMilliG;
    private final float threshold;
    private final String tag = "AverageActivityOverThreshold";
    private final FloatFunction averageActivity = Moving.avg(30);

    public AverageActivityOverThreshold(float f) {
        this.threshold = f;
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ("init: threshold=" + f), null);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final boolean update(float activity) {
        this.callCount++;
        if (activity > 150.0f && !this.looksLikeMilliG) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": update: looks like the signal is in milli-Gs, adjusting the threshold.", null);
            this.looksLikeMilliG = true;
        }
        float f = (this.looksLikeMilliG ? 100.0f : 1.0f) * this.threshold;
        float fApply = this.averageActivity.apply(activity);
        boolean z = this.callCount >= 30 && fApply > f;
        if (z != this.lastResult) {
            String str = " " + (z ? "isAwake" : "NOT AWake") + " update: " + fApply + ", " + f + ", " + activity;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
            this.lastResult = z;
        }
        return z;
    }
}
