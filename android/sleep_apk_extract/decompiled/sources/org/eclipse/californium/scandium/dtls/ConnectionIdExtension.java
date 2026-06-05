package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.HelloExtension;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class ConnectionIdExtension extends HelloExtension {
    private ConnectionId id;

    private ConnectionIdExtension(ConnectionId connectionId) {
        super(HelloExtension.ExtensionType.CONNECTION_ID);
        this.id = connectionId;
    }

    public static ConnectionIdExtension fromConnectionId(ConnectionId connectionId) {
        if (connectionId != null) {
            return new ConnectionIdExtension(connectionId);
        }
        Types$$ExternalSyntheticBUOutline0.m$1("cid must not be null!");
        return null;
    }

    public static ConnectionIdExtension fromExtensionDataReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) throws HandshakeException {
        if (datagramReader == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("cid must not be null!");
            return null;
        }
        int iBitsLeft = datagramReader.bitsLeft() / 8;
        if (iBitsLeft == 0) {
            throw new HandshakeException("Connection id length must be provided!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, inetSocketAddress));
        }
        if (iBitsLeft > 256) {
            StringBuilder sb = new StringBuilder("Connection id length too large! 255 max, but has ");
            sb.append(iBitsLeft - 1);
            throw new HandshakeException(sb.toString(), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, inetSocketAddress));
        }
        int i = datagramReader.read(8);
        int i2 = iBitsLeft - 1;
        if (i == i2) {
            return i == 0 ? new ConnectionIdExtension(ConnectionId.EMPTY) : new ConnectionIdExtension(new ConnectionId(datagramReader.readBytes(i)));
        }
        throw new HandshakeException("Connection id length " + i + " doesn't match " + i2 + "!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, inetSocketAddress));
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public void addExtensionData(DatagramWriter datagramWriter) {
        int length = this.id.length();
        datagramWriter.write(length + 1, 16);
        datagramWriter.write(length, 8);
        datagramWriter.writeBytes(this.id.getBytes());
    }

    public ConnectionId getConnectionId() {
        return this.id;
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public int getLength() {
        return this.id.length() + 5;
    }
}
