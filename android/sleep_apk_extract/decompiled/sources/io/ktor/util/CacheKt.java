package io.ktor.util;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u001aW\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"K", "V", "Lkotlin/Function1;", "supplier", "", "close", "", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "", "createLRUCache", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;I)Ljava/util/Map;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class CacheKt {
    public static final <K, V> Map<K, V> createLRUCache(Function1<? super K, ? extends V> function1, Function1<? super V, Unit> function12, int i) {
        function1.getClass();
        function12.getClass();
        Map<K, V> mapSynchronizedMap = Collections.synchronizedMap(new LRUCache(function1, function12, i));
        mapSynchronizedMap.getClass();
        return mapSynchronizedMap;
    }
}
