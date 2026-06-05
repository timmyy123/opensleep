package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

/* JADX INFO: loaded from: classes5.dex */
public final class JavaVisibilities$PackageVisibility extends Visibility {
    public static final JavaVisibilities$PackageVisibility INSTANCE = new JavaVisibilities$PackageVisibility();

    private JavaVisibilities$PackageVisibility() {
        super("package", false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
    public Integer compareTo(Visibility visibility) {
        visibility.getClass();
        if (this == visibility) {
            return 0;
        }
        return Visibilities.INSTANCE.isPrivate(visibility) ? 1 : -1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
    public String getInternalDisplayName() {
        return "public/*package*/";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
    public Visibility normalize() {
        return Visibilities.Protected.INSTANCE;
    }
}
