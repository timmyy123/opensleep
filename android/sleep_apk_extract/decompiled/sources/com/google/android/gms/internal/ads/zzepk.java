package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzepk implements zzhbe {
    private final zzfpk zza;
    private final zzdct zzb;
    private final zzfry zzc;
    private final zzfsc zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcxw zzg;
    private final zzepd zzh;
    private final zzelx zzi;
    private final Context zzj;
    private final zzfqg zzk;
    private final zzeon zzl;
    private final zzdzg zzm;

    public zzepk(Context context, zzfpk zzfpkVar, zzepd zzepdVar, zzdct zzdctVar, zzfry zzfryVar, zzfsc zzfscVar, zzcxw zzcxwVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzelx zzelxVar, zzfqg zzfqgVar, zzeon zzeonVar, zzdzg zzdzgVar) {
        this.zzj = context;
        this.zza = zzfpkVar;
        this.zzh = zzepdVar;
        this.zzb = zzdctVar;
        this.zzc = zzfryVar;
        this.zzd = zzfscVar;
        this.zzg = zzcxwVar;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzelxVar;
        this.zzk = zzfqgVar;
        this.zzl = zzeonVar;
        this.zzm = zzdzgVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String zzb(zzfkq zzfkqVar) {
        String strM = "No fill.";
        String str = true != ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgB)).booleanValue() ? "No ad config." : "No fill.";
        zzfki zzfkiVar = zzfkqVar.zzb.zzb;
        int i = zzfkiVar.zzf;
        if (i == 0) {
            strM = str;
        } else if (i < 200 || i >= 300) {
            strM = (i < 300 || i >= 400) ? zzba$$ExternalSyntheticOutline0.m(i, "Received error HTTP response code: ", new StringBuilder(String.valueOf(i).length() + 35)) : "No location header to follow redirect or too many redirects.";
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgA)).booleanValue()) {
            }
        }
        zzfkh zzfkhVar = zzfkiVar.zzj;
        return zzfkhVar != null ? zzfkhVar.zza() : strM;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        int i;
        Bundle bundle;
        final zzfkq zzfkqVar = (zzfkq) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcN)).booleanValue() && (bundle = zzfkqVar.zzb.zzd) != null) {
            this.zzm.zzg(bundle);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcO)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_START.zza(), this.zzm);
        }
        String strZzb = zzb(zzfkqVar);
        zzelx zzelxVar = this.zzi;
        zzfkp zzfkpVar = zzfkqVar.zzb;
        zzfki zzfkiVar = zzfkpVar.zzb;
        zzelxVar.zza(zzfkiVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjC)).booleanValue() && (i = zzfkiVar.zzf) != 0 && (i < 200 || i >= 300)) {
            return zzhbw.zzc(new zzeph(3, strZzb));
        }
        String str = zzfkiVar.zzq;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzew)).booleanValue() || TextUtils.isEmpty(str)) {
            for (zzfkf zzfkfVar : zzfkpVar.zza) {
                zzelxVar.zzb(zzfkfVar);
                Iterator it = zzfkfVar.zza.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        zzelxVar.zze(zzfkfVar, 0L, zzfma.zzd(1, null, null));
                        break;
                    }
                    zzels zzelsVarZza = this.zzg.zza(zzfkfVar.zzb, (String) it.next());
                    if (zzelsVarZza == null || !zzelsVarZza.zza(zzfkqVar, zzfkfVar)) {
                    }
                }
            }
        } else {
            zzelxVar.zzc(str, zzfkpVar.zza);
        }
        zzdct zzdctVar = this.zzb;
        zzctn zzctnVar = new zzctn(zzfkqVar, this.zzd, this.zzc);
        Executor executor = this.zze;
        zzdctVar.zzq(zzctnVar, executor);
        if (zzfkiVar.zzr > 1) {
            return this.zzl.zza(zzfkqVar);
        }
        String strZzb2 = zzb(zzfkqVar);
        zzfpk zzfpkVar = this.zza;
        zzfpe zzfpeVar = zzfpe.RENDER_CONFIG_INIT;
        Objects.requireNonNull(zzfpkVar);
        zzfor zzforVarZzi = zzfov.zza(zzhbw.zzc(new zzeph(3, strZzb2)), zzfpeVar, zzfpkVar).zzi();
        final zzepd zzepdVar = this.zzh;
        zzepdVar.zza();
        int i2 = 0;
        for (final zzfkf zzfkfVar2 : zzfkpVar.zza) {
            Iterator it2 = zzfkfVar2.zza.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String str2 = (String) it2.next();
                final zzels zzelsVarZza2 = this.zzg.zza(zzfkfVar2.zzb, str2);
                if (zzelsVarZza2 != null && zzelsVarZza2.zza(zzfkqVar, zzfkfVar2)) {
                    zzfpb zzfpbVarZza = zzfpkVar.zza(zzfpe.RENDER_CONFIG_WATERFALL, zzforVarZzi);
                    StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 15 + String.valueOf(str2).length());
                    sb.append("render-config-");
                    sb.append(i2);
                    sb.append("-");
                    sb.append(str2);
                    zzforVarZzi = zzfpbVarZza.zza(sb.toString()).zzg(Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzepj
                        @Override // com.google.android.gms.internal.ads.zzhbe
                        public final /* synthetic */ ListenableFuture zza(Object obj2) {
                            return this.zza.zzc(zzfkfVar2, zzfkqVar, zzelsVarZza2, (Throwable) obj2);
                        }
                    }).zzi();
                    break;
                }
            }
            i2++;
        }
        zzforVarZzi.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepi
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzepdVar.zzb();
            }
        }, executor);
        return zzforVarZzi;
    }

    public final /* synthetic */ ListenableFuture zzc(zzfkf zzfkfVar, zzfkq zzfkqVar, zzels zzelsVar, Throwable th) {
        zzfpw zzfpwVarZzn = zzfpw.zzn(this.zzj, 12);
        zzfpwVarZzn.zzi(zzfkfVar.zzE);
        zzfpwVarZzn.zza();
        ListenableFuture listenableFutureZzi = zzhbw.zzi(zzelsVar.zzb(zzfkqVar, zzfkfVar), zzfkfVar.zzR, TimeUnit.MILLISECONDS, this.zzf);
        this.zzh.zze(zzfkqVar, zzfkfVar, listenableFutureZzi, this.zzc);
        zzfqf.zzd(listenableFutureZzi, this.zzk, zzfpwVarZzn);
        return listenableFutureZzi;
    }
}
