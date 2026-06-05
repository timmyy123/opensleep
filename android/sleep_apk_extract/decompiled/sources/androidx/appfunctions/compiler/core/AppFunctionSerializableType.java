package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable;
import androidx.appfunctions.compiler.core.AppFunctionTypeReference;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSFile;
import com.google.devtools.ksp.symbol.KSTypeArgument;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.squareup.kotlinpoet.ClassName;
import com.squareup.kotlinpoet.FileSpec;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 42\u00020\u0001:\u000234J\u001e\u0010\u0019\u001a\u00020\u000b2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u0017H&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0016J$\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001bH\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001fH\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001fH\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001fH\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001fH\u0016J$\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020(0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0-H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0001"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "getClassDeclaration", "()Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "appFunctionSerializableTypeClassDeclaration", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableTypeClassDeclaration;", "getAppFunctionSerializableTypeClassDeclaration", "()Landroidx/appfunctions/compiler/core/AppFunctionSerializableTypeClassDeclaration;", "jvmQualifiedName", "", "getJvmQualifiedName", "()Ljava/lang/String;", "factoryClassName", "Lcom/squareup/kotlinpoet/ClassName;", "getFactoryClassName", "()Lcom/squareup/kotlinpoet/ClassName;", "factoryVariableName", "getFactoryVariableName", "docString", "getDocString", "isDescribedByKDoc", "", "()Z", "getDescription", "sharedDataTypeDescriptionMap", "", "validate", "allowSerializableInterfaceTypes", "findSuperTypesWithCapabilityAnnotation", "", "findSuperTypesWithSerializableAnnotation", "getProperties", "", "Landroidx/appfunctions/compiler/core/AppFunctionPropertyDeclaration;", "getSerializablePropertyTypeReferences", "Landroidx/appfunctions/compiler/core/AppFunctionTypeReference;", "getSerializableProxyPropertyTypeReferences", "getSerializableSourceFiles", "Lcom/google/devtools/ksp/symbol/KSFile;", "getTransitiveSerializableSourceFiles", "traverseSerializableClassSourceFiles", "", "sourceFileSet", "", "visitedSerializableSet", "getFactoryCodeBuilder", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType$FactoryCodeBuilder;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "FactoryCodeBuilder", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppFunctionSerializableType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionSerializableType$Companion;", "", "<init>", "()V", "create", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "typeArguments", "", "Lcom/google/devtools/ksp/symbol/KSTypeArgument;", "isAnnotatedWithAppFunctionSerializable", "", "isAnnotatedWithAppFunctionSerializableProxy", "isAnnotatedWithAppFunctionSerializableInterface", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AppFunctionSerializableType create$default(Companion companion, KSClassDeclaration kSClassDeclaration, List list, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            return companion.create(kSClassDeclaration, list);
        }

        public final AppFunctionSerializableType create(KSClassDeclaration classDeclaration, List<? extends KSTypeArgument> typeArguments) throws ProcessingException {
            classDeclaration.getClass();
            typeArguments.getClass();
            if (isAnnotatedWithAppFunctionSerializableInterface(classDeclaration)) {
                return new AnnotatedAppFunctionSerializableInterface(classDeclaration);
            }
            if (isAnnotatedWithAppFunctionSerializableProxy(classDeclaration)) {
                return new AnnotatedAppFunctionSerializableProxy(classDeclaration);
            }
            if (isAnnotatedWithAppFunctionSerializable(classDeclaration)) {
                AnnotatedOneOfAppFunctionSerializable.Companion companion = AnnotatedOneOfAppFunctionSerializable.INSTANCE;
                if (companion.isOneOfType(classDeclaration)) {
                    return companion.create(classDeclaration);
                }
            }
            if (isAnnotatedWithAppFunctionSerializable(classDeclaration)) {
                return new AnnotatedAppFunctionSerializable(classDeclaration).parameterizedBy(typeArguments);
            }
            throw new ProcessingException("Invalid AppFunctionSerializable type.", classDeclaration, null, 4, null);
        }

        public final boolean isAnnotatedWithAppFunctionSerializable(KSClassDeclaration classDeclaration) {
            classDeclaration.getClass();
            KspUtilsKt.findAnnotation(classDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionSerializableAnnotation.INSTANCE.getCLASS_NAME());
            return false;
        }

        public final boolean isAnnotatedWithAppFunctionSerializableInterface(KSClassDeclaration classDeclaration) {
            classDeclaration.getClass();
            KspUtilsKt.findAnnotation(classDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionSerializableInterfaceAnnotation.INSTANCE.getCLASS_NAME());
            return false;
        }

        public final boolean isAnnotatedWithAppFunctionSerializableProxy(KSClassDeclaration classDeclaration) {
            classDeclaration.getClass();
            KspUtilsKt.findAnnotation(classDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionSerializableProxyAnnotation.INSTANCE.getCLASS_NAME());
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionSerializableType$FactoryCodeBuilder;", "", "buildAppFunctionSerializableFactoryClass", "Lcom/squareup/kotlinpoet/FileSpec;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface FactoryCodeBuilder {
        FileSpec buildAppFunctionSerializableFactoryClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static KSClassDeclaration findSuperTypesWithSerializableAnnotation$lambda$0(KSTypeReference kSTypeReference) {
        kSTypeReference.getClass();
        kSTypeReference.resolve();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static boolean findSuperTypesWithSerializableAnnotation$lambda$1(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        KspUtilsKt.findAnnotation(kSClassDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionSerializableAnnotation.INSTANCE.getCLASS_NAME());
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ String getDescription$default(AppFunctionSerializableType appFunctionSerializableType, Map map, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: getDescription");
            return null;
        }
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return appFunctionSerializableType.getDescription(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List getProperties$default(AppFunctionSerializableType appFunctionSerializableType, Map map, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: getProperties");
            return null;
        }
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return appFunctionSerializableType.getProperties(map);
    }

    private default void traverseSerializableClassSourceFiles(Set<KSFile> sourceFileSet, Set<ClassName> visitedSerializableSet) {
        Iterator<AppFunctionTypeReference> it = getSerializablePropertyTypeReferences().iterator();
        if (it.hasNext()) {
            it.next().getSelfOrItemTypeReference();
            throw null;
        }
    }

    static /* synthetic */ AppFunctionSerializableType validate$default(AppFunctionSerializableType appFunctionSerializableType, boolean z, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: validate");
            return null;
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return appFunctionSerializableType.validate(z);
    }

    default Set<KSClassDeclaration> findSuperTypesWithCapabilityAnnotation() {
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        List mutableList = SequencesKt.toMutableList(getClassDeclaration().getSuperTypes());
        if (mutableList.isEmpty()) {
            return SetsKt.build(setCreateSetBuilder);
        }
        CollectionsKt.removeLast(mutableList).getClass();
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    default Set<KSClassDeclaration> findSuperTypesWithSerializableAnnotation() {
        return SequencesKt.toSet(SequencesKt.filter(SequencesKt.map(getClassDeclaration().getSuperTypes(), new StringUtilsKt$$ExternalSyntheticLambda0(7)), new StringUtilsKt$$ExternalSyntheticLambda0(8)));
    }

    default AppFunctionSerializableTypeClassDeclaration getAppFunctionSerializableTypeClassDeclaration() {
        return new AppFunctionSerializableTypeClassDeclaration(getClassDeclaration());
    }

    KSClassDeclaration getClassDeclaration();

    default String getDescription(Map<String, String> sharedDataTypeDescriptionMap) {
        sharedDataTypeDescriptionMap.getClass();
        String docString = getDocString();
        if (docString.length() != 0) {
            return docString;
        }
        String str = sharedDataTypeDescriptionMap.get(getJvmQualifiedName());
        return str == null ? "" : str;
    }

    default String getDocString() {
        return getIsDescribedByKDoc() ? getAppFunctionSerializableTypeClassDeclaration().getDocString() : "";
    }

    default ClassName getFactoryClassName() {
        return new ClassName(getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName().getPackageName(), FileInsert$$ExternalSyntheticOutline0.m("$", getAppFunctionSerializableTypeClassDeclaration().getJvmClassName(), "Factory"));
    }

    FactoryCodeBuilder getFactoryCodeBuilder(AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies);

    default String getFactoryVariableName() {
        String strReplace$default = StringsKt.replace$default(getAppFunctionSerializableTypeClassDeclaration().getJvmClassName(), "$", "");
        if (strReplace$default.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String strValueOf = String.valueOf(strReplace$default.charAt(0));
            strValueOf.getClass();
            String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            sb.append((Object) lowerCase);
            sb.append(strReplace$default.substring(1));
            strReplace$default = sb.toString();
        }
        return strReplace$default.concat("Factory");
    }

    default String getJvmQualifiedName() {
        return getAppFunctionSerializableTypeClassDeclaration().getJvmQualifiedName();
    }

    default List<AppFunctionPropertyDeclaration> getProperties(Map<String, String> sharedDataTypeDescriptionMap) {
        sharedDataTypeDescriptionMap.getClass();
        getClassDeclaration().getPrimaryConstructor();
        throw new IllegalStateException("Required value was null.");
    }

    default Set<AppFunctionTypeReference> getSerializablePropertyTypeReferences() {
        List properties$default = getProperties$default(this, null, 1, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties$default) {
            if (!((AppFunctionPropertyDeclaration) obj).isGenericType()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AppFunctionPropertyDeclaration) it.next()).getType();
            arrayList2.add(new AppFunctionTypeReference(null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            AppFunctionTypeReference appFunctionTypeReference = (AppFunctionTypeReference) obj2;
            if (appFunctionTypeReference.isOfTypeCategory(AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_SINGULAR) || appFunctionTypeReference.isOfTypeCategory(AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_LIST)) {
                arrayList3.add(obj2);
            }
        }
        return CollectionsKt.toSet(arrayList3);
    }

    default Set<AppFunctionTypeReference> getSerializableProxyPropertyTypeReferences() {
        List properties$default = getProperties$default(this, null, 1, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties$default) {
            if (!((AppFunctionPropertyDeclaration) obj).isGenericType()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AppFunctionPropertyDeclaration) it.next()).getType();
            arrayList2.add(new AppFunctionTypeReference(null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            AppFunctionTypeReference appFunctionTypeReference = (AppFunctionTypeReference) obj2;
            if (appFunctionTypeReference.isOfTypeCategory(AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_PROXY_SINGULAR) || appFunctionTypeReference.isOfTypeCategory(AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_PROXY_LIST)) {
                arrayList3.add(obj2);
            }
        }
        return CollectionsKt.toSet(arrayList3);
    }

    default Set<KSFile> getSerializableSourceFiles() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getClassDeclaration().getContainingFile();
        Iterator<AppFunctionTypeReference> it = getSerializablePropertyTypeReferences().iterator();
        if (!it.hasNext()) {
            return linkedHashSet;
        }
        it.next().getSelfOrItemTypeReference();
        throw null;
    }

    default Set<KSFile> getTransitiveSerializableSourceFiles() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        getClassDeclaration().getContainingFile();
        linkedHashSet2.add(getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName());
        traverseSerializableClassSourceFiles(linkedHashSet, linkedHashSet2);
        return linkedHashSet;
    }

    /* JADX INFO: renamed from: isDescribedByKDoc */
    boolean getIsDescribedByKDoc();

    AppFunctionSerializableType validate(boolean allowSerializableInterfaceTypes);
}
