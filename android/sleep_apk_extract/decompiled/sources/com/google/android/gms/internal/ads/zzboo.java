package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzboo implements zzbpq {
    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        if (TextUtils.isEmpty((CharSequence) map.get("appId"))) {
            com.google.android.gms.ads.internal.util.zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzgrs zzgrsVarZzl = zzgrt.zzl();
        zzgrsVarZzl.zzb((String) map.get("appId"));
        zzgrsVarZzl.zzg(zzckuVar.getWidth());
        zzgrsVarZzl.zza(zzckuVar.zzE().getWindowToken());
        if (map.containsKey("gravityX") && map.containsKey("gravityY")) {
            zzgrsVarZzl.zzc(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        } else {
            zzgrsVarZzl.zzc(81);
        }
        if (map.containsKey("verticalMargin")) {
            zzgrsVarZzl.zzd(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzgrsVarZzl.zzd(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzgrsVarZzl.zzh((String) map.get("enifd"));
        }
        try {
            com.google.android.gms.ads.internal.zzt.zzt().zzc(zzckuVar, zzgrsVarZzl.zzi());
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "DefaultGmsgHandlers.ShowLMDOverlay");
            com.google.android.gms.ads.internal.util.zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
