package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionArrayTypeMetadata;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "itemType", "isNullable", "", "description", "", "<init>", "(Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;ZLjava/lang/String;)V", "getItemType", "()Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "()Z", "getDescription", "()Ljava/lang/String;", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionArrayTypeMetadata extends AppFunctionDataTypeMetadata {
    public static final int TYPE = 10;
    private final String description;
    private final boolean isNullable;
    private final AppFunctionDataTypeMetadata itemType;

    public AppFunctionArrayTypeMetadata(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, boolean z, String str) {
        appFunctionDataTypeMetadata.getClass();
        str.getClass();
        this.itemType = appFunctionDataTypeMetadata;
        this.isNullable = z;
        this.description = str;
    }

    public static /* synthetic */ AppFunctionArrayTypeMetadata copy$default(AppFunctionArrayTypeMetadata appFunctionArrayTypeMetadata, AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            appFunctionDataTypeMetadata = appFunctionArrayTypeMetadata.itemType;
        }
        if ((i & 2) != 0) {
            z = appFunctionArrayTypeMetadata.isNullable;
        }
        if ((i & 4) != 0) {
            str = appFunctionArrayTypeMetadata.description;
        }
        return appFunctionArrayTypeMetadata.copy(appFunctionDataTypeMetadata, z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AppFunctionDataTypeMetadata getItemType() {
        return this.itemType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionArrayTypeMetadata copy(AppFunctionDataTypeMetadata itemType, boolean isNullable, String description) {
        itemType.getClass();
        description.getClass();
        return new AppFunctionArrayTypeMetadata(itemType, isNullable, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionArrayTypeMetadata)) {
            return false;
        }
        AppFunctionArrayTypeMetadata appFunctionArrayTypeMetadata = (AppFunctionArrayTypeMetadata) other;
        return Intrinsics.areEqual(this.itemType, appFunctionArrayTypeMetadata.itemType) && this.isNullable == appFunctionArrayTypeMetadata.isNullable && Intrinsics.areEqual(this.description, appFunctionArrayTypeMetadata.description);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public String getDescription() {
        return this.description;
    }

    public final AppFunctionDataTypeMetadata getItemType() {
        return this.itemType;
    }

    public int hashCode() {
        return this.description.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.isNullable, this.itemType.hashCode() * 31, 31);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public boolean isNullable() {
        return this.isNullable;
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument() {
        return new AppFunctionDataTypeMetadataDocument(null, null, 10, this.itemType.toAppFunctionDataTypeMetadataDocument(), null, null, null, null, null, isNullable(), null, getDescription(), null, 5619, null);
    }

    public String toString() {
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = this.itemType;
        boolean z = this.isNullable;
        String str = this.description;
        StringBuilder sb = new StringBuilder("AppFunctionArrayTypeMetadata(itemType=");
        sb.append(appFunctionDataTypeMetadata);
        sb.append(", isNullable=");
        sb.append(z);
        sb.append(", description=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, str, ")");
    }
}
