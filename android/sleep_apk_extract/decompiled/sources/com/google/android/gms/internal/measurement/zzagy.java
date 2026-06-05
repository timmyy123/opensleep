package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes3.dex */
public final class zzagy implements Supplier {
    private static final zzagy zza = new zzagy();
    private final Supplier zzb = Suppliers.ofInstance(new zzaha());

    public static boolean zza() {
        return zza.get().zza();
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzagz get() {
        return (zzagz) this.zzb.get();
    }
}
