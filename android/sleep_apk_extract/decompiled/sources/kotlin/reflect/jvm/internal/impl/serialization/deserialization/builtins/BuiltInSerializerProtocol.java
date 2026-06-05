package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes5.dex */
public final class BuiltInSerializerProtocol extends SerializerExtensionProtocol {
    public static final BuiltInSerializerProtocol INSTANCE = new BuiltInSerializerProtocol();

    /* JADX WARN: Illegal instructions before constructor call */
    private BuiltInSerializerProtocol() {
        ExtensionRegistryLite extensionRegistryLiteNewInstance = ExtensionRegistryLite.newInstance();
        BuiltInsProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
        extensionRegistryLiteNewInstance.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Package, Integer> generatedExtension = BuiltInsProtoBuf.packageFqName;
        generatedExtension.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> generatedExtension2 = BuiltInsProtoBuf.constructorAnnotation;
        generatedExtension2.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Class, List<ProtoBuf$Annotation>> generatedExtension3 = BuiltInsProtoBuf.classAnnotation;
        generatedExtension3.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> generatedExtension4 = BuiltInsProtoBuf.functionAnnotation;
        generatedExtension4.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension5 = BuiltInsProtoBuf.propertyAnnotation;
        generatedExtension5.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension6 = BuiltInsProtoBuf.propertyGetterAnnotation;
        generatedExtension6.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension7 = BuiltInsProtoBuf.propertySetterAnnotation;
        generatedExtension7.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> generatedExtension8 = BuiltInsProtoBuf.enumEntryAnnotation;
        generatedExtension8.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> generatedExtension9 = BuiltInsProtoBuf.compileTimeValue;
        generatedExtension9.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> generatedExtension10 = BuiltInsProtoBuf.parameterAnnotation;
        generatedExtension10.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Type, List<ProtoBuf$Annotation>> generatedExtension11 = BuiltInsProtoBuf.typeAnnotation;
        generatedExtension11.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> generatedExtension12 = BuiltInsProtoBuf.typeParameterAnnotation;
        generatedExtension12.getClass();
        super(extensionRegistryLiteNewInstance, generatedExtension, generatedExtension2, generatedExtension3, generatedExtension4, null, generatedExtension5, generatedExtension6, generatedExtension7, null, null, null, generatedExtension8, generatedExtension9, generatedExtension10, generatedExtension11, generatedExtension12);
    }

    private final String shortName(FqName fqName) {
        if (fqName.isRoot()) {
            return "default-package";
        }
        String strAsString = fqName.shortName().asString();
        strAsString.getClass();
        return strAsString;
    }

    public final String getBuiltInsFileName(FqName fqName) {
        fqName.getClass();
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), shortName(fqName), ".kotlin_builtins");
    }

    public final String getBuiltInsFilePath(FqName fqName) {
        fqName.getClass();
        return StringsKt__StringsJVMKt.replace$default(fqName.asString(), '.', '/', false, 4, (Object) null) + '/' + getBuiltInsFileName(fqName);
    }
}
