package androidx.appfunctions.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u000b\u001a\u00020\fH ¢\u0006\u0002\b\rJ\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "", "isNullable", "", "description", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getDescription", "()Ljava/lang/String;", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "toAppFunctionDataTypeMetadataDocument$appfunctions", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AppFunctionDataTypeMetadata {
    public static final int TYPE_ALL_OF = 12;
    public static final int TYPE_ARRAY = 10;
    public static final int TYPE_BOOLEAN = 1;
    public static final int TYPE_BYTES = 2;
    public static final int TYPE_DOUBLE = 4;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_INT = 7;
    public static final int TYPE_LONG = 6;
    public static final int TYPE_OBJECT = 3;
    public static final int TYPE_ONE_OF = 14;
    public static final int TYPE_PARCELABLE = 13;
    public static final int TYPE_REFERENCE = 11;
    public static final int TYPE_STRING = 8;
    public static final int TYPE_UNIT = 0;
    private final String description;
    private final boolean isNullable;

    public AppFunctionDataTypeMetadata(boolean z, String str) {
        str.getClass();
        this.isNullable = z;
        this.description = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = (AppFunctionDataTypeMetadata) other;
        return Intrinsics.areEqual(this.description, appFunctionDataTypeMetadata.description) && this.isNullable == appFunctionDataTypeMetadata.isNullable;
    }

    public final String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isNullable) + (this.description.hashCode() * 31);
    }

    /* JADX INFO: renamed from: isNullable, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    public abstract AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument$appfunctions();

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionDataTypeMetadata(isNullable=");
        sb.append(this.isNullable);
        sb.append(", description=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.description, ')');
    }
}
