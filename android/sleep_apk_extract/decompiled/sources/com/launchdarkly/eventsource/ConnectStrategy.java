package com.launchdarkly.eventsource;

import com.launchdarkly.logging.LDLogger;
import java.io.Closeable;
import java.io.InputStream;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ConnectStrategy {

    /* JADX INFO: loaded from: classes4.dex */
    public static abstract class Client implements Closeable {

        public static class Result {
            private final Closeable closer;
            private final ResponseHeaders headers;
            private final InputStream inputStream;
            private final URI origin;

            public Result(InputStream inputStream, URI uri, Closeable closeable, ResponseHeaders responseHeaders) {
                this.inputStream = inputStream;
                this.origin = uri;
                this.closer = closeable;
                this.headers = responseHeaders;
            }

            public Closeable getCloser() {
                return this.closer;
            }

            public ResponseHeaders getHeaders() {
                return this.headers;
            }

            public InputStream getInputStream() {
                return this.inputStream;
            }

            public URI getOrigin() {
                return this.origin;
            }
        }

        public abstract Result connect(String str);

        public abstract URI getOrigin();
    }

    public static HttpConnectStrategy http(URI uri) {
        return new HttpConnectStrategy(uri);
    }

    public abstract Client createClient(LDLogger lDLogger);
}
