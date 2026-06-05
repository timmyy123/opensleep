package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.wearable.zzai;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelClient;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbo extends ChannelClient {
    public static /* synthetic */ zzcb zzc(Channel channel) {
        zzai.zzd(channel, "channel must not be null");
        return (zzcb) channel;
    }
}
