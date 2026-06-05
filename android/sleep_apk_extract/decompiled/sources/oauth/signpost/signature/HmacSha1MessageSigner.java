package oauth.signpost.signature;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import oauth.signpost.OAuth;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public class HmacSha1MessageSigner extends OAuthMessageSigner {
    private static final String MAC_NAME = "HmacSHA1";

    @Override // oauth.signpost.signature.OAuthMessageSigner
    public String getSignatureMethod() {
        return "HMAC-SHA1";
    }

    @Override // oauth.signpost.signature.OAuthMessageSigner
    public String sign(HttpRequest httpRequest, HttpParameters httpParameters) throws OAuthMessageSignerException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec((OAuth.percentEncode(getConsumerSecret()) + '&' + OAuth.percentEncode(getTokenSecret())).getBytes(OAuth.ENCODING), MAC_NAME);
            Mac mac = Mac.getInstance(MAC_NAME);
            mac.init(secretKeySpec);
            String strGenerate = new SignatureBaseString(httpRequest, httpParameters).generate();
            OAuth.debugOut("SBS", strGenerate);
            return base64Encode(mac.doFinal(strGenerate.getBytes(OAuth.ENCODING))).trim();
        } catch (UnsupportedEncodingException e) {
            throw new OAuthMessageSignerException(e);
        } catch (GeneralSecurityException e2) {
            throw new OAuthMessageSignerException(e2);
        }
    }
}
