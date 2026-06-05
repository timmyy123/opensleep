package androidx.appfunctions.metadata;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bu\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018BW\b\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0019J\u0013\u0010-\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u0003H\u0016J\u0085\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u00064"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionMetadata;", "", "id", "", "packageName", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "", "schema", "Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "response", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "components", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "description", "deprecation", "Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;", "name", "Landroidx/appfunctions/metadata/AppFunctionName;", "packageMetadata", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/appfunctions/metadata/AppFunctionSchemaMetadata;Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;Landroidx/appfunctions/metadata/AppFunctionName;Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;)V", "(Landroidx/appfunctions/metadata/AppFunctionName;Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;ZLjava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;)V", "getId", "()Ljava/lang/String;", "getPackageName", "()Z", "getSchema", "()Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "getParameters", "()Ljava/util/List;", "getResponse", "()Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "getComponents", "()Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "getDescription", "getDeprecation", "()Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;", "getName$appfunctions", "()Landroidx/appfunctions/metadata/AppFunctionName;", "getPackageMetadata$appfunctions", "()Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "copy", "copy$appfunctions", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionMetadata {
    private final AppFunctionComponentsMetadata components;
    private final AppFunctionDeprecationMetadata deprecation;
    private final String description;
    private final String id;
    private final boolean isEnabled;
    private final AppFunctionName name;
    private final AppFunctionPackageMetadata packageMetadata;
    private final String packageName;
    private final List<AppFunctionParameterMetadata> parameters;
    private final AppFunctionResponseMetadata response;
    private final AppFunctionSchemaMetadata schema;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ AppFunctionMetadata(java.lang.String r13, java.lang.String r14, boolean r15, androidx.appfunctions.metadata.AppFunctionSchemaMetadata r16, java.util.List r17, androidx.appfunctions.metadata.AppFunctionResponseMetadata r18, androidx.appfunctions.metadata.AppFunctionComponentsMetadata r19, java.lang.String r20, androidx.appfunctions.metadata.AppFunctionDeprecationMetadata r21, androidx.appfunctions.metadata.AppFunctionName r22, androidx.appfunctions.metadata.AppFunctionPackageMetadata r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 64
            r3 = 0
            if (r1 == 0) goto Lf
            androidx.appfunctions.metadata.AppFunctionComponentsMetadata r1 = new androidx.appfunctions.metadata.AppFunctionComponentsMetadata
            r4 = 1
            r1.<init>(r3, r4, r3)
            r7 = r1
            goto L11
        Lf:
            r7 = r19
        L11:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L19
            java.lang.String r1 = ""
            r8 = r1
            goto L1b
        L19:
            r8 = r20
        L1b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L21
            r9 = r3
            goto L23
        L21:
            r9 = r21
        L23:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L2e
            androidx.appfunctions.metadata.AppFunctionName r1 = new androidx.appfunctions.metadata.AppFunctionName
            r1.<init>(r14, r13)
            r10 = r1
            goto L30
        L2e:
            r10 = r22
        L30:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L49
            androidx.appfunctions.metadata.AppFunctionPackageMetadata r0 = new androidx.appfunctions.metadata.AppFunctionPackageMetadata
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r0.<init>(r14, r1, r7)
            r11 = r0
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r0 = r12
            goto L55
        L49:
            r11 = r23
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
        L55:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.metadata.AppFunctionMetadata.<init>(java.lang.String, java.lang.String, boolean, androidx.appfunctions.metadata.AppFunctionSchemaMetadata, java.util.List, androidx.appfunctions.metadata.AppFunctionResponseMetadata, androidx.appfunctions.metadata.AppFunctionComponentsMetadata, java.lang.String, androidx.appfunctions.metadata.AppFunctionDeprecationMetadata, androidx.appfunctions.metadata.AppFunctionName, androidx.appfunctions.metadata.AppFunctionPackageMetadata, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppFunctionMetadata copy$appfunctions$default(AppFunctionMetadata appFunctionMetadata, String str, String str2, boolean z, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str3, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata, AppFunctionName appFunctionName, AppFunctionPackageMetadata appFunctionPackageMetadata, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionMetadata.id;
        }
        if ((i & 2) != 0) {
            str2 = appFunctionMetadata.packageName;
        }
        if ((i & 4) != 0) {
            z = appFunctionMetadata.isEnabled;
        }
        if ((i & 8) != 0) {
            appFunctionSchemaMetadata = appFunctionMetadata.schema;
        }
        if ((i & 16) != 0) {
            list = appFunctionMetadata.parameters;
        }
        if ((i & 32) != 0) {
            appFunctionResponseMetadata = appFunctionMetadata.response;
        }
        if ((i & 64) != 0) {
            appFunctionComponentsMetadata = appFunctionMetadata.components;
        }
        if ((i & 128) != 0) {
            str3 = appFunctionMetadata.description;
        }
        if ((i & 256) != 0) {
            appFunctionDeprecationMetadata = appFunctionMetadata.deprecation;
        }
        if ((i & 512) != 0) {
            appFunctionName = appFunctionMetadata.name;
        }
        if ((i & 1024) != 0) {
            appFunctionPackageMetadata = appFunctionMetadata.packageMetadata;
        }
        AppFunctionName appFunctionName2 = appFunctionName;
        AppFunctionPackageMetadata appFunctionPackageMetadata2 = appFunctionPackageMetadata;
        String str4 = str3;
        AppFunctionDeprecationMetadata appFunctionDeprecationMetadata2 = appFunctionDeprecationMetadata;
        AppFunctionResponseMetadata appFunctionResponseMetadata2 = appFunctionResponseMetadata;
        AppFunctionComponentsMetadata appFunctionComponentsMetadata2 = appFunctionComponentsMetadata;
        List list2 = list;
        boolean z2 = z;
        return appFunctionMetadata.copy$appfunctions(str, str2, z2, appFunctionSchemaMetadata, list2, appFunctionResponseMetadata2, appFunctionComponentsMetadata2, str4, appFunctionDeprecationMetadata2, appFunctionName2, appFunctionPackageMetadata2);
    }

    public final AppFunctionMetadata copy$appfunctions(String id, String packageName, boolean isEnabled, AppFunctionSchemaMetadata schema, List<AppFunctionParameterMetadata> parameters, AppFunctionResponseMetadata response, AppFunctionComponentsMetadata components, String description, AppFunctionDeprecationMetadata deprecation, AppFunctionName name, AppFunctionPackageMetadata packageMetadata) {
        id.getClass();
        packageName.getClass();
        parameters.getClass();
        response.getClass();
        components.getClass();
        description.getClass();
        name.getClass();
        packageMetadata.getClass();
        return new AppFunctionMetadata(id, packageName, isEnabled, schema, parameters, response, components, description, deprecation, name, packageMetadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AppFunctionMetadata.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AppFunctionMetadata appFunctionMetadata = (AppFunctionMetadata) other;
        return Intrinsics.areEqual(this.id, appFunctionMetadata.id) && this.isEnabled == appFunctionMetadata.isEnabled && Intrinsics.areEqual(this.packageName, appFunctionMetadata.packageName) && Intrinsics.areEqual(this.schema, appFunctionMetadata.schema) && Intrinsics.areEqual(this.parameters, appFunctionMetadata.parameters) && Intrinsics.areEqual(this.response, appFunctionMetadata.response) && Intrinsics.areEqual(this.components, appFunctionMetadata.components) && Intrinsics.areEqual(this.description, appFunctionMetadata.description) && Intrinsics.areEqual(this.deprecation, appFunctionMetadata.deprecation) && Intrinsics.areEqual(this.name, appFunctionMetadata.name) && Intrinsics.areEqual(this.packageMetadata, appFunctionMetadata.packageMetadata);
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

    /* JADX INFO: renamed from: getName$appfunctions, reason: from getter */
    public final AppFunctionName getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: getPackageMetadata$appfunctions, reason: from getter */
    public final AppFunctionPackageMetadata getPackageMetadata() {
        return this.packageMetadata;
    }

    public final String getPackageName() {
        return this.packageName;
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
        return Objects.hash(Boolean.valueOf(this.isEnabled), this.id, this.packageName, this.schema, this.parameters, this.response, this.components, this.description, this.deprecation, this.name, this.packageMetadata);
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionMetadata(");
        sb.append("id='" + this.id + "', ");
        sb.append("packageName='" + this.packageName + "', ");
        sb.append("isEnabled=" + this.isEnabled + ", ");
        sb.append("schema=" + this.schema + ", ");
        sb.append("parameters=" + this.parameters + ", ");
        sb.append("response=" + this.response + ", ");
        sb.append("components=" + this.components + ", ");
        sb.append("description='" + this.description + "', ");
        sb.append("deprecation=" + this.deprecation + ", ");
        sb.append("packageMetadata=" + this.packageMetadata + ", ");
        StringBuilder sb2 = new StringBuilder("name=");
        sb2.append(this.name);
        sb.append(sb2.toString());
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(AppFunctionName appFunctionName, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionPackageMetadata appFunctionPackageMetadata, boolean z, String str) {
        this(appFunctionName, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, appFunctionPackageMetadata, z, str, (AppFunctionDeprecationMetadata) null, 128, (DefaultConstructorMarker) null);
        appFunctionName.getClass();
        list.getClass();
        appFunctionResponseMetadata.getClass();
        appFunctionPackageMetadata.getClass();
        str.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(String str, String str2, boolean z, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> list, AppFunctionResponseMetadata appFunctionResponseMetadata) {
        this(str, str2, z, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, null, null, null, null, null, 1984, null);
        str.getClass();
        str2.getClass();
        list.getClass();
        appFunctionResponseMetadata.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(String str, String str2, boolean z, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata) {
        this(str, str2, z, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, appFunctionComponentsMetadata, null, null, null, null, 1920, null);
        str.getClass();
        str2.getClass();
        list.getClass();
        appFunctionResponseMetadata.getClass();
        appFunctionComponentsMetadata.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(String str, String str2, boolean z, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str3) {
        this(str, str2, z, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, appFunctionComponentsMetadata, str3, null, null, null, 1792, null);
        str.getClass();
        str2.getClass();
        list.getClass();
        appFunctionResponseMetadata.getClass();
        appFunctionComponentsMetadata.getClass();
        str3.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(String str, String str2, boolean z, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str3, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata) {
        this(str, str2, z, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, appFunctionComponentsMetadata, str3, appFunctionDeprecationMetadata, null, null, 1536, null);
        str.getClass();
        str2.getClass();
        list.getClass();
        appFunctionResponseMetadata.getClass();
        appFunctionComponentsMetadata.getClass();
        str3.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(String str, String str2, boolean z, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str3, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata, AppFunctionName appFunctionName) {
        this(str, str2, z, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, appFunctionComponentsMetadata, str3, appFunctionDeprecationMetadata, appFunctionName, null, 1024, null);
        str.getClass();
        str2.getClass();
        list.getClass();
        appFunctionResponseMetadata.getClass();
        appFunctionComponentsMetadata.getClass();
        str3.getClass();
        appFunctionName.getClass();
    }

    public AppFunctionMetadata(String str, String str2, boolean z, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str3, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata, AppFunctionName appFunctionName, AppFunctionPackageMetadata appFunctionPackageMetadata) {
        str.getClass();
        str2.getClass();
        list.getClass();
        appFunctionResponseMetadata.getClass();
        appFunctionComponentsMetadata.getClass();
        str3.getClass();
        appFunctionName.getClass();
        appFunctionPackageMetadata.getClass();
        this.id = str;
        this.packageName = str2;
        this.isEnabled = z;
        this.schema = appFunctionSchemaMetadata;
        this.parameters = list;
        this.response = appFunctionResponseMetadata;
        this.components = appFunctionComponentsMetadata;
        this.description = str3;
        this.deprecation = appFunctionDeprecationMetadata;
        this.name = appFunctionName;
        this.packageMetadata = appFunctionPackageMetadata;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(AppFunctionName appFunctionName, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionPackageMetadata appFunctionPackageMetadata, boolean z) {
        this(appFunctionName, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, appFunctionPackageMetadata, z, (String) null, (AppFunctionDeprecationMetadata) null, 192, (DefaultConstructorMarker) null);
        appFunctionName.getClass();
        list.getClass();
        appFunctionResponseMetadata.getClass();
        appFunctionPackageMetadata.getClass();
    }

    public /* synthetic */ AppFunctionMetadata(AppFunctionName appFunctionName, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionPackageMetadata appFunctionPackageMetadata, boolean z, String str, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appFunctionName, appFunctionSchemaMetadata, (List<AppFunctionParameterMetadata>) list, appFunctionResponseMetadata, appFunctionPackageMetadata, z, (i & 64) != 0 ? "" : str, (i & 128) != 0 ? null : appFunctionDeprecationMetadata);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(AppFunctionName appFunctionName, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionPackageMetadata appFunctionPackageMetadata, boolean z, String str, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata) {
        this(appFunctionName.getFunctionIdentifier(), appFunctionName.getPackageName(), z, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, appFunctionPackageMetadata.getComponents(), str, appFunctionDeprecationMetadata, appFunctionName, appFunctionPackageMetadata);
        appFunctionName.getClass();
        list.getClass();
        appFunctionResponseMetadata.getClass();
        appFunctionPackageMetadata.getClass();
        str.getClass();
    }
}
