package kotlin.reflect.jvm.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmExtensionsKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\b \u0018\u0000 H2\u00020\u0001:\u0002GHB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\t2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH&J\u001c\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010%2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'J\u0016\u0010(\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010&\u001a\u00020'J\u0016\u0010)\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010&\u001a\u00020'J\u0016\u0010*\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010&\u001a\u00020'J\u0016\u0010+\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010&\u001a\u00020'J\u000e\u0010,\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'JE\u0010-\u001a\u0004\u0018\u00010.*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0018\u001a\u00020'2\u0010\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005002\n\u00101\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u00102\u001a\u000203H\u0002¢\u0006\u0002\u00104J=\u00105\u001a\u0004\u0018\u00010.*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0018\u001a\u00020'2\u0010\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005002\n\u00101\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0002\u00106J(\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u000108*\u0006\u0012\u0002\b\u00030\u00052\u0010\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000509H\u0002J\u0018\u0010:\u001a\u0004\u0018\u00010.2\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010;\u001a\u00020'J(\u0010<\u001a\u0004\u0018\u00010.2\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010;\u001a\u00020'2\u0006\u0010=\u001a\u0002032\u0006\u0010>\u001a\u000203J\u0014\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u0001082\u0006\u0010;\u001a\u00020'J\u0014\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u0001082\u0006\u0010;\u001a\u00020'J<\u0010A\u001a\u00020B2\u0010\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050D2\u0010\u0010E\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005092\u0006\u0010F\u001a\u0002032\u0006\u0010>\u001a\u000203H\u0002R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\fR\u0014\u0010 \u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006I"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "<init>", "()V", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "functionsMetadata", "", "Lkotlin/reflect/jvm/internal/impl/km/KmFunction;", "getFunctionsMetadata", "()Ljava/util/Collection;", "propertiesMetadata", "Lkotlin/reflect/jvm/internal/impl/km/KmProperty;", "getPropertiesMetadata", "constructorsMetadata", "Lkotlin/reflect/jvm/internal/impl/km/KmConstructor;", "getConstructorsMetadata", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalPropertyDescriptor", "index", "", "getLocalPropertyMetadata", "classLoader", "Ljava/lang/ClassLoader;", "getClassLoader", "()Ljava/lang/ClassLoader;", "createLocalProperty", "Lkotlin/reflect/KProperty0;", "signature", "", "findPropertyMetadata", "findPropertyDescriptor", "findFunctionMetadata", "findFunctionDescriptor", "findConstructorMetadata", "lookupMethod", "Ljava/lang/reflect/Method;", "parameterTypes", "", "returnType", "isStaticDefault", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "tryGetConstructor", "Ljava/lang/reflect/Constructor;", "", "findMethodBySignature", "desc", "findDefaultMethod", "isMember", "hasExtensionParameter", "findConstructorBySignature", "findDefaultConstructor", "addParametersAndMasks", "", "result", "", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "isConstructor", "Data", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = DefaultConstructorMarker.class;
    public static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public abstract class Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new PropertyReference1Impl(Data.class, "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", 0)};

        /* JADX INFO: renamed from: moduleData$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal moduleData;

        public Data() {
            this.moduleData = ReflectProperties.lazySoft(new Function0(KDeclarationContainerImpl.this) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$Data$$Lambda$0
                private final KDeclarationContainerImpl arg$0;

                {
                    this.arg$0 = kDeclarationContainerImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KDeclarationContainerImpl.Data.moduleData_delegate$lambda$0(this.arg$0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final RuntimeModuleData moduleData_delegate$lambda$0(KDeclarationContainerImpl kDeclarationContainerImpl) {
            return ModuleByClassLoaderKt.getOrCreateModule(kDeclarationContainerImpl.getJClass());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final RuntimeModuleData getModuleData() {
            T value = this.moduleData.getValue(this, $$delegatedProperties[0]);
            value.getClass();
            return (RuntimeModuleData) value;
        }
    }

    private final void addParametersAndMasks(List<Class<?>> result, List<? extends Class<?>> parameters, boolean isConstructor, boolean hasExtensionParameter) {
        if (Intrinsics.areEqual(CollectionsKt.lastOrNull((List) parameters), DEFAULT_CONSTRUCTOR_MARKER)) {
            parameters = parameters.subList(0, parameters.size() - 1);
        }
        int size = parameters.size();
        if (hasExtensionParameter) {
            size--;
        }
        result.addAll(parameters);
        int i = (size + 31) / 32;
        for (int i2 = 0; i2 < i; i2++) {
            Class<?> cls = Integer.TYPE;
            cls.getClass();
            result.add(cls);
        }
        Class cls2 = isConstructor ? DEFAULT_CONSTRUCTOR_MARKER : Object.class;
        cls2.getClass();
        result.add(cls2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence findConstructorMetadata$lambda$1(KmConstructor kmConstructor) {
        kmConstructor.getClass();
        return String.valueOf(JvmExtensionsKt.getSignature(kmConstructor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence findFunctionDescriptor$lambda$1(FunctionDescriptor functionDescriptor) {
        functionDescriptor.getClass();
        return DescriptorRenderer.DEBUG_TEXT.render(functionDescriptor) + " | " + RuntimeTypeMapper.INSTANCE.mapSignature(functionDescriptor).get_signature();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence findFunctionMetadata$lambda$2(KmFunction kmFunction) {
        kmFunction.getClass();
        return kmFunction.getName() + " | " + JvmExtensionsKt.getSignature(kmFunction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findPropertyDescriptor$lambda$2(DescriptorVisibility descriptorVisibility, DescriptorVisibility descriptorVisibility2) {
        Integer numCompare = DescriptorVisibilities.compare(descriptorVisibility, descriptorVisibility2);
        if (numCompare != null) {
            return numCompare.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findPropertyDescriptor$lambda$3(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence findPropertyDescriptor$lambda$4(PropertyDescriptor propertyDescriptor) {
        propertyDescriptor.getClass();
        return DescriptorRenderer.DEBUG_TEXT.render(propertyDescriptor) + " | " + RuntimeTypeMapper.INSTANCE.mapPropertySignature(propertyDescriptor).getString();
    }

    private final ClassLoader getClassLoader() {
        return ReflectClassUtilKt.getSafeClassLoader(getJClass());
    }

    private final Method lookupMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        KDeclarationContainerImpl kDeclarationContainerImpl;
        String str2;
        Class<?>[] clsArr2;
        Class<?> cls3;
        boolean z2;
        Class<?> clsTryLoadClass;
        if (z) {
            clsArr[0] = cls;
        }
        Method methodTryGetMethod = tryGetMethod(cls, str, clsArr, cls2);
        if (methodTryGetMethod != null) {
            return methodTryGetMethod;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            Method methodLookupMethod = lookupMethod(superclass, str, clsArr, cls2, z);
            kDeclarationContainerImpl = this;
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z2 = z;
            if (methodLookupMethod != null) {
                return methodLookupMethod;
            }
        } else {
            kDeclarationContainerImpl = this;
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z2 = z;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        interfaces.getClass();
        for (Class<?> cls4 : interfaces) {
            cls4.getClass();
            Method methodLookupMethod2 = kDeclarationContainerImpl.lookupMethod(cls4, str2, clsArr2, cls3, z2);
            if (methodLookupMethod2 != null) {
                return methodLookupMethod2;
            }
            if (z2 && (clsTryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(cls4), cls4.getName().concat("$DefaultImpls"))) != null) {
                clsArr2[0] = cls4;
                Method methodTryGetMethod2 = kDeclarationContainerImpl.tryGetMethod(clsTryLoadClass, str2, clsArr2, cls3);
                if (methodTryGetMethod2 != null) {
                    return methodTryGetMethod2;
                }
            }
        }
        return null;
    }

    private final Constructor<?> tryGetConstructor(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Class[] clsArr = (Class[]) list.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final Method tryGetMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (Intrinsics.areEqual(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            declaredMethods.getClass();
            for (Method method : declaredMethods) {
                if (Intrinsics.areEqual(method.getName(), str) && Intrinsics.areEqual(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
        } catch (NoSuchMethodException unused) {
        }
        return null;
    }

    public final KProperty0<?> createLocalProperty(int index, String signature) {
        signature.getClass();
        KmProperty localPropertyMetadata = getLocalPropertyMetadata(index);
        if (localPropertyMetadata == null) {
            return null;
        }
        if (localPropertyMetadata.getReceiverParameterType() == null) {
            return Attributes.isVar(localPropertyMetadata) ? new KotlinKMutableProperty0(this, signature, null, localPropertyMetadata) : new KotlinKProperty0(this, signature, null, localPropertyMetadata);
        }
        throw new KotlinReflectionInternalError("Local property " + localPropertyMetadata.getName() + " is an extension, which is not yet supported");
    }

    public final Constructor<?> findConstructorBySignature(String desc) {
        desc.getClass();
        return tryGetConstructor(getJClass(), UtilKt.parseAndLoadDescriptor(getClassLoader(), desc, false).getParameters());
    }

    public final KmConstructor findConstructorMetadata(String signature) {
        signature.getClass();
        Collection<KmConstructor> constructorsMetadata = getConstructorsMetadata();
        ArrayList arrayList = new ArrayList();
        for (Object obj : constructorsMetadata) {
            if (Intrinsics.areEqual(String.valueOf(JvmExtensionsKt.getSignature((KmConstructor) obj)), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (KmConstructor) CollectionsKt.single((List) arrayList);
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(getConstructorsMetadata(), "\n", null, null, new Function1() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$5
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj2) {
                return KDeclarationContainerImpl.findConstructorMetadata$lambda$1((KmConstructor) obj2);
            }
        }, 30);
        StringBuilder sb = new StringBuilder("Constructor (JVM signature: ");
        sb.append(signature);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(':');
        sb.append(strJoinToString$default.length() == 0 ? " no constructors found" : " several matching constructors found:\n".concat(strJoinToString$default));
        throw new KotlinReflectionInternalError(sb.toString());
    }

    public final Constructor<?> findDefaultConstructor(String desc) {
        desc.getClass();
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        addParametersAndMasks(arrayList, UtilKt.parseAndLoadDescriptor(getClassLoader(), desc, false).getParameters(), true, false);
        Unit unit = Unit.INSTANCE;
        return tryGetConstructor(jClass, arrayList);
    }

    public final Method findDefaultMethod(String name, String desc, boolean isMember, boolean hasExtensionParameter) {
        name.getClass();
        desc.getClass();
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (isMember) {
            arrayList.add(getJClass());
        }
        FunctionJvmDescriptorLoaded andLoadDescriptor = UtilKt.parseAndLoadDescriptor(getClassLoader(), desc, true);
        addParametersAndMasks(arrayList, andLoadDescriptor.getParameters(), false, hasExtensionParameter);
        Class<?> methodOwner = getMethodOwner();
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(name, "$default");
        Class<?>[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        Class<?> returnType = andLoadDescriptor.getReturnType();
        returnType.getClass();
        return lookupMethod(methodOwner, strM$1, clsArr, returnType, isMember);
    }

    public final FunctionDescriptor findFunctionDescriptor(String name, String signature) {
        List functions;
        name.getClass();
        signature.getClass();
        if (Intrinsics.areEqual(name, "<init>")) {
            functions = CollectionsKt.toList(getConstructorDescriptors());
        } else {
            Name nameIdentifier = Name.identifier(name);
            nameIdentifier.getClass();
            functions = getFunctions(nameIdentifier);
        }
        Collection<FunctionDescriptor> collection = functions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) obj).get_signature(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (FunctionDescriptor) CollectionsKt.single((List) arrayList);
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(collection, "\n", null, null, new Function1() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj2) {
                return KDeclarationContainerImpl.findFunctionDescriptor$lambda$1((FunctionDescriptor) obj2);
            }
        }, 30);
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Function '", name, "' (JVM signature: ", signature, ") not resolved in ");
        sbM6m.append(this);
        sbM6m.append(':');
        sbM6m.append(strJoinToString$default.length() == 0 ? " no members found" : "\n".concat(strJoinToString$default));
        throw new KotlinReflectionInternalError(sbM6m.toString());
    }

    public final KmFunction findFunctionMetadata(String name, String signature) {
        name.getClass();
        signature.getClass();
        if (!(this instanceof KPackageImpl)) {
            StringBuilder sb = new StringBuilder("Only top-level functions are supported for now: ");
            sb.append(this);
            sb.append('/');
            sb.append(name);
            sb.append(" (");
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m(sb, signature, ')'));
            return null;
        }
        KPackageImpl kPackageImpl = (KPackageImpl) this;
        Collection<KmFunction> functionsMetadata = kPackageImpl.getFunctionsMetadata();
        ArrayList arrayList = new ArrayList();
        for (Object obj : functionsMetadata) {
            KmFunction kmFunction = (KmFunction) obj;
            if (Intrinsics.areEqual(kmFunction.getName(), name) && Intrinsics.areEqual(String.valueOf(JvmExtensionsKt.getSignature(kmFunction)), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (KmFunction) CollectionsKt.single((List) arrayList);
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(kPackageImpl.getFunctionsMetadata(), "\n", null, null, new Function1() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$3
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj2) {
                return KDeclarationContainerImpl.findFunctionMetadata$lambda$2((KmFunction) obj2);
            }
        }, 30);
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Function '", name, "' (JVM signature: ", signature, ") not resolved in ");
        sbM6m.append(this);
        sbM6m.append(':');
        sbM6m.append(strJoinToString$default.length() == 0 ? " no members found" : " several matching members found:\n".concat(strJoinToString$default));
        throw new KotlinReflectionInternalError(sbM6m.toString());
    }

    public final Method findMethodBySignature(String name, String desc) {
        Method methodLookupMethod;
        name.getClass();
        desc.getClass();
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        FunctionJvmDescriptorLoaded andLoadDescriptor = UtilKt.parseAndLoadDescriptor(getClassLoader(), desc, true);
        Class<?>[] clsArr = (Class[]) andLoadDescriptor.getParameters().toArray(new Class[0]);
        Class<?> returnType = andLoadDescriptor.getReturnType();
        returnType.getClass();
        Method methodLookupMethod2 = lookupMethod(getMethodOwner(), name, clsArr, returnType, false);
        if (methodLookupMethod2 != null) {
            return methodLookupMethod2;
        }
        if (!getMethodOwner().isInterface() || (methodLookupMethod = lookupMethod(Object.class, name, clsArr, returnType, false)) == null) {
            return null;
        }
        return methodLookupMethod;
    }

    public final PropertyDescriptor findPropertyDescriptor(String name, String signature) {
        name.getClass();
        signature.getClass();
        MatchResult matchResultMatchEntire = LOCAL_PROPERTY_SIGNATURE.matchEntire(signature);
        if (matchResultMatchEntire != null) {
            String str = matchResultMatchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localPropertyDescriptor = getLocalPropertyDescriptor(Integer.parseInt(str));
            if (localPropertyDescriptor != null) {
                return localPropertyDescriptor;
            }
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Local property #", str, " not found in ");
            sbM5m.append(getJClass());
            throw new KotlinReflectionInternalError(sbM5m.toString());
        }
        Name nameIdentifier = Name.identifier(name);
        nameIdentifier.getClass();
        Collection<PropertyDescriptor> properties = getProperties(nameIdentifier);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties) {
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) obj).getString(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Property '", name, "' (JVM signature: ", signature, ") not resolved in ");
            sbM6m.append(this);
            throw new KotlinReflectionInternalError(sbM6m.toString());
        }
        if (arrayList.size() == 1) {
            return (PropertyDescriptor) CollectionsKt.single((List) arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            DescriptorVisibility visibility = ((PropertyDescriptor) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        final KDeclarationContainerImpl$$Lambda$0 kDeclarationContainerImpl$$Lambda$0 = new Function2() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$0
            @Override // kotlin.jvm.functions.Function2
            public Object invoke(Object obj3, Object obj4) {
                return Integer.valueOf(KDeclarationContainerImpl.findPropertyDescriptor$lambda$2((DescriptorVisibility) obj3, (DescriptorVisibility) obj4));
            }
        };
        Collection collectionValues = MapsKt.toSortedMap(linkedHashMap, new Comparator(kDeclarationContainerImpl$$Lambda$0) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$1
            private final Function2 arg$0;

            {
                this.arg$0 = kDeclarationContainerImpl$$Lambda$0;
            }

            @Override // java.util.Comparator
            public int compare(Object obj3, Object obj4) {
                return KDeclarationContainerImpl.findPropertyDescriptor$lambda$3(this.arg$0, obj3, obj4);
            }
        }).values();
        collectionValues.getClass();
        List list = (List) CollectionsKt.last(collectionValues);
        if (list.size() == 1) {
            return (PropertyDescriptor) CollectionsKt.first(list);
        }
        Name nameIdentifier2 = Name.identifier(name);
        nameIdentifier2.getClass();
        String strJoinToString$default = CollectionsKt.joinToString$default(getProperties(nameIdentifier2), "\n", null, null, new Function1() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj3) {
                return KDeclarationContainerImpl.findPropertyDescriptor$lambda$4((PropertyDescriptor) obj3);
            }
        }, 30);
        StringBuilder sbM6m2 = FileInsert$$ExternalSyntheticOutline0.m6m("Property '", name, "' (JVM signature: ", signature, ") not resolved in ");
        sbM6m2.append(this);
        sbM6m2.append(':');
        sbM6m2.append(strJoinToString$default.length() == 0 ? " no members found" : "\n".concat(strJoinToString$default));
        throw new KotlinReflectionInternalError(sbM6m2.toString());
    }

    public final KmProperty findPropertyMetadata(String name, String signature) {
        name.getClass();
        signature.getClass();
        if (!(this instanceof KPackageImpl)) {
            StringBuilder sb = new StringBuilder("Only top-level properties are supported for now: ");
            sb.append(this);
            sb.append('/');
            sb.append(name);
            sb.append(" (");
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m(sb, signature, ')'));
            return null;
        }
        Collection<KmProperty> propertiesMetadata = ((KPackageImpl) this).getPropertiesMetadata();
        ArrayList arrayList = new ArrayList();
        for (Object obj : propertiesMetadata) {
            KmProperty kmProperty = (KmProperty) obj;
            if (Intrinsics.areEqual(kmProperty.getName(), name) && Intrinsics.areEqual(ConvertFromMetadataKt.computeJvmSignature(kmProperty, this), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Property '", name, "' (JVM signature: ", signature, ") not resolved in ");
            sbM6m.append(this);
            throw new KotlinReflectionInternalError(sbM6m.toString());
        }
        if (arrayList.size() <= 1) {
            return (KmProperty) CollectionsKt.single((List) arrayList);
        }
        StringBuilder sbM6m2 = FileInsert$$ExternalSyntheticOutline0.m6m("Property '", name, "' (JVM signature: ", signature, ") resolved in several methods in ");
        sbM6m2.append(this);
        throw new KotlinReflectionInternalError(sbM6m2.toString());
    }

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<KmConstructor> getConstructorsMetadata();

    public abstract Collection<FunctionDescriptor> getFunctions(Name name);

    public abstract PropertyDescriptor getLocalPropertyDescriptor(int index);

    public abstract KmProperty getLocalPropertyMetadata(int index);

    public Class<?> getMethodOwner() {
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive == null ? getJClass() : wrapperByPrimitive;
    }

    public abstract Collection<PropertyDescriptor> getProperties(Name name);
}
