package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

/* JADX INFO: loaded from: classes5.dex */
public final class JavaVisibilities$ProtectedStaticVisibility extends Visibility {
    public static final JavaVisibilities$ProtectedStaticVisibility INSTANCE = new JavaVisibilities$ProtectedStaticVisibility();

    private JavaVisibilities$ProtectedStaticVisibility() {
        super("protected_static", true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
    public String getInternalDisplayName() {
        return "protected/*protected static*/";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
    public Visibility normalize() {
        return Visibilities.Protected.INSTANCE;
    }
}
