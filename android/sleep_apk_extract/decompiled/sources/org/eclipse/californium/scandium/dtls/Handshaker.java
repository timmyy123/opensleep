package org.eclipse.californium.scandium.dtls;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.security.auth.Destroyable;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.RawData;
import org.eclipse.californium.elements.auth.AdditionalInfo;
import org.eclipse.californium.elements.auth.ExtensiblePrincipal;
import org.eclipse.californium.elements.auth.PreSharedKeyIdentity;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.ClockUtil;
import org.eclipse.californium.elements.util.SerialExecutor;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.config.DtlsConnectorConfig;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.cipher.PseudoRandomFunction;
import org.eclipse.californium.scandium.dtls.pskstore.AdvancedPskStore;
import org.eclipse.californium.scandium.dtls.x509.NewAdvancedCertificateVerifier;
import org.eclipse.californium.scandium.util.SecretIvParameterSpec;
import org.eclipse.californium.scandium.util.SecretUtil;
import org.eclipse.californium.scandium.util.ServerNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Handshaker implements Destroyable {
    protected final AdvancedPskStore advancedPskStore;
    private final int backOffRetransmission;
    private Throwable cause;
    protected final List<X509Certificate> certificateChain;
    protected boolean certificateVerfied;
    protected final NewAdvancedCertificateVerifier certificateVerifier;
    protected Random clientRandom;
    private SecretIvParameterSpec clientWriteIV;
    private SecretKey clientWriteKey;
    private SecretKey clientWriteMACKey;
    private final Connection connection;
    protected final ConnectionIdGenerator connectionIdGenerator;
    private Object customArgument;
    private int deferredRecordsSize;
    private boolean destroyed;
    private long flightSendNanos;
    private volatile boolean generateClusterMacKeys;
    private InboundMessageBuffer inboundMessageBuffer;
    private final boolean ipv6;
    protected final boolean isClient;
    private boolean lastFlight;
    protected SecretKey masterSecret;
    private final int maxDeferredProcessedIncomingRecordsSize;
    private final int maxDeferredProcessedOutgoingApplicationDataMessages;
    private final int maxFragmentedHandshakeMessageLength;
    private final int maxRetransmissions;
    private long nanosExpireTime;
    private final long nanosExpireTimeout;
    private int nextReceiveMessageSequence;
    private SecretKey otherSecret;
    protected CertPath peerCertPath;
    protected final PrivateKey privateKey;
    protected final PublicKey publicKey;
    protected ReassemblingHandshakeMessage reassembledMessage;
    private final RecordLayer recordLayer;
    protected Integer recordSizeLimit;
    private final int retransmissionTimeout;
    private Runnable retransmitFlight;
    private int sendMessageSequence;
    protected Random serverRandom;
    private SecretIvParameterSpec serverWriteIV;
    private SecretKey serverWriteKey;
    private SecretKey serverWriteMACKey;
    protected final DTLSSession session;
    protected boolean sniEnabled;
    protected HandshakeState[] states;
    protected int statesIndex;
    private final ScheduledExecutorService timer;
    private final boolean useEarlyStopRetransmission;
    protected final boolean useKeyUsageVerification;
    private Boolean useMultiHandshakeMessagesRecord;
    private Boolean useMultiRecordMessages;
    protected boolean useStateValidation;
    protected final boolean useTruncatedCertificatePathForVerification;
    protected ProtocolVersion usedProtocol;
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final ReentrantLock recursionProtection = new ReentrantLock();
    protected int flightNumber = 0;
    private final List<RawData> deferredApplicationData = new ArrayList();
    private final List<Record> deferredRecords = new ArrayList();
    private final AtomicReference<DTLSFlight> pendingFlight = new AtomicReference<>();
    protected final List<HandshakeMessage> handshakeMessages = new ArrayList();
    private final Set<SessionListener> sessionListeners = new LinkedHashSet();
    private boolean changeCipherSuiteMessageExpected = false;
    private boolean sessionEstablished = false;
    private boolean handshakeAborted = false;
    private boolean handshakeFailed = false;
    private boolean pskRequestPending = false;
    private boolean certificateVerificationPending = false;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.Handshaker$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType;

        static {
            int[] iArr = new int[ContentType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType = iArr;
            try {
                iArr[ContentType.CHANGE_CIPHER_SPEC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[ContentType.HANDSHAKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public class ConnectionTask implements Runnable {
        private final boolean force;
        private final Runnable task;

        private ConnectionTask(Runnable runnable, boolean z) {
            this.task = runnable;
            this.force = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Handshaker.this.connection.getExecutor().execute(this.task);
            } catch (RejectedExecutionException e) {
                Handshaker handshaker = Handshaker.this;
                handshaker.LOGGER.debug("Execution rejected while execute task of peer: {}", handshaker.connection.getPeerAddress(), e);
                if (this.force) {
                    this.task.run();
                }
            }
        }
    }

    public class TimeoutPeerTask extends ConnectionTask {
        private TimeoutPeerTask(final DTLSFlight dTLSFlight) {
            super(new Runnable() { // from class: org.eclipse.californium.scandium.dtls.Handshaker.TimeoutPeerTask.1
                @Override // java.lang.Runnable
                public void run() {
                    handshaker.handleTimeout(dTLSFlight);
                }
            }, true);
        }
    }

    public Handshaker(boolean z, int i, DTLSSession dTLSSession, RecordLayer recordLayer, ScheduledExecutorService scheduledExecutorService, Connection connection, DtlsConnectorConfig dtlsConnectorConfig) {
        this.sendMessageSequence = 0;
        this.nextReceiveMessageSequence = 0;
        if (dTLSSession == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("DTLS Session must not be null");
            throw null;
        }
        if (recordLayer == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Record layer must not be null");
            throw null;
        }
        if (scheduledExecutorService == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Timer must not be null");
            throw null;
        }
        if (connection == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Connection must not be null");
            throw null;
        }
        if (dtlsConnectorConfig == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Dtls Connector Config must not be null");
            throw null;
        }
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Initial message sequence number must not be negative");
            throw null;
        }
        this.isClient = z;
        this.sendMessageSequence = i;
        this.nextReceiveMessageSequence = i;
        this.session = dTLSSession;
        this.recordLayer = recordLayer;
        this.timer = scheduledExecutorService;
        this.connection = connection;
        this.connectionIdGenerator = dtlsConnectorConfig.getConnectionIdGenerator();
        int iIntValue = dtlsConnectorConfig.getRetransmissionTimeout().intValue();
        this.retransmissionTimeout = iIntValue;
        this.backOffRetransmission = dtlsConnectorConfig.getBackOffRetransmission().intValue();
        this.maxRetransmissions = dtlsConnectorConfig.getMaxRetransmissions().intValue();
        this.recordSizeLimit = dtlsConnectorConfig.getRecordSizeLimit();
        this.maxFragmentedHandshakeMessageLength = dtlsConnectorConfig.getMaxFragmentedHandshakeMessageLength().intValue();
        this.useMultiRecordMessages = dtlsConnectorConfig.useMultiRecordMessages();
        this.useMultiHandshakeMessagesRecord = dtlsConnectorConfig.useMultiHandshakeMessageRecords();
        this.maxDeferredProcessedOutgoingApplicationDataMessages = dtlsConnectorConfig.getMaxDeferredProcessedOutgoingApplicationDataMessages().intValue();
        this.maxDeferredProcessedIncomingRecordsSize = dtlsConnectorConfig.getMaxDeferredProcessedIncomingRecordsSize().intValue();
        this.sniEnabled = dtlsConnectorConfig.isSniEnabled().booleanValue();
        this.useStateValidation = dtlsConnectorConfig.useHandshakeStateValidation().booleanValue();
        this.useKeyUsageVerification = dtlsConnectorConfig.useKeyUsageVerification().booleanValue();
        this.useTruncatedCertificatePathForVerification = dtlsConnectorConfig.useTruncatedCertificatePathForValidation().booleanValue();
        this.useEarlyStopRetransmission = dtlsConnectorConfig.isEarlyStopRetransmission().booleanValue();
        this.privateKey = dtlsConnectorConfig.getPrivateKey();
        this.publicKey = dtlsConnectorConfig.getPublicKey();
        this.certificateChain = dtlsConnectorConfig.getCertificateChain();
        this.certificateVerifier = dtlsConnectorConfig.getAdvancedCertificateVerifier();
        this.advancedPskStore = dtlsConnectorConfig.getAdvancedPskStore();
        dtlsConnectorConfig.getApplicationLevelInfoSupplier();
        this.inboundMessageBuffer = new InboundMessageBuffer();
        this.ipv6 = connection.getPeerAddress().getAddress() instanceof Inet6Address;
        int i2 = iIntValue * 2;
        for (int i3 = 0; i3 < this.maxRetransmissions; i3++) {
            iIntValue = DTLSFlight.incrementTimeout(iIntValue);
            i2 += iIntValue;
        }
        this.nanosExpireTimeout = TimeUnit.MILLISECONDS.toNanos(i2);
        addSessionListener(connection.getSessionListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean addDeferredProcessedRecord(Record record, Collection<Record> collection) {
        int size = record.size();
        int i = this.deferredRecordsSize;
        if (i + size < this.maxDeferredProcessedIncomingRecordsSize) {
            this.deferredRecordsSize = i + size;
            collection.add(record);
            return true;
        }
        this.LOGGER.debug("Dropped incoming record from peer [{}], limit of {} bytes exceeded by {}+{} bytes!", record.getPeerAddress(), Integer.valueOf(this.maxDeferredProcessedIncomingRecordsSize), Integer.valueOf(this.deferredRecordsSize), Integer.valueOf(size));
        this.recordLayer.dropReceivedRecord(record);
        return false;
    }

    private void amendPeerPrincipal() {
        Principal peerIdentity = this.session.getPeerIdentity();
        if (peerIdentity instanceof ExtensiblePrincipal) {
            this.session.setPeerIdentity(((ExtensiblePrincipal) peerIdentity).amend(getAdditionalPeerInfo(peerIdentity)));
        }
    }

    private void applySendMessageSequenceNumber(HandshakeMessage handshakeMessage) {
        handshakeMessage.setMessageSeq(this.sendMessageSequence);
        this.sendMessageSequence++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareRecords(Record record, Record record2) {
        if (record.getEpoch() != record2.getEpoch()) {
            FacebookSdk$$ExternalSyntheticLambda1.m("records with different epoch! ", record.getEpoch(), " != ", record2.getEpoch());
            return 0;
        }
        HandshakeMessage handshakeMessage = (HandshakeMessage) record.getFragment();
        HandshakeMessage handshakeMessage2 = (HandshakeMessage) record2.getFragment();
        if (handshakeMessage.getMessageSeq() < handshakeMessage2.getMessageSeq()) {
            return -1;
        }
        if (handshakeMessage.getMessageSeq() > handshakeMessage2.getMessageSeq()) {
            return 1;
        }
        if (record.getSequenceNumber() < record2.getSequenceNumber()) {
            return -1;
        }
        return record.getSequenceNumber() > record2.getSequenceNumber() ? 1 : 0;
    }

    private AdditionalInfo getAdditionalPeerInfo(Principal principal) {
        return AdditionalInfo.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleTimeout(DTLSFlight dTLSFlight) {
        Handshaker ongoingHandshake;
        DTLSFlight dTLSFlight2;
        String str;
        String str2;
        Throwable th;
        String strM;
        int maxDatagramSize;
        List<DatagramPacket> datagrams;
        if (dTLSFlight.isResponseCompleted() || (ongoingHandshake = this.connection.getOngoingHandshake()) == null) {
            return;
        }
        if (!ongoingHandshake.isProbing() && this.connection.hasEstablishedSession()) {
            return;
        }
        InetSocketAddress peer = this.session.getPeer();
        boolean z = false;
        Throwable th2 = null;
        if (this.connection.isExecuting() && this.recordLayer.isRunning()) {
            int tries = dTLSFlight.getTries();
            if (tries >= this.maxRetransmissions || !ongoingHandshake.isExpired()) {
                int i = this.maxRetransmissions;
                if (tries >= i) {
                    dTLSFlight2 = dTLSFlight;
                    Logger logger = this.LOGGER;
                    if (tries > i) {
                        logger.debug("Flight for [{}] has reached timeout, discarding ...", peer);
                        strM = " Stopped by timeout!";
                    } else {
                        logger.debug("Flight for [{}] has reached maximum no. [{}] of retransmissions, discarding ...", peer, Integer.valueOf(i));
                        strM = FileInsert$$ExternalSyntheticOutline0.m(this.maxRetransmissions, " retransmissions!", new StringBuilder(" Stopped by timeout after "));
                    }
                    str2 = strM;
                } else {
                    if (this.useEarlyStopRetransmission && dTLSFlight.isResponseStarted()) {
                        while (tries < this.maxRetransmissions) {
                            tries++;
                            dTLSFlight.incrementTries();
                            dTLSFlight.incrementTimeout();
                        }
                        dTLSFlight.incrementTries();
                        this.LOGGER.trace("schedule handshake timeout {}ms after flight {}", Integer.valueOf(dTLSFlight.getTimeout()), Integer.valueOf(dTLSFlight.getFlightNumber()));
                        Runnable runnable = this.retransmitFlight;
                        if (runnable != null) {
                            dTLSFlight.scheduleRetransmission(this.timer, runnable);
                            return;
                        }
                        return;
                    }
                    this.LOGGER.trace("Re-transmitting flight for [{}], [{}] retransmissions left", this.session.getPeer(), Integer.valueOf((this.maxRetransmissions - tries) - 1));
                    try {
                        dTLSFlight.incrementTries();
                        dTLSFlight.incrementTimeout();
                        maxDatagramSize = this.recordLayer.getMaxDatagramSize(this.ipv6);
                        int effectiveFragmentLimit = this.session.getEffectiveFragmentLimit();
                        int i2 = this.backOffRetransmission;
                        datagrams = dTLSFlight.getDatagrams(maxDatagramSize, effectiveFragmentLimit, this.useMultiHandshakeMessagesRecord, this.useMultiRecordMessages, i2 > 0 && tries + 1 > i2);
                        dTLSFlight2 = dTLSFlight;
                    } catch (IOException e) {
                        e = e;
                        dTLSFlight2 = dTLSFlight;
                    } catch (HandshakeException e2) {
                        e = e2;
                        dTLSFlight2 = dTLSFlight;
                    }
                    try {
                        this.LOGGER.debug("Resending flight {} of {} message(s) to peer [{}] using {} datagram(s) of max. {} bytes. Retransmission {} of {}.", Integer.valueOf(dTLSFlight2.getFlightNumber()), Integer.valueOf(dTLSFlight2.getNumberOfMessages()), peer, Integer.valueOf(datagrams.size()), Integer.valueOf(maxDatagramSize), Integer.valueOf(tries + 1), Integer.valueOf(this.maxRetransmissions));
                        this.recordLayer.sendFlight(datagrams);
                        Runnable runnable2 = this.retransmitFlight;
                        if (runnable2 != null) {
                            dTLSFlight2.scheduleRetransmission(this.timer, runnable2);
                        }
                        ongoingHandshake.handshakeFlightRetransmitted(dTLSFlight2.getFlightNumber());
                        return;
                    } catch (IOException e3) {
                        e = e3;
                        th2 = e;
                        str = " " + th2.getMessage();
                        this.LOGGER.warn("Cannot retransmit flight to peer [{}]", peer, th2);
                        str2 = str;
                        th = th2;
                        this.LOGGER.debug("Flight {} of {} message(s) to peer [{}] failed, {}. Retransmission {} of {}.", Integer.valueOf(dTLSFlight2.getFlightNumber()), Integer.valueOf(dTLSFlight2.getNumberOfMessages()), peer, str2, Integer.valueOf(dTLSFlight2.getTries()), Integer.valueOf(this.maxRetransmissions));
                        if (z) {
                        }
                    } catch (HandshakeException e4) {
                        e = e4;
                        th2 = e;
                        this.LOGGER.warn("Cannot retransmit flight to peer [{}]", peer, th2);
                        str = " " + th2.getMessage();
                        str2 = str;
                        th = th2;
                        this.LOGGER.debug("Flight {} of {} message(s) to peer [{}] failed, {}. Retransmission {} of {}.", Integer.valueOf(dTLSFlight2.getFlightNumber()), Integer.valueOf(dTLSFlight2.getNumberOfMessages()), peer, str2, Integer.valueOf(dTLSFlight2.getTries()), Integer.valueOf(this.maxRetransmissions));
                        if (z) {
                        }
                    }
                }
            } else {
                str2 = " Stopped by expired realtime!";
                dTLSFlight2 = dTLSFlight;
            }
            th = null;
            z = true;
            this.LOGGER.debug("Flight {} of {} message(s) to peer [{}] failed, {}. Retransmission {} of {}.", Integer.valueOf(dTLSFlight2.getFlightNumber()), Integer.valueOf(dTLSFlight2.getNumberOfMessages()), peer, str2, Integer.valueOf(dTLSFlight2.getTries()), Integer.valueOf(this.maxRetransmissions));
            if (z) {
                ongoingHandshake.handshakeFailed(new DtlsException("Handshake flight " + dTLSFlight2.getFlightNumber() + " failed!" + str2, peer, th));
                return;
            }
            ongoingHandshake.handshakeFailed(new DtlsHandshakeTimeoutException("Handshake flight " + dTLSFlight2.getFlightNumber() + " failed!" + str2, peer, dTLSFlight2.getFlightNumber()));
            return;
        }
        dTLSFlight2 = dTLSFlight;
        str = " Stopped by shutdown!";
        str2 = str;
        th = th2;
        this.LOGGER.debug("Flight {} of {} message(s) to peer [{}] failed, {}. Retransmission {} of {}.", Integer.valueOf(dTLSFlight2.getFlightNumber()), Integer.valueOf(dTLSFlight2.getNumberOfMessages()), peer, str2, Integer.valueOf(dTLSFlight2.getTries()), Integer.valueOf(this.maxRetransmissions));
        if (z) {
        }
    }

    private boolean processNextHandshakeMessages(int i, int i2, HandshakeMessage handshakeMessage) throws HandshakeException {
        if (this.recursionProtection.isHeldByCurrentThread()) {
            this.LOGGER.warn("Called from doProcessMessage, return immediately to process next message!", new Throwable("recursion-protection"));
            return false;
        }
        DTLSFlight dTLSFlight = this.pendingFlight.get();
        if (dTLSFlight != null) {
            this.LOGGER.debug("response for flight {} started", Integer.valueOf(dTLSFlight.getFlightNumber()));
            dTLSFlight.setResponseStarted();
        }
        while (handshakeMessage != null) {
            expectMessage(handshakeMessage);
            if (handshakeMessage.getMessageType() != HandshakeType.FINISHED || i != 0) {
                if ((handshakeMessage instanceof FragmentedHandshakeMessage) && (handshakeMessage = reassembleFragment((FragmentedHandshakeMessage) handshakeMessage)) == null) {
                    break;
                }
                if (handshakeMessage instanceof GenericHandshakeMessage) {
                    handshakeMessage = HandshakeMessage.fromGenericHandshakeMessage((GenericHandshakeMessage) handshakeMessage, this.session.getParameter());
                }
                if (this.lastFlight) {
                    if (dTLSFlight != null) {
                        this.LOGGER.debug("Received ({}) FINISHED message again, retransmitting last flight...", getPeerAddress());
                        dTLSFlight.incrementTries();
                        sendFlight(dTLSFlight);
                        return false;
                    }
                    Throwable th = this.cause;
                    if (th != null) {
                        this.LOGGER.error("last flight missing, handshake already failed! {}", handshakeMessage, th);
                    } else {
                        Logger logger = this.LOGGER;
                        if (i2 == 0) {
                            logger.error("last flight missing, resend failed! {}", handshakeMessage);
                        } else {
                            logger.error("last flight missing, resend for buffered message {} failed! {}", Integer.valueOf(i2), handshakeMessage);
                        }
                    }
                    return false;
                }
                if (this.LOGGER.isDebugEnabled()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.format("Processing %s message from peer [%s], seqn: [%d]", handshakeMessage.getMessageType(), handshakeMessage.getPeer(), Integer.valueOf(handshakeMessage.getMessageSeq())));
                    if (this.LOGGER.isTraceEnabled()) {
                        sb.append(":");
                        sb.append(StringUtil.lineSeparator());
                        sb.append(handshakeMessage);
                    }
                    this.LOGGER.debug(sb.toString());
                }
                if (i == 0) {
                    this.handshakeMessages.add(handshakeMessage);
                }
                this.recursionProtection.lock();
                try {
                    doProcessMessage(handshakeMessage);
                    this.recursionProtection.unlock();
                    this.LOGGER.debug("Processed {} message from peer [{}]", handshakeMessage.getMessageType(), handshakeMessage.getPeer());
                    if (!this.lastFlight) {
                        this.nextReceiveMessageSequence++;
                        this.statesIndex++;
                    }
                    handshakeMessage = handshakeMessage.getNextHandshakeMessage();
                    if (this.useMultiHandshakeMessagesRecord == null && handshakeMessage != null) {
                        this.useMultiHandshakeMessagesRecord = Boolean.TRUE;
                    }
                } catch (Throwable th2) {
                    this.recursionProtection.unlock();
                    throw th2;
                }
            } else {
                this.LOGGER.debug("FINISH with epoch 0 from peer [{}]!", getSession().getPeer());
                throw new HandshakeException("FINISH with epoch 0!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNEXPECTED_MESSAGE, getSession().getPeer()));
            }
        }
        return true;
    }

    private void processNextMessages(Record record) throws HandshakeException {
        if (this.recursionProtection.isHeldByCurrentThread()) {
            this.LOGGER.warn("Called from doProcessMessage, return immediately to process next message!", new Throwable("recursion-protection"));
            return;
        }
        try {
            int readEpoch = this.session.getReadEpoch();
            Record nextRecord = record != null ? record : this.inboundMessageBuffer.getNextRecord();
            int i = 0;
            while (nextRecord != null) {
                if (this.useMultiRecordMessages == null && nextRecord.isFollowUpRecord()) {
                    this.useMultiRecordMessages = Boolean.TRUE;
                }
                DTLSMessage fragment = nextRecord.getFragment();
                if (fragment.getContentType() != ContentType.CHANGE_CIPHER_SPEC) {
                    if (fragment.getContentType() != ContentType.HANDSHAKE) {
                        throw new HandshakeException(String.format("Received unexpected message [%s] from peer %s", fragment.getContentType(), fragment.getPeer()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, fragment.getPeer()));
                    }
                    if (!processNextHandshakeMessages(readEpoch, i, (HandshakeMessage) fragment)) {
                        break;
                    }
                } else {
                    expectMessage(fragment);
                    this.LOGGER.debug("Processing {} message from peer [{}]", fragment.getContentType(), fragment.getPeer());
                    setCurrentReadState();
                    this.statesIndex++;
                    this.LOGGER.debug("Processed {} message from peer [{}]", fragment.getContentType(), fragment.getPeer());
                }
                this.session.markRecordAsRead(readEpoch, nextRecord.getSequenceNumber());
                this.inboundMessageBuffer.clean(nextRecord.getSequenceNumber());
                nextRecord = this.inboundMessageBuffer.getNextRecord();
                i++;
            }
            if (this.session.getReadEpoch() > readEpoch) {
                SerialExecutor executor = this.connection.getExecutor();
                List<Record> listTakeDeferredRecords = takeDeferredRecords();
                if (this.deferredRecordsSize > 0) {
                    throw new HandshakeException(String.format("Received unexpected message left from peer %s", record.getPeerAddress()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, record.getPeerAddress()));
                }
                for (final Record record2 : listTakeDeferredRecords) {
                    if (executor != null && !executor.isShutdown()) {
                        try {
                            executor.execute(new Runnable() { // from class: org.eclipse.californium.scandium.dtls.Handshaker.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Handshaker.this.recordLayer.processRecord(record2, Handshaker.this.connection);
                                }
                            });
                        } catch (RejectedExecutionException e) {
                            this.LOGGER.debug("Execution rejected while processing record [type: {}, peer: {}]", record.getType(), record.getPeerAddress(), e);
                            this.recordLayer.processRecord(record2, this.connection);
                        }
                    }
                    this.recordLayer.processRecord(record2, this.connection);
                }
            }
        } catch (RuntimeException e2) {
            this.LOGGER.warn("Cannot process handshake message from peer [{}] due to [{}]", getSession().getPeer(), e2.getMessage(), e2);
            throw new HandshakeException("Cannot process handshake message, caused by " + e2.getMessage(), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, this.session.getPeer()), e2);
        } catch (GeneralSecurityException e3) {
            this.LOGGER.warn("Cannot process handshake message from peer [{}] due to [{}]", getSession().getPeer(), e3.getMessage(), e3);
            throw new HandshakeException("Cannot process handshake message, caused by " + e3.getMessage(), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, this.session.getPeer()), e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDeferredProcessedRecord(Record record, Collection<Record> collection) {
        if (collection.remove(record)) {
            int size = record.size();
            int i = this.deferredRecordsSize;
            if (i >= size) {
                this.deferredRecordsSize = i - size;
            } else {
                this.LOGGER.warn("deferred processed incoming records corrupted for peer [{}]! Removing {} bytes exceeds available {} bytes!", record.getPeerAddress(), Integer.valueOf(size), Integer.valueOf(this.deferredRecordsSize));
                Utf8$$ExternalSyntheticBUOutline0.m$2("deferred processing of incoming records corrupted!");
            }
        }
    }

    public void addApplicationDataForDeferredProcessing(RawData rawData) {
        if (this.deferredApplicationData.size() < this.maxDeferredProcessedOutgoingApplicationDataMessages) {
            this.deferredApplicationData.add(rawData);
        }
    }

    public void addRecordsForDeferredProcessing(Record record) {
        addDeferredProcessedRecord(record, this.deferredRecords);
    }

    public final void addSessionListener(SessionListener sessionListener) {
        if (sessionListener != null) {
            this.sessionListeners.add(sessionListener);
        }
    }

    public void applyMasterSecret(SecretKey secretKey) {
        ensureUndestroyed();
        this.masterSecret = SecretUtil.create(secretKey);
        calculateKeys(secretKey);
        this.session.setMasterSecret(secretKey);
    }

    public void calculateKeys(SecretKey secretKey) {
        ensureUndestroyed();
        int macKeyLength = this.session.getCipherSuite().getMacKeyLength();
        int encKeyLength = this.session.getCipherSuite().getEncKeyLength();
        int fixedIvLength = this.session.getCipherSuite().getFixedIvLength();
        int i = this.generateClusterMacKeys ? encKeyLength : 0;
        byte[] bArrDoPRF = PseudoRandomFunction.doPRF(this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac(), secretKey, PseudoRandomFunction.Label.KEY_EXPANSION_LABEL, Bytes.concatenate(this.serverRandom, this.clientRandom), (macKeyLength + encKeyLength + fixedIvLength + i) * 2);
        this.clientWriteMACKey = SecretUtil.create(bArrDoPRF, 0, macKeyLength, "Mac");
        this.serverWriteMACKey = SecretUtil.create(bArrDoPRF, macKeyLength, macKeyLength, "Mac");
        int i2 = macKeyLength + macKeyLength;
        this.clientWriteKey = SecretUtil.create(bArrDoPRF, i2, encKeyLength, "AES");
        int i3 = i2 + encKeyLength;
        this.serverWriteKey = SecretUtil.create(bArrDoPRF, i3, encKeyLength, "AES");
        int i4 = i3 + encKeyLength;
        this.clientWriteIV = SecretUtil.createIv(bArrDoPRF, i4, fixedIvLength);
        int i5 = i4 + fixedIvLength;
        this.serverWriteIV = SecretUtil.createIv(bArrDoPRF, i5, fixedIvLength);
        if (this.generateClusterMacKeys) {
            SecretKey secretKeyCreate = SecretUtil.create(bArrDoPRF, i5, i, "Mac");
            SecretKey secretKeyCreate2 = SecretUtil.create(bArrDoPRF, i5 + i, i, "Mac");
            boolean z = this.isClient;
            DTLSSession dTLSSession = this.session;
            if (z) {
                dTLSSession.setClusterMacKeys(secretKeyCreate, secretKeyCreate2);
            } else {
                dTLSSession.setClusterMacKeys(secretKeyCreate2, secretKeyCreate);
            }
            SecretUtil.destroy(secretKeyCreate);
            SecretUtil.destroy(secretKeyCreate2);
        }
        Bytes.clear(bArrDoPRF);
    }

    public void completePendingFlight() {
        this.retransmitFlight = null;
        DTLSFlight dTLSFlight = this.pendingFlight.get();
        if (dTLSFlight != null) {
            dTLSFlight.setResponseCompleted();
        }
    }

    public DTLSFlight createFlight() {
        return new DTLSFlight(this.session, this.flightNumber);
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        SecretUtil.destroy(this.otherSecret);
        this.otherSecret = null;
        SecretUtil.destroy(this.masterSecret);
        this.masterSecret = null;
        SecretUtil.destroy(this.clientWriteKey);
        this.clientWriteKey = null;
        SecretUtil.destroy(this.clientWriteMACKey);
        this.clientWriteMACKey = null;
        SecretUtil.destroy(this.clientWriteIV);
        this.clientWriteIV = null;
        SecretUtil.destroy(this.serverWriteKey);
        this.serverWriteKey = null;
        SecretUtil.destroy(this.serverWriteMACKey);
        this.serverWriteMACKey = null;
        SecretUtil.destroy(this.serverWriteIV);
        this.serverWriteIV = null;
        this.destroyed = true;
    }

    public abstract void doProcessMessage(HandshakeMessage handshakeMessage);

    public void ensureUndestroyed() {
        if (this.destroyed) {
            if (this.handshakeFailed) {
                Types$$ExternalSyntheticBUOutline0.m("secrets destroyed after failure!", this.cause);
            } else if (this.sessionEstablished) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("secrets destroyed after success!");
            } else {
                Utf8$$ExternalSyntheticBUOutline0.m$3("secrets destroyed ???");
            }
        }
    }

    public final void expectChangeCipherSpecMessage() {
        this.changeCipherSuiteMessageExpected = true;
    }

    public void expectMessage(DTLSMessage dTLSMessage) throws HandshakeException {
        HandshakeState[] handshakeStateArr;
        if (!this.useStateValidation || (handshakeStateArr = this.states) == null) {
            return;
        }
        int i = this.statesIndex;
        if (i >= handshakeStateArr.length) {
            this.LOGGER.warn("Cannot process {} message from peer [{}], no more expected!", HandshakeState.toString(dTLSMessage), getSession().getPeer());
            throw new HandshakeException("Cannot process " + HandshakeState.toString(dTLSMessage) + " handshake message, no more expected!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, this.session.getPeer()));
        }
        HandshakeState handshakeState = handshakeStateArr[i];
        boolean zExpect = handshakeState.expect(dTLSMessage);
        if (!zExpect && handshakeState.isOptional()) {
            int i2 = this.statesIndex;
            int i3 = i2 + 1;
            HandshakeState[] handshakeStateArr2 = this.states;
            if (i3 < handshakeStateArr2.length && handshakeStateArr2[i2 + 1].expect(dTLSMessage)) {
                this.statesIndex++;
                zExpect = true;
            }
        }
        if (zExpect) {
            return;
        }
        DTLSFlight dTLSFlight = this.pendingFlight.get();
        if (dTLSFlight == null || !dTLSFlight.contains(dTLSMessage)) {
            this.LOGGER.debug("Cannot process {} message from peer [{}], {} expected!", HandshakeState.toString(dTLSMessage), getSession().getPeer(), handshakeState);
        } else {
            this.LOGGER.debug("Cannot process {} message from itself [{}]!", HandshakeState.toString(dTLSMessage), getSession().getPeer());
        }
        throw new HandshakeException("Cannot process " + HandshakeState.toString(dTLSMessage) + " handshake message, " + handshakeState + " expected!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNEXPECTED_MESSAGE, this.session.getPeer()));
    }

    public byte[] generateRandomSeed() {
        return Bytes.concatenate(this.clientRandom, this.serverRandom);
    }

    public final Connection getConnection() {
        return this.connection;
    }

    public final MessageDigest getHandshakeMessageDigest() {
        MessageDigest threadLocalPseudoRandomFunctionMessageDigest = this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMessageDigest();
        int i = 0;
        for (HandshakeMessage handshakeMessage : this.handshakeMessages) {
            threadLocalPseudoRandomFunctionMessageDigest.update(handshakeMessage.toByteArray());
            this.LOGGER.trace("  [{}] - {}", Integer.valueOf(i), handshakeMessage.getMessageType());
            i++;
        }
        return threadLocalPseudoRandomFunctionMessageDigest;
    }

    public final InetSocketAddress getPeerAddress() {
        return this.session.getPeer();
    }

    public ConnectionId getReadConnectionId() {
        ConnectionIdGenerator connectionIdGenerator = this.connectionIdGenerator;
        if (connectionIdGenerator == null) {
            return null;
        }
        return connectionIdGenerator.useConnectionId() ? this.connection.getConnectionId() : ConnectionId.EMPTY;
    }

    public final DTLSSession getSession() {
        return this.session;
    }

    public final void handshakeAborted(Throwable th) {
        this.handshakeAborted = true;
        handshakeFailed(th);
    }

    public final void handshakeCompleted() {
        completePendingFlight();
        Iterator<SessionListener> it = this.sessionListeners.iterator();
        while (it.hasNext()) {
            it.next().handshakeCompleted(this);
        }
        SecretUtil.destroy(this);
        this.LOGGER.debug("handshake completed {}", this.connection);
    }

    public final void handshakeFailed(Throwable th) {
        if (this.cause == null) {
            this.cause = th;
        }
        if (this.handshakeFailed || this.cause != th) {
            return;
        }
        this.LOGGER.debug("handshake failed {}", this.connection, th);
        this.handshakeFailed = true;
        completePendingFlight();
        Iterator<SessionListener> it = this.sessionListeners.iterator();
        while (it.hasNext()) {
            it.next().handshakeFailed(this, th);
        }
        SecretUtil.destroy(this.session);
        SecretUtil.destroy(this);
    }

    public final void handshakeFlightRetransmitted(int i) {
        Iterator<SessionListener> it = this.sessionListeners.iterator();
        while (it.hasNext()) {
            it.next().handshakeFlightRetransmitted(this, i);
        }
        Iterator<RawData> it2 = this.deferredApplicationData.iterator();
        while (it2.hasNext()) {
            it2.next().onDtlsRetransmission(i);
        }
    }

    public final void handshakeStarted() {
        this.LOGGER.debug("handshake started {}", this.connection);
        Iterator<SessionListener> it = this.sessionListeners.iterator();
        while (it.hasNext()) {
            it.next().handshakeStarted(this);
        }
    }

    public boolean hasSessionEstablished() {
        return this.sessionEstablished;
    }

    public final boolean isChangeCipherSpecMessageExpected() {
        return this.changeCipherSuiteMessageExpected;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.destroyed;
    }

    public boolean isExpired() {
        return (this.sessionEstablished || this.pendingFlight.get() == null || this.nanosExpireTime >= ClockUtil.nanoRealtime()) ? false : true;
    }

    public boolean isProbing() {
        return false;
    }

    public boolean isRemovingConnection() {
        return (this.handshakeAborted || this.connection.hasEstablishedSession()) ? false : true;
    }

    public void processCertificateVerificationResult(CertificateVerificationResult certificateVerificationResult) throws HandshakeException {
        if (!this.certificateVerificationPending) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("certificate verification not pending!");
            return;
        }
        ensureUndestroyed();
        this.certificateVerificationPending = false;
        this.LOGGER.info("Process result of certificate verification.");
        if (certificateVerificationResult.getCertificatePath() != null) {
            this.peerCertPath = certificateVerificationResult.getCertificatePath();
            this.certificateVerfied = true;
            this.customArgument = certificateVerificationResult.getCustomArgument();
            processCertificateVerified();
            return;
        }
        if (certificateVerificationResult.getPublicKey() == null) {
            if (certificateVerificationResult.getException() == null) {
                throw new HandshakeException("Bad Certificate", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.BAD_CERTIFICATE, this.session.getPeer()));
            }
            throw certificateVerificationResult.getException();
        }
        this.certificateVerfied = true;
        this.customArgument = certificateVerificationResult.getCustomArgument();
        processCertificateVerified();
    }

    public abstract void processCertificateVerified();

    public abstract void processMasterSecret(SecretKey secretKey);

    public final void processMessage(Record record) throws HandshakeException {
        int readEpoch = this.session.getReadEpoch();
        if (readEpoch != record.getEpoch()) {
            this.LOGGER.debug("Discarding {} message with wrong epoch received from peer [{}]:{}{}", record.getType(), record.getPeerAddress(), StringUtil.lineSeparator(), record);
            FacebookSdk$$ExternalSyntheticLambda1.m("processing record with wrong epoch! ", record.getEpoch(), " expected ", readEpoch);
        } else {
            if (record.getReceiveNanos() < this.flightSendNanos) {
                this.LOGGER.debug("Discarding {} message received from peer [{}] before last flight was sent:{}{}", record.getType(), record.getPeerAddress(), StringUtil.lineSeparator(), record);
                return;
            }
            Record nextRecord = this.inboundMessageBuffer.getNextRecord(record);
            if (nextRecord != null) {
                processNextMessages(nextRecord);
            }
        }
    }

    public void processPskSecretResult(PskSecretResult pskSecretResult) {
        if (!this.pskRequestPending) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("psk secret not pending!");
            return;
        }
        this.pskRequestPending = false;
        try {
            ensureUndestroyed();
            String hostName = this.sniEnabled ? this.session.getHostName() : null;
            PskPublicInformation pskPublicInformation = pskSecretResult.getPskPublicInformation();
            SecretKey secret = pskSecretResult.getSecret();
            if (secret == null) {
                AlertMessage alertMessage = new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNKNOWN_PSK_IDENTITY, this.session.getPeer());
                if (hostName == null) {
                    throw new HandshakeException("No pre-shared key found for [identity: " + pskPublicInformation + "]", alertMessage);
                }
                throw new HandshakeException("No pre-shared key found for [virtual host: " + hostName + ", identity: " + pskPublicInformation + "]", alertMessage);
            }
            Logger logger = this.LOGGER;
            if (hostName != null) {
                logger.trace("client [{}] uses PSK identity [{}] for server [{}]", this.session.getPeer(), pskPublicInformation, hostName);
            } else {
                logger.trace("client [{}] uses PSK identity [{}]", this.session.getPeer(), pskPublicInformation);
            }
            this.session.setPeerIdentity(this.sniEnabled ? new PreSharedKeyIdentity(hostName, pskPublicInformation.getPublicInfoAsString()) : new PreSharedKeyIdentity(pskPublicInformation.getPublicInfoAsString()));
            if ("PSK".equals(secret.getAlgorithm())) {
                Mac threadLocalPseudoRandomFunctionMac = this.session.getCipherSuite().getThreadLocalPseudoRandomFunctionMac();
                SecretKey secretKeyGeneratePremasterSecretFromPSK = PseudoRandomFunction.generatePremasterSecretFromPSK(this.otherSecret, secret);
                SecretKey secretKeyGenerateMasterSecret = PseudoRandomFunction.generateMasterSecret(threadLocalPseudoRandomFunctionMac, secretKeyGeneratePremasterSecretFromPSK, generateRandomSeed());
                SecretUtil.destroy(secretKeyGeneratePremasterSecretFromPSK);
                SecretUtil.destroy(secret);
                secret = secretKeyGenerateMasterSecret;
            }
            this.customArgument = pskSecretResult.getCustomArgument();
            processMasterSecret(secret);
            SecretUtil.destroy(this.otherSecret);
            this.otherSecret = null;
        } catch (Throwable th) {
            SecretUtil.destroy(this.otherSecret);
            this.otherSecret = null;
            throw th;
        }
    }

    public GenericHandshakeMessage reassembleFragment(FragmentedHandshakeMessage fragmentedHandshakeMessage) throws HandshakeException {
        this.LOGGER.debug("Processing {} message fragment ...", fragmentedHandshakeMessage.getMessageType());
        try {
            if (fragmentedHandshakeMessage.getMessageLength() > this.maxFragmentedHandshakeMessageLength) {
                throw new IllegalArgumentException("Fragmented message length exceeded (" + fragmentedHandshakeMessage.getMessageLength() + " > " + this.maxFragmentedHandshakeMessageLength + ")!");
            }
            int messageSeq = fragmentedHandshakeMessage.getMessageSeq();
            ReassemblingHandshakeMessage reassemblingHandshakeMessage = this.reassembledMessage;
            if (reassemblingHandshakeMessage == null) {
                this.reassembledMessage = new ReassemblingHandshakeMessage(fragmentedHandshakeMessage);
            } else {
                if (reassemblingHandshakeMessage.getMessageSeq() != messageSeq) {
                    throw new IllegalArgumentException("Current reassemble message has different seqn " + this.reassembledMessage.getMessageSeq() + " != " + messageSeq);
                }
                this.reassembledMessage.add(fragmentedHandshakeMessage);
            }
            if (!this.reassembledMessage.isComplete()) {
                return null;
            }
            ReassemblingHandshakeMessage reassemblingHandshakeMessage2 = this.reassembledMessage;
            this.LOGGER.debug("Successfully re-assembled {} message", reassemblingHandshakeMessage2.getMessageType());
            this.reassembledMessage = null;
            return reassemblingHandshakeMessage2;
        } catch (IllegalArgumentException e) {
            throw new HandshakeException(e.getMessage(), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, fragmentedHandshakeMessage.getPeer()));
        }
    }

    public PskSecretResult requestPskSecretResult(PskPublicInformation pskPublicInformation, SecretKey secretKey) {
        ServerNames serverNames = this.sniEnabled ? this.session.getServerNames() : null;
        String pseudoRandomFunctionMacName = this.session.getCipherSuite().getPseudoRandomFunctionMacName();
        this.pskRequestPending = true;
        this.otherSecret = SecretUtil.create(secretKey);
        return this.advancedPskStore.requestPskSecretResult(this.connection.getConnectionId(), serverNames, pskPublicInformation, pseudoRandomFunctionMacName, secretKey, generateRandomSeed());
    }

    public void resetProbing() {
    }

    public void sendFlight(DTLSFlight dTLSFlight) {
        DTLSFlight dTLSFlight2;
        completePendingFlight();
        try {
            dTLSFlight.setTimeout(this.retransmissionTimeout);
            long jNanoRealtime = ClockUtil.nanoRealtime();
            this.flightSendNanos = jNanoRealtime;
            this.nanosExpireTime = this.nanosExpireTimeout + jNanoRealtime;
            int maxDatagramSize = this.recordLayer.getMaxDatagramSize(this.ipv6);
            dTLSFlight2 = dTLSFlight;
            try {
                List<DatagramPacket> datagrams = dTLSFlight2.getDatagrams(maxDatagramSize, this.session.getEffectiveFragmentLimit(), this.useMultiHandshakeMessagesRecord, this.useMultiRecordMessages, false);
                this.LOGGER.trace("Sending flight of {} message(s) to peer [{}] using {} datagram(s) of max. {} bytes", Integer.valueOf(dTLSFlight2.getNumberOfMessages()), this.session.getPeer(), Integer.valueOf(datagrams.size()), Integer.valueOf(maxDatagramSize));
                this.recordLayer.sendFlight(datagrams);
                this.pendingFlight.set(dTLSFlight2);
                if (dTLSFlight2.isRetransmissionNeeded()) {
                    TimeoutPeerTask timeoutPeerTask = new TimeoutPeerTask(dTLSFlight2);
                    this.retransmitFlight = timeoutPeerTask;
                    dTLSFlight2.scheduleRetransmission(this.timer, timeoutPeerTask);
                }
            } catch (IOException e) {
                e = e;
                handshakeFailed(new Exception("handshake flight " + dTLSFlight2.getFlightNumber() + " failed!", e));
            } catch (HandshakeException e2) {
                e = e2;
                handshakeFailed(new Exception("handshake flight " + dTLSFlight2.getFlightNumber() + " failed!", e));
            }
        } catch (IOException e3) {
            e = e3;
            dTLSFlight2 = dTLSFlight;
        } catch (HandshakeException e4) {
            e = e4;
            dTLSFlight2 = dTLSFlight;
        }
    }

    public void sendLastFlight(DTLSFlight dTLSFlight) {
        this.lastFlight = true;
        dTLSFlight.setRetransmissionNeeded(false);
        sendFlight(dTLSFlight);
    }

    public final void sessionEstablished() {
        if (this.sessionEstablished) {
            return;
        }
        if (!getSession().getWriteState().hasValidCipherSuite()) {
            handshakeFailed(new DtlsException("Failed establishing a incomplete session.", this.connection.getPeerAddress()));
            return;
        }
        this.LOGGER.debug("session established {}", this.connection);
        amendPeerPrincipal();
        this.sessionEstablished = true;
        Iterator<SessionListener> it = this.sessionListeners.iterator();
        while (it.hasNext()) {
            it.next().sessionEstablished(this, getSession());
        }
    }

    public final void setCurrentReadState() {
        boolean z = this.isClient;
        DTLSSession dTLSSession = this.session;
        this.session.setReadState(z ? DTLSConnectionState.create(dTLSSession.getCipherSuite(), this.session.getCompressionMethod(), this.serverWriteKey, this.serverWriteIV, this.serverWriteMACKey) : DTLSConnectionState.create(dTLSSession.getCipherSuite(), this.session.getCompressionMethod(), this.clientWriteKey, this.clientWriteIV, this.clientWriteMACKey));
    }

    public final void setCurrentWriteState() {
        boolean z = this.isClient;
        DTLSSession dTLSSession = this.session;
        this.session.setWriteState(z ? DTLSConnectionState.create(dTLSSession.getCipherSuite(), this.session.getCompressionMethod(), this.clientWriteKey, this.clientWriteIV, this.clientWriteMACKey) : DTLSConnectionState.create(dTLSSession.getCipherSuite(), this.session.getCompressionMethod(), this.serverWriteKey, this.serverWriteIV, this.serverWriteMACKey));
    }

    public void setFailureCause(Throwable th) {
        completePendingFlight();
        this.cause = th;
    }

    public List<RawData> takeDeferredApplicationData() {
        ArrayList arrayList = new ArrayList(this.deferredApplicationData);
        this.deferredApplicationData.clear();
        return arrayList;
    }

    public List<Record> takeDeferredRecords() {
        ArrayList arrayList = new ArrayList(this.deferredRecords);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            removeDeferredProcessedRecord((Record) it.next(), this.deferredRecords);
        }
        if (!this.deferredRecords.isEmpty()) {
            this.LOGGER.warn("{} left deferred records", Integer.valueOf(this.deferredRecords.size()));
            this.deferredRecords.clear();
        }
        return arrayList;
    }

    public void verifyCertificate(CertificateMessage certificateMessage) throws HandshakeException {
        if (this.certificateVerifier == null) {
            this.LOGGER.debug("Certificate validation failed: no verifier available!");
            throw new HandshakeException("Trust is not possible!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNEXPECTED_MESSAGE, this.session.getPeer()));
        }
        Boolean boolValueOf = this.useKeyUsageVerification ? Boolean.valueOf(!this.isClient) : null;
        this.LOGGER.info("Start certificate verification.");
        this.certificateVerificationPending = true;
        CertificateVerificationResult certificateVerificationResultVerifyCertificate = this.certificateVerifier.verifyCertificate(this.connection.getConnectionId(), null, boolValueOf, this.useTruncatedCertificatePathForVerification, certificateMessage, this.session);
        if (certificateVerificationResultVerifyCertificate != null) {
            processCertificateVerificationResult(certificateVerificationResultVerifyCertificate);
        }
    }

    public final void wrapMessage(DTLSFlight dTLSFlight, DTLSMessage dTLSMessage) throws HandshakeException {
        int i = AnonymousClass2.$SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[dTLSMessage.getContentType().ordinal()];
        if (i == 1) {
            dTLSFlight.addDtlsMessage(this.session.getWriteEpoch(), dTLSMessage);
            return;
        }
        if (i != 2) {
            throw new HandshakeException("Cannot create " + dTLSMessage.getContentType() + " record for flight", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, this.session.getPeer()));
        }
        HandshakeMessage handshakeMessage = (HandshakeMessage) dTLSMessage;
        applySendMessageSequenceNumber(handshakeMessage);
        if (this.session.getWriteEpoch() == 0) {
            this.handshakeMessages.add(handshakeMessage);
        }
        dTLSFlight.addDtlsMessage(this.session.getWriteEpoch(), dTLSMessage);
    }

    public void takeDeferredApplicationData(Handshaker handshaker) {
        this.deferredApplicationData.addAll(handshaker.takeDeferredApplicationData());
    }

    public class InboundMessageBuffer {
        private Record changeCipherSpec;
        private SortedSet<Record> queue;

        private InboundMessageBuffer() {
            this.changeCipherSpec = null;
            this.queue = new TreeSet(new Comparator<Record>() { // from class: org.eclipse.californium.scandium.dtls.Handshaker.InboundMessageBuffer.1
                @Override // java.util.Comparator
                public int compare(Record record, Record record2) {
                    return Handshaker.compareRecords(record, record2);
                }
            });
        }

        public void clean(long j) {
            Record record = this.changeCipherSpec;
            if (record != null && record.getSequenceNumber() == j) {
                this.changeCipherSpec = null;
            }
            for (Record record2 : this.queue) {
                if (record2.getSequenceNumber() == j) {
                    Handshaker.this.removeDeferredProcessedRecord(record2, this.queue);
                }
            }
        }

        public Record getNextRecord(Record record) {
            int epoch = record.getEpoch();
            int readEpoch = Handshaker.this.session.getReadEpoch();
            if (epoch != readEpoch) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(epoch, readEpoch, "record epoch ", " doesn't match session "));
                return null;
            }
            DTLSMessage fragment = record.getFragment();
            int i = AnonymousClass2.$SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[fragment.getContentType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    Handshaker.this.LOGGER.warn("Cannot process message of type [{}], discarding...", fragment.getContentType());
                    return null;
                }
                HandshakeMessage handshakeMessage = (HandshakeMessage) fragment;
                int messageSeq = handshakeMessage.getMessageSeq();
                if (messageSeq != Handshaker.this.nextReceiveMessageSequence) {
                    int i2 = Handshaker.this.nextReceiveMessageSequence;
                    Handshaker handshaker = Handshaker.this;
                    if (messageSeq <= i2) {
                        handshaker.LOGGER.debug("Discarding old {} message_seq [{}] < next_receive_seq [{}]", handshakeMessage.getMessageType(), Integer.valueOf(messageSeq), Integer.valueOf(Handshaker.this.nextReceiveMessageSequence));
                        return null;
                    }
                    handshaker.LOGGER.debug("Queued newer {} message from current epoch, message_seq [{}] > next_receive_seq [{}]", handshakeMessage.getMessageType(), Integer.valueOf(messageSeq), Integer.valueOf(Handshaker.this.nextReceiveMessageSequence));
                    Handshaker.this.addDeferredProcessedRecord(record, this.queue);
                    return null;
                }
            } else if (!Handshaker.this.isChangeCipherSpecMessageExpected()) {
                Record record2 = this.changeCipherSpec;
                Handshaker handshaker2 = Handshaker.this;
                if (record2 != null) {
                    handshaker2.LOGGER.debug("Change Cipher Spec is received again!");
                    return null;
                }
                handshaker2.LOGGER.debug("Change Cipher Spec is not expected and therefore kept for later processing!");
                this.changeCipherSpec = record;
                return null;
            }
            return record;
        }

        public Record getNextRecord() {
            Record record;
            if (Handshaker.this.isChangeCipherSpecMessageExpected() && (record = this.changeCipherSpec) != null) {
                this.changeCipherSpec = null;
                return record;
            }
            while (!this.queue.isEmpty()) {
                Record recordFirst = this.queue.first();
                int messageSeq = ((HandshakeMessage) recordFirst.getFragment()).getMessageSeq();
                if (messageSeq > Handshaker.this.nextReceiveMessageSequence) {
                    break;
                }
                Handshaker.this.removeDeferredProcessedRecord(recordFirst, this.queue);
                if (messageSeq == Handshaker.this.nextReceiveMessageSequence) {
                    return recordFirst;
                }
            }
            return null;
        }
    }
}
