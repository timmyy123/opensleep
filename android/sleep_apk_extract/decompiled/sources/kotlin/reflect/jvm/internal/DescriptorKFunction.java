package kotlin.reflect.jvm.internal;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KotlinGenericDeclarationKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.types.DescriptorKType;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u001e\n\u0002\b\f\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0002B=\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0012B+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J#\u0010-\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010(\u001a\u00020'2\u0006\u0010+\u001a\u00020\u001cH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020/2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020/2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b2\u00101J5\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000303052\n\u0010(\u001a\u0006\u0012\u0002\b\u0003032\u0006\u0010\u0011\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001cH\u0002¢\u0006\u0004\b6\u00107R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u00108\u001a\u0004\b9\u0010:R\u001a\u0010\t\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010;\u001a\u0004\b<\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010\u0011\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001f\u0010H\u001a\u0006\u0012\u0002\b\u00030,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR!\u0010K\u001a\b\u0012\u0002\b\u0003\u0018\u00010,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bI\u0010E\u001a\u0004\bJ\u0010GR\u0014\u0010\b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010#R\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010!R\u0014\u0010S\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010TR\u0014\u0010V\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010W\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010TR\u0014\u0010X\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010T¨\u0006Y"}, d2 = {"Lkotlin/reflect/jvm/internal/DescriptorKFunction;", "Lkotlin/reflect/jvm/internal/DescriptorKCallable;", "", "Lkotlin/reflect/jvm/internal/ReflectKFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "name", "signature", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "descriptorInitialValue", "rawBoundReceiver", "Lkotlin/reflect/jvm/internal/KCallableOverriddenStorage;", "overriddenStorage", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;Lkotlin/reflect/jvm/internal/KCallableOverriddenStorage;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/reflect/jvm/internal/KCallableOverriddenStorage;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "shallowCopy$kotlin_reflection", "(Lkotlin/reflect/jvm/internal/KCallableOverriddenStorage;)Lkotlin/reflect/jvm/internal/DescriptorKFunction;", "shallowCopy", "Lkotlin/reflect/jvm/internal/types/DescriptorKType;", "computeReturnType", "()Lkotlin/reflect/jvm/internal/types/DescriptorKType;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "function", "getFunctionWithDefaultParametersForValueClassOverride", "(Lkotlin/reflect/jvm/internal/ReflectKFunction;)Lkotlin/reflect/jvm/internal/ReflectKFunction;", "Ljava/lang/reflect/Method;", "member", "useBoxedBoundReceiver", "(Ljava/lang/reflect/Method;)Z", "isCallByToValueClassMangledMethod", "Lkotlin/reflect/jvm/internal/calls/Caller;", "createStaticMethodCaller", "(Ljava/lang/reflect/Method;Z)Lkotlin/reflect/jvm/internal/calls/Caller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "createJvmStaticInObjectCaller", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "createInstanceMethodCaller", "Ljava/lang/reflect/Constructor;", "isDefault", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "createConstructorCaller", "(Ljava/lang/reflect/Constructor;Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;Z)Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Ljava/lang/String;", "getSignature", "Ljava/lang/Object;", "getRawBoundReceiver", "()Ljava/lang/Object;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "caller$delegate", "Lkotlin/Lazy;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "defaultCaller$delegate", "getDefaultCaller", "defaultCaller", "getName", "", "getOverridden", "()Ljava/util/Collection;", "overridden", "getArity", "arity", "isInline", "()Z", "isExternal", "isOperator", "isInfix", "isSuspend", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DescriptorKFunction extends DescriptorKCallable<Object> implements FunctionBase<Object>, Function0, Function1, Function10, Function11, Function12, Function13, Function14, Function15, Function16, Function17, Function18, Function19, Function2, Function20, Function21, Function22, Function3, Function4, Function5, Function6, Function7, Function8, Function9, KCallable, ReflectKFunction {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new PropertyReference1Impl(DescriptorKFunction.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", 0)};

    /* JADX INFO: renamed from: caller$delegate, reason: from kotlin metadata */
    private final Lazy caller;
    private final KDeclarationContainerImpl container;

    /* JADX INFO: renamed from: defaultCaller$delegate, reason: from kotlin metadata */
    private final Lazy defaultCaller;

    /* JADX INFO: renamed from: descriptor$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal descriptor;
    private final Object rawBoundReceiver;
    private final String signature;

    private DescriptorKFunction(KDeclarationContainerImpl kDeclarationContainerImpl, final String str, String str2, FunctionDescriptor functionDescriptor, Object obj, KCallableOverriddenStorage kCallableOverriddenStorage) {
        super(kCallableOverriddenStorage);
        this.container = kDeclarationContainerImpl;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this.descriptor = ReflectProperties.lazySoft(functionDescriptor, new Function0(this, str) { // from class: kotlin.reflect.jvm.internal.DescriptorKFunction$$Lambda$0
            private final DescriptorKFunction arg$0;
            private final String arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKFunction.descriptor_delegate$lambda$0(this.arg$0, this.arg$1);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.caller = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.DescriptorKFunction$$Lambda$1
            private final DescriptorKFunction arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKFunction.caller_delegate$lambda$0(this.arg$0);
            }
        });
        this.defaultCaller = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.DescriptorKFunction$$Lambda$2
            private final DescriptorKFunction arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKFunction.defaultCaller_delegate$lambda$0(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Caller caller_delegate$lambda$0(DescriptorKFunction descriptorKFunction) {
        Object constructor;
        Caller<?> callerCreateInstanceMethodCaller;
        JvmFunctionSignature jvmFunctionSignatureMapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(descriptorKFunction.getDescriptor());
        if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (ReflectKCallableKt.isAnnotationConstructor(descriptorKFunction)) {
                Class<?> jClass = descriptorKFunction.getContainer().getJClass();
                List<KParameter> parameters = descriptorKFunction.getParameters();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((KParameter) it.next()).getName();
                    name.getClass();
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            constructor = descriptorKFunction.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor) jvmFunctionSignatureMapSignature).getConstructorDesc());
        } else if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) jvmFunctionSignatureMapSignature;
            constructor = descriptorKFunction.getContainer().findMethodBySignature(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc());
        } else if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.JavaMethod) {
            constructor = ((JvmFunctionSignature.JavaMethod) jvmFunctionSignatureMapSignature).getMethod();
            constructor.getClass();
        } else {
            if (!(jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.JavaConstructor)) {
                if (!(jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor)) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) jvmFunctionSignatureMapSignature).getMethods();
                Class<?> jClass2 = descriptorKFunction.getContainer().getJClass();
                List<Method> list = methods;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Method) it2.next()).getName());
                }
                return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, methods);
            }
            constructor = ((JvmFunctionSignature.JavaConstructor) jvmFunctionSignatureMapSignature).getConstructor();
            constructor.getClass();
        }
        if (constructor instanceof Constructor) {
            callerCreateInstanceMethodCaller = descriptorKFunction.createConstructorCaller((Constructor) constructor, descriptorKFunction.getDescriptor(), false);
        } else {
            if (!(constructor instanceof Method)) {
                Events$$ExternalSyntheticBUOutline0.m$3("Could not compute caller for function: ", descriptorKFunction.getDescriptor(), " (member = ", constructor);
                return null;
            }
            Method method = (Method) constructor;
            callerCreateInstanceMethodCaller = !Modifier.isStatic(method.getModifiers()) ? descriptorKFunction.createInstanceMethodCaller(method) : descriptorKFunction.getDescriptor().getAnnotations().mo2472findAnnotation(UtilKt.getJVM_STATIC()) != null ? descriptorKFunction.createJvmStaticInObjectCaller(method) : descriptorKFunction.createStaticMethodCaller(method, false);
        }
        return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(callerCreateInstanceMethodCaller, descriptorKFunction, false, CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type computeReturnType$lambda$0(DescriptorKFunction descriptorKFunction) {
        Type typeExtractContinuationArgument = ReflectKFunctionKt.extractContinuationArgument(descriptorKFunction);
        return typeExtractContinuationArgument == null ? descriptorKFunction.getCaller().getReturnType() : typeExtractContinuationArgument;
    }

    private final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> member, FunctionDescriptor descriptor, boolean isDefault) {
        return (isDefault || !InlineClassManglingRulesKt.shouldHideConstructorDueToValueClassTypeValueParameters(descriptor)) ? ReflectKCallableKt.isBound(this) ? new CallerImpl.BoundConstructor(member, ReflectKCallableKt.getBoundReceiver(this)) : new CallerImpl.Constructor(member) : ReflectKCallableKt.isBound(this) ? new CallerImpl.AccessorForHiddenBoundConstructor(member, ReflectKCallableKt.getBoundReceiver(this)) : new CallerImpl.AccessorForHiddenConstructor(member);
    }

    private final CallerImpl.Method createInstanceMethodCaller(Method member) {
        return ReflectKCallableKt.isBound(this) ? new CallerImpl.Method.BoundInstance(member, ReflectKCallableKt.getBoundReceiver(this)) : new CallerImpl.Method.Instance(member);
    }

    private final CallerImpl.Method createJvmStaticInObjectCaller(Method member) {
        return ReflectKCallableKt.isBound(this) ? new CallerImpl.Method.BoundJvmStaticInObject(member) : new CallerImpl.Method.JvmStaticInObject(member);
    }

    private final Caller<?> createStaticMethodCaller(Method member, boolean isCallByToValueClassMangledMethod) {
        if (ReflectKCallableKt.isBound(this)) {
            return new CallerImpl.Method.BoundStatic(member, isCallByToValueClassMangledMethod, useBoxedBoundReceiver(member) ? getRawBoundReceiver() : ReflectKCallableKt.getBoundReceiver(this));
        }
        return new CallerImpl.Method.Static(member);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Caller defaultCaller_delegate$lambda$0(DescriptorKFunction descriptorKFunction) {
        GenericDeclaration genericDeclarationFindDefaultConstructor;
        Caller<?> callerCreateJvmStaticInObjectCaller;
        ArrayList arrayList = new ArrayList();
        JvmFunctionSignature jvmFunctionSignatureMapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(descriptorKFunction.getDescriptor());
        if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            ReflectKFunction functionWithDefaultParametersForValueClassOverride = descriptorKFunction.getFunctionWithDefaultParametersForValueClassOverride(descriptorKFunction);
            if (functionWithDefaultParametersForValueClassOverride != null) {
                String strSubstringBefore$default = StringsKt__StringsKt.substringBefore$default(functionWithDefaultParametersForValueClassOverride.getSignature(), '(', (String) null, 2, (Object) null);
                DescriptorPatchingResult descriptorPatchingResultPatchJvmDescriptorByExtraBoxing = ReflectKFunctionKt.patchJvmDescriptorByExtraBoxing(functionWithDefaultParametersForValueClassOverride, functionWithDefaultParametersForValueClassOverride.getSignature().substring(strSubstringBefore$default.length()));
                arrayList.addAll(descriptorPatchingResultPatchJvmDescriptorByExtraBoxing.getBoxedIndices());
                genericDeclarationFindDefaultConstructor = descriptorKFunction.getContainer().findDefaultMethod(strSubstringBefore$default, descriptorPatchingResultPatchJvmDescriptorByExtraBoxing.getNewDescriptor(), true, descriptorKFunction.getDescriptor().getExtensionReceiverParameter() != null);
            } else {
                JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) jvmFunctionSignatureMapSignature;
                DescriptorPatchingResult descriptorPatchingResultPatchJvmDescriptorByExtraBoxing2 = ReflectKFunctionKt.patchJvmDescriptorByExtraBoxing(descriptorKFunction, kotlinFunction.getMethodDesc());
                arrayList.addAll(descriptorPatchingResultPatchJvmDescriptorByExtraBoxing2.getBoxedIndices());
                KDeclarationContainerImpl container = descriptorKFunction.getContainer();
                String methodName = kotlinFunction.getMethodName();
                String newDescriptor = descriptorPatchingResultPatchJvmDescriptorByExtraBoxing2.getNewDescriptor();
                descriptorKFunction.getCaller().mo2469getMember().getClass();
                genericDeclarationFindDefaultConstructor = container.findDefaultMethod(methodName, newDescriptor, !Modifier.isStatic(r7.getModifiers()), descriptorKFunction.getDescriptor().getExtensionReceiverParameter() != null);
            }
        } else if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (ReflectKCallableKt.isAnnotationConstructor(descriptorKFunction)) {
                Class<?> jClass = descriptorKFunction.getContainer().getJClass();
                List<KParameter> parameters = descriptorKFunction.getParameters();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((KParameter) it.next()).getName();
                    name.getClass();
                    arrayList2.add(name);
                }
                return new AnnotationConstructorCaller(jClass, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            DescriptorPatchingResult descriptorPatchingResultPatchJvmDescriptorByExtraBoxing3 = ReflectKFunctionKt.patchJvmDescriptorByExtraBoxing(descriptorKFunction, ((JvmFunctionSignature.KotlinConstructor) jvmFunctionSignatureMapSignature).getConstructorDesc());
            arrayList.addAll(descriptorPatchingResultPatchJvmDescriptorByExtraBoxing3.getBoxedIndices());
            genericDeclarationFindDefaultConstructor = descriptorKFunction.getContainer().findDefaultConstructor(descriptorPatchingResultPatchJvmDescriptorByExtraBoxing3.getNewDescriptor());
        } else {
            if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) jvmFunctionSignatureMapSignature).getMethods();
                Class<?> jClass2 = descriptorKFunction.getContainer().getJClass();
                List<Method> list = methods;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((Method) it2.next()).getName());
                }
                return new AnnotationConstructorCaller(jClass2, arrayList3, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, methods);
            }
            genericDeclarationFindDefaultConstructor = null;
        }
        if (genericDeclarationFindDefaultConstructor instanceof Constructor) {
            callerCreateJvmStaticInObjectCaller = descriptorKFunction.createConstructorCaller((Constructor) genericDeclarationFindDefaultConstructor, descriptorKFunction.getDescriptor(), true);
        } else if (!(genericDeclarationFindDefaultConstructor instanceof Method)) {
            callerCreateJvmStaticInObjectCaller = null;
        } else if (descriptorKFunction.getDescriptor().getAnnotations().mo2472findAnnotation(UtilKt.getJVM_STATIC()) != null) {
            DeclarationDescriptor containingDeclaration = descriptorKFunction.getDescriptor().getContainingDeclaration();
            containingDeclaration.getClass();
            callerCreateJvmStaticInObjectCaller = !((ClassDescriptor) containingDeclaration).isCompanionObject() ? descriptorKFunction.createJvmStaticInObjectCaller((Method) genericDeclarationFindDefaultConstructor) : descriptorKFunction.createStaticMethodCaller((Method) genericDeclarationFindDefaultConstructor, descriptorKFunction.getCaller().isBoundInstanceCallWithValueClasses());
        }
        if (callerCreateJvmStaticInObjectCaller != null) {
            return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(callerCreateJvmStaticInObjectCaller, descriptorKFunction, true, arrayList);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FunctionDescriptor descriptor_delegate$lambda$0(DescriptorKFunction descriptorKFunction, String str) {
        return descriptorKFunction.getContainer().findFunctionDescriptor(str, descriptorKFunction.getSignature());
    }

    private final ReflectKFunction getFunctionWithDefaultParametersForValueClassOverride(ReflectKFunction function) {
        List<KParameter> valueParameters = KCallables.getValueParameters(function);
        Object obj = null;
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            for (KParameter kParameter : valueParameters) {
                ReflectKParameter reflectKParameter = kParameter instanceof ReflectKParameter ? (ReflectKParameter) kParameter : null;
                if (reflectKParameter != null && reflectKParameter.getDeclaresDefaultValue()) {
                    return null;
                }
            }
        }
        ClassBasedDeclarationContainer container = function.getContainer();
        KClass kClass = container instanceof KClass ? (KClass) container : null;
        if (kClass == null || !kClass.isValue()) {
            return null;
        }
        Member memberMo2469getMember = getCaller().mo2469getMember();
        memberMo2469getMember.getClass();
        if (!Modifier.isStatic(memberMo2469getMember.getModifiers())) {
            return null;
        }
        Iterator<T> it = function.getOverridden().iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            List<KParameter> valueParameters2 = KCallables.getValueParameters((ReflectKFunction) next);
            if (!(valueParameters2 instanceof Collection) || !valueParameters2.isEmpty()) {
                for (KParameter kParameter2 : valueParameters2) {
                    ReflectKParameter reflectKParameter2 = kParameter2 instanceof ReflectKParameter ? (ReflectKParameter) kParameter2 : null;
                    if (reflectKParameter2 != null && reflectKParameter2.getDeclaresDefaultValue()) {
                        obj = next;
                        break loop0;
                    }
                }
            }
        }
        return (ReflectKFunction) obj;
    }

    private final boolean useBoxedBoundReceiver(Method member) {
        KotlinType type;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDescriptor().getDispatchReceiverParameter();
        if (dispatchReceiverParameter == null || (type = dispatchReceiverParameter.getType()) == null || !InlineClassesUtilsKt.isInlineClassType(type)) {
            return false;
        }
        Class<?>[] parameterTypes = member.getParameterTypes();
        parameterTypes.getClass();
        Class cls = (Class) ArraysKt.firstOrNull(parameterTypes);
        return cls != null && cls.isInterface();
    }

    @Override // kotlin.reflect.jvm.internal.DescriptorKCallable
    public DescriptorKType computeReturnType() {
        KotlinType returnType = getDescriptor().getReturnType();
        returnType.getClass();
        return new DescriptorKType(returnType, new Function0(this) { // from class: kotlin.reflect.jvm.internal.DescriptorKFunction$$Lambda$3
            private final DescriptorKFunction arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKFunction.computeReturnType$lambda$0(this.arg$0);
            }
        });
    }

    public GenericDeclaration default$findJavaDeclaration() {
        return KotlinGenericDeclarationKt.findMethodBySignature(getContainer(), getSignature());
    }

    public Object default$invoke(Object obj) {
        return call(obj);
    }

    public boolean equals(Object other) {
        ReflectKFunction reflectKFunctionAsReflectFunction = UtilKt.asReflectFunction(other);
        return reflectKFunctionAsReflectFunction != null && Intrinsics.areEqual(getContainer(), reflectKFunctionAsReflectFunction.getContainer()) && Intrinsics.areEqual(getName(), reflectKFunctionAsReflectFunction.getName()) && Intrinsics.areEqual(getSignature(), reflectKFunctionAsReflectFunction.getSignature()) && Intrinsics.areEqual(getRawBoundReceiver(), reflectKFunctionAsReflectFunction.getRawBoundReceiver());
    }

    @Override // kotlin.jvm.internal.KotlinGenericDeclaration
    public /* bridge */ GenericDeclaration findJavaDeclaration() {
        return default$findJavaDeclaration();
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return CallerKt.getArity(getCaller());
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public Caller<?> getCaller() {
        return (Caller) this.caller.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public Caller<?> getDefaultCaller() {
        return (Caller) this.defaultCaller.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.DescriptorKCallable
    public FunctionDescriptor getDescriptor() {
        T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
        value.getClass();
        return (FunctionDescriptor) value;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        String strAsString = getDescriptor().getName().asString();
        strAsString.getClass();
        return strAsString;
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKFunction
    public Collection<ReflectKFunction> getOverridden() {
        Collection<? extends FunctionDescriptor> overriddenDescriptors = getDescriptor().getOverriddenDescriptors();
        overriddenDescriptors.getClass();
        Collection<? extends FunctionDescriptor> collection = overriddenDescriptors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        for (FunctionDescriptor functionDescriptor : collection) {
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            containingDeclaration.getClass();
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) containingDeclaration);
            if (javaClass == null) {
                Events$$ExternalSyntheticBUOutline0.m$1("Unknown container class for overridden function: ", this);
                return null;
            }
            KClass kotlinClass = JvmClassMappingKt.getKotlinClass(javaClass);
            kotlinClass.getClass();
            arrayList.add(new DescriptorKFunction((KClassImpl) kotlinClass, functionDescriptor, null, 4, null));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public Object getRawBoundReceiver() {
        return this.rawBoundReceiver;
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKFunction
    public String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ Object invoke() {
        return default$invoke();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getOverriddenStorage().getForceIsExternal() || getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getOverriddenStorage().getForceIsInfix() || getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getOverriddenStorage().getForceIsInline() || getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getOverriddenStorage().getForceIsOperator() || getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    @Override // kotlin.reflect.jvm.internal.DescriptorKCallable
    public DescriptorKCallable<Object> shallowCopy$kotlin_reflection(KCallableOverriddenStorage overriddenStorage) {
        overriddenStorage.getClass();
        return new DescriptorKFunction(getContainer(), getDescriptor(), overriddenStorage);
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(this);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ Object invoke(Object obj) {
        return default$invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ Object invoke(Object obj, Object obj2) {
        return default$invoke(obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ Object invoke(Object obj, Object obj2, Object obj3) {
        return default$invoke(obj, obj2, obj3);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return default$invoke(obj, obj2, obj3, obj4);
    }

    public Object default$invoke() {
        return call(new Object[0]);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return default$invoke(obj, obj2, obj3, obj4, obj5);
    }

    public Object default$invoke(Object obj, Object obj2) {
        return call(obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public Object default$invoke(Object obj, Object obj2, Object obj3) {
        return call(obj, obj2, obj3);
    }

    public Object default$invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return call(obj, obj2, obj3, obj4);
    }

    public Object default$invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return call(obj, obj2, obj3, obj4, obj5);
    }

    public Object default$invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return call(obj, obj2, obj3, obj4, obj5, obj6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DescriptorKFunction(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj, KCallableOverriddenStorage.INSTANCE.getEMPTY());
        kDeclarationContainerImpl.getClass();
        str.getClass();
        str2.getClass();
    }

    public /* synthetic */ DescriptorKFunction(KDeclarationContainerImpl kDeclarationContainerImpl, FunctionDescriptor functionDescriptor, KCallableOverriddenStorage kCallableOverriddenStorage, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kDeclarationContainerImpl, functionDescriptor, (i & 4) != 0 ? KCallableOverriddenStorage.INSTANCE.getEMPTY() : kCallableOverriddenStorage);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DescriptorKFunction(KDeclarationContainerImpl kDeclarationContainerImpl, FunctionDescriptor functionDescriptor, KCallableOverriddenStorage kCallableOverriddenStorage) {
        kDeclarationContainerImpl.getClass();
        functionDescriptor.getClass();
        kCallableOverriddenStorage.getClass();
        String strAsString = functionDescriptor.getName().asString();
        strAsString.getClass();
        this(kDeclarationContainerImpl, strAsString, RuntimeTypeMapper.INSTANCE.mapSignature(functionDescriptor).get_signature(), functionDescriptor, CallableReference.NO_RECEIVER, kCallableOverriddenStorage);
    }
}
