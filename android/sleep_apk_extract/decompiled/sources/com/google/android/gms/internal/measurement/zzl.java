package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzl extends zzal {
    private final zzab zzb;

    public zzl(zzab zzabVar) {
        this.zzb = zzabVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.measurement.zzal, com.google.android.gms.internal.measurement.zzao
    public final zzao zzcG(String str, zzg zzgVar, List list) {
        switch (str.hashCode()) {
            case 21624207:
                if (str.equals("getEventName")) {
                    zzh.zza("getEventName", 0, list);
                    return new zzas(this.zzb.zzc().zzb());
                }
                break;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    zzh.zza("getTimestamp", 0, list);
                    return new zzah(Double.valueOf(this.zzb.zzc().zza()));
                }
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    zzh.zza("getParamValue", 1, list);
                    return zzi.zza(this.zzb.zzc().zze(zzgVar.zza((zzao) list.get(0)).zzc()));
                }
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    zzh.zza("getParams", 0, list);
                    Map mapZzf = this.zzb.zzc().zzf();
                    zzal zzalVar = new zzal();
                    for (String str2 : mapZzf.keySet()) {
                        zzalVar.zzm(str2, zzi.zza(mapZzf.get(str2)));
                    }
                    return zzalVar;
                }
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    zzh.zza("setParamValue", 2, list);
                    String strZzc = zzgVar.zza((zzao) list.get(0)).zzc();
                    zzao zzaoVarZza = zzgVar.zza((zzao) list.get(1));
                    this.zzb.zzc().zzd(strZzc, zzh.zzj(zzaoVarZza));
                    return zzaoVarZza;
                }
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    zzh.zza("setEventName", 1, list);
                    zzao zzaoVarZza2 = zzgVar.zza((zzao) list.get(0));
                    if (zzao.zzf.equals(zzaoVarZza2) || zzao.zzg.equals(zzaoVarZza2)) {
                        Utf8$$ExternalSyntheticBUOutline0.m$2("Illegal event name");
                        return null;
                    }
                    this.zzb.zzc().zzc(zzaoVarZza2.zzc());
                    return new zzas(zzaoVarZza2.zzc());
                }
                break;
        }
        return super.zzcG(str, zzgVar, list);
    }
}
