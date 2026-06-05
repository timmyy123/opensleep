package com.launchdarkly.eventsource;

import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.launchdarkly.eventsource.ConnectStrategy;
import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.logging.LogValues;
import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class HttpConnectStrategy extends ConnectStrategy {
    private static final Headers DEFAULT_HEADERS = new Headers.Builder().add("Accept", "text/event-stream").add("Cache-Control", "no-cache").build();
    private final ClientConfigurer clientConfigurer;
    private final OkHttpClient httpClient;
    private final RequestTransformer requestTransformer;
    final URI uri;

    public class Client extends ConnectStrategy.Client {
        final OkHttpClient httpClient = createHttpClient();
        private final LDLogger logger;

        public Client(LDLogger lDLogger) {
            this.logger = lDLogger;
        }

        private OkHttpClient createHttpClient() {
            if (HttpConnectStrategy.this.httpClient != null) {
                return HttpConnectStrategy.this.httpClient;
            }
            OkHttpClient.Builder builderConnectionPool = new OkHttpClient.Builder().connectionPool(new ConnectionPool(1, 1L, TimeUnit.SECONDS));
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder builderRetryOnConnectionFailure = builderConnectionPool.connectTimeout(10000L, timeUnit).readTimeout(5000L, timeUnit).writeTimeout(5000L, timeUnit).retryOnConnectionFailure(false);
            try {
                builderRetryOnConnectionFailure.sslSocketFactory(new ModernTLSSocketFactory(), HttpConnectStrategy.defaultTrustManager());
            } catch (GeneralSecurityException unused) {
            }
            if (HttpConnectStrategy.this.clientConfigurer != null) {
                HttpConnectStrategy.this.clientConfigurer.configure(builderRetryOnConnectionFailure);
            }
            return builderRetryOnConnectionFailure.build();
        }

        private Request createRequest(String str) {
            Request.Builder builderHeaders = new Request.Builder().url(HttpUrl.get(HttpConnectStrategy.this.uri)).headers(HttpConnectStrategy.DEFAULT_HEADERS);
            if (str != null && !str.isEmpty()) {
                builderHeaders.addHeader("Last-Event-ID", str);
            }
            return HttpConnectStrategy.this.requestTransformer == null ? builderHeaders.build() : HttpConnectStrategy.this.requestTransformer.transformRequest(builderHeaders.build());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (HttpConnectStrategy.this.httpClient == null) {
                if (this.httpClient.getConnectionPool() != null) {
                    this.httpClient.getConnectionPool().evictAll();
                }
                if (this.httpClient.getDispatcher() != null) {
                    this.httpClient.getDispatcher().cancelAll();
                    if (this.httpClient.getDispatcher().executorService() != null) {
                        this.httpClient.getDispatcher().executorService().shutdownNow();
                    }
                }
            }
        }

        @Override // com.launchdarkly.eventsource.ConnectStrategy.Client
        public ConnectStrategy.Client.Result connect(String str) throws StreamIOException, StreamHttpErrorException {
            this.logger.debug("Attempting to connect to SSE stream at {}", HttpConnectStrategy.this.uri);
            Call callNewCall = this.httpClient.newCall(createRequest(str));
            try {
                Response responseExecute = callNewCall.execute();
                if (responseExecute.isSuccessful()) {
                    return new ConnectStrategy.Client.Result(responseExecute.getBody().byteStream(), HttpConnectStrategy.this.uri, new RequestCloser(callNewCall), ResponseHeadersImpl.fromOkHttpHeaders(responseExecute.getHeaders()));
                }
                ResponseHeaders responseHeadersFromOkHttpHeaders = ResponseHeadersImpl.fromOkHttpHeaders(responseExecute.getHeaders());
                responseExecute.close();
                this.logger.info("Server returned HTTP error {}", Integer.valueOf(responseExecute.getCode()));
                throw new StreamHttpErrorException(responseExecute.getCode(), responseHeadersFromOkHttpHeaders);
            } catch (IOException e) {
                this.logger.info("Connection failed: {}", LogValues.exceptionSummary(e));
                throw new StreamIOException(e);
            }
        }

        @Override // com.launchdarkly.eventsource.ConnectStrategy.Client
        public URI getOrigin() {
            return HttpConnectStrategy.this.uri;
        }
    }

    public interface ClientConfigurer {
        void configure(OkHttpClient.Builder builder);
    }

    public static class RequestCloser implements Closeable {
        private final Call call;

        public RequestCloser(Call call) {
            this.call = call;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.call.cancel();
        }
    }

    public interface RequestTransformer {
        Request transformRequest(Request request);
    }

    private HttpConnectStrategy(URI uri, ClientConfigurer clientConfigurer, OkHttpClient okHttpClient, RequestTransformer requestTransformer) {
        if (uri == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("URI must not be null");
            throw null;
        }
        if (!uri.getScheme().equals("http") && !uri.getScheme().equals(TournamentShareDialogURIBuilder.scheme)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("URI scheme must be http or https");
            throw null;
        }
        this.uri = uri;
        this.httpClient = okHttpClient;
        this.clientConfigurer = clientConfigurer;
        this.requestTransformer = requestTransformer;
    }

    private HttpConnectStrategy addClientConfigurerAction(final ClientConfigurer clientConfigurer) {
        if (clientConfigurer == null) {
            return this;
        }
        if (this.clientConfigurer != null) {
            clientConfigurer = new ClientConfigurer() { // from class: com.launchdarkly.eventsource.HttpConnectStrategy.1
                @Override // com.launchdarkly.eventsource.HttpConnectStrategy.ClientConfigurer
                public void configure(OkHttpClient.Builder builder) {
                    HttpConnectStrategy.this.clientConfigurer.configure(builder);
                    clientConfigurer.configure(builder);
                }
            };
        }
        return new HttpConnectStrategy(this.uri, clientConfigurer, this.httpClient, this.requestTransformer);
    }

    private HttpConnectStrategy addRequestTransformerAction(final RequestTransformer requestTransformer) {
        if (requestTransformer == null) {
            return this;
        }
        if (this.requestTransformer != null) {
            requestTransformer = new RequestTransformer() { // from class: com.launchdarkly.eventsource.HttpConnectStrategy.2
                @Override // com.launchdarkly.eventsource.HttpConnectStrategy.RequestTransformer
                public Request transformRequest(Request request) {
                    return requestTransformer.transformRequest(HttpConnectStrategy.this.requestTransformer.transformRequest(request));
                }
            };
        }
        return new HttpConnectStrategy(this.uri, this.clientConfigurer, this.httpClient, requestTransformer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static X509TrustManager defaultTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        Home$$ExternalSyntheticBUOutline0.m("Unexpected default trust managers:", (Object) Arrays.toString(trustManagers));
        return null;
    }

    public HttpConnectStrategy connectTimeout(final long j, final TimeUnit timeUnit) {
        return addClientConfigurerAction(new ClientConfigurer() { // from class: com.launchdarkly.eventsource.HttpConnectStrategy.3
            @Override // com.launchdarkly.eventsource.HttpConnectStrategy.ClientConfigurer
            public void configure(OkHttpClient.Builder builder) {
                builder.connectTimeout(j, Helpers.timeUnitOrDefault(timeUnit));
            }
        });
    }

    @Override // com.launchdarkly.eventsource.ConnectStrategy
    public Client createClient(LDLogger lDLogger) {
        return new Client(lDLogger);
    }

    public HttpConnectStrategy headers(final Headers headers) {
        return addRequestTransformerAction(new RequestTransformer() { // from class: com.launchdarkly.eventsource.HttpConnectStrategy.5
            @Override // com.launchdarkly.eventsource.HttpConnectStrategy.RequestTransformer
            public Request transformRequest(Request request) {
                Request.Builder builderNewBuilder = request.newBuilder();
                for (String str : headers.names()) {
                    builderNewBuilder.removeHeader(str);
                    Iterator<String> it = headers.values(str).iterator();
                    while (it.hasNext()) {
                        builderNewBuilder.addHeader(str, it.next());
                    }
                }
                return builderNewBuilder.build();
            }
        });
    }

    public HttpConnectStrategy httpClient(OkHttpClient okHttpClient) {
        return new HttpConnectStrategy(this.uri, this.clientConfigurer, okHttpClient, this.requestTransformer);
    }

    public HttpConnectStrategy(URI uri) {
        this(uri, null, null, null);
    }
}
