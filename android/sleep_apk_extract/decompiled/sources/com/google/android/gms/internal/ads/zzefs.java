package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzefs {
    private static final Pattern zza = Pattern.compile("\\?");
    private final zzcnj zzb;
    private final Context zzc;
    private final VersionInfoParcel zzd;
    private final zzfky zze;
    private final Executor zzf;
    private final ScheduledExecutorService zzg;
    private final String zzh;
    private final zzfqg zzi;
    private final zzdzg zzj;
    private final zzfsc zzk;
    private final zzdfv zzl;
    private final Object zzm = new Object();
    private String zzn;
    private List zzo;
    private Bundle zzp;
    private final zzcbl zzq;

    public zzefs(zzcnj zzcnjVar, Context context, VersionInfoParcel versionInfoParcel, zzfky zzfkyVar, Executor executor, String str, zzfqg zzfqgVar, zzdzg zzdzgVar, zzcbl zzcblVar, zzein zzeinVar, ScheduledExecutorService scheduledExecutorService, zzfsc zzfscVar, zzdfv zzdfvVar) {
        this.zzb = zzcnjVar;
        this.zzc = context;
        this.zzd = versionInfoParcel;
        this.zze = zzfkyVar;
        this.zzf = executor;
        this.zzh = str;
        this.zzi = zzfqgVar;
        zzcnjVar.zzB();
        this.zzj = zzdzgVar;
        this.zzq = zzcblVar;
        this.zzg = scheduledExecutorService;
        this.zzk = zzfscVar;
        this.zzl = zzdfvVar;
    }

    private final ListenableFuture zzg(String str, final String str2) {
        ListenableFuture listenableFutureZza;
        String str3;
        String str4 = "";
        if (TextUtils.isEmpty(str)) {
            return zzhbw.zzc(new zzeph(15, "Invalid ad string."));
        }
        Context context = this.zzc;
        zzfpw zzfpwVarZzn = zzfpw.zzn(context, 11);
        zzfpwVarZzn.zza();
        zzbui zzbuiVarZzb = com.google.android.gms.ads.internal.zzt.zzr().zzb(context, this.zzd, this.zzb.zzx());
        zzbuc zzbucVar = zzbuf.zza;
        final zzbty zzbtyVarZza = zzbuiVarZzb.zza("google.afma.response.normalize", zzbucVar, zzbucVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzic)).booleanValue()) {
            try {
                str3 = str;
            } catch (JSONException unused) {
                str3 = str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                this.zzn = jSONObject.optString("fetch_url", "");
                this.zzo = com.google.android.gms.ads.internal.util.zzbp.zza(new JSONObject(jSONObject.optString("settings", "")).getJSONArray("nofill_urls"), null);
            } catch (JSONException unused2) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Invalid ad response.");
            }
            String string = this.zzn;
            final List list = this.zzo;
            if (TextUtils.isEmpty(string)) {
                listenableFutureZza = zzhbw.zza(str3);
                this.zzj.zzd("sst", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            } else {
                this.zzj.zzd("sst", "2");
                String str5 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzie);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzid)).booleanValue()) {
                    List listZze = zzgty.zzb(zza).zze(string);
                    if (listZze.size() < 2) {
                        listenableFutureZza = zzhbw.zzc(new zzeph(1, "Invalid fetch URL."));
                    } else {
                        str4 = (String) listZze.get(1);
                        com.google.android.gms.ads.internal.zzt.zzc();
                        string = Uri.parse(string).buildUpon().query(null).build().toString();
                        final zzeik zzeikVar = new zzeik(string, 60000, new HashMap(), str4.getBytes(StandardCharsets.UTF_8), str5, false);
                        listenableFutureZza = (zzhbo) zzhbw.zzh((zzhbo) zzhbw.zzi(zzhbo.zzw(zzcfr.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzefp
                            @Override // java.util.concurrent.Callable
                            public final /* synthetic */ Object call() {
                                return this.zza.zzd(zzeikVar);
                            }
                        })), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzif)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefq
                            @Override // com.google.android.gms.internal.ads.zzhbe
                            public final /* synthetic */ ListenableFuture zza(Object obj) {
                                return this.zza.zze(list, (Exception) obj);
                            }
                        }, this.zzf);
                    }
                } else {
                    final zzeik zzeikVar2 = new zzeik(string, 60000, new HashMap(), str4.getBytes(StandardCharsets.UTF_8), str5, false);
                    listenableFutureZza = (zzhbo) zzhbw.zzh((zzhbo) zzhbw.zzi(zzhbo.zzw(zzcfr.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzefp
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            return this.zza.zzd(zzeikVar2);
                        }
                    })), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzif)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefq
                        @Override // com.google.android.gms.internal.ads.zzhbe
                        public final /* synthetic */ ListenableFuture zza(Object obj) {
                            return this.zza.zze(list, (Exception) obj);
                        }
                    }, this.zzf);
                }
            }
        } else {
            listenableFutureZza = zzhbw.zza(str);
            this.zzj.zzd("sst", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        zzhbe zzhbeVar = new zzhbe(this) { // from class: com.google.android.gms.internal.ads.zzefr
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) throws JSONException {
                String str6 = (String) obj;
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                String str7 = str2;
                try {
                    jSONObject4.put("headers", new JSONObject());
                    jSONObject4.put(SDKConstants.PARAM_A2U_BODY, str6);
                    jSONObject3.put("base_url", "");
                    jSONObject3.put("signals", new JSONObject(str7));
                    jSONObject2.put("request", jSONObject3);
                    jSONObject2.put("response", jSONObject4);
                    jSONObject2.put("flags", new JSONObject());
                    return zzhbw.zza(jSONObject2);
                } catch (JSONException e) {
                    throw new JSONException("Preloaded loader: ".concat(String.valueOf(e.getCause())));
                }
            }
        };
        Executor executor = this.zzf;
        ListenableFuture listenableFutureZzj = zzhbw.zzj(zzhbw.zzj(zzhbw.zzj(listenableFutureZza, zzhbeVar, executor), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefn
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzbtyVarZza, (JSONObject) obj);
            }
        }, executor), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefo
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((JSONObject) obj);
            }
        }, executor);
        zzfqf.zzd(listenableFutureZzj, this.zzi, zzfpwVarZzn);
        zzhbw.zzr(listenableFutureZzj, new zzefm(this), zzcfr.zzh);
        return listenableFutureZzj;
    }

    private final void zzh(zzdyu zzdyuVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzih)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyuVar.zza(), this.zzj);
        }
    }

    private final String zzi(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzh));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            String strConcat = "Failed to update the ad types for rendering. ".concat(e.toString());
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
            return str;
        }
    }

    private static final String zzj(String str) {
        try {
            return new JSONObject(str).optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x01e2 A[Catch: all -> 0x00d8, TryCatch #3 {all -> 0x00d8, blocks: (B:21:0x0074, B:23:0x0092, B:25:0x009a, B:27:0x00a7, B:29:0x00c1, B:33:0x00f1, B:36:0x00fd, B:38:0x0105, B:40:0x010b, B:44:0x0114, B:53:0x014c, B:47:0x0128, B:52:0x0137, B:55:0x0151, B:32:0x00db, B:56:0x0165, B:63:0x0182, B:66:0x018a, B:70:0x01ac, B:72:0x01c1, B:76:0x01e2, B:78:0x01f7, B:81:0x020b, B:83:0x0211, B:84:0x021e, B:86:0x0220, B:89:0x0229, B:88:0x0226, B:77:0x01ec, B:73:0x01d4, B:69:0x0198, B:60:0x0172, B:61:0x0177), top: B:118:0x0074, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ec A[Catch: all -> 0x00d8, TryCatch #3 {all -> 0x00d8, blocks: (B:21:0x0074, B:23:0x0092, B:25:0x009a, B:27:0x00a7, B:29:0x00c1, B:33:0x00f1, B:36:0x00fd, B:38:0x0105, B:40:0x010b, B:44:0x0114, B:53:0x014c, B:47:0x0128, B:52:0x0137, B:55:0x0151, B:32:0x00db, B:56:0x0165, B:63:0x0182, B:66:0x018a, B:70:0x01ac, B:72:0x01c1, B:76:0x01e2, B:78:0x01f7, B:81:0x020b, B:83:0x0211, B:84:0x021e, B:86:0x0220, B:89:0x0229, B:88:0x0226, B:77:0x01ec, B:73:0x01d4, B:69:0x0198, B:60:0x0172, B:61:0x0177), top: B:118:0x0074, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0209 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0226 A[Catch: all -> 0x00d8, TryCatch #3 {all -> 0x00d8, blocks: (B:21:0x0074, B:23:0x0092, B:25:0x009a, B:27:0x00a7, B:29:0x00c1, B:33:0x00f1, B:36:0x00fd, B:38:0x0105, B:40:0x010b, B:44:0x0114, B:53:0x014c, B:47:0x0128, B:52:0x0137, B:55:0x0151, B:32:0x00db, B:56:0x0165, B:63:0x0182, B:66:0x018a, B:70:0x01ac, B:72:0x01c1, B:76:0x01e2, B:78:0x01f7, B:81:0x020b, B:83:0x0211, B:84:0x021e, B:86:0x0220, B:89:0x0229, B:88:0x0226, B:77:0x01ec, B:73:0x01d4, B:69:0x0198, B:60:0x0172, B:61:0x0177), top: B:118:0x0074, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ListenableFuture zza() {
        String strOptString;
        int i;
        String str;
        String string;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcP)).booleanValue()) {
            this.zzp = this.zze.zzt;
            zzba$$ExternalSyntheticOutline0.m(zzdyu.SCAR_PRELOADER_READY.zza(), this.zzj);
        }
        String strZzb = this.zze.zzd.zzx;
        if (!TextUtils.isEmpty(strZzb)) {
            String strZzj = zzj(strZzb);
            zzbih zzbihVar = zzbiq.zzhY;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() && strZzj.isEmpty()) {
                int iLastIndexOf = strZzb.lastIndexOf("&request_id=");
                strZzj = iLastIndexOf != -1 ? strZzb.substring(iLastIndexOf + 12) : "";
            }
            if (TextUtils.isEmpty(strZzj)) {
                return zzhbw.zzc(new zzeph(15, "Invalid ad string."));
            }
            synchronized (this.zzm) {
                try {
                    com.google.android.gms.ads.nonagon.signalgeneration.zzq zzqVarZzt = this.zzb.zzt();
                    zzdzg zzdzgVar = this.zzj;
                    String strZzb2 = zzqVarZzt.zzb(strZzj, zzdzgVar);
                    String str2 = null;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() && !TextUtils.isEmpty(strZzb2)) {
                        try {
                            JSONObject jSONObjectOptJSONObject = new JSONObject(strZzb2).optJSONObject("extras");
                            if (jSONObjectOptJSONObject != null) {
                                if ((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzia)).booleanValue() ? Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzib)).split(",")) : Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhZ)).split(","))).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzb(jSONObjectOptJSONObject.optString("query_info_type", "")))) {
                                    int iLastIndexOf2 = strZzb.lastIndexOf("&");
                                    String strSubstring = iLastIndexOf2 != -1 ? strZzb.substring(0, iLastIndexOf2) : null;
                                    if (!TextUtils.isEmpty(strSubstring)) {
                                        try {
                                            byte[] bArrDecode = Base64.decode(strSubstring, 11);
                                            byte[] bytes = strZzj.getBytes(StandardCharsets.UTF_8);
                                            if (TextUtils.isEmpty(strZzb2)) {
                                                string = null;
                                                strZzb = zzflo.zzb(bArrDecode, bytes, string, zzdzgVar);
                                            } else {
                                                try {
                                                    string = new JSONObject(strZzb2).getString("arek");
                                                } catch (JSONException e) {
                                                    com.google.android.gms.ads.internal.util.zze.zza("Failed to get key from QueryJSONMap".concat(e.toString()));
                                                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "CryptoUtils.getKeyFromQueryJsonMap");
                                                    string = null;
                                                }
                                                strZzb = zzflo.zzb(bArrDecode, bytes, string, zzdzgVar);
                                            }
                                        } catch (IllegalArgumentException e2) {
                                            com.google.android.gms.ads.internal.util.zze.zza("Failed to decode the adResponse. ".concat(e2.toString()));
                                            com.google.android.gms.ads.internal.zzt.zzh().zzg(e2, "PreloadedLoader.decryptAdResponseIfNecessary");
                                        }
                                    }
                                }
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    if (TextUtils.isEmpty(strZzb)) {
                        strOptString = "";
                    } else {
                        try {
                            strOptString = new JSONObject(strZzb).optString("render_id", "");
                        } catch (JSONException unused2) {
                            strOptString = "";
                        }
                    }
                    if (TextUtils.isEmpty(strOptString)) {
                        i = 0;
                        if (str2 != null) {
                        }
                        str = (String) pair.first;
                        int iIntValue = ((Integer) pair.second).intValue();
                        if (TextUtils.isEmpty(str)) {
                        }
                    } else {
                        String str3 = "";
                        try {
                            str3 = new String(Base64.decode(strOptString, 0), StandardCharsets.UTF_8);
                        } catch (IllegalArgumentException e3) {
                            com.google.android.gms.ads.internal.util.zze.zza("Ad grouping: Has render_id, but not base64 encoded: ".concat(String.valueOf(strOptString)));
                            com.google.android.gms.ads.internal.zzt.zzh().zzg(e3, "PreloadedLoader.decodeRenderId");
                        }
                        List listZze = zzgty.zza(zzgsx.zzc(':')).zze(str3);
                        if (listZze.size() == 2) {
                            str2 = (String) listZze.get(0);
                            i = Integer.parseInt((String) listZze.get(1));
                            Pair pair = str2 != null ? new Pair(str2, Integer.valueOf(i)) : new Pair("", 0);
                            str = (String) pair.first;
                            int iIntValue2 = ((Integer) pair.second).intValue();
                            if (TextUtils.isEmpty(str) || iIntValue2 <= 0) {
                                zzqVarZzt.zzc(strZzj);
                                if (!TextUtils.isEmpty(strZzb2)) {
                                    return zzg(strZzb, zzi(strZzb2));
                                }
                            } else {
                                if (zzqVarZzt.zzd(strZzj, str)) {
                                    return zzhbw.zzc(new zzeph(10, "The ad has already been shown."));
                                }
                                if (!zzqVarZzt.zze(strZzj, str, iIntValue2)) {
                                }
                                if (!TextUtils.isEmpty(strZzb2)) {
                                }
                            }
                        } else {
                            com.google.android.gms.ads.internal.util.zze.zza("Ad grouping: Has render_id, but invalid format: ".concat(String.valueOf(strOptString)));
                            i = 0;
                            if (str2 != null) {
                            }
                            str = (String) pair.first;
                            int iIntValue22 = ((Integer) pair.second).intValue();
                            if (TextUtils.isEmpty(str)) {
                                zzqVarZzt.zzc(strZzj);
                                if (!TextUtils.isEmpty(strZzb2)) {
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        com.google.android.gms.ads.internal.client.zzc zzcVar = this.zze.zzd.zzs;
        if (zzcVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhQ)).booleanValue()) {
                String str4 = zzcVar.zza;
                String str5 = zzcVar.zzb;
                String strZzj2 = zzj(str4);
                String strZzj3 = zzj(str5);
                if (TextUtils.isEmpty(strZzj3) || !strZzj2.equals(strZzj3)) {
                    this.zzj.zzc().put("ridmm", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                } else {
                    this.zzb.zzt().zzc(strZzj2);
                    this.zzj.zzc().put(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, strZzj2);
                }
            }
            return zzg(zzcVar.zza, zzi(zzcVar.zzb));
        }
        return zzhbw.zzc(new zzeph(14, "Mismatch request IDs."));
    }

    public final /* synthetic */ ListenableFuture zzb(zzbty zzbtyVar, JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcP)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.SCAR_PRELOADER_PROCESSING_DONE.zza(), this.zzj);
        }
        return zzbtyVar.zzb(jSONObject);
    }

    public final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject) {
        zzfkn zzfknVar = new zzfkn(this.zze);
        String string = jSONObject.toString();
        return zzhbw.zza(new zzfkq(zzfknVar, zzfkp.zza(new StringReader(string), this.zzp)));
    }

    public final /* synthetic */ String zzd(zzeik zzeikVar) throws zzeph {
        zzh(zzdyu.RENDERING_ADSTRING_TYPE2_FETCH_START);
        int i = 0;
        int i2 = -1;
        while (true) {
            try {
                if (i >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzig)).intValue()) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 40);
                    sb.append("Received HTTP error code from ad server:");
                    sb.append(i2);
                    throw new zzeph(1, sb.toString());
                }
                zzeil zzeilVarZzb = new zzeim(this.zzc, this.zzd.afmaVersion, this.zzq, Binder.getCallingUid(), null).zza(zzeikVar);
                int i3 = zzeilVarZzb.zza;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzih)).booleanValue()) {
                    this.zzj.zzd("fr", String.valueOf(i));
                }
                if (i3 == 200) {
                    zzh(zzdyu.RENDERING_ADSTRING_TYPE2_FETCH_END);
                    return zzeilVarZzb.zzc;
                }
                i++;
                i2 = i3;
            } catch (Exception e) {
                throw new zzeph(1, e.getMessage() == null ? "Fetch failed." : e.getMessage(), e);
            }
        }
    }

    public final /* synthetic */ ListenableFuture zze(List list, Exception exc) {
        zzeph zzephVar;
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "PreloadedLoader.getTypeTwoAdResponseString");
        if (exc instanceof TimeoutException) {
            zzephVar = new zzeph(1, "Timed out waiting for ad response.");
        } else if (exc instanceof zzeph) {
            zzephVar = (zzeph) exc;
        } else {
            zzephVar = new zzeph(1, exc.getMessage() == null ? "Fetch failed." : exc.getMessage());
        }
        String message = zzephVar.getMessage() == null ? "" : zzephVar.getMessage();
        if (list != null && !list.isEmpty()) {
            String str = "0.6.0.0";
            if (!TextUtils.isEmpty(message)) {
                if (message.contains("Timed out waiting for ad response.")) {
                    message = "timeout";
                    str = "0.2.0.0";
                } else if (message.contains("Received HTTP error code from ad server:")) {
                    List listZze = zzgty.zza(zzgsx.zzc(':')).zze(message);
                    if (listZze.size() == 2) {
                        message = (String) listZze.get(1);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzfry.zzd(zzfry.zzd((String) it.next(), "@gw_adnetstatus@", str), "@error_code@", message));
            }
            this.zzk.zza(arrayList, null);
        }
        return zzhbw.zzc(zzephVar);
    }

    public final /* synthetic */ zzdfv zzf() {
        return this.zzl;
    }
}
