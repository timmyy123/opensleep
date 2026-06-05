package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.common.util.concurrent.ListenableFuture;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbpp {
    public static final zzbpq zza = zzbpo.zza;
    public static final zzbpq zzb = zzbpf.zza;
    public static final zzbpq zzc = zzbpg.zza;
    public static final zzbpq zzd = new zzbox();
    public static final zzbpq zze = new zzboy();
    public static final zzbpq zzf = zzbpl.zza;
    public static final zzbpq zzg = new zzboz();
    public static final zzbpq zzh = new zzbpa();
    public static final zzbpq zzi = zzbpm.zza;
    public static final zzbpq zzj = new zzbpb();
    public static final zzbpq zzk = new zzbpc();
    public static final zzbpq zzl = new zzcio();
    public static final zzbpq zzm = new zzcip();
    public static final zzbpq zzn = new zzboj();
    public static final zzbqh zzo = new zzbqh();
    public static final zzbpq zzp = new zzbpd();
    public static final zzbpq zzq = new zzbpe();
    public static final zzbpq zzr = new zzbok();
    public static final zzbpq zzs = new zzbol();
    public static final zzbpq zzt = new zzbom();
    public static final zzbpq zzu = new zzbon();
    public static final zzbpq zzv = new zzboo();
    public static final zzbpq zzw = new zzbop();
    public static final zzbpq zzx = new zzboq();
    public static final zzbpq zzy = new zzbor();
    public static final zzbpq zzz = new zzbos();
    public static final zzbpq zzA = new zzbot();
    public static final zzbpq zzB = new zzbov();
    public static final zzbpq zzC = new zzbow();

    public static ListenableFuture zza(zzcku zzckuVar, String str) {
        Uri uriZzd = Uri.parse(str);
        try {
            zzbap zzbapVarZzS = zzckuVar.zzS();
            zzflc zzflcVarZzT = zzckuVar.zzT();
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznw)).booleanValue() || zzflcVarZzT == null) {
                if (zzbapVarZzS != null && zzbapVarZzS.zza(uriZzd)) {
                    uriZzd = zzbapVarZzS.zzd(uriZzd, zzckuVar.getContext(), zzckuVar.zzE(), zzckuVar.zzj());
                }
            } else if (zzbapVarZzS != null && zzbapVarZzS.zza(uriZzd)) {
                uriZzd = zzflcVarZzT.zza(uriZzd, zzckuVar.getContext(), zzckuVar.zzE(), zzckuVar.zzj());
            }
        } catch (zzbaq unused) {
            String strConcat = "Unable to append parameter to URL: ".concat(str);
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
        }
        Map map = new HashMap();
        if (zzckuVar.zzC() != null) {
            map = zzckuVar.zzC().zzaw;
        }
        final String strZzb = zzceb.zzb(uriZzd, zzckuVar.getContext(), map);
        long jLongValue = ((Long) zzbkp.zze.zze()).longValue();
        if (jLongValue <= 0 || jLongValue > 261210000) {
            return zzhbw.zza(strZzb);
        }
        zzhbo zzhboVarZzw = zzhbo.zzw(zzckuVar.zzaF());
        zzbph zzbphVar = zzbph.zza;
        zzhcg zzhcgVar = zzcfr.zzh;
        return (zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzk((zzhbo) zzhbw.zzg(zzhboVarZzw, Throwable.class, zzbphVar, zzhcgVar), new zzgta() { // from class: com.google.android.gms.internal.ads.zzbpi
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                String str2 = (String) obj;
                zzbpq zzbpqVar = zzbpp.zza;
                String strReplace = strZzb;
                if (str2 == null) {
                    return strReplace;
                }
                if (((Boolean) zzbkp.zzf.zze()).booleanValue()) {
                    String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                    String host = Uri.parse(strReplace).getHost();
                    for (int i2 = 0; i2 < 3; i2++) {
                        if (!host.endsWith(strArr[i2])) {
                        }
                    }
                    return strReplace;
                }
                String str3 = (String) zzbkp.zza.zze();
                String str4 = (String) zzbkp.zzb.zze();
                if (!TextUtils.isEmpty(str3)) {
                    strReplace = strReplace.replace(str3, str2);
                }
                if (TextUtils.isEmpty(str4)) {
                    return strReplace;
                }
                Uri uri = Uri.parse(strReplace);
                return TextUtils.isEmpty(uri.getQueryParameter(str4)) ? uri.buildUpon().appendQueryParameter(str4, str2).toString() : strReplace;
            }
        }, zzhcgVar), Throwable.class, new zzgta() { // from class: com.google.android.gms.internal.ads.zzbpj
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbpq zzbpqVar = zzbpp.zza;
                if (((Boolean) zzbkp.zzi.zze()).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "prepareClickUrl.attestation2");
                }
                return strZzb;
            }
        }, zzhcgVar);
    }

    public static zzbpq zzb(final zzdky zzdkyVar, final zzctj zzctjVar) {
        return new zzbpq() { // from class: com.google.android.gms.internal.ads.zzbpk
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                zzcku zzckuVar = (zzcku) obj;
                zzbpp.zzc(map, zzdkyVar);
                final String str = (String) map.get("u");
                if (str == null) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("URL missing from click GMSG.");
                    return;
                }
                final zzctj zzctjVar2 = zzctjVar;
                zzhbo zzhboVarZzw = zzhbo.zzw(zzbpp.zza(zzckuVar, str));
                zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzbpn
                    @Override // com.google.android.gms.internal.ads.zzhbe
                    public final /* synthetic */ ListenableFuture zza(Object obj2) {
                        zzctj zzctjVar3;
                        String str2 = (String) obj2;
                        zzbpq zzbpqVar = zzbpp.zza;
                        return (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlw)).booleanValue() && (zzctjVar3 = zzctjVar2) != null && zzctj.zzc(str)) ? zzctjVar3.zzb(str2, com.google.android.gms.ads.internal.client.zzay.zzh()) : zzhbw.zza(str2);
                    }
                };
                zzhcg zzhcgVar = zzcfr.zza;
                zzhbw.zzr((zzhbo) zzhbw.zzj(zzhboVarZzw, zzhbeVar, zzhcgVar), new zzbou(zzckuVar), zzhcgVar);
            }
        };
    }

    public static void zzc(Map map, zzdky zzdkyVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmg)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && zzdkyVar != null) {
            zzdkyVar.zzdu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void zze(zzcmg zzcmgVar, Map map) {
        Intent uri;
        Intent intent;
        PackageManager packageManager = zzcmgVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String strOptString = jSONObject2.optString("id");
                        String strOptString2 = jSONObject2.optString("u");
                        String strOptString3 = jSONObject2.optString("i");
                        String strOptString4 = jSONObject2.optString("m");
                        String strOptString5 = jSONObject2.optString("p");
                        String strOptString6 = jSONObject2.optString("c");
                        String strOptString7 = jSONObject2.optString("intent_url");
                        ResolveInfo resolveInfoResolveActivity = null;
                        if (TextUtils.isEmpty(strOptString7)) {
                            uri = null;
                            if (uri == null) {
                            }
                            intent = uri;
                            resolveInfoResolveActivity = packageManager.resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                            jSONObject.put(strOptString, resolveInfoResolveActivity != null);
                        } else {
                            try {
                                uri = Intent.parseUri(strOptString7, 0);
                            } catch (URISyntaxException e) {
                                String strValueOf = String.valueOf(strOptString7);
                                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                com.google.android.gms.ads.internal.util.client.zzo.zzg("Error parsing the url: ".concat(strValueOf), e);
                                uri = null;
                            }
                            if (uri == null) {
                                uri = new Intent();
                                if (!TextUtils.isEmpty(strOptString2)) {
                                    uri.setData(Uri.parse(strOptString2));
                                }
                                if (!TextUtils.isEmpty(strOptString3)) {
                                    uri.setAction(strOptString3);
                                }
                                if (!TextUtils.isEmpty(strOptString4)) {
                                    uri.setType(strOptString4);
                                }
                                if (!TextUtils.isEmpty(strOptString5)) {
                                    uri.setPackage(strOptString5);
                                }
                                if (!TextUtils.isEmpty(strOptString6)) {
                                    String[] strArrSplit = strOptString6.split(MqttTopic.TOPIC_LEVEL_SEPARATOR, 2);
                                    if (strArrSplit.length == 2) {
                                        uri.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                    }
                                }
                            }
                            intent = uri;
                            try {
                                resolveInfoResolveActivity = packageManager.resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                            } catch (NullPointerException e2) {
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e2, intent.toString());
                            }
                            try {
                                jSONObject.put(strOptString, resolveInfoResolveActivity != null);
                            } catch (JSONException e3) {
                                int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                com.google.android.gms.ads.internal.util.client.zzo.zzg("Error constructing openable urls response.", e3);
                            }
                        }
                    } catch (JSONException e4) {
                        int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("Error parsing the intent data.", e4);
                    }
                }
                ((zzbsm) zzcmgVar).zzd("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzbsm) zzcmgVar).zzd("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzbsm) zzcmgVar).zzd("openableIntents", new JSONObject());
        }
    }
}
