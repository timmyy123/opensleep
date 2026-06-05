package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaix implements Supplier {
    private static final zzaix zza = new zzaix();
    private final Supplier zzb = Suppliers.ofInstance(new zzaiz());

    public static boolean zza() {
        return zza.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaiy get() {
        return (zzaiy) this.zzb.get();
    }
}
