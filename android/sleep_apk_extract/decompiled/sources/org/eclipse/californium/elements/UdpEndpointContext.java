package org.eclipse.californium.elements;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public class UdpEndpointContext extends MapBasedEndpointContext {
    public UdpEndpointContext(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress, null, "PLAIN", "");
    }

    @Override // org.eclipse.californium.elements.MapBasedEndpointContext, org.eclipse.californium.elements.AddressEndpointContext
    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m("UDP(", getPeerAddressAsString(), ")");
    }
}
