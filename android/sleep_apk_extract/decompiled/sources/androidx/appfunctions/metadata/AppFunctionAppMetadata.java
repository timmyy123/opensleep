package androidx.appfunctions.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionAppMetadata;", "", "description", "", "displayDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getDisplayDescription", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionAppMetadata {
    private final String description;
    private final String displayDescription;

    public /* synthetic */ AppFunctionAppMetadata(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionAppMetadata)) {
            return false;
        }
        AppFunctionAppMetadata appFunctionAppMetadata = (AppFunctionAppMetadata) other;
        return Intrinsics.areEqual(this.description, appFunctionAppMetadata.description) && Intrinsics.areEqual(this.displayDescription, appFunctionAppMetadata.displayDescription);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDisplayDescription() {
        return this.displayDescription;
    }

    public int hashCode() {
        return Objects.hash(this.description, this.displayDescription);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionAppMetadata(description='");
        sb.append(this.description);
        sb.append("', displayDescription='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.displayDescription, "')");
    }

    public AppFunctionAppMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.description = str;
        this.displayDescription = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionAppMetadata() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }
}
