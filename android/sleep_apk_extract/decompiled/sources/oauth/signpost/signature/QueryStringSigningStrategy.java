package oauth.signpost.signature;

import oauth.signpost.OAuth;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public class QueryStringSigningStrategy implements SigningStrategy {
    private static final long serialVersionUID = 1;

    @Override // oauth.signpost.signature.SigningStrategy
    public String writeSignature(String str, HttpRequest httpRequest, HttpParameters httpParameters) {
        StringBuilder sb = new StringBuilder(OAuth.addQueryParameters(httpRequest.getRequestUrl(), OAuth.OAUTH_SIGNATURE, str));
        if (httpParameters.containsKey(OAuth.OAUTH_TOKEN)) {
            sb.append("&");
            sb.append(httpParameters.getAsQueryString(OAuth.OAUTH_TOKEN));
        }
        if (httpParameters.containsKey(OAuth.OAUTH_CALLBACK)) {
            sb.append("&");
            sb.append(httpParameters.getAsQueryString(OAuth.OAUTH_CALLBACK));
        }
        if (httpParameters.containsKey(OAuth.OAUTH_VERIFIER)) {
            sb.append("&");
            sb.append(httpParameters.getAsQueryString(OAuth.OAUTH_VERIFIER));
        }
        sb.append("&");
        sb.append(httpParameters.getAsQueryString(OAuth.OAUTH_CONSUMER_KEY));
        sb.append("&");
        sb.append(httpParameters.getAsQueryString(OAuth.OAUTH_VERSION));
        sb.append("&");
        sb.append(httpParameters.getAsQueryString(OAuth.OAUTH_SIGNATURE_METHOD));
        sb.append("&");
        sb.append(httpParameters.getAsQueryString(OAuth.OAUTH_TIMESTAMP));
        sb.append("&");
        sb.append(httpParameters.getAsQueryString(OAuth.OAUTH_NONCE));
        String string = sb.toString();
        httpRequest.setRequestUrl(string);
        return string;
    }
}
