package org.eclipse.californium.scandium.dtls;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import javax.crypto.SecretKey;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class PskSecretResult extends HandshakeResult {
    private final PskPublicInformation pskIdentity;
    private final SecretKey secret;

    public PskSecretResult(ConnectionId connectionId, PskPublicInformation pskPublicInformation, SecretKey secretKey, Object obj) {
        super(connectionId, obj);
        if (pskPublicInformation == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("PSK identity must not be null!");
            throw null;
        }
        if (secretKey != null) {
            String algorithm = secretKey.getAlgorithm();
            if (!"MAC".equals(algorithm) && !"PSK".equals(algorithm)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Secret must be either MAC for master secret, or PSK for secret key, but not ", algorithm, "!"));
                throw null;
            }
        }
        this.pskIdentity = pskPublicInformation;
        this.secret = secretKey;
    }

    public PskPublicInformation getPskPublicInformation() {
        return this.pskIdentity;
    }

    public SecretKey getSecret() {
        return this.secret;
    }

    public PskSecretResult(ConnectionId connectionId, PskPublicInformation pskPublicInformation, SecretKey secretKey) {
        this(connectionId, pskPublicInformation, secretKey, null);
    }
}
