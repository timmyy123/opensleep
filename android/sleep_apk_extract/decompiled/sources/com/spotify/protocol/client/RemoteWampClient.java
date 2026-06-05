package com.spotify.protocol.client;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.spotify.android.appremote.api.LocalConnector$1$$ExternalSyntheticLambda0;
import com.spotify.protocol.WampClient$Receiver;
import com.spotify.protocol.client.WampCallsOrchestrator;
import com.spotify.protocol.client.error.RemoteClientException;
import com.spotify.protocol.error.SpotifyAppRemoteException;
import com.spotify.protocol.mappers.JsonMappingException;
import com.spotify.protocol.mappers.JsonObject;
import com.spotify.protocol.types.Types$RequestId;
import com.spotify.protocol.types.Types$SubscriptionId;

/* JADX INFO: loaded from: classes4.dex */
public class RemoteWampClient implements RemoteClient {
    private final AppProtocolCommunicator mCommunicator;
    private volatile Types$RequestId mHelloRecordId;
    private OnConnectionTerminatedListener mOnConnectionTerminatedListener;
    private final WampClient$Receiver mReceiver;
    private final WampCallsOrchestrator mWampCallsOrchestrator;

    public RemoteWampClient(AppProtocolCommunicator appProtocolCommunicator, WampCallsOrchestrator wampCallsOrchestrator) {
        WampClient$Receiver wampClient$Receiver = new WampClient$Receiver() { // from class: com.spotify.protocol.client.RemoteWampClient.1
            @Override // com.spotify.protocol.WampClient$Receiver
            public void onAbort(JsonObject jsonObject, String str) {
                WampCallsOrchestrator.CallRecord<?> callRecordFindCallById = RemoteWampClient.this.mWampCallsOrchestrator.findCallById(RemoteWampClient.this.mHelloRecordId);
                if (callRecordFindCallById != null) {
                    RemoteWampClient.this.mWampCallsOrchestrator.removeCall(RemoteWampClient.this.mHelloRecordId);
                    callRecordFindCallById.mCallResult.deliverError(RemoteWampClient.this.getRemoteClientException(jsonObject, str));
                }
            }

            @Override // com.spotify.protocol.WampClient$Receiver
            public void onError(Types$RequestId types$RequestId, JsonObject jsonObject, String str) {
                WampCallsOrchestrator.CallRecord<?> callRecordFindCallById = RemoteWampClient.this.mWampCallsOrchestrator.findCallById(types$RequestId);
                if (callRecordFindCallById != null) {
                    RemoteWampClient.this.mWampCallsOrchestrator.removeCall(types$RequestId);
                    callRecordFindCallById.mCallResult.deliverError(RemoteWampClient.this.getRemoteClientException(jsonObject, str));
                }
            }

            @Override // com.spotify.protocol.WampClient$Receiver
            public void onEvent(Types$SubscriptionId types$SubscriptionId, int i, JsonObject jsonObject) {
                WampCallsOrchestrator.SubscriptionRecord<?> subscriptionRecordFindSubscriptionById = RemoteWampClient.this.mWampCallsOrchestrator.findSubscriptionById(types$SubscriptionId);
                if (subscriptionRecordFindSubscriptionById != null) {
                    subscriptionRecordFindSubscriptionById.deliverEventWithPayload(jsonObject);
                }
            }

            @Override // com.spotify.protocol.WampClient$Receiver
            public void onGoodbye(JsonObject jsonObject, String str) {
                if (!"wamp.error.system_shutdown".equals(str) || RemoteWampClient.this.mOnConnectionTerminatedListener == null) {
                    return;
                }
                ((LocalConnector$1$$ExternalSyntheticLambda0) RemoteWampClient.this.mOnConnectionTerminatedListener).onConnectionTerminated();
            }

            @Override // com.spotify.protocol.WampClient$Receiver
            public void onResult(Types$RequestId types$RequestId, JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3) {
                WampCallsOrchestrator.CallRecord<?> callRecordFindCallById = RemoteWampClient.this.mWampCallsOrchestrator.findCallById(types$RequestId);
                if (callRecordFindCallById != null) {
                    RemoteWampClient.this.mWampCallsOrchestrator.removeCall(types$RequestId);
                    callRecordFindCallById.deliverResultWithPayload(jsonObject2);
                }
            }

            @Override // com.spotify.protocol.WampClient$Receiver
            public void onSubscribeError(Types$RequestId types$RequestId, JsonObject jsonObject, String str) {
                Subscription<?> subscription = RemoteWampClient.this.mWampCallsOrchestrator.findSubscriptionByRequestId(types$RequestId).mSubscription;
                if (subscription != null) {
                    RemoteWampClient.this.mWampCallsOrchestrator.removeSubscriptionByRequestId(types$RequestId);
                    subscription.deliverError(RemoteWampClient.this.getRemoteClientException(jsonObject, str));
                }
            }

            @Override // com.spotify.protocol.WampClient$Receiver
            public void onSubscribed(Types$RequestId types$RequestId, Types$SubscriptionId types$SubscriptionId) {
                RemoteWampClient.this.mWampCallsOrchestrator.onSubscriptionIdReceived(types$RequestId, types$SubscriptionId);
                Subscription<T> subscription = ((WampCallsOrchestrator.SubscriptionRecord) Coding.checkNotNull(RemoteWampClient.this.mWampCallsOrchestrator.findSubscriptionById(types$SubscriptionId))).mSubscription;
                if (subscription != 0) {
                    subscription.deliverStart();
                }
            }

            @Override // com.spotify.protocol.WampClient$Receiver
            public void onUnubscribeError(Types$RequestId types$RequestId, JsonObject jsonObject, String str) {
            }

            @Override // com.spotify.protocol.WampClient$Receiver
            public void onWelcome(int i, JsonObject jsonObject) {
                WampCallsOrchestrator.CallRecord<?> callRecordFindCallById = RemoteWampClient.this.mWampCallsOrchestrator.findCallById(RemoteWampClient.this.mHelloRecordId);
                if (callRecordFindCallById != null) {
                    RemoteWampClient.this.mWampCallsOrchestrator.removeCall(RemoteWampClient.this.mHelloRecordId);
                    callRecordFindCallById.deliverResultWithPayload(jsonObject);
                }
            }
        };
        this.mReceiver = wampClient$Receiver;
        this.mCommunicator = appProtocolCommunicator;
        this.mWampCallsOrchestrator = wampCallsOrchestrator;
        appProtocolCommunicator.setMessageReceiver(wampClient$Receiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RemoteClientException getRemoteClientException(JsonObject jsonObject, String str) {
        String strM;
        try {
            strM = jsonObject.toJson();
        } catch (JsonMappingException e) {
            strM = FileInsert$$ExternalSyntheticOutline0.m("Could not parse error details: ", e.getMessage());
        }
        return new RemoteClientException(strM, str);
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public <T> CallResult<T> call(String str, Object obj, Class<T> cls) {
        WampCallsOrchestrator.CallRecord<T> callRecordNewCall = this.mWampCallsOrchestrator.newCall(cls);
        try {
            this.mCommunicator.sendCall(callRecordNewCall.mId.getRaw(), null, str, null, obj);
        } catch (SpotifyAppRemoteException e) {
            callRecordNewCall.mCallResult.deliverError(e);
        }
        return callRecordNewCall.mCallResult;
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public void goodbye() {
        try {
            this.mCommunicator.sendGoodbye();
        } catch (SpotifyAppRemoteException unused) {
        }
    }

    public <T> CallResult<T> hello(Class<T> cls) {
        WampCallsOrchestrator.CallRecord<T> callRecordNewCall = this.mWampCallsOrchestrator.newCall(cls);
        this.mHelloRecordId = callRecordNewCall.mId;
        try {
            this.mCommunicator.sendHello();
        } catch (SpotifyAppRemoteException e) {
            this.mWampCallsOrchestrator.removeCall(this.mHelloRecordId);
            callRecordNewCall.mCallResult.deliverError(e);
        }
        return callRecordNewCall.mCallResult;
    }

    public void setOnConnectionTerminatedListener(OnConnectionTerminatedListener onConnectionTerminatedListener) {
        this.mOnConnectionTerminatedListener = onConnectionTerminatedListener;
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public <T> Subscription<T> subscribe(String str, Class<T> cls) {
        WampCallsOrchestrator.SubscriptionRecord<T> subscriptionRecordNewSubscription = this.mWampCallsOrchestrator.newSubscription(this, cls);
        try {
            this.mCommunicator.sendSubscribe(subscriptionRecordNewSubscription.mId.getRaw(), null, str);
        } catch (SpotifyAppRemoteException e) {
            subscriptionRecordNewSubscription.mSubscription.deliverError(e);
        }
        return subscriptionRecordNewSubscription.mSubscription;
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public <T> void unsubscribe(Subscription<T> subscription) {
        WampCallsOrchestrator.SubscriptionRecord<?> subscriptionRecordFindSubscriptionByRequestId = this.mWampCallsOrchestrator.findSubscriptionByRequestId(subscription.getRequestId());
        if (subscriptionRecordFindSubscriptionByRequestId != null) {
            try {
                if (!subscriptionRecordFindSubscriptionByRequestId.mSubscriptionId.equals(Types$SubscriptionId.NONE)) {
                    this.mCommunicator.sendUnsubscribe(this.mWampCallsOrchestrator.getNextRequestId().getRaw(), subscriptionRecordFindSubscriptionByRequestId.mSubscriptionId.getRaw());
                    this.mWampCallsOrchestrator.removeSubscription(subscriptionRecordFindSubscriptionByRequestId.mSubscriptionId);
                    return;
                }
            } catch (SpotifyAppRemoteException e) {
                Debug.e(e, "Cannot unsubscribe", new Object[0]);
                return;
            }
        }
        Debug.e("Cannot unsubscribe using record: %s", subscriptionRecordFindSubscriptionByRequestId);
    }
}
