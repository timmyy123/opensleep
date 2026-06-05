package twitter4j;

import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
abstract class ParseUtil {
    private static final Map<String, LinkedBlockingQueue<SimpleDateFormat>> formatMapQueue = new HashMap();

    public static boolean getBoolean(String str, JSONObject jSONObject) {
        String rawString = getRawString(str, jSONObject);
        if (rawString == null || "null".equals(rawString)) {
            return false;
        }
        return Boolean.valueOf(rawString).booleanValue();
    }

    public static Date getDate(String str, String str2) {
        Map<String, LinkedBlockingQueue<SimpleDateFormat>> map = formatMapQueue;
        LinkedBlockingQueue<SimpleDateFormat> linkedBlockingQueue = map.get(str2);
        if (linkedBlockingQueue == null) {
            linkedBlockingQueue = new LinkedBlockingQueue<>();
            map.put(str2, linkedBlockingQueue);
        }
        SimpleDateFormat simpleDateFormatPoll = linkedBlockingQueue.poll();
        if (simpleDateFormatPoll == null) {
            simpleDateFormatPoll = new SimpleDateFormat(str2, Locale.US);
            simpleDateFormatPoll.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }
        try {
            try {
                return simpleDateFormatPoll.parse(str);
            } finally {
                try {
                    linkedBlockingQueue.put(simpleDateFormatPoll);
                } catch (InterruptedException unused) {
                }
            }
        } catch (ParseException e) {
            throw new TwitterException("Unexpected date format(" + str + ") returned from twitter.com", e);
        }
    }

    public static int getInt(String str) {
        if (str != null && !"".equals(str) && !"null".equals(str)) {
            try {
                return Integer.valueOf(str).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public static long getLong(String str) {
        if (str == null || "".equals(str) || "null".equals(str)) {
            return -1L;
        }
        return str.endsWith(MqttTopic.SINGLE_LEVEL_WILDCARD) ? Long.valueOf(str.substring(0, str.length() - 1)).longValue() + 1 : Long.valueOf(str).longValue();
    }

    public static String getRawString(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        } catch (JSONException | Exception unused) {
            return null;
        }
    }

    public static String getUnescapedString(String str, JSONObject jSONObject) {
        return HTMLEntity.unescape(getRawString(str, jSONObject));
    }

    public static Date parseTrendsDate(String str) {
        int length = str.length();
        return length != 10 ? length != 20 ? getDate(str, "EEE, d MMM yyyy HH:mm:ss z") : getDate(str, "yyyy-MM-dd'T'HH:mm:ss'Z'") : new Date(Long.parseLong(str) * 1000);
    }

    public static int toAccessLevel(HttpResponse httpResponse) {
        if (httpResponse == null) {
            return -1;
        }
        String responseHeader = httpResponse.getResponseHeader("X-Access-Level");
        if (responseHeader == null) {
            return 0;
        }
        int length = responseHeader.length();
        if (length == 4) {
            return 1;
        }
        if (length != 10) {
            return (length == 25 || length == 26) ? 3 : 0;
        }
        return 2;
    }

    public static int getInt(String str, JSONObject jSONObject) {
        return getInt(getRawString(str, jSONObject));
    }

    public static long getLong(String str, JSONObject jSONObject) {
        return getLong(getRawString(str, jSONObject));
    }

    public static Date getDate(String str, JSONObject jSONObject, String str2) {
        String unescapedString = getUnescapedString(str, jSONObject);
        if ("null".equals(unescapedString) || unescapedString == null) {
            return null;
        }
        return getDate(unescapedString, str2);
    }

    public static Date getDate(String str, JSONObject jSONObject) {
        return getDate(str, jSONObject, "EEE MMM d HH:mm:ss z yyyy");
    }
}
