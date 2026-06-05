package org.eclipse.californium.scandium.dtls.pskstore;

import java.net.InetSocketAddress;
import javax.crypto.SecretKey;
import org.eclipse.californium.scandium.dtls.PskPublicInformation;
import org.eclipse.californium.scandium.util.ServerNames;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface PskStore {
    PskPublicInformation getIdentity(InetSocketAddress inetSocketAddress);

    PskPublicInformation getIdentity(InetSocketAddress inetSocketAddress, ServerNames serverNames);

    SecretKey getKey(PskPublicInformation pskPublicInformation);

    SecretKey getKey(ServerNames serverNames, PskPublicInformation pskPublicInformation);
}
