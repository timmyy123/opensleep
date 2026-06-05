package org.eclipse.californium.elements;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public interface Connector {
    InetSocketAddress getAddress();

    String getProtocol();

    void send(RawData rawData);

    void setEndpointContextMatcher(EndpointContextMatcher endpointContextMatcher);

    void setRawDataReceiver(RawDataChannel rawDataChannel);

    void start();

    void stop();
}
