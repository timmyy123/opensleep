package twitter4j.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import twitter4j.BASE64Encoder;
import twitter4j.HttpClient;
import twitter4j.HttpClientFactory;
import twitter4j.HttpParameter;
import twitter4j.HttpRequest;
import twitter4j.Logger;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
public class OAuthAuthorization implements Authorization, Serializable, OAuthSupport {
    private static transient HttpClient http = null;
    private static final long serialVersionUID = -886869424811858868L;
    private final Configuration conf;
    private String consumerSecret;
    private static final HttpParameter OAUTH_SIGNATURE_METHOD = new HttpParameter(OAuth.OAUTH_SIGNATURE_METHOD, "HMAC-SHA1");
    private static final Logger logger = Logger.getLogger(OAuthAuthorization.class);
    private static final Random RAND = new Random();
    private String consumerKey = "";
    private String realm = null;
    private OAuthToken oauthToken = null;

    public OAuthAuthorization(Configuration configuration) {
        this.conf = configuration;
        http = HttpClientFactory.getInstance(configuration.getHttpClientConfiguration());
        setOAuthConsumer(configuration.getOAuthConsumerKey(), configuration.getOAuthConsumerSecret());
        if (configuration.getOAuthAccessToken() == null || configuration.getOAuthAccessTokenSecret() == null) {
            return;
        }
        setOAuthAccessToken(new AccessToken(configuration.getOAuthAccessToken(), configuration.getOAuthAccessTokenSecret()));
    }

