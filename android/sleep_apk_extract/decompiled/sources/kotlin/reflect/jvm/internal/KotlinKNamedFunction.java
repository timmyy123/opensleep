package kotlin.reflect.jvm.internal;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.TypeParameterTable;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmExtensionsKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u000e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010$\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010%R\u0016\u0010-\u001a\u0004\u0018\u00010*8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00105\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinKNamedFunction;", "Lkotlin/reflect/jvm/internal/KotlinKFunction;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "signature", "", "rawBoundReceiver", "Lkotlin/reflect/jvm/internal/impl/km/KmFunction;", "kmFunction", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/Object;Lkotlin/metadata/KmFunction;)V", "Lkotlin/reflect/jvm/internal/impl/km/KmFunction;", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/TypeParameterTable;", "_typeParameterTable", "Lkotlin/Lazy;", "Lkotlin/reflect/KType;", "returnType$delegate", "getReturnType", "()Lkotlin/reflect/KType;", "returnType", "", "Lkotlin/reflect/jvm/internal/impl/km/KmValueParameter;", "getContextParameters", "()Ljava/util/List;", "contextParameters", "getValueParameters", "valueParameters", "getTypeParameterTable", "()Lkotlin/reflect/jvm/internal/TypeParameterTable;", "typeParameterTable", "getName", "()Ljava/lang/String;", "name", "", "isSuspend", "()Z", "isInline", "isExternal", "isOperator", "isInfix", "Lkotlin/reflect/jvm/internal/impl/km/KmType;", "getExtensionReceiverType", "()Lkotlin/metadata/KmType;", "extensionReceiverType", "Lkotlin/reflect/jvm/internal/impl/km/jvm/JvmMethodSignature;", "getJvmSignature", "()Lkotlin/metadata/jvm/JvmMethodSignature;", "jvmSignature", "Lkotlin/reflect/jvm/internal/impl/km/Modality;", "getModality", "()Lkotlin/metadata/Modality;", "modality", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KotlinKNamedFunction extends KotlinKFunction {
    private final Lazy<TypeParameterTable> _typeParameterTable;
    private final KmFunction kmFunction;

    /* JADX INFO: renamed from: returnType$delegate, reason: from kotlin metadata */
    private final Lazy returnType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinKNamedFunction(final KDeclarationContainerImpl kDeclarationContainerImpl, String str, Object obj, KmFunction kmFunction) {
        super(kDeclarationContainerImpl, str, obj);
        kDeclarationContainerImpl.getClass();
        str.getClass();
        kmFunction.getClass();
        this.kmFunction = kmFunction;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this._typeParameterTable = LazyKt.lazy(lazyThreadSafetyMode, new Function0(kDeclarationContainerImpl, this) { // from class: kotlin.reflect.jvm.internal.KotlinKNamedFunction$$Lambda$0
            private final KDeclarationContainerImpl arg$0;
            private final KotlinKNamedFunction arg$1;

            {
                this.arg$0 = kDeclarationContainerImpl;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKNamedFunction._typeParameterTable$lambda$0(this.arg$0, this.arg$1);
            }
        });
        this.returnType = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this, kDeclarationContainerImpl) { // from class: kotlin.reflect.jvm.internal.KotlinKNamedFunction$$Lambda$1
            private final KotlinKNamedFunction arg$0;
            private final KDeclarationContainerImpl arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = kDeclarationContainerImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKNamedFunction.returnType_delegate$lambda$0(this.arg$0, this.arg$1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeParameterTable _typeParameterTable$lambda$0(KDeclarationContainerImpl kDeclarationContainerImpl, KotlinKNamedFunction kotlinKNamedFunction) {
        KClassImpl kClassImpl = kDeclarationContainerImpl instanceof KClassImpl ? (KClassImpl) kDeclarationContainerImpl : null;
        TypeParameterTable typeParameterTable$kotlin_reflection = kClassImpl != null ? kClassImpl.getTypeParameterTable$kotlin_reflection() : null;
        TypeParameterTable.Companion companion = TypeParameterTable.INSTANCE;
        List<KmTypeParameter> typeParameters = kotlinKNamedFunction.kmFunction.getTypeParameters();
        ClassLoader classLoader = kDeclarationContainerImpl.getJClass().getClassLoader();
        classLoader.getClass();
        return companion.create(typeParameters, typeParameterTable$kotlin_reflection, kotlinKNamedFunction, classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType returnType_delegate$lambda$0(final KotlinKNamedFunction kotlinKNamedFunction, KDeclarationContainerImpl kDeclarationContainerImpl) {
        KmType returnType = kotlinKNamedFunction.kmFunction.getReturnType();
        ClassLoader classLoader = kDeclarationContainerImpl.getJClass().getClassLoader();
        classLoader.getClass();
        return ConvertFromMetadataKt.toKType(returnType, classLoader, kotlinKNamedFunction.getTypeParameterTable(), new Function0(kotlinKNamedFunction) { // from class: kotlin.reflect.jvm.internal.KotlinKNamedFunction$$Lambda$2
            private final KotlinKNamedFunction arg$0;

            {
                this.arg$0 = kotlinKNamedFunction;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKNamedFunction.returnType_delegate$lambda$0$0(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type returnType_delegate$lambda$0$0(KotlinKNamedFunction kotlinKNamedFunction) {
        Type typeExtractContinuationArgument = ReflectKFunctionKt.extractContinuationArgument(kotlinKNamedFunction);
        return typeExtractContinuationArgument == null ? kotlinKNamedFunction.getCaller().getReturnType() : typeExtractContinuationArgument;
    }

    @Override // kotlin.reflect.jvm.internal.KotlinKFunction
    public List<KmValueParameter> getContextParameters() {
        return this.kmFunction.getContextParameters();
    }

    @Override // kotlin.reflect.jvm.internal.KotlinKFunction
    public KmType getExtensionReceiverType() {
        return this.kmFunction.getReceiverParameterType();
    }

    @Override // kotlin.reflect.jvm.internal.KotlinKFunction
    public JvmMethodSignature getJvmSignature() {
        JvmMethodSignature signature = JvmExtensionsKt.getSignature(this.kmFunction);
        if (signature != null) {
            return signature;
        }
        Events$$ExternalSyntheticBUOutline0.m$1("No signature for function: ", this);
        return null;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.kmFunction.getName();
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return (KType) this.returnType.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.KotlinKFunction
    public TypeParameterTable getTypeParameterTable() {
        return this._typeParameterTable.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.KotlinKFunction
    public List<KmValueParameter> getValueParameters() {
        return this.kmFunction.getValueParameters();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return Attributes.isExternal(this.kmFunction);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return Attributes.isInfix(this.kmFunction);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return Attributes.isInline(this.kmFunction);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return Attributes.isOperator(this.kmFunction);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return Attributes.isSuspend(this.kmFunction);
    }
}
