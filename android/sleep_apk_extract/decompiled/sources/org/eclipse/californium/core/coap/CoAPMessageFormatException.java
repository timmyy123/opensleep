package org.eclipse.californium.core.coap;

/* JADX INFO: loaded from: classes5.dex */
public class CoAPMessageFormatException extends MessageFormatException {
    private static final long serialVersionUID = 1;
    private final int code;
    private final boolean confirmable;
    private final int mid;
    private final Token token;

    public CoAPMessageFormatException(String str, Token token, int i, int i2, boolean z) {
        super(str);
        this.token = token;
        this.mid = i;
        this.code = i2;
        this.confirmable = z;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getMid() {
        return this.mid;
    }

    public Token getToken() {
        return this.token;
    }

    public final boolean hasMid() {
        return this.mid > -1;
    }

    public final boolean isConfirmable() {
        return this.confirmable;
    }
}
