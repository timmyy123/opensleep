package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public interface DTLSMessage {
    ContentType getContentType();

    InetSocketAddress getPeer();

    int size();

    byte[] toByteArray();
}
