package kotlin.reflect.jvm.internal;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KotlinGenericDeclarationKt;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KotlinKProperty;
import kotlin.reflect.jvm.internal.TypeParameterTable;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmExtensionsKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0003WXYB)\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R!\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R!\u0010.\u001a\b\u0012\u0004\u0012\u00020&0%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u001b\u00103\u001a\u00020/8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010(\u001a\u0004\b1\u00102R\u001d\u00106\u001a\b\u0012\u0004\u0012\u000205048\u0006¢\u0006\f\n\u0004\b6\u0010(\u001a\u0004\b7\u00108R\u001d\u0010=\u001a\u0004\u0018\u0001098VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u0010(\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0019R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020@0%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010*R\u0016\u0010F\u001a\u0004\u0018\u00010C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000I8&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0006\u0012\u0002\b\u00030M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001a\u0010R\u001a\b\u0012\u0002\b\u0003\u0018\u00010M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010OR\u0014\u0010V\u001a\u00020S8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006Z"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinKProperty;", "V", "Lkotlin/reflect/jvm/internal/KotlinKCallable;", "Lkotlin/reflect/jvm/internal/ReflectKProperty;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "signature", "", "rawBoundReceiver", "Lkotlin/reflect/jvm/internal/impl/km/KmProperty;", "kmProperty", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/Object;Lkotlin/metadata/KmProperty;)V", "Ljava/lang/reflect/Member;", "computeDelegateSource", "()Ljava/lang/reflect/Member;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Ljava/lang/String;", "getSignature", "Ljava/lang/Object;", "getRawBoundReceiver", "()Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/km/KmProperty;", "getKmProperty", "()Lkotlin/metadata/KmProperty;", "", "Lkotlin/reflect/KParameter;", "allParameters$delegate", "Lkotlin/Lazy;", "getAllParameters", "()Ljava/util/List;", "allParameters", "parameters$delegate", "getParameters", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "Lkotlin/reflect/KType;", "returnType$delegate", "getReturnType", "()Lkotlin/reflect/KType;", "returnType", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/TypeParameterTable;", "typeParameterTable", "getTypeParameterTable", "()Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "javaField$delegate", "getJavaField", "()Ljava/lang/reflect/Field;", "javaField", "getName", "name", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "isSuspend", "()Z", "Lkotlin/reflect/jvm/internal/KotlinKProperty$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KotlinKProperty$Getter;", "getter", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "getDefaultCaller", "defaultCaller", "Lkotlin/reflect/jvm/internal/impl/km/Modality;", "getModality", "()Lkotlin/metadata/Modality;", "modality", "Accessor", "Getter", "Setter", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class KotlinKProperty<V> extends KotlinKCallable<V> implements ReflectKProperty<V> {

    /* JADX INFO: renamed from: allParameters$delegate, reason: from kotlin metadata */
    private final Lazy allParameters;
    private final KDeclarationContainerImpl container;

    /* JADX INFO: renamed from: javaField$delegate, reason: from kotlin metadata */
    private final Lazy javaField;
    private final KmProperty kmProperty;

    /* JADX INFO: renamed from: parameters$delegate, reason: from kotlin metadata */
    private final Lazy parameters;
    private final Object rawBoundReceiver;

    /* JADX INFO: renamed from: returnType$delegate, reason: from kotlin metadata */
    private final Lazy returnType;
    private final String signature;
    private final Lazy<TypeParameterTable> typeParameterTable;

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u00042\b\u0012\u0004\u0012\u00028\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0016\u0010'\u001a\u0004\u0018\u00010$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinKProperty$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KotlinKCallable;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "<init>", "()V", "Lkotlin/reflect/jvm/internal/KotlinKProperty;", "getProperty", "()Lkotlin/reflect/jvm/internal/KotlinKProperty;", "property", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "", "getRawBoundReceiver", "()Ljava/lang/Object;", "rawBoundReceiver", "", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "typeParameters", "", "isInline", "()Z", "isExternal", "isOperator", "isInfix", "isSuspend", "Lkotlin/reflect/jvm/internal/impl/km/KmPropertyAccessorAttributes;", "getAccessor", "()Lkotlin/metadata/KmPropertyAccessorAttributes;", "accessor", "Lkotlin/reflect/jvm/internal/impl/km/Modality;", "getModality", "()Lkotlin/metadata/Modality;", "modality", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Accessor<PropertyType, ReturnType> extends KotlinKCallable<ReturnType> implements KFunction<ReturnType>, KProperty.Accessor<PropertyType> {
        public abstract KmPropertyAccessorAttributes getAccessor();

        @Override // kotlin.reflect.jvm.internal.ReflectKCallable
        public KDeclarationContainerImpl getContainer() {
            return getProperty().getContainer();
        }

        @Override // kotlin.reflect.jvm.internal.ReflectKCallable
        public Caller<?> getDefaultCaller() {
            return null;
        }

        public abstract KotlinKProperty<PropertyType> getProperty();

        @Override // kotlin.reflect.jvm.internal.ReflectKCallable
        public Object getRawBoundReceiver() {
            return getProperty().getRawBoundReceiver();
        }

        @Override // kotlin.reflect.KCallable
        public List<KTypeParameter> getTypeParameters() {
            return getProperty().getTypeParameters();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isExternal() {
            KmPropertyAccessorAttributes accessor = getAccessor();
            return accessor != null && Attributes.isExternal(accessor);
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInfix() {
            return false;
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInline() {
            KmPropertyAccessorAttributes accessor = getAccessor();
            return accessor != null && Attributes.isInline(accessor);
        }

        @Override // kotlin.reflect.KFunction
        public boolean isOperator() {
            return false;
        }

        @Override // kotlin.reflect.KCallable
        public boolean isSuspend() {
            return false;
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0082\u0004J\n\u0010#\u001a\u00020$H\u0096\u0080\u0004J\n\u0010%\u001a\u00020\u0007H\u0096\u0080\u0004R\u0015\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0015\u001a\u00020\u00168VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinKProperty$Getter;", "V", "Lkotlin/reflect/jvm/internal/KotlinKProperty$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "accessor", "Lkotlin/reflect/jvm/internal/impl/km/KmPropertyAccessorAttributes;", "getAccessor", "()Lkotlin/metadata/KmPropertyAccessorAttributes;", "allParameters", "", "Lkotlin/reflect/KParameter;", "getAllParameters", "()Ljava/util/List;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Getter<V> extends Accessor<V, V> implements KProperty.Getter<V> {

        /* JADX INFO: renamed from: caller$delegate, reason: from kotlin metadata */
        private final Lazy caller = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKProperty$Getter$$Lambda$0
            private final KotlinKProperty.Getter arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKProperty.Getter.caller_delegate$lambda$0(this.arg$0);
            }
        });

        /* JADX INFO: Access modifiers changed from: private */
        public static final Caller caller_delegate$lambda$0(Getter getter) {
            return KotlinKPropertyKt.computeCallerForAccessor(getter, true);
        }

        public boolean equals(Object other) {
            return (other instanceof Getter) && Intrinsics.areEqual(getProperty(), ((Getter) other).getProperty());
        }

        @Override // kotlin.reflect.jvm.internal.KotlinKProperty.Accessor
        public KmPropertyAccessorAttributes getAccessor() {
            return getProperty().getKmProperty().getGetter();
        }

        @Override // kotlin.reflect.jvm.internal.ReflectKCallable
        public List<KParameter> getAllParameters() {
            return getProperty().getAllParameters();
        }

        @Override // kotlin.reflect.jvm.internal.ReflectKCallable
        public Caller<?> getCaller() {
            return (Caller) this.caller.getValue();
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            return "<get-" + getProperty().getName() + '>';
        }

        @Override // kotlin.reflect.KCallable
        public List<KParameter> getParameters() {
            return getProperty().getParameters();
        }

        @Override // kotlin.reflect.KCallable
        public KType getReturnType() {
            return getProperty().getReturnType();
        }

        public int hashCode() {
            return getProperty().hashCode();
        }

        public String toString() {
            return "getter of " + getProperty();
        }
    }

    public KotlinKProperty(KDeclarationContainerImpl kDeclarationContainerImpl, String str, Object obj, KmProperty kmProperty) {
        kDeclarationContainerImpl.getClass();
        str.getClass();
        kmProperty.getClass();
        this.container = kDeclarationContainerImpl;
        this.signature = str;
        this.rawBoundReceiver = obj;
        this.kmProperty = kmProperty;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.allParameters = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKProperty$$Lambda$0
            private final KotlinKProperty arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKProperty.allParameters_delegate$lambda$0(this.arg$0);
            }
        });
        this.parameters = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKProperty$$Lambda$1
            private final KotlinKProperty arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKProperty.parameters_delegate$lambda$0(this.arg$0);
            }
        });
        this.returnType = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKProperty$$Lambda$2
            private final KotlinKProperty arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKProperty.returnType_delegate$lambda$0(this.arg$0);
            }
        });
        this.typeParameterTable = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKProperty$$Lambda$3
            private final KotlinKProperty arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKProperty.typeParameterTable$lambda$0(this.arg$0);
            }
        });
        this.javaField = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKProperty$$Lambda$4
            private final KotlinKProperty arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKProperty.javaField_delegate$lambda$0(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List allParameters_delegate$lambda$0(KotlinKProperty kotlinKProperty) {
        return KotlinKCallableKt.computeParameters(kotlinKProperty, kotlinKProperty.kmProperty.getContextParameters(), kotlinKProperty.kmProperty.getReceiverParameterType(), CollectionsKt.emptyList(), kotlinKProperty.typeParameterTable.getValue(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Field javaField_delegate$lambda$0(KotlinKProperty kotlinKProperty) {
        JvmFieldSignature fieldSignature;
        if (ReflectKPropertyKt.isLocalDelegated(kotlinKProperty) || (fieldSignature = JvmExtensionsKt.getFieldSignature(kotlinKProperty.kmProperty)) == null) {
            return null;
        }
        if (kotlinKProperty.getContainer() instanceof KPackageImpl) {
            try {
                return kotlinKProperty.getContainer().getJClass().getDeclaredField(fieldSignature.getName());
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
        Utf8$$ExternalSyntheticBUOutline0.m$4("javaField is only supported for top-level properties for now: ", kotlinKProperty);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List parameters_delegate$lambda$0(KotlinKProperty kotlinKProperty) {
        return ReflectKCallableKt.isBound(kotlinKProperty) ? KotlinKCallableKt.computeParameters(kotlinKProperty, kotlinKProperty.kmProperty.getContextParameters(), kotlinKProperty.kmProperty.getReceiverParameterType(), CollectionsKt.emptyList(), kotlinKProperty.typeParameterTable.getValue(), false) : kotlinKProperty.getAllParameters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType returnType_delegate$lambda$0(final KotlinKProperty kotlinKProperty) {
        KmType returnType = kotlinKProperty.kmProperty.getReturnType();
        ClassLoader classLoader = kotlinKProperty.getContainer().getJClass().getClassLoader();
        classLoader.getClass();
        return ConvertFromMetadataKt.toKType(returnType, classLoader, kotlinKProperty.typeParameterTable.getValue(), ReflectKPropertyKt.isLocalDelegated(kotlinKProperty) ? null : new Function0(kotlinKProperty) { // from class: kotlin.reflect.jvm.internal.KotlinKProperty$$Lambda$5
            private final KotlinKProperty arg$0;

            {
                this.arg$0 = kotlinKProperty;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKProperty.returnType_delegate$lambda$0$0(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <V> Type returnType_delegate$lambda$0$0(KotlinKProperty<? extends V> kotlinKProperty) {
        return kotlinKProperty.getCaller().getReturnType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeParameterTable typeParameterTable$lambda$0(KotlinKProperty kotlinKProperty) {
        KDeclarationContainerImpl container = kotlinKProperty.getContainer();
        KClassImpl kClassImpl = container instanceof KClassImpl ? (KClassImpl) container : null;
        TypeParameterTable typeParameterTable$kotlin_reflection = kClassImpl != null ? kClassImpl.getTypeParameterTable$kotlin_reflection() : null;
        TypeParameterTable.Companion companion = TypeParameterTable.INSTANCE;
        List<KmTypeParameter> typeParameters = kotlinKProperty.kmProperty.getTypeParameters();
        ClassLoader classLoader = kotlinKProperty.getContainer().getJClass().getClassLoader();
        classLoader.getClass();
        return companion.create(typeParameters, typeParameterTable$kotlin_reflection, kotlinKProperty, classLoader);
    }

    public final Member computeDelegateSource() {
        if (!Attributes.isDelegated(this.kmProperty)) {
            return null;
        }
        JvmMethodSignature syntheticMethodForDelegate = JvmExtensionsKt.getSyntheticMethodForDelegate(this.kmProperty);
        return syntheticMethodForDelegate != null ? getContainer().findMethodBySignature(syntheticMethodForDelegate.getName(), syntheticMethodForDelegate.getDescriptor()) : getJavaField();
    }

    public GenericDeclaration default$findJavaDeclaration() {
        return KotlinGenericDeclarationKt.findMethodBySignature(getContainer(), getSignature());
    }

    public boolean equals(Object other) {
        ReflectKProperty<?> reflectKPropertyAsReflectProperty = UtilKt.asReflectProperty(other);
        return reflectKPropertyAsReflectProperty != null && Intrinsics.areEqual(getContainer(), reflectKPropertyAsReflectProperty.getContainer()) && Intrinsics.areEqual(getName(), reflectKPropertyAsReflectProperty.getName()) && Intrinsics.areEqual(getSignature(), reflectKPropertyAsReflectProperty.getSignature()) && Intrinsics.areEqual(getRawBoundReceiver(), reflectKPropertyAsReflectProperty.getRawBoundReceiver());
    }

    @Override // kotlin.jvm.internal.KotlinGenericDeclaration
    public /* bridge */ GenericDeclaration findJavaDeclaration() {
        return default$findJavaDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public List<KParameter> getAllParameters() {
        return (List) this.allParameters.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public Caller<?> getCaller() {
        return getGetter().getCaller();
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public Caller<?> getDefaultCaller() {
        return getGetter().getDefaultCaller();
    }

    @Override // kotlin.reflect.KProperty
    public abstract Getter<V> getGetter();

    @Override // kotlin.reflect.jvm.internal.ReflectKProperty
    public Field getJavaField() {
        return (Field) this.javaField.getValue();
    }

    public final KmProperty getKmProperty() {
        return this.kmProperty;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.kmProperty.getName();
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        return (List) this.parameters.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public Object getRawBoundReceiver() {
        return this.rawBoundReceiver;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return (KType) this.returnType.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.ReflectKProperty
    public String getSignature() {
        return this.signature;
    }

    public final Lazy<TypeParameterTable> getTypeParameterTable() {
        return this.typeParameterTable;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        return this.typeParameterTable.getValue().getOwnTypeParameters();
    }

    public KVisibility getVisibility() {
        return ConvertFromMetadataKt.toKVisibility(Attributes.getVisibility(this.kmProperty));
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderProperty(this);
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001)B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0082\u0004J\n\u0010&\u001a\u00020'H\u0096\u0080\u0004J\n\u0010(\u001a\u00020\bH\u0096\u0080\u0004R\u0015\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0018\u001a\u00020\u00198VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006*"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinKProperty$Setter;", "V", "Lkotlin/reflect/jvm/internal/KotlinKProperty$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "accessor", "Lkotlin/reflect/jvm/internal/impl/km/KmPropertyAccessorAttributes;", "getAccessor", "()Lkotlin/metadata/KmPropertyAccessorAttributes;", "allParameters", "", "Lkotlin/reflect/KParameter;", "getAllParameters", "()Ljava/util/List;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "getParameters", "setterParameter", "Lkotlin/Lazy;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "DefaultSetterValueParameter", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Setter<V> extends Accessor<V, Unit> implements KMutableProperty.Setter<V> {

        /* JADX INFO: renamed from: caller$delegate, reason: from kotlin metadata */
        private final Lazy caller;
        private final Lazy<KParameter> setterParameter;

        public Setter() {
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            this.setterParameter = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKProperty$Setter$$Lambda$0
                private final KotlinKProperty.Setter arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KotlinKProperty.Setter.setterParameter$lambda$0(this.arg$0);
                }
            });
            this.caller = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKProperty$Setter$$Lambda$1
                private final KotlinKProperty.Setter arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KotlinKProperty.Setter.caller_delegate$lambda$0(this.arg$0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Caller caller_delegate$lambda$0(Setter setter) {
            return KotlinKPropertyKt.computeCallerForAccessor(setter, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ReflectKParameter setterParameter$lambda$0(Setter setter) {
            KmValueParameter setterParameter = setter.getProperty().getKmProperty().getSetterParameter();
            return setterParameter != null ? new KotlinKParameter(setter, setterParameter, setter.getProperty().getAllParameters().size(), KParameter.Kind.VALUE, setter.getProperty().getTypeParameterTable().getValue()) : new DefaultSetterValueParameter(setter.getProperty());
        }

        public boolean equals(Object other) {
            return (other instanceof Setter) && Intrinsics.areEqual(getProperty(), ((Setter) other).getProperty());
        }

        @Override // kotlin.reflect.jvm.internal.KotlinKProperty.Accessor
        public KmPropertyAccessorAttributes getAccessor() {
            return getProperty().getKmProperty().getSetter();
        }

        @Override // kotlin.reflect.jvm.internal.ReflectKCallable
        public List<KParameter> getAllParameters() {
            return CollectionsKt.plus((Collection<? extends KParameter>) getProperty().getAllParameters(), this.setterParameter.getValue());
        }

        @Override // kotlin.reflect.jvm.internal.ReflectKCallable
        public Caller<?> getCaller() {
            return (Caller) this.caller.getValue();
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            return "<set-" + getProperty().getName() + '>';
        }

        @Override // kotlin.reflect.KCallable
        public List<KParameter> getParameters() {
            return CollectionsKt.plus((Collection<? extends KParameter>) getProperty().getParameters(), this.setterParameter.getValue());
        }

        @Override // kotlin.reflect.KCallable
        public KType getReturnType() {
            return StandardKTypes.INSTANCE.getUNIT_RETURN_TYPE();
        }

        public int hashCode() {
            return getProperty().hashCode();
        }

        public String toString() {
            return "setter of " + getProperty();
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinKProperty$Setter$DefaultSetterValueParameter;", "Lkotlin/reflect/jvm/internal/ReflectKParameter;", "Lkotlin/reflect/jvm/internal/KotlinKProperty;", "callable", "<init>", "(Lkotlin/reflect/jvm/internal/KotlinKProperty;)V", "Lkotlin/reflect/jvm/internal/KotlinKProperty;", "getCallable", "()Lkotlin/reflect/jvm/internal/KotlinKProperty;", "", "getIndex", "()I", "index", "", "getName", "()Ljava/lang/String;", "name", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "kind", "", "isOptional", "()Z", "isVararg", "getDeclaresDefaultValue", "declaresDefaultValue", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class DefaultSetterValueParameter extends ReflectKParameter {
            private final KotlinKProperty<?> callable;

            public DefaultSetterValueParameter(KotlinKProperty<?> kotlinKProperty) {
                kotlinKProperty.getClass();
                this.callable = kotlinKProperty;
            }

            @Override // kotlin.reflect.jvm.internal.ReflectKParameter
            public boolean getDeclaresDefaultValue() {
                return false;
            }

            @Override // kotlin.reflect.KParameter
            public int getIndex() {
                return 0;
            }

            @Override // kotlin.reflect.KParameter
            public KParameter.Kind getKind() {
                return KParameter.Kind.VALUE;
            }

            @Override // kotlin.reflect.KParameter
            public String getName() {
                return null;
            }

            @Override // kotlin.reflect.KParameter
            public KType getType() {
                return getCallable().getReturnType();
            }

            @Override // kotlin.reflect.KParameter
            public boolean isOptional() {
                return false;
            }

            @Override // kotlin.reflect.KParameter
            public boolean isVararg() {
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.ReflectKParameter
            public KotlinKProperty<?> getCallable() {
                return this.callable;
            }
        }
    }
}
