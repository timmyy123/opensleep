package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdtc {
    private final Context zza;
    private final zzdsi zzb;
    private final zzbap zzc;
    private final VersionInfoParcel zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbhp zzf;
    private final Executor zzg;
    private final zzblt zzh;
    private final zzdtu zzi;
    private final zzdwi zzj;
    private final ScheduledExecutorService zzk;
    private final zzdvd zzl;
    private final zzdzl zzm;
    private final zzfsc zzn;
    private final zzekg zzo;
    private final zzekr zzp;
    private final zzflc zzq;
    private final zzdzg zzr;
    private final zzeao zzs;

    public zzdtc(Context context, zzdsi zzdsiVar, zzbap zzbapVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbhp zzbhpVar, Executor executor, zzfky zzfkyVar, zzdtu zzdtuVar, zzdwi zzdwiVar, ScheduledExecutorService scheduledExecutorService, zzdzl zzdzlVar, zzfsc zzfscVar, zzekg zzekgVar, zzdvd zzdvdVar, zzekr zzekrVar, zzflc zzflcVar, zzdzg zzdzgVar, zzeao zzeaoVar) {
        this.zza = context;
        this.zzb = zzdsiVar;
        this.zzc = zzbapVar;
        this.zzd = versionInfoParcel;
        this.zze = zzaVar;
        this.zzf = zzbhpVar;
        this.zzg = executor;
        this.zzh = zzfkyVar.zzj;
        this.zzi = zzdtuVar;
        this.zzj = zzdwiVar;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdzlVar;
        this.zzn = zzfscVar;
        this.zzo = zzekgVar;
        this.zzl = zzdvdVar;
        this.zzp = zzekrVar;
        this.zzq = zzflcVar;
        this.zzr = zzdzgVar;
        this.zzs = zzeaoVar;
    }

    public static final com.google.android.gms.ads.internal.client.zzew zzk(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzs(jSONObjectOptJSONObject);
    }

    public static final List zzl(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject == null) {
            return zzgwm.zzi();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reasons");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzgwm.zzi();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            com.google.android.gms.ads.internal.client.zzew zzewVarZzs = zzs(jSONArrayOptJSONArray.optJSONObject(i));
            if (zzewVarZzs != null) {
                arrayList.add(zzewVarZzs);
            }
        }
        return zzgwm.zzq(arrayList);
    }

    private final ListenableFuture zzm(JSONArray jSONArray, boolean z, boolean z2, zzdyu zzdyuVar) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzhbw.zza(Collections.EMPTY_LIST);
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcU)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyuVar.zza(), this.zzr);
        }
        for (int i = 0; i < length; i++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i), z, null));
        }
        return zzhbw.zzk(zzhbw.zzm(arrayList), zzdtb.zza, this.zzg);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ListenableFuture zzn(JSONObject jSONObject, boolean z, zzdyu zzdyuVar) {
        HashMap map;
        int i;
        double d;
        if (jSONObject == null) {
            return zzhbw.zza(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeP)).booleanValue()) {
            if (jSONObject.has((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeQ))) {
                HashMap map2 = new HashMap();
                for (String str : ((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeR)).split(",")) {
                    try {
                        map2.put(str, jSONObject.getString(str));
                    } catch (JSONException unused) {
                    }
                }
                map = map2;
            } else {
                map = null;
            }
        }
        final String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString) && map == null) {
            return zzhbw.zza(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcU)).booleanValue() && zzdyuVar != null) {
            zzba$$ExternalSyntheticOutline0.m(zzdyuVar.zza(), this.zzr);
        }
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        final int iOptInt = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, -1);
        final int iOptInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, -1);
        if (z) {
            i = iOptInt;
            d = dOptDouble;
        } else {
            if (map == null) {
                return zzq("NativeAssetsLoader.loadImage", jSONObject.optBoolean("require"), zzhbw.zzk(this.zzb.zza(strOptString, dOptDouble, zOptBoolean), new zzgta() { // from class: com.google.android.gms.internal.ads.zzdsr
                    @Override // com.google.android.gms.internal.ads.zzgta
                    public final /* synthetic */ Object apply(Object obj) {
                        return new zzblp(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2, null);
                    }
                }, this.zzg), null);
            }
            d = dOptDouble;
            i = iOptInt;
        }
        return zzhbw.zza(new zzblp(null, Uri.parse(strOptString), d, i, iOptInt2, map));
    }

    private static Integer zzo(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private final ListenableFuture zzp(JSONObject jSONObject, zzfkf zzfkfVar, zzfki zzfkiVar, com.google.android.gms.ads.internal.zzb zzbVar, zzcdn zzcdnVar) {
        final ListenableFuture listenableFutureZzb = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzfkfVar, zzfkiVar, zzr(jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0), jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0)), zzbVar, zzcdnVar);
        return zzhbw.zzj(listenableFutureZzb, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzdsw
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) throws zzeph {
                zzcku zzckuVar = (zzcku) obj;
                if (zzckuVar == null || zzckuVar.zzh() == null) {
                    throw new zzeph(1, "Retrieve video view in html5 ad response failed.");
                }
                return listenableFutureZzb;
            }
        }, zzcfr.zzh);
    }

    private final ListenableFuture zzq(String str, boolean z, final ListenableFuture listenableFuture, Object obj) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcV)).booleanValue()) {
            zzcfu.zza(listenableFuture, str, this.zzg);
        }
        if (z) {
            return zzhbw.zzj(listenableFuture, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzdsy
                @Override // com.google.android.gms.internal.ads.zzhbe
                public final /* synthetic */ ListenableFuture zza(Object obj2) {
                    return obj2 != null ? listenableFuture : zzhbw.zzc(new zzeph(1, "Retrieve required value in native ad response failed."));
                }
            }, zzcfr.zzh);
        }
        final Object obj2 = null;
        return zzhbw.zzh(listenableFuture, Exception.class, new zzhbe(obj2) { // from class: com.google.android.gms.internal.ads.zzdsx
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj3) {
                com.google.android.gms.ads.internal.util.zze.zzb("Error during loading assets.", (Exception) obj3);
                return zzhbw.zza(null);
            }
        }, zzcfr.zzh);
    }

    private final com.google.android.gms.ads.internal.client.zzr zzr(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return com.google.android.gms.ads.internal.client.zzr.zzb();
            }
            i = 0;
        }
        return new com.google.android.gms.ads.internal.client.zzr(this.zza, new AdSize(i, i2));
    }

    private static final com.google.android.gms.ads.internal.client.zzew zzs(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new com.google.android.gms.ads.internal.client.zzew(strOptString, strOptString2);
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str, zzdyu zzdyuVar) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb, zzdyuVar);
    }

    public final ListenableFuture zzb(JSONObject jSONObject, String str, zzdyu zzdyuVar) {
        zzblt zzbltVar = this.zzh;
        return zzm(jSONObject.optJSONArray("images"), zzbltVar.zzb, zzbltVar.zzd, zzdyuVar);
    }

    public final ListenableFuture zzc(JSONObject jSONObject, String str, final zzfkf zzfkfVar, final zzfki zzfkiVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zzcdn zzcdnVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlv)).booleanValue()) {
            return zzhbw.zza(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzhbw.zza(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return zzhbw.zza(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeP)).booleanValue()) {
            if (jSONObjectOptJSONObject.has((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeQ))) {
                return zzhbw.zza(null);
            }
        }
        final String strOptString = jSONObjectOptJSONObject.optString("base_url");
        final String strOptString2 = jSONObjectOptJSONObject.optString("html");
        final com.google.android.gms.ads.internal.client.zzr zzrVarZzr = zzr(jSONObjectOptJSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0), jSONObjectOptJSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0));
        if (TextUtils.isEmpty(strOptString2)) {
            return zzhbw.zza(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcU)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_START.zza(), this.zzr);
        }
        final ListenableFuture listenableFutureZzj = zzhbw.zzj(zzhbw.zza(null), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzdss
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzh(zzrVarZzr, zzfkfVar, zzfkiVar, zzbVar, zzcdnVar, strOptString, strOptString2, obj);
            }
        }, zzcfr.zzf);
        ListenableFuture listenableFutureZzj2 = zzhbw.zzj(listenableFutureZzj, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzdst
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) throws zzeph {
                if (((zzcku) obj) != null) {
                    return listenableFutureZzj;
                }
                throw new zzeph(1, "Retrieve Web View from image ad response failed.");
            }
        }, zzcfr.zzh);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcV)).booleanValue()) {
            zzcfu.zza(listenableFutureZzj2, "NativeAssetsLoader.loadImageHtml", this.zzg);
        }
        return listenableFutureZzj2;
    }

    public final ListenableFuture zzd(JSONObject jSONObject, String str, zzdyu zzdyuVar) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObjectOptJSONObject == null) {
            return zzhbw.zza(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("images");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
        if (jSONArrayOptJSONArray == null && jSONObjectOptJSONObject2 != null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONArrayOptJSONArray.put(jSONObjectOptJSONObject2);
        }
        return zzq("NativeAssetsLoader.loadAttributionInfo", jSONObjectOptJSONObject.optBoolean("require"), zzhbw.zzk(zzm(jSONArrayOptJSONArray, false, true, zzdyuVar), new zzgta() { // from class: com.google.android.gms.internal.ads.zzdsu
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzi(jSONObjectOptJSONObject, (List) obj);
            }
        }, this.zzg), null);
    }

    public final ListenableFuture zze(JSONObject jSONObject, final com.google.android.gms.ads.internal.zzb zzbVar, final zzcdn zzcdnVar) {
        if (!jSONObject.optBoolean("enable_omid")) {
            return zzhbw.zza(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings");
        if (jSONObjectOptJSONObject == null) {
            return zzhbw.zza(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
        if (TextUtils.isEmpty(strOptString)) {
            return zzhbw.zza(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcU)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.NATIVE_ASSETS_LOADING_OMID_START.zza(), this.zzr);
        }
        ListenableFuture listenableFutureZzj = zzhbw.zzj(zzhbw.zza(null), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzdsv
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzj(strOptString, zzcdnVar, zzbVar, obj);
            }
        }, zzcfr.zzf);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcV)).booleanValue()) {
            zzcfu.zza(listenableFutureZzj, "NativeAssetsLoader.omidWebView", this.zzg);
        }
        return listenableFutureZzj;
    }

    public final ListenableFuture zzf(ListenableFuture listenableFuture) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcU)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.NATIVE_ASSETS_LOADING_MEDIA_START.zza(), this.zzr);
        }
        zzcfw zzcfwVar = new zzcfw();
        zzhbw.zzr(listenableFuture, new zzdsq(this, zzcfwVar), zzcfr.zzf);
        return zzcfwVar;
    }

    public final ListenableFuture zzg(JSONObject jSONObject, zzfkf zzfkfVar, zzfki zzfkiVar, com.google.android.gms.ads.internal.zzb zzbVar, zzcdn zzcdnVar) {
        JSONObject jSONObjectZzi = com.google.android.gms.ads.internal.util.zzbp.zzi(jSONObject, "html_containers", "instream");
        if (jSONObjectZzi != null) {
            return zzp(jSONObjectZzi, zzfkfVar, zzfkiVar, zzbVar, zzcdnVar);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO);
        if (jSONObjectOptJSONObject == null) {
            return zzhbw.zza(null);
        }
        String strOptString = jSONObjectOptJSONObject.optString("vast_xml");
        boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlu)).booleanValue() && jSONObjectOptJSONObject.has("html");
        if (!TextUtils.isEmpty(strOptString) || z) {
            return zzq(true != z ? "NativeAssetsLoader.loadVideoView" : "NativeAssetsLoader.loadVideoHtml", false, zzhbw.zzi(z ? zzp(jSONObjectOptJSONObject, zzfkfVar, zzfkiVar, zzbVar, zzcdnVar) : this.zzi.zza(jSONObjectOptJSONObject, zzbVar, zzcdnVar), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeH)).intValue(), TimeUnit.SECONDS, this.zzk), null);
        }
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Required field 'vast_xml' or 'html' is missing");
        return zzhbw.zza(null);
    }

    public final /* synthetic */ ListenableFuture zzh(com.google.android.gms.ads.internal.client.zzr zzrVar, zzfkf zzfkfVar, zzfki zzfkiVar, com.google.android.gms.ads.internal.zzb zzbVar, zzcdn zzcdnVar, String str, String str2, Object obj) throws zzclj {
        zzeao zzeaoVar;
        zzcku zzckuVarZza = this.zzj.zza(zzrVar, zzfkfVar, zzfkiVar);
        final zzcfv zzcfvVarZza = zzcfv.zza(zzckuVarZza);
        zzdva zzdvaVarZza = this.zzl.zza();
        zzcms zzcmsVarZzP = zzckuVarZza.zzP();
        zzbih zzbihVar = zzbiq.zzpg;
        zzcmsVarZzP.zzab(zzdvaVarZza, zzdvaVarZza, zzdvaVarZza, zzdvaVarZza, zzdvaVarZza, false, null, !((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() ? new com.google.android.gms.ads.internal.zzb(this.zza, null, null) : zzbVar, null, true != ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() ? null : zzcdnVar, this.zzo, this.zzn, this.zzm, null, zzdvaVarZza, null, null, null, null, null, null, null);
        zzckuVarZza.zzab("/getNativeAdViewSignals", zzbpp.zzs);
        zzckuVarZza.zzab("/getNativeClickMeta", zzbpp.zzt);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziK)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziM)).booleanValue() && (zzeaoVar = this.zzs) != null) {
                zzckuVarZza.zzab("/onDeviceStorageEvent", new zzbpy(zzeaoVar));
            }
        }
        zzckuVarZza.zzP().zzS(true);
        zzckuVarZza.zzP().zzG(new zzcmq() { // from class: com.google.android.gms.internal.ads.zzdta
            @Override // com.google.android.gms.internal.ads.zzcmq
            public final /* synthetic */ void zza(boolean z, int i, String str3, String str4) {
                zzcfv zzcfvVar = zzcfvVarZza;
                if (z) {
                    zzcfvVar.zzb();
                    return;
                }
                int length = String.valueOf(i).length();
                StringBuilder sb = new StringBuilder(length + 58 + String.valueOf(str3).length() + 15 + String.valueOf(str4).length());
                zzba$$ExternalSyntheticOutline0.m(sb, "Image Web View failed to load. Error code: ", i, ", Description: ", str3);
                zzcfvVar.zzd(new zzeph(1, FileInsert$$ExternalSyntheticOutline0.m(sb, ", Failing URL: ", str4)));
            }
        });
        zzckuVarZza.zzau(str, str2, null);
        return zzcfvVarZza;
    }

    public final /* synthetic */ zzblm zzi(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String strOptString = jSONObject.optString("text");
        Integer numZzo = zzo(jSONObject, "bg_color");
        Integer numZzo2 = zzo(jSONObject, "text_color");
        int iOptInt = jSONObject.optInt("text_size", -1);
        boolean zOptBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int iOptInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzblm(strOptString, list, numZzo, numZzo2, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, jSONObject.optInt("presentation_ms", 4000) + iOptInt2, this.zzh.zze, zOptBoolean);
    }

    public final /* synthetic */ ListenableFuture zzj(String str, zzcdn zzcdnVar, com.google.android.gms.ads.internal.zzb zzbVar, Object obj) throws zzclj {
        com.google.android.gms.ads.internal.zzt.zzd();
        Context context = this.zza;
        zzekr zzekrVar = this.zzp;
        zzcku zzckuVarZza = zzclk.zza(context, zzcne.zzb(), "native-omid", false, false, this.zzc, null, this.zzd, null, null, this.zze, this.zzf, null, null, zzekrVar, this.zzq, this.zzm);
        final zzcfv zzcfvVarZza = zzcfv.zza(zzckuVarZza);
        zzckuVarZza.zzP().zzG(new zzcmq() { // from class: com.google.android.gms.internal.ads.zzdsz
            @Override // com.google.android.gms.internal.ads.zzcmq
            public final /* synthetic */ void zza(boolean z, int i, String str2, String str3) {
                zzcfvVarZza.zzb();
            }
        });
        zzckuVarZza.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpg)).booleanValue()) {
            if (zzcdnVar != null) {
                zzckuVarZza.zzP().zzj(zzcdnVar);
            }
            zzckuVarZza.zzP().zzi(zzbVar);
        }
        return zzcfvVarZza;
    }
}
