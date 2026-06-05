package twitter4j.conf;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import twitter4j.HttpClientConfiguration;
import twitter4j.Logger;

/* JADX INFO: loaded from: classes5.dex */
class ConfigurationBase implements Configuration, Serializable {
    private static final List<ConfigurationBase> instances = new ArrayList();
    private static final long serialVersionUID = 6175546394599249696L;
    private String oAuth2AccessToken;
    private String oAuth2Scope;
    private String oAuth2TokenType;
    private boolean debug = false;
    private String user = null;
    private String password = null;
    private int httpStreamingReadTimeout = 40000;
    private int httpRetryCount = 0;
    private int httpRetryIntervalSeconds = 5;
    private String oAuthConsumerKey = null;
    private String oAuthConsumerSecret = null;
    private String oAuthAccessToken = null;
    private String oAuthAccessTokenSecret = null;
    private String oAuthRequestTokenURL = "https://api.twitter.com/oauth/request_token";
    private String oAuthAuthorizationURL = "https://api.twitter.com/oauth/authorize";
    private String oAuthAccessTokenURL = "https://api.twitter.com/oauth/access_token";
    private String oAuthAuthenticationURL = "https://api.twitter.com/oauth/authenticate";
    private String oAuth2TokenURL = "https://api.twitter.com/oauth2/token";
    private String oAuth2InvalidateTokenURL = "https://api.twitter.com/oauth2/invalidate_token";
    private String restBaseURL = "https://api.twitter.com/1.1/";
    private String streamBaseURL = "https://stream.twitter.com/1.1/";
    private String userStreamBaseURL = "https://userstream.twitter.com/1.1/";
    private String siteStreamBaseURL = "https://sitestream.twitter.com/1.1/";
    private String uploadBaseURL = "https://upload.twitter.com/1.1/";
    private String dispatcherImpl = "twitter4j.DispatcherImpl";
    private int asyncNumThreads = 1;
    private String loggerFactory = null;
    private long contributingTo = -1;
    private boolean includeMyRetweetEnabled = true;
    private boolean includeEntitiesEnabled = true;
    private boolean trimUserEnabled = false;
    private boolean includeExtAltTextEnabled = true;
    private boolean tweetModeExtended = true;
    private boolean includeEmailEnabled = false;
    private boolean jsonStoreEnabled = false;
    private boolean mbeanEnabled = false;
    private boolean userStreamRepliesAllEnabled = false;
    private boolean userStreamWithFollowingsEnabled = true;
    private boolean stallWarningsEnabled = true;
    private boolean applicationOnlyAuthEnabled = false;
    private String mediaProvider = "TWITTER";
    private String mediaProviderAPIKey = null;
    private Properties mediaProviderParameters = null;
    private boolean daemonEnabled = true;
    private String streamThreadName = "";
    private HttpClientConfiguration httpConf = new MyHttpClientConfiguration(null, null, null, -1, false, 20000, 120000, false, true);

    public class MyHttpClientConfiguration implements HttpClientConfiguration, Serializable {
        private static final long serialVersionUID = 8226866124868861058L;
        private boolean gzipEnabled;
        private int httpConnectionTimeout;
        private String httpProxyHost;
        private String httpProxyPassword;
        private int httpProxyPort;
        private boolean httpProxySocks;
        private String httpProxyUser;
        private int httpReadTimeout;
        private boolean prettyDebug;

        public MyHttpClientConfiguration(String str, String str2, String str3, int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
            this.httpProxyHost = str;
            this.httpProxyUser = str2;
            this.httpProxyPassword = str3;
            this.httpProxyPort = i;
            this.httpProxySocks = z;
            this.httpConnectionTimeout = i2;
            this.httpReadTimeout = i3;
            this.prettyDebug = z2;
            this.gzipEnabled = z3;
        }

