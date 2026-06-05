package org.eclipse.californium.elements;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.net.InetSocketAddress;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import org.eclipse.californium.elements.util.StringUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class AddressEndpointContext implements EndpointContext {
    private final InetSocketAddress peerAddress;
    private final Principal peerIdentity;
    private final String virtualHost;

    public AddressEndpointContext(InetSocketAddress inetSocketAddress, String str, Principal principal) {
        if (inetSocketAddress == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("missing peer socket address, must not be null!");
            throw null;
        }
        this.peerAddress = inetSocketAddress;
        this.virtualHost = str != null ? str.toLowerCase() : null;
        this.peerIdentity = principal;
    }

    @Override // org.eclipse.californium.elements.EndpointContext
    public Map<String, String> entries() {
        return Collections.EMPTY_MAP;
    }

    @Override // org.eclipse.californium.elements.EndpointContext
    public String get(String str) {
        return null;
    }

    @Override // org.eclipse.californium.elements.EndpointContext
    public final InetSocketAddress getPeerAddress() {
        return this.peerAddress;
    }

    public final String getPeerAddressAsString() {
        return StringUtil.toDisplayString(this.peerAddress);
    }

    @Override // org.eclipse.californium.elements.EndpointContext
    public final Principal getPeerIdentity() {
        return this.peerIdentity;
    }

    @Override // org.eclipse.californium.elements.EndpointContext
    public final String getVirtualHost() {
        return this.virtualHost;
    }

    @Override // org.eclipse.californium.elements.EndpointContext
    public boolean hasCriticalEntries() {
        return false;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m("IP(", getPeerAddressAsString(), ")");
    }
}
