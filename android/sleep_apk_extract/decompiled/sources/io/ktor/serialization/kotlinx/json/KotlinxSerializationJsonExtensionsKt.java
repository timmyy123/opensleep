package io.ktor.serialization.kotlinx.json;

import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/util/reflect/TypeInfo;", "argumentTypeInfo", "(Lio/ktor/util/reflect/TypeInfo;)Lio/ktor/util/reflect/TypeInfo;", "ktor-serialization-kotlinx-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class KotlinxSerializationJsonExtensionsKt {
    public static final TypeInfo argumentTypeInfo(TypeInfo typeInfo) {
        typeInfo.getClass();
        KType kotlinType = typeInfo.getKotlinType();
        kotlinType.getClass();
        KType type = kotlinType.getArguments().get(0).getType();
        type.getClass();
        KClassifier classifier = type.getClassifier();
        classifier.getClass();
        return new TypeInfo((KClass) classifier, type);
    }
}
