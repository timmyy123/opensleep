package androidx.appfunctions.compiler.processors;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.AppFunctionCompiler;
import androidx.appfunctions.compiler.AppFunctionCompilerOptions;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.KspUtilsKt;
import androidx.appfunctions.compiler.core.ProcessingException;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Dependencies;
import com.google.devtools.ksp.processing.KSPLogger;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.squareup.kotlinpoet.ClassNames;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import com.squareup.kotlinpoet.PropertySpec;
import com.squareup.kotlinpoet.TypeSpec;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import javax.xml.transform.TransformerConfigurationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0018\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionAggregateProcessor;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Landroidx/appfunctions/compiler/AppFunctionCompilerOptions;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "logger", "Lcom/google/devtools/ksp/processing/KSPLogger;", "<init>", "(Landroidx/appfunctions/compiler/AppFunctionCompilerOptions;Lcom/google/devtools/ksp/processing/CodeGenerator;Lcom/google/devtools/ksp/processing/KSPLogger;)V", "hasProcessed", "", "process", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "generateAggregatedAppFunctionInventory", "", "buildInventoriesProperty", "Lcom/squareup/kotlinpoet/PropertySpec;", "generatedInventories", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "generateAggregatedAppFunctionInvoker", "buildInvokersProperty", "generatedInvokers", "generateAggregatedIndexXml", "shouldProcess", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionAggregateProcessor implements SymbolProcessor {
    private final CodeGenerator codeGenerator;
    private boolean hasProcessed;
    private final KSPLogger logger;
    private final AppFunctionCompilerOptions options;

    public AppFunctionAggregateProcessor(AppFunctionCompilerOptions appFunctionCompilerOptions, CodeGenerator codeGenerator, KSPLogger kSPLogger) {
        appFunctionCompilerOptions.getClass();
        codeGenerator.getClass();
        kSPLogger.getClass();
        this.options = appFunctionCompilerOptions;
    }

    private final PropertySpec buildInventoriesProperty(List<? extends KSClassDeclaration> generatedInventories) {
        PropertySpec.Builder builderAddModifiers = PropertySpec.INSTANCE.builder(IntrospectionHelper.AggregatedAppFunctionInventoryClass.PROPERTY_INVENTORIES_NAME, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(List.class)), IntrospectionHelper.INSTANCE.getAPP_FUNCTION_INVENTORY_CLASS()), new KModifier[0]).addModifiers(KModifier.OVERRIDE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("listOf(", new Object[0]);
        builder.indent();
        Iterator<? extends KSClassDeclaration> it = generatedInventories.iterator();
        while (it.hasNext()) {
            builder.addStatement("%T(),", KspUtilsKt.toClassName(it.next()));
        }
        builder.unindent();
        builder.addStatement(")", new Object[0]);
        return builderAddModifiers.initializer(builder.build()).build();
    }

    private final PropertySpec buildInvokersProperty(List<? extends KSClassDeclaration> generatedInvokers) {
        PropertySpec.Builder builderAddModifiers = PropertySpec.INSTANCE.builder(IntrospectionHelper.AggregatedAppFunctionInvokerClass.PROPERTY_INVOKERS_NAME, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(List.class)), IntrospectionHelper.AppFunctionInvokerClass.INSTANCE.getCLASS_NAME()), new KModifier[0]).addModifiers(KModifier.OVERRIDE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("listOf(", new Object[0]);
        builder.indent();
        Iterator<? extends KSClassDeclaration> it = generatedInvokers.iterator();
        while (it.hasNext()) {
            builder.addStatement("%T(),", KspUtilsKt.toClassName(it.next()));
        }
        builder.unindent();
        builder.addStatement(")", new Object[0]);
        return builderAddModifiers.initializer(builder.build()).build();
    }

    private final void generateAggregatedAppFunctionInventory(Resolver resolver) {
        List<KSClassDeclaration> generatedAppFunctionInventories = new AppFunctionSymbolResolver(resolver).getGeneratedAppFunctionInventories();
        IntrospectionHelper.AggregatedAppFunctionInventoryClass aggregatedAppFunctionInventoryClass = IntrospectionHelper.AggregatedAppFunctionInventoryClass.INSTANCE;
        String strM = FileInsert$$ExternalSyntheticOutline0.m("$", aggregatedAppFunctionInventoryClass.getCLASS_NAME().getSimpleName(), "_Impl");
        TypeSpec.Builder builderClassBuilder = TypeSpec.INSTANCE.classBuilder(strM);
        builderClassBuilder.superclass(aggregatedAppFunctionInventoryClass.getCLASS_NAME());
        builderClassBuilder.addAnnotation(AppFunctionCompiler.INSTANCE.getGENERATED_ANNOTATION$appfunctions_compiler());
        builderClassBuilder.addProperty(buildInventoriesProperty(generatedAppFunctionInventories));
        FileSpec fileSpecBuild = FileSpec.INSTANCE.builder(IntrospectionHelper.APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, strM).addType(builderClassBuilder.build()).build();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(CodeGenerator.createNewFile$default(null, Dependencies.INSTANCE.getALL_FILES(), IntrospectionHelper.APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, strM, null, 8, null), Charsets.UTF_8), Utility.DEFAULT_STREAM_BUFFER_SIZE);
        try {
            fileSpecBuild.writeTo(bufferedWriter);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
        } finally {
        }
    }

    private final void generateAggregatedAppFunctionInvoker(Resolver resolver) {
        List<KSClassDeclaration> generatedAppFunctionInvokers = new AppFunctionSymbolResolver(resolver).getGeneratedAppFunctionInvokers();
        IntrospectionHelper.AggregatedAppFunctionInvokerClass aggregatedAppFunctionInvokerClass = IntrospectionHelper.AggregatedAppFunctionInvokerClass.INSTANCE;
        String strM = FileInsert$$ExternalSyntheticOutline0.m("$", aggregatedAppFunctionInvokerClass.getCLASS_NAME().getSimpleName(), "_Impl");
        TypeSpec.Builder builderClassBuilder = TypeSpec.INSTANCE.classBuilder(strM);
        builderClassBuilder.superclass(aggregatedAppFunctionInvokerClass.getCLASS_NAME());
        builderClassBuilder.addAnnotation(AppFunctionCompiler.INSTANCE.getGENERATED_ANNOTATION$appfunctions_compiler());
        builderClassBuilder.addProperty(buildInvokersProperty(generatedAppFunctionInvokers));
        FileSpec fileSpecBuild = FileSpec.INSTANCE.builder(IntrospectionHelper.APP_FUNCTIONS_SERVICE_INTERNAL_PACKAGE_NAME, strM).addType(builderClassBuilder.build()).build();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(CodeGenerator.createNewFile$default(null, Dependencies.INSTANCE.getALL_FILES(), IntrospectionHelper.APP_FUNCTIONS_SERVICE_INTERNAL_PACKAGE_NAME, strM, null, 8, null), Charsets.UTF_8), Utility.DEFAULT_STREAM_BUFFER_SIZE);
        try {
            fileSpecBuild.writeTo(bufferedWriter);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
        } finally {
        }
    }

    private final void generateAggregatedIndexXml(Resolver resolver) throws TransformerConfigurationException, ProcessingException {
        new AppFunctionLegacyIndexXmlProcessor(null, this.options, null).process(resolver);
        new AppFunctionIndexXmlProcessor(null, this.options, null).process(resolver);
    }

    private final boolean shouldProcess(Resolver resolver) {
        return new AppFunctionSymbolResolver(resolver).resolveAnnotatedAppFunctions().isEmpty();
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
    public List<KSAnnotated> process(Resolver resolver) throws TransformerConfigurationException, ProcessingException {
        resolver.getClass();
        if (!this.options.getAggregateAppFunctions()) {
            return CollectionsKt.emptyList();
        }
        if (this.hasProcessed) {
            return CollectionsKt.emptyList();
        }
        if (!shouldProcess(resolver)) {
            return CollectionsKt.emptyList();
        }
        generateAggregatedAppFunctionInventory(resolver);
        generateAggregatedAppFunctionInvoker(resolver);
        generateAggregatedIndexXml(resolver);
        this.hasProcessed = true;
        return CollectionsKt.emptyList();
    }
}
