package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessage implements DTLSMessage {
    private final InetSocketAddress peerAddress;

    public AbstractMessage(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress != null) {
            this.peerAddress = inetSocketAddress;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("Peer address must not be null");
            throw null;
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public final InetSocketAddress getPeer() {
        return this.peerAddress;
    }
}
