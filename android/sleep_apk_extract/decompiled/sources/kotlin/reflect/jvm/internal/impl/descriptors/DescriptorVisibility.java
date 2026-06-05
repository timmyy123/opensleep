package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DescriptorVisibility {
    public final Integer compareTo(DescriptorVisibility descriptorVisibility) {
        descriptorVisibility.getClass();
        return getDelegate().compareTo(descriptorVisibility.getDelegate());
    }

    public abstract Visibility getDelegate();

    public abstract String getInternalDisplayName();

    public final boolean isPublicAPI() {
        return getDelegate().isPublicAPI();
    }

    public abstract boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor, boolean z);

    public abstract DescriptorVisibility normalize();

    public final String toString() {
        return getDelegate().toString();
    }
}
