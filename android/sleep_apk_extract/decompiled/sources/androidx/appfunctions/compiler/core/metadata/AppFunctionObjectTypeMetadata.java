package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#BC\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0004HÖ\u0081\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006$"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionObjectTypeMetadata;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "properties", "", "", "required", "", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "isNullable", "", "description", "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "getProperties", "()Ljava/util/Map;", "getRequired", "()Ljava/util/List;", "getQualifiedName", "()Ljava/lang/String;", "()Z", "getDescription", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionObjectTypeMetadata extends AppFunctionDataTypeMetadata {
    public static final int TYPE = 3;
    private final String description;
    private final boolean isNullable;
    private final Map<String, AppFunctionDataTypeMetadata> properties;
    private final String qualifiedName;
    private final List<String> required;

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionObjectTypeMetadata(Map<String, ? extends AppFunctionDataTypeMetadata> map, List<String> list, String str, boolean z, String str2) {
        map.getClass();
        list.getClass();
        str2.getClass();
        this.properties = map;
        this.required = list;
        this.qualifiedName = str;
        this.isNullable = z;
        this.description = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppFunctionObjectTypeMetadata copy$default(AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata, Map map, List list, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = appFunctionObjectTypeMetadata.properties;
        }
        if ((i & 2) != 0) {
            list = appFunctionObjectTypeMetadata.required;
        }
        if ((i & 4) != 0) {
            str = appFunctionObjectTypeMetadata.qualifiedName;
        }
        if ((i & 8) != 0) {
            z = appFunctionObjectTypeMetadata.isNullable;
        }
        if ((i & 16) != 0) {
            str2 = appFunctionObjectTypeMetadata.description;
        }
        String str3 = str2;
        String str4 = str;
        return appFunctionObjectTypeMetadata.copy(map, list, str4, z, str3);
    }

    public final Map<String, AppFunctionDataTypeMetadata> component1() {
        return this.properties;
    }

    public final List<String> component2() {
        return this.required;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionObjectTypeMetadata copy(Map<String, ? extends AppFunctionDataTypeMetadata> properties, List<String> required, String qualifiedName, boolean isNullable, String description) {
        properties.getClass();
        required.getClass();
        description.getClass();
        return new AppFunctionObjectTypeMetadata(properties, required, qualifiedName, isNullable, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionObjectTypeMetadata)) {
            return false;
        }
        AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = (AppFunctionObjectTypeMetadata) other;
        return Intrinsics.areEqual(this.properties, appFunctionObjectTypeMetadata.properties) && Intrinsics.areEqual(this.required, appFunctionObjectTypeMetadata.required) && Intrinsics.areEqual(this.qualifiedName, appFunctionObjectTypeMetadata.qualifiedName) && this.isNullable == appFunctionObjectTypeMetadata.isNullable && Intrinsics.areEqual(this.description, appFunctionObjectTypeMetadata.description);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public String getDescription() {
        return this.description;
    }

    public final Map<String, AppFunctionDataTypeMetadata> getProperties() {
        return this.properties;
    }

    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    public final List<String> getRequired() {
        return this.required;
    }

    public int hashCode() {
        int iM = FileInsert$$ExternalSyntheticOutline0.m((List) this.required, this.properties.hashCode() * 31, 31);
        String str = this.qualifiedName;
        return this.description.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.isNullable, (iM + (str == null ? 0 : str.hashCode())) * 31, 31);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public boolean isNullable() {
        return this.isNullable;
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument() {
        Map<String, AppFunctionDataTypeMetadata> map = this.properties;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, AppFunctionDataTypeMetadata> entry : map.entrySet()) {
            String key = entry.getKey();
            AppFunctionDataTypeMetadata value = entry.getValue();
            if (key == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                return null;
            }
            arrayList.add(new AppFunctionNamedDataTypeMetadataDocument(null, null, key, value.toAppFunctionDataTypeMetadataDocument(), 3, null));
        }
        return new AppFunctionDataTypeMetadataDocument(null, null, 3, null, arrayList, null, null, this.required, null, isNullable(), this.qualifiedName, getDescription(), null, 4459, null);
    }

    public String toString() {
        Map<String, AppFunctionDataTypeMetadata> map = this.properties;
        List<String> list = this.required;
        String str = this.qualifiedName;
        boolean z = this.isNullable;
        String str2 = this.description;
        StringBuilder sb = new StringBuilder("AppFunctionObjectTypeMetadata(properties=");
        sb.append(map);
        sb.append(", required=");
        sb.append(list);
        sb.append(", qualifiedName=");
        sb.append(str);
        sb.append(", isNullable=");
        sb.append(z);
        sb.append(", description=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, str2, ")");
    }
}
