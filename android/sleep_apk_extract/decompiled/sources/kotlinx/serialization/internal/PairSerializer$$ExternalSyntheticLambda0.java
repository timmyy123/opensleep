package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function1;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PairSerializer$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ KSerializer f$0;
    public final /* synthetic */ KSerializer f$1;

    public /* synthetic */ PairSerializer$$ExternalSyntheticLambda0(KSerializer kSerializer, KSerializer kSerializer2, int i) {
        this.$r8$classId = i;
        this.f$0 = kSerializer;
        this.f$1 = kSerializer2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return PairSerializer.descriptor$lambda$0(this.f$0, this.f$1, (ClassSerialDescriptorBuilder) obj);
            default:
                return MapEntrySerializer.descriptor$lambda$0(this.f$0, this.f$1, (ClassSerialDescriptorBuilder) obj);
        }
    }
}
