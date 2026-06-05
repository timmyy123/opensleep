package org.eclipse.californium.core.network;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface CoapEndpointHealth {
    void dump(String str);

    boolean isEnabled();

    void receivedReject();

    void receivedRequest(boolean z);

    void receivedResponse(boolean z);

    void sendError();

    void sentReject();

    void sentRequest(boolean z);

    void sentResponse(boolean z);
}
