package androidx.appfunctions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/AppFunctionTextResource;", "", "mimeType", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMimeType", "()Ljava/lang/String;", "getContent", "equals", "", "other", "hashCode", "", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionTextResource {
    private final String content;
    private final String mimeType;

    public AppFunctionTextResource(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.mimeType = str;
        this.content = str2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AppFunctionTextResource.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AppFunctionTextResource appFunctionTextResource = (AppFunctionTextResource) other;
        if (Intrinsics.areEqual(this.mimeType, appFunctionTextResource.mimeType)) {
            return Intrinsics.areEqual(this.content, appFunctionTextResource.content);
        }
        return false;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public int hashCode() {
        return this.content.hashCode() + (this.mimeType.hashCode() * 31);
    }
}
