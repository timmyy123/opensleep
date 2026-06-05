package org.eclipse.californium.core.network;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.server.MessageDeliverer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class EndpointManager {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) EndpointManager.class);
    private static final EndpointManager manager = new EndpointManager();
    private final Map<String, Endpoint> endpoints = new ConcurrentHashMap();

    public static class ClientMessageDeliverer implements MessageDeliverer {
        @Override // org.eclipse.californium.core.server.MessageDeliverer
        public void deliverRequest(Exchange exchange) {
            EndpointManager.LOGGER.error("Default endpoint without CoapServer has received a request.");
            exchange.sendReject();
        }

        @Override // org.eclipse.californium.core.server.MessageDeliverer
        public void deliverResponse(Exchange exchange, Response response) {
            if (exchange == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("no CoAP exchange!");
                return;
            }
            if (exchange.getRequest() == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("no CoAP request!");
            } else if (response != null) {
                exchange.getRequest().setResponse(response);
            } else {
                Types$$ExternalSyntheticBUOutline0.m$1("no CoAP response!");
            }
        }
    }

    public static EndpointManager getEndpointManager() {
        return manager;
    }

    public synchronized Endpoint getDefaultEndpoint(String str) {
        Endpoint endpointBuild;
        if (str == null) {
            str = "coap";
        }
        try {
            if (!CoAP.isSupportedScheme(str)) {
                throw new IllegalArgumentException("URI scheme " + str + " not supported!");
            }
            String lowerCase = str.toLowerCase();
            endpointBuild = this.endpoints.get(lowerCase);
            if (endpointBuild == null) {
                if ("coaps".equalsIgnoreCase(lowerCase)) {
                    throw new IllegalStateException("URI scheme " + lowerCase + " requires a previous set connector!");
                }
                if ("coap+tcp".equalsIgnoreCase(lowerCase)) {
                    throw new IllegalStateException("URI scheme " + lowerCase + " requires a previous set connector!");
                }
                if ("coaps+tcp".equalsIgnoreCase(lowerCase)) {
                    throw new IllegalStateException("URI scheme " + lowerCase + " requires a previous set connector!");
                }
                endpointBuild = new CoapEndpoint.Builder().build();
                try {
                    endpointBuild.start();
                    LOGGER.info("created implicit endpoint {} for {}", endpointBuild.getUri(), lowerCase);
                } catch (IOException e) {
                    LOGGER.error("could not create {} endpoint", lowerCase, e);
                }
                this.endpoints.put(lowerCase, endpointBuild);
            }
        } catch (Throwable th) {
            throw th;
        }
        return endpointBuild;
    }
}
