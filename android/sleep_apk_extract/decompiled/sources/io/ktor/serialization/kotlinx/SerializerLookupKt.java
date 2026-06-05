package io.ktor.serialization.kotlinx;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0003\"\b\b\u0000\u0010\u0007*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "Lkotlinx/serialization/KSerializer;", "serializerForTypeInfo", "(Lkotlinx/serialization/modules/SerializersModule;Lio/ktor/util/reflect/TypeInfo;)Lkotlinx/serialization/KSerializer;", "", "T", "maybeNullable", "(Lkotlinx/serialization/KSerializer;Lio/ktor/util/reflect/TypeInfo;)Lkotlinx/serialization/KSerializer;", SDKConstants.PARAM_VALUE, "module", "guessSerializer", "(Ljava/lang/Object;Lkotlinx/serialization/modules/SerializersModule;)Lkotlinx/serialization/KSerializer;", "", "elementSerializer", "(Ljava/util/Collection;Lkotlinx/serialization/modules/SerializersModule;)Lkotlinx/serialization/KSerializer;", "ktor-serialization-kotlinx"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class SerializerLookupKt {
    private static final KSerializer<?> elementSerializer(Collection<?> collection, SerializersModule serializersModule) {
        Collection<?> collection2 = collection;
        List listFilterNotNull = CollectionsKt.filterNotNull(collection2);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterNotNull, 10));
        Iterator it = listFilterNotNull.iterator();
        while (it.hasNext()) {
            arrayList.add(guessSerializer(it.next(), serializersModule));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (hashSet.add(((KSerializer) obj).getDescriptor().getSerialName())) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.size() > 1) {
            StringBuilder sb = new StringBuilder("Serializing collections of different element types is not yet supported. Selected serializers: ");
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((KSerializer) it2.next()).getDescriptor().getSerialName());
            }
            sb.append(arrayList3);
            throw new IllegalStateException(sb.toString().toString());
        }
        KSerializer<String> kSerializerSerializer = (KSerializer) CollectionsKt.singleOrNull((List) arrayList2);
        if (kSerializerSerializer == null) {
            kSerializerSerializer = BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE);
        }
        if (!kSerializerSerializer.getDescriptor().isNullable() && (!(collection2 instanceof Collection) || !collection2.isEmpty())) {
            Iterator<T> it3 = collection2.iterator();
            while (it3.hasNext()) {
                if (it3.next() == null) {
                    return BuiltinSerializersKt.getNullable(kSerializerSerializer);
                }
            }
        }
        return kSerializerSerializer;
    }

    public static final KSerializer<Object> guessSerializer(Object obj, SerializersModule serializersModule) {
        KSerializer<Object> kSerializerSerializer;
        serializersModule.getClass();
        if (obj == null) {
            kSerializerSerializer = BuiltinSerializersKt.getNullable(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
        } else if (obj instanceof List) {
            kSerializerSerializer = BuiltinSerializersKt.ListSerializer(elementSerializer((Collection) obj, serializersModule));
        } else if (obj instanceof Object[]) {
            Object objFirstOrNull = ArraysKt.firstOrNull((Object[]) obj);
            if (objFirstOrNull == null || (kSerializerSerializer = guessSerializer(objFirstOrNull, serializersModule)) == null) {
                kSerializerSerializer = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
            }
        } else if (obj instanceof Set) {
            kSerializerSerializer = BuiltinSerializersKt.SetSerializer(elementSerializer((Collection) obj, serializersModule));
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            kSerializerSerializer = BuiltinSerializersKt.MapSerializer(elementSerializer(map.keySet(), serializersModule), elementSerializer(map.values(), serializersModule));
        } else {
            KSerializer<Object> contextual$default = SerializersModule.getContextual$default(serializersModule, Reflection.getOrCreateKotlinClass(obj.getClass()), null, 2, null);
            kSerializerSerializer = contextual$default == null ? SerializersKt.serializer(Reflection.getOrCreateKotlinClass(obj.getClass())) : contextual$default;
        }
        kSerializerSerializer.getClass();
        return kSerializerSerializer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> KSerializer<?> maybeNullable(KSerializer<T> kSerializer, TypeInfo typeInfo) {
        KType kotlinType = typeInfo.getKotlinType();
        return (kotlinType == null || !kotlinType.getIsMarkedNullable()) ? kSerializer : BuiltinSerializersKt.getNullable(kSerializer);
    }

    public static final KSerializer<?> serializerForTypeInfo(SerializersModule serializersModule, TypeInfo typeInfo) {
        serializersModule.getClass();
        typeInfo.getClass();
        KType kotlinType = typeInfo.getKotlinType();
        if (kotlinType != null) {
            KSerializer<?> kSerializerSerializerOrNull = kotlinType.getArguments().isEmpty() ? null : SerializersKt.serializerOrNull(serializersModule, kotlinType);
            if (kSerializerSerializerOrNull != null) {
                return kSerializerSerializerOrNull;
            }
        }
        KSerializer contextual$default = SerializersModule.getContextual$default(serializersModule, typeInfo.getType(), null, 2, null);
        return contextual$default != null ? maybeNullable(contextual$default, typeInfo) : maybeNullable(SerializersKt.serializer(typeInfo.getType()), typeInfo);
    }
}
