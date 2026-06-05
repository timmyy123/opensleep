package com.google.android.gms.internal.serialization;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0017\b\u0007\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096\u0001J\u0016\u0010\u001b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\rH\u0096\u0003¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u000fH\u0096\u0001J\u0016\u0010 \u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001eJ\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH\u0096\u0001R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/google/protobuf/kotlin/DslList;", "E", "P", "Lcom/google/protobuf/kotlin/DslProxy;", "", "delegate", "<init>", "(Ljava/util/List;)V", "iterator", "", "listIterator", "", "index", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "lastIndexOf", "subList", "fromIndex", "toIndex", "size", "getSize", "()I", "third_party.kotlin.protobuf.src.commonMain.kotlin.com.google.protobuf.kotlin_shared_runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzack<E, P> implements List<E>, KMappedMarker {
    private final List zza;

    public zzack(List list) {
        list.getClass();
        this.zza = list;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object element) {
        return this.zza.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection elements) {
        elements.getClass();
        return this.zza.containsAll(elements);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object other) {
        return Intrinsics.areEqual(this.zza, other);
    }

    @Override // java.util.List
    public final Object get(int index) {
        return this.zza.get(index);
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object element) {
        return this.zza.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new zzaco(this.zza.iterator());
    }

    @Override // java.util.List
    public final int lastIndexOf(Object element) {
        return this.zza.lastIndexOf(element);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new zzacp(this.zza.listIterator());
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return this.zza.size();
    }

    @Override // java.util.List
    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List subList(int fromIndex, int toIndex) {
        return this.zza.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        return CollectionToArray.toArray(this, objArr);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int index) {
        return new zzacp(this.zza.listIterator(index));
    }
}
