package com.urbandroid.sleep.sensor.extra;

import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.Utils;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.hr.RawHrDataPersister;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ%\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0014¢\u0006\u0002\u0010\u0018J\"\u0010\u0019\u001a\u00020\u001a2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/RRIntervalsDataProducer;", "Lcom/urbandroid/sleep/sensor/extra/BTLEDataProducer;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tag", "", "getTag", "()Ljava/lang/String;", "extract", "", "Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "(Landroid/content/Intent;)[Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", "externalDataLog", "Lcom/urbandroid/sleep/hr/RawHrDataPersister;", "extractValuesBatch", "range", "Lkotlin/ranges/IntRange;", "(Landroid/content/Intent;Lkotlin/ranges/IntRange;)[Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", "extractSingleValue", "extraName", "(Landroid/content/Intent;Ljava/lang/String;Lkotlin/ranges/IntRange;)[Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", "start", "", "onNewValue", "Lkotlin/Function2;", "", "", "stop", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RRIntervalsDataProducer extends BTLEDataProducer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int RR_MAX = (int) Utils.getMinutesInMillis(60);
    private static final int RR_MIN = 0;
    private static volatile boolean receivingRRIntervals;
    private final RawHrDataPersister externalDataLog;
    private final String tag;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0086D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/RRIntervalsDataProducer$Companion;", "", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "rr", "", "timestamp", "", "produce", "(Landroid/content/Context;FJ)V", "", "RR_MIN", "I", "getRR_MIN", "()I", "RR_MAX", "getRR_MAX", "", "receivingRRIntervals", "Z", "getReceivingRRIntervals", "()Z", "setReceivingRRIntervals", "(Z)V", "", "EXTRA_DATA_RR", "Ljava/lang/String;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getRR_MAX() {
            return RRIntervalsDataProducer.RR_MAX;
        }

        public final int getRR_MIN() {
            return RRIntervalsDataProducer.RR_MIN;
        }

        public final boolean getReceivingRRIntervals() {
            return RRIntervalsDataProducer.receivingRRIntervals;
        }

        public final void produce(Context context, float rr, long timestamp) {
            context.getClass();
            Intent intent = new Intent("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE");
            intent.putExtra("com.urbandroid.sleep.EXTRA_DATA_RR", rr);
            intent.putExtra("com.urbandroid.sleep.EXTRA_DATA_TIMESTAMP", timestamp);
            ContextExtKt.sendLocalBroadcast(context, intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RRIntervalsDataProducer(Context context) {
        super(context);
        context.getClass();
        this.tag = "DataCollector RR";
        this.externalDataLog = new RawHrDataPersister("extra data from outside");
    }

    @Override // com.urbandroid.sleep.sensor.extra.BTLEDataProducer
    public ExtraValue[] extract(Intent intent) {
        intent.getClass();
        return extract(intent, "com.urbandroid.sleep.EXTRA_DATA_RR", new IntRange(RR_MIN, RR_MAX));
    }

    @Override // com.urbandroid.sleep.sensor.extra.BTLEDataProducer
    public ExtraValue[] extractSingleValue(Intent intent, String extraName, IntRange range) {
        intent.getClass();
        extraName.getClass();
        range.getClass();
        ExtraValue[] extraValueArrExtractSingleValue = super.extractSingleValue(intent, extraName, range);
        if (extraValueArrExtractSingleValue != null) {
            if (!(extraValueArrExtractSingleValue.length == 0)) {
                receivingRRIntervals = true;
                ExtraValue extraValue = extraValueArrExtractSingleValue[0];
                this.externalDataLog.addRR(extraValue.getTimestamp(), extraValue.getValue());
            }
        }
        return extraValueArrExtractSingleValue;
    }

    @Override // com.urbandroid.sleep.sensor.extra.BTLEDataProducer
    public ExtraValue[] extractValuesBatch(Intent intent, IntRange range) {
        List<Float> listReversed;
        intent.getClass();
        range.getClass();
        long longExtra = intent.getLongExtra("com.urbandroid.sleep.EXTRA_DATA_TIMESTAMP", System.currentTimeMillis());
        float[] floatArrayExtra = intent.getFloatArrayExtra("com.urbandroid.sleep.EXTRA_DATA_BATCH");
        if (floatArrayExtra != null && floatArrayExtra.length != 0) {
            receivingRRIntervals = true;
        }
        if (floatArrayExtra == null || (listReversed = ArraysKt.reversed(floatArrayExtra)) == null) {
            return null;
        }
        List<Float> list = listReversed;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            float fFloatValue = ((Number) it.next()).floatValue();
            ExtraValue extraValue = new ExtraValue(fFloatValue, longExtra);
            longExtra -= (long) fFloatValue;
            arrayList.add(extraValue);
        }
        List listReversed2 = CollectionsKt.reversed(arrayList);
        if (listReversed2 == null) {
            return null;
        }
        List<ExtraValue> list2 = listReversed2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ExtraValue extraValue2 : list2) {
            this.externalDataLog.addRR(extraValue2.getTimestamp(), extraValue2.getValue());
            arrayList2.add(extraValue2);
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            int first = range.getFirst();
            int last = range.getLast();
            int value = (int) ((ExtraValue) obj).getValue();
            if (first <= value && value <= last) {
                arrayList3.add(obj);
            }
        }
        return (ExtraValue[]) arrayList3.toArray(new ExtraValue[0]);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.sensor.extra.BTLEDataProducer, com.urbandroid.sleep.sensor.extra.ExtraDataProducer
    public void start(Function2<? super Float, ? super Long, Unit> onNewValue) {
        onNewValue.getClass();
        super.start(onNewValue);
        receivingRRIntervals = false;
    }

    @Override // com.urbandroid.sleep.sensor.extra.BTLEDataProducer, com.urbandroid.sleep.sensor.extra.ExtraDataProducer
    public void stop() {
        super.stop();
        this.externalDataLog.stop();
    }
}
