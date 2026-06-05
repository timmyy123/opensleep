package com.google.api.client.http.javanet;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Preconditions;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes4.dex */
public final class NetHttpTransport extends HttpTransport {
    private static final String[] SUPPORTED_METHODS;
    private final ConnectionFactory connectionFactory;
    private final HostnameVerifier hostnameVerifier;
    private final boolean isMtls;
    private final SSLSocketFactory sslSocketFactory;

    static {
        String[] strArr = {"DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};
        SUPPORTED_METHODS = strArr;
        Arrays.sort(strArr);
    }

    public NetHttpTransport(ConnectionFactory connectionFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, boolean z) {
        this.connectionFactory = getConnectionFactory(connectionFactory);
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.isMtls = z;
    }

    private static Proxy defaultProxy() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("https.proxyHost"), Integer.parseInt(System.getProperty("https.proxyPort"))));
    }

    private ConnectionFactory getConnectionFactory(ConnectionFactory connectionFactory) {
        return connectionFactory == null ? System.getProperty("com.google.api.client.should_use_proxy") != null ? new DefaultConnectionFactory(defaultProxy()) : new DefaultConnectionFactory() : connectionFactory;
    }

    @Override // com.google.api.client.http.HttpTransport
    public NetHttpRequest buildRequest(String str, String str2) throws ProtocolException {
        Preconditions.checkArgument(supportsMethod(str), "HTTP method %s not supported", str);
        HttpURLConnection httpURLConnectionOpenConnection = this.connectionFactory.openConnection(new URL(str2));
        httpURLConnectionOpenConnection.setRequestMethod(str);
        if (httpURLConnectionOpenConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnectionOpenConnection;
            HostnameVerifier hostnameVerifier = this.hostnameVerifier;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }
            SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return new NetHttpRequest(httpURLConnectionOpenConnection);
    }

    @Override // com.google.api.client.http.HttpTransport
    public boolean supportsMethod(String str) {
        return Arrays.binarySearch(SUPPORTED_METHODS, str) >= 0;
    }

    public NetHttpTransport() {
        this(null, null, null, false);
    }
}
