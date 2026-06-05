package androidx.appfunctions.compiler.processors;

import androidx.appfunctions.compiler.AppFunctionCompiler;
import androidx.appfunctions.compiler.AppFunctionCompilerOptions;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSchemaDefinition;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AppFunctionInventoryCodeBuilder;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.ProcessingException;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Dependencies;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSFile;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.TypeSpec;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionSchemaInventoryProcessor;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Landroidx/appfunctions/compiler/AppFunctionCompilerOptions;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;Landroidx/appfunctions/compiler/AppFunctionCompilerOptions;)V", "hasProcessed", "", "process", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "generateSchemaAppFunctionInventoryClass", "", "schemaDefinitions", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSchemaDefinition;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "shouldProcess", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionSchemaInventoryProcessor implements SymbolProcessor {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String SCHEMA_INVENTORY_CLASS_NAME = "$SchemaAppFunctionInventory_Impl";
    private final CodeGenerator codeGenerator;
    private boolean hasProcessed;
    private final AppFunctionCompilerOptions options;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionSchemaInventoryProcessor$Companion;", "", "<init>", "()V", "SCHEMA_INVENTORY_CLASS_NAME", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AppFunctionSchemaInventoryProcessor(CodeGenerator codeGenerator, AppFunctionCompilerOptions appFunctionCompilerOptions) {
        codeGenerator.getClass();
        appFunctionCompilerOptions.getClass();
        this.options = appFunctionCompilerOptions;
    }

    private final void generateSchemaAppFunctionInventoryClass(List<AnnotatedAppFunctionSchemaDefinition> schemaDefinitions, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) throws ProcessingException {
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        String packageName = introspectionHelper.getSCHEMA_APP_FUNCTION_INVENTORY_CLASS().getPackageName();
        TypeSpec.Builder builderClassBuilder = TypeSpec.INSTANCE.classBuilder(SCHEMA_INVENTORY_CLASS_NAME);
        builderClassBuilder.superclass(introspectionHelper.getSCHEMA_APP_FUNCTION_INVENTORY_CLASS());
        builderClassBuilder.addAnnotation(AppFunctionCompiler.INSTANCE.getGENERATED_ANNOTATION$appfunctions_compiler());
        AppFunctionInventoryCodeBuilder appFunctionInventoryCodeBuilder = new AppFunctionInventoryCodeBuilder(builderClassBuilder);
        List<AnnotatedAppFunctionSchemaDefinition> list = schemaDefinitions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AnnotatedAppFunctionSchemaDefinition) it.next()).createAppFunctionMetadata(resolvedAnnotatedSerializableProxies));
        }
        appFunctionInventoryCodeBuilder.addFunctionMetadataProperties(arrayList);
        FileSpec fileSpecBuild = FileSpec.INSTANCE.builder(packageName, SCHEMA_INVENTORY_CLASS_NAME).addType(builderClassBuilder.build()).build();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, ((AnnotatedAppFunctionSchemaDefinition) it2.next()).getSourceFiles());
        }
        KSFile[] kSFileArr = (KSFile[]) arrayList2.toArray(new KSFile[0]);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(CodeGenerator.createNewFile$default(null, new Dependencies(true, (KSFile[]) Arrays.copyOf(kSFileArr, kSFileArr.length)), packageName, SCHEMA_INVENTORY_CLASS_NAME, null, 8, null), Charsets.UTF_8), Utility.DEFAULT_STREAM_BUFFER_SIZE);
        try {
            fileSpecBuild.writeTo(bufferedWriter);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
        } finally {
        }
    }

    private final boolean shouldProcess(Resolver resolver) {
        return new AppFunctionSymbolResolver(resolver).resolveAnnotatedAppFunctionSchemaDefinitions().isEmpty();
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
    public List<KSAnnotated> process(Resolver resolver) throws ProcessingException {
        resolver.getClass();
        if (!this.options.getGenerateMetadataFromSchema()) {
            return CollectionsKt.emptyList();
        }
        if (this.hasProcessed) {
            return CollectionsKt.emptyList();
        }
        if (!shouldProcess(resolver)) {
            return CollectionsKt.emptyList();
        }
        AppFunctionSymbolResolver appFunctionSymbolResolver = new AppFunctionSymbolResolver(resolver);
        generateSchemaAppFunctionInventoryClass(appFunctionSymbolResolver.getAppFunctionSchemaDefinitionFromAllModules(), new AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies(appFunctionSymbolResolver.resolveAllAnnotatedSerializableProxiesFromModule()));
        this.hasProcessed = true;
        return CollectionsKt.emptyList();
    }
}
