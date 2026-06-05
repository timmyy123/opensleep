package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes5.dex */
public abstract class InvalidModuleExceptionKt {
    private static final ModuleCapability<Object> INVALID_MODULE_NOTIFIER_CAPABILITY = new ModuleCapability<>("InvalidModuleNotifier");

    public static final void moduleInvalidated(ModuleDescriptor moduleDescriptor) {
        moduleDescriptor.getClass();
        if (moduleDescriptor.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY) != null) {
            throw new ClassCastException();
        }
        throw new InvalidModuleException("Accessing invalid module descriptor " + moduleDescriptor);
    }
}
