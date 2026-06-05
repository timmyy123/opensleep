package kotlin.reflect.jvm.internal.impl.km.jvm;

import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmFlags;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JvmAttributes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(JvmAttributes.class, "hasAnnotationsInBytecode", "getHasAnnotationsInBytecode(Lkotlin/metadata/KmClass;)Z", 1), new MutablePropertyReference1Impl(JvmAttributes.class, "hasAnnotationsInBytecode", "getHasAnnotationsInBytecode(Lkotlin/metadata/KmConstructor;)Z", 1), new MutablePropertyReference1Impl(JvmAttributes.class, "hasAnnotationsInBytecode", "getHasAnnotationsInBytecode(Lkotlin/metadata/KmFunction;)Z", 1), new MutablePropertyReference1Impl(JvmAttributes.class, "hasAnnotationsInBytecode", "getHasAnnotationsInBytecode(Lkotlin/metadata/KmProperty;)Z", 1), new MutablePropertyReference1Impl(JvmAttributes.class, "hasAnnotationsInBytecode", "getHasAnnotationsInBytecode(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1), new MutablePropertyReference1Impl(JvmAttributes.class, "hasAnnotationsInBytecode", "getHasAnnotationsInBytecode(Lkotlin/metadata/KmValueParameter;)Z", 1), new MutablePropertyReference1Impl(JvmAttributes.class, "isMovedFromInterfaceCompanion", "isMovedFromInterfaceCompanion(Lkotlin/metadata/KmProperty;)Z", 1), new MutablePropertyReference1Impl(JvmAttributes.class, "hasMethodBodiesInInterface", "getHasMethodBodiesInInterface(Lkotlin/metadata/KmClass;)Z", 1), new MutablePropertyReference1Impl(JvmAttributes.class, "isCompiledInCompatibilityMode", "isCompiledInCompatibilityMode(Lkotlin/metadata/KmClass;)Z", 1)};
    private static final BooleanFlagDelegate hasAnnotationsInBytecode$delegate;
    private static final BooleanFlagDelegate hasAnnotationsInBytecode$delegate$1;
    private static final BooleanFlagDelegate hasAnnotationsInBytecode$delegate$2;
    private static final BooleanFlagDelegate hasAnnotationsInBytecode$delegate$3;
    private static final BooleanFlagDelegate hasAnnotationsInBytecode$delegate$4;
    private static final BooleanFlagDelegate hasAnnotationsInBytecode$delegate$5;
    private static final BooleanFlagDelegate hasMethodBodiesInInterface$delegate;
    private static final BooleanFlagDelegate isCompiledInCompatibilityMode$delegate;
    private static final BooleanFlagDelegate isMovedFromInterfaceCompanion$delegate;

    static {
        Flags.BooleanFlagField booleanFlagField = Flags.HAS_ANNOTATIONS;
        booleanFlagField.getClass();
        hasAnnotationsInBytecode$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField));
        booleanFlagField.getClass();
        hasAnnotationsInBytecode$delegate$1 = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(booleanFlagField));
        booleanFlagField.getClass();
        hasAnnotationsInBytecode$delegate$2 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField));
        booleanFlagField.getClass();
        hasAnnotationsInBytecode$delegate$3 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField));
        booleanFlagField.getClass();
        hasAnnotationsInBytecode$delegate$4 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(booleanFlagField));
        booleanFlagField.getClass();
        hasAnnotationsInBytecode$delegate$5 = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(booleanFlagField));
        AnonymousClass2 anonymousClass2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.jvm.JvmAttributes.isMovedFromInterfaceCompanion.2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(JvmAttributes.getJvmFlags((KmProperty) obj));
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                JvmAttributes.setJvmFlags((KmProperty) obj, ((Number) obj2).intValue());
            }
        };
        JvmFlags jvmFlags = JvmFlags.INSTANCE;
        Flags.BooleanFlagField is_moved_from_interface_companion = jvmFlags.getIS_MOVED_FROM_INTERFACE_COMPANION();
        is_moved_from_interface_companion.getClass();
        isMovedFromInterfaceCompanion$delegate = new BooleanFlagDelegate(anonymousClass2, booleanFlag(is_moved_from_interface_companion));
        JvmAttributes$hasMethodBodiesInInterface$2 jvmAttributes$hasMethodBodiesInInterface$2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.jvm.JvmAttributes$hasMethodBodiesInInterface$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(JvmAttributes.getJvmFlags((KmClass) obj));
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                JvmAttributes.setJvmFlags((KmClass) obj, ((Number) obj2).intValue());
            }
        };
        Flags.BooleanFlagField is_compiled_in_jvm_default_mode = jvmFlags.getIS_COMPILED_IN_JVM_DEFAULT_MODE();
        is_compiled_in_jvm_default_mode.getClass();
        hasMethodBodiesInInterface$delegate = new BooleanFlagDelegate(jvmAttributes$hasMethodBodiesInInterface$2, booleanFlag(is_compiled_in_jvm_default_mode));
        JvmAttributes$isCompiledInCompatibilityMode$2 jvmAttributes$isCompiledInCompatibilityMode$2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.jvm.JvmAttributes$isCompiledInCompatibilityMode$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(JvmAttributes.getJvmFlags((KmClass) obj));
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                JvmAttributes.setJvmFlags((KmClass) obj, ((Number) obj2).intValue());
            }
        };
        Flags.BooleanFlagField is_compiled_in_compatibility_mode = jvmFlags.getIS_COMPILED_IN_COMPATIBILITY_MODE();
        is_compiled_in_compatibility_mode.getClass();
        isCompiledInCompatibilityMode$delegate = new BooleanFlagDelegate(jvmAttributes$isCompiledInCompatibilityMode$2, booleanFlag(is_compiled_in_compatibility_mode));
    }

    private static final FlagImpl booleanFlag(Flags.BooleanFlagField booleanFlagField) {
        return new FlagImpl(booleanFlagField.offset, booleanFlagField.bitWidth, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getJvmFlags(KmProperty kmProperty) {
        return JvmExtensionNodesKt.getJvm(kmProperty).getJvmFlags();
    }

    public static final boolean isMovedFromInterfaceCompanion(KmProperty kmProperty) {
        kmProperty.getClass();
        return isMovedFromInterfaceCompanion$delegate.getValue(kmProperty, $$delegatedProperties[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setJvmFlags(KmProperty kmProperty, int i) {
        JvmExtensionNodesKt.getJvm(kmProperty).setJvmFlags(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setJvmFlags(KmClass kmClass, int i) {
        JvmExtensionNodesKt.getJvm(kmClass).setJvmFlags(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getJvmFlags(KmClass kmClass) {
        return JvmExtensionNodesKt.getJvm(kmClass).getJvmFlags();
    }
}
