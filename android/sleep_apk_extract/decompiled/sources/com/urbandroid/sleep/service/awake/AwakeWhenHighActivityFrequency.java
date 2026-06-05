package com.urbandroid.sleep.service.awake;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import com.urbandroid.sleep.domain.AdaptiveNormalizationFilter;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010'\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/urbandroid/sleep/service/awake/AwakeWhenHighActivityFrequency;", "Lcom/urbandroid/sleep/service/awake/AwakeDetector;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "range", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;)V", "Lcom/urbandroid/sleep/domain/SleepRecord;", "record", "", "haFlags", "", "recomputeBeginning", "(Lcom/urbandroid/sleep/domain/SleepRecord;[F)V", "", "isAwake", "()Z", "stop", "()V", "Landroid/content/Context;", "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "", "windowSize", "I", "getWindowSize", "()I", "", "threshold", "F", "getThreshold", "()F", "lastResult", "Z", "beginningRecomputed", "getBeginningRecomputed", "setBeginningRecomputed", "(Z)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AwakeWhenHighActivityFrequency implements AwakeDetector, FeatureLogger {
    private boolean beginningRecomputed;
    private final Context context;
    private boolean lastResult;
    private final ExpectedTrackingRange range;
    private final String tag;
    private final float threshold;
    private final int windowSize;

    public AwakeWhenHighActivityFrequency(Context context, ExpectedTrackingRange expectedTrackingRange) {
        context.getClass();
        this.context = context;
        this.range = expectedTrackingRange;
        this.tag = "AwakeWhenHighActivityFrequency";
        this.windowSize = 30;
        int awakeDetectionHighActivitySensitivity = SharedApplicationContext.getSettings().getAwakeDetectionHighActivitySensitivity();
        float f = awakeDetectionHighActivitySensitivity != 1 ? awakeDetectionHighActivitySensitivity != 2 ? awakeDetectionHighActivitySensitivity != 3 ? Float.POSITIVE_INFINITY : 0.25f : 0.35f : 0.475f;
        this.threshold = f;
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ("init: threshold=" + f), null);
    }

    private final void recomputeBeginning(SleepRecord record, float[] haFlags) {
        boolean z;
        if (this.beginningRecomputed || haFlags.length < 720 || record.isFinished()) {
            return;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() - record.getFromTime()) / ((long) haFlags.length);
        if (jCurrentTimeMillis < 9000 || jCurrentTimeMillis > 11000) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            long fromTime = record.getFromTime();
            int length = haFlags.length;
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("unexpected number of data points: ", " ", jCurrentTimeMillis2);
            sbM.append(fromTime);
            sbM.append(" ");
            sbM.append(length);
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + sbM.toString(), null);
            this.beginningRecomputed = true;
            return;
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": recomputing the beginning", null);
        FloatFunction floatFunctionSum = Moving.sum(this.windowSize);
        ArrayList arrayList = new ArrayList(haFlags.length);
        for (float f : haFlags) {
            arrayList.add(Boolean.valueOf(floatFunctionSum.apply(f) >= this.threshold * ((float) this.windowSize)));
        }
        boolean z2 = false;
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            if (!z2 || zBooleanValue) {
                z = zBooleanValue;
            } else {
                z = zBooleanValue;
                long fromTime2 = (((long) i) * jCurrentTimeMillis) + record.getFromTime();
                EventLabel eventLabel = EventLabel.AWAKE_END;
                record.addEventLabel(eventLabel, fromTime2);
                StringBuilder sb = new StringBuilder();
                sb.append(eventLabel);
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + zzba$$ExternalSyntheticOutline0.m(fromTime2, ", ", sb), null);
                z2 = false;
            }
            if (!z2 && z) {
                long fromTime3 = (((long) i) * jCurrentTimeMillis) + record.getFromTime();
                EventLabel eventLabel2 = EventLabel.AWAKE_START;
                record.addEventLabel(eventLabel2, fromTime3);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(eventLabel2);
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + zzba$$ExternalSyntheticOutline0.m(fromTime3, ", ", sb2), null);
                z2 = true;
            }
            i = i2;
        }
        if (z2) {
            long length2 = (((long) haFlags.length) * jCurrentTimeMillis) + record.getFromTime();
            EventLabel eventLabel3 = EventLabel.AWAKE_END;
            record.addEventLabel(eventLabel3, length2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(eventLabel3);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + zzba$$ExternalSyntheticOutline0.m(length2, ", ", sb3), null);
        }
        this.beginningRecomputed = true;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void forceAwakeNow() {
        super.forceAwakeNow();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void forceNotAwake() {
        super.forceNotAwake();
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public boolean isAwake() {
        SleepRecord record;
        if (!CurrentSleepRecord.getInstance().isInProcessTracking() || (record = CurrentSleepRecord.getInstance().getRecord()) == null) {
            return false;
        }
        List<Float> history = record.getHistory();
        if (history.size() < this.windowSize) {
            return false;
        }
        float[] highActivityFlagsFloat = AdaptiveNormalizationFilter.normalizeAmplitudes(ScienceUtil.toFloatArray(history)).getHighActivityFlagsFloat(3.0f);
        float fAvg = ScienceUtil.avg(highActivityFlagsFloat, highActivityFlagsFloat.length - this.windowSize, highActivityFlagsFloat.length);
        float f = this.threshold;
        boolean z = fAvg >= f;
        if (z != this.lastResult) {
            String str = "awake: " + f + " " + fAvg + " " + z;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
            this.lastResult = z;
        }
        recomputeBeginning(record, highActivityFlagsFloat);
        return z;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void onScreenOff() {
        super.onScreenOff();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void onScreenOn() {
        super.onScreenOn();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void stop() {
    }
}
