package org.eclipse.californium.elements;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class RawData {
    public final byte[] bytes;
    private final MessageCallback callback;
    private final boolean multicast;
    private final EndpointContext peerEndpointContext;
    private final long receiveNanoTimestamp;

    private RawData(byte[] bArr, EndpointContext endpointContext, MessageCallback messageCallback, boolean z, long j) {
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Data must not be null");
            throw null;
        }
        if (endpointContext == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Peer's EndpointContext must not be null");
            throw null;
        }
        this.bytes = bArr;
        this.peerEndpointContext = endpointContext;
        this.callback = messageCallback;
        this.multicast = z;
        this.receiveNanoTimestamp = j;
    }

    public static RawData inbound(byte[] bArr, EndpointContext endpointContext, boolean z, long j) {
        return new RawData(bArr, endpointContext, null, z, j);
    }

    public static RawData outbound(byte[] bArr, EndpointContext endpointContext, MessageCallback messageCallback, boolean z) {
        return new RawData(bArr, endpointContext, messageCallback, z, 0L);
    }

    public InetAddress getAddress() {
        return this.peerEndpointContext.getPeerAddress().getAddress();
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public EndpointContext getEndpointContext() {
        return this.peerEndpointContext;
    }

    public InetSocketAddress getInetSocketAddress() {
        return this.peerEndpointContext.getPeerAddress();
    }

    public int getPort() {
        return this.peerEndpointContext.getPeerAddress().getPort();
    }

    public long getReceiveNanoTimestamp() {
        return this.receiveNanoTimestamp;
    }

    public int getSize() {
        return this.bytes.length;
    }

    public boolean isMulticast() {
        return this.multicast;
    }

    public void onConnecting() {
        MessageCallback messageCallback = this.callback;
        if (messageCallback != null) {
            messageCallback.onConnecting();
        }
    }

    public void onContextEstablished(EndpointContext endpointContext) {
        MessageCallback messageCallback = this.callback;
        if (messageCallback != null) {
            messageCallback.onContextEstablished(endpointContext);
        }
    }

    public void onDtlsRetransmission(int i) {
        MessageCallback messageCallback = this.callback;
        if (messageCallback != null) {
            messageCallback.onDtlsRetransmission(i);
        }
    }

    public void onError(Throwable th) {
        if (this.callback != null) {
            if (th == null) {
                th = new UnknownError();
            }
            this.callback.onError(th);
        }
    }

    public void onSent() {
        MessageCallback messageCallback = this.callback;
        if (messageCallback != null) {
            messageCallback.onSent();
        }
    }
}
