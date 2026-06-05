package androidx.appfunctions.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionNamedDataTypeMetadataDocument;", "", "namespace", "", "id", "name", "dataTypeMetadata", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getName", "getDataTypeMetadata", "()Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionNamedDataTypeMetadataDocument {
    private final AppFunctionDataTypeMetadataDocument dataTypeMetadata;
    private final String id;
    private final String name;
    private final String namespace;

    public AppFunctionNamedDataTypeMetadataDocument(String str, String str2, String str3, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        appFunctionDataTypeMetadataDocument.getClass();
        this.namespace = str;
        this.id = str2;
        this.name = str3;
        this.dataTypeMetadata = appFunctionDataTypeMetadataDocument;
    }

    public static /* synthetic */ AppFunctionNamedDataTypeMetadataDocument copy$default(AppFunctionNamedDataTypeMetadataDocument appFunctionNamedDataTypeMetadataDocument, String str, String str2, String str3, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionNamedDataTypeMetadataDocument.namespace;
        }
        if ((i & 2) != 0) {
            str2 = appFunctionNamedDataTypeMetadataDocument.id;
        }
        if ((i & 4) != 0) {
            str3 = appFunctionNamedDataTypeMetadataDocument.name;
        }
        if ((i & 8) != 0) {
            appFunctionDataTypeMetadataDocument = appFunctionNamedDataTypeMetadataDocument.dataTypeMetadata;
        }
        return appFunctionNamedDataTypeMetadataDocument.copy(str, str2, str3, appFunctionDataTypeMetadataDocument);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final AppFunctionDataTypeMetadataDocument getDataTypeMetadata() {
        return this.dataTypeMetadata;
    }

    public final AppFunctionNamedDataTypeMetadataDocument copy(String namespace, String id, String name, AppFunctionDataTypeMetadataDocument dataTypeMetadata) {
        namespace.getClass();
        id.getClass();
        name.getClass();
        dataTypeMetadata.getClass();
        return new AppFunctionNamedDataTypeMetadataDocument(namespace, id, name, dataTypeMetadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionNamedDataTypeMetadataDocument)) {
            return false;
        }
        AppFunctionNamedDataTypeMetadataDocument appFunctionNamedDataTypeMetadataDocument = (AppFunctionNamedDataTypeMetadataDocument) other;
        return Intrinsics.areEqual(this.namespace, appFunctionNamedDataTypeMetadataDocument.namespace) && Intrinsics.areEqual(this.id, appFunctionNamedDataTypeMetadataDocument.id) && Intrinsics.areEqual(this.name, appFunctionNamedDataTypeMetadataDocument.name) && Intrinsics.areEqual(this.dataTypeMetadata, appFunctionNamedDataTypeMetadataDocument.dataTypeMetadata);
    }

    public final AppFunctionDataTypeMetadataDocument getDataTypeMetadata() {
        return this.dataTypeMetadata;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        return this.dataTypeMetadata.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(this.namespace.hashCode() * 31, 31, this.id), 31, this.name);
    }

    public String toString() {
        return "AppFunctionNamedDataTypeMetadataDocument(namespace=" + this.namespace + ", id=" + this.id + ", name=" + this.name + ", dataTypeMetadata=" + this.dataTypeMetadata + ')';
    }

    public /* synthetic */ AppFunctionNamedDataTypeMetadataDocument(String str, String str2, String str3, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "appfunctions" : str, (i & 2) != 0 ? "unused" : str2, str3, appFunctionDataTypeMetadataDocument);
    }
}
