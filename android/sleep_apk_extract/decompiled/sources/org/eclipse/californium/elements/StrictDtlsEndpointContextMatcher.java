package org.eclipse.californium.elements;

/* JADX INFO: loaded from: classes5.dex */
public class StrictDtlsEndpointContextMatcher extends KeySetEndpointContextMatcher {
    private static final String[] KEYS = {"DTLS_SESSION_ID", "DTLS_EPOCH", "DTLS_CIPHER"};

    public StrictDtlsEndpointContextMatcher() {
        super("strict context", KEYS, true);
    }
}
