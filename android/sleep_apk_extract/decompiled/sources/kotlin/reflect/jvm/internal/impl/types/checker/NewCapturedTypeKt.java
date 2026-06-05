package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NewCapturedTypeKt {
    private static final List<TypeProjection> captureArguments(UnwrappedType unwrappedType, CaptureStatus captureStatus) {
        if (unwrappedType.getArguments().size() == unwrappedType.getConstructor().getParameters().size()) {
            List<TypeProjection> arguments = unwrappedType.getArguments();
            List<TypeProjection> list = arguments;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((TypeProjection) it.next()).getProjectionKind() != Variance.INVARIANT) {
                        List<TypeParameterDescriptor> parameters = unwrappedType.getConstructor().getParameters();
                        parameters.getClass();
                        List<Pair> listZip = CollectionsKt.zip(list, parameters);
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listZip, 10));
                        for (Pair pair : listZip) {
                            TypeProjection typeProjectionAsTypeProjection = (TypeProjection) pair.component1();
                            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
                            if (typeProjectionAsTypeProjection.getProjectionKind() != Variance.INVARIANT) {
                                UnwrappedType unwrappedTypeUnwrap = (typeProjectionAsTypeProjection.isStarProjection() || typeProjectionAsTypeProjection.getProjectionKind() != Variance.IN_VARIANCE) ? null : typeProjectionAsTypeProjection.getType().unwrap();
                                typeParameterDescriptor.getClass();
                                typeProjectionAsTypeProjection = TypeUtilsKt.asTypeProjection(new NewCapturedType(captureStatus, unwrappedTypeUnwrap, typeProjectionAsTypeProjection, typeParameterDescriptor));
                            }
                            arrayList.add(typeProjectionAsTypeProjection);
                        }
                        TypeSubstitutor typeSubstitutorBuildSubstitutor = TypeConstructorSubstitution.Companion.create(unwrappedType.getConstructor(), arrayList).buildSubstitutor();
                        int size = arguments.size();
                        for (int i = 0; i < size; i++) {
                            TypeProjection typeProjection = arguments.get(i);
                            TypeProjection typeProjection2 = (TypeProjection) arrayList.get(i);
                            if (typeProjection.getProjectionKind() != Variance.INVARIANT) {
                                List<KotlinType> upperBounds = unwrappedType.getConstructor().getParameters().get(i).getUpperBounds();
                                upperBounds.getClass();
                                ArrayList arrayList2 = new ArrayList();
                                Iterator<T> it2 = upperBounds.iterator();
                                while (it2.hasNext()) {
                                    arrayList2.add(KotlinTypePreparator.Default.INSTANCE.prepareType((KotlinTypeMarker) typeSubstitutorBuildSubstitutor.safeSubstitute((KotlinType) it2.next(), Variance.INVARIANT).unwrap()));
                                }
                                if (!typeProjection.isStarProjection() && typeProjection.getProjectionKind() == Variance.OUT_VARIANCE) {
                                    arrayList2.add(KotlinTypePreparator.Default.INSTANCE.prepareType((KotlinTypeMarker) typeProjection.getType().unwrap()));
                                }
                                KotlinType type = typeProjection2.getType();
                                type.getClass();
                                ((NewCapturedType) type).getConstructor().initializeSupertypes(arrayList2);
                            }
                        }
                        return arrayList;
                    }
                }
            }
        }
        return null;
    }

    public static final SimpleType captureFromArguments(SimpleType simpleType, CaptureStatus captureStatus) {
        simpleType.getClass();
        captureStatus.getClass();
        List<TypeProjection> listCaptureArguments = captureArguments(simpleType, captureStatus);
        if (listCaptureArguments != null) {
            return replaceArguments(simpleType, listCaptureArguments);
        }
        return null;
    }

    private static final SimpleType replaceArguments(UnwrappedType unwrappedType, List<? extends TypeProjection> list) {
        return KotlinTypeFactory.simpleType$default(unwrappedType.getAttributes(), unwrappedType.getConstructor(), list, unwrappedType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
    }
}
