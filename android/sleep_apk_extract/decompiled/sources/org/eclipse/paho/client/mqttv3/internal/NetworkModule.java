package org.eclipse.paho.client.mqttv3.internal;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface NetworkModule {
    InputStream getInputStream();

    OutputStream getOutputStream();

    String getServerURI();

    void start();

    void stop();
}
