package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ProtoContainer {
    private final NameResolver nameResolver;
    private final SourceElement source;
    private final TypeTable typeTable;

    public static final class Class extends ProtoContainer {
        private final ClassId classId;
        private final ProtoBuf$Class classProto;
        private final boolean isData;
        private final boolean isInner;
        private final ProtoBuf$Class.Kind kind;
        private final Class outerClass;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Class(ProtoBuf$Class protoBuf$Class, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, Class r6) {
            super(nameResolver, typeTable, sourceElement, null);
            protoBuf$Class.getClass();
            nameResolver.getClass();
            typeTable.getClass();
            this.classProto = protoBuf$Class;
            this.outerClass = r6;
            this.classId = NameResolverUtilKt.getClassId(nameResolver, protoBuf$Class.getFqName());
            ProtoBuf$Class.Kind kind = Flags.CLASS_KIND.get(protoBuf$Class.getFlags());
            this.kind = kind == null ? ProtoBuf$Class.Kind.CLASS : kind;
            Boolean bool = Flags.IS_INNER.get(protoBuf$Class.getFlags());
            bool.getClass();
            this.isInner = bool.booleanValue();
            Boolean bool2 = Flags.IS_DATA.get(protoBuf$Class.getFlags());
            bool2.getClass();
            this.isData = bool2.booleanValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            return this.classId.asSingleFqName();
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public final ProtoBuf$Class getClassProto() {
            return this.classProto;
        }

        public final ProtoBuf$Class.Kind getKind() {
            return this.kind;
        }

        public final Class getOuterClass() {
            return this.outerClass;
        }

        public final boolean isInner() {
            return this.isInner;
        }
    }

    public static final class Package extends ProtoContainer {
        private final FqName fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Package(FqName fqName, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
            super(nameResolver, typeTable, sourceElement, null);
            fqName.getClass();
            nameResolver.getClass();
            typeTable.getClass();
            this.fqName = fqName;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            return this.fqName;
        }
    }

    private ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.source = sourceElement;
    }

    public abstract FqName debugFqName();

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final SourceElement getSource() {
        return this.source;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + debugFqName();
    }

    public /* synthetic */ ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(nameResolver, typeTable, sourceElement);
    }
}
