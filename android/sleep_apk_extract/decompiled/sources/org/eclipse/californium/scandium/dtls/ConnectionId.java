package org.eclipse.californium.scandium.dtls;

import org.eclipse.californium.elements.util.Bytes;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectionId extends Bytes {
    public static final ConnectionId EMPTY = new ConnectionId(Bytes.EMPTY);

    public ConnectionId(byte[] bArr) {
        super(bArr);
    }

    public String toString() {
        return "CID=" + getAsString();
    }
}
