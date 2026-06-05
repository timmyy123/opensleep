package androidx.health.connect.client.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AggregateMetric$Companion$$ExternalSyntheticLambda2 implements AggregateMetric.Converter.FromDouble {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Double.valueOf(AggregateMetric.Companion.doubleMetric$lambda$0(((Double) obj).doubleValue()));
    }
}
