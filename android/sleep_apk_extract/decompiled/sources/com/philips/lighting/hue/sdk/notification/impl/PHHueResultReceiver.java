package com.philips.lighting.hue.sdk.notification.impl;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class PHHueResultReceiver implements Executor {
    private PHHandlerListener listener;

    public PHHueResultReceiver(PHHandlerListener pHHandlerListener) {
        this.listener = pHHandlerListener;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        PHHandlerListener pHHandlerListener = this.listener;
        if (pHHandlerListener != null) {
            pHHandlerListener.onReceived();
        }
    }
}
