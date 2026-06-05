package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzbph implements zzgta {
    static final /* synthetic */ zzbph zza = new zzbph();

    private /* synthetic */ zzbph() {
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* synthetic */ Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        zzbpq zzbpqVar = zzbpp.zza;
        if (!((Boolean) zzbkp.zzi.zze()).booleanValue()) {
            return "failure_click_attok";
        }
        com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "prepareClickUrl.attestation1");
        return "failure_click_attok";
    }
}
