package io.github.zeroone3010.yahueapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes5.dex */
final class HttpUtil {
    private HttpUtil() {
    }

    private static String getString(URL url, String str, String str2, String str3) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(url.toString() + str).openConnection();
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod(str3);
            httpsURLConnection.setRequestProperty("Host", httpsURLConnection.getURL().getHost());
            if (str2 != null) {
                OutputStream outputStream = httpsURLConnection.getOutputStream();
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
            httpsURLConnection.connect();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
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

    public static String post(URL url, String str, String str2) {
        return getString(url, str, str2, "POST");
    }

    public static String put(URL url, String str, String str2) {
        return getString(url, str, str2, "PUT");
    }
}
