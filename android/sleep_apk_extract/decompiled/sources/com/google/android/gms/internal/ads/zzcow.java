package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
final class zzcow extends zzfdm {
    final zzind zza;
    final zzind zzb;
    final zzind zzc;
    final zzind zzd;
    final zzind zze;
    final zzind zzf;
    final zzind zzg;
    final zzind zzh;
    final zzind zzi;
    final zzind zzj;
    final zzind zzk;
    final zzind zzl;
    final zzind zzm;
    final zzind zzn;
    final zzind zzo;
    final zzind zzp;
    final zzind zzq;
    final zzind zzr;
    final zzind zzs;
    final zzind zzt;
    final zzind zzu;
    final zzind zzv;
    final zzind zzw;
    private final zzfep zzx;
    private final zzcox zzy;

    public zzcow(zzcox zzcoxVar, zzfep zzfepVar) {
        this.zzy = zzcoxVar;
        this.zzx = zzfepVar;
        zzfeq zzfeqVarZzc = zzfeq.zzc(zzfepVar);
        this.zza = zzfeqVarZzc;
        this.zzb = zzfeh.zzc(zzcrh.zza, zzfoa.zza(), zzfeqVarZzc);
        zzcrk zzcrkVar = zzcrj.zza;
        zzind zzindVar = zzcoxVar.zzc;
        zzind zzindVar2 = zzcoxVar.zzf;
        this.zzc = zzfeo.zzc(zzcrkVar, zzindVar, zzindVar2);
        zzfer zzferVarZzc = zzfer.zzc(zzfepVar);
        this.zzd = zzferVarZzc;
        zzfes zzfesVarZzc = zzfes.zzc(zzfepVar);
        this.zze = zzfesVarZzc;
        zzfet zzfetVarZzc = zzfet.zzc(zzfepVar);
        this.zzf = zzfetVarZzc;
        this.zzg = zzfdl.zzc(zzcrl.zza, zzindVar2, zzindVar, zzfoa.zza(), zzferVarZzc, zzfesVarZzc, zzfetVarZzc);
        this.zzh = zzfff.zza(zzfoa.zza());
        this.zzi = zzfdz.zzc(zzcrf.zza, zzfoa.zza(), zzindVar2);
        zzcre zzcreVar = zzcrd.zza;
        zzind zzindVar3 = zzcoxVar.zzU;
        this.zzj = zzfdv.zzc(zzfeqVarZzc, zzcreVar, zzindVar3, zzindVar, zzfoa.zza());
        zzfev zzfevVarZzc = zzfev.zzc(zzfepVar);
        this.zzk = zzfevVarZzc;
        this.zzl = zzffb.zzc(zzindVar3, zzfetVarZzc, zzcrn.zza, zzfoa.zza(), zzfeqVarZzc, zzindVar, zzfevVarZzc);
        this.zzm = zzimt.zza(zzfqh.zza(zzcoxVar.zzG));
        zzfeu zzfeuVarZzc = zzfeu.zzc(zzfepVar);
        this.zzn = zzfeuVarZzc;
        zzind zzindVarZza = zzimt.zza(zzdyg.zza());
        this.zzo = zzindVarZza;
        zzind zzindVarZza2 = zzimt.zza(zzdye.zza());
        this.zzp = zzindVarZza2;
        zzind zzindVarZza3 = zzimt.zza(zzdyi.zza());
        this.zzq = zzindVarZza3;
        zzind zzindVarZza4 = zzimt.zza(zzdyk.zza());
        this.zzr = zzindVarZza4;
        zzimx zzimxVarZzc = zzimy.zzc(4);
        zzimxVarZzc.zzb(zzfpe.GMS_SIGNALS, zzindVarZza);
        zzimxVarZzc.zzb(zzfpe.BUILD_URL, zzindVarZza2);
        zzimxVarZzc.zzb(zzfpe.HTTP, zzindVarZza3);
        zzimxVarZzc.zzb(zzfpe.PRE_PROCESS, zzindVarZza4);
        zzimy zzimyVarZzc = zzimxVarZzc.zzc();
        this.zzs = zzimyVarZzc;
        zzind zzindVarZza5 = zzimt.zza(zzdyl.zza(zzfeuVarZzc, zzcoxVar.zzf, zzfoa.zza(), zzimyVarZzc));
        this.zzt = zzindVarZza5;
        zzinf zzinfVarZza = zzing.zza(0, 1);
        zzinfVarZza.zzb(zzindVarZza5);
        zzing zzingVarZzc = zzinfVarZza.zzc();
        this.zzu = zzingVarZzc;
        zzfpn zzfpnVarZzc = zzfpn.zzc(zzingVarZzc);
        this.zzv = zzfpnVarZzc;
        this.zzw = zzimt.zza(zzfpm.zza(zzfoa.zza(), zzcoxVar.zzc, zzfpnVarZzc));
    }

