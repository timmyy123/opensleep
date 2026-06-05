package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class TripleSerializer$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ TripleSerializer$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return TripleSerializer.descriptor$lambda$0((TripleSerializer) obj2, (ClassSerialDescriptorBuilder) obj);
            default:
                return PluginGeneratedSerialDescriptor.toString$lambda$6((PluginGeneratedSerialDescriptor) obj2, ((Integer) obj).intValue());
        }
    }
}
