package com.philips.lighting.hue.sdk.exception;

/* JADX INFO: loaded from: classes4.dex */
public class PHInvalidInputException extends PHHueException {
    private static final long serialVersionUID = 2;

    public PHInvalidInputException() {
    }

    public PHInvalidInputException(String str) {
        super(str);
    }

    public PHInvalidInputException(String str, Throwable th) {
        super(str, th);
    }

    public PHInvalidInputException(Throwable th) {
        super(th);
    }
}
