package androidx.appfunctions.compiler.core.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.KspUtilsKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.devtools.ksp.symbol.KSAnnotation;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionStringTypeMetadata;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "isNullable", "", "description", "", "enumValues", "", "<init>", "(ZLjava/lang/String;Ljava/util/Set;)V", "()Z", "getDescription", "()Ljava/lang/String;", "getEnumValues", "()Ljava/util/Set;", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionStringTypeMetadata extends AppFunctionDataTypeMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String description;
    private final Set<String> enumValues;
    private final boolean isNullable;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionStringTypeMetadata$Companion;", "", "<init>", "()V", "create", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionStringTypeMetadata;", "isNullable", "", "description", "", "annotations", "Lkotlin/sequences/Sequence;", "Lcom/google/devtools/ksp/symbol/KSAnnotation;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppFunctionStringTypeMetadata create(boolean isNullable, String description, Sequence<? extends KSAnnotation> annotations) {
            description.getClass();
            annotations.getClass();
            KspUtilsKt.findAnnotation(annotations, IntrospectionHelper.AppFunctionStringValueConstraintAnnotation.INSTANCE.getCLASS_NAME());
            return new AppFunctionStringTypeMetadata(isNullable, description, null);
        }

        private Companion() {
        }
    }

    public AppFunctionStringTypeMetadata(boolean z, String str, Set<String> set) {
        str.getClass();
        this.isNullable = z;
        this.description = str;
        this.enumValues = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppFunctionStringTypeMetadata copy$default(AppFunctionStringTypeMetadata appFunctionStringTypeMetadata, boolean z, String str, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            z = appFunctionStringTypeMetadata.isNullable;
        }
        if ((i & 2) != 0) {
            str = appFunctionStringTypeMetadata.description;
        }
        if ((i & 4) != 0) {
            set = appFunctionStringTypeMetadata.enumValues;
        }
        return appFunctionStringTypeMetadata.copy(z, str, set);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final Set<String> component3() {
        return this.enumValues;
    }

    public final AppFunctionStringTypeMetadata copy(boolean isNullable, String description, Set<String> enumValues) {
        description.getClass();
        return new AppFunctionStringTypeMetadata(isNullable, description, enumValues);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionStringTypeMetadata)) {
            return false;
        }
        AppFunctionStringTypeMetadata appFunctionStringTypeMetadata = (AppFunctionStringTypeMetadata) other;
        return this.isNullable == appFunctionStringTypeMetadata.isNullable && Intrinsics.areEqual(this.description, appFunctionStringTypeMetadata.description) && Intrinsics.areEqual(this.enumValues, appFunctionStringTypeMetadata.enumValues);
    }

    @Override // androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata
    public String getDescription() {
        return this.description;
    }

    public final Set<String> getEnumValues() {
        return this.enumValues;
    }

    public int hashCode() {
        int iM = FileInsert$$ExternalSyntheticOutline0.m(Boolean.hashCode(this.isNullable) * 31, 31, this.description);
        Set<String> set = this.enumValues;
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
        Set<String> setEmptySet = this.enumValues;
        if (setEmptySet == null) {
            setEmptySet = SetsKt.emptySet();
        }
        return new AppFunctionDataTypeMetadataDocument(null, null, 8, null, null, null, null, null, null, zIsNullable, null, description, CollectionsKt.toList(setEmptySet), 1531, null);
    }

    public String toString() {
        return "AppFunctionStringTypeMetadata(isNullable=" + this.isNullable + ", description=" + this.description + ", enumValues=" + this.enumValues + ")";
    }

    public /* synthetic */ AppFunctionStringTypeMetadata(boolean z, String str, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, (i & 4) != 0 ? null : set);
    }
}
