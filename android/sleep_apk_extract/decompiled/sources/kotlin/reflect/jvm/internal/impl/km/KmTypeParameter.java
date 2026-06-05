package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* JADX INFO: loaded from: classes5.dex */
public final class KmTypeParameter {
    private final List<KmTypeParameterExtension> extensions;
    private int flags;
    private int id;
    private String name;
    private final List<KmType> upperBounds;
    private KmVariance variance;

    public KmTypeParameter(int i, String str, int i2, KmVariance kmVariance) {
        str.getClass();
        kmVariance.getClass();
        this.flags = i;
        this.name = str;
        this.id = i2;
        this.variance = kmVariance;
        this.upperBounds = new ArrayList(1);
        List<MetadataExtensions> iNSTANCES$kotlin_metadata = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlin_metadata, 10));
        Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            arrayList.add(((MetadataExtensions) it.next()).createTypeParameterExtension());
        }
        this.extensions = arrayList;
    }

    public final List<KmTypeParameterExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<KmType> getUpperBounds() {
        return this.upperBounds;
    }

    public final KmVariance getVariance() {
        return this.variance;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KmTypeParameter(String str, int i, KmVariance kmVariance) {
        this(0, str, i, kmVariance);
        str.getClass();
        kmVariance.getClass();
    }
}
