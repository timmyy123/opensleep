package androidx.appfunctions.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013Ju\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b'J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0014\u00100\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u000203HÖ\u0081\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00065"}, d2 = {"Landroidx/appfunctions/metadata/CompileTimeAppFunctionMetadata;", "", "id", "", "isEnabledByDefault", "", "schema", "Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "response", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "components", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "description", "deprecation", "Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;", "<init>", "(Ljava/lang/String;ZLandroidx/appfunctions/metadata/AppFunctionSchemaMetadata;Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;)V", "getId", "()Ljava/lang/String;", "()Z", "getSchema", "()Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "getParameters", "()Ljava/util/List;", "getResponse", "()Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "getComponents", "()Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "getDescription", "getDeprecation", "()Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;", "copy", "copy$appfunctions", "(Ljava/lang/String;Ljava/lang/Boolean;Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;)Landroidx/appfunctions/metadata/CompileTimeAppFunctionMetadata;", "toAppFunctionMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;", "toAppFunctionMetadataDocument$appfunctions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CompileTimeAppFunctionMetadata {
    private final AppFunctionComponentsMetadata components;
    private final AppFunctionDeprecationMetadata deprecation;
    private final String description;
    private final String id;
    private final boolean isEnabledByDefault;
    private final List<AppFunctionParameterMetadata> parameters;
    private final AppFunctionResponseMetadata response;
    private final AppFunctionSchemaMetadata schema;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CompileTimeAppFunctionMetadata(String str, boolean z, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str2, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, (i & 32) != 0 ? new AppFunctionComponentsMetadata(null, 1, 0 == true ? 1 : 0) : appFunctionComponentsMetadata, (i & 64) != 0 ? "" : str2, (i & 128) != 0 ? null : appFunctionDeprecationMetadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompileTimeAppFunctionMetadata copy$appfunctions$default(CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata, String str, Boolean bool, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str2, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            appFunctionSchemaMetadata = null;
        }
        if ((i & 8) != 0) {
            list = null;
        }
        if ((i & 16) != 0) {
            appFunctionResponseMetadata = null;
        }
        if ((i & 32) != 0) {
            appFunctionComponentsMetadata = null;
        }
        if ((i & 64) != 0) {
            str2 = null;
        }
        if ((i & 128) != 0) {
            appFunctionDeprecationMetadata = null;
        }
        return compileTimeAppFunctionMetadata.copy$appfunctions(str, bool, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, appFunctionComponentsMetadata, str2, appFunctionDeprecationMetadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompileTimeAppFunctionMetadata copy$default(CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata, String str, boolean z, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str2, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata, int i, Object obj) {
        if ((i & 1) != 0) {
            str = compileTimeAppFunctionMetadata.id;
        }
        if ((i & 2) != 0) {
            z = compileTimeAppFunctionMetadata.isEnabledByDefault;
        }
        if ((i & 4) != 0) {
            appFunctionSchemaMetadata = compileTimeAppFunctionMetadata.schema;
        }
        if ((i & 8) != 0) {
            list = compileTimeAppFunctionMetadata.parameters;
        }
        if ((i & 16) != 0) {
            appFunctionResponseMetadata = compileTimeAppFunctionMetadata.response;
        }
        if ((i & 32) != 0) {
            appFunctionComponentsMetadata = compileTimeAppFunctionMetadata.components;
        }
        if ((i & 64) != 0) {
            str2 = compileTimeAppFunctionMetadata.description;
        }
        if ((i & 128) != 0) {
            appFunctionDeprecationMetadata = compileTimeAppFunctionMetadata.deprecation;
        }
        String str3 = str2;
        AppFunctionDeprecationMetadata appFunctionDeprecationMetadata2 = appFunctionDeprecationMetadata;
        AppFunctionResponseMetadata appFunctionResponseMetadata2 = appFunctionResponseMetadata;
        AppFunctionComponentsMetadata appFunctionComponentsMetadata2 = appFunctionComponentsMetadata;
        return compileTimeAppFunctionMetadata.copy(str, z, appFunctionSchemaMetadata, list, appFunctionResponseMetadata2, appFunctionComponentsMetadata2, str3, appFunctionDeprecationMetadata2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsEnabledByDefault() {
        return this.isEnabledByDefault;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AppFunctionSchemaMetadata getSchema() {
        return this.schema;
    }

    public final List<AppFunctionParameterMetadata> component4() {
        return this.parameters;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final AppFunctionResponseMetadata getResponse() {
        return this.response;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final AppFunctionComponentsMetadata getComponents() {
        return this.components;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final AppFunctionDeprecationMetadata getDeprecation() {
        return this.deprecation;
    }

    public final CompileTimeAppFunctionMetadata copy(String id, boolean isEnabledByDefault, AppFunctionSchemaMetadata schema, List<AppFunctionParameterMetadata> parameters, AppFunctionResponseMetadata response, AppFunctionComponentsMetadata components, String description, AppFunctionDeprecationMetadata deprecation) {
        id.getClass();
        parameters.getClass();
        response.getClass();
        components.getClass();
        description.getClass();
        return new CompileTimeAppFunctionMetadata(id, isEnabledByDefault, schema, parameters, response, components, description, deprecation);
    }

    public final CompileTimeAppFunctionMetadata copy$appfunctions(String id, Boolean isEnabledByDefault, AppFunctionSchemaMetadata schema, List<AppFunctionParameterMetadata> parameters, AppFunctionResponseMetadata response, AppFunctionComponentsMetadata components, String description, AppFunctionDeprecationMetadata deprecation) {
        if (id == null) {
            id = this.id;
        }
        boolean zBooleanValue = isEnabledByDefault != null ? isEnabledByDefault.booleanValue() : this.isEnabledByDefault;
        if (schema == null) {
            schema = this.schema;
        }
        if (parameters == null) {
            parameters = this.parameters;
        }
        if (response == null) {
            response = this.response;
        }
        if (components == null) {
            components = this.components;
        }
        if (description == null) {
            description = this.description;
        }
        if (deprecation == null) {
            deprecation = this.deprecation;
        }
        return new CompileTimeAppFunctionMetadata(id, zBooleanValue, schema, parameters, response, components, description, deprecation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompileTimeAppFunctionMetadata)) {
            return false;
        }
        CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata = (CompileTimeAppFunctionMetadata) other;
        return Intrinsics.areEqual(this.id, compileTimeAppFunctionMetadata.id) && this.isEnabledByDefault == compileTimeAppFunctionMetadata.isEnabledByDefault && Intrinsics.areEqual(this.schema, compileTimeAppFunctionMetadata.schema) && Intrinsics.areEqual(this.parameters, compileTimeAppFunctionMetadata.parameters) && Intrinsics.areEqual(this.response, compileTimeAppFunctionMetadata.response) && Intrinsics.areEqual(this.components, compileTimeAppFunctionMetadata.components) && Intrinsics.areEqual(this.description, compileTimeAppFunctionMetadata.description) && Intrinsics.areEqual(this.deprecation, compileTimeAppFunctionMetadata.deprecation);
    }

    public final AppFunctionComponentsMetadata getComponents() {
        return this.components;
    }

    public final AppFunctionDeprecationMetadata getDeprecation() {
        return this.deprecation;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final List<AppFunctionParameterMetadata> getParameters() {
        return this.parameters;
    }

    public final AppFunctionResponseMetadata getResponse() {
        return this.response;
    }

    public final AppFunctionSchemaMetadata getSchema() {
        return this.schema;
    }

    public int hashCode() {
        int iM = FileInsert$$ExternalSyntheticOutline0.m(this.isEnabledByDefault, this.id.hashCode() * 31, 31);
        AppFunctionSchemaMetadata appFunctionSchemaMetadata = this.schema;
        int iM2 = FileInsert$$ExternalSyntheticOutline0.m((this.components.hashCode() + ((this.response.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((List) this.parameters, (iM + (appFunctionSchemaMetadata == null ? 0 : appFunctionSchemaMetadata.hashCode())) * 31, 31)) * 31)) * 31, 31, this.description);
        AppFunctionDeprecationMetadata appFunctionDeprecationMetadata = this.deprecation;
        return iM2 + (appFunctionDeprecationMetadata != null ? appFunctionDeprecationMetadata.hashCode() : 0);
    }

    public final boolean isEnabledByDefault() {
        return this.isEnabledByDefault;
    }

    public final AppFunctionMetadataDocument toAppFunctionMetadataDocument$appfunctions() {
        String str = this.id;
        boolean z = this.isEnabledByDefault;
        AppFunctionSchemaMetadata appFunctionSchemaMetadata = this.schema;
        String name = appFunctionSchemaMetadata != null ? appFunctionSchemaMetadata.getName() : null;
        AppFunctionSchemaMetadata appFunctionSchemaMetadata2 = this.schema;
        String category = appFunctionSchemaMetadata2 != null ? appFunctionSchemaMetadata2.getCategory() : null;
        AppFunctionSchemaMetadata appFunctionSchemaMetadata3 = this.schema;
        Long lValueOf = appFunctionSchemaMetadata3 != null ? Long.valueOf(appFunctionSchemaMetadata3.getVersion()) : null;
        List<AppFunctionParameterMetadata> list = this.parameters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppFunctionParameterMetadata) it.next()).toAppFunctionParameterMetadataDocument$appfunctions());
        }
        AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument$appfunctions = this.response.toAppFunctionResponseMetadataDocument$appfunctions();
        String str2 = this.description;
        AppFunctionDeprecationMetadata appFunctionDeprecationMetadata = this.deprecation;
        return new AppFunctionMetadataDocument(null, str, z, category, name, lValueOf, arrayList, appFunctionResponseMetadataDocument$appfunctions, str2, appFunctionDeprecationMetadata != null ? appFunctionDeprecationMetadata.toAppFunctionDeprecationMetadataDocument$appfunctions() : null, 1, null);
    }

    public String toString() {
        return "CompileTimeAppFunctionMetadata(id=" + this.id + ", isEnabledByDefault=" + this.isEnabledByDefault + ", schema=" + this.schema + ", parameters=" + this.parameters + ", response=" + this.response + ", components=" + this.components + ", description=" + this.description + ", deprecation=" + this.deprecation + ')';
    }

    public CompileTimeAppFunctionMetadata(String str, boolean z, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str2, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata) {
        str.getClass();
        list.getClass();
        appFunctionResponseMetadata.getClass();
        appFunctionComponentsMetadata.getClass();
        str2.getClass();
        this.id = str;
        this.isEnabledByDefault = z;
        this.schema = appFunctionSchemaMetadata;
        this.parameters = list;
        this.response = appFunctionResponseMetadata;
        this.components = appFunctionComponentsMetadata;
        this.description = str2;
        this.deprecation = appFunctionDeprecationMetadata;
    }
}
