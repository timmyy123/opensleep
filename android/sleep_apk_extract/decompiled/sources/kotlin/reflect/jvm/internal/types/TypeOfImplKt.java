package kotlin.reflect.jvm.internal.types;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.SystemPropertiesKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.types.FlexibleKType;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/KType;", "lowerBound", "upperBound", "createPlatformKType", "(Lkotlin/reflect/KType;Lkotlin/reflect/KType;)Lkotlin/reflect/KType;", "type", "createMutableCollectionKType", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "readOnlyToMutable", "(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class TypeOfImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final KType createMutableCollectionKType(KType kType) {
        String qualifiedName;
        kType.getClass();
        Function0 function0 = null;
        Object[] objArr = 0;
        if (!SystemPropertiesKt.getUseK1Implementation()) {
            SimpleKType simpleKType = (SimpleKType) kType;
            KClassifier classifier = simpleKType.getClassifier();
            KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
            if (kClass == null || (qualifiedName = kClass.getQualifiedName()) == null) {
                Events$$ExternalSyntheticBUOutline0.m$1("Non-class type cannot be a mutable collection type: ", kType);
                return null;
            }
            FqName onlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(new FqNameUnsafe(qualifiedName));
            if (onlyToMutable != null) {
                return new SimpleKType(simpleKType.getClassifier(), simpleKType.getArguments(), simpleKType.getIsMarkedNullable(), simpleKType.getAnnotations(), simpleKType.getAbbreviation(), simpleKType.getIsDefinitelyNotNullType(), simpleKType.getIsNothingType(), simpleKType.getIsSuspendFunctionType(), MutableCollectionKClassKt.getMutableCollectionKClass(onlyToMutable, (KClass) classifier), null, 512, null);
            }
            Gson$$ExternalSyntheticBUOutline0.m("Not a readonly collection: ", kType);
            return null;
        }
        KotlinType type = ((DescriptorKType) kType).getType();
        if (!(type instanceof SimpleType)) {
            Utf8$$ExternalSyntheticBUOutline0.m$4("Non-simple type cannot be a mutable collection type: ", kType);
            return null;
        }
        ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = type.getConstructor().mo2510getDeclarationDescriptor();
        ClassDescriptor classDescriptor = classifierDescriptorMo2510getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor : null;
        if (classDescriptor == null) {
            Gson$$ExternalSyntheticBUOutline0.m("Non-class type cannot be a mutable collection type: ", kType);
            return null;
        }
        SimpleType simpleType = (SimpleType) type;
        TypeConstructor typeConstructor = readOnlyToMutable(classDescriptor).getTypeConstructor();
        typeConstructor.getClass();
        return new DescriptorKType(KotlinTypeFactory.simpleType$default(simpleType, (TypeAttributes) null, typeConstructor, (List) null, false, 26, (Object) null), function0, 2, objArr == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final KType createPlatformKType(KType kType, KType kType2) {
        kType.getClass();
        kType2.getClass();
        if (!SystemPropertiesKt.getUseK1Implementation()) {
            return FlexibleKType.Companion.create$default(FlexibleKType.INSTANCE, (AbstractKType) kType, (AbstractKType) kType2, false, null, 8, null);
        }
        KotlinType type = ((DescriptorKType) kType).getType();
        type.getClass();
        KotlinType type2 = ((DescriptorKType) kType2).getType();
        type2.getClass();
        return new DescriptorKType(KotlinTypeFactory.flexibleType((SimpleType) type, (SimpleType) type2), null, 2, 0 == true ? 1 : 0);
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor classDescriptor) {
        FqName onlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(classDescriptor));
        if (onlyToMutable == null) {
            Gson$$ExternalSyntheticBUOutline0.m("Not a readonly collection: ", classDescriptor);
            return null;
        }
        ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(classDescriptor).getBuiltInClassByFqName(onlyToMutable);
        builtInClassByFqName.getClass();
        return builtInClassByFqName;
    }
}
