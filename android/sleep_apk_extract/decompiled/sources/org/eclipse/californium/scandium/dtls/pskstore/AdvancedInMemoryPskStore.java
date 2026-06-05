package org.eclipse.californium.scandium.dtls.pskstore;

import java.net.InetSocketAddress;
import javax.crypto.SecretKey;
import org.eclipse.californium.scandium.dtls.ConnectionId;
import org.eclipse.californium.scandium.dtls.PskPublicInformation;
import org.eclipse.californium.scandium.dtls.PskSecretResult;
import org.eclipse.californium.scandium.dtls.PskSecretResultHandler;
import org.eclipse.californium.scandium.dtls.cipher.PseudoRandomFunction;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCryptoMap;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalMac;
import org.eclipse.californium.scandium.util.SecretUtil;
import org.eclipse.californium.scandium.util.ServerNames;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class AdvancedInMemoryPskStore implements AdvancedPskStore {
    protected static final ThreadLocalCryptoMap<ThreadLocalMac> MAC = new ThreadLocalCryptoMap<>(new ThreadLocalCryptoMap.Factory<ThreadLocalMac>() { // from class: org.eclipse.californium.scandium.dtls.pskstore.AdvancedInMemoryPskStore.1
        @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCryptoMap.Factory
        public ThreadLocalMac getInstance(String str) {
            return new ThreadLocalMac(str);
        }
    });
    protected final PskStore pskStore;

    public AdvancedInMemoryPskStore(PskStore pskStore) {
        if (pskStore != null) {
            this.pskStore = pskStore;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("PSK store must not be null!");
            throw null;
        }
    }

    public SecretKey generateMasterSecret(String str, SecretKey secretKey, SecretKey secretKey2, byte[] bArr) {
        ThreadLocalMac threadLocalMac = (ThreadLocalMac) MAC.get(str);
        SecretKey secretKeyGeneratePremasterSecretFromPSK = PseudoRandomFunction.generatePremasterSecretFromPSK(secretKey2, secretKey);
        SecretKey secretKeyGenerateMasterSecret = PseudoRandomFunction.generateMasterSecret(threadLocalMac.current(), secretKeyGeneratePremasterSecretFromPSK, bArr);
        SecretUtil.destroy(secretKeyGeneratePremasterSecretFromPSK);
        return secretKeyGenerateMasterSecret;
    }

    @Override // org.eclipse.californium.scandium.dtls.pskstore.AdvancedPskStore
    public PskPublicInformation getIdentity(InetSocketAddress inetSocketAddress, ServerNames serverNames) {
        PskStore pskStore = this.pskStore;
        return serverNames != null ? pskStore.getIdentity(inetSocketAddress, serverNames) : pskStore.getIdentity(inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.pskstore.AdvancedPskStore
    public boolean hasEcdhePskSupported() {
        return true;
    }

    @Override // org.eclipse.californium.scandium.dtls.pskstore.AdvancedPskStore
    public PskSecretResult requestPskSecretResult(ConnectionId connectionId, ServerNames serverNames, PskPublicInformation pskPublicInformation, String str, SecretKey secretKey, byte[] bArr) {
        PskStore pskStore = this.pskStore;
        SecretKey key = serverNames != null ? pskStore.getKey(serverNames, pskPublicInformation) : pskStore.getKey(pskPublicInformation);
        if (key != null) {
            SecretKey secretKeyGenerateMasterSecret = generateMasterSecret(str, key, secretKey, bArr);
            SecretUtil.destroy(key);
            key = secretKeyGenerateMasterSecret;
        }
        return new PskSecretResult(connectionId, pskPublicInformation, key);
    }

    @Override // org.eclipse.californium.scandium.dtls.pskstore.AdvancedPskStore
    public void setResultHandler(PskSecretResultHandler pskSecretResultHandler) {
    }
}
