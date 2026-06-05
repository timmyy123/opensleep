package org.eclipse.californium.scandium.dtls;

import java.security.MessageDigest;
import java.util.concurrent.ScheduledExecutorService;
import javax.crypto.SecretKey;
import org.eclipse.californium.scandium.config.DtlsConnectorConfig;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;

/* JADX INFO: loaded from: classes5.dex */
public class ResumingServerHandshaker extends ServerHandshaker {
    private byte[] handshakeHash;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.ResumingServerHandshaker$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType;

        static {
            int[] iArr = new int[HandshakeType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType = iArr;
            try {
                iArr[HandshakeType.CLIENT_HELLO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ResumingServerHandshaker(int i, DTLSSession dTLSSession, RecordLayer recordLayer, ScheduledExecutorService scheduledExecutorService, Connection connection, DtlsConnectorConfig dtlsConnectorConfig) {
        super(i, dTLSSession, recordLayer, scheduledExecutorService, connection, dtlsConnectorConfig);
    }

    private void receivedClientFinished(Finished finished) throws HandshakeException {
        finished.verifyData(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), this.masterSecret, true, this.handshakeHash);
        sessionEstablished();
        handshakeCompleted();
    }

    private void receivedClientHello(ClientHello clientHello) throws HandshakeException {
        handshakeStarted();
        if (!clientHello.getCipherSuites().contains(this.session.getCipherSuite())) {
            throw new HandshakeException("Client wants to change cipher suite in resumed session", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, clientHello.getPeer()));
        }
        if (!clientHello.getCompressionMethods().contains(this.session.getCompressionMethod())) {
            throw new HandshakeException("Client wants to change compression method in resumed session", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, clientHello.getPeer()));
        }
        this.clientRandom = clientHello.getRandom();
        this.serverRandom = new Random();
        CipherSuite cipherSuite = this.session.getCipherSuite();
        HelloExtensions helloExtensions = new HelloExtensions();
        negotiateCipherSuite(clientHello, helloExtensions);
        processHelloExtensions(clientHello, helloExtensions);
        this.flightNumber += 2;
        DTLSFlight dTLSFlightCreateFlight = createFlight();
        wrapMessage(dTLSFlightCreateFlight, new ServerHello(clientHello.getClientVersion(), this.serverRandom, this.session.getSessionIdentifier(), cipherSuite, this.session.getCompressionMethod(), helloExtensions, clientHello.getPeer()));
        wrapMessage(dTLSFlightCreateFlight, new ChangeCipherSpecMessage(clientHello.getPeer()));
        MessageDigest handshakeMessageDigest = getHandshakeMessageDigest();
        try {
            MessageDigest messageDigest = (MessageDigest) handshakeMessageDigest.clone();
            SecretKey masterSecret = this.session.getMasterSecret();
            this.masterSecret = masterSecret;
            calculateKeys(masterSecret);
            setCurrentWriteState();
            Finished finished = new Finished(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), this.masterSecret, false, handshakeMessageDigest.digest(), clientHello.getPeer());
            wrapMessage(dTLSFlightCreateFlight, finished);
            messageDigest.update(finished.toByteArray());
            this.handshakeHash = messageDigest.digest();
            sendFlight(dTLSFlightCreateFlight);
            this.states = ServerHandshaker.NO_CLIENT_CERTIFICATE;
            this.statesIndex = 0;
        } catch (CloneNotSupportedException unused) {
            throw new HandshakeException("Cannot create FINISHED message hash", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, clientHello.getPeer()));
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ServerHandshaker, org.eclipse.californium.scandium.dtls.Handshaker
    public void doProcessMessage(HandshakeMessage handshakeMessage) throws HandshakeException {
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[handshakeMessage.getMessageType().ordinal()];
        if (i == 1) {
            receivedClientHello((ClientHello) handshakeMessage);
            expectChangeCipherSpecMessage();
        } else {
            if (i != 2) {
                throw new HandshakeException(String.format("Received unexpected handshake message [%s] from peer %s", handshakeMessage.getMessageType(), handshakeMessage.getPeer()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNEXPECTED_MESSAGE, handshakeMessage.getPeer()));
            }
            receivedClientFinished((Finished) handshakeMessage);
        }
    }
}
