package org.eclipse.californium.elements.auth;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Arrays;
import org.eclipse.californium.elements.util.Base64;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class RawPublicKeyIdentity extends AbstractExtensiblePrincipal<RawPublicKeyIdentity> {
    private String niUri;
    private final PublicKey publicKey;

    private RawPublicKeyIdentity(PublicKey publicKey, AdditionalInfo additionalInfo) {
        super(additionalInfo);
        if (publicKey == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Public key must not be null");
            throw null;
        }
        this.publicKey = publicKey;
        createNamedInformationUri(publicKey.getEncoded());
    }

    private void createNamedInformationUri(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            this.niUri = "ni:///sha-256;" + Base64.encodeBytes(messageDigest.digest(), 81);
        } catch (IOException | NoSuchAlgorithmException unused) {
        }
    }

    @Override // org.eclipse.californium.elements.auth.ExtensiblePrincipal
    public RawPublicKeyIdentity amend(AdditionalInfo additionalInfo) {
        return new RawPublicKeyIdentity(this.publicKey, additionalInfo);
    }

    @Override // java.security.Principal
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RawPublicKeyIdentity rawPublicKeyIdentity = (RawPublicKeyIdentity) obj;
        if (this.publicKey == null) {
            if (rawPublicKeyIdentity.publicKey != null) {
                return false;
            }
        } else if (!Arrays.equals(getSubjectInfo(), rawPublicKeyIdentity.getSubjectInfo())) {
            return false;
        }
        return true;
    }

    @Override // java.security.Principal
    public final String getName() {
        return this.niUri;
    }

    public final byte[] getSubjectInfo() {
        return this.publicKey.getEncoded();
    }

    @Override // java.security.Principal
    public int hashCode() {
        return 31 + (this.publicKey == null ? 0 : Arrays.hashCode(getSubjectInfo()));
    }

    @Override // java.security.Principal
    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("RawPublicKey Identity ["), this.niUri, "]");
    }

    public RawPublicKeyIdentity(PublicKey publicKey) {
        this(publicKey, null);
    }
}
