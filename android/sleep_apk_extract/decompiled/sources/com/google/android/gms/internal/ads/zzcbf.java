package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcbf {
    private final List zza;
    private final String zzb;
    private final String zzc;
    private final boolean zzd;
    private final boolean zze;
    private final String zzf;
    private final int zzg;
    private final JSONObject zzh;
    private final String zzi;
    private final long zzj;
    private final long zzk;
    private final boolean zzl;
    private final String zzm;

    public zzcbf(JSONObject jSONObject) {
        this.zzf = jSONObject.optString("url");
        this.zzb = jSONObject.optString("base_uri");
        this.zzc = jSONObject.optString("post_parameters");
        this.zzd = zzn(jSONObject.optString("drt_include"));
        this.zzm = jSONObject.optString("content_type");
        this.zzl = zzn(jSONObject.optString("use_compression"));
        this.zze = zzn(jSONObject.optString("cookies_include", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
        jSONObject.optString("type");
        String strOptString = jSONObject.optString("errors");
        this.zza = strOptString == null ? null : Arrays.asList(strOptString.split(","));
        this.zzg = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        jSONObject.optString("fetched_ad");
        jSONObject.optBoolean("render_test_ad_label");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzh = jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
        jSONObject.optString("analytics_query_ad_event_id");
        jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzi = jSONObject.optString("pool_key");
        this.zzj = zzo(jSONObject.optString("start_time")).longValue();
        this.zzk = zzo(jSONObject.optString(SDKConstants.PARAM_TOURNAMENTS_END_TIME)).longValue();
    }

    private static boolean zzn(String str) {
        if (str != null) {
            return str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) || str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        return false;
    }

    private static Long zzo(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public final int zza() {
        return this.zzg;
    }

    public final List zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zze;
    }

    public final JSONObject zzh() {
        return this.zzh;
    }

    public final String zzi() {
        return this.zzi;
    }

    public final long zzj() {
        return this.zzj;
    }

    public final long zzk() {
        return this.zzk;
    }

    public final String zzl() {
        return this.zzm;
    }

    public final boolean zzm() {
        return this.zzl;
    }
}
