package kotlin.reflect.jvm.internal;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmExtensionsKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0016\u0010/\u001a\u0004\u0018\u00010,8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00107\u001a\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinKConstructor;", "Lkotlin/reflect/jvm/internal/KotlinKFunction;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "signature", "", "rawBoundReceiver", "Lkotlin/reflect/jvm/internal/impl/km/KmConstructor;", "kmConstructor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/Object;Lkotlin/metadata/KmConstructor;)V", "Lkotlin/reflect/jvm/internal/impl/km/KmConstructor;", "Lkotlin/reflect/KType;", "returnType$delegate", "Lkotlin/Lazy;", "getReturnType", "()Lkotlin/reflect/KType;", "returnType", "", "Lkotlin/reflect/jvm/internal/impl/km/KmValueParameter;", "getContextParameters", "()Ljava/util/List;", "contextParameters", "getValueParameters", "valueParameters", "Lkotlin/reflect/jvm/internal/TypeParameterTable;", "getTypeParameterTable", "()Lkotlin/reflect/jvm/internal/TypeParameterTable;", "typeParameterTable", "getName", "()Ljava/lang/String;", "name", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "", "isSuspend", "()Z", "isInline", "isExternal", "isOperator", "isInfix", "Lkotlin/reflect/jvm/internal/impl/km/KmType;", "getExtensionReceiverType", "()Lkotlin/metadata/KmType;", "extensionReceiverType", "Lkotlin/reflect/jvm/internal/impl/km/jvm/JvmMethodSignature;", "getJvmSignature", "()Lkotlin/metadata/jvm/JvmMethodSignature;", "jvmSignature", "Lkotlin/reflect/jvm/internal/impl/km/Modality;", "getModality", "()Lkotlin/metadata/Modality;", "modality", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KotlinKConstructor extends KotlinKFunction {
    private final KmConstructor kmConstructor;

    /* JADX INFO: renamed from: returnType$delegate, reason: from kotlin metadata */
    private final Lazy returnType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinKConstructor(final KDeclarationContainerImpl kDeclarationContainerImpl, String str, Object obj, KmConstructor kmConstructor) {
        super(kDeclarationContainerImpl, str, obj);
        kDeclarationContainerImpl.getClass();
        str.getClass();
        kmConstructor.getClass();
        this.kmConstructor = kmConstructor;
        this.returnType = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(kDeclarationContainerImpl) { // from class: kotlin.reflect.jvm.internal.KotlinKConstructor$$Lambda$0
            private final KDeclarationContainerImpl arg$0;

            {
                this.arg$0 = kDeclarationContainerImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKConstructor.returnType_delegate$lambda$0(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType returnType_delegate$lambda$0(KDeclarationContainerImpl kDeclarationContainerImpl) {
        kDeclarationContainerImpl.getClass();
        return KClasses.createDefaultType((KClassImpl) kDeclarationContainerImpl);
    }

    @Override // kotlin.reflect.jvm.internal.KotlinKFunction
    public List<KmValueParameter> getContextParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.KotlinKFunction
    public KmType getExtensionReceiverType() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.KotlinKFunction
    public JvmMethodSignature getJvmSignature() {
        JvmMethodSignature signature = JvmExtensionsKt.getSignature(this.kmConstructor);
        if (signature != null) {
            return signature;
        }
        Events$$ExternalSyntheticBUOutline0.m$1("No signature for constructor: ", this);
        return null;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return "<init>";
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return (KType) this.returnType.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.KotlinKFunction
    public TypeParameterTable getTypeParameterTable() {
        KDeclarationContainerImpl container = getContainer();
        container.getClass();
        return ((KClassImpl) container).getTypeParameterTable$kotlin_reflection();
    }

    @Override // kotlin.reflect.jvm.internal.KotlinKFunction
    public List<KmValueParameter> getValueParameters() {
        return this.kmConstructor.getValueParameters();
    }

    public KVisibility getVisibility() {
        return ConvertFromMetadataKt.toKVisibility(Attributes.getVisibility(this.kmConstructor));
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return false;
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return false;
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
