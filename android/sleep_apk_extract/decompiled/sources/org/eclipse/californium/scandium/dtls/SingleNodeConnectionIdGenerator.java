package org.eclipse.californium.scandium.dtls;

import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.scandium.dtls.cipher.RandomManager;

/* JADX INFO: loaded from: classes5.dex */
public class SingleNodeConnectionIdGenerator implements ConnectionIdGenerator {
    private final int connectionIdLength;

    public SingleNodeConnectionIdGenerator(int i) {
        if (i >= 0) {
            this.connectionIdLength = i;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2("cid length must not be less than 0 bytes!");
            throw null;
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ConnectionIdGenerator
    public ConnectionId createConnectionId() {
        if (!useConnectionId()) {
            return null;
        }
        byte[] bArr = new byte[this.connectionIdLength];
        RandomManager.currentRandom().nextBytes(bArr);
        return new ConnectionId(bArr);
    }

    @Override // org.eclipse.californium.scandium.dtls.ConnectionIdGenerator
    public ConnectionId read(DatagramReader datagramReader) {
        if (useConnectionId()) {
            return new ConnectionId(datagramReader.readBytes(this.connectionIdLength));
        }
        return null;
    }

    @Override // org.eclipse.californium.scandium.dtls.ConnectionIdGenerator
    public boolean useConnectionId() {
        return this.connectionIdLength > 0;
    }
}
