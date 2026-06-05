package com.philips.lighting.hue.sdk.exception;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeNotConnectedException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public PHBridgeNotConnectedException() {
    }

    public PHBridgeNotConnectedException(String str) {
        super(str);
    }

    public PHBridgeNotConnectedException(String str, Throwable th) {
        super(str, th);
    }

    public PHBridgeNotConnectedException(Throwable th) {
        super(th);
    }
}
