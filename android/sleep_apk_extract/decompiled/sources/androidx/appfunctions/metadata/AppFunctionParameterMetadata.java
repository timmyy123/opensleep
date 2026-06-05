package androidx.appfunctions.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "", "name", "", "isRequired", "", "dataType", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "description", "<init>", "(Ljava/lang/String;ZLandroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "()Z", "getDataType", "()Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "getDescription", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "toAppFunctionParameterMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadataDocument;", "toAppFunctionParameterMetadataDocument$appfunctions", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionParameterMetadata {
    private final AppFunctionDataTypeMetadata dataType;
    private final String description;
    private final boolean isRequired;
    private final String name;

    public AppFunctionParameterMetadata(String str, boolean z, AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str2) {
        str.getClass();
        appFunctionDataTypeMetadata.getClass();
        str2.getClass();
        this.name = str;
        this.isRequired = z;
        this.dataType = appFunctionDataTypeMetadata;
        this.description = str2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AppFunctionParameterMetadata.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AppFunctionParameterMetadata appFunctionParameterMetadata = (AppFunctionParameterMetadata) other;
        return Intrinsics.areEqual(this.name, appFunctionParameterMetadata.name) && this.isRequired == appFunctionParameterMetadata.isRequired && Intrinsics.areEqual(this.dataType, appFunctionParameterMetadata.dataType) && Intrinsics.areEqual(this.description, appFunctionParameterMetadata.description);
    }

    public final AppFunctionDataTypeMetadata getDataType() {
        return this.dataType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.description.hashCode() + ((this.dataType.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.isRequired, this.name.hashCode() * 31, 31)) * 31);
    }

    /* JADX INFO: renamed from: isRequired, reason: from getter */
    public final boolean getIsRequired() {
        return this.isRequired;
    }

    public final AppFunctionParameterMetadataDocument toAppFunctionParameterMetadataDocument$appfunctions() {
        return new AppFunctionParameterMetadataDocument(null, null, this.name, this.isRequired, this.dataType.toAppFunctionDataTypeMetadataDocument$appfunctions(), this.description, 3, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionParameterMetadata(name=");
        sb.append(this.name);
        sb.append(", isRequired=");
        sb.append(this.isRequired);
        sb.append(", dataType=");
        sb.append(this.dataType);
        sb.append(",description=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.description, ')');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionParameterMetadata(String str, boolean z, AppFunctionDataTypeMetadata appFunctionDataTypeMetadata) {
        this(str, z, appFunctionDataTypeMetadata, null, 8, null);
        str.getClass();
        appFunctionDataTypeMetadata.getClass();
    }

    public /* synthetic */ AppFunctionParameterMetadata(String str, boolean z, AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, appFunctionDataTypeMetadata, (i & 8) != 0 ? "" : str2);
    }
}
