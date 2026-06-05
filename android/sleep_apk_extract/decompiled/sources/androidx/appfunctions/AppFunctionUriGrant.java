package androidx.appfunctions;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.net.Uri;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\r\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\b\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Landroidx/appfunctions/AppFunctionUriGrant;", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "modeFlags", "", "<init>", "(Landroid/net/Uri;I)V", "getUri", "()Landroid/net/Uri;", "getModeFlags", "()I", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "toPlatformClass", "Landroid/app/appfunctions/AppFunctionUriGrant;", "toPlatformClass$appfunctions", "GrantUriMode", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionUriGrant {
    private static final Companion Companion = new Companion(null);
    private final int modeFlags;
    private final Uri uri;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"Landroidx/appfunctions/AppFunctionUriGrant$Companion;", "", "<init>", "()V", "isAccessUriMode", "", "modeFlags", "", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAccessUriMode(int modeFlags) {
            return (modeFlags & 3) != 0;
        }

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/appfunctions/AppFunctionUriGrant$GrantUriMode;", "", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface GrantUriMode {
    }

    public AppFunctionUriGrant(Uri uri, int i) {
        uri.getClass();
        this.uri = uri;
        this.modeFlags = i;
        if (Companion.isAccessUriMode(i)) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Must set either FLAG_GRANT_READ_URI_PERMISSION or FLAG_GRANT_WRITE_URI_PERMISSION to specify the access mode");
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionUriGrant)) {
            return false;
        }
        AppFunctionUriGrant appFunctionUriGrant = (AppFunctionUriGrant) other;
        return Intrinsics.areEqual(this.uri, appFunctionUriGrant.uri) && this.modeFlags == appFunctionUriGrant.modeFlags;
    }

    public final int getModeFlags() {
        return this.modeFlags;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return Objects.hash(this.uri, Integer.valueOf(this.modeFlags));
    }

    public final android.app.appfunctions.AppFunctionUriGrant toPlatformClass$appfunctions() {
        AppFunctionUriGrant$$ExternalSyntheticApiModelOutline0.m();
        return AppFunctionUriGrant$$ExternalSyntheticApiModelOutline0.m(this.uri, this.modeFlags);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionUriGrant(uri=");
        sb.append(this.uri);
        sb.append(", modeFlags=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.modeFlags, ')');
    }
}
