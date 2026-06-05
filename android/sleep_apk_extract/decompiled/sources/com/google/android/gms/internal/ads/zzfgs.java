package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfgs implements zzets {
    private final Context zza;
    private final Executor zzb;
    private final zzcnj zzc;
    private final zzetc zzd;
    private final zzetg zze;
    private final ViewGroup zzf;
    private zzbjl zzg;
    private final zzdfs zzh;
    private final zzfqj zzi;
    private final zzdhx zzj;
    private final zzfkx zzk;
    private ListenableFuture zzl;
    private boolean zzm;
    private com.google.android.gms.ads.internal.client.zze zzn;
    private zzetr zzo;

    public zzfgs(Context context, Executor executor, com.google.android.gms.ads.internal.client.zzr zzrVar, zzcnj zzcnjVar, zzetc zzetcVar, zzetg zzetgVar, zzfkx zzfkxVar, zzdhx zzdhxVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcnjVar;
        this.zzd = zzetcVar;
        this.zze = zzetgVar;
        this.zzk = zzfkxVar;
        this.zzh = zzcnjVar.zzd();
        this.zzi = zzcnjVar.zzx();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdhxVar;
        zzfkxVar.zzc(zzrVar);
        this.zzm = true;
        this.zzn = null;
        this.zzo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
    public final void zzn() {
        this.zzl = null;
        final com.google.android.gms.ads.internal.client.zze zzeVar = this.zzn;
        this.zzn = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzju)).booleanValue() && zzeVar != null) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzm(zzeVar);
                }
            });
        }
        zzetr zzetrVar = this.zzo;
        if (zzetrVar != null) {
            zzetrVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzets
    public final boolean zza(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzetq zzetqVar, zzetr zzetrVar) {
        zzcwq zzcwqVarZza;
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzl();
                }
            });
            return false;
        }
        if (!zzb()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdi)).booleanValue()) {
                com.google.android.gms.ads.internal.client.zzay.zzc();
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzko)).booleanValue() && zzmVar.zzf) {
                this.zzc.zzw().zzc(true);
            }
            Bundle bundleZza = zzdyw.zza(new Pair(zzdyu.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz)), new Pair(zzdyu.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis())));
            zzfkx zzfkxVar = this.zzk;
            zzfkxVar.zzg(str);
            zzfkxVar.zza(zzmVar);
            zzfkxVar.zzv(bundleZza);
            Context context = this.zza;
            zzfky zzfkyVarZzB = zzfkxVar.zzB();
            zzfpw zzfpwVarZzo = zzfpw.zzo(context, zzfqf.zzg(zzfkyVarZzB), 3, zzmVar);
            zzfqg zzfqgVarZze = null;
            if (!((Boolean) zzbkw.zze.zze()).booleanValue() || !zzfkxVar.zzf().zzk) {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzju)).booleanValue();
                zzcnj zzcnjVar = this.zzc;
                if (zBooleanValue) {
                    zzcwp zzcwpVarZzi = zzcnjVar.zzi();
                    zzdca zzdcaVar = new zzdca();
                    zzdcaVar.zza(context);
                    zzdcaVar.zzb(zzfkyVarZzB);
                    zzcwpVarZzi.zzl(zzdcaVar.zze());
                    zzdiq zzdiqVar = new zzdiq();
                    zzetc zzetcVar = this.zzd;
                    Executor executor = this.zzb;
                    zzdiqVar.zzm(zzetcVar, executor);
                    zzdiqVar.zze(zzetcVar, executor);
                    zzcwpVarZzi.zzm(zzdiqVar.zzn());
                    zzcwpVarZzi.zzk(new zzeri(this.zzg));
                    zzcwpVarZzi.zzd(new zzdnx(zzdqd.zza, null));
                    zzcwpVarZzi.zzg(new zzcxl(this.zzh, this.zzj));
                    zzcwpVarZzi.zze(new zzcvi(this.zzf));
                    zzcwqVarZza = zzcwpVarZzi.zzh();
                } else {
                    zzcwp zzcwpVarZzi2 = zzcnjVar.zzi();
                    zzdca zzdcaVar2 = new zzdca();
                    zzdcaVar2.zza(context);
                    zzdcaVar2.zzb(zzfkyVarZzB);
                    zzcwpVarZzi2.zzl(zzdcaVar2.zze());
                    zzdiq zzdiqVar2 = new zzdiq();
                    zzetc zzetcVar2 = this.zzd;
                    Executor executor2 = this.zzb;
                    zzdiqVar2.zzm(zzetcVar2, executor2);
                    zzdiqVar2.zzf(zzetcVar2, executor2);
                    zzdiqVar2.zzf(this.zze, executor2);
                    zzdiqVar2.zzg(zzetcVar2, executor2);
                    zzdiqVar2.zzh(zzetcVar2, executor2);
                    zzdiqVar2.zza(zzetcVar2, executor2);
                    zzdiqVar2.zzb(zzetcVar2, executor2);
                    zzdiqVar2.zzc(zzetcVar2, executor2);
                    zzdiqVar2.zze(zzetcVar2, executor2);
                    zzdiqVar2.zzk(zzetcVar2, executor2);
                    zzcwpVarZzi2.zzm(zzdiqVar2.zzn());
                    zzcwpVarZzi2.zzk(new zzeri(this.zzg));
                    zzcwpVarZzi2.zzd(new zzdnx(zzdqd.zza, null));
                    zzcwpVarZzi2.zzg(new zzcxl(this.zzh, this.zzj));
                    zzcwpVarZzi2.zze(new zzcvi(this.zzf));
                    zzcwqVarZza = zzcwpVarZzi2.zzh();
                }
                if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
                    zzfqgVarZze = zzcwqVarZza.zze();
                    zzfqgVarZze.zzi(3);
                    zzfqgVarZze.zzc(zzmVar.zzp);
                    zzfqgVarZze.zzd(zzmVar.zzm);
                }
                this.zzo = zzetrVar;
                zzcyx zzcyxVarZzc = zzcwqVarZza.zzc();
                ListenableFuture listenableFutureZzc = zzcyxVarZzc.zzc(zzcyxVarZzc.zzb());
                this.zzl = listenableFutureZzc;
                zzhbw.zzr(listenableFutureZzc, new zzfgo(this, zzfqgVarZze, zzfpwVarZzo, zzcwqVarZza), this.zzb);
                return true;
            }
            zzetc zzetcVar3 = this.zzd;
            if (zzetcVar3 != null) {
                zzetcVar3.zzdJ(zzfma.zzd(7, null, null));
            }
        } else if (!this.zzk.zzC()) {
            this.zzm = true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzets
    public final boolean zzb() {
        ListenableFuture listenableFuture = this.zzl;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzc() {
        synchronized (this) {
            try {
                ListenableFuture listenableFuture = this.zzl;
                if (listenableFuture != null && listenableFuture.isDone()) {
                    try {
                        zzcvl zzcvlVar = (zzcvl) this.zzl.get();
                        this.zzl = null;
                        ViewGroup viewGroup = this.zzf;
                        viewGroup.removeAllViews();
                        zzcvlVar.zza();
                        ViewParent parent = zzcvlVar.zza().getParent();
                        if (parent instanceof ViewGroup) {
                            String strZze = zzcvlVar.zzn() != null ? zzcvlVar.zzn().zze() : "";
                            StringBuilder sb = new StringBuilder(String.valueOf(strZze).length() + 78);
                            sb.append("Banner view provided from ");
                            sb.append(strZze);
                            sb.append(" already has a parent view. Removing its old parent.");
                            String string = sb.toString();
                            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
                            ((ViewGroup) parent).removeView(zzcvlVar.zza());
                        }
                        zzbih zzbihVar = zzbiq.zzju;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
                            zzdgh zzdghVarZzq = zzcvlVar.zzq();
                            zzdghVarZzq.zza(this.zzd);
                            zzdghVarZzq.zzb(this.zze);
                        }
                        viewGroup.addView(zzcvlVar.zza());
                        zzetr zzetrVar = this.zzo;
                        if (zzetrVar != null) {
                            zzetrVar.zzb(zzcvlVar);
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
                            Executor executor = this.zzb;
                            final zzetc zzetcVar = this.zzd;
                            Objects.requireNonNull(zzetcVar);
                            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgr
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    zzetcVar.zzg();
                                }
                            });
                        }
                        if (zzcvlVar.zzh() >= 0) {
                            this.zzm = false;
                            zzdfs zzdfsVar = this.zzh;
                            zzdfsVar.zzd(zzcvlVar.zzh());
                            zzdfsVar.zze(zzcvlVar.zzg());
                        } else {
                            this.zzm = true;
                            this.zzh.zzd(zzcvlVar.zzg());
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        zzn();
                        com.google.android.gms.ads.internal.util.zze.zzb("Error occurred while refreshing the ad. Making a new ad request.", e);
                        this.zzm = true;
                        this.zzh.zzc();
                    } catch (ExecutionException e2) {
                        e = e2;
                        zzn();
                        com.google.android.gms.ads.internal.util.zze.zzb("Error occurred while refreshing the ad. Making a new ad request.", e);
                        this.zzm = true;
                        this.zzh.zzc();
                    }
                } else if (this.zzl != null) {
                    com.google.android.gms.ads.internal.util.zze.zza("Show timer went off but there is an ongoing ad request.");
                    this.zzm = true;
                } else {
                    com.google.android.gms.ads.internal.util.zze.zza("No ad request was in progress or an ad was cached when show timer went off. Hence requesting a new ad.");
                    this.zzm = true;
                    this.zzh.zzc();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ViewGroup zzd() {
        return this.zzf;
    }

    public final void zze(zzbjl zzbjlVar) {
        this.zzg = zzbjlVar;
    }

    public final void zzf(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
        this.zze.zza(zzbeVar);
    }

    public final zzfkx zzg() {
        return this.zzk;
    }

    public final boolean zzh() {
        Object parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        com.google.android.gms.ads.internal.zzt.zzc();
        return com.google.android.gms.ads.internal.util.zzs.zzab(view, view.getContext());
    }

    public final void zzi(zzdfn zzdfnVar) {
        this.zzh.zzq(zzdfnVar, this.zzb);
    }

    public final void zzj() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzk() {
        this.zzh.zze(this.zzj.zzd());
    }

    public final /* synthetic */ void zzl() {
        this.zzd.zzdJ(zzfma.zzd(6, null, null));
    }

    public final /* synthetic */ void zzm(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zzd.zzdJ(zzeVar);
    }

    public final /* synthetic */ zzdfs zzo() {
        return this.zzh;
    }

    public final /* synthetic */ zzfqj zzp() {
        return this.zzi;
    }

    public final /* synthetic */ zzdhx zzq() {
        return this.zzj;
    }

    public final /* synthetic */ boolean zzr() {
        return this.zzm;
    }

    public final /* synthetic */ void zzs(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zzn = zzeVar;
    }
}
