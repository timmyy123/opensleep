package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class KmTypeProjection {
    public static final Companion Companion = new Companion(null);
    public static final KmTypeProjection STAR = new KmTypeProjection(null, null);
    private KmType type;
    private KmVariance variance;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public KmTypeProjection(KmVariance kmVariance, KmType kmType) {
        this.variance = kmVariance;
        this.type = kmType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KmTypeProjection)) {
            return false;
        }
        KmTypeProjection kmTypeProjection = (KmTypeProjection) obj;
        return this.variance == kmTypeProjection.variance && Intrinsics.areEqual(this.type, kmTypeProjection.type);
    }

    public final KmType getType() {
        return this.type;
    }

    public final KmVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        KmVariance kmVariance = this.variance;
        int iHashCode = (kmVariance == null ? 0 : kmVariance.hashCode()) * 31;
        KmType kmType = this.type;
        return iHashCode + (kmType != null ? kmType.hashCode() : 0);
    }

    public String toString() {
        return "KmTypeProjection(variance=" + this.variance + ", type=" + this.type + ')';
    }
}
