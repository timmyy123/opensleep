package androidx.appfunctions.compiler.processors;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctions;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.squareup.kotlinpoet.TypeSpec;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0014\u0010\u0012\u001a\u00020\f*\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionIdProcessor;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;)V", "process", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "generateAppFunctionIdClasses", "", "appFunctionClass", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;", "getAppFunctionIdClassName", "", "functionClassName", "addAppFunctionIdProperties", "Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionIdProcessor implements SymbolProcessor {
    private final CodeGenerator codeGenerator;

    public AppFunctionIdProcessor(CodeGenerator codeGenerator) {
        codeGenerator.getClass();
    }

    private final void addAppFunctionIdProperties(TypeSpec.Builder builder, AnnotatedAppFunctions annotatedAppFunctions) {
        Iterator<KSFunctionDeclaration> it = annotatedAppFunctions.getAppFunctionDeclarations().iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
    }

    private final void generateAppFunctionIdClasses(AnnotatedAppFunctions appFunctionClass) {
        appFunctionClass.getClassDeclaration().getPackageName();
        throw null;
    }

    private final String getAppFunctionIdClassName(String functionClassName) {
        return FileInsert$$ExternalSyntheticOutline0.m$1(functionClassName, "Ids");
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
        Iterator<AnnotatedAppFunctions> it = new AppFunctionSymbolResolver(resolver).resolveAnnotatedAppFunctions().iterator();
        while (it.hasNext()) {
            generateAppFunctionIdClasses(it.next());
        }
        return CollectionsKt.emptyList();
    }
}
