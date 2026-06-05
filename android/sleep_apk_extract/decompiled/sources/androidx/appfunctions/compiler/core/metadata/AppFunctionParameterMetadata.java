package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionParameterMetadata;", "", "name", "", "isRequired", "", "dataType", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "description", "<init>", "(Ljava/lang/String;ZLandroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "()Z", "getDataType", "()Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "getDescription", "toAppFunctionParameterMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionParameterMetadataDocument;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionParameterMetadata {
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

    public static /* synthetic */ AppFunctionParameterMetadata copy$default(AppFunctionParameterMetadata appFunctionParameterMetadata, String str, boolean z, AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionParameterMetadata.name;
        }
        if ((i & 2) != 0) {
            z = appFunctionParameterMetadata.isRequired;
        }
        if ((i & 4) != 0) {
            appFunctionDataTypeMetadata = appFunctionParameterMetadata.dataType;
        }
        if ((i & 8) != 0) {
            str2 = appFunctionParameterMetadata.description;
        }
        return appFunctionParameterMetadata.copy(str, z, appFunctionDataTypeMetadata, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsRequired() {
        return this.isRequired;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AppFunctionDataTypeMetadata getDataType() {
        return this.dataType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionParameterMetadata copy(String name, boolean isRequired, AppFunctionDataTypeMetadata dataType, String description) {
        name.getClass();
        dataType.getClass();
        description.getClass();
        return new AppFunctionParameterMetadata(name, isRequired, dataType, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionParameterMetadata)) {
            return false;
        }
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

    public final boolean isRequired() {
        return this.isRequired;
    }

    public final AppFunctionParameterMetadataDocument toAppFunctionParameterMetadataDocument() {
        return new AppFunctionParameterMetadataDocument(null, null, this.name, this.isRequired, this.dataType.toAppFunctionDataTypeMetadataDocument(), this.description, 3, null);
    }

    public String toString() {
        return "AppFunctionParameterMetadata(name=" + this.name + ", isRequired=" + this.isRequired + ", dataType=" + this.dataType + ", description=" + this.description + ")";
    }
}
