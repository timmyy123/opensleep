package org.eclipse.paho.client.mqttv3;

/* JADX INFO: loaded from: classes5.dex */
public interface IMqttActionListener {
    void onFailure(IMqttToken iMqttToken, Throwable th);

    void onSuccess(IMqttToken iMqttToken);
}
