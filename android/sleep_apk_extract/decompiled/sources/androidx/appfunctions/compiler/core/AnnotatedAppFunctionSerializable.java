package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.AppFunctionCompiler;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AppFunctionSerializableType;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.processors.AppFunctionSerializableFactoryCodeBuilderHelper;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSTypeArgument;
import com.google.devtools.ksp.symbol.Modifier;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import com.squareup.kotlinpoet.TypeSpec;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000e\u0010\u0010¨\u0006 "}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializable;", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;)V", "getClassDeclaration", "()Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "factoryVariableName", "", "getFactoryVariableName", "()Ljava/lang/String;", "factoryVariableName$delegate", "Lkotlin/Lazy;", "isDescribedByKDoc", "", "()Z", "isDescribedByKDoc$delegate", "getDescription", "sharedDataTypeDescriptionMap", "", "parameterizedBy", "arguments", "", "Lcom/google/devtools/ksp/symbol/KSTypeArgument;", "validate", "allowSerializableInterfaceTypes", "getFactoryCodeBuilder", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType$FactoryCodeBuilder;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "AnnotatedAppFunctionSerializableFactoryCodeBuilder", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AnnotatedAppFunctionSerializable implements AppFunctionSerializableType {
    private final KSClassDeclaration classDeclaration;

    /* JADX INFO: renamed from: factoryVariableName$delegate, reason: from kotlin metadata */
    private final Lazy factoryVariableName;

    /* JADX INFO: renamed from: isDescribedByKDoc$delegate, reason: from kotlin metadata */
    private final Lazy isDescribedByKDoc;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializable$AnnotatedAppFunctionSerializableFactoryCodeBuilder;", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType$FactoryCodeBuilder;", "annotatedClass", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializable;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "<init>", "(Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializable;Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;)V", "getAnnotatedClass", "()Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializable;", "getResolvedAnnotatedSerializableProxies", "()Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "buildAppFunctionSerializableFactoryClass", "Lcom/squareup/kotlinpoet/FileSpec;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnnotatedAppFunctionSerializableFactoryCodeBuilder implements AppFunctionSerializableType.FactoryCodeBuilder {
        private final AnnotatedAppFunctionSerializable annotatedClass;
        private final AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies;

        public AnnotatedAppFunctionSerializableFactoryCodeBuilder(AnnotatedAppFunctionSerializable annotatedAppFunctionSerializable, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) {
            annotatedAppFunctionSerializable.getClass();
            resolvedAnnotatedSerializableProxies.getClass();
            this.annotatedClass = annotatedAppFunctionSerializable;
            this.resolvedAnnotatedSerializableProxies = resolvedAnnotatedSerializableProxies;
        }

        @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType.FactoryCodeBuilder
        public FileSpec buildAppFunctionSerializableFactoryClass() {
            ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.INSTANCE.get(IntrospectionHelper.AppFunctionSerializableFactoryClass.INSTANCE.getCLASS_NAME(), CollectionsKt.listOf(this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getTypeName()));
            AppFunctionSerializableFactoryCodeBuilderHelper appFunctionSerializableFactoryCodeBuilderHelper = new AppFunctionSerializableFactoryCodeBuilderHelper(this.annotatedClass, this.resolvedAnnotatedSerializableProxies);
            String simpleName = this.annotatedClass.getFactoryClassName().getSimpleName();
            FileSpec.Builder builder = FileSpec.INSTANCE.builder(this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName().getPackageName(), simpleName);
            TypeSpec.Builder builderAddSuperinterface$default = TypeSpec.Builder.addSuperinterface$default(TypeSpec.INSTANCE.classBuilder(simpleName).addAnnotation(IntrospectionHelper.INSTANCE.getRESTRICT_API_TO_33_ANNOTATION()).addAnnotation(AppFunctionCompiler.INSTANCE.getGENERATED_ANNOTATION$appfunctions_compiler()), parameterizedTypeName, null, 2, null);
            if (this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getModifiers().contains(Modifier.INTERNAL)) {
                builderAddSuperinterface$default.addModifiers(KModifier.INTERNAL);
            }
            if (!this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getTypeParameters().isEmpty()) {
                AppFunctionSerializableFactoryCodeBuilderHelper.INSTANCE.setGenericPrimaryConstructor(builderAddSuperinterface$default, this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getTypeParameters());
            }
            AppFunctionSerializableFactoryCodeBuilderHelper.Companion companion = AppFunctionSerializableFactoryCodeBuilderHelper.INSTANCE;
            return builder.addType(builderAddSuperinterface$default.addFunction(companion.buildFromAppFunctionDataFunction(appFunctionSerializableFactoryCodeBuilderHelper.buildFromAppFunctionDataMethodBody(), this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getTypeName())).addFunction(companion.buildToAppFunctionDataFunction(appFunctionSerializableFactoryCodeBuilderHelper.buildToAppFunctionDataMethodBody(), this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getTypeName())).build()).build();
        }

        public final AnnotatedAppFunctionSerializable getAnnotatedClass() {
            return this.annotatedClass;
        }

        public final AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies getResolvedAnnotatedSerializableProxies() {
            return this.resolvedAnnotatedSerializableProxies;
        }
    }

    public AnnotatedAppFunctionSerializable(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        this.classDeclaration = kSClassDeclaration;
        final int i = 0;
        this.factoryVariableName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializable$$ExternalSyntheticLambda1
            public final /* synthetic */ AnnotatedAppFunctionSerializable f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                AnnotatedAppFunctionSerializable annotatedAppFunctionSerializable = this.f$0;
                switch (i2) {
                    case 0:
                        return AnnotatedAppFunctionSerializable.factoryVariableName_delegate$lambda$0(annotatedAppFunctionSerializable);
                    default:
                        return Boolean.valueOf(AnnotatedAppFunctionSerializable.isDescribedByKDoc_delegate$lambda$0(annotatedAppFunctionSerializable));
                }
            }
        });
        final int i2 = 1;
        this.isDescribedByKDoc = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializable$$ExternalSyntheticLambda1
            public final /* synthetic */ AnnotatedAppFunctionSerializable f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i2;
                AnnotatedAppFunctionSerializable annotatedAppFunctionSerializable = this.f$0;
                switch (i22) {
                    case 0:
                        return AnnotatedAppFunctionSerializable.factoryVariableName_delegate$lambda$0(annotatedAppFunctionSerializable);
                    default:
                        return Boolean.valueOf(AnnotatedAppFunctionSerializable.isDescribedByKDoc_delegate$lambda$0(annotatedAppFunctionSerializable));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String factoryVariableName_delegate$lambda$0(AnnotatedAppFunctionSerializable annotatedAppFunctionSerializable) {
        String strReplace$default = StringsKt.replace$default(annotatedAppFunctionSerializable.getAppFunctionSerializableTypeClassDeclaration().getJvmClassName(), "$", "");
        if (strReplace$default.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String strValueOf = String.valueOf(strReplace$default.charAt(0));
            strValueOf.getClass();
            String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            sb.append((Object) lowerCase);
            sb.append(strReplace$default.substring(1));
            strReplace$default = sb.toString();
        }
        return strReplace$default.concat("Factory");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDescribedByKDoc_delegate$lambda$0(AnnotatedAppFunctionSerializable annotatedAppFunctionSerializable) {
        KspUtilsKt.findAnnotation(annotatedAppFunctionSerializable.getClassDeclaration().getAnnotations(), IntrospectionHelper.AppFunctionSerializableAnnotation.INSTANCE.getCLASS_NAME());
        return false;
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public KSClassDeclaration getClassDeclaration() {
        return this.classDeclaration;
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public String getDescription(Map<String, String> sharedDataTypeDescriptionMap) {
        sharedDataTypeDescriptionMap.getClass();
        String docString = getDocString();
        if (docString.length() != 0) {
            return docString;
        }
        String str = sharedDataTypeDescriptionMap.get(getJvmQualifiedName());
        return str == null ? "" : str;
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public AppFunctionSerializableType.FactoryCodeBuilder getFactoryCodeBuilder(AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) {
        resolvedAnnotatedSerializableProxies.getClass();
        return new AnnotatedAppFunctionSerializableFactoryCodeBuilder(this, resolvedAnnotatedSerializableProxies);
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public String getFactoryVariableName() {
        return (String) this.factoryVariableName.getValue();
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    /* JADX INFO: renamed from: isDescribedByKDoc */
    public boolean getIsDescribedByKDoc() {
        return ((Boolean) this.isDescribedByKDoc.getValue()).booleanValue();
    }

    public final AnnotatedAppFunctionSerializable parameterizedBy(List<? extends KSTypeArgument> arguments) {
        arguments.getClass();
        return arguments.isEmpty() ? this : new AnnotatedParameterizedAppFunctionSerializable(getClassDeclaration(), arguments);
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public AnnotatedAppFunctionSerializable validate(boolean allowSerializableInterfaceTypes) throws ProcessingException {
        KspUtilsKt.findAnnotation(getClassDeclaration().getAnnotations(), IntrospectionHelper.AppFunctionSerializableAnnotation.INSTANCE.getCLASS_NAME());
        throw new ProcessingException(FileInsert$$ExternalSyntheticOutline0.m(KspUtilsKt.getJvmClassName(getClassDeclaration()), " cannot be represented as an app function serializable. Did you forget to annotate ", KspUtilsKt.getJvmClassName(getClassDeclaration()), "?"), getClassDeclaration(), null, 4, null);
    }
}
