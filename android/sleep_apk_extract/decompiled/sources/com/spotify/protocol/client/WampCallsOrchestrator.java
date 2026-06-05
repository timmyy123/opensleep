package com.spotify.protocol.client;

import com.spotify.protocol.mappers.JsonObject;
import com.spotify.protocol.types.Types$RequestId;
import com.spotify.protocol.types.Types$SubscriptionId;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class WampCallsOrchestrator {
    private final AtomicInteger mIdGenerator = new AtomicInteger(0);
    private final Map<Types$RequestId, CallRecord<?>> mCallsMap = new ConcurrentHashMap();
    private final Map<Types$RequestId, SubscriptionRecord<?>> mSubscriptionsMap = new ConcurrentHashMap();
    private final Map<Types$SubscriptionId, Types$RequestId> mSubscriptionIdToRequestId = new ConcurrentHashMap();

    public static class CallRecord<T> {
        final CallResult<T> mCallResult;
        final Types$RequestId mId;
        private final Class<T> mType;

        public CallRecord(Types$RequestId types$RequestId, CallResult<T> callResult, Class<T> cls) {
            this.mType = cls;
            this.mId = (Types$RequestId) Coding.checkNotNull(types$RequestId);
            this.mCallResult = (CallResult) Coding.checkNotNull(callResult);
        }

        public void deliverResultWithPayload(JsonObject jsonObject) {
            try {
                this.mCallResult.deliverResult(ResultUtils.createSuccessfulResult(jsonObject.getAs(this.mType)));
            } catch (Exception e) {
                this.mCallResult.deliverError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof CallRecord) {
                return this.mId.equals(((CallRecord) obj).mId);
            }
            return false;
        }

        public int hashCode() {
            return this.mId.hashCode();
        }
    }

    public static class SubscriptionRecord<T> {
        final Class<T> mEventType;
        final Types$RequestId mId;
        final Subscription<T> mSubscription;
        Types$SubscriptionId mSubscriptionId = Types$SubscriptionId.NONE;

        public SubscriptionRecord(Types$RequestId types$RequestId, Subscription<T> subscription, Class<T> cls) {
            this.mEventType = cls;
            this.mId = (Types$RequestId) Coding.checkNotNull(types$RequestId);
            this.mSubscription = (Subscription) Coding.checkNotNull(subscription);
        }

        public void deliverEventWithPayload(JsonObject jsonObject) {
            try {
                this.mSubscription.deliverResult(ResultUtils.createSuccessfulResult(jsonObject.getAs(this.mEventType)));
            } catch (Exception e) {
                this.mSubscription.deliverError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof SubscriptionRecord) {
                return this.mId.equals(((SubscriptionRecord) obj).mId);
            }
            return false;
        }

        public int hashCode() {
            return this.mId.hashCode();
        }
    }

    public CallRecord<?> findCallById(Types$RequestId types$RequestId) {
        return this.mCallsMap.get(types$RequestId);
    }

    @Nullable
    public SubscriptionRecord<?> findSubscriptionById(Types$SubscriptionId types$SubscriptionId) {
        Types$RequestId types$RequestId = this.mSubscriptionIdToRequestId.get(types$SubscriptionId);
        if (types$RequestId != null) {
            return findSubscriptionByRequestId(types$RequestId);
        }
        return null;
    }

    public SubscriptionRecord<?> findSubscriptionByRequestId(Types$RequestId types$RequestId) {
        return this.mSubscriptionsMap.get(types$RequestId);
    }

    public Types$RequestId getNextRequestId() {
        return Types$RequestId.from(this.mIdGenerator.getAndIncrement());
    }

    public <T> CallRecord<T> newCall(Class<T> cls) {
        Types$RequestId nextRequestId = getNextRequestId();
        CallRecord<T> callRecord = new CallRecord<>(nextRequestId, new CallResult(nextRequestId), cls);
        this.mCallsMap.put(callRecord.mId, callRecord);
        return callRecord;
    }

    public <T> SubscriptionRecord<T> newSubscription(RemoteWampClient remoteWampClient, Class<T> cls) {
        Types$RequestId nextRequestId = getNextRequestId();
        SubscriptionRecord<T> subscriptionRecord = new SubscriptionRecord<>(nextRequestId, new Subscription(nextRequestId, remoteWampClient), cls);
        this.mSubscriptionsMap.put(subscriptionRecord.mId, subscriptionRecord);
        return subscriptionRecord;
    }

    public void onSubscriptionIdReceived(Types$RequestId types$RequestId, Types$SubscriptionId types$SubscriptionId) {
        this.mSubscriptionIdToRequestId.put(types$SubscriptionId, types$RequestId);
        SubscriptionRecord<?> subscriptionRecordFindSubscriptionByRequestId = findSubscriptionByRequestId(types$RequestId);
        if (subscriptionRecordFindSubscriptionByRequestId != null) {
            subscriptionRecordFindSubscriptionByRequestId.mSubscriptionId = types$SubscriptionId;
            return;
        }
        String str = String.format("Cannot find a subscription record for [%s]", types$RequestId);
        Debug.e(str, new Object[0]);
        Debug.assertTrue(false, str);
    }

    public void removeCall(Types$RequestId types$RequestId) {
        this.mCallsMap.remove(types$RequestId);
    }

    public void removeSubscription(Types$SubscriptionId types$SubscriptionId) {
        this.mSubscriptionsMap.remove(this.mSubscriptionIdToRequestId.remove(types$SubscriptionId));
    }

    public void removeSubscriptionByRequestId(Types$RequestId types$RequestId) {
        this.mSubscriptionsMap.remove(types$RequestId);
    }
}
