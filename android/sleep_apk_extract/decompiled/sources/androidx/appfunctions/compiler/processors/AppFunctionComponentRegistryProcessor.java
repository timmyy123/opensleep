package androidx.appfunctions.compiler.processors;

import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSchemaDefinition;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctions;
import androidx.appfunctions.compiler.core.AppFunctionComponentRegistryGenerator;
import androidx.appfunctions.compiler.core.AppFunctionPropertyDeclaration;
import androidx.appfunctions.compiler.core.AppFunctionSerializableType;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import androidx.appfunctions.compiler.core.KspUtilsKt;
import androidx.appfunctions.compiler.core.ProcessingException;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSDeclaration;
import com.google.devtools.ksp.symbol.KSFile;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionComponentRegistryProcessor;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;)V", "hasProcessed", "", "process", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "generateSerializableComponentRegistry", "", "generateFunctionComponentRegistry", "generateSchemaDefinitionComponentRegistry", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionComponentRegistryProcessor implements SymbolProcessor {
    private final CodeGenerator codeGenerator;
    private boolean hasProcessed;

    public AppFunctionComponentRegistryProcessor(CodeGenerator codeGenerator) {
        codeGenerator.getClass();
    }

    private final void generateFunctionComponentRegistry(Resolver resolver) throws ProcessingException {
        List<AnnotatedAppFunctions> listResolveAnnotatedAppFunctions = new AppFunctionSymbolResolver(resolver).resolveAnnotatedAppFunctions();
        ArrayList arrayList = new ArrayList();
        for (AnnotatedAppFunctions annotatedAppFunctions : listResolveAnnotatedAppFunctions) {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            Iterator<KSFunctionDeclaration> it = annotatedAppFunctions.getAppFunctionDeclarations().iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                String strEnsureQualifiedName = KspUtilsKt.ensureQualifiedName((KSDeclaration) null);
                Set<KSFile> sourceFiles = annotatedAppFunctions.getSourceFiles();
                if (annotatedAppFunctions.isDescribedByKDoc(null)) {
                    throw null;
                }
                listCreateListBuilder.add(new AppFunctionComponentRegistryGenerator.AppFunctionComponent(strEnsureQualifiedName, sourceFiles, ""));
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, CollectionsKt.build(listCreateListBuilder));
        }
        new AppFunctionComponentRegistryGenerator(null);
        resolver.getModuleName();
        throw null;
    }

    private final void generateSchemaDefinitionComponentRegistry(Resolver resolver) {
        List<AnnotatedAppFunctionSchemaDefinition> listResolveAnnotatedAppFunctionSchemaDefinitions = new AppFunctionSymbolResolver(resolver).resolveAnnotatedAppFunctionSchemaDefinitions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listResolveAnnotatedAppFunctionSchemaDefinitions, 10));
        for (AnnotatedAppFunctionSchemaDefinition annotatedAppFunctionSchemaDefinition : listResolveAnnotatedAppFunctionSchemaDefinitions) {
            arrayList.add(new AppFunctionComponentRegistryGenerator.AppFunctionComponent(annotatedAppFunctionSchemaDefinition.getQualifiedName(), annotatedAppFunctionSchemaDefinition.getSourceFiles(), null, 4, null));
        }
        new AppFunctionComponentRegistryGenerator(null);
        resolver.getModuleName();
        throw null;
    }

    private final void generateSerializableComponentRegistry(Resolver resolver) {
        List<AppFunctionSerializableType> listResolveAnnotatedAppFunctionSerializables = new AppFunctionSymbolResolver(resolver).resolveAnnotatedAppFunctionSerializables();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (AppFunctionSerializableType appFunctionSerializableType : listResolveAnnotatedAppFunctionSerializables) {
            listCreateListBuilder.add(new AppFunctionComponentRegistryGenerator.AppFunctionComponent(appFunctionSerializableType.getJvmQualifiedName(), null, appFunctionSerializableType.getIsDescribedByKDoc() ? AppFunctionSerializableType.getDescription$default(appFunctionSerializableType, null, 1, null) : "", 2, null));
            for (AppFunctionPropertyDeclaration appFunctionPropertyDeclaration : AppFunctionSerializableType.getProperties$default(appFunctionSerializableType, null, 1, null)) {
                listCreateListBuilder.add(new AppFunctionComponentRegistryGenerator.AppFunctionComponent(appFunctionPropertyDeclaration.getQualifiedName(), null, appFunctionPropertyDeclaration.getDescription(), 2, null));
            }
        }
        CollectionsKt.build(listCreateListBuilder);
        new AppFunctionComponentRegistryGenerator(null);
        resolver.getModuleName();
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
    public List<KSAnnotated> process(Resolver resolver) throws ProcessingException {
        resolver.getClass();
        if (this.hasProcessed) {
            return CollectionsKt.emptyList();
        }
        this.hasProcessed = true;
        generateFunctionComponentRegistry(resolver);
        generateSerializableComponentRegistry(resolver);
        generateSchemaDefinitionComponentRegistry(resolver);
        return CollectionsKt.emptyList();
    }
}
