package twitter4j;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import twitter4j.auth.Authorization;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpRequest implements Serializable {
    private static final HttpParameter[] NULL_PARAMETERS = new HttpParameter[0];
    private static final long serialVersionUID = 3365496352032493020L;
    private final Authorization authorization;
    private final RequestMethod method;
    private final HttpParameter[] parameters;
    private final Map<String, String> requestHeaders;
    private final String url;

    public HttpRequest(RequestMethod requestMethod, String str, HttpParameter[] httpParameterArr, Authorization authorization, Map<String, String> map) {
        this.method = requestMethod;
        if (requestMethod == RequestMethod.POST || httpParameterArr == null || httpParameterArr.length == 0) {
            this.url = str;
            this.parameters = httpParameterArr;
        } else {
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(str, "?");
            sbM.append(HttpParameter.encodeParameters(httpParameterArr));
            this.url = sbM.toString();
            this.parameters = NULL_PARAMETERS;
        }
        this.authorization = authorization;
        this.requestHeaders = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HttpRequest.class != obj.getClass()) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        Authorization authorization = this.authorization;
        Authorization authorization2 = httpRequest.authorization;
        if (authorization == null ? authorization2 != null : !authorization.equals(authorization2)) {
            return false;
        }
        if (!Arrays.equals(this.parameters, httpRequest.parameters)) {
            return false;
        }
        Map<String, String> map = this.requestHeaders;
        Map<String, String> map2 = httpRequest.requestHeaders;
        if (map == null ? map2 != null : !map.equals(map2)) {
            return false;
        }
        RequestMethod requestMethod = this.method;
        RequestMethod requestMethod2 = httpRequest.method;
        if (requestMethod == null ? requestMethod2 != null : !requestMethod.equals(requestMethod2)) {
            return false;
        }
        String str = this.url;
        String str2 = httpRequest.url;
        return str == null ? str2 == null : str.equals(str2);
    }

    public Authorization getAuthorization() {
        return this.authorization;
    }

    public RequestMethod getMethod() {
        return this.method;
    }

    public HttpParameter[] getParameters() {
        return this.parameters;
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public String getURL() {
        return this.url;
    }

    public int hashCode() {
        RequestMethod requestMethod = this.method;
        int iHashCode = (requestMethod != null ? requestMethod.hashCode() : 0) * 31;
        String str = this.url;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        HttpParameter[] httpParameterArr = this.parameters;
        int iHashCode3 = (iHashCode2 + (httpParameterArr != null ? Arrays.hashCode(httpParameterArr) : 0)) * 31;
        Authorization authorization = this.authorization;
        int iHashCode4 = (iHashCode3 + (authorization != null ? authorization.hashCode() : 0)) * 31;
        Map<String, String> map = this.requestHeaders;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HttpRequest{requestMethod=");
        sb.append(this.method);
        sb.append(", url='");
        sb.append(this.url);
        sb.append("', postParams=");
        HttpParameter[] httpParameterArr = this.parameters;
        sb.append(httpParameterArr == null ? null : Arrays.asList(httpParameterArr));
        sb.append(", authentication=");
        sb.append(this.authorization);
        sb.append(", requestHeaders=");
        sb.append(this.requestHeaders);
        sb.append('}');
        return sb.toString();
    }
}
