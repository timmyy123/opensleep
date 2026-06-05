package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.SerializationPluginMetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmProtoBufUtil {
    private static final ExtensionRegistryLite EXTENSION_REGISTRY;
    public static final JvmProtoBufUtil INSTANCE = new JvmProtoBufUtil();

    static {
        ExtensionRegistryLite extensionRegistryLiteNewInstance = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
        SerializationPluginMetadataExtensions.registerAllExtensions(extensionRegistryLiteNewInstance);
        extensionRegistryLiteNewInstance.getClass();
        EXTENSION_REGISTRY = extensionRegistryLiteNewInstance;
    }

    private JvmProtoBufUtil() {
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil jvmProtoBufUtil, ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, TypeTable typeTable, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return jvmProtoBufUtil.getJvmFieldSignature(protoBuf$Property, nameResolver, typeTable, z);
    }

    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf$Property protoBuf$Property) {
        protoBuf$Property.getClass();
        Flags.BooleanFlagField is_moved_from_interface_companion = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = protoBuf$Property.getExtension(JvmProtoBuf.flags);
        extension.getClass();
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        bool.getClass();
        return bool.booleanValue();
    }

    private final String mapTypeDefault(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver) {
        if (protoBuf$Type.hasClassName()) {
            return ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(protoBuf$Type.getClassName()));
        }
        return null;
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Class> readClassDataFrom(byte[] bArr, String[] strArr) {
        bArr.getClass();
        strArr.getClass();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr), ProtoBuf$Class.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Function> readFunctionDataFrom(String[] strArr, String[] strArr2) {
        strArr.getClass();
        strArr2.getClass();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.decodeBytes(strArr));
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr2), ProtoBuf$Function.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes delimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, EXTENSION_REGISTRY);
        delimitedFrom.getClass();
        return new JvmNameResolver(delimitedFrom, strArr);
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Package> readPackageDataFrom(byte[] bArr, String[] strArr) {
        bArr.getClass();
        strArr.getClass();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr), ProtoBuf$Package.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    public final JvmMemberSignature.Method getJvmConstructorSignature(ProtoBuf$Constructor protoBuf$Constructor, NameResolver nameResolver, TypeTable typeTable) {
        String strJoinToString$default;
        protoBuf$Constructor.getClass();
        nameResolver.getClass();
        typeTable.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Constructor, JvmProtoBuf.JvmMethodSignature> generatedExtension = JvmProtoBuf.constructorSignature;
        generatedExtension.getClass();
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Constructor, generatedExtension);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? "<init>" : nameResolver.getString(jvmMethodSignature.getName());
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Constructor.getValueParameterList();
            valueParameterList.getClass();
            List<ProtoBuf$ValueParameter> list = valueParameterList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list) {
                JvmProtoBufUtil jvmProtoBufUtil = INSTANCE;
                protoBuf$ValueParameter.getClass();
                String strMapTypeDefault = jvmProtoBufUtil.mapTypeDefault(ProtoTypeTableUtilKt.type(protoBuf$ValueParameter, typeTable), nameResolver);
                if (strMapTypeDefault == null) {
                    return null;
                }
                arrayList.add(strMapTypeDefault);
            }
            strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "", "(", ")V", null, 56);
        } else {
            strJoinToString$default = nameResolver.getString(jvmMethodSignature.getDesc());
        }
        return new JvmMemberSignature.Method(string, strJoinToString$default);
    }

    public final JvmMemberSignature.Field getJvmFieldSignature(ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, TypeTable typeTable, boolean z) {
        String strMapTypeDefault;
        protoBuf$Property.getClass();
        nameResolver.getClass();
        typeTable.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
        generatedExtension.getClass();
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Property, generatedExtension);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature field = jvmPropertySignature.hasField() ? jvmPropertySignature.getField() : null;
        if (field == null && z) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? protoBuf$Property.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            strMapTypeDefault = mapTypeDefault(ProtoTypeTableUtilKt.returnType(protoBuf$Property, typeTable), nameResolver);
            if (strMapTypeDefault == null) {
                return null;
            }
        } else {
            strMapTypeDefault = nameResolver.getString(field.getDesc());
        }
        return new JvmMemberSignature.Field(nameResolver.getString(name), strMapTypeDefault);
    }

    public final JvmMemberSignature.Method getJvmMethodSignature(ProtoBuf$Function protoBuf$Function, NameResolver nameResolver, TypeTable typeTable) {
        String strM;
        protoBuf$Function.getClass();
        nameResolver.getClass();
        typeTable.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, JvmProtoBuf.JvmMethodSignature> generatedExtension = JvmProtoBuf.methodSignature;
        generatedExtension.getClass();
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Function, generatedExtension);
        int name = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? protoBuf$Function.getName() : jvmMethodSignature.getName();
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List listListOfNotNull = CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(protoBuf$Function, typeTable));
            List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Function.getValueParameterList();
            valueParameterList.getClass();
            List<ProtoBuf$ValueParameter> list = valueParameterList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list) {
                protoBuf$ValueParameter.getClass();
                arrayList.add(ProtoTypeTableUtilKt.type(protoBuf$ValueParameter, typeTable));
            }
            List listPlus = CollectionsKt.plus((Collection) listListOfNotNull, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
            Iterator it = listPlus.iterator();
            while (it.hasNext()) {
                String strMapTypeDefault = INSTANCE.mapTypeDefault((ProtoBuf$Type) it.next(), nameResolver);
                if (strMapTypeDefault == null) {
                    return null;
                }
                arrayList2.add(strMapTypeDefault);
            }
            String strMapTypeDefault2 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(protoBuf$Function, typeTable), nameResolver);
            if (strMapTypeDefault2 == null) {
                return null;
            }
            strM = FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), CollectionsKt.joinToString$default(arrayList2, "", "(", ")", null, 56), strMapTypeDefault2);
        } else {
            strM = nameResolver.getString(jvmMethodSignature.getDesc());
        }
        return new JvmMemberSignature.Method(nameResolver.getString(name), strM);
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Class> readClassDataFrom(String[] strArr, String[] strArr2) {
        strArr.getClass();
        strArr2.getClass();
        byte[] bArrDecodeBytes = BitEncoding.decodeBytes(strArr);
        bArrDecodeBytes.getClass();
        return readClassDataFrom(bArrDecodeBytes, strArr2);
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Package> readPackageDataFrom(String[] strArr, String[] strArr2) {
        strArr.getClass();
        strArr2.getClass();
        byte[] bArrDecodeBytes = BitEncoding.decodeBytes(strArr);
        bArrDecodeBytes.getClass();
        return readPackageDataFrom(bArrDecodeBytes, strArr2);
    }
}
