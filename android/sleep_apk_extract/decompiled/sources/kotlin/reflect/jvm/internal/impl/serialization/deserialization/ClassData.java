package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: loaded from: classes5.dex */
public final class ClassData {
    private final ProtoBuf$Class classProto;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;
    private final SourceElement sourceElement;

    public ClassData(NameResolver nameResolver, ProtoBuf$Class protoBuf$Class, BinaryVersion binaryVersion, SourceElement sourceElement) {
        nameResolver.getClass();
        protoBuf$Class.getClass();
        binaryVersion.getClass();
        sourceElement.getClass();
        this.nameResolver = nameResolver;
        this.classProto = protoBuf$Class;
        this.metadataVersion = binaryVersion;
        this.sourceElement = sourceElement;
    }

    public final NameResolver component1() {
        return this.nameResolver;
    }

    public final ProtoBuf$Class component2() {
        return this.classProto;
    }

    public final BinaryVersion component3() {
        return this.metadataVersion;
    }

    public final SourceElement component4() {
        return this.sourceElement;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassData)) {
            return false;
        }
        ClassData classData = (ClassData) obj;
        return Intrinsics.areEqual(this.nameResolver, classData.nameResolver) && Intrinsics.areEqual(this.classProto, classData.classProto) && Intrinsics.areEqual(this.metadataVersion, classData.metadataVersion) && Intrinsics.areEqual(this.sourceElement, classData.sourceElement);
    }

    public int hashCode() {
        return this.sourceElement.hashCode() + ((this.metadataVersion.hashCode() + ((this.classProto.hashCode() + (this.nameResolver.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.nameResolver + ", classProto=" + this.classProto + ", metadataVersion=" + this.metadataVersion + ", sourceElement=" + this.sourceElement + ')';
    }
}
