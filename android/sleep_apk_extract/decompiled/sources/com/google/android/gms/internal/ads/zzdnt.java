package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.ads.zzbhv$zza;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdnt implements zzdcr, zzdkd {
    private final zzcdw zza;
    private final Context zzb;
    private final zzcdz zzc;
    private final View zzd;
    private String zze;
    private final zzbhv$zza.zza zzf;
    private final zzfkf zzg;

    public zzdnt(zzcdw zzcdwVar, Context context, zzcdz zzcdzVar, View view, zzbhv$zza.zza zzaVar, zzfkf zzfkfVar) {
        this.zza = zzcdwVar;
        this.zzb = context;
        this.zzc = zzcdzVar;
        this.zzd = view;
        this.zzf = zzaVar;
        this.zzg = zzfkfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    @ParametersAreNonnullByDefault
    public final void zzd(zzcbp zzcbpVar, String str, String str2) {
        zzcdz zzcdzVar = this.zzc;
        Context context = this.zzb;
        if (zzcdzVar.zza(context) && this.zzg.zzaG) {
            try {
                zzcdzVar.zzo(context, zzcdzVar.zzj(context), this.zza.zzb(), zzcbpVar.zzb(), zzcbpVar.zzc());
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Remote Exception to get reward item.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdK() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzds() {
        if (this.zzg.zzaG) {
            this.zza.zza(false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdt() {
        if (this.zzg.zzaG) {
            View view = this.zzd;
            if (view != null && this.zze != null) {
                this.zzc.zzg(view.getContext(), this.zze);
            }
            this.zza.zza(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdkd
    public final void zzg() {
    }

    @Override // com.google.android.gms.internal.ads.zzdkd
    public final void zzh() {
        zzbhv$zza.zza zzaVar = this.zzf;
        if (zzaVar != zzbhv$zza.zza.APP_OPEN && this.zzg.zzaG) {
            String strZzf = this.zzc.zzf(this.zzb);
            this.zze = strZzf;
            this.zze = String.valueOf(strZzf).concat(zzaVar == zzbhv$zza.zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
        }
    }
}
