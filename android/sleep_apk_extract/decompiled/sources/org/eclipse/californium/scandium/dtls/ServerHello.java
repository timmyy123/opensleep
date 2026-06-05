package org.eclipse.californium.scandium.dtls;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.HelloExtension;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class ServerHello extends HandshakeMessage {
    private final CipherSuite cipherSuite;
    private final CompressionMethod compressionMethod;
    private final HelloExtensions extensions;
    private final Random random;
    private final ProtocolVersion serverVersion;
    private final SessionId sessionId;

    public ServerHello(ProtocolVersion protocolVersion, Random random, SessionId sessionId, CipherSuite cipherSuite, CompressionMethod compressionMethod, HelloExtensions helloExtensions, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        if (protocolVersion == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Negotiated protocol version must not be null");
            throw null;
        }
        if (random == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("ServerHello message must contain a random");
            throw null;
        }
        if (sessionId == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("ServerHello must be associated with a session ID");
            throw null;
        }
        if (cipherSuite == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Negotiated cipher suite must not be null");
            throw null;
        }
        if (compressionMethod == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Negotiated compression method must not be null");
            throw null;
        }
        this.serverVersion = protocolVersion;
        this.random = random;
        this.sessionId = sessionId;
        this.cipherSuite = cipherSuite;
        this.compressionMethod = compressionMethod;
        this.extensions = helloExtensions;
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        ProtocolVersion protocolVersionValueOf = ProtocolVersion.valueOf(datagramReader.read(8), datagramReader.read(8));
        Random random = new Random(datagramReader.readBytes(32));
        SessionId sessionId = new SessionId(datagramReader.readBytes(datagramReader.read(8)));
        int i = datagramReader.read(16);
        CipherSuite typeByCode = CipherSuite.getTypeByCode(i);
        if (typeByCode == null) {
            throw new HandshakeException(FileInsert$$ExternalSyntheticOutline0.m("Server selected unknown cipher suite [", Integer.toHexString(i), "]"), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, inetSocketAddress));
        }
        if (typeByCode != CipherSuite.TLS_NULL_WITH_NULL_NULL) {
            return new ServerHello(protocolVersionValueOf, random, sessionId, typeByCode, CompressionMethod.getMethodByCode(datagramReader.read(8)), datagramReader.bytesAvailable() ? HelloExtensions.fromReader(datagramReader, inetSocketAddress) : null, inetSocketAddress);
        }
        throw new HandshakeException("Server tries to negotiate NULL cipher suite", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, inetSocketAddress));
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.serverVersion.getMajor(), 8);
        datagramWriter.write(this.serverVersion.getMinor(), 8);
        datagramWriter.writeBytes(this.random.getBytes());
        datagramWriter.write(this.sessionId.length(), 8);
        datagramWriter.writeBytes(this.sessionId.getBytes());
        datagramWriter.write(this.cipherSuite.getCode(), 16);
        datagramWriter.write(this.compressionMethod.getCode(), 8);
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            datagramWriter.writeBytes(helloExtensions.toByteArray());
        }
        return datagramWriter.toByteArray();
    }

    public CertificateType getCertificateType(HelloExtension.ExtensionType extensionType) {
        CertificateTypeExtension certificateTypeExtension;
        CertificateType certificateType = CertificateType.X_509;
        HelloExtensions helloExtensions = this.extensions;
        return (helloExtensions == null || (certificateTypeExtension = (CertificateTypeExtension) helloExtensions.getExtension(extensionType)) == null || certificateTypeExtension.getCertificateTypes().isEmpty()) ? certificateType : certificateTypeExtension.getCertificateTypes().get(0);
    }

    public CipherSuite getCipherSuite() {
        return this.cipherSuite;
    }

    public CertificateType getClientCertificateType() {
        return getCertificateType(HelloExtension.ExtensionType.CLIENT_CERT_TYPE);
    }

    public CompressionMethod getCompressionMethod() {
        return this.compressionMethod;
    }

    public ConnectionIdExtension getConnectionIdExtension() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (ConnectionIdExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.CONNECTION_ID);
        }
        return null;
    }

    public HelloExtensions getExtensions() {
        return this.extensions;
    }

    public MaxFragmentLengthExtension getMaxFragmentLength() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (MaxFragmentLengthExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.MAX_FRAGMENT_LENGTH);
        }
        return null;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        HelloExtensions helloExtensions = this.extensions;
        return this.sessionId.length() + 38 + ((helloExtensions == null || helloExtensions.isEmpty()) ? 0 : this.extensions.getLength() + 2);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return HandshakeType.SERVER_HELLO;
    }

    public Random getRandom() {
        return this.random;
    }

    public RecordSizeLimitExtension getRecordSizeLimit() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (RecordSizeLimitExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.RECORD_SIZE_LIMIT);
        }
        return null;
    }

    public CertificateType getServerCertificateType() {
        return getCertificateType(HelloExtension.ExtensionType.SERVER_CERT_TYPE);
    }

    public ProtocolVersion getServerVersion() {
        return this.serverVersion;
    }

    public SessionId getSessionId() {
        return this.sessionId;
    }

    public SupportedPointFormatsExtension getSupportedPointFormatsExtension() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (SupportedPointFormatsExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.EC_POINT_FORMATS);
        }
        return null;
    }

    public boolean hasServerNameExtension() {
        HelloExtensions helloExtensions = this.extensions;
        return (helloExtensions == null || helloExtensions.getExtension(HelloExtension.ExtensionType.SERVER_NAME) == null) ? false : true;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\t\tServer Version: ");
        sb.append(this.serverVersion.getMajor());
        sb.append(", ");
        sb.append(this.serverVersion.getMinor());
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\tRandom:");
        sb.append(this.random);
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\tSession ID Length: ");
        sb.append(this.sessionId.length());
        if (this.sessionId.length() > 0) {
            sb.append(StringUtil.lineSeparator());
            sb.append("\t\tSession ID: ");
            sb.append(this.sessionId);
        }
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\tCipher Suite: ");
        sb.append(this.cipherSuite);
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\tCompression Method: ");
        sb.append(this.compressionMethod);
        if (this.extensions != null) {
            sb.append(StringUtil.lineSeparator());
            sb.append(this.extensions);
        }
        return sb.toString();
    }
}
