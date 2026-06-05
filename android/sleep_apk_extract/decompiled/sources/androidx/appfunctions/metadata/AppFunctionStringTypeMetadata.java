package androidx.appfunctions.metadata;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\f\u001a\u00020\rH\u0010¢\u0006\u0002\b\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionStringTypeMetadata;", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "isNullable", "", "description", "", "enumValues", "", "<init>", "(ZLjava/lang/String;Ljava/util/Set;)V", "getEnumValues", "()Ljava/util/Set;", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "toAppFunctionDataTypeMetadataDocument$appfunctions", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionStringTypeMetadata extends AppFunctionDataTypeMetadata {
    private final Set<String> enumValues;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFunctionStringTypeMetadata(boolean z, String str, Set<String> set) {
        super(z, str);
        str.getClass();
        this.enumValues = set;
        if (set == null || !set.isEmpty()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("If specified, enumValues cannot be empty.");
        throw null;
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AppFunctionStringTypeMetadata) {
            return super.equals(other);
        }
        return false;
    }

    public final Set<String> getEnumValues() {
        return this.enumValues;
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
        return new AppFunctionDataTypeMetadataDocument(null, null, 8, null, null, null, null, null, null, isNullable, null, description, null, 5627, null);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public String toString() {
        return "AppFunctionStringTypeMetadata(isNullable=" + getIsNullable() + ", description=" + getDescription() + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionStringTypeMetadata(boolean z, String str) {
        this(z, str, null, 4, null);
        str.getClass();
    }

    public AppFunctionStringTypeMetadata(boolean z) {
        this(z, null, null, 6, null);
    }

    public /* synthetic */ AppFunctionStringTypeMetadata(boolean z, String str, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : set);
    }
}
