package org.eclipse.californium.core.observe;

import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.Request;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ObservationUtil {
    public static Observation shallowClone(Observation observation) {
        if (observation == null) {
            return null;
        }
        Request request = observation.getRequest();
        if (request == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("missing request for observation!");
            return null;
        }
        Request request2 = new Request(request.getCode());
        request2.setDestinationContext(request.getDestinationContext());
        request2.setType(request.getType());
        request2.setMID(request.getMID());
        request2.setToken(request.getToken());
        request2.setOptions(request.getOptions());
        if (request.isUnintendedPayload()) {
            request2.setUnintendedPayload();
        }
        request2.setPayload(request.getPayload());
        request2.setUserContext(request.getUserContext());
        request2.setMaxResourceBodySize(request.getMaxResourceBodySize());
        return new Observation(request2, observation.getContext());
    }
}
