package io.github.zeroone3010.yahueapi.v2;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda0;
import io.github.zeroone3010.yahueapi.HueApiException;
import io.github.zeroone3010.yahueapi.SecureJsonFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger("io.github.zeroone3010.yahueapi");

    private HttpUtil() {
    }

    public static ObjectMapper buildObjectMapper(String str) {
        return JsonMapper.builder(new SecureJsonFactory(str)).enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, true).build();
    }

    public static HttpsURLConnection getAnonymousUrlConnection(URL url) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            SecureJsonFactory secureJsonFactory = (SecureJsonFactory) buildObjectMapper(url.getHost()).getFactory();
            httpsURLConnection.setSSLSocketFactory(secureJsonFactory.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(secureJsonFactory.getHostnameVerifier());
            return httpsURLConnection;
        } catch (IOException e) {
            throw new HueApiException(e);
        }
    }

    private static String getString(Function<URL, HttpsURLConnection> function, URL url, String str, String str2, String str3) {
        try {
            logger.trace("Request body: " + str2);
            HttpsURLConnection httpsURLConnectionApply = function.apply(new URL(url.toString() + str));
            httpsURLConnectionApply.setDoOutput(true);
            httpsURLConnectionApply.setRequestMethod(str3);
            httpsURLConnectionApply.setRequestProperty("Host", httpsURLConnectionApply.getURL().getHost());
            if (str2 != null) {
                OutputStream outputStream = httpsURLConnectionApply.getOutputStream();
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                    try {
                        outputStreamWriter.write(str2);
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    } finally {
                    }
                } finally {
                }
            }
            httpsURLConnectionApply.connect();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnectionApply.getInputStream()));
            try {
                String str4 = (String) bufferedReader.lines().collect(Collectors.joining("\n"));
                bufferedReader.close();
                return str4;
            } finally {
            }
        } catch (IOException e) {
            throw new HueApiException(e);
        }
    }

    public static String post(Hue hue, URL url, String str, String str2) {
        Objects.requireNonNull(hue);
        return getString(new Hue$$ExternalSyntheticLambda7(hue, 2), url, str, str2, "POST");
    }

    public static String put(Hue hue, URL url, String str, String str2) {
        Objects.requireNonNull(hue);
        return getString(new Hue$$ExternalSyntheticLambda7(hue, 2), url, str, str2, "PUT");
    }

    public static String post(URL url, String str, String str2) {
        return getString(new Color$$ExternalSyntheticLambda0(17), url, str, str2, "POST");
    }
}
