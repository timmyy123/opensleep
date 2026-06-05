package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
final class zzeqb implements zzdno {
    private final Context zza;
    private final zzdwi zzb;
    private final zzfky zzc;
    private final VersionInfoParcel zzd;
    private final zzfkf zze;
    private final ListenableFuture zzf;
    private final zzcku zzg;
    private final zzbpt zzh;
    private final boolean zzi;
    private final zzekr zzj;
    private final zzdzg zzk;
    private final zzdzl zzl;

    public zzeqb(Context context, zzdwi zzdwiVar, zzfky zzfkyVar, VersionInfoParcel versionInfoParcel, zzfkf zzfkfVar, ListenableFuture listenableFuture, zzcku zzckuVar, zzbpt zzbptVar, boolean z, zzekr zzekrVar, zzdzg zzdzgVar, zzdzl zzdzlVar) {
        this.zza = context;
        this.zzb = zzdwiVar;
        this.zzc = zzfkyVar;
        this.zzd = versionInfoParcel;
        this.zze = zzfkfVar;
        this.zzf = listenableFuture;
        this.zzg = zzckuVar;
        this.zzh = zzbptVar;
        this.zzi = z;
        this.zzj = zzekrVar;
        this.zzk = zzdzgVar;
        this.zzl = zzdzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final void zza(boolean z, Context context, zzdde zzddeVar) {
        boolean z2;
        zzdvn zzdvnVar = (zzdvn) zzhbw.zzt(this.zzf);
        try {
            zzfkf zzfkfVar = this.zze;
            final zzcku zzckuVarZza = this.zzg;
            if (zzckuVarZza.zzaB()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzby)).booleanValue()) {
                    zzckuVarZza = this.zzb.zza(this.zzc.zzf, null, null);
                    zzbqj.zzb(zzckuVarZza, zzdvnVar.zzk());
                    final zzdwm zzdwmVar = new zzdwm();
                    zzdvnVar.zzl().zzi(zzckuVarZza, true, this.zzi ? this.zzh : null, this.zzk);
                    zzckuVarZza.zzP().zzG(new zzcmq(zzdwmVar, zzckuVarZza) { // from class: com.google.android.gms.internal.ads.zzeqa
                        private final /* synthetic */ zzcku zza;

                        {
                            this.zza = zzckuVarZza;
                        }

                        @Override // com.google.android.gms.internal.ads.zzcmq
                        public final /* synthetic */ void zza(boolean z3, int i, String str, String str2) {
                            zzcku zzckuVar = this.zza;
                            zzckuVar.zzJ();
                            zzckuVar.zzP().zzq();
                        }
                    });
                    zzckuVarZza.zzP().zzH(new zzcmr() { // from class: com.google.android.gms.internal.ads.zzepz
                        @Override // com.google.android.gms.internal.ads.zzcmr
                        public final /* synthetic */ void zza() {
                            zzckuVarZza.zzI();
                        }
                    });
                    zzfkk zzfkkVar = zzfkfVar.zzs;
                    zzckuVarZza.zzau(zzfkkVar.zzb, zzfkkVar.zza, null);
                }
            }
            zzcku zzckuVar = zzckuVarZza;
            zzckuVar.zzag(true);
            boolean z3 = this.zzi;
            boolean z4 = false;
            boolean zZzc = z3 ? this.zzh.zzc(false) : false;
            com.google.android.gms.ads.internal.zzt.zzc();
            boolean zZzL = com.google.android.gms.ads.internal.util.zzs.zzL(this.zza);
            if (!z3) {
                z2 = z4;
            } else if (this.zzh.zzd()) {
                z4 = true;
                z2 = z4;
            } else {
                z2 = false;
                z4 = true;
            }
            float fZze = z4 ? this.zzh.zze() : 0.0f;
            zzfkf zzfkfVar2 = this.zze;
            com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZzc, zZzL, z2, fZze, -1, z, zzfkfVar2.zzO, zzfkfVar2.zzP);
            if (zzddeVar != null) {
                zzddeVar.zzb();
            }
            com.google.android.gms.ads.internal.zzt.zzb();
            zzdnd zzdndVarZzj = zzdvnVar.zzj();
            int i = zzfkfVar2.zzQ;
            VersionInfoParcel versionInfoParcel = this.zzd;
            String str = zzfkfVar2.zzB;
            zzfkk zzfkkVar2 = zzfkfVar2.zzs;
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(null, zzdndVarZzj, null, zzckuVar, i, versionInfoParcel, str, zzlVar, zzfkkVar2.zzb, zzfkkVar2.zza, this.zzc.zzg, zzddeVar, zzfkfVar2.zzb() ? this.zzj : null, zzckuVar.zzn()), true, this.zzl);
        } catch (zzclj e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zze;
    }
}
