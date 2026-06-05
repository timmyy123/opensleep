package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmPackagePartSource implements DeserializedContainerSource {
    private final DeserializedContainerAbiStability abiStability;
    private final JvmClassName className;
    private final JvmClassName facadeClassName;
    private final IncompatibleVersionErrorData<MetadataVersion> incompatibility;
    private final JvmClassName jvmClassName;
    private final KotlinJvmBinaryClass knownJvmBinaryClass;
    private final String moduleName;
    private final PreReleaseInfo preReleaseInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    public JvmPackagePartSource(KotlinJvmBinaryClass kotlinJvmBinaryClass, ProtoBuf$Package protoBuf$Package, NameResolver nameResolver, IncompatibleVersionErrorData<MetadataVersion> incompatibleVersionErrorData, boolean z, DeserializedContainerAbiStability deserializedContainerAbiStability) {
        JvmClassName jvmClassNameByInternalName;
        kotlinJvmBinaryClass.getClass();
        protoBuf$Package.getClass();
        nameResolver.getClass();
        deserializedContainerAbiStability.getClass();
        JvmClassName jvmClassNameByClassId = JvmClassName.byClassId(kotlinJvmBinaryClass.getClassId());
        jvmClassNameByClassId.getClass();
        String multifileClassName = kotlinJvmBinaryClass.getClassHeader().getMultifileClassName();
        if (multifileClassName != null) {
            jvmClassNameByInternalName = multifileClassName.length() > 0 ? JvmClassName.byInternalName(multifileClassName) : null;
        } else {
            jvmClassNameByInternalName = null;
        }
        this(jvmClassNameByClassId, jvmClassNameByInternalName, null, protoBuf$Package, nameResolver, incompatibleVersionErrorData, new PreReleaseInfo(z, null, 2, null), deserializedContainerAbiStability, kotlinJvmBinaryClass);
    }

    public final ClassId getClassId() {
        FqName packageFqName = getClassName().getPackageFqName();
        packageFqName.getClass();
        return new ClassId(packageFqName, getSimpleName());
    }

    public JvmClassName getClassName() {
        return this.className;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        sourceFile.getClass();
        return sourceFile;
    }

    public JvmClassName getFacadeClassName() {
        return this.facadeClassName;
    }

    public final KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.knownJvmBinaryClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public String getPresentableString() {
        return "Class '" + getClassId().asSingleFqName().asString() + '\'';
    }

    public final Name getSimpleName() {
        String internalName = getClassName().getInternalName();
        internalName.getClass();
        Name nameIdentifier = Name.identifier(StringsKt__StringsKt.substringAfterLast$default(internalName, '/', (String) null, 2, (Object) null));
        nameIdentifier.getClass();
        return nameIdentifier;
    }

    public String toString() {
        return "JvmPackagePartSource: " + getClassName();
    }

    public JvmPackagePartSource(JvmClassName jvmClassName, JvmClassName jvmClassName2, JvmClassName jvmClassName3, ProtoBuf$Package protoBuf$Package, NameResolver nameResolver, IncompatibleVersionErrorData<MetadataVersion> incompatibleVersionErrorData, PreReleaseInfo preReleaseInfo, DeserializedContainerAbiStability deserializedContainerAbiStability, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String string;
        jvmClassName.getClass();
        protoBuf$Package.getClass();
        nameResolver.getClass();
        preReleaseInfo.getClass();
        deserializedContainerAbiStability.getClass();
        this.className = jvmClassName;
        this.facadeClassName = jvmClassName2;
        this.jvmClassName = jvmClassName3;
        this.incompatibility = incompatibleVersionErrorData;
        this.preReleaseInfo = preReleaseInfo;
        this.abiStability = deserializedContainerAbiStability;
        this.knownJvmBinaryClass = kotlinJvmBinaryClass;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Package, Integer> generatedExtension = JvmProtoBuf.packageModuleName;
        generatedExtension.getClass();
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Package, generatedExtension);
        this.moduleName = (num == null || (string = nameResolver.getString(num.intValue())) == null) ? "main" : string;
    }
}
