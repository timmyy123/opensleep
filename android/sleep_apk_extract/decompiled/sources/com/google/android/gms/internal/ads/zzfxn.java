package com.google.android.gms.internal.ads;

import android.content.Context;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfxn {
    public static zzaym zza(Context context, String str, String str2) {
        return new zzfxm(context, str, str2).zza(DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT);
    }
}
