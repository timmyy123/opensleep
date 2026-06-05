package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzi {
    public static zzao zza(Object obj) {
        if (obj == null) {
            return zzao.zzg;
        }
        if (obj instanceof String) {
            return new zzas((String) obj);
        }
        if (obj instanceof Double) {
            return new zzah((Double) obj);
        }
        if (obj instanceof Long) {
            return new zzah(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzah(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new zzaf((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid value type");
                return null;
            }
            zzae zzaeVar = new zzae();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzaeVar.zzn(zzaeVar.zzh(), zza(it.next()));
            }
            return zzaeVar;
        }
        zzal zzalVar = new zzal();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            zzao zzaoVarZza = zza(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                zzalVar.zzm((String) string, zzaoVarZza);
            }
        }
        return zzalVar;
    }

    public static zzao zzb(zzje zzjeVar) {
        if (zzjeVar == null) {
            return zzao.zzf;
        }
        int iZzk = zzjeVar.zzk() - 1;
        if (iZzk == 1) {
            return zzjeVar.zzc() ? new zzas(zzjeVar.zzd()) : zzao.zzm;
        }
        if (iZzk == 2) {
            return zzjeVar.zzh() ? new zzah(Double.valueOf(zzjeVar.zzi())) : new zzah(null);
        }
        if (iZzk == 3) {
            return zzjeVar.zze() ? new zzaf(Boolean.valueOf(zzjeVar.zzf())) : new zzaf(null);
        }
        if (iZzk != 4) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Unknown type found. Cannot convert entity");
            return null;
        }
        List listZza = zzjeVar.zza();
        ArrayList arrayList = new ArrayList();
        Iterator it = listZza.iterator();
        while (it.hasNext()) {
            arrayList.add(zzb((zzje) it.next()));
        }
        return new zzap(zzjeVar.zzb(), arrayList);
    }
}
