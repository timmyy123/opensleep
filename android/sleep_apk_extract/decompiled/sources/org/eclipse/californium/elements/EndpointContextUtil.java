package org.eclipse.californium.elements;

import com.facebook.appevents.integrity.IntegrityManager;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EndpointContextUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) EndpointContextUtil.class);

    public static EndpointContext getFollowUpEndpointContext(EndpointContext endpointContext, EndpointContext endpointContext2) {
        String str = endpointContext.get("*DTLS_HANDSHAKE_MODE");
        return (str == null || !str.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) ? endpointContext2 : MapBasedEndpointContext.addEntries(endpointContext2, "*DTLS_HANDSHAKE_MODE", IntegrityManager.INTEGRITY_TYPE_NONE);
    }

    public static boolean match(String str, Set<String> set, EndpointContext endpointContext, EndpointContext endpointContext2) {
        boolean z;
        Logger logger = LOGGER;
        boolean zIsWarnEnabled = logger.isWarnEnabled();
        boolean zIsTraceEnabled = logger.isTraceEnabled();
        while (true) {
            for (String str2 : set) {
                String str3 = endpointContext.get(str2);
                String str4 = endpointContext2.get(str2);
                boolean z2 = str3 == str4 || (str3 != null && str3.equals(str4));
                if (!z2 && !zIsWarnEnabled) {
                    return false;
                }
                if (!z2) {
                    LOGGER.warn("{}, {}: \"{}\" != \"{}\"", str, str2, str3, str4);
                } else if (zIsTraceEnabled) {
                    LOGGER.trace("{}, {}: \"{}\" == \"{}\"", str, str2, str3, str4);
                }
                z = z && z2;
            }
            return z;
        }
    }
}
