package kotlinx.serialization;

import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SealedClassSerializer$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AbstractPolymorphicSerializer f$0;

    public /* synthetic */ SealedClassSerializer$$ExternalSyntheticLambda1(AbstractPolymorphicSerializer abstractPolymorphicSerializer, int i) {
        this.$r8$classId = i;
        this.f$0 = abstractPolymorphicSerializer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        AbstractPolymorphicSerializer abstractPolymorphicSerializer = this.f$0;
        switch (i) {
            case 0:
                return SealedClassSerializer.descriptor_delegate$lambda$3$lambda$2((SealedClassSerializer) abstractPolymorphicSerializer, (ClassSerialDescriptorBuilder) obj);
            case 1:
                return SealedClassSerializer.descriptor_delegate$lambda$3$lambda$2$lambda$1((SealedClassSerializer) abstractPolymorphicSerializer, (ClassSerialDescriptorBuilder) obj);
            default:
                return PolymorphicSerializer.descriptor_delegate$lambda$1$lambda$0((PolymorphicSerializer) abstractPolymorphicSerializer, (ClassSerialDescriptorBuilder) obj);
        }
    }
}
