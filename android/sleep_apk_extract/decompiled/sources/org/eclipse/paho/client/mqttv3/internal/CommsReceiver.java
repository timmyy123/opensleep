package org.eclipse.paho.client.mqttv3.internal;

import java.io.IOException;
import java.io.InputStream;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttInputStream;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class CommsReceiver implements Runnable {
    private static final String CLASS_NAME;
    static /* synthetic */ Class class$0;
    private static final Logger log;
    private ClientComms clientComms;
    private ClientState clientState;
    private MqttInputStream in;
    private volatile boolean receiving;
    private CommsTokenStore tokenStore;
    private boolean running = false;
    private Object lifecycle = new Object();
    private Thread recThread = null;

    static {
        Class<CommsReceiver> cls = class$0;
        if (cls == null) {
            cls = CommsReceiver.class;
            class$0 = cls;
        }
        String name = cls.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public CommsReceiver(ClientComms clientComms, ClientState clientState, CommsTokenStore commsTokenStore, InputStream inputStream) {
        this.clientState = null;
        this.clientComms = null;
        this.tokenStore = null;
        this.in = new MqttInputStream(clientState, inputStream);
        this.clientComms = clientComms;
        this.clientState = clientState;
        this.tokenStore = commsTokenStore;
        log.setResourceName(clientComms.getClient().getClientId());
    }

    public boolean isReceiving() {
        return this.receiving;
    }

    public boolean isRunning() {
        return this.running;
    }

    @Override // java.lang.Runnable
    public void run() {
        MqttToken token = null;
        while (this.running && this.in != null) {
            try {
                try {
                    log.fine(CLASS_NAME, "run", "852");
                    this.receiving = this.in.available() > 0;
                    MqttWireMessage mqttWireMessage = this.in.readMqttWireMessage();
                    this.receiving = false;
                    if (mqttWireMessage instanceof MqttAck) {
                        token = this.tokenStore.getToken(mqttWireMessage);
                        if (token == null) {
                            throw new MqttException(6);
                        }
                        synchronized (token) {
                            this.clientState.notifyReceivedAck((MqttAck) mqttWireMessage);
                        }
                    } else {
                        this.clientState.notifyReceivedMsg(mqttWireMessage);
                    }
                } catch (IOException e) {
                    log.fine(CLASS_NAME, "run", "853");
                    this.running = false;
                    if (!this.clientComms.isDisconnecting()) {
                        this.clientComms.shutdownConnection(token, new MqttException(32109, e));
                    }
                } catch (MqttException e2) {
                    log.fine(CLASS_NAME, "run", "856", null, e2);
                    this.running = false;
                    this.clientComms.shutdownConnection(token, e2);
                }
                this.receiving = false;
            } catch (Throwable th) {
                this.receiving = false;
                throw th;
            }
        }
        log.fine(CLASS_NAME, "run", "854");
    }

    public void start(String str) {
        log.fine(CLASS_NAME, "start", "855");
        synchronized (this.lifecycle) {
            try {
                if (!this.running) {
                    this.running = true;
                    Thread thread = new Thread(this, str);
                    this.recThread = thread;
                    thread.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void stop() {
        synchronized (this.lifecycle) {
            log.fine(CLASS_NAME, "stop", "850");
            if (this.running) {
                this.running = false;
                this.receiving = false;
                if (!Thread.currentThread().equals(this.recThread)) {
                    try {
                        this.recThread.join();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
        this.recThread = null;
        log.fine(CLASS_NAME, "stop", "851");
    }
}
