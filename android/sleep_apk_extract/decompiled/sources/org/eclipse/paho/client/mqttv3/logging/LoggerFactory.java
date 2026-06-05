package org.eclipse.paho.client.mqttv3.logging;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* JADX INFO: loaded from: classes5.dex */
public class LoggerFactory {
    private static final String CLASS_NAME;
    public static final String MQTT_CLIENT_MSG_CAT = "org.eclipse.paho.client.mqttv3.internal.nls.logcat";
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;
    private static String jsr47LoggerClassName;
    private static String overrideloggerClassName;

    static {
        Class<LoggerFactory> cls = class$0;
        if (cls == null) {
            cls = LoggerFactory.class;
            class$0 = cls;
        }
        CLASS_NAME = cls.getName();
        overrideloggerClassName = null;
        Class<JSR47Logger> cls2 = class$1;
        if (cls2 == null) {
            cls2 = JSR47Logger.class;
            class$1 = cls2;
        }
        jsr47LoggerClassName = cls2.getName();
    }

    public static Logger getLogger(String str, String str2) {
        String str3 = overrideloggerClassName;
        if (str3 == null) {
            str3 = jsr47LoggerClassName;
        }
        Logger logger = getLogger(str3, ResourceBundle.getBundle(str), str2, null);
        if (logger != null) {
            return logger;
        }
        throw new MissingResourceException("Error locating the logging class", CLASS_NAME, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 5 */
    public static String getLoggingProperty(String str) {
        try {
            Class<?> cls = Class.forName("java.util.logging.LogManager");
            Object objInvoke = cls.getMethod("getLogManager", null).invoke(null, null);
            Class<String> cls2 = class$2;
            if (cls2 == null) {
                cls2 = String.class;
                class$2 = cls2;
            }
            return (String) cls.getMethod("getProperty", cls2).invoke(objInvoke, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void setLogger(String str) {
        overrideloggerClassName = str;
    }

    private static Logger getLogger(String str, ResourceBundle resourceBundle, String str2, String str3) {
        try {
            Logger logger = (Logger) Class.forName(str).newInstance();
            logger.initialise(resourceBundle, str2, str3);
            return logger;
        } catch (ClassNotFoundException | ExceptionInInitializerError | IllegalAccessException | InstantiationException | NoClassDefFoundError | SecurityException unused) {
            return null;
        }
    }
}
