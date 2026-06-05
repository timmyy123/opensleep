package org.eclipse.paho.client.mqttv3.internal;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class CommsTokenStore {
    private static final String CLASS_NAME;
    static /* synthetic */ Class class$0;
    private static final Logger log;
    private MqttException closedResponse = null;
    private String logContext;
    private Hashtable tokens;

    static {
        Class<CommsTokenStore> cls = class$0;
        if (cls == null) {
            cls = CommsTokenStore.class;
            class$0 = cls;
        }
        String name = cls.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public CommsTokenStore(String str) {
        Logger logger = log;
        logger.setResourceName(str);
        this.tokens = new Hashtable();
        this.logContext = str;
        logger.fine(CLASS_NAME, "<Init>", "308");
    }

    public void clear() {
        log.fine(CLASS_NAME, "clear", "305", new Object[]{new Integer(this.tokens.size())});
        synchronized (this.tokens) {
            this.tokens.clear();
        }
    }

    public int count() {
        int size;
        synchronized (this.tokens) {
            size = this.tokens.size();
        }
        return size;
    }

    public MqttDeliveryToken[] getOutstandingDelTokens() {
        MqttDeliveryToken[] mqttDeliveryTokenArr;
        synchronized (this.tokens) {
            try {
                log.fine(CLASS_NAME, "getOutstandingDelTokens", "311");
                Vector vector = new Vector();
                Enumeration enumerationElements = this.tokens.elements();
                while (enumerationElements.hasMoreElements()) {
                    MqttToken mqttToken = (MqttToken) enumerationElements.nextElement();
                    if (mqttToken != null && (mqttToken instanceof MqttDeliveryToken) && !mqttToken.internalTok.isNotified()) {
                        vector.addElement(mqttToken);
                    }
                }
                mqttDeliveryTokenArr = (MqttDeliveryToken[]) vector.toArray(new MqttDeliveryToken[vector.size()]);
            } catch (Throwable th) {
                throw th;
            }
        }
        return mqttDeliveryTokenArr;
    }

    public Vector getOutstandingTokens() {
        Vector vector;
        synchronized (this.tokens) {
            try {
                log.fine(CLASS_NAME, "getOutstandingTokens", "312");
                vector = new Vector();
                Enumeration enumerationElements = this.tokens.elements();
                while (enumerationElements.hasMoreElements()) {
                    MqttToken mqttToken = (MqttToken) enumerationElements.nextElement();
                    if (mqttToken != null) {
                        vector.addElement(mqttToken);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return vector;
    }

    public MqttToken getToken(MqttWireMessage mqttWireMessage) {
        return (MqttToken) this.tokens.get(mqttWireMessage.getKey());
    }

    public void open() {
        synchronized (this.tokens) {
            log.fine(CLASS_NAME, "open", "310");
            this.closedResponse = null;
        }
    }

    public void quiesce(MqttException mqttException) {
        synchronized (this.tokens) {
            log.fine(CLASS_NAME, "quiesce", "309", new Object[]{mqttException});
            this.closedResponse = mqttException;
        }
    }

    public MqttToken removeToken(String str) {
        log.fine(CLASS_NAME, "removeToken", "306", new Object[]{str});
        if (str != null) {
            return (MqttToken) this.tokens.remove(str);
        }
        return null;
    }

    public MqttDeliveryToken restoreToken(MqttPublish mqttPublish) {
        MqttDeliveryToken mqttDeliveryToken;
        synchronized (this.tokens) {
            try {
                String string = new Integer(mqttPublish.getMessageId()).toString();
                if (this.tokens.containsKey(string)) {
                    mqttDeliveryToken = (MqttDeliveryToken) this.tokens.get(string);
                    log.fine(CLASS_NAME, "restoreToken", "302", new Object[]{string, mqttPublish, mqttDeliveryToken});
                } else {
                    MqttDeliveryToken mqttDeliveryToken2 = new MqttDeliveryToken(this.logContext);
                    mqttDeliveryToken2.internalTok.setKey(string);
                    this.tokens.put(string, mqttDeliveryToken2);
                    log.fine(CLASS_NAME, "restoreToken", "303", new Object[]{string, mqttPublish, mqttDeliveryToken2});
                    mqttDeliveryToken = mqttDeliveryToken2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mqttDeliveryToken;
    }

    public void saveToken(MqttToken mqttToken, String str) {
        synchronized (this.tokens) {
            log.fine(CLASS_NAME, "saveToken", "307", new Object[]{str, mqttToken.toString()});
            mqttToken.internalTok.setKey(str);
            this.tokens.put(str, mqttToken);
        }
    }

    public String toString() {
        String string;
        String property = System.getProperty("line.separator", "\n");
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (this.tokens) {
            try {
                Enumeration enumerationElements = this.tokens.elements();
                while (enumerationElements.hasMoreElements()) {
                    MqttToken mqttToken = (MqttToken) enumerationElements.nextElement();
                    StringBuffer stringBuffer2 = new StringBuffer("{");
                    stringBuffer2.append(mqttToken.internalTok);
                    stringBuffer2.append("}");
                    stringBuffer2.append(property);
                    stringBuffer.append(stringBuffer2.toString());
                }
                string = stringBuffer.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    public MqttToken getToken(String str) {
        return (MqttToken) this.tokens.get(str);
    }

    public MqttToken removeToken(MqttWireMessage mqttWireMessage) {
        if (mqttWireMessage != null) {
            return removeToken(mqttWireMessage.getKey());
        }
        return null;
    }

    public void saveToken(MqttToken mqttToken, MqttWireMessage mqttWireMessage) {
        synchronized (this.tokens) {
            try {
                MqttException mqttException = this.closedResponse;
                if (mqttException == null) {
                    String key = mqttWireMessage.getKey();
                    log.fine(CLASS_NAME, "saveToken", "300", new Object[]{key, mqttWireMessage});
                    saveToken(mqttToken, key);
                } else {
                    throw mqttException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
