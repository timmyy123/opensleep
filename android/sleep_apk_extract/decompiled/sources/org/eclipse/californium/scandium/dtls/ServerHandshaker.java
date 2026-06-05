package org.eclipse.californium.scandium.dtls;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.crypto.SecretKey;
import org.eclipse.californium.elements.auth.RawPublicKeyIdentity;
import org.eclipse.californium.elements.auth.X509CertPath;
import org.eclipse.californium.scandium.config.DtlsConnectorConfig;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.CertificateRequest;
import org.eclipse.californium.scandium.dtls.SupportedPointFormatsExtension;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuiteParameters;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuiteSelector;
import org.eclipse.californium.scandium.dtls.cipher.PseudoRandomFunction;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;
import org.eclipse.californium.scandium.dtls.x509.NewAdvancedCertificateVerifier;
import org.eclipse.californium.scandium.util.SecretUtil;

/* JADX INFO: loaded from: classes5.dex */
public class ServerHandshaker extends Handshaker {
    private static HandshakeState[] CLIENT_CERTIFICATE;
    private static HandshakeState[] EMPTY_CLIENT_CERTIFICATE;
    protected static HandshakeState[] NO_CLIENT_CERTIFICATE;
    private CertificateVerify certificateVerifyMessage;
    private CipherSuiteSelector cipherSuiteSelector;
    private boolean clientAuthenticationRequired;
    private boolean clientAuthenticationWanted;
    private PublicKey clientPublicKey;
    private XECDHECryptography ecdhe;
    private PskPublicInformation preSharedKeyIdentity;
    private CipherSuiteParameters selectedCipherSuiteParameters;
    private List<CipherSuite> supportedCipherSuites;
    private final List<CertificateType> supportedClientCertificateTypes;
    protected final List<XECDHECryptography.SupportedGroup> supportedGroups;
    private final List<CertificateType> supportedServerCertificateTypes;
    private final List<SignatureAndHashAlgorithm> supportedSignatureAndHashAlgorithms;
    private boolean useNoSessionId;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.ServerHandshaker$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType;
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm;

