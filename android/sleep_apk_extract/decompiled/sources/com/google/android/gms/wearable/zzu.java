package com.google.android.gms.wearable;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzu implements ServiceConnection {
    public /* synthetic */ zzu(WearableListenerService wearableListenerService, byte[] bArr) {
        Objects.requireNonNull(wearableListenerService);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
