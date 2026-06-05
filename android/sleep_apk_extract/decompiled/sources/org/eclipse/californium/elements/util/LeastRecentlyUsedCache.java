package org.eclipse.californium.elements.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class LeastRecentlyUsedCache<K, V> {
    private final Map<K, CacheEntry<K, V>> cache;
    private volatile int capacity;
    private volatile boolean evictOnReadAccess;
    private final List<EvictionListener<V>> evictionListeners;
    private volatile long expirationThresholdNanos;
    private CacheEntry<K, V> header;
    private volatile boolean updateOnReadAccess;
    private Collection<V> values;

    public interface EvictionListener<V> {
        void onEviction(V v);
    }

    public interface Predicate<V> {
        boolean accept(V v);
    }

    public LeastRecentlyUsedCache(int i, int i2, long j) {
        this.evictOnReadAccess = true;
        this.updateOnReadAccess = true;
        this.evictionListeners = new LinkedList();
        if (i > i2) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("initial capacity must be <= max capacity");
            throw null;
        }
        this.capacity = i2;
        this.cache = new ConcurrentHashMap(i);
        setExpirationThreshold(j);
        initLinkedList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final V access(CacheEntry<K, V> cacheEntry, Iterator<CacheEntry<K, V>> it) {
        if (!this.evictOnReadAccess || this.expirationThresholdNanos <= 0 || !cacheEntry.isStale(this.expirationThresholdNanos)) {
            if (this.updateOnReadAccess) {
                cacheEntry.recordAccess(this.header);
            }
            return (V) cacheEntry.getValue();
        }
        if (it != null) {
            it.remove();
        } else {
            this.cache.remove(cacheEntry.getKey());
        }
        cacheEntry.remove();
        notifyEvictionListeners(cacheEntry.getValue());
        return null;
    }

    private void add(K k, V v) {
        CacheEntry<K, V> cacheEntry = new CacheEntry<>(k, v);
        this.cache.put(k, cacheEntry);
        cacheEntry.addBefore(this.header);
    }

    private void initLinkedList() {
        CacheEntry<K, V> cacheEntry = new CacheEntry<>();
        this.header = cacheEntry;
        ((CacheEntry) cacheEntry).after = ((CacheEntry) cacheEntry).before = cacheEntry;
    }

    private void notifyEvictionListeners(V v) {
        Iterator<EvictionListener<V>> it = this.evictionListeners.iterator();
        while (it.hasNext()) {
            it.next().onEviction(v);
        }
    }

    public void addEvictionListener(EvictionListener<V> evictionListener) {
        if (evictionListener != null) {
            this.evictionListeners.add(evictionListener);
        }
    }

    public final void clear() {
        this.cache.clear();
        initLinkedList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V find(Predicate<V> predicate, boolean z) {
        if (predicate == 0) {
            return null;
        }
        Iterator<CacheEntry<K, V>> it = this.cache.values().iterator();
        while (it.hasNext()) {
            CacheEntry<K, V> next = it.next();
            if (predicate.accept(next.getValue())) {
                V vAccess = access(next, it);
                if (z || vAccess != null) {
                    return vAccess;
                }
            }
        }
        return null;
    }

    public final V get(K k) {
        CacheEntry<K, V> cacheEntry;
        if (k == null || (cacheEntry = this.cache.get(k)) == null) {
            return null;
        }
        return access(cacheEntry, null);
    }

    public final int getCapacity() {
        return this.capacity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean put(K k, V v) {
        if (v == null) {
            return false;
        }
        CacheEntry<K, V> cacheEntry = this.cache.get(k);
        if (cacheEntry != null) {
            cacheEntry.remove();
            add(k, v);
            return true;
        }
        if (this.cache.size() < this.capacity) {
            add(k, v);
            return true;
        }
        CacheEntry cacheEntry2 = ((CacheEntry) this.header).after;
        if (!cacheEntry2.isStale(this.expirationThresholdNanos)) {
            return false;
        }
        cacheEntry2.remove();
        this.cache.remove(cacheEntry2.getKey());
        add(k, v);
        notifyEvictionListeners(cacheEntry2.getValue());
        return true;
    }

    public final int remainingCapacity() {
        return Math.max(0, this.capacity - this.cache.size());
    }

    public final V remove(K k, V v) {
        CacheEntry<K, V> cacheEntry;
        if (k == null || (cacheEntry = this.cache.get(k)) == null || cacheEntry.getValue() != v) {
            return null;
        }
        this.cache.remove(k);
        cacheEntry.remove();
        return v;
    }

    public void setEvictingOnReadAccess(boolean z) {
        this.evictOnReadAccess = z;
    }

    public final void setExpirationThreshold(long j, TimeUnit timeUnit) {
        this.expirationThresholdNanos = timeUnit.toNanos(j);
    }

    public void setUpdatingOnReadAccess(boolean z) {
        this.updateOnReadAccess = z;
    }

    public final int size() {
        return this.cache.size();
    }

    public final boolean update(K k) {
        CacheEntry<K, V> cacheEntry;
        if (k == null || (cacheEntry = this.cache.get(k)) == null) {
            return false;
        }
        cacheEntry.recordAccess(this.header);
        return true;
    }

    public final Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        AbstractCollection<V> abstractCollection = new AbstractCollection<V>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUsedCache.2
            @Override // java.util.AbstractCollection, java.util.Collection
            public final boolean add(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public final void clear() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public final boolean contains(final Object obj) {
                return LeastRecentlyUsedCache.this.find(new Predicate<V>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUsedCache.2.1
                    @Override // org.eclipse.californium.elements.util.LeastRecentlyUsedCache.Predicate
                    public boolean accept(V v) {
                        return v.equals(obj);
                    }
                }, false) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public final Iterator<V> iterator() {
                return LeastRecentlyUsedCache.this.valuesIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public final boolean remove(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public final int size() {
                return LeastRecentlyUsedCache.this.cache.size();
            }
        };
        this.values = abstractCollection;
        return abstractCollection;
    }

    public final Iterator<V> valuesIterator() {
        final Iterator<CacheEntry<K, V>> it = this.cache.values().iterator();
        return new Iterator<V>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUsedCache.1
            private boolean hasNextCalled;
            private CacheEntry<K, V> nextEntry;

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (!this.hasNextCalled) {
                    this.nextEntry = null;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CacheEntry<K, V> cacheEntry = (CacheEntry) it.next();
                        if (LeastRecentlyUsedCache.this.access(cacheEntry, it) != null) {
                            this.nextEntry = cacheEntry;
                            break;
                        }
                    }
                    this.hasNextCalled = true;
                }
                return this.nextEntry != null;
            }

            @Override // java.util.Iterator
            public V next() {
                hasNext();
                this.hasNextCalled = false;
                CacheEntry<K, V> cacheEntry = this.nextEntry;
                if (cacheEntry != null) {
                    return (V) ((CacheEntry) cacheEntry).value;
                }
                Types$$ExternalSyntheticBUOutline0.m();
                return null;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public final void setExpirationThreshold(long j) {
        setExpirationThreshold(j, TimeUnit.SECONDS);
    }

    public static class CacheEntry<K, V> {
        private CacheEntry<K, V> after;
        private CacheEntry<K, V> before;
        private final K key;
        private long lastUpdate;
        private final V value;

        private CacheEntry(K k, V v) {
            this.value = v;
            this.key = k;
            this.lastUpdate = ClockUtil.nanoRealtime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addBefore(CacheEntry<K, V> cacheEntry) {
            this.after = cacheEntry;
            CacheEntry<K, V> cacheEntry2 = cacheEntry.before;
            this.before = cacheEntry2;
            cacheEntry2.after = this;
            this.after.before = this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public K getKey() {
            return this.key;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public V getValue() {
            return this.value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isStale(long j) {
            return ClockUtil.nanoRealtime() - this.lastUpdate >= j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recordAccess(CacheEntry<K, V> cacheEntry) {
            remove();
            this.lastUpdate = ClockUtil.nanoRealtime();
            addBefore(cacheEntry);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void remove() {
            CacheEntry<K, V> cacheEntry = this.before;
            cacheEntry.after = this.after;
            this.after.before = cacheEntry;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CacheEntry [key: ");
            sb.append(this.key);
            sb.append(", last access: ");
            return FileInsert$$ExternalSyntheticOutline0.m(this.lastUpdate, "]", sb);
        }

        private CacheEntry() {
            this.key = null;
            this.value = null;
            this.lastUpdate = -1L;
        }
    }

    public final V remove(K k) {
        CacheEntry<K, V> cacheEntryRemove;
        if (k == null || (cacheEntryRemove = this.cache.remove(k)) == null) {
            return null;
        }
        cacheEntryRemove.remove();
        return (V) cacheEntryRemove.getValue();
    }

    public LeastRecentlyUsedCache(int i, long j) {
        this(Math.min(i, 16), i, j);
    }
}
