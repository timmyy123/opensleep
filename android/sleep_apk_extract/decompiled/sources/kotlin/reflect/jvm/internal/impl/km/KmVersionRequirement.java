package kotlin.reflect.jvm.internal.impl.km;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class KmVersionRequirement {
    private Integer errorCode;
    public KmVersionRequirementVersionKind kind;
    public KmVersionRequirementLevel level;
    private String message;
    public KmVersion version;

    public final KmVersionRequirementVersionKind getKind() {
        KmVersionRequirementVersionKind kmVersionRequirementVersionKind = this.kind;
        if (kmVersionRequirementVersionKind != null) {
            return kmVersionRequirementVersionKind;
        }
        Intrinsics.throwUninitializedPropertyAccessException("kind");
        return null;
    }

    public final KmVersionRequirementLevel getLevel() {
        KmVersionRequirementLevel kmVersionRequirementLevel = this.level;
        if (kmVersionRequirementLevel != null) {
            return kmVersionRequirementLevel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("level");
        return null;
    }

    public final KmVersion getVersion() {
        KmVersion kmVersion = this.version;
        if (kmVersion != null) {
            return kmVersion;
        }
        Intrinsics.throwUninitializedPropertyAccessException("version");
        return null;
    }

    public final void setErrorCode(Integer num) {
        this.errorCode = num;
    }

    public final void setKind(KmVersionRequirementVersionKind kmVersionRequirementVersionKind) {
        kmVersionRequirementVersionKind.getClass();
        this.kind = kmVersionRequirementVersionKind;
    }

    public final void setLevel(KmVersionRequirementLevel kmVersionRequirementLevel) {
        kmVersionRequirementLevel.getClass();
        this.level = kmVersionRequirementLevel;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setVersion(KmVersion kmVersion) {
        kmVersion.getClass();
        this.version = kmVersion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KmVersionRequirement(kind=");
        sb.append(getKind());
        sb.append(", level=");
        sb.append(getLevel());
        sb.append(", version=");
        sb.append(getVersion());
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", message=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.message, ')');
    }
}
