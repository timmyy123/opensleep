package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzedx implements zzasa {
    final /* synthetic */ zzedy zza;

    public zzedx(zzedy zzedyVar) {
        Objects.requireNonNull(zzedyVar);
        this.zza = zzedyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasa
    public final void zza(int i) {
        zzasb zzasbVarZzd;
        try {
            zzfqt zzfqtVarZza = zzfqu.zza();
            zzfqtVarZza.zzh(i != 0 ? i != 1 ? i != 2 ? i != 3 ? 7 : 6 : 5 : 4 : 3);
            if (i == 0 && (zzasbVarZzd = this.zza.zzc().zzd()) != null) {
                zzfqtVarZza.zzb(zzasbVarZzd.zzb());
                zzfqtVarZza.zzc(zzasbVarZzd.zzc());
                zzfqtVarZza.zzd(zzasbVarZzd.zzd());
                zzfqtVarZza.zze(zzasbVarZzd.zze());
                zzfqtVarZza.zzf(zzasbVarZzd.zzf());
                if (!TextUtils.isEmpty(zzasbVarZzd.zza())) {
                    zzfqtVarZza.zza(zzasbVarZzd.zza());
                }
                if (!TextUtils.isEmpty(zzasbVarZzd.zzg())) {
                    zzfqtVarZza.zzg(zzasbVarZzd.zzg());
                }
            }
            zzedy zzedyVar = this.zza;
            zzedyVar.zzc().zzc();
            zzdzl zzdzlVarZzd = zzedyVar.zzd();
            String strEncodeToString = Base64.encodeToString(((zzfqu) zzfqtVarZza.zzbm()).zzaN(), 1);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfP)).booleanValue()) {
                zzdzk zzdzkVarZza = zzdzlVarZzd.zza();
                zzdzkVarZza.zzc("action", "irda");
                zzdzkVarZza.zzc("irdd", strEncodeToString);
                zzdzkVarZza.zzf();
            }
            zzedyVar.zze().zzQ(true);
        } catch (Exception e) {
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfQ)).booleanValue();
            zzedy zzedyVar2 = this.zza;
            if (zBooleanValue) {
                if (zzedyVar2.zzb == null) {
                    zzedyVar2.zzb = zzbzy.zzc(zzedyVar2.zzb());
                }
                zzedyVar2.zzb.zzh(e, "InstallReferrerUnsampled.onInstallReferrerSetupFinished");
            } else {
                if (zzedyVar2.zza == null) {
                    zzedyVar2.zza = zzbzy.zza(zzedyVar2.zzb());
                }
                zzedyVar2.zza.zzh(e, "InstallReferrer.onInstallReferrerSetupFinished");
            }
        }
    }
}
