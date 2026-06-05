package org.eclipse.paho.client.mqttv3;

/* JADX INFO: loaded from: classes5.dex */
public interface IMqttClient {
    void close();

    void connect();

    void connect(MqttConnectOptions mqttConnectOptions);

    IMqttToken connectWithResult(MqttConnectOptions mqttConnectOptions);

    void disconnect();

    void disconnect(long j);

    void disconnectForcibly();

    void disconnectForcibly(long j);

    void disconnectForcibly(long j, long j2);

    String getClientId();

    IMqttDeliveryToken[] getPendingDeliveryTokens();

    String getServerURI();

    MqttTopic getTopic(String str);

    boolean isConnected();

    void messageArrivedComplete(int i, int i2);

    void publish(String str, MqttMessage mqttMessage);

    void publish(String str, byte[] bArr, int i, boolean z);

    void setCallback(MqttCallback mqttCallback);

    void setManualAcks(boolean z);

    void subscribe(String str);

    void subscribe(String str, int i);

    void subscribe(String str, int i, IMqttMessageListener iMqttMessageListener);

    void subscribe(String str, IMqttMessageListener iMqttMessageListener);

    void subscribe(String[] strArr);

    void subscribe(String[] strArr, int[] iArr);

    void subscribe(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr);

    void subscribe(String[] strArr, IMqttMessageListener[] iMqttMessageListenerArr);

    void unsubscribe(String str);

    void unsubscribe(String[] strArr);
}
