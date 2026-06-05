package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcrz implements zzcrt {
    private final zzecr zza;

    public zzcrz(zzecr zzecrVar) {
        this.zza = zzecrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrt
    public final void zza(Map map) {
        String str = (String) map.get("gesture");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 97520651) {
            if (iHashCode == 109399814 && str.equals("shake")) {
                this.zza.zze(zzecn.SHAKE);
                return;
            }
        } else if (str.equals("flick")) {
            this.zza.zze(zzecn.FLICK);
            return;
        }
        this.zza.zze(zzecn.NONE);
    }
}
