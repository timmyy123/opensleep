package androidx.appfunctions.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006#"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionParameterMetadataDocument;", "", "namespace", "", "id", "name", "isRequired", "", "dataTypeMetadata", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getName", "()Z", "getDataTypeMetadata", "()Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "getDescription", "toAppFunctionParameterMetadata", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionParameterMetadataDocument {
    private final AppFunctionDataTypeMetadataDocument dataTypeMetadata;
    private final String description;
    private final String id;
    private final boolean isRequired;
    private final String name;
    private final String namespace;

    public AppFunctionParameterMetadataDocument(String str, String str2, String str3, boolean z, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, String str4) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        appFunctionDataTypeMetadataDocument.getClass();
        this.namespace = str;
        this.id = str2;
        this.name = str3;
        this.isRequired = z;
        this.dataTypeMetadata = appFunctionDataTypeMetadataDocument;
        this.description = str4;
    }

    public static /* synthetic */ AppFunctionParameterMetadataDocument copy$default(AppFunctionParameterMetadataDocument appFunctionParameterMetadataDocument, String str, String str2, String str3, boolean z, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionParameterMetadataDocument.namespace;
        }
        if ((i & 2) != 0) {
            str2 = appFunctionParameterMetadataDocument.id;
        }
        if ((i & 4) != 0) {
            str3 = appFunctionParameterMetadataDocument.name;
        }
        if ((i & 8) != 0) {
            z = appFunctionParameterMetadataDocument.isRequired;
        }
        if ((i & 16) != 0) {
            appFunctionDataTypeMetadataDocument = appFunctionParameterMetadataDocument.dataTypeMetadata;
        }
        if ((i & 32) != 0) {
            str4 = appFunctionParameterMetadataDocument.description;
        }
        AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument2 = appFunctionDataTypeMetadataDocument;
        String str5 = str4;
        return appFunctionParameterMetadataDocument.copy(str, str2, str3, z, appFunctionDataTypeMetadataDocument2, str5);
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
    public final boolean getIsRequired() {
        return this.isRequired;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final AppFunctionDataTypeMetadataDocument getDataTypeMetadata() {
        return this.dataTypeMetadata;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionParameterMetadataDocument copy(String namespace, String id, String name, boolean isRequired, AppFunctionDataTypeMetadataDocument dataTypeMetadata, String description) {
        namespace.getClass();
        id.getClass();
        name.getClass();
        dataTypeMetadata.getClass();
        return new AppFunctionParameterMetadataDocument(namespace, id, name, isRequired, dataTypeMetadata, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionParameterMetadataDocument)) {
            return false;
        }
        AppFunctionParameterMetadataDocument appFunctionParameterMetadataDocument = (AppFunctionParameterMetadataDocument) other;
        return Intrinsics.areEqual(this.namespace, appFunctionParameterMetadataDocument.namespace) && Intrinsics.areEqual(this.id, appFunctionParameterMetadataDocument.id) && Intrinsics.areEqual(this.name, appFunctionParameterMetadataDocument.name) && this.isRequired == appFunctionParameterMetadataDocument.isRequired && Intrinsics.areEqual(this.dataTypeMetadata, appFunctionParameterMetadataDocument.dataTypeMetadata) && Intrinsics.areEqual(this.description, appFunctionParameterMetadataDocument.description);
    }

    public final AppFunctionDataTypeMetadataDocument getDataTypeMetadata() {
        return this.dataTypeMetadata;
    }

    public final String getDescription() {
        return this.description;
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
        int iHashCode = (this.dataTypeMetadata.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.isRequired, FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(this.namespace.hashCode() * 31, 31, this.id), 31, this.name), 31)) * 31;
        String str = this.description;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean isRequired() {
        return this.isRequired;
    }

    public final AppFunctionParameterMetadata toAppFunctionParameterMetadata() {
        String str = this.name;
        boolean z = this.isRequired;
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = this.dataTypeMetadata.toAppFunctionDataTypeMetadata();
        String str2 = this.description;
        if (str2 == null) {
            str2 = "";
        }
        return new AppFunctionParameterMetadata(str, z, appFunctionDataTypeMetadata, str2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionParameterMetadataDocument(namespace=");
        sb.append(this.namespace);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", isRequired=");
        sb.append(this.isRequired);
        sb.append(", dataTypeMetadata=");
        sb.append(this.dataTypeMetadata);
        sb.append(", description=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.description, ')');
    }

    public /* synthetic */ AppFunctionParameterMetadataDocument(String str, String str2, String str3, boolean z, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "appfunctions" : str, (i & 2) != 0 ? "unused" : str2, str3, z, appFunctionDataTypeMetadataDocument, (i & 32) != 0 ? null : str4);
    }
}
