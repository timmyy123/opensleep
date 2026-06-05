package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Visibility {
    private final boolean isPublicAPI;
    private final String name;

    public Visibility(String str, boolean z) {
        str.getClass();
        this.name = str;
        this.isPublicAPI = z;
    }

    public Integer compareTo(Visibility visibility) {
        visibility.getClass();
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, visibility);
    }

    public String getInternalDisplayName() {
        return this.name;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    public Visibility normalize() {
        return this;
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}
