package androidx.appfunctions.compiler.processors;

import androidx.appfunctions.compiler.core.AnnotatedAppFunctionEntryPoint;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import androidx.appfunctions.compiler.core.AppFunctionXmlGenerator;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.KSPLoggerUtil;
import androidx.appfunctions.compiler.core.ProcessingException;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.KSPLogger;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.FunSpec;
import com.squareup.kotlinpoet.KModifier;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.transform.TransformerConfigurationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionEntryPointProcessor;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "logger", "Lcom/google/devtools/ksp/processing/KSPLogger;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;Lcom/google/devtools/ksp/processing/KSPLogger;)V", "isProcessed", "", "process", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "generateXml", "", "entryPoint", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionEntryPoint;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "descriptionMap", "", "", "generateAppFunctionService", "buildExecuteFunction", "Lcom/squareup/kotlinpoet/FunSpec;", "buildExecuteFunctionBody", "Lcom/squareup/kotlinpoet/CodeBlock;", "Provider", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionEntryPointProcessor implements SymbolProcessor {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String XML_PACKAGE_NAME = "assets";
    private final CodeGenerator codeGenerator;
    private boolean isProcessed;
    private final KSPLogger logger;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionEntryPointProcessor$Companion;", "", "<init>", "()V", "XML_PACKAGE_NAME", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionEntryPointProcessor$Provider;", "", "<init>", "()V", "Lcom/google/devtools/ksp/processing/SymbolProcessorEnvironment;", "environment", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "create", "(Lcom/google/devtools/ksp/processing/SymbolProcessorEnvironment;)Lcom/google/devtools/ksp/processing/SymbolProcessor;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Provider {
        public SymbolProcessor create(SymbolProcessorEnvironment environment) {
            throw null;
        }
    }

    public AppFunctionEntryPointProcessor(CodeGenerator codeGenerator, KSPLogger kSPLogger) {
        codeGenerator.getClass();
        kSPLogger.getClass();
    }

    private final FunSpec buildExecuteFunction(AnnotatedAppFunctionEntryPoint entryPoint) {
        return FunSpec.Builder.returns$default(FunSpec.INSTANCE.builder(IntrospectionHelper.AppFunctionServiceClass.ExecuteFunctionMethod.METHOD_NAME).addModifiers(KModifier.OVERRIDE, KModifier.SUSPEND).addParameter("request", IntrospectionHelper.ExecuteAppFunctionRequestClass.INSTANCE.getCLASS_NAME(), new KModifier[0]), IntrospectionHelper.ExecuteAppFunctionResponseClass.INSTANCE.getCLASS_NAME(), null, 2, null).addCode(buildExecuteFunctionBody(entryPoint)).build();
    }

    private final CodeBlock buildExecuteFunctionBody(AnnotatedAppFunctionEntryPoint entryPoint) {
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.beginControlFlow("return %T.%L(request) { parameters ->", IntrospectionHelper.AppFunctionExecutionDispatcherClass.INSTANCE.getCLASS_NAME(), IntrospectionHelper.AppFunctionExecutionDispatcherClass.ExecuteAppFunctionMethod.METHOD_NAME);
        builder.beginControlFlow("when (request.functionIdentifier)", new Object[0]);
        Iterator<KSFunctionDeclaration> it = entryPoint.getAnnotatedAppFunctions().getAppFunctionDeclarations().iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            builder.beginControlFlow("%S ->", entryPoint.getAnnotatedAppFunctions().getAppFunctionIdentifier(null));
            throw null;
        }
        builder.beginControlFlow("else ->", new Object[0]);
        builder.addStatement("throw %T(\n    \"${request.functionIdentifier} is not available\"\n)", IntrospectionHelper.INSTANCE.getAPP_FUNCTION_FUNCTION_NOT_FOUND_EXCEPTION_CLASS());
        builder.endControlFlow();
        builder.endControlFlow();
        builder.endControlFlow();
        return builder.build();
    }

    private final void generateAppFunctionService(AnnotatedAppFunctionEntryPoint entryPoint) {
        KSClassDeclaration serviceDeclaration = entryPoint.getServiceDeclaration();
        entryPoint.getServiceName();
        serviceDeclaration.getPackageName();
        throw null;
    }

    private final void generateXml(AnnotatedAppFunctionEntryPoint entryPoint, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map<String, String> descriptionMap) throws TransformerConfigurationException, ProcessingException {
        AppFunctionXmlGenerator.generateXml$default(new AppFunctionXmlGenerator(null, null), CollectionsKt.listOf(entryPoint.getAnnotatedAppFunctions()), resolvedAnnotatedSerializableProxies, descriptionMap, "assets", entryPoint.getAppFunctionXmlFileName(), null, 32, null);
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
    public List<KSAnnotated> process(Resolver resolver) throws TransformerConfigurationException {
        resolver.getClass();
        if (this.isProcessed) {
            return CollectionsKt.emptyList();
        }
        this.isProcessed = true;
        AppFunctionSymbolResolver appFunctionSymbolResolver = new AppFunctionSymbolResolver(resolver);
        AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies = new AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies(appFunctionSymbolResolver.resolveAllAnnotatedSerializableProxiesFromModule());
        Map<String, String> appFunctionSerializablesDescriptionMap = appFunctionSymbolResolver.getAppFunctionSerializablesDescriptionMap();
        for (AnnotatedAppFunctionEntryPoint annotatedAppFunctionEntryPoint : appFunctionSymbolResolver.resolveAnnotatedAppFunctionEntryPoints()) {
            try {
                annotatedAppFunctionEntryPoint.validate();
                generateAppFunctionService(annotatedAppFunctionEntryPoint);
                generateXml(annotatedAppFunctionEntryPoint, resolvedAnnotatedSerializableProxies, appFunctionSerializablesDescriptionMap);
            } catch (ProcessingException e) {
                KSPLoggerUtil.logException(null, e);
            }
        }
        return CollectionsKt.emptyList();
    }
}
