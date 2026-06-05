package org.eclipse.californium.core.network;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.Connector;
import org.eclipse.californium.elements.EndpointContextMatcher;
import org.eclipse.californium.elements.PrincipalEndpointContextMatcher;
import org.eclipse.californium.elements.RelaxedDtlsEndpointContextMatcher;
import org.eclipse.californium.elements.StrictDtlsEndpointContextMatcher;
import org.eclipse.californium.elements.TcpEndpointContextMatcher;
import org.eclipse.californium.elements.TlsEndpointContextMatcher;
import org.eclipse.californium.elements.UdpEndpointContextMatcher;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EndpointContextMatcherFactory {

    /* JADX INFO: renamed from: org.eclipse.californium.core.network.EndpointContextMatcherFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$core$network$EndpointContextMatcherFactory$MatcherMode;

        static {
            int[] iArr = new int[MatcherMode.values().length];
            $SwitchMap$org$eclipse$californium$core$network$EndpointContextMatcherFactory$MatcherMode = iArr;
            try {
                iArr[MatcherMode.RELAXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$core$network$EndpointContextMatcherFactory$MatcherMode[MatcherMode.PRINCIPAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$eclipse$californium$core$network$EndpointContextMatcherFactory$MatcherMode[MatcherMode.STRICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum MatcherMode {
        STRICT,
        RELAXED,
        PRINCIPAL
    }

    public static EndpointContextMatcher create(Connector connector, NetworkConfig networkConfig) {
        String protocol2;
        if (connector != null) {
            protocol2 = connector.getProtocol();
            if ("TCP".equalsIgnoreCase(protocol2)) {
                return new TcpEndpointContextMatcher();
            }
            if (SSLSocketFactoryFactory.DEFAULT_PROTOCOL.equalsIgnoreCase(protocol2)) {
                return new TlsEndpointContextMatcher();
            }
        } else {
            protocol2 = null;
        }
        String string = "???";
        MatcherMode matcherMode = MatcherMode.STRICT;
        try {
            string = networkConfig.getString("RESPONSE_MATCHING");
            int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$core$network$EndpointContextMatcherFactory$MatcherMode[MatcherMode.valueOf(string).ordinal()];
            return i != 1 ? i != 2 ? "UDP".equalsIgnoreCase(protocol2) ? new UdpEndpointContextMatcher(true) : new StrictDtlsEndpointContextMatcher() : "UDP".equalsIgnoreCase(protocol2) ? new UdpEndpointContextMatcher(false) : new PrincipalEndpointContextMatcher() : "UDP".equalsIgnoreCase(protocol2) ? new UdpEndpointContextMatcher(false) : new RelaxedDtlsEndpointContextMatcher();
        } catch (IllegalArgumentException unused) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Response matching mode '", string, "' not supported!"));
            return null;
        } catch (NullPointerException unused2) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Response matching mode not provided/configured!");
            return null;
        }
    }
}
