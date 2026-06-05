package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ValueCache {
    private final Map<String, Object> cache = new HashMap();

    public interface Supplier {
        Object get();
    }

    public <T> T computeIfAbsent(String str, Supplier supplier) {
        if (!this.cache.containsKey(str)) {
            this.cache.put(str, supplier.get());
        }
        return (T) this.cache.get(str);
    }

    public <T> T get(String str) {
        return (T) this.cache.get(str);
    }

    public void put(String str, Object obj) {
        this.cache.put(str, obj);
    }
}
