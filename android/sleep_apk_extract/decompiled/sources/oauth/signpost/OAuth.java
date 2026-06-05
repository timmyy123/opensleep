package oauth.signpost;

import com.google.gdata.util.common.base.PercentEscaper;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import oauth.signpost.http.HttpParameters;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class OAuth {
    public static final String ENCODING = "UTF-8";
    public static final String FORM_ENCODED = "application/x-www-form-urlencoded";
    public static final String HTTP_AUTHORIZATION_HEADER = "Authorization";
    public static final String OAUTH_CALLBACK = "oauth_callback";
    public static final String OAUTH_CALLBACK_CONFIRMED = "oauth_callback_confirmed";
    public static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    public static final String OAUTH_NONCE = "oauth_nonce";
    public static final String OAUTH_SIGNATURE = "oauth_signature";
    public static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    public static final String OAUTH_TIMESTAMP = "oauth_timestamp";
    public static final String OAUTH_TOKEN = "oauth_token";
    public static final String OAUTH_TOKEN_SECRET = "oauth_token_secret";
    public static final String OAUTH_VERIFIER = "oauth_verifier";
    public static final String OAUTH_VERSION = "oauth_version";
    public static final String OUT_OF_BAND = "oob";
    public static final String VERSION_1_0 = "1.0";
    private static final PercentEscaper percentEncoder = new PercentEscaper("-._~", false);

    public static String addQueryParameters(String str, String... strArr) {
        StringBuilder sb = new StringBuilder(str.concat(str.contains("?") ? "&" : "?"));
        for (int i = 0; i < strArr.length; i += 2) {
            if (i > 0) {
                sb.append("&");
            }
            sb.append(percentEncode(strArr[i]) + "=" + percentEncode(strArr[i + 1]));
        }
        return sb.toString();
    }

    public static void debugOut(String str, String str2) {
        if (System.getProperty("debug") != null) {
            System.out.println("[SIGNPOST] " + str + ": " + str2);
        }
    }

    public static HttpParameters decodeForm(String str) {
        String strPercentDecode;
        String strPercentDecode2;
        HttpParameters httpParameters = new HttpParameters();
        if (!isEmpty(str)) {
            for (String str2 : str.split("\\&")) {
                int iIndexOf = str2.indexOf(61);
                if (iIndexOf < 0) {
                    strPercentDecode2 = percentDecode(str2);
                    strPercentDecode = null;
                } else {
                    String strPercentDecode3 = percentDecode(str2.substring(0, iIndexOf));
                    strPercentDecode = percentDecode(str2.substring(iIndexOf + 1));
                    strPercentDecode2 = strPercentDecode3;
                }
                httpParameters.put(strPercentDecode2, strPercentDecode);
            }
        }
        return httpParameters;
    }

    public static <T extends Map.Entry<String, String>> void formEncode(Collection<T> collection, OutputStream outputStream) throws IOException {
        if (collection != null) {
            boolean z = true;
            for (T t : collection) {
                if (z) {
                    z = false;
                } else {
                    outputStream.write(38);
                }
                outputStream.write(percentEncode(safeToString(t.getKey())).getBytes());
                outputStream.write(61);
                outputStream.write(percentEncode(safeToString(t.getValue())).getBytes());
            }
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static HttpParameters oauthHeaderToParamsMap(String str) {
        HttpParameters httpParameters = new HttpParameters();
        if (str != null && str.startsWith("OAuth ")) {
            for (String str2 : str.substring(6).split(",")) {
                String[] strArrSplit = str2.split("=");
                httpParameters.put(strArrSplit[0].trim(), strArrSplit[1].replace("\"", "").trim());
            }
        }
        return httpParameters;
    }

    public static String percentDecode(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, ENCODING);
        } catch (UnsupportedEncodingException e) {
            Utf8$$ExternalSyntheticBUOutline0.m(e.getMessage(), (Throwable) e);
            return null;
        }
    }

    public static String percentEncode(String str) {
        return str == null ? "" : percentEncoder.escape(str);
    }

    public static String prepareOAuthHeader(String... strArr) {
        StringBuilder sb = new StringBuilder("OAuth ");
        for (int i = 0; i < strArr.length; i += 2) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(percentEncode(strArr[i]) + "=\"" + (strArr[i].startsWith("oauth_") ? percentEncode(strArr[i + 1]) : strArr[i + 1]) + "\"");
        }
        return sb.toString();
    }

    public static final String safeToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static String toHeaderElement(String str, String str2) {
        return percentEncode(str) + "=\"" + percentEncode(str2) + "\"";
    }

    public static <T extends Map.Entry<String, String>> Map<String, String> toMap(Collection<T> collection) {
        HashMap map = new HashMap();
        if (collection != null) {
            for (T t : collection) {
                String str = (String) t.getKey();
                if (!map.containsKey(str)) {
                    map.put(str, t.getValue());
                }
            }
        }
        return map;
    }

    public static HttpParameters decodeForm(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            sb.append(line);
        }
        return decodeForm(sb.toString());
    }

    public static <T extends Map.Entry<String, String>> String formEncode(Collection<T> collection) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        formEncode(collection, byteArrayOutputStream);
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static String addQueryParameters(String str, Map<String, String> map) {
        String[] strArr = new String[map.size() * 2];
        int i = 0;
        for (String str2 : map.keySet()) {
            strArr[i] = str2;
            strArr[i + 1] = map.get(str2);
            i += 2;
        }
        return addQueryParameters(str, strArr);
    }
}
