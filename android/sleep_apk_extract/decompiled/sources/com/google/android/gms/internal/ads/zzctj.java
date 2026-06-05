package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import com.facebook.appevents.AppEventsConstants;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzctj {
    zzcaa zza;
    zzcaa zzb;
    private final Context zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzelo zze;
    private final zzdwn zzf;
    private final zzhcg zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    public zzctj(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar, zzelo zzeloVar, zzdwn zzdwnVar, zzhcg zzhcgVar, zzhcg zzhcgVar2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = zzgVar;
        this.zze = zzeloVar;
        this.zzf = zzdwnVar;
        this.zzg = zzhcgVar;
        this.zzh = zzhcgVar2;
        this.zzi = scheduledExecutorService;
    }

    public static boolean zzc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlD));
    }

    private final ListenableFuture zzk(final String str, final InputEvent inputEvent, Random random) {
        try {
            if (!str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlD)) || this.zzd.zzx()) {
                return zzhbw.zza(str);
            }
            final Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlE), String.valueOf(random.nextInt(Integer.MAX_VALUE)));
            if (inputEvent != null) {
                return (zzhbo) zzhbw.zzh((zzhbo) zzhbw.zzj(zzhbo.zzw(this.zze.zza()), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzctd
                    @Override // com.google.android.gms.internal.ads.zzhbe
                    public final /* synthetic */ ListenableFuture zza(Object obj) {
                        return this.zza.zze(builderBuildUpon, str, inputEvent, (Integer) obj);
                    }
                }, this.zzh), Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzcte
                    @Override // com.google.android.gms.internal.ads.zzhbe
                    public final /* synthetic */ ListenableFuture zza(Object obj) {
                        return this.zza.zzf(builderBuildUpon, (Throwable) obj);
                    }
                }, this.zzg);
            }
            builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlF), "11");
            return zzhbw.zza(builderBuildUpon.toString());
        } catch (Exception e) {
            return zzhbw.zzc(e);
        }
    }

    public final void zza(String str, zzfsc zzfscVar, Random random, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzhbw.zzr(zzhbw.zzi(zzk(str, this.zzf.zzb(), random), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlJ)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzctc(this, zzfscVar, str, zzvVar), this.zzg);
    }

    public final ListenableFuture zzb(final String str, Random random) {
        return TextUtils.isEmpty(str) ? zzhbw.zza(str) : zzhbw.zzh(zzk(str, this.zzf.zzb(), random), Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzcti
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzd(str, (Throwable) obj);
            }
        }, this.zzg);
    }

    public final /* synthetic */ ListenableFuture zzd(String str, final Throwable th) {
        this.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcth
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzh(th);
            }
        });
        return zzhbw.zza(str);
    }

    public final /* synthetic */ ListenableFuture zze(final Uri.Builder builder, String str, InputEvent inputEvent, Integer num) {
        if (num.intValue() != 1) {
            builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlF), "10");
            return zzhbw.zza(builder.toString());
        }
        Uri.Builder builderBuildUpon = builder.build().buildUpon();
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlG), AppEventsConstants.EVENT_PARAM_VALUE_YES);
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlF), "12");
        if (str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlH))) {
            builderBuildUpon.authority((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlI));
        }
        return (zzhbo) zzhbw.zzj(zzhbo.zzw(this.zze.zzb(builderBuildUpon.build(), inputEvent)), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzctf
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlF);
                Uri.Builder builder2 = builder;
                builder2.appendQueryParameter(str2, "12");
                return zzhbw.zza(builder2.toString());
            }
        }, this.zzh);
    }

    public final /* synthetic */ ListenableFuture zzf(Uri.Builder builder, final Throwable th) {
        this.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctg
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzg(th);
            }
        });
        builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlF), "9");
        return zzhbw.zza(builder.toString());
    }

    public final /* synthetic */ void zzg(Throwable th) {
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlK)).booleanValue();
        Context context = this.zzc;
        if (zBooleanValue) {
            zzcaa zzcaaVarZzc = zzbzy.zzc(context);
            this.zzb = zzcaaVarZzc;
            zzcaaVarZzc.zzh(th, "AttributionReporting");
        } else {
            zzcaa zzcaaVarZza = zzbzy.zza(context);
            this.zza = zzcaaVarZza;
            zzcaaVarZza.zzh(th, "AttributionReportingSampled");
        }
    }

    public final /* synthetic */ void zzh(Throwable th) {
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlK)).booleanValue();
        Context context = this.zzc;
        if (zBooleanValue) {
            zzcaa zzcaaVarZzc = zzbzy.zzc(context);
            this.zzb = zzcaaVarZzc;
            zzcaaVarZzc.zzh(th, "AttributionReporting.getUpdatedUrlAndRegisterSource");
        } else {
            zzcaa zzcaaVarZza = zzbzy.zza(context);
            this.zza = zzcaaVarZza;
            zzcaaVarZza.zzh(th, "AttributionReportingSampled.getUpdatedUrlAndRegisterSource");
        }
    }

    public final /* synthetic */ Context zzi() {
        return this.zzc;
    }

    public final /* synthetic */ zzhcg zzj() {
        return this.zzg;
    }
}
