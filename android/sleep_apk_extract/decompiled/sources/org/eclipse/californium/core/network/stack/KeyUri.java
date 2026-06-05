package org.eclipse.californium.core.network.stack;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.net.InetSocketAddress;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class KeyUri {
    private final byte[] address;
    private final int hash;
    private final int port;
    private final String uri;

    public KeyUri(String str, byte[] bArr, int i) {
        if (str == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("URI must not be null");
            throw null;
        }
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("address must not be null");
            throw null;
        }
        if (i < 0 || i > 65535) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("port must be an unsigned 16 bit int");
            throw null;
        }
        this.uri = str;
        this.address = bArr;
        this.port = i;
        this.hash = Arrays.hashCode(bArr) + FileInsert$$ExternalSyntheticOutline0.m(i * 31, 31, str);
    }

    public static KeyUri fromInboundRequest(Request request) {
        String uri = getUri(request);
        InetSocketAddress peerAddress = request.getSourceContext().getPeerAddress();
        return new KeyUri(uri, peerAddress.getAddress().getAddress(), peerAddress.getPort());
    }

    public static KeyUri fromInboundResponse(Request request, Response response) {
        if (response != null) {
            InetSocketAddress peerAddress = response.getSourceContext().getPeerAddress();
            return new KeyUri(getUri(request), peerAddress.getAddress().getAddress(), peerAddress.getPort());
        }
        Types$$ExternalSyntheticBUOutline0.m$1("response must not be null");
        return null;
    }

    public static KeyUri fromOutboundRequest(Request request) {
        String uri = getUri(request);
        InetSocketAddress peerAddress = request.getDestinationContext().getPeerAddress();
        return new KeyUri(uri, peerAddress.getAddress().getAddress(), peerAddress.getPort());
    }

    public static KeyUri fromOutboundResponse(Request request, Response response) {
        if (response != null) {
            InetSocketAddress peerAddress = response.getDestinationContext().getPeerAddress();
            return new KeyUri(getUri(request), peerAddress.getAddress().getAddress(), peerAddress.getPort());
        }
        Types$$ExternalSyntheticBUOutline0.m$1("response must not be null");
        return null;
    }

    private static String getUri(Request request) {
        if (request == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("request must not be null");
            return null;
        }
        return request.getScheme() + ":" + request.getOptions().getUriString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || KeyUri.class != obj.getClass()) {
            return false;
        }
        KeyUri keyUri = (KeyUri) obj;
        if (!Arrays.equals(this.address, keyUri.address) || this.port != keyUri.port) {
            return false;
        }
        String str = this.uri;
        String str2 = keyUri.uri;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.hash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KeyUri[");
        sb.append(this.uri);
        sb.append(", ");
        sb.append(Utils.toHexString(this.address));
        sb.append(":");
        return FileInsert$$ExternalSyntheticOutline0.m(this.port, "]", sb);
    }
}
