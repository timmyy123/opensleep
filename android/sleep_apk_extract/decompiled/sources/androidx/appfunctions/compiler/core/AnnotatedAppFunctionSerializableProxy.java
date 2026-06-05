package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.AppFunctionCompiler;
import androidx.appfunctions.compiler.core.AppFunctionSerializableType;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.processors.AppFunctionSerializableFactoryCodeBuilderHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.squareup.kotlinpoet.ClassName;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import com.squareup.kotlinpoet.TypeSpec;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u000223B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0013\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0083\u0004J\n\u0010/\u001a\u000200HÖ\u0081\u0004J\n\u00101\u001a\u00020\u0010HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u001b\u0010\u000b\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\f\u0010\u0007R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!¨\u00064"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy;", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;)V", "getClassDeclaration", "()Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "isDescribedByKDoc", "", "()Z", "targetClassDeclaration", "getTargetClassDeclaration", "targetClassDeclaration$delegate", "Lkotlin/Lazy;", "toTargetClassMethodName", "", "getToTargetClassMethodName", "()Ljava/lang/String;", "toTargetClassMethodName$delegate", "fromTargetClassMethodName", "getFromTargetClassMethodName", "fromTargetClassMethodName$delegate", "serializableReferenceType", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "getSerializableReferenceType", "()Lcom/google/devtools/ksp/symbol/KSTypeReference;", "serializableReferenceType$delegate", "validate", "allowSerializableInterfaceTypes", "factoryClassName", "Lcom/squareup/kotlinpoet/ClassName;", "getFactoryClassName", "()Lcom/squareup/kotlinpoet/ClassName;", "factoryClassName$delegate", "validateProxyHasToTargetClassMethod", "", "validateProxyHasFromTargetClassMethod", "getFactoryCodeBuilder", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType$FactoryCodeBuilder;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "component1", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "ResolvedAnnotatedSerializableProxies", "AppFunctionSerializableProxyFactoryCodeBuilder", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AnnotatedAppFunctionSerializableProxy implements AppFunctionSerializableType {
    private final KSClassDeclaration classDeclaration;

    /* JADX INFO: renamed from: factoryClassName$delegate, reason: from kotlin metadata */
    private final Lazy factoryClassName;

    /* JADX INFO: renamed from: fromTargetClassMethodName$delegate, reason: from kotlin metadata */
    private final Lazy fromTargetClassMethodName;
    private final boolean isDescribedByKDoc;

    /* JADX INFO: renamed from: serializableReferenceType$delegate, reason: from kotlin metadata */
    private final Lazy serializableReferenceType;

    /* JADX INFO: renamed from: targetClassDeclaration$delegate, reason: from kotlin metadata */
    private final Lazy targetClassDeclaration;

    /* JADX INFO: renamed from: toTargetClassMethodName$delegate, reason: from kotlin metadata */
    private final Lazy toTargetClassMethodName;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$AppFunctionSerializableProxyFactoryCodeBuilder;", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType$FactoryCodeBuilder;", "annotatedProxyClass", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "<init>", "(Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy;Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;)V", "getAnnotatedProxyClass", "()Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy;", "getResolvedAnnotatedSerializableProxies", "()Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "buildAppFunctionSerializableFactoryClass", "Lcom/squareup/kotlinpoet/FileSpec;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionSerializableProxyFactoryCodeBuilder implements AppFunctionSerializableType.FactoryCodeBuilder {
        private final AnnotatedAppFunctionSerializableProxy annotatedProxyClass;
        private final ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies;

        public AppFunctionSerializableProxyFactoryCodeBuilder(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy, ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) {
            annotatedAppFunctionSerializableProxy.getClass();
            resolvedAnnotatedSerializableProxies.getClass();
            this.annotatedProxyClass = annotatedAppFunctionSerializableProxy;
            this.resolvedAnnotatedSerializableProxies = resolvedAnnotatedSerializableProxies;
        }

        @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType.FactoryCodeBuilder
        public FileSpec buildAppFunctionSerializableFactoryClass() {
            ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.INSTANCE.get(IntrospectionHelper.AppFunctionSerializableFactoryClass.INSTANCE.getCLASS_NAME(), KspUtilsKt.toClassName(this.annotatedProxyClass.getTargetClassDeclaration()));
            TypeSpec.Builder builderClassBuilder = TypeSpec.INSTANCE.classBuilder(this.annotatedProxyClass.getFactoryClassName());
            AppFunctionSerializableFactoryCodeBuilderHelper appFunctionSerializableFactoryCodeBuilderHelper = new AppFunctionSerializableFactoryCodeBuilderHelper(this.annotatedProxyClass, this.resolvedAnnotatedSerializableProxies);
            builderClassBuilder.addAnnotation(IntrospectionHelper.INSTANCE.getRESTRICT_API_TO_33_ANNOTATION());
            builderClassBuilder.addAnnotation(AppFunctionCompiler.INSTANCE.getGENERATED_ANNOTATION$appfunctions_compiler());
            TypeSpec.Builder.addSuperinterface$default(builderClassBuilder, parameterizedTypeName, null, 2, null);
            KspUtilsKt.toClassName(this.annotatedProxyClass.getTargetClassDeclaration());
            AppFunctionSerializableFactoryCodeBuilderHelper.Companion companion = AppFunctionSerializableFactoryCodeBuilderHelper.INSTANCE;
            builderClassBuilder.addFunction(companion.buildFromAppFunctionDataFunction(appFunctionSerializableFactoryCodeBuilderHelper.buildFromAppFunctionDataMethodBodyForProxy(), KspUtilsKt.toClassName(this.annotatedProxyClass.getTargetClassDeclaration())));
            builderClassBuilder.addFunction(companion.buildToAppFunctionDataFunction(appFunctionSerializableFactoryCodeBuilderHelper.buildToAppFunctionDataMethodBodyForProxy(), KspUtilsKt.toClassName(this.annotatedProxyClass.getTargetClassDeclaration())));
            return FileSpec.INSTANCE.builder(this.annotatedProxyClass.getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName().getPackageName(), this.annotatedProxyClass.getFactoryClassName().getSimpleName()).addType(builderClassBuilder.build()).build();
        }

        public final AnnotatedAppFunctionSerializableProxy getAnnotatedProxyClass() {
            return this.annotatedProxyClass;
        }

        public final ResolvedAnnotatedSerializableProxies getResolvedAnnotatedSerializableProxies() {
            return this.resolvedAnnotatedSerializableProxies;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "", "resolvedAnnotatedSerializableProxies", "", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy;", "<init>", "(Ljava/util/List;)V", "getResolvedAnnotatedSerializableProxies", "()Ljava/util/List;", "proxyTargetToSerializableProxy", "", "Lcom/squareup/kotlinpoet/ClassName;", "getProxyTargetToSerializableProxy", "()Ljava/util/Map;", "proxyTargetToSerializableProxy$delegate", "Lkotlin/Lazy;", "getSerializableProxyForTypeReference", "appFunctionTypeReference", "Landroidx/appfunctions/compiler/core/AppFunctionTypeReference;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ResolvedAnnotatedSerializableProxies {

        /* JADX INFO: renamed from: proxyTargetToSerializableProxy$delegate, reason: from kotlin metadata */
        private final Lazy proxyTargetToSerializableProxy;
        private final List<AnnotatedAppFunctionSerializableProxy> resolvedAnnotatedSerializableProxies;

        public ResolvedAnnotatedSerializableProxies(List<AnnotatedAppFunctionSerializableProxy> list) {
            list.getClass();
            this.resolvedAnnotatedSerializableProxies = list;
            this.proxyTargetToSerializableProxy = LazyKt.lazy(new AppFunctionPropertyDeclaration$$ExternalSyntheticLambda1(this, 2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResolvedAnnotatedSerializableProxies copy$default(ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = resolvedAnnotatedSerializableProxies.resolvedAnnotatedSerializableProxies;
            }
            return resolvedAnnotatedSerializableProxies.copy(list);
        }

        private final Map<ClassName, AnnotatedAppFunctionSerializableProxy> getProxyTargetToSerializableProxy() {
            return (Map) this.proxyTargetToSerializableProxy.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map proxyTargetToSerializableProxy_delegate$lambda$0(ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) {
            List<AnnotatedAppFunctionSerializableProxy> list = resolvedAnnotatedSerializableProxies.resolvedAnnotatedSerializableProxies;
            LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) list, 10, 16));
            for (Object obj : list) {
                linkedHashMap.put(KspUtilsKt.toClassName(((AnnotatedAppFunctionSerializableProxy) obj).getTargetClassDeclaration()), obj);
            }
            return linkedHashMap;
        }

        public final List<AnnotatedAppFunctionSerializableProxy> component1() {
            return this.resolvedAnnotatedSerializableProxies;
        }

        public final ResolvedAnnotatedSerializableProxies copy(List<AnnotatedAppFunctionSerializableProxy> resolvedAnnotatedSerializableProxies) {
            resolvedAnnotatedSerializableProxies.getClass();
            return new ResolvedAnnotatedSerializableProxies(resolvedAnnotatedSerializableProxies);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ResolvedAnnotatedSerializableProxies) && Intrinsics.areEqual(this.resolvedAnnotatedSerializableProxies, ((ResolvedAnnotatedSerializableProxies) other).resolvedAnnotatedSerializableProxies);
        }

        public final List<AnnotatedAppFunctionSerializableProxy> getResolvedAnnotatedSerializableProxies() {
            return this.resolvedAnnotatedSerializableProxies;
        }

        public final AnnotatedAppFunctionSerializableProxy getSerializableProxyForTypeReference(AppFunctionTypeReference appFunctionTypeReference) {
            appFunctionTypeReference.getClass();
            appFunctionTypeReference.getSelfOrItemTypeReference();
            throw null;
        }

        public int hashCode() {
            return this.resolvedAnnotatedSerializableProxies.hashCode();
        }

        public String toString() {
            return "ResolvedAnnotatedSerializableProxies(resolvedAnnotatedSerializableProxies=" + this.resolvedAnnotatedSerializableProxies + ")";
        }
    }

    public AnnotatedAppFunctionSerializableProxy(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        this.classDeclaration = kSClassDeclaration;
        final int i = 0;
        this.targetClassDeclaration = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy$$ExternalSyntheticLambda3
            public final /* synthetic */ AnnotatedAppFunctionSerializableProxy f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy = this.f$0;
                switch (i2) {
                    case 0:
                        return AnnotatedAppFunctionSerializableProxy.targetClassDeclaration_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 1:
                        return AnnotatedAppFunctionSerializableProxy.toTargetClassMethodName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 2:
                        return AnnotatedAppFunctionSerializableProxy.fromTargetClassMethodName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 3:
                        AnnotatedAppFunctionSerializableProxy.serializableReferenceType_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                        return null;
                    default:
                        return AnnotatedAppFunctionSerializableProxy.factoryClassName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                }
            }
        });
        final int i2 = 1;
        this.toTargetClassMethodName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy$$ExternalSyntheticLambda3
            public final /* synthetic */ AnnotatedAppFunctionSerializableProxy f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i2;
                AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy = this.f$0;
                switch (i22) {
                    case 0:
                        return AnnotatedAppFunctionSerializableProxy.targetClassDeclaration_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 1:
                        return AnnotatedAppFunctionSerializableProxy.toTargetClassMethodName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 2:
                        return AnnotatedAppFunctionSerializableProxy.fromTargetClassMethodName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 3:
                        AnnotatedAppFunctionSerializableProxy.serializableReferenceType_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                        return null;
                    default:
                        return AnnotatedAppFunctionSerializableProxy.factoryClassName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                }
            }
        });
        final int i3 = 2;
        this.fromTargetClassMethodName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy$$ExternalSyntheticLambda3
            public final /* synthetic */ AnnotatedAppFunctionSerializableProxy f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i3;
                AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy = this.f$0;
                switch (i22) {
                    case 0:
                        return AnnotatedAppFunctionSerializableProxy.targetClassDeclaration_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 1:
                        return AnnotatedAppFunctionSerializableProxy.toTargetClassMethodName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 2:
                        return AnnotatedAppFunctionSerializableProxy.fromTargetClassMethodName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 3:
                        AnnotatedAppFunctionSerializableProxy.serializableReferenceType_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                        return null;
                    default:
                        return AnnotatedAppFunctionSerializableProxy.factoryClassName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                }
            }
        });
        final int i4 = 3;
        this.serializableReferenceType = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy$$ExternalSyntheticLambda3
            public final /* synthetic */ AnnotatedAppFunctionSerializableProxy f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i4;
                AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy = this.f$0;
                switch (i22) {
                    case 0:
                        return AnnotatedAppFunctionSerializableProxy.targetClassDeclaration_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 1:
                        return AnnotatedAppFunctionSerializableProxy.toTargetClassMethodName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 2:
                        return AnnotatedAppFunctionSerializableProxy.fromTargetClassMethodName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 3:
                        AnnotatedAppFunctionSerializableProxy.serializableReferenceType_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                        return null;
                    default:
                        return AnnotatedAppFunctionSerializableProxy.factoryClassName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                }
            }
        });
        final int i5 = 4;
        this.factoryClassName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy$$ExternalSyntheticLambda3
            public final /* synthetic */ AnnotatedAppFunctionSerializableProxy f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i5;
                AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy = this.f$0;
                switch (i22) {
                    case 0:
                        return AnnotatedAppFunctionSerializableProxy.targetClassDeclaration_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 1:
                        return AnnotatedAppFunctionSerializableProxy.toTargetClassMethodName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 2:
                        return AnnotatedAppFunctionSerializableProxy.fromTargetClassMethodName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                    case 3:
                        AnnotatedAppFunctionSerializableProxy.serializableReferenceType_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                        return null;
                    default:
                        return AnnotatedAppFunctionSerializableProxy.factoryClassName_delegate$lambda$0(annotatedAppFunctionSerializableProxy);
                }
            }
        });
    }

    public static /* synthetic */ AnnotatedAppFunctionSerializableProxy copy$default(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy, KSClassDeclaration kSClassDeclaration, int i, Object obj) {
        if ((i & 1) != 0) {
            kSClassDeclaration = annotatedAppFunctionSerializableProxy.classDeclaration;
        }
        return annotatedAppFunctionSerializableProxy.copy(kSClassDeclaration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClassName factoryClassName_delegate$lambda$0(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy) {
        return new ClassName(annotatedAppFunctionSerializableProxy.getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName().getPackageName(), FileInsert$$ExternalSyntheticOutline0.m("$", KspUtilsKt.getJvmClassName(annotatedAppFunctionSerializableProxy.getTargetClassDeclaration()), "Factory"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String fromTargetClassMethodName_delegate$lambda$0(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy) {
        annotatedAppFunctionSerializableProxy.getTargetClassDeclaration().getSimpleName();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSTypeReference serializableReferenceType_delegate$lambda$0(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy) {
        Sequence sequenceFilter = SequencesKt.filter(annotatedAppFunctionSerializableProxy.getClassDeclaration().getDeclarations(), new Function1<Object, Boolean>() { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy$serializableReferenceType_delegate$lambda$0$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return false;
            }
        });
        sequenceFilter.getClass();
        SequencesKt.first(SequencesKt.filter(((KSClassDeclaration) SequencesKt.single(SequencesKt.filter(sequenceFilter, new StringUtilsKt$$ExternalSyntheticLambda0(3)))).getAllFunctions(), new AnnotatedAppFunctionSerializableProxy$$ExternalSyntheticLambda0(annotatedAppFunctionSerializableProxy, 1))).getClass();
        throw new ClassCastException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean serializableReferenceType_delegate$lambda$0$0(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        return kSClassDeclaration.isCompanionObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean serializableReferenceType_delegate$lambda$0$1(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy, KSFunctionDeclaration kSFunctionDeclaration) {
        kSFunctionDeclaration.getClass();
        kSFunctionDeclaration.getSimpleName();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSClassDeclaration targetClassDeclaration_delegate$lambda$0(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy) throws ProcessingException {
        KspUtilsKt.findAnnotation(annotatedAppFunctionSerializableProxy.getClassDeclaration().getAnnotations(), IntrospectionHelper.AppFunctionSerializableProxyAnnotation.INSTANCE.getCLASS_NAME());
        throw new ProcessingException("Class Must have @AppFunctionSerializableProxy annotation", annotatedAppFunctionSerializableProxy.getClassDeclaration(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toTargetClassMethodName_delegate$lambda$0(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy) {
        annotatedAppFunctionSerializableProxy.getTargetClassDeclaration().getSimpleName();
        throw null;
    }

    private final void validateProxyHasFromTargetClassMethod() {
        getTargetClassDeclaration().getSimpleName();
        throw new IllegalStateException("Required value was null.");
    }

    private static final boolean validateProxyHasFromTargetClassMethod$lambda$0(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        return kSClassDeclaration.isCompanionObject();
    }

    private static final boolean validateProxyHasFromTargetClassMethod$lambda$1(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy, KSFunctionDeclaration kSFunctionDeclaration) {
        kSFunctionDeclaration.getClass();
        kSFunctionDeclaration.getSimpleName();
        throw null;
    }

    private final void validateProxyHasToTargetClassMethod() throws ProcessingException {
        List list = SequencesKt.toList(SequencesKt.filter(getClassDeclaration().getAllFunctions(), new AnnotatedAppFunctionSerializableProxy$$ExternalSyntheticLambda0(this, 0)));
        if (list.size() != 1) {
            throw new ProcessingException(FileInsert$$ExternalSyntheticOutline0.m("Class must have exactly one member function: ", getToTargetClassMethodName()), getClassDeclaration(), null, 4, null);
        }
        CollectionsKt.first(list).getClass();
        throw new ClassCastException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean validateProxyHasToTargetClassMethod$lambda$0(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy, KSFunctionDeclaration kSFunctionDeclaration) {
        kSFunctionDeclaration.getClass();
        kSFunctionDeclaration.getSimpleName();
        throw null;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final KSClassDeclaration getClassDeclaration() {
        return this.classDeclaration;
    }

    public final AnnotatedAppFunctionSerializableProxy copy(KSClassDeclaration classDeclaration) {
        classDeclaration.getClass();
        return new AnnotatedAppFunctionSerializableProxy(classDeclaration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnnotatedAppFunctionSerializableProxy) && Intrinsics.areEqual(this.classDeclaration, ((AnnotatedAppFunctionSerializableProxy) other).classDeclaration);
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public KSClassDeclaration getClassDeclaration() {
        return this.classDeclaration;
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public ClassName getFactoryClassName() {
        return (ClassName) this.factoryClassName.getValue();
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public AppFunctionSerializableType.FactoryCodeBuilder getFactoryCodeBuilder(ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) {
        resolvedAnnotatedSerializableProxies.getClass();
        return new AppFunctionSerializableProxyFactoryCodeBuilder(this, resolvedAnnotatedSerializableProxies);
    }

    public final String getFromTargetClassMethodName() {
        return (String) this.fromTargetClassMethodName.getValue();
    }

    public final KSTypeReference getSerializableReferenceType() {
        if (this.serializableReferenceType.getValue() == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public final KSClassDeclaration getTargetClassDeclaration() {
        return (KSClassDeclaration) this.targetClassDeclaration.getValue();
    }

    public final String getToTargetClassMethodName() {
        return (String) this.toTargetClassMethodName.getValue();
    }

    public int hashCode() {
        return this.classDeclaration.hashCode();
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    /* JADX INFO: renamed from: isDescribedByKDoc, reason: from getter */
    public boolean getIsDescribedByKDoc() {
        return this.isDescribedByKDoc;
    }

    public String toString() {
        return "AnnotatedAppFunctionSerializableProxy(classDeclaration=" + this.classDeclaration + ")";
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public AnnotatedAppFunctionSerializableProxy validate(boolean allowSerializableInterfaceTypes) throws ProcessingException {
        AppFunctionSerializableValidateHelper appFunctionSerializableValidateHelper = new AppFunctionSerializableValidateHelper(this);
        appFunctionSerializableValidateHelper.validatePrimaryConstructor();
        appFunctionSerializableValidateHelper.validateParameters(allowSerializableInterfaceTypes);
        validateProxyHasToTargetClassMethod();
        validateProxyHasFromTargetClassMethod();
        return this;
    }
}
