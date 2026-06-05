package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AppFunctionComponentRegistryGenerator;
import androidx.appfunctions.compiler.core.AppFunctionSerializableType;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.devtools.ksp.UtilsKt;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSAnnotation;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSDeclaration;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0007J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0007J\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\u0006\u0010\u001d\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionSymbolResolver;", "", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "<init>", "(Lcom/google/devtools/ksp/processing/Resolver;)V", "resolveAnnotatedAppFunctionEntryPoints", "", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionEntryPoint;", "resolveAnnotatedAppFunctionSchemaDefinitions", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSchemaDefinition;", "resolveUnvalidatedAnnotatedAppFunctions", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;", "resolveAnnotatedAppFunctions", "resolveAnnotatedAppFunctionSerializables", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "resolveLocalAnnotatedAppFunctionSerializableProxy", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy;", "resolveAllAnnotatedSerializableProxiesFromModule", "getAnnotatedAppFunctionsFromAllModules", "getAppFunctionSerializablesDescriptionMap", "", "", "getGeneratedAppFunctionInventories", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "getGeneratedAppFunctionInvokers", "getAppFunctionSchemaDefinitionFromAllModules", "filterAppFunctionComponent", "Landroidx/appfunctions/compiler/core/AppFunctionComponentRegistryGenerator$AppFunctionComponent;", "filterComponentCategory", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionSymbolResolver {
    private final Resolver resolver;

    public AppFunctionSymbolResolver(Resolver resolver) {
        resolver.getClass();
    }

    private final List<AppFunctionComponentRegistryGenerator.AppFunctionComponent> filterAppFunctionComponent(String filterComponentCategory) {
        throw null;
    }

    private static final Iterable filterAppFunctionComponent$lambda$0(String str, KSDeclaration kSDeclaration) {
        kSDeclaration.getClass();
        KspUtilsKt.findAnnotation(kSDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionComponentRegistryAnnotation.INSTANCE.getCLASS_NAME());
        return CollectionsKt.emptyList();
    }

    private static final boolean resolveAllAnnotatedSerializableProxiesFromModule$lambda$1(KSDeclaration kSDeclaration) {
        kSDeclaration.getClass();
        KspUtilsKt.findAnnotation(kSDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionSerializableProxyAnnotation.INSTANCE.getCLASS_NAME());
        return false;
    }

    private static final AnnotatedAppFunctionSerializableProxy resolveAllAnnotatedSerializableProxiesFromModule$lambda$2(KSDeclaration kSDeclaration) throws ProcessingException {
        kSDeclaration.getClass();
        if (kSDeclaration instanceof KSClassDeclaration) {
            return (AnnotatedAppFunctionSerializableProxy) AppFunctionSerializableType.validate$default(new AnnotatedAppFunctionSerializableProxy((KSClassDeclaration) kSDeclaration), false, 1, null);
        }
        throw new ProcessingException("Only classes can be annotated with @AppFunctionSerializableProxy", kSDeclaration, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSClassDeclaration resolveAnnotatedAppFunctionEntryPoints$lambda$0(KSAnnotated kSAnnotated) throws ProcessingException {
        kSAnnotated.getClass();
        if (kSAnnotated instanceof KSClassDeclaration) {
            return (KSClassDeclaration) kSAnnotated;
        }
        throw new ProcessingException("Only classes can be annotated with @AppFunctionEntryPoint", kSAnnotated, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedAppFunctionEntryPoint resolveAnnotatedAppFunctionEntryPoints$lambda$2(KSClassDeclaration kSClassDeclaration) {
        KSClassDeclaration kSClassDeclaration2;
        AnnotatedAppFunctions annotatedAppFunctions;
        kSClassDeclaration.getClass();
        List list = SequencesKt.toList(SequencesKt.filter(UtilsKt.getDeclaredFunctions(kSClassDeclaration), new StringUtilsKt$$ExternalSyntheticLambda0(9)));
        if (list.isEmpty()) {
            kSClassDeclaration2 = kSClassDeclaration;
            annotatedAppFunctions = new AnnotatedAppFunctions(kSClassDeclaration2, CollectionsKt.emptyList(), null, 4, null);
        } else {
            annotatedAppFunctions = new AnnotatedAppFunctions(kSClassDeclaration, list, null, 4, null);
            kSClassDeclaration2 = kSClassDeclaration;
        }
        return new AnnotatedAppFunctionEntryPoint(kSClassDeclaration2, annotatedAppFunctions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean resolveAnnotatedAppFunctionEntryPoints$lambda$2$0(KSFunctionDeclaration kSFunctionDeclaration) {
        kSFunctionDeclaration.getClass();
        KspUtilsKt.findAnnotation(kSFunctionDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionAnnotation.INSTANCE.getCLASS_NAME());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSClassDeclaration resolveAnnotatedAppFunctionSchemaDefinitions$lambda$0(KSAnnotated kSAnnotated) throws ProcessingException {
        kSAnnotated.getClass();
        if (kSAnnotated instanceof KSClassDeclaration) {
            return (KSClassDeclaration) kSAnnotated;
        }
        throw new ProcessingException("Only class can be annotated with @AppFunctionSchemaDefinition", kSAnnotated, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedAppFunctionSchemaDefinition resolveAnnotatedAppFunctionSchemaDefinitions$lambda$2(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        return new AnnotatedAppFunctionSchemaDefinition(kSClassDeclaration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSClassDeclaration resolveAnnotatedAppFunctionSerializables$lambda$0(KSAnnotated kSAnnotated) throws ProcessingException {
        kSAnnotated.getClass();
        if (kSAnnotated instanceof KSClassDeclaration) {
            return (KSClassDeclaration) kSAnnotated;
        }
        throw new ProcessingException("Only classes can be annotated with @AppFunctionSerializable", kSAnnotated, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionSerializableType resolveAnnotatedAppFunctionSerializables$lambda$2(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        return AppFunctionSerializableType.validate$default(AppFunctionSerializableType.Companion.create$default(AppFunctionSerializableType.INSTANCE, kSClassDeclaration, null, 2, null), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSClassDeclaration resolveLocalAnnotatedAppFunctionSerializableProxy$lambda$0(KSAnnotated kSAnnotated) throws ProcessingException {
        kSAnnotated.getClass();
        if (kSAnnotated instanceof KSClassDeclaration) {
            return (KSClassDeclaration) kSAnnotated;
        }
        throw new ProcessingException("Only classes can be annotated with @AppFunctionSerializableProxy", kSAnnotated, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedAppFunctionSerializableProxy resolveLocalAnnotatedAppFunctionSerializableProxy$lambda$2(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        return (AnnotatedAppFunctionSerializableProxy) AppFunctionSerializableType.validate$default(new AnnotatedAppFunctionSerializableProxy(kSClassDeclaration), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSFunctionDeclaration resolveUnvalidatedAnnotatedAppFunctions$lambda$0(KSAnnotated kSAnnotated) throws ProcessingException {
        kSAnnotated.getClass();
        if (kSAnnotated instanceof KSFunctionDeclaration) {
            return (KSFunctionDeclaration) kSAnnotated;
        }
        throw new ProcessingException("Only functions can be annotated with @AppFunction", kSAnnotated, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean resolveUnvalidatedAnnotatedAppFunctions$lambda$1(KSFunctionDeclaration kSFunctionDeclaration) {
        Sequence<KSAnnotation> annotations;
        kSFunctionDeclaration.getClass();
        KSDeclaration parentDeclaration = kSFunctionDeclaration.getParentDeclaration();
        KSClassDeclaration kSClassDeclaration = parentDeclaration instanceof KSClassDeclaration ? (KSClassDeclaration) parentDeclaration : null;
        if (kSClassDeclaration == null || (annotations = kSClassDeclaration.getAnnotations()) == null) {
            return true;
        }
        KspUtilsKt.findAnnotation(annotations, IntrospectionHelper.AppFunctionEntryPointAnnotation.INSTANCE.getCLASS_NAME());
        return true;
    }

    public final List<AnnotatedAppFunctions> getAnnotatedAppFunctionsFromAllModules() {
        List<AppFunctionComponentRegistryGenerator.AppFunctionComponent> listFilterAppFunctionComponent = filterAppFunctionComponent("FUNCTION");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterAppFunctionComponent, 10));
        Iterator<T> it = listFilterAppFunctionComponent.iterator();
        if (it.hasNext()) {
            ((AppFunctionComponentRegistryGenerator.AppFunctionComponent) it.next()).getQualifiedName();
            throw null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m(it2);
        }
        List<Map.Entry> listSortedWith = CollectionsKt.sortedWith(linkedHashMap.entrySet(), new Comparator() { // from class: androidx.appfunctions.compiler.core.AppFunctionSymbolResolver$getAnnotatedAppFunctionsFromAllModules$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ((KSClassDeclaration) ((Map.Entry) t).getKey()).getQualifiedName();
                ((KSClassDeclaration) ((Map.Entry) t2).getKey()).getQualifiedName();
                return ComparisonsKt.compareValues(null, null);
            }
        });
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
        for (Map.Entry entry : listSortedWith) {
            KSClassDeclaration kSClassDeclaration = (KSClassDeclaration) entry.getKey();
            List list = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) listFilterAppFunctionComponent, 10, 16));
            for (AppFunctionComponentRegistryGenerator.AppFunctionComponent appFunctionComponent : listFilterAppFunctionComponent) {
                Pair pair = TuplesKt.to(appFunctionComponent.getQualifiedName(), appFunctionComponent.getDocString());
                linkedHashMap2.put(pair.getFirst(), pair.getSecond());
            }
            arrayList2.add(AnnotatedAppFunctions.validate$default(new AnnotatedAppFunctions(kSClassDeclaration, list, linkedHashMap2), false, 1, null));
        }
        return arrayList2;
    }

    public final List<AnnotatedAppFunctionSchemaDefinition> getAppFunctionSchemaDefinitionFromAllModules() {
        List<AppFunctionComponentRegistryGenerator.AppFunctionComponent> listFilterAppFunctionComponent = filterAppFunctionComponent("SCHEMA_DEFINITION");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterAppFunctionComponent, 10));
        Iterator<T> it = listFilterAppFunctionComponent.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        ((AppFunctionComponentRegistryGenerator.AppFunctionComponent) it.next()).getQualifiedName();
        throw null;
    }

    public final Map<String, String> getAppFunctionSerializablesDescriptionMap() {
        List<AppFunctionComponentRegistryGenerator.AppFunctionComponent> listFilterAppFunctionComponent = filterAppFunctionComponent("SERIALIZABLE");
        LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) listFilterAppFunctionComponent, 10, 16));
        for (AppFunctionComponentRegistryGenerator.AppFunctionComponent appFunctionComponent : listFilterAppFunctionComponent) {
            Pair pair = TuplesKt.to(appFunctionComponent.getQualifiedName(), appFunctionComponent.getDocString());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    public final List<KSClassDeclaration> getGeneratedAppFunctionInventories() {
        List<AppFunctionComponentRegistryGenerator.AppFunctionComponent> listFilterAppFunctionComponent = filterAppFunctionComponent("INVENTORY");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterAppFunctionComponent, 10));
        Iterator<T> it = listFilterAppFunctionComponent.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        ((AppFunctionComponentRegistryGenerator.AppFunctionComponent) it.next()).getQualifiedName();
        throw null;
    }

    public final List<KSClassDeclaration> getGeneratedAppFunctionInvokers() {
        List<AppFunctionComponentRegistryGenerator.AppFunctionComponent> listFilterAppFunctionComponent = filterAppFunctionComponent("INVOKER");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterAppFunctionComponent, 10));
        Iterator<T> it = listFilterAppFunctionComponent.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        ((AppFunctionComponentRegistryGenerator.AppFunctionComponent) it.next()).getQualifiedName();
        throw null;
    }

    public final List<AnnotatedAppFunctionSerializableProxy> resolveAllAnnotatedSerializableProxiesFromModule() {
        throw null;
    }

    public final List<AnnotatedAppFunctionEntryPoint> resolveAnnotatedAppFunctionEntryPoints() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.sortedWith(SequencesKt.map(Resolver.getSymbolsWithAnnotation$default(null, IntrospectionHelper.AppFunctionEntryPointAnnotation.INSTANCE.getCLASS_NAME().getCanonicalName(), false, 2, null), new StringUtilsKt$$ExternalSyntheticLambda0(15)), new Comparator() { // from class: androidx.appfunctions.compiler.core.AppFunctionSymbolResolver$resolveAnnotatedAppFunctionEntryPoints$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ((KSClassDeclaration) t).getQualifiedName();
                throw new IllegalStateException("Required value was null.");
            }
        }), new StringUtilsKt$$ExternalSyntheticLambda0(16)));
    }

    public final List<AnnotatedAppFunctionSchemaDefinition> resolveAnnotatedAppFunctionSchemaDefinitions() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.sortedWith(SequencesKt.map(Resolver.getSymbolsWithAnnotation$default(null, IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.INSTANCE.getCLASS_NAME().getCanonicalName(), false, 2, null), new StringUtilsKt$$ExternalSyntheticLambda0(11)), new Comparator() { // from class: androidx.appfunctions.compiler.core.AppFunctionSymbolResolver$resolveAnnotatedAppFunctionSchemaDefinitions$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ((KSClassDeclaration) t).getQualifiedName();
                throw new IllegalStateException("Required value was null.");
            }
        }), new StringUtilsKt$$ExternalSyntheticLambda0(12)));
    }

    public final List<AppFunctionSerializableType> resolveAnnotatedAppFunctionSerializables() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.sortedWith(SequencesKt.map(Resolver.getSymbolsWithAnnotation$default(null, IntrospectionHelper.AppFunctionSerializableAnnotation.INSTANCE.getCLASS_NAME().getCanonicalName(), false, 2, null), new StringUtilsKt$$ExternalSyntheticLambda0(19)), new Comparator() { // from class: androidx.appfunctions.compiler.core.AppFunctionSymbolResolver$resolveAnnotatedAppFunctionSerializables$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ((KSClassDeclaration) t).getQualifiedName();
                throw new IllegalStateException("Required value was null.");
            }
        }), new StringUtilsKt$$ExternalSyntheticLambda0(10)));
    }

    public final List<AnnotatedAppFunctions> resolveAnnotatedAppFunctions() {
        List<AnnotatedAppFunctions> listResolveUnvalidatedAnnotatedAppFunctions = resolveUnvalidatedAnnotatedAppFunctions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listResolveUnvalidatedAnnotatedAppFunctions, 10));
        Iterator<T> it = listResolveUnvalidatedAnnotatedAppFunctions.iterator();
        while (it.hasNext()) {
            arrayList.add(AnnotatedAppFunctions.validate$default((AnnotatedAppFunctions) it.next(), false, 1, null));
        }
        return arrayList;
    }

    public final List<AnnotatedAppFunctionSerializableProxy> resolveLocalAnnotatedAppFunctionSerializableProxy() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.sortedWith(SequencesKt.map(Resolver.getSymbolsWithAnnotation$default(null, IntrospectionHelper.AppFunctionSerializableProxyAnnotation.INSTANCE.getCLASS_NAME().getCanonicalName(), false, 2, null), new StringUtilsKt$$ExternalSyntheticLambda0(17)), new Comparator() { // from class: androidx.appfunctions.compiler.core.AppFunctionSymbolResolver$resolveLocalAnnotatedAppFunctionSerializableProxy$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ((KSClassDeclaration) t).getQualifiedName();
                throw new IllegalStateException("Required value was null.");
            }
        }), new StringUtilsKt$$ExternalSyntheticLambda0(18)));
    }

    public final List<AnnotatedAppFunctions> resolveUnvalidatedAnnotatedAppFunctions() {
        Sequence sequenceSortedWith = SequencesKt.sortedWith(SequencesKt.filter(SequencesKt.map(Resolver.getSymbolsWithAnnotation$default(null, IntrospectionHelper.AppFunctionAnnotation.INSTANCE.getCLASS_NAME().getCanonicalName(), false, 2, null), new StringUtilsKt$$ExternalSyntheticLambda0(13)), new StringUtilsKt$$ExternalSyntheticLambda0(14)), new Comparator() { // from class: androidx.appfunctions.compiler.core.AppFunctionSymbolResolver$resolveUnvalidatedAnnotatedAppFunctions$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                throw FileInsert$$ExternalSyntheticOutline0.m(t);
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = sequenceSortedWith.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m(it);
        }
        List<Map.Entry> listSortedWith = CollectionsKt.sortedWith(linkedHashMap.entrySet(), new Comparator() { // from class: androidx.appfunctions.compiler.core.AppFunctionSymbolResolver$resolveUnvalidatedAnnotatedAppFunctions$$inlined$sortedBy$2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ((KSClassDeclaration) ((Map.Entry) t).getKey()).getQualifiedName();
                ((KSClassDeclaration) ((Map.Entry) t2).getKey()).getQualifiedName();
                return ComparisonsKt.compareValues(null, null);
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
        for (Map.Entry entry : listSortedWith) {
            arrayList.add(new AnnotatedAppFunctions((KSClassDeclaration) entry.getKey(), (List) entry.getValue(), null, 4, null));
        }
        return arrayList;
    }
}
