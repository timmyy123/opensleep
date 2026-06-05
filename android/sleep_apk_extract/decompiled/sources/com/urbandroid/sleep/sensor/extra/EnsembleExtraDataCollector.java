package com.urbandroid.sleep.sensor.extra;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Millis;
import com.urbandroid.common.Minutes;
import com.urbandroid.common.Seconds;
import com.urbandroid.common.TimeType;
import com.urbandroid.common.Utils;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.apnea.ApneaAlarmDetector;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.sensor.extra.ExtraDataCollector;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.Experiments;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001c8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b \u0010\b¨\u0006\""}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/EnsembleExtraDataCollector;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "", "start", "()V", "stop", "Lcom/urbandroid/sleep/domain/SleepRecord;", "record", "process", "(Lcom/urbandroid/sleep/domain/SleepRecord;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/apnea/ApneaAlarmDetector;", "apneaAlarmDetector$delegate", "Lkotlin/Lazy;", "getApneaAlarmDetector", "()Lcom/urbandroid/sleep/apnea/ApneaAlarmDetector;", "apneaAlarmDetector", "", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataProcessor;", "processors", "Ljava/util/List;", "getProcessors$annotations", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnsembleExtraDataCollector implements FeatureLogger {

    /* JADX INFO: renamed from: apneaAlarmDetector$delegate, reason: from kotlin metadata */
    private final Lazy apneaAlarmDetector;
    private final Context context;
    private final List<ExtraDataProcessor<?>> processors;
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public EnsembleExtraDataCollector(Context context) {
        context.getClass();
        this.context = context;
        StringBuilder sb = new StringBuilder("DataCollector");
        String strConcat = null;
        String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
        if (strM != null) {
            strConcat = StringsKt.isBlank(strM) ? "" : ":".concat(strM);
        }
        sb.append(strConcat);
        this.tag = sb.toString();
        this.apneaAlarmDetector = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(this, 14));
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        final int i = 0;
        listCreateListBuilder.add(new ExtraDataProcessor(new HrDataProducer(context), new ExtraDataCollector.Buffered(), new MedianHeartRateAggregator(EventLabel.HR, Millis.m973constructorimpl(Utils.getMinutesInMillis(5)), 2.0f, Millis.m972boximpl(Millis.m973constructorimpl(Utils.getMinutesInMillis(10))), null), new Function1(this) { // from class: com.urbandroid.sleep.sensor.extra.EnsembleExtraDataCollector$$ExternalSyntheticLambda1
            public final /* synthetic */ EnsembleExtraDataCollector f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int i2 = i;
                EnsembleExtraDataCollector ensembleExtraDataCollector = this.f$0;
                float fFloatValue = ((Float) obj).floatValue();
                switch (i2) {
                    case 0:
                        return EnsembleExtraDataCollector.processors$lambda$0$0(ensembleExtraDataCollector, fFloatValue);
                    case 1:
                        return EnsembleExtraDataCollector.processors$lambda$0$1(ensembleExtraDataCollector, fFloatValue);
                    default:
                        return EnsembleExtraDataCollector.processors$lambda$0$2(ensembleExtraDataCollector, fFloatValue);
                }
            }
        }));
        int i2 = 16;
        DefaultConstructorMarker defaultConstructorMarker = null;
        float f = 2.0f;
        TimeType timeType = null;
        final int i3 = 1;
        listCreateListBuilder.add(new ExtraDataProcessor(new Spo2DataProducer(context), new ExtraDataCollector.Buffered(), new CompressingAggregator(EventLabel.SPO2, 0.0f, f, Seconds.m989boximpl(Utils.getSeconds(60)), timeType, i2, defaultConstructorMarker), new Function1(this) { // from class: com.urbandroid.sleep.sensor.extra.EnsembleExtraDataCollector$$ExternalSyntheticLambda1
            public final /* synthetic */ EnsembleExtraDataCollector f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int i22 = i3;
                EnsembleExtraDataCollector ensembleExtraDataCollector = this.f$0;
                float fFloatValue = ((Float) obj).floatValue();
                switch (i22) {
                    case 0:
                        return EnsembleExtraDataCollector.processors$lambda$0$0(ensembleExtraDataCollector, fFloatValue);
                    case 1:
                        return EnsembleExtraDataCollector.processors$lambda$0$1(ensembleExtraDataCollector, fFloatValue);
                    default:
                        return EnsembleExtraDataCollector.processors$lambda$0$2(ensembleExtraDataCollector, fFloatValue);
                }
            }
        }));
        final int i4 = 2;
        listCreateListBuilder.add(new ExtraDataProcessor(new RespirationDataProducer(context), new ExtraDataCollector.Buffered(), new CompressingAggregator(EventLabel.RR, 8.0f, f, Seconds.m989boximpl(Utils.getSeconds(120)), timeType, i2, defaultConstructorMarker), new Function1(this) { // from class: com.urbandroid.sleep.sensor.extra.EnsembleExtraDataCollector$$ExternalSyntheticLambda1
            public final /* synthetic */ EnsembleExtraDataCollector f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int i22 = i4;
                EnsembleExtraDataCollector ensembleExtraDataCollector = this.f$0;
                float fFloatValue = ((Float) obj).floatValue();
                switch (i22) {
                    case 0:
                        return EnsembleExtraDataCollector.processors$lambda$0$0(ensembleExtraDataCollector, fFloatValue);
                    case 1:
                        return EnsembleExtraDataCollector.processors$lambda$0$1(ensembleExtraDataCollector, fFloatValue);
                    default:
                        return EnsembleExtraDataCollector.processors$lambda$0$2(ensembleExtraDataCollector, fFloatValue);
                }
            }
        }));
        if (new Settings(context).isAwakeDetectionLight()) {
            listCreateListBuilder.add(new ExtraDataProcessor(new LightSensorExtraDataProducer(context), new ExtraDataCollector.SingleValue(0.0f), new CompressingAggregator(EventLabel.LUX, 5.0f, 3.0f, Minutes.m981boximpl(Utils.getMinutes(7)), Minutes.m981boximpl(Utils.getMinutes(2))), null, 8, null));
        }
        if (Experiments.getInstance().isHrvExperiment()) {
            listCreateListBuilder.add(new ExtraDataProcessor(new RRIntervalsDataProducer(context), new ExtraDataCollector.Buffered(), new RRIntervalsAggregator(), null, 8, null));
        }
        if (Experiments.getInstance().isHrvExperiment()) {
            listCreateListBuilder.add(new ExtraDataProcessor(new SDNNDataProducer(context), new ExtraDataCollector.Buffered(), new MedianAggregator(EventLabel.SDNN, Minutes.m981boximpl(Utils.getMinutes(5)), null, 4, null), null, 8, 0 == true ? 1 : 0));
        }
        this.processors = CollectionsKt.build(listCreateListBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApneaAlarmDetector apneaAlarmDetector_delegate$lambda$0(EnsembleExtraDataCollector ensembleExtraDataCollector) {
        Context context = ensembleExtraDataCollector.context;
        return new ApneaAlarmDetector(context, ContextExtKt.getSettings(context).getApneaAlarmSensitivity());
    }

    private final ApneaAlarmDetector getApneaAlarmDetector() {
        return (ApneaAlarmDetector) this.apneaAlarmDetector.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processors$lambda$0$0(EnsembleExtraDataCollector ensembleExtraDataCollector, float f) {
        Context context = ensembleExtraDataCollector.context;
        Intent intentPutExtra = new Intent("com.urbandroid.sleep.ACTION_HR_UI_UPDATE").putExtra("extra_hr_update", f);
        intentPutExtra.getClass();
        ContextExtKt.sendLocalBroadcast(context, intentPutExtra);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processors$lambda$0$1(EnsembleExtraDataCollector ensembleExtraDataCollector, float f) {
        ensembleExtraDataCollector.getApneaAlarmDetector().add(f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processors$lambda$0$2(EnsembleExtraDataCollector ensembleExtraDataCollector, float f) {
        ensembleExtraDataCollector.getApneaAlarmDetector().add(f);
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void process(SleepRecord record) {
        record.getClass();
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            ((ExtraDataProcessor) it.next()).process(record);
        }
    }

    public final void start() {
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            ((ExtraDataProcessor) it.next()).start();
        }
    }

    public final void stop() {
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            ((ExtraDataProcessor) it.next()).stop();
        }
    }
}
