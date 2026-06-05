package org.eclipse.californium.scandium.dtls;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.crypto.SecretKey;
import org.eclipse.californium.elements.auth.RawPublicKeyIdentity;
import org.eclipse.californium.elements.auth.X509CertPath;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.config.DtlsConnectorConfig;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.HelloExtension;
import org.eclipse.californium.scandium.dtls.MaxFragmentLengthExtension;
import org.eclipse.californium.scandium.dtls.SupportedPointFormatsExtension;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.dtls.cipher.PseudoRandomFunction;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;
import org.eclipse.californium.scandium.util.SecretUtil;
import org.eclipse.californium.scandium.util.ServerNames;

/* JADX INFO: loaded from: classes5.dex */
public class ClientHandshaker extends Handshaker {
    private static HandshakeState[] NO_SEVER_CERTIFICATE;
    protected static HandshakeState[] SEVER_CERTIFICATE;
    protected CertificateRequest certificateRequest;
    protected ClientHello clientHello;
    protected ClientKeyExchange clientKeyExchange;
    protected byte[] handshakeHash;
    protected final Integer maxFragmentLengthCode;
    private ProtocolVersion maxProtocolVersion;
    protected SignatureAndHashAlgorithm negotiatedSignatureAndHashAlgorithm;
    private boolean probe;
    protected boolean sentClientCertificate;
    protected ECDHServerKeyExchange serverKeyExchange;
    private PublicKey serverPublicKey;
    private final List<CipherSuite> supportedCipherSuites;
    protected final List<CertificateType> supportedClientCertificateTypes;
    protected final List<XECDHECryptography.SupportedGroup> supportedGroups;
    protected final List<CertificateType> supportedServerCertificateTypes;
    protected final List<SignatureAndHashAlgorithm> supportedSignatureAlgorithms;
    protected final boolean truncateCertificatePath;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.ClientHandshaker$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType;
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm;

