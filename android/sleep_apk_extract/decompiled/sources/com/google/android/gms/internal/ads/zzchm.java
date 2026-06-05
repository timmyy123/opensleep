package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzchm {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final boolean zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final long zzm;
    public final long zzn;

    public zzchm(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzbiq.zzaw);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzbiq.zzm);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzbiq.zzw);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzbiq.zzi);
        zzbih zzbihVar = zzbiq.zzh;
        if (jSONObject != null) {
            try {
                jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
        }
        this.zze = zzb(jSONObject, "exo_read_timeout_millis", zzbiq.zzj);
        this.zzf = zzb(jSONObject, "load_check_interval_bytes", zzbiq.zzk);
        this.zzg = zzb(jSONObject, "player_precache_limit", zzbiq.zzl);
        this.zzh = zzb(jSONObject, "socket_receive_buffer_size", zzbiq.zzn);
        this.zzi = zza(jSONObject, "use_cache_data_source", zzbiq.zzfj);
        zzb(jSONObject, "min_retry_count", zzbiq.zzo);
        this.zzj = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbiq.zzq);
        this.zzk = zza(jSONObject, "enable_multiple_video_playback", zzbiq.zzcC);
        this.zzl = zza(jSONObject, "use_range_http_data_source", zzbiq.zzcE);
        this.zzm = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbiq.zzcF);
        this.zzn = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbiq.zzcG);
    }

    private static final boolean zza(JSONObject jSONObject, String str, zzbih zzbihVar) {
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue();
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return zBooleanValue;
    }

    private static final int zzb(JSONObject jSONObject, String str, zzbih zzbihVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).intValue();
    }

    private static final long zzc(JSONObject jSONObject, String str, zzbih zzbihVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException unused) {
            }
        }
        return ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).longValue();
    }
}
