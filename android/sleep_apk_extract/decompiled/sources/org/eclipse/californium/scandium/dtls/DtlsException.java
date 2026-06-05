package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public class DtlsException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private final InetSocketAddress peer;

    public DtlsException(String str, InetSocketAddress inetSocketAddress) {
        super(str);
        this.peer = inetSocketAddress;
    }

    public DtlsException(String str, InetSocketAddress inetSocketAddress, Throwable th) {
        super(str, th);
        this.peer = inetSocketAddress;
    }
}
