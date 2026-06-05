package org.eclipse.paho.client.mqttv3;

/* JADX INFO: loaded from: classes5.dex */
public interface MqttPersistable {
    byte[] getHeaderBytes();

    int getHeaderLength();

    int getHeaderOffset();

    byte[] getPayloadBytes();

    int getPayloadLength();

    int getPayloadOffset();
}
