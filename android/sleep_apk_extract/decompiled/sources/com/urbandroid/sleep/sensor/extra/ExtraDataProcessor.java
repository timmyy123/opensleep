package com.urbandroid.sleep.sensor.extra;

import com.urbandroid.common.FeatureLogger;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.sensor.extra.ExtraDataCollector;
import io.ktor.http.URLParserKt$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/ExtraDataProcessor;", "C", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector;", "Lcom/urbandroid/common/FeatureLogger;", "producer", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataProducer;", "collector", "aggregator", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataAggregator;", "onValueProduced", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/urbandroid/sleep/sensor/extra/ExtraDataProducer;Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector;Lcom/urbandroid/sleep/sensor/extra/ExtraDataAggregator;Lkotlin/jvm/functions/Function1;)V", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector;", "tag", "", "getTag", "()Ljava/lang/String;", "start", "stop", "process", "record", "Lcom/urbandroid/sleep/domain/SleepRecord;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtraDataProcessor<C extends ExtraDataCollector> implements FeatureLogger {
    private final ExtraDataAggregator<C> aggregator;
    private final C collector;
    private final Function1<Float, Unit> onValueProduced;
    private final ExtraDataProducer producer;
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtraDataProcessor(ExtraDataProducer extraDataProducer, C c, ExtraDataAggregator<C> extraDataAggregator, Function1<? super Float, Unit> function1) {
        extraDataProducer.getClass();
        c.getClass();
        extraDataAggregator.getClass();
        this.producer = extraDataProducer;
        this.collector = c;
        this.aggregator = extraDataAggregator;
        this.onValueProduced = function1;
        this.tag = "DataCollector: " + ExtraDataProcessor.class + " ";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$0(ExtraDataProcessor extraDataProcessor, float f, long j) {
        extraDataProcessor.collector.add(f, j);
        Function1<Float, Unit> function1 = extraDataProcessor.onValueProduced;
        if (function1 != null) {
            function1.invoke(Float.valueOf(f));
        }
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void process(SleepRecord record) {
        record.getClass();
        this.aggregator.aggregate(this.collector, record);
    }

    public final void start() {
        this.producer.start(new URLParserKt$$ExternalSyntheticLambda0(this, 1));
    }

    public final void stop() {
        this.producer.stop();
    }

    public /* synthetic */ ExtraDataProcessor(ExtraDataProducer extraDataProducer, ExtraDataCollector extraDataCollector, ExtraDataAggregator extraDataAggregator, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(extraDataProducer, extraDataCollector, extraDataAggregator, (i & 8) != 0 ? null : function1);
    }
}
