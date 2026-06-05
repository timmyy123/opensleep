package org.eclipse.californium.scandium.dtls;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.concurrent.ScheduledExecutorService;
import javax.crypto.SecretKey;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.scandium.config.DtlsConnectorConfig;
import org.eclipse.californium.scandium.dtls.AlertMessage;

/* JADX INFO: loaded from: classes5.dex */
public class ResumingClientHandshaker extends ClientHandshaker {
    private static HandshakeState[] RESUME = {new HandshakeState(HandshakeType.HELLO_VERIFY_REQUEST, true), new HandshakeState(HandshakeType.SERVER_HELLO), new HandshakeState(ContentType.CHANGE_CIPHER_SPEC), new HandshakeState(HandshakeType.FINISHED)};
    private boolean fullHandshake;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.ResumingClientHandshaker$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType;

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
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ResumingClientHandshaker(DTLSSession dTLSSession, RecordLayer recordLayer, ScheduledExecutorService scheduledExecutorService, Connection connection, DtlsConnectorConfig dtlsConnectorConfig, boolean z) {
        super(dTLSSession, recordLayer, scheduledExecutorService, connection, dtlsConnectorConfig, z);
        this.fullHandshake = false;
        if (dTLSSession.getSessionIdentifier() != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Session must contain the ID of the session to resume");
        throw null;
    }

    private void receivedServerFinished(Finished finished) throws HandshakeException {
        this.flightNumber += 2;
        DTLSFlight dTLSFlightCreateFlight = createFlight();
        MessageDigest handshakeMessageDigest = getHandshakeMessageDigest();
        try {
            MessageDigest messageDigest = (MessageDigest) handshakeMessageDigest.clone();
            finished.verifyData(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), this.masterSecret, false, handshakeMessageDigest.digest());
            wrapMessage(dTLSFlightCreateFlight, new ChangeCipherSpecMessage(finished.getPeer()));
            setCurrentWriteState();
            messageDigest.update(finished.getRawMessage());
            this.handshakeHash = messageDigest.digest();
            wrapMessage(dTLSFlightCreateFlight, new Finished(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), this.masterSecret, this.isClient, this.handshakeHash, finished.getPeer()));
            sendLastFlight(dTLSFlightCreateFlight);
            sessionEstablished();
        } catch (CloneNotSupportedException unused) {
            throw new HandshakeException("Cannot create FINISHED message hash", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, finished.getPeer()));
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ClientHandshaker, org.eclipse.californium.scandium.dtls.Handshaker
    public void doProcessMessage(HandshakeMessage handshakeMessage) throws GeneralSecurityException, HandshakeException {
        if (this.fullHandshake) {
            super.doProcessMessage(handshakeMessage);
            return;
        }
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[handshakeMessage.getMessageType().ordinal()];
        if (i == 1) {
            receivedHelloVerifyRequest((HelloVerifyRequest) handshakeMessage);
        } else if (i == 2) {
            receivedServerHello((ServerHello) handshakeMessage);
        } else {
            if (i != 3) {
                throw new HandshakeException(String.format("Received unexpected handshake message [%s] from peer %s", handshakeMessage.getMessageType(), handshakeMessage.getPeer()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNEXPECTED_MESSAGE, handshakeMessage.getPeer()));
            }
            receivedServerFinished((Finished) handshakeMessage);
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ClientHandshaker
    public void receivedServerHello(ServerHello serverHello) throws HandshakeException {
        ConnectionIdExtension connectionIdExtension;
        if (!this.session.getSessionIdentifier().equals(serverHello.getSessionId())) {
            this.LOGGER.debug("Server [{}] refuses to resume session [{}], performing full handshake instead...", serverHello.getPeer(), this.session.getSessionIdentifier());
            this.fullHandshake = true;
            this.states = ClientHandshaker.SEVER_CERTIFICATE;
            super.receivedServerHello(serverHello);
            return;
        }
        if (!serverHello.getCompressionMethod().equals(this.session.getCompressionMethod())) {
            throw new HandshakeException("Server wants to change compression method in resumed session", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, serverHello.getPeer()));
        }
        if (!serverHello.getCipherSuite().equals(this.session.getCipherSuite())) {
            throw new HandshakeException("Server wants to change cipher suite in resumed session", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, serverHello.getPeer()));
        }
        verifyServerHelloExtensions(serverHello);
        this.serverRandom = serverHello.getRandom();
        if (this.connectionIdGenerator != null && (connectionIdExtension = serverHello.getConnectionIdExtension()) != null) {
            this.session.setWriteConnectionId(connectionIdExtension.getConnectionId());
            this.session.setReadConnectionId(getReadConnectionId());
        }
        expectChangeCipherSpecMessage();
        SecretKey masterSecret = this.session.getMasterSecret();
        this.masterSecret = masterSecret;
        calculateKeys(masterSecret);
    }

    @Override // org.eclipse.californium.scandium.dtls.ClientHandshaker
    public void startHandshake() throws HandshakeException {
        handshakeStarted();
        ClientHello clientHello = new ClientHello(ProtocolVersion.VERSION_DTLS_1_2, this.session, this.supportedSignatureAlgorithms, this.supportedClientCertificateTypes, this.supportedServerCertificateTypes, this.supportedGroups);
        this.clientRandom = clientHello.getRandom();
        clientHello.addCompressionMethod(this.session.getCompressionMethod());
        addConnectionId(clientHello);
        addRecordSizeLimit(clientHello);
        addMaxFragmentLength(clientHello);
        addServerNameIndication(clientHello);
        this.clientHello = clientHello;
        this.flightNumber = 1;
        DTLSFlight dTLSFlightCreateFlight = createFlight();
        wrapMessage(dTLSFlightCreateFlight, clientHello);
        sendFlight(dTLSFlightCreateFlight);
        this.states = RESUME;
        this.statesIndex = 0;
    }
}
