package com.google.android.gms.wearable;

import com.google.android.gms.wearable.ChannelClient;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzt extends ChannelClient.ChannelCallback {
    final /* synthetic */ WearableListenerService zza;

    public /* synthetic */ zzt(WearableListenerService wearableListenerService, byte[] bArr) {
        Objects.requireNonNull(wearableListenerService);
        this.zza = wearableListenerService;
    }

    @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
    public final void onChannelClosed(ChannelClient.Channel channel, int i, int i2) {
        this.zza.onChannelClosed(channel, i, i2);
    }

    @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
    public final void onChannelOpened(ChannelClient.Channel channel) {
        this.zza.onChannelOpened(channel);
    }

    @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
    public final void onInputClosed(ChannelClient.Channel channel, int i, int i2) {
        this.zza.onInputClosed(channel, i, i2);
    }

    @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
    public final void onOutputClosed(ChannelClient.Channel channel, int i, int i2) {
        this.zza.onOutputClosed(channel, i, i2);
    }
}
