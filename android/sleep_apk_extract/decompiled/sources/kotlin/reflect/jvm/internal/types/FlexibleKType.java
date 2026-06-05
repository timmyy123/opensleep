package kotlin.reflect.jvm.internal.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0005H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0001H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0001H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0018\u001a\u00020\u00058VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000eR\u0014\u0010\u001e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000eR\u0014\u0010\u001f\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001b\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00148VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b,\u0010\u0017¨\u0006."}, d2 = {"Lkotlin/reflect/jvm/internal/types/FlexibleKType;", "Lkotlin/reflect/jvm/internal/types/AbstractKType;", "lowerBound", "upperBound", "isRawType", "", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "<init>", "(Lkotlin/reflect/jvm/internal/types/AbstractKType;Lkotlin/reflect/jvm/internal/types/AbstractKType;ZLkotlin/jvm/functions/Function0;)V", "getLowerBound", "()Lkotlin/reflect/jvm/internal/types/AbstractKType;", "getUpperBound", "()Z", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "isMarkedNullable", "abbreviation", "Lkotlin/reflect/KType;", "getAbbreviation", "()Lkotlin/reflect/KType;", "isDefinitelyNotNullType", "isNothingType", "isSuspendFunctionType", "mutableCollectionClass", "Lkotlin/reflect/KClass;", "getMutableCollectionClass", "()Lkotlin/reflect/KClass;", "makeNullableAsSpecified", "nullable", "makeDefinitelyNotNullAsSpecified", "isDefinitelyNotNull", "lowerBoundIfFlexible", "upperBoundIfFlexible", "annotations", "", "getAnnotations", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FlexibleKType extends AbstractKType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isRawType;
    private final AbstractKType lowerBound;
    private final AbstractKType upperBound;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/types/FlexibleKType$Companion;", "", "<init>", "()V", "create", "Lkotlin/reflect/jvm/internal/types/AbstractKType;", "lowerBound", "upperBound", "isRawType", "", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AbstractKType create$default(Companion companion, AbstractKType abstractKType, AbstractKType abstractKType2, boolean z, Function0 function0, int i, Object obj) {
            if ((i & 8) != 0) {
                function0 = null;
            }
            return companion.create(abstractKType, abstractKType2, z, function0);
        }

        public final AbstractKType create(AbstractKType lowerBound, AbstractKType upperBound, boolean isRawType, Function0<? extends Type> computeJavaType) {
            lowerBound.getClass();
            upperBound.getClass();
            return Intrinsics.areEqual(lowerBound, upperBound) ? lowerBound : new FlexibleKType(lowerBound, upperBound, isRawType, computeJavaType, null);
        }

        private Companion() {
        }
    }

    private FlexibleKType(AbstractKType abstractKType, AbstractKType abstractKType2, boolean z, Function0<? extends Type> function0) {
        super(function0);
        this.lowerBound = abstractKType;
        this.upperBound = abstractKType2;
        this.isRawType = z;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public KType getAbbreviation() {
        return null;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return this.lowerBound.getAnnotations();
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        return this.lowerBound.getArguments();
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return this.lowerBound.getClassifier();
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public KClass<?> getMutableCollectionClass() {
        return this.lowerBound.getMutableCollectionClass();
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public boolean isDefinitelyNotNullType() {
        return false;
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.lowerBound.isMarkedNullable();
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public boolean isNothingType() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: isRawType, reason: from getter */
    public boolean getIsRawType() {
        return this.isRawType;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public boolean isSuspendFunctionType() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: lowerBoundIfFlexible, reason: from getter */
    public AbstractKType getLowerBound() {
        return this.lowerBound;
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public AbstractKType makeDefinitelyNotNullAsSpecified(boolean isDefinitelyNotNull) {
        return Companion.create$default(INSTANCE, this.lowerBound.makeDefinitelyNotNullAsSpecified(isDefinitelyNotNull), this.upperBound.makeDefinitelyNotNullAsSpecified(isDefinitelyNotNull), getIsRawType(), null, 8, null);
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    public AbstractKType makeNullableAsSpecified(boolean nullable) {
        return Companion.create$default(INSTANCE, this.lowerBound.makeNullableAsSpecified(nullable), this.upperBound.makeNullableAsSpecified(nullable), getIsRawType(), null, 8, null);
    }

    @Override // kotlin.reflect.jvm.internal.types.AbstractKType
    /* JADX INFO: renamed from: upperBoundIfFlexible, reason: from getter */
    public AbstractKType getUpperBound() {
        return this.upperBound;
    }

    public /* synthetic */ FlexibleKType(AbstractKType abstractKType, AbstractKType abstractKType2, boolean z, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(abstractKType, abstractKType2, z, function0);
    }
}
