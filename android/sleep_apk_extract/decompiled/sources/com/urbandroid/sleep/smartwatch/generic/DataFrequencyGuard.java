package com.urbandroid.sleep.smartwatch.generic;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.util.ScienceUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/generic/DataFrequencyGuard;", "", "Lkotlin/Function0;", "", "getCurrentTime", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "", "start", "()V", "", "batch", "process", "([F)[F", "Lkotlin/jvm/functions/Function0;", "sampleRateMillis", "J", "emptyArray", "[F", "startTime", "", "processedValuesCount", "I", "buffer", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DataFrequencyGuard {
    private float[] buffer;
    private final float[] emptyArray;
    private final Function0<Long> getCurrentTime;
    private int processedValuesCount;
    private final long sampleRateMillis;
    private long startTime;

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.generic.DataFrequencyGuard$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    public DataFrequencyGuard(Function0<Long> function0) {
        function0.getClass();
        this.getCurrentTime = function0;
        this.sampleRateMillis = 10000L;
        float[] fArr = new float[0];
        this.emptyArray = fArr;
        this.startTime = -1L;
        this.buffer = fArr;
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("DataFrequencyGuard:"), FrequencyGuards.maxCountPerInterval(60, 10), 0, 4, null));
    }

    public final float[] process(float[] batch) {
        batch.getClass();
        if (this.startTime < 0) {
            Logger.logSevere("DataFrequencyGuard: start() has never been called.");
            return batch;
        }
        float[] fArr = this.buffer;
        float[] fArrPlus = fArr.length == 0 ? batch : ArraysKt.plus(fArr, batch);
        long jLongValue = (this.getCurrentTime.invoke().longValue() - this.startTime) / this.sampleRateMillis;
        int i = this.processedValuesCount;
        long j = (jLongValue - ((long) i)) + 1;
        if (j <= 0) {
            int length = batch.length;
            int length2 = fArrPlus.length;
            StringBuilder sb = new StringBuilder("DataFrequencyGuard: process() has been called too frequently, no new data can be returned now, the incoming values will be buffered. expectedTotalValuesCount=");
            sb.append(jLongValue);
            sb.append(" processedValuesCount=");
            sb.append(i);
            zzba$$ExternalSyntheticOutline0.m(sb, " expectedNewValuesCount=", j, " batch.size=");
            sb.append(length);
            sb.append(" data.size=");
            sb.append(length2);
            Logger.logInfo(sb.toString());
            this.buffer = fArrPlus;
            return this.emptyArray;
        }
        if (fArrPlus.length <= j) {
            this.processedValuesCount = i + fArrPlus.length;
            this.buffer = this.emptyArray;
            return fArrPlus;
        }
        int length3 = batch.length;
        int length4 = fArrPlus.length;
        StringBuilder sb2 = new StringBuilder("DataFrequencyGuard: There are some extra data, they will be averaged. expectedTotalValuesCount=");
        sb2.append(jLongValue);
        sb2.append(" processedValuesCount=");
        sb2.append(i);
        zzba$$ExternalSyntheticOutline0.m(sb2, " expectedNewValuesCount=", j, " batch.size=");
        sb2.append(length3);
        sb2.append(" data.size=");
        sb2.append(length4);
        Logger.logInfo(sb2.toString());
        int i2 = (int) j;
        float[] fArr2 = new float[i2];
        int i3 = i2 - 1;
        System.arraycopy(fArrPlus, 0, fArr2, 0, i3);
        fArr2[i3] = ScienceUtil.max(fArrPlus, i3, fArrPlus.length);
        this.processedValuesCount += i2;
        this.buffer = this.emptyArray;
        return fArr2;
    }

    public final void start() {
        this.startTime = this.getCurrentTime.invoke().longValue();
        this.processedValuesCount = 0;
        this.buffer = this.emptyArray;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DataFrequencyGuard() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ DataFrequencyGuard(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
