package androidx.appfunctions.compiler.core;

import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AppFunctionSerializableType;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSPropertyDeclaration;
import com.squareup.kotlinpoet.FunSpec$$ExternalSyntheticLambda1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0016J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableInterface;", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;)V", "getClassDeclaration", "()Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "isDescribedByKDoc", "", "()Z", "validate", "allowSerializableInterfaceTypes", "getProperties", "", "Landroidx/appfunctions/compiler/core/AppFunctionPropertyDeclaration;", "sharedDataTypeDescriptionMap", "", "", "getFactoryCodeBuilder", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType$FactoryCodeBuilder;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnotatedAppFunctionSerializableInterface implements AppFunctionSerializableType {
    private final KSClassDeclaration classDeclaration;
    private final boolean isDescribedByKDoc;

    public AnnotatedAppFunctionSerializableInterface(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        this.classDeclaration = kSClassDeclaration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionPropertyDeclaration getProperties$lambda$0(AnnotatedAppFunctionSerializableInterface annotatedAppFunctionSerializableInterface, Map map, KSPropertyDeclaration kSPropertyDeclaration) {
        kSPropertyDeclaration.getClass();
        return new AppFunctionPropertyDeclaration(kSPropertyDeclaration, annotatedAppFunctionSerializableInterface.getIsDescribedByKDoc(), true, map);
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public KSClassDeclaration getClassDeclaration() {
        return this.classDeclaration;
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public AppFunctionSerializableType.FactoryCodeBuilder getFactoryCodeBuilder(AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) throws ProcessingException {
        resolvedAnnotatedSerializableProxies.getClass();
        throw new ProcessingException("@AppFunctionSerializableInterface doesn't need a factory.", getAppFunctionSerializableTypeClassDeclaration().getAttributeNode(), null, 4, null);
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public List<AppFunctionPropertyDeclaration> getProperties(Map<String, String> sharedDataTypeDescriptionMap) {
        sharedDataTypeDescriptionMap.getClass();
        return SequencesKt.toList(SequencesKt.map(getClassDeclaration().getAllProperties(), new FunSpec$$ExternalSyntheticLambda1(this, sharedDataTypeDescriptionMap, 2)));
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    /* JADX INFO: renamed from: isDescribedByKDoc, reason: from getter */
    public boolean getIsDescribedByKDoc() {
        return this.isDescribedByKDoc;
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public AnnotatedAppFunctionSerializableInterface validate(boolean allowSerializableInterfaceTypes) {
        new AppFunctionSerializableValidateHelper(this).validateParameters(allowSerializableInterfaceTypes);
        return this;
    }
}
