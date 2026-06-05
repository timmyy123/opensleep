package com.google.android.gms.internal.clearcut;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class zzfc implements Iterator<String> {
    private final /* synthetic */ zzfa zzpe;
    private Iterator<String> zzpf;

    public zzfc(zzfa zzfaVar) {
        this.zzpe = zzfaVar;
        this.zzpf = zzfaVar.zzpb.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzpf.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzpf.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
