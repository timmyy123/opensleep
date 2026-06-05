package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdox implements zzimu {
    private final zzind zza;

    private zzdox(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzdox zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdox(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        VersionInfoParcel versionInfoParcelZza = ((zzcoi) this.zza).zza();
        com.google.android.gms.ads.internal.zzt.zzc();
        return new zzben(UUID.randomUUID().toString(), versionInfoParcelZza, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, new JSONObject(), false, true);
    }
}
