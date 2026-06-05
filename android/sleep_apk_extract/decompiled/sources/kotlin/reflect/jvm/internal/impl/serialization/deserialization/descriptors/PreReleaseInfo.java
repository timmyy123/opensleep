package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class PreReleaseInfo {
    public static final Companion Companion = new Companion(null);
    private static final PreReleaseInfo DEFAULT_VISIBLE = new PreReleaseInfo(false, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    private final boolean isInvisible;
    private final List<String> poisoningFeatures;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ PreReleaseInfo(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreReleaseInfo)) {
            return false;
        }
        PreReleaseInfo preReleaseInfo = (PreReleaseInfo) obj;
        return this.isInvisible == preReleaseInfo.isInvisible && Intrinsics.areEqual(this.poisoningFeatures, preReleaseInfo.poisoningFeatures);
    }

    public int hashCode() {
        return this.poisoningFeatures.hashCode() + (Boolean.hashCode(this.isInvisible) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PreReleaseInfo(isInvisible=");
        sb.append(this.isInvisible);
        sb.append(", poisoningFeatures=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.poisoningFeatures, ')');
    }

    public PreReleaseInfo(boolean z, List<String> list) {
        list.getClass();
        this.isInvisible = z;
        this.poisoningFeatures = list;
    }
}
