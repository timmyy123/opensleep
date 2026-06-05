package kotlin.reflect.jvm.internal.types;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\bH\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0001H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0001H\u0016J\u0014\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0096\u0082\u0004J\n\u0010/\u001a\u000200H\u0096\u0080\u0004J\n\u00101\u001a\u000202H\u0096\u0080\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u00020\bX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00158VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0014\u0010 \u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u000fR\u0016\u0010!\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\fR\u0014\u0010#\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u000fR\u0014\u0010$\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000fR\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000fR\u001a\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u00063"}, d2 = {"Lkotlin/reflect/jvm/internal/types/CapturedKType;", "Lkotlin/reflect/jvm/internal/types/AbstractKType;", "Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeMarker;", "lowerType", "Lkotlin/reflect/KType;", "typeConstructor", "Lkotlin/reflect/jvm/internal/types/CapturedKTypeConstructor;", "isMarkedNullable", "", "<init>", "(Lkotlin/reflect/KType;Lkotlin/reflect/jvm/internal/types/CapturedKTypeConstructor;Z)V", "getLowerType", "()Lkotlin/reflect/KType;", "getTypeConstructor", "()Lkotlin/reflect/jvm/internal/types/CapturedKTypeConstructor;", "()Z", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "annotations", "", "getAnnotations", "makeNullableAsSpecified", "nullable", "makeDefinitelyNotNullAsSpecified", "isDefinitelyNotNull", "isDefinitelyNotNullType", "abbreviation", "getAbbreviation", "isNothingType", "isSuspendFunctionType", "isRawType", "mutableCollectionClass", "Lkotlin/reflect/KClass;", "getMutableCollectionClass", "()Lkotlin/reflect/KClass;", "lowerBoundIfFlexible", "upperBoundIfFlexible", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CapturedKType extends AbstractKType implements CapturedTypeMarker {
    private final KClassifier classifier;
    private final boolean isMarkedNullable;
    private final KType lowerType;
    private final CapturedKTypeConstructor typeConstructor;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.types.CapturedKType$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0, CapturedKTypeKt.class, "javaTypeNotSupported", "javaTypeNotSupported()Ljava/lang/Void;", 1);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Void invoke() {
            CapturedKTypeKt.javaTypeNotSupported();
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturedKType(KType kType, CapturedKTypeConstructor capturedKTypeConstructor, boolean z) {
        super(AnonymousClass1.INSTANCE);
        capturedKTypeConstructor.getClass();
        this.lowerType = kType;
        this.typeConstructor = capturedKTypeConstructor;
        this.isMarkedNullable = z;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public boolean equals(Object other) {
        if (!(other instanceof CapturedKType)) {
            return false;
        }
        CapturedKType capturedKType = (CapturedKType) other;
        return Intrinsics.areEqual(this.lowerType, capturedKType.lowerType) && Intrinsics.areEqual(this.typeConstructor, capturedKType.typeConstructor) && getIsMarkedNullable() == capturedKType.getIsMarkedNullable();
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public KType getAbbreviation() {
        return null;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return this.classifier;
    }

    public final KType getLowerType() {
        return this.lowerType;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public KClass<?> getMutableCollectionClass() {
        return null;
    }

    public final CapturedKTypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public int hashCode() {
        KType kType = this.lowerType;
        int iHashCode = kType != null ? kType.hashCode() : 0;
        return Boolean.hashCode(getIsMarkedNullable()) + ((this.typeConstructor.hashCode() + (iHashCode * 31)) * 31);
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isDefinitelyNotNullType */
    public boolean getIsDefinitelyNotNullType() {
        return false;
    }

    @Override // kotlin.reflect.KType
    /* JADX INFO: renamed from: isMarkedNullable, reason: from getter */
    public boolean getIsMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isNothingType */
    public boolean getIsNothingType() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isRawType */
    public boolean getIsRawType() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isSuspendFunctionType */
    public boolean getIsSuspendFunctionType() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: lowerBoundIfFlexible */
    public AbstractKType getLowerBound() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public AbstractKType makeDefinitelyNotNullAsSpecified(boolean isDefinitelyNotNull) {
        if (!isDefinitelyNotNull) {
            return this;
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Definitely not null captured type is not supported yet: ", this);
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public AbstractKType makeNullableAsSpecified(boolean nullable) {
        return nullable == getIsMarkedNullable() ? this : new CapturedKType(this.lowerType, this.typeConstructor, nullable);
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public String toString() {
        return this.typeConstructor.toString();
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: upperBoundIfFlexible */
    public AbstractKType getUpperBound() {
        return null;
    }
}
