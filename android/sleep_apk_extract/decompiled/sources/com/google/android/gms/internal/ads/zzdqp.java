package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class zzdqp implements zzblr {
    final /* synthetic */ zzdrq zza;
    final /* synthetic */ ViewGroup zzb;

    public zzdqp(zzdrq zzdrqVar, ViewGroup viewGroup) {
        this.zza = zzdrqVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final void zza() {
        zzgwm zzgwmVar = zzdqo.zza;
        zzdrq zzdrqVar = this.zza;
        Map mapZzj = zzdrqVar.zzj();
        if (mapZzj == null) {
            return;
        }
        int size = zzgwmVar.size();
        int i = 0;
        while (i < size) {
            Object obj = mapZzj.get((String) zzgwmVar.get(i));
            i++;
            if (obj != null) {
                zzdrqVar.onClick(this.zzb);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final void zzb(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final JSONObject zzc() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final JSONObject zzd() {
        return this.zza.zzp();
    }
}
