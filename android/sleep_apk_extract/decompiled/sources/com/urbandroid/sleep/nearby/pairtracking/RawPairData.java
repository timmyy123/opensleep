package com.urbandroid.sleep.nearby.pairtracking;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.domain.AdaptiveNormalizationFilter;
import com.urbandroid.sleep.sensor.aggregator.IActivityAggregator;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.SettingsExtKt;
import java.util.BitSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BI\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\r\u001a\u00020\u00032\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00010\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u0010J\u0019\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001f\u0010 J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u001d\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0004¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020'2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0004¢\u0006\u0004\b*\u0010)J\u001d\u0010,\u001a\u00020'2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003¢\u0006\u0004\b,\u0010-J\r\u0010/\u001a\u00020.¢\u0006\u0004\b/\u00100J\u001d\u00102\u001a\u00020.2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u0015¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020'¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u0002062\u0006\u0010&\u001a\u000206¢\u0006\u0004\b7\u00108J\r\u0010:\u001a\u000209¢\u0006\u0004\b:\u0010;R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010<R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010<R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010<¨\u0006="}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/RawPairData;", "", "Lcom/urbandroid/sleep/nearby/pairtracking/AppendableSeries;", "", "", "local", "remote", "timeDiff", "<init>", "(Lcom/urbandroid/sleep/nearby/pairtracking/AppendableSeries;Lcom/urbandroid/sleep/nearby/pairtracking/AppendableSeries;Lcom/urbandroid/sleep/nearby/pairtracking/AppendableSeries;)V", "Lcom/urbandroid/sleep/nearby/pairtracking/Series;", "series", "newKey", "adjustNewKey", "(Lcom/urbandroid/sleep/nearby/pairtracking/Series;J)J", "getLastRemoteValueAgeMillis", "()J", "getLastRemoteValueTime", "from", "tail", "(J)Lcom/urbandroid/sleep/nearby/pairtracking/RawPairData;", "", "getValidLocalHistorySize", "()I", "getLocalMillisPerPoint", "getLocalRemoteOverlapMinutes", "Ljava/util/BitSet;", "excludedIndices", "normalizeAmplitudes", "(Ljava/util/BitSet;)Lcom/urbandroid/sleep/nearby/pairtracking/RawPairData;", "localIndices", "getCorrespondingRemoteIndices$Sleep_prodRelease", "(Ljava/util/BitSet;)Ljava/util/BitSet;", "getCorrespondingRemoteIndices", "Lcom/urbandroid/sleep/nearby/pairtracking/PairRecord;", "matchTimes", "()Lcom/urbandroid/sleep/nearby/pairtracking/PairRecord;", "time", "activity", "", "addLocalActivity", "(JF)V", "addRemoteActivity", "diff", "addTimeDiff", "(JJ)V", "", "getLocalActivity", "()[F", "aggregation", "getAggregatedActigraph", "(Ljava/util/BitSet;I)[F", "logStatus", "()V", "Lcom/urbandroid/sleep/sensor/aggregator/IActivityAggregator$Result;", "adjustRealtimeActivity", "(Lcom/urbandroid/sleep/sensor/aggregator/IActivityAggregator$Result;)Lcom/urbandroid/sleep/sensor/aggregator/IActivityAggregator$Result;", "", "hasSufficientDataForPairTracking", "()Z", "Lcom/urbandroid/sleep/nearby/pairtracking/AppendableSeries;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RawPairData {
    private final AppendableSeries<Long, Float> local;
    private final AppendableSeries<Long, Float> remote;
    private final AppendableSeries<Long, Long> timeDiff;

    public /* synthetic */ RawPairData(AppendableSeries appendableSeries, AppendableSeries appendableSeries2, AppendableSeries appendableSeries3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LFSeries(0.0f, 0, null, null, 15, null) : appendableSeries, (i & 2) != 0 ? new LFSeries(0.0f, 0, null, null, 15, null) : appendableSeries2, (i & 4) != 0 ? new LLSeries(0L, 0, null, null, 15, null) : appendableSeries3);
    }

    private final long adjustNewKey(Series<Long, ? extends Object> series, long newKey) {
        Long lLastKeyOrNull = series.lastKeyOrNull();
        return (lLastKeyOrNull == null || lLastKeyOrNull.longValue() < newKey) ? newKey : lLastKeyOrNull.longValue() + 1;
    }

    private final long getLastRemoteValueAgeMillis() {
        return System.currentTimeMillis() - getLastRemoteValueTime();
    }

    private final long getLastRemoteValueTime() {
        Long lLastKeyOrNull = this.remote.lastKeyOrNull();
        return this.timeDiff.getLGE(Long.valueOf(System.currentTimeMillis())).longValue() + (lLastKeyOrNull != null ? lLastKeyOrNull.longValue() : 0L);
    }

    private final long getLocalMillisPerPoint() {
        if (this.local.size() < 2) {
            return 0L;
        }
        Long lLastKeyOrNull = this.local.lastKeyOrNull();
        lLastKeyOrNull.getClass();
        return (lLastKeyOrNull.longValue() - this.local.key(0).longValue()) / ((long) this.local.size());
    }

    private final long getLocalRemoteOverlapMinutes() {
        if (this.local.isEmpty() || this.remote.isEmpty()) {
            return 0L;
        }
        long jMax = Math.max(this.local.key(0).longValue(), this.remote.key(0).longValue());
        Long lLastKeyOrNull = this.local.lastKeyOrNull();
        lLastKeyOrNull.getClass();
        long jLongValue = lLastKeyOrNull.longValue();
        Long lLastKeyOrNull2 = this.remote.lastKeyOrNull();
        lLastKeyOrNull2.getClass();
        return Math.max(0L, (Math.min(jLongValue, lLastKeyOrNull2.longValue()) - jMax) / 60000);
    }

    private final int getValidLocalHistorySize() {
        int i = 0;
        for (float f : getLocalActivity()) {
            if (f >= 0.0f) {
                i++;
            }
        }
        return i;
    }

    public static /* synthetic */ RawPairData normalizeAmplitudes$default(RawPairData rawPairData, BitSet bitSet, int i, Object obj) {
        if ((i & 1) != 0) {
            bitSet = new BitSet();
        }
        return rawPairData.normalizeAmplitudes(bitSet);
    }

    private final RawPairData tail(long from) {
        return new RawPairData(this.local.tail(Long.valueOf(from)), this.remote.tail(Long.valueOf(from)), this.timeDiff.tail(Long.valueOf(from)));
    }

    public final synchronized void addLocalActivity(long time, float activity) {
        AppendableSeries<Long, Float> appendableSeries = this.local;
        appendableSeries.add(Long.valueOf(adjustNewKey(appendableSeries, time)), Float.valueOf(activity));
    }

    public final synchronized void addRemoteActivity(long time, float activity) {
        AppendableSeries<Long, Float> appendableSeries = this.remote;
        appendableSeries.add(Long.valueOf(adjustNewKey(appendableSeries, time)), Float.valueOf(activity));
    }

    public final synchronized void addTimeDiff(long time, long diff) {
        AppendableSeries<Long, Long> appendableSeries = this.timeDiff;
        appendableSeries.add(Long.valueOf(adjustNewKey(appendableSeries, time)), Long.valueOf(diff));
    }

    public final synchronized IActivityAggregator.Result adjustRealtimeActivity(IActivityAggregator.Result activity) {
        Pair pair;
        Float fValueOf = Float.valueOf(3.3f);
        synchronized (this) {
            try {
                activity.getClass();
                if (activity.hasNoData()) {
                    return activity;
                }
                if (!hasSufficientDataForPairTracking()) {
                    return activity;
                }
                if (getLastRemoteValueAgeMillis() > 60000) {
                    return activity;
                }
                boolean z = true;
                float pairAdjustedActivity = normalizeAmplitudes$default(tail(System.currentTimeMillis() - 3600000), null, 1, null).matchTimes().getPairAdjustedActivity(getLastRemoteValueTime());
                if (Experiments.getInstance().isActigraphyImprovementsExperiment2()) {
                    pair = new Pair(Float.valueOf(2.5f), fValueOf);
                } else if (Experiments.getInstance().isActigraphyImprovementsExperiment1()) {
                    Settings settings = SharedApplicationContext.getSettings();
                    settings.getClass();
                    pair = new Pair(Float.valueOf(SettingsExtKt.mapDeepSleepSensitivity(settings, 4.0f, 3.0f, 2.5f, 2.0f, 2.5f)), Float.valueOf(SettingsExtKt.mapDeepSleepSensitivity(settings, 5.5f, 4.2f, 3.3f, 2.6f, 3.3f)));
                } else {
                    pair = new Pair(fValueOf, fValueOf);
                }
                float fFloatValue = ((Number) pair.component1()).floatValue();
                float fFloatValue2 = ((Number) pair.component2()).floatValue();
                float f = activity.rawActivity;
                float f2 = activity.actigraph;
                boolean z2 = pairAdjustedActivity > fFloatValue;
                if (pairAdjustedActivity <= fFloatValue2) {
                    z = false;
                }
                return new IActivityAggregator.Result(f, f2, z2, z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized float[] getAggregatedActigraph(BitSet excludedIndices, int aggregation) {
        excludedIndices.getClass();
        if (hasSufficientDataForPairTracking()) {
            return normalizeAmplitudes(excludedIndices).matchTimes().aggregate(aggregation).getPairAdjustedActivity();
        }
        return new float[0];
    }

    public final synchronized BitSet getCorrespondingRemoteIndices$Sleep_prodRelease(BitSet localIndices) {
        localIndices.getClass();
        if (localIndices.isEmpty()) {
            return new BitSet();
        }
        LongAscSortedAppendableArray longAscSortedAppendableArray = new LongAscSortedAppendableArray(RawPairDataKt.normalizeTimeSteps$default(this.local, 0L, 2, null), 0, 2, null);
        LongAscSortedAppendableArray longAscSortedAppendableArray2 = new LongAscSortedAppendableArray(RawPairDataKt.normalizeTimeSteps$default(this.remote, 0L, 2, null), 0, 2, null);
        if (!longAscSortedAppendableArray.isEmpty() && !longAscSortedAppendableArray2.isEmpty()) {
            BitSet bitSet = new BitSet();
            int iNextSetBit = localIndices.nextSetBit(0);
            while (iNextSetBit >= 0 && iNextSetBit < longAscSortedAppendableArray.getSize()) {
                Long l = longAscSortedAppendableArray.get(iNextSetBit);
                long jLongValue = l.longValue() - this.timeDiff.getLGE(l).longValue();
                int iFindLE = longAscSortedAppendableArray2.findLE(jLongValue);
                if (iFindLE >= 0 && jLongValue - longAscSortedAppendableArray2.get(iFindLE).longValue() < SleepService.FRAMERATE * 2) {
                    bitSet.set(iFindLE);
                }
                int iFindGE = longAscSortedAppendableArray2.findGE(jLongValue);
                if (iFindGE < longAscSortedAppendableArray2.getSize() && longAscSortedAppendableArray2.get(iFindGE).longValue() - jLongValue < SleepService.FRAMERATE * 2) {
                    bitSet.set(iFindGE);
                }
                iNextSetBit = localIndices.nextSetBit(iNextSetBit + 1);
            }
            return bitSet;
        }
        return new BitSet();
    }

    public final synchronized float[] getLocalActivity() {
        Object objValuesAsPrimitiveArray;
        objValuesAsPrimitiveArray = this.local.valuesAsPrimitiveArray();
        objValuesAsPrimitiveArray.getClass();
        return (float[]) objValuesAsPrimitiveArray;
    }

    public final synchronized boolean hasSufficientDataForPairTracking() {
        if (this.local.size() < 360) {
            return false;
        }
        if (getValidLocalHistorySize() < 360) {
            return false;
        }
        if (getLocalMillisPerPoint() >= 8000) {
            if (this.remote.size() < 360) {
                return false;
            }
            return getLocalRemoteOverlapMinutes() >= 60;
        }
        Logger.logWarning("PairTracking: Wrong frequency of local data: " + getLocalMillisPerPoint());
        return false;
    }

    public final synchronized void logStatus() {
        Logger.logInfo("PairTracking: local.size()=" + this.local.size() + ", remote.size()=" + this.remote.size());
        Logger.logInfo("PairTracking: getValidLocalHistorySize()=" + getValidLocalHistorySize() + ", getLocalMillisPerPoint()=" + getLocalMillisPerPoint());
        long localRemoteOverlapMinutes = getLocalRemoteOverlapMinutes();
        StringBuilder sb = new StringBuilder("PairTracking: getLocalRemoteOverlapMinutes()=");
        sb.append(localRemoteOverlapMinutes);
        Logger.logInfo(sb.toString());
    }

    public final synchronized PairRecord matchTimes() {
        LongAscSortedAppendableArray longAscSortedAppendableArray;
        AppendableArray<Float> appendableArrayCopyOfValues;
        FloatAppendableArray floatAppendableArray;
        long j;
        long jAbs;
        float fFloatValue;
        try {
            longAscSortedAppendableArray = new LongAscSortedAppendableArray(RawPairDataKt.normalizeTimeSteps$default(this.local, 0L, 2, null), 0, 2, null);
            appendableArrayCopyOfValues = this.local.copyOfValues();
            LongAscSortedAppendableArray longAscSortedAppendableArray2 = new LongAscSortedAppendableArray(RawPairDataKt.normalizeTimeSteps$default(this.remote, 0L, 2, null), 0, 2, null);
            AppendableArray<Float> appendableArrayCopyOfValues2 = this.remote.copyOfValues();
            floatAppendableArray = new FloatAppendableArray(null, longAscSortedAppendableArray.getSize(), 1, null);
            int size = longAscSortedAppendableArray.getSize();
            for (int i = 0; i < size; i++) {
                if (appendableArrayCopyOfValues.get(i).floatValue() < 0.0f) {
                    floatAppendableArray.add(0.0f);
                } else {
                    Long l = longAscSortedAppendableArray.get(i);
                    long jLongValue = l.longValue();
                    long jLongValue2 = jLongValue - this.timeDiff.getLGE(l).longValue();
                    int iFindLE = longAscSortedAppendableArray2.findLE(jLongValue2);
                    long jAbs2 = Long.MAX_VALUE;
                    if (iFindLE < 0) {
                        j = jLongValue;
                        jAbs = Long.MAX_VALUE;
                    } else {
                        j = jLongValue;
                        jAbs = Math.abs(jLongValue - longAscSortedAppendableArray2.get(iFindLE).longValue());
                    }
                    int iFindGE = longAscSortedAppendableArray2.findGE(jLongValue2);
                    if (iFindGE < longAscSortedAppendableArray2.getSize()) {
                        jAbs2 = Math.abs(j - longAscSortedAppendableArray2.get(iFindGE).longValue());
                    }
                    if (jAbs < 10000 && jAbs2 >= 10000) {
                        fFloatValue = appendableArrayCopyOfValues2.get(iFindLE).floatValue();
                    } else if (jAbs2 < 10000 && jAbs >= 10000) {
                        fFloatValue = appendableArrayCopyOfValues2.get(iFindGE).floatValue();
                    } else if (jAbs2 >= 10000 || jAbs >= 10000) {
                        fFloatValue = 0.0f;
                    } else if (iFindLE == iFindGE) {
                        fFloatValue = appendableArrayCopyOfValues2.get(iFindLE).floatValue();
                    } else {
                        fFloatValue = ((appendableArrayCopyOfValues2.get(iFindLE).floatValue() * jAbs2) + (appendableArrayCopyOfValues2.get(iFindGE).floatValue() * jAbs)) / (jAbs + jAbs2);
                    }
                    floatAppendableArray.add(fFloatValue);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return new PairRecord(longAscSortedAppendableArray, appendableArrayCopyOfValues, floatAppendableArray);
    }

    public final synchronized RawPairData normalizeAmplitudes(BitSet excludedIndices) {
        LFSeries lFSeries;
        Object objKeysAsPrimitiveArray;
        float[] fArr;
        excludedIndices.getClass();
        Object objValuesAsPrimitiveArray = this.local.valuesAsPrimitiveArray();
        objValuesAsPrimitiveArray.getClass();
        AdaptiveNormalizationFilter.ANFResult aNFResultNormalizeAmplitudes = AdaptiveNormalizationFilter.normalizeAmplitudes((float[]) objValuesAsPrimitiveArray, excludedIndices);
        Object objValuesAsPrimitiveArray2 = this.remote.valuesAsPrimitiveArray();
        objValuesAsPrimitiveArray2.getClass();
        AdaptiveNormalizationFilter.ANFResult aNFResultNormalizeAmplitudes2 = AdaptiveNormalizationFilter.normalizeAmplitudes((float[]) objValuesAsPrimitiveArray2, getCorrespondingRemoteIndices$Sleep_prodRelease(excludedIndices));
        Object objKeysAsPrimitiveArray2 = this.local.keysAsPrimitiveArray();
        objKeysAsPrimitiveArray2.getClass();
        float[] fArr2 = aNFResultNormalizeAmplitudes.output;
        fArr2.getClass();
        lFSeries = new LFSeries((long[]) objKeysAsPrimitiveArray2, fArr2);
        objKeysAsPrimitiveArray = this.remote.keysAsPrimitiveArray();
        objKeysAsPrimitiveArray.getClass();
        fArr = aNFResultNormalizeAmplitudes2.output;
        fArr.getClass();
        return new RawPairData(lFSeries, new LFSeries((long[]) objKeysAsPrimitiveArray, fArr), this.timeDiff);
    }

    public RawPairData(AppendableSeries<Long, Float> appendableSeries, AppendableSeries<Long, Float> appendableSeries2, AppendableSeries<Long, Long> appendableSeries3) {
        appendableSeries.getClass();
        appendableSeries2.getClass();
        appendableSeries3.getClass();
        this.local = appendableSeries;
        this.remote = appendableSeries2;
        this.timeDiff = appendableSeries3;
    }
}
