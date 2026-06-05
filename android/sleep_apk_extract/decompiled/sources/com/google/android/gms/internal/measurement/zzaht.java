package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaht implements Supplier {
    private static final zzaht zza = new zzaht();
    private final Supplier zzb = Suppliers.ofInstance(new zzahv());

    public static boolean zza() {
        return zza.get().zza();
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzahu get() {
        return (zzahu) this.zzb.get();
    }
}
