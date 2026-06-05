package kotlin.reflect.jvm.internal.impl.km.jvm;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmMetadataVersion implements Comparable<JvmMetadataVersion> {
    private final int major;
    private final int minor;
    private final int patch;
    public static final Companion Companion = new Companion(null);
    public static final JvmMetadataVersion LATEST_STABLE_SUPPORTED = new JvmMetadataVersion(MetadataVersion.INSTANCE.toArray());
    public static final JvmMetadataVersion HIGHEST_ALLOWED_TO_WRITE = new JvmMetadataVersion(MetadataVersion.INSTANCE_NEXT.toArray());

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public JvmMetadataVersion(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Major version should be not less than 0");
            throw null;
        }
        if (i2 < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Minor version should be not less than 0");
            throw null;
        }
        if (i3 >= 0) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Patch version should be not less than 0");
        throw null;
    }

    @Override // java.lang.Comparable
    public int compareTo(JvmMetadataVersion jvmMetadataVersion) {
        jvmMetadataVersion.getClass();
        int iCompare = Intrinsics.compare(this.major, jvmMetadataVersion.major);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Intrinsics.compare(this.minor, jvmMetadataVersion.minor);
        return iCompare2 != 0 ? iCompare2 : Intrinsics.compare(this.patch, jvmMetadataVersion.patch);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(JvmMetadataVersion.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        JvmMetadataVersion jvmMetadataVersion = (JvmMetadataVersion) obj;
        return this.major == jvmMetadataVersion.major && this.minor == jvmMetadataVersion.minor && this.patch == jvmMetadataVersion.patch;
    }

    public int hashCode() {
        return (((this.major * 31) + this.minor) * 31) + this.patch;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.major);
        sb.append('.');
        sb.append(this.minor);
        sb.append('.');
        sb.append(this.patch);
        return sb.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(int[] iArr) {
        this(iArr[0], iArr[1], iArr[2]);
        iArr.getClass();
    }
}
