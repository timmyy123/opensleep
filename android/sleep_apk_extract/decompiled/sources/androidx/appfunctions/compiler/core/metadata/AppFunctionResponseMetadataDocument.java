package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionResponseMetadataDocument;", "", "namespace", "", "id", "valueType", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getValueType", "()Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "getDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionResponseMetadataDocument {
    private final String description;
    private final String id;
    private final String namespace;
    private final AppFunctionDataTypeMetadataDocument valueType;

    public AppFunctionResponseMetadataDocument(String str, String str2, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, String str3) {
        str.getClass();
        str2.getClass();
        appFunctionDataTypeMetadataDocument.getClass();
        str3.getClass();
        this.namespace = str;
        this.id = str2;
        this.valueType = appFunctionDataTypeMetadataDocument;
        this.description = str3;
    }

    public static /* synthetic */ AppFunctionResponseMetadataDocument copy$default(AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument, String str, String str2, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionResponseMetadataDocument.namespace;
        }
        if ((i & 2) != 0) {
            str2 = appFunctionResponseMetadataDocument.id;
        }
        if ((i & 4) != 0) {
            appFunctionDataTypeMetadataDocument = appFunctionResponseMetadataDocument.valueType;
        }
        if ((i & 8) != 0) {
            str3 = appFunctionResponseMetadataDocument.description;
        }
        return appFunctionResponseMetadataDocument.copy(str, str2, appFunctionDataTypeMetadataDocument, str3);
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
    public final AppFunctionDataTypeMetadataDocument getValueType() {
        return this.valueType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionResponseMetadataDocument copy(String namespace, String id, AppFunctionDataTypeMetadataDocument valueType, String description) {
        namespace.getClass();
        id.getClass();
        valueType.getClass();
        description.getClass();
        return new AppFunctionResponseMetadataDocument(namespace, id, valueType, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionResponseMetadataDocument)) {
            return false;
        }
        AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument = (AppFunctionResponseMetadataDocument) other;
        return Intrinsics.areEqual(this.namespace, appFunctionResponseMetadataDocument.namespace) && Intrinsics.areEqual(this.id, appFunctionResponseMetadataDocument.id) && Intrinsics.areEqual(this.valueType, appFunctionResponseMetadataDocument.valueType) && Intrinsics.areEqual(this.description, appFunctionResponseMetadataDocument.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final AppFunctionDataTypeMetadataDocument getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        return this.description.hashCode() + ((this.valueType.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.namespace.hashCode() * 31, 31, this.id)) * 31);
    }

    public String toString() {
        String str = this.namespace;
        String str2 = this.id;
        AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument = this.valueType;
        String str3 = this.description;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("AppFunctionResponseMetadataDocument(namespace=", str, ", id=", str2, ", valueType=");
        sbM6m.append(appFunctionDataTypeMetadataDocument);
        sbM6m.append(", description=");
        sbM6m.append(str3);
        sbM6m.append(")");
        return sbM6m.toString();
    }

    public /* synthetic */ AppFunctionResponseMetadataDocument(String str, String str2, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "appfunctions" : str, (i & 2) != 0 ? "unused" : str2, appFunctionDataTypeMetadataDocument, str3);
    }
}
