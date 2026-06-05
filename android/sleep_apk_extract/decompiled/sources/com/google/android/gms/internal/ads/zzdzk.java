package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdzk {
    final /* synthetic */ zzdzl zza;
    private final Map zzb;

    public zzdzk(zzdzl zzdzlVar) {
        Objects.requireNonNull(zzdzlVar);
        this.zza = zzdzlVar;
        this.zzb = new ConcurrentHashMap();
    }

    public final zzdzk zza(zzfki zzfkiVar) {
        zzc("gqi", zzfkiVar.zzb);
        return this;
    }

    public final zzdzk zzb(zzfkf zzfkfVar) {
        zzc("aai", zzfkfVar.zzw);
        zzc(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, zzfkfVar.zzan);
        zzc("ad_format", zzfkf.zza(zzfkfVar.zzb));
        return this;
    }

    public final zzdzk zzc(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final void zzd() {
        this.zza.zzd().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdzj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzh();
            }
        });
    }

    public final com.google.android.gms.ads.internal.util.client.zzt zze() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpJ)).booleanValue()) {
            zzd();
            return com.google.android.gms.ads.internal.util.client.zzt.SUCCESS;
        }
        zzdzl zzdzlVar = this.zza;
        return zzdzlVar.zzc().zze(this.zzb);
    }

    public final void zzf() {
        this.zza.zzd().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdzi
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzi();
            }
        });
    }

    public final String zzg() {
        return this.zza.zzc().zzc(this.zzb);
    }

    public final /* synthetic */ void zzh() {
        this.zza.zzc().zzb(this.zzb);
    }

    public final /* synthetic */ void zzi() {
        this.zza.zzc().zzf(this.zzb);
    }

    public final /* synthetic */ zzdzk zzj() {
        this.zzb.putAll(this.zza.zze());
        return this;
    }
}
