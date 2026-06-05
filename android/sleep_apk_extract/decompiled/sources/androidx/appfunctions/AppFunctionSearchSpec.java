package androidx.appfunctions;

import androidx.work.Data$$ExternalSyntheticLambda0;
import com.fasterxml.jackson.core.JsonFactory;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B=\b\u0007\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Landroidx/appfunctions/AppFunctionSearchSpec;", "", "packageNames", "", "", "schemaCategory", "schemaName", "minSchemaVersion", "", "<init>", "(Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;I)V", "getPackageNames", "()Ljava/util/Set;", "getSchemaCategory", "()Ljava/lang/String;", "getSchemaName", "getMinSchemaVersion", "()I", "toStaticMetadataAppSearchQuery", "toStaticMetadataAppSearchQuery$appfunctions", "getOrQueryExpression", "elements", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionSearchSpec {
    private final int minSchemaVersion;
    private final Set<String> packageNames;
    private final String schemaCategory;
    private final String schemaName;

    public /* synthetic */ AppFunctionSearchSpec(Set set, String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : set, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? 0 : i);
    }

    private final String getOrQueryExpression(Set<String> elements) {
        return CollectionsKt.joinToString$default(elements, " OR ", null, null, new Data$$ExternalSyntheticLambda0(1), 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getOrQueryExpression$lambda$0(String str) {
        str.getClass();
        return "\"" + str + JsonFactory.DEFAULT_QUOTE_CHAR;
    }

    public final int getMinSchemaVersion() {
        return this.minSchemaVersion;
    }

    public final Set<String> getPackageNames() {
        return this.packageNames;
    }

    public final String getSchemaCategory() {
        return this.schemaCategory;
    }

    public final String getSchemaName() {
        return this.schemaName;
    }

    public final String toStaticMetadataAppSearchQuery$appfunctions() {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Set<String> set = this.packageNames;
        if (set != null) {
            if (set.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Cannot filter by empty set of package names.");
                return null;
            }
            listCreateListBuilder.add("packageName:(" + getOrQueryExpression(this.packageNames) + ')');
        }
        if (this.schemaName != null) {
            listCreateListBuilder.add("schemaName:\"" + this.schemaName + JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        if (this.schemaCategory != null) {
            listCreateListBuilder.add("schemaCategory:\"" + this.schemaCategory + JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        if (this.minSchemaVersion > 0) {
            listCreateListBuilder.add("schemaVersion>=" + this.minSchemaVersion);
        }
        return CollectionsKt.joinToString$default(CollectionsKt.build(listCreateListBuilder), " ", null, null, null, 62);
    }

    public AppFunctionSearchSpec(Set<String> set) {
        this(set, null, null, 0, 14, null);
    }

    public AppFunctionSearchSpec(Set<String> set, String str) {
        this(set, str, null, 0, 12, null);
    }

    public AppFunctionSearchSpec(Set<String> set, String str, String str2) {
        this(set, str, str2, 0, 8, null);
    }

    public AppFunctionSearchSpec(Set<String> set, String str, String str2, int i) {
        this.packageNames = set;
        this.schemaCategory = str;
        this.schemaName = str2;
        this.minSchemaVersion = i;
        if (i >= 0) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("The minimum schema version must be a non-negative integer.");
        throw null;
    }

    public AppFunctionSearchSpec() {
        this(null, null, null, 0, 15, null);
    }
}
