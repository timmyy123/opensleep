package kotlin.reflect.jvm.internal.types;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.KTypeBase;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0017\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0013H&J\n\u0010#\u001a\u0004\u0018\u00010\u0000H&J\n\u0010$\u001a\u0004\u0018\u00010\u0000H&J\u0014\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0082\u0004J\n\u0010(\u001a\u00020)H\u0096\u0080\u0004J\n\u0010*\u001a\u00020+H\u0096\u0080\u0004R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u0004\u0018\u00010\b8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001bR\u0012\u0010\u001d\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0012\u0010\u001e\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\u0018\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006,"}, d2 = {"Lkotlin/reflect/jvm/internal/types/AbstractKType;", "Lkotlin/jvm/internal/KTypeBase;", "Lkotlin/reflect/jvm/internal/impl/types/model/FlexibleTypeMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/SimpleTypeMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentListMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/DefinitelyNotNullTypeMarker;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getComputeJavaType", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "makeNullableAsSpecified", "nullable", "", "makeDefinitelyNotNullAsSpecified", "isDefinitelyNotNull", "abbreviation", "Lkotlin/reflect/KType;", "getAbbreviation", "()Lkotlin/reflect/KType;", "isDefinitelyNotNullType", "()Z", "isNothingType", "isSuspendFunctionType", "isRawType", "mutableCollectionClass", "Lkotlin/reflect/KClass;", "getMutableCollectionClass", "()Lkotlin/reflect/KClass;", "lowerBoundIfFlexible", "upperBoundIfFlexible", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractKType implements KTypeBase, DefinitelyNotNullTypeMarker, FlexibleTypeMarker, SimpleTypeMarker, TypeArgumentListMarker {
    private final ReflectProperties.LazySoftVal<Type> computeJavaType;

    public AbstractKType(Function0<? extends Type> function0) {
        ReflectProperties.LazySoftVal<Type> lazySoftValLazySoft = null;
        ReflectProperties.LazySoftVal<Type> lazySoftVal = function0 instanceof ReflectProperties.LazySoftVal ? (ReflectProperties.LazySoftVal) function0 : null;
        if (lazySoftVal != null) {
            lazySoftValLazySoft = lazySoftVal;
        } else if (function0 != null) {
            lazySoftValLazySoft = ReflectProperties.lazySoft(function0);
        }
        this.computeJavaType = lazySoftValLazySoft;
    }

    public boolean equals(Object other) {
        return (other instanceof AbstractKType) && AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(ReflectTypeSystemContext.INSTANCE, this, (KotlinTypeMarker) other);
    }

    public abstract KType getAbbreviation();

    public final ReflectProperties.LazySoftVal<Type> getComputeJavaType() {
        return this.computeJavaType;
    }

    @Override // kotlin.jvm.internal.KTypeBase
    public Type getJavaType() {
        ReflectProperties.LazySoftVal<Type> lazySoftVal = this.computeJavaType;
        if (lazySoftVal != null) {
            return lazySoftVal.invoke();
        }
        return null;
    }

    public abstract KClass<?> getMutableCollectionClass();

    public int hashCode() {
        KClassifier classifier = getClassifier();
        int iHashCode = classifier != null ? classifier.hashCode() : 0;
        return Boolean.hashCode(isMarkedNullable()) + ((getArguments().hashCode() + (iHashCode * 31)) * 31);
    }

    public abstract boolean isDefinitelyNotNullType();

    public abstract boolean isNothingType();

    /* JADX INFO: renamed from: isRawType */
    public abstract boolean getIsRawType();

    public abstract boolean isSuspendFunctionType();

    /* JADX INFO: renamed from: lowerBoundIfFlexible */
    public abstract AbstractKType getLowerBound();

    public abstract AbstractKType makeDefinitelyNotNullAsSpecified(boolean isDefinitelyNotNull);

    public abstract AbstractKType makeNullableAsSpecified(boolean nullable);

    public String toString() {
        return ReflectionObjectRenderer.renderType$default(ReflectionObjectRenderer.INSTANCE, this, false, 2, null);
    }

    /* JADX INFO: renamed from: upperBoundIfFlexible */
    public abstract AbstractKType getUpperBound();
}
