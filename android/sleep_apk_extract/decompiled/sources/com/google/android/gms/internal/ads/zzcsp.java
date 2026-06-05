package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcsp implements zzcrt {
    private final zzfke zza;

    public zzcsp(zzfke zzfkeVar) {
        this.zza = zzfkeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrt
    public final void zza(Map map) {
        String str = (String) map.get("render_in_browser");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.zza.zza(Boolean.parseBoolean(str));
        } catch (Exception e) {
            Types$$ExternalSyntheticBUOutline0.m("Invalid render_in_browser state", e);
        }
    }
}
