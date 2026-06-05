package com.philips.lighting.hue.sdk.exception;

/* JADX INFO: loaded from: classes4.dex */
public class PHHueInvalidAPIException extends PHHueException {
    private static final long serialVersionUID = 1;

    public PHHueInvalidAPIException() {
    }

    public PHHueInvalidAPIException(String str) {
        super(str);
    }

    public PHHueInvalidAPIException(String str, Throwable th) {
        super(str, th);
    }

    public PHHueInvalidAPIException(Throwable th) {
        super(th);
    }
}
