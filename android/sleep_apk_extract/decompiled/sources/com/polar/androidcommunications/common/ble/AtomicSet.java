package com.polar.androidcommunications.common.ble;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class AtomicSet<E> {
    private final List<E> items = new ArrayList();

    public interface CompareFunction<E> {
        boolean compare(E e);
    }

    public interface ObjectAccess<E> {
        void access(E e);
    }

    public synchronized void accessAll(ObjectAccess<E> objectAccess) {
        int size = this.items.size();
        while (true) {
            size--;
            if (size != -1) {
                objectAccess.access(this.items.get(size));
            }
        }
    }

    public synchronized boolean add(E e) {
        if (e != null) {
            if (!this.items.contains(e)) {
                this.items.add(e);
                return true;
            }
        }
        return false;
    }

    public synchronized void clear() {
        this.items.clear();
    }

    public synchronized E fetch(CompareFunction<E> compareFunction) {
        int size = this.items.size();
        do {
            size--;
            if (size == -1) {
                return null;
            }
        } while (!compareFunction.compare(this.items.get(size)));
        return this.items.get(size);
    }

    public synchronized Set<E> objects() {
        return new HashSet(this.items);
    }

    public synchronized void remove(E e) {
        if (e != null) {
            this.items.remove(e);
        }
    }

    public synchronized int size() {
        return this.items.size();
    }
}
