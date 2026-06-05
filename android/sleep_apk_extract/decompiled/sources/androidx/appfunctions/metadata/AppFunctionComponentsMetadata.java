package androidx.appfunctions.metadata;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "", "dataTypes", "", "", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "<init>", "(Ljava/util/Map;)V", "getDataTypes", "()Ljava/util/Map;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "toAppFunctionComponentsMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadataDocument;", "toAppFunctionComponentsMetadataDocument$appfunctions", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionComponentsMetadata {
    private final Map<String, AppFunctionDataTypeMetadata> dataTypes;

    public /* synthetic */ AppFunctionComponentsMetadata(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AppFunctionComponentsMetadata.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        return Intrinsics.areEqual(this.dataTypes, ((AppFunctionComponentsMetadata) other).dataTypes);
    }

    public final Map<String, AppFunctionDataTypeMetadata> getDataTypes() {
        return this.dataTypes;
    }

    public int hashCode() {
        return Objects.hashCode(this.dataTypes);
    }

    public final AppFunctionComponentsMetadataDocument toAppFunctionComponentsMetadataDocument$appfunctions() {
        Map<String, AppFunctionDataTypeMetadata> map = this.dataTypes;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, AppFunctionDataTypeMetadata> entry : map.entrySet()) {
            arrayList.add(new AppFunctionNamedDataTypeMetadataDocument(null, null, entry.getKey(), entry.getValue().toAppFunctionDataTypeMetadataDocument$appfunctions(), 3, null));
        }
        return new AppFunctionComponentsMetadataDocument(null, null, arrayList, 3, null);
    }

    public String toString() {
        return "AppFunctionComponentsMetadata(dataTypes=" + this.dataTypes + ')';
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
