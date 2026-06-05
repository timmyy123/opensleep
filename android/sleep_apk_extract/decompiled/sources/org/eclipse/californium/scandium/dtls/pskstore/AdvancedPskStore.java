package org.eclipse.californium.scandium.dtls.pskstore;

import java.net.InetSocketAddress;
import javax.crypto.SecretKey;
import org.eclipse.californium.scandium.dtls.ConnectionId;
import org.eclipse.californium.scandium.dtls.PskPublicInformation;
import org.eclipse.californium.scandium.dtls.PskSecretResult;
import org.eclipse.californium.scandium.dtls.PskSecretResultHandler;
import org.eclipse.californium.scandium.util.ServerNames;

/* JADX INFO: loaded from: classes5.dex */
public interface AdvancedPskStore {
    PskPublicInformation getIdentity(InetSocketAddress inetSocketAddress, ServerNames serverNames);

    boolean hasEcdhePskSupported();

    PskSecretResult requestPskSecretResult(ConnectionId connectionId, ServerNames serverNames, PskPublicInformation pskPublicInformation, String str, SecretKey secretKey, byte[] bArr);

    void setResultHandler(PskSecretResultHandler pskSecretResultHandler);
}
