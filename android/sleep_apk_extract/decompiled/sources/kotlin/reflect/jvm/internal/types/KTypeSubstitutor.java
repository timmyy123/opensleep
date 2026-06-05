package kotlin.reflect.jvm.internal.types;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000J\u0014\u0010\u000f\u001a\u00020\n*\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\f\u0010\u0010\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010\u0011\u001a\u00020\u0005*\u00020\u0005H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor;", "", "substitution", "", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/KTypeProjection;", "<init>", "(Ljava/util/Map;)V", "substitute", "type", "Lkotlin/reflect/KType;", "variance", "Lkotlin/reflect/KVariance;", "combinedWith", "other", "withNullabilityOf", "lowerBoundIfFlexible", "upperBoundIfFlexible", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KTypeSubstitutor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KTypeSubstitutor EMPTY = new KTypeSubstitutor(MapsKt.emptyMap());
    private final Map<KTypeParameter, KTypeProjection> substitution;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ(\u0010\b\u001a\u00020\u00052\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor;", "getEMPTY", "()Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor;", "create", "type", "Lkotlin/reflect/KType;", "klass", "Lkotlin/reflect/KClass;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isSuspendFunctionType", "", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KTypeSubstitutor create(KType type) {
            type.getClass();
            ReflectTypeSystemContext reflectTypeSystemContext = ReflectTypeSystemContext.INSTANCE;
            TypeConstructorMarker typeConstructorMarkerTypeConstructor = reflectTypeSystemContext.typeConstructor((RigidTypeMarker) type);
            int iParametersCount = reflectTypeSystemContext.parametersCount(typeConstructorMarkerTypeConstructor);
            ArrayList arrayList = new ArrayList(iParametersCount);
            for (int i = 0; i < iParametersCount; i++) {
                TypeParameterMarker parameter = reflectTypeSystemContext.getParameter(typeConstructorMarkerTypeConstructor, i);
                parameter.getClass();
                arrayList.add((KTypeParameter) parameter);
            }
            return !arrayList.isEmpty() ? new KTypeSubstitutor(MapsKt.toMap(CollectionsKt.zip(arrayList, type.getArguments()))) : getEMPTY();
        }

        public final KTypeSubstitutor getEMPTY() {
            return KTypeSubstitutor.EMPTY;
        }

        private Companion() {
        }

        public final KTypeSubstitutor create(KClass<?> klass, List<KTypeProjection> arguments, boolean isSuspendFunctionType) {
            klass.getClass();
            arguments.getClass();
            List<KTypeParameter> listAllTypeParameters = CapturedKTypeKt.allTypeParameters(klass);
            if (isSuspendFunctionType) {
                listAllTypeParameters = CollectionsKt.drop(listAllTypeParameters, 1);
            }
            return new KTypeSubstitutor(MapsKt.toMap(CollectionsKt.zip(listAllTypeParameters, arguments)));
        }
    }

    public KTypeSubstitutor(Map<KTypeParameter, KTypeProjection> map) {
        map.getClass();
        this.substitution = map;
    }

    private final KTypeProjection lowerBoundIfFlexible(KTypeProjection kTypeProjection) {
        AbstractKType lowerBound;
        KType type = kTypeProjection.getType();
        AbstractKType abstractKType = type instanceof AbstractKType ? (AbstractKType) type : null;
        return (abstractKType == null || (lowerBound = abstractKType.getLowerBound()) == null) ? kTypeProjection : new KTypeProjection(kTypeProjection.getVariance(), lowerBound);
    }

    public static /* synthetic */ KTypeProjection substitute$default(KTypeSubstitutor kTypeSubstitutor, KType kType, KVariance kVariance, int i, Object obj) {
        if ((i & 2) != 0) {
            kVariance = KVariance.INVARIANT;
        }
        return kTypeSubstitutor.substitute(kType, kVariance);
    }

    private final KTypeProjection upperBoundIfFlexible(KTypeProjection kTypeProjection) {
        AbstractKType upperBound;
        KType type = kTypeProjection.getType();
        AbstractKType abstractKType = type instanceof AbstractKType ? (AbstractKType) type : null;
        return (abstractKType == null || (upperBound = abstractKType.getUpperBound()) == null) ? kTypeProjection : new KTypeProjection(kTypeProjection.getVariance(), upperBound);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final KType withNullabilityOf(KType kType, KType kType2) {
        kType.getClass();
        RigidTypeMarker rigidTypeMarker = (RigidTypeMarker) kType;
        boolean z = false;
        RigidTypeMarker rigidTypeMarkerWithNullability = ReflectTypeSystemContext.INSTANCE.withNullability(rigidTypeMarker, kType2.isMarkedNullable() || kType.isMarkedNullable());
        if (rigidTypeMarkerWithNullability instanceof AbstractKType) {
            AbstractKType abstractKType = (AbstractKType) rigidTypeMarkerWithNullability;
            AbstractKType abstractKType2 = kType2 instanceof AbstractKType ? (AbstractKType) kType2 : null;
            if (abstractKType2 == null || !abstractKType2.isDefinitelyNotNullType()) {
                AbstractKType abstractKType3 = rigidTypeMarker instanceof AbstractKType ? (AbstractKType) rigidTypeMarker : null;
                if (abstractKType3 != null && abstractKType3.isDefinitelyNotNullType() && !kType2.isMarkedNullable()) {
                    z = true;
                }
                rigidTypeMarkerWithNullability = abstractKType.makeDefinitelyNotNullAsSpecified(z);
            }
        }
        rigidTypeMarkerWithNullability.getClass();
        return (KType) rigidTypeMarkerWithNullability;
    }

    public final KTypeSubstitutor combinedWith(KTypeSubstitutor other) {
        other.getClass();
        if (this.substitution.isEmpty()) {
            return other;
        }
        if (other.substitution.isEmpty()) {
            return this;
        }
        Map<KTypeParameter, KTypeProjection> map = this.substitution;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            KTypeProjection kTypeProjectionSubstitute = (KTypeProjection) entry.getValue();
            KType type = kTypeProjectionSubstitute.getType();
            KVariance variance = kTypeProjectionSubstitute.getVariance();
            if (type != null && variance != null) {
                kTypeProjectionSubstitute = other.substitute(type, variance);
            }
            linkedHashMap.put(key, kTypeProjectionSubstitute);
        }
        return new KTypeSubstitutor(linkedHashMap);
    }

    public final KTypeProjection substitute(KType type, KVariance variance) {
        type.getClass();
        variance.getClass();
        if (this.substitution.isEmpty()) {
            return new KTypeProjection(variance, type);
        }
        boolean z = type instanceof AbstractKType;
        AbstractKType abstractKType = z ? (AbstractKType) type : null;
        AbstractKType lowerBound = abstractKType != null ? abstractKType.getLowerBound() : null;
        AbstractKType abstractKType2 = z ? (AbstractKType) type : null;
        AbstractKType upperBound = abstractKType2 != null ? abstractKType2.getUpperBound() : null;
        if (lowerBound != null && upperBound != null) {
            KTypeProjection kTypeProjectionLowerBoundIfFlexible = lowerBoundIfFlexible(substitute(lowerBound, variance));
            KType type2 = upperBoundIfFlexible(substitute(upperBound, variance)).getType();
            KType type3 = kTypeProjectionLowerBoundIfFlexible.getType();
            return (type2 == null || type3 == null) ? KTypeProjection.INSTANCE.getSTAR() : new KTypeProjection(kTypeProjectionLowerBoundIfFlexible.getVariance(), TypeOfImplKt.createPlatformKType(type3, type2));
        }
        KClassifier classifier = type.getClassifier();
        if (classifier == null) {
            return new KTypeProjection(variance, type);
        }
        KTypeProjection kTypeProjection = this.substitution.get(classifier);
        if (kTypeProjection != null) {
            KType type4 = kTypeProjection.getType();
            KVariance variance2 = kTypeProjection.getVariance();
            return (type4 == null || variance2 == null) ? kTypeProjection : new KTypeProjection(KTypeSubstitutorKt.intersectWith(variance2, variance), withNullabilityOf(type4, type));
        }
        if (!type.getArguments().isEmpty()) {
            List<KTypeProjection> arguments = type.getArguments();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
            for (KTypeProjection kTypeProjection2 : arguments) {
                KVariance variance3 = kTypeProjection2.getVariance();
                KType type5 = kTypeProjection2.getType();
                arrayList.add((type5 == null || variance3 == null) ? KTypeProjection.INSTANCE.getSTAR() : substitute(type5, variance3));
            }
            boolean zIsMarkedNullable = type.isMarkedNullable();
            List<Annotation> annotations = type.getAnnotations();
            AbstractKType abstractKType3 = z ? (AbstractKType) type : null;
            type = KClassifiers.createTypeImpl(classifier, arrayList, zIsMarkedNullable, annotations, abstractKType3 != null ? abstractKType3.getMutableCollectionClass() : null);
        }
        return new KTypeProjection(variance, type);
    }
}
