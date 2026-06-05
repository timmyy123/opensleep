package com.fasterxml.jackson.databind.util.internal;

import com.fasterxml.jackson.databind.util.internal.Linked;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class LinkedDeque<E extends Linked<E>> extends AbstractCollection<E> implements Deque<E> {
    E first;
    E last;

    public abstract class AbstractLinkedIterator implements Iterator<E> {
        E cursor;

        public AbstractLinkedIterator(E e) {
            this.cursor = e;
        }

        public abstract E computeNext();

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != null;
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                Types$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            E e = this.cursor;
            this.cursor = (E) computeNext();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Deque
    public void addFirst(E e) {
        if (offerFirst((Linked) e)) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3();
    }

    @Override // java.util.Deque
    public void addLast(E e) {
        if (offerLast((Linked) e)) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3();
    }

    public void checkNotEmpty() {
        if (isEmpty()) {
            Types$$ExternalSyntheticBUOutline0.m();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Linked linked = this.first;
        while (linked != null) {
            Linked next = linked.getNext();
            linked.setPrevious(null);
            linked.setNext(null);
            linked = next;
        }
        this.last = null;
        this.first = null;
    }

    public boolean contains(Linked<?> linked) {
        return (linked.getPrevious() == null && linked.getNext() == null && linked != this.first) ? false : true;
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new LinkedDeque<E>.AbstractLinkedIterator(this.last) { // from class: com.fasterxml.jackson.databind.util.internal.LinkedDeque.2
            @Override // com.fasterxml.jackson.databind.util.internal.LinkedDeque.AbstractLinkedIterator
            public E computeNext() {
                return (E) this.cursor.getPrevious();
            }
        };
    }

    @Override // java.util.Deque
    public E getFirst() {
        checkNotEmpty();
        return (E) peekFirst();
    }

    @Override // java.util.Deque
    public E getLast() {
        checkNotEmpty();
        return (E) peekLast();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Deque
    public Iterator<E> iterator() {
        return new LinkedDeque<E>.AbstractLinkedIterator(this.first) { // from class: com.fasterxml.jackson.databind.util.internal.LinkedDeque.1
            @Override // com.fasterxml.jackson.databind.util.internal.LinkedDeque.AbstractLinkedIterator
            public E computeNext() {
                return (E) this.cursor.getNext();
            }
        };
    }

    public void linkFirst(E e) {
        E e2 = this.first;
        this.first = e;
        if (e2 == null) {
            this.last = e;
        } else {
            e2.setPrevious(e);
            e.setNext(e2);
        }
    }

    public void linkLast(E e) {
        E e2 = this.last;
        this.last = e;
        if (e2 == null) {
            this.first = e;
        } else {
            e2.setNext(e);
            e.setPrevious(e2);
        }
    }

    public void moveToBack(E e) {
        if (e != this.last) {
            unlink(e);
            linkLast(e);
        }
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e) {
        if (contains((Linked<?>) e)) {
            return false;
        }
        linkFirst(e);
        return true;
    }

    @Override // java.util.Deque
    public boolean offerLast(E e) {
        if (contains((Linked<?>) e)) {
            return false;
        }
        linkLast(e);
        return true;
    }

    @Override // java.util.Deque
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        return (E) unlinkFirst();
    }

    @Override // java.util.Deque
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return (E) unlinkLast();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public boolean remove(Object obj) {
        return (obj instanceof Linked) && remove((Linked) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Deque
    public E removeFirst() {
        checkNotEmpty();
        return (E) pollFirst();
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        return remove(obj);
    }

    @Override // java.util.Deque
    public E removeLast() {
        checkNotEmpty();
        return (E) pollLast();
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        return remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public int size() {
        int i = 0;
        for (Linked next = this.first; next != null; next = next.getNext()) {
            i++;
        }
        return i;
    }

    public void unlink(E e) {
        E e2 = (E) e.getPrevious();
        E e3 = (E) e.getNext();
        if (e2 == null) {
            this.first = e3;
        } else {
            e2.setNext(e3);
            e.setPrevious(null);
        }
        if (e3 == null) {
            this.last = e2;
        } else {
            e3.setPrevious(e2);
            e.setNext(null);
        }
    }

    public E unlinkFirst() {
        E e = this.first;
        E e2 = (E) e.getNext();
        e.setNext(null);
        this.first = e2;
        if (e2 == null) {
            this.last = null;
            return e;
        }
        e2.setPrevious(null);
        return e;
    }

    public E unlinkLast() {
        E e = this.last;
        E e2 = (E) e.getPrevious();
        e.setPrevious(null);
        this.last = e2;
        if (e2 == null) {
            this.first = null;
            return e;
        }
        e2.setNext(null);
        return e;
    }

    @Override // java.util.Deque, java.util.Queue
    public E element() {
        return (E) getFirst();
    }

    @Override // java.util.Deque, java.util.Queue
    public E peek() {
        return (E) peekFirst();
    }

    @Override // java.util.Deque
    public E peekFirst() {
        return this.first;
    }

    @Override // java.util.Deque
    public E peekLast() {
        return this.last;
    }

    @Override // java.util.Deque, java.util.Queue
    public E poll() {
        return (E) pollFirst();
    }

    @Override // java.util.Deque
    public E pop() {
        return (E) removeFirst();
    }

    @Override // java.util.Deque
    public void push(E e) {
        addFirst((Linked) e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
    public boolean add(E e) {
        return offerLast((Linked) e);
    }

    @Override // java.util.Deque, java.util.Queue
    public boolean offer(E e) {
        return offerLast((Linked) e);
    }

    @Override // java.util.Deque, java.util.Queue
    public E remove() {
        return (E) removeFirst();
    }

    public boolean remove(E e) {
        if (!contains((Linked<?>) e)) {
            return false;
        }
        unlink(e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public boolean contains(Object obj) {
        return (obj instanceof Linked) && contains((Linked<?>) obj);
    }
}
