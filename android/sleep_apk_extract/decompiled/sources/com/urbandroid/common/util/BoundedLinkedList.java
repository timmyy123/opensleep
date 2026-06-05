package com.urbandroid.common.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class BoundedLinkedList<E> implements Serializable, Cloneable, Iterable<E>, Collection<E>, List<E> {
    private int capacity;
    private LinkedList<E> nestedList = new LinkedList<>();

    public BoundedLinkedList(int i) {
        if (i >= 1) {
            this.capacity = i;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Capacity must be larger than 0.");
            throw null;
        }
    }

    private boolean trimFromBeginningToFit() {
        int size = this.nestedList.size() - this.capacity;
        boolean z = false;
        while (size > 0) {
            removeFirst();
            size--;
            z = true;
        }
        return z;
    }

    @Override // java.util.Collection, java.util.List
    public boolean add(E e) {
        return trimFromBeginningToFit() || this.nestedList.add(e);
    }

    @Override // java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        return trimFromBeginningToFit() || this.nestedList.addAll(collection);
    }

    public void addFirst(E e) {
        this.nestedList.addFirst(e);
        trimFromBeginningToFit();
    }

    public void addLast(E e) {
        this.nestedList.addLast(e);
        trimFromBeginningToFit();
    }

    @Override // java.util.Collection, java.util.List
    public void clear() {
        this.nestedList.clear();
    }

    public Object clone() {
        return this.nestedList.clone();
    }

    @Override // java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.nestedList.contains(obj);
    }

    @Override // java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        return this.nestedList.containsAll(collection);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return this.nestedList.equals(obj);
    }

    @Override // java.util.List
    public E get(int i) {
        return this.nestedList.get(i);
    }

    public E getFirst() {
        return this.nestedList.getFirst();
    }

    public E getLast() {
        return this.nestedList.getLast();
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return this.nestedList.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.nestedList.indexOf(obj);
    }

    @Override // java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.nestedList.isEmpty();
    }

    @Override // java.lang.Iterable, java.util.Collection, java.util.List
    public Iterator<E> iterator() {
        return this.nestedList.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.nestedList.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return this.nestedList.listIterator();
    }

    @Override // java.util.List
    public E remove(int i) {
        return this.nestedList.remove(i);
    }

    @Override // java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        return this.nestedList.removeAll(collection);
    }

    public E removeFirst() {
        return this.nestedList.removeFirst();
    }

    public E removeLast() {
        return this.nestedList.removeLast();
    }

    @Override // java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        return this.nestedList.retainAll(collection);
    }

    @Override // java.util.List
    public E set(int i, E e) {
        return this.nestedList.set(i, e);
    }

    @Override // java.util.Collection, java.util.List
    public int size() {
        return this.nestedList.size();
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return this.nestedList.subList(i, i2);
    }

    @Override // java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.nestedList.toArray();
    }

    public String toString() {
        return this.nestedList.toString();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return this.nestedList.listIterator(i);
    }

    @Override // java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        return this.nestedList.remove(obj);
    }

    @Override // java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.nestedList.toArray(tArr);
    }

    @Override // java.util.List
    public void add(int i, E e) {
        this.nestedList.add(i, e);
        trimFromBeginningToFit();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        return trimFromBeginningToFit() || this.nestedList.addAll(i, collection);
    }
}
