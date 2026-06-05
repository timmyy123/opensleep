package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzahn;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzy {
    final /* synthetic */ zzad zza;
    private String zzb;
    private boolean zzc;
    private com.google.android.gms.internal.measurement.zzii zzd;
    private BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    public /* synthetic */ zzy(zzad zzadVar, String str, com.google.android.gms.internal.measurement.zzii zziiVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, byte[] bArr) {
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zziiVar;
    }

    public final void zza(zzab zzabVar) {
        int iZza = zzabVar.zza();
        if (zzabVar.zzd != null) {
            this.zzf.set(iZza, true);
        }
        Boolean bool = zzabVar.zze;
        if (bool != null) {
            this.zze.set(iZza, bool.booleanValue());
        }
        if (zzabVar.zzf != null) {
            Map map = this.zzg;
            Integer numValueOf = Integer.valueOf(iZza);
            Long l = (Long) map.get(numValueOf);
            long jLongValue = zzabVar.zzf.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.zzg.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (zzabVar.zzg != null) {
            Map map2 = this.zzh;
            Integer numValueOf2 = Integer.valueOf(iZza);
            List arrayList = (List) map2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.zzh.put(numValueOf2, arrayList);
            }
            if (zzabVar.zzb()) {
                arrayList.clear();
            }
            zzahn.zza();
            zzic zzicVar = this.zza.zzu;
            zzal zzalVarZzc = zzicVar.zzc();
            String str = this.zzb;
            zzfx zzfxVar = zzfy.zzaF;
            if (zzalVarZzc.zzp(str, zzfxVar) && zzabVar.zzc()) {
                arrayList.clear();
            }
            zzahn.zza();
            boolean zZzp = zzicVar.zzc().zzp(this.zzb, zzfxVar);
            Long l2 = zzabVar.zzg;
            if (!zZzp) {
                arrayList.add(Long.valueOf(l2.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(l2.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public final com.google.android.gms.internal.measurement.zzhg zzb(int i) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.zzhf zzhfVarZzi = com.google.android.gms.internal.measurement.zzhg.zzi();
        zzhfVarZzi.zza(i);
        zzhfVarZzi.zzd(this.zzc);
        com.google.android.gms.internal.measurement.zzii zziiVar = this.zzd;
        if (zziiVar != null) {
            zzhfVarZzi.zzc(zziiVar);
        }
        com.google.android.gms.internal.measurement.zzih zzihVarZzj = com.google.android.gms.internal.measurement.zzii.zzj();
        zzihVarZzj.zzc(zzpk.zzp(this.zze));
        zzihVarZzj.zza(zzpk.zzp(this.zzf));
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.zzg.keySet()) {
                int iIntValue = num.intValue();
                Long l = (Long) this.zzg.get(num);
                if (l != null) {
                    com.google.android.gms.internal.measurement.zzhp zzhpVarZze = com.google.android.gms.internal.measurement.zzhq.zze();
                    zzhpVarZze.zza(iIntValue);
                    zzhpVarZze.zzb(l.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.zzhq) zzhpVarZze.zzbd());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzihVarZzj.zze(arrayList);
        }
        Map map2 = this.zzh;
        if (map2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.zzh.keySet()) {
                com.google.android.gms.internal.measurement.zzij zzijVarZzf = com.google.android.gms.internal.measurement.zzik.zzf();
                zzijVarZzf.zza(num2.intValue());
                List list2 = (List) this.zzh.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzijVarZzf.zzb(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.zzik) zzijVarZzf.zzbd());
            }
            list = arrayList3;
        }
        zzihVarZzj.zzg(list);
        zzhfVarZzi.zzb(zzihVarZzj);
        return (com.google.android.gms.internal.measurement.zzhg) zzhfVarZzi.zzbd();
    }

    public final /* synthetic */ BitSet zzc() {
        return this.zze;
    }

    public /* synthetic */ zzy(zzad zzadVar, String str, byte[] bArr) {
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }
}
