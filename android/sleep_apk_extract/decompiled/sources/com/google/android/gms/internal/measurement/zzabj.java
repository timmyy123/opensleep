package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzabj extends zzabh {
    private static final Map zza;
    private final zzyz zzb;

    static {
        EnumMap enumMap = new EnumMap(zzyz.class);
        for (zzyz zzyzVar : zzyz.values()) {
            zzabj[] zzabjVarArr = new zzabj[10];
            for (int i = 0; i < 10; i++) {
                zzabjVarArr[i] = new zzabj(i, zzyzVar, zzza.zza());
            }
            enumMap.put(zzyzVar, zzabjVarArr);
        }
        zza = Collections.unmodifiableMap(enumMap);
    }

    private zzabj(int i, zzyz zzyzVar, zzza zzzaVar) {
        super(zzzaVar, i);
        zzabr.zza(zzyzVar, "format char");
        this.zzb = zzyzVar;
        if (zzzaVar.zze()) {
            zzyzVar.zze();
            return;
        }
        int iZzb = zzyzVar.zzb();
        iZzb = zzzaVar.zzk() ? iZzb & 65503 : iZzb;
        StringBuilder sb = new StringBuilder("%");
        zzzaVar.zzl(sb);
        sb.append((char) iZzb);
    }

    public static zzabj zza(int i, zzyz zzyzVar, zzza zzzaVar) {
        if (i >= 10 || !zzzaVar.zze()) {
            return new zzabj(i, zzyzVar, zzzaVar);
        }
        zzabj[] zzabjVarArr = (zzabj[]) zza.get(zzyzVar);
        zzabr.zza(zzabjVarArr, "default parameter");
        return zzabjVarArr[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzabh
    public final void zzb(zzabi zzabiVar, Object obj) {
        zzabiVar.zzc(obj, this.zzb, zzd());
    }
}
