package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaio implements Supplier {
    private static final zzaio zza = new zzaio();
    private final Supplier zzb = Suppliers.ofInstance(new zzaiq());

    public static boolean zza() {
        return zza.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaip get() {
        return (zzaip) this.zzb.get();
    }
}
