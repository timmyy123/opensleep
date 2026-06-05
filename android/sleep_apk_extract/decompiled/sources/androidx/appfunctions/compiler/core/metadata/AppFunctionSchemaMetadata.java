package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionSchemaMetadata;", "", IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, "", "name", "version", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getCategory", "()Ljava/lang/String;", "getName", "getVersion", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionSchemaMetadata {
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

    public static /* synthetic */ AppFunctionSchemaMetadata copy$default(AppFunctionSchemaMetadata appFunctionSchemaMetadata, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionSchemaMetadata.category;
        }
        if ((i & 2) != 0) {
            str2 = appFunctionSchemaMetadata.name;
        }
        if ((i & 4) != 0) {
            j = appFunctionSchemaMetadata.version;
        }
        return appFunctionSchemaMetadata.copy(str, str2, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getVersion() {
        return this.version;
    }

    public final AppFunctionSchemaMetadata copy(String category, String name, long version) {
        category.getClass();
        name.getClass();
        return new AppFunctionSchemaMetadata(category, name, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionSchemaMetadata)) {
            return false;
        }
        AppFunctionSchemaMetadata appFunctionSchemaMetadata = (AppFunctionSchemaMetadata) other;
        return Intrinsics.areEqual(this.category, appFunctionSchemaMetadata.category) && Intrinsics.areEqual(this.name, appFunctionSchemaMetadata.name) && this.version == appFunctionSchemaMetadata.version;
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
        return Long.hashCode(this.version) + FileInsert$$ExternalSyntheticOutline0.m(this.category.hashCode() * 31, 31, this.name);
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(this.version, ")", FileInsert$$ExternalSyntheticOutline0.m6m("AppFunctionSchemaMetadata(category=", this.category, ", name=", this.name, ", version="));
    }
}
