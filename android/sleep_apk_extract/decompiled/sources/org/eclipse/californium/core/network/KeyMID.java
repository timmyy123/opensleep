package org.eclipse.californium.core.network;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.net.InetSocketAddress;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.StringUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class KeyMID {
    private final int hash;
    private final int mid;
    private final Object peer;

    public KeyMID(int i, Object obj) {
        if (i < 0 || i > 65535) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "MID must be a 16 bit unsigned int: "));
            throw null;
        }
        if (obj == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("peer must not be null");
            throw null;
        }
        this.mid = i;
        this.peer = obj;
        this.hash = obj.hashCode() + (i * 31);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || KeyMID.class != obj.getClass()) {
            return false;
        }
        KeyMID keyMID = (KeyMID) obj;
        if (this.mid != keyMID.mid) {
            return false;
        }
        return this.peer.equals(keyMID.peer);
    }

    public Object getPeer() {
        return this.peer;
    }

    public int hashCode() {
        return this.hash;
    }

    public String toString() {
        Object displayString = this.peer;
        if (displayString instanceof InetSocketAddress) {
            displayString = StringUtil.toDisplayString((InetSocketAddress) displayString);
        }
        StringBuilder sb = new StringBuilder("KeyMID[");
        sb.append(displayString);
        sb.append('-');
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.mid, ']');
    }
}
