package org.eclipse.californium.elements.auth;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.StringUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class PreSharedKeyIdentity extends AbstractExtensiblePrincipal<PreSharedKeyIdentity> {
    private final String identity;
    private final String name;
    private final boolean scopedIdentity;
    private final String virtualHost;

    private PreSharedKeyIdentity(boolean z, String str, String str2, AdditionalInfo additionalInfo) {
        super(additionalInfo);
        if (str2 == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Identity must not be null");
            throw null;
        }
        this.scopedIdentity = z;
        if (z) {
            StringBuilder sb = new StringBuilder();
            if (str == null) {
                this.virtualHost = null;
            } else {
                if (!StringUtil.isValidHostName(str)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("virtual host is not a valid hostname");
                    throw null;
                }
                String lowerCase = str.toLowerCase();
                this.virtualHost = lowerCase;
                sb.append(lowerCase);
            }
            this.name = FileInsert$$ExternalSyntheticOutline0.m(sb, ":", str2);
        } else {
            if (str != null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("virtual host is not supported, if sni is disabled");
                throw null;
            }
            this.virtualHost = null;
            this.name = str2;
        }
        this.identity = str2;
    }

    @Override // org.eclipse.californium.elements.auth.ExtensiblePrincipal
    public PreSharedKeyIdentity amend(AdditionalInfo additionalInfo) {
        return new PreSharedKeyIdentity(this.scopedIdentity, this.virtualHost, this.identity, this.name, additionalInfo);
    }

    @Override // java.security.Principal
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PreSharedKeyIdentity.class != obj.getClass()) {
            return false;
        }
        String str = this.name;
        String str2 = ((PreSharedKeyIdentity) obj).name;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    @Override // java.security.Principal
    public String getName() {
        return this.name;
    }

    @Override // java.security.Principal
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // java.security.Principal
    public String toString() {
        if (!this.scopedIdentity) {
            return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("PreSharedKey Identity [identity: "), this.identity, "]");
        }
        StringBuilder sb = new StringBuilder("PreSharedKey Identity [virtual host: ");
        sb.append(this.virtualHost);
        sb.append(", identity: ");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.identity, "]");
    }

    public PreSharedKeyIdentity(String str, String str2) {
        this(true, str, str2, null);
    }

    public PreSharedKeyIdentity(String str) {
        this(false, null, str, null);
    }

    private PreSharedKeyIdentity(boolean z, String str, String str2, String str3, AdditionalInfo additionalInfo) {
        super(additionalInfo);
        this.scopedIdentity = z;
        this.virtualHost = str;
        this.identity = str2;
        this.name = str3;
    }
}
