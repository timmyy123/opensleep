package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TypeSystemContextContextualKt {
    public static final int argumentsCount(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.argumentsCount(kotlinTypeMarker);
    }

    public static final TypeArgumentListMarker asArgumentList(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.asArgumentList(rigidTypeMarker);
    }

    public static final CapturedTypeMarker asCapturedTypeUnwrappingDnn(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.asCapturedTypeUnwrappingDnn(rigidTypeMarker);
    }

    public static final FlexibleTypeMarker asFlexibleType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.asFlexibleType(kotlinTypeMarker);
    }

    public static final RigidTypeMarker asRigidType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.asRigidType(kotlinTypeMarker);
    }

    public static final TypeArgumentMarker asTypeArgument(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.asTypeArgument(kotlinTypeMarker);
    }

    public static final CaptureStatus captureStatus(TypeSystemContext typeSystemContext, CapturedTypeMarker capturedTypeMarker) {
        typeSystemContext.getClass();
        capturedTypeMarker.getClass();
        return typeSystemContext.captureStatus(capturedTypeMarker);
    }

    public static final List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.fastCorrespondingSupertypes(rigidTypeMarker, typeConstructorMarker);
    }

    public static final TypeArgumentMarker get(TypeSystemContext typeSystemContext, TypeArgumentListMarker typeArgumentListMarker, int i) {
        typeSystemContext.getClass();
        typeArgumentListMarker.getClass();
        return typeSystemContext.get(typeArgumentListMarker, i);
    }

    public static final TypeArgumentMarker getArgument(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, int i) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.getArgument(kotlinTypeMarker, i);
    }

    public static final TypeArgumentMarker getArgumentOrNull(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, int i) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.getArgumentOrNull(rigidTypeMarker, i);
    }

    public static final TypeParameterMarker getParameter(TypeSystemContext typeSystemContext, TypeConstructorMarker typeConstructorMarker, int i) {
        typeSystemContext.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.getParameter(typeConstructorMarker, i);
    }

    public static final KotlinTypeMarker getType(TypeSystemContext typeSystemContext, TypeArgumentMarker typeArgumentMarker) {
        typeSystemContext.getClass();
        typeArgumentMarker.getClass();
        return typeSystemContext.getType(typeArgumentMarker);
    }

    public static final TypeVariance getVariance(TypeSystemContext typeSystemContext, TypeArgumentMarker typeArgumentMarker) {
        typeSystemContext.getClass();
        typeArgumentMarker.getClass();
        return typeSystemContext.getVariance(typeArgumentMarker);
    }

    public static final boolean hasRecursiveBounds(TypeSystemContext typeSystemContext, TypeParameterMarker typeParameterMarker, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        typeParameterMarker.getClass();
        return typeSystemContext.hasRecursiveBounds(typeParameterMarker, typeConstructorMarker);
    }

    public static final boolean isAnyConstructor(TypeSystemContext typeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.isAnyConstructor(typeConstructorMarker);
    }

    public static final boolean isCapturedType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.isCapturedType(kotlinTypeMarker);
    }

    public static final boolean isClassType(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.isClassType(rigidTypeMarker);
    }

    public static final boolean isClassTypeConstructor(TypeSystemContext typeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.isClassTypeConstructor(typeConstructorMarker);
    }

    public static final boolean isCommonFinalClassConstructor(TypeSystemContext typeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.isCommonFinalClassConstructor(typeConstructorMarker);
    }

    public static final boolean isDefinitelyNotNullType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.isDefinitelyNotNullType(kotlinTypeMarker);
    }

    public static final boolean isDenotable(TypeSystemContext typeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.isDenotable(typeConstructorMarker);
    }

    public static final boolean isDynamic(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.isDynamic(kotlinTypeMarker);
    }

    public static final boolean isError(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.isError(kotlinTypeMarker);
    }

    public static final boolean isFlexible(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.isFlexible(kotlinTypeMarker);
    }

    public static final boolean isFlexibleWithDifferentTypeConstructors(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.isFlexibleWithDifferentTypeConstructors(kotlinTypeMarker);
    }

    public static final boolean isIntegerLiteralType(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.isIntegerLiteralType(rigidTypeMarker);
    }

    public static final boolean isIntegerLiteralTypeConstructor(TypeSystemContext typeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.isIntegerLiteralTypeConstructor(typeConstructorMarker);
    }

    public static final boolean isIntersection(TypeSystemContext typeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.isIntersection(typeConstructorMarker);
    }

    public static final boolean isMarkedNullable(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.isMarkedNullable(kotlinTypeMarker);
    }

    public static final boolean isNotNullTypeParameter(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.isNotNullTypeParameter(kotlinTypeMarker);
    }

    public static final boolean isNothingConstructor(TypeSystemContext typeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.isNothingConstructor(typeConstructorMarker);
    }

    public static final boolean isOldCapturedType(TypeSystemContext typeSystemContext, CapturedTypeMarker capturedTypeMarker) {
        typeSystemContext.getClass();
        capturedTypeMarker.getClass();
        return typeSystemContext.isOldCapturedType(capturedTypeMarker);
    }

    public static final boolean isSingleClassifierType(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.isSingleClassifierType(rigidTypeMarker);
    }

    public static final boolean isStarProjection(TypeSystemContext typeSystemContext, TypeArgumentMarker typeArgumentMarker) {
        typeSystemContext.getClass();
        typeArgumentMarker.getClass();
        return typeSystemContext.isStarProjection(typeArgumentMarker);
    }

    public static final boolean isStubType(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.isStubType(rigidTypeMarker);
    }

    public static final boolean isStubTypeForBuilderInference(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.isStubTypeForBuilderInference(rigidTypeMarker);
    }

    public static final RigidTypeMarker lowerBound(TypeSystemContext typeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
        typeSystemContext.getClass();
        flexibleTypeMarker.getClass();
        return typeSystemContext.lowerBound(flexibleTypeMarker);
    }

    public static final RigidTypeMarker lowerBoundIfFlexible(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker);
    }

    public static final KotlinTypeMarker lowerType(TypeSystemContext typeSystemContext, CapturedTypeMarker capturedTypeMarker) {
        typeSystemContext.getClass();
        capturedTypeMarker.getClass();
        return typeSystemContext.lowerType(capturedTypeMarker);
    }

    public static final KotlinTypeMarker makeDefinitelyNotNullOrNotNull(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.makeDefinitelyNotNullOrNotNull(kotlinTypeMarker);
    }

    public static final SimpleTypeMarker originalIfDefinitelyNotNullable(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.originalIfDefinitelyNotNullable(rigidTypeMarker);
    }

    public static final int parametersCount(TypeSystemContext typeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.parametersCount(typeConstructorMarker);
    }

    public static final Collection<KotlinTypeMarker> possibleIntegerTypes(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.possibleIntegerTypes(rigidTypeMarker);
    }

    public static final TypeArgumentMarker projection(TypeSystemContext typeSystemContext, CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
        typeSystemContext.getClass();
        capturedTypeConstructorMarker.getClass();
        return typeSystemContext.projection(capturedTypeConstructorMarker);
    }

    public static final int size(TypeSystemContext typeSystemContext, TypeArgumentListMarker typeArgumentListMarker) {
        typeSystemContext.getClass();
        typeArgumentListMarker.getClass();
        return typeSystemContext.size(typeArgumentListMarker);
    }

    public static final Collection<KotlinTypeMarker> supertypes(TypeSystemContext typeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        typeSystemContext.getClass();
        typeConstructorMarker.getClass();
        return typeSystemContext.supertypes(typeConstructorMarker);
    }

    public static final TypeConstructorMarker typeConstructor(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.typeConstructor(rigidTypeMarker);
    }

    public static final RigidTypeMarker upperBoundIfFlexible(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.upperBoundIfFlexible(kotlinTypeMarker);
    }

    public static final RigidTypeMarker withNullability(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, boolean z) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.withNullability(rigidTypeMarker, z);
    }

    public static final TypeVariance getVariance(TypeSystemContext typeSystemContext, TypeParameterMarker typeParameterMarker) {
        typeSystemContext.getClass();
        typeParameterMarker.getClass();
        return typeSystemContext.getVariance(typeParameterMarker);
    }

    public static final boolean isDefinitelyNotNullType(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        typeSystemContext.getClass();
        rigidTypeMarker.getClass();
        return typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker);
    }

    public static final CapturedTypeConstructorMarker typeConstructor(TypeSystemContext typeSystemContext, CapturedTypeMarker capturedTypeMarker) {
        typeSystemContext.getClass();
        capturedTypeMarker.getClass();
        return typeSystemContext.typeConstructor(capturedTypeMarker);
    }

    public static final KotlinTypeMarker withNullability(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, boolean z) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.withNullability(kotlinTypeMarker, z);
    }

    public static final TypeConstructorMarker typeConstructor(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemContext.getClass();
        kotlinTypeMarker.getClass();
        return typeSystemContext.typeConstructor(kotlinTypeMarker);
    }
}
