package org.eclipse.californium.core.network;

import java.net.InetSocketAddress;
import java.net.URI;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.config.NetworkConfig;

/* JADX INFO: loaded from: classes5.dex */
public interface Endpoint {
    InetSocketAddress getAddress();

    NetworkConfig getConfig();

    URI getUri();

    boolean isStarted();

    void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage);

    void sendRequest(Request request);

    void start();
}
