package kotlin.reflect.jvm.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B5\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0007H\u0086\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/TypeParameterTable;", "", "ownTypeParameters", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "map", "", "", "Lkotlin/reflect/KTypeParameter;", "parent", "<init>", "(Ljava/util/List;Ljava/util/Map;Lkotlin/reflect/jvm/internal/TypeParameterTable;)V", "getOwnTypeParameters", "()Ljava/util/List;", "get", "id", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TypeParameterTable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final TypeParameterTable EMPTY = new TypeParameterTable(CollectionsKt.emptyList(), MapsKt.emptyMap(), null);
    private final Map<Integer, KTypeParameter> map;
    private final List<KTypeParameterImpl> ownTypeParameters;
    private final TypeParameterTable parent;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/TypeParameterTable$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/reflect/jvm/internal/TypeParameterTable;", "create", "kmTypeParameters", "", "Lkotlin/reflect/jvm/internal/impl/km/KmTypeParameter;", "parent", "container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "classLoader", "Ljava/lang/ClassLoader;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List] */
        public final TypeParameterTable create(List<KmTypeParameter> kmTypeParameters, TypeParameterTable parent, KTypeParameterOwnerImpl container, ClassLoader classLoader) {
            kmTypeParameters.getClass();
            container.getClass();
            classLoader.getClass();
            List<KmTypeParameter> list = kmTypeParameters;
            ArrayList<KTypeParameterImpl> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (KmTypeParameter kmTypeParameter : list) {
                arrayList.add(new KTypeParameterImpl(container, kmTypeParameter.getName(), ConvertFromMetadataKt.toKVariance(kmTypeParameter.getVariance()), Attributes.isReified(kmTypeParameter)));
            }
            Iterable<IndexedValue> iterableWithIndex = CollectionsKt.withIndex(list);
            LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m(iterableWithIndex, 10, 16));
            for (IndexedValue indexedValue : iterableWithIndex) {
                Pair pair = TuplesKt.to(Integer.valueOf(((KmTypeParameter) indexedValue.component2()).getId()), arrayList.get(indexedValue.getIndex()));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            TypeParameterTable typeParameterTable = new TypeParameterTable(arrayList, linkedHashMap, parent, null);
            int i = 0;
            for (KTypeParameterImpl kTypeParameterImpl : arrayList) {
                int i2 = i + 1;
                List<KmType> upperBounds = kmTypeParameters.get(i).getUpperBounds();
                ?? arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(upperBounds, 10));
                Iterator it = upperBounds.iterator();
                while (it.hasNext()) {
                    ClassLoader classLoader2 = classLoader;
                    arrayList2.add(ConvertFromMetadataKt.toKType$default((KmType) it.next(), classLoader2, typeParameterTable, null, 4, null));
                    classLoader = classLoader2;
                }
                ClassLoader classLoader3 = classLoader;
                if (arrayList2.isEmpty()) {
                    arrayList2 = CollectionsKt.listOf(StandardKTypes.INSTANCE.getNULLABLE_ANY());
                }
                kTypeParameterImpl.setUpperBounds((List) arrayList2);
                i = i2;
                classLoader = classLoader3;
            }
            return typeParameterTable;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeParameterTable(List<KTypeParameterImpl> list, Map<Integer, ? extends KTypeParameter> map, TypeParameterTable typeParameterTable) {
        this.ownTypeParameters = list;
        this.map = map;
        this.parent = typeParameterTable;
    }

    public final KTypeParameter get(int id) {
        KTypeParameter kTypeParameter = this.map.get(Integer.valueOf(id));
        if (kTypeParameter != null) {
            return kTypeParameter;
        }
        TypeParameterTable typeParameterTable = this.parent;
        if (typeParameterTable != null) {
            return typeParameterTable.get(id);
        }
        return null;
    }

    public final List<KTypeParameterImpl> getOwnTypeParameters() {
        return this.ownTypeParameters;
    }

    public /* synthetic */ TypeParameterTable(List list, Map map, TypeParameterTable typeParameterTable, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, map, typeParameterTable);
    }
}
