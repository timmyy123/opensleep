package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
final class zzdk extends zzdh {
    private final zzdn zza;

    public zzdk(zzdn zzdnVar, int i) {
        super(zzdnVar.size(), i);
        this.zza = zzdnVar;
    }

    @Override // com.google.android.gms.internal.serialization.zzdh
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
