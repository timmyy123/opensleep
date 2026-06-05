package oauth.signpost.signature;

import oauth.signpost.OAuth;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public class PlainTextMessageSigner extends OAuthMessageSigner {
    @Override // oauth.signpost.signature.OAuthMessageSigner
    public String getSignatureMethod() {
        return "PLAINTEXT";
    }

    @Override // oauth.signpost.signature.OAuthMessageSigner
    public String sign(HttpRequest httpRequest, HttpParameters httpParameters) {
        return OAuth.percentEncode(getConsumerSecret()) + '&' + OAuth.percentEncode(getTokenSecret());
    }
}
