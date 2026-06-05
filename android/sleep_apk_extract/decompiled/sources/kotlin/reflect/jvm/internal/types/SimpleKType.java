package kotlin.reflect.jvm.internal.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.KTypeBase;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\tH\u0016J\u0014\u0010$\u001a\u00020\u0004*\u00020\u00042\u0006\u0010#\u001a\u00020\tH\u0002J\u0010\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\tH\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0001H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0001H\u0016R\u0015\u0010\u0003\u001a\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\b\u001a\u00020\tX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001cR\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u000e\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001cR\u0014\u0010\u000f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001cR\u0014\u0010\u0010\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001cR\u001a\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010)\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001c¨\u0006*"}, d2 = {"Lkotlin/reflect/jvm/internal/types/SimpleKType;", "Lkotlin/reflect/jvm/internal/types/AbstractKType;", "Lkotlin/jvm/internal/KTypeBase;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "annotations", "", "abbreviation", "Lkotlin/reflect/KType;", "isDefinitelyNotNullType", "isNothingType", "isSuspendFunctionType", "mutableCollectionClass", "Lkotlin/reflect/KClass;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;ZLjava/util/List;Lkotlin/reflect/KType;ZZZLkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getArguments", "()Ljava/util/List;", "()Z", "getAnnotations", "getAbbreviation", "()Lkotlin/reflect/KType;", "getMutableCollectionClass", "()Lkotlin/reflect/KClass;", "makeNullableAsSpecified", "nullable", "toWrapperClassIfNeeded", "makeDefinitelyNotNullAsSpecified", "isDefinitelyNotNull", "lowerBoundIfFlexible", "upperBoundIfFlexible", "isRawType", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SimpleKType extends AbstractKType implements KTypeBase {
    private final KType abbreviation;
    private final List<Annotation> annotations;
    private final List<KTypeProjection> arguments;
    private final KClassifier classifier;
    private final boolean isDefinitelyNotNullType;
    private final boolean isMarkedNullable;
    private final boolean isNothingType;
    private final boolean isSuspendFunctionType;
    private final KClass<?> mutableCollectionClass;

    public /* synthetic */ SimpleKType(KClassifier kClassifier, List list, boolean z, List list2, KType kType, boolean z2, boolean z3, boolean z4, KClass kClass, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClassifier, list, z, list2, kType, z2, z3, z4, kClass, (i & 512) != 0 ? null : function0);
    }

    private final KClassifier toWrapperClassIfNeeded(KClassifier kClassifier, boolean z) {
        KClass kotlinClass;
        if (!(kClassifier instanceof KClass)) {
            return kClassifier;
        }
        KClass kClass = (KClass) kClassifier;
        if (z) {
            return JvmClassMappingKt.getKotlinClass(JvmClassMappingKt.getJavaObjectType(kClass));
        }
        Class javaPrimitiveType = JvmClassMappingKt.getJavaPrimitiveType(kClass);
        return (javaPrimitiveType == null || (kotlinClass = JvmClassMappingKt.getKotlinClass(javaPrimitiveType)) == null) ? kClass : kotlinClass;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public KType getAbbreviation() {
        return this.abbreviation;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public KClass<?> getMutableCollectionClass() {
        return this.mutableCollectionClass;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isDefinitelyNotNullType, reason: from getter */
    public boolean getIsDefinitelyNotNullType() {
        return this.isDefinitelyNotNullType;
    }

    @Override // kotlin.reflect.KType
    /* JADX INFO: renamed from: isMarkedNullable, reason: from getter */
    public boolean getIsMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isNothingType, reason: from getter */
    public boolean getIsNothingType() {
        return this.isNothingType;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isRawType */
    public boolean getIsRawType() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isSuspendFunctionType, reason: from getter */
    public boolean getIsSuspendFunctionType() {
        return this.isSuspendFunctionType;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: lowerBoundIfFlexible */
    public AbstractKType getLowerBound() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public AbstractKType makeDefinitelyNotNullAsSpecified(boolean isDefinitelyNotNull) {
        return new SimpleKType(getClassifier(), getArguments(), getIsMarkedNullable() && !isDefinitelyNotNull, getAnnotations(), getAbbreviation(), isDefinitelyNotNull, getIsNothingType(), getIsSuspendFunctionType(), getMutableCollectionClass(), null, 512, null);
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public AbstractKType makeNullableAsSpecified(boolean nullable) {
        return new SimpleKType(toWrapperClassIfNeeded(getClassifier(), nullable), getArguments(), nullable, getAnnotations(), getAbbreviation(), false, getIsNothingType(), getIsSuspendFunctionType(), getMutableCollectionClass(), null, 512, null);
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: upperBoundIfFlexible */
    public AbstractKType getUpperBound() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleKType(KClassifier kClassifier, List<KTypeProjection> list, boolean z, List<? extends Annotation> list2, KType kType, boolean z2, boolean z3, boolean z4, KClass<?> kClass, Function0<? extends Type> function0) {
        super(function0);
        kClassifier.getClass();
        list.getClass();
        list2.getClass();
        this.classifier = kClassifier;
        this.arguments = list;
        this.isMarkedNullable = z;
        this.annotations = list2;
        this.abbreviation = kType;
        this.isDefinitelyNotNullType = z2;
        this.isNothingType = z3;
        this.isSuspendFunctionType = z4;
        this.mutableCollectionClass = kClass;
    }
}
