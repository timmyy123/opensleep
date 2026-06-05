package org.eclipse.californium.elements;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.net.InetSocketAddress;
import java.security.Principal;
import org.eclipse.californium.elements.util.StringUtil;

/* JADX INFO: loaded from: classes5.dex */
public class DtlsEndpointContext extends MapBasedEndpointContext {
    public DtlsEndpointContext(InetSocketAddress inetSocketAddress, String str, Principal principal, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(inetSocketAddress, str, principal, "DTLS_SESSION_ID", str2, "DTLS_CIPHER", str4, "DTLS_EPOCH", str3, "DTLS_HANDSHAKE_TIMESTAMP", str5, "DTLS_WRITE_CONNECTION_ID", str6, "DTLS_READ_CONNECTION_ID", str7, "*DTLS_VIA_ROUTER", str8);
    }

    public final String getSessionId() {
        return get("DTLS_SESSION_ID");
    }

    @Override // org.eclipse.californium.elements.MapBasedEndpointContext, org.eclipse.californium.elements.AddressEndpointContext
    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m("DTLS(", getPeerAddressAsString(), ",ID:", StringUtil.trunc(getSessionId(), 10), ")");
    }

    public DtlsEndpointContext(InetSocketAddress inetSocketAddress, String str, Principal principal, String str2, String str3, String str4, String str5) {
        super(inetSocketAddress, str, principal, "DTLS_SESSION_ID", str2, "DTLS_CIPHER", str4, "DTLS_EPOCH", str3, "DTLS_HANDSHAKE_TIMESTAMP", str5);
    }
}
