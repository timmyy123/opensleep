package androidx.appfunctions.metadata;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\rJ\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionParcelableTypeMetadata;", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "", "isNullable", "", "description", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getQualifiedName", "()Ljava/lang/String;", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "toAppFunctionDataTypeMetadataDocument$appfunctions", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionParcelableTypeMetadata extends AppFunctionDataTypeMetadata {
    private final String qualifiedName;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionParcelableTypeMetadata(String str, boolean z) {
        this(str, z, null, 4, null);
        str.getClass();
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof AppFunctionParcelableTypeMetadata) && super.equals(other)) {
            return Intrinsics.areEqual(this.qualifiedName, ((AppFunctionParcelableTypeMetadata) other).qualifiedName);
        }
        return false;
    }

    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public int hashCode() {
        return this.qualifiedName.hashCode() + (super.hashCode() * 31);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument$appfunctions() {
        boolean isNullable = getIsNullable();
        String description = getDescription();
        if (description.length() == 0) {
            description = null;
        }
        return new AppFunctionDataTypeMetadataDocument(null, null, 13, null, null, null, null, null, null, isNullable, this.qualifiedName, description, null, 4603, null);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public String toString() {
        return "AppFunctionParcelableTypeMetadata(qualifiedName=" + this.qualifiedName + ", isNullable=" + getIsNullable() + ", description=" + getDescription() + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFunctionParcelableTypeMetadata(String str, boolean z, String str2) {
        super(z, str2);
        str.getClass();
        str2.getClass();
        this.qualifiedName = str;
    }

    public /* synthetic */ AppFunctionParcelableTypeMetadata(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? "" : str2);
    }
}
