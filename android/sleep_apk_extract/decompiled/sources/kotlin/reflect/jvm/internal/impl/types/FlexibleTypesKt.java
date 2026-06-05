package kotlin.reflect.jvm.internal.impl.types;

import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FlexibleTypesKt {
    public static final FlexibleType asFlexibleType(KotlinType kotlinType) {
        kotlinType.getClass();
        UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        unwrappedTypeUnwrap.getClass();
        return (FlexibleType) unwrappedTypeUnwrap;
    }

    public static final boolean isFlexible(KotlinType kotlinType) {
        kotlinType.getClass();
        return kotlinType.unwrap() instanceof FlexibleType;
    }

    public static final SimpleType lowerIfFlexible(KotlinType kotlinType) {
        kotlinType.getClass();
        UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (unwrappedTypeUnwrap instanceof FlexibleType) {
            return ((FlexibleType) unwrappedTypeUnwrap).getLowerBound();
        }
        if (unwrappedTypeUnwrap instanceof SimpleType) {
            return (SimpleType) unwrappedTypeUnwrap;
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public static final SimpleType upperIfFlexible(KotlinType kotlinType) {
        kotlinType.getClass();
        UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (unwrappedTypeUnwrap instanceof FlexibleType) {
            return ((FlexibleType) unwrappedTypeUnwrap).getUpperBound();
        }
        if (unwrappedTypeUnwrap instanceof SimpleType) {
            return (SimpleType) unwrappedTypeUnwrap;
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}
