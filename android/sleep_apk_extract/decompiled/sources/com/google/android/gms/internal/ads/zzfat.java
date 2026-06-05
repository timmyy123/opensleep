package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.Base64;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfat implements zzfci {
    private final Map zza;

    public zzfat(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        Map map = this.zza;
        if (map.isEmpty()) {
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziN)).booleanValue()) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry : map.entrySet()) {
                ArrayDeque arrayDeque = (ArrayDeque) entry.getValue();
                if (!arrayDeque.isEmpty()) {
                    zzear zzearVar = (zzear) entry.getKey();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", zzearVar.zza());
                        jSONObject.put("event_type", zzearVar.zzb());
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = arrayDeque.iterator();
                        while (it.hasNext()) {
                            jSONArray2.put((Long) it.next());
                        }
                        jSONObject.put("timestamps", jSONArray2);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.google.android.gms.ads.internal.util.zze.zzb("Failed putting the on-device storage record.", e);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                bundle.putString("on_device_storage_records", jSONArray.toString());
                return;
            }
            return;
        }
        Map map2 = this.zza;
        zzhde zzhdeVarZzb = zzhdh.zzb();
        for (Map.Entry entry2 : map2.entrySet()) {
            ArrayDeque arrayDeque2 = (ArrayDeque) entry2.getValue();
            if (!arrayDeque2.isEmpty()) {
                zzear zzearVar2 = (zzear) entry2.getKey();
                int iZza = zzhdb.zza(zzearVar2.zzb());
                if (iZza != 0) {
                    zzhdc zzhdcVarZza = zzhdd.zza();
                    zzhdcVarZza.zza(zzearVar2.zza());
                    zzhdcVarZza.zzb(iZza);
                    zzhdd zzhddVar = (zzhdd) zzhdcVarZza.zzbm();
                    zzhdf zzhdfVarZza = zzhdg.zza();
                    zzhdfVarZza.zza(zzhddVar);
                    zzhdfVarZza.zzb(arrayDeque2);
                    zzhdeVarZzb.zza(zzhdfVarZza);
                }
            }
        }
        zzhdh zzhdhVar = (zzhdh) zzhdeVarZzb.zzbm();
        if (zzhdhVar.zza() > 0) {
            bundle.putString("ods", Base64.encodeToString(zzhdhVar.zzaN(), 11));
        }
    }
}
