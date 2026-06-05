package org.eclipse.californium.core.coap;

import org.eclipse.californium.elements.EndpointContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MessageObserverAdapter implements MessageObserver2 {
    public void failed() {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onAcknowledgement() {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onCancel() {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onComplete() {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onConnecting() {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onContextEstablished(EndpointContext endpointContext) {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onDtlsRetransmission(int i) {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onReadyToSend() {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onReject() {
        failed();
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onResponse(Response response) {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver2
    public void onResponseHandlingError(Throwable th) {
        failed();
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onRetransmission() {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onSendError(Throwable th) {
        failed();
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onSent(boolean z) {
    }

    @Override // org.eclipse.californium.core.coap.MessageObserver
    public void onTimeout() {
        failed();
    }
}
