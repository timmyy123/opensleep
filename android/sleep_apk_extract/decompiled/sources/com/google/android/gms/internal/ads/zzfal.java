package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfal implements zzfci {
    private final zzfky zza;
    private final PackageInfo zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;

    public zzfal(zzfky zzfkyVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzfkyVar;
        this.zzb = packageInfo;
        this.zzc = zzgVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00ea  */
    @Override // com.google.android.gms.internal.ads.zzfci
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        JSONArray jSONArrayOptJSONArray;
        zzfky zzfkyVar = this.zza;
        ArrayList<String> arrayList = zzfkyVar.zzh;
        Bundle bundle = (Bundle) obj;
        if (arrayList == null) {
            return;
        }
        if (arrayList.isEmpty()) {
            bundle.putInt("native_version", 0);
            return;
        }
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", zzfkyVar.zzi);
        zzblt zzbltVar = zzfkyVar.zzj;
        if (zzbltVar != null) {
            if (zzbltVar.zza > 3) {
                bundle.putBoolean("enable_native_media_orientation", true);
                int i = zzbltVar.zzh;
                String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "square" : "portrait" : "landscape" : "any";
                if (!"unknown".equals(str)) {
                    bundle.putString("native_media_orientation", str);
                }
            }
            int i2 = zzbltVar.zzc;
            String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? "unknown" : "landscape" : "portrait" : "any";
            if (!"unknown".equals(str2)) {
                bundle.putString("native_image_orientation", str2);
            }
            bundle.putBoolean("native_multiple_images", zzbltVar.zzd);
            bundle.putBoolean("use_custom_mute", zzbltVar.zzg);
            int i3 = zzbltVar.zzi;
            if (i3 != 0) {
                bundle.putBoolean("sccg_tap", zzbltVar.zzj);
                bundle.putInt("sccg_dir", i3);
            }
        }
        PackageInfo packageInfo = this.zzb;
        int i4 = packageInfo != null ? packageInfo.versionCode : 0;
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzc;
        if (i4 > zzgVar.zzg()) {
            zzgVar.zzt();
            zzgVar.zzf(i4);
        }
        JSONObject jSONObjectZzs = zzgVar.zzs();
        String string = null;
        if (jSONObjectZzs != null && (jSONArrayOptJSONArray = jSONObjectZzs.optJSONArray(zzfkyVar.zzg)) != null) {
            string = jSONArrayOptJSONArray.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            bundle.putString("native_advanced_settings", string);
        }
        int i5 = zzfkyVar.zzl;
        if (i5 > 1) {
            bundle.putInt("max_num_ads", i5);
        }
        zzbsb zzbsbVar = zzfkyVar.zzb;
        if (zzbsbVar != null) {
            String str3 = zzbsbVar.zzc;
            if (TextUtils.isEmpty(str3)) {
                String str4 = "p";
                if (zzbsbVar.zza >= 2) {
                    int i6 = zzbsbVar.zzd;
                    if (i6 == 2 || i6 != 3) {
                        str4 = "l";
                    }
                    bundle.putString("ia_var", str4);
                } else {
                    int i7 = zzbsbVar.zzb;
                    if (i7 != 1) {
                        if (i7 != 2) {
                            StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 41);
                            sb.append("Instream ad video aspect ratio ");
                            sb.append(i7);
                            sb.append(" is wrong.");
                            com.google.android.gms.ads.internal.util.client.zzo.zzf(sb.toString());
                            str4 = "l";
                        }
                        bundle.putString("ia_var", str4);
                    }
                }
            } else {
                bundle.putString("ad_tag", str3);
            }
            bundle.putBoolean("instr", true);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznp)).booleanValue() || zzbltVar == null) {
            return;
        }
        com.google.android.gms.ads.internal.client.zzfw zzfwVar = zzbltVar.zzf;
        if (zzfwVar != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("startMuted", zzfwVar.zza);
            bundle2.putBoolean("clickToExpandRequested", zzfwVar.zzc);
            bundle2.putBoolean("customControlsRequested", zzfwVar.zzb);
            bundle.putBundle(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, bundle2);
        }
        bundle.putBoolean("disable_image_loading", zzbltVar.zzb);
        bundle.putInt("preferred_ad_choices_position", zzbltVar.zze);
    }
}
