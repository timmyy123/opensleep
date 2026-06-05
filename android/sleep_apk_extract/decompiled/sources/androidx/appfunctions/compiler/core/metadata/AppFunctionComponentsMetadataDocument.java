package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionComponentsMetadataDocument;", "", "namespace", "", "id", "dataTypes", "", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionNamedDataTypeMetadataDocument;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getDataTypes", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionComponentsMetadataDocument {
    private final List<AppFunctionNamedDataTypeMetadataDocument> dataTypes;
    private final String id;
    private final String namespace;

    public AppFunctionComponentsMetadataDocument(String str, String str2, List<AppFunctionNamedDataTypeMetadataDocument> list) {
        str.getClass();
        str2.getClass();
        list.getClass();
        this.namespace = str;
        this.id = str2;
        this.dataTypes = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppFunctionComponentsMetadataDocument copy$default(AppFunctionComponentsMetadataDocument appFunctionComponentsMetadataDocument, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionComponentsMetadataDocument.namespace;
        }
        if ((i & 2) != 0) {
            str2 = appFunctionComponentsMetadataDocument.id;
        }
        if ((i & 4) != 0) {
            list = appFunctionComponentsMetadataDocument.dataTypes;
        }
        return appFunctionComponentsMetadataDocument.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<AppFunctionNamedDataTypeMetadataDocument> component3() {
        return this.dataTypes;
    }

    public final AppFunctionComponentsMetadataDocument copy(String namespace, String id, List<AppFunctionNamedDataTypeMetadataDocument> dataTypes) {
        namespace.getClass();
        id.getClass();
        dataTypes.getClass();
        return new AppFunctionComponentsMetadataDocument(namespace, id, dataTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionComponentsMetadataDocument)) {
            return false;
        }
        AppFunctionComponentsMetadataDocument appFunctionComponentsMetadataDocument = (AppFunctionComponentsMetadataDocument) other;
        return Intrinsics.areEqual(this.namespace, appFunctionComponentsMetadataDocument.namespace) && Intrinsics.areEqual(this.id, appFunctionComponentsMetadataDocument.id) && Intrinsics.areEqual(this.dataTypes, appFunctionComponentsMetadataDocument.dataTypes);
    }

    public final List<AppFunctionNamedDataTypeMetadataDocument> getDataTypes() {
        return this.dataTypes;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        return this.dataTypes.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.namespace.hashCode() * 31, 31, this.id);
    }

    public String toString() {
        String str = this.namespace;
        String str2 = this.id;
        List<AppFunctionNamedDataTypeMetadataDocument> list = this.dataTypes;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("AppFunctionComponentsMetadataDocument(namespace=", str, ", id=", str2, ", dataTypes=");
        sbM6m.append(list);
        sbM6m.append(")");
        return sbM6m.toString();
    }

    public /* synthetic */ AppFunctionComponentsMetadataDocument(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "appfunctions" : str, (i & 2) != 0 ? "unused" : str2, list);
    }
}
