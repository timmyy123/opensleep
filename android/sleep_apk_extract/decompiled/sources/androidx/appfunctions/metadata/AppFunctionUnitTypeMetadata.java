package androidx.appfunctions.metadata;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\tH\u0010¢\u0006\u0002\b\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionUnitTypeMetadata;", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "isNullable", "", "description", "", "<init>", "(ZLjava/lang/String;)V", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "toAppFunctionDataTypeMetadataDocument$appfunctions", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionUnitTypeMetadata extends AppFunctionDataTypeMetadata {
    public /* synthetic */ AppFunctionUnitTypeMetadata(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AppFunctionUnitTypeMetadata) {
            return super.equals(other);
        }
        return false;
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument$appfunctions() {
        boolean isNullable = getIsNullable();
        String description = getDescription();
        if (description.length() == 0) {
            description = null;
        }
        return new AppFunctionDataTypeMetadataDocument(null, null, 0, null, null, null, null, null, null, isNullable, null, description, null, 5627, null);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public String toString() {
        return "AppFunctionUnitTypeMetadata(isNullable=" + getIsNullable() + ", description=" + getDescription() + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionUnitTypeMetadata(boolean z) {
        this(z, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFunctionUnitTypeMetadata(boolean z, String str) {
        super(z, str);
        str.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionUnitTypeMetadata() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }
}
