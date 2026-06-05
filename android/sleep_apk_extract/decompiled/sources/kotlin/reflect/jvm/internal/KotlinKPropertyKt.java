package kotlin.reflect.jvm.internal;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.reflect.KClass;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KotlinKProperty;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.jvm.internal.calls.ThrowingCaller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmAttributes;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmExtensionsKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0010\u0010\t\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KotlinKProperty$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KotlinKProperty$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/KotlinKProperty;", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class KotlinKPropertyKt {
    public static final Caller<?> computeCallerForAccessor(KotlinKProperty.Accessor<?, ?> accessor, boolean z) {
        Caller boundInstance;
        Method inlineClassUnboxMethod;
        accessor.getClass();
        KotlinKProperty<?> property = accessor.getProperty();
        if (ReflectKPropertyKt.isLocalDelegated(property)) {
            return ThrowingCaller.INSTANCE;
        }
        KmProperty kmProperty = property.getKmProperty();
        JvmMethodSignature getterSignature = z ? JvmExtensionsKt.getGetterSignature(kmProperty) : JvmExtensionsKt.getSetterSignature(kmProperty);
        Method methodFindMethodBySignature = getterSignature != null ? property.getContainer().findMethodBySignature(getterSignature.getName(), getterSignature.getDescriptor()) : null;
        if (methodFindMethodBySignature != null) {
            boundInstance = !Modifier.isStatic(methodFindMethodBySignature.getModifiers()) ? ReflectKCallableKt.isBound(accessor) ? new CallerImpl.Method.BoundInstance(methodFindMethodBySignature, getBoundReceiver(accessor)) : new CallerImpl.Method.Instance(methodFindMethodBySignature) : computeCallerForAccessor$isJvmStaticProperty(accessor) ? ReflectKCallableKt.isBound(accessor) ? new CallerImpl.Method.BoundJvmStaticInObject(methodFindMethodBySignature) : new CallerImpl.Method.JvmStaticInObject(methodFindMethodBySignature) : ReflectKCallableKt.isBound(accessor) ? new CallerImpl.Method.BoundStatic(methodFindMethodBySignature, false, getBoundReceiver(accessor)) : new CallerImpl.Method.Static(methodFindMethodBySignature);
        } else if (ValueClassAwareCallerKt.isUnderlyingPropertyOfValueClass(property) && property.getVisibility() == KVisibility.INTERNAL) {
            Class<?> inlineClass = ValueClassAwareCallerKt.toInlineClass(((KParameter) CollectionsKt.single((List) property.getParameters())).getType());
            if (inlineClass == null || (inlineClassUnboxMethod = ValueClassAwareCallerKt.getInlineClassUnboxMethod(inlineClass, property)) == null) {
                throw new KotlinReflectionInternalError("Underlying property of inline class " + property + " should have a field");
            }
            boundInstance = ReflectKCallableKt.isBound(accessor) ? new InternalUnderlyingValOfInlineClass.Bound(inlineClassUnboxMethod, getBoundReceiver(accessor)) : new InternalUnderlyingValOfInlineClass.Unbound(inlineClassUnboxMethod);
        } else {
            Field javaField = property.getJavaField();
            if (javaField == null) {
                Events$$ExternalSyntheticBUOutline0.m$1("No accessors or field is found for property ", property);
                return null;
            }
            boundInstance = computeCallerForAccessor$computeFieldCaller(property, z, accessor, javaField);
        }
        return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(boundInstance, accessor, false, CollectionsKt.emptyList());
    }

    private static final CallerImpl<Field> computeCallerForAccessor$computeFieldCaller(KotlinKProperty<? extends Object> kotlinKProperty, boolean z, KotlinKProperty.Accessor<?, ?> accessor, Field field) {
        return (isJvmFieldPropertyInCompanionObject(kotlinKProperty) || !Modifier.isStatic(field.getModifiers())) ? z ? ReflectKCallableKt.isBound(accessor) ? new CallerImpl.FieldGetter.BoundInstance(field, getBoundReceiver(accessor)) : new CallerImpl.FieldGetter.Instance(field) : ReflectKCallableKt.isBound(accessor) ? new CallerImpl.FieldSetter.BoundInstance(field, computeCallerForAccessor$isNotNullProperty(kotlinKProperty), getBoundReceiver(accessor)) : new CallerImpl.FieldSetter.Instance(field, computeCallerForAccessor$isNotNullProperty(kotlinKProperty)) : computeCallerForAccessor$isJvmStaticProperty(accessor) ? z ? ReflectKCallableKt.isBound(accessor) ? new CallerImpl.FieldGetter.BoundJvmStaticInObject(field) : new CallerImpl.FieldGetter.JvmStaticInObject(field) : ReflectKCallableKt.isBound(accessor) ? new CallerImpl.FieldSetter.BoundJvmStaticInObject(field, computeCallerForAccessor$isNotNullProperty(kotlinKProperty)) : new CallerImpl.FieldSetter.JvmStaticInObject(field, computeCallerForAccessor$isNotNullProperty(kotlinKProperty)) : z ? new CallerImpl.FieldGetter.Static(field) : new CallerImpl.FieldSetter.Static(field, computeCallerForAccessor$isNotNullProperty(kotlinKProperty));
    }

    private static final boolean computeCallerForAccessor$isJvmStaticProperty(KotlinKProperty.Accessor<?, ?> accessor) {
        if (accessor.getContainer() instanceof KPackageImpl) {
            return false;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$4("Only top-level properties are supported for now: ", accessor);
        return false;
    }

    private static final boolean computeCallerForAccessor$isNotNullProperty(KotlinKProperty<? extends Object> kotlinKProperty) {
        return !UtilKt.isNullableType(kotlinKProperty.getReturnType());
    }

    public static final Object getBoundReceiver(KotlinKProperty.Accessor<?, ?> accessor) {
        accessor.getClass();
        return ReflectKCallableKt.getBoundReceiver(accessor.getProperty());
    }

    private static final boolean isJvmFieldPropertyInCompanionObject(KotlinKProperty<?> kotlinKProperty) {
        ClassBasedDeclarationContainer container = kotlinKProperty.getContainer();
        if (!(container instanceof KClassImpl) || ((KClassImpl) container).getClassKind$kotlin_reflection() != ClassKind.COMPANION_OBJECT) {
            return false;
        }
        Class<?> enclosingClass = JvmClassMappingKt.getJavaClass((KClass) container).getEnclosingClass();
        enclosingClass.getClass();
        KClass kotlinClass = JvmClassMappingKt.getKotlinClass(enclosingClass);
        KClassImpl kClassImpl = kotlinClass instanceof KClassImpl ? (KClassImpl) kotlinClass : null;
        if (kClassImpl == null) {
            return false;
        }
        if (kClassImpl.getClassKind$kotlin_reflection() == ClassKind.INTERFACE || kClassImpl.getClassKind$kotlin_reflection() == ClassKind.ANNOTATION_CLASS) {
            return JvmAttributes.isMovedFromInterfaceCompanion(kotlinKProperty.getKmProperty());
        }
        return true;
    }
}
