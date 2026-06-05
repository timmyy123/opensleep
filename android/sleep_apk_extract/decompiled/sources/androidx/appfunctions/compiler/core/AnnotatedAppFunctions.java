package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AppFunctionMetadataCreatorHelper;
import androidx.appfunctions.compiler.core.AppFunctionTypeReference;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.metadata.AppFunctionDeprecationMetadata;
import androidx.appfunctions.compiler.core.metadata.CompileTimeAppFunctionMetadata;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSDeclaration;
import com.google.devtools.ksp.symbol.KSFile;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.squareup.kotlinpoet.ClassName;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005J\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0006J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0006\u0010\u001d\u001a\u00020\u001eJ*\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010!\u001a\u00020\"2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010$\u001a\u00020%*\u00020&2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\f\u0010-\u001a\u00020\u0014*\u00020,H\u0002J\u0014\u0010.\u001a\u00020\t*\u00020\u00062\u0006\u0010/\u001a\u00020%H\u0002J\u000e\u00100\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u00101\u001a\u0004\u0018\u000102*\u000203H\u0002J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u00106\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bHÂ\u0003J9\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0014\u00108\u001a\u00020\u00142\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010:\u001a\u00020;HÖ\u0081\u0004J\n\u0010<\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;", "", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "appFunctionDeclarations", "", "Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "appFunctionNameToDocstringMap", "", "", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;Ljava/util/List;Ljava/util/Map;)V", "getClassDeclaration", "()Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "getAppFunctionDeclarations", "()Ljava/util/List;", "getAllAnnotated", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "validate", "skipFirstParameterValidation", "", "validateFirstParameter", "", "validateParameterTypes", "getAppFunctionIdentifier", "functionDeclaration", "getSourceFiles", "", "Lcom/google/devtools/ksp/symbol/KSFile;", "getEnclosingClassName", "Lcom/squareup/kotlinpoet/ClassName;", "createAppFunctionMetadataList", "Landroidx/appfunctions/compiler/core/metadata/CompileTimeAppFunctionMetadata;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "sharedDataTypeDescriptionMap", "computeAppFunctionAnnotationProperties", "Landroidx/appfunctions/compiler/core/AppFunctionMetadataCreatorHelper$AppFunctionAnnotationProperties;", "Landroidx/appfunctions/compiler/core/AppFunctionMetadataCreatorHelper;", "findRootAppFunctionSchemaInterface", "function", "getAnnotatedAppFunctionSerializable", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "appFunctionTypeReference", "Landroidx/appfunctions/compiler/core/AppFunctionTypeReference;", "typeOrItemTypeIsAppFunctionSerializable", "getFunctionDescription", "appFunctionAnnotationProperties", "isDescribedByKDoc", "getDeprecationMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDeprecationMetadata;", "Lcom/google/devtools/ksp/symbol/KSDeclaration;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AnnotatedAppFunctions {
    private final List<KSFunctionDeclaration> appFunctionDeclarations;
    private final Map<String, String> appFunctionNameToDocstringMap;
    private final KSClassDeclaration classDeclaration;

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedAppFunctions(KSClassDeclaration kSClassDeclaration, List<? extends KSFunctionDeclaration> list, Map<String, String> map) {
        kSClassDeclaration.getClass();
        list.getClass();
        map.getClass();
        this.classDeclaration = kSClassDeclaration;
        this.appFunctionDeclarations = list;
        this.appFunctionNameToDocstringMap = map;
    }

    private final Map<String, String> component3() {
        return this.appFunctionNameToDocstringMap;
    }

    private final AppFunctionMetadataCreatorHelper.AppFunctionAnnotationProperties computeAppFunctionAnnotationProperties(AppFunctionMetadataCreatorHelper appFunctionMetadataCreatorHelper, KSFunctionDeclaration kSFunctionDeclaration) throws ProcessingException {
        KspUtilsKt.findAnnotation(kSFunctionDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionAnnotation.INSTANCE.getCLASS_NAME());
        throw new ProcessingException("Function not annotated with @AppFunction.", kSFunctionDeclaration, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnotatedAppFunctions copy$default(AnnotatedAppFunctions annotatedAppFunctions, KSClassDeclaration kSClassDeclaration, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            kSClassDeclaration = annotatedAppFunctions.classDeclaration;
        }
        if ((i & 2) != 0) {
            list = annotatedAppFunctions.appFunctionDeclarations;
        }
        if ((i & 4) != 0) {
            map = annotatedAppFunctions.appFunctionNameToDocstringMap;
        }
        return annotatedAppFunctions.copy(kSClassDeclaration, list, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List createAppFunctionMetadataList$default(AnnotatedAppFunctions annotatedAppFunctions, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return annotatedAppFunctions.createAppFunctionMetadataList(resolvedAnnotatedSerializableProxies, map);
    }

    private final KSClassDeclaration findRootAppFunctionSchemaInterface(KSFunctionDeclaration function) {
        KSDeclaration parentDeclaration = function.getParentDeclaration();
        KSClassDeclaration kSClassDeclaration = parentDeclaration instanceof KSClassDeclaration ? (KSClassDeclaration) parentDeclaration : null;
        if (kSClassDeclaration == null) {
            return null;
        }
        KspUtilsKt.findAnnotation(kSClassDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.INSTANCE.getCLASS_NAME());
        KSDeclaration kSDeclarationFindOverridee = function.findOverridee();
        KSFunctionDeclaration kSFunctionDeclaration = kSDeclarationFindOverridee instanceof KSFunctionDeclaration ? (KSFunctionDeclaration) kSDeclarationFindOverridee : null;
        if (kSFunctionDeclaration == null) {
            return null;
        }
        return findRootAppFunctionSchemaInterface(kSFunctionDeclaration);
    }

    private final AppFunctionSerializableType getAnnotatedAppFunctionSerializable(AppFunctionTypeReference appFunctionTypeReference) {
        appFunctionTypeReference.getSelfOrItemTypeReference();
        throw null;
    }

    private final AppFunctionDeprecationMetadata getDeprecationMetadata(KSDeclaration kSDeclaration) {
        KspUtilsKt.findAnnotation(kSDeclaration.getAnnotations(), IntrospectionHelper.DeprecatedAnnotation.INSTANCE.getCLASS_NAME());
        return null;
    }

    private final String getFunctionDescription(KSFunctionDeclaration kSFunctionDeclaration, AppFunctionMetadataCreatorHelper.AppFunctionAnnotationProperties appFunctionAnnotationProperties) {
        String str;
        return (!Intrinsics.areEqual(appFunctionAnnotationProperties.isDescribedByKDoc(), Boolean.TRUE) || (str = this.appFunctionNameToDocstringMap.get(KspUtilsKt.ensureQualifiedName(kSFunctionDeclaration))) == null) ? "" : str;
    }

    private final boolean typeOrItemTypeIsAppFunctionSerializable(AppFunctionTypeReference appFunctionTypeReference) {
        return appFunctionTypeReference.isOfTypeCategory(AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_SINGULAR) || appFunctionTypeReference.isOfTypeCategory(AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_LIST);
    }

    public static /* synthetic */ AnnotatedAppFunctions validate$default(AnnotatedAppFunctions annotatedAppFunctions, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return annotatedAppFunctions.validate(z);
    }

    private final void validateFirstParameter() {
        Iterator<KSFunctionDeclaration> it = this.appFunctionDeclarations.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
    }

    private final void validateParameterTypes() {
        Iterator<KSFunctionDeclaration> it = this.appFunctionDeclarations.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final KSClassDeclaration getClassDeclaration() {
        return this.classDeclaration;
    }

    public final List<KSFunctionDeclaration> component2() {
        return this.appFunctionDeclarations;
    }

    public final AnnotatedAppFunctions copy(KSClassDeclaration classDeclaration, List<? extends KSFunctionDeclaration> appFunctionDeclarations, Map<String, String> appFunctionNameToDocstringMap) {
        classDeclaration.getClass();
        appFunctionDeclarations.getClass();
        appFunctionNameToDocstringMap.getClass();
        return new AnnotatedAppFunctions(classDeclaration, appFunctionDeclarations, appFunctionNameToDocstringMap);
    }

    public final List<CompileTimeAppFunctionMetadata> createAppFunctionMetadataList(AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map<String, String> sharedDataTypeDescriptionMap) {
        resolvedAnnotatedSerializableProxies.getClass();
        sharedDataTypeDescriptionMap.getClass();
        AppFunctionMetadataCreatorHelper appFunctionMetadataCreatorHelper = new AppFunctionMetadataCreatorHelper(sharedDataTypeDescriptionMap);
        List<KSFunctionDeclaration> list = this.appFunctionDeclarations;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        if (it.next() != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        new LinkedHashMap();
        new LinkedHashSet();
        getFunctionDescription(null, computeAppFunctionAnnotationProperties(appFunctionMetadataCreatorHelper, null));
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotatedAppFunctions)) {
            return false;
        }
        AnnotatedAppFunctions annotatedAppFunctions = (AnnotatedAppFunctions) other;
        return Intrinsics.areEqual(this.classDeclaration, annotatedAppFunctions.classDeclaration) && Intrinsics.areEqual(this.appFunctionDeclarations, annotatedAppFunctions.appFunctionDeclarations) && Intrinsics.areEqual(this.appFunctionNameToDocstringMap, annotatedAppFunctions.appFunctionNameToDocstringMap);
    }

    public final List<KSAnnotated> getAllAnnotated() {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Iterator<KSFunctionDeclaration> it = this.appFunctionDeclarations.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            listCreateListBuilder.add(null);
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    public final List<KSFunctionDeclaration> getAppFunctionDeclarations() {
        return this.appFunctionDeclarations;
    }

    public final String getAppFunctionIdentifier(KSFunctionDeclaration functionDeclaration) {
        functionDeclaration.getClass();
        KspUtilsKt.toClassName(this.classDeclaration);
        functionDeclaration.getSimpleName();
        throw null;
    }

    public final KSClassDeclaration getClassDeclaration() {
        return this.classDeclaration;
    }

    public final ClassName getEnclosingClassName() {
        return KspUtilsKt.toClassName(this.classDeclaration);
    }

    public final Set<KSFile> getSourceFiles() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.classDeclaration.getContainingFile();
        Iterator<KSFunctionDeclaration> it = this.appFunctionDeclarations.iterator();
        if (!it.hasNext()) {
            return linkedHashSet;
        }
        if (it.next() != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        KSClassDeclaration kSClassDeclarationFindRootAppFunctionSchemaInterface = findRootAppFunctionSchemaInterface(null);
        if (kSClassDeclarationFindRootAppFunctionSchemaInterface == null) {
            throw null;
        }
        kSClassDeclarationFindRootAppFunctionSchemaInterface.getContainingFile();
        throw null;
    }

    public int hashCode() {
        return this.appFunctionNameToDocstringMap.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((List) this.appFunctionDeclarations, this.classDeclaration.hashCode() * 31, 31);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDescribedByKDoc(KSFunctionDeclaration functionDeclaration) {
        functionDeclaration.getClass();
        Boolean boolIsDescribedByKDoc = computeAppFunctionAnnotationProperties(new AppFunctionMetadataCreatorHelper(null, 1, 0 == true ? 1 : 0), functionDeclaration).isDescribedByKDoc();
        if (boolIsDescribedByKDoc != null) {
            return boolIsDescribedByKDoc.booleanValue();
        }
        return false;
    }

    public String toString() {
        return "AnnotatedAppFunctions(classDeclaration=" + this.classDeclaration + ", appFunctionDeclarations=" + this.appFunctionDeclarations + ", appFunctionNameToDocstringMap=" + this.appFunctionNameToDocstringMap + ")";
    }

    public final AnnotatedAppFunctions validate(boolean skipFirstParameterValidation) {
        Iterator<KSFunctionDeclaration> it = this.appFunctionDeclarations.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        if (!skipFirstParameterValidation) {
            validateFirstParameter();
        }
        validateParameterTypes();
        return this;
    }

    public /* synthetic */ AnnotatedAppFunctions(KSClassDeclaration kSClassDeclaration, List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSClassDeclaration, list, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }
}
