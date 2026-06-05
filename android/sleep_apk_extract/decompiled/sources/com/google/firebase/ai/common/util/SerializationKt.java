package com.google.firebase.ai.common.util;

import com.google.firebase.ai.type.SerializationException;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerialName;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0000¢\u0006\u0002\u0010\t\"(\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"serialName", "", "T", "", "getSerialName", "(Ljava/lang/Enum;)Ljava/lang/String;", "enumValues", "", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)[Ljava/lang/Enum;", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SerializationKt {
    public static final <T extends Enum<T>> T[] enumValues(KClass<T> kClass) {
        kClass.getClass();
        T[] tArr = (T[]) ((Enum[]) JvmClassMappingKt.getJavaClass(kClass).getEnumConstants());
        if (tArr != null) {
            return tArr;
        }
        throw new SerializationException(kClass.getSimpleName() + " is not a valid enum type.", null, 2, null);
    }

    public static final <T extends Enum<T>> String getSerialName(T t) throws NoSuchFieldException {
        String strValue;
        t.getClass();
        Class declaringClass = t.getDeclaringClass();
        declaringClass.getClass();
        Field field = declaringClass.getField(t.name());
        field.getClass();
        SerialName serialName = (SerialName) field.getAnnotation(SerialName.class);
        return (serialName == null || (strValue = serialName.value()) == null) ? t.name() : strValue;
    }
}
