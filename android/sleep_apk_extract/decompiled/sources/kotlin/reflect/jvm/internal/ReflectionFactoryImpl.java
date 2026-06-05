package kotlin.reflect.jvm.internal;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.ReflectLambdaKt;
import kotlin.reflect.jvm.internal.types.TypeOfImplKt;
import kotlin.text.MatchResult;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class ReflectionFactoryImpl extends ReflectionFactory {
    private static KDeclarationContainerImpl getOwner(CallableReference callableReference) {
        KDeclarationContainer owner = callableReference.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : EmptyContainerForLocal.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$mutableProperty1$3(KDeclarationContainerImpl kDeclarationContainerImpl, MutablePropertyReference1 mutablePropertyReference1, String str) {
        if (!(kDeclarationContainerImpl instanceof KPackageImpl)) {
            return new DescriptorKMutableProperty1(kDeclarationContainerImpl, mutablePropertyReference1.getName(), str, mutablePropertyReference1.getBoundReceiver());
        }
        return new KotlinKMutableProperty1(kDeclarationContainerImpl, str, mutablePropertyReference1.getBoundReceiver(), kDeclarationContainerImpl.findPropertyMetadata(mutablePropertyReference1.getName(), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$property0$0(String str, KDeclarationContainerImpl kDeclarationContainerImpl, PropertyReference0 propertyReference0) {
        MatchResult matchResultMatchEntire = KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE.matchEntire(str);
        if (matchResultMatchEntire != null) {
            return kDeclarationContainerImpl.createLocalProperty(Integer.parseInt(matchResultMatchEntire.getGroupValues().get(1)), str);
        }
        if (!(kDeclarationContainerImpl instanceof KPackageImpl)) {
            return new DescriptorKProperty0(kDeclarationContainerImpl, propertyReference0.getName(), str, propertyReference0.getBoundReceiver());
        }
        return new KotlinKProperty0(kDeclarationContainerImpl, str, propertyReference0.getBoundReceiver(), kDeclarationContainerImpl.findPropertyMetadata(propertyReference0.getName(), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$property1$2(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyReference1 propertyReference1, String str) {
        if (!(kDeclarationContainerImpl instanceof KPackageImpl)) {
            return new DescriptorKProperty1(kDeclarationContainerImpl, propertyReference1.getName(), str, propertyReference1.getBoundReceiver());
        }
        return new KotlinKProperty1(kDeclarationContainerImpl, str, propertyReference1.getBoundReceiver(), kDeclarationContainerImpl.findPropertyMetadata(propertyReference1.getName(), str));
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KFunction function(FunctionReference functionReference) {
        KDeclarationContainerImpl owner = getOwner(functionReference);
        String name = functionReference.getName();
        String signature = functionReference.getSignature();
        if (!SystemPropertiesKt.getUseK1Implementation()) {
            if (name.equals("<init>")) {
                if ((owner instanceof KClassImpl) && owner.getJClass().getAnnotation(Metadata.class) != null) {
                    return new KotlinKConstructor(owner, signature, functionReference.getBoundReceiver(), owner.findConstructorMetadata(signature));
                }
            } else if (owner instanceof KPackageImpl) {
                return new KotlinKNamedFunction(owner, signature, functionReference.getBoundReceiver(), owner.findFunctionMetadata(name, signature));
            }
        }
        return new DescriptorKFunction(owner, name, signature, functionReference.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class cls) {
        return CachesKt.getOrCreateKotlinClass(cls);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return CachesKt.getOrCreateKotlinPackage(cls);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType mutableCollectionType(KType kType) {
        return TypeOfImplKt.createMutableCollectionKType(kType);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty1 mutableProperty1(final MutablePropertyReference1 mutablePropertyReference1) {
        final KDeclarationContainerImpl owner = getOwner(mutablePropertyReference1);
        final String signature = mutablePropertyReference1.getSignature();
        return !SystemPropertiesKt.getUseK1Implementation() ? new LazyKMutableProperty1(new Function0(owner, mutablePropertyReference1, signature) { // from class: kotlin.reflect.jvm.internal.ReflectionFactoryImpl$$Lambda$3
            private final KDeclarationContainerImpl arg$0;
            private final MutablePropertyReference1 arg$1;
            private final String arg$2;

            {
                this.arg$0 = owner;
                this.arg$1 = mutablePropertyReference1;
                this.arg$2 = signature;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ReflectionFactoryImpl.lambda$mutableProperty1$3(this.arg$0, this.arg$1, this.arg$2);
            }
        }) : new DescriptorKMutableProperty1(owner, mutablePropertyReference1.getName(), signature, mutablePropertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty0 property0(final PropertyReference0 propertyReference0) {
        final KDeclarationContainerImpl owner = getOwner(propertyReference0);
        final String signature = propertyReference0.getSignature();
        return !SystemPropertiesKt.getUseK1Implementation() ? new LazyKProperty0(new Function0(signature, owner, propertyReference0) { // from class: kotlin.reflect.jvm.internal.ReflectionFactoryImpl$$Lambda$0
            private final String arg$0;
            private final KDeclarationContainerImpl arg$1;
            private final PropertyReference0 arg$2;

            {
                this.arg$0 = signature;
                this.arg$1 = owner;
                this.arg$2 = propertyReference0;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ReflectionFactoryImpl.lambda$property0$0(this.arg$0, this.arg$1, this.arg$2);
            }
        }) : new DescriptorKProperty0(owner, propertyReference0.getName(), signature, propertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty1 property1(final PropertyReference1 propertyReference1) {
        final KDeclarationContainerImpl owner = getOwner(propertyReference1);
        final String signature = propertyReference1.getSignature();
        return !SystemPropertiesKt.getUseK1Implementation() ? new LazyKProperty1(new Function0(owner, propertyReference1, signature) { // from class: kotlin.reflect.jvm.internal.ReflectionFactoryImpl$$Lambda$2
            private final KDeclarationContainerImpl arg$0;
            private final PropertyReference1 arg$1;
            private final String arg$2;

            {
                this.arg$0 = owner;
                this.arg$1 = propertyReference1;
                this.arg$2 = signature;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ReflectionFactoryImpl.lambda$property1$2(this.arg$0, this.arg$1, this.arg$2);
            }
        }) : new DescriptorKProperty1(owner, propertyReference1.getName(), signature, propertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty2 property2(PropertyReference2 propertyReference2) {
        return new DescriptorKProperty2(getOwner(propertyReference2), propertyReference2.getName(), propertyReference2.getSignature());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public String renderLambdaToString(FunctionBase functionBase) {
        KFunction<?> kFunctionReflect = ReflectLambdaKt.reflect(functionBase);
        return kFunctionReflect != null ? ReflectionObjectRenderer.INSTANCE.renderLambda(kFunctionReflect) : super.renderLambdaToString(functionBase);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public void setUpperBounds(KTypeParameter kTypeParameter, List<KType> list) {
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType typeOf(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        return kClassifier instanceof ClassBasedDeclarationContainer ? CachesKt.getOrCreateKType(((ClassBasedDeclarationContainer) kClassifier).getJClass(), list, z) : KClassifiers.createType(kClassifier, list, z, Collections.EMPTY_LIST);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KTypeParameter typeParameter(Object obj, String str, KVariance kVariance, boolean z) {
        List<KTypeParameter> typeParameters;
        if (obj instanceof KClass) {
            typeParameters = ((KClass) obj).getTypeParameters();
        } else {
            if (!(obj instanceof KCallable)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m("Type parameter container must be a class or a callable: ", obj));
                return null;
            }
            typeParameters = ((KCallable) obj).getTypeParameters();
        }
        for (KTypeParameter kTypeParameter : typeParameters) {
            if (kTypeParameter.getName().equals(str)) {
                return kTypeParameter;
            }
        }
        Types$$ExternalSyntheticBUOutline0.m("Type parameter ", str, " is not found in container: ", obj);
        return null;
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public String renderLambdaToString(Lambda lambda) {
        return renderLambdaToString((FunctionBase) lambda);
    }
}
