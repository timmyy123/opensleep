package org.eclipse.californium.scandium.dtls;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.HelloExtension;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class ClientHello extends HandshakeMessage {
    private ProtocolVersion clientVersion;
    private List<CompressionMethod> compressionMethods;
    private byte[] cookie;
    private HelloExtensions extensions;
    private Random random;
    private SessionId sessionId;
    private List<CipherSuite> supportedCipherSuites;

    private ClientHello(ProtocolVersion protocolVersion, SessionId sessionId, List<CipherSuite> list, List<SignatureAndHashAlgorithm> list2, List<CertificateType> list3, List<CertificateType> list4, List<XECDHECryptography.SupportedGroup> list5, InetSocketAddress inetSocketAddress) {
        this(inetSocketAddress);
        this.clientVersion = protocolVersion;
        this.random = new Random();
        this.cookie = Bytes.EMPTY;
        if (sessionId != null) {
            this.sessionId = sessionId;
        } else {
            this.sessionId = SessionId.emptySessionId();
        }
        if (list != null) {
            this.supportedCipherSuites.addAll(list);
        }
        if (CipherSuite.containsEccBasedCipherSuite(list)) {
            this.extensions.addExtension(new SupportedEllipticCurvesExtension(list5));
            this.extensions.addExtension(SupportedPointFormatsExtension.DEFAULT_POINT_FORMATS_EXTENSION);
        }
        if (!list2.isEmpty()) {
            if (useCertificateTypeRawPublicKeyOnly(list3) && useCertificateTypeRawPublicKeyOnly(list4)) {
                list2 = SignatureAndHashAlgorithm.getEcdsaCompatibleSignatureAlgorithms(list2);
            }
            this.extensions.addExtension(new SignatureAlgorithmsExtension(list2));
        }
        if (CipherSuite.containsCipherSuiteRequiringCertExchange(list)) {
            if (useCertificateTypeExtension(list3)) {
                this.extensions.addExtension(new ClientCertificateTypeExtension(list3));
            }
            if (useCertificateTypeExtension(list4)) {
                this.extensions.addExtension(new ServerCertificateTypeExtension(list4));
            }
        }
    }

    public static ClientHello fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        ClientHello clientHello = new ClientHello(inetSocketAddress);
        clientHello.clientVersion = ProtocolVersion.valueOf(datagramReader.read(8), datagramReader.read(8));
        clientHello.random = new Random(datagramReader.readBytes(32));
        clientHello.sessionId = new SessionId(datagramReader.readBytes(datagramReader.read(8)));
        clientHello.cookie = datagramReader.readBytes(datagramReader.read(8));
        clientHello.supportedCipherSuites = CipherSuite.listFromReader(datagramReader.createRangeReader(datagramReader.read(16)));
        clientHello.compressionMethods = CompressionMethod.listFromReader(datagramReader.createRangeReader(datagramReader.read(8)));
        if (datagramReader.bytesAvailable()) {
            clientHello.extensions = HelloExtensions.fromReader(datagramReader, inetSocketAddress);
        }
        return clientHello;
    }

    private boolean useCertificateTypeExtension(List<CertificateType> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return list.size() > 1 || !list.contains(CertificateType.X_509);
    }

    private boolean useCertificateTypeRawPublicKeyOnly(List<CertificateType> list) {
        if (list == null || list.size() != 1) {
            return false;
        }
        return list.contains(CertificateType.RAW_PUBLIC_KEY);
    }

    public void addCompressionMethod(CompressionMethod compressionMethod) {
        if (this.compressionMethods == null) {
            this.compressionMethods = new ArrayList();
        }
        this.compressionMethods.add(compressionMethod);
    }

    public void addExtension(HelloExtension helloExtension) {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            helloExtensions.addExtension(helloExtension);
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.clientVersion.getMajor(), 8);
        datagramWriter.write(this.clientVersion.getMinor(), 8);
        datagramWriter.writeBytes(this.random.getBytes());
        datagramWriter.write(this.sessionId.length(), 8);
        datagramWriter.writeBytes(this.sessionId.getBytes());
        datagramWriter.write(this.cookie.length, 8);
        datagramWriter.writeBytes(this.cookie);
        datagramWriter.write(this.supportedCipherSuites.size() * 2, 16);
        datagramWriter.writeBytes(CipherSuite.listToByteArray(this.supportedCipherSuites));
        datagramWriter.write(this.compressionMethods.size(), 8);
        datagramWriter.writeBytes(CompressionMethod.listToByteArray(this.compressionMethods));
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            datagramWriter.writeBytes(helloExtensions.toByteArray());
        }
        return datagramWriter.toByteArray();
    }

    public List<CipherSuite> getCipherSuites() {
        return Collections.unmodifiableList(this.supportedCipherSuites);
    }

    public ClientCertificateTypeExtension getClientCertificateTypeExtension() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (ClientCertificateTypeExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.CLIENT_CERT_TYPE);
        }
        return null;
    }

    public ProtocolVersion getClientVersion() {
        return this.clientVersion;
    }

    public List<CompressionMethod> getCompressionMethods() {
        return Collections.unmodifiableList(this.compressionMethods);
    }

    public ConnectionIdExtension getConnectionIdExtension() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (ConnectionIdExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.CONNECTION_ID);
        }
        return null;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public HelloExtensions getExtensions() {
        return this.extensions;
    }

    public MaxFragmentLengthExtension getMaxFragmentLengthExtension() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (MaxFragmentLengthExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.MAX_FRAGMENT_LENGTH);
        }
        return null;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        HelloExtensions helloExtensions = this.extensions;
        return this.compressionMethods.size() + Fragment$$ExternalSyntheticOutline1.m(this.supportedCipherSuites, 2, this.sessionId.length() + 39 + this.cookie.length) + ((helloExtensions == null || helloExtensions.isEmpty()) ? 0 : this.extensions.getLength() + 2);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return HandshakeType.CLIENT_HELLO;
    }

    public Random getRandom() {
        return this.random;
    }

    public RecordSizeLimitExtension getRecordSizeLimitExtension() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (RecordSizeLimitExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.RECORD_SIZE_LIMIT);
        }
        return null;
    }

    public ServerCertificateTypeExtension getServerCertificateTypeExtension() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (ServerCertificateTypeExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.SERVER_CERT_TYPE);
        }
        return null;
    }

    public ServerNameExtension getServerNameExtension() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (ServerNameExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.SERVER_NAME);
        }
        return null;
    }

    public SessionId getSessionId() {
        return this.sessionId;
    }

    public SupportedEllipticCurvesExtension getSupportedEllipticCurvesExtension() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (SupportedEllipticCurvesExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.ELLIPTIC_CURVES);
        }
        return null;
    }

    public SupportedPointFormatsExtension getSupportedPointFormatsExtension() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (SupportedPointFormatsExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.EC_POINT_FORMATS);
        }
        return null;
    }

    public SignatureAlgorithmsExtension getSupportedSignatureAlgorithms() {
        HelloExtensions helloExtensions = this.extensions;
        if (helloExtensions != null) {
            return (SignatureAlgorithmsExtension) helloExtensions.getExtension(HelloExtension.ExtensionType.SIGNATURE_ALGORITHMS);
        }
        return null;
    }

    public boolean hasSessionId() {
        SessionId sessionId = this.sessionId;
        return sessionId != null && sessionId.length() > 0;
    }

    public void setCookie(byte[] bArr) {
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("cookie must not be null!");
        } else if (bArr.length == 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("cookie must not be empty!");
        } else {
            this.cookie = Arrays.copyOf(bArr, bArr.length);
            fragmentChanged();
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\t\tVersion: ");
        sb.append(this.clientVersion.getMajor());
        sb.append(", ");
        sb.append(this.clientVersion.getMinor());
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\tRandom:");
        sb.append(StringUtil.lineSeparator());
        sb.append(this.random);
        sb.append("\t\tSession ID Length: ");
        sb.append(this.sessionId.length());
        if (this.sessionId.length() > 0) {
            sb.append(StringUtil.lineSeparator());
            sb.append("\t\tSession ID: ");
            sb.append(this.sessionId);
        }
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\tCookie Length: ");
        sb.append(this.cookie.length);
        if (this.cookie.length > 0) {
            sb.append(StringUtil.lineSeparator());
            sb.append("\t\tCookie: ");
            sb.append(StringUtil.byteArray2HexString(this.cookie));
        }
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\tCipher Suites Length: ");
        sb.append(this.supportedCipherSuites.size() * 2);
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\tCipher Suites (");
        sb.append(this.supportedCipherSuites.size());
        sb.append(" suites)");
        for (CipherSuite cipherSuite : this.supportedCipherSuites) {
            sb.append(StringUtil.lineSeparator());
            sb.append("\t\t\tCipher Suite: ");
            sb.append(cipherSuite);
        }
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\tCompression Methods Length: ");
        sb.append(this.compressionMethods.size());
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\tCompression Methods (");
        sb.append(this.compressionMethods.size());
        sb.append(" method)");
        for (CompressionMethod compressionMethod : this.compressionMethods) {
            sb.append(StringUtil.lineSeparator());
            sb.append("\t\t\tCompression Method: ");
            sb.append(compressionMethod);
        }
        if (this.extensions != null) {
            sb.append(StringUtil.lineSeparator());
            sb.append(this.extensions);
        }
        return sb.toString();
    }

    public ClientHello(ProtocolVersion protocolVersion, DTLSSession dTLSSession, List<SignatureAndHashAlgorithm> list, List<CertificateType> list2, List<CertificateType> list3, List<XECDHECryptography.SupportedGroup> list4) {
        this(protocolVersion, dTLSSession.getSessionIdentifier(), Arrays.asList(dTLSSession.getCipherSuite()), list, list2, list3, list4, dTLSSession.getPeer());
        addCompressionMethod(dTLSSession.getWriteState().getCompressionMethod());
    }

    public ClientHello(ProtocolVersion protocolVersion, List<CipherSuite> list, List<SignatureAndHashAlgorithm> list2, List<CertificateType> list3, List<CertificateType> list4, List<XECDHECryptography.SupportedGroup> list5, InetSocketAddress inetSocketAddress) {
        this(protocolVersion, null, list, list2, list3, list4, list5, inetSocketAddress);
    }

    private ClientHello(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.supportedCipherSuites = new ArrayList();
        this.compressionMethods = new ArrayList();
        this.extensions = new HelloExtensions();
    }
}
