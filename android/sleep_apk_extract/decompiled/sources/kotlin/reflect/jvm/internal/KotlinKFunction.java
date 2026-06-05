package kotlin.reflect.jvm.internal;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
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
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KotlinGenericDeclarationKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KParameter;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0002B!\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\r*\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0!2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\r*\u0006\u0012\u0002\b\u00030(H\u0002¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010.\u001a\u0004\b/\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b1\u00102R!\u00109\u001a\b\u0012\u0004\u0012\u000204038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R!\u0010<\u001a\b\u0012\u0004\u0012\u000204038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108R\u001f\u0010@\u001a\u0006\u0012\u0002\b\u00030\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u00106\u001a\u0004\b>\u0010?R!\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bA\u00106\u001a\u0004\bB\u0010?R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020D038$X¤\u0004¢\u0006\u0006\u001a\u0004\bE\u00108R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020D038$X¤\u0004¢\u0006\u0006\u001a\u0004\bG\u00108R\u0014\u0010L\u001a\u00020I8$X¤\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020M038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u00108R\u0014\u0010Q\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0012R\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00030R8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010Y\u001a\u0004\u0018\u00010V8$X¤\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8$X¤\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\¨\u0006^"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinKFunction;", "Lkotlin/reflect/jvm/internal/KotlinKCallable;", "", "Lkotlin/reflect/jvm/internal/ReflectKFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "signature", "rawBoundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/Object;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "isInlineClass", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)Z", "Ljava/lang/reflect/Method;", "member", "useBoxedBoundReceiver", "(Ljava/lang/reflect/Method;)Z", "isCallByToValueClassMangledMethod", "Lkotlin/reflect/jvm/internal/calls/Caller;", "createStaticMethodCaller", "(Ljava/lang/reflect/Method;Z)Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Constructor;", "isDefault", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "createConstructorCaller", "(Ljava/lang/reflect/Constructor;Z)Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Lkotlin/reflect/jvm/internal/KotlinKConstructor;", "constructor", "shouldHideConstructorDueToValueClassTypeValueParameters", "(Lkotlin/reflect/jvm/internal/KotlinKConstructor;)Z", "Lkotlin/reflect/KClass;", "isValueClassThatRequiresMangling", "(Lkotlin/reflect/KClass;)Z", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Ljava/lang/String;", "getSignature", "Ljava/lang/Object;", "getRawBoundReceiver", "()Ljava/lang/Object;", "", "Lkotlin/reflect/KParameter;", "allParameters$delegate", "Lkotlin/Lazy;", "getAllParameters", "()Ljava/util/List;", "allParameters", "parameters$delegate", "getParameters", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "caller$delegate", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "defaultCaller$delegate", "getDefaultCaller", "defaultCaller", "Lkotlin/reflect/jvm/internal/impl/km/KmValueParameter;", "getContextParameters", "contextParameters", "getValueParameters", "valueParameters", "Lkotlin/reflect/jvm/internal/TypeParameterTable;", "getTypeParameterTable", "()Lkotlin/reflect/jvm/internal/TypeParameterTable;", "typeParameterTable", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters", "getArity", "arity", "", "getOverridden", "()Ljava/util/Collection;", "overridden", "Lkotlin/reflect/jvm/internal/impl/km/KmType;", "getExtensionReceiverType", "()Lkotlin/metadata/KmType;", "extensionReceiverType", "Lkotlin/reflect/jvm/internal/impl/km/jvm/JvmMethodSignature;", "getJvmSignature", "()Lkotlin/metadata/jvm/JvmMethodSignature;", "jvmSignature", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class KotlinKFunction extends KotlinKCallable<Object> implements FunctionBase<Object>, Function0, Function1, Function10, Function11, Function12, Function13, Function14, Function15, Function16, Function17, Function18, Function19, Function2, Function20, Function21, Function22, Function3, Function4, Function5, Function6, Function7, Function8, Function9, KCallable, ReflectKFunction {

    /* JADX INFO: renamed from: allParameters$delegate, reason: from kotlin metadata */
    private final Lazy allParameters;

    /* JADX INFO: renamed from: caller$delegate, reason: from kotlin metadata */
    private final Lazy caller;
    private final KDeclarationContainerImpl container;

    /* JADX INFO: renamed from: defaultCaller$delegate, reason: from kotlin metadata */
    private final Lazy defaultCaller;

    /* JADX INFO: renamed from: parameters$delegate, reason: from kotlin metadata */
    private final Lazy parameters;
    private final Object rawBoundReceiver;
    private final String signature;

    public KotlinKFunction(KDeclarationContainerImpl kDeclarationContainerImpl, String str, Object obj) {
        kDeclarationContainerImpl.getClass();
        str.getClass();
        this.container = kDeclarationContainerImpl;
        this.signature = str;
        this.rawBoundReceiver = obj;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.allParameters = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKFunction$$Lambda$0
            private final KotlinKFunction arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKFunction.allParameters_delegate$lambda$0(this.arg$0);
            }
        });
        this.parameters = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKFunction$$Lambda$1
            private final KotlinKFunction arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKFunction.parameters_delegate$lambda$0(this.arg$0);
            }
        });
        this.caller = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKFunction$$Lambda$2
            private final KotlinKFunction arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKFunction.caller_delegate$lambda$0(this.arg$0);
            }
        });
        this.defaultCaller = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKFunction$$Lambda$3
            private final KotlinKFunction arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKFunction.defaultCaller_delegate$lambda$0(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List allParameters_delegate$lambda$0(KotlinKFunction kotlinKFunction) {
        return KotlinKCallableKt.computeParameters(kotlinKFunction, kotlinKFunction.getContextParameters(), kotlinKFunction.getExtensionReceiverType(), kotlinKFunction.getValueParameters(), kotlinKFunction.getTypeParameterTable(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Caller caller_delegate$lambda$0(KotlinKFunction kotlinKFunction) {
        GenericDeclaration genericDeclarationFindMethodBySignature;
        Caller<?> callerCreateStaticMethodCaller;
        if (!ReflectKCallableKt.isConstructor(kotlinKFunction) && !(kotlinKFunction.getContainer() instanceof KPackageImpl)) {
            Utf8$$ExternalSyntheticBUOutline0.m$4("Only constructors and top-level functions are supported for now: ", kotlinKFunction);
            return null;
        }
        JvmMethodSignature jvmSignature = kotlinKFunction.getJvmSignature();
        if (!ReflectKCallableKt.isConstructor(kotlinKFunction) || kotlinKFunction.isInlineClass(kotlinKFunction.getContainer())) {
            genericDeclarationFindMethodBySignature = kotlinKFunction.getContainer().findMethodBySignature(jvmSignature.getName(), jvmSignature.getDescriptor());
        } else {
            if (ReflectKCallableKt.isAnnotationConstructor(kotlinKFunction)) {
                Class<?> jClass = kotlinKFunction.getContainer().getJClass();
                List<KParameter> parameters = kotlinKFunction.getParameters();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((KParameter) it.next()).getName();
                    name.getClass();
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            genericDeclarationFindMethodBySignature = kotlinKFunction.getContainer().findConstructorBySignature(jvmSignature.getDescriptor());
        }
        if (genericDeclarationFindMethodBySignature instanceof Constructor) {
            callerCreateStaticMethodCaller = kotlinKFunction.createConstructorCaller((Constructor) genericDeclarationFindMethodBySignature, false);
        } else {
            if (!(genericDeclarationFindMethodBySignature instanceof Method)) {
                Events$$ExternalSyntheticBUOutline0.m$1("Could not compute caller for function: ", kotlinKFunction);
                return null;
            }
            callerCreateStaticMethodCaller = kotlinKFunction.createStaticMethodCaller((Method) genericDeclarationFindMethodBySignature, false);
        }
        return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(callerCreateStaticMethodCaller, kotlinKFunction, false, CollectionsKt.emptyList());
    }

    private final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> member, boolean isDefault) {
        return (!isDefault && (this instanceof KotlinKConstructor) && shouldHideConstructorDueToValueClassTypeValueParameters((KotlinKConstructor) this)) ? ReflectKCallableKt.isBound(this) ? new CallerImpl.AccessorForHiddenBoundConstructor(member, ReflectKCallableKt.getBoundReceiver(this)) : new CallerImpl.AccessorForHiddenConstructor(member) : ReflectKCallableKt.isBound(this) ? new CallerImpl.BoundConstructor(member, ReflectKCallableKt.getBoundReceiver(this)) : new CallerImpl.Constructor(member);
    }

    private final Caller<?> createStaticMethodCaller(Method member, boolean isCallByToValueClassMangledMethod) {
        if (ReflectKCallableKt.isBound(this)) {
            return new CallerImpl.Method.BoundStatic(member, isCallByToValueClassMangledMethod, useBoxedBoundReceiver(member) ? getRawBoundReceiver() : ReflectKCallableKt.getBoundReceiver(this));
        }
        return new CallerImpl.Method.Static(member);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Caller defaultCaller_delegate$lambda$0(KotlinKFunction kotlinKFunction) {
        GenericDeclaration genericDeclarationFindDefaultMethod;
        if (!ReflectKCallableKt.isConstructor(kotlinKFunction) && !(kotlinKFunction.getContainer() instanceof KPackageImpl)) {
            Utf8$$ExternalSyntheticBUOutline0.m$4("Only constructors and top-level functions are supported for now: ", kotlinKFunction);
            return null;
        }
        JvmMethodSignature jvmSignature = kotlinKFunction.getJvmSignature();
        ArrayList arrayList = new ArrayList();
        if (!ReflectKCallableKt.isConstructor(kotlinKFunction) || kotlinKFunction.isInlineClass(kotlinKFunction.getContainer())) {
            DescriptorPatchingResult descriptorPatchingResultPatchJvmDescriptorByExtraBoxing = ReflectKFunctionKt.patchJvmDescriptorByExtraBoxing(kotlinKFunction, jvmSignature.getDescriptor());
            arrayList.addAll(descriptorPatchingResultPatchJvmDescriptorByExtraBoxing.getBoxedIndices());
            KDeclarationContainerImpl container = kotlinKFunction.getContainer();
            String name = jvmSignature.getName();
            String newDescriptor = descriptorPatchingResultPatchJvmDescriptorByExtraBoxing.getNewDescriptor();
            Member memberMo2469getMember = kotlinKFunction.getCaller().mo2469getMember();
            memberMo2469getMember.getClass();
            boolean z = !Modifier.isStatic(memberMo2469getMember.getModifiers());
            List<KParameter> allParameters = kotlinKFunction.getAllParameters();
            boolean z2 = false;
            if (!(allParameters instanceof Collection) || !allParameters.isEmpty()) {
                Iterator<T> it = allParameters.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((KParameter) it.next()).getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                        z2 = true;
                        break;
                    }
                }
            }
            genericDeclarationFindDefaultMethod = container.findDefaultMethod(name, newDescriptor, z, z2);
        } else {
            if (ReflectKCallableKt.isAnnotationConstructor(kotlinKFunction)) {
                Class<?> jClass = kotlinKFunction.getContainer().getJClass();
                List<KParameter> parameters = kotlinKFunction.getParameters();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it2 = parameters.iterator();
                while (it2.hasNext()) {
                    String name2 = ((KParameter) it2.next()).getName();
                    name2.getClass();
                    arrayList2.add(name2);
                }
                return new AnnotationConstructorCaller(jClass, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            DescriptorPatchingResult descriptorPatchingResultPatchJvmDescriptorByExtraBoxing2 = ReflectKFunctionKt.patchJvmDescriptorByExtraBoxing(kotlinKFunction, kotlinKFunction.getJvmSignature().getDescriptor());
            arrayList.addAll(descriptorPatchingResultPatchJvmDescriptorByExtraBoxing2.getBoxedIndices());
            genericDeclarationFindDefaultMethod = kotlinKFunction.getContainer().findDefaultConstructor(descriptorPatchingResultPatchJvmDescriptorByExtraBoxing2.getNewDescriptor());
        }
        Caller<?> callerCreateConstructorCaller = genericDeclarationFindDefaultMethod instanceof Constructor ? kotlinKFunction.createConstructorCaller((Constructor) genericDeclarationFindDefaultMethod, true) : genericDeclarationFindDefaultMethod instanceof Method ? kotlinKFunction.createStaticMethodCaller((Method) genericDeclarationFindDefaultMethod, kotlinKFunction.getCaller().isBoundInstanceCallWithValueClasses()) : null;
        if (callerCreateConstructorCaller != null) {
            return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(callerCreateConstructorCaller, kotlinKFunction, true, arrayList);
        }
        return null;
    }

    private final boolean isInlineClass(KDeclarationContainerImpl kDeclarationContainerImpl) {
        return (kDeclarationContainerImpl instanceof KClassImpl) && ((KClassImpl) kDeclarationContainerImpl).isValue();
    }

    private final boolean isValueClassThatRequiresMangling(KClass<?> kClass) {
        return kClass.isValue() && !Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Result.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List parameters_delegate$lambda$0(KotlinKFunction kotlinKFunction) {
        return ReflectKCallableKt.isBound(kotlinKFunction) ? KotlinKCallableKt.computeParameters(kotlinKFunction, kotlinKFunction.getContextParameters(), kotlinKFunction.getExtensionReceiverType(), kotlinKFunction.getValueParameters(), kotlinKFunction.getTypeParameterTable(), false) : kotlinKFunction.getAllParameters();
    }

    private final boolean shouldHideConstructorDueToValueClassTypeValueParameters(KotlinKConstructor constructor) {
        if (constructor.getVisibility() == KVisibility.PRIVATE) {
            return false;
        }
        List<KParameter> parameters = constructor.getParameters();
        if ((parameters instanceof Collection) && parameters.isEmpty()) {
            return false;
        }
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            if (isValueClassThatRequiresMangling(KTypesJvm.getJvmErasure(((KParameter) it.next()).getType()))) {
                return true;
            }
        }
        return false;
    }

    private final boolean useBoxedBoundReceiver(Method member) {
        if (getContainer() instanceof KPackageImpl) {
            return false;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$4("Only top-level functions are supported for now: ", this);
        return false;
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

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public List<KParameter> getAllParameters() {
        return (List) this.allParameters.getValue();
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

    public abstract List<KmValueParameter> getContextParameters();

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public Caller<?> getDefaultCaller() {
        return (Caller) this.defaultCaller.getValue();
    }

    public abstract KmType getExtensionReceiverType();

    public abstract JvmMethodSignature getJvmSignature();

    @Override // kotlin.reflect.jvm.internal.ReflectKFunction
    public Collection<ReflectKFunction> getOverridden() {
        if (getContainer() instanceof KPackageImpl) {
            return CollectionsKt.emptyList();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$4("Only top-level functions are supported for now: ", this);
        return null;
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        return (List) this.parameters.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public Object getRawBoundReceiver() {
        return this.rawBoundReceiver;
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKFunction
    public String getSignature() {
        return this.signature;
    }

    public abstract TypeParameterTable getTypeParameterTable();

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        return getTypeParameterTable().getOwnTypeParameters();
    }

    public abstract List<KmValueParameter> getValueParameters();

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ Object invoke() {
        return default$invoke();
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
}
