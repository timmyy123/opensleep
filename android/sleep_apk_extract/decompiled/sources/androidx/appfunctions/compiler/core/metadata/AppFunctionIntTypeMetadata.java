package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.KspUtilsKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.devtools.ksp.symbol.KSAnnotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionIntTypeMetadata;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "isNullable", "", "description", "", "enumValues", "", "", "<init>", "(ZLjava/lang/String;Ljava/util/Set;)V", "()Z", "getDescription", "()Ljava/lang/String;", "getEnumValues", "()Ljava/util/Set;", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionIntTypeMetadata extends AppFunctionDataTypeMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String description;
    private final Set<Integer> enumValues;
    private final boolean isNullable;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionIntTypeMetadata$Companion;", "", "<init>", "()V", "create", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionIntTypeMetadata;", "isNullable", "", "description", "", "annotations", "Lkotlin/sequences/Sequence;", "Lcom/google/devtools/ksp/symbol/KSAnnotation;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppFunctionIntTypeMetadata create(boolean isNullable, String description, Sequence<? extends KSAnnotation> annotations) {
            description.getClass();
            annotations.getClass();
            KspUtilsKt.findAnnotation(annotations, IntrospectionHelper.AppFunctionIntValueConstraintAnnotation.INSTANCE.getCLASS_NAME());
            return new AppFunctionIntTypeMetadata(isNullable, description, null);
        }

        private Companion() {
        }
    }

    public AppFunctionIntTypeMetadata(boolean z, String str, Set<Integer> set) {
        str.getClass();
        this.isNullable = z;
        this.description = str;
        this.enumValues = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppFunctionIntTypeMetadata copy$default(AppFunctionIntTypeMetadata appFunctionIntTypeMetadata, boolean z, String str, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            z = appFunctionIntTypeMetadata.isNullable;
        }
        if ((i & 2) != 0) {
            str = appFunctionIntTypeMetadata.description;
        }
        if ((i & 4) != 0) {
            set = appFunctionIntTypeMetadata.enumValues;
        }
        return appFunctionIntTypeMetadata.copy(z, str, set);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final Set<Integer> component3() {
        return this.enumValues;
    }

    public final AppFunctionIntTypeMetadata copy(boolean isNullable, String description, Set<Integer> enumValues) {
        description.getClass();
        return new AppFunctionIntTypeMetadata(isNullable, description, enumValues);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionIntTypeMetadata)) {
            return false;
        }
        AppFunctionIntTypeMetadata appFunctionIntTypeMetadata = (AppFunctionIntTypeMetadata) other;
        return this.isNullable == appFunctionIntTypeMetadata.isNullable && Intrinsics.areEqual(this.description, appFunctionIntTypeMetadata.description) && Intrinsics.areEqual(this.enumValues, appFunctionIntTypeMetadata.enumValues);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public String getDescription() {
        return this.description;
    }

    public final Set<Integer> getEnumValues() {
        return this.enumValues;
    }

    public int hashCode() {
        int iM = FileInsert$$ExternalSyntheticOutline0.m(Boolean.hashCode(this.isNullable) * 31, 31, this.description);
        Set<Integer> set = this.enumValues;
        return iM + (set == null ? 0 : set.hashCode());
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public boolean isNullable() {
        return this.isNullable;
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument() {
        boolean zIsNullable = isNullable();
        String description = getDescription();
        Set<Integer> setEmptySet = this.enumValues;
        if (setEmptySet == null) {
            setEmptySet = SetsKt.emptySet();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEmptySet, 10));
        Iterator<T> it = setEmptySet.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).intValue()));
        }
        return new AppFunctionDataTypeMetadataDocument(null, null, 7, null, null, null, null, null, null, zIsNullable, null, description, arrayList, 1531, null);
    }

    public String toString() {
        return "AppFunctionIntTypeMetadata(isNullable=" + this.isNullable + ", description=" + this.description + ", enumValues=" + this.enumValues + ")";
    }

    public /* synthetic */ AppFunctionIntTypeMetadata(boolean z, String str, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, (i & 4) != 0 ? null : set);
    }
}
