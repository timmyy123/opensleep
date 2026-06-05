package com.spotify.android.appremote.internal;

import android.content.Context;
import com.spotify.android.appremote.api.ConnectionParams;

/* JADX INFO: loaded from: classes4.dex */
public class SdkRemoteClientConnectorFactory {
    public SdkRemoteClientConnector newConnector(Context context, ConnectionParams connectionParams, String str) {
        return SdkRemoteClientConnector.create(context, connectionParams, str);
    }
}
