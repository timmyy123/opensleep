package org.eclipse.californium.elements;

/* JADX INFO: loaded from: classes5.dex */
public class TcpEndpointContextMatcher extends KeySetEndpointContextMatcher {
    private static final String[] KEYS = {"CONNECTION_ID"};

    public TcpEndpointContextMatcher() {
        super("tcp context", KEYS);
    }
}
