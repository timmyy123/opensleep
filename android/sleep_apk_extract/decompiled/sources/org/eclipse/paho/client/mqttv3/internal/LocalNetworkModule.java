package org.eclipse.paho.client.mqttv3.internal;

import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.paho.client.mqttv3.MqttException;

/* JADX INFO: loaded from: classes5.dex */
public class LocalNetworkModule implements NetworkModule {
    static /* synthetic */ Class class$0;
    private String brokerName;
    private Object localAdapter;
    private Class localListener;

    public LocalNetworkModule(String str) {
        this.brokerName = str;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.NetworkModule
    public InputStream getInputStream() {
        try {
            return (InputStream) this.localListener.getMethod("getClientInputStream", null).invoke(this.localAdapter, null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.NetworkModule
    public OutputStream getOutputStream() {
        try {
            return (OutputStream) this.localListener.getMethod("getClientOutputStream", null).invoke(this.localAdapter, null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.NetworkModule
    public String getServerURI() {
        StringBuffer stringBuffer = new StringBuffer("local://");
        stringBuffer.append(this.brokerName);
        return stringBuffer.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 5 */
    @Override // org.eclipse.paho.client.mqttv3.internal.NetworkModule
    public void start() throws MqttException {
        if (!ExceptionHelper.isClassAvailable("com.ibm.mqttdirect.modules.local.bindings.localListener")) {
            throw ExceptionHelper.createMqttException(32103);
        }
        try {
            Class<?> cls = Class.forName("com.ibm.mqttdirect.modules.local.bindings.localListener");
            this.localListener = cls;
            Class<String> cls2 = class$0;
            if (cls2 == null) {
                cls2 = String.class;
                class$0 = cls2;
            }
            this.localAdapter = cls.getMethod("connect", cls2).invoke(null, this.brokerName);
        } catch (Exception unused) {
        }
        if (this.localAdapter == null) {
            throw ExceptionHelper.createMqttException(32103);
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.NetworkModule
    public void stop() {
        if (this.localAdapter != null) {
            try {
                this.localListener.getMethod("close", null).invoke(this.localAdapter, null);
            } catch (Exception unused) {
            }
        }
    }
}
