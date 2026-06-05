package kotlin.reflect.jvm.internal.impl.types;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextContextualKt;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    public static boolean RUN_SLOW_ASSERTIONS;

    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            try {
                iArr[TypeVariance.INV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypeVariance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TypeVariance.IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private AbstractTypeChecker() {
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        if (!TypeSystemContextContextualKt.isIntegerLiteralType(typeSystemContext, rigidTypeMarker) && !TypeSystemContextContextualKt.isIntegerLiteralType(typeSystemContext, rigidTypeMarker2)) {
            return null;
        }
        if (checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, rigidTypeMarker) && checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, rigidTypeMarker2)) {
            return Boolean.TRUE;
        }
        if (TypeSystemContextContextualKt.isIntegerLiteralType(typeSystemContext, rigidTypeMarker)) {
            if (checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, rigidTypeMarker, rigidTypeMarker2, false)) {
                return Boolean.TRUE;
            }
        } else if (TypeSystemContextContextualKt.isIntegerLiteralType(typeSystemContext, rigidTypeMarker2) && (checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeInIntersectionComponents(typeSystemContext, rigidTypeMarker) || checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, rigidTypeMarker2, rigidTypeMarker, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$isCapturedIntegerLiteralType(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        KotlinTypeMarker type;
        RigidTypeMarker rigidTypeMarkerUpperBoundIfFlexible;
        return (rigidTypeMarker instanceof CapturedTypeMarker) && (type = TypeSystemContextContextualKt.getType(typeSystemContext, TypeSystemContextContextualKt.projection(typeSystemContext, TypeSystemContextContextualKt.typeConstructor(typeSystemContext, (CapturedTypeMarker) rigidTypeMarker)))) != null && (rigidTypeMarkerUpperBoundIfFlexible = TypeSystemContextContextualKt.upperBoundIfFlexible(typeSystemContext, type)) != null && TypeSystemContextContextualKt.isIntegerLiteralType(typeSystemContext, rigidTypeMarkerUpperBoundIfFlexible);
    }

    private static final boolean checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeInIntersectionComponents(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        TypeConstructorMarker typeConstructorMarkerTypeConstructor = TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker);
        if (!(typeConstructorMarkerTypeConstructor instanceof IntersectionTypeConstructorMarker)) {
            return false;
        }
        Collection<KotlinTypeMarker> collectionSupertypes = TypeSystemContextContextualKt.supertypes(typeSystemContext, typeConstructorMarkerTypeConstructor);
        if ((collectionSupertypes instanceof Collection) && collectionSupertypes.isEmpty()) {
            return false;
        }
        Iterator<T> it = collectionSupertypes.iterator();
        while (it.hasNext()) {
            RigidTypeMarker rigidTypeMarkerAsRigidType = TypeSystemContextContextualKt.asRigidType(typeSystemContext, (KotlinTypeMarker) it.next());
            if (rigidTypeMarkerAsRigidType != null && TypeSystemContextContextualKt.isIntegerLiteralType(typeSystemContext, rigidTypeMarkerAsRigidType)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        return TypeSystemContextContextualKt.isIntegerLiteralType(typeSystemContext, rigidTypeMarker) || checkSubtypeForIntegerLiteralType$isCapturedIntegerLiteralType(typeSystemContext, rigidTypeMarker);
    }

    private static final boolean checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(TypeSystemContext typeSystemContext, TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2, boolean z) {
        TypeCheckerState typeCheckerState2;
        RigidTypeMarker rigidTypeMarker3;
        Collection<KotlinTypeMarker> collectionPossibleIntegerTypes = TypeSystemContextContextualKt.possibleIntegerTypes(typeSystemContext, rigidTypeMarker);
        if ((collectionPossibleIntegerTypes instanceof Collection) && collectionPossibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (KotlinTypeMarker kotlinTypeMarker : collectionPossibleIntegerTypes) {
            if (Intrinsics.areEqual(TypeSystemContextContextualKt.typeConstructor(typeSystemContext, kotlinTypeMarker), TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker2))) {
                return true;
            }
            if (z) {
                typeCheckerState2 = typeCheckerState;
                rigidTypeMarker3 = rigidTypeMarker2;
                if (isSubtypeOf$default(INSTANCE, typeCheckerState2, rigidTypeMarker3, kotlinTypeMarker, false, 8, null)) {
                    return true;
                }
            } else {
                typeCheckerState2 = typeCheckerState;
                rigidTypeMarker3 = rigidTypeMarker2;
            }
            typeCheckerState = typeCheckerState2;
            rigidTypeMarker2 = rigidTypeMarker3;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Boolean checkSubtypeForSpecialCases(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        TypeParameterMarker typeParameterForArgumentInBaseIfItEqualToTarget;
        if (TypeSystemContextContextualKt.isError(typeSystemContext, rigidTypeMarker) || TypeSystemContextContextualKt.isError(typeSystemContext, rigidTypeMarker2)) {
            if (typeCheckerState.isErrorTypeEqualsToAnything()) {
                return Boolean.TRUE;
            }
            if (!TypeSystemContextContextualKt.isMarkedNullable(typeSystemContext, rigidTypeMarker) || TypeSystemContextContextualKt.isMarkedNullable(typeSystemContext, rigidTypeMarker2)) {
                return Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(typeSystemContext, TypeSystemContextContextualKt.isError(typeSystemContext, rigidTypeMarker) ? rigidTypeMarker : TypeSystemContextContextualKt.withNullability(typeSystemContext, rigidTypeMarker, false), TypeSystemContextContextualKt.isError(typeSystemContext, rigidTypeMarker2) ? rigidTypeMarker2 : TypeSystemContextContextualKt.withNullability(typeSystemContext, rigidTypeMarker2, false)));
            }
            return Boolean.FALSE;
        }
        if (TypeSystemContextContextualKt.isStubTypeForBuilderInference(typeSystemContext, rigidTypeMarker) && TypeSystemContextContextualKt.isStubTypeForBuilderInference(typeSystemContext, rigidTypeMarker2)) {
            return Boolean.valueOf(isStubTypeSubtypeOfAnother(typeSystemContext, rigidTypeMarker, rigidTypeMarker2) || typeCheckerState.isStubTypeEqualsToAnything());
        }
        if (TypeSystemContextContextualKt.isStubType(typeSystemContext, rigidTypeMarker) || TypeSystemContextContextualKt.isStubType(typeSystemContext, rigidTypeMarker2)) {
            return Boolean.valueOf(typeCheckerState.isStubTypeEqualsToAnything());
        }
        CapturedTypeMarker capturedTypeMarkerAsCapturedTypeUnwrappingDnn = TypeSystemContextContextualKt.asCapturedTypeUnwrappingDnn(typeSystemContext, rigidTypeMarker2);
        KotlinTypeMarker kotlinTypeMarkerLowerType = capturedTypeMarkerAsCapturedTypeUnwrappingDnn != null ? TypeSystemContextContextualKt.lowerType(typeSystemContext, capturedTypeMarkerAsCapturedTypeUnwrappingDnn) : null;
        if (capturedTypeMarkerAsCapturedTypeUnwrappingDnn != null && kotlinTypeMarkerLowerType != null) {
            if (TypeSystemContextContextualKt.isMarkedNullable(typeSystemContext, rigidTypeMarker2)) {
                kotlinTypeMarkerLowerType = TypeSystemContextContextualKt.withNullability(typeSystemContext, kotlinTypeMarkerLowerType, true);
            } else if (TypeSystemContextContextualKt.isDefinitelyNotNullType(typeSystemContext, rigidTypeMarker2)) {
                kotlinTypeMarkerLowerType = TypeSystemContextContextualKt.makeDefinitelyNotNullOrNotNull(typeSystemContext, kotlinTypeMarkerLowerType);
            }
            int i = WhenMappings.$EnumSwitchMapping$1[typeCheckerState.getLowerCapturedTypePolicy(rigidTypeMarker, capturedTypeMarkerAsCapturedTypeUnwrappingDnn).ordinal()];
            if (i == 1) {
                return Boolean.valueOf(isSubtypeOf$default(this, typeCheckerState, rigidTypeMarker, kotlinTypeMarkerLowerType, false, 8, null));
            }
            if (i != 2) {
                if (i != 3) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
            } else if (isSubtypeOf$default(this, typeCheckerState, rigidTypeMarker, kotlinTypeMarkerLowerType, false, 8, null)) {
                return Boolean.TRUE;
            }
        }
        TypeConstructorMarker typeConstructorMarkerTypeConstructor = TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker2);
        if (TypeSystemContextContextualKt.isIntersection(typeSystemContext, typeConstructorMarkerTypeConstructor)) {
            TypeSystemContextContextualKt.isMarkedNullable(typeSystemContext, rigidTypeMarker2);
            Collection<KotlinTypeMarker> collectionSupertypes = TypeSystemContextContextualKt.supertypes(typeSystemContext, typeConstructorMarkerTypeConstructor);
            if ((collectionSupertypes instanceof Collection) && collectionSupertypes.isEmpty()) {
                z = true;
            } else {
                Iterator<T> it = collectionSupertypes.iterator();
                while (it.hasNext()) {
                    if (!isSubtypeOf$default(INSTANCE, typeCheckerState, rigidTypeMarker, (KotlinTypeMarker) it.next(), false, 8, null)) {
                        break;
                    }
                }
                z = true;
            }
            return Boolean.valueOf(z);
        }
        TypeConstructorMarker typeConstructorMarkerTypeConstructor2 = TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker);
        if (rigidTypeMarker instanceof CapturedTypeMarker) {
            typeParameterForArgumentInBaseIfItEqualToTarget = getTypeParameterForArgumentInBaseIfItEqualToTarget(typeSystemContext, rigidTypeMarker2, rigidTypeMarker);
            if (typeParameterForArgumentInBaseIfItEqualToTarget != null && TypeSystemContextContextualKt.hasRecursiveBounds(typeSystemContext, typeParameterForArgumentInBaseIfItEqualToTarget, TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker2))) {
                return Boolean.TRUE;
            }
        } else if (TypeSystemContextContextualKt.isIntersection(typeSystemContext, typeConstructorMarkerTypeConstructor2)) {
            Collection<KotlinTypeMarker> collectionSupertypes2 = TypeSystemContextContextualKt.supertypes(typeSystemContext, typeConstructorMarkerTypeConstructor2);
            if (!(collectionSupertypes2 instanceof Collection) || !collectionSupertypes2.isEmpty()) {
                Iterator<T> it2 = collectionSupertypes2.iterator();
                while (it2.hasNext()) {
                    if (!(((KotlinTypeMarker) it2.next()) instanceof CapturedTypeMarker)) {
                        break;
                    }
                }
                typeParameterForArgumentInBaseIfItEqualToTarget = getTypeParameterForArgumentInBaseIfItEqualToTarget(typeSystemContext, rigidTypeMarker2, rigidTypeMarker);
                if (typeParameterForArgumentInBaseIfItEqualToTarget != null) {
                    return Boolean.TRUE;
                }
            }
        }
        return null;
    }

    private final List<RigidTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeCheckerState.SupertypesPolicy supertypesPolicySubstitutionSupertypePolicy;
        List<SimpleTypeMarker> listFastCorrespondingSupertypes = TypeSystemContextContextualKt.fastCorrespondingSupertypes(typeSystemContext, rigidTypeMarker, typeConstructorMarker);
        if (listFastCorrespondingSupertypes != null) {
            return listFastCorrespondingSupertypes;
        }
        if (!TypeSystemContextContextualKt.isClassTypeConstructor(typeSystemContext, typeConstructorMarker) && TypeSystemContextContextualKt.isClassType(typeSystemContext, rigidTypeMarker)) {
            return CollectionsKt.emptyList();
        }
        if (TypeSystemContextContextualKt.isCommonFinalClassConstructor(typeSystemContext, typeConstructorMarker)) {
            if (!typeSystemContext.areEqualTypeConstructors(TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker), typeConstructorMarker)) {
                return CollectionsKt.emptyList();
            }
            RigidTypeMarker rigidTypeMarkerCaptureFromArguments = typeSystemContext.captureFromArguments(rigidTypeMarker, CaptureStatus.FOR_SUBTYPING);
            if (rigidTypeMarkerCaptureFromArguments != null) {
                rigidTypeMarker = rigidTypeMarkerCaptureFromArguments;
            }
            return CollectionsKt.listOf(rigidTypeMarker);
        }
        SmartList smartList = new SmartList();
        typeCheckerState.initialize();
        ArrayDeque<RigidTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        supertypesDeque.getClass();
        Set<RigidTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        supertypesSet.getClass();
        supertypesDeque.push(rigidTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            RigidTypeMarker rigidTypeMarkerPop = supertypesDeque.pop();
            rigidTypeMarkerPop.getClass();
            if (supertypesSet.add(rigidTypeMarkerPop)) {
                RigidTypeMarker rigidTypeMarkerCaptureFromArguments2 = typeSystemContext.captureFromArguments(rigidTypeMarkerPop, CaptureStatus.FOR_SUBTYPING);
                if (rigidTypeMarkerCaptureFromArguments2 == null) {
                    rigidTypeMarkerCaptureFromArguments2 = rigidTypeMarkerPop;
                }
                if (typeSystemContext.areEqualTypeConstructors(TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarkerCaptureFromArguments2), typeConstructorMarker)) {
                    smartList.add(rigidTypeMarkerCaptureFromArguments2);
                    supertypesPolicySubstitutionSupertypePolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                } else {
                    supertypesPolicySubstitutionSupertypePolicy = TypeSystemContextContextualKt.argumentsCount(typeSystemContext, rigidTypeMarkerCaptureFromArguments2) == 0 ? TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE : typeCheckerState.getTypeSystemContext().substitutionSupertypePolicy(rigidTypeMarkerCaptureFromArguments2);
                }
                if (Intrinsics.areEqual(supertypesPolicySubstitutionSupertypePolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    supertypesPolicySubstitutionSupertypePolicy = null;
                }
                if (supertypesPolicySubstitutionSupertypePolicy != null) {
                    TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                    Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(rigidTypeMarkerPop)).iterator();
                    while (it.hasNext()) {
                        supertypesDeque.add(supertypesPolicySubstitutionSupertypePolicy.mo2514transformType(typeCheckerState, it.next()));
                    }
                }
            }
        }
        typeCheckerState.clear();
        return smartList;
    }

    private final List<RigidTypeMarker> collectAndFilter(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return selectOnlyPureKotlinSupertypes(typeSystemContext, collectAllSupertypesWithGivenTypeConstructor(typeCheckerState, typeSystemContext, rigidTypeMarker, typeConstructorMarker));
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        KotlinTypeMarker kotlinTypeMarkerPrepareType = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker));
        KotlinTypeMarker kotlinTypeMarkerPrepareType2 = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker2));
        if (typeCheckerState.isDnnTypesEqualToFlexible() && TypeSystemContextContextualKt.isFlexible(typeSystemContext, kotlinTypeMarkerPrepareType) && TypeSystemContextContextualKt.isDefinitelyNotNullType(typeSystemContext, kotlinTypeMarkerPrepareType2)) {
            FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = TypeSystemContextContextualKt.asFlexibleType(typeSystemContext, kotlinTypeMarkerPrepareType);
            flexibleTypeMarkerAsFlexibleType.getClass();
            RigidTypeMarker rigidTypeMarkerLowerBound = TypeSystemContextContextualKt.lowerBound(typeSystemContext, flexibleTypeMarkerAsFlexibleType);
            RigidTypeMarker rigidTypeMarkerAsRigidType = TypeSystemContextContextualKt.asRigidType(typeSystemContext, kotlinTypeMarkerPrepareType2);
            rigidTypeMarkerAsRigidType.getClass();
            return completeIsSubTypeOf(typeCheckerState, typeSystemContext, rigidTypeMarkerLowerBound, TypeSystemContextContextualKt.originalIfDefinitelyNotNullable(typeSystemContext, rigidTypeMarkerAsRigidType), z);
        }
        Boolean boolCheckSubtypeForSpecialCases = checkSubtypeForSpecialCases(typeCheckerState, typeSystemContext, TypeSystemContextContextualKt.lowerBoundIfFlexible(typeSystemContext, kotlinTypeMarkerPrepareType), TypeSystemContextContextualKt.upperBoundIfFlexible(typeSystemContext, kotlinTypeMarkerPrepareType2));
        if (boolCheckSubtypeForSpecialCases == null) {
            Boolean boolAddSubtypeConstraint = typeCheckerState.addSubtypeConstraint(kotlinTypeMarkerPrepareType, kotlinTypeMarkerPrepareType2, z);
            return boolAddSubtypeConstraint != null ? boolAddSubtypeConstraint.booleanValue() : isSubtypeOfForSingleClassifierType(typeCheckerState, typeSystemContext, TypeSystemContextContextualKt.lowerBoundIfFlexible(typeSystemContext, kotlinTypeMarkerPrepareType), TypeSystemContextContextualKt.upperBoundIfFlexible(typeSystemContext, kotlinTypeMarkerPrepareType2));
        }
        boolean zBooleanValue = boolCheckSubtypeForSpecialCases.booleanValue();
        typeCheckerState.addSubtypeConstraint(kotlinTypeMarkerPrepareType, kotlinTypeMarkerPrepareType2, z);
        return zBooleanValue;
    }

    private final Collection<RigidTypeMarker> filterOutEquivalentSupertypesWithSameConstructor(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, List<? extends RigidTypeMarker> list) {
        if (list.size() > 1) {
            TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
            TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext = typeSystemContext2 instanceof TypeSystemInferenceExtensionContext ? (TypeSystemInferenceExtensionContext) typeSystemContext2 : null;
            if (typeSystemInferenceExtensionContext != null && typeSystemInferenceExtensionContext.isK2()) {
                LinkedHashSet<RigidTypeMarker> linkedHashSet = new LinkedHashSet();
                for (RigidTypeMarker rigidTypeMarker : list) {
                    RigidTypeMarker rigidTypeMarkerAsRigidType = TypeSystemContextContextualKt.asRigidType(typeSystemContext, typeCheckerState.prepareType(rigidTypeMarker));
                    if (rigidTypeMarkerAsRigidType != null) {
                        rigidTypeMarker = rigidTypeMarkerAsRigidType;
                    }
                    linkedHashSet.add(rigidTypeMarker);
                }
                if (linkedHashSet.size() == 1) {
                    return linkedHashSet;
                }
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                for (RigidTypeMarker rigidTypeMarker2 : linkedHashSet) {
                    if (linkedHashSet3.add(typeCheckerState.getKotlinTypePreparator().clearTypeFromUnnecessaryAttributes(rigidTypeMarker2))) {
                        linkedHashSet2.add(rigidTypeMarker2);
                    }
                }
                return linkedHashSet2;
            }
        }
        List<? extends RigidTypeMarker> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (RigidTypeMarker rigidTypeMarker3 : list2) {
            RigidTypeMarker rigidTypeMarkerAsRigidType2 = TypeSystemContextContextualKt.asRigidType(typeSystemContext, typeCheckerState.prepareType(rigidTypeMarker3));
            if (rigidTypeMarkerAsRigidType2 != null) {
                rigidTypeMarker3 = rigidTypeMarkerAsRigidType2;
            }
            arrayList.add(rigidTypeMarker3);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
    
        return kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextContextualKt.getParameter(r7, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextContextualKt.typeConstructor(r7, r8), r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        KotlinTypeMarker type;
        int iArgumentsCount = TypeSystemContextContextualKt.argumentsCount(typeSystemContext, kotlinTypeMarker);
        int i = 0;
        while (true) {
            if (i >= iArgumentsCount) {
                return null;
            }
            TypeArgumentMarker argument = TypeSystemContextContextualKt.getArgument(typeSystemContext, kotlinTypeMarker, i);
            TypeArgumentMarker typeArgumentMarker = TypeSystemContextContextualKt.isStarProjection(typeSystemContext, argument) ? null : argument;
            if (typeArgumentMarker != null && (type = TypeSystemContextContextualKt.getType(typeSystemContext, typeArgumentMarker)) != null) {
                boolean z = TypeSystemContextContextualKt.isCapturedType(typeSystemContext, TypeSystemContextContextualKt.lowerBoundIfFlexible(typeSystemContext, type)) && TypeSystemContextContextualKt.isCapturedType(typeSystemContext, TypeSystemContextContextualKt.lowerBoundIfFlexible(typeSystemContext, kotlinTypeMarker2));
                if (Intrinsics.areEqual(type, kotlinTypeMarker2) || (z && Intrinsics.areEqual(TypeSystemContextContextualKt.typeConstructor(typeSystemContext, type), TypeSystemContextContextualKt.typeConstructor(typeSystemContext, kotlinTypeMarker2)))) {
                    break;
                }
                TypeParameterMarker typeParameterForArgumentInBaseIfItEqualToTarget = getTypeParameterForArgumentInBaseIfItEqualToTarget(typeSystemContext, type, kotlinTypeMarker2);
                if (typeParameterForArgumentInBaseIfItEqualToTarget != null) {
                    return typeParameterForArgumentInBaseIfItEqualToTarget;
                }
            }
            i++;
        }
    }

    private final boolean hasNothingSupertype(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        TypeConstructorMarker typeConstructorMarkerTypeConstructor = TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker);
        if (TypeSystemContextContextualKt.isClassTypeConstructor(typeSystemContext, typeConstructorMarkerTypeConstructor)) {
            return TypeSystemContextContextualKt.isNothingConstructor(typeSystemContext, typeConstructorMarkerTypeConstructor);
        }
        if (TypeSystemContextContextualKt.isNothingConstructor(typeSystemContext, TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker))) {
            return true;
        }
        typeCheckerState.initialize();
        ArrayDeque<RigidTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        supertypesDeque.getClass();
        Set<RigidTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        supertypesSet.getClass();
        supertypesDeque.push(rigidTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            RigidTypeMarker rigidTypeMarkerPop = supertypesDeque.pop();
            rigidTypeMarkerPop.getClass();
            if (supertypesSet.add(rigidTypeMarkerPop)) {
                TypeCheckerState.SupertypesPolicy supertypesPolicy = TypeSystemContextContextualKt.isClassType(typeSystemContext, rigidTypeMarkerPop) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                if (Intrinsics.areEqual(supertypesPolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    supertypesPolicy = null;
                }
                if (supertypesPolicy == null) {
                    continue;
                } else {
                    TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                    Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(rigidTypeMarkerPop)).iterator();
                    while (it.hasNext()) {
                        RigidTypeMarker rigidTypeMarkerMo2514transformType = supertypesPolicy.mo2514transformType(typeCheckerState, it.next());
                        if (TypeSystemContextContextualKt.isNothingConstructor(typeSystemContext, TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarkerMo2514transformType))) {
                            typeCheckerState.clear();
                            return true;
                        }
                        supertypesDeque.add(rigidTypeMarkerMo2514transformType);
                    }
                }
            }
        }
        typeCheckerState.clear();
        return false;
    }

    private final boolean isCommonDenotableType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        return (!TypeSystemContextContextualKt.isDenotable(typeSystemContext, TypeSystemContextContextualKt.typeConstructor(typeSystemContext, kotlinTypeMarker)) || TypeSystemContextContextualKt.isDynamic(typeSystemContext, kotlinTypeMarker) || TypeSystemContextContextualKt.isDefinitelyNotNullType(typeSystemContext, kotlinTypeMarker) || TypeSystemContextContextualKt.isNotNullTypeParameter(typeSystemContext, kotlinTypeMarker) || TypeSystemContextContextualKt.isFlexibleWithDifferentTypeConstructors(typeSystemContext, kotlinTypeMarker)) ? false : true;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        if (TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker) != TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker2)) {
            return false;
        }
        if (TypeSystemContextContextualKt.isDefinitelyNotNullType(typeSystemContext, rigidTypeMarker) || !TypeSystemContextContextualKt.isDefinitelyNotNullType(typeSystemContext, rigidTypeMarker2)) {
            return !TypeSystemContextContextualKt.isMarkedNullable(typeSystemContext, rigidTypeMarker) || TypeSystemContextContextualKt.isMarkedNullable(typeSystemContext, rigidTypeMarker2);
        }
        return false;
    }

    private final boolean isSubtypeForSameConstructorWithIntersectedTypeArguments(TypeSystemContext typeSystemContext, TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2, TypeConstructorMarker typeConstructorMarker, Collection<? extends RigidTypeMarker> collection) {
        KotlinTypeMarker type;
        ArgumentList argumentList = new ArgumentList(TypeSystemContextContextualKt.parametersCount(typeSystemContext, typeConstructorMarker));
        int iParametersCount = TypeSystemContextContextualKt.parametersCount(typeSystemContext, typeConstructorMarker);
        for (int i = 0; i < iParametersCount; i++) {
            if (TypeSystemContextContextualKt.getVariance(typeSystemContext, TypeSystemContextContextualKt.getParameter(typeSystemContext, typeConstructorMarker, i)) != TypeVariance.OUT) {
                return false;
            }
            Collection<? extends RigidTypeMarker> collection2 = collection;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
            for (RigidTypeMarker rigidTypeMarker3 : collection2) {
                TypeArgumentMarker argumentOrNull = TypeSystemContextContextualKt.getArgumentOrNull(typeSystemContext, rigidTypeMarker3, i);
                if (argumentOrNull != null) {
                    if (TypeSystemContextContextualKt.getVariance(typeSystemContext, argumentOrNull) != TypeVariance.INV) {
                        argumentOrNull = null;
                    }
                    if (argumentOrNull != null && (type = TypeSystemContextContextualKt.getType(typeSystemContext, argumentOrNull)) != null) {
                        arrayList.add(type);
                    }
                }
                throw new IllegalStateException(("Incorrect type: " + rigidTypeMarker3 + ", subType: " + rigidTypeMarker + ", superType: " + rigidTypeMarker2).toString());
            }
            argumentList.add(TypeSystemContextContextualKt.asTypeArgument(typeSystemContext, typeSystemContext.intersectTypes(arrayList)));
        }
        return isSubtypeForSameConstructor(typeCheckerState, typeSystemContext, argumentList, rigidTypeMarker2);
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker abstractTypeChecker, TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return abstractTypeChecker.isSubtypeOf(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    private final boolean isSubtypeOfForSingleClassifierType(final TypeCheckerState typeCheckerState, final TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, final RigidTypeMarker rigidTypeMarker2) {
        if (RUN_SLOW_ASSERTIONS) {
            if (!TypeSystemContextContextualKt.isSingleClassifierType(typeSystemContext, rigidTypeMarker) && !TypeSystemContextContextualKt.isIntersection(typeSystemContext, TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker))) {
                typeCheckerState.isAllowedTypeVariable(rigidTypeMarker);
            }
            if (!TypeSystemContextContextualKt.isSingleClassifierType(typeSystemContext, rigidTypeMarker2)) {
                typeCheckerState.isAllowedTypeVariable(rigidTypeMarker2);
            }
        }
        if (!AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(typeCheckerState, rigidTypeMarker, rigidTypeMarker2)) {
            return false;
        }
        Boolean boolCheckSubtypeForIntegerLiteralType = checkSubtypeForIntegerLiteralType(typeCheckerState, typeSystemContext, rigidTypeMarker, rigidTypeMarker2);
        if (boolCheckSubtypeForIntegerLiteralType != null) {
            boolean zBooleanValue = boolCheckSubtypeForIntegerLiteralType.booleanValue();
            TypeCheckerState.addSubtypeConstraint$default(typeCheckerState, rigidTypeMarker, rigidTypeMarker2, false, 4, null);
            return zBooleanValue;
        }
        TypeConstructorMarker typeConstructorMarkerTypeConstructor = TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker2);
        if ((typeSystemContext.areEqualTypeConstructors(TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker), typeConstructorMarkerTypeConstructor) && TypeSystemContextContextualKt.parametersCount(typeSystemContext, typeConstructorMarkerTypeConstructor) == 0) || TypeSystemContextContextualKt.isAnyConstructor(typeSystemContext, TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker2))) {
            return true;
        }
        final Collection<RigidTypeMarker> collectionFilterOutEquivalentSupertypesWithSameConstructor = filterOutEquivalentSupertypesWithSameConstructor(typeCheckerState, typeSystemContext, findCorrespondingSupertypes(typeCheckerState, rigidTypeMarker, typeConstructorMarkerTypeConstructor));
        int size = collectionFilterOutEquivalentSupertypesWithSameConstructor.size();
        if (size == 0) {
            return hasNothingSupertype(typeCheckerState, typeSystemContext, rigidTypeMarker);
        }
        if (size == 1) {
            return isSubtypeForSameConstructor(typeCheckerState, typeSystemContext, TypeSystemContextContextualKt.asArgumentList(typeSystemContext, (RigidTypeMarker) CollectionsKt.first(collectionFilterOutEquivalentSupertypesWithSameConstructor)), rigidTypeMarker2);
        }
        if (isSubtypeForSameConstructorWithIntersectedTypeArguments(typeSystemContext, typeCheckerState, rigidTypeMarker, rigidTypeMarker2, typeConstructorMarkerTypeConstructor, collectionFilterOutEquivalentSupertypesWithSameConstructor)) {
            return true;
        }
        return typeCheckerState.runForkingPoint(new Function1(collectionFilterOutEquivalentSupertypesWithSameConstructor, typeCheckerState, typeSystemContext, rigidTypeMarker2) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$$Lambda$0
            private final Collection arg$0;
            private final TypeCheckerState arg$1;
            private final TypeSystemContext arg$2;
            private final RigidTypeMarker arg$3;

            {
                this.arg$0 = collectionFilterOutEquivalentSupertypesWithSameConstructor;
                this.arg$1 = typeCheckerState;
                this.arg$2 = typeSystemContext;
                this.arg$3 = rigidTypeMarker2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return AbstractTypeChecker.isSubtypeOfForSingleClassifierType$lambda$3(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (TypeCheckerState.ForkPointContext) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit isSubtypeOfForSingleClassifierType$lambda$3(Collection collection, final TypeCheckerState typeCheckerState, final TypeSystemContext typeSystemContext, final RigidTypeMarker rigidTypeMarker, TypeCheckerState.ForkPointContext forkPointContext) {
        forkPointContext.getClass();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            final RigidTypeMarker rigidTypeMarker2 = (RigidTypeMarker) it.next();
            forkPointContext.fork(new Function0(typeCheckerState, typeSystemContext, rigidTypeMarker2, rigidTypeMarker) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$$Lambda$1
                private final TypeCheckerState arg$0;
                private final TypeSystemContext arg$1;
                private final RigidTypeMarker arg$2;
                private final RigidTypeMarker arg$3;

                {
                    this.arg$0 = typeCheckerState;
                    this.arg$1 = typeSystemContext;
                    this.arg$2 = rigidTypeMarker2;
                    this.arg$3 = rigidTypeMarker;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return Boolean.valueOf(AbstractTypeChecker.isSubtypeOfForSingleClassifierType$lambda$3$0(this.arg$0, this.arg$1, this.arg$2, this.arg$3));
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSubtypeOfForSingleClassifierType$lambda$3$0(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        return INSTANCE.isSubtypeForSameConstructor(typeCheckerState, typeSystemContext, TypeSystemContextContextualKt.asArgumentList(typeSystemContext, rigidTypeMarker), rigidTypeMarker2);
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, TypeConstructorMarker typeConstructorMarker) {
        RigidTypeMarker rigidTypeMarkerAsRigidType = TypeSystemContextContextualKt.asRigidType(typeSystemContext, kotlinTypeMarker);
        if (rigidTypeMarkerAsRigidType instanceof CapturedTypeMarker) {
            CapturedTypeMarker capturedTypeMarker = (CapturedTypeMarker) rigidTypeMarkerAsRigidType;
            if (TypeSystemContextContextualKt.isOldCapturedType(typeSystemContext, capturedTypeMarker) || !TypeSystemContextContextualKt.isStarProjection(typeSystemContext, TypeSystemContextContextualKt.projection(typeSystemContext, TypeSystemContextContextualKt.typeConstructor(typeSystemContext, capturedTypeMarker))) || TypeSystemContextContextualKt.captureStatus(typeSystemContext, capturedTypeMarker) != CaptureStatus.FOR_SUBTYPING) {
                return false;
            }
            TypeSystemContextContextualKt.typeConstructor(typeSystemContext, kotlinTypeMarker2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<RigidTypeMarker> selectOnlyPureKotlinSupertypes(TypeSystemContext typeSystemContext, List<? extends RigidTypeMarker> list) {
        int i;
        if (list.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                TypeArgumentListMarker typeArgumentListMarkerAsArgumentList = TypeSystemContextContextualKt.asArgumentList(typeSystemContext, (RigidTypeMarker) obj);
                int size = typeSystemContext.size(typeArgumentListMarkerAsArgumentList);
                while (true) {
                    if (i >= size) {
                        arrayList.add(obj);
                        break;
                    }
                    KotlinTypeMarker type = TypeSystemContextContextualKt.getType(typeSystemContext, typeSystemContext.get(typeArgumentListMarkerAsArgumentList, i));
                    i = (type != null ? TypeSystemContextContextualKt.asFlexibleType(typeSystemContext, type) : null) == null ? i + 1 : 0;
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return list;
    }

    public final TypeVariance effectiveVariance(TypeVariance typeVariance, TypeVariance typeVariance2) {
        typeVariance.getClass();
        typeVariance2.getClass();
        TypeVariance typeVariance3 = TypeVariance.INV;
        if (typeVariance == typeVariance3) {
            return typeVariance2;
        }
        if (typeVariance2 == typeVariance3 || typeVariance == typeVariance2) {
            return typeVariance;
        }
        return null;
    }

    public final boolean equalTypes(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        typeCheckerState.getClass();
        kotlinTypeMarker.getClass();
        kotlinTypeMarker2.getClass();
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        if (abstractTypeChecker.isCommonDenotableType(typeSystemContext, kotlinTypeMarker) && abstractTypeChecker.isCommonDenotableType(typeSystemContext, kotlinTypeMarker2)) {
            KotlinTypeMarker kotlinTypeMarkerPrepareType = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker));
            KotlinTypeMarker kotlinTypeMarkerPrepareType2 = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker2));
            RigidTypeMarker rigidTypeMarkerLowerBoundIfFlexible = typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarkerPrepareType);
            if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(kotlinTypeMarkerPrepareType), typeSystemContext.typeConstructor(kotlinTypeMarkerPrepareType2))) {
                return false;
            }
            if (typeSystemContext.argumentsCount(rigidTypeMarkerLowerBoundIfFlexible) == 0) {
                return typeSystemContext.hasFlexibleNullability(kotlinTypeMarkerPrepareType) || typeSystemContext.hasFlexibleNullability(kotlinTypeMarkerPrepareType2) || typeSystemContext.isMarkedNullable(rigidTypeMarkerLowerBoundIfFlexible) == typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarkerPrepareType2));
            }
        }
        return isSubtypeOf$default(abstractTypeChecker, typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, false, 8, null) && isSubtypeOf$default(abstractTypeChecker, typeCheckerState, kotlinTypeMarker2, kotlinTypeMarker, false, 8, null);
    }

    public final List<RigidTypeMarker> findCorrespondingSupertypes(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        typeCheckerState.getClass();
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        typeConstructorMarker.getClass();
        if (TypeSystemContextContextualKt.isClassType(typeSystemContext, rigidTypeMarker)) {
            return collectAndFilter(typeCheckerState, typeSystemContext, rigidTypeMarker, typeConstructorMarker);
        }
        if (!TypeSystemContextContextualKt.isClassTypeConstructor(typeSystemContext, typeConstructorMarker) && !TypeSystemContextContextualKt.isIntegerLiteralTypeConstructor(typeSystemContext, typeConstructorMarker)) {
            return collectAllSupertypesWithGivenTypeConstructor(typeCheckerState, typeSystemContext, rigidTypeMarker, typeConstructorMarker);
        }
        SmartList<RigidTypeMarker> smartList = new SmartList();
        typeCheckerState.initialize();
        ArrayDeque<RigidTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        supertypesDeque.getClass();
        Set<RigidTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        supertypesSet.getClass();
        supertypesDeque.push(rigidTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            RigidTypeMarker rigidTypeMarkerPop = supertypesDeque.pop();
            rigidTypeMarkerPop.getClass();
            if (supertypesSet.add(rigidTypeMarkerPop)) {
                if (TypeSystemContextContextualKt.isClassType(typeSystemContext, rigidTypeMarkerPop)) {
                    smartList.add(rigidTypeMarkerPop);
                    supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                } else {
                    supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                }
                if (Intrinsics.areEqual(supertypesPolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    supertypesPolicy = null;
                }
                if (supertypesPolicy != null) {
                    TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                    Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(rigidTypeMarkerPop)).iterator();
                    while (it.hasNext()) {
                        supertypesDeque.add(supertypesPolicy.mo2514transformType(typeCheckerState, it.next()));
                    }
                }
            }
        }
        typeCheckerState.clear();
        ArrayList arrayList = new ArrayList();
        for (RigidTypeMarker rigidTypeMarker2 : smartList) {
            AbstractTypeChecker abstractTypeChecker = INSTANCE;
            rigidTypeMarker2.getClass();
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, abstractTypeChecker.collectAndFilter(typeCheckerState, typeSystemContext, rigidTypeMarker2, typeConstructorMarker));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, TypeArgumentListMarker typeArgumentListMarker, RigidTypeMarker rigidTypeMarker) {
        boolean zEqualTypes;
        TypeCheckerState typeCheckerState2 = typeCheckerState;
        typeCheckerState2.getClass();
        typeSystemContext.getClass();
        typeArgumentListMarker.getClass();
        rigidTypeMarker.getClass();
        TypeConstructorMarker typeConstructorMarkerTypeConstructor = TypeSystemContextContextualKt.typeConstructor(typeSystemContext, rigidTypeMarker);
        int size = TypeSystemContextContextualKt.size(typeSystemContext, typeArgumentListMarker);
        int iParametersCount = TypeSystemContextContextualKt.parametersCount(typeSystemContext, typeConstructorMarkerTypeConstructor);
        if (size != iParametersCount || size != TypeSystemContextContextualKt.argumentsCount(typeSystemContext, rigidTypeMarker)) {
            return false;
        }
        for (int i = 0; i < iParametersCount; i++) {
            TypeArgumentMarker argument = TypeSystemContextContextualKt.getArgument(typeSystemContext, rigidTypeMarker, i);
            KotlinTypeMarker type = TypeSystemContextContextualKt.getType(typeSystemContext, argument);
            if (type != null) {
                TypeArgumentMarker typeArgumentMarker = TypeSystemContextContextualKt.get(typeSystemContext, typeArgumentListMarker, i);
                TypeSystemContextContextualKt.getVariance(typeSystemContext, typeArgumentMarker);
                TypeVariance typeVariance = TypeVariance.INV;
                KotlinTypeMarker type2 = TypeSystemContextContextualKt.getType(typeSystemContext, typeArgumentMarker);
                type2.getClass();
                TypeVariance typeVarianceEffectiveVariance = effectiveVariance(TypeSystemContextContextualKt.getVariance(typeSystemContext, TypeSystemContextContextualKt.getParameter(typeSystemContext, typeConstructorMarkerTypeConstructor, i)), TypeSystemContextContextualKt.getVariance(typeSystemContext, argument));
                if (typeVarianceEffectiveVariance == null) {
                    return typeCheckerState2.isErrorTypeEqualsToAnything();
                }
                if (typeVarianceEffectiveVariance != typeVariance || (!isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type2, type, typeConstructorMarkerTypeConstructor) && !isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type, type2, typeConstructorMarkerTypeConstructor))) {
                    if (typeCheckerState2.argumentsDepth > 100) {
                        Utf8$$ExternalSyntheticBUOutline0.m("Arguments depth is too high. Some related argument: ", type2);
                        return false;
                    }
                    typeCheckerState2.argumentsDepth++;
                    int i2 = WhenMappings.$EnumSwitchMapping$0[typeVarianceEffectiveVariance.ordinal()];
                    if (i2 == 1) {
                        zEqualTypes = INSTANCE.equalTypes(typeCheckerState2, type2, type);
                    } else if (i2 == 2) {
                        typeCheckerState2 = typeCheckerState;
                        zEqualTypes = isSubtypeOf$default(INSTANCE, typeCheckerState2, type2, type, false, 8, null);
                    } else {
                        if (i2 != 3) {
                            Home$$ExternalSyntheticBUOutline0.m();
                            return false;
                        }
                        zEqualTypes = isSubtypeOf$default(INSTANCE, typeCheckerState2, type, type2, false, 8, null);
                        typeCheckerState2 = typeCheckerState;
                    }
                    typeCheckerState2.argumentsDepth--;
                    if (!zEqualTypes) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean isSubtypeOf(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        typeCheckerState.getClass();
        kotlinTypeMarker.getClass();
        kotlinTypeMarker2.getClass();
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (!typeCheckerState.customIsSubtypeOf(kotlinTypeMarker, kotlinTypeMarker2)) {
            return false;
        }
        return INSTANCE.completeIsSubTypeOf(typeCheckerState, typeCheckerState.getTypeSystemContext(), kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    public final boolean isSubtypeOf(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        typeCheckerState.getClass();
        kotlinTypeMarker.getClass();
        kotlinTypeMarker2.getClass();
        return isSubtypeOf$default(this, typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, false, 8, null);
    }

    public final List<RigidTypeMarker> findCorrespondingSupertypes(TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        typeCheckerState.getClass();
        rigidTypeMarker.getClass();
        typeConstructorMarker.getClass();
        return INSTANCE.findCorrespondingSupertypes(typeCheckerState, typeCheckerState.getTypeSystemContext(), rigidTypeMarker, typeConstructorMarker);
    }
}
