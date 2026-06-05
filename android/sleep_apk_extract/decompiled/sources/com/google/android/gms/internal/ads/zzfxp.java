package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfxp {
    public static zzfyu zza(Context context, int i, zzbds zzbdsVar, String str, String str2, String str3, zzfxg zzfxgVar) {
        return new zzfxo(context, 1, zzbdsVar, str, str2, AppEventsConstants.EVENT_PARAM_VALUE_YES, zzfxgVar).zza(50000);
    }
}
