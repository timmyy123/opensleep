package androidx.appfunctions.compiler.processors;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctions;
import androidx.appfunctions.compiler.core.AppFunctionComponentRegistryGenerator;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.KspUtilsKt;
import androidx.appfunctions.compiler.processors.AppFunctionLegacyIndexXmlProcessor;
import com.google.devtools.ksp.UtilsKt;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.squareup.kotlinpoet.ClassNames;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.FunSpec;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.ParameterSpec;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import com.squareup.kotlinpoet.PropertySpec;
import com.squareup.kotlinpoet.TypeName;
import com.squareup.kotlinpoet.TypeNames;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J,\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\f\u0010\u001e\u001a\u00020\u0007*\u00020\u0010H\u0002J\f\u0010\u001f\u001a\u00020\u0007*\u00020\u001aH\u0002J\u001c\u0010 \u001a\u00020\u000e*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionInvokerProcessor;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;)V", "hasProcessed", "", "process", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "generateAppFunctionInvokerClass", "", "appFunctionClass", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;", "buildSupportedFunctionIdsProperty", "Lcom/squareup/kotlinpoet/PropertySpec;", "annotatedAppFunctions", "buildUnsafeInvokeFunction", "Lcom/squareup/kotlinpoet/FunSpec;", "appendInvocationBranchStatement", "", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "appFunction", "Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "contextSpec", "Lcom/squareup/kotlinpoet/ParameterSpec;", "functionParametersSpec", "containsPublicNoArgConstructor", "isDeprecated", "getAppFunctionParametersStatement", "getAppFunctionInvokerClassName", "functionClassName", "isParametrized", "type", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionInvokerProcessor implements SymbolProcessor {
    private final CodeGenerator codeGenerator;
    private boolean hasProcessed;

    public AppFunctionInvokerProcessor(CodeGenerator codeGenerator) {
        codeGenerator.getClass();
    }

    private final void appendInvocationBranchStatement(CodeBlock.Builder builder, AnnotatedAppFunctions annotatedAppFunctions, KSFunctionDeclaration kSFunctionDeclaration, ParameterSpec parameterSpec, ParameterSpec parameterSpec2) {
        isDeprecated(kSFunctionDeclaration);
        getAppFunctionParametersStatement(kSFunctionDeclaration, parameterSpec, parameterSpec2);
        TuplesKt.to(AppFunctionLegacyIndexXmlProcessor.Companion.XmlElement.APP_FUNCTION_ID_TAG, annotatedAppFunctions.getAppFunctionIdentifier(kSFunctionDeclaration));
        TuplesKt.to("factory_class", IntrospectionHelper.ConfigurableAppFunctionFactoryClass.INSTANCE.getCLASS_NAME());
        TuplesKt.to("enclosing_class", annotatedAppFunctions.getEnclosingClassName());
        TuplesKt.to("context_param", parameterSpec.getName());
        TuplesKt.to("context_property", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME);
        TuplesKt.to("create_method", IntrospectionHelper.ConfigurableAppFunctionFactoryClass.CreateEnclosingClassMethod.METHOD_NAME);
        kSFunctionDeclaration.getSimpleName();
        throw null;
    }

    private final PropertySpec buildSupportedFunctionIdsProperty(AnnotatedAppFunctions annotatedAppFunctions) {
        List<KSFunctionDeclaration> appFunctionDeclarations = annotatedAppFunctions.getAppFunctionDeclarations();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(appFunctionDeclarations, 10));
        Iterator<T> it = appFunctionDeclarations.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            arrayList.add(annotatedAppFunctions.getAppFunctionIdentifier(null));
        }
        PropertySpec.Builder builderAddModifiers = PropertySpec.INSTANCE.builder(IntrospectionHelper.AppFunctionInvokerClass.SUPPORTED_FUNCTION_IDS_PROPERTY_NAME, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(Set.class)), TypeNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(String.class))), new KModifier[0]).addModifiers(KModifier.OVERRIDE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("setOf(", new Object[0]);
        builder.indent();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            builder.addStatement("%S,", (String) it2.next());
        }
        builder.unindent();
        builder.add(")", new Object[0]);
        return builderAddModifiers.initializer(builder.build()).build();
    }

    private final FunSpec buildUnsafeInvokeFunction(AnnotatedAppFunctions annotatedAppFunctions) {
        ParameterSpec.Companion companion = ParameterSpec.INSTANCE;
        ParameterSpec parameterSpecBuild = companion.builder(IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.APPLICATION_CONTEXT_PARAM_NAME, IntrospectionHelper.AppFunctionContextClass.INSTANCE.getCLASS_NAME(), new KModifier[0]).build();
        ParameterSpec parameterSpecBuild2 = companion.builder(IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.FUNCTION_ID_PARAM_NAME, Reflection.getOrCreateKotlinClass(String.class), new KModifier[0]).build();
        ParameterSpec parameterSpecBuild3 = companion.builder(IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(Map.class)), TypeNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(String.class)), TypeName.copy$default(TypeNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(Object.class)), true, null, 2, null)), new KModifier[0]).build();
        FunSpec.Builder builderReturns$default = FunSpec.Builder.returns$default(FunSpec.INSTANCE.builder(IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.METHOD_NAME).addModifiers(KModifier.SUSPEND).addModifiers(KModifier.OVERRIDE).addParameter(parameterSpecBuild).addParameter(parameterSpecBuild2).addParameter(parameterSpecBuild3), TypeName.copy$default(TypeNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(Object.class)), true, null, 2, null), null, 2, null);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement(FileInsert$$ExternalSyntheticOutline0.m("val result: Any? = when (", parameterSpecBuild2.getName(), ") {"), new Object[0]);
        builder.indent();
        Iterator<KSFunctionDeclaration> it = annotatedAppFunctions.getAppFunctionDeclarations().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            appendInvocationBranchStatement(builder, annotatedAppFunctions, null, parameterSpecBuild, parameterSpecBuild3);
        }
        builder.unindent();
        builder.add(StringsKt.trimIndent("\n                else -> {\n                  throw %T(\"Unable to find $" + parameterSpecBuild2.getName() + "\")\n                }\n              }\n              return result\n              "), IntrospectionHelper.INSTANCE.getAPP_FUNCTION_FUNCTION_NOT_FOUND_EXCEPTION_CLASS());
        return builderReturns$default.addCode(builder.build()).build();
    }

    private final boolean containsPublicNoArgConstructor(AnnotatedAppFunctions annotatedAppFunctions) {
        Iterator<KSFunctionDeclaration> it = UtilsKt.getConstructors(annotatedAppFunctions.getClassDeclaration()).iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        return false;
    }

    private final String generateAppFunctionInvokerClass(AnnotatedAppFunctions appFunctionClass) {
        appFunctionClass.getClassDeclaration().getPackageName();
        throw null;
    }

    private final String getAppFunctionInvokerClassName(String functionClassName) {
        return String.format("$%s_AppFunctionInvoker", Arrays.copyOf(new Object[]{functionClassName}, 1));
    }

    private final String getAppFunctionParametersStatement(KSFunctionDeclaration kSFunctionDeclaration, ParameterSpec parameterSpec, ParameterSpec parameterSpec2) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Iterator<T> it = kSFunctionDeclaration.getParameters().iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            if (i != 0) {
                throw null;
            }
            listCreateListBuilder.add(parameterSpec.getName());
            i = i2;
        }
        return CollectionsKt.joinToString$default(CollectionsKt.build(listCreateListBuilder), ", ", null, null, null, 62);
    }

    private final boolean isDeprecated(KSFunctionDeclaration kSFunctionDeclaration) {
        KspUtilsKt.findAnnotation(kSFunctionDeclaration.getAnnotations(), IntrospectionHelper.DeprecatedAnnotation.INSTANCE.getCLASS_NAME());
        return false;
    }

    private final boolean isParametrized(KSTypeReference type) {
        type.resolve();
        throw null;
    }

    @Override // com.google.devtools.ksp.processing.SymbolProcessor
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.google.devtools.ksp.processing.SymbolProcessor
    public /* bridge */ /* synthetic */ void onError() {
        super.onError();
    }

    @Override // com.google.devtools.ksp.processing.SymbolProcessor
    public List<KSAnnotated> process(Resolver resolver) {
        resolver.getClass();
        if (this.hasProcessed) {
            return CollectionsKt.emptyList();
        }
        this.hasProcessed = true;
        List<AnnotatedAppFunctions> listResolveAnnotatedAppFunctions = new AppFunctionSymbolResolver(resolver).resolveAnnotatedAppFunctions();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (AnnotatedAppFunctions annotatedAppFunctions : listResolveAnnotatedAppFunctions) {
            listCreateListBuilder.add(new AppFunctionComponentRegistryGenerator.AppFunctionComponent(generateAppFunctionInvokerClass(annotatedAppFunctions), annotatedAppFunctions.getSourceFiles(), null, 4, null));
        }
        CollectionsKt.build(listCreateListBuilder);
        new AppFunctionComponentRegistryGenerator(null);
        resolver.getModuleName();
        throw null;
    }
}
