package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfbf implements zzfci {
    private zzgcg zza;
    private zzgcg zzb;
    private boolean zzc;
    private boolean zzd;
    private final boolean zze = false;
    private final boolean zzf;

    public zzfbf(zzgcg zzgcgVar, zzgcg zzgcgVar2, boolean z, boolean z2, boolean z3) {
        this.zza = zzgcgVar;
        this.zzb = zzgcgVar2;
        this.zzc = z;
        this.zzd = z2;
        this.zzf = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // com.google.android.gms.internal.ads.zzfci
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zze) {
            return;
        }
        Bundle bundleZza = zzfln.zza(bundle, "pii");
        boolean z = this.zzf;
        if (!z) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdW)).booleanValue()) {
                if (z) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdY)).booleanValue()) {
                        if (this.zza.zzc()) {
                            bundleZza.putString("paidv1_id_android", this.zza.zza());
                            bundleZza.putLong("paidv1_creation_time_android", this.zza.zzb());
                        }
                    }
                }
            }
        }
        if (!z) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdX)).booleanValue()) {
                if (z) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdZ)).booleanValue()) {
                        if (this.zzb.zzc()) {
                            bundleZza.putString("paidv2_id_android", this.zzb.zza());
                            bundleZza.putLong("paidv2_creation_time_android", this.zzb.zzb());
                        }
                        bundleZza.putBoolean("paidv2_pub_option_android", this.zzc);
                        bundleZza.putBoolean("paidv2_user_option_android", this.zzd);
                    }
                }
            }
        }
        if (bundleZza.isEmpty()) {
            return;
        }
        bundle.putBundle("pii", bundleZza);
    }

    public zzfbf(boolean z) {
        this.zzf = z;
    }
}
