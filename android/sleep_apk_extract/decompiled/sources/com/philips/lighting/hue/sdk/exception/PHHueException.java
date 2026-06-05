package com.philips.lighting.hue.sdk.exception;

/* JADX INFO: loaded from: classes4.dex */
public class PHHueException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public PHHueException() {
    }

    public PHHueException(String str) {
        super(str);
    }

    public PHHueException(String str, Throwable th) {
        super(str, th);
    }

    public PHHueException(Throwable th) {
        super(th);
    }
}
