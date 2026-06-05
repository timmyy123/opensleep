package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.LeastRecentlyUsedCache;
import org.eclipse.californium.elements.util.SerialExecutor;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.ConnectionListener;
import org.eclipse.californium.scandium.util.SecretUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class InMemoryConnectionStore implements ResumptionSupportingConnectionStore {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) InMemoryConnectionStore.class);
    private ConnectionIdGenerator connectionIdGenerator;
    protected final LeastRecentlyUsedCache<ConnectionId, Connection> connections;
    protected final ConcurrentMap<InetSocketAddress, Connection> connectionsByAddress;
    protected final ConcurrentMap<SessionId, Connection> connectionsByEstablishedSession;
    protected String tag = "";

    public InMemoryConnectionStore(int i, long j, SessionCache sessionCache) {
        LeastRecentlyUsedCache<ConnectionId, Connection> leastRecentlyUsedCache = new LeastRecentlyUsedCache<>(i, j);
        this.connections = leastRecentlyUsedCache;
        leastRecentlyUsedCache.setEvictingOnReadAccess(false);
        leastRecentlyUsedCache.setUpdatingOnReadAccess(false);
        this.connectionsByEstablishedSession = new ConcurrentHashMap();
        this.connectionsByAddress = new ConcurrentHashMap();
        leastRecentlyUsedCache.addEvictionListener(new LeastRecentlyUsedCache.EvictionListener<Connection>() { // from class: org.eclipse.californium.scandium.dtls.InMemoryConnectionStore.1
            @Override // org.eclipse.californium.elements.util.LeastRecentlyUsedCache.EvictionListener
            public void onEviction(final Connection connection) {
                Runnable runnable = new Runnable() { // from class: org.eclipse.californium.scandium.dtls.InMemoryConnectionStore.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Handshaker ongoingHandshake = connection.getOngoingHandshake();
                        if (ongoingHandshake != null) {
                            ongoingHandshake.handshakeFailed(new ConnectionEvictedException("Evicted!", connection.getPeerAddress()));
                        }
                        synchronized (InMemoryConnectionStore.this) {
                            InMemoryConnectionStore.this.removeFromAddressConnections(connection);
                            InMemoryConnectionStore.this.removeFromEstablishedSessions(connection);
                            InMemoryConnectionStore.access$200(InMemoryConnectionStore.this);
                        }
                    }
                };
                if (connection.isExecuting()) {
                    connection.getExecutor().execute(runnable);
                } else {
                    runnable.run();
                }
            }
        });
        LOG.info("Created new InMemoryConnectionStore [capacity: {}, connection expiration threshold: {}s]", Integer.valueOf(i), Long.valueOf(j));
    }

    public static /* synthetic */ ConnectionListener access$200(InMemoryConnectionStore inMemoryConnectionStore) {
        inMemoryConnectionStore.getClass();
        return null;
    }

    private void addToAddressConnections(Connection connection) {
        final InetSocketAddress peerAddress = connection.getPeerAddress();
        if (peerAddress == null) {
            LOG.debug("{}connection: {} - missing address!", this.tag, connection.getConnectionId());
            return;
        }
        final Connection connectionPut = this.connectionsByAddress.put(peerAddress, connection);
        if (connectionPut == null || connectionPut == connection) {
            LOG.debug("{}connection: {} - {} added!", this.tag, connection.getConnectionId(), peerAddress);
            return;
        }
        Runnable runnable = new Runnable() { // from class: org.eclipse.californium.scandium.dtls.InMemoryConnectionStore.3
            @Override // java.lang.Runnable
            public void run() {
                if (connectionPut.equalsPeerAddress(peerAddress)) {
                    connectionPut.updatePeerAddress(null);
                }
            }
        };
        LOG.debug("{}connection: {} - {} added! {} removed from address.", this.tag, connection.getConnectionId(), peerAddress, connectionPut.getConnectionId());
        if (connectionPut.isExecuting()) {
            connectionPut.getExecutor().execute(runnable);
        } else {
            runnable.run();
        }
    }

    private synchronized Connection findLocally(SessionId sessionId) {
        Connection connection;
        try {
            connection = this.connectionsByEstablishedSession.get(sessionId);
            if (connection != null) {
                DTLSSession establishedSession = connection.getEstablishedSession();
                if (establishedSession == null) {
                    LOG.warn("{}connection {} lost session {}!", this.tag, connection.getConnectionId(), sessionId);
                } else if (!establishedSession.getSessionIdentifier().equals(sessionId)) {
                    LOG.warn("{}connection {} changed session {}!={}!", this.tag, connection.getConnectionId(), sessionId, establishedSession.getSessionIdentifier());
                }
                this.connections.update(connection.getConnectionId());
            }
        } catch (Throwable th) {
            throw th;
        }
        return connection;
    }

    private ConnectionId newConnectionId() {
        for (int i = 0; i < 10; i++) {
            ConnectionId connectionIdCreateConnectionId = this.connectionIdGenerator.createConnectionId();
            if (this.connections.get(connectionIdCreateConnectionId) == null) {
                return connectionIdCreateConnectionId;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromAddressConnections(Connection connection) {
        InetSocketAddress peerAddress = connection.getPeerAddress();
        if (peerAddress != null) {
            this.connectionsByAddress.remove(peerAddress, connection);
            connection.updatePeerAddress(null);
        }
    }

    private synchronized void removeSessionFromCache(Connection connection) {
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public void attach(ConnectionIdGenerator connectionIdGenerator) {
        if (this.connectionIdGenerator != null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Connection id generator already attached!");
        } else if (connectionIdGenerator != null && connectionIdGenerator.useConnectionId()) {
            this.connectionIdGenerator = connectionIdGenerator;
        } else {
            int iNumberOfLeadingZeros = (39 - Integer.numberOfLeadingZeros(this.connections.getCapacity())) / 8;
            this.connectionIdGenerator = new SingleNodeConnectionIdGenerator(iNumberOfLeadingZeros + (iNumberOfLeadingZeros < 3 ? 2 : 3));
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public final synchronized void clear() {
        try {
            Iterator<Connection> it = this.connections.values().iterator();
            while (it.hasNext()) {
                SerialExecutor executor = it.next().getExecutor();
                if (executor != null) {
                    executor.shutdownNow();
                }
            }
            this.connections.clear();
            this.connectionsByEstablishedSession.clear();
            this.connectionsByAddress.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public synchronized Connection find(SessionId sessionId) {
        if (sessionId != null) {
            if (!sessionId.isEmpty()) {
                return findLocally(sessionId);
            }
        }
        return null;
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public synchronized Connection get(InetSocketAddress inetSocketAddress) {
        Connection connection;
        try {
            connection = this.connectionsByAddress.get(inetSocketAddress);
            if (connection == null) {
                LOG.debug("{}connection: missing connection for {}!", this.tag, inetSocketAddress);
            } else {
                InetSocketAddress peerAddress = connection.getPeerAddress();
                if (peerAddress == null) {
                    LOG.warn("{}connection {} lost ip-address {}!", this.tag, connection.getConnectionId(), inetSocketAddress);
                } else if (!peerAddress.equals(inetSocketAddress)) {
                    LOG.warn("{}connection {} changed ip-address {}!={}!", this.tag, connection.getConnectionId(), inetSocketAddress, peerAddress);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return connection;
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public synchronized void markAllAsResumptionRequired() {
        for (Connection connection : this.connections.values()) {
            if (connection.getPeerAddress() != null && !connection.isResumptionRequired()) {
                connection.setResumptionRequired(true);
                LOG.debug("{}connection: mark for resumption {}!", this.tag, connection);
            }
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public synchronized boolean put(Connection connection) {
        if (connection == null) {
            return false;
        }
        try {
            if (!connection.isExecuting()) {
                throw new IllegalStateException("Connection is not executing!");
            }
            ConnectionId connectionId = connection.getConnectionId();
            if (connectionId == null) {
                if (this.connectionIdGenerator == null) {
                    throw new IllegalStateException("Connection id generator must be attached before!");
                }
                connectionId = newConnectionId();
                if (connectionId == null) {
                    throw new IllegalStateException("Connection ids exhausted!");
                }
                connection.setConnectionId(connectionId);
            } else {
                if (connectionId.isEmpty()) {
                    throw new IllegalStateException("Connection must have a none empty connection id!");
                }
                if (this.connections.get(connectionId) != null) {
                    throw new IllegalStateException("Connection id already used! " + connectionId);
                }
            }
            if (!this.connections.put(connectionId, connection)) {
                LOG.warn("{}connection store is full! {} max. entries.", this.tag, Integer.valueOf(this.connections.getCapacity()));
                return false;
            }
            Logger logger = LOG;
            if (logger.isTraceEnabled()) {
                logger.trace("{}connection: add {} (size {})", this.tag, connection, Integer.valueOf(this.connections.size()), new Throwable("connection added!"));
            } else {
                logger.debug("{}connection: add {} (size {})", this.tag, connectionId, Integer.valueOf(this.connections.size()));
            }
            addToAddressConnections(connection);
            DTLSSession establishedSession = connection.getEstablishedSession();
            if (establishedSession != null) {
                putEstablishedSession(establishedSession, connection);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public synchronized void putEstablishedSession(DTLSSession dTLSSession, Connection connection) {
        final Connection connectionPut;
        try {
            SessionId sessionIdentifier = dTLSSession.getSessionIdentifier();
            if (!sessionIdentifier.isEmpty() && (connectionPut = this.connectionsByEstablishedSession.put(sessionIdentifier, connection)) != null && connectionPut != connection) {
                Runnable runnable = new Runnable() { // from class: org.eclipse.californium.scandium.dtls.InMemoryConnectionStore.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InMemoryConnectionStore.this.remove(connectionPut, false);
                    }
                };
                if (connectionPut.isExecuting()) {
                    connectionPut.getExecutor().execute(runnable);
                } else {
                    runnable.run();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public synchronized int remainingCapacity() {
        int iRemainingCapacity;
        iRemainingCapacity = this.connections.remainingCapacity();
        LOG.debug("{}connection: size {}, remaining {}!", this.tag, Integer.valueOf(this.connections.size()), Integer.valueOf(iRemainingCapacity));
        return iRemainingCapacity;
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public synchronized boolean remove(Connection connection, boolean z) {
        boolean z2;
        try {
            z2 = this.connections.remove(connection.getConnectionId(), connection) == connection;
            if (z2) {
                List<Runnable> listShutdownNow = connection.getExecutor().shutdownNow();
                Logger logger = LOG;
                if (logger.isTraceEnabled()) {
                    logger.trace("{}connection: remove {} (size {}, left jobs: {})", this.tag, connection, Integer.valueOf(this.connections.size()), Integer.valueOf(listShutdownNow.size()), new Throwable("connection removed!"));
                } else if (listShutdownNow.isEmpty()) {
                    logger.debug("{}connection: remove {} (size {})", this.tag, connection, Integer.valueOf(this.connections.size()));
                } else {
                    logger.debug("{}connection: remove {} (size {}, left jobs: {})", this.tag, connection, Integer.valueOf(this.connections.size()), Integer.valueOf(listShutdownNow.size()));
                }
                removeFromEstablishedSessions(connection);
                removeFromAddressConnections(connection);
                if (z) {
                    removeSessionFromCache(connection);
                }
            }
        } finally {
        }
        return z2;
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public synchronized void removeFromEstablishedSessions(DTLSSession dTLSSession, Connection connection) {
        SessionId sessionIdentifier = dTLSSession.getSessionIdentifier();
        if (!sessionIdentifier.isEmpty()) {
            this.connectionsByEstablishedSession.remove(sessionIdentifier, connection);
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public void setConnectionListener(ConnectionListener connectionListener) {
    }

    public synchronized InMemoryConnectionStore setTag(String str) {
        this.tag = StringUtil.normalizeLoggingTag(str);
        return this;
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public final synchronized void stop(List<Runnable> list) {
        Iterator<Connection> it = this.connections.values().iterator();
        while (it.hasNext()) {
            SerialExecutor executor = it.next().getExecutor();
            if (executor != null) {
                executor.shutdownNow(list);
            }
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public synchronized boolean update(Connection connection, InetSocketAddress inetSocketAddress) {
        if (connection == null) {
            return false;
        }
        try {
            if (!this.connections.update(connection.getConnectionId())) {
                LOG.debug("{}connection: {} - {} update failed!", this.tag, connection.getConnectionId(), inetSocketAddress);
                return false;
            }
            if (inetSocketAddress == null) {
                LOG.debug("{}connection: {} updated usage!", this.tag, connection.getConnectionId());
            } else if (!connection.equalsPeerAddress(inetSocketAddress)) {
                InetSocketAddress peerAddress = connection.getPeerAddress();
                Logger logger = LOG;
                if (logger.isTraceEnabled()) {
                    logger.trace("{}connection: {} updated, address changed from {} to {}!", this.tag, connection.getConnectionId(), peerAddress, inetSocketAddress, new Throwable("connection updated!"));
                } else {
                    logger.debug("{}connection: {} updated, address changed from {} to {}!", this.tag, connection.getConnectionId(), peerAddress, inetSocketAddress);
                }
                if (peerAddress != null) {
                    this.connectionsByAddress.remove(peerAddress, connection);
                    connection.updatePeerAddress(null);
                }
                connection.updatePeerAddress(inetSocketAddress);
                addToAddressConnections(connection);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromEstablishedSessions(Connection connection) {
        DTLSSession establishedSession = connection.getEstablishedSession();
        if (establishedSession != null) {
            this.connectionsByEstablishedSession.remove(establishedSession.getSessionIdentifier(), connection);
            SecretUtil.destroy(establishedSession);
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public synchronized Connection get(ConnectionId connectionId) {
        Connection connection;
        try {
            connection = this.connections.get(connectionId);
            if (connection == null) {
                LOG.debug("{}connection: missing connection for {}!", this.tag, connectionId);
            } else {
                ConnectionId connectionId2 = connection.getConnectionId();
                if (connectionId2 == null) {
                    LOG.warn("{}connection lost cid {}!", this.tag, connectionId);
                } else if (!connectionId2.equals(connectionId)) {
                    LOG.warn("{}connection changed cid {}!={}!", this.tag, connectionId2, connectionId);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return connection;
    }

    @Override // org.eclipse.californium.scandium.dtls.ResumptionSupportingConnectionStore
    public boolean remove(Connection connection) {
        return remove(connection, true);
    }
}
