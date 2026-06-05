package org.eclipse.paho.client.mqttv3;

/* JADX INFO: loaded from: classes5.dex */
public interface MqttCallback {
    void connectionLost(Throwable th);

    void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken);

    void messageArrived(String str, MqttMessage mqttMessage);
}
