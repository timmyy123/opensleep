package com.urbandroid.sleep.hr.polar;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.sleep.hr.AccelBatch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000bj\b\u0012\u0004\u0012\u00020\u000f`\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/hr/polar/BreathDataBuffer;", "", "outputSampleRate", "", "outputSize", "timeoutMillis", "", "<init>", "(IIJ)V", "lastTimestamp", "rawRemainder", "Ljava/util/ArrayList;", "Lcom/urbandroid/sleep/hr/AccelBatch$Point;", "Lkotlin/collections/ArrayList;", "aggregatedBuffer", "", "aggregate", "Lcom/urbandroid/sleep/hr/polar/BreathDataBuffer$Result;", "batch", "Lcom/urbandroid/sleep/hr/AccelBatch;", "points", "", "reset", "", "Result", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BreathDataBuffer {
    private final int outputSampleRate;
    private final int outputSize;
    private final long timeoutMillis;
    private long lastTimestamp = -1;
    private ArrayList<AccelBatch.Point> rawRemainder = new ArrayList<>();
    private ArrayList<Float> aggregatedBuffer = new ArrayList<>();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/hr/polar/BreathDataBuffer$Result;", "", "", "dataOutage", "", "data", "<init>", "(Z[F)V", "component1", "()Z", "component2", "()[F", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getDataOutage", "[F", "getData", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Result {
        private final float[] data;
        private final boolean dataOutage;

        public Result(boolean z, float[] fArr) {
            fArr.getClass();
            this.dataOutage = z;
            this.data = fArr;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getDataOutage() {
            return this.dataOutage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float[] getData() {
            return this.data;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return this.dataOutage == result.dataOutage && Intrinsics.areEqual(this.data, result.data);
        }

        public int hashCode() {
            return Arrays.hashCode(this.data) + (Boolean.hashCode(this.dataOutage) * 31);
        }

        public String toString() {
            return "Result(dataOutage=" + this.dataOutage + ", data=" + Arrays.toString(this.data) + ")";
        }
    }

    public BreathDataBuffer(int i, int i2, long j) {
        this.outputSampleRate = i;
        this.outputSize = i2;
        this.timeoutMillis = j;
    }

    private final void reset() {
        this.lastTimestamp = -1L;
        this.aggregatedBuffer.clear();
        this.rawRemainder.clear();
    }

    public final Result aggregate(AccelBatch batch) {
        batch.getClass();
        if (this.lastTimestamp > 0 && batch.getLocalTimestampMillis() - this.lastTimestamp > this.timeoutMillis) {
            reset();
            return new Result(true, new float[0]);
        }
        this.lastTimestamp = batch.getLocalTimestampMillis();
        int sampleRate = batch.getSampleRate() / this.outputSampleRate;
        List listPlus = CollectionsKt.plus((Collection) this.rawRemainder, (Iterable) batch.getPoints());
        this.rawRemainder.clear();
        for (List<AccelBatch.Point> list : CollectionsKt.chunked(listPlus, sampleRate)) {
            if (list.size() == sampleRate) {
                this.aggregatedBuffer.add(Float.valueOf(aggregate(list)));
            } else {
                this.rawRemainder.addAll(list);
            }
        }
        int size = this.aggregatedBuffer.size();
        int i = this.outputSize;
        if (size < i) {
            return new Result(false, new float[0]);
        }
        List<Float> listSubList = this.aggregatedBuffer.subList(0, i);
        listSubList.getClass();
        Result result = new Result(false, CollectionsKt.toFloatArray(listSubList));
        ArrayList<Float> arrayList = this.aggregatedBuffer;
        this.aggregatedBuffer = new ArrayList<>(arrayList.subList(this.outputSize / 2, arrayList.size()));
        return result;
    }

    private final float aggregate(List<AccelBatch.Point> points) {
        List<AccelBatch.Point> list = points;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (AccelBatch.Point point : list) {
            arrayList.add(Float.valueOf((float) Math.sqrt((point.getZ() * point.getZ()) + (point.getY() * point.getY()) + (point.getX() * point.getX()))));
        }
        return (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList);
    }
}