    public static String constructRequestURL(String str) {
        int iIndexOf = str.indexOf("?");
        if (-1 != iIndexOf) {
            str = str.substring(0, iIndexOf);
        }
        int iIndexOf2 = str.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR, 8);
        String lowerCase = str.substring(0, iIndexOf2).toLowerCase();
        int iIndexOf3 = lowerCase.indexOf(":", 8);
        if (-1 != iIndexOf3) {
            if (lowerCase.startsWith("http://") && lowerCase.endsWith(":80")) {
                lowerCase = lowerCase.substring(0, iIndexOf3);
            } else if (lowerCase.startsWith("https://") && lowerCase.endsWith(":443")) {
                lowerCase = lowerCase.substring(0, iIndexOf3);
            }
        }
        return lowerCase.concat(str.substring(iIndexOf2));
    }

    public static String encodeParameters(List<HttpParameter> list, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (HttpParameter httpParameter : list) {
            if (!httpParameter.isFile() && !httpParameter.isJson()) {
                if (sb.length() != 0) {
                    if (z) {
                        sb.append("\"");
                    }
                    sb.append(str);
                }
                sb.append(HttpParameter.encode(httpParameter.getName()));
                sb.append("=");
                if (z) {
                    sb.append("\"");
                }
                sb.append(HttpParameter.encode(httpParameter.getValue()));
            }
        }
        if (sb.length() != 0 && z) {
            sb.append("\"");
        }
        return sb.toString();
    }

    private void ensureTokenIsAvailable() {
        if (this.oauthToken != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("No Token available.");
    }

    private static String normalizeRequestParameters(List<HttpParameter> list) {
        Collections.sort(list);
        return encodeParameters(list);
    }

    private void parseGetParameters(String str, List<HttpParameter> list) {
        int iIndexOf = str.indexOf("?");
        if (-1 != iIndexOf) {
            try {
                for (String str2 : str.substring(iIndexOf + 1).split("&")) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length == 2) {
                        list.add(new HttpParameter(URLDecoder.decode(strArrSplit[0], OAuth.ENCODING), URLDecoder.decode(strArrSplit[1], OAuth.ENCODING)));
                    } else {
                        list.add(new HttpParameter(URLDecoder.decode(strArrSplit[0], OAuth.ENCODING), ""));
                    }
                }
            } catch (UnsupportedEncodingException unused) {
            }
        }
    }

    private static List<HttpParameter> toParamList(HttpParameter[] httpParameterArr) {
        ArrayList arrayList = new ArrayList(httpParameterArr.length);
        arrayList.addAll(Arrays.asList(httpParameterArr));
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OAuthSupport)) {
            return false;
        }
        OAuthAuthorization oAuthAuthorization = (OAuthAuthorization) obj;
        String str = this.consumerKey;
        String str2 = oAuthAuthorization.consumerKey;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.consumerSecret;
        String str4 = oAuthAuthorization.consumerSecret;
        if (str3 == null ? str4 != null : !str3.equals(str4)) {
            return false;
        }
        OAuthToken oAuthToken = this.oauthToken;
        OAuthToken oAuthToken2 = oAuthAuthorization.oauthToken;
        return oAuthToken == null ? oAuthToken2 == null : oAuthToken.equals(oAuthToken2);
    }

    public String generateAuthorizationHeader(String str, String str2, HttpParameter[] httpParameterArr, String str3, String str4, OAuthToken oAuthToken) {
        if (httpParameterArr == null) {
            httpParameterArr = new HttpParameter[0];
        }
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new HttpParameter(OAuth.OAUTH_CONSUMER_KEY, this.consumerKey));
        arrayList.add(OAUTH_SIGNATURE_METHOD);
        arrayList.add(new HttpParameter(OAuth.OAUTH_TIMESTAMP, str4));
        arrayList.add(new HttpParameter(OAuth.OAUTH_NONCE, str3));
        arrayList.add(new HttpParameter(OAuth.OAUTH_VERSION, OAuth.VERSION_1_0));
        if (oAuthToken != null) {
            arrayList.add(new HttpParameter(OAuth.OAUTH_TOKEN, oAuthToken.getToken()));
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size() + httpParameterArr.length);
        arrayList2.addAll(arrayList);
        if (!HttpParameter.containsFile(httpParameterArr)) {
            arrayList2.addAll(toParamList(httpParameterArr));
        }
        parseGetParameters(str2, arrayList2);
        String str5 = str + "&" + HttpParameter.encode(constructRequestURL(str2)) + "&" + HttpParameter.encode(normalizeRequestParameters(arrayList2));
        Logger logger2 = logger;
        logger2.debug("OAuth base string: ", str5);
        String strGenerateSignature = generateSignature(str5, oAuthToken);
        logger2.debug("OAuth signature: ", strGenerateSignature);
        arrayList.add(new HttpParameter(OAuth.OAUTH_SIGNATURE, strGenerateSignature));
        String str6 = this.realm;
        if (str6 != null) {
            arrayList.add(new HttpParameter("realm", str6));
        }
        return "OAuth " + encodeParameters(arrayList, ",", true);
    }

    public String generateSignature(String str, OAuthToken oAuthToken) {
        SecretKeySpec secretKeySpec;
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            if (oAuthToken == null) {
                secretKeySpec = new SecretKeySpec((HttpParameter.encode(this.consumerSecret) + "&").getBytes(), "HmacSHA1");
            } else {
                SecretKeySpec secretKeySpec2 = oAuthToken.getSecretKeySpec();
                if (secretKeySpec2 == null) {
                    SecretKeySpec secretKeySpec3 = new SecretKeySpec((HttpParameter.encode(this.consumerSecret) + "&" + HttpParameter.encode(oAuthToken.getTokenSecret())).getBytes(), "HmacSHA1");
                    oAuthToken.setSecretKeySpec(secretKeySpec3);
                    secretKeySpec = secretKeySpec3;
                } else {
                    secretKeySpec = secretKeySpec2;
                }
            }
            mac.init(secretKeySpec);
            return BASE64Encoder.encode(mac.doFinal(str.getBytes()));
        } catch (InvalidKeyException e) {
            logger.error("Failed initialize \"Message Authentication Code\" (MAC)", e);
            Utf8$$ExternalSyntheticBUOutline0.m$1(e);
            return null;
        } catch (NoSuchAlgorithmException e2) {
            logger.error("Failed to get HmacSHA1 \"Message Authentication Code\" (MAC)", e2);
            Utf8$$ExternalSyntheticBUOutline0.m$1(e2);
            return null;
        }
    }

    @Override // twitter4j.auth.Authorization
    public String getAuthorizationHeader(HttpRequest httpRequest) {
        return generateAuthorizationHeader(httpRequest.getMethod().name(), httpRequest.getURL(), httpRequest.getParameters(), this.oauthToken);
    }

    @Override // twitter4j.auth.OAuthSupport
    public AccessToken getOAuthAccessToken(String str, String str2) throws TwitterException {
        try {
            String oAuthAccessTokenURL = this.conf.getOAuthAccessTokenURL();
            if (oAuthAccessTokenURL.indexOf("http://") == 0) {
                oAuthAccessTokenURL = "https://".concat(oAuthAccessTokenURL.substring(7));
            }
            AccessToken accessToken = new AccessToken(http.post(oAuthAccessTokenURL, new HttpParameter[]{new HttpParameter("x_auth_username", str), new HttpParameter("x_auth_password", str2), new HttpParameter("x_auth_mode", "client_auth")}, this, null));
            this.oauthToken = accessToken;
            return accessToken;
        } catch (TwitterException e) {
            throw new TwitterException("The screen name / password combination seems to be invalid.", e, e.getStatusCode());
        }
    }

    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str, String str2, String str3) {
        if (this.oauthToken instanceof AccessToken) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Access token already available.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(new HttpParameter(OAuth.OAUTH_CALLBACK, str));
        }
        if (str2 != null) {
            arrayList.add(new HttpParameter("x_auth_access_type", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("x_auth_mode", str3));
        }
        RequestToken requestToken = new RequestToken(http.post(this.conf.getOAuthRequestTokenURL(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]), this, null), this);
        this.oauthToken = requestToken;
        return requestToken;
    }

    public int hashCode() {
        String str = this.consumerKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.consumerSecret;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        OAuthToken oAuthToken = this.oauthToken;
        return iHashCode2 + (oAuthToken != null ? oAuthToken.hashCode() : 0);
    }

    @Override // twitter4j.auth.Authorization
    public boolean isEnabled() {
        OAuthToken oAuthToken = this.oauthToken;
        return oAuthToken != null && (oAuthToken instanceof AccessToken);
    }

    @Override // twitter4j.auth.OAuthSupport
    public void setOAuthAccessToken(AccessToken accessToken) {
        this.oauthToken = accessToken;
    }

    @Override // twitter4j.auth.OAuthSupport
    public void setOAuthConsumer(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.consumerKey = str;
        if (str2 == null) {
            str2 = "";
        }
        this.consumerSecret = str2;
    }

    public String toString() {
        return "OAuthAuthorization{consumerKey='" + this.consumerKey + "', consumerSecret='******************************************', oauthToken=" + this.oauthToken + '}';
    }

    @Override // twitter4j.auth.OAuthSupport
    public AccessToken getOAuthAccessToken(String str) {
        ensureTokenIsAvailable();
        AccessToken accessToken = new AccessToken(http.post(this.conf.getOAuthAccessTokenURL(), new HttpParameter[]{new HttpParameter(OAuth.OAUTH_VERIFIER, str)}, this, null));
        this.oauthToken = accessToken;
        return accessToken;
    }

    @Override // twitter4j.auth.OAuthSupport
    public AccessToken getOAuthAccessToken(RequestToken requestToken) {
        this.oauthToken = requestToken;
        return getOAuthAccessToken();
    }

    @Override // twitter4j.auth.OAuthSupport
    public AccessToken getOAuthAccessToken(RequestToken requestToken, String str) {
        this.oauthToken = requestToken;
        return getOAuthAccessToken(str);
    }

    @Override // twitter4j.auth.OAuthSupport
    public AccessToken getOAuthAccessToken() {
        ensureTokenIsAvailable();
        OAuthToken oAuthToken = this.oauthToken;
        if (oAuthToken instanceof AccessToken) {
            return (AccessToken) oAuthToken;
        }
        AccessToken accessToken = new AccessToken(http.post(this.conf.getOAuthAccessTokenURL(), null, this, null));
        this.oauthToken = accessToken;
        return accessToken;
    }

    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str, String str2) {
        return getOAuthRequestToken(str, str2, null);
    }

    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str) {
        return getOAuthRequestToken(str, null, null);
    }

    public static String encodeParameters(List<HttpParameter> list) {
        return encodeParameters(list, "&", false);
    }

    public String generateAuthorizationHeader(String str, String str2, HttpParameter[] httpParameterArr, OAuthToken oAuthToken) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        return generateAuthorizationHeader(str, str2, httpParameterArr, String.valueOf(((long) RAND.nextInt()) + jCurrentTimeMillis), String.valueOf(jCurrentTimeMillis), oAuthToken);
    }
}
