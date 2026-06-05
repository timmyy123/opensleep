package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzibq extends zzibu {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzibq(zzibr zzibrVar) {
        super(zzibrVar.zza);
        Objects.requireNonNull(zzibrVar);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return zza();
    }
}
