package com.philips.lighting.hue.sdk;

import com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PHNotificationManager {
    public static PHNotificationManager getDefaultManager() {
        return PHNotificationManagerImpl.getInstance();
    }

    public abstract void cancelSearchNotification();

    public abstract void registerSDKListener(PHSDKListener pHSDKListener);

    public abstract void unregisterSDKListener(PHSDKListener pHSDKListener);
}
