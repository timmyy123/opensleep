package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.AdFormat;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzftd {
    private final zzdzl zza;

    public zzftd(zzdzl zzdzlVar, Context context) {
        this.zza = zzdzlVar;
    }

    private final void zzv(String str, long j, String str2, String str3, AdFormat adFormat, int i, int i2, int i3, String str4) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", str);
        zzdzkVarZza.zzc("pat", Long.toString(j));
        zzdzkVarZza.zzc("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        zzdzkVarZza.zzc("max_ads", Integer.toString(i));
        zzdzkVarZza.zzc("cache_size", Integer.toString(i2));
        zzdzkVarZza.zzc("pas", Integer.toString(i3));
        zzdzkVarZza.zzc("pv", "2");
        zzdzkVarZza.zzc("ad_unit_id", str3);
        zzdzkVarZza.zzc("pid", str2);
        zzdzkVarZza.zzd();
    }

    private final void zzw(String str, String str2, long j, int i, int i2, String str3, zzftk zzftkVar, String str4) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc(str2, Long.toString(j));
        if (zzftkVar != null) {
            zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
            zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
            zzdzkVarZza.zzc("pid", zzftkVar.zzc());
        }
        zzdzkVarZza.zzc("action", str);
        if (str3 != null) {
            zzdzkVarZza.zzc("gqi", str3);
        }
        if (i >= 0) {
            zzdzkVarZza.zzc("max_ads", Integer.toString(i));
        }
        if (i2 >= 0) {
            zzdzkVarZza.zzc("cache_size", Integer.toString(i2));
        }
        zzdzkVarZza.zzc("pv", str4);
        zzdzkVarZza.zzd();
    }

    private final void zzx(String str, long j, String str2, String str3, AdFormat adFormat, int i, int i2, int i3, int i4, int i5) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", str);
        zzdzkVarZza.zzc("pat", Long.toString(j));
        zzdzkVarZza.zzc("pid", str2);
        zzdzkVarZza.zzc("ad_unit_id", str3);
        zzdzkVarZza.zzc("max_ads", Integer.toString(i));
        zzdzkVarZza.zzc("cache_size", Integer.toString(i2));
        zzdzkVarZza.zzc("tpcnt", Integer.toString(i4));
        zzdzkVarZza.zzc("mpl", Integer.toString(i5));
        if (adFormat != null) {
            zzdzkVarZza.zzc("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        }
        if (i3 > 0) {
            zzdzkVarZza.zzc("nptr", Integer.toString(i3));
        }
        zzdzkVarZza.zzd();
    }

    public final void zza(int i, long j, zzftk zzftkVar, String str) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "start_preload");
        zzdzkVarZza.zzc("sp_ts", Long.toString(j));
        zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
        zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
        zzdzkVarZza.zzc("pid", zzftkVar.zzc());
        zzdzkVarZza.zzc("max_ads", Integer.toString(i));
        zzdzkVarZza.zzc("pv", str);
        zzdzkVarZza.zzd();
    }

    public final void zzb(Map map, long j, String str) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "start_preload");
        zzdzkVarZza.zzc("sp_ts", Long.toString(j));
        zzdzkVarZza.zzc("pv", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        for (AdFormat adFormat : map.keySet()) {
            String strValueOf = String.valueOf(adFormat.name().toLowerCase(Locale.ENGLISH));
            zzdzkVarZza.zzc(strValueOf.concat("_count"), Integer.toString(((Integer) map.get(adFormat)).intValue()));
        }
        zzdzkVarZza.zzd();
    }

    public final void zzc(int i, int i2, long j, zzftk zzftkVar) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "cache_resize");
        zzdzkVarZza.zzc("cs_ts", Long.toString(j));
        zzdzkVarZza.zzc("orig_ma", Integer.toString(i));
        zzdzkVarZza.zzc("max_ads", Integer.toString(i2));
        zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
        zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
        zzdzkVarZza.zzc("pid", zzftkVar.zzc());
        zzdzkVarZza.zzc("pv", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        zzdzkVarZza.zzd();
    }

    public final void zzd(int i, int i2, long j, Long l, String str, zzftk zzftkVar, String str2) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("plaac_ts", Long.toString(j));
        zzdzkVarZza.zzc("max_ads", Integer.toString(i));
        zzdzkVarZza.zzc("cache_size", Integer.toString(i2));
        zzdzkVarZza.zzc("action", "is_ad_available");
        if (zzftkVar != null) {
            zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
            zzdzkVarZza.zzc("pid", zzftkVar.zzc());
            zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
        }
        if (l != null) {
            zzdzkVarZza.zzc("plaay_ts", Long.toString(l.longValue()));
        }
        if (str != null) {
            zzdzkVarZza.zzc("gqi", str);
        }
        zzdzkVarZza.zzc("pv", str2);
        zzdzkVarZza.zzd();
    }

    public final void zze(long j, String str) {
        zzw("poll_ad", "ppacwe_ts", j, -1, -1, null, null, "2");
    }

    public final void zzf(long j, zzftk zzftkVar, int i, int i2, String str) {
        zzw("poll_ad", "ppac_ts", j, i, i2, null, zzftkVar, str);
    }

    public final void zzg(long j, int i, int i2, String str, zzftk zzftkVar, String str2) {
        zzw("poll_ad", "psvroc_ts", j, i, i2, str, zzftkVar, str2);
    }

    public final void zzh(long j, int i, int i2, String str, zzftk zzftkVar, String str2) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("ppla_ts", Long.toString(j));
        zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
        zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
        zzdzkVarZza.zzc("pid", zzftkVar.zzc());
        zzdzkVarZza.zzc("max_ads", Integer.toString(i));
        zzdzkVarZza.zzc("cache_size", Integer.toString(i2));
        zzdzkVarZza.zzc("action", "poll_ad");
        if (str != null) {
            zzdzkVarZza.zzc("gqi", str);
        }
        zzdzkVarZza.zzc("pv", str2);
        zzdzkVarZza.zzd();
    }

    public final void zzi(long j, String str, zzftk zzftkVar, int i, int i2, String str2) {
        zzw("paa", "pano_ts", j, i, i2, str, zzftkVar, str2);
    }

    public final void zzj(long j, zzftk zzftkVar, int i, String str) {
        zzw("pae", "paeo_ts", j, i, 0, null, zzftkVar, str);
    }

    public final void zzk(long j, zzftk zzftkVar, com.google.android.gms.ads.internal.client.zze zzeVar, int i, int i2, String str) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "pftla");
        zzdzkVarZza.zzc("pftlat_ts", Long.toString(j));
        zzdzkVarZza.zzc("pftlaec", Integer.toString(zzeVar.zza));
        zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
        zzdzkVarZza.zzc("max_ads", Integer.toString(i));
        zzdzkVarZza.zzc("cache_size", Integer.toString(i2));
        zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
        zzdzkVarZza.zzc("pid", zzftkVar.zzc());
        zzdzkVarZza.zzc("pv", str);
        zzdzkVarZza.zzd();
    }

    public final void zzl(long j, AdFormat adFormat, int i) {
        zzv("pda", j, null, null, adFormat, -1, -1, i, "2");
    }

    public final void zzm(long j, String str, String str2, AdFormat adFormat, int i, int i2) {
        zzv("pd", j, str, str2, adFormat, i, i2, 1, "2");
    }

    public final void zzn(AdFormat adFormat, long j, int i) {
        zzv("pgcs", j, null, null, adFormat, -1, -1, i, "2");
    }

    public final void zzo(long j, String str, String str2, AdFormat adFormat, int i, int i2) {
        zzv("pgc", j, str, str2, adFormat, i, i2, 1, "2");
    }

    public final void zzp(int i, long j, String str, String str2, AdFormat adFormat, int i2) {
        zzv("pnav", j, str, str2, adFormat, i2, i, 1, "2");
    }

    public final void zzq(long j, String str, String str2, AdFormat adFormat, int i, int i2, int i3, int i4) {
        zzx("acmpa", j, str, str2, adFormat, i, i2, 0, i3, i4);
    }

    public final void zzr(long j, String str, String str2, AdFormat adFormat, int i, int i2, int i3, int i4, int i5) {
        zzx("acmpr", j, str, str2, adFormat, i, i2, i3, i4, i5);
    }

    public final void zzs(long j, int i, int i2) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "acmlr");
        zzdzkVarZza.zzc("pat", Long.toString(j));
        zzdzkVarZza.zzc("mpl", Integer.toString(i));
        zzdzkVarZza.zzc("pas", Integer.toString(i2));
        zzdzkVarZza.zzd();
    }

    public final void zzt(long j, AdFormat adFormat, String str, String str2) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "poact");
        zzdzkVarZza.zzc("ad_unit_id", str2);
        zzdzkVarZza.zzc("pid", str);
        zzdzkVarZza.zzc("poact_ts", Long.toString(j));
        if (adFormat != null) {
            zzdzkVarZza.zzc("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        }
        zzdzkVarZza.zzd();
    }

    public final void zzu(long j, AdFormat adFormat, String str, String str2) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "poac");
        zzdzkVarZza.zzc("ad_unit_id", str2);
        zzdzkVarZza.zzc("pid", str);
        if (adFormat != null) {
            zzdzkVarZza.zzc("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        }
        zzdzkVarZza.zzd();
    }
}
