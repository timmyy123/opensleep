package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* JADX INFO: loaded from: classes5.dex */
public abstract class KotlinTypeKt {
    public static final boolean isError(KotlinType kotlinType) {
        kotlinType.getClass();
        UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (unwrappedTypeUnwrap instanceof ErrorType) {
            return true;
        }
        return (unwrappedTypeUnwrap instanceof FlexibleType) && (((FlexibleType) unwrappedTypeUnwrap).getDelegate() instanceof ErrorType);
    }

    public static final boolean isNullable(KotlinType kotlinType) {
        kotlinType.getClass();
        return TypeUtils.isNullableType(kotlinType);
    }
}
