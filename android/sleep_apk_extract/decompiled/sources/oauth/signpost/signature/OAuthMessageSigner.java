package oauth.signpost.signature;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;
import org.apache.commons.codec.binary.Base64;

/* JADX INFO: loaded from: classes5.dex */
public abstract class OAuthMessageSigner implements Serializable {
    private static final long serialVersionUID = 4445779788786131202L;
    private transient Base64 base64 = new Base64();
    private String consumerSecret;
    private String tokenSecret;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.base64 = new Base64();
    }

    public String base64Encode(byte[] bArr) {
        return new String(this.base64.encode(bArr));
    }

    public byte[] decodeBase64(String str) {
        return this.base64.decode(str.getBytes());
    }

    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    public abstract String getSignatureMethod();

    public String getTokenSecret() {
        return this.tokenSecret;
    }

    public void setConsumerSecret(String str) {
        this.consumerSecret = str;
    }

    public void setTokenSecret(String str) {
        this.tokenSecret = str;
    }

    public abstract String sign(HttpRequest httpRequest, HttpParameters httpParameters);
}
