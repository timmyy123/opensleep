package androidx.appfunctions.compiler.processors;

import androidx.appfunctions.compiler.AppFunctionCompilerOptions;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctions;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import androidx.appfunctions.compiler.core.AppFunctionXmlGenerator;
import androidx.appfunctions.compiler.core.ProcessingException;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.KSPLogger;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.symbol.KSAnnotated;
import java.util.List;
import java.util.Map;
import javax.xml.transform.TransformerConfigurationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J2\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J2\u0010\u0018\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionIndexXmlProcessor;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Landroidx/appfunctions/compiler/AppFunctionCompilerOptions;", "logger", "Lcom/google/devtools/ksp/processing/KSPLogger;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;Landroidx/appfunctions/compiler/AppFunctionCompilerOptions;Lcom/google/devtools/ksp/processing/KSPLogger;)V", "process", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "generateIndexXml", "", "appFunctionsByClass", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "appFunctionSerializablesDescriptionMap", "", "", "writeXmlFile", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionIndexXmlProcessor implements SymbolProcessor {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String XML_FILE_NAME = "app_functions_v2";

    @Deprecated
    public static final String XML_PACKAGE_NAME = "assets";
    private final CodeGenerator codeGenerator;
    private final KSPLogger logger;
    private final AppFunctionCompilerOptions options;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionIndexXmlProcessor$Companion;", "", "<init>", "()V", "XML_PACKAGE_NAME", "", "XML_FILE_NAME", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AppFunctionIndexXmlProcessor(CodeGenerator codeGenerator, AppFunctionCompilerOptions appFunctionCompilerOptions, KSPLogger kSPLogger) {
        codeGenerator.getClass();
        appFunctionCompilerOptions.getClass();
        kSPLogger.getClass();
        this.options = appFunctionCompilerOptions;
    }

    private final void generateIndexXml(List<AnnotatedAppFunctions> appFunctionsByClass, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map<String, String> appFunctionSerializablesDescriptionMap) throws TransformerConfigurationException, ProcessingException {
        writeXmlFile(appFunctionsByClass, resolvedAnnotatedSerializableProxies, appFunctionSerializablesDescriptionMap);
    }

    private final void writeXmlFile(List<AnnotatedAppFunctions> appFunctionsByClass, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map<String, String> appFunctionSerializablesDescriptionMap) throws TransformerConfigurationException, ProcessingException {
        new AppFunctionXmlGenerator(null, null).generateXml(appFunctionsByClass, resolvedAnnotatedSerializableProxies, appFunctionSerializablesDescriptionMap, "assets", XML_FILE_NAME, this.options.getAppFunctionsXmlLocation());
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
        AppFunctionSymbolResolver appFunctionSymbolResolver = new AppFunctionSymbolResolver(resolver);
        generateIndexXml(appFunctionSymbolResolver.getAnnotatedAppFunctionsFromAllModules(), new AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies(appFunctionSymbolResolver.resolveAllAnnotatedSerializableProxiesFromModule()), appFunctionSymbolResolver.getAppFunctionSerializablesDescriptionMap());
        return CollectionsKt.emptyList();
    }
}
