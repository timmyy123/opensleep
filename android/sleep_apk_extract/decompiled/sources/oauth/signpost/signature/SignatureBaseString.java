package oauth.signpost.signature;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import java.net.URI;
import oauth.signpost.OAuth;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
public class SignatureBaseString {
    private HttpRequest request;
    private HttpParameters requestParameters;

    public SignatureBaseString(HttpRequest httpRequest, HttpParameters httpParameters) {
        this.request = httpRequest;
        this.requestParameters = httpParameters;
    }

    public String generate() throws OAuthMessageSignerException {
        try {
            return this.request.getMethod() + '&' + OAuth.percentEncode(normalizeRequestUrl()) + '&' + OAuth.percentEncode(normalizeRequestParameters());
        } catch (Exception e) {
            throw new OAuthMessageSignerException(e);
        }
    }

    public String normalizeRequestParameters() {
        if (this.requestParameters == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : this.requestParameters.keySet()) {
            if (!OAuth.OAUTH_SIGNATURE.equals(str) && !"realm".equals(str)) {
                if (i > 0) {
                    sb.append("&");
                }
                sb.append(this.requestParameters.getAsQueryString(str));
            }
            i++;
        }
        return sb.toString();
    }

    public String normalizeRequestUrl() {
        int iLastIndexOf;
        URI uri = new URI(this.request.getRequestUrl());
        String lowerCase = uri.getScheme().toLowerCase();
        String lowerCase2 = uri.getAuthority().toLowerCase();
        if (((lowerCase.equals("http") && uri.getPort() == 80) || (lowerCase.equals(TournamentShareDialogURIBuilder.scheme) && uri.getPort() == 443)) && (iLastIndexOf = lowerCase2.lastIndexOf(":")) >= 0) {
            lowerCase2 = lowerCase2.substring(0, iLastIndexOf);
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() <= 0) {
            rawPath = MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
        return FileInsert$$ExternalSyntheticOutline0.m(lowerCase, "://", lowerCase2, rawPath);
    }
}
