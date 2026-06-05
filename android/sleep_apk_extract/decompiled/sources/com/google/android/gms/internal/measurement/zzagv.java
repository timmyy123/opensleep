package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzagv implements Supplier {
    private static final zzagv zza = new zzagv();
    private final Supplier zzb = Suppliers.ofInstance(new zzagx());

    public static long zza() {
        return zza.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagw get() {
        return (zzagw) this.zzb.get();
    }
}
