package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.util.List;
import org.eclipse.californium.scandium.ConnectionListener;

/* JADX INFO: loaded from: classes5.dex */
public interface ResumptionSupportingConnectionStore {
    void attach(ConnectionIdGenerator connectionIdGenerator);

    void clear();

    Connection find(SessionId sessionId);

    Connection get(InetSocketAddress inetSocketAddress);

    Connection get(ConnectionId connectionId);

    void markAllAsResumptionRequired();

    boolean put(Connection connection);

    void putEstablishedSession(DTLSSession dTLSSession, Connection connection);

    int remainingCapacity();

    boolean remove(Connection connection);

    boolean remove(Connection connection, boolean z);

    void removeFromEstablishedSessions(DTLSSession dTLSSession, Connection connection);

    void setConnectionListener(ConnectionListener connectionListener);

    void stop(List<Runnable> list);

    boolean update(Connection connection, InetSocketAddress inetSocketAddress);
}
