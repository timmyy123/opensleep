package org.eclipse.californium.core.observe;

import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;

/* JADX INFO: loaded from: classes5.dex */
public interface NotificationListener {
    void onNotification(Request request, Response response);
}
