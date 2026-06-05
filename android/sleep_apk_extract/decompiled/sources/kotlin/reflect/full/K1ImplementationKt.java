package kotlin.reflect.full;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.types.DescriptorKType;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, d2 = {"createK1KType", "Lkotlin/reflect/jvm/internal/types/DescriptorKType;", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "nullable", "", "createKotlinType", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "typeConstructor", "Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class K1ImplementationKt {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final DescriptorKType createK1KType(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        ClassifierDescriptor descriptor;
        kClassifier.getClass();
        list.getClass();
        if (kClassifier instanceof KClassImpl) {
            descriptor = ((KClassImpl) kClassifier).getDescriptor();
        } else {
            if (!(kClassifier instanceof KTypeParameterImpl)) {
                StringBuilder sb = new StringBuilder("Cannot create type for an unsupported classifier: ");
                sb.append(kClassifier);
                Class<?> cls = kClassifier.getClass();
                sb.append(" (");
                sb.append(cls);
                sb.append(')');
                throw new KotlinReflectionInternalError(sb.toString());
            }
            descriptor = ((KTypeParameterImpl) kClassifier).getDescriptor();
        }
        KClassifiers.checkArgumentsSize(descriptor.getTypeConstructor().getParameters().size(), list.size());
        TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        typeConstructor.getClass();
        return new DescriptorKType(createKotlinType(typeConstructor, list, z), null, 2, 0 == true ? 1 : 0);
    }

    private static final SimpleType createKotlinType(TypeConstructor typeConstructor, List<KTypeProjection> list, boolean z) {
        TypeProjectionBase starProjectionImpl;
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        parameters.getClass();
        TypeAttributes empty = TypeAttributes.Companion.getEmpty();
        List<KTypeProjection> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KTypeProjection kTypeProjection = (KTypeProjection) obj;
            DescriptorKType descriptorKType = (DescriptorKType) kTypeProjection.getType();
            KotlinType type = descriptorKType != null ? descriptorKType.getType() : null;
            KVariance variance = kTypeProjection.getVariance();
            int i3 = variance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
            if (i3 == -1) {
                TypeParameterDescriptor typeParameterDescriptor = parameters.get(i);
                typeParameterDescriptor.getClass();
                starProjectionImpl = new StarProjectionImpl(typeParameterDescriptor);
            } else if (i3 == 1) {
                Variance variance2 = Variance.INVARIANT;
                type.getClass();
                starProjectionImpl = new TypeProjectionImpl(variance2, type);
            } else if (i3 == 2) {
                Variance variance3 = Variance.IN_VARIANCE;
                type.getClass();
                starProjectionImpl = new TypeProjectionImpl(variance3, type);
            } else {
                if (i3 != 3) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                Variance variance4 = Variance.OUT_VARIANCE;
                type.getClass();
                starProjectionImpl = new TypeProjectionImpl(variance4, type);
            }
            arrayList.add(starProjectionImpl);
            i = i2;
        }
        return KotlinTypeFactory.simpleType$default(empty, typeConstructor, arrayList, z, (KotlinTypeRefiner) null, 16, (Object) null);
    }
}
