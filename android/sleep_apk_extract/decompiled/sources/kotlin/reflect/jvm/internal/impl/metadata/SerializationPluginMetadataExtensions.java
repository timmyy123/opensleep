package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SerializationPluginMetadataExtensions {
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Class, List<Integer>> propertiesNamesInProgramOrder = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Class.getDefaultInstance(), null, null, 18000, WireFormat.FieldType.INT32, false, Integer.class);

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(propertiesNamesInProgramOrder);
    }
}
