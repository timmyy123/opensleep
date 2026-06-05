package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfde implements zzfck {
    private final com.google.android.gms.ads.internal.util.zzg zza;
    private final Context zzb;
    private final zzhcg zzc;
    private final ScheduledExecutorService zzd;
    private final zzelq zze;
    private final zzfky zzf;
    private final VersionInfoParcel zzg;

    public zzfde(com.google.android.gms.ads.internal.util.zzg zzgVar, Context context, zzhcg zzhcgVar, ScheduledExecutorService scheduledExecutorService, zzelq zzelqVar, zzfky zzfkyVar, VersionInfoParcel versionInfoParcel) {
        this.zza = zzgVar;
        this.zzb = context;
        this.zzc = zzhcgVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzelqVar;
        this.zzf = zzfkyVar;
        this.zzg = versionInfoParcel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a0, code lost:
    
        if (java.util.Arrays.asList(r1.split(",")).contains(r5.zzb.getPackageName()) == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    @Override // com.google.android.gms.internal.ads.zzfck
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ListenableFuture zza() {
        ListenableFuture listenableFutureZzc;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlP)).booleanValue() && this.zza.zzz()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlT)).booleanValue()) {
                if (this.zzf.zzd.zzy != RequestConfiguration.PublisherPrivacyPersonalizationState.DISABLED.getValue()) {
                    if (this.zzg.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlN)).intValue()) {
                        if (Build.VERSION.SDK_INT >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlO)).intValue()) {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlL)).booleanValue()) {
                                String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlM);
                                if (!TextUtils.isEmpty(str)) {
                                }
                            }
                            try {
                                listenableFutureZzc = zzhbw.zzi(this.zze.zza(false), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlR)).intValue(), timeUnit, this.zzd);
                            } catch (Exception e) {
                                listenableFutureZzc = zzhbw.zzc(e);
                            }
                            zzhcg zzhcgVar = this.zzc;
                            return zzhbw.zzi((zzhbo) zzhbw.zzh((zzhbo) zzhbw.zzj(zzhbo.zzw(listenableFutureZzc), zzfdd.zza, zzhcgVar), Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfdb
                                @Override // com.google.android.gms.internal.ads.zzhbe
                                public final /* synthetic */ ListenableFuture zza(Object obj) {
                                    return this.zza.zzc((Throwable) obj);
                                }
                            }, zzhcgVar), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlR)).intValue(), timeUnit, this.zzd);
                        }
                    }
                }
            }
        }
        return zzhbw.zza(new zzfdf("", -1, null));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 56;
    }

    public final /* synthetic */ ListenableFuture zzc(final Throwable th) {
        this.zzc.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdc
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlQ)).booleanValue();
                Throwable th2 = th;
                if (zBooleanValue) {
                    com.google.android.gms.ads.internal.zzt.zzh().zzi(th2, "TopicsSignalUnsampled.fetchTopicsSignal");
                } else {
                    com.google.android.gms.ads.internal.zzt.zzh().zzh(th2, "TopicsSignal.fetchTopicsSignal");
                }
            }
        });
        return zzhbw.zza(th instanceof SecurityException ? new zzfdf("", 2, null) : th instanceof IllegalStateException ? new zzfdf("", 3, null) : th instanceof IllegalArgumentException ? new zzfdf("", 4, null) : th instanceof TimeoutException ? new zzfdf("", 5, null) : new zzfdf("", 0, null));
    }
}
