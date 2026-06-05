package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.HelloExtension;
import org.eclipse.californium.scandium.util.ServerNames;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class ServerNameExtension extends HelloExtension {
    private ServerNames serverNames;

    private ServerNameExtension(ServerNames serverNames) {
        this();
        if (serverNames != null) {
            this.serverNames = serverNames;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("server names must not be null");
            throw null;
        }
    }

    public static ServerNameExtension emptyServerNameIndication() {
        return new ServerNameExtension();
    }

    public static ServerNameExtension forServerNames(ServerNames serverNames) {
        return new ServerNameExtension(serverNames);
    }

    public static ServerNameExtension fromExtensionDataReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) throws HandshakeException {
        if (datagramReader == null || !datagramReader.bytesAvailable()) {
            return emptyServerNameIndication();
        }
        ServerNames serverNamesNewInstance = ServerNames.newInstance();
        try {
            serverNamesNewInstance.decode(datagramReader);
            return new ServerNameExtension(serverNamesNewInstance);
        } catch (IllegalArgumentException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                throw new HandshakeException("Server Name Indication extension contains unknown name_type", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, inetSocketAddress));
            }
            throw new HandshakeException("malformed Server Name Indication extension", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.DECODE_ERROR, inetSocketAddress));
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public void addExtensionData(DatagramWriter datagramWriter) {
        ServerNames serverNames = this.serverNames;
        if (serverNames == null) {
            datagramWriter.write(0, 16);
        } else {
            datagramWriter.write(serverNames.getEncodedLength() + 2, 16);
            this.serverNames.encode(datagramWriter);
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public int getLength() {
        ServerNames serverNames = this.serverNames;
        if (serverNames != null) {
            return serverNames.getEncodedLength() + 6;
        }
        return 4;
    }

    public ServerNames getServerNames() {
        return this.serverNames;
    }

    private ServerNameExtension() {
        super(HelloExtension.ExtensionType.SERVER_NAME);
    }
}
