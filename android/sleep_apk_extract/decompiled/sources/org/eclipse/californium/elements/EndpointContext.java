package org.eclipse.californium.elements;

import java.net.InetSocketAddress;
import java.security.Principal;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface EndpointContext {
    Map<String, String> entries();

    String get(String str);

    InetSocketAddress getPeerAddress();

    Principal getPeerIdentity();

    String getVirtualHost();

    boolean hasCriticalEntries();
}
