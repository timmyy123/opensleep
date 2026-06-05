package org.eclipse.californium.elements;

/* JADX INFO: loaded from: classes5.dex */
public class RelaxedDtlsEndpointContextMatcher extends KeySetEndpointContextMatcher {
    private static final String[] KEYS = {"DTLS_SESSION_ID", "DTLS_CIPHER"};

    public RelaxedDtlsEndpointContextMatcher() {
        super("relaxed context", KEYS, true);
    }
}