        public boolean equals(Object obj) {
            boolean z;
            boolean z2;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MyHttpClientConfiguration myHttpClientConfiguration = (MyHttpClientConfiguration) obj;
            if (this.gzipEnabled != myHttpClientConfiguration.gzipEnabled || (z = this.httpProxySocks) != (z2 = myHttpClientConfiguration.httpProxySocks) || this.httpConnectionTimeout != myHttpClientConfiguration.httpConnectionTimeout || this.httpProxyPort != myHttpClientConfiguration.httpProxyPort || z != z2 || this.httpReadTimeout != myHttpClientConfiguration.httpReadTimeout || this.prettyDebug != myHttpClientConfiguration.prettyDebug) {
                return false;
            }
            String str = this.httpProxyHost;
            String str2 = myHttpClientConfiguration.httpProxyHost;
            if (str == null ? str2 != null : !str.equals(str2)) {
                return false;
            }
            String str3 = this.httpProxyPassword;
            String str4 = myHttpClientConfiguration.httpProxyPassword;
            if (str3 == null ? str4 != null : !str3.equals(str4)) {
                return false;
            }
            String str5 = this.httpProxyUser;
            String str6 = myHttpClientConfiguration.httpProxyUser;
            return str5 == null ? str6 == null : str5.equals(str6);
        }

        @Override // twitter4j.HttpClientConfiguration
        public int getHttpConnectionTimeout() {
            return this.httpConnectionTimeout;
        }

        @Override // twitter4j.HttpClientConfiguration
        public String getHttpProxyHost() {
            return this.httpProxyHost;
        }

        @Override // twitter4j.HttpClientConfiguration
        public String getHttpProxyPassword() {
            return this.httpProxyPassword;
        }

        @Override // twitter4j.HttpClientConfiguration
        public int getHttpProxyPort() {
            return this.httpProxyPort;
        }

        @Override // twitter4j.HttpClientConfiguration
        public String getHttpProxyUser() {
            return this.httpProxyUser;
        }

        @Override // twitter4j.HttpClientConfiguration
        public int getHttpReadTimeout() {
            return this.httpReadTimeout;
        }

        @Override // twitter4j.HttpClientConfiguration
        public int getHttpRetryCount() {
            return ConfigurationBase.this.httpRetryCount;
        }

        @Override // twitter4j.HttpClientConfiguration
        public int getHttpRetryIntervalSeconds() {
            return ConfigurationBase.this.httpRetryIntervalSeconds;
        }

        public int hashCode() {
            String str = this.httpProxyHost;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.httpProxyUser;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.httpProxyPassword;
            return ((((((((((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.httpProxyPort) * 31) + (this.httpProxySocks ? 1 : 0)) * 31) + this.httpConnectionTimeout) * 31) + this.httpReadTimeout) * 31) + (this.prettyDebug ? 1 : 0)) * 31) + (this.gzipEnabled ? 1 : 0);
        }

        @Override // twitter4j.HttpClientConfiguration
        public boolean isGZIPEnabled() {
            return this.gzipEnabled;
        }

        @Override // twitter4j.HttpClientConfiguration
        public boolean isHttpProxySocks() {
            return this.httpProxySocks;
        }

