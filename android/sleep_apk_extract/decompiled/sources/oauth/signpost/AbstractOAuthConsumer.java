package oauth.signpost;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;
import oauth.signpost.basic.UrlStringRequestAdapter;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;
import oauth.signpost.signature.AuthorizationHeaderSigningStrategy;
import oauth.signpost.signature.HmacSha1MessageSigner;
import oauth.signpost.signature.OAuthMessageSigner;
import oauth.signpost.signature.QueryStringSigningStrategy;
import oauth.signpost.signature.SigningStrategy;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractOAuthConsumer implements OAuthConsumer {
    private static final long serialVersionUID = 1;
    private HttpParameters additionalParameters;
    private String consumerKey;
    private String consumerSecret;
    private OAuthMessageSigner messageSigner;
    private HttpParameters requestParameters;
    private boolean sendEmptyTokens;
    private SigningStrategy signingStrategy;
    private String token;

    public AbstractOAuthConsumer(String str, String str2) {
        this.consumerKey = str;
        this.consumerSecret = str2;
        setMessageSigner(new HmacSha1MessageSigner());
        setSigningStrategy(new AuthorizationHeaderSigningStrategy());
    }

    public void collectBodyParameters(HttpRequest httpRequest, HttpParameters httpParameters) {
        String contentType = httpRequest.getContentType();
        if (contentType == null || !contentType.startsWith(OAuth.FORM_ENCODED)) {
            return;
        }
        httpParameters.putAll((Map<? extends String, ? extends SortedSet<String>>) OAuth.decodeForm(httpRequest.getMessagePayload()), true);
    }

    public void collectHeaderParameters(HttpRequest httpRequest, HttpParameters httpParameters) {
        httpParameters.putAll((Map<? extends String, ? extends SortedSet<String>>) OAuth.oauthHeaderToParamsMap(httpRequest.getHeader(OAuth.HTTP_AUTHORIZATION_HEADER)), false);
    }

    public void collectQueryParameters(HttpRequest httpRequest, HttpParameters httpParameters) {
        String requestUrl = httpRequest.getRequestUrl();
        int iIndexOf = requestUrl.indexOf(63);
        if (iIndexOf >= 0) {
            httpParameters.putAll((Map<? extends String, ? extends SortedSet<String>>) OAuth.decodeForm(requestUrl.substring(iIndexOf + 1)), true);
        }
    }

    public void completeOAuthParameters(HttpParameters httpParameters) {
        if (!httpParameters.containsKey(OAuth.OAUTH_CONSUMER_KEY)) {
            httpParameters.put(OAuth.OAUTH_CONSUMER_KEY, this.consumerKey, true);
        }
        if (!httpParameters.containsKey(OAuth.OAUTH_SIGNATURE_METHOD)) {
            httpParameters.put(OAuth.OAUTH_SIGNATURE_METHOD, this.messageSigner.getSignatureMethod(), true);
        }
        if (!httpParameters.containsKey(OAuth.OAUTH_TIMESTAMP)) {
            httpParameters.put(OAuth.OAUTH_TIMESTAMP, generateTimestamp(), true);
        }
        if (!httpParameters.containsKey(OAuth.OAUTH_NONCE)) {
            httpParameters.put(OAuth.OAUTH_NONCE, generateNonce(), true);
        }
        if (!httpParameters.containsKey(OAuth.OAUTH_VERSION)) {
            httpParameters.put(OAuth.OAUTH_VERSION, OAuth.VERSION_1_0, true);
        }
        if (httpParameters.containsKey(OAuth.OAUTH_TOKEN)) {
            return;
        }
        String str = this.token;
        if ((str == null || str.equals("")) && !this.sendEmptyTokens) {
            return;
        }
        httpParameters.put(OAuth.OAUTH_TOKEN, this.token, true);
    }

    public String generateNonce() {
        return Long.toString(new Random().nextLong());
    }

    public String generateTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    @Override // oauth.signpost.OAuthConsumer
    public String getConsumerKey() {
        return this.consumerKey;
    }

    @Override // oauth.signpost.OAuthConsumer
    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    @Override // oauth.signpost.OAuthConsumer
    public HttpParameters getRequestParameters() {
        return this.requestParameters;
    }

    @Override // oauth.signpost.OAuthConsumer
    public String getToken() {
        return this.token;
    }

    @Override // oauth.signpost.OAuthConsumer
    public String getTokenSecret() {
        return this.messageSigner.getTokenSecret();
    }

    @Override // oauth.signpost.OAuthConsumer
    public void setAdditionalParameters(HttpParameters httpParameters) {
        this.additionalParameters = httpParameters;
    }

    @Override // oauth.signpost.OAuthConsumer
    public void setMessageSigner(OAuthMessageSigner oAuthMessageSigner) {
        this.messageSigner = oAuthMessageSigner;
        oAuthMessageSigner.setConsumerSecret(this.consumerSecret);
    }

    @Override // oauth.signpost.OAuthConsumer
    public void setSendEmptyTokens(boolean z) {
        this.sendEmptyTokens = z;
    }

    @Override // oauth.signpost.OAuthConsumer
    public void setSigningStrategy(SigningStrategy signingStrategy) {
        this.signingStrategy = signingStrategy;
    }

    @Override // oauth.signpost.OAuthConsumer
    public void setTokenWithSecret(String str, String str2) {
        this.token = str;
        this.messageSigner.setTokenSecret(str2);
    }

    @Override // oauth.signpost.OAuthConsumer
    public HttpRequest sign(HttpRequest httpRequest) throws OAuthExpectationFailedException, OAuthCommunicationException {
        if (this.consumerKey == null) {
            throw new OAuthExpectationFailedException("consumer key not set");
        }
        if (this.consumerSecret == null) {
            throw new OAuthExpectationFailedException("consumer secret not set");
        }
        HttpParameters httpParameters = new HttpParameters();
        this.requestParameters = httpParameters;
        try {
            HttpParameters httpParameters2 = this.additionalParameters;
            if (httpParameters2 != null) {
                httpParameters.putAll((Map<? extends String, ? extends SortedSet<String>>) httpParameters2, false);
            }
            collectHeaderParameters(httpRequest, this.requestParameters);
            collectQueryParameters(httpRequest, this.requestParameters);
            collectBodyParameters(httpRequest, this.requestParameters);
            completeOAuthParameters(this.requestParameters);
            this.requestParameters.remove((Object) OAuth.OAUTH_SIGNATURE);
            String strSign = this.messageSigner.sign(httpRequest, this.requestParameters);
            OAuth.debugOut("signature", strSign);
            this.signingStrategy.writeSignature(strSign, httpRequest, this.requestParameters);
            OAuth.debugOut("Auth header", httpRequest.getHeader(OAuth.HTTP_AUTHORIZATION_HEADER));
            OAuth.debugOut("Request URL", httpRequest.getRequestUrl());
            return httpRequest;
        } catch (IOException e) {
            throw new OAuthCommunicationException(e);
        }
    }

    public abstract HttpRequest wrap(Object obj);

    @Override // oauth.signpost.OAuthConsumer
    public HttpRequest sign(Object obj) {
        return sign(wrap(obj));
    }

    @Override // oauth.signpost.OAuthConsumer
    public String sign(String str) throws OAuthExpectationFailedException, OAuthCommunicationException {
        UrlStringRequestAdapter urlStringRequestAdapter = new UrlStringRequestAdapter(str);
        SigningStrategy signingStrategy = this.signingStrategy;
        this.signingStrategy = new QueryStringSigningStrategy();
        sign((HttpRequest) urlStringRequestAdapter);
        this.signingStrategy = signingStrategy;
        return urlStringRequestAdapter.getRequestUrl();
    }
}
