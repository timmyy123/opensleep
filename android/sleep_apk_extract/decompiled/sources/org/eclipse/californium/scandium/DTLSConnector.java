package org.eclipse.californium.scandium;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.integrity.IntegrityManager;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.Connector;
import org.eclipse.californium.elements.DtlsEndpointContext;
import org.eclipse.californium.elements.EndpointContext;
import org.eclipse.californium.elements.EndpointContextMatcher;
import org.eclipse.californium.elements.RawData;
import org.eclipse.californium.elements.RawDataChannel;
import org.eclipse.californium.elements.exception.EndpointMismatchException;
import org.eclipse.californium.elements.exception.EndpointUnconnectedException;
import org.eclipse.californium.elements.exception.MulticastNotSupportedException;
import org.eclipse.californium.elements.util.ClockUtil;
import org.eclipse.californium.elements.util.DaemonThreadFactory;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.ExecutorsUtil;
import org.eclipse.californium.elements.util.NamedThreadFactory;
import org.eclipse.californium.elements.util.NetworkInterfacesUtil;
import org.eclipse.californium.elements.util.SerialExecutor;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.config.DtlsConnectorConfig;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.ApplicationMessage;
import org.eclipse.californium.scandium.dtls.AvailableConnections;
import org.eclipse.californium.scandium.dtls.ClientHandshaker;
import org.eclipse.californium.scandium.dtls.ClientHello;
import org.eclipse.californium.scandium.dtls.Connection;
import org.eclipse.californium.scandium.dtls.ConnectionEvictedException;
import org.eclipse.californium.scandium.dtls.ConnectionId;
import org.eclipse.californium.scandium.dtls.ConnectionIdGenerator;
import org.eclipse.californium.scandium.dtls.ContentType;
import org.eclipse.californium.scandium.dtls.DTLSMessage;
import org.eclipse.californium.scandium.dtls.DTLSSession;
import org.eclipse.californium.scandium.dtls.DtlsException;
import org.eclipse.californium.scandium.dtls.DtlsHandshakeException;
import org.eclipse.californium.scandium.dtls.FragmentedHandshakeMessage;
import org.eclipse.californium.scandium.dtls.HandshakeException;
import org.eclipse.californium.scandium.dtls.HandshakeMessage;
import org.eclipse.californium.scandium.dtls.HandshakeResultHandler;
import org.eclipse.californium.scandium.dtls.HandshakeType;
import org.eclipse.californium.scandium.dtls.Handshaker;
import org.eclipse.californium.scandium.dtls.HelloVerifyRequest;
import org.eclipse.californium.scandium.dtls.InMemoryConnectionStore;
import org.eclipse.californium.scandium.dtls.MaxFragmentLengthExtension;
import org.eclipse.californium.scandium.dtls.ProtocolVersion;
import org.eclipse.californium.scandium.dtls.Record;
import org.eclipse.californium.scandium.dtls.RecordLayer;
import org.eclipse.californium.scandium.dtls.ResumingClientHandshaker;
import org.eclipse.californium.scandium.dtls.ResumingServerHandshaker;
import org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore;
import org.eclipse.californium.scandium.dtls.ServerHandshaker;
import org.eclipse.californium.scandium.dtls.ServerNameExtension;
import org.eclipse.californium.scandium.dtls.SessionAdapter;
import org.eclipse.californium.scandium.dtls.SessionCache;
import org.eclipse.californium.scandium.dtls.SessionId;
import org.eclipse.californium.scandium.dtls.SessionListener;
import org.eclipse.californium.scandium.dtls.SessionTicket;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.dtls.pskstore.AdvancedPskStore;
import org.eclipse.californium.scandium.dtls.x509.NewAdvancedCertificateVerifier;
import org.eclipse.californium.scandium.util.SecretUtil;
import org.eclipse.californium.scandium.util.ServerNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class DTLSConnector implements Connector, RecordLayer {
    private static final long CLIENT_HELLO_TIMEOUT_MILLIS;
    private static final Logger DROP_LOGGER;
    private static final Logger LOGGER;
    private static final int MAX_CIPHERTEXT_EXPANSION;
    private static final int MAX_DATAGRAM_BUFFER_SIZE;
    private static final boolean MDC_SUPPORT;
    private Object alertHandlerLock;
    private final Long autoResumptionTimeoutMillis;
    protected final DtlsConnectorConfig config;
    protected final ConnectionIdGenerator connectionIdGenerator;
    private final ResumptionSupportingConnectionStore connectionStore;
    private CookieGenerator cookieGenerator;
    private final String defaultHandshakeMode;
    private volatile EndpointContextMatcher endpointContextMatcher;
    private ExecutorService executorService;
    private boolean hasInternalExecutor;
    protected final DtlsHealth health;
    protected int inboundDatagramBufferSize;
    private int ipv4Mtu;
    private int ipv6Mtu;
    private InetSocketAddress lastBindAddress;
    private Integer maximumTransmissionUnit;
    private volatile RawDataChannel messageHandler;
    private final AtomicInteger pendingHandshakesWithoutVerifiedPeer;
    private final AtomicInteger pendingOutboundMessagesCountdown;
    private final ProtocolVersion protocolVersionForHelloVerifyRequests;
    private final List<Thread> receiverThreads;
    private AtomicBoolean running;
    private final boolean serverOnly;
    private SessionListener sessionListener;
    private volatile DatagramSocket socket;
    private ScheduledFuture<?> statusLogger;
    private final int thresholdHandshakesWithoutVerifiedPeer;
    protected ScheduledExecutorService timer;
    private final boolean useCidUpdateAddressOnNewerRecordFilter;
    private final int useExtendedWindowFilter;
    private final boolean useFilter;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.DTLSConnector$18, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass18 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType;
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType;

        static {
            int[] iArr = new int[HandshakeType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType = iArr;
            try {
                iArr[HandshakeType.CLIENT_HELLO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.HELLO_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ContentType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType = iArr2;
            try {
                iArr2[ContentType.APPLICATION_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[ContentType.ALERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[ContentType.CHANGE_CIPHER_SPEC.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[ContentType.HANDSHAKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public abstract class Worker extends Thread {
        public Worker(String str) {
            super(NamedThreadFactory.SCANDIUM_THREAD_GROUP, str);
        }

        public abstract void doWork();

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                DTLSConnector.LOGGER.info("Starting worker thread [{}]", getName());
                while (DTLSConnector.this.running.get()) {
                    try {
                        doWork();
                    } catch (InterruptedIOException unused) {
                        if (DTLSConnector.this.running.get()) {
                            DTLSConnector.LOGGER.info("Worker thread [{}] IO has been interrupted", getName());
                        } else {
                            DTLSConnector.LOGGER.debug("Worker thread [{}] IO has been interrupted", getName());
                        }
                    } catch (InterruptedException unused2) {
                        if (DTLSConnector.this.running.get()) {
                            DTLSConnector.LOGGER.info("Worker thread [{}] has been interrupted", getName());
                        } else {
                            DTLSConnector.LOGGER.debug("Worker thread [{}] has been interrupted", getName());
                        }
                    } catch (Exception e) {
                        if (DTLSConnector.this.running.get()) {
                            DTLSConnector.LOGGER.debug("Exception thrown by worker thread [{}]", getName(), e);
                        } else {
                            DTLSConnector.LOGGER.trace("Exception thrown by worker thread [{}]", getName(), e);
                        }
                    }
                }
            } finally {
                DTLSConnector.LOGGER.info("Worker thread [{}] has terminated", getName());
            }
        }
    }

    static {
        boolean z;
        Logger logger = LoggerFactory.getLogger((Class<?>) DTLSConnector.class);
        LOGGER = logger;
        DROP_LOGGER = LoggerFactory.getLogger(logger.getName() + ".drops");
        int overallMaxCiphertextExpansion = CipherSuite.getOverallMaxCiphertextExpansion();
        MAX_CIPHERTEXT_EXPANSION = overallMaxCiphertextExpansion;
        MAX_DATAGRAM_BUFFER_SIZE = overallMaxCiphertextExpansion + 16409;
        CLIENT_HELLO_TIMEOUT_MILLIS = 60000L;
        try {
            MDC.clear();
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        MDC_SUPPORT = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3 A[PHI: r0
      0x00d3: PHI (r0v12 org.eclipse.californium.scandium.DtlsHealth) = 
      (r0v11 org.eclipse.californium.scandium.DtlsHealth)
      (r0v11 org.eclipse.californium.scandium.DtlsHealth)
      (r0v11 org.eclipse.californium.scandium.DtlsHealth)
      (r0v16 org.eclipse.californium.scandium.DtlsHealth)
     binds: [B:16:0x00be, B:17:0x00c0, B:19:0x00c6, B:21:0x00d0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DTLSConnector(DtlsConnectorConfig dtlsConnectorConfig, final ResumptionSupportingConnectionStore resumptionSupportingConnectionStore) {
        this.pendingHandshakesWithoutVerifiedPeer = new AtomicInteger();
        AtomicInteger atomicInteger = new AtomicInteger();
        this.pendingOutboundMessagesCountdown = atomicInteger;
        this.receiverThreads = new LinkedList();
        this.ipv4Mtu = 576;
        this.ipv6Mtu = 1280;
        this.inboundDatagramBufferSize = MAX_DATAGRAM_BUFFER_SIZE;
        this.cookieGenerator = new CookieGenerator();
        this.alertHandlerLock = new Object();
        this.running = new AtomicBoolean(false);
        DtlsHealth dtlsHealth = null;
        if (dtlsConnectorConfig == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Configuration must not be null");
            throw null;
        }
        if (resumptionSupportingConnectionStore == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Connection store must not be null");
            throw null;
        }
        this.config = dtlsConnectorConfig;
        ConnectionIdGenerator connectionIdGenerator = dtlsConnectorConfig.getConnectionIdGenerator();
        this.connectionIdGenerator = connectionIdGenerator;
        this.protocolVersionForHelloVerifyRequests = dtlsConnectorConfig.getProtocolVersionForHelloVerifyRequests();
        atomicInteger.set(dtlsConnectorConfig.getOutboundMessageBufferSize().intValue());
        this.autoResumptionTimeoutMillis = dtlsConnectorConfig.getAutoResumptionTimeoutMillis();
        this.serverOnly = dtlsConnectorConfig.isServerOnly().booleanValue();
        this.defaultHandshakeMode = dtlsConnectorConfig.getDefaultHandshakeMode();
        int iIntValue = dtlsConnectorConfig.useExtendedWindowFilter().intValue();
        this.useExtendedWindowFilter = iIntValue;
        this.useFilter = dtlsConnectorConfig.useAntiReplayFilter().booleanValue() || iIntValue != 0;
        this.useCidUpdateAddressOnNewerRecordFilter = dtlsConnectorConfig.useCidUpdateAddressOnNewerRecordFilter().booleanValue();
        this.connectionStore = resumptionSupportingConnectionStore;
        resumptionSupportingConnectionStore.attach(connectionIdGenerator);
        dtlsConnectorConfig.getConnectionListener();
        resumptionSupportingConnectionStore.setConnectionListener(null);
        dtlsConnectorConfig.getConnectionListener();
        HandshakeResultHandler handshakeResultHandler = new HandshakeResultHandler() { // from class: org.eclipse.californium.scandium.DTLSConnector.1
        };
        AdvancedPskStore advancedPskStore = dtlsConnectorConfig.getAdvancedPskStore();
        if (advancedPskStore != null) {
            advancedPskStore.setResultHandler(handshakeResultHandler);
        }
        NewAdvancedCertificateVerifier advancedCertificateVerifier = dtlsConnectorConfig.getAdvancedCertificateVerifier();
        if (advancedCertificateVerifier != null) {
            advancedCertificateVerifier.setResultHandler(handshakeResultHandler);
        }
        DtlsHealth healthHandler = dtlsConnectorConfig.getHealthHandler();
        Integer healthStatusInterval = dtlsConnectorConfig.getHealthStatusInterval();
        if (healthHandler != null || healthStatusInterval == null || healthStatusInterval.intValue() <= 0) {
            dtlsHealth = healthHandler;
        } else {
            healthHandler = createDefaultHealthHandler(dtlsConnectorConfig);
            if (healthHandler.isEnabled()) {
            }
        }
        this.health = dtlsHealth;
        this.sessionListener = new SessionAdapter() { // from class: org.eclipse.californium.scandium.DTLSConnector.2
            @Override // org.eclipse.californium.scandium.dtls.SessionAdapter, org.eclipse.californium.scandium.dtls.SessionListener
            public void handshakeCompleted(Handshaker handshaker) {
                DtlsHealth dtlsHealth2 = DTLSConnector.this.health;
                if (dtlsHealth2 != null) {
                    dtlsHealth2.endHandshake(true);
                }
                final Connection connection = handshaker.getConnection();
                ScheduledExecutorService scheduledExecutorService = DTLSConnector.this.timer;
                if (scheduledExecutorService != null) {
                    try {
                        scheduledExecutorService.schedule(new Runnable() { // from class: org.eclipse.californium.scandium.DTLSConnector.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                connection.startByClientHello(null);
                            }
                        }, DTLSConnector.CLIENT_HELLO_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                        return;
                    } catch (RejectedExecutionException unused) {
                        DTLSConnector.LOGGER.debug("stopping.");
                    }
                }
                connection.startByClientHello(null);
            }

            @Override // org.eclipse.californium.scandium.dtls.SessionListener
            public void handshakeFailed(Handshaker handshaker, Throwable th) {
                DtlsHealth dtlsHealth2 = DTLSConnector.this.health;
                if (dtlsHealth2 != null) {
                    dtlsHealth2.endHandshake(false);
                }
                List<RawData> listTakeDeferredApplicationData = handshaker.takeDeferredApplicationData();
                if (!listTakeDeferredApplicationData.isEmpty()) {
                    DTLSConnector.LOGGER.debug("Handshake with [{}] failed, report error to deferred {} messages", handshaker.getPeerAddress(), Integer.valueOf(listTakeDeferredApplicationData.size()));
                    Iterator<RawData> it = listTakeDeferredApplicationData.iterator();
                    while (it.hasNext()) {
                        it.next().onError(th);
                    }
                }
                Connection connection = handshaker.getConnection();
                if (handshaker.isRemovingConnection()) {
                    resumptionSupportingConnectionStore.remove(connection, false);
                    return;
                }
                if (handshaker.isProbing()) {
                    DTLSConnector.LOGGER.debug("Handshake with [{}] failed within probe!", handshaker.getPeerAddress());
                    return;
                }
                if (connection.getEstablishedSession() != handshaker.getSession()) {
                    if (connection.hasEstablishedSession()) {
                        DTLSConnector.LOGGER.warn("Handshake with [{}] failed, but has an established session!", handshaker.getPeerAddress());
                        return;
                    } else {
                        DTLSConnector.LOGGER.warn("Handshake with [{}] failed, connection preserved!", handshaker.getPeerAddress());
                        return;
                    }
                }
                if (!(th instanceof HandshakeException)) {
                    if (th instanceof ConnectionEvictedException) {
                        DTLSConnector.LOGGER.debug("Handshake with [{}] never get APPLICATION_DATA", handshaker.getPeerAddress(), th);
                        return;
                    } else {
                        DTLSConnector.LOGGER.warn("Handshake with [{}] failed after session was established!", handshaker.getPeerAddress(), th);
                        return;
                    }
                }
                AlertMessage alert = ((HandshakeException) th).getAlert();
                if (alert == null || alert.getDescription() != AlertMessage.AlertDescription.CLOSE_NOTIFY) {
                    DTLSConnector.LOGGER.warn("Handshake with [{}] failed after session was established! {}", handshaker.getPeerAddress(), alert);
                } else {
                    DTLSConnector.LOGGER.debug("Handshake with [{}] closed after session was established!", handshaker.getPeerAddress());
                }
            }

            @Override // org.eclipse.californium.scandium.dtls.SessionListener
            public void sessionEstablished(Handshaker handshaker, DTLSSession dTLSSession) {
                DTLSConnector.this.sessionEstablished(handshaker, dTLSSession);
            }
        };
        int iIntValue2 = dtlsConnectorConfig.getMaxConnections().intValue();
        long jIntValue = dtlsConnectorConfig.getVerifyPeersOnResumptionThreshold().intValue();
        long j = ((((long) iIntValue2) * jIntValue) + 50) / 100;
        if (j == 0 && jIntValue > 0) {
            j = 1;
        }
        this.thresholdHandshakesWithoutVerifiedPeer = (int) j;
    }

    private boolean checkOutboundEndpointContext(RawData rawData, EndpointContext endpointContext) {
        EndpointContextMatcher endpointContextMatcher = getEndpointContextMatcher();
        if (endpointContextMatcher == null || endpointContextMatcher.isToBeSent(rawData.getEndpointContext(), endpointContext)) {
            return true;
        }
        Logger logger = DROP_LOGGER;
        if (logger.isInfoEnabled()) {
            logger.info("DTLSConnector ({}) drops {} bytes outgoing, {} != {}", this, Integer.valueOf(rawData.getSize()), endpointContextMatcher.toRelevantState(rawData.getEndpointContext()), endpointContextMatcher.toRelevantState(endpointContext));
        }
        rawData.onError(new EndpointMismatchException());
        DtlsHealth dtlsHealth = this.health;
        if (dtlsHealth == null) {
            return false;
        }
        dtlsHealth.sendingRecord(true);
        return false;
    }

    public static ResumptionSupportingConnectionStore createConnectionStore(DtlsConnectorConfig dtlsConnectorConfig, SessionCache sessionCache) {
        return new InMemoryConnectionStore(dtlsConnectorConfig.getMaxConnections().intValue(), dtlsConnectorConfig.getStaleConnectionThreshold().longValue(), sessionCache).setTag(dtlsConnectorConfig.getLoggingTag());
    }

    private void discardRecord(Record record, Throwable th) {
        DtlsHealth dtlsHealth = this.health;
        if (dtlsHealth != null) {
            dtlsHealth.receivingRecord(true);
        }
        byte[] fragmentBytes = record.getFragmentBytes();
        Logger logger = DROP_LOGGER;
        if (logger.isTraceEnabled()) {
            logger.trace("Discarding received {} record (epoch {}, payload: {}) from peer [{}]: ", record.getType(), Integer.valueOf(record.getEpoch()), StringUtil.byteArray2HexString(fragmentBytes, (char) 0, 64), record.getPeerAddress(), th);
        } else if (logger.isDebugEnabled()) {
            logger.debug("Discarding received {} record (epoch {}, payload: {}) from peer [{}]: {}", record.getType(), Integer.valueOf(record.getEpoch()), StringUtil.byteArray2HexString(fragmentBytes, (char) 0, 16), record.getPeerAddress(), th.getMessage());
        }
    }

    private Long getAutResumptionTimeout(RawData rawData) {
        Long l = this.autoResumptionTimeoutMillis;
        String str = rawData.getEndpointContext().get("*DTLS_RESUMPTION_TIMEOUT");
        if (str == null) {
            return l;
        }
        if (str.isEmpty()) {
            return null;
        }
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException unused) {
            return l;
        }
    }

    private final Connection getConnection(InetSocketAddress inetSocketAddress, ConnectionId connectionId, boolean z) {
        Connection connection;
        ExecutorService executorService = getExecutorService();
        synchronized (this.connectionStore) {
            ResumptionSupportingConnectionStore resumptionSupportingConnectionStore = this.connectionStore;
            try {
                if (connectionId != null) {
                    connection = resumptionSupportingConnectionStore.get(connectionId);
                } else {
                    Connection connection2 = resumptionSupportingConnectionStore.get(inetSocketAddress);
                    if (connection2 == null && z) {
                        LOGGER.trace("create new connection for {}", inetSocketAddress);
                        Connection connection3 = new Connection(inetSocketAddress, new SerialExecutor(executorService));
                        connection3.setExecutionListener(null);
                        if (!this.running.get() || this.connectionStore.put(connection3)) {
                            return connection3;
                        }
                        return null;
                    }
                    connection = connection2;
                }
                if (connection == null) {
                    LOGGER.trace("no connection available for {},{}", inetSocketAddress, connectionId);
                } else if (connection.isExecuting() || !this.running.get()) {
                    LOGGER.trace("connection available for {},{}", inetSocketAddress, connectionId);
                } else {
                    LOGGER.trace("revive connection for {},{}", inetSocketAddress, connectionId);
                    connection.setExecutor(new SerialExecutor(executorService));
                }
                return connection;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private String getEffectiveHandshakeMode(RawData rawData) {
        String str = rawData.getEndpointContext().get("*DTLS_HANDSHAKE_MODE");
        return str == null ? this.defaultHandshakeMode : str;
    }

    private EndpointContextMatcher getEndpointContextMatcher() {
        return this.endpointContextMatcher;
    }

    private synchronized ExecutorService getExecutorService() {
        return this.executorService;
    }

    private final DatagramSocket getSocket() {
        return this.socket;
    }

    private void handleAlertInternal(InetSocketAddress inetSocketAddress, AlertMessage alertMessage, Connection connection) {
        if (connection.getRootCauseAlert() == null) {
            connection.setRootCause(alertMessage);
            synchronized (this.alertHandlerLock) {
            }
        }
    }

    private void handleExceptionDuringHandshake(HandshakeException handshakeException, Connection connection, Record record) {
        AlertMessage alert = handshakeException.getAlert();
        if (!AlertMessage.AlertLevel.FATAL.equals(alert.getLevel())) {
            if (record != null) {
                discardRecord(record, handshakeException);
            }
            handleAlertInternal(alert.getPeer(), alert, connection);
        } else {
            if (!AlertMessage.AlertDescription.UNKNOWN_PSK_IDENTITY.equals(alert.getDescription())) {
                terminateOngoingHandshake(connection, handshakeException);
                return;
            }
            if (record != null) {
                discardRecord(record, handshakeException);
            }
            handleAlertInternal(alert.getPeer(), alert, connection);
        }
    }

    private final void initializeHandshaker(Handshaker handshaker) {
        SessionListener sessionListener = this.sessionListener;
        if (sessionListener != null) {
            handshaker.addSessionListener(sessionListener);
            DtlsHealth dtlsHealth = this.health;
            if (dtlsHealth != null) {
                dtlsHealth.startHandshake();
            }
        }
        onInitializeHandshaker(handshaker);
    }

    private boolean isClientInControlOfSourceIpAddress(ClientHello clientHello, Record record, AvailableConnections availableConnections) {
        byte[] bArrGenerateCookie;
        if (availableConnections == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("available connections must not be null!");
            return false;
        }
        try {
            byte[] cookie = clientHello.getCookie();
            if (cookie.length > 0) {
                bArrGenerateCookie = this.cookieGenerator.generateCookie(clientHello);
                if (MessageDigest.isEqual(bArrGenerateCookie, cookie)) {
                    return true;
                }
                byte[] bArrGeneratePastCookie = this.cookieGenerator.generatePastCookie(clientHello);
                if (bArrGeneratePastCookie != null && MessageDigest.isEqual(bArrGeneratePastCookie, cookie)) {
                    return true;
                }
                Logger logger = LOGGER;
                if (logger.isDebugEnabled()) {
                    logger.debug("provided cookie must {} match {}. Send verify request to {}", StringUtil.byteArray2HexString(cookie, (char) 0, 6), StringUtil.byteArray2HexString(bArrGenerateCookie, (char) 0, 6), record.getPeerAddress());
                }
            } else {
                if (this.thresholdHandshakesWithoutVerifiedPeer > 0) {
                    int i = this.pendingHandshakesWithoutVerifiedPeer.get();
                    LOGGER.trace("pending fast resumptions [{}], threshold [{}]", Integer.valueOf(i), Integer.valueOf(this.thresholdHandshakesWithoutVerifiedPeer));
                    if (i < this.thresholdHandshakesWithoutVerifiedPeer) {
                        Connection connectionFind = this.connectionStore.find(clientHello.getSessionId());
                        availableConnections.setConnectionBySessionId(connectionFind);
                        if (connectionFind != null) {
                            return true;
                        }
                    }
                }
                bArrGenerateCookie = null;
            }
            sendHelloVerify(clientHello, record, bArrGenerateCookie);
            return false;
        } catch (GeneralSecurityException e) {
            throw new DtlsHandshakeException("Cannot compute cookie for peer", AlertMessage.AlertDescription.INTERNAL_ERROR, AlertMessage.AlertLevel.FATAL, clientHello.getPeer(), e);
        }
    }

    private void processAlertRecord(Record record, Connection connection, DTLSSession dTLSSession) {
        AlertMessage alertMessage = (AlertMessage) record.getFragment();
        Handshaker ongoingHandshake = connection.getOngoingHandshake();
        LOGGER.trace("Processing {} ALERT from [{}]: {}", alertMessage.getLevel(), alertMessage.getPeer(), alertMessage.getDescription());
        AlertMessage.AlertDescription alertDescription = AlertMessage.AlertDescription.CLOSE_NOTIFY;
        HandshakeException handshakeException = null;
        if (alertDescription.equals(alertMessage.getDescription())) {
            if (connection.hasEstablishedSession()) {
                updateConnectionAddress(record, connection, dTLSSession);
            } else {
                handshakeException = new HandshakeException("Received 'close notify'", alertMessage);
                if (ongoingHandshake != null) {
                    ongoingHandshake.setFailureCause(handshakeException);
                }
            }
            if (!connection.isResumptionRequired()) {
                if (dTLSSession.getPeer() != null) {
                    send(new AlertMessage(AlertMessage.AlertLevel.WARNING, alertDescription, alertMessage.getPeer()), dTLSSession);
                }
                if (connection.hasEstablishedSession()) {
                    connection.close(record);
                } else {
                    this.connectionStore.remove(connection);
                }
            }
        } else if (AlertMessage.AlertLevel.FATAL.equals(alertMessage.getLevel())) {
            handshakeException = new HandshakeException("Received 'fatal alert/" + alertMessage.getDescription() + "'", alertMessage);
            if (ongoingHandshake != null) {
                ongoingHandshake.setFailureCause(handshakeException);
            }
            this.connectionStore.remove(connection);
        }
        handleAlertInternal(alertMessage.getPeer(), alertMessage, connection);
        if (handshakeException == null || ongoingHandshake == null) {
            return;
        }
        ongoingHandshake.handshakeFailed(handshakeException);
    }

    private void processApplicationDataRecord(Record record, Connection connection) {
        Handshaker ongoingHandshake = connection.getOngoingHandshake();
        DTLSSession establishedSession = connection.getEstablishedSession();
        if (establishedSession == null || connection.isResumptionRequired()) {
            if (ongoingHandshake != null) {
                ongoingHandshake.addRecordsForDeferredProcessing(record);
                return;
            } else {
                DROP_LOGGER.debug("Discarding APPLICATION_DATA record received from peer [{}]", record.getPeerAddress());
                return;
            }
        }
        ApplicationMessage applicationMessage = (ApplicationMessage) record.getFragment();
        updateConnectionAddress(record, connection, establishedSession);
        RawDataChannel rawDataChannel = this.messageHandler;
        if (rawDataChannel != null) {
            InetSocketAddress peer = establishedSession.getPeer();
            if (peer == null) {
                establishedSession.setPeer(record.getPeerAddress());
            }
            DtlsEndpointContext connectionReadContext = establishedSession.getConnectionReadContext();
            if (peer == null) {
                establishedSession.setPeer(null);
                LOGGER.debug("Received APPLICATION_DATA from deprecated {}", record.getPeerAddress());
            }
            LOGGER.trace("Received APPLICATION_DATA for {}", connectionReadContext);
            rawDataChannel.receiveData(RawData.inbound(applicationMessage.getData(), connectionReadContext, false, record.getReceiveNanos()));
        }
    }

    private void processChangeCipherSpecRecord(Record record, Connection connection) {
        Handshaker ongoingHandshake = connection.getOngoingHandshake();
        if (ongoingHandshake == null) {
            DROP_LOGGER.debug("Received CHANGE_CIPHER_SPEC record from peer [{}] with no handshake going on", record.getPeerAddress());
            return;
        }
        try {
            ongoingHandshake.processMessage(record);
        } catch (HandshakeException e) {
            handleExceptionDuringHandshake(e, connection, record);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processClientHello(ClientHello clientHello, Record record, AvailableConnections availableConnections) {
        if (availableConnections == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("available connections must not be null!");
            return;
        }
        Connection connectionByAddress = availableConnections.getConnectionByAddress();
        if (connectionByAddress == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("connection by address must not be null!");
            return;
        }
        if (!connectionByAddress.equalsPeerAddress(record.getPeerAddress())) {
            DROP_LOGGER.info("Drop received CLIENT_HELLO, changed address {} => {}!", record.getPeerAddress(), connectionByAddress.getPeerAddress());
            return;
        }
        Logger logger = LOGGER;
        if (logger.isTraceEnabled()) {
            logger.trace("Processing CLIENT_HELLO from peer [" + record.getPeerAddress() + "]:" + StringUtil.lineSeparator() + record);
        }
        try {
            if (!connectionByAddress.hasEstablishedSession() && connectionByAddress.getOngoingHandshake() == null) {
                if (clientHello.hasSessionId()) {
                    resumeExistingSession(clientHello, record, availableConnections);
                    return;
                } else {
                    startNewHandshake(clientHello, record, connectionByAddress);
                    return;
                }
            }
            DROP_LOGGER.debug("Discarding received duplicate CLIENT_HELLO message [epoch={}] from peer [{}]!", Integer.valueOf(record.getEpoch()), record.getPeerAddress());
        } catch (HandshakeException e) {
            handleExceptionDuringHandshake(e, connectionByAddress, record);
        }
    }

    private void processHandshakeRecord(Record record, Connection connection) {
        LOGGER.trace("Received {} record from peer [{}]", record.getType(), record.getPeerAddress());
        try {
            if (record.isNewClientHello()) {
                throw new IllegalArgumentException("new CLIENT_HELLO must be processed by processClientHello!");
            }
            int i = AnonymousClass18.$SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[((HandshakeMessage) record.getFragment()).getMessageType().ordinal()];
            if (i == 1) {
                DROP_LOGGER.debug("Reject re-negotiation from peer {}", record.getPeerAddress());
                send(new AlertMessage(AlertMessage.AlertLevel.WARNING, AlertMessage.AlertDescription.NO_RENEGOTIATION, record.getPeerAddress()), connection.getEstablishedSession());
            } else {
                if (i == 2) {
                    processHelloRequest(connection);
                    return;
                }
                Handshaker ongoingHandshake = connection.getOngoingHandshake();
                if (ongoingHandshake != null) {
                    ongoingHandshake.processMessage(record);
                } else {
                    DROP_LOGGER.debug("Discarding HANDSHAKE message [epoch={}] from peer [{}], no ongoing handshake!", Integer.valueOf(record.getEpoch()), record.getPeerAddress());
                }
            }
        } catch (HandshakeException e) {
            handleExceptionDuringHandshake(e, connection, record);
        }
    }

    private void processHelloRequest(Connection connection) {
        if (connection.hasOngoingHandshake()) {
            DROP_LOGGER.debug("Ignoring HELLO_REQUEST received from [{}] while already in an ongoing handshake with peer", connection.getPeerAddress());
        } else {
            send(new AlertMessage(AlertMessage.AlertLevel.WARNING, AlertMessage.AlertDescription.NO_RENEGOTIATION, connection.getPeerAddress()), connection.getEstablishedSession());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNewClientHello(final Record record) {
        DTLSSession establishedSession;
        InetSocketAddress peerAddress = record.getPeerAddress();
        Logger logger = LOGGER;
        if (logger.isTraceEnabled()) {
            logger.trace("Processing new CLIENT_HELLO from peer [" + peerAddress + "]:" + StringUtil.lineSeparator() + record);
        }
        try {
            try {
                record.applySession(null);
                DTLSMessage fragment = record.getFragment();
                if (fragment instanceof FragmentedHandshakeMessage) {
                    logger.debug("Received unsupported fragmented CLIENT_HELLO from peer [{}].", peerAddress);
                    discardRecord(record, new DtlsException("Fragmented CLIENT_HELLO is not supported!", peerAddress));
                    return;
                }
                final ClientHello clientHello = (ClientHello) fragment;
                final AvailableConnections availableConnections = new AvailableConnections();
                if (isClientInControlOfSourceIpAddress(clientHello, record, availableConnections)) {
                    ExecutorService executorService = getExecutorService();
                    synchronized (this.connectionStore) {
                        try {
                            Connection connection = this.connectionStore.get(peerAddress);
                            boolean z = false;
                            if (connection != null && !connection.isStartedByClientHello(clientHello)) {
                                Connection connectionBySessionId = availableConnections.getConnectionBySessionId();
                                if (connectionBySessionId == null || connectionBySessionId == connection) {
                                    if (connectionBySessionId != null && connectionBySessionId == connection) {
                                        availableConnections.setRemoveConnectionBySessionId(true);
                                    }
                                    final Handshaker ongoingHandshake = connection.getOngoingHandshake();
                                    if (ongoingHandshake != null && ((establishedSession = connection.getEstablishedSession()) == null || ongoingHandshake.getSession() != establishedSession)) {
                                        final DtlsException dtlsException = new DtlsException("Received new CLIENT_HELLO from " + StringUtil.toDisplayString(peerAddress), peerAddress);
                                        ongoingHandshake.setFailureCause(dtlsException);
                                        connection.getExecutor().execute(new Runnable() { // from class: org.eclipse.californium.scandium.DTLSConnector.13
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                if (DTLSConnector.this.running.get()) {
                                                    ongoingHandshake.handshakeFailed(dtlsException);
                                                }
                                            }
                                        });
                                    }
                                    connection = null;
                                } else {
                                    z = true;
                                }
                            }
                            if (connection == null) {
                                connection = new Connection(peerAddress, new SerialExecutor(executorService));
                                connection.setExecutionListener(null);
                                connection.startByClientHello(clientHello);
                                if (!this.connectionStore.put(connection)) {
                                    return;
                                }
                            }
                            if (z) {
                                sendHelloVerify(clientHello, record, null);
                                return;
                            }
                            availableConnections.setConnectionByAddress(connection);
                            try {
                                connection.getExecutor().execute(new Runnable() { // from class: org.eclipse.californium.scandium.DTLSConnector.14
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (DTLSConnector.this.running.get()) {
                                            DTLSConnector.this.processClientHello(clientHello, record, availableConnections);
                                        }
                                    }
                                });
                            } catch (RejectedExecutionException e) {
                                LOGGER.debug("Execution rejected while processing record [type: {}, peer: {}]", record.getType(), peerAddress, e);
                            } catch (RuntimeException e2) {
                                LOGGER.warn("Unexpected error occurred while processing record [type: {}, peer: {}]", record.getType(), peerAddress, e2);
                                terminateConnection(availableConnections.getConnectionByAddress(), e2, AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR);
                            }
                        } finally {
                        }
                    }
                }
            } catch (RuntimeException e3) {
                LOGGER.warn("Processing new CLIENT_HELLO from peer [{}] failed!", record.getPeerAddress(), e3);
            }
        } catch (GeneralSecurityException e4) {
            DROP_LOGGER.debug("Processing new CLIENT_HELLO from peer [{}] failed!", record.getPeerAddress(), e4);
        } catch (HandshakeException e5) {
            LOGGER.debug("Processing new CLIENT_HELLO from peer [{}] failed!", record.getPeerAddress(), e5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void resumeExistingSession(ClientHello clientHello, Record record, AvailableConnections availableConnections) throws HandshakeException {
        SessionTicket sessionTicket;
        boolean zEquals;
        InetSocketAddress peerAddress = record.getPeerAddress();
        Logger logger = LOGGER;
        logger.trace("Client [{}] wants to resume session with ID [{}]", peerAddress, clientHello.getSessionId());
        if (availableConnections == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("available connections must not be null!");
            return;
        }
        Connection connectionByAddress = availableConnections.getConnectionByAddress();
        if (connectionByAddress == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("connection by address must not be null!");
            return;
        }
        if (!connectionByAddress.equalsPeerAddress(peerAddress)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("connection must have records address!");
            return;
        }
        if (!availableConnections.isConnectionBySessionIdKnown()) {
            availableConnections.setConnectionBySessionId(this.connectionStore.find(clientHello.getSessionId()));
        }
        Connection connectionBySessionId = availableConnections.getConnectionBySessionId();
        if (connectionBySessionId == null || !connectionBySessionId.isActive()) {
            sessionTicket = null;
        } else {
            SessionTicket sessionTicket2 = connectionBySessionId.hasEstablishedSession() ? connectionBySessionId.getEstablishedSession().getSessionTicket() : connectionBySessionId.getSessionTicket();
            if (sessionTicket2 == null || !this.config.isSniEnabled().booleanValue()) {
                zEquals = true;
                if (!zEquals || sessionTicket2 == null) {
                    sessionTicket = sessionTicket2;
                } else {
                    SecretUtil.destroy(sessionTicket2);
                    sessionTicket = null;
                }
            } else {
                ServerNames serverNames = sessionTicket2.getServerNames();
                ServerNameExtension serverNameExtension = clientHello.getServerNameExtension();
                ServerNames serverNames2 = serverNameExtension != null ? serverNameExtension.getServerNames() : null;
                if (serverNames != null) {
                    zEquals = serverNames.equals(serverNames2);
                } else if (serverNames2 != null) {
                    zEquals = false;
                }
                if (zEquals) {
                }
                sessionTicket = sessionTicket2;
            }
        }
        if (sessionTicket == null) {
            logger.trace("Client [{}] tries to resume non-existing session [ID={}], performing full handshake instead ...", peerAddress, clientHello.getSessionId());
            startNewHandshake(clientHello, record, connectionByAddress);
            return;
        }
        ResumingServerHandshaker resumingServerHandshaker = new ResumingServerHandshaker(clientHello.getMessageSeq(), new DTLSSession(clientHello.getSessionId(), peerAddress, sessionTicket, record.getSequenceNumber()), this, this.timer, connectionByAddress, this.config);
        initializeHandshaker(resumingServerHandshaker);
        SecretUtil.destroy(sessionTicket);
        if (connectionBySessionId.hasEstablishedSession()) {
            if (availableConnections.isRemoveConnectionBySessionId()) {
                this.connectionStore.remove(connectionBySessionId, false);
            } else if (clientHello.getCookie().length == 0) {
                this.pendingHandshakesWithoutVerifiedPeer.incrementAndGet();
                resumingServerHandshaker.addSessionListener(new SessionAdapter() { // from class: org.eclipse.californium.scandium.DTLSConnector.15
                    @Override // org.eclipse.californium.scandium.dtls.SessionListener
                    public void handshakeFailed(Handshaker handshaker, Throwable th) {
                        DTLSConnector.this.pendingHandshakesWithoutVerifiedPeer.decrementAndGet();
                    }

                    @Override // org.eclipse.californium.scandium.dtls.SessionListener
                    public void sessionEstablished(Handshaker handshaker, DTLSSession dTLSSession) {
                        DTLSConnector.this.pendingHandshakesWithoutVerifiedPeer.decrementAndGet();
                    }
                });
            }
        }
        resumingServerHandshaker.processMessage(record);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e A[PHI: r0
      0x002e: PHI (r0v2 org.eclipse.californium.scandium.dtls.ProtocolVersion) = 
      (r0v1 org.eclipse.californium.scandium.dtls.ProtocolVersion)
      (r0v4 org.eclipse.californium.scandium.dtls.ProtocolVersion)
     binds: [B:6:0x0015, B:11:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void sendHelloVerify(ClientHello clientHello, Record record, byte[] bArr) {
        ProtocolVersion protocolVersion;
        LOGGER.trace("Verifying client IP address [{}] using HELLO_VERIFY_REQUEST", record.getPeerAddress());
        if (bArr == null) {
            bArr = this.cookieGenerator.generateCookie(clientHello);
        }
        ProtocolVersion clientVersion = this.protocolVersionForHelloVerifyRequests;
        if (clientVersion == null) {
            clientVersion = clientHello.getClientVersion();
            ProtocolVersion protocolVersion2 = ProtocolVersion.VERSION_DTLS_1_0;
            if (clientVersion.compareTo(protocolVersion2) >= 0) {
                protocolVersion2 = ProtocolVersion.VERSION_DTLS_1_2;
                if (clientVersion.compareTo(protocolVersion2) <= 0) {
                    protocolVersion = clientVersion;
                }
            }
            protocolVersion = protocolVersion2;
        }
        HelloVerifyRequest helloVerifyRequest = new HelloVerifyRequest(protocolVersion, bArr, record.getPeerAddress());
        helloVerifyRequest.setMessageSeq(clientHello.getMessageSeq());
        try {
            sendRecord(new Record(ContentType.HANDSHAKE, protocolVersion, record.getSequenceNumber(), helloVerifyRequest, record.getPeerAddress()));
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(long j, RawData rawData, Connection connection) throws HandshakeException {
        if (connection.getPeerAddress() == null) {
            DROP_LOGGER.info("Drop outgoing record with {} bytes, connection lost address {}! (shift {}ms)", Integer.valueOf(rawData.getSize()), rawData.getInetSocketAddress(), Long.valueOf((ClockUtil.nanoRealtime() - j) / 1000000));
            rawData.onError(new EndpointUnconnectedException("connection not longer assigned to address!"));
            DtlsHealth dtlsHealth = this.health;
            if (dtlsHealth != null) {
                dtlsHealth.sendingRecord(true);
                return;
            }
            return;
        }
        LOGGER.trace("Sending application layer message to [{}]", rawData.getEndpointContext());
        Handshaker ongoingHandshake = connection.getOngoingHandshake();
        if (ongoingHandshake != null && !ongoingHandshake.hasSessionEstablished()) {
            if (ongoingHandshake.isExpired()) {
                ongoingHandshake.handshakeAborted(new Exception("handshake already expired!"));
            } else if (ongoingHandshake.isProbing()) {
                if (checkOutboundEndpointContext(rawData, null)) {
                    rawData.onConnecting();
                    ongoingHandshake.addApplicationDataForDeferredProcessing(rawData);
                    return;
                }
                return;
            }
        }
        if (!connection.isActive() || connection.isClosed()) {
            sendMessageWithoutSession(rawData, connection);
        } else {
            sendMessageWithSession(rawData, connection);
        }
    }

    private void sendMessageWithSession(RawData rawData, Connection connection) throws HandshakeException {
        SessionId sessionId;
        SessionTicket sessionTicket;
        boolean z;
        ClientHandshaker resumingClientHandshaker;
        DTLSSession establishedSession = connection.getEstablishedSession();
        boolean z2 = establishedSession != null && establishedSession.isMarkedAsClosed();
        String effectiveHandshakeMode = getEffectiveHandshakeMode(rawData);
        if (!IntegrityManager.INTEGRITY_TYPE_NONE.equals(effectiveHandshakeMode)) {
            boolean zEquals = "probe".equals(effectiveHandshakeMode);
            boolean zEquals2 = "full".equals(effectiveHandshakeMode);
            if (zEquals || zEquals2 || "force".equals(effectiveHandshakeMode) || z2 || connection.isAutoResumptionRequired(getAutResumptionTimeout(rawData))) {
                if (this.serverOnly) {
                    DROP_LOGGER.trace("DTLSConnector drops {} outgoing bytes to {}:{}, server only, resumption requested failed!", Integer.valueOf(rawData.getSize()), rawData.getAddress(), Integer.valueOf(rawData.getPort()));
                    rawData.onError(new EndpointUnconnectedException("server only, resumption requested failed!"));
                    DtlsHealth dtlsHealth = this.health;
                    if (dtlsHealth != null) {
                        dtlsHealth.sendingRecord(true);
                        return;
                    }
                    return;
                }
                rawData.onConnecting();
                Handshaker ongoingHandshake = connection.getOngoingHandshake();
                SessionTicket sessionTicket2 = null;
                if (zEquals2) {
                    sessionId = null;
                    sessionTicket = null;
                } else {
                    SessionId sessionIdentifier = establishedSession != null ? establishedSession.getSessionIdentifier() : connection.getSessionIdentity();
                    if (!sessionIdentifier.isEmpty()) {
                        if (establishedSession != null) {
                            try {
                                sessionTicket2 = establishedSession.getSessionTicket();
                            } catch (IllegalStateException unused) {
                                LOGGER.debug("Not possible to resume incomplete session!");
                            }
                        } else {
                            sessionTicket2 = connection.getSessionTicket();
                        }
                    }
                    sessionTicket = sessionTicket2;
                    sessionId = sessionIdentifier;
                }
                if (establishedSession != null) {
                    if (!zEquals) {
                        this.connectionStore.removeFromEstablishedSessions(establishedSession, connection);
                    }
                    z = zEquals;
                } else {
                    z = false;
                }
                if (z) {
                    connection.setResumptionRequired(false);
                } else {
                    connection.resetSession();
                }
                if (sessionTicket == null) {
                    DTLSSession dTLSSession = new DTLSSession(rawData.getInetSocketAddress());
                    dTLSSession.setHostName(rawData.getEndpointContext().getVirtualHost());
                    resumingClientHandshaker = new ClientHandshaker(dTLSSession, this, this.timer, connection, this.config, z);
                } else {
                    DTLSSession dTLSSession2 = new DTLSSession(sessionId, rawData.getInetSocketAddress(), sessionTicket, 0L);
                    SecretUtil.destroy(sessionTicket);
                    dTLSSession2.setHostName(rawData.getEndpointContext().getVirtualHost());
                    resumingClientHandshaker = new ResumingClientHandshaker(dTLSSession2, this, this.timer, connection, this.config, z);
                }
                initializeHandshaker(resumingClientHandshaker);
                if (ongoingHandshake != null) {
                    resumingClientHandshaker.takeDeferredApplicationData(ongoingHandshake);
                    ongoingHandshake.handshakeAborted(new Exception("handshake replaced!"));
                }
                resumingClientHandshaker.addApplicationDataForDeferredProcessing(rawData);
                resumingClientHandshaker.startHandshake();
                return;
            }
        } else if (z2 || connection.isResumptionRequired()) {
            DROP_LOGGER.trace("DTLSConnector drops {} outgoing bytes to {}:{}, resumption required!", Integer.valueOf(rawData.getSize()), rawData.getAddress(), Integer.valueOf(rawData.getPort()));
            rawData.onError(new EndpointUnconnectedException("resumption required!"));
            DtlsHealth dtlsHealth2 = this.health;
            if (dtlsHealth2 != null) {
                dtlsHealth2.sendingRecord(true);
                return;
            }
            return;
        }
        sendMessage(rawData, connection, establishedSession);
    }

    private void sendMessageWithoutSession(RawData rawData, Connection connection) throws HandshakeException {
        if (checkOutboundEndpointContext(rawData, null)) {
            Handshaker ongoingHandshake = connection.getOngoingHandshake();
            if (ongoingHandshake != null) {
                rawData.onConnecting();
                ongoingHandshake.addApplicationDataForDeferredProcessing(rawData);
                return;
            }
            if (this.serverOnly) {
                DROP_LOGGER.trace("DTLSConnector drops {} outgoing bytes to {}:{}, server only, connection missing!", Integer.valueOf(rawData.getSize()), rawData.getAddress(), Integer.valueOf(rawData.getPort()));
                rawData.onError(new EndpointUnconnectedException("server only, connection missing!"));
                DtlsHealth dtlsHealth = this.health;
                if (dtlsHealth != null) {
                    dtlsHealth.sendingRecord(true);
                    return;
                }
                return;
            }
            if (getEffectiveHandshakeMode(rawData).contentEquals(IntegrityManager.INTEGRITY_TYPE_NONE)) {
                DROP_LOGGER.trace("DTLSConnector drops {} outgoing bytes to {}:{}, connection missing!", Integer.valueOf(rawData.getSize()), rawData.getAddress(), Integer.valueOf(rawData.getPort()));
                rawData.onError(new EndpointUnconnectedException("connection missing!"));
                DtlsHealth dtlsHealth2 = this.health;
                if (dtlsHealth2 != null) {
                    dtlsHealth2.sendingRecord(true);
                    return;
                }
                return;
            }
            DTLSSession dTLSSession = new DTLSSession(rawData.getInetSocketAddress());
            dTLSSession.setHostName(rawData.getEndpointContext().getVirtualHost());
            ClientHandshaker clientHandshaker = new ClientHandshaker(dTLSSession, this, this.timer, connection, this.config, false);
            initializeHandshaker(clientHandshaker);
            rawData.onConnecting();
            clientHandshaker.addApplicationDataForDeferredProcessing(rawData);
            clientHandshaker.startHandshake();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sessionEstablished(Handshaker handshaker, final DTLSSession dTLSSession) {
        try {
            final Connection connection = handshaker.getConnection();
            this.connectionStore.putEstablishedSession(dTLSSession, connection);
            SerialExecutor executor = connection.getExecutor();
            List<RawData> listTakeDeferredApplicationData = handshaker.takeDeferredApplicationData();
            if (!listTakeDeferredApplicationData.isEmpty()) {
                LOGGER.trace("Session with [{}] established, now process deferred {} messages", dTLSSession.getPeer(), Integer.valueOf(listTakeDeferredApplicationData.size()));
                for (final RawData rawData : listTakeDeferredApplicationData) {
                    executor.execute(new Runnable() { // from class: org.eclipse.californium.scandium.DTLSConnector.3
                        @Override // java.lang.Runnable
                        public void run() {
                            DTLSConnector.this.sendMessage(rawData, connection, dTLSSession);
                        }
                    });
                }
            }
            List<Record> listTakeDeferredRecords = handshaker.takeDeferredRecords();
            if (listTakeDeferredRecords.isEmpty()) {
                return;
            }
            LOGGER.trace("Session with [{}] established, now process deferred {} messages", dTLSSession.getPeer(), Integer.valueOf(listTakeDeferredRecords.size()));
            for (final Record record : listTakeDeferredRecords) {
                executor.execute(new Runnable() { // from class: org.eclipse.californium.scandium.DTLSConnector.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DTLSConnector.this.processRecord(record, connection);
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
            LOGGER.debug("stopping.");
        }
    }

    private void startNewHandshake(ClientHello clientHello, Record record, Connection connection) throws HandshakeException {
        ServerHandshaker serverHandshaker = new ServerHandshaker(clientHello.getMessageSeq(), new DTLSSession(record.getPeerAddress(), record.getSequenceNumber()), this, this.timer, connection, this.config);
        initializeHandshaker(serverHandshaker);
        serverHandshaker.processMessage(record);
    }

    private void terminateConnection(Connection connection, AlertMessage alertMessage, DTLSSession dTLSSession) {
        if (alertMessage == null) {
            LOGGER.trace("Terminating connection with peer [{}]", connection.getPeerAddress());
        } else if (dTLSSession == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Session must not be null, if alert message is to be sent");
            return;
        } else {
            LOGGER.trace("Terminating connection with peer [{}], reason [{}]", connection.getPeerAddress(), alertMessage.getDescription());
            send(alertMessage, dTLSSession);
        }
        if (alertMessage != null && alertMessage.getLevel() == AlertMessage.AlertLevel.WARNING && alertMessage.getDescription() == AlertMessage.AlertDescription.CLOSE_NOTIFY) {
            connection.setResumptionRequired(true);
        } else {
            this.connectionStore.remove(connection);
        }
    }

    private void terminateOngoingHandshake(Connection connection, HandshakeException handshakeException) {
        Handshaker ongoingHandshake = connection.getOngoingHandshake();
        if (ongoingHandshake != null) {
            Logger logger = LOGGER;
            if (logger.isTraceEnabled()) {
                logger.trace("Aborting handshake with peer [{}]:", connection.getPeerAddress(), handshakeException);
            } else if (logger.isDebugEnabled()) {
                logger.debug("Aborting handshake with peer [{}]: {}", connection.getPeerAddress(), handshakeException.getMessage());
            }
            ongoingHandshake.setFailureCause(handshakeException);
            AlertMessage alert = handshakeException.getAlert();
            DTLSSession session = ongoingHandshake.getSession();
            if (connection.hasEstablishedSession()) {
                if (connection.getEstablishedSession() != ongoingHandshake.getSession()) {
                    logger.warn("Handshake with [{}] failed, but has an established session!", ongoingHandshake.getPeerAddress());
                } else if (alert.getDescription() == AlertMessage.AlertDescription.CLOSE_NOTIFY) {
                    logger.debug("Handshake with [{}] closed after session was established!", ongoingHandshake.getPeerAddress());
                } else {
                    logger.warn("Handshake with [{}] failed after session was established! {}", ongoingHandshake.getPeerAddress(), alert);
                }
                send(alert, session);
            } else {
                terminateConnection(connection, alert, session);
            }
            ongoingHandshake.handshakeFailed(handshakeException);
        }
    }

    private void updateConnectionAddress(Record record, Connection connection, DTLSSession dTLSSession) {
        InetSocketAddress peerAddress;
        if (dTLSSession.markRecordAsRead(record.getEpoch(), record.getSequenceNumber()) || !this.useCidUpdateAddressOnNewerRecordFilter) {
            connection.setRouter(record.getRouter());
            peerAddress = record.getPeerAddress();
        } else {
            peerAddress = null;
        }
        connection.refreshAutoResumptionTime();
        this.connectionStore.update(connection, peerAddress);
        Handshaker ongoingHandshake = connection.getOngoingHandshake();
        if (ongoingHandshake != null) {
            ongoingHandshake.handshakeCompleted();
        }
    }

    public DtlsHealth createDefaultHealthHandler(DtlsConnectorConfig dtlsConnectorConfig) {
        return new DtlsHealthLogger(dtlsConnectorConfig.getLoggingTag());
    }

    @Override // org.eclipse.californium.scandium.dtls.RecordLayer
    public void dropReceivedRecord(Record record) {
        DROP_LOGGER.debug("Discarding {} record [epoch {}, rseqn {}] dropped by handshaker for peer [{}]", record.getType(), Integer.valueOf(record.getEpoch()), Long.valueOf(record.getSequenceNumber()), record.getPeerAddress());
        DtlsHealth dtlsHealth = this.health;
        if (dtlsHealth != null) {
            dtlsHealth.receivingRecord(true);
        }
    }

    @Override // org.eclipse.californium.elements.Connector
    public final InetSocketAddress getAddress() {
        DatagramSocket socket = getSocket();
        int localPort = socket == null ? -1 : socket.getLocalPort();
        return localPort < 0 ? this.config.getAddress() : new InetSocketAddress(socket.getLocalAddress(), localPort);
    }

    @Override // org.eclipse.californium.scandium.dtls.RecordLayer
    public int getMaxDatagramSize(boolean z) {
        int i = z ? 128 : 64;
        Integer num = this.maximumTransmissionUnit;
        int iIntValue = num != null ? num.intValue() : z ? this.ipv6Mtu : this.ipv4Mtu;
        int i2 = iIntValue - i;
        if (i2 < 64) {
            throw new IllegalStateException(String.format("%s, datagram size %d, mtu %d", z ? "IPV6" : "IPv4", Integer.valueOf(i2), Integer.valueOf(iIntValue)));
        }
        return i2;
    }

    @Override // org.eclipse.californium.elements.Connector
    public String getProtocol() {
        return "DTLS";
    }

    public void init(InetSocketAddress inetSocketAddress, DatagramSocket datagramSocket, Integer num) throws SocketException {
        Integer healthStatusInterval;
        this.socket = datagramSocket;
        this.pendingOutboundMessagesCountdown.set(this.config.getOutboundMessageBufferSize().intValue());
        if (inetSocketAddress.getPort() != 0 && this.config.isAddressReuseEnabled().booleanValue()) {
            Logger logger = LOGGER;
            logger.info("Enable address reuse for socket!");
            datagramSocket.setReuseAddress(true);
            if (!datagramSocket.getReuseAddress()) {
                logger.warn("Enable address reuse for socket failed!");
            }
        }
        Integer socketReceiveBufferSize = this.config.getSocketReceiveBufferSize();
        if (socketReceiveBufferSize != null) {
            try {
                if (socketReceiveBufferSize.intValue() != 0) {
                    datagramSocket.setReceiveBufferSize(socketReceiveBufferSize.intValue());
                }
            } catch (IllegalArgumentException e) {
                LOGGER.error("failed to apply {}", socketReceiveBufferSize, e);
            }
        }
        socketReceiveBufferSize = this.config.getSocketSendBufferSize();
        if (socketReceiveBufferSize != null && socketReceiveBufferSize.intValue() != 0) {
            datagramSocket.setSendBufferSize(socketReceiveBufferSize.intValue());
        }
        int receiveBufferSize = datagramSocket.getReceiveBufferSize();
        int sendBufferSize = datagramSocket.getSendBufferSize();
        if (!datagramSocket.isBound()) {
            datagramSocket.bind(inetSocketAddress);
        }
        if (this.lastBindAddress != null && (!datagramSocket.getLocalAddress().equals(this.lastBindAddress.getAddress()) || datagramSocket.getLocalPort() != this.lastBindAddress.getPort())) {
            ResumptionSupportingConnectionStore resumptionSupportingConnectionStore = this.connectionStore;
            ResumptionSupportingConnectionStore resumptionSupportingConnectionStore2 = this.connectionStore;
            if (resumptionSupportingConnectionStore != null) {
                resumptionSupportingConnectionStore2.markAllAsResumptionRequired();
            } else {
                resumptionSupportingConnectionStore2.clear();
            }
        }
        if (this.config.getMaxFragmentLengthCode() != null) {
            this.inboundDatagramBufferSize = MaxFragmentLengthExtension.Length.fromCode(this.config.getMaxFragmentLengthCode().intValue()).length() + MAX_CIPHERTEXT_EXPANSION + 25;
        }
        if (this.config.getMaxTransmissionUnit() != null) {
            Integer maxTransmissionUnit = this.config.getMaxTransmissionUnit();
            this.maximumTransmissionUnit = maxTransmissionUnit;
            LOGGER.info("Configured MTU [{}]", maxTransmissionUnit);
        } else if (num != null) {
            this.maximumTransmissionUnit = num;
            LOGGER.info("Forced MTU [{}]", num);
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            if (address.isAnyLocalAddress()) {
                this.ipv4Mtu = NetworkInterfacesUtil.getIPv4Mtu();
                this.ipv6Mtu = NetworkInterfacesUtil.getIPv6Mtu();
                LOGGER.info("multiple network interfaces, using smallest MTU [IPv4 {}, IPv6 {}]", Integer.valueOf(this.ipv4Mtu), Integer.valueOf(this.ipv6Mtu));
            } else {
                NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(address);
                boolean z = address instanceof Inet6Address;
                if (byInetAddress == null || byInetAddress.getMTU() <= 0) {
                    if (z) {
                        int iPv6Mtu = NetworkInterfacesUtil.getIPv6Mtu();
                        this.ipv6Mtu = iPv6Mtu;
                        LOGGER.info("Cannot determine MTU of network interface, using minimum MTU [{}] of IPv6 instead", Integer.valueOf(iPv6Mtu));
                    } else {
                        int iPv4Mtu = NetworkInterfacesUtil.getIPv4Mtu();
                        this.ipv4Mtu = iPv4Mtu;
                        LOGGER.info("Cannot determine MTU of network interface, using minimum MTU [{}] of IPv4 instead", Integer.valueOf(iPv4Mtu));
                    }
                } else if (z) {
                    this.ipv6Mtu = byInetAddress.getMTU();
                } else {
                    this.ipv4Mtu = byInetAddress.getMTU();
                }
            }
            int i = this.inboundDatagramBufferSize;
            int iIntValue = this.config.getMaxTransmissionUnitLimit().intValue();
            int i2 = this.ipv4Mtu;
            if (i > iIntValue) {
                if (i2 > this.config.getMaxTransmissionUnitLimit().intValue()) {
                    int iIntValue2 = this.config.getMaxTransmissionUnitLimit().intValue();
                    this.ipv4Mtu = iIntValue2;
                    LOGGER.info("Limit MTU IPv4[{}]", Integer.valueOf(iIntValue2));
                }
                if (this.ipv6Mtu > this.config.getMaxTransmissionUnitLimit().intValue()) {
                    int iIntValue3 = this.config.getMaxTransmissionUnitLimit().intValue();
                    this.ipv6Mtu = iIntValue3;
                    LOGGER.info("Limit MTU IPv6[{}]", Integer.valueOf(iIntValue3));
                }
            } else {
                int i3 = this.inboundDatagramBufferSize;
                if (i2 > i3) {
                    this.ipv4Mtu = i3;
                    LOGGER.info("Buffersize MTU IPv4[{}]", Integer.valueOf(i3));
                }
                int i4 = this.ipv6Mtu;
                int i5 = this.inboundDatagramBufferSize;
                if (i4 > i5) {
                    this.ipv6Mtu = i5;
                    LOGGER.info("Buffersize MTU IPv6[{}]", Integer.valueOf(i5));
                }
            }
        }
        this.lastBindAddress = new InetSocketAddress(datagramSocket.getLocalAddress(), datagramSocket.getLocalPort());
        ExecutorService executorService = this.executorService;
        if (executorService instanceof ScheduledExecutorService) {
            this.timer = (ScheduledExecutorService) executorService;
        } else {
            this.timer = ExecutorsUtil.newSingleThreadScheduledExecutor(new DaemonThreadFactory("DTLS-Timer-" + this.lastBindAddress + "#", NamedThreadFactory.SCANDIUM_THREAD_GROUP));
        }
        if (this.executorService == null) {
            int iIntValue4 = this.config.getConnectionThreadCount().intValue();
            if (iIntValue4 > 1) {
                this.executorService = ExecutorsUtil.newFixedThreadPool(iIntValue4 - 1, new DaemonThreadFactory("DTLS-Worker-" + this.lastBindAddress + "#", NamedThreadFactory.SCANDIUM_THREAD_GROUP));
            } else {
                this.executorService = this.timer;
            }
            this.hasInternalExecutor = true;
        }
        this.running.set(true);
        int iIntValue5 = this.config.getReceiverThreadCount().intValue();
        for (int i6 = 0; i6 < iIntValue5; i6++) {
            StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i6, "DTLS-Receiver-", "-");
            sbM65m.append(this.lastBindAddress);
            Worker worker = new Worker(sbM65m.toString()) { // from class: org.eclipse.californium.scandium.DTLSConnector.6
                private final DatagramPacket packet;
                private final byte[] receiverBuffer;

                {
                    byte[] bArr = new byte[DTLSConnector.this.inboundDatagramBufferSize];
                    this.receiverBuffer = bArr;
                    this.packet = new DatagramPacket(bArr, DTLSConnector.this.inboundDatagramBufferSize);
                }

                @Override // org.eclipse.californium.scandium.DTLSConnector.Worker
                public void doWork() throws IOException {
                    if (DTLSConnector.MDC_SUPPORT) {
                        MDC.clear();
                    }
                    this.packet.setData(this.receiverBuffer);
                    DTLSConnector.this.receiveNextDatagramFromNetwork(this.packet);
                }
            };
            worker.setDaemon(true);
            worker.start();
            this.receiverThreads.add(worker);
        }
        Integer num2 = this.maximumTransmissionUnit;
        LOGGER.info("DTLSConnector listening on {}, recv buf = {}, send buf = {}, recv packet size = {}, MTU = {}", this.lastBindAddress, Integer.valueOf(receiveBufferSize), Integer.valueOf(sendBufferSize), Integer.valueOf(this.inboundDatagramBufferSize), num2 != null ? num2.toString() : "IPv4 " + this.ipv4Mtu + " / IPv6 " + this.ipv6Mtu);
        DtlsHealth dtlsHealth = this.health;
        if (dtlsHealth == null || !dtlsHealth.isEnabled() || (healthStatusInterval = this.config.getHealthStatusInterval()) == null) {
            return;
        }
        this.statusLogger = this.timer.scheduleAtFixedRate(new Runnable() { // from class: org.eclipse.californium.scandium.DTLSConnector.7
            @Override // java.lang.Runnable
            public void run() {
                DTLSConnector dTLSConnector = DTLSConnector.this;
                dTLSConnector.health.dump(dTLSConnector.config.getLoggingTag(), DTLSConnector.this.config.getMaxConnections().intValue(), DTLSConnector.this.connectionStore.remainingCapacity(), DTLSConnector.this.pendingHandshakesWithoutVerifiedPeer.get());
            }
        }, healthStatusInterval.intValue(), healthStatusInterval.intValue(), TimeUnit.SECONDS);
    }

    @Override // org.eclipse.californium.scandium.dtls.RecordLayer
    public final boolean isRunning() {
        return this.running.get();
    }

    public void onInitializeHandshaker(Handshaker handshaker) {
    }

    public void processDatagram(DatagramPacket datagramPacket, InetSocketAddress inetSocketAddress) {
        InetSocketAddress inetSocketAddress2 = (InetSocketAddress) datagramPacket.getSocketAddress();
        if (MDC_SUPPORT) {
            MDC.put("PEER", StringUtil.toString(inetSocketAddress2));
        }
        DtlsHealth dtlsHealth = this.health;
        if (dtlsHealth != null) {
            dtlsHealth.receivingRecord(false);
        }
        List<Record> listFromReader = Record.fromReader(new DatagramReader(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength()), inetSocketAddress2, inetSocketAddress, this.connectionIdGenerator, ClockUtil.nanoRealtime());
        Logger logger = LOGGER;
        logger.trace("Received {} DTLS records from {} using a {} byte datagram buffer", Integer.valueOf(listFromReader.size()), inetSocketAddress2, Integer.valueOf(this.inboundDatagramBufferSize));
        if (listFromReader.isEmpty()) {
            DROP_LOGGER.trace("Discarding {} malicious record with {} bytes from [{}]", Integer.valueOf(datagramPacket.getLength()), inetSocketAddress2);
            DtlsHealth dtlsHealth2 = this.health;
            if (dtlsHealth2 != null) {
                dtlsHealth2.receivingRecord(true);
                return;
            }
            return;
        }
        if (!this.running.get()) {
            DROP_LOGGER.trace("Discarding {} records, startting with {} from [{}] on shutdown", Integer.valueOf(listFromReader.size()), listFromReader.get(0).getType(), inetSocketAddress2);
            logger.debug("Execution shutdown while processing incoming records from peer: {}", inetSocketAddress2);
            DtlsHealth dtlsHealth3 = this.health;
            if (dtlsHealth3 != null) {
                dtlsHealth3.receivingRecord(true);
                return;
            }
            return;
        }
        final Record record = listFromReader.get(0);
        if (listFromReader.size() == 1 && record.isNewClientHello()) {
            getExecutorService().execute(new Runnable() { // from class: org.eclipse.californium.scandium.DTLSConnector.11
                @Override // java.lang.Runnable
                public void run() {
                    if (DTLSConnector.MDC_SUPPORT) {
                        MDC.put("PEER", StringUtil.toString(record.getPeerAddress()));
                    }
                    DTLSConnector.this.processNewClientHello(record);
                    if (DTLSConnector.MDC_SUPPORT) {
                        MDC.clear();
                    }
                }
            });
            return;
        }
        ConnectionId connectionId = record.getConnectionId();
        final Connection connection = getConnection(inetSocketAddress2, connectionId, false);
        if (connection == null) {
            DtlsHealth dtlsHealth4 = this.health;
            if (dtlsHealth4 != null) {
                dtlsHealth4.receivingRecord(true);
            }
            if (connectionId == null) {
                DROP_LOGGER.trace("Discarding {} records from [{}] received without existing connection", Integer.valueOf(listFromReader.size()), inetSocketAddress2);
                return;
            } else {
                DROP_LOGGER.trace("Discarding {} records from [{},{}] received without existing connection", Integer.valueOf(listFromReader.size()), inetSocketAddress2, connectionId);
                return;
            }
        }
        SerialExecutor executor = connection.getExecutor();
        for (final Record record2 : listFromReader) {
            try {
                executor.execute(new Runnable() { // from class: org.eclipse.californium.scandium.DTLSConnector.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DTLSConnector.this.running.get()) {
                            DTLSConnector.this.processRecord(record2, connection);
                        }
                    }
                });
            } catch (RejectedExecutionException e) {
                LOGGER.debug("Execution rejected while processing record [type: {}, peer: {}]", record2.getType(), inetSocketAddress2, e);
                return;
            } catch (RuntimeException e2) {
                LOGGER.warn("Unexpected error occurred while processing record [type: {}, peer: {}]", record2.getType(), inetSocketAddress2, e2);
                terminateConnection(connection, e2, AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR);
                return;
            }
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.RecordLayer
    public void processRecord(Record record, Connection connection) {
        try {
            if (record.getConnectionId() == null && !connection.equalsPeerAddress(record.getPeerAddress())) {
                DROP_LOGGER.debug("Drop received record {}, connection changed address {} => {}! (shift {}ms)", record.getType(), record.getPeerAddress(), connection.getPeerAddress(), Long.valueOf((ClockUtil.nanoRealtime() - record.getReceiveNanos()) / 1000000));
                DtlsHealth dtlsHealth = this.health;
                if (dtlsHealth != null) {
                    dtlsHealth.receivingRecord(true);
                    return;
                }
                return;
            }
            int epoch = record.getEpoch();
            Logger logger = LOGGER;
            logger.trace("Received DTLS record of type [{}], length: {}, [epoche:{},rseqn:{}]", record.getType(), Integer.valueOf(record.getFragmentLength()), Integer.valueOf(epoch), Long.valueOf(record.getSequenceNumber()));
            Handshaker ongoingHandshake = connection.getOngoingHandshake();
            if (ongoingHandshake != null && ongoingHandshake.isExpired()) {
                ongoingHandshake.handshakeFailed(new Exception("handshake already expired!"));
                if (this.connectionStore.get(connection.getConnectionId()) != connection) {
                    DROP_LOGGER.debug("Discarding {} record [epoch {}, rseqn {}] received from peer [{}], handshake expired!", record.getType(), Integer.valueOf(epoch), Long.valueOf(record.getSequenceNumber()), record.getPeerAddress());
                    DtlsHealth dtlsHealth2 = this.health;
                    if (dtlsHealth2 != null) {
                        dtlsHealth2.receivingRecord(true);
                        return;
                    }
                    return;
                }
                ongoingHandshake = null;
            }
            DTLSSession session = connection.getSession(epoch);
            if (session == null) {
                if (ongoingHandshake != null && ongoingHandshake.getSession().getReadEpoch() == 0 && epoch == 1) {
                    ongoingHandshake.addRecordsForDeferredProcessing(record);
                    return;
                }
                DROP_LOGGER.debug("Discarding {} record [epoch {}, rseqn {}] received from peer [{}] without an active session", record.getType(), Integer.valueOf(epoch), Long.valueOf(record.getSequenceNumber()), record.getPeerAddress());
                DtlsHealth dtlsHealth3 = this.health;
                if (dtlsHealth3 != null) {
                    dtlsHealth3.receivingRecord(true);
                    return;
                }
                return;
            }
            boolean zIsClosed = connection.isClosed();
            if ((this.useFilter || zIsClosed) && !session.isRecordProcessable((long) epoch, record.getSequenceNumber(), this.useExtendedWindowFilter)) {
                if (zIsClosed) {
                    DROP_LOGGER.debug("Discarding {} record [epoch {}, rseqn {}] received from closed peer [{}]", record.getType(), Integer.valueOf(epoch), Long.valueOf(record.getSequenceNumber()), record.getPeerAddress());
                } else {
                    DROP_LOGGER.debug("Discarding duplicate {} record [epoch {}, rseqn {}] received from peer [{}]", record.getType(), Integer.valueOf(epoch), Long.valueOf(record.getSequenceNumber()), record.getPeerAddress());
                }
                DtlsHealth dtlsHealth4 = this.health;
                if (dtlsHealth4 != null) {
                    dtlsHealth4.receivingRecord(true);
                    return;
                }
                return;
            }
            if (record.getType() == ContentType.TLS12_CID) {
                if (epoch == 0) {
                    DROP_LOGGER.debug("Discarding TLS_CID record received from peer [{}] during handshake", record.getPeerAddress());
                    DtlsHealth dtlsHealth5 = this.health;
                    if (dtlsHealth5 != null) {
                        dtlsHealth5.receivingRecord(true);
                        return;
                    }
                    return;
                }
            } else if (epoch > 0 && connection.expectCid()) {
                DROP_LOGGER.debug("Discarding record received from peer [{}], CID required!", record.getPeerAddress());
                DtlsHealth dtlsHealth6 = this.health;
                if (dtlsHealth6 != null) {
                    dtlsHealth6.receivingRecord(true);
                    return;
                }
                return;
            }
            if (!record.isDecoded() || record.getType() != ContentType.APPLICATION_DATA) {
                record.applySession(session);
            }
            if (ongoingHandshake != null && ongoingHandshake.isProbing()) {
                if (connection.hasEstablishedSession()) {
                    this.connectionStore.removeFromEstablishedSessions(connection.getEstablishedSession(), connection);
                }
                connection.resetSession();
                ongoingHandshake.resetProbing();
                logger.trace("handshake probe successful {}", connection.getPeerAddress());
            }
            int i = AnonymousClass18.$SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[record.getType().ordinal()];
            if (i == 1) {
                processApplicationDataRecord(record, connection);
                return;
            }
            if (i == 2) {
                processAlertRecord(record, connection, session);
                return;
            }
            if (i == 3) {
                processChangeCipherSpecRecord(record, connection);
            } else if (i != 4) {
                DROP_LOGGER.debug("Discarding record of unsupported type [{}] from peer [{}]", record.getType(), record.getPeerAddress());
            } else {
                processHandshakeRecord(record, connection);
            }
        } catch (RuntimeException e) {
            DtlsHealth dtlsHealth7 = this.health;
            if (dtlsHealth7 != null) {
                dtlsHealth7.receivingRecord(true);
            }
            LOGGER.warn("Unexpected error occurred while processing record from peer [{}]", record.getPeerAddress(), e);
            terminateConnection(connection, e, AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR);
        } catch (GeneralSecurityException e2) {
            DROP_LOGGER.debug("Discarding {} received from peer [{}] caused by {}", record.getType(), record.getPeerAddress(), e2.getMessage());
            DtlsHealth dtlsHealth8 = this.health;
            if (dtlsHealth8 != null) {
                dtlsHealth8.receivingRecord(true);
            }
            LOGGER.debug("error occurred while processing record from peer [{}]", record.getPeerAddress(), e2);
        } catch (HandshakeException e3) {
            LOGGER.debug("error occurred while processing record from peer [{}]", record.getPeerAddress(), e3);
        }
    }

    public void receiveNextDatagramFromNetwork(DatagramPacket datagramPacket) throws IOException {
        DatagramSocket socket = getSocket();
        if (socket == null) {
            return;
        }
        socket.receive(datagramPacket);
        if (datagramPacket.getLength() == 0) {
            return;
        }
        processDatagram(datagramPacket);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    @Override // org.eclipse.californium.elements.Connector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void send(final RawData rawData) throws Throwable {
        final Connection connection;
        Throwable illegalArgumentException;
        if (rawData == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Message must not be null");
            return;
        }
        DtlsHealth dtlsHealth = this.health;
        if (dtlsHealth != null) {
            dtlsHealth.sendingRecord(false);
        }
        if (rawData.isMulticast()) {
            DROP_LOGGER.warn("DTLSConnector drops {} outgoing bytes to multicast {}:{}", Integer.valueOf(rawData.getSize()), rawData.getAddress(), Integer.valueOf(rawData.getPort()));
            rawData.onError(new MulticastNotSupportedException("DTLS doesn't support multicast!"));
            DtlsHealth dtlsHealth2 = this.health;
            if (dtlsHealth2 != null) {
                dtlsHealth2.sendingRecord(true);
                return;
            }
            return;
        }
        Throwable illegalStateException = null;
        if (!this.running.get()) {
            illegalArgumentException = new IllegalStateException("connector must be started before sending messages is possible");
        } else {
            if (rawData.getSize() <= 16384) {
                boolean z = this.serverOnly;
                boolean z2 = !z;
                if (!z) {
                    z2 = !getEffectiveHandshakeMode(rawData).equals(IntegrityManager.INTEGRITY_TYPE_NONE);
                }
                Connection connection2 = getConnection(rawData.getInetSocketAddress(), null, z2);
                if (connection2 == null) {
                    if (!z2) {
                        if (this.serverOnly) {
                            rawData.onError(new EndpointUnconnectedException("server only, connection missing!"));
                        } else {
                            rawData.onError(new EndpointUnconnectedException("connection missing!"));
                        }
                        DROP_LOGGER.debug("DTLSConnector drops {} outgoing bytes to {}:{}, connection missing!", Integer.valueOf(rawData.getSize()), rawData.getAddress(), Integer.valueOf(rawData.getPort()));
                        DtlsHealth dtlsHealth3 = this.health;
                        if (dtlsHealth3 != null) {
                            dtlsHealth3.sendingRecord(true);
                            return;
                        }
                        return;
                    }
                    illegalStateException = new IllegalStateException("connection store is exhausted!");
                }
                connection = connection2;
                if (illegalStateException == null) {
                    DROP_LOGGER.debug("DTLSConnector drops {} outgoing bytes to {}:{}, {}!", Integer.valueOf(rawData.getSize()), rawData.getAddress(), Integer.valueOf(rawData.getPort()), illegalStateException.getMessage());
                    rawData.onError(illegalStateException);
                    DtlsHealth dtlsHealth4 = this.health;
                    if (dtlsHealth4 == null) {
                        throw illegalStateException;
                    }
                    dtlsHealth4.sendingRecord(true);
                    throw illegalStateException;
                }
                final long jNanoRealtime = ClockUtil.nanoRealtime();
                if (this.pendingOutboundMessagesCountdown.decrementAndGet() < 0) {
                    this.pendingOutboundMessagesCountdown.incrementAndGet();
                    DROP_LOGGER.warn("Outbound message overflow! Dropping outbound message to peer [{}]", rawData.getInetSocketAddress());
                    rawData.onError(new IllegalStateException("Outbound message overflow!"));
                    DtlsHealth dtlsHealth5 = this.health;
                    if (dtlsHealth5 != null) {
                        dtlsHealth5.sendingRecord(true);
                        return;
                    }
                    return;
                }
                try {
                    SerialExecutor executor = connection.getExecutor();
                    try {
                        if (executor != null) {
                            executor.execute(new Runnable() { // from class: org.eclipse.californium.scandium.DTLSConnector.16
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        try {
                                            if (DTLSConnector.this.running.get()) {
                                                DTLSConnector.this.sendMessage(jNanoRealtime, rawData, connection);
                                            } else {
                                                DTLSConnector.DROP_LOGGER.trace("DTLSConnector drops {} outgoing bytes to {}:{}, connector not running!", Integer.valueOf(rawData.getSize()), rawData.getAddress(), Integer.valueOf(rawData.getPort()));
                                                rawData.onError(new InterruptedIOException("Connector is not running."));
                                                DtlsHealth dtlsHealth6 = DTLSConnector.this.health;
                                                if (dtlsHealth6 != null) {
                                                    dtlsHealth6.sendingRecord(true);
                                                }
                                            }
                                        } catch (Exception e) {
                                            if (DTLSConnector.this.running.get()) {
                                                DTLSConnector.LOGGER.warn("Exception thrown by executor thread [{}]", Thread.currentThread().getName(), e);
                                            }
                                            DTLSConnector.DROP_LOGGER.trace("DTLSConnector drops {} outgoing bytes to {}:{}, {}", Integer.valueOf(rawData.getSize()), rawData.getAddress(), Integer.valueOf(rawData.getPort()), e.getMessage());
                                            DtlsHealth dtlsHealth7 = DTLSConnector.this.health;
                                            if (dtlsHealth7 != null) {
                                                dtlsHealth7.sendingRecord(true);
                                            }
                                            rawData.onError(e);
                                        }
                                        DTLSConnector.this.pendingOutboundMessagesCountdown.incrementAndGet();
                                    } catch (Throwable th) {
                                        DTLSConnector.this.pendingOutboundMessagesCountdown.incrementAndGet();
                                        throw th;
                                    }
                                }
                            });
                            return;
                        } else {
                            throw new NullPointerException("missing executor for connection! " + connection.getPeerAddress());
                        }
                    } catch (RejectedExecutionException e) {
                        e = e;
                    }
                } catch (RejectedExecutionException e2) {
                    e = e2;
                }
                RejectedExecutionException rejectedExecutionException = e;
                LOGGER.debug("Execution rejected while sending application record [peer: {}]", rawData.getInetSocketAddress(), rejectedExecutionException);
                DROP_LOGGER.trace("DTLSConnector drops {} outgoing bytes to {}:{}, {}", Integer.valueOf(rawData.getSize()), rawData.getAddress(), Integer.valueOf(rawData.getPort()), rejectedExecutionException.getMessage());
                rawData.onError(new InterruptedIOException("Connector is not running."));
                DtlsHealth dtlsHealth6 = this.health;
                if (dtlsHealth6 != null) {
                    dtlsHealth6.sendingRecord(true);
                    return;
                }
                return;
            }
            illegalArgumentException = new IllegalArgumentException("Message data must not exceed 16384 bytes");
        }
        connection = null;
        illegalStateException = illegalArgumentException;
        if (illegalStateException == null) {
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.RecordLayer
    public void sendFlight(List<DatagramPacket> list) throws IOException {
        for (DatagramPacket datagramPacket : list) {
            DtlsHealth dtlsHealth = this.health;
            if (dtlsHealth != null) {
                dtlsHealth.sendingRecord(false);
            }
            sendNextDatagramOverNetwork(datagramPacket);
        }
    }

    public void sendNextDatagramOverNetwork(DatagramPacket datagramPacket) throws IOException {
        DatagramSocket socket = getSocket();
        if (socket != null && !socket.isClosed()) {
            try {
                socket.send(datagramPacket);
                return;
            } catch (PortUnreachableException unused) {
                if (!socket.isClosed()) {
                    LOGGER.warn("Could not send record, destination {} unreachable!", StringUtil.toString((InetSocketAddress) datagramPacket.getSocketAddress()));
                }
            } catch (IOException e) {
                if (!socket.isClosed()) {
                    LOGGER.warn("Could not send record", (Throwable) e);
                    throw e;
                }
            }
        }
        InetSocketAddress address = this.lastBindAddress;
        if (address == null) {
            address = this.config.getAddress();
        }
        DROP_LOGGER.debug("Socket [{}] is closed, discarding packet ...", address);
        OggIO$$ExternalSyntheticBUOutline0.m("Socket closed.");
    }

    public void sendRecord(Record record) throws IOException {
        if (this.health != null && record.getType() != ContentType.APPLICATION_DATA) {
            this.health.sendingRecord(false);
        }
        byte[] byteArray = record.toByteArray();
        sendNextDatagramOverNetwork(new DatagramPacket(byteArray, byteArray.length, record.getPeerAddress()));
    }

    @Override // org.eclipse.californium.elements.Connector
    public void setEndpointContextMatcher(EndpointContextMatcher endpointContextMatcher) {
        this.endpointContextMatcher = endpointContextMatcher;
    }

    @Override // org.eclipse.californium.elements.Connector
    public void setRawDataReceiver(RawDataChannel rawDataChannel) {
        if (isRunning()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("message handler cannot be set on running connector");
        } else {
            this.messageHandler = rawDataChannel;
        }
    }

    public void start(InetSocketAddress inetSocketAddress) throws SocketException {
        if (this.running.get()) {
            return;
        }
        init(inetSocketAddress, new DatagramSocket((SocketAddress) null), this.config.getMaxTransmissionUnit());
    }

    @Override // org.eclipse.californium.elements.Connector
    public void stop() {
        ExecutorService executorService;
        ExecutorService executorService2;
        ScheduledExecutorService scheduledExecutorService;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                executorService = null;
                if (this.running.compareAndSet(true, false)) {
                    ScheduledFuture<?> scheduledFuture = this.statusLogger;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                        this.statusLogger = null;
                    }
                    LOGGER.info("Stopping DTLS connector on [{}]", this.lastBindAddress);
                    Iterator<Thread> it = this.receiverThreads.iterator();
                    while (it.hasNext()) {
                        it.next().interrupt();
                    }
                    if (this.socket != null) {
                        this.socket.close();
                        this.socket = null;
                    }
                    this.maximumTransmissionUnit = null;
                    this.ipv4Mtu = 576;
                    this.ipv6Mtu = 1280;
                    this.connectionStore.stop(arrayList);
                    ExecutorService executorService3 = this.executorService;
                    ScheduledExecutorService scheduledExecutorService2 = this.timer;
                    if (executorService3 != scheduledExecutorService2) {
                        arrayList.addAll(scheduledExecutorService2.shutdownNow());
                        scheduledExecutorService = this.timer;
                        this.timer = null;
                    } else {
                        scheduledExecutorService = null;
                    }
                    if (this.hasInternalExecutor) {
                        arrayList.addAll(this.executorService.shutdownNow());
                        ExecutorService executorService4 = this.executorService;
                        this.executorService = null;
                        this.hasInternalExecutor = false;
                        executorService = executorService4;
                    }
                    for (Thread thread : this.receiverThreads) {
                        thread.interrupt();
                        try {
                            thread.join(500L);
                        } catch (InterruptedException unused) {
                        }
                    }
                    this.receiverThreads.clear();
                    ExecutorService executorService5 = executorService;
                    executorService = scheduledExecutorService;
                    executorService2 = executorService5;
                } else {
                    executorService2 = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (executorService != null) {
            try {
                if (!executorService.awaitTermination(500L, TimeUnit.MILLISECONDS)) {
                    LOGGER.warn("Shutdown DTLS connector on [{}] timer not terminated in time!", this.lastBindAddress);
                }
            } catch (InterruptedException unused2) {
            }
        }
        if (executorService2 != null) {
            try {
                if (!executorService2.awaitTermination(500L, TimeUnit.MILLISECONDS)) {
                    LOGGER.warn("Shutdown DTLS connector on [{}] executor not terminated in time!", this.lastBindAddress);
                }
            } catch (InterruptedException unused3) {
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                ((Runnable) it2.next()).run();
            } catch (Exception e) {
                LOGGER.warn("Shutdown DTLS connector:", (Throwable) e);
            }
        }
    }

    public String toString() {
        return getProtocol() + "-" + StringUtil.toString(getAddress());
    }

    @Override // org.eclipse.californium.elements.Connector
    public final synchronized void start() {
        start(this.config.getAddress());
    }

    private void terminateConnection(Connection connection, Throwable th, AlertMessage.AlertLevel alertLevel, AlertMessage.AlertDescription alertDescription) {
        if (connection.hasEstablishedSession()) {
            terminateConnection(connection, new AlertMessage(alertLevel, alertDescription, connection.getPeerAddress()), connection.getEstablishedSession());
        } else if (connection.hasOngoingHandshake()) {
            terminateConnection(connection, new AlertMessage(alertLevel, alertDescription, connection.getPeerAddress()), connection.getOngoingHandshake().getSession());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(RawData rawData, Connection connection, DTLSSession dTLSSession) {
        try {
            LOGGER.trace("send {}-{} using {}-{}", connection.getConnectionId(), connection.getPeerAddress(), dTLSSession.getSessionIdentifier(), dTLSSession.getPeer());
            DtlsEndpointContext connectionWriteContext = dTLSSession.getConnectionWriteContext();
            if (checkOutboundEndpointContext(rawData, connectionWriteContext)) {
                rawData.onContextEstablished(connectionWriteContext);
                sendRecord(new Record(ContentType.APPLICATION_DATA, dTLSSession.getWriteEpoch(), dTLSSession.getSequenceNumber(), (DTLSMessage) new ApplicationMessage(rawData.getBytes(), rawData.getInetSocketAddress()), dTLSSession, true, 0));
                rawData.onSent();
                connection.refreshAutoResumptionTime();
            }
        } catch (IOException e) {
            rawData.onError(e);
        } catch (GeneralSecurityException e2) {
            DROP_LOGGER.warn("Cannot send APPLICATION record to peer [{}]", rawData.getInetSocketAddress(), e2);
            rawData.onError(e2);
        }
    }

    public DTLSConnector(DtlsConnectorConfig dtlsConnectorConfig, SessionCache sessionCache) {
        this(dtlsConnectorConfig, createConnectionStore(dtlsConnectorConfig, sessionCache));
    }

    public DTLSConnector(DtlsConnectorConfig dtlsConnectorConfig) {
        this(dtlsConnectorConfig, (SessionCache) null);
    }

    @Deprecated
    public void processDatagram(DatagramPacket datagramPacket) {
        processDatagram(datagramPacket, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void send(AlertMessage alertMessage, DTLSSession dTLSSession) {
        DTLSSession dTLSSession2;
        GeneralSecurityException generalSecurityException;
        Record record;
        if (alertMessage == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Alert must not be NULL");
            return;
        }
        if (dTLSSession != null) {
            try {
                try {
                    LOGGER.trace("send ALERT {} for peer {}.", alertMessage, dTLSSession.getPeer());
                    boolean z = dTLSSession.getWriteEpoch() > 0;
                    if (!z) {
                        try {
                            if (alertMessage.getProtocolVersion() != null) {
                                record = new Record(ContentType.ALERT, alertMessage.getProtocolVersion(), dTLSSession.getSequenceNumber(), alertMessage, dTLSSession.getPeer());
                                dTLSSession2 = dTLSSession;
                            } else {
                                dTLSSession2 = dTLSSession;
                                try {
                                    record = new Record(ContentType.ALERT, dTLSSession.getWriteEpoch(), dTLSSession.getSequenceNumber(), alertMessage, dTLSSession2, z, 0);
                                } catch (GeneralSecurityException e) {
                                    e = e;
                                    generalSecurityException = e;
                                    DROP_LOGGER.warn("Cannot create ALERT message for peer [{}]", dTLSSession2.getPeer(), generalSecurityException);
                                    return;
                                }
                            }
                        } catch (GeneralSecurityException e2) {
                            generalSecurityException = e2;
                            dTLSSession2 = dTLSSession;
                            DROP_LOGGER.warn("Cannot create ALERT message for peer [{}]", dTLSSession2.getPeer(), generalSecurityException);
                            return;
                        }
                    }
                    sendRecord(record);
                } catch (GeneralSecurityException e3) {
                    e = e3;
                    dTLSSession2 = dTLSSession;
                }
            } catch (IOException unused) {
            }
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Session must not be NULL");
        }
    }
}