        static {
            int[] iArr = new int[HandshakeType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType = iArr;
            try {
                iArr[HandshakeType.CLIENT_HELLO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.CERTIFICATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.CLIENT_KEY_EXCHANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.CERTIFICATE_VERIFY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[CipherSuite.KeyExchangeAlgorithm.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm = iArr2;
            try {
                iArr2[CipherSuite.KeyExchangeAlgorithm.PSK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[CipherSuite.KeyExchangeAlgorithm.ECDHE_PSK.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[CipherSuite.KeyExchangeAlgorithm.EC_DIFFIE_HELLMAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        HandshakeType handshakeType = HandshakeType.CERTIFICATE;
        HandshakeState handshakeState = new HandshakeState(handshakeType);
        HandshakeType handshakeType2 = HandshakeType.CLIENT_KEY_EXCHANGE;
        HandshakeState handshakeState2 = new HandshakeState(handshakeType2);
        HandshakeState handshakeState3 = new HandshakeState(HandshakeType.CERTIFICATE_VERIFY);
        ContentType contentType = ContentType.CHANGE_CIPHER_SPEC;
        HandshakeState handshakeState4 = new HandshakeState(contentType);
        HandshakeType handshakeType3 = HandshakeType.FINISHED;
        CLIENT_CERTIFICATE = new HandshakeState[]{handshakeState, handshakeState2, handshakeState3, handshakeState4, new HandshakeState(handshakeType3)};
        EMPTY_CLIENT_CERTIFICATE = new HandshakeState[]{new HandshakeState(handshakeType), new HandshakeState(handshakeType2), new HandshakeState(contentType), new HandshakeState(handshakeType3)};
        NO_CLIENT_CERTIFICATE = new HandshakeState[]{new HandshakeState(handshakeType2), new HandshakeState(contentType), new HandshakeState(handshakeType3)};
    }

    public ServerHandshaker(int i, DTLSSession dTLSSession, RecordLayer recordLayer, ScheduledExecutorService scheduledExecutorService, Connection connection, DtlsConnectorConfig dtlsConnectorConfig) {
        super(false, i, dTLSSession, recordLayer, scheduledExecutorService, connection, dtlsConnectorConfig);
        this.useNoSessionId = false;
        this.clientAuthenticationWanted = false;
        this.clientAuthenticationRequired = false;
        this.certificateVerifyMessage = null;
        this.cipherSuiteSelector = dtlsConnectorConfig.getCipherSuiteSelector();
        this.supportedCipherSuites = dtlsConnectorConfig.getSupportedCipherSuites();
        this.supportedGroups = dtlsConnectorConfig.getSupportedGroups();
        this.clientAuthenticationWanted = dtlsConnectorConfig.isClientAuthenticationWanted().booleanValue();
        this.clientAuthenticationRequired = dtlsConnectorConfig.isClientAuthenticationRequired().booleanValue();
        this.useNoSessionId = dtlsConnectorConfig.useNoServerSessionId().booleanValue();
        this.supportedClientCertificateTypes = dtlsConnectorConfig.getTrustCertificateTypes();
        this.supportedServerCertificateTypes = dtlsConnectorConfig.getIdentityCertificateTypes();
        this.supportedSignatureAndHashAlgorithms = dtlsConnectorConfig.getSupportedSignatureAlgorithms();
    }

    private void addServerHelloExtensions(CipherSuite cipherSuite, ClientHello clientHello, HelloExtensions helloExtensions) {
        CertificateType certificateTypeReceiveCertificateType;
        ClientCertificateTypeExtension clientCertificateTypeExtension;
        ServerCertificateTypeExtension serverCertificateTypeExtension;
        if (cipherSuite.requiresServerCertificateMessage()) {
            if ((this.clientAuthenticationRequired || this.clientAuthenticationWanted) && (certificateTypeReceiveCertificateType = this.session.receiveCertificateType()) != null && (clientCertificateTypeExtension = clientHello.getClientCertificateTypeExtension()) != null && clientCertificateTypeExtension.getCertificateTypes().contains(certificateTypeReceiveCertificateType)) {
                helloExtensions.addExtension(new ClientCertificateTypeExtension(certificateTypeReceiveCertificateType));
            }
            CertificateType certificateTypeSendCertificateType = this.session.sendCertificateType();
            if (certificateTypeSendCertificateType != null && (serverCertificateTypeExtension = clientHello.getServerCertificateTypeExtension()) != null && serverCertificateTypeExtension.getCertificateTypes().contains(certificateTypeSendCertificateType)) {
                helloExtensions.addExtension(new ServerCertificateTypeExtension(certificateTypeSendCertificateType));
            }
        }
        if (!cipherSuite.isEccBased() || clientHello.getSupportedPointFormatsExtension() == null) {
            return;
        }
        helloExtensions.addExtension(SupportedPointFormatsExtension.DEFAULT_POINT_FORMATS_EXTENSION);
    }

    private void createCertificateMessage(ClientHello clientHello, DTLSFlight dTLSFlight) throws HandshakeException {
        CertificateMessage certificateMessage;
        if (this.session.getCipherSuite().requiresServerCertificateMessage()) {
            if (CertificateType.RAW_PUBLIC_KEY == this.session.sendCertificateType()) {
                certificateMessage = new CertificateMessage(this.publicKey, this.session.getPeer());
            } else {
                if (CertificateType.X_509 != this.session.sendCertificateType()) {
                    Gson$$ExternalSyntheticBUOutline0.m("Certificate type ", this.session.sendCertificateType(), " not supported!");
                    return;
                }
                certificateMessage = new CertificateMessage(this.certificateChain, this.session.getPeer());
            }
            wrapMessage(dTLSFlight, certificateMessage);
        }
    }

    private boolean createCertificateRequest(ClientHello clientHello, DTLSFlight dTLSFlight) throws HandshakeException {
        if ((!this.clientAuthenticationWanted && !this.clientAuthenticationRequired) || !this.session.getCipherSuite().requiresServerCertificateMessage() || this.selectedCipherSuiteParameters.getSelectedClientCertificateType() == null) {
            return false;
        }
        CertificateRequest certificateRequest = new CertificateRequest(this.session.getPeer());
        certificateRequest.addCertificateType(CertificateRequest.ClientCertificateType.ECDSA_SIGN);
        if (this.session.receiveCertificateType() == CertificateType.X_509) {
            certificateRequest.addSignatureAlgorithms(this.supportedSignatureAndHashAlgorithms);
            NewAdvancedCertificateVerifier newAdvancedCertificateVerifier = this.certificateVerifier;
            if (newAdvancedCertificateVerifier != null) {
                certificateRequest.addCerticiateAuthorities(newAdvancedCertificateVerifier.getAcceptedIssuers());
            }
        } else if (this.session.receiveCertificateType() == CertificateType.RAW_PUBLIC_KEY) {
            certificateRequest.addSignatureAlgorithms(SignatureAndHashAlgorithm.getEcdsaCompatibleSignatureAlgorithms(this.supportedSignatureAndHashAlgorithms));
        }
        wrapMessage(dTLSFlight, certificateRequest);
        return true;
    }

    private void createServerHello(ClientHello clientHello, DTLSFlight dTLSFlight) throws HandshakeException {
        ProtocolVersion protocolVersionNegotiateProtocolVersion = negotiateProtocolVersion(clientHello.getClientVersion());
        this.clientRandom = clientHello.getRandom();
        this.serverRandom = new Random();
        SessionId sessionIdEmptySessionId = this.useNoSessionId ? SessionId.emptySessionId() : new SessionId();
        this.session.setSessionIdentifier(sessionIdEmptySessionId);
        List<CompressionMethod> compressionMethods = clientHello.getCompressionMethods();
        CompressionMethod compressionMethod = CompressionMethod.NULL;
        if (!compressionMethods.contains(compressionMethod)) {
            throw new HandshakeException("Client does not support NULL compression method", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, clientHello.getPeer()));
        }
        this.session.setCompressionMethod(compressionMethod);
        HelloExtensions helloExtensions = new HelloExtensions();
        negotiateCipherSuite(clientHello, helloExtensions);
        processHelloExtensions(clientHello, helloExtensions);
        wrapMessage(dTLSFlight, new ServerHello(protocolVersionNegotiateProtocolVersion, this.serverRandom, sessionIdEmptySessionId, this.session.getCipherSuite(), this.session.getCompressionMethod(), helloExtensions, this.session.getPeer()));
    }

    private void createServerKeyExchange(ClientHello clientHello, DTLSFlight dTLSFlight) throws HandshakeException {
        DTLSMessage ecdhPskServerKeyExchange;
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[this.session.getKeyExchange().ordinal()];
        if (i == 2) {
            try {
                this.ecdhe = new XECDHECryptography(this.selectedCipherSuiteParameters.getSelectedSupportedGroup());
                ecdhPskServerKeyExchange = new EcdhPskServerKeyExchange(PskPublicInformation.EMPTY, this.ecdhe, this.session.getPeer());
            } catch (GeneralSecurityException e) {
                throw new HandshakeException(FileInsert$$ExternalSyntheticOutline0.m("Error performing EC Diffie Hellman key exchange: ", e.getMessage()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, getPeerAddress()));
            }
        } else if (i != 3) {
            ecdhPskServerKeyExchange = null;
        } else {
            try {
                this.ecdhe = new XECDHECryptography(this.selectedCipherSuiteParameters.getSelectedSupportedGroup());
                ecdhPskServerKeyExchange = new EcdhEcdsaServerKeyExchange(this.session.getSignatureAndHashAlgorithm(), this.ecdhe, this.privateKey, this.clientRandom, this.serverRandom, this.session.getPeer());
            } catch (GeneralSecurityException e2) {
                throw new HandshakeException(FileInsert$$ExternalSyntheticOutline0.m("Error performing EC Diffie Hellman key exchange: ", e2.getMessage()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, getPeerAddress()));
            }
        }
        if (ecdhPskServerKeyExchange != null) {
            wrapMessage(dTLSFlight, ecdhPskServerKeyExchange);
        }
    }

    private static List<CertificateType> getCommonCertificateTypes(CertificateTypeExtension certificateTypeExtension, List<CertificateType> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            if (certificateTypeExtension != null) {
                for (CertificateType certificateType : certificateTypeExtension.getCertificateTypes()) {
                    if (list.contains(certificateType)) {
                        arrayList.add(certificateType);
                    }
                }
            } else {
                CertificateType certificateType2 = CertificateType.X_509;
                if (list.contains(certificateType2)) {
                    arrayList.add(certificateType2);
                }
            }
        }
        return arrayList;
    }

    private List<CipherSuite> getCommonCipherSuites(ClientHello clientHello) {
        List<CipherSuite> listAsList = this.supportedCipherSuites;
        CipherSuite cipherSuite = this.session.getCipherSuite();
        if (!cipherSuite.equals(CipherSuite.TLS_NULL_WITH_NULL_NULL)) {
            listAsList = Arrays.asList(cipherSuite);
        }
        ArrayList arrayList = new ArrayList();
        for (CipherSuite cipherSuite2 : clientHello.getCipherSuites()) {
            if (cipherSuite2 != CipherSuite.TLS_NULL_WITH_NULL_NULL && listAsList.contains(cipherSuite2)) {
                arrayList.add(cipherSuite2);
            }
        }
        return arrayList;
    }

    private List<CertificateType> getCommonClientCertificateTypes(ClientHello clientHello) {
        List<CertificateType> list = this.supportedClientCertificateTypes;
        Principal peerIdentity = this.session.getPeerIdentity();
        List list2 = list;
        if (peerIdentity != null) {
            ArrayList arrayList = new ArrayList();
            if (peerIdentity instanceof RawPublicKeyIdentity) {
                arrayList.add(CertificateType.RAW_PUBLIC_KEY);
                list2 = arrayList;
            } else {
                list2 = arrayList;
                if (peerIdentity instanceof X509CertPath) {
                    arrayList.add(CertificateType.X_509);
                    list2 = arrayList;
                }
            }
        }
        return getCommonCertificateTypes(clientHello.getClientCertificateTypeExtension(), list2);
    }

    private List<CertificateType> getCommonServerCertificateTypes(ClientHello clientHello) {
        return getCommonCertificateTypes(clientHello.getServerCertificateTypeExtension(), this.supportedServerCertificateTypes);
    }

    private List<SignatureAndHashAlgorithm> getCommonSignatureAndHashAlgorithms(ClientHello clientHello) {
        SignatureAlgorithmsExtension supportedSignatureAlgorithms = clientHello.getSupportedSignatureAlgorithms();
        if (supportedSignatureAlgorithms != null) {
            return SignatureAndHashAlgorithm.getCommonSignatureAlgorithms(supportedSignatureAlgorithms.getSupportedSignatureAndHashAlgorithms(), this.supportedSignatureAndHashAlgorithms);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.supportedSignatureAndHashAlgorithms);
        return arrayList;
    }

    private List<XECDHECryptography.SupportedGroup> getCommonSupportedGroups(ClientHello clientHello) {
        ArrayList arrayList = new ArrayList();
        SupportedEllipticCurvesExtension supportedEllipticCurvesExtension = clientHello.getSupportedEllipticCurvesExtension();
        if (supportedEllipticCurvesExtension == null) {
            arrayList.addAll(this.supportedGroups);
            return arrayList;
        }
        for (XECDHECryptography.SupportedGroup supportedGroup : supportedEllipticCurvesExtension.getSupportedGroups()) {
            if (this.supportedGroups.contains(supportedGroup)) {
                arrayList.add(supportedGroup);
            }
        }
        return arrayList;
    }

    private SupportedPointFormatsExtension.ECPointFormat negotiateECPointFormat(ClientHello clientHello) {
        SupportedPointFormatsExtension supportedPointFormatsExtension = clientHello.getSupportedPointFormatsExtension();
        if (supportedPointFormatsExtension == null) {
            return SupportedPointFormatsExtension.ECPointFormat.UNCOMPRESSED;
        }
        SupportedPointFormatsExtension.ECPointFormat eCPointFormat = SupportedPointFormatsExtension.ECPointFormat.UNCOMPRESSED;
        if (supportedPointFormatsExtension.contains(eCPointFormat)) {
            return eCPointFormat;
        }
        return null;
    }

    private ProtocolVersion negotiateProtocolVersion(ProtocolVersion protocolVersion) throws HandshakeException {
        ProtocolVersion protocolVersion2 = ProtocolVersion.VERSION_DTLS_1_2;
        if (protocolVersion.compareTo(protocolVersion2) >= 0) {
            return protocolVersion2;
        }
        ProtocolVersion protocolVersion3 = ProtocolVersion.VERSION_DTLS_1_0;
        if (protocolVersion.compareTo(protocolVersion3) >= 0) {
            protocolVersion3 = protocolVersion;
        }
        throw new HandshakeException("The server only supports DTLS v1.2, not " + protocolVersion + "!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.PROTOCOL_VERSION, protocolVersion3, this.session.getPeer()));
    }

    private void receivedCertificateVerify(CertificateVerify certificateVerify) throws HandshakeException {
        this.certificateVerifyMessage = certificateVerify;
        this.handshakeMessages.remove(r0.size() - 1);
        certificateVerify.verifySignature(this.clientPublicKey, this.handshakeMessages);
        this.handshakeMessages.add(certificateVerify);
        if (this.certificateVerfied) {
            CertPath certPath = this.peerCertPath;
            DTLSSession dTLSSession = this.session;
            if (certPath != null) {
                dTLSSession.setPeerIdentity(new X509CertPath(certPath));
            } else {
                dTLSSession.setPeerIdentity(new RawPublicKeyIdentity(this.clientPublicKey));
            }
        }
    }

    private void receivedClientCertificate(CertificateMessage certificateMessage) throws HandshakeException {
        PublicKey publicKey = certificateMessage.getPublicKey();
        this.clientPublicKey = publicKey;
        if (this.clientAuthenticationRequired && publicKey == null) {
            this.LOGGER.debug("Client authentication failed: missing certificate!");
            throw new HandshakeException("Client Certificate required!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, this.session.getPeer()));
        }
        if (publicKey == null) {
            this.states = EMPTY_CLIENT_CERTIFICATE;
        }
        verifyCertificate(certificateMessage);
    }

    private void receivedClientFinished(Finished finished) throws HandshakeException {
        if (this.clientAuthenticationRequired && this.states == EMPTY_CLIENT_CERTIFICATE) {
            throw new HandshakeException("Client did not send required authentication messages.", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, this.session.getPeer()));
        }
        this.flightNumber += 2;
        DTLSFlight dTLSFlightCreateFlight = createFlight();
        MessageDigest handshakeMessageDigest = getHandshakeMessageDigest();
        try {
            MessageDigest messageDigest = (MessageDigest) handshakeMessageDigest.clone();
            finished.verifyData(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), this.masterSecret, true, handshakeMessageDigest.digest());
            wrapMessage(dTLSFlightCreateFlight, new ChangeCipherSpecMessage(this.session.getPeer()));
            setCurrentWriteState();
            messageDigest.update(finished.toByteArray());
            wrapMessage(dTLSFlightCreateFlight, new Finished(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), this.masterSecret, this.isClient, messageDigest.digest(), this.session.getPeer()));
            sendLastFlight(dTLSFlightCreateFlight);
            sessionEstablished();
        } catch (CloneNotSupportedException unused) {
            throw new HandshakeException("Cannot create FINISHED message hash", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, finished.getPeer()));
        }
    }

    private void receivedClientHello(ClientHello clientHello) throws HandshakeException {
        handshakeStarted();
        byte[] cookie = clientHello.getCookie();
        this.flightNumber = (cookie == null || cookie.length <= 0) ? 2 : 4;
        DTLSFlight dTLSFlightCreateFlight = createFlight();
        createServerHello(clientHello, dTLSFlightCreateFlight);
        createCertificateMessage(clientHello, dTLSFlightCreateFlight);
        createServerKeyExchange(clientHello, dTLSFlightCreateFlight);
        if (createCertificateRequest(clientHello, dTLSFlightCreateFlight)) {
            this.states = CLIENT_CERTIFICATE;
        } else {
            this.states = NO_CLIENT_CERTIFICATE;
        }
        this.statesIndex = -1;
        wrapMessage(dTLSFlightCreateFlight, new ServerHelloDone(this.session.getPeer()));
        sendFlight(dTLSFlightCreateFlight);
    }

    private SecretKey receivedClientKeyExchange(ECDHClientKeyExchange eCDHClientKeyExchange) throws GeneralSecurityException {
        SecretKey secretKeyGenerateSecret = this.ecdhe.generateSecret(eCDHClientKeyExchange.getEncodedPoint());
        SecretKey secretKeyGenerateMasterSecret = PseudoRandomFunction.generateMasterSecret(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), secretKeyGenerateSecret, generateRandomSeed());
        SecretUtil.destroy(secretKeyGenerateSecret);
        return secretKeyGenerateMasterSecret;
    }

    @Override // org.eclipse.californium.scandium.dtls.Handshaker, javax.security.auth.Destroyable
    public void destroy() {
        SecretUtil.destroy(this.ecdhe);
        this.ecdhe = null;
    }

    @Override // org.eclipse.californium.scandium.dtls.Handshaker
    public void doProcessMessage(HandshakeMessage handshakeMessage) throws GeneralSecurityException, HandshakeException {
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[handshakeMessage.getMessageType().ordinal()];
        if (i == 1) {
            receivedClientHello((ClientHello) handshakeMessage);
            return;
        }
        if (i == 2) {
            receivedClientCertificate((CertificateMessage) handshakeMessage);
            return;
        }
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    throw new HandshakeException(String.format("Received unexpected %s message from peer %s", handshakeMessage.getMessageType(), handshakeMessage.getPeer()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNEXPECTED_MESSAGE, handshakeMessage.getPeer()));
                }
                receivedClientFinished((Finished) handshakeMessage);
                return;
            } else {
                receivedCertificateVerify((CertificateVerify) handshakeMessage);
                if (this.masterSecret == null || !this.certificateVerfied) {
                    return;
                }
                expectChangeCipherSpecMessage();
                return;
            }
        }
        int i2 = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[this.session.getKeyExchange().ordinal()];
        if (i2 == 1) {
            PskSecretResult pskSecretResultReceivedClientKeyExchange = receivedClientKeyExchange((PSKClientKeyExchange) handshakeMessage);
            if (pskSecretResultReceivedClientKeyExchange != null) {
                processPskSecretResult(pskSecretResultReceivedClientKeyExchange);
                return;
            }
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                throw new HandshakeException(FileInsert$$ExternalSyntheticOutline0.m("Unsupported key exchange algorithm ", this.session.getKeyExchange().name()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, handshakeMessage.getPeer()));
            }
            processMasterSecret(receivedClientKeyExchange((ECDHClientKeyExchange) handshakeMessage));
        } else {
            PskSecretResult pskSecretResultReceivedClientKeyExchange2 = receivedClientKeyExchange((EcdhPskClientKeyExchange) handshakeMessage);
            if (pskSecretResultReceivedClientKeyExchange2 != null) {
                processPskSecretResult(pskSecretResultReceivedClientKeyExchange2);
            }
        }
    }

    public void negotiateCipherSuite(ClientHello clientHello, HelloExtensions helloExtensions) {
        CipherSuiteParameters cipherSuiteParameters = new CipherSuiteParameters(this.publicKey, this.certificateChain, this.clientAuthenticationRequired, this.clientAuthenticationWanted, getCommonCipherSuites(clientHello), getCommonServerCertificateTypes(clientHello), getCommonClientCertificateTypes(clientHello), getCommonSupportedGroups(clientHello), getCommonSignatureAndHashAlgorithms(clientHello), negotiateECPointFormat(clientHello));
        if (!this.cipherSuiteSelector.select(cipherSuiteParameters)) {
            throw new HandshakeException("Client proposed unsupported cipher suites only", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, this.session.getPeer()));
        }
        this.selectedCipherSuiteParameters = cipherSuiteParameters;
        CipherSuite selectedCipherSuite = cipherSuiteParameters.getSelectedCipherSuite();
        this.session.setCipherSuite(selectedCipherSuite);
        if (selectedCipherSuite.requiresServerCertificateMessage()) {
            this.session.setSignatureAndHashAlgorithm(cipherSuiteParameters.getSelectedSignature());
            this.session.setSendCertificateType(cipherSuiteParameters.getSelectedServerCertificateType());
            CertificateType selectedClientCertificateType = cipherSuiteParameters.getSelectedClientCertificateType();
            if (this.clientAuthenticationRequired || (this.clientAuthenticationWanted && selectedClientCertificateType != null)) {
                this.session.setReceiveCertificateType(cipherSuiteParameters.getSelectedClientCertificateType());
            }
        }
        addServerHelloExtensions(selectedCipherSuite, clientHello, helloExtensions);
        this.session.setParameterAvailable();
        this.LOGGER.debug("Negotiated cipher suite [{}] with peer [{}]", selectedCipherSuite.name(), getPeerAddress());
    }

    @Override // org.eclipse.californium.scandium.dtls.Handshaker
    public void processCertificateVerified() {
        if (this.certificateVerifyMessage != null) {
            CertPath certPath = this.peerCertPath;
            DTLSSession dTLSSession = this.session;
            if (certPath != null) {
                dTLSSession.setPeerIdentity(new X509CertPath(certPath));
            } else {
                dTLSSession.setPeerIdentity(new RawPublicKeyIdentity(this.clientPublicKey));
            }
        }
        if ((this.states == EMPTY_CLIENT_CERTIFICATE || this.certificateVerifyMessage != null) && this.masterSecret != null) {
            expectChangeCipherSpecMessage();
        }
    }

    public void processHelloExtensions(ClientHello clientHello, HelloExtensions helloExtensions) {
        ConnectionIdExtension connectionIdExtension;
        MaxFragmentLengthExtension maxFragmentLengthExtension;
        RecordSizeLimitExtension recordSizeLimitExtension = clientHello.getRecordSizeLimitExtension();
        if (recordSizeLimitExtension != null) {
            this.session.setRecordSizeLimit(recordSizeLimitExtension.getRecordSizeLimit());
            Integer num = this.recordSizeLimit;
            int maxFragmentLength = num == null ? this.session.getMaxFragmentLength() : num.intValue();
            helloExtensions.addExtension(new RecordSizeLimitExtension(maxFragmentLength));
            this.LOGGER.debug("Received record size limit [{} bytes] from peer [{}]", Integer.valueOf(maxFragmentLength), clientHello.getPeer());
        }
        if (recordSizeLimitExtension == null && (maxFragmentLengthExtension = clientHello.getMaxFragmentLengthExtension()) != null) {
            this.session.setMaxFragmentLength(maxFragmentLengthExtension.getFragmentLength().length());
            helloExtensions.addExtension(maxFragmentLengthExtension);
            this.LOGGER.debug("Negotiated max. fragment length [{} bytes] with peer [{}]", Integer.valueOf(maxFragmentLengthExtension.getFragmentLength().length()), clientHello.getPeer());
        }
        ServerNameExtension serverNameExtension = clientHello.getServerNameExtension();
        if (serverNameExtension != null) {
            if (this.sniEnabled) {
                this.session.setServerNames(serverNameExtension.getServerNames());
                helloExtensions.addExtension(ServerNameExtension.emptyServerNameIndication());
                this.session.setSniSupported(true);
                this.LOGGER.debug("using server name indication received from peer [{}]", clientHello.getPeer());
            } else {
                this.LOGGER.debug("client [{}] included SNI in HELLO but SNI support is disabled", clientHello.getPeer());
            }
        }
        if (this.connectionIdGenerator == null || (connectionIdExtension = clientHello.getConnectionIdExtension()) == null) {
            return;
        }
        this.session.setWriteConnectionId(connectionIdExtension.getConnectionId());
        ConnectionId readConnectionId = getReadConnectionId();
        this.session.setReadConnectionId(readConnectionId);
        helloExtensions.addExtension(ConnectionIdExtension.fromConnectionId(readConnectionId));
    }

    @Override // org.eclipse.californium.scandium.dtls.Handshaker
    public void processMasterSecret(SecretKey secretKey) {
        applyMasterSecret(secretKey);
        SecretUtil.destroy(secretKey);
        HandshakeState[] handshakeStateArr = this.states;
        if (handshakeStateArr == NO_CLIENT_CERTIFICATE || (handshakeStateArr == EMPTY_CLIENT_CERTIFICATE && this.certificateVerfied)) {
            expectChangeCipherSpecMessage();
        }
    }

    private PskSecretResult receivedClientKeyExchange(PSKClientKeyExchange pSKClientKeyExchange) {
        PskPublicInformation identity = pSKClientKeyExchange.getIdentity();
        this.preSharedKeyIdentity = identity;
        return requestPskSecretResult(identity, null);
    }

    private PskSecretResult receivedClientKeyExchange(EcdhPskClientKeyExchange ecdhPskClientKeyExchange) throws GeneralSecurityException {
        this.preSharedKeyIdentity = ecdhPskClientKeyExchange.getIdentity();
        SecretKey secretKeyGenerateSecret = this.ecdhe.generateSecret(ecdhPskClientKeyExchange.getEncodedPoint());
        PskSecretResult pskSecretResultRequestPskSecretResult = requestPskSecretResult(this.preSharedKeyIdentity, secretKeyGenerateSecret);
        SecretUtil.destroy(secretKeyGenerateSecret);
        return pskSecretResultRequestPskSecretResult;
    }
}
