package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u001a"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionParcelableTypeMetadata;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "", "isNullable", "", "description", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getQualifiedName", "()Ljava/lang/String;", "()Z", "getDescription", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionParcelableTypeMetadata extends AppFunctionDataTypeMetadata {
    public static final int TYPE = 13;
    private final String description;
    private final boolean isNullable;
    private final String qualifiedName;

    public AppFunctionParcelableTypeMetadata(String str, boolean z, String str2) {
        str2.getClass();
        this.qualifiedName = str;
        this.isNullable = z;
        this.description = str2;
    }

    public static /* synthetic */ AppFunctionParcelableTypeMetadata copy$default(AppFunctionParcelableTypeMetadata appFunctionParcelableTypeMetadata, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionParcelableTypeMetadata.qualifiedName;
        }
        if ((i & 2) != 0) {
            z = appFunctionParcelableTypeMetadata.isNullable;
        }
        if ((i & 4) != 0) {
            str2 = appFunctionParcelableTypeMetadata.description;
        }
        return appFunctionParcelableTypeMetadata.copy(str, z, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionParcelableTypeMetadata copy(String qualifiedName, boolean isNullable, String description) {
        description.getClass();
        return new AppFunctionParcelableTypeMetadata(qualifiedName, isNullable, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionParcelableTypeMetadata)) {
            return false;
        }
        AppFunctionParcelableTypeMetadata appFunctionParcelableTypeMetadata = (AppFunctionParcelableTypeMetadata) other;
        return Intrinsics.areEqual(this.qualifiedName, appFunctionParcelableTypeMetadata.qualifiedName) && this.isNullable == appFunctionParcelableTypeMetadata.isNullable && Intrinsics.areEqual(this.description, appFunctionParcelableTypeMetadata.description);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public String getDescription() {
        return this.description;
    }

    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    public int hashCode() {
        String str = this.qualifiedName;
        return this.description.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.isNullable, (str == null ? 0 : str.hashCode()) * 31, 31);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public boolean isNullable() {
        return this.isNullable;
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument() {
        return new AppFunctionDataTypeMetadataDocument(null, null, 13, null, null, null, null, null, null, isNullable(), this.qualifiedName, getDescription(), null, 4603, null);
    }

    public String toString() {
        String str = this.qualifiedName;
        boolean z = this.isNullable;
        String str2 = this.description;
        StringBuilder sb = new StringBuilder("AppFunctionParcelableTypeMetadata(qualifiedName=");
        sb.append(str);
        sb.append(", isNullable=");
        sb.append(z);
        sb.append(", description=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, str2, ")");
    }
}
