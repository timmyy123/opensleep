package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzahz implements Supplier {
    private static final zzahz zza = new zzahz();
    private final Supplier zzb = Suppliers.ofInstance(new zzaib());

    public static boolean zza() {
        return zza.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaia get() {
        return (zzaia) this.zzb.get();
    }
}
