package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class KmPropertyAccessorAttributes {
    private final List<KmAnnotation> annotations = new ArrayList(0);
    private int flags;

    public KmPropertyAccessorAttributes(int i) {
        this.flags = i;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }
}
