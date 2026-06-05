package androidx.appfunctions.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "", IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, "", "name", "version", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getCategory", "()Ljava/lang/String;", "getName", "getVersion", "()J", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionSchemaMetadata {
    private final String category;
    private final String name;
    private final long version;

    public AppFunctionSchemaMetadata(String str, String str2, long j) {
        str.getClass();
        str2.getClass();
        this.category = str;
        this.name = str2;
        this.version = j;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AppFunctionSchemaMetadata.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AppFunctionSchemaMetadata appFunctionSchemaMetadata = (AppFunctionSchemaMetadata) other;
        return this.version == appFunctionSchemaMetadata.version && Intrinsics.areEqual(this.category, appFunctionSchemaMetadata.category) && Intrinsics.areEqual(this.name, appFunctionSchemaMetadata.name);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getName() {
        return this.name;
    }

    public final long getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.name.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(Long.hashCode(this.version) * 31, 31, this.category);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionSchemaMetadata(category='");
        sb.append(this.category);
        sb.append("', name='");
        sb.append(this.name);
        sb.append("', version=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.version, ')');
    }
}
