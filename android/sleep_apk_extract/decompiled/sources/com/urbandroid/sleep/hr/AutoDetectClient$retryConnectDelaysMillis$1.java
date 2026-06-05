package com.urbandroid.sleep.hr;

import com.urbandroid.common.Utils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0005\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u00020\bH\u0096\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"com/urbandroid/sleep/hr/AutoDetectClient$retryConnectDelaysMillis$1", "", "", "count", "", "next", "()Ljava/lang/Long;", "hasNext", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AutoDetectClient$retryConnectDelaysMillis$1 implements Iterator<Long>, KMappedMarker {
    private int count;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Long next() {
        int i = this.count;
        this.count = i + 1;
        return Long.valueOf(i == 0 ? 0L : (1 > i || i >= 4) ? (4 > i || i >= 11) ? (11 > i || i >= 21) ? Utils.getMinutesInMillis(1) : Utils.getSecondsInMillis(30) : Utils.getSecondsInMillis(10) : Utils.getSecondsInMillis(1));
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
