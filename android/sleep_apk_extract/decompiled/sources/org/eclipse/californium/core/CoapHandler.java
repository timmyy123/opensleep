package org.eclipse.californium.core;

/* JADX INFO: loaded from: classes5.dex */
public interface CoapHandler {
    void onError();

    void onLoad(CoapResponse coapResponse);
}
