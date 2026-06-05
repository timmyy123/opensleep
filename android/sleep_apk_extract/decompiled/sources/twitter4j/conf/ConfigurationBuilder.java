package twitter4j.conf;

import java.util.Properties;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class ConfigurationBuilder {
    private ConfigurationBase configurationBean = new PropertyConfiguration();

    private void checkNotBuilt() {
        if (this.configurationBean != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Cannot use this builder any longer, build() has already been called");
    }

    public Configuration build() {
        checkNotBuilt();
        this.configurationBean.cacheInstance();
        try {
            return this.configurationBean;
        } finally {
            this.configurationBean = null;
        }
    }

    public ConfigurationBuilder setApplicationOnlyAuthEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setApplicationOnlyAuthEnabled(z);
        return this;
    }

    public ConfigurationBuilder setAsyncNumThreads(int i) {
        checkNotBuilt();
        this.configurationBean.setAsyncNumThreads(i);
        return this;
    }

    public ConfigurationBuilder setContributingTo(long j) {
        checkNotBuilt();
        this.configurationBean.setContributingTo(j);
        return this;
    }

    public ConfigurationBuilder setDaemonEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setDaemonEnabled(z);
        return this;
    }

    public ConfigurationBuilder setDebugEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setDebug(z);
        return this;
    }

    public ConfigurationBuilder setDispatcherImpl(String str) {
        checkNotBuilt();
        this.configurationBean.setDispatcherImpl(str);
        return this;
    }

    public ConfigurationBuilder setGZIPEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setGZIPEnabled(z);
        return this;
    }

    public ConfigurationBuilder setHttpConnectionTimeout(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpConnectionTimeout(i);
        return this;
    }

    public ConfigurationBuilder setHttpProxyHost(String str) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyHost(str);
        return this;
    }

    public ConfigurationBuilder setHttpProxyPassword(String str) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyPassword(str);
        return this;
    }

    public ConfigurationBuilder setHttpProxyPort(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyPort(i);
        return this;
    }

    public ConfigurationBuilder setHttpProxySocks(boolean z) {
        checkNotBuilt();
        this.configurationBean.setHttpProxySocks(z);
        return this;
    }

    public ConfigurationBuilder setHttpProxyUser(String str) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyUser(str);
        return this;
    }

    public ConfigurationBuilder setHttpReadTimeout(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpReadTimeout(i);
        return this;
    }

    public ConfigurationBuilder setHttpRetryCount(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpRetryCount(i);
        return this;
    }

    public ConfigurationBuilder setHttpRetryIntervalSeconds(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpRetryIntervalSeconds(i);
        return this;
    }

    public ConfigurationBuilder setHttpStreamingReadTimeout(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpStreamingReadTimeout(i);
        return this;
    }

    public ConfigurationBuilder setIncludeEmailEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setIncludeEmailEnabled(z);
        return this;
    }

    public ConfigurationBuilder setIncludeEntitiesEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setIncludeEntitiesEnabled(z);
        return this;
    }

    public ConfigurationBuilder setIncludeExtAltTextEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setIncludeExtAltTextEnabled(z);
        return this;
    }

    public ConfigurationBuilder setIncludeMyRetweetEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setIncludeMyRetweetEnabled(z);
        return this;
    }

    public ConfigurationBuilder setJSONStoreEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setJSONStoreEnabled(z);
        return this;
    }

    public ConfigurationBuilder setMBeanEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setMBeanEnabled(z);
        return this;
    }

    public ConfigurationBuilder setMediaProvider(String str) {
        checkNotBuilt();
        this.configurationBean.setMediaProvider(str);
        return this;
    }

    public ConfigurationBuilder setMediaProviderAPIKey(String str) {
        checkNotBuilt();
        this.configurationBean.setMediaProviderAPIKey(str);
        return this;
    }

    public ConfigurationBuilder setMediaProviderParameters(Properties properties) {
        checkNotBuilt();
        this.configurationBean.setMediaProviderParameters(properties);
        return this;
    }

    public ConfigurationBuilder setOAuth2AccessToken(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuth2AccessToken(str);
        return this;
    }

    public ConfigurationBuilder setOAuth2InvalidateTokenURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuth2InvalidateTokenURL(str);
        return this;
    }

    public ConfigurationBuilder setOAuth2Scope(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuth2Scope(str);
        return this;
    }

    public ConfigurationBuilder setOAuth2TokenType(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuth2TokenType(str);
        return this;
    }

    public ConfigurationBuilder setOAuth2TokenURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuth2TokenURL(str);
        return this;
    }

    public ConfigurationBuilder setOAuthAccessToken(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAccessToken(str);
        return this;
    }

    public ConfigurationBuilder setOAuthAccessTokenSecret(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAccessTokenSecret(str);
        return this;
    }

    public ConfigurationBuilder setOAuthAccessTokenURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAccessTokenURL(str);
        return this;
    }

    public ConfigurationBuilder setOAuthAuthenticationURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAuthenticationURL(str);
        return this;
    }

    public ConfigurationBuilder setOAuthAuthorizationURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAuthorizationURL(str);
        return this;
    }

    public ConfigurationBuilder setOAuthConsumerKey(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthConsumerKey(str);
        return this;
    }

    public ConfigurationBuilder setOAuthConsumerSecret(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthConsumerSecret(str);
        return this;
    }

    public ConfigurationBuilder setOAuthRequestTokenURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthRequestTokenURL(str);
        return this;
    }

    public ConfigurationBuilder setPassword(String str) {
        checkNotBuilt();
        this.configurationBean.setPassword(str);
        return this;
    }

    public ConfigurationBuilder setPrettyDebugEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setPrettyDebugEnabled(z);
        return this;
    }

    public ConfigurationBuilder setRestBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setRestBaseURL(str);
        return this;
    }

    public ConfigurationBuilder setSiteStreamBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setSiteStreamBaseURL(str);
        return this;
    }

    public ConfigurationBuilder setStreamBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setStreamBaseURL(str);
        return this;
    }

    public ConfigurationBuilder setTrimUserEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setTrimUserEnabled(z);
        return this;
    }

    public ConfigurationBuilder setTweetModeExtended(boolean z) {
        checkNotBuilt();
        this.configurationBean.setTweetModeExtended(z);
        return this;
    }

    public ConfigurationBuilder setUploadBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setUploadBaseURL(str);
        return this;
    }

    public ConfigurationBuilder setUser(String str) {
        checkNotBuilt();
        this.configurationBean.setUser(str);
        return this;
    }

    public ConfigurationBuilder setUserStreamBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setUserStreamBaseURL(str);
        return this;
    }

    public ConfigurationBuilder setUserStreamRepliesAllEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setUserStreamRepliesAllEnabled(z);
        return this;
    }

    public ConfigurationBuilder setUserStreamWithFollowingsEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setUserStreamWithFollowingsEnabled(z);
        return this;
    }
}