        @Override // twitter4j.HttpClientConfiguration
        public boolean isPrettyDebugEnabled() {
            return this.prettyDebug;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MyHttpClientConfiguration{httpProxyHost='");
            sb.append(this.httpProxyHost);
            sb.append("', httpProxyUser='");
            sb.append(this.httpProxyUser);
            sb.append("', httpProxyPassword='");
            sb.append(this.httpProxyPassword);
            sb.append("', httpProxyPort=");
            sb.append(this.httpProxyPort);
            sb.append(", proxyType=");
            sb.append(this.httpProxySocks ? Proxy.Type.SOCKS : Proxy.Type.HTTP);
            sb.append(", httpConnectionTimeout=");
            sb.append(this.httpConnectionTimeout);
            sb.append(", httpReadTimeout=");
            sb.append(this.httpReadTimeout);
            sb.append(", prettyDebug=");
            sb.append(this.prettyDebug);
            sb.append(", gzipEnabled=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, this.gzipEnabled, '}');
        }
    }

    private static void cacheInstance(ConfigurationBase configurationBase) {
        List<ConfigurationBase> list = instances;
        if (list.contains(configurationBase)) {
            return;
        }
        list.add(configurationBase);
    }

    public static String fixURL(boolean z, String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf("://");
        if (-1 != iIndexOf) {
            String strSubstring = str.substring(iIndexOf + 3);
            return z ? "https://".concat(strSubstring) : "http://".concat(strSubstring);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("url should contain '://'");
        return null;
    }

    private static ConfigurationBase getInstance(ConfigurationBase configurationBase) {
        List<ConfigurationBase> list = instances;
        int iIndexOf = list.indexOf(configurationBase);
        if (iIndexOf != -1) {
            return list.get(iIndexOf);
        }
        list.add(configurationBase);
        return configurationBase;
    }

    public void dumpConfiguration() {
        Logger logger = Logger.getLogger(ConfigurationBase.class);
        if (this.debug) {
            for (Field field : ConfigurationBase.class.getDeclaredFields()) {
                try {
                    Object obj = field.get(this);
                    String strValueOf = String.valueOf(obj);
                    if (obj != null && field.getName().matches("oAuthConsumerSecret|oAuthAccessTokenSecret|password")) {
                        strValueOf = String.valueOf(obj).replaceAll(".", "*");
                    }
                    logger.debug(field.getName() + ": " + strValueOf);
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ConfigurationBase configurationBase = (ConfigurationBase) obj;
            if (this.debug != configurationBase.debug || this.httpStreamingReadTimeout != configurationBase.httpStreamingReadTimeout || this.httpRetryCount != configurationBase.httpRetryCount || this.httpRetryIntervalSeconds != configurationBase.httpRetryIntervalSeconds || this.asyncNumThreads != configurationBase.asyncNumThreads || this.contributingTo != configurationBase.contributingTo || this.includeMyRetweetEnabled != configurationBase.includeMyRetweetEnabled || this.includeEntitiesEnabled != configurationBase.includeEntitiesEnabled || this.trimUserEnabled != configurationBase.trimUserEnabled || this.includeExtAltTextEnabled != configurationBase.includeExtAltTextEnabled || this.tweetModeExtended != configurationBase.tweetModeExtended || this.includeEmailEnabled != configurationBase.includeEmailEnabled || this.jsonStoreEnabled != configurationBase.jsonStoreEnabled || this.mbeanEnabled != configurationBase.mbeanEnabled || this.userStreamRepliesAllEnabled != configurationBase.userStreamRepliesAllEnabled || this.userStreamWithFollowingsEnabled != configurationBase.userStreamWithFollowingsEnabled || this.stallWarningsEnabled != configurationBase.stallWarningsEnabled || this.applicationOnlyAuthEnabled != configurationBase.applicationOnlyAuthEnabled || this.daemonEnabled != configurationBase.daemonEnabled) {
                return false;
            }
            String str = this.user;
            String str2 = configurationBase.user;
            if (str == null ? str2 != null : !str.equals(str2)) {
                return false;
            }
            String str3 = this.password;
            String str4 = configurationBase.password;
            if (str3 == null ? str4 != null : !str3.equals(str4)) {
                return false;
            }
            HttpClientConfiguration httpClientConfiguration = this.httpConf;
            HttpClientConfiguration httpClientConfiguration2 = configurationBase.httpConf;
            if (httpClientConfiguration == null ? httpClientConfiguration2 != null : !httpClientConfiguration.equals(httpClientConfiguration2)) {
                return false;
            }
            String str5 = this.oAuthConsumerKey;
            String str6 = configurationBase.oAuthConsumerKey;
            if (str5 == null ? str6 != null : !str5.equals(str6)) {
                return false;
            }
            String str7 = this.oAuthConsumerSecret;
            String str8 = configurationBase.oAuthConsumerSecret;
            if (str7 == null ? str8 != null : !str7.equals(str8)) {
                return false;
            }
            String str9 = this.oAuthAccessToken;
            String str10 = configurationBase.oAuthAccessToken;
            if (str9 == null ? str10 != null : !str9.equals(str10)) {
                return false;
            }
            String str11 = this.oAuthAccessTokenSecret;
            String str12 = configurationBase.oAuthAccessTokenSecret;
            if (str11 == null ? str12 != null : !str11.equals(str12)) {
                return false;
            }
            String str13 = this.oAuth2TokenType;
            String str14 = configurationBase.oAuth2TokenType;
            if (str13 == null ? str14 != null : !str13.equals(str14)) {
                return false;
            }
            String str15 = this.oAuth2AccessToken;
            String str16 = configurationBase.oAuth2AccessToken;
            if (str15 == null ? str16 != null : !str15.equals(str16)) {
                return false;
            }
            String str17 = this.oAuth2Scope;
            String str18 = configurationBase.oAuth2Scope;
            if (str17 == null ? str18 != null : !str17.equals(str18)) {
                return false;
            }
            String str19 = this.oAuthRequestTokenURL;
            String str20 = configurationBase.oAuthRequestTokenURL;
            if (str19 == null ? str20 != null : !str19.equals(str20)) {
                return false;
            }
            String str21 = this.oAuthAuthorizationURL;
            String str22 = configurationBase.oAuthAuthorizationURL;
            if (str21 == null ? str22 != null : !str21.equals(str22)) {
                return false;
            }
            String str23 = this.oAuthAccessTokenURL;
            String str24 = configurationBase.oAuthAccessTokenURL;
            if (str23 == null ? str24 != null : !str23.equals(str24)) {
                return false;
            }
            String str25 = this.oAuthAuthenticationURL;
            String str26 = configurationBase.oAuthAuthenticationURL;
            if (str25 == null ? str26 != null : !str25.equals(str26)) {
                return false;
            }
            String str27 = this.oAuth2TokenURL;
            String str28 = configurationBase.oAuth2TokenURL;
            if (str27 == null ? str28 != null : !str27.equals(str28)) {
                return false;
            }
            String str29 = this.oAuth2InvalidateTokenURL;
            String str30 = configurationBase.oAuth2InvalidateTokenURL;
            if (str29 == null ? str30 != null : !str29.equals(str30)) {
                return false;
            }
            String str31 = this.restBaseURL;
            String str32 = configurationBase.restBaseURL;
            if (str31 == null ? str32 != null : !str31.equals(str32)) {
                return false;
            }
            String str33 = this.streamBaseURL;
            String str34 = configurationBase.streamBaseURL;
            if (str33 == null ? str34 != null : !str33.equals(str34)) {
                return false;
            }
            String str35 = this.userStreamBaseURL;
            String str36 = configurationBase.userStreamBaseURL;
            if (str35 == null ? str36 != null : !str35.equals(str36)) {
                return false;
            }
            String str37 = this.siteStreamBaseURL;
            String str38 = configurationBase.siteStreamBaseURL;
            if (str37 == null ? str38 != null : !str37.equals(str38)) {
                return false;
            }
            String str39 = this.uploadBaseURL;
            String str40 = configurationBase.uploadBaseURL;
            if (str39 == null ? str40 != null : !str39.equals(str40)) {
                return false;
            }
            String str41 = this.dispatcherImpl;
            String str42 = configurationBase.dispatcherImpl;
            if (str41 == null ? str42 != null : !str41.equals(str42)) {
                return false;
            }
            String str43 = this.loggerFactory;
            String str44 = configurationBase.loggerFactory;
            if (str43 == null ? str44 != null : !str43.equals(str44)) {
                return false;
            }
            String str45 = this.mediaProvider;
            String str46 = configurationBase.mediaProvider;
            if (str45 == null ? str46 != null : !str45.equals(str46)) {
                return false;
            }
            String str47 = this.mediaProviderAPIKey;
            String str48 = configurationBase.mediaProviderAPIKey;
            if (str47 == null ? str48 != null : !str47.equals(str48)) {
                return false;
            }
            Properties properties = this.mediaProviderParameters;
            Properties properties2 = configurationBase.mediaProviderParameters;
            if (properties == null ? properties2 != null : !properties.equals(properties2)) {
                return false;
            }
            String str49 = this.streamThreadName;
            String str50 = configurationBase.streamThreadName;
            if (str49 != null) {
                return str49.equals(str50);
            }
            if (str50 == null) {
                return true;
            }
        }
        return false;
    }

    @Override // twitter4j.conf.Configuration
    public final int getAsyncNumThreads() {
        return this.asyncNumThreads;
    }

    @Override // twitter4j.conf.Configuration
    public final long getContributingTo() {
        return this.contributingTo;
    }

    @Override // twitter4j.conf.Configuration
    public String getDispatcherImpl() {
        return this.dispatcherImpl;
    }

    @Override // twitter4j.conf.Configuration
    public HttpClientConfiguration getHttpClientConfiguration() {
        return this.httpConf;
    }

    @Override // twitter4j.conf.Configuration
    public int getHttpStreamingReadTimeout() {
        return this.httpStreamingReadTimeout;
    }

    @Override // twitter4j.conf.Configuration
    public String getLoggerFactory() {
        return this.loggerFactory;
    }

    @Override // twitter4j.conf.Configuration
    public String getMediaProvider() {
        return this.mediaProvider;
    }

    @Override // twitter4j.conf.Configuration
    public String getMediaProviderAPIKey() {
        return this.mediaProviderAPIKey;
    }

    @Override // twitter4j.conf.Configuration
    public Properties getMediaProviderParameters() {
        return this.mediaProviderParameters;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuth2AccessToken() {
        return this.oAuth2AccessToken;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuth2InvalidateTokenURL() {
        return this.oAuth2InvalidateTokenURL;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuth2Scope() {
        return this.oAuth2Scope;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuth2TokenType() {
        return this.oAuth2TokenType;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuth2TokenURL() {
        return this.oAuth2TokenURL;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuthAccessToken() {
        return this.oAuthAccessToken;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuthAccessTokenSecret() {
        return this.oAuthAccessTokenSecret;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuthAccessTokenURL() {
        return this.oAuthAccessTokenURL;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuthAuthenticationURL() {
        return this.oAuthAuthenticationURL;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuthAuthorizationURL() {
        return this.oAuthAuthorizationURL;
    }

    @Override // twitter4j.conf.Configuration
    public final String getOAuthConsumerKey() {
        return this.oAuthConsumerKey;
    }

    @Override // twitter4j.conf.Configuration
    public final String getOAuthConsumerSecret() {
        return this.oAuthConsumerSecret;
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuthRequestTokenURL() {
        return this.oAuthRequestTokenURL;
    }

    @Override // twitter4j.conf.Configuration
    public final String getPassword() {
        return this.password;
    }

    @Override // twitter4j.conf.Configuration
    public String getRestBaseURL() {
        return this.restBaseURL;
    }

    @Override // twitter4j.conf.Configuration
    public String getSiteStreamBaseURL() {
        return this.siteStreamBaseURL;
    }

    @Override // twitter4j.conf.Configuration
    public String getStreamBaseURL() {
        return this.streamBaseURL;
    }

    @Override // twitter4j.conf.Configuration
    public String getStreamThreadName() {
        return this.streamThreadName;
    }

    @Override // twitter4j.conf.Configuration
    public String getUploadBaseURL() {
        return this.uploadBaseURL;
    }

    @Override // twitter4j.conf.Configuration
    public final String getUser() {
        return this.user;
    }

    @Override // twitter4j.conf.Configuration
    public String getUserStreamBaseURL() {
        return this.userStreamBaseURL;
    }

    public int hashCode() {
        int i = (this.debug ? 1 : 0) * 31;
        String str = this.user;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.password;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        HttpClientConfiguration httpClientConfiguration = this.httpConf;
        int iHashCode3 = (((((((iHashCode2 + (httpClientConfiguration != null ? httpClientConfiguration.hashCode() : 0)) * 31) + this.httpStreamingReadTimeout) * 31) + this.httpRetryCount) * 31) + this.httpRetryIntervalSeconds) * 31;
        String str3 = this.oAuthConsumerKey;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.oAuthConsumerSecret;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.oAuthAccessToken;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.oAuthAccessTokenSecret;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.oAuth2TokenType;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.oAuth2AccessToken;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.oAuth2Scope;
        int iHashCode10 = (iHashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.oAuthRequestTokenURL;
        int iHashCode11 = (iHashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.oAuthAuthorizationURL;
        int iHashCode12 = (iHashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.oAuthAccessTokenURL;
        int iHashCode13 = (iHashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.oAuthAuthenticationURL;
        int iHashCode14 = (iHashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.oAuth2TokenURL;
        int iHashCode15 = (iHashCode14 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.oAuth2InvalidateTokenURL;
        int iHashCode16 = (iHashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.restBaseURL;
        int iHashCode17 = (iHashCode16 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.streamBaseURL;
        int iHashCode18 = (iHashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.userStreamBaseURL;
        int iHashCode19 = (iHashCode18 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.siteStreamBaseURL;
        int iHashCode20 = (iHashCode19 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.uploadBaseURL;
        int iHashCode21 = (iHashCode20 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.dispatcherImpl;
        int iHashCode22 = (((iHashCode21 + (str21 != null ? str21.hashCode() : 0)) * 31) + this.asyncNumThreads) * 31;
        String str22 = this.loggerFactory;
        int iHashCode23 = str22 != null ? str22.hashCode() : 0;
        long j = this.contributingTo;
        int i2 = (((((((((((((((((((((((((((iHashCode22 + iHashCode23) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.includeMyRetweetEnabled ? 1 : 0)) * 31) + (this.includeEntitiesEnabled ? 1 : 0)) * 31) + (this.trimUserEnabled ? 1 : 0)) * 31) + (this.includeExtAltTextEnabled ? 1 : 0)) * 31) + (this.tweetModeExtended ? 1 : 0)) * 31) + (this.includeEmailEnabled ? 1 : 0)) * 31) + (this.jsonStoreEnabled ? 1 : 0)) * 31) + (this.mbeanEnabled ? 1 : 0)) * 31) + (this.userStreamRepliesAllEnabled ? 1 : 0)) * 31) + (this.userStreamWithFollowingsEnabled ? 1 : 0)) * 31) + (this.stallWarningsEnabled ? 1 : 0)) * 31) + (this.applicationOnlyAuthEnabled ? 1 : 0)) * 31;
        String str23 = this.mediaProvider;
        int iHashCode24 = (i2 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.mediaProviderAPIKey;
        int iHashCode25 = (iHashCode24 + (str24 != null ? str24.hashCode() : 0)) * 31;
        Properties properties = this.mediaProviderParameters;
        int iHashCode26 = (((iHashCode25 + (properties != null ? properties.hashCode() : 0)) * 31) + (this.daemonEnabled ? 1 : 0)) * 31;
        String str25 = this.streamThreadName;
        return iHashCode26 + (str25 != null ? str25.hashCode() : 0);
    }

    @Override // twitter4j.conf.Configuration
    public boolean isApplicationOnlyAuthEnabled() {
        return this.applicationOnlyAuthEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isDaemonEnabled() {
        return this.daemonEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public final boolean isDebugEnabled() {
        return this.debug;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isIncludeEmailEnabled() {
        return this.includeEmailEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isIncludeEntitiesEnabled() {
        return this.includeEntitiesEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isIncludeExtAltTextEnabled() {
        return this.includeExtAltTextEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isIncludeMyRetweetEnabled() {
        return this.includeMyRetweetEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isJSONStoreEnabled() {
        return this.jsonStoreEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isMBeanEnabled() {
        return this.mbeanEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isStallWarningsEnabled() {
        return this.stallWarningsEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isTrimUserEnabled() {
        return this.trimUserEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isTweetModeExtended() {
        return this.tweetModeExtended;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isUserStreamRepliesAllEnabled() {
        return this.userStreamRepliesAllEnabled;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isUserStreamWithFollowingsEnabled() {
        return this.userStreamWithFollowingsEnabled;
    }

    public Object readResolve() {
        return getInstance(this);
    }

    public final void setApplicationOnlyAuthEnabled(boolean z) {
        this.applicationOnlyAuthEnabled = z;
    }

    public final void setAsyncNumThreads(int i) {
        this.asyncNumThreads = i;
    }

    public final void setContributingTo(long j) {
        this.contributingTo = j;
    }

    public void setDaemonEnabled(boolean z) {
        this.daemonEnabled = z;
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public final void setDispatcherImpl(String str) {
        this.dispatcherImpl = str;
    }

    public final void setGZIPEnabled(boolean z) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), z);
    }

    public final void setHttpConnectionTimeout(int i) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), i, this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    public final void setHttpProxyHost(String str) {
        this.httpConf = new MyHttpClientConfiguration(str, this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    public final void setHttpProxyPassword(String str) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), str, this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    public final void setHttpProxyPort(int i) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), i, this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    public final void setHttpProxySocks(boolean z) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), z, this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    public final void setHttpProxyUser(String str) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), str, this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    public final void setHttpReadTimeout(int i) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), i, this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    public final void setHttpRetryCount(int i) {
        this.httpRetryCount = i;
    }

    public final void setHttpRetryIntervalSeconds(int i) {
        this.httpRetryIntervalSeconds = i;
    }

    public final void setHttpStreamingReadTimeout(int i) {
        this.httpStreamingReadTimeout = i;
    }

    public void setIncludeEmailEnabled(boolean z) {
        this.includeEmailEnabled = z;
    }

    public void setIncludeEntitiesEnabled(boolean z) {
        this.includeEntitiesEnabled = z;
    }

    public void setIncludeExtAltTextEnabled(boolean z) {
        this.includeExtAltTextEnabled = z;
    }

    public void setIncludeMyRetweetEnabled(boolean z) {
        this.includeMyRetweetEnabled = z;
    }

    public final void setJSONStoreEnabled(boolean z) {
        this.jsonStoreEnabled = z;
    }

    public final void setLoggerFactory(String str) {
        this.loggerFactory = str;
    }

    public final void setMBeanEnabled(boolean z) {
        this.mbeanEnabled = z;
    }

    public final void setMediaProvider(String str) {
        this.mediaProvider = str;
    }

    public final void setMediaProviderAPIKey(String str) {
        this.mediaProviderAPIKey = str;
    }

    public final void setMediaProviderParameters(Properties properties) {
        this.mediaProviderParameters = properties;
    }

    public final void setOAuth2AccessToken(String str) {
        this.oAuth2AccessToken = str;
    }

    public final void setOAuth2InvalidateTokenURL(String str) {
        this.oAuth2InvalidateTokenURL = str;
    }

    public final void setOAuth2Scope(String str) {
        this.oAuth2Scope = str;
    }

    public final void setOAuth2TokenType(String str) {
        this.oAuth2TokenType = str;
    }

    public final void setOAuth2TokenURL(String str) {
        this.oAuth2TokenURL = str;
    }

    public final void setOAuthAccessToken(String str) {
        this.oAuthAccessToken = str;
    }

    public final void setOAuthAccessTokenSecret(String str) {
        this.oAuthAccessTokenSecret = str;
    }

    public final void setOAuthAccessTokenURL(String str) {
        this.oAuthAccessTokenURL = str;
    }

    public final void setOAuthAuthenticationURL(String str) {
        this.oAuthAuthenticationURL = str;
    }

    public final void setOAuthAuthorizationURL(String str) {
        this.oAuthAuthorizationURL = str;
    }

    public final void setOAuthConsumerKey(String str) {
        this.oAuthConsumerKey = str;
    }

    public final void setOAuthConsumerSecret(String str) {
        this.oAuthConsumerSecret = str;
    }

    public final void setOAuthRequestTokenURL(String str) {
        this.oAuthRequestTokenURL = str;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final void setPrettyDebugEnabled(boolean z) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), z, this.httpConf.isGZIPEnabled());
    }

    public final void setRestBaseURL(String str) {
        this.restBaseURL = str;
    }

    public final void setSiteStreamBaseURL(String str) {
        this.siteStreamBaseURL = str;
    }

    public final void setStallWarningsEnabled(boolean z) {
        this.stallWarningsEnabled = z;
    }

    public final void setStreamBaseURL(String str) {
        this.streamBaseURL = str;
    }

    public final void setStreamThreadName(String str) {
        this.streamThreadName = str;
    }

    public void setTrimUserEnabled(boolean z) {
        this.trimUserEnabled = z;
    }

    public void setTweetModeExtended(boolean z) {
        this.tweetModeExtended = z;
    }

    public final void setUploadBaseURL(String str) {
        this.uploadBaseURL = str;
    }

    public final void setUser(String str) {
        this.user = str;
    }

    public final void setUserStreamBaseURL(String str) {
        this.userStreamBaseURL = str;
    }

    public final void setUserStreamRepliesAllEnabled(boolean z) {
        this.userStreamRepliesAllEnabled = z;
    }

    public final void setUserStreamWithFollowingsEnabled(boolean z) {
        this.userStreamWithFollowingsEnabled = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConfigurationBase{debug=");
        sb.append(this.debug);
        sb.append(", user='");
        sb.append(this.user);
        sb.append("', password='");
        sb.append(this.password);
        sb.append("', httpConf=");
        sb.append(this.httpConf);
        sb.append(", httpStreamingReadTimeout=");
        sb.append(this.httpStreamingReadTimeout);
        sb.append(", httpRetryCount=");
        sb.append(this.httpRetryCount);
        sb.append(", httpRetryIntervalSeconds=");
        sb.append(this.httpRetryIntervalSeconds);
        sb.append(", oAuthConsumerKey='");
        sb.append(this.oAuthConsumerKey);
        sb.append("', oAuthConsumerSecret='");
        sb.append(this.oAuthConsumerSecret);
        sb.append("', oAuthAccessToken='");
        sb.append(this.oAuthAccessToken);
        sb.append("', oAuthAccessTokenSecret='");
        sb.append(this.oAuthAccessTokenSecret);
        sb.append("', oAuth2TokenType='");
        sb.append(this.oAuth2TokenType);
        sb.append("', oAuth2AccessToken='");
        sb.append(this.oAuth2AccessToken);
        sb.append("', oAuth2Scope='");
        sb.append(this.oAuth2Scope);
        sb.append("', oAuthRequestTokenURL='");
        sb.append(this.oAuthRequestTokenURL);
        sb.append("', oAuthAuthorizationURL='");
        sb.append(this.oAuthAuthorizationURL);
        sb.append("', oAuthAccessTokenURL='");
        sb.append(this.oAuthAccessTokenURL);
        sb.append("', oAuthAuthenticationURL='");
        sb.append(this.oAuthAuthenticationURL);
        sb.append("', oAuth2TokenURL='");
        sb.append(this.oAuth2TokenURL);
        sb.append("', oAuth2InvalidateTokenURL='");
        sb.append(this.oAuth2InvalidateTokenURL);
        sb.append("', restBaseURL='");
        sb.append(this.restBaseURL);
        sb.append("', streamBaseURL='");
        sb.append(this.streamBaseURL);
        sb.append("', userStreamBaseURL='");
        sb.append(this.userStreamBaseURL);
        sb.append("', siteStreamBaseURL='");
        sb.append(this.siteStreamBaseURL);
        sb.append("', uploadBaseURL='");
        sb.append(this.uploadBaseURL);
        sb.append("', dispatcherImpl='");
        sb.append(this.dispatcherImpl);
        sb.append("', asyncNumThreads=");
        sb.append(this.asyncNumThreads);
        sb.append(", loggerFactory='");
        sb.append(this.loggerFactory);
        sb.append("', contributingTo=");
        sb.append(this.contributingTo);
        sb.append(", includeMyRetweetEnabled=");
        sb.append(this.includeMyRetweetEnabled);
        sb.append(", includeEntitiesEnabled=");
        sb.append(this.includeEntitiesEnabled);
        sb.append(", trimUserEnabled=");
        sb.append(this.trimUserEnabled);
        sb.append(", includeExtAltTextEnabled=");
        sb.append(this.includeExtAltTextEnabled);
        sb.append(", tweetModeExtended=");
        sb.append(this.tweetModeExtended);
        sb.append(", includeEmailEnabled=");
        sb.append(this.includeEmailEnabled);
        sb.append(", jsonStoreEnabled=");
        sb.append(this.jsonStoreEnabled);
        sb.append(", mbeanEnabled=");
        sb.append(this.mbeanEnabled);
        sb.append(", userStreamRepliesAllEnabled=");
        sb.append(this.userStreamRepliesAllEnabled);
        sb.append(", userStreamWithFollowingsEnabled=");
        sb.append(this.userStreamWithFollowingsEnabled);
        sb.append(", stallWarningsEnabled=");
        sb.append(this.stallWarningsEnabled);
        sb.append(", applicationOnlyAuthEnabled=");
        sb.append(this.applicationOnlyAuthEnabled);
        sb.append(", mediaProvider='");
        sb.append(this.mediaProvider);
        sb.append("', mediaProviderAPIKey='");
        sb.append(this.mediaProviderAPIKey);
        sb.append("', mediaProviderParameters=");
        sb.append(this.mediaProviderParameters);
        sb.append(", daemonEnabled=");
        sb.append(this.daemonEnabled);
        sb.append(", streamThreadName='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.streamThreadName, "'}");
    }

    public void cacheInstance() {
        cacheInstance(this);
    }
}
