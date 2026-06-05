package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
public final class zzait implements zzais {

    @Deprecated
    public static final zzom zza = zzagr.zzc().zza("measurement.session_stitching_token_enabled", false);

    @Override // com.google.android.gms.internal.measurement.zzais
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzais
    public final boolean zzb() {
        return ((Boolean) zza.get()).booleanValue();
    }
}
