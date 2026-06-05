package androidx.health.connect.client.records.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/records/metadata/DataOrigin;", "", "packageName", "", "<init>", "(Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataOrigin {
    private final String packageName;

    public DataOrigin(String str) {
        str.getClass();
        this.packageName = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DataOrigin) && Intrinsics.areEqual(this.packageName, ((DataOrigin) other).packageName);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.packageName.hashCode();
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("DataOrigin(packageName='"), this.packageName, "')");
    }
}
