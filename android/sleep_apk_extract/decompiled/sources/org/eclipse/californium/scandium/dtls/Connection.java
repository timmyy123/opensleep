package org.eclipse.californium.scandium.dtls;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ConcurrentModificationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.ClockUtil;
import org.eclipse.californium.elements.util.SerialExecutor;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.ConnectionExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class Connection {
    private static final Logger LOGGER;
    private static final Logger LOGGER_OWNER;
    private ConnectionId cid;
    private volatile DTLSSession establishedSession;
    private long lastMessageNanos;
    private long lastPeerAddressNanos;
    private InetSocketAddress peerAddress;
    private volatile boolean resumptionRequired;
    private AlertMessage rootCause;
    private InetSocketAddress router;
    private SerialExecutor serialExecutor;
    private SessionId sessionId;
    private int startingClientHelloMessageSeq;
    private volatile Random startingClientHelloRandom;
    private SessionTicket ticket;
    private final AtomicReference<Handshaker> ongoingHandshake = new AtomicReference<>();
    private final SessionListener sessionListener = new ConnectionSessionListener();

    public class ConnectionSessionListener implements SessionListener {
        private ConnectionSessionListener() {
        }

        @Override // org.eclipse.californium.scandium.dtls.SessionListener
        public void handshakeCompleted(Handshaker handshaker) {
            SerialExecutor serialExecutor = Connection.this.serialExecutor;
            if (serialExecutor != null && !serialExecutor.isShutdown() && Connection.LOGGER_OWNER.isErrorEnabled()) {
                try {
                    serialExecutor.assertOwner();
                } catch (ConcurrentModificationException e) {
                    Connection.LOGGER_OWNER.error("on handshake completed: connection {}", e.getMessage(), e);
                    if (Connection.LOGGER_OWNER.isDebugEnabled()) {
                        throw e;
                    }
                }
            }
            AtomicReference atomicReference = Connection.this.ongoingHandshake;
            while (!atomicReference.compareAndSet(handshaker, null)) {
                if (atomicReference.get() != handshaker) {
                    return;
                }
            }
            Connection.LOGGER.debug("Handshake with [{}] has been completed", handshaker.getPeerAddress());
        }

        @Override // org.eclipse.californium.scandium.dtls.SessionListener
        public void handshakeFailed(Handshaker handshaker, Throwable th) {
            SerialExecutor serialExecutor = Connection.this.serialExecutor;
            if (serialExecutor != null && !serialExecutor.isShutdown() && Connection.LOGGER_OWNER.isErrorEnabled()) {
                try {
                    serialExecutor.assertOwner();
                } catch (ConcurrentModificationException e) {
                    Connection.LOGGER_OWNER.error("on handshake failed: connection {}", e.getMessage(), e);
                    if (Connection.LOGGER_OWNER.isDebugEnabled()) {
                        throw e;
                    }
                }
            }
            AtomicReference atomicReference = Connection.this.ongoingHandshake;
            while (!atomicReference.compareAndSet(handshaker, null)) {
                if (atomicReference.get() != handshaker) {
                    return;
                }
            }
            Connection.this.startingClientHelloRandom = null;
            Connection.LOGGER.debug("Handshake with [{}] has failed", handshaker.getPeerAddress());
        }

        @Override // org.eclipse.californium.scandium.dtls.SessionListener
        public void handshakeFlightRetransmitted(Handshaker handshaker, int i) {
        }

        @Override // org.eclipse.californium.scandium.dtls.SessionListener
        public void handshakeStarted(Handshaker handshaker) {
            Connection.this.ongoingHandshake.set(handshaker);
            Connection.LOGGER.debug("Handshake with [{}] has been started", handshaker.getPeerAddress());
        }

        @Override // org.eclipse.californium.scandium.dtls.SessionListener
        public void sessionEstablished(Handshaker handshaker, DTLSSession dTLSSession) {
            Connection.this.establishedSession = dTLSSession;
            Connection.LOGGER.debug("Session with [{}] has been established", dTLSSession.getPeer());
        }
    }

    static {
        Logger logger = LoggerFactory.getLogger((Class<?>) Connection.class);
        LOGGER = logger;
        LOGGER_OWNER = LoggerFactory.getLogger(logger.getName() + ".owner");
    }

    public Connection(InetSocketAddress inetSocketAddress, SerialExecutor serialExecutor) {
        if (inetSocketAddress == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Peer address must not be null");
            throw null;
        }
        if (serialExecutor == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Serial executor must not be null");
            throw null;
        }
        long jNanoRealtime = ClockUtil.nanoRealtime();
        this.sessionId = null;
        this.ticket = null;
        this.peerAddress = inetSocketAddress;
        this.serialExecutor = serialExecutor;
        this.lastPeerAddressNanos = jNanoRealtime;
        this.lastMessageNanos = jNanoRealtime;
    }

    public void close(Record record) {
        DTLSSession dTLSSession = this.establishedSession;
        if (dTLSSession != null) {
            dTLSSession.markCloseNotiy(record.getEpoch(), record.getSequenceNumber());
        }
    }

    public boolean equalsPeerAddress(InetSocketAddress inetSocketAddress) {
        InetSocketAddress inetSocketAddress2 = this.peerAddress;
        if (inetSocketAddress2 == inetSocketAddress) {
            return true;
        }
        if (inetSocketAddress2 == null) {
            return false;
        }
        return inetSocketAddress2.equals(inetSocketAddress);
    }

    public boolean expectCid() {
        DTLSSession session = getSession();
        return (session == null || session.getReadConnectionId() == null || session.getReadConnectionId().isEmpty()) ? false : true;
    }

    public ConnectionId getConnectionId() {
        return this.cid;
    }

    public DTLSSession getEstablishedSession() {
        return this.establishedSession;
    }

    public SerialExecutor getExecutor() {
        return this.serialExecutor;
    }

    public Handshaker getOngoingHandshake() {
        return this.ongoingHandshake.get();
    }

    public InetSocketAddress getPeerAddress() {
        return this.peerAddress;
    }

    public AlertMessage getRootCauseAlert() {
        return this.rootCause;
    }

    public DTLSSession getSession(int i) {
        DTLSSession session;
        DTLSSession dTLSSession = this.establishedSession;
        if (dTLSSession != null && dTLSSession.getReadEpoch() == i) {
            return dTLSSession;
        }
        Handshaker handshaker = this.ongoingHandshake.get();
        if (handshaker == null || (session = handshaker.getSession()) == null || session.getReadEpoch() != i) {
            return null;
        }
        return session;
    }

    public SessionId getSessionIdentity() {
        return this.sessionId;
    }

    public final SessionListener getSessionListener() {
        return this.sessionListener;
    }

    public SessionTicket getSessionTicket() {
        return this.ticket;
    }

    public boolean hasEstablishedSession() {
        return this.establishedSession != null;
    }

    public boolean hasOngoingHandshake() {
        return this.ongoingHandshake.get() != null;
    }

    public boolean isActive() {
        return (this.establishedSession == null && this.ticket == null) ? false : true;
    }

    public boolean isAutoResumptionRequired(Long l) {
        if (!this.resumptionRequired && l != null && this.establishedSession != null) {
            if (ClockUtil.nanoRealtime() - (TimeUnit.MILLISECONDS.toNanos(l.longValue()) + this.lastMessageNanos) > 0) {
                setResumptionRequired(true);
            }
        }
        return this.resumptionRequired;
    }

    public boolean isClosed() {
        DTLSSession dTLSSession = this.establishedSession;
        return dTLSSession != null && dTLSSession.isMarkedAsClosed();
    }

    public boolean isExecuting() {
        SerialExecutor serialExecutor = this.serialExecutor;
        return (serialExecutor == null || serialExecutor.isShutdown()) ? false : true;
    }

    public boolean isResumptionRequired() {
        return this.resumptionRequired;
    }

    public boolean isStartedByClientHello(ClientHello clientHello) {
        if (clientHello != null) {
            Random random = this.startingClientHelloRandom;
            return random != null && random.equals(clientHello.getRandom()) && this.startingClientHelloMessageSeq >= clientHello.getMessageSeq();
        }
        Types$$ExternalSyntheticBUOutline0.m$1("client hello must not be null!");
        return false;
    }

    public void refreshAutoResumptionTime() {
        this.lastMessageNanos = ClockUtil.nanoRealtime();
    }

    public void resetSession() {
        if (this.establishedSession == null && this.ticket == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("No session established nor ticket available!");
            return;
        }
        this.establishedSession = null;
        this.sessionId = null;
        this.ticket = null;
        this.resumptionRequired = false;
        updateConnectionState();
    }

    public void setConnectionId(ConnectionId connectionId) {
        this.cid = connectionId;
        updateConnectionState();
    }

    public void setExecutionListener(ConnectionExecutionListener connectionExecutionListener) {
        SerialExecutor serialExecutor = this.serialExecutor;
        if (serialExecutor != null) {
            if (connectionExecutionListener == null) {
                serialExecutor.setExecutionListener(null);
            } else {
                serialExecutor.setExecutionListener(new SerialExecutor.ExecutionListener(connectionExecutionListener) { // from class: org.eclipse.californium.scandium.dtls.Connection.1
                    @Override // org.eclipse.californium.elements.util.SerialExecutor.ExecutionListener
                    public void afterExecution() {
                        throw null;
                    }

                    @Override // org.eclipse.californium.elements.util.SerialExecutor.ExecutionListener
                    public void beforeExecution() {
                        throw null;
                    }
                });
            }
        }
    }

    public void setExecutor(SerialExecutor serialExecutor) {
        if (serialExecutor == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Serial executor must not be null1");
        } else if (isExecuting()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Serial executor already available!");
        } else {
            this.serialExecutor = serialExecutor;
            setExecutionListener(null);
        }
    }

    public void setResumptionRequired(boolean z) {
        this.resumptionRequired = z;
    }

    public void setRootCause(AlertMessage alertMessage) {
        this.rootCause = alertMessage;
    }

    public void setRouter(InetSocketAddress inetSocketAddress) {
        InetSocketAddress inetSocketAddress2 = this.router;
        if (inetSocketAddress2 != inetSocketAddress) {
            if (inetSocketAddress2 == null || !inetSocketAddress2.equals(inetSocketAddress)) {
                this.router = inetSocketAddress;
                if (this.establishedSession != null) {
                    this.establishedSession.setRouter(inetSocketAddress);
                }
                updateConnectionState();
            }
        }
    }

    public void startByClientHello(ClientHello clientHello) {
        if (clientHello == null) {
            this.startingClientHelloRandom = null;
        } else {
            this.startingClientHelloMessageSeq = clientHello.getMessageSeq();
            this.startingClientHelloRandom = clientHello.getRandom();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("dtls-con: ");
        ConnectionId connectionId = this.cid;
        if (connectionId != null) {
            sb.append(connectionId);
        }
        if (this.peerAddress != null) {
            sb.append(", ");
            sb.append(this.peerAddress);
            if (getOngoingHandshake() != null) {
                sb.append(", ongoing handshake ");
                SessionId sessionIdentifier = getOngoingHandshake().getSession().getSessionIdentifier();
                if (sessionIdentifier != null && !sessionIdentifier.isEmpty()) {
                    sb.append(StringUtil.byteArray2HexString(sessionIdentifier.getBytes(), (char) 0, 6));
                }
            }
            if (isResumptionRequired()) {
                sb.append(", resumption required");
            } else if (hasEstablishedSession()) {
                sb.append(", session established ");
                SessionId sessionIdentifier2 = getEstablishedSession().getSessionIdentifier();
                if (sessionIdentifier2 != null && !sessionIdentifier2.isEmpty()) {
                    sb.append(StringUtil.byteArray2HexString(sessionIdentifier2.getBytes(), (char) 0, 6));
                }
            }
        }
        if (this.sessionId != null) {
            sb.append(", ");
            sb.append(this.sessionId);
            sb.append(", ");
            sb.append(this.ticket);
        }
        if (isExecuting()) {
            sb.append(", is alive");
        }
        return sb.toString();
    }

    public void updateConnectionState() {
    }

    public void updatePeerAddress(InetSocketAddress inetSocketAddress) {
        if (equalsPeerAddress(inetSocketAddress)) {
            return;
        }
        if (this.establishedSession == null && inetSocketAddress != null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Address change without established sesson is not supported!");
            return;
        }
        this.lastPeerAddressNanos = ClockUtil.nanoRealtime();
        InetSocketAddress inetSocketAddress2 = this.peerAddress;
        this.peerAddress = inetSocketAddress;
        if (this.establishedSession != null) {
            this.establishedSession.setPeer(inetSocketAddress);
        }
        if (inetSocketAddress != null) {
            updateConnectionState();
            return;
        }
        Handshaker ongoingHandshake = getOngoingHandshake();
        if (ongoingHandshake != null) {
            if (this.establishedSession == null || ongoingHandshake.getSession() != this.establishedSession) {
                ongoingHandshake.handshakeFailed(new IOException(inetSocketAddress2 + " address reused during handshake!"));
            }
        }
    }

    public DTLSSession getSession() {
        Handshaker handshaker;
        DTLSSession dTLSSession = this.establishedSession;
        return (dTLSSession != null || (handshaker = this.ongoingHandshake.get()) == null) ? dTLSSession : handshaker.getSession();
    }
}
