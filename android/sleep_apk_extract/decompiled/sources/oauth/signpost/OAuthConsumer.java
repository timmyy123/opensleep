package oauth.signpost;

import java.io.Serializable;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;
import oauth.signpost.signature.OAuthMessageSigner;
import oauth.signpost.signature.SigningStrategy;

/* JADX INFO: loaded from: classes5.dex */
public interface OAuthConsumer extends Serializable {
    String getConsumerKey();

    String getConsumerSecret();

    HttpParameters getRequestParameters();

    String getToken();

    String getTokenSecret();

    void setAdditionalParameters(HttpParameters httpParameters);

    void setMessageSigner(OAuthMessageSigner oAuthMessageSigner);

    void setSendEmptyTokens(boolean z);

    void setSigningStrategy(SigningStrategy signingStrategy);

    void setTokenWithSecret(String str, String str2);

    String sign(String str);

    HttpRequest sign(Object obj);

    HttpRequest sign(HttpRequest httpRequest);
}
