package com.urbandroid.smartlight.common.discovery;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.smartlight.common.model.Gateway;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/urbandroid/smartlight/common/discovery/DiscoveryCallback;", "", "started", "", "found", "gateway", "Lcom/urbandroid/smartlight/common/model/Gateway;", "(Lcom/urbandroid/smartlight/common/model/Gateway;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "failed", SDKConstants.PARAM_DEBUG_MESSAGE, "", "finished", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DiscoveryCallback {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void failed(DiscoveryCallback discoveryCallback, String str) {
            str.getClass();
        }

        public static void finished(DiscoveryCallback discoveryCallback) {
        }

        public static void started(DiscoveryCallback discoveryCallback) {
        }
    }

    void failed(String msg);

    void finished();

    Object found(Gateway gateway, Continuation<? super Unit> continuation);

    void started();
}
