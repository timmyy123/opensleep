package kotlin.reflect.jvm.internal.impl.km;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class KmVersion {
    private final int major;
    private final int minor;
    private final int patch;

    public KmVersion(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KmVersion)) {
            return false;
        }
        KmVersion kmVersion = (KmVersion) obj;
        return this.major == kmVersion.major && this.minor == kmVersion.minor && this.patch == kmVersion.patch;
    }

    public int hashCode() {
        return Integer.hashCode(this.patch) + FileInsert$$ExternalSyntheticOutline0.m(this.minor, Integer.hashCode(this.major) * 31, 31);
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
}
