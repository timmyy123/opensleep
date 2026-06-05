package com.spotify.android.appremote.internal;

import android.content.ServiceConnection;
import com.spotify.protocol.client.AppProtocolIo;
import com.spotify.protocol.client.OnConnectionTerminatedListener;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface RemoteService extends ServiceConnection, AppProtocolIo {
    void setOnConnectionTerminatedListener(@Nullable OnConnectionTerminatedListener onConnectionTerminatedListener);
}
