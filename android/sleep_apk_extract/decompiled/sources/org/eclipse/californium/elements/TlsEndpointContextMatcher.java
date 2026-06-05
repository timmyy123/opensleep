package org.eclipse.californium.elements;

/* JADX INFO: loaded from: classes5.dex */
public class TlsEndpointContextMatcher extends KeySetEndpointContextMatcher {
    private static final String[] KEYS = {"CONNECTION_ID", "TLS_SESSION_ID", "TLS_CIPHER"};

    public TlsEndpointContextMatcher() {
        super("tls context", KEYS);
    }
}
