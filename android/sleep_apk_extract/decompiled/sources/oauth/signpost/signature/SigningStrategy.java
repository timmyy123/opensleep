package oauth.signpost.signature;

import java.io.Serializable;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public interface SigningStrategy extends Serializable {
    String writeSignature(String str, HttpRequest httpRequest, HttpParameters httpParameters);
}
