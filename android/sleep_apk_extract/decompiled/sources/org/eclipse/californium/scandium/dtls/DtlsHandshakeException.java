package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class DtlsHandshakeException extends DtlsException {
    private static final long serialVersionUID = 1;
    private final AlertMessage.AlertDescription description;
    private final AlertMessage.AlertLevel level;

    public DtlsHandshakeException(String str, AlertMessage.AlertDescription alertDescription, AlertMessage.AlertLevel alertLevel, InetSocketAddress inetSocketAddress, Throwable th) {
        super(str, inetSocketAddress, th);
        if (alertDescription == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Description must not be null");
            throw null;
        }
        if (alertLevel == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Level must not be null");
            throw null;
        }
        this.description = alertDescription;
        this.level = alertLevel;
    }
}
