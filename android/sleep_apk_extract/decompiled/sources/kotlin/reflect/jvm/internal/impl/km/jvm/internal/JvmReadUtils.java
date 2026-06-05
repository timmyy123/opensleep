package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmLambda;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.km.jvm.KotlinClassMetadata;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmReadUtils {
    public static final JvmReadUtils INSTANCE = new JvmReadUtils();

    private JvmReadUtils() {
    }

    private final void checkMetadataVersionForRead(Metadata metadata, boolean z) {
        if (metadata.mv().length != 0) {
            throwIfNotCompatible$kotlin_metadata_jvm(new MetadataVersion(metadata.mv(), (metadata.xi() & 8) != 0), z);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.");
        }
    }

    private final boolean isLessThan14(Metadata metadata) {
        return new JvmMetadataVersion(metadata.mv()).compareTo(new JvmMetadataVersion(1, 4, 0)) < 0;
    }

    public final KmClass readKmClass$kotlin_metadata_jvm(Metadata metadata) {
        metadata.getClass();
        Pair<JvmNameResolver, ProtoBuf$Class> classDataFrom = JvmProtoBufUtil.readClassDataFrom(JvmExceptionUtilsKt.requireNotEmpty(metadata), metadata.d2());
        return ReadersKt.toKmClass$default(classDataFrom.component2(), classDataFrom.component1(), isLessThan14(metadata), null, 4, null);
    }

    public final KmLambda readKmLambda$kotlin_metadata_jvm(Metadata metadata) {
        Pair<JvmNameResolver, ProtoBuf$Function> functionDataFrom;
        metadata.getClass();
        String[] strArrD1 = metadata.d1();
        if (strArrD1.length == 0) {
            strArrD1 = null;
        }
        if (strArrD1 == null || (functionDataFrom = JvmProtoBufUtil.readFunctionDataFrom(strArrD1, metadata.d2())) == null) {
            return null;
        }
        return ReadersKt.toKmLambda(functionDataFrom.component2(), functionDataFrom.component1(), isLessThan14(metadata));
    }

    public final KmPackage readKmPackage$kotlin_metadata_jvm(Metadata metadata) {
        metadata.getClass();
        Pair<JvmNameResolver, ProtoBuf$Package> packageDataFrom = JvmProtoBufUtil.readPackageDataFrom(JvmExceptionUtilsKt.requireNotEmpty(metadata), metadata.d2());
        return ReadersKt.toKmPackage$default(packageDataFrom.component2(), packageDataFrom.component1(), isLessThan14(metadata), null, 4, null);
    }

    public final KotlinClassMetadata readMetadataImpl$kotlin_metadata_jvm(Metadata metadata, boolean z) {
        metadata.getClass();
        checkMetadataVersionForRead(metadata, z);
        try {
            int iK = metadata.k();
            return iK != 1 ? iK != 2 ? iK != 3 ? iK != 4 ? iK != 5 ? new KotlinClassMetadata.Unknown(metadata, z) : new KotlinClassMetadata.MultiFileClassPart(metadata, z) : new KotlinClassMetadata.MultiFileClassFacade(metadata, z) : new KotlinClassMetadata.SyntheticClass(metadata, z) : new KotlinClassMetadata.FileFacade(metadata, z) : new KotlinClassMetadata.Class(metadata, z);
        } catch (Throwable th) {
            if ((th instanceof IllegalArgumentException) || (th instanceof VirtualMachineError) || (th instanceof ThreadDeath)) {
                throw th;
            }
            throw new InconsistentKotlinMetadataException("Exception occurred when reading Kotlin metadata", th);
        }
    }

    public final void throwIfNotCompatible$kotlin_metadata_jvm(MetadataVersion metadataVersion, boolean z) {
        String string;
        metadataVersion.getClass();
        boolean zIsAtLeast = metadataVersion.isAtLeast(1, 1, 0);
        if (z ? zIsAtLeast : metadataVersion.isCompatibleWithCurrentCompilerVersion()) {
            return;
        }
        if (zIsAtLeast) {
            StringBuilder sb = new StringBuilder("while maximum supported version is ");
            sb.append(metadataVersion.isStrictSemantics() ? MetadataVersion.INSTANCE : MetadataVersion.INSTANCE_NEXT);
            sb.append(". To support newer versions, update the kotlin-metadata-jvm library.");
            string = sb.toString();
        } else {
            string = "while minimum supported version is 1.1.0 (Kotlin 1.0).";
        }
        Types$$ExternalSyntheticBUOutline0.m("Provided Metadata instance has version ", metadataVersion, ", ", string);
    }
}
