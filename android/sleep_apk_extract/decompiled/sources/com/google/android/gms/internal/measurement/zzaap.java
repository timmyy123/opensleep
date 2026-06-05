package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
final class zzaap extends zzaat {
    private static final zzaap zza = new zzaap(zzaat.zze());
    private final AtomicReference zzb;

    public zzaap(zzaat zzaatVar) {
        this.zzb = new AtomicReference(zzaatVar);
    }

    public static final zzaap zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaat
    public final boolean zzb(String str, Level level, boolean z) {
        ((zzaat) this.zzb.get()).zzb(str, level, z);
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzaat
    public final zzabe zzc() {
        return ((zzaat) this.zzb.get()).zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzaat
    public final zzzj zzd() {
        return ((zzaat) this.zzb.get()).zzd();
    }
}
