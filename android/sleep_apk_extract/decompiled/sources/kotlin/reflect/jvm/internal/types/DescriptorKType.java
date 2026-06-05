package kotlin.reflect.jvm.internal.types;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.ConvertFromMetadataKt;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KTypeAliasImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImplKt;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.SystemPropertiesKt;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u000bJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001e\u0010\u001b\u001a\u00020\u0017*\u00020\u001c2\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\bH\u0016J\n\u00102\u001a\u0004\u0018\u00010\u0001H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u0001H\u0016J\u0014\u00104\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u000106H\u0096\u0082\u0004J\n\u00107\u001a\u000208H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0084\n¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0084\n¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001d\u001a\u00020\b8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00168VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0016\u0010&\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001eR\u0014\u0010+\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u001eR\u001a\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001eR\u0014\u00101\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001e¨\u00069"}, d2 = {"Lkotlin/reflect/jvm/internal/types/DescriptorKType;", "Lkotlin/reflect/jvm/internal/types/AbstractKType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "isAbbreviation", "", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;Z)V", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "convert", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "arguments$delegate", "toKTypeProjection", "Lkotlin/reflect/jvm/internal/impl/types/TypeProjection;", "isMarkedNullable", "()Z", "annotations", "", "getAnnotations", "makeNullableAsSpecified", "nullable", "makeDefinitelyNotNullAsSpecified", "isDefinitelyNotNull", "abbreviation", "Lkotlin/reflect/KType;", "getAbbreviation", "()Lkotlin/reflect/KType;", "isDefinitelyNotNullType", "isNothingType", "mutableCollectionClass", "Lkotlin/reflect/KClass;", "getMutableCollectionClass", "()Lkotlin/reflect/KClass;", "isSuspendFunctionType", "isRawType", "lowerBoundIfFlexible", "upperBoundIfFlexible", "equals", "other", "", "hashCode", "", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DescriptorKType extends AbstractKType {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new PropertyReference1Impl(DescriptorKType.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0), new PropertyReference1Impl(DescriptorKType.class, "arguments", "getArguments()Ljava/util/List;", 0)};

    /* JADX INFO: renamed from: arguments$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal arguments;

    /* JADX INFO: renamed from: classifier$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal classifier;
    private final boolean isAbbreviation;
    private final KotlinType type;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorKType(KotlinType kotlinType, final Function0<? extends Type> function0, boolean z) {
        super(function0);
        kotlinType.getClass();
        this.type = kotlinType;
        this.isAbbreviation = z;
        this.classifier = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.types.DescriptorKType$$Lambda$0
            private final DescriptorKType arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKType.classifier_delegate$lambda$0(this.arg$0);
            }
        });
        this.arguments = ReflectProperties.lazySoft(new Function0(this, function0) { // from class: kotlin.reflect.jvm.internal.types.DescriptorKType$$Lambda$1
            private final DescriptorKType arg$0;
            private final Function0 arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = function0;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKType.arguments_delegate$lambda$0(this.arg$0, this.arg$1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _get_mutableCollectionClass_$lambda$0(ClassDescriptor classDescriptor, MutableCollectionKClass mutableCollectionKClass) {
        mutableCollectionKClass.getClass();
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        declaredTypeParameters.getClass();
        List<TypeParameterDescriptor> list = declaredTypeParameters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            typeParameterDescriptor.getClass();
            arrayList.add(new KTypeParameterImpl(mutableCollectionKClass, typeParameterDescriptor, (KTypeSubstitutor) null, 4, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final List _get_mutableCollectionClass_$lambda$1(ClassDescriptor classDescriptor, MutableCollectionKClass mutableCollectionKClass) {
        mutableCollectionKClass.getClass();
        Collection<KotlinType> collectionMo2511getSupertypes = classDescriptor.getTypeConstructor().mo2511getSupertypes();
        collectionMo2511getSupertypes.getClass();
        Collection<KotlinType> collection = collectionMo2511getSupertypes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new DescriptorKType((KotlinType) it.next(), null, 2, 0 == true ? 1 : 0));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List arguments_delegate$lambda$0(final DescriptorKType descriptorKType, Function0 function0) {
        List<TypeProjection> arguments = descriptorKType.type.getArguments();
        if (arguments.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<TypeProjection> list = arguments;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(descriptorKType.toKTypeProjection((TypeProjection) obj, function0 == null ? null : ConvertFromMetadataKt.convertTypeArgumentToJavaType(new Function0(descriptorKType) { // from class: kotlin.reflect.jvm.internal.types.DescriptorKType$$Lambda$4
                private final DescriptorKType arg$0;

                {
                    this.arg$0 = descriptorKType;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return DescriptorKType.arguments_delegate$lambda$0$0$0(this.arg$0);
                }
            }, i)));
            i = i2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractKType arguments_delegate$lambda$0$0$0(DescriptorKType descriptorKType) {
        return descriptorKType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassifier classifier_delegate$lambda$0(DescriptorKType descriptorKType) {
        return descriptorKType.convert(descriptorKType.type);
    }

    private final KClassifier convert(KotlinType type) {
        KotlinType type2;
        if (this.isAbbreviation) {
            ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = type.getConstructor().mo2510getDeclarationDescriptor();
            NotFoundClasses.MockClassDescriptor mockClassDescriptor = classifierDescriptorMo2510getDeclarationDescriptor instanceof NotFoundClasses.MockClassDescriptor ? (NotFoundClasses.MockClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor : null;
            if (mockClassDescriptor != null) {
                return new KTypeAliasImpl(DescriptorUtilsKt.getFqNameSafe(mockClassDescriptor));
            }
        }
        ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor2 = type.getConstructor().mo2510getDeclarationDescriptor();
        if (!(classifierDescriptorMo2510getDeclarationDescriptor2 instanceof ClassDescriptor)) {
            if (!(classifierDescriptorMo2510getDeclarationDescriptor2 instanceof TypeParameterDescriptor)) {
                return null;
            }
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) classifierDescriptorMo2510getDeclarationDescriptor2;
            return new KTypeParameterImpl(KTypeParameterImplKt.toContainer(typeParameterDescriptor), typeParameterDescriptor, (KTypeSubstitutor) null, 4, (DefaultConstructorMarker) null);
        }
        Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor2);
        if (javaClass == null) {
            return null;
        }
        if (!KotlinBuiltIns.isArray(type)) {
            if (TypeUtils.isNullableType(type)) {
                return new KClassImpl(javaClass);
            }
            Class<?> primitiveByWrapper = ReflectClassUtilKt.getPrimitiveByWrapper(javaClass);
            if (primitiveByWrapper != null) {
                javaClass = primitiveByWrapper;
            }
            return new KClassImpl(javaClass);
        }
        TypeProjection typeProjection = (TypeProjection) CollectionsKt.singleOrNull((List) type.getArguments());
        if (typeProjection == null || (type2 = typeProjection.getType()) == null) {
            return new KClassImpl(javaClass);
        }
        KClassifier kClassifierConvert = convert(TypeUtilsKt.makeNullable(type2));
        if (kClassifierConvert != null) {
            return new KClassImpl(UtilKt.createArrayType(JvmClassMappingKt.getJavaObjectType(KTypesJvm.getJvmErasure(kClassifierConvert))));
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Cannot determine classifier for array element type: ", this);
        return null;
    }

    private final KTypeProjection toKTypeProjection(TypeProjection typeProjection, Function0<? extends Type> function0) {
        if (typeProjection.isStarProjection()) {
            return KTypeProjection.INSTANCE.getSTAR();
        }
        KotlinType type = typeProjection.getType();
        type.getClass();
        DescriptorKType descriptorKType = new DescriptorKType(type, function0);
        int i = WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()];
        if (i == 1) {
            return KTypeProjection.INSTANCE.invariant(descriptorKType);
        }
        if (i == 2) {
            return KTypeProjection.INSTANCE.contravariant(descriptorKType);
        }
        if (i == 3) {
            return KTypeProjection.INSTANCE.covariant(descriptorKType);
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public boolean equals(Object other) {
        if (!SystemPropertiesKt.getUseK1Implementation()) {
            return super.equals(other);
        }
        if (!(other instanceof DescriptorKType)) {
            return false;
        }
        DescriptorKType descriptorKType = (DescriptorKType) other;
        return Intrinsics.areEqual(this.type, descriptorKType.type) && Intrinsics.areEqual(getClassifier(), descriptorKType.getClassifier()) && Intrinsics.areEqual(getArguments(), descriptorKType.getArguments());
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public KType getAbbreviation() {
        SimpleType abbreviation = SpecialTypesKt.getAbbreviation(this.type);
        if (abbreviation != null) {
            return new DescriptorKType(abbreviation, getComputeJavaType(), true);
        }
        return null;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return UtilKt.computeAnnotations(this.type);
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        T value = this.arguments.getValue(this, $$delegatedProperties[1]);
        value.getClass();
        return (List) value;
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return (KClassifier) this.classifier.getValue(this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public KClass<?> getMutableCollectionClass() {
        ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = this.type.getConstructor().mo2510getDeclarationDescriptor();
        final ClassDescriptor classDescriptor = classifierDescriptorMo2510getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor : null;
        if (classDescriptor == null || !JavaToKotlinClassMapper.INSTANCE.isMutable(classDescriptor)) {
            return null;
        }
        if (SystemPropertiesKt.getUseK1Implementation()) {
            KClassifier classifier = getClassifier();
            classifier.getClass();
            return new MutableCollectionKClass((KClass) classifier, DescriptorUtilsKt.getFqNameSafe(classDescriptor).asString(), new Function1(classDescriptor) { // from class: kotlin.reflect.jvm.internal.types.DescriptorKType$$Lambda$2
                private final ClassDescriptor arg$0;

                {
                    this.arg$0 = classDescriptor;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return DescriptorKType._get_mutableCollectionClass_$lambda$0(this.arg$0, (MutableCollectionKClass) obj);
                }
            }, new Function1(classDescriptor) { // from class: kotlin.reflect.jvm.internal.types.DescriptorKType$$Lambda$3
                private final ClassDescriptor arg$0;

                {
                    this.arg$0 = classDescriptor;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return DescriptorKType._get_mutableCollectionClass_$lambda$1(this.arg$0, (MutableCollectionKClass) obj);
                }
            });
        }
        FqName fqNameSafe = DescriptorUtilsKt.getFqNameSafe(classDescriptor);
        KClassifier classifier2 = getClassifier();
        classifier2.getClass();
        return MutableCollectionKClassKt.getMutableCollectionKClass(fqNameSafe, (KClass) classifier2);
    }

    public final KotlinType getType() {
        return this.type;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public int hashCode() {
        if (!SystemPropertiesKt.getUseK1Implementation()) {
            return super.hashCode();
        }
        int iHashCode = this.type.hashCode() * 31;
        KClassifier classifier = getClassifier();
        return getArguments().hashCode() + ((iHashCode + (classifier != null ? classifier.hashCode() : 0)) * 31);
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isDefinitelyNotNullType */
    public boolean getIsDefinitelyNotNullType() {
        return SpecialTypesKt.isDefinitelyNotNullType(this.type);
    }

    @Override // kotlin.reflect.KType
    /* JADX INFO: renamed from: isMarkedNullable */
    public boolean getIsMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isNothingType */
    public boolean getIsNothingType() {
        return KotlinBuiltIns.isNothingOrNullableNothing(this.type);
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isRawType */
    public boolean getIsRawType() {
        return this.type instanceof RawType;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isSuspendFunctionType */
    public boolean getIsSuspendFunctionType() {
        return FunctionTypesKt.isSuspendFunctionType(this.type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: lowerBoundIfFlexible */
    public AbstractKType getLowerBound() {
        UnwrappedType unwrappedTypeUnwrap = this.type.unwrap();
        Function0 function0 = null;
        Object[] objArr = 0;
        if (unwrappedTypeUnwrap instanceof FlexibleType) {
            return new DescriptorKType(((FlexibleType) unwrappedTypeUnwrap).getLowerBound(), function0, 2, objArr == true ? 1 : 0);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public AbstractKType makeDefinitelyNotNullAsSpecified(boolean isDefinitelyNotNull) {
        SimpleType original;
        Function0 function0 = null;
        Object[] objArr = 0;
        if (isDefinitelyNotNull) {
            original = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, this.type.unwrap(), true, false, 4, null);
            if (original == null) {
                return this;
            }
        } else {
            KotlinType kotlinType = this.type;
            DefinitelyNotNullType definitelyNotNullType = kotlinType instanceof DefinitelyNotNullType ? (DefinitelyNotNullType) kotlinType : null;
            if (definitelyNotNullType == null || (original = definitelyNotNullType.getOriginal()) == null) {
                return this;
            }
        }
        return new DescriptorKType(original, function0, 2, objArr == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public AbstractKType makeNullableAsSpecified(boolean nullable) {
        if (!FlexibleTypesKt.isFlexible(this.type) && getIsMarkedNullable() == nullable) {
            return this;
        }
        KotlinType kotlinTypeMakeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(this.type, nullable);
        kotlinTypeMakeNullableAsSpecified.getClass();
        return new DescriptorKType(kotlinTypeMakeNullableAsSpecified, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: upperBoundIfFlexible */
    public AbstractKType getUpperBound() {
        UnwrappedType unwrappedTypeUnwrap = this.type.unwrap();
        Function0 function0 = null;
        Object[] objArr = 0;
        if (unwrappedTypeUnwrap instanceof FlexibleType) {
            return new DescriptorKType(((FlexibleType) unwrappedTypeUnwrap).getUpperBound(), function0, 2, objArr == true ? 1 : 0);
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DescriptorKType(KotlinType kotlinType, Function0<? extends Type> function0) {
        this(kotlinType, function0, false);
        kotlinType.getClass();
    }

    public /* synthetic */ DescriptorKType(KotlinType kotlinType, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinType, (i & 2) != 0 ? null : function0);
    }
}
