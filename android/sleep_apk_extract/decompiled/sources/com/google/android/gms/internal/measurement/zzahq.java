package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzahq implements Supplier {
    private static final zzahq zza = new zzahq();
    private final Supplier zzb = Suppliers.ofInstance(new zzahs());

    public static boolean zza() {
        return zza.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahr get() {
        return (zzahr) this.zzb.get();
    }
}
