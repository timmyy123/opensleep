package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DynamicTypesKt {
    public static final boolean isDynamic(KotlinType kotlinType) {
        kotlinType.getClass();
        kotlinType.unwrap();
        return false;
    }
}
