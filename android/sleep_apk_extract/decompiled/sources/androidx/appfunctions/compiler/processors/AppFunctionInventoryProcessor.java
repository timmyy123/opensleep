package androidx.appfunctions.compiler.processors;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctions;
import androidx.appfunctions.compiler.core.AppFunctionComponentRegistryGenerator;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSFile;
import com.squareup.kotlinpoet.CodeBlock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionInventoryProcessor;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;)V", "hasProcessed", "", "process", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "generateAppFunctionInventoryClass", "", "appFunctionClass", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "buildSourceFilesKdoc", "Lcom/squareup/kotlinpoet/CodeBlock;", "getAppFunctionInventoryClassName", "functionClassName", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionInventoryProcessor implements SymbolProcessor {
    public static final String APP_FUNCTION_METADATA_PROPERTY_NAME = "APP_FUNCTION_METADATA";
    public static final String COMPONENT_METADATA_PROPERTY_NAME = "COMPONENTS_METADATA";
    public static final String DEPRECATION_METADATA_PROPERTY_NAME = "DEPRECATION_METADATA";
    public static final String FUNCTION_ID_TO_METADATA_MAP_PROPERTY_NAME = "functionIdToMetadataMap";
    public static final String INVENTORY_COMPONENTS_METADATA_PROPERTY_NAME = "componentsMetadata";
    public static final String PARAMETER_METADATA_LIST_PROPERTY_NAME = "PARAMETER_METADATA_LIST";
    public static final String RESPONSE_METADATA_PROPERTY_NAME = "RESPONSE_METADATA";
    public static final String SCHEMA_METADATA_PROPERTY_NAME = "SCHEMA_METADATA";
    private final CodeGenerator codeGenerator;
    private boolean hasProcessed;

    public AppFunctionInventoryProcessor(CodeGenerator codeGenerator) {
        codeGenerator.getClass();
    }

    private final CodeBlock buildSourceFilesKdoc(AnnotatedAppFunctions appFunctionClass) {
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("Source Files:", new Object[0]);
        Iterator<KSFile> it = appFunctionClass.getSourceFiles().iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        return builder.build();
    }

    private final String generateAppFunctionInventoryClass(AnnotatedAppFunctions appFunctionClass, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) {
        appFunctionClass.getClassDeclaration().getPackageName();
        throw null;
    }

    private final String getAppFunctionInventoryClassName(String functionClassName) {
        return String.format("$%s_AppFunctionInventory", Arrays.copyOf(new Object[]{functionClassName}, 1));
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
        AppFunctionSymbolResolver appFunctionSymbolResolver = new AppFunctionSymbolResolver(resolver);
        List<AnnotatedAppFunctions> listResolveAnnotatedAppFunctions = appFunctionSymbolResolver.resolveAnnotatedAppFunctions();
        AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies = new AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies(appFunctionSymbolResolver.resolveAllAnnotatedSerializableProxiesFromModule());
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (AnnotatedAppFunctions annotatedAppFunctions : listResolveAnnotatedAppFunctions) {
            listCreateListBuilder.add(new AppFunctionComponentRegistryGenerator.AppFunctionComponent(generateAppFunctionInventoryClass(annotatedAppFunctions, resolvedAnnotatedSerializableProxies), annotatedAppFunctions.getSourceFiles(), null, 4, null));
        }
        CollectionsKt.build(listCreateListBuilder);
        new AppFunctionComponentRegistryGenerator(null);
        resolver.getModuleName();
        throw null;
    }
}
