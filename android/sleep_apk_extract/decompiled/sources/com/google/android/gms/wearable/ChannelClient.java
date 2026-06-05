package com.google.android.gms.wearable;

import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.wearable.Wearable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ChannelClient extends GoogleApi<Wearable.WearableOptions> {

    public interface Channel extends Parcelable {
    }

    public static abstract class ChannelCallback {
        public abstract void onChannelClosed(Channel channel, int i, int i2);

        public abstract void onChannelOpened(Channel channel);

        public abstract void onInputClosed(Channel channel, int i, int i2);

        public abstract void onOutputClosed(Channel channel, int i, int i2);
    }
}
