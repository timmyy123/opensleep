package kotlin.reflect.jvm.internal;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "Lkotlin/reflect/jvm/internal/CreateKFunctionVisitor;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/DescriptorKCallable;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "data", "", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/DescriptorKCallable;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class CreateKCallableVisitor extends CreateKFunctionVisitor {
    private final KDeclarationContainerImpl container;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateKCallableVisitor(KDeclarationContainerImpl kDeclarationContainerImpl) {
        super(kDeclarationContainerImpl);
        kDeclarationContainerImpl.getClass();
        this.container = kDeclarationContainerImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public DescriptorKCallable<?> visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Unit unit) {
        int i;
        propertyDescriptor.getClass();
        unit.getClass();
        List<ReceiverParameterDescriptor> contextReceiverParameters = propertyDescriptor.getContextReceiverParameters();
        contextReceiverParameters.getClass();
        if (contextReceiverParameters.isEmpty()) {
            i = (propertyDescriptor.getDispatchReceiverParameter() != null ? 1 : 0) + (propertyDescriptor.getExtensionReceiverParameter() != null ? 1 : 0);
        } else {
            i = -1;
        }
        if (propertyDescriptor.isVar()) {
            if (i == -1) {
                return new DescriptorKMutablePropertyN(this.container, propertyDescriptor, KCallableOverriddenStorage.INSTANCE.getEMPTY());
            }
            if (i == 0) {
                return new DescriptorKMutableProperty0(this.container, propertyDescriptor, KCallableOverriddenStorage.INSTANCE.getEMPTY());
            }
            if (i == 1) {
                return new DescriptorKMutableProperty1(this.container, propertyDescriptor, KCallableOverriddenStorage.INSTANCE.getEMPTY());
            }
            if (i == 2) {
                return new DescriptorKMutableProperty2(this.container, propertyDescriptor, KCallableOverriddenStorage.INSTANCE.getEMPTY());
            }
        } else {
            if (i == -1) {
                return new DescriptorKPropertyN(this.container, propertyDescriptor, KCallableOverriddenStorage.INSTANCE.getEMPTY());
            }
            if (i == 0) {
                return new DescriptorKProperty0(this.container, propertyDescriptor, KCallableOverriddenStorage.INSTANCE.getEMPTY());
            }
            if (i == 1) {
                return new DescriptorKProperty1(this.container, propertyDescriptor, KCallableOverriddenStorage.INSTANCE.getEMPTY());
            }
            if (i == 2) {
                return new DescriptorKProperty2(this.container, propertyDescriptor, KCallableOverriddenStorage.INSTANCE.getEMPTY());
            }
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Unsupported property: ", propertyDescriptor);
        return null;
    }
}
