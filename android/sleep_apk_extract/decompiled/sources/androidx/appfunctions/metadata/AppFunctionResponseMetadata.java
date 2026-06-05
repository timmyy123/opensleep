package androidx.appfunctions.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "", "valueType", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "description", "", "<init>", "(Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Ljava/lang/String;)V", "getValueType", "()Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "getDescription", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "toAppFunctionResponseMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadataDocument;", "toAppFunctionResponseMetadataDocument$appfunctions", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionResponseMetadata {
    private final String description;
    private final AppFunctionDataTypeMetadata valueType;

    public AppFunctionResponseMetadata(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str) {
        appFunctionDataTypeMetadata.getClass();
        str.getClass();
        this.valueType = appFunctionDataTypeMetadata;
        this.description = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AppFunctionResponseMetadata.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AppFunctionResponseMetadata appFunctionResponseMetadata = (AppFunctionResponseMetadata) other;
        return Intrinsics.areEqual(this.valueType, appFunctionResponseMetadata.valueType) && Intrinsics.areEqual(this.description, appFunctionResponseMetadata.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionDataTypeMetadata getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        return this.description.hashCode() + (this.valueType.hashCode() * 31);
    }

    public final AppFunctionResponseMetadataDocument toAppFunctionResponseMetadataDocument$appfunctions() {
        return new AppFunctionResponseMetadataDocument(null, null, this.valueType.toAppFunctionDataTypeMetadataDocument$appfunctions(), this.description, 3, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionResponseMetadata(valueType=");
        sb.append(this.valueType);
        sb.append(", description=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.description, ')');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionResponseMetadata(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata) {
        this(appFunctionDataTypeMetadata, null, 2, 0 == true ? 1 : 0);
        appFunctionDataTypeMetadata.getClass();
    }

    public /* synthetic */ AppFunctionResponseMetadata(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appFunctionDataTypeMetadata, (i & 2) != 0 ? "" : str);
    }
}
