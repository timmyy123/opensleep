package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzicb extends zzibm {
    public static final zzicb zza = new zzicb();

    private zzicb() {
    }

    public final void zza(zzicf zzicfVar, zzibg zzibgVar) {
        if (zzibgVar == null || (zzibgVar instanceof zzibh)) {
            zzicfVar.zzj();
            return;
        }
        if (zzibgVar instanceof zzibk) {
            zzibk zzibkVarZzg = zzibgVar.zzg();
            if (zzibkVarZzg.zzc()) {
                zzicfVar.zzi(zzibkVarZzg.zzh());
                return;
            } else if (zzibkVarZzg.zza()) {
                zzicfVar.zzh(zzibkVarZzg.zzb());
                return;
            } else {
                zzicfVar.zzg(zzibkVarZzg.zzd());
                return;
            }
        }
        if (zzibgVar instanceof zzibf) {
            zzicfVar.zzb();
            Iterator it = zzibgVar.zzf().iterator();
            while (it.hasNext()) {
                zza(zzicfVar, (zzibg) it.next());
            }
            zzicfVar.zzc();
            return;
        }
        if (!(zzibgVar instanceof zzibi)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Couldn't write ".concat(String.valueOf(zzibgVar.getClass())));
            return;
        }
        zzicfVar.zzd();
        for (Map.Entry entry : zzibgVar.zze().zzb()) {
            zzicfVar.zzf((String) entry.getKey());
            zza(zzicfVar, (zzibg) entry.getValue());
        }
        zzicfVar.zze();
    }
}
