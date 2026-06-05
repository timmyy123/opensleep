package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u001a"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionReferenceTypeMetadata;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "referenceDataType", "", "isNullable", "", "description", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getReferenceDataType", "()Ljava/lang/String;", "()Z", "getDescription", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionReferenceTypeMetadata extends AppFunctionDataTypeMetadata {
    public static final int TYPE = 11;
    private final String description;
    private final boolean isNullable;
    private final String referenceDataType;

    public AppFunctionReferenceTypeMetadata(String str, boolean z, String str2) {
        str.getClass();
        str2.getClass();
        this.referenceDataType = str;
        this.isNullable = z;
        this.description = str2;
    }

    public static /* synthetic */ AppFunctionReferenceTypeMetadata copy$default(AppFunctionReferenceTypeMetadata appFunctionReferenceTypeMetadata, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionReferenceTypeMetadata.referenceDataType;
        }
        if ((i & 2) != 0) {
            z = appFunctionReferenceTypeMetadata.isNullable;
        }
        if ((i & 4) != 0) {
            str2 = appFunctionReferenceTypeMetadata.description;
        }
        return appFunctionReferenceTypeMetadata.copy(str, z, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getReferenceDataType() {
        return this.referenceDataType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionReferenceTypeMetadata copy(String referenceDataType, boolean isNullable, String description) {
        referenceDataType.getClass();
        description.getClass();
        return new AppFunctionReferenceTypeMetadata(referenceDataType, isNullable, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionReferenceTypeMetadata)) {
            return false;
        }
        AppFunctionReferenceTypeMetadata appFunctionReferenceTypeMetadata = (AppFunctionReferenceTypeMetadata) other;
        return Intrinsics.areEqual(this.referenceDataType, appFunctionReferenceTypeMetadata.referenceDataType) && this.isNullable == appFunctionReferenceTypeMetadata.isNullable && Intrinsics.areEqual(this.description, appFunctionReferenceTypeMetadata.description);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public String getDescription() {
        return this.description;
    }

    public final String getReferenceDataType() {
        return this.referenceDataType;
    }

    public int hashCode() {
        return this.description.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.isNullable, this.referenceDataType.hashCode() * 31, 31);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public boolean isNullable() {
        return this.isNullable;
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument() {
        return new AppFunctionDataTypeMetadataDocument(null, null, 11, null, null, null, null, null, this.referenceDataType, isNullable(), null, getDescription(), null, 5371, null);
    }

    public String toString() {
        String str = this.referenceDataType;
        boolean z = this.isNullable;
        String str2 = this.description;
        StringBuilder sb = new StringBuilder("AppFunctionReferenceTypeMetadata(referenceDataType=");
        sb.append(str);
        sb.append(", isNullable=");
        sb.append(z);
        sb.append(", description=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, str2, ")");
    }
}
