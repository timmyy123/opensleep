package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001f"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionAllOfTypeMetadata;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "matchAll", "", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "", "isNullable", "", "description", "<init>", "(Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "getMatchAll", "()Ljava/util/List;", "getQualifiedName", "()Ljava/lang/String;", "()Z", "getDescription", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionAllOfTypeMetadata extends AppFunctionDataTypeMetadata {
    public static final int TYPE = 12;
    private final String description;
    private final boolean isNullable;
    private final List<AppFunctionDataTypeMetadata> matchAll;
    private final String qualifiedName;

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionAllOfTypeMetadata(List<? extends AppFunctionDataTypeMetadata> list, String str, boolean z, String str2) {
        list.getClass();
        str2.getClass();
        this.matchAll = list;
        this.qualifiedName = str;
        this.isNullable = z;
        this.description = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppFunctionAllOfTypeMetadata copy$default(AppFunctionAllOfTypeMetadata appFunctionAllOfTypeMetadata, List list, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = appFunctionAllOfTypeMetadata.matchAll;
        }
        if ((i & 2) != 0) {
            str = appFunctionAllOfTypeMetadata.qualifiedName;
        }
        if ((i & 4) != 0) {
            z = appFunctionAllOfTypeMetadata.isNullable;
        }
        if ((i & 8) != 0) {
            str2 = appFunctionAllOfTypeMetadata.description;
        }
        return appFunctionAllOfTypeMetadata.copy(list, str, z, str2);
    }

    public final List<AppFunctionDataTypeMetadata> component1() {
        return this.matchAll;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionAllOfTypeMetadata copy(List<? extends AppFunctionDataTypeMetadata> matchAll, String qualifiedName, boolean isNullable, String description) {
        matchAll.getClass();
        description.getClass();
        return new AppFunctionAllOfTypeMetadata(matchAll, qualifiedName, isNullable, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionAllOfTypeMetadata)) {
            return false;
        }
        AppFunctionAllOfTypeMetadata appFunctionAllOfTypeMetadata = (AppFunctionAllOfTypeMetadata) other;
        return Intrinsics.areEqual(this.matchAll, appFunctionAllOfTypeMetadata.matchAll) && Intrinsics.areEqual(this.qualifiedName, appFunctionAllOfTypeMetadata.qualifiedName) && this.isNullable == appFunctionAllOfTypeMetadata.isNullable && Intrinsics.areEqual(this.description, appFunctionAllOfTypeMetadata.description);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public String getDescription() {
        return this.description;
    }

    public final List<AppFunctionDataTypeMetadata> getMatchAll() {
        return this.matchAll;
    }

    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    public int hashCode() {
        int iHashCode = this.matchAll.hashCode() * 31;
        String str = this.qualifiedName;
        return this.description.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.isNullable, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public boolean isNullable() {
        return this.isNullable;
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument() {
        List<AppFunctionDataTypeMetadata> list = this.matchAll;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppFunctionDataTypeMetadata) it.next()).toAppFunctionDataTypeMetadataDocument());
        }
        return new AppFunctionDataTypeMetadataDocument(null, null, 12, null, null, arrayList, null, null, null, isNullable(), this.qualifiedName, getDescription(), null, 4571, null);
    }

    public String toString() {
        return "AppFunctionAllOfTypeMetadata(matchAll=" + this.matchAll + ", qualifiedName=" + this.qualifiedName + ", isNullable=" + this.isNullable + ", description=" + this.description + ")";
    }
}
