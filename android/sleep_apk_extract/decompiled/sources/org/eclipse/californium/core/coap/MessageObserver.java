package org.eclipse.californium.core.coap;

import org.eclipse.californium.elements.EndpointContext;

/* JADX INFO: loaded from: classes5.dex */
public interface MessageObserver {
    void onAcknowledgement();

    void onCancel();

    void onComplete();

    void onConnecting();

    void onContextEstablished(EndpointContext endpointContext);

    void onDtlsRetransmission(int i);

    void onReadyToSend();

    void onReject();

    void onResponse(Response response);

    void onRetransmission();

    void onSendError(Throwable th);

    void onSent(boolean z);

    void onTimeout();
}
