package org.eclipse.californium.elements.auth;

import java.security.cert.CertPath;
import java.security.cert.X509Certificate;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class X509CertPath extends AbstractExtensiblePrincipal<X509CertPath> {
    private final CertPath path;
    private final X509Certificate target;

    private X509CertPath(CertPath certPath, AdditionalInfo additionalInfo) {
        super(additionalInfo);
        if (!"X.509".equals(certPath.getType())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Cert path must contain X.509 certificates only");
            throw null;
        }
        if (certPath.getCertificates().isEmpty()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Cert path must not be empty");
            throw null;
        }
        this.path = certPath;
        this.target = (X509Certificate) certPath.getCertificates().get(0);
    }

    @Override // org.eclipse.californium.elements.auth.ExtensiblePrincipal
    public X509CertPath amend(AdditionalInfo additionalInfo) {
        return new X509CertPath(this.path, additionalInfo);
    }

    @Override // java.security.Principal
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.target.equals(((X509CertPath) obj).target);
        }
        return false;
    }

    @Override // java.security.Principal
    public String getName() {
        return this.target.getSubjectX500Principal().getName();
    }

    @Override // java.security.Principal
    public int hashCode() {
        return this.target.hashCode();
    }

    @Override // java.security.Principal
    public String toString() {
        return "x509 [" + getName() + "]";
    }

    public X509CertPath(CertPath certPath) {
        this(certPath, null);
    }
}
