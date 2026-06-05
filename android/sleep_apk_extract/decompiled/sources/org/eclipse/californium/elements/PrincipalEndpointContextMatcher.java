package org.eclipse.californium.elements;

import java.security.Principal;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class PrincipalEndpointContextMatcher implements EndpointContextMatcher {
    private final boolean usePrincipalAsIdentity;

    public PrincipalEndpointContextMatcher(boolean z) {
        this.usePrincipalAsIdentity = z;
    }

    private final boolean internalMatch(EndpointContext endpointContext, EndpointContext endpointContext2) {
        if (endpointContext.getPeerIdentity() != null && (endpointContext2.getPeerIdentity() == null || !matchPrincipals(endpointContext.getPeerIdentity(), endpointContext2.getPeerIdentity()))) {
            return false;
        }
        String str = endpointContext.get("DTLS_CIPHER");
        return str == null || str.equals(endpointContext2.get("DTLS_CIPHER"));
    }

    @Override // org.eclipse.californium.elements.EndpointIdentityResolver
    public Object getEndpointIdentity(EndpointContext endpointContext) {
        if (!this.usePrincipalAsIdentity) {
            return endpointContext.getPeerAddress();
        }
        Principal peerIdentity = endpointContext.getPeerIdentity();
        if (peerIdentity != null) {
            return peerIdentity;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Principal identity missing in provided endpoint context!");
        return null;
    }

    @Override // org.eclipse.californium.elements.EndpointContextMatcher
    public String getName() {
        return "principal correlation";
    }

    @Override // org.eclipse.californium.elements.EndpointContextMatcher
    public boolean isResponseRelatedToRequest(EndpointContext endpointContext, EndpointContext endpointContext2) {
        return internalMatch(endpointContext, endpointContext2);
    }

    @Override // org.eclipse.californium.elements.EndpointContextMatcher
    public boolean isToBeSent(EndpointContext endpointContext, EndpointContext endpointContext2) {
        if (endpointContext2 == null) {
            return true;
        }
        return internalMatch(endpointContext, endpointContext2);
    }

    public boolean matchPrincipals(Principal principal, Principal principal2) {
        return principal.equals(principal2);
    }

    @Override // org.eclipse.californium.elements.EndpointContextMatcher
    public String toRelevantState(EndpointContext endpointContext) {
        if (endpointContext == null) {
            return "n.a.";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(endpointContext.getPeerIdentity());
        String str = endpointContext.get("DTLS_CIPHER");
        if (str != null) {
            sb.append(",");
            sb.append(str);
        }
        sb.append("]");
        return sb.toString();
    }

    public PrincipalEndpointContextMatcher() {
        this(false);
    }
}
