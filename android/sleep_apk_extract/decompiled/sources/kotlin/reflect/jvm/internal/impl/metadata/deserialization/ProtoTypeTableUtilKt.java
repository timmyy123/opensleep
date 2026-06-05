package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ProtoTypeTableUtilKt {
    public static final ProtoBuf$Type abbreviatedType(ProtoBuf$Type protoBuf$Type, TypeTable typeTable) {
        protoBuf$Type.getClass();
        typeTable.getClass();
        if (protoBuf$Type.hasAbbreviatedType()) {
            return protoBuf$Type.getAbbreviatedType();
        }
        if (protoBuf$Type.hasAbbreviatedTypeId()) {
            return typeTable.get(protoBuf$Type.getAbbreviatedTypeId());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static final List<ProtoBuf$Type> contextReceiverTypes(ProtoBuf$Class protoBuf$Class, TypeTable typeTable) {
        protoBuf$Class.getClass();
        typeTable.getClass();
        List<ProtoBuf$Type> contextReceiverTypeList = protoBuf$Class.getContextReceiverTypeList();
        boolean zIsEmpty = contextReceiverTypeList.isEmpty();
        ?? arrayList = contextReceiverTypeList;
        if (zIsEmpty) {
            arrayList = 0;
        }
        if (arrayList == 0) {
            List<Integer> contextReceiverTypeIdList = protoBuf$Class.getContextReceiverTypeIdList();
            contextReceiverTypeIdList.getClass();
            List<Integer> list = contextReceiverTypeIdList;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Integer num : list) {
                num.getClass();
                arrayList.add(typeTable.get(num.intValue()));
            }
        }
        return arrayList;
    }

    public static final ProtoBuf$Type expandedType(ProtoBuf$TypeAlias protoBuf$TypeAlias, TypeTable typeTable) {
        protoBuf$TypeAlias.getClass();
        typeTable.getClass();
        if (protoBuf$TypeAlias.hasExpandedType()) {
            ProtoBuf$Type expandedType = protoBuf$TypeAlias.getExpandedType();
            expandedType.getClass();
            return expandedType;
        }
        if (protoBuf$TypeAlias.hasExpandedTypeId()) {
            return typeTable.get(protoBuf$TypeAlias.getExpandedTypeId());
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("No expandedType in ProtoBuf.TypeAlias");
        return null;
    }

    public static final ProtoBuf$Type flexibleUpperBound(ProtoBuf$Type protoBuf$Type, TypeTable typeTable) {
        protoBuf$Type.getClass();
        typeTable.getClass();
        if (protoBuf$Type.hasFlexibleUpperBound()) {
            return protoBuf$Type.getFlexibleUpperBound();
        }
        if (protoBuf$Type.hasFlexibleUpperBoundId()) {
            return typeTable.get(protoBuf$Type.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final boolean hasReceiver(ProtoBuf$Function protoBuf$Function) {
        protoBuf$Function.getClass();
        return protoBuf$Function.hasReceiverType() || protoBuf$Function.hasReceiverTypeId();
    }

    public static final ProtoBuf$Type inlineClassUnderlyingType(ProtoBuf$Class protoBuf$Class, TypeTable typeTable) {
        protoBuf$Class.getClass();
        typeTable.getClass();
        if (protoBuf$Class.hasInlineClassUnderlyingType()) {
            return protoBuf$Class.getInlineClassUnderlyingType();
        }
        if (protoBuf$Class.hasInlineClassUnderlyingTypeId()) {
            return typeTable.get(protoBuf$Class.getInlineClassUnderlyingTypeId());
        }
        return null;
    }

    public static final ProtoBuf$Type isInstanceType(ProtoBuf$Expression protoBuf$Expression, TypeTable typeTable) {
        protoBuf$Expression.getClass();
        typeTable.getClass();
        if (protoBuf$Expression.hasIsInstanceType()) {
            return protoBuf$Expression.getIsInstanceType();
        }
        if (protoBuf$Expression.hasIsInstanceTypeId()) {
            return typeTable.get(protoBuf$Expression.getIsInstanceTypeId());
        }
        return null;
    }

    public static final ProtoBuf$Type outerType(ProtoBuf$Type protoBuf$Type, TypeTable typeTable) {
        protoBuf$Type.getClass();
        typeTable.getClass();
        if (protoBuf$Type.hasOuterType()) {
            return protoBuf$Type.getOuterType();
        }
        if (protoBuf$Type.hasOuterTypeId()) {
            return typeTable.get(protoBuf$Type.getOuterTypeId());
        }
        return null;
    }

    public static final ProtoBuf$Type receiverType(ProtoBuf$Function protoBuf$Function, TypeTable typeTable) {
        protoBuf$Function.getClass();
        typeTable.getClass();
        if (protoBuf$Function.hasReceiverType()) {
            return protoBuf$Function.getReceiverType();
        }
        if (protoBuf$Function.hasReceiverTypeId()) {
            return typeTable.get(protoBuf$Function.getReceiverTypeId());
        }
        return null;
    }

    public static final ProtoBuf$Type returnType(ProtoBuf$Function protoBuf$Function, TypeTable typeTable) {
        protoBuf$Function.getClass();
        typeTable.getClass();
        if (protoBuf$Function.hasReturnType()) {
            ProtoBuf$Type returnType = protoBuf$Function.getReturnType();
            returnType.getClass();
            return returnType;
        }
        if (protoBuf$Function.hasReturnTypeId()) {
            return typeTable.get(protoBuf$Function.getReturnTypeId());
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("No returnType in ProtoBuf.Function");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static final List<ProtoBuf$Type> supertypes(ProtoBuf$Class protoBuf$Class, TypeTable typeTable) {
        protoBuf$Class.getClass();
        typeTable.getClass();
        List<ProtoBuf$Type> supertypeList = protoBuf$Class.getSupertypeList();
        boolean zIsEmpty = supertypeList.isEmpty();
        ?? arrayList = supertypeList;
        if (zIsEmpty) {
            arrayList = 0;
        }
        if (arrayList == 0) {
            List<Integer> supertypeIdList = protoBuf$Class.getSupertypeIdList();
            supertypeIdList.getClass();
            List<Integer> list = supertypeIdList;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Integer num : list) {
                num.getClass();
                arrayList.add(typeTable.get(num.intValue()));
            }
        }
        return arrayList;
    }

    public static final ProtoBuf$Type type(ProtoBuf$ValueParameter protoBuf$ValueParameter, TypeTable typeTable) {
        protoBuf$ValueParameter.getClass();
        typeTable.getClass();
        if (protoBuf$ValueParameter.hasType()) {
            ProtoBuf$Type type = protoBuf$ValueParameter.getType();
            type.getClass();
            return type;
        }
        if (protoBuf$ValueParameter.hasTypeId()) {
            return typeTable.get(protoBuf$ValueParameter.getTypeId());
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("No type in ProtoBuf.ValueParameter");
        return null;
    }

    public static final ProtoBuf$Type underlyingType(ProtoBuf$TypeAlias protoBuf$TypeAlias, TypeTable typeTable) {
        protoBuf$TypeAlias.getClass();
        typeTable.getClass();
        if (protoBuf$TypeAlias.hasUnderlyingType()) {
            ProtoBuf$Type underlyingType = protoBuf$TypeAlias.getUnderlyingType();
            underlyingType.getClass();
            return underlyingType;
        }
        if (protoBuf$TypeAlias.hasUnderlyingTypeId()) {
            return typeTable.get(protoBuf$TypeAlias.getUnderlyingTypeId());
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("No underlyingType in ProtoBuf.TypeAlias");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static final List<ProtoBuf$Type> upperBounds(ProtoBuf$TypeParameter protoBuf$TypeParameter, TypeTable typeTable) {
        protoBuf$TypeParameter.getClass();
        typeTable.getClass();
        List<ProtoBuf$Type> upperBoundList = protoBuf$TypeParameter.getUpperBoundList();
        boolean zIsEmpty = upperBoundList.isEmpty();
        ?? arrayList = upperBoundList;
        if (zIsEmpty) {
            arrayList = 0;
        }
        if (arrayList == 0) {
            List<Integer> upperBoundIdList = protoBuf$TypeParameter.getUpperBoundIdList();
            upperBoundIdList.getClass();
            List<Integer> list = upperBoundIdList;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Integer num : list) {
                num.getClass();
                arrayList.add(typeTable.get(num.intValue()));
            }
        }
        return arrayList;
    }

    public static final ProtoBuf$Type varargElementType(ProtoBuf$ValueParameter protoBuf$ValueParameter, TypeTable typeTable) {
        protoBuf$ValueParameter.getClass();
        typeTable.getClass();
        if (protoBuf$ValueParameter.hasVarargElementType()) {
            return protoBuf$ValueParameter.getVarargElementType();
        }
        if (protoBuf$ValueParameter.hasVarargElementTypeId()) {
            return typeTable.get(protoBuf$ValueParameter.getVarargElementTypeId());
        }
        return null;
    }

    public static final boolean hasReceiver(ProtoBuf$Property protoBuf$Property) {
        protoBuf$Property.getClass();
        return protoBuf$Property.hasReceiverType() || protoBuf$Property.hasReceiverTypeId();
    }

    public static final ProtoBuf$Type receiverType(ProtoBuf$Property protoBuf$Property, TypeTable typeTable) {
        protoBuf$Property.getClass();
        typeTable.getClass();
        if (protoBuf$Property.hasReceiverType()) {
            return protoBuf$Property.getReceiverType();
        }
        if (protoBuf$Property.hasReceiverTypeId()) {
            return typeTable.get(protoBuf$Property.getReceiverTypeId());
        }
        return null;
    }

    public static final ProtoBuf$Type returnType(ProtoBuf$Property protoBuf$Property, TypeTable typeTable) {
        protoBuf$Property.getClass();
        typeTable.getClass();
        if (protoBuf$Property.hasReturnType()) {
            ProtoBuf$Type returnType = protoBuf$Property.getReturnType();
            returnType.getClass();
            return returnType;
        }
        if (protoBuf$Property.hasReturnTypeId()) {
            return typeTable.get(protoBuf$Property.getReturnTypeId());
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("No returnType in ProtoBuf.Property");
        return null;
    }

    public static final ProtoBuf$Type type(ProtoBuf$Type.Argument argument, TypeTable typeTable) {
        argument.getClass();
        typeTable.getClass();
        if (argument.hasType()) {
            return argument.getType();
        }
        if (argument.hasTypeId()) {
            return typeTable.get(argument.getTypeId());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static final List<ProtoBuf$Type> contextReceiverTypes(ProtoBuf$Function protoBuf$Function, TypeTable typeTable) {
        protoBuf$Function.getClass();
        typeTable.getClass();
        List<ProtoBuf$Type> contextReceiverTypeList = protoBuf$Function.getContextReceiverTypeList();
        boolean zIsEmpty = contextReceiverTypeList.isEmpty();
        ?? arrayList = contextReceiverTypeList;
        if (zIsEmpty) {
            arrayList = 0;
        }
        if (arrayList == 0) {
            List<Integer> contextReceiverTypeIdList = protoBuf$Function.getContextReceiverTypeIdList();
            contextReceiverTypeIdList.getClass();
            List<Integer> list = contextReceiverTypeIdList;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Integer num : list) {
                num.getClass();
                arrayList.add(typeTable.get(num.intValue()));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static final List<ProtoBuf$Type> contextReceiverTypes(ProtoBuf$Property protoBuf$Property, TypeTable typeTable) {
        protoBuf$Property.getClass();
        typeTable.getClass();
        List<ProtoBuf$Type> contextReceiverTypeList = protoBuf$Property.getContextReceiverTypeList();
        boolean zIsEmpty = contextReceiverTypeList.isEmpty();
        ?? arrayList = contextReceiverTypeList;
        if (zIsEmpty) {
            arrayList = 0;
        }
        if (arrayList == 0) {
            List<Integer> contextReceiverTypeIdList = protoBuf$Property.getContextReceiverTypeIdList();
            contextReceiverTypeIdList.getClass();
            List<Integer> list = contextReceiverTypeIdList;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Integer num : list) {
                num.getClass();
                arrayList.add(typeTable.get(num.intValue()));
            }
        }
        return arrayList;
    }
}
