package io.ktor.util.reflect;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0004\b\u0004\u0010\u0005*\f\b\u0007\u0010\u0007\"\u00020\u00062\u00020\u0006¨\u0006\b"}, d2 = {"", "Lkotlin/reflect/KClass;", "type", "", "instanceOf", "(Ljava/lang/Object;Lkotlin/reflect/KClass;)Z", "Ljava/lang/reflect/Type;", "Type", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class TypeInfoJvmKt {
    public static final boolean instanceOf(Object obj, KClass<?> kClass) {
        obj.getClass();
        kClass.getClass();
        return JvmClassMappingKt.getJavaClass(kClass).isInstance(obj);
    }
}
