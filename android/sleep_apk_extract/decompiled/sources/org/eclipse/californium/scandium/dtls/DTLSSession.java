package org.eclipse.californium.scandium.dtls;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.net.InetSocketAddress;
import java.security.Principal;
import javax.crypto.SecretKey;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.DtlsEndpointContext;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.util.SecretUtil;
import org.eclipse.californium.scandium.util.ServerName;
import org.eclipse.californium.scandium.util.ServerNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class DTLSSession implements Destroyable {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) DTLSSession.class);
    private CipherSuite cipherSuite;
    private SecretKey clusterReadMacKey;
    private SecretKey clusterWriteMacKey;
    private CompressionMethod compressionMethod;
    private long creationTime;
    private final String handshakeTimeTag;
    private String hostName;
    private boolean markedAsclosed;
    private SecretKey masterSecret;
    private int maxFragmentLength;
    private boolean parameterAvailable;
    private InetSocketAddress peer;
    private Principal peerIdentity;
    private boolean peerSupportsSni;
    private ConnectionId readConnectionId;
    private int readEpoch;
    private int readEpochClosed;
    private long readSequenceNumberClosed;
    private DTLSConnectionState readState;
    private CertificateType receiveCertificateType;
    private volatile long receiveWindowLowerBoundary;
    private volatile long receiveWindowUpperCurrent;
    private volatile long receivedRecordsVector;
    private Integer recordSizeLimit;
    private InetSocketAddress router;
    private CertificateType sendCertificateType;
    private long[] sequenceNumbers;
    private ServerNames serverNames;
    private SessionId sessionIdentifier;
    private SignatureAndHashAlgorithm signatureAndHashAlgorithm;
    private ConnectionId writeConnectionId;
    private int writeEpoch;
    private DTLSConnectionState writeState;

    public DTLSSession(InetSocketAddress inetSocketAddress, long j, long j2) {
        this.maxFragmentLength = 16384;
        this.cipherSuite = CipherSuite.TLS_NULL_WITH_NULL_NULL;
        this.compressionMethod = CompressionMethod.NULL;
        this.masterSecret = null;
        this.writeConnectionId = null;
        this.readConnectionId = null;
        DTLSConnectionState dTLSConnectionState = DTLSConnectionState.NULL;
        this.readState = dTLSConnectionState;
        this.writeState = dTLSConnectionState;
        this.clusterWriteMacKey = null;
        this.clusterReadMacKey = null;
        this.readEpoch = 0;
        this.writeEpoch = 0;
        this.sequenceNumbers = new long[2];
        CertificateType certificateType = CertificateType.X_509;
        this.sendCertificateType = certificateType;
        this.receiveCertificateType = certificateType;
        this.parameterAvailable = false;
        this.receiveWindowUpperCurrent = -1L;
        this.receiveWindowLowerBoundary = 0L;
        this.receivedRecordsVector = 0L;
        if (inetSocketAddress == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Peer address must not be null");
            throw null;
        }
        if (j < 0 || j > 281474976710655L) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Initial sequence number must be greater than 0 and less than 2^48");
            throw null;
        }
        this.creationTime = j2;
        this.handshakeTimeTag = Long.toString(System.currentTimeMillis());
        this.peer = inetSocketAddress;
        this.sequenceNumbers[0] = j;
    }

    private DtlsEndpointContext getConnectionContext(String str) {
        String string;
        if (this.sessionIdentifier.isEmpty()) {
            string = "TIME:" + Long.toString(this.creationTime);
        } else {
            string = this.sessionIdentifier.toString();
        }
        String str2 = string;
        if (this.writeConnectionId == null || this.readConnectionId == null) {
            return new DtlsEndpointContext(this.peer, this.hostName, this.peerIdentity, str2, str, this.cipherSuite.name(), this.handshakeTimeTag);
        }
        InetSocketAddress inetSocketAddress = this.router;
        InetSocketAddress inetSocketAddress2 = this.peer;
        return inetSocketAddress != null ? new DtlsEndpointContext(inetSocketAddress2, this.hostName, this.peerIdentity, str2, str, this.cipherSuite.name(), this.handshakeTimeTag, this.writeConnectionId.getAsString(), this.readConnectionId.getAsString(), "dtls-cid-router") : new DtlsEndpointContext(inetSocketAddress2, this.hostName, this.peerIdentity, str2, str, this.cipherSuite.name(), this.handshakeTimeTag, this.writeConnectionId.getAsString(), this.readConnectionId.getAsString(), null);
    }

    private void incrementReadEpoch() {
        resetReceiveWindow();
        this.readEpoch++;
    }

    private void incrementWriteEpoch() {
        int i = this.writeEpoch + 1;
        this.writeEpoch = i;
        this.sequenceNumbers[i] = 0;
    }

    private void resetReceiveWindow() {
        this.receivedRecordsVector = 0L;
        this.receiveWindowUpperCurrent = -1L;
        this.receiveWindowLowerBoundary = 0L;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() throws DestroyFailedException {
        SecretUtil.destroy(this.masterSecret);
        this.masterSecret = null;
        SecretUtil.destroy(this.clusterWriteMacKey);
        this.clusterWriteMacKey = null;
        SecretUtil.destroy(this.clusterReadMacKey);
        this.clusterReadMacKey = null;
        DTLSConnectionState dTLSConnectionState = this.readState;
        DTLSConnectionState dTLSConnectionState2 = DTLSConnectionState.NULL;
        if (dTLSConnectionState != dTLSConnectionState2) {
            dTLSConnectionState.destroy();
            this.readState = dTLSConnectionState2;
        }
        DTLSConnectionState dTLSConnectionState3 = this.writeState;
        if (dTLSConnectionState3 != dTLSConnectionState2) {
            dTLSConnectionState3.destroy();
            this.writeState = dTLSConnectionState2;
        }
    }

    public CipherSuite getCipherSuite() {
        return this.cipherSuite;
    }

    public CompressionMethod getCompressionMethod() {
        return this.compressionMethod;
    }

    public DtlsEndpointContext getConnectionReadContext() {
        return getConnectionContext(Integer.toString(this.readEpoch));
    }

    public DtlsEndpointContext getConnectionWriteContext() {
        return getConnectionContext(Integer.toString(this.writeEpoch));
    }

    public int getEffectiveFragmentLimit() {
        Integer num = this.recordSizeLimit;
        return num != null ? num.intValue() : this.maxFragmentLength;
    }

    public String getHostName() {
        return this.hostName;
    }

    public final CipherSuite.KeyExchangeAlgorithm getKeyExchange() {
        CipherSuite cipherSuite = this.cipherSuite;
        if (cipherSuite != null) {
            return cipherSuite.getKeyExchange();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Cipher suite has not been set (yet)");
        return null;
    }

    public SecretKey getMasterSecret() {
        return SecretUtil.create(this.masterSecret);
    }

    public int getMaxCiphertextExpansion() {
        CipherSuite cipherSuite = this.cipherSuite;
        if (cipherSuite != null) {
            return cipherSuite.getMaxCiphertextExpansion();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Missing cipher suite.");
        return 0;
    }

    public int getMaxFragmentLength() {
        return this.maxFragmentLength;
    }

    public HandshakeParameter getParameter() {
        if (this.parameterAvailable) {
            return new HandshakeParameter(this.cipherSuite.getKeyExchange(), this.receiveCertificateType);
        }
        return null;
    }

    public InetSocketAddress getPeer() {
        return this.peer;
    }

    public Principal getPeerIdentity() {
        return this.peerIdentity;
    }

    public ConnectionId getReadConnectionId() {
        return this.readConnectionId;
    }

    public int getReadEpoch() {
        return this.readEpoch;
    }

    public DTLSConnectionState getReadState() {
        return this.readState;
    }

    public InetSocketAddress getRouter() {
        return this.router;
    }

    public long getSequenceNumber(int i) {
        long[] jArr = this.sequenceNumbers;
        long j = jArr[i];
        if (j < 281474976710655L) {
            jArr[i] = 1 + j;
            return j;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Maximum sequence number for epoch has been reached");
        return 0L;
    }

    public ServerNames getServerNames() {
        return this.serverNames;
    }

    public SessionId getSessionIdentifier() {
        return this.sessionIdentifier;
    }

    public SessionTicket getSessionTicket() {
        DTLSConnectionState writeState = getWriteState();
        if (!writeState.hasValidCipherSuite()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("session has no valid crypto params, not fully negotiated yet?");
            return null;
        }
        if (this.sessionIdentifier.isEmpty()) {
            return null;
        }
        return new SessionTicket(ProtocolVersion.VERSION_DTLS_1_2, writeState.getCipherSuite(), writeState.getCompressionMethod(), this.masterSecret, getServerNames(), getPeerIdentity(), this.creationTime);
    }

    public SignatureAndHashAlgorithm getSignatureAndHashAlgorithm() {
        return this.signatureAndHashAlgorithm;
    }

    public ConnectionId getWriteConnectionId() {
        return this.writeConnectionId;
    }

    public int getWriteEpoch() {
        return this.writeEpoch;
    }

    public DTLSConnectionState getWriteState(int i) {
        return i == 0 ? DTLSConnectionState.NULL : this.writeState;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return SecretUtil.isDestroyed(this.masterSecret) && SecretUtil.isDestroyed(this.readState) && SecretUtil.isDestroyed(this.writeState);
    }

    public boolean isDuplicate(long j) {
        if (j > this.receiveWindowUpperCurrent) {
            return false;
        }
        long j2 = 1 << ((int) (j - this.receiveWindowLowerBoundary));
        Logger logger = LOGGER;
        if (logger.isDebugEnabled()) {
            logger.debug("Checking sequence no [{}] using bit mask [{}] against received records [{}] with lower boundary [{}]", Long.valueOf(j), Long.toBinaryString(j2), Long.toBinaryString(this.receivedRecordsVector), Long.valueOf(this.receiveWindowLowerBoundary));
        }
        return (this.receivedRecordsVector & j2) == j2;
    }

    public boolean isMarkedAsClosed() {
        return this.markedAsclosed;
    }

    public boolean isRecordProcessable(long j, long j2, int i) {
        if (j < getReadEpoch() || j > getReadEpoch()) {
            return false;
        }
        if (j2 < this.receiveWindowLowerBoundary) {
            return i < 0 || j2 > this.receiveWindowLowerBoundary - ((long) i);
        }
        if (this.markedAsclosed) {
            int i2 = this.readEpochClosed;
            if (j > i2) {
                return false;
            }
            if (j == i2 && j2 >= this.readSequenceNumberClosed) {
                return false;
            }
        }
        return !isDuplicate(j2);
    }

    public boolean isSniSupported() {
        return this.peerSupportsSni;
    }

    public void markCloseNotiy(int i, long j) {
        this.markedAsclosed = true;
        this.readEpochClosed = i;
        this.readSequenceNumberClosed = j;
    }

    public boolean markRecordAsRead(long j, long j2) {
        if (j != getReadEpoch()) {
            return j > ((long) getReadEpoch());
        }
        boolean z = j2 > this.receiveWindowUpperCurrent;
        if (z) {
            this.receiveWindowUpperCurrent = j2;
            long jMax = Math.max(0L, j2 - 63);
            long j3 = jMax - this.receiveWindowLowerBoundary;
            if (j3 > 0) {
                this.receivedRecordsVector >>>= (int) j3;
                this.receiveWindowLowerBoundary = jMax;
            }
        }
        this.receivedRecordsVector = (1 << ((int) (j2 - this.receiveWindowLowerBoundary))) | this.receivedRecordsVector;
        LOGGER.debug("Updated receive window with sequence number [{}]: new upper boundary [{}], new bit vector [{}]", Long.valueOf(j2), Long.valueOf(this.receiveWindowUpperCurrent), Long.toBinaryString(this.receivedRecordsVector));
        return z;
    }

    public CertificateType receiveCertificateType() {
        return this.receiveCertificateType;
    }

    public CertificateType sendCertificateType() {
        return this.sendCertificateType;
    }

    public void setCipherSuite(CipherSuite cipherSuite) {
        if (cipherSuite == null || CipherSuite.TLS_NULL_WITH_NULL_NULL == cipherSuite) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Negotiated cipher suite must not be null");
        } else {
            this.cipherSuite = cipherSuite;
        }
    }

    public void setClusterMacKeys(SecretKey secretKey, SecretKey secretKey2) {
        this.clusterWriteMacKey = SecretUtil.create(secretKey);
        this.clusterReadMacKey = SecretUtil.create(secretKey2);
    }

    public void setCompressionMethod(CompressionMethod compressionMethod) {
        this.compressionMethod = compressionMethod;
    }

    public void setHostName(String str) {
        this.serverNames = null;
        this.hostName = str;
        if (str != null) {
            this.serverNames = ServerNames.newInstance(ServerName.from(ServerName.NameType.HOST_NAME, str.getBytes(ServerName.CHARSET)));
        }
    }

    public void setMasterSecret(SecretKey secretKey) {
        if (this.masterSecret != null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("master secret already available!");
            return;
        }
        if (!this.sessionIdentifier.isEmpty()) {
            if (secretKey == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("Master secret must not be null");
                return;
            }
            byte[] encoded = secretKey.getEncoded();
            Bytes.clear(encoded);
            if (encoded.length != 48) {
                Home$$ExternalSyntheticBUOutline0.m("Master secret must consist of of exactly %d bytes but has %d bytes", new Object[]{48, Integer.valueOf(encoded.length)});
                return;
            }
            this.masterSecret = SecretUtil.create(secretKey);
        }
        this.creationTime = System.currentTimeMillis();
    }

    public void setMaxFragmentLength(int i) {
        if (i < 0 || i > 16384) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Max. fragment length must be in range [0...16384]");
        } else {
            this.maxFragmentLength = i;
        }
    }

    public void setParameterAvailable() {
        this.parameterAvailable = true;
    }

    public void setPeer(InetSocketAddress inetSocketAddress) {
        this.peer = inetSocketAddress;
    }

    public void setPeerIdentity(Principal principal) {
        if (principal != null) {
            this.peerIdentity = principal;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("Peer identity must not be null");
        }
    }

    public void setReadConnectionId(ConnectionId connectionId) {
        this.readConnectionId = connectionId;
    }

    public void setReadState(DTLSConnectionState dTLSConnectionState) {
        if (dTLSConnectionState == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Read state must not be null");
            return;
        }
        SecretUtil.destroy(this.readState);
        this.readState = dTLSConnectionState;
        incrementReadEpoch();
        LOGGER.trace("Setting current read state to{}{}", StringUtil.lineSeparator(), dTLSConnectionState);
    }

    public void setReceiveCertificateType(CertificateType certificateType) {
        this.receiveCertificateType = certificateType;
    }

    public void setRecordSizeLimit(int i) {
        this.recordSizeLimit = Integer.valueOf(RecordSizeLimitExtension.ensureInRange(i));
    }

    public void setRouter(InetSocketAddress inetSocketAddress) {
        this.router = inetSocketAddress;
    }

    public void setSendCertificateType(CertificateType certificateType) {
        this.sendCertificateType = certificateType;
    }

    public void setServerNames(ServerNames serverNames) {
        ServerName serverName;
        this.hostName = null;
        this.serverNames = serverNames;
        if (serverNames == null || (serverName = serverNames.getServerName(ServerName.NameType.HOST_NAME)) == null) {
            return;
        }
        this.hostName = serverName.getNameAsString();
    }

    public void setSessionIdentifier(SessionId sessionId) {
        if (sessionId == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("session identifier must not be null!");
            return;
        }
        if (sessionId.equals(this.sessionIdentifier)) {
            return;
        }
        SecretUtil.destroy(this.masterSecret);
        this.masterSecret = null;
        SecretUtil.destroy(this.clusterWriteMacKey);
        this.clusterWriteMacKey = null;
        SecretUtil.destroy(this.clusterReadMacKey);
        this.clusterReadMacKey = null;
        this.sessionIdentifier = sessionId;
    }

    public void setSignatureAndHashAlgorithm(SignatureAndHashAlgorithm signatureAndHashAlgorithm) {
        this.signatureAndHashAlgorithm = signatureAndHashAlgorithm;
    }

    public void setSniSupported(boolean z) {
        this.peerSupportsSni = z;
    }

    public void setWriteConnectionId(ConnectionId connectionId) {
        this.writeConnectionId = connectionId;
    }

    public void setWriteState(DTLSConnectionState dTLSConnectionState) {
        if (dTLSConnectionState == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Write state must not be null");
            return;
        }
        SecretUtil.destroy(this.writeState);
        this.writeState = dTLSConnectionState;
        incrementWriteEpoch();
        LOGGER.trace("Setting current write state to{}{}", StringUtil.lineSeparator(), dTLSConnectionState);
    }

    public DTLSConnectionState getWriteState() {
        return getWriteState(this.writeEpoch);
    }

    public long getSequenceNumber() {
        return getSequenceNumber(this.writeEpoch);
    }

    public DTLSSession(SessionId sessionId, InetSocketAddress inetSocketAddress, SessionTicket sessionTicket, long j) {
        this(inetSocketAddress, j, sessionTicket.getTimestamp());
        this.sessionIdentifier = sessionId;
        this.masterSecret = SecretUtil.create(sessionTicket.getMasterSecret());
        this.peerIdentity = sessionTicket.getClientIdentity();
        this.cipherSuite = sessionTicket.getCipherSuite();
        this.serverNames = sessionTicket.getServerNames();
        this.compressionMethod = sessionTicket.getCompressionMethod();
    }

    public DTLSSession(InetSocketAddress inetSocketAddress, long j) {
        this(inetSocketAddress, j, System.currentTimeMillis());
    }

    public DTLSSession(InetSocketAddress inetSocketAddress) {
        this(inetSocketAddress, 0L, System.currentTimeMillis());
    }
}
