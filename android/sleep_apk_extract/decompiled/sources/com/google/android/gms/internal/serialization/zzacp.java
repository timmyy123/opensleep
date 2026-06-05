package com.google.android.gms.internal.serialization;

import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0003J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u000e\u0010\t\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u000e\u0010\r\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\nJ\t\u0010\u000e\u001a\u00020\fH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/google/protobuf/kotlin/UnmodifiableListIterator;", "E", "", "delegate", "<init>", "(Ljava/util/ListIterator;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "", "previous", "previousIndex", "third_party.kotlin.protobuf.src.commonMain.kotlin.com.google.protobuf.kotlin_shared_runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzacp implements ListIterator, KMappedMarker {
    private final /* synthetic */ ListIterator zza;

    public zzacp(ListIterator listIterator) {
        listIterator.getClass();
        this.zza = listIterator;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.zza.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return this.zza.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
