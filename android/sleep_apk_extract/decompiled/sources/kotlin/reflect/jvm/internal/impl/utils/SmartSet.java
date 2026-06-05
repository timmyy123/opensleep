package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.AbstractMutableSet;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class SmartSet<T> extends AbstractMutableSet<T> {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private Object f103data;
    private int size;

    public static final class ArrayIterator<T> implements Iterator<T>, KMappedMarker {
        private final Iterator<T> arrayIterator;

        public ArrayIterator(T[] tArr) {
            tArr.getClass();
            this.arrayIterator = ArrayIteratorKt.iterator(tArr);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.arrayIterator.next();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> SmartSet<T> create(Collection<? extends T> collection) {
            collection.getClass();
            SmartSet<T> smartSet = new SmartSet<>(null);
            smartSet.addAll(collection);
            return smartSet;
        }

        private Companion() {
        }

        public final <T> SmartSet<T> create() {
            return new SmartSet<>(null);
        }
    }

    public static final class SingletonIterator<T> implements Iterator<T>, KMappedMarker {
        private final T element;
        private boolean hasNext = true;

        public SingletonIterator(T t) {
            this.element = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.hasNext) {
                this.hasNext = false;
                return this.element;
            }
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public /* synthetic */ SmartSet(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        Object obj;
        if (size() == 0) {
            this.f103data = t;
        } else if (size() != 1) {
            int size = size();
            Object obj2 = this.f103data;
            if (size < 5) {
                obj2.getClass();
                Object[] objArr = (Object[]) obj2;
                if (ArraysKt.contains(objArr, t)) {
                    return false;
                }
                if (size() == 4) {
                    LinkedHashSet linkedHashSetLinkedSetOf = SetsKt.linkedSetOf(Arrays.copyOf(objArr, objArr.length));
                    linkedHashSetLinkedSetOf.add(t);
                    obj = linkedHashSetLinkedSetOf;
                } else {
                    Object[] objArrCopyOf = Arrays.copyOf(objArr, size() + 1);
                    objArrCopyOf[objArrCopyOf.length - 1] = t;
                    obj = objArrCopyOf;
                }
                this.f103data = obj;
            } else {
                obj2.getClass();
                if (!TypeIntrinsics.asMutableSet(obj2).add(t)) {
                    return false;
                }
            }
        } else {
            if (Intrinsics.areEqual(this.f103data, t)) {
                return false;
            }
            this.f103data = new Object[]{this.f103data, t};
        }
        setSize(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f103data = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return Intrinsics.areEqual(this.f103data, obj);
        }
        int size = size();
        Object obj2 = this.f103data;
        if (size < 5) {
            obj2.getClass();
            return ArraysKt.contains((Object[]) obj2, obj);
        }
        obj2.getClass();
        return ((Set) obj2).contains(obj);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.EMPTY_SET.iterator();
        }
        if (size() == 1) {
            return new SingletonIterator(this.f103data);
        }
        int size = size();
        Object obj = this.f103data;
        if (size < 5) {
            obj.getClass();
            return new ArrayIterator((Object[]) obj);
        }
        obj.getClass();
        return TypeIntrinsics.asMutableSet(obj).iterator();
    }

    public void setSize(int i) {
        this.size = i;
    }

    private SmartSet() {
    }
}
