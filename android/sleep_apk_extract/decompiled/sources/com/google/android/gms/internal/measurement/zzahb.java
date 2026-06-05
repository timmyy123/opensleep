package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzahb implements Supplier {
    private static final zzahb zza = new zzahb();
    private final Supplier zzb = Suppliers.ofInstance(new zzahd());

    public static boolean zza() {
        return zza.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahc get() {
        return (zzahc) this.zzb.get();
    }
}
