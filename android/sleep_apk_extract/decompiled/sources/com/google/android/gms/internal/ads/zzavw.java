package com.google.android.gms.internal.ads;

import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzavw implements Supplier {
    private final /* synthetic */ int zzc;
    public static final /* synthetic */ zzavw zzb = new zzavw(1);
    static final /* synthetic */ zzavw zza = new zzavw(0);

    private /* synthetic */ zzavw(int i) {
        this.zzc = i;
    }

    @Override // java.util.function.Supplier
    public final /* synthetic */ Object get() {
        return this.zzc != 0 ? zzawm.zza(null) : new zzavz();
    }
}
