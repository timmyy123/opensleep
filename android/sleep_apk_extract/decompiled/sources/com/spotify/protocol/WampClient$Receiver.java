package com.spotify.protocol;

import com.spotify.protocol.mappers.JsonObject;
import com.spotify.protocol.types.Types$RequestId;
import com.spotify.protocol.types.Types$SubscriptionId;

/* JADX INFO: loaded from: classes4.dex */
public interface WampClient$Receiver {
    void onAbort(JsonObject jsonObject, String str);

    void onError(Types$RequestId types$RequestId, JsonObject jsonObject, String str);

    void onEvent(Types$SubscriptionId types$SubscriptionId, int i, JsonObject jsonObject);

    void onGoodbye(JsonObject jsonObject, String str);

    void onResult(Types$RequestId types$RequestId, JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3);

    void onSubscribeError(Types$RequestId types$RequestId, JsonObject jsonObject, String str);

    void onSubscribed(Types$RequestId types$RequestId, Types$SubscriptionId types$SubscriptionId);

    void onUnubscribeError(Types$RequestId types$RequestId, JsonObject jsonObject, String str);

    void onWelcome(int i, JsonObject jsonObject);
}
