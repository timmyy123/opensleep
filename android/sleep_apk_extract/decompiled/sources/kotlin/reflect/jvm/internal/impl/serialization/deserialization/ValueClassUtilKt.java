package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ValueClassUtilKt {
    public static final <T extends RigidTypeMarker> ValueClassRepresentation<T> loadValueClassRepresentation(ProtoBuf$Class protoBuf$Class, boolean z, NameResolver nameResolver, TypeTable typeTable, Function1<? super ProtoBuf$Type, ? extends T> function1, Function1<? super Name, ? extends T> function12) {
        T tInvoke;
        protoBuf$Class.getClass();
        nameResolver.getClass();
        typeTable.getClass();
        function1.getClass();
        function12.getClass();
        if (protoBuf$Class.hasInlineClassUnderlyingPropertyName()) {
            Name name = NameResolverUtilKt.getName(nameResolver, protoBuf$Class.getInlineClassUnderlyingPropertyName());
            ProtoBuf$Type protoBuf$TypeInlineClassUnderlyingType = ProtoTypeTableUtilKt.inlineClassUnderlyingType(protoBuf$Class, typeTable);
            if ((protoBuf$TypeInlineClassUnderlyingType != null && (tInvoke = function1.invoke(protoBuf$TypeInlineClassUnderlyingType)) != null) || (tInvoke = function12.invoke(name)) != null) {
                return new InlineClassRepresentation(name, tInvoke);
            }
            throw new IllegalStateException(("cannot determine underlying type for value class " + NameResolverUtilKt.getName(nameResolver, protoBuf$Class.getFqName()) + " with property " + name).toString());
        }
        if (z && Flags.IS_VALUE_CLASS.get(protoBuf$Class.getFlags()).booleanValue()) {
            List<ProtoBuf$Constructor> constructorList = protoBuf$Class.getConstructorList();
            constructorList.getClass();
            Iterator<T> it = constructorList.iterator();
            boolean z2 = false;
            Object obj = null;
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    if (!Flags.IS_SECONDARY.get(((ProtoBuf$Constructor) next).getFlags()).booleanValue()) {
                        if (z2) {
                            break;
                        }
                        z2 = true;
                        obj = next;
                    }
                } else if (!z2) {
                    break;
                }
            }
            obj = null;
            ProtoBuf$Constructor protoBuf$Constructor = (ProtoBuf$Constructor) obj;
            if (protoBuf$Constructor != null) {
                List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Constructor.getValueParameterList();
                valueParameterList.getClass();
                List<ProtoBuf$ValueParameter> list = valueParameterList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list) {
                    arrayList.add(TuplesKt.to(NameResolverUtilKt.getName(nameResolver, protoBuf$ValueParameter.getName()), function1.invoke(ProtoTypeTableUtilKt.type(protoBuf$ValueParameter, typeTable))));
                }
                return new MultiFieldValueClassRepresentation(arrayList);
            }
        }
        return null;
    }
}
