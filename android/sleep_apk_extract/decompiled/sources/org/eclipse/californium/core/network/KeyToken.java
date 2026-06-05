package org.eclipse.californium.core.network;

import java.net.InetSocketAddress;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.elements.util.StringUtil;

/* JADX INFO: loaded from: classes5.dex */
public class KeyToken {
    private final int hash;
    private final Object peer;
    private final Token token;

    public KeyToken(Token token, Object obj) {
        this.token = token;
        this.peer = obj;
        int iHashCode = token.hashCode();
        this.hash = obj != null ? iHashCode + (obj.hashCode() * 31) : iHashCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyToken keyToken = (KeyToken) obj;
        if (this.hash != keyToken.hash || !this.token.equals(keyToken.token)) {
            return false;
        }
        Object obj2 = this.peer;
        Object obj3 = keyToken.peer;
        if (obj2 == obj3) {
            return true;
        }
        if (obj2 == null) {
            return false;
        }
        return obj2.equals(obj3);
    }

    public final int hashCode() {
        return this.hash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KeyToken[");
        Object displayString = this.peer;
        if (displayString != null) {
            if (displayString instanceof InetSocketAddress) {
                displayString = StringUtil.toDisplayString((InetSocketAddress) displayString);
            }
            sb.append(displayString);
            sb.append('-');
        }
        sb.append(this.token.getAsString());
        sb.append(']');
        return sb.toString();
    }
}
