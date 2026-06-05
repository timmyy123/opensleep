package androidx.health.connect.client.records;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.ext.SdkExtensions;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0003\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0002\u001a3\u0010\n\u001a\u00020\t\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a3\u0010\f\u001a\u00020\t\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000f\u0010\u0012\u001a+\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u0013*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a;\u0010\u0019\u001a\u00020\t\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"", "isAtLeastSdkExtension13", "()Z", "isAtLeastSdkExtension15", "", "T", "other", "", "name", "", "requireNotLess", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/String;)V", "requireNotMore", "", SDKConstants.PARAM_VALUE, "requireNonNegative", "(JLjava/lang/String;)V", "", "(DLjava/lang/String;)V", "", "", "reverse", "(Ljava/util/Map;)Ljava/util/Map;", "min", "max", "requireInRange", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/String;)V", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class UtilsKt {
    public static final boolean isAtLeastSdkExtension13() {
        return SdkExtensions.getExtensionVersion(34) >= 13;
    }

    public static final boolean isAtLeastSdkExtension15() {
        return SdkExtensions.getExtensionVersion(34) >= 15;
    }

    public static final <T extends Comparable<? super T>> void requireInRange(T t, T t2, T t3, String str) {
        t.getClass();
        t2.getClass();
        t3.getClass();
        str.getClass();
        requireNotLess(t, t2, str);
        requireNotMore(t, t3, str);
    }

    public static final void requireNonNegative(long j, String str) {
        str.getClass();
        if (j >= 0) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m$1(str, " must not be negative"));
    }

    public static final <T extends Comparable<? super T>> void requireNotLess(T t, T t2, String str) {
        t.getClass();
        t2.getClass();
        str.getClass();
        if (t.compareTo(t2) >= 0) {
            return;
        }
        throw new IllegalArgumentException((str + " must not be less than " + t2 + ", currently " + t + '.').toString());
    }

    public static final <T extends Comparable<? super T>> void requireNotMore(T t, T t2, String str) {
        t.getClass();
        t2.getClass();
        str.getClass();
        if (t.compareTo(t2) <= 0) {
            return;
        }
        throw new IllegalArgumentException((str + " must not be more than " + t2 + ", currently " + t + '.').toString());
    }

    public static final Map<Integer, String> reverse(Map<String, Integer> map) {
        map.getClass();
        Set<Map.Entry<String, Integer>> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(((Number) entry.getValue()).intValue()), (String) entry.getKey());
        }
        return linkedHashMap;
    }

    public static final void requireNonNegative(double d, String str) {
        str.getClass();
        if (d >= 0.0d) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m$1(str, " must not be negative"));
    }
}
