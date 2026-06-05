package org.eclipse.californium.scandium.dtls.pskstore;

import java.net.InetSocketAddress;
import javax.crypto.SecretKey;
import org.eclipse.californium.scandium.dtls.PskPublicInformation;
import org.eclipse.californium.scandium.util.SecretUtil;
import org.eclipse.californium.scandium.util.ServerNames;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class StaticPskStore implements PskStore {
    private final PskPublicInformation fixedIdentity;
    private final SecretKey key;

    public StaticPskStore(PskPublicInformation pskPublicInformation, byte[] bArr) {
        this.fixedIdentity = pskPublicInformation;
        this.key = SecretUtil.create(bArr, "PSK");
    }

    @Override // org.eclipse.californium.scandium.dtls.pskstore.PskStore
    public PskPublicInformation getIdentity(InetSocketAddress inetSocketAddress, ServerNames serverNames) {
        return getIdentity(inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.pskstore.PskStore
    public SecretKey getKey(PskPublicInformation pskPublicInformation) {
        if (!this.fixedIdentity.equals(pskPublicInformation)) {
            return null;
        }
        if (!this.fixedIdentity.isCompliantEncoding()) {
            pskPublicInformation.normalize(this.fixedIdentity.getPublicInfoAsString());
        }
        return SecretUtil.create(this.key);
    }

    @Override // org.eclipse.californium.scandium.dtls.pskstore.PskStore
    public PskPublicInformation getIdentity(InetSocketAddress inetSocketAddress) {
        return this.fixedIdentity;
    }

    public StaticPskStore(String str, byte[] bArr) {
        this(new PskPublicInformation(str), bArr);
    }

    @Override // org.eclipse.californium.scandium.dtls.pskstore.PskStore
    public SecretKey getKey(ServerNames serverNames, PskPublicInformation pskPublicInformation) {
        return getKey(pskPublicInformation);
    }
}
