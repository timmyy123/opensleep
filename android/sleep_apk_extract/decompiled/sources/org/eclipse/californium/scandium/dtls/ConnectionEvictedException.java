package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectionEvictedException extends DtlsException {
    private static final long serialVersionUID = 1;

    public ConnectionEvictedException(String str, InetSocketAddress inetSocketAddress) {
        super(str, inetSocketAddress);
    }
}
