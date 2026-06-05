package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzffn implements zzets {
    protected final zzcnj zza;
    private final Context zzb;
    private final Executor zzc;
    private final zzfge zzd;
    private final zzfhw zze;
    private final VersionInfoParcel zzf;
    private final ViewGroup zzg;
    private final zzfqj zzh;
    private final zzfkx zzi;

    @Nullable
    private ListenableFuture zzj;

    public zzffn(Context context, Executor executor, zzcnj zzcnjVar, zzfhw zzfhwVar, zzfge zzfgeVar, zzfkx zzfkxVar, VersionInfoParcel versionInfoParcel) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcnjVar;
        this.zze = zzfhwVar;
        this.zzd = zzfgeVar;
        this.zzi = zzfkxVar;
        this.zzf = versionInfoParcel;
        this.zzg = new FrameLayout(context);
        this.zzh = zzcnjVar.zzx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized zzdby zzg(zzfhu zzfhuVar) {
        zzffk zzffkVar = (zzffk) zzfhuVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjv)).booleanValue()) {
            zzcvi zzcviVar = new zzcvi(this.zzg);
            zzdca zzdcaVar = new zzdca();
            zzdcaVar.zza(this.zzb);
            zzdcaVar.zzb(zzffkVar.zza);
            zzdcb zzdcbVarZze = zzdcaVar.zze();
            zzdiq zzdiqVar = new zzdiq();
            zzfge zzfgeVar = this.zzd;
            Executor executor = this.zzc;
            zzdiqVar.zzd(zzfgeVar, executor);
            zzdiqVar.zzg(zzfgeVar, executor);
            return zzc(zzcviVar, zzdcbVarZze, zzdiqVar.zzn());
        }
        zzfge zzfgeVarZzn = zzfge.zzn(this.zzd);
        zzdiq zzdiqVar2 = new zzdiq();
        Executor executor2 = this.zzc;
        zzdiqVar2.zzc(zzfgeVarZzn, executor2);
        zzdiqVar2.zzi(zzfgeVarZzn, executor2);
        zzdiqVar2.zzj(zzfgeVarZzn, executor2);
        zzdiqVar2.zzk(zzfgeVarZzn, executor2);
        zzdiqVar2.zzd(zzfgeVarZzn, executor2);
        zzdiqVar2.zzg(zzfgeVarZzn, executor2);
        zzdiqVar2.zzl(zzfgeVarZzn);
        zzcvi zzcviVar2 = new zzcvi(this.zzg);
        zzdca zzdcaVar2 = new zzdca();
        zzdcaVar2.zza(this.zzb);
        zzdcaVar2.zzb(zzffkVar.zza);
        return zzc(zzcviVar2, zzdcaVar2.zze(), zzdiqVar2.zzn());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    @Override // com.google.android.gms.internal.ads.zzets
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean zza(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzetq zzetqVar, zzetr zzetrVar) throws Throwable {
        zzffn zzffnVar;
        Throwable th;
        zzfqg zzfqgVar;
        zzcuv zzcuvVar;
        try {
            try {
                if (!zzmVar.zzb()) {
                    if (((Boolean) zzbko.zzd.zze()).booleanValue()) {
                        try {
                            boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmD)).booleanValue();
                            if (this.zzf.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmE)).intValue() || !z) {
                                Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            zzffnVar = this;
                        }
                    }
                }
                if (str == null) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzf("Ad unit ID should not be null for app open ad.");
                    this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffm
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze();
                        }
                    });
                    return false;
                }
                if (this.zzj != null) {
                    return false;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdi)).booleanValue()) {
                    com.google.android.gms.ads.internal.client.zzay.zzc();
                }
                if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzcuvVar = (zzcuv) this.zze.zzd()) == null) {
                    zzfqgVar = null;
                } else {
                    zzfqg zzfqgVarZzd = zzcuvVar.zzd();
                    zzfqgVarZzd.zzi(7);
                    zzfqgVarZzd.zzc(zzmVar.zzp);
                    zzfqgVarZzd.zzd(zzmVar.zzm);
                    zzfqgVar = zzfqgVarZzd;
                }
                Context context = this.zzb;
                boolean z2 = zzmVar.zzf;
                zzflv.zzb(context, z2);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzko)).booleanValue() && z2) {
                    this.zza.zzw().zzc(true);
                }
                Bundle bundleZza = zzdyw.zza(new Pair(zzdyu.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz)), new Pair(zzdyu.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis())));
                zzfkx zzfkxVar = this.zzi;
                zzfkxVar.zzg(str);
                zzfkxVar.zzc(com.google.android.gms.ads.internal.client.zzr.zzd());
                zzfkxVar.zza(zzmVar);
                zzfkxVar.zzv(bundleZza);
                zzfky zzfkyVarZzB = zzfkxVar.zzB();
                zzfpw zzfpwVarZzo = zzfpw.zzo(context, zzfqf.zzg(zzfkyVarZzB), 7, zzmVar);
                zzffk zzffkVar = new zzffk(null);
                zzffkVar.zza = zzfkyVarZzB;
                ListenableFuture listenableFutureZzc = this.zze.zzc(new zzfhx(zzffkVar, null), new zzfhv() { // from class: com.google.android.gms.internal.ads.zzffl
                    @Override // com.google.android.gms.internal.ads.zzfhv
                    public final /* synthetic */ zzdby zza(zzfhu zzfhuVar) {
                        return this.zza.zzf(zzfhuVar);
                    }
                }, null);
                this.zzj = listenableFutureZzc;
                zzhbw.zzr(listenableFutureZzc, new zzffj(this, zzetrVar, zzfqgVar, zzfpwVarZzo, zzffkVar), this.zzc);
                return true;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            zzffnVar = this;
        }
        th = th;
        throw th;
    }

    @Override // com.google.android.gms.internal.ads.zzets
    public final boolean zzb() {
        ListenableFuture listenableFuture = this.zzj;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    public abstract zzdby zzc(zzcvi zzcviVar, zzdcb zzdcbVar, zzdir zzdirVar);

    public final void zzd(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzi.zzp(zzxVar);
    }

    public final /* synthetic */ void zze() {
        this.zzd.zzdJ(zzfma.zzd(6, null, null));
    }

    public final /* synthetic */ Executor zzh() {
        return this.zzc;
    }

    public final /* synthetic */ zzfge zzi() {
        return this.zzd;
    }

    public final /* synthetic */ zzfhw zzj() {
        return this.zze;
    }

    public final /* synthetic */ zzfqj zzk() {
        return this.zzh;
    }

    public final /* synthetic */ void zzl(ListenableFuture listenableFuture) {
        this.zzj = null;
    }
}
