package androidx.appfunctions.compiler.core;

import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.metadata.CompileTimeAppFunctionMetadata;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSFile;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSchemaDefinition;", "", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;)V", "schemaFunctionDeclaration", "Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "getSchemaFunctionDeclaration", "()Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "schemaFunctionDeclaration$delegate", "Lkotlin/Lazy;", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "getAllAnnotated", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "getSourceFiles", "", "Lcom/google/devtools/ksp/symbol/KSFile;", "createAppFunctionMetadata", "Landroidx/appfunctions/compiler/core/metadata/CompileTimeAppFunctionMetadata;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnotatedAppFunctionSchemaDefinition {
    private final KSClassDeclaration classDeclaration;

    /* JADX INFO: renamed from: qualifiedName$delegate, reason: from kotlin metadata */
    private final Lazy qualifiedName;

    /* JADX INFO: renamed from: schemaFunctionDeclaration$delegate, reason: from kotlin metadata */
    private final Lazy schemaFunctionDeclaration;

    public AnnotatedAppFunctionSchemaDefinition(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        this.classDeclaration = kSClassDeclaration;
        final int i = 0;
        this.schemaFunctionDeclaration = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSchemaDefinition$$ExternalSyntheticLambda0
            public final /* synthetic */ AnnotatedAppFunctionSchemaDefinition f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws ProcessingException {
                int i2 = i;
                AnnotatedAppFunctionSchemaDefinition annotatedAppFunctionSchemaDefinition = this.f$0;
                switch (i2) {
                    case 0:
                        AnnotatedAppFunctionSchemaDefinition.schemaFunctionDeclaration_delegate$lambda$0(annotatedAppFunctionSchemaDefinition);
                        return null;
                    default:
                        return AnnotatedAppFunctionSchemaDefinition.qualifiedName_delegate$lambda$0(annotatedAppFunctionSchemaDefinition);
                }
            }
        });
        final int i2 = 1;
        this.qualifiedName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSchemaDefinition$$ExternalSyntheticLambda0
            public final /* synthetic */ AnnotatedAppFunctionSchemaDefinition f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws ProcessingException {
                int i22 = i2;
                AnnotatedAppFunctionSchemaDefinition annotatedAppFunctionSchemaDefinition = this.f$0;
                switch (i22) {
                    case 0:
                        AnnotatedAppFunctionSchemaDefinition.schemaFunctionDeclaration_delegate$lambda$0(annotatedAppFunctionSchemaDefinition);
                        return null;
                    default:
                        return AnnotatedAppFunctionSchemaDefinition.qualifiedName_delegate$lambda$0(annotatedAppFunctionSchemaDefinition);
                }
            }
        });
    }

    private final KSFunctionDeclaration getSchemaFunctionDeclaration() {
        if (this.schemaFunctionDeclaration.getValue() == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String qualifiedName_delegate$lambda$0(AnnotatedAppFunctionSchemaDefinition annotatedAppFunctionSchemaDefinition) {
        return KspUtilsKt.ensureQualifiedName(annotatedAppFunctionSchemaDefinition.classDeclaration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSFunctionDeclaration schemaFunctionDeclaration_delegate$lambda$0(AnnotatedAppFunctionSchemaDefinition annotatedAppFunctionSchemaDefinition) throws ProcessingException {
        Sequence sequenceFilter = SequencesKt.filter(annotatedAppFunctionSchemaDefinition.classDeclaration.getDeclarations(), new Function1<Object, Boolean>() { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionSchemaDefinition$schemaFunctionDeclaration_delegate$lambda$0$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return false;
            }
        });
        sequenceFilter.getClass();
        if (SequencesKt.singleOrNull(sequenceFilter) == null) {
            throw new ProcessingException("The @AppFunctionSchemaDefinition should have exactly one function declaration", annotatedAppFunctionSchemaDefinition.classDeclaration, null, 4, null);
        }
        throw new ClassCastException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CompileTimeAppFunctionMetadata createAppFunctionMetadata(AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) throws ProcessingException {
        resolvedAnnotatedSerializableProxies.getClass();
        new AppFunctionMetadataCreatorHelper(null, 1, 0 == true ? 1 : 0);
        KspUtilsKt.findAnnotation(this.classDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.INSTANCE.getCLASS_NAME());
        throw new ProcessingException("Class not annotated with @AppFunctionSchemaDefinition", this.classDeclaration, null, 4, null);
    }

    public final List<KSAnnotated> getAllAnnotated() {
        return CollectionsKt.listOf(this.classDeclaration);
    }

    public final String getQualifiedName() {
        return (String) this.qualifiedName.getValue();
    }

    public final Set<KSFile> getSourceFiles() {
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        this.classDeclaration.getContainingFile();
        return SetsKt.build(setCreateSetBuilder);
    }
}
