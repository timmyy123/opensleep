package androidx.appfunctions.metadata;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\r\u0010\u0011\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u0013R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionArrayTypeMetadata;", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "itemType", "isNullable", "", "description", "", "<init>", "(Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;ZLjava/lang/String;)V", "getItemType", "()Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "toAppFunctionDataTypeMetadataDocument$appfunctions", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionArrayTypeMetadata extends AppFunctionDataTypeMetadata {
    public static final int TYPE = 10;
    private final AppFunctionDataTypeMetadata itemType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionArrayTypeMetadata(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, boolean z) {
        this(appFunctionDataTypeMetadata, z, null, 4, null);
        appFunctionDataTypeMetadata.getClass();
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public boolean equals(Object other) {
        if (super.equals(other) && (other instanceof AppFunctionArrayTypeMetadata)) {
            return Intrinsics.areEqual(this.itemType, ((AppFunctionArrayTypeMetadata) other).itemType);
        }
        return false;
    }

    public final AppFunctionDataTypeMetadata getItemType() {
        return this.itemType;
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public int hashCode() {
        return this.itemType.hashCode() + (super.hashCode() * 31);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument$appfunctions() {
        AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument$appfunctions = this.itemType.toAppFunctionDataTypeMetadataDocument$appfunctions();
        boolean isNullable = getIsNullable();
        String description = getDescription();
        if (description.length() == 0) {
            description = null;
        }
        return new AppFunctionDataTypeMetadataDocument(null, null, 10, appFunctionDataTypeMetadataDocument$appfunctions, null, null, null, null, null, isNullable, null, description, null, 5619, null);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public String toString() {
        return "AppFunctionArrayTypeMetadataDocument(itemType=" + this.itemType + ", isNullable=" + getIsNullable() + ",description=" + getDescription() + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFunctionArrayTypeMetadata(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, boolean z, String str) {
        super(z, str);
        appFunctionDataTypeMetadata.getClass();
        str.getClass();
        this.itemType = appFunctionDataTypeMetadata;
    }

    public /* synthetic */ AppFunctionArrayTypeMetadata(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appFunctionDataTypeMetadata, z, (i & 4) != 0 ? "" : str);
    }
}
