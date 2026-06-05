package androidx.graphics.shapes;

import androidx.graphics.shapes.Feature;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a3\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u00022\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0000¢\u0006\u0004\b\f\u0010\r\u001a=\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u00022\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u00022\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000f*\u0018\b\u0000\u0010\u0010\"\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0012\u0004\u0012\u00020\u00010\u0000¨\u0006\u0011"}, d2 = {"", "Landroidx/graphics/shapes/ProgressableFeature;", "Landroidx/graphics/shapes/MeasuredFeatures;", "features1", "features2", "Landroidx/graphics/shapes/DoubleMapper;", "featureMapper", "(Ljava/util/List;Ljava/util/List;)Landroidx/graphics/shapes/DoubleMapper;", "Landroidx/graphics/shapes/Feature;", "f1", "f2", "", "featureDistSquared", "(Landroidx/graphics/shapes/Feature;Landroidx/graphics/shapes/Feature;)F", "doMapping", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "MeasuredFeatures", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public abstract class FeatureMappingKt {
    public static final List<ProgressableFeature> doMapping(List<ProgressableFeature> list, List<ProgressableFeature> list2) {
        list.getClass();
        list2.getClass();
        Iterator<Integer> it = CollectionsKt.getIndices(list2).iterator();
        if (!it.hasNext()) {
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        IntIterator intIterator = (IntIterator) it;
        int iNextInt = intIterator.nextInt();
        if (it.hasNext()) {
            float fFeatureDistSquared = featureDistSquared(list.get(0).getFeature(), list2.get(iNextInt).getFeature());
            do {
                int iNextInt2 = intIterator.nextInt();
                float fFeatureDistSquared2 = featureDistSquared(list.get(0).getFeature(), list2.get(iNextInt2).getFeature());
                if (Float.compare(fFeatureDistSquared, fFeatureDistSquared2) > 0) {
                    iNextInt = iNextInt2;
                    fFeatureDistSquared = fFeatureDistSquared2;
                }
            } while (it.hasNext());
        }
        int size = list.size();
        int size2 = list2.size();
        List<ProgressableFeature> listMutableListOf = CollectionsKt.mutableListOf(list2.get(iNextInt));
        int i = iNextInt;
        for (int i2 = 1; i2 < size; i2++) {
            int i3 = iNextInt - (size - i2);
            if (i3 <= i) {
                i3 += size2;
            }
            Iterator<Integer> it2 = new IntRange(i + 1, i3).iterator();
            if (!it2.hasNext()) {
                Types$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            IntIterator intIterator2 = (IntIterator) it2;
            int iNextInt3 = intIterator2.nextInt();
            if (it2.hasNext()) {
                float fFeatureDistSquared3 = featureDistSquared(list.get(i2).getFeature(), list2.get(iNextInt3 % size2).getFeature());
                do {
                    int iNextInt4 = intIterator2.nextInt();
                    float fFeatureDistSquared4 = featureDistSquared(list.get(i2).getFeature(), list2.get(iNextInt4 % size2).getFeature());
                    if (Float.compare(fFeatureDistSquared3, fFeatureDistSquared4) > 0) {
                        iNextInt3 = iNextInt4;
                        fFeatureDistSquared3 = fFeatureDistSquared4;
                    }
                } while (it2.hasNext());
            }
            i = iNextInt3;
            listMutableListOf.add(list2.get(i % size2));
        }
        return listMutableListOf;
    }

    public static final float featureDistSquared(Feature feature, Feature feature2) {
        feature.getClass();
        feature2.getClass();
        if ((feature instanceof Feature.Corner) && (feature2 instanceof Feature.Corner) && ((Feature.Corner) feature).getConvex() != ((Feature.Corner) feature2).getConvex()) {
            return Float.MAX_VALUE;
        }
        float anchor1X = (((Cubic) CollectionsKt.last((List) feature.getCubics())).getAnchor1X() + ((Cubic) CollectionsKt.first((List) feature.getCubics())).getAnchor0X()) / 2.0f;
        float anchor1Y = (((Cubic) CollectionsKt.last((List) feature.getCubics())).getAnchor1Y() + ((Cubic) CollectionsKt.first((List) feature.getCubics())).getAnchor0Y()) / 2.0f;
        float anchor1X2 = (((Cubic) CollectionsKt.last((List) feature2.getCubics())).getAnchor1X() + ((Cubic) CollectionsKt.first((List) feature2.getCubics())).getAnchor0X()) / 2.0f;
        float f = anchor1X - anchor1X2;
        float anchor1Y2 = anchor1Y - ((((Cubic) CollectionsKt.last((List) feature2.getCubics())).getAnchor1Y() + ((Cubic) CollectionsKt.first((List) feature2.getCubics())).getAnchor0Y()) / 2.0f);
        return (anchor1Y2 * anchor1Y2) + (f * f);
    }

    public static final DoubleMapper featureMapper(List<ProgressableFeature> list, List<ProgressableFeature> list2) {
        list.getClass();
        list2.getClass();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getFeature() instanceof Feature.Corner) {
                listCreateListBuilder.add(list.get(i));
            }
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        List listCreateListBuilder2 = CollectionsKt.createListBuilder();
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (list2.get(i2).getFeature() instanceof Feature.Corner) {
                listCreateListBuilder2.add(list2.get(i2));
            }
        }
        List listBuild2 = CollectionsKt.build(listCreateListBuilder2);
        Pair pair = listBuild.size() > listBuild2.size() ? TuplesKt.to(doMapping(listBuild2, listBuild), listBuild2) : TuplesKt.to(listBuild, doMapping(listBuild, listBuild2));
        List list3 = (List) pair.component1();
        List list4 = (List) pair.component2();
        List listCreateListBuilder3 = CollectionsKt.createListBuilder();
        int size3 = list3.size();
        for (int i3 = 0; i3 < size3 && i3 != list4.size(); i3++) {
            listCreateListBuilder3.add(TuplesKt.to(Float.valueOf(((ProgressableFeature) list3.get(i3)).getProgress()), Float.valueOf(((ProgressableFeature) list4.get(i3)).getProgress())));
        }
        Pair[] pairArr = (Pair[]) CollectionsKt.build(listCreateListBuilder3).toArray(new Pair[0]);
        return new DoubleMapper((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }
}
