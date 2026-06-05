package org.eclipse.californium.scandium.dtls;

/* JADX INFO: loaded from: classes5.dex */
public interface SessionListener {
    void handshakeCompleted(Handshaker handshaker);

    void handshakeFailed(Handshaker handshaker, Throwable th);

    void handshakeFlightRetransmitted(Handshaker handshaker, int i);

    void handshakeStarted(Handshaker handshaker);

    void sessionEstablished(Handshaker handshaker, DTLSSession dTLSSession);
}
