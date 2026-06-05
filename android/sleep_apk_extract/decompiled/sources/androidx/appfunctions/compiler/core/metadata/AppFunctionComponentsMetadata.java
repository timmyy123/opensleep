package androidx.appfunctions.compiler.core.metadata;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0004HÖ\u0081\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionComponentsMetadata;", "", "dataTypes", "", "", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "<init>", "(Ljava/util/Map;)V", "getDataTypes", "()Ljava/util/Map;", "toAppFunctionComponentsMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionComponentsMetadataDocument;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionComponentsMetadata {
    private final Map<String, AppFunctionDataTypeMetadata> dataTypes;

    public /* synthetic */ AppFunctionComponentsMetadata(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppFunctionComponentsMetadata copy$default(AppFunctionComponentsMetadata appFunctionComponentsMetadata, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = appFunctionComponentsMetadata.dataTypes;
        }
        return appFunctionComponentsMetadata.copy(map);
    }

    public final Map<String, AppFunctionDataTypeMetadata> component1() {
        return this.dataTypes;
    }

    public final AppFunctionComponentsMetadata copy(Map<String, ? extends AppFunctionDataTypeMetadata> dataTypes) {
        dataTypes.getClass();
        return new AppFunctionComponentsMetadata(dataTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AppFunctionComponentsMetadata) && Intrinsics.areEqual(this.dataTypes, ((AppFunctionComponentsMetadata) other).dataTypes);
    }

    public final Map<String, AppFunctionDataTypeMetadata> getDataTypes() {
        return this.dataTypes;
    }

    public int hashCode() {
        return this.dataTypes.hashCode();
    }

    public final AppFunctionComponentsMetadataDocument toAppFunctionComponentsMetadataDocument() {
        List<Map.Entry> listSortedWith = CollectionsKt.sortedWith(this.dataTypes.entrySet(), new Comparator() { // from class: androidx.appfunctions.compiler.core.metadata.AppFunctionComponentsMetadata$toAppFunctionComponentsMetadataDocument$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Map.Entry) t).getKey(), (String) ((Map.Entry) t2).getKey());
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
        for (Map.Entry entry : listSortedWith) {
            arrayList.add(new AppFunctionNamedDataTypeMetadataDocument(null, null, (String) entry.getKey(), ((AppFunctionDataTypeMetadata) entry.getValue()).toAppFunctionDataTypeMetadataDocument(), 3, null));
        }
        return new AppFunctionComponentsMetadataDocument(null, null, arrayList, 3, null);
    }

    public String toString() {
        return "AppFunctionComponentsMetadata(dataTypes=" + this.dataTypes + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionComponentsMetadata(Map<String, ? extends AppFunctionDataTypeMetadata> map) {
        map.getClass();
        this.dataTypes = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionComponentsMetadata() {
        this(null, 1, 0 == true ? 1 : 0);
    }
}
