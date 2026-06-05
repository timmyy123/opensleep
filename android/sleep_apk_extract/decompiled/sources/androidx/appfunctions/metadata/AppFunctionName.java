package androidx.appfunctions.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionName;", "", "packageName", "", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.FUNCTION_ID_PARAM_NAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getFunctionIdentifier", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionName {
    private final String functionIdentifier;
    private final String packageName;

    public AppFunctionName(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.packageName = str;
        this.functionIdentifier = str2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AppFunctionName.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AppFunctionName appFunctionName = (AppFunctionName) other;
        return Intrinsics.areEqual(this.packageName, appFunctionName.packageName) && Intrinsics.areEqual(this.functionIdentifier, appFunctionName.functionIdentifier);
    }

    public final String getFunctionIdentifier() {
        return this.functionIdentifier;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.functionIdentifier.hashCode() + (this.packageName.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionName(packageName='");
        sb.append(this.packageName);
        sb.append("', functionIdentifier='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.functionIdentifier, "')");
    }
}
