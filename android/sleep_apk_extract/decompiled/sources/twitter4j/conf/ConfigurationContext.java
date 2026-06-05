package twitter4j.conf;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class ConfigurationContext {
    private static final String CONFIGURATION_IMPL = "twitter4j.configurationFactory";
    private static final String DEFAULT_CONFIGURATION_FACTORY = "twitter4j.conf.PropertyConfigurationFactory";
    private static final ConfigurationFactory factory;

    static {
        String property = DEFAULT_CONFIGURATION_FACTORY;
        try {
            property = System.getProperty(CONFIGURATION_IMPL, DEFAULT_CONFIGURATION_FACTORY);
        } catch (SecurityException unused) {
        }
        try {
            factory = (ConfigurationFactory) Class.forName(property).newInstance();
        } catch (ClassNotFoundException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e);
        } catch (IllegalAccessException e2) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e2);
        } catch (InstantiationException e3) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e3);
        }
    }

    public static Configuration getInstance() {
        return factory.getInstance();
    }

    public static Configuration getInstance(String str) {
        return factory.getInstance(str);
    }
}
