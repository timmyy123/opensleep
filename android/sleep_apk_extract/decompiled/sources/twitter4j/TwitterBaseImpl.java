package twitter4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.BasicAuthorization;
import twitter4j.auth.NullAuthorization;
import twitter4j.auth.OAuth2Authorization;
import twitter4j.auth.OAuth2Support;
import twitter4j.auth.OAuth2Token;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.OAuthSupport;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.util.function.Consumer;

/* JADX INFO: loaded from: classes5.dex */
abstract class TwitterBaseImpl implements TwitterBase, Serializable, OAuthSupport, OAuth2Support, HttpResponseListener {
    private static final String WWW_DETAILS = "See http://twitter4j.org/en/configuration.html for details. See and register at http://apps.twitter.com/";
    private static final long serialVersionUID = -7824361938865528554L;
    Authorization auth;
    Configuration conf;
    ObjectFactory factory;
    transient HttpClient http;
    private transient String screenName = null;
    private transient long id = 0;
    private List<RateLimitStatusListener> rateLimitStatusListeners = new ArrayList(0);

    public TwitterBaseImpl(Configuration configuration, Authorization authorization) {
        this.conf = configuration;
        this.auth = authorization;
        init();
    }

    private OAuthSupport getOAuth() {
        Authorization authorization = this.auth;
        if (authorization instanceof OAuthSupport) {
            return (OAuthSupport) authorization;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("OAuth consumer key/secret combination not supplied");
        return null;
    }

    private OAuth2Support getOAuth2() {
        Authorization authorization = this.auth;
        if (authorization instanceof OAuth2Support) {
            return (OAuth2Support) authorization;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("OAuth consumer key/secret combination not supplied");
        return null;
    }

    private void init() {
        if (this.auth == null) {
            String oAuthConsumerKey = this.conf.getOAuthConsumerKey();
            String oAuthConsumerSecret = this.conf.getOAuthConsumerSecret();
            if (oAuthConsumerKey == null || oAuthConsumerSecret == null) {
                this.auth = NullAuthorization.getInstance();
            } else if (this.conf.isApplicationOnlyAuthEnabled()) {
                OAuth2Authorization oAuth2Authorization = new OAuth2Authorization(this.conf);
                String oAuth2TokenType = this.conf.getOAuth2TokenType();
                String oAuth2AccessToken = this.conf.getOAuth2AccessToken();
                if (oAuth2TokenType != null && oAuth2AccessToken != null) {
                    oAuth2Authorization.setOAuth2Token(new OAuth2Token(oAuth2TokenType, oAuth2AccessToken));
                }
                this.auth = oAuth2Authorization;
            } else {
                OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
                String oAuthAccessToken = this.conf.getOAuthAccessToken();
                String oAuthAccessTokenSecret = this.conf.getOAuthAccessTokenSecret();
                if (oAuthAccessToken != null && oAuthAccessTokenSecret != null) {
                    oAuthAuthorization.setOAuthAccessToken(new AccessToken(oAuthAccessToken, oAuthAccessTokenSecret));
                }
                this.auth = oAuthAuthorization;
            }
        }
        this.http = HttpClientFactory.getInstance(this.conf.getHttpClientConfiguration());
        setFactory();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.readFields();
        this.conf = (Configuration) objectInputStream.readObject();
        this.auth = (Authorization) objectInputStream.readObject();
        this.rateLimitStatusListeners = (List) objectInputStream.readObject();
        this.http = HttpClientFactory.getInstance(this.conf.getHttpClientConfiguration());
        setFactory();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.putFields();
        objectOutputStream.writeFields();
        objectOutputStream.writeObject(this.conf);
        objectOutputStream.writeObject(this.auth);
        ArrayList arrayList = new ArrayList(0);
        for (RateLimitStatusListener rateLimitStatusListener : this.rateLimitStatusListeners) {
            if (rateLimitStatusListener instanceof Serializable) {
                arrayList.add(rateLimitStatusListener);
            }
        }
        objectOutputStream.writeObject(arrayList);
    }

    public void addRateLimitStatusListener(RateLimitStatusListener rateLimitStatusListener) {
        this.rateLimitStatusListeners.add(rateLimitStatusListener);
    }

    public final void ensureAuthorizationEnabled() {
        if (this.auth.isEnabled()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Authentication credentials are missing. See http://twitter4j.org/en/configuration.html for details. See and register at http://apps.twitter.com/");
    }

    public final void ensureOAuthEnabled() {
        if (this.auth instanceof OAuthAuthorization) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("OAuth required. Authentication credentials are missing. See http://twitter4j.org/en/configuration.html for details. See and register at http://apps.twitter.com/");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterBaseImpl)) {
            return false;
        }
        TwitterBaseImpl twitterBaseImpl = (TwitterBaseImpl) obj;
        Authorization authorization = this.auth;
        Authorization authorization2 = twitterBaseImpl.auth;
        if (authorization == null ? authorization2 != null : !authorization.equals(authorization2)) {
            return false;
        }
        if (!this.conf.equals(twitterBaseImpl.conf)) {
            return false;
        }
        HttpClient httpClient = this.http;
        HttpClient httpClient2 = twitterBaseImpl.http;
        if (httpClient == null ? httpClient2 == null : httpClient.equals(httpClient2)) {
            return this.rateLimitStatusListeners.equals(twitterBaseImpl.rateLimitStatusListeners);
        }
        return false;
    }

    public User fillInIDAndScreenName(HttpParameter[] httpParameterArr) {
        ensureAuthorizationEnabled();
        UserJSONImpl userJSONImpl = new UserJSONImpl(this.http.get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/verify_credentials.json"), httpParameterArr, this.auth, this), this.conf);
        this.screenName = userJSONImpl.getScreenName();
        this.id = userJSONImpl.getId();
        return userJSONImpl;
    }

    @Override // twitter4j.TwitterBase
    public final Authorization getAuthorization() {
        return this.auth;
    }

    @Override // twitter4j.TwitterBase
    public Configuration getConfiguration() {
        return this.conf;
    }

    public long getId() {
        if (!this.auth.isEnabled()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
            return 0L;
        }
        if (0 == this.id) {
            fillInIDAndScreenName();
        }
        return this.id;
    }

    @Override // twitter4j.auth.OAuth2Support
    public synchronized OAuth2Token getOAuth2Token() {
        return getOAuth2().getOAuth2Token();
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken() {
        AccessToken oAuthAccessToken;
        try {
            Authorization authorization = getAuthorization();
            if (authorization instanceof BasicAuthorization) {
                BasicAuthorization basicAuthorization = (BasicAuthorization) authorization;
                Authorization authorizationFactory = AuthorizationFactory.getInstance(this.conf);
                if (!(authorizationFactory instanceof OAuthAuthorization)) {
                    throw new IllegalStateException("consumer key / secret combination not supplied.");
                }
                this.auth = authorizationFactory;
                oAuthAccessToken = ((OAuthAuthorization) authorizationFactory).getOAuthAccessToken(basicAuthorization.getUserId(), basicAuthorization.getPassword());
            } else if (authorization instanceof XAuthAuthorization) {
                XAuthAuthorization xAuthAuthorization = (XAuthAuthorization) authorization;
                this.auth = xAuthAuthorization;
                OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
                oAuthAuthorization.setOAuthConsumer(xAuthAuthorization.getConsumerKey(), xAuthAuthorization.getConsumerSecret());
                oAuthAccessToken = oAuthAuthorization.getOAuthAccessToken(xAuthAuthorization.getUserId(), xAuthAuthorization.getPassword());
            } else {
                oAuthAccessToken = getOAuth().getOAuthAccessToken();
            }
            this.screenName = oAuthAccessToken.getScreenName();
            this.id = oAuthAccessToken.getUserId();
        } catch (Throwable th) {
            throw th;
        }
        return oAuthAccessToken;
    }

    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str) {
        return getOAuth().getOAuthRequestToken(str);
    }

    public String getScreenName() {
        if (!this.auth.isEnabled()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
            return null;
        }
        if (this.screenName == null) {
            Authorization authorization = this.auth;
            if (authorization instanceof BasicAuthorization) {
                String userId = ((BasicAuthorization) authorization).getUserId();
                this.screenName = userId;
                if (userId.contains("@")) {
                    this.screenName = null;
                }
            }
            if (this.screenName == null) {
                fillInIDAndScreenName();
            }
        }
        return this.screenName;
    }

    public int hashCode() {
        int iHashCode = this.conf.hashCode() * 31;
        HttpClient httpClient = this.http;
        int iHashCode2 = (this.rateLimitStatusListeners.hashCode() + ((iHashCode + (httpClient != null ? httpClient.hashCode() : 0)) * 31)) * 31;
        Authorization authorization = this.auth;
        return iHashCode2 + (authorization != null ? authorization.hashCode() : 0);
    }

    @Override // twitter4j.HttpResponseListener
    public void httpResponseReceived(HttpResponseEvent httpResponseEvent) {
        int statusCode;
        RateLimitStatus rateLimitStatus;
        if (this.rateLimitStatusListeners.size() != 0) {
            HttpResponse response = httpResponseEvent.getResponse();
            TwitterException twitterException = httpResponseEvent.getTwitterException();
            if (twitterException != null) {
                rateLimitStatus = twitterException.getRateLimitStatus();
                statusCode = twitterException.getStatusCode();
            } else {
                RateLimitStatus rateLimitStatusCreateRateLimitStatusFromResponseHeader = JSONImplFactory.createRateLimitStatusFromResponseHeader(response);
                statusCode = response.getStatusCode();
                rateLimitStatus = rateLimitStatusCreateRateLimitStatusFromResponseHeader;
            }
            if (rateLimitStatus != null) {
                RateLimitStatusEvent rateLimitStatusEvent = new RateLimitStatusEvent(this, rateLimitStatus, httpResponseEvent.isAuthenticated());
                if (statusCode == 420 || statusCode == 503 || statusCode == 429) {
                    for (RateLimitStatusListener rateLimitStatusListener : this.rateLimitStatusListeners) {
                        rateLimitStatusListener.onRateLimitStatus(rateLimitStatusEvent);
                        rateLimitStatusListener.onRateLimitReached(rateLimitStatusEvent);
                    }
                } else {
                    Iterator<RateLimitStatusListener> it = this.rateLimitStatusListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onRateLimitStatus(rateLimitStatusEvent);
                    }
                }
            }
        }
    }

    @Override // twitter4j.auth.OAuth2Support
    public synchronized void invalidateOAuth2Token() {
        getOAuth2().invalidateOAuth2Token();
    }

    public void onRateLimitReached(Consumer<RateLimitStatusEvent> consumer) {
        this.rateLimitStatusListeners.add(new RateLimitStatusListener(consumer) { // from class: twitter4j.TwitterBaseImpl.2
            @Override // twitter4j.RateLimitStatusListener
            public void onRateLimitReached(RateLimitStatusEvent rateLimitStatusEvent) {
                throw null;
            }

            @Override // twitter4j.RateLimitStatusListener
            public void onRateLimitStatus(RateLimitStatusEvent rateLimitStatusEvent) {
            }
        });
    }

    public void onRateLimitStatus(Consumer<RateLimitStatusEvent> consumer) {
        this.rateLimitStatusListeners.add(new RateLimitStatusListener(consumer) { // from class: twitter4j.TwitterBaseImpl.1
            @Override // twitter4j.RateLimitStatusListener
            public void onRateLimitReached(RateLimitStatusEvent rateLimitStatusEvent) {
            }

            @Override // twitter4j.RateLimitStatusListener
            public void onRateLimitStatus(RateLimitStatusEvent rateLimitStatusEvent) {
                throw null;
            }
        });
    }

    public void setFactory() {
        this.factory = new JSONImplFactory(this.conf);
    }

    @Override // twitter4j.auth.OAuth2Support
    public void setOAuth2Token(OAuth2Token oAuth2Token) {
        getOAuth2().setOAuth2Token(oAuth2Token);
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized void setOAuthAccessToken(AccessToken accessToken) {
        getOAuth().setOAuthAccessToken(accessToken);
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized void setOAuthConsumer(String str, String str2) {
        try {
            if (str == null) {
                throw new NullPointerException("consumer key is null");
            }
            if (str2 == null) {
                throw new NullPointerException("consumer secret is null");
            }
            Authorization authorization = this.auth;
            if (authorization instanceof NullAuthorization) {
                if (this.conf.isApplicationOnlyAuthEnabled()) {
                    OAuth2Authorization oAuth2Authorization = new OAuth2Authorization(this.conf);
                    oAuth2Authorization.setOAuthConsumer(str, str2);
                    this.auth = oAuth2Authorization;
                } else {
                    OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
                    oAuthAuthorization.setOAuthConsumer(str, str2);
                    this.auth = oAuthAuthorization;
                }
            } else if (authorization instanceof BasicAuthorization) {
                XAuthAuthorization xAuthAuthorization = new XAuthAuthorization((BasicAuthorization) authorization);
                xAuthAuthorization.setOAuthConsumer(str, str2);
                this.auth = xAuthAuthorization;
            } else if ((authorization instanceof OAuthAuthorization) || (authorization instanceof OAuth2Authorization)) {
                throw new IllegalStateException("consumer key/secret pair already set.");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken() {
        return getOAuthRequestToken(null);
    }

    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str, String str2) {
        return getOAuth().getOAuthRequestToken(str, str2);
    }

    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str, String str2, String str3) {
        return getOAuth().getOAuthRequestToken(str, str2, str3);
    }

    public User fillInIDAndScreenName() {
        return fillInIDAndScreenName(null);
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(String str) {
        AccessToken oAuthAccessToken;
        oAuthAccessToken = getOAuth().getOAuthAccessToken(str);
        this.screenName = oAuthAccessToken.getScreenName();
        return oAuthAccessToken;
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken) {
        AccessToken oAuthAccessToken;
        oAuthAccessToken = getOAuth().getOAuthAccessToken(requestToken);
        this.screenName = oAuthAccessToken.getScreenName();
        return oAuthAccessToken;
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken, String str) {
        return getOAuth().getOAuthAccessToken(requestToken, str);
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(String str, String str2) {
        return getOAuth().getOAuthAccessToken(str, str2);
    }
}
