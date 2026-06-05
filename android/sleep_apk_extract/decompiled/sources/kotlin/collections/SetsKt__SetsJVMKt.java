package kotlin.collections;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.builders.SetBuilder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0007\u0010\u000b\u001a)\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\"\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"T", "element", "", "setOf", "(Ljava/lang/Object;)Ljava/util/Set;", "E", "", "createSetBuilder", "()Ljava/util/Set;", "", "capacity", "(I)Ljava/util/Set;", "builder", InAppPurchaseConstants.METHOD_BUILD, "(Ljava/util/Set;)Ljava/util/Set;", "", "elements", "Ljava/util/TreeSet;", "sortedSetOf", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
public abstract class SetsKt__SetsJVMKt {
    public static <E> Set<E> build(Set<E> set) {
        set.getClass();
        return ((SetBuilder) set).build();
    }

    public static <E> Set<E> createSetBuilder() {
        return new SetBuilder();
    }

    public static <T> Set<T> setOf(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        setSingleton.getClass();
        return setSingleton;
    }

    public static <T> TreeSet<T> sortedSetOf(T... tArr) {
        tArr.getClass();
        return (TreeSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet());
    }

    public static <E> Set<E> createSetBuilder(int i) {
        return new SetBuilder(i);
    }
}
