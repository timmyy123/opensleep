package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfwh {
    private static int zza = 2;

    public static void zza(Context context) {
        context.registerReceiver(new zzfwg(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }

    public static int zzb() {
        if (zzfwd.zzb() != zzfuq.CTV) {
            return 2;
        }
        return zza;
    }
}
