package kotlin.reflect.jvm.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.km.KmClassifier;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeProjection;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.Visibility;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmExtensionsKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.types.AbstractKType;
import kotlin.reflect.jvm.internal.types.FlexibleKType;
import kotlin.reflect.jvm.internal.types.MutableCollectionKClass;
import kotlin.reflect.jvm.internal.types.MutableCollectionKClassKt;
import kotlin.reflect.jvm.internal.types.SimpleKType;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u0002*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u001e\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006*\u00020\u00072\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0000\u001a.\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0000\u001a\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002\u001a$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a*\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002\u001a,\u0010 \u001a\u00020\u001f*\u00020!2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002\u001a\f\u0010\"\u001a\u00020#*\u00020$H\u0000\u001a\u001a\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&*\u00020\u001c2\u0006\u0010'\u001a\u00020\u001bH\u0002\u001a\u0014\u0010(\u001a\u00020)*\u00020*2\u0006\u0010\f\u001a\u00020\u0007H\u0000\u001a*\u0010+\u001a\u00020,*\u00020-2\n\u0010.\u001a\u00060\u0002j\u0002`\u00032\b\u0010/\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0007H\u0002\u001a\u000e\u00100\u001a\u0004\u0018\u000101*\u000202H\u0000\u001a\u0016\u00103\u001a\u0004\u0018\u00010\u0002*\u0002042\u0006\u00105\u001a\u000206H\u0000\u001a\u0014\u00107\u001a\u00020\u0002*\u0002042\u0006\u00105\u001a\u000206H\u0002\u001a\u001c\u00108\u001a\u0006\u0012\u0002\b\u0003092\u0006\u0010:\u001a\u0002042\u0006\u00105\u001a\u000206H\u0000\u001a\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u00105\u001a\u000206H\u0000\u001a\u0018\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020A2\u0006\u00105\u001a\u000206H\u0000¨\u0006B²\u0006\u0010\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00110\u001eX\u008a\u0084\u0002"}, d2 = {"toClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "", "Lkotlin/reflect/jvm/internal/impl/km/ClassName;", "toNonLocalSimpleName", "loadKClass", "Lkotlin/reflect/KClass;", "Ljava/lang/ClassLoader;", "name", "toKType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/jvm/internal/impl/km/KmType;", "classLoader", "typeParameterTable", "Lkotlin/reflect/jvm/internal/TypeParameterTable;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "unwrapSuspendFunctionType", "Lkotlin/reflect/jvm/internal/types/SimpleKType;", "type", "convertTypeArgumentToJavaType", "computeType", "Lkotlin/reflect/jvm/internal/types/AbstractKType;", "index", "", "toClassifier", "Lkotlin/reflect/KClassifier;", "Lkotlin/reflect/jvm/internal/impl/km/KmClassifier;", "typeArguments", "", "Lkotlin/reflect/KTypeProjection;", "toKTypeProjection", "Lkotlin/reflect/jvm/internal/impl/km/KmTypeProjection;", "toKVariance", "Lkotlin/reflect/KVariance;", "Lkotlin/reflect/jvm/internal/impl/km/KmVariance;", "toMutableCollectionKClass", "Lkotlin/reflect/jvm/internal/types/MutableCollectionKClass;", "kClassifier", "toAnnotation", "", "Lkotlin/reflect/jvm/internal/impl/km/KmAnnotation;", "toAnnotationArgument", "", "Lkotlin/reflect/jvm/internal/impl/km/KmAnnotationArgument;", "annotationClassName", "argumentName", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/km/Visibility;", "computeJvmSignature", "Lkotlin/reflect/jvm/internal/impl/km/KmProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getManglingSuffix", "createUnboundProperty", "Lkotlin/reflect/jvm/internal/KotlinKProperty;", "property", "createUnboundFunction", "Lkotlin/reflect/jvm/internal/KotlinKFunction;", "function", "Lkotlin/reflect/jvm/internal/impl/km/KmFunction;", "createUnboundConstructor", "constructor", "Lkotlin/reflect/jvm/internal/impl/km/KmConstructor;", "kotlin-reflection", "javaParameterizedTypeArguments"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ConvertFromMetadataKt {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[KmVariance.values().length];
            try {
                iArr[KmVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KmVariance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KmVariance.INVARIANT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Visibility.values().length];
            try {
                iArr2[Visibility.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Visibility.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Visibility.PROTECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Visibility.PUBLIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Visibility.PRIVATE_TO_THIS.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Visibility.LOCAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final String computeJvmSignature(KmProperty kmProperty, KDeclarationContainerImpl kDeclarationContainerImpl) {
        String string;
        kmProperty.getClass();
        kDeclarationContainerImpl.getClass();
        JvmMethodSignature getterSignature = JvmExtensionsKt.getGetterSignature(kmProperty);
        if (getterSignature != null && (string = getterSignature.toString()) != null) {
            return string;
        }
        JvmFieldSignature fieldSignature = JvmExtensionsKt.getFieldSignature(kmProperty);
        if (fieldSignature == null) {
            return null;
        }
        return JvmAbi.getterName(fieldSignature.getName()) + getManglingSuffix(kmProperty, kDeclarationContainerImpl) + "()" + fieldSignature.getDescriptor();
    }

    public static final Function0<Type> convertTypeArgumentToJavaType(final Function0<? extends AbstractKType> function0, final int i) {
        function0.getClass();
        return new Function0(function0, i) { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$3
            private final Function0 arg$0;
            private final int arg$1;

            {
                this.arg$0 = function0;
                this.arg$1 = i;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ConvertFromMetadataKt.convertTypeArgumentToJavaType$lambda$0(this.arg$0, this.arg$1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type convertTypeArgumentToJavaType$lambda$0(Function0 function0, int i) {
        final AbstractKType abstractKType = (AbstractKType) function0.invoke();
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(abstractKType) { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$5
            private final AbstractKType arg$0;

            {
                this.arg$0 = abstractKType;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ConvertFromMetadataKt.convertTypeArgumentToJavaType$lambda$0$0(this.arg$0);
            }
        });
        Type javaType = abstractKType.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            componentType.getClass();
            return componentType;
        }
        if (javaType instanceof GenericArrayType) {
            if (i != 0) {
                Events$$ExternalSyntheticBUOutline0.m$1("Array type has been queried for a non-0th argument: ", abstractKType);
                return null;
            }
            Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
            genericComponentType.getClass();
            return genericComponentType;
        }
        if (!(javaType instanceof ParameterizedType)) {
            Events$$ExternalSyntheticBUOutline0.m$1("Non-generic type has been queried for arguments: ", abstractKType);
            return null;
        }
        Type type = convertTypeArgumentToJavaType$lambda$0$1(lazy).get(i);
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        lowerBounds.getClass();
        Type type2 = (Type) ArraysKt.firstOrNull(lowerBounds);
        if (type2 == null) {
            Type[] upperBounds = wildcardType.getUpperBounds();
            upperBounds.getClass();
            type2 = (Type) ArraysKt.first(upperBounds);
        }
        type2.getClass();
        return type2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List convertTypeArgumentToJavaType$lambda$0$0(AbstractKType abstractKType) {
        Type javaType = abstractKType.getJavaType();
        javaType.getClass();
        return ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
    }

    private static final List<Type> convertTypeArgumentToJavaType$lambda$0$1(Lazy<? extends List<? extends Type>> lazy) {
        return (List) lazy.getValue();
    }

    public static final KotlinKFunction createUnboundConstructor(KmConstructor kmConstructor, KDeclarationContainerImpl kDeclarationContainerImpl) {
        String string;
        kmConstructor.getClass();
        kDeclarationContainerImpl.getClass();
        JvmMethodSignature signature = JvmExtensionsKt.getSignature(kmConstructor);
        if (signature != null && (string = signature.toString()) != null) {
            return new KotlinKConstructor(kDeclarationContainerImpl, string, CallableReference.NO_RECEIVER, kmConstructor);
        }
        throw new KotlinReflectionInternalError("No signature for constructor (" + kmConstructor.getValueParameters().size() + " parameters, declared in " + kDeclarationContainerImpl + ')');
    }

    public static final KotlinKFunction createUnboundFunction(KmFunction kmFunction, KDeclarationContainerImpl kDeclarationContainerImpl) {
        String string;
        kmFunction.getClass();
        kDeclarationContainerImpl.getClass();
        JvmMethodSignature signature = JvmExtensionsKt.getSignature(kmFunction);
        if (signature != null && (string = signature.toString()) != null) {
            return new KotlinKNamedFunction(kDeclarationContainerImpl, string, CallableReference.NO_RECEIVER, kmFunction);
        }
        Events$$ExternalSyntheticBUOutline0.m$2("No signature for function: ", kmFunction.getName());
        return null;
    }

    public static final KotlinKProperty<?> createUnboundProperty(KmProperty kmProperty, KDeclarationContainerImpl kDeclarationContainerImpl) {
        kmProperty.getClass();
        kDeclarationContainerImpl.getClass();
        byte b = !kmProperty.getContextParameters().isEmpty() ? (byte) -1 : kmProperty.getReceiverParameterType() != null ? (byte) 1 : (byte) 0;
        String strComputeJvmSignature = computeJvmSignature(kmProperty, kDeclarationContainerImpl);
        KotlinKProperty<?> kotlinKMutablePropertyN = null;
        if (strComputeJvmSignature == null) {
            Events$$ExternalSyntheticBUOutline0.m$2("No field or getter signature for property: ", kmProperty.getName());
            return null;
        }
        Object obj = CallableReference.NO_RECEIVER;
        if (Attributes.isVar(kmProperty)) {
            if (b == -1) {
                kotlinKMutablePropertyN = new KotlinKMutablePropertyN<>(kDeclarationContainerImpl, strComputeJvmSignature, obj, kmProperty);
            } else if (b == 0) {
                kotlinKMutablePropertyN = new KotlinKMutableProperty0<>(kDeclarationContainerImpl, strComputeJvmSignature, obj, kmProperty);
            } else if (b == 1) {
                kotlinKMutablePropertyN = new KotlinKMutableProperty1<>(kDeclarationContainerImpl, strComputeJvmSignature, obj, kmProperty);
            }
        } else if (b == -1) {
            kotlinKMutablePropertyN = new KotlinKPropertyN<>(kDeclarationContainerImpl, strComputeJvmSignature, obj, kmProperty);
        } else if (b == 0) {
            kotlinKMutablePropertyN = new KotlinKProperty0<>(kDeclarationContainerImpl, strComputeJvmSignature, obj, kmProperty);
        } else if (b == 1) {
            kotlinKMutablePropertyN = new KotlinKProperty1<>(kDeclarationContainerImpl, strComputeJvmSignature, obj, kmProperty);
        }
        if (kotlinKMutablePropertyN != null) {
            return kotlinKMutablePropertyN;
        }
        throw new KotlinReflectionInternalError("Unsupported property: name=" + kmProperty.getName() + " signature=" + strComputeJvmSignature + " container=" + kDeclarationContainerImpl);
    }

    private static final String getManglingSuffix(KmProperty kmProperty, KDeclarationContainerImpl kDeclarationContainerImpl) {
        if (Attributes.getVisibility(kmProperty) != Visibility.INTERNAL || !(kDeclarationContainerImpl instanceof KClassImpl)) {
            if (Attributes.getVisibility(kmProperty) != Visibility.PRIVATE || !(kDeclarationContainerImpl instanceof KPackageImpl)) {
                return "";
            }
            KPackageImpl kPackageImpl = (KPackageImpl) kDeclarationContainerImpl;
            return kPackageImpl.isMultifilePart$kotlin_reflection() ? "$".concat(kPackageImpl.getJClass().getSimpleName()) : "";
        }
        String moduleName$kotlin_reflection = ((KClassImpl) kDeclarationContainerImpl).getModuleName$kotlin_reflection();
        if (moduleName$kotlin_reflection == null) {
            moduleName$kotlin_reflection = "main";
        }
        return "$" + NameUtils.sanitizeAsJavaIdentifier(moduleName$kotlin_reflection);
    }

    public static final KClass<?> loadKClass(ClassLoader classLoader, String str) {
        classLoader.getClass();
        str.getClass();
        Class clsLoadClass$default = UtilKt.loadClass$default(classLoader, toClassId(str), 0, 2, null);
        if (clsLoadClass$default != null) {
            return JvmClassMappingKt.getKotlinClass(clsLoadClass$default);
        }
        return null;
    }

    public static final Annotation toAnnotation(KmAnnotation kmAnnotation, ClassLoader classLoader) {
        kmAnnotation.getClass();
        classLoader.getClass();
        Class clsLoadClass$default = UtilKt.loadClass$default(classLoader, toClassId(kmAnnotation.getClassName()), 0, 2, null);
        if (clsLoadClass$default == null) {
            Events$$ExternalSyntheticBUOutline0.m$2("Annotation class not found: ", kmAnnotation.getClassName());
            return null;
        }
        Map<String, KmAnnotationArgument> arguments = kmAnnotation.getArguments();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments.size()));
        Iterator<T> it = arguments.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), toAnnotationArgument((KmAnnotationArgument) entry.getValue(), kmAnnotation.getClassName(), (String) entry.getKey(), classLoader));
        }
        Object objCreateAnnotationInstance$default = AnnotationConstructorCallerKt.createAnnotationInstance$default(clsLoadClass$default, linkedHashMap, null, 4, null);
        objCreateAnnotationInstance$default.getClass();
        return (Annotation) objCreateAnnotationInstance$default;
    }

    private static final Object toAnnotationArgument(KmAnnotationArgument kmAnnotationArgument, String str, String str2, ClassLoader classLoader) {
        List<KParameter> parameters;
        KType type;
        Class javaClass;
        Class<?> javaClass2;
        if (kmAnnotationArgument instanceof KmAnnotationArgument.AnnotationValue) {
            return toAnnotation(((KmAnnotationArgument.AnnotationValue) kmAnnotationArgument).getAnnotation(), classLoader);
        }
        int i = 0;
        Object obj = null;
        if (kmAnnotationArgument instanceof KmAnnotationArgument.ArrayKClassValue) {
            KmAnnotationArgument.ArrayKClassValue arrayKClassValue = (KmAnnotationArgument.ArrayKClassValue) kmAnnotationArgument;
            KClass<?> kClassLoadKClass = loadKClass(classLoader, arrayKClassValue.getClassName());
            if (kClassLoadKClass == null || (javaClass2 = JvmClassMappingKt.getJavaClass(kClassLoadKClass)) == null) {
                Events$$ExternalSyntheticBUOutline0.m$2("Unresolved class: ", arrayKClassValue.getClassName());
                return null;
            }
            int arrayDimensionCount = arrayKClassValue.getArrayDimensionCount();
            while (i < arrayDimensionCount) {
                javaClass2 = UtilKt.createArrayType(javaClass2);
                i++;
            }
            return javaClass2;
        }
        if (kmAnnotationArgument instanceof KmAnnotationArgument.ArrayValue) {
            KClass<?> kClassLoadKClass2 = loadKClass(classLoader, str);
            if (kClassLoadKClass2 != null) {
                if (!JvmClassMappingKt.getJavaClass(kClassLoadKClass2).isAnnotation()) {
                    kClassLoadKClass2 = null;
                }
                if (kClassLoadKClass2 != null) {
                    KFunction kFunction = (KFunction) CollectionsKt.singleOrNull(kClassLoadKClass2.getConstructors());
                    if (kFunction != null && (parameters = kFunction.getParameters()) != null) {
                        Iterator<T> it = parameters.iterator();
                        boolean z = false;
                        Object obj2 = null;
                        while (true) {
                            if (!it.hasNext()) {
                                if (!z) {
                                    break;
                                }
                            } else {
                                Object next = it.next();
                                if (Intrinsics.areEqual(((KParameter) next).getName(), str2)) {
                                    if (z) {
                                        break;
                                    }
                                    z = true;
                                    obj2 = next;
                                }
                            }
                        }
                        obj2 = null;
                        KParameter kParameter = (KParameter) obj2;
                        if (kParameter != null && (type = kParameter.getType()) != null) {
                            KClassifier classifier = type.getClassifier();
                            KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
                            if (kClass == null || (javaClass = JvmClassMappingKt.getJavaClass(kClass)) == null) {
                                Events$$ExternalSyntheticBUOutline0.m$1("Array parameter type is not a class: ", type);
                                return null;
                            }
                            KmAnnotationArgument.ArrayValue arrayValue = (KmAnnotationArgument.ArrayValue) kmAnnotationArgument;
                            Object objNewInstance = Array.newInstance(Intrinsics.areEqual(javaClass.getComponentType(), KClass.class) ? Class.class : javaClass.getComponentType(), arrayValue.getElements().size());
                            Iterator<T> it2 = arrayValue.getElements().iterator();
                            while (it2.hasNext()) {
                                Array.set(objNewInstance, i, toAnnotationArgument((KmAnnotationArgument) it2.next(), str, null, classLoader));
                                i++;
                            }
                            objNewInstance.getClass();
                            return objNewInstance;
                        }
                    }
                    throw new KotlinReflectionInternalError(Fragment$$ExternalSyntheticOutline1.m("No parameter ", str2, " found in annotation constructor of ", str));
                }
            }
            throw new KotlinReflectionInternalError(FileInsert$$ExternalSyntheticOutline0.m("Not an annotation class: ", str));
        }
        if (!(kmAnnotationArgument instanceof KmAnnotationArgument.EnumValue)) {
            if (!(kmAnnotationArgument instanceof KmAnnotationArgument.KClassValue)) {
                if (kmAnnotationArgument instanceof KmAnnotationArgument.LiteralValue) {
                    return ((KmAnnotationArgument.LiteralValue) kmAnnotationArgument).getValue();
                }
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            KmAnnotationArgument.KClassValue kClassValue = (KmAnnotationArgument.KClassValue) kmAnnotationArgument;
            Class clsLoadClass$default = UtilKt.loadClass$default(classLoader, toClassId(kClassValue.getClassName()), 0, 2, null);
            if (clsLoadClass$default != null) {
                return clsLoadClass$default;
            }
            Events$$ExternalSyntheticBUOutline0.m$2("Unresolved class: ", kClassValue.getClassName());
            return null;
        }
        KmAnnotationArgument.EnumValue enumValue = (KmAnnotationArgument.EnumValue) kmAnnotationArgument;
        Class clsLoadClass$default2 = UtilKt.loadClass$default(classLoader, toClassId(enumValue.getEnumClassName()), 0, 2, null);
        if (clsLoadClass$default2 == null) {
            Events$$ExternalSyntheticBUOutline0.m$2("Unresolved enum class: ", enumValue.getEnumClassName());
            return null;
        }
        Object[] enumConstants = clsLoadClass$default2.getEnumConstants();
        enumConstants.getClass();
        int length = enumConstants.length;
        boolean z2 = false;
        Object obj3 = null;
        while (true) {
            if (i < length) {
                Object obj4 = enumConstants[i];
                obj4.getClass();
                if (Intrinsics.areEqual(((Enum) obj4).name(), enumValue.getEnumEntryName())) {
                    if (z2) {
                        break;
                    }
                    obj3 = obj4;
                    z2 = true;
                }
                i++;
            } else if (z2) {
                obj = obj3;
            }
        }
        if (obj != null) {
            return obj;
        }
        throw new KotlinReflectionInternalError("Unresolved enum entry: " + enumValue.getEnumClassName() + '.' + enumValue.getEnumEntryName());
    }

    public static final ClassId toClassId(String str) {
        str.getClass();
        boolean zStartsWith$default = StringsKt.startsWith$default(str, ".");
        if (zStartsWith$default) {
            str = str.substring(1);
        }
        return new ClassId(new FqName(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsKt.substringBeforeLast(str, '/', ""), '/', '.', false, 4, (Object) null)), new FqName(StringsKt__StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null)), zStartsWith$default);
    }

    private static final KClassifier toClassifier(KmClassifier kmClassifier, ClassLoader classLoader, TypeParameterTable typeParameterTable, List<KTypeProjection> list) {
        if (!(kmClassifier instanceof KmClassifier.Class)) {
            if (kmClassifier instanceof KmClassifier.TypeAlias) {
                return new KTypeAliasImpl(toClassId(((KmClassifier.TypeAlias) kmClassifier).getName()).asSingleFqName());
            }
            if (!(kmClassifier instanceof KmClassifier.TypeParameter)) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            KmClassifier.TypeParameter typeParameter = (KmClassifier.TypeParameter) kmClassifier;
            KTypeParameter kTypeParameter = typeParameterTable.get(typeParameter.getId());
            return kTypeParameter != null ? kTypeParameter : new ErrorTypeParameter(typeParameter.getId());
        }
        KmClassifier.Class r2 = (KmClassifier.Class) kmClassifier;
        if (Intrinsics.areEqual(r2.getName(), "kotlin/Array")) {
            KType type = ((KTypeProjection) CollectionsKt.single((List) list)).getType();
            if (type == null) {
                type = StandardKTypes.INSTANCE.getANY();
            }
            return JvmClassMappingKt.getKotlinClass(UtilKt.createArrayType(JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(type))));
        }
        KClass<?> kClassLoadKClass = loadKClass(classLoader, r2.getName());
        if (kClassLoadKClass != null) {
            return kClassLoadKClass;
        }
        Events$$ExternalSyntheticBUOutline0.m$2("Class not found: ", r2.getName());
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [T, kotlin.reflect.jvm.internal.types.SimpleKType] */
    /* JADX WARN: Type inference failed for: r0v27, types: [T, kotlin.reflect.jvm.internal.types.SimpleKType] */
    public static final KType toKType(KmType kmType, final ClassLoader classLoader, final TypeParameterTable typeParameterTable, final Function0<? extends Type> function0) {
        SimpleKType simpleKType;
        kmType.getClass();
        classLoader.getClass();
        typeParameterTable.getClass();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        List list = SequencesKt.toList(SequencesKt.mapIndexed(SequencesKt.flatMapIterable(SequencesKt.generateSequence(kmType, new Function1() { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ConvertFromMetadataKt.toKType$lambda$0((KmType) obj);
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ConvertFromMetadataKt.toKType$lambda$1((KmType) obj);
            }
        }), new Function2(classLoader, typeParameterTable, function0, ref$ObjectRef) { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$2
            private final ClassLoader arg$0;
            private final TypeParameterTable arg$1;
            private final Function0 arg$2;
            private final Ref$ObjectRef arg$3;

            {
                this.arg$0 = classLoader;
                this.arg$1 = typeParameterTable;
                this.arg$2 = function0;
                this.arg$3 = ref$ObjectRef;
            }

            @Override // kotlin.jvm.functions.Function2
            public Object invoke(Object obj, Object obj2) {
                return ConvertFromMetadataKt.toKType$lambda$2(this.arg$0, this.arg$1, this.arg$2, this.arg$3, ((Number) obj).intValue(), (KmTypeProjection) obj2);
            }
        }));
        KClassifier classifier = toClassifier(kmType.getClassifier(), classLoader, typeParameterTable, list);
        boolean zIsNullable = Attributes.isNullable(kmType);
        List<KmAnnotation> annotations = JvmExtensionsKt.getAnnotations(kmType);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(annotations, 10));
        Iterator<T> it = annotations.iterator();
        while (it.hasNext()) {
            arrayList.add(toAnnotation((KmAnnotation) it.next(), classLoader));
        }
        KmType abbreviatedType = kmType.getAbbreviatedType();
        SimpleKType simpleKType2 = null;
        KType kType$default = abbreviatedType != null ? toKType$default(abbreviatedType, classLoader, typeParameterTable, null, 4, null) : null;
        boolean zIsDefinitelyNonNull = Attributes.isDefinitelyNonNull(kmType);
        KmClassifier classifier2 = kmType.getClassifier();
        KmClassifier.Class r0 = classifier2 instanceof KmClassifier.Class ? (KmClassifier.Class) classifier2 : null;
        ref$ObjectRef.element = new SimpleKType(classifier, list, zIsNullable, arrayList, kType$default, zIsDefinitelyNonNull, Intrinsics.areEqual(r0 != null ? r0.getName() : null, "kotlin/Nothing"), Attributes.isSuspend(kmType), toMutableCollectionKClass(kmType.getClassifier(), classifier), function0);
        if (Attributes.isSuspend(kmType)) {
            T t = ref$ObjectRef.element;
            if (t == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("result");
                simpleKType = null;
            } else {
                simpleKType = (SimpleKType) t;
            }
            ?? UnwrapSuspendFunctionType = unwrapSuspendFunctionType(simpleKType, function0);
            if (UnwrapSuspendFunctionType == 0) {
                StringBuilder sb = new StringBuilder("Invalid suspend function type: ");
                T t2 = ref$ObjectRef.element;
                if (t2 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("result");
                } else {
                    simpleKType2 = (SimpleKType) t2;
                }
                sb.append(simpleKType2);
                throw new KotlinReflectionInternalError(sb.toString());
            }
            ref$ObjectRef.element = UnwrapSuspendFunctionType;
        }
        KmFlexibleTypeUpperBound flexibleTypeUpperBound = kmType.getFlexibleTypeUpperBound();
        if (flexibleTypeUpperBound == null || !Intrinsics.areEqual(flexibleTypeUpperBound.getTypeFlexibilityId(), "kotlin.jvm.PlatformType")) {
            T t3 = ref$ObjectRef.element;
            if (t3 != 0) {
                return (SimpleKType) t3;
            }
            Intrinsics.throwUninitializedPropertyAccessException("result");
            return null;
        }
        FlexibleKType.Companion companion = FlexibleKType.INSTANCE;
        T t4 = ref$ObjectRef.element;
        if (t4 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        } else {
            simpleKType2 = (SimpleKType) t4;
        }
        KType kType$default2 = toKType$default(flexibleTypeUpperBound.getType(), classLoader, typeParameterTable, null, 4, null);
        kType$default2.getClass();
        return companion.create(simpleKType2, (SimpleKType) kType$default2, JvmExtensionsKt.isRaw(kmType), function0);
    }

    public static /* synthetic */ KType toKType$default(KmType kmType, ClassLoader classLoader, TypeParameterTable typeParameterTable, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        return toKType(kmType, classLoader, typeParameterTable, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KmType toKType$lambda$0(KmType kmType) {
        kmType.getClass();
        return kmType.getOuterType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable toKType$lambda$1(KmType kmType) {
        kmType.getClass();
        return kmType.getArguments();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KTypeProjection toKType$lambda$2(ClassLoader classLoader, TypeParameterTable typeParameterTable, Function0 function0, final Ref$ObjectRef ref$ObjectRef, int i, KmTypeProjection kmTypeProjection) {
        kmTypeProjection.getClass();
        return toKTypeProjection(kmTypeProjection, classLoader, typeParameterTable, function0 == null ? null : convertTypeArgumentToJavaType(new Function0(ref$ObjectRef) { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$4
            private final Ref$ObjectRef arg$0;

            {
                this.arg$0 = ref$ObjectRef;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ConvertFromMetadataKt.toKType$lambda$2$0(this.arg$0);
            }
        }, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final AbstractKType toKType$lambda$2$0(Ref$ObjectRef ref$ObjectRef) {
        T t = ref$ObjectRef.element;
        if (t != 0) {
            return (SimpleKType) t;
        }
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return null;
    }

    private static final KTypeProjection toKTypeProjection(KmTypeProjection kmTypeProjection, ClassLoader classLoader, TypeParameterTable typeParameterTable, Function0<? extends Type> function0) {
        if (Intrinsics.areEqual(kmTypeProjection, KmTypeProjection.STAR)) {
            return KTypeProjection.INSTANCE.getSTAR();
        }
        KmVariance variance = kmTypeProjection.getVariance();
        KVariance kVariance = variance != null ? toKVariance(variance) : null;
        KmType type = kmTypeProjection.getType();
        return new KTypeProjection(kVariance, type != null ? toKType(type, classLoader, typeParameterTable, function0) : null);
    }

    public static final KVariance toKVariance(KmVariance kmVariance) {
        kmVariance.getClass();
        int i = WhenMappings.$EnumSwitchMapping$0[kmVariance.ordinal()];
        if (i == 1) {
            return KVariance.IN;
        }
        if (i == 2) {
            return KVariance.OUT;
        }
        if (i == 3) {
            return KVariance.INVARIANT;
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public static final KVisibility toKVisibility(Visibility visibility) {
        visibility.getClass();
        switch (WhenMappings.$EnumSwitchMapping$1[visibility.ordinal()]) {
            case 1:
                return KVisibility.INTERNAL;
            case 2:
                return KVisibility.PRIVATE;
            case 3:
                return KVisibility.PROTECTED;
            case 4:
                return KVisibility.PUBLIC;
            case 5:
                return KVisibility.PRIVATE;
            case 6:
                return null;
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
        }
    }

    private static final MutableCollectionKClass<?> toMutableCollectionKClass(KmClassifier kmClassifier, KClassifier kClassifier) {
        String name;
        ClassId classId;
        KmClassifier.Class r2 = kmClassifier instanceof KmClassifier.Class ? (KmClassifier.Class) kmClassifier : null;
        if (r2 == null || (name = r2.getName()) == null || (classId = toClassId(name)) == null || !JavaToKotlinClassMap.INSTANCE.isMutable(classId)) {
            return null;
        }
        FqName fqNameAsSingleFqName = classId.asSingleFqName();
        kClassifier.getClass();
        return MutableCollectionKClassKt.getMutableCollectionKClass(fqNameAsSingleFqName, (KClass) kClassifier);
    }

    public static final String toNonLocalSimpleName(String str) {
        str.getClass();
        if (!StringsKt.startsWith$default(str, ".")) {
            return StringsKt__StringsKt.substringAfterLast$default(StringsKt__StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null), '.', (String) null, 2, (Object) null);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) "Local class is not supported: ".concat(str));
        return null;
    }

    private static final SimpleKType unwrapSuspendFunctionType(SimpleKType simpleKType, Function0<? extends Type> function0) {
        KType type;
        KTypeProjection kTypeProjection;
        KType type2;
        if (!simpleKType.getIsSuspendFunctionType()) {
            Utf8$$ExternalSyntheticBUOutline0.m$4("Not a suspend function type: ", simpleKType);
            return null;
        }
        KTypeProjection kTypeProjection2 = (KTypeProjection) CollectionsKt.getOrNull(simpleKType.getArguments(), simpleKType.getArguments().size() - 2);
        if (kTypeProjection2 == null || (type = kTypeProjection2.getType()) == null || !Intrinsics.areEqual(type.getClassifier(), Reflection.getOrCreateKotlinClass(Continuation.class)) || (kTypeProjection = (KTypeProjection) CollectionsKt.singleOrNull((List) type.getArguments())) == null || (type2 = kTypeProjection.getType()) == null) {
            return null;
        }
        return new SimpleKType(simpleKType.getClassifier(), CollectionsKt.plus((Collection<? extends KTypeProjection>) CollectionsKt.dropLast(simpleKType.getArguments(), 2), KTypeProjection.INSTANCE.invariant(type2)), simpleKType.getIsMarkedNullable(), simpleKType.getAnnotations(), simpleKType.getAbbreviation(), simpleKType.getIsDefinitelyNotNullType(), simpleKType.getIsNothingType(), true, simpleKType.getMutableCollectionClass(), function0);
    }
}
