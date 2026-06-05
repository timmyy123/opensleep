package androidx.graphics.shapes;

import androidx.collection.FloatList;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.RangesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0000¨\u0006\u000e"}, d2 = {"linearMap", "", "xValues", "Landroidx/collection/FloatList;", "yValues", "x", "progressInRange", "", "progress", "progressFrom", "progressTo", "validateProgress", "", "p", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public abstract class FloatMappingKt {
    public static final float linearMap(FloatList floatList, FloatList floatList2, float f) {
        floatList.getClass();
        floatList2.getClass();
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException(("Invalid progress: " + f).toString());
        }
        Iterator<Integer> it = RangesKt.until(0, floatList._size).iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            int i = iNextInt + 1;
            if (progressInRange(f, floatList.get(iNextInt), floatList.get(i % floatList.get_size()))) {
                int i2 = i % floatList.get_size();
                float fPositiveModulo = Utils.positiveModulo(floatList.get(i2) - floatList.get(iNextInt), 1.0f);
                return Utils.positiveModulo((Utils.positiveModulo(floatList2.get(i2) - floatList2.get(iNextInt), 1.0f) * (fPositiveModulo < 0.001f ? 0.5f : Utils.positiveModulo(f - floatList.get(iNextInt), 1.0f) / fPositiveModulo)) + floatList2.get(iNextInt), 1.0f);
            }
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Collection contains no element matching the predicate.");
        return 0.0f;
    }

    public static final boolean progressInRange(float f, float f2, float f3) {
        return f3 >= f2 ? f2 <= f && f <= f3 : f >= f2 || f <= f3;
    }

    public static final void validateProgress(FloatList floatList) {
        floatList.getClass();
        Boolean boolValueOf = Boolean.TRUE;
        float[] fArr = floatList.content;
        int i = floatList._size;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= i) {
                break;
            }
            float f = fArr[i3];
            if (!boolValueOf.booleanValue() || 0.0f > f || f > 1.0f) {
                z = false;
            }
            boolValueOf = Boolean.valueOf(z);
            i3++;
        }
        if (!boolValueOf.booleanValue()) {
            Utf8$$ExternalSyntheticBUOutline0.m$4("FloatMapping - Progress outside of range: ", FloatList.joinToString$default(floatList, null, null, null, 0, null, 31, null));
            return;
        }
        Iterable iterableUntil = RangesKt.until(1, floatList.get_size());
        if (!(iterableUntil instanceof Collection) || !((Collection) iterableUntil).isEmpty()) {
            Iterator it = iterableUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                if (floatList.get(iNextInt) < floatList.get(iNextInt - 1) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i2 <= 1) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$4("FloatMapping - Progress wraps more than once: ", FloatList.joinToString$default(floatList, null, null, null, 0, null, 31, null));
    }
}
