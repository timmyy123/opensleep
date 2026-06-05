package androidx.appfunctions.compiler;

import androidx.appfunctions.compiler.core.AnnotatedAppFunctions;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import androidx.appfunctions.compiler.core.KSPLoggerUtil;
import androidx.appfunctions.compiler.core.ProcessingException;
import androidx.appfunctions.compiler.core.SymbolNotReadyException;
import com.google.devtools.ksp.processing.KSPLogger;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.squareup.kotlinpoet.AnnotationSpec;
import java.util.Iterator;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/compiler/AppFunctionCompiler;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "processors", "", "logger", "Lcom/google/devtools/ksp/processing/KSPLogger;", "<init>", "(Ljava/util/List;Lcom/google/devtools/ksp/processing/KSPLogger;)V", "process", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "shouldDeferAllProcessing", "Provider", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionCompiler implements SymbolProcessor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AnnotationSpec GENERATED_ANNOTATION;
    private final KSPLogger logger;
    private final List<SymbolProcessor> processors;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/compiler/AppFunctionCompiler$Companion;", "", "<init>", "()V", "GENERATED_ANNOTATION", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getGENERATED_ANNOTATION$appfunctions_compiler", "()Lcom/squareup/kotlinpoet/AnnotationSpec;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnnotationSpec getGENERATED_ANNOTATION$appfunctions_compiler() {
            return AppFunctionCompiler.GENERATED_ANNOTATION;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/appfunctions/compiler/AppFunctionCompiler$Provider;", "", "<init>", "()V", "Lcom/google/devtools/ksp/processing/SymbolProcessorEnvironment;", "environment", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "create", "(Lcom/google/devtools/ksp/processing/SymbolProcessorEnvironment;)Lcom/google/devtools/ksp/processing/SymbolProcessor;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Provider {
        public SymbolProcessor create(SymbolProcessorEnvironment environment) {
            throw null;
        }
    }

    static {
        AnnotationSpec.Builder builder = AnnotationSpec.INSTANCE.builder(Reflection.getOrCreateKotlinClass(Generated.class));
        String canonicalName = AppFunctionCompiler.class.getCanonicalName();
        canonicalName.getClass();
        GENERATED_ANNOTATION = builder.addMember("%S", canonicalName).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionCompiler(List<? extends SymbolProcessor> list, KSPLogger kSPLogger) {
        list.getClass();
        kSPLogger.getClass();
        this.processors = list;
    }

    private final List<KSAnnotated> shouldDeferAllProcessing(Resolver resolver) {
        Iterator<AnnotatedAppFunctions> it = new AppFunctionSymbolResolver(resolver).resolveUnvalidatedAnnotatedAppFunctions().iterator();
        while (it.hasNext()) {
            try {
                AnnotatedAppFunctions.validate$default(it.next(), false, 1, null);
            } catch (SymbolNotReadyException e) {
                e.getMessage();
                e.getNode();
                throw null;
            }
        }
        return CollectionsKt.emptyList();
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
        try {
            List<KSAnnotated> listShouldDeferAllProcessing = shouldDeferAllProcessing(resolver);
            if (!listShouldDeferAllProcessing.isEmpty()) {
                return listShouldDeferAllProcessing;
            }
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            Iterator<SymbolProcessor> it = this.processors.iterator();
            while (it.hasNext()) {
                listCreateListBuilder.addAll(it.next().process(resolver));
            }
            return CollectionsKt.build(listCreateListBuilder);
        } catch (ProcessingException e) {
            KSPLoggerUtil.logException(null, e);
            return CollectionsKt.emptyList();
        }
    }
}
