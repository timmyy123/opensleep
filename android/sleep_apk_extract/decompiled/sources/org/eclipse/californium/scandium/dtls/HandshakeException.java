package org.eclipse.californium.scandium.dtls;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class HandshakeException extends Exception {
    private static final long serialVersionUID = 1123415935894222594L;
    private final AlertMessage alert;

    public HandshakeException(String str, AlertMessage alertMessage) {
        super(str);
        if (alertMessage != null) {
            this.alert = alertMessage;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("Alert must not be null!");
            throw null;
        }
    }

    public AlertMessage getAlert() {
        return this.alert;
    }

    public HandshakeException(String str, AlertMessage alertMessage, Throwable th) {
        super(str, th);
        if (alertMessage != null) {
            this.alert = alertMessage;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("Alert must not be null!");
            throw null;
        }
    }
}
