package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0084\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00100J\u0014\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u000204HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionMetadataDocument;", "", "namespace", "", "id", "isEnabledByDefault", "", "schemaCategory", "schemaName", "schemaVersion", "", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionParameterMetadataDocument;", "response", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionResponseMetadataDocument;", "description", "deprecation", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDeprecationMetadataDocument;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Landroidx/appfunctions/compiler/core/metadata/AppFunctionResponseMetadataDocument;Ljava/lang/String;Landroidx/appfunctions/compiler/core/metadata/AppFunctionDeprecationMetadataDocument;)V", "getNamespace", "()Ljava/lang/String;", "getId", "()Z", "getSchemaCategory", "getSchemaName", "getSchemaVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getParameters", "()Ljava/util/List;", "getResponse", "()Landroidx/appfunctions/compiler/core/metadata/AppFunctionResponseMetadataDocument;", "getDescription", "getDeprecation", "()Landroidx/appfunctions/compiler/core/metadata/AppFunctionDeprecationMetadataDocument;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Landroidx/appfunctions/compiler/core/metadata/AppFunctionResponseMetadataDocument;Ljava/lang/String;Landroidx/appfunctions/compiler/core/metadata/AppFunctionDeprecationMetadataDocument;)Landroidx/appfunctions/compiler/core/metadata/AppFunctionMetadataDocument;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionMetadataDocument {
    private final AppFunctionDeprecationMetadataDocument deprecation;
    private final String description;
    private final String id;
    private final boolean isEnabledByDefault;
    private final String namespace;
    private final List<AppFunctionParameterMetadataDocument> parameters;
    private final AppFunctionResponseMetadataDocument response;
    private final String schemaCategory;
    private final String schemaName;
    private final Long schemaVersion;

    public /* synthetic */ AppFunctionMetadataDocument(String str, String str2, boolean z, String str3, String str4, Long l, List list, AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument, String str5, AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "appfunctions" : str, (i & 2) != 0 ? "unused" : str2, z, str3, str4, l, list, appFunctionResponseMetadataDocument, (i & 256) != 0 ? "" : str5, (i & 512) != 0 ? null : appFunctionDeprecationMetadataDocument);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppFunctionMetadataDocument copy$default(AppFunctionMetadataDocument appFunctionMetadataDocument, String str, String str2, boolean z, String str3, String str4, Long l, List list, AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument, String str5, AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionMetadataDocument.namespace;
        }
        if ((i & 2) != 0) {
            str2 = appFunctionMetadataDocument.id;
        }
        if ((i & 4) != 0) {
            z = appFunctionMetadataDocument.isEnabledByDefault;
        }
        if ((i & 8) != 0) {
            str3 = appFunctionMetadataDocument.schemaCategory;
        }
        if ((i & 16) != 0) {
            str4 = appFunctionMetadataDocument.schemaName;
        }
        if ((i & 32) != 0) {
            l = appFunctionMetadataDocument.schemaVersion;
        }
        if ((i & 64) != 0) {
            list = appFunctionMetadataDocument.parameters;
        }
        if ((i & 128) != 0) {
            appFunctionResponseMetadataDocument = appFunctionMetadataDocument.response;
        }
        if ((i & 256) != 0) {
            str5 = appFunctionMetadataDocument.description;
        }
        if ((i & 512) != 0) {
            appFunctionDeprecationMetadataDocument = appFunctionMetadataDocument.deprecation;
        }
        String str6 = str5;
        AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument2 = appFunctionDeprecationMetadataDocument;
        List list2 = list;
        AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument2 = appFunctionResponseMetadataDocument;
        String str7 = str4;
        Long l2 = l;
        return appFunctionMetadataDocument.copy(str, str2, z, str3, str7, l2, list2, appFunctionResponseMetadataDocument2, str6, appFunctionDeprecationMetadataDocument2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final AppFunctionDeprecationMetadataDocument getDeprecation() {
        return this.deprecation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsEnabledByDefault() {
        return this.isEnabledByDefault;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSchemaCategory() {
        return this.schemaCategory;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSchemaName() {
        return this.schemaName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getSchemaVersion() {
        return this.schemaVersion;
    }

    public final List<AppFunctionParameterMetadataDocument> component7() {
        return this.parameters;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final AppFunctionResponseMetadataDocument getResponse() {
        return this.response;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionMetadataDocument copy(String namespace, String id, boolean isEnabledByDefault, String schemaCategory, String schemaName, Long schemaVersion, List<AppFunctionParameterMetadataDocument> parameters, AppFunctionResponseMetadataDocument response, String description, AppFunctionDeprecationMetadataDocument deprecation) {
        namespace.getClass();
        id.getClass();
        description.getClass();
        return new AppFunctionMetadataDocument(namespace, id, isEnabledByDefault, schemaCategory, schemaName, schemaVersion, parameters, response, description, deprecation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionMetadataDocument)) {
            return false;
        }
        AppFunctionMetadataDocument appFunctionMetadataDocument = (AppFunctionMetadataDocument) other;
        return Intrinsics.areEqual(this.namespace, appFunctionMetadataDocument.namespace) && Intrinsics.areEqual(this.id, appFunctionMetadataDocument.id) && this.isEnabledByDefault == appFunctionMetadataDocument.isEnabledByDefault && Intrinsics.areEqual(this.schemaCategory, appFunctionMetadataDocument.schemaCategory) && Intrinsics.areEqual(this.schemaName, appFunctionMetadataDocument.schemaName) && Intrinsics.areEqual(this.schemaVersion, appFunctionMetadataDocument.schemaVersion) && Intrinsics.areEqual(this.parameters, appFunctionMetadataDocument.parameters) && Intrinsics.areEqual(this.response, appFunctionMetadataDocument.response) && Intrinsics.areEqual(this.description, appFunctionMetadataDocument.description) && Intrinsics.areEqual(this.deprecation, appFunctionMetadataDocument.deprecation);
    }

    public final AppFunctionDeprecationMetadataDocument getDeprecation() {
        return this.deprecation;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final List<AppFunctionParameterMetadataDocument> getParameters() {
        return this.parameters;
    }

    public final AppFunctionResponseMetadataDocument getResponse() {
        return this.response;
    }

    public final String getSchemaCategory() {
        return this.schemaCategory;
    }

    public final String getSchemaName() {
        return this.schemaName;
    }

    public final Long getSchemaVersion() {
        return this.schemaVersion;
    }

    public int hashCode() {
        int iM = FileInsert$$ExternalSyntheticOutline0.m(this.isEnabledByDefault, FileInsert$$ExternalSyntheticOutline0.m(this.namespace.hashCode() * 31, 31, this.id), 31);
        String str = this.schemaCategory;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.schemaName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.schemaVersion;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        List<AppFunctionParameterMetadataDocument> list = this.parameters;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument = this.response;
        int iM2 = FileInsert$$ExternalSyntheticOutline0.m((iHashCode4 + (appFunctionResponseMetadataDocument == null ? 0 : appFunctionResponseMetadataDocument.hashCode())) * 31, 31, this.description);
        AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument = this.deprecation;
        return iM2 + (appFunctionDeprecationMetadataDocument != null ? appFunctionDeprecationMetadataDocument.hashCode() : 0);
    }

    public final boolean isEnabledByDefault() {
        return this.isEnabledByDefault;
    }

    public String toString() {
        String str = this.namespace;
        String str2 = this.id;
        boolean z = this.isEnabledByDefault;
        String str3 = this.schemaCategory;
        String str4 = this.schemaName;
        Long l = this.schemaVersion;
        List<AppFunctionParameterMetadataDocument> list = this.parameters;
        AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument = this.response;
        String str5 = this.description;
        AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument = this.deprecation;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("AppFunctionMetadataDocument(namespace=", str, ", id=", str2, ", isEnabledByDefault=");
        sbM6m.append(z);
        sbM6m.append(", schemaCategory=");
        sbM6m.append(str3);
        sbM6m.append(", schemaName=");
        sbM6m.append(str4);
        sbM6m.append(", schemaVersion=");
        sbM6m.append(l);
        sbM6m.append(", parameters=");
        sbM6m.append(list);
        sbM6m.append(", response=");
        sbM6m.append(appFunctionResponseMetadataDocument);
        sbM6m.append(", description=");
        sbM6m.append(str5);
        sbM6m.append(", deprecation=");
        sbM6m.append(appFunctionDeprecationMetadataDocument);
        sbM6m.append(")");
        return sbM6m.toString();
    }

    public AppFunctionMetadataDocument(String str, String str2, boolean z, String str3, String str4, Long l, List<AppFunctionParameterMetadataDocument> list, AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument, String str5, AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument) {
        Fragment$$ExternalSyntheticOutline1.m(str, str2, str5);
        this.namespace = str;
        this.id = str2;
        this.isEnabledByDefault = z;
        this.schemaCategory = str3;
        this.schemaName = str4;
        this.schemaVersion = l;
        this.parameters = list;
        this.response = appFunctionResponseMetadataDocument;
        this.description = str5;
        this.deprecation = appFunctionDeprecationMetadataDocument;
    }
}
