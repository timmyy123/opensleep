package org.eclipse.californium.scandium.dtls;

import java.security.Principal;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.security.auth.Destroyable;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.util.SecretUtil;
import org.eclipse.californium.scandium.util.ServerNames;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class SessionTicket implements Destroyable {
    private final CipherSuite cipherSuite;
    private final Principal clientIdentity;
    private final CompressionMethod compressionMethod;
    private final int hashCode;
    private final SecretKey masterSecret;
    private final ProtocolVersion protocolVersion;
    private final ServerNames serverNames;
    private final long timestampMillis;

    public SessionTicket(ProtocolVersion protocolVersion, CipherSuite cipherSuite, CompressionMethod compressionMethod, SecretKey secretKey, ServerNames serverNames, Principal principal, long j) {
        if (protocolVersion == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Protcol version must not be null");
            throw null;
        }
        if (cipherSuite == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Cipher suite must not be null");
            throw null;
        }
        if (compressionMethod == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Compression method must not be null");
            throw null;
        }
        if (secretKey == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Master secret must not be null");
            throw null;
        }
        this.protocolVersion = protocolVersion;
        SecretKey secretKeyCreate = SecretUtil.create(secretKey);
        this.masterSecret = secretKeyCreate;
        this.cipherSuite = cipherSuite;
        this.compressionMethod = compressionMethod;
        this.serverNames = serverNames;
        this.clientIdentity = principal;
        this.timestampMillis = j;
        this.hashCode = secretKeyCreate.hashCode();
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        SecretUtil.destroy(this.masterSecret);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SessionTicket.class != obj.getClass()) {
            return false;
        }
        SessionTicket sessionTicket = (SessionTicket) obj;
        if (this.hashCode != sessionTicket.hashCode) {
            return false;
        }
        byte[] encoded = this.masterSecret.getEncoded();
        byte[] encoded2 = sessionTicket.masterSecret.getEncoded();
        if (Arrays.equals(encoded, encoded2)) {
            Bytes.clear(encoded);
            Bytes.clear(encoded2);
            return this.protocolVersion.equals(sessionTicket.protocolVersion) && this.cipherSuite.equals(sessionTicket.cipherSuite) && this.compressionMethod.equals(sessionTicket.compressionMethod) && this.clientIdentity.equals(sessionTicket.clientIdentity) && this.timestampMillis == sessionTicket.timestampMillis;
        }
        Bytes.clear(encoded);
        Bytes.clear(encoded2);
        return false;
    }

    public final CipherSuite getCipherSuite() {
        return this.cipherSuite;
    }

    public final Principal getClientIdentity() {
        return this.clientIdentity;
    }

    public final CompressionMethod getCompressionMethod() {
        return this.compressionMethod;
    }

    public final SecretKey getMasterSecret() {
        return this.masterSecret;
    }

    public final ServerNames getServerNames() {
        return this.serverNames;
    }

    public final long getTimestamp() {
        return this.timestampMillis;
    }

    public int hashCode() {
        return this.hashCode;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return SecretUtil.isDestroyed(this.masterSecret);
    }
}
