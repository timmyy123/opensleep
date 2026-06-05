package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* JADX INFO: loaded from: classes4.dex */
public final class zzaif implements Supplier {
    private static final zzaif zza = new zzaif();
    private final Supplier zzb = Suppliers.ofInstance(new zzaih());

    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    public static boolean zzc() {
        return zza.get().zzc();
    }

    public static boolean zzd() {
        return zza.get().zzd();
    }

    public static boolean zze() {
        return zza.get().zze();
    }

    public static boolean zzf() {
        return zza.get().zzf();
    }

    public static boolean zzg() {
        return zza.get().zzg();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzaig get() {
        return (zzaig) this.zzb.get();
    }
}
