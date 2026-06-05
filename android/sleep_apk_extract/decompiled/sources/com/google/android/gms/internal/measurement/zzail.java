package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzail implements Supplier {
    private static final zzail zza = new zzail();
    private final Supplier zzb = Suppliers.ofInstance(new zzain());

    public static boolean zza() {
        return zza.get().zza();
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzaim get() {
        return (zzaim) this.zzb.get();
    }
}
