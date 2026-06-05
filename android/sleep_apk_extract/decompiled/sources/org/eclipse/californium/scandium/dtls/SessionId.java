package org.eclipse.californium.scandium.dtls;

import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.scandium.dtls.cipher.RandomManager;

/* JADX INFO: loaded from: classes5.dex */
public final class SessionId extends Bytes {
    private static final SessionId EMPTY_SESSION_ID = new SessionId(Bytes.EMPTY);

    public SessionId() {
        this(Bytes.createBytes(RandomManager.currentSecureRandom(), 32));
    }

    public static SessionId emptySessionId() {
        return EMPTY_SESSION_ID;
    }

    public String toString() {
        return getAsString();
    }

    public SessionId(byte[] bArr) {
        super(bArr);
    }
}
