package twitter4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HttpClientFactory {
    private static final Constructor<?> HTTP_CLIENT_CONSTRUCTOR;
    private static final ConcurrentHashMap<HttpClientConfiguration, HttpClient> confClientMap;

    static {
        Class<?> cls;
        String property = System.getProperty("twitter4j.http.httpClient");
        if (property != null) {
            try {
                cls = Class.forName(property);
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
        } else {
            cls = null;
        }
        if (cls == null) {
            try {
                cls = Class.forName("twitter4j.AlternativeHttpClientImpl");
            } catch (ClassNotFoundException unused2) {
            }
        }
        if (cls == null) {
            try {
                cls = HttpClientImpl.class;
                int i = HttpClientImpl.$r8$clinit;
            } catch (ClassNotFoundException e) {
                Utf8$$ExternalSyntheticBUOutline0.m$1(e);
                return;
            }
        }
        try {
            HTTP_CLIENT_CONSTRUCTOR = cls.getConstructor(HttpClientConfiguration.class);
            confClientMap = new ConcurrentHashMap<>();
        } catch (NoSuchMethodException e2) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e2);
        }
    }

    public static HttpClient getInstance(HttpClientConfiguration httpClientConfiguration) {
        ConcurrentHashMap<HttpClientConfiguration, HttpClient> concurrentHashMap = confClientMap;
        HttpClient httpClient = concurrentHashMap.get(httpClientConfiguration);
        if (httpClient == null) {
            httpClient = null;
            try {
                HttpClient httpClient2 = (HttpClient) HTTP_CLIENT_CONSTRUCTOR.newInstance(httpClientConfiguration);
                concurrentHashMap.put(httpClientConfiguration, httpClient2);
                return httpClient2;
            } catch (IllegalAccessException e) {
                Utf8$$ExternalSyntheticBUOutline0.m$1(e);
                return null;
            } catch (InstantiationException e2) {
                Utf8$$ExternalSyntheticBUOutline0.m$1(e2);
            } catch (InvocationTargetException e3) {
                Utf8$$ExternalSyntheticBUOutline0.m$1(e3);
                return null;
            }
        }
        return httpClient;
    }
}
