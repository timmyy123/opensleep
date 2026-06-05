package com.urbandroid.sleep.sensor.extra;

import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.sleep.ContextExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\b\n\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/HrDataProducer;", "Lcom/urbandroid/sleep/sensor/extra/BTLEDataProducer;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tag", "", "getTag", "()Ljava/lang/String;", "tag$1", "extract", "", "Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "(Landroid/content/Intent;)[Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HrDataProducer extends BTLEDataProducer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String tag = "DataCollector HR";

    /* JADX INFO: renamed from: tag$1, reason: from kotlin metadata */
    private final String tag;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0016\u001a\u00020\u0013H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/HrDataProducer$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "EXTRA_DATA_HR", "", "HR_MAX", "", "HR_MIN", "tag", "getTag", "()Ljava/lang/String;", "produce", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "hr", "", "timestamp", "", "hrs", "", "intervalMillis", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements FeatureLogger {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return HrDataProducer.tag;
        }

        public final void produce(Context context, List<Float> hrs, long intervalMillis) {
            context.getClass();
            hrs.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i = 0;
            for (Object obj : hrs) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                float fFloatValue = ((Number) obj).floatValue();
                HrDataProducer.INSTANCE.produce(context, fFloatValue, jCurrentTimeMillis - (Math.min(intervalMillis, 60000L) * ((long) (hrs.size() - i))));
                i = i2;
            }
        }

        private Companion() {
        }

        public final void produce(Context context, float[] hrs, long intervalMillis) {
            context.getClass();
            hrs.getClass();
            produce(context, ArraysKt.toList(hrs), intervalMillis);
        }

        public final void produce(Context context, float hr, long timestamp) {
            context.getClass();
            Intent intent = new Intent("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE");
            intent.putExtra("com.urbandroid.sleep.EXTRA_DATA_HR", hr);
            intent.putExtra("com.urbandroid.sleep.EXTRA_DATA_TIMESTAMP", timestamp);
            ContextExtKt.sendLocalBroadcast(context, intent);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HrDataProducer(Context context) {
        super(context);
        context.getClass();
        this.tag = tag;
    }

    public static final void produce(Context context, float f, long j) {
        INSTANCE.produce(context, f, j);
    }

    @Override // com.urbandroid.sleep.sensor.extra.BTLEDataProducer
    public ExtraValue[] extract(Intent intent) {
        intent.getClass();
        return extract(intent, "com.urbandroid.sleep.EXTRA_DATA_HR", new IntRange(27, 150));
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public static final void produce(Context context, List<Float> list, long j) {
        INSTANCE.produce(context, list, j);
    }

    public static final void produce(Context context, float[] fArr, long j) {
        INSTANCE.produce(context, fArr, j);
    }
}
