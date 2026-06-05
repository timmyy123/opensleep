package org.eclipse.californium.scandium.dtls;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HandshakeResult {
    private final ConnectionId cid;
    private final Object customArgument;

    public HandshakeResult(ConnectionId connectionId, Object obj) {
        if (connectionId == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("cid must not be null!");
            throw null;
        }
        this.cid = connectionId;
        this.customArgument = obj;
    }

    public Object getCustomArgument() {
        return this.customArgument;
    }
}
