package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaja implements Supplier {
    private static final zzaja zza = new zzaja();
    private final Supplier zzb = Suppliers.ofInstance(new zzajc());

    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzajb get() {
        return (zzajb) this.zzb.get();
    }
}