    public final zzfej zza() {
        zzfep zzfepVar = this.zzx;
        zzbia zzbiaVarZza = zzcrb.zza();
        zzhcg zzhcgVarZzc = zzfoa.zzc();
        List listZzd = zzfepVar.zzd();
        zzinc.zzb(listZzd);
        return new zzfej(zzbiaVarZza, zzhcgVarZzc, listZzd);
    }

    public final zzfdp zzb() {
        zzfep zzfepVar = this.zzx;
        return new zzfdp(zzcrm.zza(), zzfoa.zzc(), zzfepVar.zzb(), zzfepVar.zzc(), zzfepVar.zzf());
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final zzfcn zzc() {
        zzind zzindVar = this.zzb;
        zzcox zzcoxVar = this.zzy;
        Context contextZzd = zzcns.zzd(zzcoxVar.zzI());
        zzhcg zzhcgVarZzc = zzfoa.zzc();
        zzfef zzfefVarZzb = ((zzfeh) zzindVar).zzb();
        zzind zzindVar2 = zzcoxVar.zzc;
        return new zzfcn(contextZzd, zzhcgVarZzc, zzgww.zzn(new zzfaw(zzfefVarZzb, 0L, (ScheduledExecutorService) zzindVar2.zzb()), new zzfaw(((zzfeo) this.zzc).zzb(), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfe)).longValue(), (ScheduledExecutorService) zzindVar2.zzb()), new zzfaw(((zzfdl) this.zzg).zzb(), 0L, (ScheduledExecutorService) zzindVar2.zzb()), new zzfaw(zzfff.zzc(), 0L, (ScheduledExecutorService) zzindVar2.zzb()), ((zzfdz) this.zzi).zzb(), zza(), zzb(), (zzfck) zzcoxVar.zzbD.zzb(), ((zzfdv) this.zzj).zzb(), ((zzffb) this.zzl).zzb()), (zzfqg) this.zzm.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final zzfcn zzd() {
        zzind zzindVar = this.zzm;
        zzind zzindVar2 = this.zzj;
        zzind zzindVar3 = this.zzl;
        zzind zzindVar4 = this.zzh;
        zzind zzindVar5 = this.zzc;
        zzind zzindVar6 = this.zzb;
        zzind zzindVar7 = this.zzi;
        zzind zzindVar8 = this.zzg;
        zzcox zzcoxVar = this.zzy;
        return zzfew.zza(zzcns.zzd(zzcoxVar.zzI()), zzcri.zza(), zzcro.zza(), zzcoxVar.zzbD.zzb(), zzb(), zza(), zzimt.zzc(zzindVar8), zzimt.zzc(zzindVar7), zzimt.zzc(zzindVar6), zzimt.zzc(zzindVar5), zzimt.zzc(zzindVar4), zzimt.zzc(zzindVar3), zzimt.zzc(zzindVar2), zzfoa.zzc(), (zzfqg) zzindVar.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final zzfpk zze() {
        return (zzfpk) this.zzw.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final zzfqg zzf() {
        return (zzfqg) this.zzm.zzb();
    }
}
