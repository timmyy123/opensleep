package kotlin.reflect.jvm.internal.impl.km;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class KmFlexibleTypeUpperBound {
    public static final Companion Companion = new Companion(null);
    private KmType type;
    private String typeFlexibilityId;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public KmFlexibleTypeUpperBound(KmType kmType, String str) {
        kmType.getClass();
        this.type = kmType;
        this.typeFlexibilityId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KmFlexibleTypeUpperBound)) {
            return false;
        }
        KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = (KmFlexibleTypeUpperBound) obj;
        return Intrinsics.areEqual(this.type, kmFlexibleTypeUpperBound.type) && Intrinsics.areEqual(this.typeFlexibilityId, kmFlexibleTypeUpperBound.typeFlexibilityId);
    }

    public final KmType getType() {
        return this.type;
    }

    public final String getTypeFlexibilityId() {
        return this.typeFlexibilityId;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.typeFlexibilityId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KmFlexibleTypeUpperBound(type=");
        sb.append(this.type);
        sb.append(", typeFlexibilityId=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.typeFlexibilityId, ')');
    }
}
