package twitter4j;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.firebase.ai.common.util.KtorKt;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oauth.signpost.OAuth;
import twitter4j.conf.ConfigurationContext;

/* JADX INFO: loaded from: classes5.dex */
class HttpClientImpl extends HttpClientBase implements Serializable {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Map<HttpClientConfiguration, HttpClient> instanceMap;
    private static final Logger logger = Logger.getLogger(HttpClientImpl.class);
    private static final long serialVersionUID = -403500272719330534L;

    static {
        try {
            if (Integer.parseInt((String) Class.forName("android.os.Build$VERSION").getField("SDK").get(null)) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
        } catch (Exception unused) {
        }
        instanceMap = new HashMap(1);
    }

    public HttpClientImpl() {
        super(ConfigurationContext.getInstance().getHttpClientConfiguration());
    }

    public static HttpClient getInstance(HttpClientConfiguration httpClientConfiguration) {
        Map<HttpClientConfiguration, HttpClient> map = instanceMap;
        HttpClient httpClient = map.get(httpClientConfiguration);
        if (httpClient != null) {
            return httpClient;
        }
        HttpClientImpl httpClientImpl = new HttpClientImpl(httpClientConfiguration);
        map.put(httpClientConfiguration, httpClientImpl);
        return httpClientImpl;
    }

    private void setHeaders(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        String authorizationHeader;
        Logger logger2 = logger;
        if (logger2.isDebugEnabled()) {
            logger2.debug("Request: ");
            logger2.debug(httpRequest.getMethod().name() + " ", httpRequest.getURL());
        }
        if (httpRequest.getAuthorization() != null && (authorizationHeader = httpRequest.getAuthorization().getAuthorizationHeader(httpRequest)) != null) {
            if (logger2.isDebugEnabled()) {
                logger2.debug("Authorization: ", authorizationHeader.replaceAll(".", "*"));
            }
            httpURLConnection.addRequestProperty(OAuth.HTTP_AUTHORIZATION_HEADER, authorizationHeader);
        }
        if (httpRequest.getRequestHeaders() != null) {
            for (String str : httpRequest.getRequestHeaders().keySet()) {
                httpURLConnection.addRequestProperty(str, httpRequest.getRequestHeaders().get(str));
                Logger logger3 = logger;
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(str, ": ");
                sbM.append(httpRequest.getRequestHeaders().get(str));
                logger3.debug(sbM.toString());
            }
        }
    }

    public HttpResponse get(String str) {
        return request(new HttpRequest(RequestMethod.GET, str, null, null, null));
    }

    public HttpURLConnection getConnection(String str) {
        HttpURLConnection httpURLConnection;
        if (isProxyConfigured()) {
            if (this.CONF.getHttpProxyUser() != null && !this.CONF.getHttpProxyUser().equals("")) {
                Logger logger2 = logger;
                if (logger2.isDebugEnabled()) {
                    logger2.debug("Proxy AuthUser: " + this.CONF.getHttpProxyUser());
                    logger2.debug("Proxy AuthPassword: " + this.CONF.getHttpProxyPassword().replaceAll(".", "*"));
                }
                Authenticator.setDefault(new Authenticator() { // from class: twitter4j.HttpClientImpl.1
                    @Override // java.net.Authenticator
                    public PasswordAuthentication getPasswordAuthentication() {
                        if (getRequestorType().equals(Authenticator.RequestorType.PROXY)) {
                            return new PasswordAuthentication(HttpClientImpl.this.CONF.getHttpProxyUser(), HttpClientImpl.this.CONF.getHttpProxyPassword().toCharArray());
                        }
                        return null;
                    }
                });
            }
            Proxy proxy = new Proxy(this.CONF.isHttpProxySocks() ? Proxy.Type.SOCKS : Proxy.Type.HTTP, InetSocketAddress.createUnresolved(this.CONF.getHttpProxyHost(), this.CONF.getHttpProxyPort()));
            Logger logger3 = logger;
            if (logger3.isDebugEnabled()) {
                logger3.debug("Opening proxied connection(" + this.CONF.getHttpProxyHost() + ":" + this.CONF.getHttpProxyPort() + ")");
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        }
        if (this.CONF.getHttpConnectionTimeout() > 0) {
            httpURLConnection.setConnectTimeout(this.CONF.getHttpConnectionTimeout());
        }
        if (this.CONF.getHttpReadTimeout() > 0) {
            httpURLConnection.setReadTimeout(this.CONF.getHttpReadTimeout());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    @Override // twitter4j.HttpClientBase
    public HttpResponse handleRequest(HttpRequest httpRequest) throws Throwable {
        int i;
        boolean z;
        int responseCode;
        OutputStream outputStream;
        HttpURLConnection connection;
        BufferedInputStream bufferedInputStream;
        String string;
        boolean z2 = true;
        int httpRetryCount = this.CONF.getHttpRetryCount() + 1;
        int i2 = 0;
        HttpResponseImpl httpResponseImpl = null;
        while (i2 < httpRetryCount) {
            try {
                connection = getConnection(httpRequest.getURL());
                connection.setDoInput(z2);
            } catch (Throwable th) {
                th = th;
            }
            try {
                setHeaders(httpRequest, connection);
                connection.setRequestMethod(httpRequest.getMethod().name());
                if (httpRequest.getMethod() == RequestMethod.POST) {
                    if (HttpParameter.containsFile(httpRequest.getParameters())) {
                        try {
                            String str = "----Twitter4J-upload" + System.currentTimeMillis();
                            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str);
                            String str2 = "--" + str;
                            connection.setDoOutput(z2);
                            outputStream = connection.getOutputStream();
                            try {
                                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                                HttpParameter[] parameters = httpRequest.getParameters();
                                int length = parameters.length;
                                int i3 = 0;
                                while (i3 < length) {
                                    HttpParameter httpParameter = parameters[i3];
                                    if (httpParameter.isFile()) {
                                        i = httpRetryCount;
                                        try {
                                            write(dataOutputStream, str2 + "\r\n");
                                            write(dataOutputStream, "Content-Disposition: form-data; name=\"" + httpParameter.getName() + "\"; filename=\"" + httpParameter.getFile().getName() + "\"\r\n");
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("Content-Type: ");
                                            sb.append(httpParameter.getContentType());
                                            sb.append(KtorKt.SSE_SEPARATOR);
                                            write(dataOutputStream, sb.toString());
                                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpParameter.hasFileBody() ? httpParameter.getFileBody() : new FileInputStream(httpParameter.getFile()));
                                            byte[] bArr = new byte[1024];
                                            while (true) {
                                                int i4 = bufferedInputStream2.read(bArr);
                                                bufferedInputStream = bufferedInputStream2;
                                                if (i4 == -1) {
                                                    break;
                                                }
                                                dataOutputStream.write(bArr, 0, i4);
                                                bufferedInputStream2 = bufferedInputStream;
                                            }
                                            write(dataOutputStream, "\r\n");
                                            bufferedInputStream.close();
                                        } catch (Throwable th2) {
                                            th = th2;
                                            z = true;
                                            responseCode = -1;
                                            try {
                                                outputStream.close();
                                            } catch (Exception unused) {
                                            }
                                            try {
                                                throw th;
                                            } catch (IOException e) {
                                                if (i2 == this.CONF.getHttpRetryCount()) {
                                                    throw new TwitterException(e.getMessage(), e, responseCode);
                                                }
                                            }
                                        }
                                    } else {
                                        i = httpRetryCount;
                                        write(dataOutputStream, str2 + "\r\n");
                                        write(dataOutputStream, "Content-Disposition: form-data; name=\"" + httpParameter.getName() + "\"\r\n");
                                        write(dataOutputStream, "Content-Type: text/plain; charset=UTF-8\r\n\r\n");
                                        logger.debug(httpParameter.getValue());
                                        dataOutputStream.write(httpParameter.getValue().getBytes(OAuth.ENCODING));
                                        write(dataOutputStream, "\r\n");
                                    }
                                    i3++;
                                    httpRetryCount = i;
                                }
                                i = httpRetryCount;
                                write(dataOutputStream, str2 + "--\r\n");
                                write(dataOutputStream, "\r\n");
                                z = true;
                            } catch (Throwable th3) {
                                th = th3;
                                i = httpRetryCount;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            i = httpRetryCount;
                            z = true;
                            responseCode = -1;
                            outputStream = null;
                        }
                    } else {
                        i = httpRetryCount;
                        try {
                            if (HttpParameter.containsJson(httpRequest.getParameters())) {
                                try {
                                    connection.setRequestProperty("Content-Type", "application/json");
                                    try {
                                        string = httpRequest.getParameters()[0].getJsonObject().toString();
                                    } catch (Throwable th5) {
                                        th = th5;
                                        z = true;
                                        responseCode = -1;
                                        outputStream = null;
                                        outputStream.close();
                                        throw th;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    z = true;
                                    responseCode = -1;
                                    outputStream = null;
                                    outputStream.close();
                                    throw th;
                                }
                            } else {
                                connection.setRequestProperty("Content-Type", OAuth.FORM_ENCODED);
                                string = HttpParameter.encodeParameters(httpRequest.getParameters());
                            }
                            logger.debug("Post Params: ", string);
                            byte[] bytes = string.getBytes(OAuth.ENCODING);
                            connection.setRequestProperty("Content-Length", Integer.toString(bytes.length));
                            z = true;
                            try {
                                connection.setDoOutput(true);
                                outputStream = connection.getOutputStream();
                                try {
                                    outputStream.write(bytes);
                                } catch (Throwable th7) {
                                    th = th7;
                                    responseCode = -1;
                                    outputStream.close();
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                responseCode = -1;
                                outputStream = null;
                                outputStream.close();
                                throw th;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            z = true;
                        }
                    }
                    outputStream.flush();
                    outputStream.close();
                } else {
                    i = httpRetryCount;
                    z = z2;
                    outputStream = null;
                }
                HttpResponseImpl httpResponseImpl2 = new HttpResponseImpl(connection, this.CONF);
                try {
                    responseCode = connection.getResponseCode();
                } catch (Throwable th10) {
                    th = th10;
                    httpResponseImpl = httpResponseImpl2;
                    responseCode = -1;
                    outputStream.close();
                    throw th;
                }
                try {
                    Logger logger2 = logger;
                    if (logger2.isDebugEnabled()) {
                        logger2.debug("Response: ");
                        Map<String, List<String>> headerFields = connection.getHeaderFields();
                        for (String str3 : headerFields.keySet()) {
                            for (String str4 : headerFields.get(str3)) {
                                if (str3 != null) {
                                    logger.debug(str3 + ": " + str4);
                                } else {
                                    logger.debug(str4);
                                }
                            }
                        }
                    }
                    if (responseCode >= 200 && (responseCode == 302 || 300 > responseCode)) {
                        try {
                            outputStream.close();
                        } catch (Exception unused2) {
                        }
                        return httpResponseImpl2;
                    }
                    if (responseCode == 420 || responseCode == 400 || responseCode < 500 || i2 == this.CONF.getHttpRetryCount()) {
                        throw new TwitterException(httpResponseImpl2.asString(), httpResponseImpl2);
                    }
                    try {
                        outputStream.close();
                    } catch (Exception unused3) {
                    }
                    httpResponseImpl = httpResponseImpl2;
                    try {
                        Logger logger3 = logger;
                        if (logger3.isDebugEnabled() && httpResponseImpl != null) {
                            httpResponseImpl.asString();
                        }
                        logger3.debug("Sleeping " + this.CONF.getHttpRetryIntervalSeconds() + " seconds until the next retry.");
                        Thread.sleep((long) (this.CONF.getHttpRetryIntervalSeconds() * 1000));
                    } catch (InterruptedException unused4) {
                    }
                    i2++;
                    z2 = z;
                    httpRetryCount = i;
                } catch (Throwable th11) {
                    th = th11;
                    httpResponseImpl = httpResponseImpl2;
                    outputStream.close();
                    throw th;
                }
            } catch (Throwable th12) {
                th = th12;
                i = httpRetryCount;
                z = z2;
                responseCode = -1;
                outputStream = null;
                outputStream.close();
                throw th;
            }
        }
        return httpResponseImpl;
    }

    public HttpResponse post(String str, HttpParameter[] httpParameterArr) {
        return request(new HttpRequest(RequestMethod.POST, str, httpParameterArr, null, null));
    }

    public HttpClientImpl(HttpClientConfiguration httpClientConfiguration) {
        super(httpClientConfiguration);
    }
}
