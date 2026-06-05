package org.eclipse.paho.client.mqttv3.util;

import java.util.Enumeration;
import java.util.Properties;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class Debug {
    private static final String CLASS_NAME;
    static /* synthetic */ Class class$0 = null;
    private static final String lineSep;
    private static final Logger log;
    private static final String separator = "==============";
    private String clientID;
    private ClientComms comms;

    static {
        Class<ClientComms> cls = class$0;
        if (cls == null) {
            try {
                cls = ClientComms.class;
                String str = ClientComms.VERSION;
                class$0 = cls;
            } catch (ClassNotFoundException e) {
                Types$$ExternalSyntheticBUOutline0.m(e.getMessage());
                return;
            }
        }
        String name = cls.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
        lineSep = System.getProperty("line.separator", "\n");
    }

    public Debug(String str, ClientComms clientComms) {
        this.clientID = str;
        this.comms = clientComms;
        log.setResourceName(str);
    }

    public static String dumpProperties(Properties properties, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        String str2 = lineSep;
        StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(str2));
        stringBuffer2.append("============== ");
        stringBuffer2.append(str);
        stringBuffer2.append(" ==============");
        stringBuffer2.append(str2);
        stringBuffer.append(stringBuffer2.toString());
        while (enumerationPropertyNames.hasMoreElements()) {
            String str3 = (String) enumerationPropertyNames.nextElement();
            StringBuffer stringBuffer3 = new StringBuffer(String.valueOf(left(str3, 28, ' ')));
            stringBuffer3.append(":  ");
            stringBuffer3.append(properties.get(str3));
            stringBuffer3.append(lineSep);
            stringBuffer.append(stringBuffer3.toString());
        }
        StringBuffer stringBuffer4 = new StringBuffer("==========================================");
        stringBuffer4.append(lineSep);
        stringBuffer.append(stringBuffer4.toString());
        return stringBuffer.toString();
    }

    public static String left(String str, int i, char c) {
        if (str.length() >= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(str);
        int length = i - str.length();
        while (true) {
            length--;
            if (length < 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(c);
        }
    }

    public void dumpBaseDebug() {
        dumpVersion();
        dumpSystemProperties();
        dumpMemoryTrace();
    }

    public void dumpClientComms() {
        ClientComms clientComms = this.comms;
        if (clientComms != null) {
            log.fine(CLASS_NAME, "dumpClientComms", dumpProperties(clientComms.getDebug(), String.valueOf(this.clientID).concat(" : ClientComms")).toString());
        }
    }

    public void dumpClientDebug() {
        dumpClientComms();
        dumpConOptions();
        dumpClientState();
        dumpBaseDebug();
    }

    public void dumpClientState() {
        ClientComms clientComms = this.comms;
        if (clientComms == null || clientComms.getClientState() == null) {
            return;
        }
        log.fine(CLASS_NAME, "dumpClientState", dumpProperties(this.comms.getClientState().getDebug(), String.valueOf(this.clientID).concat(" : ClientState")).toString());
    }

    public void dumpConOptions() {
        ClientComms clientComms = this.comms;
        if (clientComms != null) {
            log.fine(CLASS_NAME, "dumpConOptions", dumpProperties(clientComms.getConOptions().getDebug(), String.valueOf(this.clientID).concat(" : Connect Options")).toString());
        }
    }

    public void dumpMemoryTrace() {
        log.dumpTrace();
    }

    public void dumpSystemProperties() {
        log.fine(CLASS_NAME, "dumpSystemProperties", dumpProperties(System.getProperties(), "SystemProperties").toString());
    }

    public void dumpVersion() {
        StringBuffer stringBuffer = new StringBuffer();
        String str = lineSep;
        StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(str));
        stringBuffer2.append("============== Version Info ==============");
        stringBuffer2.append(str);
        stringBuffer.append(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer(String.valueOf(left("Version", 20, ' ')));
        stringBuffer3.append(":  ");
        stringBuffer3.append(ClientComms.VERSION);
        stringBuffer3.append(str);
        stringBuffer.append(stringBuffer3.toString());
        StringBuffer stringBuffer4 = new StringBuffer(String.valueOf(left("Build Level", 20, ' ')));
        stringBuffer4.append(":  ");
        stringBuffer4.append(ClientComms.BUILD_LEVEL);
        stringBuffer4.append(str);
        stringBuffer.append(stringBuffer4.toString());
        StringBuffer stringBuffer5 = new StringBuffer("==========================================");
        stringBuffer5.append(str);
        stringBuffer.append(stringBuffer5.toString());
        log.fine(CLASS_NAME, "dumpVersion", stringBuffer.toString());
    }
}
