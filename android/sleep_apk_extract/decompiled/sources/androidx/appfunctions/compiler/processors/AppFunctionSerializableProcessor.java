package androidx.appfunctions.compiler.processors;

import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AppFunctionSerializableType;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import androidx.appfunctions.compiler.core.KSPLoggerUtil;
import androidx.appfunctions.compiler.core.ProcessingException;
import com.facebook.internal.Utility;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Dependencies;
import com.google.devtools.ksp.processing.KSPLogger;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSFile;
import com.squareup.kotlinpoet.FileSpec;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionSerializableProcessor;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "logger", "Lcom/google/devtools/ksp/processing/KSPLogger;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;Lcom/google/devtools/ksp/processing/KSPLogger;)V", "hasProcessed", "", "process", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "writeFile", "", "serializable", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "fileSpec", "Lcom/squareup/kotlinpoet/FileSpec;", "Provider", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionSerializableProcessor implements SymbolProcessor {
    private final CodeGenerator codeGenerator;
    private boolean hasProcessed;
    private final KSPLogger logger;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionSerializableProcessor$Provider;", "", "<init>", "()V", "Lcom/google/devtools/ksp/processing/SymbolProcessorEnvironment;", "environment", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "create", "(Lcom/google/devtools/ksp/processing/SymbolProcessorEnvironment;)Lcom/google/devtools/ksp/processing/SymbolProcessor;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Provider {
        public SymbolProcessor create(SymbolProcessorEnvironment environment) {
            throw null;
        }
    }

    public AppFunctionSerializableProcessor(CodeGenerator codeGenerator, KSPLogger kSPLogger) {
        codeGenerator.getClass();
        kSPLogger.getClass();
    }

    private final void writeFile(AppFunctionSerializableType serializable, FileSpec fileSpec) {
        KSFile[] kSFileArr = (KSFile[]) serializable.getSerializableSourceFiles().toArray(new KSFile[0]);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(CodeGenerator.createNewFile$default(null, new Dependencies(true, (KSFile[]) Arrays.copyOf(kSFileArr, kSFileArr.length)), fileSpec.getPackageName(), fileSpec.getName(), null, 8, null), Charsets.UTF_8), Utility.DEFAULT_STREAM_BUFFER_SIZE);
        try {
            fileSpec.writeTo(bufferedWriter);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
        } finally {
        }
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
        try {
            AppFunctionSymbolResolver appFunctionSymbolResolver = new AppFunctionSymbolResolver(resolver);
            List<AppFunctionSerializableType> listResolveAnnotatedAppFunctionSerializables = appFunctionSymbolResolver.resolveAnnotatedAppFunctionSerializables();
            AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies = new AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies(appFunctionSymbolResolver.resolveAllAnnotatedSerializableProxiesFromModule());
            AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies2 = new AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies(appFunctionSymbolResolver.resolveLocalAnnotatedAppFunctionSerializableProxy());
            for (AppFunctionSerializableType appFunctionSerializableType : listResolveAnnotatedAppFunctionSerializables) {
                writeFile(appFunctionSerializableType, appFunctionSerializableType.getFactoryCodeBuilder(resolvedAnnotatedSerializableProxies).buildAppFunctionSerializableFactoryClass());
            }
            Iterator<AnnotatedAppFunctionSerializableProxy> it = resolvedAnnotatedSerializableProxies2.getResolvedAnnotatedSerializableProxies().iterator();
            if (it.hasNext()) {
                it.next();
                throw null;
            }
            List<AnnotatedAppFunctionSerializableProxy> resolvedAnnotatedSerializableProxies3 = resolvedAnnotatedSerializableProxies.getResolvedAnnotatedSerializableProxies();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(resolvedAnnotatedSerializableProxies3, 10));
            Iterator<T> it2 = resolvedAnnotatedSerializableProxies3.iterator();
            while (it2.hasNext()) {
                arrayList.add(((AnnotatedAppFunctionSerializableProxy) it2.next()).getClassDeclaration());
            }
            return arrayList;
        } catch (ProcessingException e) {
            KSPLoggerUtil.logException(null, e);
            return CollectionsKt.emptyList();
        }
    }
}
