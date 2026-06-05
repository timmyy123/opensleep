package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionDeprecationMetadata;", "", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "toAppFunctionDeprecationMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDeprecationMetadataDocument;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionDeprecationMetadata {
    private final String message;

    public AppFunctionDeprecationMetadata(String str) {
        str.getClass();
        this.message = str;
    }

    public static /* synthetic */ AppFunctionDeprecationMetadata copy$default(AppFunctionDeprecationMetadata appFunctionDeprecationMetadata, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionDeprecationMetadata.message;
        }
        return appFunctionDeprecationMetadata.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final AppFunctionDeprecationMetadata copy(String message) {
        message.getClass();
        return new AppFunctionDeprecationMetadata(message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AppFunctionDeprecationMetadata) && Intrinsics.areEqual(this.message, ((AppFunctionDeprecationMetadata) other).message);
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    public final AppFunctionDeprecationMetadataDocument toAppFunctionDeprecationMetadataDocument() {
        return new AppFunctionDeprecationMetadataDocument(null, null, this.message, 3, null);
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m("AppFunctionDeprecationMetadata(message=", this.message, ")");
    }
}
