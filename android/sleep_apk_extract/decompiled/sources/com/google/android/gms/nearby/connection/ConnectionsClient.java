package com.google.android.gms.nearby.connection;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public interface ConnectionsClient {
    Task<Void> acceptConnection(String str, PayloadCallback payloadCallback);

    Task<Void> rejectConnection(String str);

    Task<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback);

    Task<Void> sendPayload(String str, Payload payload);

    Task<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions);

    Task<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions);

    void stopAdvertising();

    void stopAllEndpoints();

    void stopDiscovery();
}
