package org.eclipse.californium.elements;

/* JADX INFO: loaded from: classes5.dex */
public interface MessageCallback {
    void onConnecting();

    void onContextEstablished(EndpointContext endpointContext);

    void onDtlsRetransmission(int i);

    void onError(Throwable th);

    void onSent();
}
