package org.eclipse.californium.scandium.dtls;

/* JADX INFO: loaded from: classes5.dex */
public class AvailableConnections {
    private Connection byAddress;
    private Connection bySessionId;
    private boolean removeBySessionId;
    private boolean setBySessionId;

    public Connection getConnectionByAddress() {
        return this.byAddress;
    }

    public Connection getConnectionBySessionId() {
        return this.bySessionId;
    }

    public boolean isConnectionBySessionIdKnown() {
        return this.setBySessionId;
    }

    public boolean isRemoveConnectionBySessionId() {
        return this.removeBySessionId;
    }

    public void setConnectionByAddress(Connection connection) {
        this.byAddress = connection;
    }

    public void setConnectionBySessionId(Connection connection) {
        this.bySessionId = connection;
        this.setBySessionId = true;
    }

    public void setRemoveConnectionBySessionId(boolean z) {
        this.removeBySessionId = z;
    }
}
