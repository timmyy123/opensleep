package twitter4j.conf;

/* JADX INFO: loaded from: classes5.dex */
class PropertyConfigurationFactory implements ConfigurationFactory {
    private static final PropertyConfiguration ROOT_CONFIGURATION = new PropertyConfiguration();

    @Override // twitter4j.conf.ConfigurationFactory
    public void dispose() {
    }

    @Override // twitter4j.conf.ConfigurationFactory
    public Configuration getInstance(String str) {
        PropertyConfiguration propertyConfiguration = new PropertyConfiguration(str);
        propertyConfiguration.dumpConfiguration();
        return propertyConfiguration;
    }

    @Override // twitter4j.conf.ConfigurationFactory
    public Configuration getInstance() {
        return ROOT_CONFIGURATION;
    }
}
