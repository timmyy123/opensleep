package org.eclipse.californium.scandium.dtls;

/* JADX INFO: loaded from: classes5.dex */
public enum ContentType {
    CHANGE_CIPHER_SPEC(20),
    ALERT(21),
    HANDSHAKE(22),
    APPLICATION_DATA(23),
    TLS12_CID(25);

    private int code;

    ContentType(int i) {
        this.code = i;
    }

    public static ContentType getTypeByValue(int i) {
        switch (i) {
            case 20:
                return CHANGE_CIPHER_SPEC;
            case 21:
                return ALERT;
            case 22:
                return HANDSHAKE;
            case 23:
                return APPLICATION_DATA;
            case 24:
            default:
                return null;
            case 25:
                return TLS12_CID;
        }
    }

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (this.code) {
            case 20:
                return "Change Cipher Spec (20)";
            case 21:
                return "Alert (21)";
            case 22:
                return "Handshake (22)";
            case 23:
                return "Application Data (23)";
            case 24:
            default:
                return "Unknown Content Type";
            case 25:
                return "TLS CID (25)";
        }
    }
}
