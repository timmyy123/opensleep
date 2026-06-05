package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzahe implements Supplier {
    private static final zzahe zza = new zzahe();
    private final Supplier zzb = Suppliers.ofInstance(new zzahg());

    public static String zza() {
        return zza.get().zza();
    }

    public static String zzb() {
        return zza.get().zzb();
    }

    public static String zzc() {
        return zza.get().zzc();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzahf get() {
        return (zzahf) this.zzb.get();
    }
}
