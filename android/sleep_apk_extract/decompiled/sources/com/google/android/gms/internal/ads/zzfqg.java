package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfqg implements Runnable {
    private final zzfqj zzb;
    private String zzc;
    private String zze;
    private zzfkp zzf;
    private com.google.android.gms.ads.internal.client.zze zzg;
    private Future zzh;
    private final List zza = new ArrayList();
    private int zzi = 2;
    private zzfql zzd = zzfql.SCAR_REQUEST_TYPE_UNSPECIFIED;

    public zzfqg(zzfqj zzfqjVar) {
        this.zzb = zzfqjVar;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        zzh();
    }

    public final synchronized zzfqg zza(zzfpw zzfpwVar) {
        try {
            if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
                List list = this.zza;
                zzfpwVar.zzc();
                list.add(zzfpwVar);
                Future future = this.zzh;
                if (future != null) {
                    future.cancel(false);
                }
                this.zzh = zzcfr.zzd.schedule(this, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkb)).intValue(), TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final synchronized zzfqg zzb(ArrayList arrayList) {
        try {
            if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
                if (arrayList.contains("banner") || arrayList.contains(AdFormat.BANNER.name())) {
                    this.zzi = 3;
                } else if (arrayList.contains("interstitial") || arrayList.contains(AdFormat.INTERSTITIAL.name())) {
                    this.zzi = 4;
                } else if (arrayList.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE) || arrayList.contains(AdFormat.NATIVE.name())) {
                    this.zzi = 8;
                } else if (arrayList.contains("rewarded") || arrayList.contains(AdFormat.REWARDED.name())) {
                    this.zzi = 5;
                } else if (arrayList.contains("app_open_ad")) {
                    this.zzi = 7;
                } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains(AdFormat.REWARDED_INTERSTITIAL.name())) {
                    this.zzi = 6;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final synchronized zzfqg zzc(String str) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue() && zzfqf.zza(str)) {
            this.zzc = str;
        }
        return this;
    }

    public final synchronized zzfqg zzd(Bundle bundle) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            this.zzd = com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzd(bundle);
        }
        return this;
    }

    public final synchronized zzfqg zze(zzfkp zzfkpVar) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            this.zzf = zzfkpVar;
        }
        return this;
    }

    public final synchronized zzfqg zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            this.zzg = zzeVar;
        }
        return this;
    }

    public final synchronized zzfqg zzg(String str) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            this.zze = str;
        }
        return this;
    }

    public final synchronized void zzh() {
        try {
            if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
                Future future = this.zzh;
                if (future != null) {
                    future.cancel(false);
                }
                List<zzfpw> list = this.zza;
                for (zzfpw zzfpwVar : list) {
                    int i = this.zzi;
                    if (i != 2) {
                        zzfpwVar.zzp(i);
                    }
                    if (!TextUtils.isEmpty(this.zzc)) {
                        zzfpwVar.zze(this.zzc);
                    }
                    if (!TextUtils.isEmpty(this.zze) && !zzfpwVar.zzl()) {
                        zzfpwVar.zzi(this.zze);
                    }
                    zzfkp zzfkpVar = this.zzf;
                    if (zzfkpVar != null) {
                        zzfpwVar.zzg(zzfkpVar);
                    } else {
                        com.google.android.gms.ads.internal.client.zze zzeVar = this.zzg;
                        if (zzeVar != null) {
                            zzfpwVar.zzh(zzeVar);
                        }
                    }
                    zzfpwVar.zzf(this.zzd);
                    this.zzb.zzb(zzfpwVar.zzm());
                }
                list.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized zzfqg zzi(int i) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            this.zzi = i;
        }
        return this;
    }
}
