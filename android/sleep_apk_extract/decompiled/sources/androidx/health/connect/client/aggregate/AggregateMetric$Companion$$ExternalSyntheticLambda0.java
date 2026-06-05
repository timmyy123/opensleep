package androidx.health.connect.client.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AggregateMetric$Companion$$ExternalSyntheticLambda0 implements AggregateMetric.Converter.FromLong {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ AggregateMetric$Companion$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        long jCountMetric$lambda$2;
        Long l = (Long) obj;
        switch (this.$r8$classId) {
            case 0:
                jCountMetric$lambda$2 = AggregateMetric.Companion.countMetric$lambda$2(l.longValue());
                break;
            default:
                jCountMetric$lambda$2 = AggregateMetric.Companion.longMetric$lambda$1(l.longValue());
                break;
        }
        return Long.valueOf(jCountMetric$lambda$2);
    }
}
