package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public class DtlsHandshakeTimeoutException extends DtlsException {
    private static final long serialVersionUID = 1;
    private final int flightNumber;

    public DtlsHandshakeTimeoutException(String str, InetSocketAddress inetSocketAddress, int i) {
        super(str, inetSocketAddress);
        this.flightNumber = i;
    }
}
