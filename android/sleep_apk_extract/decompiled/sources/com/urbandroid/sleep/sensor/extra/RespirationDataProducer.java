package com.urbandroid.sleep.sensor.extra;

import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/RespirationDataProducer;", "Lcom/urbandroid/sleep/sensor/extra/BTLEDataProducer;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tag", "", "getTag", "()Ljava/lang/String;", "extract", "", "Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "(Landroid/content/Intent;)[Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RespirationDataProducer extends BTLEDataProducer {
    private final String tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RespirationDataProducer(Context context) {
        super(context);
        context.getClass();
        this.tag = "DataCollector Resp";
    }

    @Override // com.urbandroid.sleep.sensor.extra.BTLEDataProducer
    public ExtraValue[] extract(Intent intent) {
        intent.getClass();
        return extract(intent, "com.urbandroid.sleep.EXTRA_DATA_RESP", new IntRange(8, 20));
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }
}
