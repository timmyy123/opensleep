package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcwn implements zzddl {
    private final zzcku zza;
    private final zzdzl zzb;
    private final zzfkf zzc;

    public zzcwn(zzcku zzckuVar, zzdzl zzdzlVar, zzfkf zzfkfVar) {
        this.zza = zzckuVar;
        this.zzb = zzdzlVar;
        this.zzc = zzfkfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        zzcku zzckuVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzot)).booleanValue() || (zzckuVar = this.zza) == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzab.zza(zzckuVar.zzE()) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        zzdzk zzdzkVarZza = this.zzb.zza();
        zzdzkVarZza.zzc("action", "hcp");
        zzdzkVarZza.zzc("hcp", str);
        zzdzkVarZza.zzb(this.zzc);
        zzdzkVarZza.zzd();
    }
}
