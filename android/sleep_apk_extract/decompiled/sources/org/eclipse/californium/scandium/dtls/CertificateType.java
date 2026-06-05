package org.eclipse.californium.scandium.dtls;

/* JADX INFO: loaded from: classes5.dex */
public enum CertificateType {
    X_509(0, true),
    OPEN_PGP(1, false),
    RAW_PUBLIC_KEY(2, true);

    private final int code;
    private final boolean isSupported;

    CertificateType(int i, boolean z) {
        this.code = i;
        this.isSupported = z;
    }

    public static CertificateType getTypeFromCode(int i) {
        if (i == 0) {
            return X_509;
        }
        if (i == 1) {
            return OPEN_PGP;
        }
        if (i != 2) {
            return null;
        }
        return RAW_PUBLIC_KEY;
    }

    public final int getCode() {
        return this.code;
    }
}
