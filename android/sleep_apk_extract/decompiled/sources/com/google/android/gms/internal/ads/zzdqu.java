package com.google.android.gms.internal.ads;

import android.view.View;
import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdqu {
    private final zzdzl zza;

    public zzdqu(zzdzl zzdzlVar) {
        this.zza = zzdzlVar;
    }

    public final void zza(View view, zzfkf zzfkfVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzot)).booleanValue() || view == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzab.zza(view) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "hcp");
        zzdzkVarZza.zzc("hcp", str);
        zzdzkVarZza.zzb(zzfkfVar);
        zzdzkVarZza.zzd();
    }
}
