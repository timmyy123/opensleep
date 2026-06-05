package oauth.signpost;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;
import oauth.signpost.http.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractOAuthProvider implements OAuthProvider {
    private static final long serialVersionUID = 1;
    private String accessTokenEndpointUrl;
    private String authorizationWebsiteUrl;
    private boolean isOAuth10a;
    private transient OAuthProviderListener listener;
    private String requestTokenEndpointUrl;
    private HttpParameters responseParameters = new HttpParameters();
    private Map<String, String> defaultHeaders = new HashMap();

    public AbstractOAuthProvider(String str, String str2, String str3) {
        this.requestTokenEndpointUrl = str;
        this.accessTokenEndpointUrl = str2;
        this.authorizationWebsiteUrl = str3;
    }

    public void closeConnection(HttpRequest httpRequest, HttpResponse httpResponse) {
    }

    public abstract HttpRequest createRequest(String str);

    @Override // oauth.signpost.OAuthProvider
    public String getAccessTokenEndpointUrl() {
        return this.accessTokenEndpointUrl;
    }

    @Override // oauth.signpost.OAuthProvider
    public String getAuthorizationWebsiteUrl() {
        return this.authorizationWebsiteUrl;
    }

    @Override // oauth.signpost.OAuthProvider
    public Map<String, String> getRequestHeaders() {
        return this.defaultHeaders;
    }

    @Override // oauth.signpost.OAuthProvider
    public String getRequestTokenEndpointUrl() {
        return this.requestTokenEndpointUrl;
    }

    public String getResponseParameter(String str) {
        return this.responseParameters.getFirst(str);
    }

    @Override // oauth.signpost.OAuthProvider
    public HttpParameters getResponseParameters() {
        return this.responseParameters;
    }

    public void handleUnexpectedResponse(int i, HttpResponse httpResponse) throws OAuthNotAuthorizedException, IOException, OAuthCommunicationException {
        if (httpResponse == null) {
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getContent()));
        StringBuilder sb = new StringBuilder();
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            sb.append(line);
        }
        if (i == 401) {
            throw new OAuthNotAuthorizedException(sb.toString());
        }
        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "Service provider responded in error: ", " (");
        sbM65m.append(httpResponse.getReasonPhrase());
        sbM65m.append(")");
        throw new OAuthCommunicationException(sbM65m.toString(), sb.toString());
    }

    @Override // oauth.signpost.OAuthProvider
    public boolean isOAuth10a() {
        return this.isOAuth10a;
    }

    @Override // oauth.signpost.OAuthProvider
    public void removeListener(OAuthProviderListener oAuthProviderListener) {
        this.listener = null;
    }

    @Override // oauth.signpost.OAuthProvider
    public void retrieveAccessToken(OAuthConsumer oAuthConsumer, String str) throws Throwable {
        if (oAuthConsumer.getToken() == null || oAuthConsumer.getTokenSecret() == null) {
            throw new OAuthExpectationFailedException("Authorized request token or token secret not set. Did you retrieve an authorized request token before?");
        }
        if (!this.isOAuth10a || str == null) {
            retrieveToken(oAuthConsumer, this.accessTokenEndpointUrl, new String[0]);
        } else {
            retrieveToken(oAuthConsumer, this.accessTokenEndpointUrl, OAuth.OAUTH_VERIFIER, str);
        }
    }

    @Override // oauth.signpost.OAuthProvider
    public String retrieveRequestToken(OAuthConsumer oAuthConsumer, String str) throws Throwable {
        oAuthConsumer.setTokenWithSecret(null, null);
        retrieveToken(oAuthConsumer, this.requestTokenEndpointUrl, OAuth.OAUTH_CALLBACK, str);
        String first = this.responseParameters.getFirst(OAuth.OAUTH_CALLBACK_CONFIRMED);
        this.responseParameters.remove((Object) OAuth.OAUTH_CALLBACK_CONFIRMED);
        boolean zEquals = Boolean.TRUE.toString().equals(first);
        this.isOAuth10a = zEquals;
        String str2 = this.authorizationWebsiteUrl;
        return zEquals ? OAuth.addQueryParameters(str2, OAuth.OAUTH_TOKEN, oAuthConsumer.getToken()) : OAuth.addQueryParameters(str2, OAuth.OAUTH_TOKEN, oAuthConsumer.getToken(), OAuth.OAUTH_CALLBACK, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v5, types: [oauth.signpost.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [oauth.signpost.AbstractOAuthProvider] */
    public void retrieveToken(OAuthConsumer oAuthConsumer, String str, String... strArr) throws Throwable {
        ?? r10;
        HttpRequest httpRequestCreateRequest;
        Map<String, String> requestHeaders = getRequestHeaders();
        if (oAuthConsumer.getConsumerKey() == null || oAuthConsumer.getConsumerSecret() == null) {
            throw new OAuthExpectationFailedException("Consumer key or secret not set");
        }
        HttpRequest httpRequest = null;
        try {
            try {
                httpRequestCreateRequest = createRequest(str);
            } catch (Throwable th) {
                th = th;
                r10 = str;
            }
            try {
                for (String str2 : requestHeaders.keySet()) {
                    httpRequestCreateRequest.setHeader(str2, requestHeaders.get(str2));
                }
                if (strArr != null) {
                    HttpParameters httpParameters = new HttpParameters();
                    httpParameters.putAll(strArr, true);
                    oAuthConsumer.setAdditionalParameters(httpParameters);
                }
                OAuthProviderListener oAuthProviderListener = this.listener;
                if (oAuthProviderListener != null) {
                    oAuthProviderListener.prepareRequest(httpRequestCreateRequest);
                }
                oAuthConsumer.sign(httpRequestCreateRequest);
                OAuthProviderListener oAuthProviderListener2 = this.listener;
                if (oAuthProviderListener2 != null) {
                    oAuthProviderListener2.prepareSubmission(httpRequestCreateRequest);
                }
                HttpResponse httpResponseSendRequest = sendRequest(httpRequestCreateRequest);
                int statusCode = httpResponseSendRequest.getStatusCode();
                OAuthProviderListener oAuthProviderListener3 = this.listener;
                if (oAuthProviderListener3 != null ? oAuthProviderListener3.onResponseReceived(httpRequestCreateRequest, httpResponseSendRequest) : false) {
                    try {
                        closeConnection(httpRequestCreateRequest, httpResponseSendRequest);
                        return;
                    } catch (Exception e) {
                        throw new OAuthCommunicationException(e);
                    }
                }
                if (statusCode >= 300) {
                    handleUnexpectedResponse(statusCode, httpResponseSendRequest);
                }
                HttpParameters httpParametersDecodeForm = OAuth.decodeForm(httpResponseSendRequest.getContent());
                String first = httpParametersDecodeForm.getFirst(OAuth.OAUTH_TOKEN);
                String first2 = httpParametersDecodeForm.getFirst(OAuth.OAUTH_TOKEN_SECRET);
                httpParametersDecodeForm.remove((Object) OAuth.OAUTH_TOKEN);
                httpParametersDecodeForm.remove((Object) OAuth.OAUTH_TOKEN_SECRET);
                setResponseParameters(httpParametersDecodeForm);
                if (first == null || first2 == null) {
                    throw new OAuthExpectationFailedException("Request token or token secret not set in server reply. The service provider you use is probably buggy.");
                }
                oAuthConsumer.setTokenWithSecret(first, first2);
                try {
                    closeConnection(httpRequestCreateRequest, httpResponseSendRequest);
                } catch (Exception e2) {
                    throw new OAuthCommunicationException(e2);
                }
            } catch (OAuthExpectationFailedException e3) {
                throw e3;
            } catch (OAuthNotAuthorizedException e4) {
                throw e4;
            } catch (Exception e5) {
                e = e5;
                throw new OAuthCommunicationException(e);
            } catch (Throwable th2) {
                th = th2;
                httpRequest = httpRequestCreateRequest;
                r10 = 0;
                try {
                    closeConnection(httpRequest, r10);
                    throw th;
                } catch (Exception e6) {
                    throw new OAuthCommunicationException(e6);
                }
            }
        } catch (OAuthExpectationFailedException e7) {
            throw e7;
        } catch (OAuthNotAuthorizedException e8) {
            throw e8;
        } catch (Exception e9) {
            e = e9;
        } catch (Throwable th3) {
            th = th3;
            r10 = 0;
        }
    }

    public abstract HttpResponse sendRequest(HttpRequest httpRequest);

    @Override // oauth.signpost.OAuthProvider
    public void setListener(OAuthProviderListener oAuthProviderListener) {
        this.listener = oAuthProviderListener;
    }

    @Override // oauth.signpost.OAuthProvider
    public void setOAuth10a(boolean z) {
        this.isOAuth10a = z;
    }

    @Override // oauth.signpost.OAuthProvider
    public void setRequestHeader(String str, String str2) {
        this.defaultHeaders.put(str, str2);
    }

    @Override // oauth.signpost.OAuthProvider
    public void setResponseParameters(HttpParameters httpParameters) {
        this.responseParameters = httpParameters;
    }
}
