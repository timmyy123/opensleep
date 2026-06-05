package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfnb {
    private final HashMap zza = new HashMap();

    public final zzfna zza(zzfmr zzfmrVar, Context context, zzfmj zzfmjVar, zzfng zzfngVar) {
        HashMap map = this.zza;
        zzfna zzfnaVar = (zzfna) map.get(zzfmrVar);
        if (zzfnaVar != null) {
            return zzfnaVar;
        }
        zzfmo zzfmoVar = new zzfmo(zzfmu.zza(zzfmrVar, context));
        zzfna zzfnaVar2 = new zzfna(zzfmoVar, new zzfnj(zzfmoVar, zzfmjVar, zzfngVar));
        map.put(zzfmrVar, zzfnaVar2);
        return zzfnaVar2;
    }
}
