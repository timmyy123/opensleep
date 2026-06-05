package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TypeRegistry<K, V> {
    private final ConcurrentHashMap<String, Integer> idPerType = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getId$lambda$0(TypeRegistry typeRegistry, String str) {
        str.getClass();
        return typeRegistry.idCounter.getAndIncrement();
    }

    public final Map<String, Integer> allValuesThreadUnsafeForRendering() {
        return this.idPerType;
    }

    public abstract int customComputeIfAbsent(ConcurrentHashMap<String, Integer> concurrentHashMap, String str, Function1<? super String, Integer> function1);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(KClass<KK> kClass) {
        kClass.getClass();
        return new NullableArrayMapAccessor<>(getId(kClass));
    }

    public final <T extends K> int getId(KClass<T> kClass) {
        kClass.getClass();
        String qualifiedName = kClass.getQualifiedName();
        qualifiedName.getClass();
        return getId(qualifiedName);
    }

    public final Collection<Integer> getIndices() {
        Collection<Integer> collectionValues = this.idPerType.values();
        collectionValues.getClass();
        return collectionValues;
    }

    public final int getId(String str) {
        str.getClass();
        return customComputeIfAbsent(this.idPerType, str, new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.util.TypeRegistry$$Lambda$0
            private final TypeRegistry arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return Integer.valueOf(TypeRegistry.getId$lambda$0(this.arg$0, (String) obj));
            }
        });
    }
}
