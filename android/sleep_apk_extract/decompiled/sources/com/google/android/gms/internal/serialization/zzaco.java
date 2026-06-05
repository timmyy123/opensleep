package com.google.android.gms.internal.serialization;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0003J\u000e\u0010\b\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/protobuf/kotlin/UnmodifiableIterator;", "E", "", "delegate", "<init>", "(Ljava/util/Iterator;)V", "hasNext", "", "next", "()Ljava/lang/Object;", "third_party.kotlin.protobuf.src.commonMain.kotlin.com.google.protobuf.kotlin_shared_runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzaco implements Iterator, KMappedMarker {
    private final /* synthetic */ Iterator zza;

    public zzaco(Iterator it) {
        it.getClass();
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
