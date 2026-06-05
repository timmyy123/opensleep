package twitter4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Logger {
    private static final LoggerFactory LOGGER_FACTORY;

    static {
        String property = System.getProperty("twitter4j.loggerFactory");
        if (property == null) {
            property = System.getenv("twitter4j_loggerFactory");
        }
        LoggerFactory loggerFactoryIfAvailable = property != null ? getLoggerFactoryIfAvailable(property, property) : null;
        Configuration configurationContext = ConfigurationContext.getInstance();
        String loggerFactory = configurationContext.getLoggerFactory();
        if (loggerFactory != null) {
            loggerFactoryIfAvailable = getLoggerFactoryIfAvailable(loggerFactory, loggerFactory);
        }
        if (loggerFactoryIfAvailable == null) {
            loggerFactoryIfAvailable = getLoggerFactoryIfAvailable("org.slf4j.impl.StaticLoggerBinder", "twitter4j.SLF4JLoggerFactory");
        }
        if (loggerFactoryIfAvailable == null) {
            loggerFactoryIfAvailable = getLoggerFactoryIfAvailable("org.apache.commons.logging.Log", "twitter4j.CommonsLoggingLoggerFactory");
        }
        if (loggerFactoryIfAvailable == null) {
            loggerFactoryIfAvailable = getLoggerFactoryIfAvailable("org.apache.log4j.Logger", "twitter4j.Log4JLoggerFactory");
        }
        if (loggerFactoryIfAvailable == null) {
            loggerFactoryIfAvailable = getLoggerFactoryIfAvailable("com.google.appengine.api.urlfetch.URLFetchService", "twitter4j.JULLoggerFactory");
        }
        if (loggerFactoryIfAvailable == null) {
            loggerFactoryIfAvailable = new StdOutLoggerFactory();
        }
        LOGGER_FACTORY = loggerFactoryIfAvailable;
        try {
            Method method = configurationContext.getClass().getMethod("dumpConfiguration", null);
            method.setAccessible(true);
            method.invoke(configurationContext, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }

    public static Logger getLogger(Class<?> cls) {
        return LOGGER_FACTORY.getLogger(cls);
    }

    private static LoggerFactory getLoggerFactoryIfAvailable(String str, String str2) {
        try {
            Class.forName(str);
            return (LoggerFactory) Class.forName(str2).newInstance();
        } catch (ClassNotFoundException | SecurityException unused) {
            return null;
        } catch (IllegalAccessException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e);
            return null;
        } catch (InstantiationException e2) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e2);
            return null;
        }
    }

    public abstract void debug(String str);

    public abstract void debug(String str, String str2);

    public abstract void error(String str);

    public abstract void error(String str, Throwable th);

    public abstract boolean isDebugEnabled();
}
