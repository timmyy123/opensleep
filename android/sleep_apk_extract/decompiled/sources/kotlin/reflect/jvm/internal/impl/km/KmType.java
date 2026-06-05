package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* JADX INFO: loaded from: classes5.dex */
public final class KmType {
    private KmType abbreviatedType;
    private final List<KmTypeProjection> arguments;
    public KmClassifier classifier;
    private final List<KmTypeExtension> extensions;
    private int flags;
    private KmFlexibleTypeUpperBound flexibleTypeUpperBound;
    private KmType outerType;

    public KmType(int i) {
        this.flags = i;
        this.arguments = new ArrayList(0);
        List<MetadataExtensions> iNSTANCES$kotlin_metadata = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlin_metadata, 10));
        Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            arrayList.add(((MetadataExtensions) it.next()).createTypeExtension());
        }
        this.extensions = arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(KmType.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        KmType kmType = (KmType) obj;
        return this.flags == kmType.flags && Intrinsics.areEqual(getClassifier(), kmType.getClassifier()) && Intrinsics.areEqual(this.arguments, kmType.arguments) && Intrinsics.areEqual(this.outerType, kmType.outerType) && Intrinsics.areEqual(this.abbreviatedType, kmType.abbreviatedType) && Intrinsics.areEqual(this.flexibleTypeUpperBound, kmType.flexibleTypeUpperBound) && Intrinsics.areEqual(this.extensions, kmType.extensions);
    }

    public final KmType getAbbreviatedType() {
        return this.abbreviatedType;
    }

    public final List<KmTypeProjection> getArguments() {
        return this.arguments;
    }

    public final KmClassifier getClassifier() {
        KmClassifier kmClassifier = this.classifier;
        if (kmClassifier != null) {
            return kmClassifier;
        }
        Intrinsics.throwUninitializedPropertyAccessException("classifier");
        return null;
    }

    public final List<KmTypeExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final KmFlexibleTypeUpperBound getFlexibleTypeUpperBound() {
        return this.flexibleTypeUpperBound;
    }

    public final KmType getOuterType() {
        return this.outerType;
    }

    public int hashCode() {
        return this.arguments.hashCode() + ((getClassifier().hashCode() + (this.flags * 31)) * 31);
    }

    public final void setAbbreviatedType(KmType kmType) {
        this.abbreviatedType = kmType;
    }

    public final void setClassifier(KmClassifier kmClassifier) {
        kmClassifier.getClass();
        this.classifier = kmClassifier;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public final void setFlexibleTypeUpperBound(KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound) {
        this.flexibleTypeUpperBound = kmFlexibleTypeUpperBound;
    }

    public final void setOuterType(KmType kmType) {
        this.outerType = kmType;
    }

    public KmType() {
        this(0);
    }
}
