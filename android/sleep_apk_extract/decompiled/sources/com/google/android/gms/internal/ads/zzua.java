package com.google.android.gms.internal.ads;

import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzua implements Function {
    static final /* synthetic */ zzua zza = new zzua();

    private /* synthetic */ zzua() {
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return new Integer(Integer.bitCount(((Integer) obj).intValue()));
    }
}
