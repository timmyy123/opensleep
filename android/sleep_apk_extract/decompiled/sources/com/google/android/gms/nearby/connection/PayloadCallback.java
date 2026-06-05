package com.google.android.gms.nearby.connection;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PayloadCallback {
    public abstract void onPayloadReceived(String str, Payload payload);

    public abstract void onPayloadTransferUpdate(String str, PayloadTransferUpdate payloadTransferUpdate);
}
