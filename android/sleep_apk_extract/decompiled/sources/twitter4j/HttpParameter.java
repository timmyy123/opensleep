package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpParameter implements Comparable<HttpParameter>, Serializable {
    private static final long serialVersionUID = 4046908449190454692L;
    private File file;
    private InputStream fileBody;
    private JSONObject jsonObject;
    private String name;
    private String value;

    public HttpParameter(String str, String str2, InputStream inputStream) {
        this.value = null;
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.file = new File(str2);
        this.fileBody = inputStream;
    }

    public static boolean containsFile(HttpParameter[] httpParameterArr) {
        if (httpParameterArr == null) {
            return false;
        }
        for (HttpParameter httpParameter : httpParameterArr) {
            if (httpParameter.isFile()) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsJson(HttpParameter[] httpParameterArr) {
        return httpParameterArr.length == 1 && httpParameterArr[0].isJson();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String encode(String str) {
        String strEncode;
        int i;
        try {
            strEncode = URLEncoder.encode(str, OAuth.ENCODING);
        } catch (UnsupportedEncodingException unused) {
            strEncode = null;
        }
        StringBuilder sb = new StringBuilder(strEncode.length());
        int i2 = 0;
        while (i2 < strEncode.length()) {
            char cCharAt = strEncode.charAt(i2);
            if (cCharAt == '*') {
                sb.append("%2A");
            } else if (cCharAt == '+') {
                sb.append("%20");
            } else if (cCharAt == '%' && (i = i2 + 1) < strEncode.length() && strEncode.charAt(i) == '7') {
                int i3 = i2 + 2;
                if (strEncode.charAt(i3) == 'E') {
                    sb.append('~');
                    i2 = i3;
                }
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb.toString();
    }

    public static String encodeParameters(HttpParameter[] httpParameterArr) {
        if (httpParameterArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < httpParameterArr.length; i++) {
            if (httpParameterArr[i].isFile()) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("parameter ["), httpParameterArr[i].name, "]should be text"));
                return null;
            }
            if (i != 0) {
                sb.append("&");
            }
            sb.append(encode(httpParameterArr[i].name));
            sb.append("=");
            sb.append(encode(httpParameterArr[i].value));
        }
        return sb.toString();
    }

    public static HttpParameter[] getParameterArray(String str, String str2, String str3, String str4) {
        return new HttpParameter[]{new HttpParameter(str, str2), new HttpParameter(str3, str4)};
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpParameter httpParameter) {
        String str;
        String str2 = this.name;
        int iCompareTo = str2 != null ? str2.compareTo(httpParameter.name) : 0;
        return (iCompareTo != 0 || (str = this.value) == null) ? iCompareTo : str.compareTo(httpParameter.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && HttpParameter.class == obj.getClass()) {
            HttpParameter httpParameter = (HttpParameter) obj;
            String str = this.name;
            String str2 = httpParameter.name;
            if (str == null ? str2 != null : !str.equals(str2)) {
                return false;
            }
            String str3 = this.value;
            String str4 = httpParameter.value;
            if (str3 == null ? str4 != null : !str3.equals(str4)) {
                return false;
            }
            JSONObject jSONObject = this.jsonObject;
            JSONObject jSONObject2 = httpParameter.jsonObject;
            if (jSONObject == null ? jSONObject2 != null : !jSONObject.equals(jSONObject2)) {
                return false;
            }
            File file = this.file;
            File file2 = httpParameter.file;
            if (file == null ? file2 != null : !file.equals(file2)) {
                return false;
            }
            InputStream inputStream = this.fileBody;
            InputStream inputStream2 = httpParameter.fileBody;
            if (inputStream != null) {
                return inputStream.equals(inputStream2);
            }
            if (inputStream2 == null) {
                return true;
            }
        }
        return false;
    }

    public String getContentType() {
        if (!isFile()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("not a file");
            return null;
        }
        String name = this.file.getName();
        if (-1 == name.lastIndexOf(".")) {
            return "application/octet-stream";
        }
        String lowerCase = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
        return lowerCase.length() == 3 ? "gif".equals(lowerCase) ? "image/gif" : "png".equals(lowerCase) ? "image/png" : "jpg".equals(lowerCase) ? "image/jpeg" : "application/octet-stream" : (lowerCase.length() == 4 && "jpeg".equals(lowerCase)) ? "image/jpeg" : "application/octet-stream";
    }

    public File getFile() {
        return this.file;
    }

    public InputStream getFileBody() {
        return this.fileBody;
    }

    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean hasFileBody() {
        return this.fileBody != null;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.jsonObject;
        int iHashCode3 = (iHashCode2 + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31;
        File file = this.file;
        int iHashCode4 = (iHashCode3 + (file != null ? file.hashCode() : 0)) * 31;
        InputStream inputStream = this.fileBody;
        return iHashCode4 + (inputStream != null ? inputStream.hashCode() : 0);
    }

    public boolean isFile() {
        return this.file != null;
    }

    public boolean isJson() {
        return this.jsonObject != null;
    }

    public String toString() {
        return "HttpParameter{name='" + this.name + "', value='" + this.value + "', jsonObject=" + this.jsonObject + ", file=" + this.file + ", fileBody=" + this.fileBody + '}';
    }

    public HttpParameter(JSONObject jSONObject) {
        this.name = null;
        this.value = null;
        this.file = null;
        this.fileBody = null;
        this.jsonObject = jSONObject;
    }

    public HttpParameter(String str, File file) {
        this.value = null;
        this.jsonObject = null;
        this.fileBody = null;
        this.name = str;
        this.file = file;
    }

    public HttpParameter(String str, String str2) {
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = str2;
    }

    public HttpParameter(String str, int i) {
        this.value = null;
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(i);
    }

    public HttpParameter(String str, long j) {
        this.value = null;
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(j);
    }

    public HttpParameter(String str, double d) {
        this.value = null;
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(d);
    }

    public HttpParameter(String str, boolean z) {
        this.value = null;
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(z);
    }
}