        static {
            int[] iArr = new int[HandshakeType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType = iArr;
            try {
                iArr[HandshakeType.HELLO_VERIFY_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.SERVER_HELLO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.CERTIFICATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.SERVER_KEY_EXCHANGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.CERTIFICATE_REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.SERVER_HELLO_DONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.FINISHED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[CipherSuite.KeyExchangeAlgorithm.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm = iArr2;
            try {
                iArr2[CipherSuite.KeyExchangeAlgorithm.EC_DIFFIE_HELLMAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[CipherSuite.KeyExchangeAlgorithm.PSK.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[CipherSuite.KeyExchangeAlgorithm.ECDHE_PSK.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[CipherSuite.KeyExchangeAlgorithm.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        HandshakeType handshakeType = HandshakeType.HELLO_VERIFY_REQUEST;
        HandshakeState handshakeState = new HandshakeState(handshakeType, true);
        HandshakeType handshakeType2 = HandshakeType.SERVER_HELLO;
        HandshakeState handshakeState2 = new HandshakeState(handshakeType2);
        HandshakeState handshakeState3 = new HandshakeState(HandshakeType.CERTIFICATE);
        HandshakeType handshakeType3 = HandshakeType.SERVER_KEY_EXCHANGE;
        HandshakeState handshakeState4 = new HandshakeState(handshakeType3);
        HandshakeState handshakeState5 = new HandshakeState(HandshakeType.CERTIFICATE_REQUEST, true);
        HandshakeType handshakeType4 = HandshakeType.SERVER_HELLO_DONE;
        HandshakeState handshakeState6 = new HandshakeState(handshakeType4);
        ContentType contentType = ContentType.CHANGE_CIPHER_SPEC;
        HandshakeState handshakeState7 = new HandshakeState(contentType);
        HandshakeType handshakeType5 = HandshakeType.FINISHED;
        SEVER_CERTIFICATE = new HandshakeState[]{handshakeState, handshakeState2, handshakeState3, handshakeState4, handshakeState5, handshakeState6, handshakeState7, new HandshakeState(handshakeType5)};
        NO_SEVER_CERTIFICATE = new HandshakeState[]{new HandshakeState(handshakeType, true), new HandshakeState(handshakeType2), new HandshakeState(handshakeType3, true), new HandshakeState(handshakeType4), new HandshakeState(contentType), new HandshakeState(handshakeType5)};
    }

    public ClientHandshaker(DTLSSession dTLSSession, RecordLayer recordLayer, ScheduledExecutorService scheduledExecutorService, Connection connection, DtlsConnectorConfig dtlsConnectorConfig, boolean z) {
        super(true, 0, dTLSSession, recordLayer, scheduledExecutorService, connection, dtlsConnectorConfig);
        this.maxProtocolVersion = ProtocolVersion.VERSION_DTLS_1_2;
        this.clientHello = null;
        this.certificateRequest = null;
        this.handshakeHash = null;
        this.supportedCipherSuites = dtlsConnectorConfig.getSupportedCipherSuites();
        this.supportedGroups = dtlsConnectorConfig.getSupportedGroups();
        this.maxFragmentLengthCode = dtlsConnectorConfig.getMaxFragmentLengthCode();
        this.truncateCertificatePath = dtlsConnectorConfig.useTruncatedCertificatePathForClientsCertificateMessage().booleanValue();
        this.supportedServerCertificateTypes = dtlsConnectorConfig.getTrustCertificateTypes();
        this.supportedClientCertificateTypes = dtlsConnectorConfig.getIdentityCertificateTypes();
        this.supportedSignatureAlgorithms = dtlsConnectorConfig.getSupportedSignatureAlgorithms();
        this.probe = z;
    }

    public static boolean isSupportedCertificateType(CertificateType certificateType, List<CertificateType> list) {
        return list != null ? list.contains(certificateType) : certificateType == CertificateType.X_509;
    }

    private void processServerHelloDone() throws HandshakeException {
        DTLSFlight dTLSFlightCreateFlight = createFlight();
        createCertificateMessage(dTLSFlightCreateFlight);
        wrapMessage(dTLSFlightCreateFlight, this.clientKeyExchange);
        if (this.sentClientCertificate && this.certificateRequest != null && this.negotiatedSignatureAndHashAlgorithm != null) {
            CertificateType certificateTypeSendCertificateType = this.session.sendCertificateType();
            if (!isSupportedCertificateType(certificateTypeSendCertificateType, this.supportedClientCertificateTypes)) {
                throw new HandshakeException("Server wants to use not supported client certificate type " + certificateTypeSendCertificateType, new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, this.session.getPeer()));
            }
            wrapMessage(dTLSFlightCreateFlight, new CertificateVerify(this.negotiatedSignatureAndHashAlgorithm, this.privateKey, this.handshakeMessages, this.session.getPeer()));
        }
        wrapMessage(dTLSFlightCreateFlight, new ChangeCipherSpecMessage(this.session.getPeer()));
        setCurrentWriteState();
        MessageDigest handshakeMessageDigest = getHandshakeMessageDigest();
        try {
            MessageDigest messageDigest = (MessageDigest) handshakeMessageDigest.clone();
            Finished finished = new Finished(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), this.masterSecret, this.isClient, handshakeMessageDigest.digest(), this.session.getPeer());
            wrapMessage(dTLSFlightCreateFlight, finished);
            messageDigest.update(finished.toByteArray());
            this.handshakeHash = messageDigest.digest();
            sendFlight(dTLSFlightCreateFlight);
            expectChangeCipherSpecMessage();
        } catch (CloneNotSupportedException unused) {
            throw new HandshakeException("Cannot create FINISHED message", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, this.session.getPeer()));
        }
    }

    private void receivedServerCertificate(CertificateMessage certificateMessage) throws HandshakeException {
        if (certificateMessage.isEmpty()) {
            this.LOGGER.debug("Certificate validation failed: empty server certificate!");
            throw new HandshakeException("Empty server certificate!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.BAD_CERTIFICATE, this.session.getPeer()));
        }
        verifyCertificate(certificateMessage);
        this.serverPublicKey = certificateMessage.getPublicKey();
    }

    private void receivedServerFinished(Finished finished) throws HandshakeException {
        finished.verifyData(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), this.masterSecret, false, this.handshakeHash);
        sessionEstablished();
        handshakeCompleted();
    }

    private void receivedServerHelloDone(ServerHelloDone serverHelloDone) throws GeneralSecurityException, HandshakeException {
        this.flightNumber += 2;
        XECDHECryptography xECDHECryptography = this.serverKeyExchange == null ? null : new XECDHECryptography(this.serverKeyExchange.getSupportedGroup());
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[this.session.getKeyExchange().ordinal()];
        if (i == 1) {
            this.clientKeyExchange = new ECDHClientKeyExchange(xECDHECryptography.getEncodedPoint(), this.session.getPeer());
            SecretKey secretKeyGenerateSecret = xECDHECryptography.generateSecret(this.serverKeyExchange.getEncodedPoint());
            SecretKey secretKeyGenerateMasterSecret = PseudoRandomFunction.generateMasterSecret(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), secretKeyGenerateSecret, generateRandomSeed());
            SecretUtil.destroy(secretKeyGenerateSecret);
            processMasterSecret(secretKeyGenerateMasterSecret);
        } else if (i == 2) {
            PskPublicInformation pskClientIdentity = getPskClientIdentity();
            this.LOGGER.trace("Using PSK identity: {}", pskClientIdentity);
            this.clientKeyExchange = new PSKClientKeyExchange(pskClientIdentity, this.session.getPeer());
            PskSecretResult pskSecretResultRequestPskSecretResult = requestPskSecretResult(pskClientIdentity, null);
            if (pskSecretResultRequestPskSecretResult != null) {
                processPskSecretResult(pskSecretResultRequestPskSecretResult);
            }
        } else {
            if (i != 3) {
                throw new HandshakeException("Unknown key exchange algorithm: " + this.session.getKeyExchange(), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, this.session.getPeer()));
            }
            PskPublicInformation pskClientIdentity2 = getPskClientIdentity();
            this.LOGGER.trace("Using ECDHE PSK identity: {}", pskClientIdentity2);
            this.clientKeyExchange = new EcdhPskClientKeyExchange(pskClientIdentity2, xECDHECryptography.getEncodedPoint(), this.session.getPeer());
            SecretKey secretKeyGenerateSecret2 = xECDHECryptography.generateSecret(this.serverKeyExchange.getEncodedPoint());
            PskSecretResult pskSecretResultRequestPskSecretResult2 = requestPskSecretResult(pskClientIdentity2, secretKeyGenerateSecret2);
            SecretUtil.destroy(secretKeyGenerateSecret2);
            if (pskSecretResultRequestPskSecretResult2 != null) {
                processPskSecretResult(pskSecretResultRequestPskSecretResult2);
            }
        }
        SecretUtil.destroy(xECDHECryptography);
    }

    private void receivedServerKeyExchange(EcdhEcdsaServerKeyExchange ecdhEcdsaServerKeyExchange) throws HandshakeException {
        ecdhEcdsaServerKeyExchange.verifySignature(this.serverPublicKey, this.clientRandom, this.serverRandom);
        CertPath certPath = this.peerCertPath;
        DTLSSession dTLSSession = this.session;
        if (certPath != null) {
            dTLSSession.setPeerIdentity(new X509CertPath(certPath));
        } else {
            dTLSSession.setPeerIdentity(new RawPublicKeyIdentity(this.serverPublicKey));
        }
        this.serverKeyExchange = ecdhEcdsaServerKeyExchange;
    }

    public void addConnectionId(ClientHello clientHello) {
        ConnectionIdGenerator connectionIdGenerator = this.connectionIdGenerator;
        if (connectionIdGenerator != null) {
            clientHello.addExtension(ConnectionIdExtension.fromConnectionId(connectionIdGenerator.useConnectionId() ? getConnection().getConnectionId() : ConnectionId.EMPTY));
        }
    }

    public void addMaxFragmentLength(ClientHello clientHello) {
        Integer num = this.maxFragmentLengthCode;
        if (num != null) {
            clientHello.addExtension(new MaxFragmentLengthExtension(num.intValue()));
            this.LOGGER.debug("Indicating max. fragment length [{}] to server [{}]", this.maxFragmentLengthCode, getPeerAddress());
        }
    }

    public void addRecordSizeLimit(ClientHello clientHello) {
        Integer num = this.recordSizeLimit;
        if (num != null) {
            clientHello.addExtension(new RecordSizeLimitExtension(num.intValue()));
            this.LOGGER.debug("Indicating record size limit [{}] to server [{}]", this.recordSizeLimit, getPeerAddress());
        }
    }

    public void addServerNameIndication(ClientHello clientHello) {
        if (!this.sniEnabled || this.session.getServerNames() == null) {
            return;
        }
        this.LOGGER.debug("adding SNI extension to CLIENT_HELLO message [{}]", this.session.getHostName());
        clientHello.addExtension(ServerNameExtension.forServerNames(this.session.getServerNames()));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void createCertificateMessage(DTLSFlight dTLSFlight) throws HandshakeException {
        CertificateMessage certificateMessage;
        if (this.certificateRequest != null) {
            List<SignatureAndHashAlgorithm> list = this.supportedSignatureAlgorithms;
            if (list.isEmpty()) {
                list = SignatureAndHashAlgorithm.DEFAULT;
            }
            this.certificateRequest.selectSignatureAlgorithms(list);
            if (CertificateType.RAW_PUBLIC_KEY == this.session.sendCertificateType()) {
                PublicKey publicKey = this.publicKey;
                if (publicKey != null) {
                    SignatureAndHashAlgorithm signatureAndHashAlgorithm = this.certificateRequest.getSignatureAndHashAlgorithm(publicKey);
                    this.negotiatedSignatureAndHashAlgorithm = signatureAndHashAlgorithm;
                    PublicKey publicKey2 = signatureAndHashAlgorithm != null ? publicKey : null;
                    if (this.LOGGER.isDebugEnabled()) {
                        this.LOGGER.debug("sending CERTIFICATE message with client RawPublicKey [{}] to server", StringUtil.byteArray2HexString(publicKey2 == null ? Bytes.EMPTY : publicKey2.getEncoded()));
                    }
                    certificateMessage = new CertificateMessage(publicKey2, this.session.getPeer());
                }
            } else {
                if (CertificateType.X_509 != this.session.sendCertificateType()) {
                    Gson$$ExternalSyntheticBUOutline0.m("Certificate type ", this.session.sendCertificateType(), " not supported!");
                    return;
                }
                List<X509Certificate> list2 = Collections.EMPTY_LIST;
                List<X509Certificate> list3 = this.certificateChain;
                if (list3 != null) {
                    SignatureAndHashAlgorithm signatureAndHashAlgorithm2 = this.certificateRequest.getSignatureAndHashAlgorithm(list3);
                    this.negotiatedSignatureAndHashAlgorithm = signatureAndHashAlgorithm2;
                    if (signatureAndHashAlgorithm2 != null) {
                        list2 = this.certificateChain;
                    }
                }
                certificateMessage = new CertificateMessage(list2, this.truncateCertificatePath ? this.certificateRequest.getCertificateAuthorities() : null, this.session.getPeer());
            }
            this.sentClientCertificate = certificateMessage.getMessageLength() > 3;
            wrapMessage(dTLSFlight, certificateMessage);
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.Handshaker
    public void doProcessMessage(HandshakeMessage handshakeMessage) throws GeneralSecurityException, HandshakeException {
        switch (AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[handshakeMessage.getMessageType().ordinal()]) {
            case 1:
                receivedHelloVerifyRequest((HelloVerifyRequest) handshakeMessage);
                return;
            case 2:
                receivedServerHello((ServerHello) handshakeMessage);
                return;
            case 3:
                receivedServerCertificate((CertificateMessage) handshakeMessage);
                return;
            case 4:
                int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[this.session.getKeyExchange().ordinal()];
                if (i == 1) {
                    receivedServerKeyExchange((EcdhEcdsaServerKeyExchange) handshakeMessage);
                    return;
                }
                if (i != 2) {
                    if (i == 3) {
                        this.serverKeyExchange = (EcdhPskServerKeyExchange) handshakeMessage;
                        return;
                    } else {
                        if (i != 4) {
                            throw new HandshakeException(FileInsert$$ExternalSyntheticOutline0.m("Unsupported key exchange algorithm ", this.session.getKeyExchange().name()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, handshakeMessage.getPeer()));
                        }
                        this.LOGGER.info("Received unexpected ServerKeyExchange message in NULL key exchange mode.");
                        return;
                    }
                }
                return;
            case 5:
                this.certificateRequest = (CertificateRequest) handshakeMessage;
                return;
            case 6:
                receivedServerHelloDone((ServerHelloDone) handshakeMessage);
                return;
            case 7:
                receivedServerFinished((Finished) handshakeMessage);
                return;
            default:
                throw new HandshakeException(String.format("Received unexpected handshake message [%s] from peer %s", handshakeMessage.getMessageType(), handshakeMessage.getPeer()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNEXPECTED_MESSAGE, handshakeMessage.getPeer()));
        }
    }

    public PskPublicInformation getPskClientIdentity() throws HandshakeException {
        ServerNames serverNames = this.sniEnabled ? this.session.getServerNames() : null;
        if (serverNames != null && !this.session.isSniSupported()) {
            this.LOGGER.warn("client is configured to use SNI but server does not support it, PSK authentication is likely to fail");
        }
        PskPublicInformation identity = this.advancedPskStore.getIdentity(this.session.getPeer(), serverNames);
        if (identity != null) {
            return identity;
        }
        AlertMessage alertMessage = new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, this.session.getPeer());
        if (serverNames != null) {
            throw new HandshakeException(String.format("No Identity found for peer [address: %s, virtual host: %s]", this.session.getPeer(), this.session.getHostName()), alertMessage);
        }
        throw new HandshakeException(String.format("No Identity found for peer [address: %s]", this.session.getPeer()), alertMessage);
    }

    @Override // org.eclipse.californium.scandium.dtls.Handshaker
    public boolean isProbing() {
        return this.probe;
    }

    @Override // org.eclipse.californium.scandium.dtls.Handshaker
    public boolean isRemovingConnection() {
        return !this.probe && super.isRemovingConnection();
    }

    @Override // org.eclipse.californium.scandium.dtls.Handshaker
    public void processCertificateVerified() throws HandshakeException {
        if (this.masterSecret != null) {
            processServerHelloDone();
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.Handshaker
    public void processMasterSecret(SecretKey secretKey) throws HandshakeException {
        applyMasterSecret(secretKey);
        SecretUtil.destroy(secretKey);
        if (this.states != SEVER_CERTIFICATE || this.certificateVerfied) {
            processServerHelloDone();
        }
    }

    public void receivedHelloVerifyRequest(HelloVerifyRequest helloVerifyRequest) throws HandshakeException {
        this.handshakeMessages.clear();
        this.clientHello.setCookie(helloVerifyRequest.getCookie());
        this.flightNumber = 3;
        DTLSFlight dTLSFlightCreateFlight = createFlight();
        wrapMessage(dTLSFlightCreateFlight, this.clientHello);
        sendFlight(dTLSFlightCreateFlight);
        this.statesIndex--;
    }

    public void receivedServerHello(ServerHello serverHello) throws HandshakeException {
        ConnectionIdExtension connectionIdExtension;
        ProtocolVersion serverVersion = serverHello.getServerVersion();
        this.usedProtocol = serverVersion;
        if (serverVersion.compareTo(ProtocolVersion.VERSION_DTLS_1_2) != 0) {
            throw new HandshakeException("The client only supports DTLS v1.2, not " + this.usedProtocol + "!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.PROTOCOL_VERSION, this.session.getPeer()));
        }
        this.serverRandom = serverHello.getRandom();
        this.session.setSessionIdentifier(serverHello.getSessionId());
        CipherSuite cipherSuite = serverHello.getCipherSuite();
        if (!this.supportedCipherSuites.contains(cipherSuite)) {
            throw new HandshakeException("Server wants to use not supported cipher suite " + cipherSuite, new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, serverHello.getPeer()));
        }
        this.session.setCipherSuite(cipherSuite);
        CompressionMethod compressionMethod = serverHello.getCompressionMethod();
        if (compressionMethod != CompressionMethod.NULL) {
            throw new HandshakeException("Server wants to use not supported compression method " + compressionMethod, new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, serverHello.getPeer()));
        }
        this.session.setCompressionMethod(serverHello.getCompressionMethod());
        verifyServerHelloExtensions(serverHello);
        if (this.connectionIdGenerator != null && (connectionIdExtension = serverHello.getConnectionIdExtension()) != null) {
            this.session.setWriteConnectionId(connectionIdExtension.getConnectionId());
            this.session.setReadConnectionId(getReadConnectionId());
        }
        this.session.setSniSupported(serverHello.hasServerNameExtension());
        this.session.setParameterAvailable();
        if (cipherSuite.requiresServerCertificateMessage()) {
            return;
        }
        this.states = NO_SEVER_CERTIFICATE;
    }

    @Override // org.eclipse.californium.scandium.dtls.Handshaker
    public void resetProbing() {
        this.probe = false;
    }

    public void startHandshake() throws HandshakeException {
        handshakeStarted();
        ClientHello clientHello = new ClientHello(this.maxProtocolVersion, this.supportedCipherSuites, this.supportedSignatureAlgorithms, this.supportedClientCertificateTypes, this.supportedServerCertificateTypes, this.supportedGroups, this.session.getPeer());
        this.clientRandom = clientHello.getRandom();
        clientHello.addCompressionMethod(CompressionMethod.NULL);
        addConnectionId(clientHello);
        addRecordSizeLimit(clientHello);
        addMaxFragmentLength(clientHello);
        addServerNameIndication(clientHello);
        this.flightNumber = 1;
        this.clientHello = clientHello;
        DTLSFlight dTLSFlightCreateFlight = createFlight();
        wrapMessage(dTLSFlightCreateFlight, clientHello);
        sendFlight(dTLSFlightCreateFlight);
        this.states = SEVER_CERTIFICATE;
        this.statesIndex = 0;
    }

    public void verifyServerHelloExtensions(ServerHello serverHello) throws HandshakeException {
        HelloExtensions extensions = serverHello.getExtensions();
        if (extensions != null && !extensions.isEmpty()) {
            HelloExtensions extensions2 = this.clientHello.getExtensions();
            if (extensions2 == null || extensions2.isEmpty()) {
                throw new HandshakeException("Server wants extensions, but client not!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNSUPPORTED_EXTENSION, serverHello.getPeer()));
            }
            for (HelloExtension helloExtension : extensions.getExtensions()) {
                if (extensions2.getExtension(helloExtension.getType()) == null) {
                    throw new HandshakeException("Server wants " + helloExtension.getType() + ", but client not!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNSUPPORTED_EXTENSION, serverHello.getPeer()));
                }
            }
            if (extensions.getExtension(HelloExtension.ExtensionType.SERVER_CERT_TYPE) != null) {
                CertificateType serverCertificateType = serverHello.getServerCertificateType();
                if (!isSupportedCertificateType(serverCertificateType, this.supportedServerCertificateTypes)) {
                    throw new HandshakeException("Server wants to use not supported server certificate type " + serverCertificateType, new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, serverHello.getPeer()));
                }
                this.session.setReceiveCertificateType(serverCertificateType);
            }
            if (extensions.getExtension(HelloExtension.ExtensionType.CLIENT_CERT_TYPE) != null) {
                CertificateType clientCertificateType = serverHello.getClientCertificateType();
                if (!isSupportedCertificateType(clientCertificateType, this.supportedClientCertificateTypes)) {
                    throw new HandshakeException("Server wants to use not supported client certificate type " + clientCertificateType, new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, serverHello.getPeer()));
                }
                this.session.setSendCertificateType(clientCertificateType);
            }
        }
        SupportedPointFormatsExtension supportedPointFormatsExtension = serverHello.getSupportedPointFormatsExtension();
        if (supportedPointFormatsExtension != null && !supportedPointFormatsExtension.contains(SupportedPointFormatsExtension.ECPointFormat.UNCOMPRESSED)) {
            throw new HandshakeException("Server wants to use only not supported EC point formats!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, serverHello.getPeer()));
        }
        RecordSizeLimitExtension recordSizeLimit = serverHello.getRecordSizeLimit();
        if (recordSizeLimit != null) {
            this.session.setRecordSizeLimit(recordSizeLimit.getRecordSizeLimit());
        }
        MaxFragmentLengthExtension maxFragmentLength = serverHello.getMaxFragmentLength();
        if (maxFragmentLength != null) {
            if (recordSizeLimit != null) {
                throw new HandshakeException("Server wants to use record size limit and max. fragment size", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, serverHello.getPeer()));
            }
            MaxFragmentLengthExtension.Length fragmentLength = maxFragmentLength.getFragmentLength();
            if (fragmentLength.code() != this.maxFragmentLengthCode.intValue()) {
                throw new HandshakeException("Server wants to use other max. fragment size than proposed", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, serverHello.getPeer()));
            }
            this.session.setMaxFragmentLength(fragmentLength.length());
        }
    }
}
