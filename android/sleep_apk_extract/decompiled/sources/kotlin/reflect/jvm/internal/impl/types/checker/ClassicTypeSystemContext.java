package kotlin.reflect.jvm.internal.impl.types.checker;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSubstitutorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextKt;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import twitter4j.TwitterImpl$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes5.dex */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext {
    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    CapturedTypeMarker asCapturedType(SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker asRigidType(KotlinTypeMarker kotlinTypeMarker);

    KotlinTypeMarker createFlexibleType(RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2);

    KotlinBuiltIns getBuiltIns();

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isSingleClassifierType(RigidTypeMarker rigidTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isStarProjection(TypeArgumentMarker typeArgumentMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker lowerBound(FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    TypeConstructorMarker typeConstructor(RigidTypeMarker rigidTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker upperBound(FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker withNullability(RigidTypeMarker rigidTypeMarker, boolean z);

    public static final class DefaultImpls {
        public static boolean areEqualTypeConstructors(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2) {
            typeConstructorMarker.getClass();
            typeConstructorMarker2.getClass();
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
                return false;
            }
            if (typeConstructorMarker2 instanceof TypeConstructor) {
                return Intrinsics.areEqual(typeConstructorMarker, typeConstructorMarker2);
            }
            Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker2, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker2.getClass()));
            return false;
        }

        public static int argumentsCount(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments().size();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return 0;
        }

        public static SimpleTypeMarker arrayType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                SimpleType arrayType = classicTypeSystemContext.getBuiltIns().getArrayType(Variance.INVARIANT, (KotlinType) kotlinTypeMarker);
                arrayType.getClass();
                return arrayType;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(classicTypeSystemContext);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass()));
            return null;
        }

        public static TypeArgumentListMarker asArgumentList(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker) {
            rigidTypeMarker.getClass();
            if (rigidTypeMarker instanceof SimpleType) {
                return (TypeArgumentListMarker) rigidTypeMarker;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(rigidTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
            return null;
        }

        public static CapturedTypeMarker asCapturedType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            simpleTypeMarker.getClass();
            if (!(simpleTypeMarker instanceof SimpleType)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(simpleTypeMarker);
                Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
                return null;
            }
            if (simpleTypeMarker instanceof SimpleTypeWithEnhancement) {
                return classicTypeSystemContext.asCapturedType(((SimpleTypeWithEnhancement) simpleTypeMarker).getOrigin());
            }
            if (simpleTypeMarker instanceof NewCapturedType) {
                return (NewCapturedType) simpleTypeMarker;
            }
            return null;
        }

        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker) {
            rigidTypeMarker.getClass();
            if (rigidTypeMarker instanceof SimpleType) {
                if (rigidTypeMarker instanceof DefinitelyNotNullType) {
                    return (DefinitelyNotNullType) rigidTypeMarker;
                }
                return null;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(rigidTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
            return null;
        }

        public static DynamicTypeMarker asDynamicType(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
            flexibleTypeMarker.getClass();
            if (flexibleTypeMarker instanceof FlexibleType) {
                return null;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(flexibleTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass()));
            return null;
        }

        public static FlexibleTypeMarker asFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                UnwrappedType unwrappedTypeUnwrap = ((KotlinType) kotlinTypeMarker).unwrap();
                if (unwrappedTypeUnwrap instanceof FlexibleType) {
                    return (FlexibleType) unwrappedTypeUnwrap;
                }
                return null;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return null;
        }

        public static SimpleTypeMarker asRigidType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                UnwrappedType unwrappedTypeUnwrap = ((KotlinType) kotlinTypeMarker).unwrap();
                if (unwrappedTypeUnwrap instanceof SimpleType) {
                    return (SimpleType) unwrappedTypeUnwrap;
                }
                return null;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return null;
        }

        public static TypeArgumentMarker asTypeArgument(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                return TypeUtilsKt.asTypeProjection((KotlinType) kotlinTypeMarker);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return null;
        }

        public static SimpleType captureFromArguments(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker, CaptureStatus captureStatus) {
            rigidTypeMarker.getClass();
            captureStatus.getClass();
            if (rigidTypeMarker instanceof SimpleType) {
                return NewCapturedTypeKt.captureFromArguments((SimpleType) rigidTypeMarker, captureStatus);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(rigidTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
            return null;
        }

        public static CaptureStatus captureStatus(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            capturedTypeMarker.getClass();
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getCaptureStatus();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(capturedTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass()));
            return null;
        }

        public static KotlinTypeMarker createFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
            rigidTypeMarker.getClass();
            rigidTypeMarker2.getClass();
            if (!(rigidTypeMarker instanceof SimpleType)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(classicTypeSystemContext);
                Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass()));
                return null;
            }
            if (rigidTypeMarker2 instanceof SimpleType) {
                return KotlinTypeFactory.flexibleType((SimpleType) rigidTypeMarker, (SimpleType) rigidTypeMarker2);
            }
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(classicTypeSystemContext);
            Home$$ExternalSyntheticBUOutline0.m$1(sb2, ", ", Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass()));
            return null;
        }

        public static TypeArgumentMarker getArgument(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, int i) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments().get(i);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return null;
        }

        public static List<TypeArgumentMarker> getArguments(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return null;
        }

        public static KotlinBuiltIns getBuiltIns(ClassicTypeSystemContext classicTypeSystemContext) {
            throw new UnsupportedOperationException("Not supported");
        }

        public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
                return null;
            }
            ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2510getDeclarationDescriptor();
            classifierDescriptorMo2510getDeclarationDescriptor.getClass();
            return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor);
        }

        public static TypeParameterMarker getParameter(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker, int i) {
            typeConstructorMarker.getClass();
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
                return null;
            }
            TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) typeConstructorMarker).getParameters().get(i);
            typeParameterDescriptor.getClass();
            return typeParameterDescriptor;
        }

        public static List<TypeParameterMarker> getParameters(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
                return null;
            }
            List<TypeParameterDescriptor> parameters = ((TypeConstructor) typeConstructorMarker).getParameters();
            parameters.getClass();
            return parameters;
        }

        public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
                return null;
            }
            ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2510getDeclarationDescriptor();
            classifierDescriptorMo2510getDeclarationDescriptor.getClass();
            return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor);
        }

        public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
                return null;
            }
            ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2510getDeclarationDescriptor();
            classifierDescriptorMo2510getDeclarationDescriptor.getClass();
            return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor);
        }

        public static KotlinTypeMarker getRepresentativeUpperBound(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
            typeParameterMarker.getClass();
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) typeParameterMarker);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeParameterMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass()));
            return null;
        }

        public static KotlinTypeMarker getType(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
            typeArgumentMarker.getClass();
            if (classicTypeSystemContext.isStarProjection(typeArgumentMarker)) {
                return null;
            }
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).getType().unwrap();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeArgumentMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass()));
            return null;
        }

        public static TypeConstructorMarker getTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
            typeParameterMarker.getClass();
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                TypeConstructor typeConstructor = ((TypeParameterDescriptor) typeParameterMarker).getTypeConstructor();
                typeConstructor.getClass();
                return typeConstructor;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeParameterMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass()));
            return null;
        }

        public static TypeParameterMarker getTypeParameterClassifier(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
                return null;
            }
            ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2510getDeclarationDescriptor();
            if (classifierDescriptorMo2510getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                return (TypeParameterDescriptor) classifierDescriptorMo2510getDeclarationDescriptor;
            }
            return null;
        }

        public static KotlinTypeMarker getUnsubstitutedUnderlyingType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                return InlineClassesUtilsKt.unsubstitutedUnderlyingType((KotlinType) kotlinTypeMarker);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return null;
        }

        public static List<KotlinTypeMarker> getUpperBounds(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
            typeParameterMarker.getClass();
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                List<KotlinType> upperBounds = ((TypeParameterDescriptor) typeParameterMarker).getUpperBounds();
                upperBounds.getClass();
                return upperBounds;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeParameterMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass()));
            return null;
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
            typeArgumentMarker.getClass();
            if (typeArgumentMarker instanceof TypeProjection) {
                Variance projectionKind = ((TypeProjection) typeArgumentMarker).getProjectionKind();
                projectionKind.getClass();
                return TypeSystemContextKt.convertVariance(projectionKind);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeArgumentMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass()));
            return null;
        }

        public static boolean hasAnnotation(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, FqName fqName) {
            kotlinTypeMarker.getClass();
            fqName.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getAnnotations().hasAnnotation(fqName);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return false;
        }

        public static boolean hasRecursiveBounds(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker, TypeConstructorMarker typeConstructorMarker) {
            typeParameterMarker.getClass();
            if (!(typeParameterMarker instanceof TypeParameterDescriptor)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(typeParameterMarker);
                Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass()));
                return false;
            }
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) typeParameterMarker;
            if (typeConstructorMarker == null ? true : typeConstructorMarker instanceof TypeConstructor) {
                return TypeUtilsKt.hasTypeParameterRecursiveBounds$default(typeParameterDescriptor, (TypeConstructor) typeConstructorMarker, null, 4, null);
            }
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(typeParameterDescriptor);
            Home$$ExternalSyntheticBUOutline0.m$1(sb2, ", ", Reflection.getOrCreateKotlinClass(typeParameterDescriptor.getClass()));
            return false;
        }

        public static boolean identicalArguments(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
            rigidTypeMarker.getClass();
            rigidTypeMarker2.getClass();
            if (!(rigidTypeMarker instanceof SimpleType)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(rigidTypeMarker);
                Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
                return false;
            }
            if (rigidTypeMarker2 instanceof SimpleType) {
                return ((SimpleType) rigidTypeMarker).getArguments() == ((SimpleType) rigidTypeMarker2).getArguments();
            }
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(rigidTypeMarker2);
            Home$$ExternalSyntheticBUOutline0.m$1(sb2, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker2.getClass()));
            return false;
        }

        public static KotlinTypeMarker intersectTypes(ClassicTypeSystemContext classicTypeSystemContext, Collection<? extends KotlinTypeMarker> collection) {
            collection.getClass();
            return IntersectionTypeKt.intersectTypes(collection);
        }

        public static boolean isAnyConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (typeConstructorMarker instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, StandardNames.FqNames.any);
            }
            Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            return false;
        }

        public static boolean isArrayOrNullableArray(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                return KotlinBuiltIns.isArray((KotlinType) kotlinTypeMarker);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return false;
        }

        public static boolean isClassTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).mo2510getDeclarationDescriptor() instanceof ClassDescriptor;
            }
            Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            return false;
        }

        public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
                return false;
            }
            ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2510getDeclarationDescriptor();
            ClassDescriptor classDescriptor = classifierDescriptorMo2510getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor : null;
            return (classDescriptor == null || !ModalityUtilsKt.isFinalClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) ? false : true;
        }

        public static boolean isDenotable(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).isDenotable();
            }
            Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            return false;
        }

        public static boolean isError(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                return KotlinTypeKt.isError((KotlinType) kotlinTypeMarker);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return false;
        }

        public static boolean isInlineClass(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
                return false;
            }
            ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2510getDeclarationDescriptor();
            ClassDescriptor classDescriptor = classifierDescriptorMo2510getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor : null;
            return (classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null) instanceof InlineClassRepresentation;
        }

        public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntegerLiteralTypeConstructor;
            }
            Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            return false;
        }

        public static boolean isIntersection(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntersectionTypeConstructor;
            }
            Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            return false;
        }

        public static boolean isK2(ClassicTypeSystemContext classicTypeSystemContext) {
            return false;
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            return (kotlinTypeMarker instanceof SimpleType) && ((SimpleType) kotlinTypeMarker).isMarkedNullable();
        }

        public static boolean isNotNullTypeParameter(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            return kotlinTypeMarker instanceof NotNullTypeParameter;
        }

        public static boolean isNothingConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (typeConstructorMarker instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, StandardNames.FqNames.nothing);
            }
            Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            return false;
        }

        public static boolean isNullableType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                return TypeUtils.isNullableType((KotlinType) kotlinTypeMarker);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return false;
        }

        public static boolean isOldCapturedType(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            capturedTypeMarker.getClass();
            return capturedTypeMarker instanceof CapturedType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            simpleTypeMarker.getClass();
            if (simpleTypeMarker instanceof KotlinType) {
                return KotlinBuiltIns.isPrimitiveType((KotlinType) simpleTypeMarker);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            return false;
        }

        public static boolean isProjectionNotNull(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            capturedTypeMarker.getClass();
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).isProjectionNotNull();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(capturedTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass()));
            return false;
        }

        public static boolean isRawType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof KotlinType) {
                return kotlinTypeMarker instanceof RawType;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isSingleClassifierType(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker) {
            rigidTypeMarker.getClass();
            if (!(rigidTypeMarker instanceof SimpleType)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(rigidTypeMarker);
                Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
                return false;
            }
            if (!KotlinTypeKt.isError((KotlinType) rigidTypeMarker)) {
                SimpleType simpleType = (SimpleType) rigidTypeMarker;
                if (!(simpleType.getConstructor().mo2510getDeclarationDescriptor() instanceof TypeAliasDescriptor) && (simpleType.getConstructor().mo2510getDeclarationDescriptor() != null || (rigidTypeMarker instanceof CapturedType) || (rigidTypeMarker instanceof NewCapturedType) || (rigidTypeMarker instanceof DefinitelyNotNullType) || (simpleType.getConstructor() instanceof IntegerLiteralTypeConstructor) || isSingleClassifierTypeWithEnhancement(classicTypeSystemContext, (SimpleTypeMarker) rigidTypeMarker))) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isSingleClassifierTypeWithEnhancement(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            return (simpleTypeMarker instanceof SimpleTypeWithEnhancement) && classicTypeSystemContext.isSingleClassifierType(((SimpleTypeWithEnhancement) simpleTypeMarker).getOrigin());
        }

        public static boolean isStarProjection(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
            typeArgumentMarker.getClass();
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).isStarProjection();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeArgumentMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass()));
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubType(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker) {
            rigidTypeMarker.getClass();
            if (rigidTypeMarker instanceof SimpleType) {
                return TypeUtilsKt.isStubType((KotlinType) rigidTypeMarker);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(rigidTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubTypeForBuilderInference(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker) {
            rigidTypeMarker.getClass();
            if (rigidTypeMarker instanceof SimpleType) {
                return TypeUtilsKt.isStubTypeForBuilderInference((KotlinType) rigidTypeMarker);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(rigidTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
            return false;
        }

        public static boolean isTypeVariableType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            if (!(kotlinTypeMarker instanceof UnwrappedType)) {
                return false;
            }
            ((UnwrappedType) kotlinTypeMarker).getConstructor();
            return false;
        }

        public static boolean isUnderKotlinPackage(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2510getDeclarationDescriptor();
                return classifierDescriptorMo2510getDeclarationDescriptor != null && KotlinBuiltIns.isUnderKotlinPackage(classifierDescriptorMo2510getDeclarationDescriptor);
            }
            Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            return false;
        }

        public static SimpleTypeMarker lowerBound(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
            flexibleTypeMarker.getClass();
            if (flexibleTypeMarker instanceof FlexibleType) {
                return ((FlexibleType) flexibleTypeMarker).getLowerBound();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(flexibleTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass()));
            return null;
        }

        public static KotlinTypeMarker lowerType(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            capturedTypeMarker.getClass();
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getLowerType();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(capturedTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass()));
            return null;
        }

        public static KotlinTypeMarker makeDefinitelyNotNullOrNotNull(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, boolean z) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof UnwrappedType) {
                return ClassicTypeSystemContextKt.makeDefinitelyNotNullOrNotNullInternal((UnwrappedType) kotlinTypeMarker);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            return null;
        }

        public static TypeCheckerState newTypeCheckerState(ClassicTypeSystemContext classicTypeSystemContext, boolean z, boolean z2, boolean z3) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(z, z2, classicTypeSystemContext, null, null, 24, null);
        }

        public static SimpleTypeMarker nullableAnyType(ClassicTypeSystemContext classicTypeSystemContext) {
            SimpleType nullableAnyType = classicTypeSystemContext.getBuiltIns().getNullableAnyType();
            nullableAnyType.getClass();
            return nullableAnyType;
        }

        public static SimpleTypeMarker original(ClassicTypeSystemContext classicTypeSystemContext, DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
            definitelyNotNullTypeMarker.getClass();
            if (definitelyNotNullTypeMarker instanceof DefinitelyNotNullType) {
                return ((DefinitelyNotNullType) definitelyNotNullTypeMarker).getOriginal();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(definitelyNotNullTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(definitelyNotNullTypeMarker.getClass()));
            return null;
        }

        public static int parametersCount(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getParameters().size();
            }
            Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            return 0;
        }

        public static Collection<KotlinTypeMarker> possibleIntegerTypes(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker) {
            rigidTypeMarker.getClass();
            TypeConstructorMarker typeConstructorMarkerTypeConstructor = classicTypeSystemContext.typeConstructor(rigidTypeMarker);
            if (typeConstructorMarkerTypeConstructor instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) typeConstructorMarkerTypeConstructor).getPossibleTypes();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(rigidTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
            return null;
        }

        public static TypeArgumentMarker projection(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
            capturedTypeConstructorMarker.getClass();
            if (capturedTypeConstructorMarker instanceof NewCapturedTypeConstructor) {
                return ((NewCapturedTypeConstructor) capturedTypeConstructorMarker).getProjection();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(capturedTypeConstructorMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(capturedTypeConstructorMarker.getClass()));
            return null;
        }

        public static KotlinTypeMarker safeSubstitute(ClassicTypeSystemContext classicTypeSystemContext, TypeSubstitutorMarker typeSubstitutorMarker, KotlinTypeMarker kotlinTypeMarker) {
            typeSubstitutorMarker.getClass();
            kotlinTypeMarker.getClass();
            if (!(kotlinTypeMarker instanceof UnwrappedType)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(kotlinTypeMarker);
                Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
                return null;
            }
            if (typeSubstitutorMarker instanceof TypeSubstitutor) {
                KotlinType kotlinTypeSafeSubstitute = ((TypeSubstitutor) typeSubstitutorMarker).safeSubstitute((KotlinType) kotlinTypeMarker, Variance.INVARIANT);
                kotlinTypeSafeSubstitute.getClass();
                return kotlinTypeSafeSubstitute;
            }
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(typeSubstitutorMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb2, ", ", Reflection.getOrCreateKotlinClass(typeSubstitutorMarker.getClass()));
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(final ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker) {
            rigidTypeMarker.getClass();
            if (rigidTypeMarker instanceof SimpleType) {
                final TypeSubstitutor typeSubstitutorBuildSubstitutor = TypeConstructorSubstitution.Companion.create((KotlinType) rigidTypeMarker).buildSubstitutor();
                return new TypeCheckerState.SupertypesPolicy.DoCustomTransform() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext$substitutionSupertypePolicy$2
                    @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
                    /* JADX INFO: renamed from: transformType */
                    public SimpleTypeMarker mo2514transformType(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker) {
                        typeCheckerState.getClass();
                        kotlinTypeMarker.getClass();
                        ClassicTypeSystemContext classicTypeSystemContext2 = classicTypeSystemContext;
                        TypeSubstitutor typeSubstitutor = typeSubstitutorBuildSubstitutor;
                        Object objLowerBoundIfFlexible = classicTypeSystemContext2.lowerBoundIfFlexible(kotlinTypeMarker);
                        objLowerBoundIfFlexible.getClass();
                        KotlinType kotlinTypeSafeSubstitute = typeSubstitutor.safeSubstitute((KotlinType) objLowerBoundIfFlexible, Variance.INVARIANT);
                        kotlinTypeSafeSubstitute.getClass();
                        SimpleTypeMarker simpleTypeMarkerAsRigidType = classicTypeSystemContext2.asRigidType((KotlinTypeMarker) kotlinTypeSafeSubstitute);
                        simpleTypeMarkerAsRigidType.getClass();
                        return simpleTypeMarkerAsRigidType;
                    }
                };
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(rigidTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
            return null;
        }

        public static Collection<KotlinTypeMarker> supertypes(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            typeConstructorMarker.getClass();
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                Utf8$$ExternalSyntheticBUOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", "), Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
                return null;
            }
            Collection<KotlinType> collectionMo2511getSupertypes = ((TypeConstructor) typeConstructorMarker).mo2511getSupertypes();
            collectionMo2511getSupertypes.getClass();
            return collectionMo2511getSupertypes;
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker) {
            rigidTypeMarker.getClass();
            if (rigidTypeMarker instanceof SimpleType) {
                return ((SimpleType) rigidTypeMarker).getConstructor();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(rigidTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
            return null;
        }

        public static TypeSubstitutorMarker typeSubstitutorForUnderlyingType(ClassicTypeSystemContext classicTypeSystemContext, Map<TypeConstructorMarker, ? extends KotlinTypeMarker> map) {
            map.getClass();
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<TypeConstructorMarker, ? extends KotlinTypeMarker> entry : map.entrySet()) {
                TypeConstructorMarker key = entry.getKey();
                KotlinTypeMarker value = entry.getValue();
                key.getClass();
                value.getClass();
                arrayList.add(TuplesKt.to((TypeConstructor) key, TypeUtilsKt.asTypeProjection((KotlinType) value)));
            }
            TypeSubstitutor typeSubstitutorCreate = TypeSubstitutor.create((Map<TypeConstructor, TypeProjection>) MapsKt.toMap(arrayList));
            typeSubstitutorCreate.getClass();
            return typeSubstitutorCreate;
        }

        public static SimpleTypeMarker upperBound(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
            flexibleTypeMarker.getClass();
            if (flexibleTypeMarker instanceof FlexibleType) {
                return ((FlexibleType) flexibleTypeMarker).getUpperBound();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(flexibleTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass()));
            return null;
        }

        public static KotlinTypeMarker withNullability(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, boolean z) {
            kotlinTypeMarker.getClass();
            if (kotlinTypeMarker instanceof RigidTypeMarker) {
                return classicTypeSystemContext.withNullability((RigidTypeMarker) kotlinTypeMarker, z);
            }
            if (kotlinTypeMarker instanceof FlexibleTypeMarker) {
                FlexibleTypeMarker flexibleTypeMarker = (FlexibleTypeMarker) kotlinTypeMarker;
                return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability((RigidTypeMarker) classicTypeSystemContext.lowerBound(flexibleTypeMarker), z), classicTypeSystemContext.withNullability((RigidTypeMarker) classicTypeSystemContext.upperBound(flexibleTypeMarker), z));
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("sealed");
            return null;
        }

        public static CapturedTypeConstructorMarker typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            capturedTypeMarker.getClass();
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getConstructor();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(capturedTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass()));
            return null;
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
            typeParameterMarker.getClass();
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                Variance variance = ((TypeParameterDescriptor) typeParameterMarker).getVariance();
                variance.getClass();
                return TypeSystemContextKt.convertVariance(variance);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeParameterMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass()));
            return null;
        }

        public static SimpleTypeMarker withNullability(ClassicTypeSystemContext classicTypeSystemContext, RigidTypeMarker rigidTypeMarker, boolean z) {
            rigidTypeMarker.getClass();
            if (rigidTypeMarker instanceof SimpleType) {
                return ((SimpleType) rigidTypeMarker).makeNullableAsSpecified(z);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(rigidTypeMarker);
            Home$$ExternalSyntheticBUOutline0.m$1(sb, ", ", Reflection.getOrCreateKotlinClass(rigidTypeMarker.getClass()));
            return null;
        }
    }
}
