package org.eclipse.paho.client.mqttv3.persist;

import java.util.Enumeration;
import java.util.Hashtable;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttPersistable;

/* JADX INFO: loaded from: classes5.dex */
public class MemoryPersistence implements MqttClientPersistence {

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private Hashtable f123data;

    @Override // org.eclipse.paho.client.mqttv3.MqttClientPersistence
    public void clear() {
        this.f123data.clear();
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttClientPersistence
    public void close() {
        this.f123data.clear();
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttClientPersistence
    public boolean containsKey(String str) {
        return this.f123data.containsKey(str);
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttClientPersistence
    public MqttPersistable get(String str) {
        return (MqttPersistable) this.f123data.get(str);
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttClientPersistence
    public Enumeration keys() {
        return this.f123data.keys();
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttClientPersistence
    public void open(String str, String str2) {
        this.f123data = new Hashtable();
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttClientPersistence
    public void put(String str, MqttPersistable mqttPersistable) {
        this.f123data.put(str, mqttPersistable);
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttClientPersistence
    public void remove(String str) {
        this.f123data.remove(str);
    }
}
