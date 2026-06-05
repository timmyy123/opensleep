package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinaryClassAnnotationLoader<A, S extends AnnotationsContainer<? extends A>> implements AnnotationLoader<A> {
    public static final Companion Companion = new Companion(null);
    private final KotlinClassFinder kotlinClassFinder;

    public static abstract class AnnotationsContainer<A> {
        public abstract Map<MemberSignature, List<A>> getMemberAnnotations();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00db  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer protoContainer, boolean z, boolean z2, Boolean bool, boolean z3, KotlinClassFinder kotlinClassFinder, MetadataVersion metadataVersion) {
            ProtoContainer.Class outerClass;
            protoContainer.getClass();
            kotlinClassFinder.getClass();
            metadataVersion.getClass();
            if (z) {
                if (bool == null) {
                    throw new IllegalStateException(("isConst should not be null for property (container=" + protoContainer + ')').toString());
                }
                if (protoContainer instanceof ProtoContainer.Class) {
                    ProtoContainer.Class r4 = (ProtoContainer.Class) protoContainer;
                    if (r4.getKind() == ProtoBuf$Class.Kind.INTERFACE) {
                        ClassId classId = r4.getClassId();
                        Name nameIdentifier = Name.identifier("DefaultImpls");
                        nameIdentifier.getClass();
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, classId.createNestedClassId(nameIdentifier), metadataVersion);
                    }
                }
                if (bool.booleanValue() && (protoContainer instanceof ProtoContainer.Package)) {
                    SourceElement source = protoContainer.getSource();
                    JvmPackagePartSource jvmPackagePartSource = source instanceof JvmPackagePartSource ? (JvmPackagePartSource) source : null;
                    JvmClassName facadeClassName = jvmPackagePartSource != null ? jvmPackagePartSource.getFacadeClassName() : null;
                    if (facadeClassName != null) {
                        ClassId.Companion companion = ClassId.Companion;
                        String internalName = facadeClassName.getInternalName();
                        internalName.getClass();
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, companion.topLevel(new FqName(StringsKt__StringsJVMKt.replace$default(internalName, '/', '.', false, 4, (Object) null))), metadataVersion);
                    }
                }
            }
            if (z2 && (protoContainer instanceof ProtoContainer.Class)) {
                ProtoContainer.Class r42 = (ProtoContainer.Class) protoContainer;
                if (r42.getKind() == ProtoBuf$Class.Kind.COMPANION_OBJECT && (outerClass = r42.getOuterClass()) != null && (outerClass.getKind() == ProtoBuf$Class.Kind.CLASS || outerClass.getKind() == ProtoBuf$Class.Kind.ENUM_CLASS || (z3 && (outerClass.getKind() == ProtoBuf$Class.Kind.INTERFACE || outerClass.getKind() == ProtoBuf$Class.Kind.ANNOTATION_CLASS)))) {
                    SourceElement source2 = outerClass.getSource();
                    KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = source2 instanceof KotlinJvmBinarySourceElement ? (KotlinJvmBinarySourceElement) source2 : null;
                    if (kotlinJvmBinarySourceElement != null) {
                        return kotlinJvmBinarySourceElement.getBinaryClass();
                    }
                }
            } else if ((protoContainer instanceof ProtoContainer.Package) && (protoContainer.getSource() instanceof JvmPackagePartSource)) {
                SourceElement source3 = protoContainer.getSource();
                source3.getClass();
                JvmPackagePartSource jvmPackagePartSource2 = (JvmPackagePartSource) source3;
                KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource2.getKnownJvmBinaryClass();
                return knownJvmBinaryClass == null ? KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, jvmPackagePartSource2.getClassId(), metadataVersion) : knownJvmBinaryClass;
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class PropertyRelatedElement {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PropertyRelatedElement[] $VALUES;
        public static final PropertyRelatedElement PROPERTY = new PropertyRelatedElement("PROPERTY", 0);
        public static final PropertyRelatedElement BACKING_FIELD = new PropertyRelatedElement("BACKING_FIELD", 1);
        public static final PropertyRelatedElement DELEGATE_FIELD = new PropertyRelatedElement("DELEGATE_FIELD", 2);

        private static final /* synthetic */ PropertyRelatedElement[] $values() {
            return new PropertyRelatedElement[]{PROPERTY, BACKING_FIELD, DELEGATE_FIELD};
        }

        static {
            PropertyRelatedElement[] propertyRelatedElementArr$values = $values();
            $VALUES = propertyRelatedElementArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(propertyRelatedElementArr$values);
        }

        private PropertyRelatedElement(String str, int i) {
        }

        public static PropertyRelatedElement valueOf(String str) {
            return (PropertyRelatedElement) Enum.valueOf(PropertyRelatedElement.class, str);
        }

        public static PropertyRelatedElement[] values() {
            return (PropertyRelatedElement[]) $VALUES.clone();
        }
    }

    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            try {
                iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AbstractBinaryClassAnnotationLoader(KotlinClassFinder kotlinClassFinder) {
        kotlinClassFinder.getClass();
        this.kotlinClassFinder = kotlinClassFinder;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int computeJvmParameterIndexShift(ProtoContainer protoContainer, MessageLite messageLite) {
        int contextParameterCount = getContextParameterCount(messageLite);
        int i = 0;
        if (messageLite instanceof ProtoBuf$Function) {
            if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf$Function) messageLite)) {
                i = 1;
            }
        } else if (messageLite instanceof ProtoBuf$Property) {
            if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf$Property) messageLite)) {
            }
        } else {
            if (!(messageLite instanceof ProtoBuf$Constructor)) {
                throw new UnsupportedOperationException("Unsupported message: " + messageLite.getClass());
            }
            protoContainer.getClass();
            ProtoContainer.Class r4 = (ProtoContainer.Class) protoContainer;
            if (r4.getKind() == ProtoBuf$Class.Kind.ENUM_CLASS) {
                i = 2;
            } else if (r4.isInner()) {
            }
        }
        return contextParameterCount + i;
    }

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool, boolean z3) {
        KotlinJvmBinaryClass kotlinJvmBinaryClassFindClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(protoContainer, Companion.getSpecialCaseContainerClass(protoContainer, z, z2, bool, z3, this.kotlinClassFinder, getMetadataVersion()));
        if (kotlinJvmBinaryClassFindClassWithAnnotationsAndInitializers == null) {
            return CollectionsKt.emptyList();
        }
        List<A> list = getAnnotationsContainer(kotlinJvmBinaryClassFindClassWithAnnotationsAndInitializers).getMemberAnnotations().get(memberSignature);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool, boolean z3, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
            return null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        if ((i & 16) != 0) {
            bool = null;
        }
        if ((i & 32) != 0) {
            z3 = false;
        }
        return abstractBinaryClassAnnotationLoader.findClassAndLoadMemberAnnotations(protoContainer, memberSignature, z, z2, bool, z3);
    }

    private final int getCallableAnnotationFlags(MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        if (messageLite instanceof ProtoBuf$Constructor) {
            return ((ProtoBuf$Constructor) messageLite).getFlags();
        }
        if (messageLite instanceof ProtoBuf$Function) {
            return ((ProtoBuf$Function) messageLite).getFlags();
        }
        if (messageLite instanceof ProtoBuf$Property) {
            return getPropertyFlags((ProtoBuf$Property) messageLite, annotatedCallableKind);
        }
        return 0;
    }

    public static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: getCallableSignature");
            return null;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return abstractBinaryClassAnnotationLoader.getCallableSignature(messageLite, nameResolver, typeTable, annotatedCallableKind, z);
    }

    private final int getContextParameterCount(MessageLite messageLite) {
        if (messageLite instanceof ProtoBuf$Function) {
            return ((ProtoBuf$Function) messageLite).getContextParameterCount();
        }
        if (messageLite instanceof ProtoBuf$Property) {
            return ((ProtoBuf$Property) messageLite).getContextParameterCount();
        }
        return 0;
    }

    private final int getPropertyFlags(ProtoBuf$Property protoBuf$Property, AnnotatedCallableKind annotatedCallableKind) {
        int i = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
        return i != 1 ? i != 2 ? protoBuf$Property.getFlags() : protoBuf$Property.hasSetterFlags() ? protoBuf$Property.getSetterFlags() : protoBuf$Property.getFlags() : protoBuf$Property.hasGetterFlags() ? protoBuf$Property.getGetterFlags() : protoBuf$Property.getFlags();
    }

    private final List<A> loadAnnotationsIfPresentInBytecode(int i, Function0<? extends List<? extends A>> function0) {
        return noAnnotationsInBytecode(i) ? CollectionsKt.emptyList() : function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<A> loadParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i) {
        MemberSignature callableSignature$default = getCallableSignature$default(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        return callableSignature$default == null ? CollectionsKt.emptyList() : findClassAndLoadMemberAnnotations$default(this, protoContainer, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, i), false, false, null, false, 60, null);
    }

    private final List<A> loadPropertyAnnotations(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property, PropertyRelatedElement propertyRelatedElement) {
        Boolean bool = Flags.IS_CONST.get(protoBuf$Property.getFlags());
        bool.getClass();
        boolean zIsMovedFromInterfaceCompanion = JvmProtoBufUtil.isMovedFromInterfaceCompanion(protoBuf$Property);
        if (propertyRelatedElement == PropertyRelatedElement.PROPERTY) {
            MemberSignature propertySignature$default = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(protoBuf$Property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), false, true, false, 40, null);
            return propertySignature$default == null ? CollectionsKt.emptyList() : findClassAndLoadMemberAnnotations$default(this, protoContainer, propertySignature$default, true, false, bool, zIsMovedFromInterfaceCompanion, 8, null);
        }
        MemberSignature propertySignature$default2 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(protoBuf$Property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), true, false, false, 48, null);
        if (propertySignature$default2 == null) {
            return CollectionsKt.emptyList();
        }
        return StringsKt.contains$default(propertySignature$default2.getSignature(), "$delegate") != (propertyRelatedElement == PropertyRelatedElement.DELEGATE_FIELD) ? CollectionsKt.emptyList() : findClassAndLoadMemberAnnotations(protoContainer, propertySignature$default2, true, true, bool, zIsMovedFromInterfaceCompanion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List loadPropertyBackingFieldAnnotations$lambda$0(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property) {
        return abstractBinaryClassAnnotationLoader.loadPropertyAnnotations(protoContainer, protoBuf$Property, PropertyRelatedElement.BACKING_FIELD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List loadPropertyDelegateFieldAnnotations$lambda$0(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property) {
        return abstractBinaryClassAnnotationLoader.loadPropertyAnnotations(protoContainer, protoBuf$Property, PropertyRelatedElement.DELEGATE_FIELD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List loadValueParameterAnnotations$lambda$0(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i) {
        return abstractBinaryClassAnnotationLoader.loadParameterAnnotations(protoContainer, messageLite, annotatedCallableKind, i + abstractBinaryClassAnnotationLoader.computeJvmParameterIndexShift(protoContainer, messageLite));
    }

    private final boolean noAnnotationsInBytecode(int i) {
        return !Flags.HAS_ANNOTATIONS.get(i).booleanValue();
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class r2) {
        SourceElement source = r2.getSource();
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = source instanceof KotlinJvmBinarySourceElement ? (KotlinJvmBinarySourceElement) source : null;
        if (kotlinJvmBinarySourceElement != null) {
            return kotlinJvmBinarySourceElement.getBinaryClass();
        }
        return null;
    }

    public final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(ProtoContainer protoContainer, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        protoContainer.getClass();
        if (kotlinJvmBinaryClass != null) {
            return kotlinJvmBinaryClass;
        }
        if (protoContainer instanceof ProtoContainer.Class) {
            return toBinaryClass((ProtoContainer.Class) protoContainer);
        }
        return null;
    }

    public abstract S getAnnotationsContainer(KotlinJvmBinaryClass kotlinJvmBinaryClass);

    public byte[] getCachedFileContent(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        kotlinJvmBinaryClass.getClass();
        return null;
    }

    public final MemberSignature getCallableSignature(MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z) {
        messageLite.getClass();
        nameResolver.getClass();
        typeTable.getClass();
        annotatedCallableKind.getClass();
        if (messageLite instanceof ProtoBuf$Constructor) {
            MemberSignature.Companion companion = MemberSignature.Companion;
            JvmMemberSignature.Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf$Constructor) messageLite, nameResolver, typeTable);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return companion.fromJvmMemberSignature(jvmConstructorSignature);
        }
        if (messageLite instanceof ProtoBuf$Function) {
            MemberSignature.Companion companion2 = MemberSignature.Companion;
            JvmMemberSignature.Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf$Function) messageLite, nameResolver, typeTable);
            if (jvmMethodSignature == null) {
                return null;
            }
            return companion2.fromJvmMemberSignature(jvmMethodSignature);
        }
        if (messageLite instanceof ProtoBuf$Property) {
            GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
            generatedExtension.getClass();
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) messageLite, generatedExtension);
            if (jvmPropertySignature == null) {
                return null;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return AbstractBinaryClassAnnotationLoaderKt.getPropertySignature((ProtoBuf$Property) messageLite, nameResolver, typeTable, true, true, z);
                }
                if (!jvmPropertySignature.hasSetter()) {
                    return null;
                }
                MemberSignature.Companion companion3 = MemberSignature.Companion;
                JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
                setter.getClass();
                return companion3.fromMethod(nameResolver, setter);
            }
            if (jvmPropertySignature.hasGetter()) {
                MemberSignature.Companion companion4 = MemberSignature.Companion;
                JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                getter.getClass();
                return companion4.fromMethod(nameResolver, getter);
            }
        }
        return null;
    }

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    public abstract MetadataVersion getMetadataVersion();

    public final boolean isImplicitRepeatableContainer(ClassId classId) {
        KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass;
        classId.getClass();
        return classId.getOuterClassId() != null && Intrinsics.areEqual(classId.getShortClassName().asString(), "Container") && (kotlinJvmBinaryClassFindKotlinClass = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, classId, getMetadataVersion())) != null && SpecialJvmAnnotations.INSTANCE.isAnnotatedWithContainerMetaAnnotation(kotlinJvmBinaryClassFindKotlinClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public abstract A loadAnnotation(ProtoBuf$Annotation protoBuf$Annotation, NameResolver nameResolver);

    public abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(ClassId classId, SourceElement sourceElement, List<A> list);

    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(ClassId classId, SourceElement sourceElement, List<A> list) {
        classId.getClass();
        sourceElement.getClass();
        list.getClass();
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(classId)) {
            return null;
        }
        return loadAnnotation(classId, sourceElement, list);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        protoContainer.getClass();
        messageLite.getClass();
        annotatedCallableKind.getClass();
        if (noAnnotationsInBytecode(getCallableAnnotationFlags(messageLite, annotatedCallableKind))) {
            return CollectionsKt.emptyList();
        }
        if (annotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
            return loadPropertyAnnotations(protoContainer, (ProtoBuf$Property) messageLite, PropertyRelatedElement.PROPERTY);
        }
        MemberSignature callableSignature$default = getCallableSignature$default(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        return callableSignature$default == null ? CollectionsKt.emptyList() : findClassAndLoadMemberAnnotations$default(this, protoContainer, callableSignature$default, false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class r3) {
        r3.getClass();
        if (noAnnotationsInBytecode(r3.getClassProto().getFlags())) {
            return CollectionsKt.emptyList();
        }
        KotlinJvmBinaryClass binaryClass = toBinaryClass(r3);
        if (binaryClass == null) {
            FacebookSdk$$ExternalSyntheticLambda1.m$2("Class for loading annotations is not found: ", r3.debugFqName());
            return null;
        }
        final ArrayList arrayList = new ArrayList(1);
        binaryClass.loadClassAnnotations(new KotlinJvmBinaryClass.AnnotationVisitor(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.loadClassAnnotations.1
            final /* synthetic */ AbstractBinaryClassAnnotationLoader<A, S> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
                classId.getClass();
                sourceElement.getClass();
                return this.this$0.loadAnnotationIfNotSpecial(classId, sourceElement, arrayList);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public void visitEnd() {
            }
        }, getCachedFileContent(binaryClass));
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadContextParameterAnnotations(final ProtoContainer protoContainer, final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind, final int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        protoContainer.getClass();
        messageLite.getClass();
        annotatedCallableKind.getClass();
        return loadAnnotationsIfPresentInBytecode(protoBuf$ValueParameter != null ? protoBuf$ValueParameter.getFlags() : 0, new Function0(this, protoContainer, messageLite, annotatedCallableKind, i) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader$$Lambda$3
            private final AbstractBinaryClassAnnotationLoader arg$0;
            private final ProtoContainer arg$1;
            private final MessageLite arg$2;
            private final AnnotatedCallableKind arg$3;
            private final int arg$4;

            {
                this.arg$0 = this;
                this.arg$1 = protoContainer;
                this.arg$2 = messageLite;
                this.arg$3 = annotatedCallableKind;
                this.arg$4 = i;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.arg$0.loadParameterAnnotations(this.arg$1, this.arg$2, this.arg$3, this.arg$4);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer protoContainer, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        protoContainer.getClass();
        protoBuf$EnumEntry.getClass();
        return findClassAndLoadMemberAnnotations$default(this, protoContainer, MemberSignature.Companion.fromFieldNameAndDesc(protoContainer.getNameResolver().getString(protoBuf$EnumEntry.getName()), ClassMapperLite.mapClass(((ProtoContainer.Class) protoContainer).getClassId().asString())), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        protoContainer.getClass();
        messageLite.getClass();
        annotatedCallableKind.getClass();
        return loadParameterAnnotations(protoContainer, messageLite, annotatedCallableKind, getContextParameterCount(messageLite));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyBackingFieldAnnotations(final ProtoContainer protoContainer, final ProtoBuf$Property protoBuf$Property) {
        protoContainer.getClass();
        protoBuf$Property.getClass();
        return loadAnnotationsIfPresentInBytecode(protoBuf$Property.getFlags(), new Function0(this, protoContainer, protoBuf$Property) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader$$Lambda$0
            private final AbstractBinaryClassAnnotationLoader arg$0;
            private final ProtoContainer arg$1;
            private final ProtoBuf$Property arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = protoContainer;
                this.arg$2 = protoBuf$Property;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return AbstractBinaryClassAnnotationLoader.loadPropertyBackingFieldAnnotations$lambda$0(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyDelegateFieldAnnotations(final ProtoContainer protoContainer, final ProtoBuf$Property protoBuf$Property) {
        protoContainer.getClass();
        protoBuf$Property.getClass();
        return loadAnnotationsIfPresentInBytecode(protoBuf$Property.getFlags(), new Function0(this, protoContainer, protoBuf$Property) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader$$Lambda$1
            private final AbstractBinaryClassAnnotationLoader arg$0;
            private final ProtoContainer arg$1;
            private final ProtoBuf$Property arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = protoContainer;
                this.arg$2 = protoBuf$Property;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return AbstractBinaryClassAnnotationLoader.loadPropertyDelegateFieldAnnotations$lambda$0(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeAnnotations(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver) {
        protoBuf$Type.getClass();
        nameResolver.getClass();
        List<ProtoBuf$Annotation> annotationList = protoBuf$Type.getAnnotationList();
        annotationList.getClass();
        List<ProtoBuf$Annotation> list = annotationList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            protoBuf$Annotation.getClass();
            arrayList.add(loadAnnotation(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf$TypeParameter protoBuf$TypeParameter, NameResolver nameResolver) {
        protoBuf$TypeParameter.getClass();
        nameResolver.getClass();
        List<ProtoBuf$Annotation> annotationList = protoBuf$TypeParameter.getAnnotationList();
        annotationList.getClass();
        List<ProtoBuf$Annotation> list = annotationList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            protoBuf$Annotation.getClass();
            arrayList.add(loadAnnotation(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadValueParameterAnnotations(final ProtoContainer protoContainer, final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind, final int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        protoContainer.getClass();
        messageLite.getClass();
        annotatedCallableKind.getClass();
        protoBuf$ValueParameter.getClass();
        return loadAnnotationsIfPresentInBytecode(protoBuf$ValueParameter.getFlags(), new Function0(this, protoContainer, messageLite, annotatedCallableKind, i) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader$$Lambda$2
            private final AbstractBinaryClassAnnotationLoader arg$0;
            private final ProtoContainer arg$1;
            private final MessageLite arg$2;
            private final AnnotatedCallableKind arg$3;
            private final int arg$4;

            {
                this.arg$0 = this;
                this.arg$1 = protoContainer;
                this.arg$2 = messageLite;
                this.arg$3 = annotatedCallableKind;
                this.arg$4 = i;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return AbstractBinaryClassAnnotationLoader.loadValueParameterAnnotations$lambda$0(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4);
            }
        });
    }
}
