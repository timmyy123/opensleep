package com.philips.lighting.hue.sdk.exception;

/* JADX INFO: loaded from: classes4.dex */
public class PHInvalidRuleException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public PHInvalidRuleException() {
    }

    public PHInvalidRuleException(String str) {
        super(str);
    }

    public PHInvalidRuleException(String str, Throwable th) {
        super(str, th);
    }

    public PHInvalidRuleException(Throwable th) {
        super(th);
    }
}
