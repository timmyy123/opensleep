package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class zzzz extends zzaaa {
    private final Map zza;

    public /* synthetic */ zzzz(zzzj zzzjVar, zzzj zzzjVar2, byte[] bArr) {
        super(null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzd(linkedHashMap, zzzjVar);
        zzd(linkedHashMap, zzzjVar2);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((zzyl) entry.getKey()).zzf()) {
                entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
            }
        }
        this.zza = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void zzd(Map map, zzzj zzzjVar) {
        for (int i = 0; i < zzzjVar.zza(); i++) {
            zzyl zzylVarZzb = zzzjVar.zzb(i);
            Object obj = map.get(zzylVarZzb);
            if (zzylVarZzb.zzf()) {
                List arrayList = (List) obj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(zzylVarZzb, arrayList);
                }
                arrayList.add(zzylVarZzb.zze(zzzjVar.zzc(i)));
            } else {
                map.put(zzylVarZzb, zzylVarZzb.zze(zzzjVar.zzc(i)));
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final void zza(zzzq zzzqVar, Object obj) {
        for (Map.Entry entry : this.zza.entrySet()) {
            zzyl zzylVar = (zzyl) entry.getKey();
            Object value = entry.getValue();
            if (zzylVar.zzf()) {
                zzzqVar.zzb(zzylVar, ((List) value).iterator(), obj);
            } else {
                zzzqVar.zza(zzylVar, value, obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final int zzb() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final Set zzc() {
        return this.zza.keySet();
    }
}
