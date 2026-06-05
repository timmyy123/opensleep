package org.eclipse.californium.elements;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.NetworkInterfacesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class UdpEndpointContextMatcher extends KeySetEndpointContextMatcher {
    private final boolean checkAddress;
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) UdpEndpointContextMatcher.class);
    private static final String[] KEYS = {"PLAIN"};

    public UdpEndpointContextMatcher(boolean z) {
        super("udp plain", KEYS);
        this.checkAddress = z;
    }

    @Override // org.eclipse.californium.elements.KeySetEndpointContextMatcher, org.eclipse.californium.elements.EndpointContextMatcher
    public boolean isResponseRelatedToRequest(EndpointContext endpointContext, EndpointContext endpointContext2) {
        if (this.checkAddress) {
            InetSocketAddress peerAddress = endpointContext.getPeerAddress();
            InetSocketAddress peerAddress2 = endpointContext2.getPeerAddress();
            if (!peerAddress.equals(peerAddress2) && !NetworkInterfacesUtil.isMultiAddress(peerAddress.getAddress())) {
                LOGGER.info("request {}:{} doesn't match {}:{}!", peerAddress.getAddress().getHostAddress(), Integer.valueOf(peerAddress.getPort()), peerAddress2.getAddress().getHostAddress(), Integer.valueOf(peerAddress2.getPort()));
                return false;
            }
        }
        return super.isResponseRelatedToRequest(endpointContext, endpointContext2);
    }
}
