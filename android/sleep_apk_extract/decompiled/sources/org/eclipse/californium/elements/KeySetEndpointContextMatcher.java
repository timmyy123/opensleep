package org.eclipse.californium.elements;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.eclipse.californium.elements.util.StringUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class KeySetEndpointContextMatcher implements EndpointContextMatcher {
    private final boolean compareHostname;
    private final Set<String> keys;
    private final String name;

    public KeySetEndpointContextMatcher(String str, String[] strArr, boolean z) {
        this.name = str;
        this.keys = createKeySet(strArr);
        this.compareHostname = z;
    }

    public static Set<String> createKeySet(String... strArr) {
        return Collections.unmodifiableSet(new CopyOnWriteArraySet(Arrays.asList(strArr)));
    }

    private final boolean internalMatch(EndpointContext endpointContext, EndpointContext endpointContext2) {
        if (endpointContext.hasCriticalEntries()) {
            return EndpointContextUtil.match(getName(), this.keys, endpointContext, endpointContext2);
        }
        return true;
    }

    public static final boolean isSameVirtualHost(EndpointContext endpointContext, EndpointContext endpointContext2) {
        String virtualHost;
        String virtualHost2;
        if (endpointContext != null) {
            return endpointContext2 == null || (virtualHost = endpointContext.getVirtualHost()) == (virtualHost2 = endpointContext2.getVirtualHost()) || (virtualHost != null && virtualHost.equals(virtualHost2));
        }
        Types$$ExternalSyntheticBUOutline0.m$1("first context must not be null");
        return false;
    }

    @Override // org.eclipse.californium.elements.EndpointIdentityResolver
    public Object getEndpointIdentity(EndpointContext endpointContext) {
        InetSocketAddress peerAddress = endpointContext.getPeerAddress();
        if (!peerAddress.isUnresolved()) {
            return peerAddress;
        }
        throw new IllegalArgumentException(StringUtil.toDisplayString(peerAddress) + " must be resolved!");
    }

    @Override // org.eclipse.californium.elements.EndpointContextMatcher
    public String getName() {
        return this.name;
    }

    @Override // org.eclipse.californium.elements.EndpointContextMatcher
    public boolean isResponseRelatedToRequest(EndpointContext endpointContext, EndpointContext endpointContext2) {
        return (this.compareHostname ? isSameVirtualHost(endpointContext, endpointContext2) : true) && internalMatch(endpointContext, endpointContext2);
    }

    @Override // org.eclipse.californium.elements.EndpointContextMatcher
    public boolean isToBeSent(EndpointContext endpointContext, EndpointContext endpointContext2) {
        if (endpointContext2 == null) {
            return !endpointContext.hasCriticalEntries();
        }
        return (this.compareHostname ? isSameVirtualHost(endpointContext, endpointContext2) : true) && internalMatch(endpointContext, endpointContext2);
    }

    @Override // org.eclipse.californium.elements.EndpointContextMatcher
    public String toRelevantState(EndpointContext endpointContext) {
        return endpointContext == null ? "n.a." : endpointContext.toString();
    }

    public KeySetEndpointContextMatcher(String str, String[] strArr) {
        this(str, strArr, false);
    }
}
