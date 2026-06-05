package androidx.appfunctions.compiler.core.metadata;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionResponseMetadata;", "", "valueType", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "description", "", "<init>", "(Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;Ljava/lang/String;)V", "getValueType", "()Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "getDescription", "()Ljava/lang/String;", "toAppFunctionResponseMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionResponseMetadataDocument;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionResponseMetadata {
    private final String description;
    private final AppFunctionDataTypeMetadata valueType;

    public AppFunctionResponseMetadata(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str) {
        appFunctionDataTypeMetadata.getClass();
        str.getClass();
        this.valueType = appFunctionDataTypeMetadata;
        this.description = str;
    }

    public static /* synthetic */ AppFunctionResponseMetadata copy$default(AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            appFunctionDataTypeMetadata = appFunctionResponseMetadata.valueType;
        }
        if ((i & 2) != 0) {
            str = appFunctionResponseMetadata.description;
        }
        return appFunctionResponseMetadata.copy(appFunctionDataTypeMetadata, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AppFunctionDataTypeMetadata getValueType() {
        return this.valueType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionResponseMetadata copy(AppFunctionDataTypeMetadata valueType, String description) {
        valueType.getClass();
        description.getClass();
        return new AppFunctionResponseMetadata(valueType, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionResponseMetadata)) {
            return false;
        }
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

    public final AppFunctionResponseMetadataDocument toAppFunctionResponseMetadataDocument() {
        return new AppFunctionResponseMetadataDocument(null, null, this.valueType.toAppFunctionDataTypeMetadataDocument(), this.description, 3, null);
    }

    public String toString() {
        return "AppFunctionResponseMetadata(valueType=" + this.valueType + ", description=" + this.description + ")";
    }
}
