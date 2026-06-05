package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.getpebble.android.kit.Constants;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzeos implements zzels {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final boolean zza(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        return !TextUtils.isEmpty(zzfkfVar.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final ListenableFuture zzb(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        JSONObject jSONObject = zzfkfVar.zzv;
        String strOptString = jSONObject.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzfky zzfkyVar = zzfkqVar.zza.zza;
        zzfkx zzfkxVar = new zzfkx();
        zzfkxVar.zzA(zzfkyVar);
        zzfkxVar.zzg(strOptString);
        zzfkxVar.zzy(true);
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfkyVar.zzd;
        Bundle bundleZzd = zzd(zzmVar.zzm);
        Bundle bundleZzd2 = zzd(bundleZzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        bundleZzd2.putInt("gw", 1);
        String strOptString2 = jSONObject.optString("mad_hac", null);
        if (strOptString2 != null) {
            bundleZzd2.putString("mad_hac", strOptString2);
        }
        String strOptString3 = jSONObject.optString("adJson", null);
        if (strOptString3 != null) {
            bundleZzd2.putString("_ad", strOptString3);
        }
        bundleZzd2.putBoolean("_noRefresh", true);
        JSONObject jSONObject2 = zzfkfVar.zzD;
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString4 = jSONObject2.optString(next, null);
            if (next != null) {
                bundleZzd2.putString(next, strOptString4);
            }
        }
        bundleZzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundleZzd2);
        zzfkxVar.zza(new com.google.android.gms.ads.internal.client.zzm(zzmVar.zza, zzmVar.zzb, bundleZzd2, zzmVar.zzd, zzmVar.zze, zzmVar.zzf, zzmVar.zzg, zzmVar.zzh, zzmVar.zzi, zzmVar.zzj, zzmVar.zzk, zzmVar.zzl, bundleZzd, zzmVar.zzn, zzmVar.zzo, zzmVar.zzp, zzmVar.zzq, zzmVar.zzr, zzmVar.zzs, zzmVar.zzt, zzmVar.zzu, zzmVar.zzv, zzmVar.zzw, zzmVar.zzx, zzmVar.zzy, zzmVar.zzz, zzmVar.zzA));
        zzfkxVar.zzz(zzfkfVar.zzaH);
        zzfky zzfkyVarZzB = zzfkxVar.zzB();
        Bundle bundle = new Bundle();
        zzfki zzfkiVar = zzfkqVar.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzfkiVar.zza));
        bundle2.putInt("refresh_interval", zzfkiVar.zzc);
        bundle2.putString("gws_query_id", zzfkiVar.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        Bundle bundleM = zzba$$ExternalSyntheticOutline0.m("initial_ad_unit_id", zzfkyVar.zzg);
        bundleM.putString("allocation_id", zzfkfVar.zzw);
        bundleM.putString("ad_source_name", zzfkfVar.zzF);
        bundleM.putStringArrayList("click_urls", new ArrayList<>(zzfkfVar.zzc));
        bundleM.putStringArrayList("imp_urls", new ArrayList<>(zzfkfVar.zzd));
        bundleM.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzfkfVar.zzp));
        bundleM.putStringArrayList("fill_urls", new ArrayList<>(zzfkfVar.zzm));
        bundleM.putStringArrayList("video_start_urls", new ArrayList<>(zzfkfVar.zzg));
        bundleM.putStringArrayList("video_reward_urls", new ArrayList<>(zzfkfVar.zzh));
        bundleM.putStringArrayList("video_complete_urls", new ArrayList<>(zzfkfVar.zzi));
        bundleM.putString(Constants.TRANSACTION_ID, zzfkfVar.zzj);
        bundleM.putString("valid_from_timestamp", zzfkfVar.zzk);
        bundleM.putBoolean("is_closable_area_disabled", zzfkfVar.zzP);
        bundleM.putString("recursive_server_response_data", zzfkfVar.zzao);
        bundleM.putBoolean("is_analytics_logging_enabled", zzfkfVar.zzW);
        zzccb zzccbVar = zzfkfVar.zzl;
        if (zzccbVar != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("rb_amount", zzccbVar.zzb);
            bundle3.putString("rb_type", zzccbVar.zza);
            bundleM.putParcelableArray("rewards", new Bundle[]{bundle3});
        }
        bundle.putBundle("parent_ad_config", bundleM);
        return zzc(zzfkyVarZzB, bundle, zzfkfVar, zzfkqVar);
    }

    public abstract ListenableFuture zzc(zzfky zzfkyVar, Bundle bundle, zzfkf zzfkfVar, zzfkq zzfkqVar);
}
