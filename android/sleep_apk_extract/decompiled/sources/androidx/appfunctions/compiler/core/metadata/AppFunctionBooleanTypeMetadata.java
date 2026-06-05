package androidx.appfunctions.compiler.core.metadata;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionBooleanTypeMetadata;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "isNullable", "", "description", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getDescription", "()Ljava/lang/String;", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionBooleanTypeMetadata extends AppFunctionDataTypeMetadata {
    private final String description;
    private final boolean isNullable;

    public AppFunctionBooleanTypeMetadata(boolean z, String str) {
        str.getClass();
        this.isNullable = z;
        this.description = str;
    }

    public static /* synthetic */ AppFunctionBooleanTypeMetadata copy$default(AppFunctionBooleanTypeMetadata appFunctionBooleanTypeMetadata, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = appFunctionBooleanTypeMetadata.isNullable;
        }
        if ((i & 2) != 0) {
            str = appFunctionBooleanTypeMetadata.description;
        }
        return appFunctionBooleanTypeMetadata.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionBooleanTypeMetadata copy(boolean isNullable, String description) {
        description.getClass();
        return new AppFunctionBooleanTypeMetadata(isNullable, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionBooleanTypeMetadata)) {
            return false;
        }
        AppFunctionBooleanTypeMetadata appFunctionBooleanTypeMetadata = (AppFunctionBooleanTypeMetadata) other;
        return this.isNullable == appFunctionBooleanTypeMetadata.isNullable && Intrinsics.areEqual(this.description, appFunctionBooleanTypeMetadata.description);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return this.description.hashCode() + (Boolean.hashCode(this.isNullable) * 31);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public boolean isNullable() {
        return this.isNullable;
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument() {
        return new AppFunctionDataTypeMetadataDocument(null, null, 1, null, null, null, null, null, null, isNullable(), null, getDescription(), null, 5627, null);
    }

    public String toString() {
        return "AppFunctionBooleanTypeMetadata(isNullable=" + this.isNullable + ", description=" + this.description + ")";
    }
}
