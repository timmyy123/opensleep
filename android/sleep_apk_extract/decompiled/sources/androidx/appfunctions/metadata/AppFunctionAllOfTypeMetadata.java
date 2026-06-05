package androidx.appfunctions.metadata;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.processors.AppFunctionInventoryProcessor;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB3\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\r\u0010\u0015\u001a\u00020\u0016H\u0010¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionAllOfTypeMetadata;", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "matchAll", "", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "", "isNullable", "", "description", "<init>", "(Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "getMatchAll", "()Ljava/util/List;", "getQualifiedName", "()Ljava/lang/String;", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "toAppFunctionDataTypeMetadataDocument$appfunctions", "getPseudoObjectTypeMetadata", "Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;", AppFunctionInventoryProcessor.INVENTORY_COMPONENTS_METADATA_PROPERTY_NAME, "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "getPseudoObjectTypeMetadata$appfunctions", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionAllOfTypeMetadata extends AppFunctionDataTypeMetadata {
    public static final int TYPE = 12;
    private final List<AppFunctionDataTypeMetadata> matchAll;
    private final String qualifiedName;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionAllOfTypeMetadata(List<? extends AppFunctionDataTypeMetadata> list, String str, boolean z) {
        this(list, str, z, null, 8, null);
        list.getClass();
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public boolean equals(Object other) {
        if (!super.equals(other) || !(other instanceof AppFunctionAllOfTypeMetadata)) {
            return false;
        }
        AppFunctionAllOfTypeMetadata appFunctionAllOfTypeMetadata = (AppFunctionAllOfTypeMetadata) other;
        if (Intrinsics.areEqual(this.qualifiedName, appFunctionAllOfTypeMetadata.qualifiedName)) {
            return Intrinsics.areEqual(this.matchAll, appFunctionAllOfTypeMetadata.matchAll);
        }
        return false;
    }

    public final List<AppFunctionDataTypeMetadata> getMatchAll() {
        return this.matchAll;
    }

    public final AppFunctionObjectTypeMetadata getPseudoObjectTypeMetadata$appfunctions(AppFunctionComponentsMetadata componentsMetadata) {
        componentsMetadata.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (AppFunctionDataTypeMetadata appFunctionDataTypeMetadata : this.matchAll) {
            if (appFunctionDataTypeMetadata instanceof AppFunctionReferenceTypeMetadata) {
                AppFunctionReferenceTypeMetadata appFunctionReferenceTypeMetadata = (AppFunctionReferenceTypeMetadata) appFunctionDataTypeMetadata;
                AppFunctionDataTypeMetadata appFunctionDataTypeMetadata2 = componentsMetadata.getDataTypes().get(appFunctionReferenceTypeMetadata.getReferenceDataType());
                if (appFunctionDataTypeMetadata2 == null) {
                    Home$$ExternalSyntheticBUOutline0.m("Unable to resolve the ", (Object) appFunctionReferenceTypeMetadata.getReferenceDataType());
                    return null;
                }
                if (appFunctionDataTypeMetadata2 instanceof AppFunctionObjectTypeMetadata) {
                    AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata2;
                    linkedHashMap.putAll(appFunctionObjectTypeMetadata.getProperties());
                    linkedHashSet.addAll(appFunctionObjectTypeMetadata.getRequired());
                }
            } else if (appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata) {
                AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata2 = (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata;
                linkedHashMap.putAll(appFunctionObjectTypeMetadata2.getProperties());
                linkedHashSet.addAll(appFunctionObjectTypeMetadata2.getRequired());
            } else if (appFunctionDataTypeMetadata instanceof AppFunctionAllOfTypeMetadata) {
                AppFunctionObjectTypeMetadata pseudoObjectTypeMetadata$appfunctions = ((AppFunctionAllOfTypeMetadata) appFunctionDataTypeMetadata).getPseudoObjectTypeMetadata$appfunctions(componentsMetadata);
                linkedHashMap.putAll(pseudoObjectTypeMetadata$appfunctions.getProperties());
                linkedHashSet.addAll(pseudoObjectTypeMetadata$appfunctions.getRequired());
            }
        }
        return new AppFunctionObjectTypeMetadata(linkedHashMap, CollectionsKt.toList(linkedHashSet), this.qualifiedName, false, "");
    }

    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public int hashCode() {
        int iHashCode = this.matchAll.hashCode() + (super.hashCode() * 31);
        String str = this.qualifiedName;
        if (str == null) {
            return iHashCode;
        }
        return str.hashCode() + (iHashCode * 31);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument$appfunctions() {
        List<AppFunctionDataTypeMetadata> list = this.matchAll;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppFunctionDataTypeMetadata) it.next()).toAppFunctionDataTypeMetadataDocument$appfunctions());
        }
        boolean isNullable = getIsNullable();
        String str = this.qualifiedName;
        String description = getDescription();
        if (description.length() == 0) {
            description = null;
        }
        return new AppFunctionDataTypeMetadataDocument(null, null, 12, null, null, arrayList, null, null, null, isNullable, str, description, null, 4571, null);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public String toString() {
        return "AppFunctionAllOfTypeMetadata(matchAll=" + this.matchAll + ", isNullable=" + getIsNullable() + ", description=" + getDescription() + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionAllOfTypeMetadata(List<? extends AppFunctionDataTypeMetadata> list, String str, boolean z, String str2) {
        super(z, str2);
        list.getClass();
        str2.getClass();
        this.matchAll = list;
        this.qualifiedName = str;
    }

    public /* synthetic */ AppFunctionAllOfTypeMetadata(List list, String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, z, (i & 8) != 0 ? "" : str2);
    }
}
