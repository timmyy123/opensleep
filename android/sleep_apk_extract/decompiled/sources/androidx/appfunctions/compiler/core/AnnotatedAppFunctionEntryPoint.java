package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.devtools.ksp.UtilsKt;
import com.google.devtools.ksp.symbol.KSAnnotation;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSType;
import com.google.devtools.ksp.symbol.Modifier;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\u0000J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0018\u0010\u0015¨\u0006!"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionEntryPoint;", "", "serviceDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "annotatedAppFunctions", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;)V", "getServiceDeclaration", "()Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "getAnnotatedAppFunctions", "()Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;", "appFunctionEntryPointAnnotation", "Lcom/google/devtools/ksp/symbol/KSAnnotation;", "getAppFunctionEntryPointAnnotation", "()Lcom/google/devtools/ksp/symbol/KSAnnotation;", "appFunctionEntryPointAnnotation$delegate", "Lkotlin/Lazy;", IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_SERVICE_NAME, "", "getServiceName", "()Ljava/lang/String;", "serviceName$delegate", IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_APP_FUNCTION_XML_FILE_NAME, "getAppFunctionXmlFileName", "appFunctionXmlFileName$delegate", "validate", "validateAnnotation", "", "validateSuperClass", "validateIsAbstract", "validateExecuteFunctionIsNotImplemented", "validateAppFunctions", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnotatedAppFunctionEntryPoint {
    private final AnnotatedAppFunctions annotatedAppFunctions;

    /* JADX INFO: renamed from: appFunctionEntryPointAnnotation$delegate, reason: from kotlin metadata */
    private final Lazy appFunctionEntryPointAnnotation;

    /* JADX INFO: renamed from: appFunctionXmlFileName$delegate, reason: from kotlin metadata */
    private final Lazy appFunctionXmlFileName;
    private final KSClassDeclaration serviceDeclaration;

    /* JADX INFO: renamed from: serviceName$delegate, reason: from kotlin metadata */
    private final Lazy serviceName;

    public AnnotatedAppFunctionEntryPoint(KSClassDeclaration kSClassDeclaration, AnnotatedAppFunctions annotatedAppFunctions) {
        kSClassDeclaration.getClass();
        annotatedAppFunctions.getClass();
        this.serviceDeclaration = kSClassDeclaration;
        this.annotatedAppFunctions = annotatedAppFunctions;
        final int i = 0;
        this.appFunctionEntryPointAnnotation = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionEntryPoint$$ExternalSyntheticLambda0
            public final /* synthetic */ AnnotatedAppFunctionEntryPoint f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws ProcessingException {
                int i2 = i;
                AnnotatedAppFunctionEntryPoint annotatedAppFunctionEntryPoint = this.f$0;
                switch (i2) {
                    case 0:
                        AnnotatedAppFunctionEntryPoint.appFunctionEntryPointAnnotation_delegate$lambda$0(annotatedAppFunctionEntryPoint);
                        return null;
                    case 1:
                        return AnnotatedAppFunctionEntryPoint.serviceName_delegate$lambda$0(annotatedAppFunctionEntryPoint);
                    default:
                        return AnnotatedAppFunctionEntryPoint.appFunctionXmlFileName_delegate$lambda$0(annotatedAppFunctionEntryPoint);
                }
            }
        });
        final int i2 = 1;
        this.serviceName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionEntryPoint$$ExternalSyntheticLambda0
            public final /* synthetic */ AnnotatedAppFunctionEntryPoint f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws ProcessingException {
                int i22 = i2;
                AnnotatedAppFunctionEntryPoint annotatedAppFunctionEntryPoint = this.f$0;
                switch (i22) {
                    case 0:
                        AnnotatedAppFunctionEntryPoint.appFunctionEntryPointAnnotation_delegate$lambda$0(annotatedAppFunctionEntryPoint);
                        return null;
                    case 1:
                        return AnnotatedAppFunctionEntryPoint.serviceName_delegate$lambda$0(annotatedAppFunctionEntryPoint);
                    default:
                        return AnnotatedAppFunctionEntryPoint.appFunctionXmlFileName_delegate$lambda$0(annotatedAppFunctionEntryPoint);
                }
            }
        });
        final int i3 = 2;
        this.appFunctionXmlFileName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionEntryPoint$$ExternalSyntheticLambda0
            public final /* synthetic */ AnnotatedAppFunctionEntryPoint f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws ProcessingException {
                int i22 = i3;
                AnnotatedAppFunctionEntryPoint annotatedAppFunctionEntryPoint = this.f$0;
                switch (i22) {
                    case 0:
                        AnnotatedAppFunctionEntryPoint.appFunctionEntryPointAnnotation_delegate$lambda$0(annotatedAppFunctionEntryPoint);
                        return null;
                    case 1:
                        return AnnotatedAppFunctionEntryPoint.serviceName_delegate$lambda$0(annotatedAppFunctionEntryPoint);
                    default:
                        return AnnotatedAppFunctionEntryPoint.appFunctionXmlFileName_delegate$lambda$0(annotatedAppFunctionEntryPoint);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSAnnotation appFunctionEntryPointAnnotation_delegate$lambda$0(AnnotatedAppFunctionEntryPoint annotatedAppFunctionEntryPoint) throws ProcessingException {
        KspUtilsKt.findAnnotation(annotatedAppFunctionEntryPoint.serviceDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionEntryPointAnnotation.INSTANCE.getCLASS_NAME());
        throw new ProcessingException("Class not annotated with @AppFunctionEntryPoint", annotatedAppFunctionEntryPoint.serviceDeclaration, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String appFunctionXmlFileName_delegate$lambda$0(AnnotatedAppFunctionEntryPoint annotatedAppFunctionEntryPoint) {
        annotatedAppFunctionEntryPoint.getAppFunctionEntryPointAnnotation();
        return (String) KspUtilsKt.requirePropertyValueOfType(null, IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_APP_FUNCTION_XML_FILE_NAME, Reflection.getOrCreateKotlinClass(String.class));
    }

    private final KSAnnotation getAppFunctionEntryPointAnnotation() {
        if (this.appFunctionEntryPointAnnotation.getValue() == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String serviceName_delegate$lambda$0(AnnotatedAppFunctionEntryPoint annotatedAppFunctionEntryPoint) {
        annotatedAppFunctionEntryPoint.getAppFunctionEntryPointAnnotation();
        return (String) KspUtilsKt.requirePropertyValueOfType(null, IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_SERVICE_NAME, Reflection.getOrCreateKotlinClass(String.class));
    }

    private final void validateAnnotation() throws ProcessingException {
        KspUtilsKt.findAnnotation(this.serviceDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionEntryPointAnnotation.INSTANCE.getCLASS_NAME());
        throw new ProcessingException("Class must be annotated with @AppFunctionEntryPoint", this.serviceDeclaration, null, 4, null);
    }

    private final void validateAppFunctions() throws ProcessingException {
        if (this.annotatedAppFunctions.getAppFunctionDeclarations().isEmpty()) {
            throw new ProcessingException("Class must have at least one AppFunction", this.serviceDeclaration, null, 4, null);
        }
        this.annotatedAppFunctions.validate(true);
    }

    private final void validateExecuteFunctionIsNotImplemented() {
        Sequence sequenceFilter = SequencesKt.filter(this.serviceDeclaration.getDeclarations(), new Function1<Object, Boolean>() { // from class: androidx.appfunctions.compiler.core.AnnotatedAppFunctionEntryPoint$validateExecuteFunctionIsNotImplemented$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return false;
            }
        });
        sequenceFilter.getClass();
        Iterator it = sequenceFilter.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m(it);
        }
    }

    private final void validateIsAbstract() throws ProcessingException {
        if (!this.serviceDeclaration.getModifiers().contains(Modifier.ABSTRACT)) {
            throw new ProcessingException("The class being annotated with AppFunctionEntryPoint should be an abstract class", this.serviceDeclaration, null, 4, null);
        }
    }

    private final void validateSuperClass() throws ProcessingException {
        Iterator<KSType> it = UtilsKt.getAllSuperTypes(this.serviceDeclaration).iterator();
        if (!it.hasNext()) {
            throw new ProcessingException(FileInsert$$ExternalSyntheticOutline0.m("Class must extend ", IntrospectionHelper.AppFunctionServiceClass.INSTANCE.getCLASS_NAME().getCanonicalName()), this.serviceDeclaration, null, 4, null);
        }
        throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
    }

    public final AnnotatedAppFunctions getAnnotatedAppFunctions() {
        return this.annotatedAppFunctions;
    }

    public final String getAppFunctionXmlFileName() {
        return (String) this.appFunctionXmlFileName.getValue();
    }

    public final KSClassDeclaration getServiceDeclaration() {
        return this.serviceDeclaration;
    }

    public final String getServiceName() {
        return (String) this.serviceName.getValue();
    }

    public final AnnotatedAppFunctionEntryPoint validate() throws ProcessingException {
        validateAnnotation();
        validateSuperClass();
        validateIsAbstract();
        validateExecuteFunctionIsNotImplemented();
        validateAppFunctions();
        return this;
    }
}
