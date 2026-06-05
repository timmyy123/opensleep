package com.spotify.android.appremote.internal;

import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.Coding;
import com.spotify.protocol.client.RemoteClient;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.Types$RequestId;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class StrictRemoteClient implements RemoteClient {
    private final RemoteClient mRemoteClient;
    private final List<Rule> mRules = new ArrayList(0);

    public interface Rule {
        Throwable getError();

        boolean isSatisfied();
    }

    public StrictRemoteClient(RemoteClient remoteClient) {
        this.mRemoteClient = (RemoteClient) Coding.checkNotNull(remoteClient);
    }

    public void addRule(Rule rule) {
        this.mRules.add((Rule) Coding.checkNotNull(rule));
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public <T> CallResult<T> call(String str, Object obj, Class<T> cls) {
        Throwable thPrecallCheck = precallCheck();
        if (thPrecallCheck == null) {
            return this.mRemoteClient.call(str, obj, cls);
        }
        CallResult<T> callResult = new CallResult<>(Types$RequestId.NONE);
        callResult.deliverError(thPrecallCheck);
        return callResult;
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public void goodbye() {
        this.mRemoteClient.goodbye();
    }

    @Nullable
    public Throwable precallCheck() {
        for (Rule rule : this.mRules) {
            if (!rule.isSatisfied()) {
                return rule.getError();
            }
        }
        return null;
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public <T> Subscription<T> subscribe(String str, Class<T> cls) {
        Throwable thPrecallCheck = precallCheck();
        if (thPrecallCheck == null) {
            return this.mRemoteClient.subscribe(str, cls);
        }
        Subscription<T> subscription = new Subscription<>(Types$RequestId.NONE, this);
        subscription.deliverError(thPrecallCheck);
        return subscription;
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public <T> void unsubscribe(Subscription<T> subscription) {
        Throwable thPrecallCheck = precallCheck();
        if (thPrecallCheck != null) {
            subscription.deliverError(thPrecallCheck);
        } else {
            this.mRemoteClient.unsubscribe(subscription);
        }
    }
}
