package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
final class zzdt extends zzdq {
    private final zzdv zza;

    public zzdt(zzdv zzdvVar, int i) {
        super(zzdvVar.size(), i);
        this.zza = zzdvVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdq
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
