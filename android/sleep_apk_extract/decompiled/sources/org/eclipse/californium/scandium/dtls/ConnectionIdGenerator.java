package org.eclipse.californium.scandium.dtls;

import org.eclipse.californium.elements.util.DatagramReader;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnectionIdGenerator {
    ConnectionId createConnectionId();

    ConnectionId read(DatagramReader datagramReader);

    boolean useConnectionId();
}
