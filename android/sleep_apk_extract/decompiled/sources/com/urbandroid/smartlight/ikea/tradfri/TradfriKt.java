package com.urbandroid.smartlight.ikea.tradfri;

import com.urbandroid.common.Utils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"NODE_DEVICE", "", "NODE_GROUP", "NSD_SERVICE_TYPE", "DISCOVERY_TIMEOUT_IN_SECONDS", "", "COAPS_PORT", "DIRIGERA_PORT", "RETRANSMISSION_TIMEOUT_IN_MILLIS", "getRETRANSMISSION_TIMEOUT_IN_MILLIS", "()I", "smartlight_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TradfriKt {
    public static final int COAPS_PORT = 5684;
    public static final int DIRIGERA_PORT = 8443;
    private static final int DISCOVERY_TIMEOUT_IN_SECONDS = 5;
    public static final String NODE_DEVICE = "/15001";
    public static final String NODE_GROUP = "/15004";
    public static final String NSD_SERVICE_TYPE = "_coap._udp";
    private static final int RETRANSMISSION_TIMEOUT_IN_MILLIS = (int) Utils.getSecondsInMillis(30);

    public static final int getRETRANSMISSION_TIMEOUT_IN_MILLIS() {
        return RETRANSMISSION_TIMEOUT_IN_MILLIS;
    }
}
